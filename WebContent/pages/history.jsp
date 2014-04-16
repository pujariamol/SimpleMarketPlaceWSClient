<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.amazon.dto.ProductDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My History</title>
<%@ include file="head.jsp"%>
<%@ include file="checkLoggedIn.jsp"%>
<%String pageOf ="history"; %>
</head>
<body align="center">
	<%@ include file="navigationBar.jsp"%>
	<div id="notification"></div>
	<div align="center">
		<div class="historyPageStyle" align="left">
			<h3>History</h3>
			<div style="">
				<div class="panel panel-primary">
					<div class="panel-heading">Items Bought</div>
					<div class="panel-body">
						<%
							ProductDTO[] products = ((ProductDTO[]) request.getAttribute("boughtProducts"));
							if (products != null) {
								for (int i = 0; i < products.length; i++) {
									ProductDTO product = ((ProductDTO) products[i]);
						%>
						<div>
							<b><%=product.getBrand()%></b>
							<%=product.getProductName()%>
							<%=product.getDescription()%>
							<label style="color: green">Price/Unit $ <%=product.getPrice()%>
							</label> <label style="color: blue"> Units Bought : <%=product.getQuantity()%> </label><br />
							<hr>
						</div>
						<%
							}
							} else {
						%>
						<div>You haven't made any purchase yet!</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
			<div style="">
				<div class="panel panel-primary">
					<div class="panel-heading">Items Sold</div>
					<div class="panel-body">
						<%
							ProductDTO[] soldProducts = ((ProductDTO[]) request.getAttribute("soldProducts"));
							if (soldProducts != null) {
								for (int i = 0; i < soldProducts.length; i++) {
									ProductDTO product = ((ProductDTO) soldProducts[i]);
						%>
						<b><%=product.getBrand()%></b>
						<%=product.getProductName()%>
						<%=product.getDescription()%>
						<label style="color: green">Price/Unit $ <%=product.getPrice()%></label>
						</label> <label style="color: blue"> Units Sold : <%=product.getQuantity()%> </label><br />
						<br />
						<hr>
						<%
							}
							} else {
						%>
						<div>You haven't made any purchase yet!</div>
						<%
							}
						%>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>