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
import hotelService from "./../services/hotel.service"
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import TextField from '@mui/material/TextField';
import { Stack } from "@mui/material";
import Button from '@mui/material/Button';

const theme = createTheme();

function HotelRooms() {

	const [posts, setPosts] = useState([]);
	const [showItem, setShowItem] = useState(false);
	const [fullRoom, setFullRoom] = useState({});

	const [start, setStart] = React.useState(new Date('2022-05-22T00:00:00.000Z'));
	const [end, setEnd] = React.useState(new Date('2022-05-22T00:00:00.000Z'));
	const [desc, setDesc] = useState("");
	const [price, setPrice] = useState(-1);
	const [name, setName] = useState("");

	const [formErrors, setFormErrors] = useState({});

	const role = JSON.parse(localStorage.getItem("role"));

	const validate = (values) => {
		const errors = {};
		errors.server = values;
		errors.message = "Что-то пошло не так, у вас";
		return errors;
	}

	const handleRoom = async (event) => {
		event.preventDefault();
		try {
			await hotelService.createRoom(name, desc, price, start, end).then(
			  () => {
				window.location.reload();
			  },
			  (error) => {
				setFormErrors(validate(error));
				console.log(error);
			  }
			);
		  } catch (err) {
			console.log(err);
		  }
	  };

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		const response = await roomService.getById();
		setPosts(response.data);
		console.log("posts: " + posts);
	}

	const onShowItem=(room) => {
		setFullRoom(room);
		setShowItem(!showItem);
	}

	return (
		<ThemeProvider theme={theme}>
		<Container component="main" maxWidth="900" sx={{
				marginLeft: 35,
				alignItems: 'center',
			}}>
		  <CssBaseline />
			{!showItem && 
				<div>
					<Typography variant="h4" color="text.secondary" marginTop={1} align="center">
						Ваши комнаты
					</Typography>
					<Grid container direction="row" alignItems="center" justifyContent={"space-between"}>
								<Grid item style={{marginLeft: 40}}>
							{role == "HOTEL" && 
								<Box component="form" onSubmit={handleRoom} sx={{ mt: 1 }}>
								<LocalizationProvider dateAdapter={AdapterDateFns}>
								<Stack spacing={3}>
									<TextField
										margin="normal"
										required
										fullWidth
										id="name"
										label="Название комнаты"
										name="name"
										onChange={(e) => setName(e.target.value)}
									/>
									<TextField
										margin="normal"
										fullWidth
										id="desc"
										label="Описание"
										name="description"
										onChange={(e) => setDesc(e.target.value)}
									/>
									<TextField
										margin="normal"
										required
										fullWidth
										id="price"
										label="Цена"
										name="price"
										onChange={(e) => setPrice(e.target.value)}
									/>
									<DateTimePicker
										renderInput={(props) => <TextField {...props} />}
										label="Начало бронирований"
										value={start}
										onChange={(newValue) => {
										  setStart(newValue);
										}}
									/>
									<DateTimePicker
										renderInput={(props) => <TextField {...props} />}
										label="Конец бронирований"
										value={end}
										onChange={(newValue) => {
										  setEnd(newValue);
										}}
									/>
								</Stack>
								</LocalizationProvider>
								<Typography sx= {{color: "red"}}> { formErrors.message } </Typography>
								<Button
									type="submit"
									fullWidth
									variant="contained"
									sx={{ mt: 3, mb: 2 }}
								>
									Создать
								</Button>
								</Box>}
							</Grid>
						<Grid item xs={8}>
							<Grid container>
								{posts.map(post => 
									<Room onShowItem={onShowItem} room={post} key={post.id}/>
								)}
							</Grid>
						</Grid>
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

export default HotelRooms;