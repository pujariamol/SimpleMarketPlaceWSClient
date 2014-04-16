/**
 * ServiceProviderService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.amazon;

public interface ServiceProviderService extends javax.xml.rpc.Service {
    public java.lang.String getServiceProviderAddress();

    public com.amazon.ServiceProvider getServiceProvider() throws javax.xml.rpc.ServiceException;

    public com.amazon.ServiceProvider getServiceProvider(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
