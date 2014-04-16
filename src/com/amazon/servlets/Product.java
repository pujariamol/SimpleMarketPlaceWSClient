package com.amazon.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.ServiceProviderProxy;
import com.amazon.dto.ProductDTO;
import com.amazon.dto.UserDTO;
import com.amazon.util.Constants;

/**
 * Servlet implementation class Product
 */
public class Product extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ServiceProviderProxy proxy = new ServiceProviderProxy();
    public Product() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("pages/addProduct.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductDTO product = new ProductDTO();
		product.setBrand(request.getParameter(Constants.BRAND_NAME));
		product.setProductName(request.getParameter(Constants.PRODUCT_NAME));
		product.setCategoryId(Integer.valueOf(request.getParameter(Constants.CATEGORY_ID)));
		product.setDescription(request.getParameter(Constants.DESCRIPTION));
		product.setPrice(Integer.valueOf(request.getParameter(Constants.PRICE)));
		product.setProductOwnerId(((UserDTO) request.getSession().getAttribute(Constants.USER)).getIdentifier());
		product.setQuantity(Integer.valueOf(request.getParameter(Constants.QUANTITY)));
		product.setSellerInformation(request.getParameter(Constants.SELLER_INFORMATION));

		try {
			proxy.addProduct(product);
			request.setAttribute(Constants.STATUS, Constants.CSS_SUCCESS);
			request.setAttribute(Constants.MESSAGE, Constants.SUCCESS_PRODUCT_ADD);
		} catch (SQLException e) {
			request.setAttribute(Constants.STATUS, Constants.CSS_ERROR);
			request.setAttribute(Constants.MESSAGE, Constants.ERROR_PRODUCT_ADD);
			e.printStackTrace();
		}

		request.getRequestDispatcher("pages/addProduct.jsp").forward(request, response);
	}

}
