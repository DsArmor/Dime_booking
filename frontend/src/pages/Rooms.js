import NavBar from "../components/NavBar";
import React,{ useEffect } from 'react';
import { useState } from "react";
import { makeStyles } from "@mui/styles";
import Grid from '@mui/material/Grid';
import Room from "./../components/Room";
import roomService from "../services/room.service";

function Rooms() {

	const [posts, setPosts] = useState([]);

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		const response = await roomService.getAll();
		setPosts(response.data);
		console.log("posts: " + posts);
	}

	return (
		<div className="Rooms">
		<NavBar/>
			<Grid 
				container
				justifyContent="center"
				spacing={3}
				marginTop={2}>
				{posts.map(post => 
					<Room room={post} key={post.id}/>
					)}
			</Grid>
		</div>
	);
}

export default Rooms;