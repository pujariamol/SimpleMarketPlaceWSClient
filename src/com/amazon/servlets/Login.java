package com.amazon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amazon.ServiceProviderProxy;
import com.amazon.dto.UserDTO;
import com.amazon.util.Constants;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("pages/signIn.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		HttpSession session = request.getSession();
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		ServiceProviderProxy proxy = new ServiceProviderProxy();
		UserDTO user = proxy.authenticate(emailId, password);
		if (user != null) {
			// Cookie loginCookie = new Cookie("user", emailId);
			// // setting cookie to expiry in 30 mins
			// loginCookie.setMaxAge(30 * 60);
			// response.addCookie(loginCookie);
			String url = request.getContextPath() + "/Catalog.do";
			session.setAttribute("user", user);
			response.sendRedirect(url);
		} else {
			request.setAttribute("errorMessage", "Authentication Failed!!");
			request.setAttribute(Constants.STATUS, Constants.CSS_ERROR);
			request.setAttribute(Constants.MESSAGE, "Authentication Failed!!");
			request.getRequestDispatcher("pages/signIn.jsp").forward(request, response);
		}


	}
}
