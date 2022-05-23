import PeopleIcon from '@mui/icons-material/People';
import ImageIcon from '@mui/icons-material/Image';
import PublicIcon from '@mui/icons-material/Public';
import SettingsEthernetIcon from '@mui/icons-material/SettingsEthernet';
import SettingsInputComponentIcon from '@mui/icons-material/SettingsInputComponent';
import DnsIcon from '@mui/icons-material/Dns';

const mainNavbarItems = [

	{
		id: 0,
		icon: <PeopleIcon />,
		label: 'Войти',
		route: '/',
	},
	{
		id: 1,
		icon: <ImageIcon />,
		label: 'Комнаты',
		route: '/room',
	},
]

function addItems() {

	const role = JSON.parse(localStorage.getItem("role"));

	const booking = {
		id: 3,
		icon: <PublicIcon />,
		label: 'Бронирования',
		route: '/booking',
	}
	const hotelRooms = {
		id: 3,
		icon: <ImageIcon />,
		label: 'Мои комнаты',
		route: '/hotel-rooms',
	}

	if (role == "USER") {
		mainNavbarItems.push(booking);
	}
	if (role == "HOTEL") {
		mainNavbarItems.push(hotelRooms);
	}
}

addItems();

export { mainNavbarItems };