<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<%@ include file="head.jsp"%>
<%
	String userName = "Guest";
	String lastLoginTime = "";
	String pageOf = "signUp";
%>
</head>
<body>
	<%@ include file="navigationBar.jsp"%>
	<form action="<%=request.getContextPath()%>/SignUp.do" method="post" onsubmit="return validate()">
		<div align="center" height="100%">
			<div style="width: 30%">
				<h1>SignUp Page</h1>
				<b>
					<div id="notification" class="<%=request.getAttribute("msgType")%>" style="width: 100%">
						<%=((request.getAttribute("message") == null) ? "" : request.getAttribute("message"))%></div>
				</b> <input id="firstname" name="firstname" placeholder="Enter First Name" class="form-control" /><br /> <input
					id="lastName" onblur="addToJSON(this)" placeholder="Enter Last Name" class="form-control"
				/><br /> <input id="emailId" name="emailId" placeholder="Enter Email Id" class="form-control" /><br /> <input
					id="pwd" type="password" name="password" placeholder="Enter Password" class="form-control"
				/><br /> <input id="confirmPwd" type="password" placeholder="Re-enter Password for confirmation"
					class="form-control"
				/><br /> <input type="submit" value="Submit" class="btn btn-primary btn-block" />
			</div>
		</div>
	</form>
</body>
</html>