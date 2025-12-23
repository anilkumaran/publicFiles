Here’s how Kubernetes works, component by component:

1. API Server – The Brain
Every kubectl call you make first hits the API Server.
Validates requests (authn + authz)
Talks to etcd (the memory)
Broadcasts changes to other components
If your API Server goes down, the cluster is blind. Nothing can be scheduled or scaled.

2. etcd – The Memory
A highly available key-value store containing the entire cluster state.
Stores Pods, ConfigMaps, Secrets, Nodes
Version-controlled for consistency
If etcd is corrupt, the cluster forgets what it is. This is why etcd backup & restore is life-saving.

3. Controller Manager – The Conductor
Constantly checks the “desired state” vs “current state.”
Keeps the right number of Pods alive
Ensures Jobs and CronJobs complete
Cleans up Nodes that fail
If reconciliation fails, your workloads drift silently from reality.

4. Scheduler – The Smart Planner
Decides where each Pod will run.
Evaluates CPU, memory, affinity, and taints
Assigns Pods to the best available node
If the Scheduler dies, no new workloads can start, even if resources are free.

5. Kubelet – The Executor
Runs on every node, responsible for making Pods real.
Talks to the API server
Starts containers via container runtime
Reports node health
If Kubelet crashes, that node effectively leaves the cluster.

6. Kube-Proxy – The Network Bridge
Make sure services can reach Pods.
Configures iptables/ipvs rules
Enables DNS-based service discovery
Routes traffic across nodes
If kube-proxy breaks, services exist, but traffic won’t reach the Pods.

7. Container Runtime – The Engine
Docker, containerd, CRI-O - the low-level tool that runs your containers.
Without it, your Pods are just YAML files with no execution.

Why This Matters: Kubernetes isn’t magic. 
It’s just a distributed system with very human failure points:
1. API Server → Control center
2. etcd → Memory
3. Controller → Reconciler
4. Scheduler → Planner
5. Kubelet → Executor
6. Proxy → Networker
If you can’t explain these, you’ll freeze the next time your cluster fails in production.
