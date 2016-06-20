package br.com.brq.services;

public class ServiceProdutoProxy implements br.com.brq.services.ServiceProduto {
  private String _endpoint = null;
  private br.com.brq.services.ServiceProduto serviceProduto = null;
  
  public ServiceProdutoProxy() {
    _initServiceProdutoProxy();
  }
  
  public ServiceProdutoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProdutoProxy();
  }
  
  private void _initServiceProdutoProxy() {
    try {
      serviceProduto = (new br.com.brq.services.ServiceProdutoServiceLocator()).getServiceProduto();
      if (serviceProduto != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceProduto)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceProduto)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceProduto != null)
      ((javax.xml.rpc.Stub)serviceProduto)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.brq.services.ServiceProduto getServiceProduto() {
    if (serviceProduto == null)
      _initServiceProdutoProxy();
    return serviceProduto;
  }
  
  public java.lang.String cadastrarProduto(java.lang.String nome, double preco) throws java.rmi.RemoteException{
    if (serviceProduto == null)
      _initServiceProdutoProxy();
    return serviceProduto.cadastrarProduto(nome, preco);
  }
  
  
}