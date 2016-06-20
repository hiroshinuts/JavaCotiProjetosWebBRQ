package br.com.brq.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.brq.entities.Produto;
import br.com.brq.persistence.DAOProduto;

@WebService //servi�o para integra��o de sistemas web..
public class ServiceProduto {

	//opera��o para cadastro de produto..
	//este m�todo ser� executado por outros sistemas (clientes do servi�o..)
	@WebMethod
	public String cadastrarProduto(String nome, Double preco){
		try{
			
			Produto p = new Produto(); //entidade..
			p.setNome(nome); //recebendo nome..
			p.setPreco(preco); //recebendo preco..
			
			DAOProduto d = new DAOProduto(); //persistencia..
			d.insert(p); //gravando..
			
			return "Produto " + p.getNome() + ", cadastrado com sucesso.";
		}
		catch(Exception e){
			//retornar mensagem de erro..
			return "Ocorreu um erro: " + e.getMessage();
		}
	}
	
}
