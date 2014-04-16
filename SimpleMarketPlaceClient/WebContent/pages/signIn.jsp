<%@page import="com.amazon.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignIn</title>
<%@ include file="head.jsp"%>
<%
	String userName = "Guest";
	String lastLoginTime = "";
	String pageOf = "signIn";
%>

</head>
<body>
	<%@ include file="navigationBar.jsp"%>
	<form action="<%=request.getContextPath()%>/Login.do" method="post" onsubmit="return validateLogin()">
		<div align="center">
			<div style="width: 30%">
				<b>
					<div id="notification" class="<%=request.getAttribute(Constants.STATUS)%>"><%=((request.getAttribute(Constants.MESSAGE) == null) ? "" : request.getAttribute(Constants.MESSAGE))%></div>
				</b> <input id="emailId" name="emailId" placeholder="Email Address" class="form-control" />&nbsp 
				<input id="password"
					name="password" type="password" placeholder="Password" class="form-control"
				/><br /> <input id="submit" type="Submit" value="Submit" class="btn btn-primary btn-block" />
			</div>
		</div>
	</form>
</body>
</html>