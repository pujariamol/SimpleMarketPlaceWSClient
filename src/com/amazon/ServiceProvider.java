/**
 * ServiceProvider.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.amazon;

import java.sql.SQLException;

public interface ServiceProvider extends java.rmi.Remote {
	public void addCategory(java.lang.String categoryName) throws java.rmi.RemoteException, SQLException;
    public com.amazon.dto.UserDTO authenticate(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;

	public void checkout(int userId) throws java.rmi.RemoteException, SQLException;
    public com.amazon.dto.ShoppingCartDTO getShoppingCart(int userId) throws java.rmi.RemoteException;
    public int getShoppingCartItemCount(int userId) throws java.rmi.RemoteException;

	public void removeFromCart(int userId, int productId) throws java.rmi.RemoteException, SQLException;
    public com.amazon.dto.CategoryDTO[] getAllCategories() throws java.rmi.RemoteException;
    public com.amazon.dto.ProductDTO[] getProductsByCategoryId(int categoryId) throws java.rmi.RemoteException;
    public com.amazon.dto.ProductDTO[] getAllProducts() throws java.rmi.RemoteException;
    public com.amazon.dto.ProductDTO[] getSoldProducts(int userId) throws java.rmi.RemoteException;
    public com.amazon.dto.ProductDTO[] getBoughtProducts(int userId) throws java.rmi.RemoteException;

	public void addToCart(com.amazon.dto.ShoppingCartDTO shoppingCartDTO) throws java.rmi.RemoteException, SQLException;
    public java.lang.String[] createUser(com.amazon.dto.SignUpDTO signUpDTO) throws java.rmi.RemoteException;

	public void addProduct(com.amazon.dto.ProductDTO productDTO) throws java.rmi.RemoteException, SQLException;
}
