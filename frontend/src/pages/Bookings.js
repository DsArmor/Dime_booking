import NavBar from "../components/NavBar";
import React,{ useEffect } from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { useState } from "react";
import FullRoom from "../components/FullRoom";
import bookingService from "../services/booking.service";
import Booking from "../components/Booking";
import { Paper } from "@mui/material";

function Rooms() {

	const [bookings, setBookings] = useState([]);
	const [showItem, setShowItem] = useState(false);
	const [fullRoom, setFullRoom] = useState({});

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		const response = await bookingService.getBookings();
		setBookings(response.data);
		console.log("bookings: " + bookings);
	}

	const onShowItem=(room) => {
		setFullRoom(room);
		setShowItem(!showItem);
	}

	return (
		<div className="Bookings">
			<NavBar/>
			{!showItem &&
				<Paper>
				<Table>
				  <TableHead>
					<TableRow>
					  <TableCell>Комната</TableCell>
					  <TableCell numeric>Начало бронирования</TableCell>
					  <TableCell numeric>Конец бронирования</TableCell>
					</TableRow>
				  </TableHead>
				  	<TableBody>
						{bookings.map(booking => 
						<Booking onShowItem={onShowItem} booking={booking} key={booking.id}/>
						)}
					</TableBody>
				</Table>
				</Paper>}
			{showItem && 
			<div style={{marginLeft: "auto", marginRight: "auto", margin: "20px"}}>
				<FullRoom room={fullRoom} />
			</div>}
		</div>
	);
}

export default Rooms;