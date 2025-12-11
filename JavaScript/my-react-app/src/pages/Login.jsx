import React from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();

  function handleLogin() {
    alert("Login successful!");
    navigate("/dashboard"); // Redirect after login
  }

  return <button onClick={handleLogin}>Login</button>;
}
