import axios from "axios";
import authHeader from "./auth.header";

const API_URL = "http://localhost:8080/backpacker";

const backpackerId = JSON.parse(localStorage.getItem("id"));

const createBooking = async (start, end, roomId) => {

	const CREATE_API_URL = API_URL + "/" + backpackerId + "/room/" + roomId + "/booking";

	console.log(CREATE_API_URL);
	console.log(authHeader());

	const response = await axios
		.post(CREATE_API_URL, {
			startBookingDateTime: start,
			endBookingDateTime: end
		}, {
			headers: {
				'Authorization': authHeader()
			}
		});
}

const getBookings = async () => {

	const GET_API_URL = API_URL + "/" + backpackerId + "/booking";

	console.log(GET_API_URL);
	console.log(authHeader());

	const response = await axios
		.get(GET_API_URL, {
			headers: {
				'Authorization': authHeader()
			}
		});
	return response;
}


const bookingService = {
	createBooking,
	getBookings
};

export default bookingService;