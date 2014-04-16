<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.amazon.dto.ProductDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog</title>
<%@ include file="head.jsp"%>
<%@ include file="checkLoggedIn.jsp"%>
<%String pageOf ="catalog"; %>
</head>
<body>
	<%@ include file="navigationBar.jsp"%>
	<div id="notification"></div>
	<%
		ProductDTO[] products = ((ProductDTO[]) request.getAttribute("products"));
		if (products != null) {
			for (int i = 0; i < products.length; i++) {
				ProductDTO product = ((ProductDTO) products[i]);
	%>
	<div class="itemContainer shadow">
		<div class="itemStyle">
			<li><div style="margin-top: -12px; text-align: right; float: right;">
					<span class="label label-info">Seller : <%=product.getProductOwnerName()%></span><br />
				</div></li> <b>
				<li><%=product.getBrand()%></li>
			</b> <i>
				<li>Model : <%=product.getProductName()%></li>
			</i> <b>
				<li>Description</li>
			</b>
			<li><%=product.getDescription()%></li> <b>
				<li>Seller Info : <%=((product.getSellerInformation() == null)?"N/A":product.getSellerInformation())%></li>
				<li>Price</li>
			</b>
			<li>$ <%=product.getPrice()%></li>
			<li><%=product.getQuantity()%> In Stock</li> <input value="1" id="<%=product.getIdentifier()%>QuantityTxt"
				style="width: 30px"
			/> &nbsp
			<button class="btn btn-sm btn-primary" id="addToCartBtn" align="right"
				onclick="addToCart(<%=product.getIdentifier()%>)"
			>Add To Cart</button>
			&nbsp
			<button class="btn btn-danger btn-sm" id="remove" align="right"
				onclick="removeFromCart(<%=product.getIdentifier()%>)"
			>Remove</button>

		</div>
	</div>
	<%
		}
		} else {
	%>
	<div style="height: 100%; width: 100%; border: 1px solid #EEEEEE" align="center">
		<b>No Item present in the catalog for this category!!</b>
	</div>
	<%
		}
	%>

</body>
</html>