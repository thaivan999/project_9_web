const address = document.querySelector('#addressInp');
const phoneNumber = document.querySelector('#phoneNumberInp');
const listRadio = document.querySelectorAll('.form-check-input-radio');
const note = document.querySelector('#exampleFormControlTextarea1');
const price = document.querySelector('.payment-price-val');
const product = document.querySelector('.payment-product');
const fee = document.querySelector('.payment-fee');
const finalPrice = document.querySelector('.payment-final-price');
const orderDay = document.querySelector('.payment-order-day');
const shipDay = document.querySelector('.payment-ship-day');
const paymentBtn = document.querySelector('.payment-btn');
const agreeCheckbox = document.querySelector('#flexCheckDefault');
const placeResult = document.querySelector('.places-result');
let listPlaceItem = document.querySelectorAll('.places-result-item');

let timeoutId = null;

var currentDate = new Date();
var day = currentDate.getDate();
var month = currentDate.getMonth() + 1; // Tháng bắt đầu từ 0
var year = currentDate.getFullYear();

var formattedDate = year + '-' + (month < 10 ? '0' + month : month) + '-' + (day < 10 ? '0' + day : day);
orderDay.textContent = formattedDate;

function findDay() {
	let currDay = day;
	let currMonth = month;
	let currYear = year;
	var days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	if ((currYear % 400 == 0) || ((currYear % 100 != 0 && currYear % 4 == 0))) {
		days[2] = 29;
	}
	currDay += 3;
	if (currDay > days[month]) {
		currDay = days[month] - currDay;
		currMonth++;
		if (currMonth == 13) {
			currMonth = 1;
			currYear++;
		}
	}
	let dateFormatted = currYear + '-' + (currMonth < 10 ? '0' + currMonth : currMonth) + '-' + (currDay < 10 ? '0' + currDay : currDay);
	return dateFormatted;
}

function convertToVal(str) {
	str = str.slice(0, -1);
	console.log(str);
	return parseInt(str);
}

console.log(price);
console.log(fee);

shipDay.textContent = findDay();
finalPrice.textContent = convertToVal(price.textContent) + convertToVal(fee.textContent) + 'đ';

paymentBtn.addEventListener('click', function() {
	var dataJSON = document.querySelector('.payment-content').getAttribute('data-name');
	console.log(dataJSON);
	data = JSON.parse(dataJSON);
	var orderData = {};
	orderData.address = address.value;
	orderData.phoneNumber = phoneNumber.value;
	orderData.note = note.value;
	orderData.totalPrice = convertToVal(price.textContent);
	orderData.totalProduct = parseInt(product.textContent);
	orderData.finalPrice = convertToVal(finalPrice.textContent);
	orderData.orderDay = orderDay.textContent;
	orderData.shipDay = shipDay.textContent;
	orderData.idBranch = parseInt(document.querySelector('.payment-content').getAttribute('data-id'));
	orderData.fee = convertToVal(fee.textContent);
	listRadio.forEach(function(item) {
		if (item.checked) {
			orderData.idPayMethod = item.getAttribute('data-id');
		}
	})
	const check = orderData.idPayMethod == 'VNPAY';

	if (!agreeCheckbox.checked) {
		alert('Bạn cần đồng ý với điều khoản trước khi thanh toán.');
		return;
	}

	orderData.list = data.list;
	orderData.orderState = 0;
	function customBase64Encode(str) {
		return btoa(unescape(encodeURIComponent(str)));
	}

	var encodedData = customBase64Encode(JSON.stringify(orderData));
	var myAnchor = document.createElement('a');

	if (check) {
		myAnchor.setAttribute('href', '/api/payment/create_payment?cost=' + orderData.finalPrice + '&data=' + encodedData);
	}
	else {
		myAnchor.setAttribute('href', '/payment/order?data=' + encodedData);
	}
	myAnchor.click();
})

/*google map*/
function callPlacesAPI(query) {
	const url = `http://localhost:8989/api/places?query=${query}`;
	return new Promise((resolve, reject) => {
		fetch(url)
			.then(response => {
				if (!response.ok) {
					throw new Error('Network response was not ok.');
				}
				return response.json();
			})
			.then(data => {
				resolve(data);
			})
			.catch(error => {
				reject(error);
			});
	});
}

function addPlace(value) {
	address.value = value;
	placeResult.innerHTML = '';
}

const getListPlace = async (query) => {
	const places = await callPlacesAPI(query);
	let listPlaces = places.results;
	if (listPlaces.length > 6) {
		listPlaces = listPlaces.slice(0, 5);
	}
	const liElements = listPlaces.reduce((html, place, index) => {
		html += `<li class="places-result-item" onclick="addPlace('${place.formatted_address}')">${place.formatted_address}</li>`;
		return html;
	}, '');
	placeResult.innerHTML = liElements;
}

address.addEventListener("keyup", function() {
	clearTimeout(timeoutId);
	timeoutId = setTimeout(() => {
		getListPlace(address.value);
		listPlaceItem = document.querySelectorAll('.places-result-item');
	}, 300);
})

/*Calculate Ship Price*/
function callShipPriceAPI(origins, destinations, units) {
	const url = `http://localhost:8989/api/calculateDistance?origins=${origins}&destinations=${destinations}&units=${units}`;
	return new Promise((resolve, reject) => {
		fetch(url)
			.then(response => {
				if (!response.ok) {
					throw new Error('Network response was not ok.');
				}
				return response.json();
			})
			.then(data => {
				resolve(data);
			})
			.catch(error => {
				reject(error);
			});
	});
}

const calculateShipPrice = async () => {
	const data = await callShipPriceAPI(address.value, document.querySelector('#addressRecieveInp').value, "DRIVER");
	const distance = data.rows[0].elements[0].distance.text;
	const matchResult = distance.match(/^\d+(\.\d+)?/);
	let distanceNumber = 10000;
	if(matchResult) {
		distanceNumber = parseFloat(matchResult[0]);
		distanceNumber = parseInt(distanceNumber * 2);
		distanceNumber *= 1000;
	}
	fee.textContent = distanceNumber + "đ";
	finalPrice.textContent = convertToVal(price.textContent) + distanceNumber + "đ";
}

address.addEventListener('blur', function() {
	setTimeout(() => {
		calculateShipPrice();
	}, 500);
})






