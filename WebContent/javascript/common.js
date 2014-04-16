/**
 * common javascript for client side validation and calls
 */

var jsonInput = {};
var cartCounter = 0;
var notificationClassName = {
	'error' : 'alert alert-danger',
	'info' : 'alert alert-info',
	'warning' : 'alert alert-warning',
	'success' : 'alert alert-success'
};

function ajaxCall(url, method) {
	var result = "";
	$.ajax({
		url : url,
		type : method,
		async : false,
		success : function(data) {
			result = data;
		}
	});
	return result;
}

/*
 * function login() { //if (validateLogin()) { var url = "/Login?" var content =
 * ajaxCall(url, "post"); if (typeof content.redirect == 'string') {
 * window.location = content.redirect; } alert(content);
 * $("#notification").html(content); clearJSON(); //} }
 */

function validateLogin() {
	var flag = true;
	if ($("#emailId").val() == "" || $("#password") == "") {
		flag = false;
		showNotification({
			'status' : 'info',
			'message' : 'Please enter credential!!'
		});
	}
	return flag;
}

// function signUp() {
// if (validate()) {
// var url = "signUp/add?" + $.param(jsonInput);
// var content = ajaxCall(url, "post");
// showNotification(content);
// // $("#notification").html(content);
// clearJSON();
// }
// }

function validate() {
	var flag = false;
	if (validatePassword() && validateEmail()) {
		flag = true;
	}
	return flag;
}

function validatePassword() {
	var flag = true;
	if ($("#pwd").val() == "" || $("#pwd").val() != $("#confirmPwd").val()) {
		showNotification({
			'status' : 'info',
			'message' : 'Passwords do not match!!'
		});
		flag = false;
	}
	return flag;
}

function validateEmail() {
	var flag = true;
	var emailId = $("#emailId").val();
	var atpos = emailId.indexOf("@");
	var dotpos = emailId.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= emailId.length) {
		showNotification({
			'status' : 'info',
			'message' : 'Not a valid e-mail address'
		});
		flag = false;
	}
	return flag;
}

/*
 * function signIn() { var emailId = $('#emailId').val(); var pass =
 * $('#password').val();
 * 
 * if (emailId == "" || pass == "") { $("#notifi").html("Please enter
 * credentials"); } else { var url = "login/" + emailId + "/" + pass; var val =
 * ajaxCall(url, "post"); if (typeof val.url != 'undefined') {
 * window.location.href = val.url; } else { $("#notifi").html(val.error); } } }
 */

function addToCart(productId) {
	incrementCartCounter();
	var url = CONTEXT_PATH + "/ShoppingCart.do?operation=add&productId="
			+ productId + "&quantity="
			+ $("#" + productId + "QuantityTxt").val();
	var result = ajaxCall(url, "post");
	showNotification(JSON.parse(result));
}

function removeFromCart(productId) {
	var content ;
	if (decrementCartCounter()) {
		var url = CONTEXT_PATH + "/ShoppingCart.do?operation=remove&productId="
				+ productId;
		 content = JSON.parse(ajaxCall(url, "post"));
	}else{
		content  = {
			'status' : 'info',
			'message' : 'Cart is empty!!'
		}
	}
	showNotification(content);

}

function makePayment() {
	if ($("#cardNumber").val().match(/^\d{16}$/)) {
		var url = CONTEXT_PATH + "/ShoppingCart.do?operation=pay"
		var content = ajaxCall(url, 'post');
		content = JSON.parse(content);
		showNotification(content);
	} else {
		showNotification({
			"status" : "error",
			"message" : "Invalid card number"
		});
	}
	// alert('\d{10}$/'.test($("#cardNumber").val()));

}

function showNotification(content) {
	$("#notification").attr('class', notificationClassName[content.status]);
	$("#notification").html(content.message);
}

function incrementCartCounter() {
	cartCounter++;
	cartCounter = parseInt($("#cartItemCount").html()) + 1;
	$('#cartItemCount').html(cartCounter);
}

function decrementCartCounter() {
	var flag = false;
	cartCounter = parseInt($('#cartItemCount').html());
	if (cartCounter != 0) {
		cartCounter--;
		$('#cartItemCount').html(cartCounter);
		flag = true;
	}
	return flag;
}

function dropdownHandling(obj) {
	var url = "/Catalog.do";
	if (obj.id != 0) {
		url = url + "?categoryId=" + obj.id + "&categoryName=" + $(obj).html();
	}
	window.location = CONTEXT_PATH + url;
}

function calculateTotalPrice(price, quantity) {
	var itemPrice = parseInt(price) * parseInt(quantity);
	$("#totalPrice").html(parseInt($("#totalPrice").html()) + itemPrice);
}
