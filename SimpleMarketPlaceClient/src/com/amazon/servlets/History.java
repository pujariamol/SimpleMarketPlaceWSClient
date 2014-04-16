package com.amazon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.ServiceProviderProxy;
import com.amazon.dto.ProductDTO;
import com.amazon.dto.UserDTO;
import com.amazon.util.Constants;

/**
 * Servlet implementation class History
 */
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public History() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO user = (UserDTO) request.getSession().getAttribute(Constants.USER);
		ServiceProviderProxy proxy = new ServiceProviderProxy();
		if (user != null) {
			
			ProductDTO[] boughtProducts = proxy.getBoughtProducts(user.getIdentifier());
			request.setAttribute("boughtProducts", boughtProducts);
			ProductDTO[] soldProducts = proxy.getSoldProducts(user.getIdentifier());
			request.setAttribute("soldProducts", soldProducts);
			request.getRequestDispatcher("pages/history.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("pages/signIn.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
