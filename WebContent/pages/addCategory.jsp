<%@page import="com.amazon.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>
<%@ include file="head.jsp"%>
<%@ include file="checkLoggedIn.jsp"%>
<%String pageOf ="category"; %>
<%
	if (request.getAttribute(Constants.MESSAGE) == null) {
		request.setAttribute(Constants.MESSAGE, "");
	}
%>
</head>
<body>
	<%@ include file="navigationBar.jsp"%>
	<form action="<%=request.getContextPath()%>/Category.do" method="post">
		<div align="center">
			<h3>Enter new category details below</h3>
			<b>
				<div id="notification"  class="<%=request.getAttribute(Constants.STATUS)%>"><%=request.getAttribute(Constants.MESSAGE)%></div>
			</b>
			<div style="width: 50%" align="center">
				<input id="categoryName" name="categoryName" placeholder="Category Name" class="form-control" /><br />
				<input type="submit" id="submit" onclick="addCategory()" class="btn btn-primary btn-block" value="ADD Category"/>
					
			</div>
		</div>
	</form>
</body>
</html>