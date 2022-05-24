import axios from "axios";

const API_URL = "http://localhost:8080/room";

const hotelId = JSON.parse(localStorage.getItem("id"));

const getAll = () => {
	return axios
	.get(API_URL)
	.then(function (response) {
		console.log(response.data);
		return response;
	});
}

const getById = async () => {

	const GET_BY_ID_API_URL = API_URL + "/hotel/" + hotelId;

	const response = await axios
		.get(GET_BY_ID_API_URL);
	console.log(response.data);
	return response;
}

const roomService = {
	getAll,
	getById
};

export default roomService;