const listDesc = document.querySelectorAll('.cart-modify-quantity-desc');
const listAsc = document.querySelectorAll('.cart-modify-quantity-asc');
const checkboxAll = document.querySelector('.checkbox-select-all');
const listCheckbox = document.querySelectorAll('.checkbox-element');
const listPrice = document.querySelectorAll('.cart-price');
const sumPriceEle = document.querySelector('.cart-sum-price');

listDesc.forEach(function(btnDesc) {
	btnDesc.addEventListener('click', function() {
		var quantityInput = btnDesc.nextElementSibling;
		var currentValue = parseInt(quantityInput.value);
		if (currentValue > 1) {
			currentValue -= 1;
		}
		quantityInput.value = currentValue;
	})
})

listAsc.forEach(function(btnAsc) {
	btnAsc.addEventListener('click', function() {
		var quantityInput = btnAsc.previousElementSibling;
		var currentValue = parseInt(quantityInput.value);
		currentValue += 1;
		quantityInput.value = currentValue;
	})
})

checkboxAll.addEventListener('click', function() {
	listCheckbox.forEach(function(item) {
		item.checked = checkboxAll.checked;
	})
})

function calculateSumPrice() {
	var sumPrice = 0;
	listPrice.forEach(function(price) {
		var val = parseInt(price.textContent);
		console.log(val);
		sumPrice += val;
	})
	return sumPrice;
}


sumPriceEle.textContent = calculateSumPrice() + 'đ';



