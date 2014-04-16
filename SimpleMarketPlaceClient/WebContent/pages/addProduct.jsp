<%@page import="com.amazon.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<%@ include file="head.jsp"%>
<%@ include file="checkLoggedIn.jsp"%>
<%String pageOf ="addProduct"; %>
<%
	if (request.getAttribute(Constants.MESSAGE) == null) {
		request.setAttribute(Constants.MESSAGE, "");
	}
%>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Product.do" method="post">
		<%@ include file="navigationBar.jsp"%>
		<div align="center">
			<h3>Enter new product details below</h3>
			<b>
				<div id="notification" class="<%=request.getAttribute(Constants.STATUS)%>"><%=request.getAttribute(Constants.MESSAGE)%></div>
			</b>
			<div style="width: 50%" align="center">
				<select id="categoryId" name="categoryId" placeholder="Select a category" class="form-control">
					<%
						CategoryDTO[] categories = ((CategoryDTO[]) session.getAttribute("categories"));
						if (categories != null) {
							for (int j = 1; j < categories.length; j++) {
								CategoryDTO category = categories[j];
					%>
					<option value="<%=category.getIdentifier()%>"><%=category.getCategoryName()%></option>
					<%
						}
						}
					%>

				</select> <br /> <input id="productName" name="productName" placeholder="Product Name" class="form-control" /><br /> <input
					id="brandName" name="brandName" placeholder="Brand Name" class="form-control"
				/><br />
				<textarea type="textarea" rows="2" id="description" name="description" placeholder="Description"
					class="form-control"
				></textarea>
				<br />
				<div class="input-group">
					<span class="input-group-addon">$</span> <input id="price" name="price" placeholder="Enter price per unit"
						class="form-control"
					/>
				</div>
				<br /> <input id="quantityInStock" name="quantity" placeholder="Quantity Available In Stock" class="form-control" /><br />
				<input id="sellerInformation" name="sellerInformation" placeholder="Seller Information" class="form-control" /><br />

				<b><input type="submit" id="submit" class="btn btn-primary btn-block" value="ADD" /> </b>

			</div>
		</div>
	</form>
</body>
</html>