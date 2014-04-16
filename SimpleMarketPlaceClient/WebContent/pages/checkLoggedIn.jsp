
<%@page import="com.amazon.dto.UserDTO"%>
<%
	String userName = "Guest";
	String lastLoginTime = "";
	UserDTO user = null;
	if (session.getAttribute("user") == null) {
		response.sendRedirect("signIn.jsp");
	} else {
		user = (UserDTO) session.getAttribute("user");
		lastLoginTime = user.getLastLoginTime();
		userName = user.getFirstName() + " " + user.getLastName();
		
	}

	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user"))
				userName = cookie.getValue();
			if (cookie.getName().equals("JSESSIONID"))
				sessionID = cookie.getValue();
		}
	}
%>
