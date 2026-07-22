"""Strands HR Assistant on AgentCore Runtime.

Discovers tools from an AgentCore Gateway on every invocation, so newly-added
Gateway connectors are picked up without redeploying or restarting the runtime.

Required environment variables:
    GATEWAY_URL       - MCP endpoint URL of the AgentCore Gateway to connect to
    BEDROCK_MODEL_ID  - Foundation model or inference profile ID
                        (default: us.amazon.nova-pro-v1:0)
    SYSTEM_PROMPT     - Optional; overrides DEFAULT_SYSTEM_PROMPT below
"""
import logging
import os

from bedrock_agentcore import BedrockAgentCoreApp
from mcp_proxy_for_aws.client import aws_iam_streamablehttp_client
from strands import Agent
from strands.models import BedrockModel
from strands.tools.mcp.mcp_client import MCPClient

logger = logging.getLogger()
logger.setLevel(logging.INFO)

GATEWAY_URL = os.environ["GATEWAY_URL"]
MODEL_ID = os.environ.get("BEDROCK_MODEL_ID", "us.amazon.nova-pro-v1:0")
AWS_REGION = os.environ.get("AWS_REGION", "us-east-1")

DEFAULT_SYSTEM_PROMPT = """\
You are a professional HR Assistant helping employees with HR-related questions and requests.

You have tools available that fall into two categories:
- Retrieval tools that search the company employee handbook and HR policy documents. Use these to answer questions about policies, benefits eligibility, vacation accrual, or anything covered in the employee handbook.
- Action tools that record leave requests or benefits claims in the HR system. Use these when an employee asks to submit a request.

Guidelines:
- For policy questions, always use a retrieval tool before answering, and reference the relevant policy content when helpful.
- For submission requests, gather all required parameters from the employee before calling the tool. If any required field is missing, ask for it.
- If a retrieval tool returns no relevant content, say so and suggest contacting the HR department directly. Do not invent policy content.
- Keep responses concise and professional.
- Protect confidentiality â€” do not repeat personal information beyond what the employee has shared.
"""

_SYSTEM_PROMPT = os.environ.get("SYSTEM_PROMPT", DEFAULT_SYSTEM_PROMPT)


def _mcp_client_factory():
    return aws_iam_streamablehttp_client(
        endpoint=GATEWAY_URL,
        aws_region=AWS_REGION,
        aws_service="bedrock-agentcore",
    )


app = BedrockAgentCoreApp()


@app.entrypoint
def invoke(payload):
    prompt = payload.get("prompt", "")
    if not prompt:
        return {"result": "No prompt provided."}

    with MCPClient(_mcp_client_factory) as client:
        tools = client.list_tools_sync()
        logger.info(f"Discovered {len(tools)} tool(s) from Gateway {GATEWAY_URL}")
        agent = Agent(
            model=BedrockModel(
                model_id=MODEL_ID,
                temperature=0.0,
                max_tokens=4096,
                additional_request_fields={"inferenceConfig": {"topK": 1}},
            ),
            system_prompt=_SYSTEM_PROMPT,
            tools=tools,
        )
        result = agent(prompt)

    return {"result": result.message}


if __name__ == "__main__":
    app.run()
