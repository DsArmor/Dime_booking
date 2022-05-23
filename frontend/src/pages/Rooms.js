import NavBar from "../components/NavBar";
import React,{ useEffect } from 'react';
import { useState } from "react";
import { makeStyles } from "@mui/styles";
import Grid from '@mui/material/Grid';
import Room from "./../components/Room";
import roomService from "../services/room.service";
import FullRoom from "../components/FullRoom";

function Rooms() {

	const [posts, setPosts] = useState([]);
	const [showItem, setShowItem] = useState(false);
	const [fullRoom, setFullRoom] = useState({});

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		const response = await roomService.getAll();
		setPosts(response.data);
		console.log("posts: " + posts);
	}

	const onShowItem=(room) => {
		setFullRoom(room);
		setShowItem(!showItem);
	}

	return (
		<div className="Rooms">
			<NavBar/>
			{!showItem && <Grid 
				container
				justifyContent="center"
				spacing={3}
				marginTop={2}>
				{posts.map(post => 
					<Room onShowItem={onShowItem} room={post} key={post.id}/>
					)}
			</Grid>}
			{showItem && 
			<div style={{marginLeft: "auto", marginRight: "auto", margin: "20px"}}>
				<FullRoom room={fullRoom} onShowItem={onShowItem}/>
			</div>}
		</div>
	);
}

export default Rooms;