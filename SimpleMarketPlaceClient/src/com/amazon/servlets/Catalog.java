package com.amazon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amazon.ServiceProviderProxy;
import com.amazon.dto.CategoryDTO;
import com.amazon.dto.UserDTO;
import com.amazon.util.Constants;

/**
 * Servlet implementation class Catalog
 */
public class Catalog extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Catalog() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute(Constants.USER);
		if (user != null) {
			ServiceProviderProxy proxy = new ServiceProviderProxy();

			if (request.getParameter("categoryId") != null) {
				Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
				request.setAttribute(Constants.PRODUCTS, proxy.getProductsByCategoryId(categoryId));
				request.setAttribute(Constants.SELECTED_CATEGORY, request.getParameter("categoryName"));
			} else {
				request.setAttribute(Constants.PRODUCTS, proxy.getAllProducts());
			}

			CategoryDTO[] categories = proxy.getAllCategories();
			session.setAttribute(Constants.CATEGORIES, categories);

			int cartCount = proxy.getShoppingCartItemCount(user.getIdentifier());
			request.setAttribute(Constants.CART_ITEM_COUNT, cartCount);

			if (request.getAttribute(Constants.SELECTED_CATEGORY) == null) {
				request.setAttribute(Constants.SELECTED_CATEGORY, categories[0].getCategoryName());
			}
			request.getRequestDispatcher("pages/catalog.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("pages/signIn.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// request.setAttribute("errorMessage", "catalog");
		request.getRequestDispatcher("pages/catalog.jsp").forward(request, response);
	}

}
