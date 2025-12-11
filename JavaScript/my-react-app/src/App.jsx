import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

import Home from './pages/Home';
import About from './pages/About';
import Contact from './pages/Contact';
import UserPage from './pages/UserPage';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Settings from './pages/Settings';


export default function App() {
  return (
    <Router>
      <div>
        <h1>React Router Multi-File Example</h1>
        {/* Navigation Links */}
        <nav>
          <Link to="/">Home</Link> | {" "}
          <Link to="/about">About</Link> |{" "}
          <Link to="/contact">Contact</Link> |{" "}
          <Link to="/user/123">User 123</Link> |{" "}
          <Link to="/login">Login</Link> |{" "}
          <Link to="/dashboard">Dashboard</Link>
        </nav>

        {/* Route definitions */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/user/:id" element={<UserPage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/dashboard/*" element={<Dashboard />}>
            {/* Nested route */}
              <Route path="settings" element={<Settings />} />
          </Route>
        </Routes>
      </div>
    </Router>
  )
}
