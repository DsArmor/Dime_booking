import axios from "axios";
import authHeader from "./auth.header";

const API_URL = "http://localhost:8080/hotel";

const hotelId = JSON.parse(localStorage.getItem("id"));

const createRoom = async (name, desc, price, start, end) => {

	const CREATE_API_URL = API_URL + "/" + hotelId + "/room";

	console.log(CREATE_API_URL);
	console.log(authHeader());

	const response = await axios
		.post(CREATE_API_URL, {
			name: name,
			priceForDay: price,
			description: desc,
			startAllocationDateTime: start,
			endAllocationDateTime: end
		}, {
			headers: {
				'Authorization': authHeader()
			}
		});
}

const hotelService = {
	createRoom,
};

export default hotelService;