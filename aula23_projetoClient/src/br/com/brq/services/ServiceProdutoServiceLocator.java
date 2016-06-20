/**
 * ServiceProdutoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.brq.services;

public class ServiceProdutoServiceLocator extends org.apache.axis.client.Service implements br.com.brq.services.ServiceProdutoService {

    public ServiceProdutoServiceLocator() {
    }


    public ServiceProdutoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceProdutoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceProduto
    private java.lang.String ServiceProduto_address = "http://localhost:8082/aula23_projetoServer/services/ServiceProduto";

    public java.lang.String getServiceProdutoAddress() {
        return ServiceProduto_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceProdutoWSDDServiceName = "ServiceProduto";

    public java.lang.String getServiceProdutoWSDDServiceName() {
        return ServiceProdutoWSDDServiceName;
    }

    public void setServiceProdutoWSDDServiceName(java.lang.String name) {
        ServiceProdutoWSDDServiceName = name;
    }

    public br.com.brq.services.ServiceProduto getServiceProduto() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceProduto_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceProduto(endpoint);
    }

    public br.com.brq.services.ServiceProduto getServiceProduto(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.brq.services.ServiceProdutoSoapBindingStub _stub = new br.com.brq.services.ServiceProdutoSoapBindingStub(portAddress, this);
            _stub.setPortName(getServiceProdutoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceProdutoEndpointAddress(java.lang.String address) {
        ServiceProduto_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.brq.services.ServiceProduto.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.brq.services.ServiceProdutoSoapBindingStub _stub = new br.com.brq.services.ServiceProdutoSoapBindingStub(new java.net.URL(ServiceProduto_address), this);
                _stub.setPortName(getServiceProdutoWSDDServiceName());
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
        if ("ServiceProduto".equals(inputPortName)) {
            return getServiceProduto();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.brq.com.br", "ServiceProdutoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.brq.com.br", "ServiceProduto"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceProduto".equals(portName)) {
            setServiceProdutoEndpointAddress(address);
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
