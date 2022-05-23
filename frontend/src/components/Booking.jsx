import * as React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';

const Booking = (props) => {
  return (

		<TableRow>
			<TableCell component="th" scope="row">
				{props.booking.room.name}
			</TableCell>
			<TableCell numeric>{props.booking.startBookingDateTime}</TableCell>
			<TableCell numeric>{props.booking.endBookingDateTime}</TableCell>
		</TableRow>
		// <Grid item padding="20px">
		// 	<Typography gutterBottom variant="h5" component="div">
		// 	  {props.booking.room.name}
		// 	</Typography>
		// 	<Typography variant="body2" color="text.secondary" paddingBottom="2px">
		// 	  {props.booking.startBookingDateTime}
		// 	</Typography>
		// 	<Typography variant="body2" color="text.secondary" paddingBottom="2px">
		// 		{props.booking.endBookingDateTime}
		// 	</Typography>
		// </Grid>
  );
}

export default Booking