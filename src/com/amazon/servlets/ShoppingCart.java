package com.amazon.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.amazon.ServiceProviderProxy;
import com.amazon.dto.ProductDTO;
import com.amazon.dto.ShoppingCartDTO;
import com.amazon.dto.UserDTO;
import com.amazon.util.Constants;

/**
 * Servlet implementation class ShoppingCart
 */
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServiceProviderProxy proxy = new ServiceProviderProxy();
	public ShoppingCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO) session.getAttribute(Constants.USER);
		if (user != null) {


			ShoppingCartDTO shoppingCart = proxy.getShoppingCart(user.getIdentifier());
			request.setAttribute(Constants.PRODUCTS, shoppingCart.getProducts());

			int cartCount = proxy.getShoppingCartItemCount(user.getIdentifier());
			request.setAttribute(Constants.CART_ITEM_COUNT, cartCount);

			request.getRequestDispatcher("pages/shoppingCart.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("pages/signIn.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String operation = request.getParameter(Constants.OPERATION);
		System.out.println("----------------------------------" + operation);
		JSONObject jsonObject = new JSONObject();
		try {
			if (operation.equalsIgnoreCase(Constants.ADD)) {
				jsonObject = addToCart(request);
			} else if (operation.equalsIgnoreCase(Constants.REMOVE)) {
				UserDTO user = (UserDTO) request.getSession().getAttribute(Constants.USER);
				jsonObject = removeFromCart(Integer.valueOf(request.getParameter("productId")),
						user.getIdentifier());
			} else if (operation.equalsIgnoreCase(Constants.PAY)) {
				jsonObject = checkout(request);
			}
			response.getWriter().write(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private JSONObject removeFromCart(int productId, int userId) throws JSONException, RemoteException {
		JSONObject jsonObject = new JSONObject();
		try {
			proxy.removeFromCart(userId, productId);
			jsonObject.accumulate(Constants.STATUS, Constants.SUCCESS);
			jsonObject.accumulate(Constants.MESSAGE, Constants.SUCCESS_REMOVE_FROM_CART);
		} catch (SQLException e) {
			jsonObject.accumulate(Constants.STATUS, Constants.ERROR);
			jsonObject.accumulate(Constants.MESSAGE, Constants.ERROR_REMOVE_FROM_CART);
			e.printStackTrace();
		}
		return jsonObject;

	}

	private JSONObject checkout(HttpServletRequest request) throws JSONException,
			RemoteException {
		UserDTO user = (UserDTO) request.getSession().getAttribute(Constants.USER);
		JSONObject jsonObject = new JSONObject();
		try {
			proxy.checkout(user.getIdentifier());
			jsonObject.accumulate(Constants.STATUS, Constants.SUCCESS);
			jsonObject.accumulate(Constants.MESSAGE, Constants.TRANSACTION_COMPLETED_MSG);
		} catch (SQLException e) {
			jsonObject.accumulate(Constants.STATUS, Constants.ERROR);
			jsonObject.accumulate(Constants.MESSAGE, Constants.ERROR_SHOPPING_CART);
			e.printStackTrace();
		}
		return jsonObject;
	}

	private JSONObject addToCart(HttpServletRequest request) throws RemoteException,
			JSONException {
		UserDTO user = (UserDTO) request.getSession().getAttribute(Constants.USER);

		ProductDTO[] productDTOs = new ProductDTO[1];
		ProductDTO product = new ProductDTO();
		product.setIdentifier(Integer.valueOf(request.getParameter("productId")));
		product.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		productDTOs[0] = product;

		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setUser(user);
		shoppingCartDTO.setProducts(productDTOs);
		shoppingCartDTO.setOrderStatus(Constants.PENDING);
		JSONObject jsonObject = new JSONObject();

		try {
			proxy.addToCart(shoppingCartDTO);
			jsonObject.accumulate(Constants.STATUS, Constants.SUCCESS);
			jsonObject.accumulate(Constants.MESSAGE, Constants.ADDED_TO_CART_SUCCESS);
		} catch (SQLException e) {
			jsonObject.accumulate(Constants.STATUS, Constants.ERROR);
			jsonObject.accumulate(Constants.MESSAGE, Constants.ERROR_ADDING_TO_CART);
			e.printStackTrace();
		}

		return jsonObject;
	}
}