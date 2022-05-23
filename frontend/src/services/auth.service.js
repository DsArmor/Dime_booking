import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/auth";

// const signup = (email, password) => {
// 	return axios
// 	.post(API_URL, {
// 	  username: email,
// 	  password: password
// 	})
// 	.then((response) => {
// 		if (response.data.accessToken) {
// 			localStorage.setItem("user", JSON.stringify(response.data));
// 		}
// 		return response.data;
// 	});
// };

const login = async (email, password) => {
	const response = await axios
		.post(API_URL, {
			username: email,
			password: password
		});
	if (response.data.accessToken) {
		localStorage.setItem("user", JSON.stringify(response.data.accessToken));
		localStorage.setItem("id", JSON.stringify(response.data.id));
		localStorage.setItem("role", JSON.stringify(response.data.role));
	}
	return response.data;
};

const logout = () => {
	localStorage.removeItem("user");
};

const getCurrentUser = () => {
	return JSON.parse(localStorage.getItem("user"));
};

const authService = {
	login,
	logout,
	getCurrentUser,
};

export default authService;