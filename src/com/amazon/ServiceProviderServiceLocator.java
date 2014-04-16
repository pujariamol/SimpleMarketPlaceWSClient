/**
 * ServiceProviderServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.amazon;

public class ServiceProviderServiceLocator extends org.apache.axis.client.Service implements com.amazon.ServiceProviderService {

    public ServiceProviderServiceLocator() {
    }


    public ServiceProviderServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceProviderServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceProvider
    private java.lang.String ServiceProvider_address = "http://localhost:8080/273AmazonStoreWS/services/ServiceProvider";

    public java.lang.String getServiceProviderAddress() {
        return ServiceProvider_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceProviderWSDDServiceName = "ServiceProvider";

    public java.lang.String getServiceProviderWSDDServiceName() {
        return ServiceProviderWSDDServiceName;
    }

    public void setServiceProviderWSDDServiceName(java.lang.String name) {
        ServiceProviderWSDDServiceName = name;
    }

    public com.amazon.ServiceProvider getServiceProvider() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceProvider_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceProvider(endpoint);
    }

    public com.amazon.ServiceProvider getServiceProvider(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.amazon.ServiceProviderSoapBindingStub _stub = new com.amazon.ServiceProviderSoapBindingStub(portAddress, this);
            _stub.setPortName(getServiceProviderWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceProviderEndpointAddress(java.lang.String address) {
        ServiceProvider_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.amazon.ServiceProvider.class.isAssignableFrom(serviceEndpointInterface)) {
                com.amazon.ServiceProviderSoapBindingStub _stub = new com.amazon.ServiceProviderSoapBindingStub(new java.net.URL(ServiceProvider_address), this);
                _stub.setPortName(getServiceProviderWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServiceProvider".equals(inputPortName)) {
            return getServiceProvider();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://amazon.com", "ServiceProviderService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://amazon.com", "ServiceProvider"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceProvider".equals(portName)) {
            setServiceProviderEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
