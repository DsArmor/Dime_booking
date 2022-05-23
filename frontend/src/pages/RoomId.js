import NavBar from "../components/NavBar";
import React,{ useEffect } from 'react';
import { useState } from "react";
import { makeStyles } from "@mui/styles";
import Grid from '@mui/material/Grid';
import Room from "./../components/Room";
import roomService from "../services/room.service";

const RoomId = (props) => {

	return (
		<div className="Rooms">
		<NavBar/>

		</div>
	);
}

export default RoomId;