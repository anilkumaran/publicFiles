import React from "react";
import { Link, Outlet } from "react-router-dom";

export default function Dashboard() {
  return (
    <div>
      <h2>Dashboard</h2>
      <nav>
        <Link to="settings">Settings</Link>
      </nav>

      {/* Nested routes render here */}
      <Outlet />
    </div>
  );
}
