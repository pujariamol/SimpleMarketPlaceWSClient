package com.amazon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.ServiceProviderProxy;
import com.amazon.util.Constants;

/**
 * Servlet implementation class Category
 */
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProviderProxy proxy = new ServiceProviderProxy();
	public Category() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getRequestDispatcher("pages/addCategory.jsp").forward(request, response);
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		try {
			proxy.addCategory(request.getParameter("categoryName"));
			request.setAttribute(Constants.STATUS, Constants.CSS_SUCCESS);
			request.setAttribute(Constants.MESSAGE, Constants.SUCCESS_CATEGORY_ADD);
		} catch (SQLException e) {
			request.setAttribute(Constants.STATUS, Constants.CSS_ERROR);
			request.setAttribute(Constants.MESSAGE, Constants.ERROR_CATEGORY_ADD);
			e.printStackTrace();
		}


		request.getRequestDispatcher("pages/addCategory.jsp").forward(request, response);
	}

}
