import NavBar from "../components/NavBar";
import React,{ useEffect } from 'react';
import { useState } from "react";
import { makeStyles } from "@mui/styles";
import Grid from '@mui/material/Grid';
import Room from "./../components/Room";
import roomService from "../services/room.service";
import FullRoom from "../components/FullRoom";
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import { Typography } from "@mui/material";

const theme = createTheme();

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
		<ThemeProvider theme={theme}>
		<Container component="main" maxWidth="700" sx={{
				marginLeft: 35,
				alignItems: 'center',
			}}>
		  <CssBaseline />
			{!showItem && 
				<div>
					<Typography variant="h4" color="text.secondary" marginTop={1} align="center">
						Доступные комнаты
					</Typography>
					<Grid 
						container
						justifyContent="center"
						spacing={4}
						marginTop={2}>
						{posts.map(post => 
							<Room onShowItem={onShowItem} room={post} key={post.id}/>
						)}
					</Grid>
				</div>}
			{showItem && 
			<div style={{marginLeft: "auto", marginRight: "auto", margin: "20px"}}>
				<FullRoom room={fullRoom} onShowItem={onShowItem}/>
			</div>}
			</Container>
    	</ThemeProvider>
	)
}

export default Rooms;