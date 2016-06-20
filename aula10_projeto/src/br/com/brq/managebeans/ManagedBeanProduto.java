package br.com.brq.managebeans;

import java.util.List;

import br.com.brq.entities.Produto;
import br.com.brq.persistence.DAOProduto;

public class ManagedBeanProduto {

	//atributo..
	private List<Produto> listagemProdutos;

	//método get para retornar o valor do atributo preenchido
	//com a consulta do banco de dados..
	public List<Produto> getListagemProdutos() {
		
		try{
			DAOProduto d = new DAOProduto();
			listagemProdutos = d.findAll();
		}
		catch(Exception e){
			//imprimir erro no log do servidor tomcat..
			e.printStackTrace();
		}
		
		return listagemProdutos;
	}
	
}
