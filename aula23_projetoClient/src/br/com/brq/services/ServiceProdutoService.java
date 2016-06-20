/**
 * ServiceProdutoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.brq.services;

public interface ServiceProdutoService extends javax.xml.rpc.Service {
    public java.lang.String getServiceProdutoAddress();

    public br.com.brq.services.ServiceProduto getServiceProduto() throws javax.xml.rpc.ServiceException;

    public br.com.brq.services.ServiceProduto getServiceProduto(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
