import NavBar from "./NavBar";
import React,{ useEffect } from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import { useState } from 'react';
import authService from '../services/auth.service';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import { useNavigate } from 'react-router-dom';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { Stack } from "@mui/material";
import bookingService from "./../services/booking.service"

const FullRoom = (props) => {

	const [start, setStart] = React.useState(new Date('2022-05-22T00:00:00.000Z'));
	const [end, setEnd] = React.useState(new Date('2022-05-22T00:00:00.000Z'));
	const [formErrors, setFormErrors] = useState({});

	const navigate = useNavigate();

	const validate = (values) => {
		const errors = {};
		errors.server = values;
		errors.message = "Date are busy now";
		return errors;
	}

  const handleBooking = async (event) => {
    event.preventDefault();
    try {
		await bookingService.createBooking(start, end, props.room.id).then(
		  () => {
			navigate("/booking");
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

	return (
		<div className="FullRoom" style={{justifyContent: "center"}}>
			<Grid container>
				<Card>
				<Card sx={{ minWidth: 400, padding: 5}}>
			  <CardContent>
				<Typography gutterBottom variant="h3" component="div">
				  {props.room.name}
				</Typography>
				<Typography variant="h5" color="text.secondary" paddingBottom="2px">
				  {props.room.description}
				</Typography>
				<Typography variant="h5" color="text.secondary" paddingBottom="2px">
					{props.room.startAllocationDateTime}
				</Typography>
				<Typography variant="h5" color="text.secondary" paddingBottom="2px">
					{props.room.endAllocationDateTime}
			    </Typography>
				<Typography variant="h4" color="text.secondary">
					Цена за ночь: {props.room.priceForDay}
				</Typography>
			  </CardContent>
			  <CardActions>
			  </CardActions>
			</Card>
			<Card sx={{ maxWidth: 1000, padding: 5, paddingTop: 0}}>
			  <CardContent>
				<Typography gutterBottom variant="h3" component="div">
				  {props.room.owner.name}
				</Typography>
				<Typography variant="h4" color="text.secondary" paddingBottom="2px">
					{props.room.owner.email}
				</Typography>
				<Typography variant="h4" color="text.secondary" paddingBottom="2px">
				  {props.room.owner.description}
				</Typography>
			  </CardContent>
			  <CardActions>
			  </CardActions>
			</Card>
				</Card>
				<Grid item style={{marginLeft: 40}}>
				<Box component="form" onSubmit={handleBooking} sx={{ mt: 1 }}>
				<LocalizationProvider dateAdapter={AdapterDateFns}>
				<Stack spacing={3}>
					<DateTimePicker
						renderInput={(props) => <TextField {...props} />}
						label="Начало бронирования"
						value={start}
						onChange={(newValue) => {
						  setStart(newValue);
						}}
					/>
					<DateTimePicker
						renderInput={(props) => <TextField {...props} />}
						label="Конец бронирования"
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
					Забронировать
				</Button>
				<Button
					onClick={() => props.onShowItem(props.room)}
					fullWidth
					variant="contained"
					sx={{ mt: 3, mb: 2 }}
				>
					Закрыть
				</Button>
			</Box>
				</Grid>
			
			</Grid>
		</div>
	);
}

export default FullRoom;