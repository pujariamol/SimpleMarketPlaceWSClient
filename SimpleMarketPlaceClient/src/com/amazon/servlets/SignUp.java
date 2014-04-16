package com.amazon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.ServiceProviderProxy;
import com.amazon.dto.SignUpDTO;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUp() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("pages/signUp.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("Inside signUp servlet" + request.getHeader("Referer"));
		ServiceProviderProxy spProxy = new ServiceProviderProxy();
		SignUpDTO signUpDTO = new SignUpDTO();
		signUpDTO.setEmailId(request.getParameter("emailId"));
		signUpDTO.setFirstname(request.getParameter("firstname"));
		signUpDTO.setLastname(request.getParameter("lastname"));
		signUpDTO.setPassword(request.getParameter("password"));

		String[] message = spProxy.createUser(signUpDTO);
		request.setAttribute("msgType", "alert alert-success");
		request.setAttribute("message", message[1]);
		request.getRequestDispatcher("pages/signUp.jsp").forward(request, response);
	}
}
