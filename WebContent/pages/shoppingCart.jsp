<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.amazon.dto.ProductDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<%@ include file="head.jsp"%>
<%@ include file="checkLoggedIn.jsp"%>
<%String pageOf ="cart"; %>
</head>
<body>
	<%@ include file="navigationBar.jsp"%>
	<b>
		<div id="notification"></div>
	</b>
	<div class="total">
		<label>Total : </label>&nbsp &nbsp $<label id="totalPrice">
		0</label>
	</div>
	<div class="shoppingCartItems">
	<%
		ProductDTO[] products = ((ProductDTO[]) request.getAttribute("products"));
		if (products.length > 0) {
			for (int i = 0; i < products.length; i++) {
				ProductDTO product = ((ProductDTO) products[i]);
	%>
		<div class="itemStyle" id="<%=product.getIdentifier() %>">
			<b><%=product.getBrand() %></b></br>
			<i><%=product.getProductName() %></i></br>
			<%=product.getDescription() %></br>
			<label style="color:green;font-weight:bold">$ <%=product.getPrice() %></label></br>
			<label style="color:blue;font-weight:bold">Quantity : <%=product.getQuantity() %></label></br>
			<script>calculateTotalPrice(<%=product.getPrice() %>,<%=product.getQuantity() %>)</script>
		</div>
	<%
		}
		} else {
	%>
		<div class="itemStyle">
			<p>No Product In Shopping Cart</p>
		</div>
	<%
		}
	%>
	</div>
	<div align="center" class="payment">
		<div style="padding-bottom: 15px">
			<label>Enter your card information</label>
		</div>
		<div style="width: 50%">
			<input id="nameOnCard" placeholder="Name on card" class="form-control" /><br /> <input id="cardNumber"
				placeholder="Card Number" class="form-control"
			/><br />
		</div>
		<button id="payBtn" style="margin: 15px" onclick="makePayment()" class="btn btn-primary">Make Payment</button>
	</div>
</body>
</html>