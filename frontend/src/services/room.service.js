import axios from "axios";

const API_URL = "http://localhost:8080/room";

const getAll = () => {
	return axios
	.get(API_URL)
	.then(function (response) {
		console.log(response.data);
		return response;
	});
}

const roomService = {
	getAll,
};

export default roomService;