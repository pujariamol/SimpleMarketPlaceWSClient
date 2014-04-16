package com.amazon;

import java.sql.SQLException;

public class ServiceProviderProxy implements com.amazon.ServiceProvider {
  private String _endpoint = null;
  private com.amazon.ServiceProvider serviceProvider = null;
  
  public ServiceProviderProxy() {
    _initServiceProviderProxy();
  }
  
  public ServiceProviderProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProviderProxy();
  }
  
  private void _initServiceProviderProxy() {
    try {
      serviceProvider = (new com.amazon.ServiceProviderServiceLocator()).getServiceProvider();
      if (serviceProvider != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceProvider)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceProvider)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceProvider != null)
      ((javax.xml.rpc.Stub)serviceProvider)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.amazon.ServiceProvider getServiceProvider() {
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider;
  }
  
	public void addCategory(java.lang.String categoryName) throws java.rmi.RemoteException, SQLException {
    if (serviceProvider == null)
      _initServiceProviderProxy();
    serviceProvider.addCategory(categoryName);
  }
  
  public com.amazon.dto.UserDTO authenticate(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.authenticate(username, password);
  }
  
	public void checkout(int userId) throws java.rmi.RemoteException, SQLException {
    if (serviceProvider == null)
      _initServiceProviderProxy();
    serviceProvider.checkout(userId);
  }
  
  public com.amazon.dto.ShoppingCartDTO getShoppingCart(int userId) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getShoppingCart(userId);
  }
  
  public int getShoppingCartItemCount(int userId) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getShoppingCartItemCount(userId);
  }
  
	public void removeFromCart(int userId, int productId) throws java.rmi.RemoteException, SQLException {
    if (serviceProvider == null)
      _initServiceProviderProxy();
    serviceProvider.removeFromCart(userId, productId);
  }
  
  public com.amazon.dto.CategoryDTO[] getAllCategories() throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getAllCategories();
  }
  
  public com.amazon.dto.ProductDTO[] getProductsByCategoryId(int categoryId) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getProductsByCategoryId(categoryId);
  }
  
  public com.amazon.dto.ProductDTO[] getAllProducts() throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getAllProducts();
  }
  
  public com.amazon.dto.ProductDTO[] getSoldProducts(int userId) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getSoldProducts(userId);
  }
  
  public com.amazon.dto.ProductDTO[] getBoughtProducts(int userId) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.getBoughtProducts(userId);
  }
  
	public void addToCart(com.amazon.dto.ShoppingCartDTO shoppingCartDTO) throws java.rmi.RemoteException, SQLException {
    if (serviceProvider == null)
      _initServiceProviderProxy();
    serviceProvider.addToCart(shoppingCartDTO);
  }
  
  public java.lang.String[] createUser(com.amazon.dto.SignUpDTO signUpDTO) throws java.rmi.RemoteException{
    if (serviceProvider == null)
      _initServiceProviderProxy();
    return serviceProvider.createUser(signUpDTO);
  }
  
	public void addProduct(com.amazon.dto.ProductDTO productDTO) throws java.rmi.RemoteException, SQLException {
    if (serviceProvider == null)
      _initServiceProviderProxy();
    serviceProvider.addProduct(productDTO);
  }
  
  
}