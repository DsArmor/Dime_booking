import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import SignIn from './pages/SignIn';
import Rooms from './pages/Rooms';
import Bookings from './pages/Bookings';

ReactDOM.render(
		<BrowserRouter>
		<Routes>
			<Route path="/" element={<App />}>
				<Route path="/" element={<SignIn />} />
				<Route path="/room" element={<Rooms />} />
				<Route path="/booking" element={<Bookings />} />
			</Route>
		</Routes>
	</BrowserRouter>,
	document.getElementById('root')
);

// import React from "react";
// import { BrowserRouter } from "react-router-dom";
// import { Route, Routes } from "react-router-dom";
// import ReactDOM from "react-dom";
// import { BrowserRouter as Router } from "react-router-dom";
// import "./index.css";
// import App from "./App";
// import reportWebVitals from "./reportWebVitals";

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
// 	<React.StrictMode>
// 		<App />
// 	</React.StrictMode>,
// 	document.getElementById('root')
// );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
