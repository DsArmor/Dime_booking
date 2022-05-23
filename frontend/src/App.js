import { useState, useEffect } from "react";
import { Routes, Route, Link, Router, BrowserRouter } from "react-router-dom";
import { Switch } from "@mui/material";
import NavBar from "./components/NavBar";
import authService from "./services/auth.service";
import SignIn from "./pages/SignIn";
import Rooms from "./pages/Rooms";
import { AppBar } from "@mui/material";
import { Container } from "@mui/system";

// import Signup from "./components/Signup";
// import Home from "./components/Home";
// import Private from "./components/Private";
// import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = authService.getCurrentUser();
    if (user) {
      setCurrentUser(user);
    }
  }, []);

  const logOut = () => {
    authService.logout();
  };

  return (
	<div className="App">
		<BrowserRouter>
		<Routes>
				<Route path="/" element={<SignIn />} />
				<Route path="/room" element={<Rooms />} />
			</Routes>
		</BrowserRouter>
	</div>
  );
}

export default App;