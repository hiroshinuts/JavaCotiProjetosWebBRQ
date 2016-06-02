package br.com.brq.managebeans;

import java.util.List;

import br.com.brq.entities.Fornecedor;
import br.com.brq.persistence.DAOFornecedor;

//classe para entregar dados de fornecedores para as p�ginas JSP
public class ManagedBeanFornecedor {

	//lista de fornecedores..
	private List<Fornecedor> listagemFornecedores;

	//m�todo para retornar uma lista com os fornecedores..
	public List<Fornecedor> getListagemFornecedores() {
		
		try{
			DAOFornecedor d = new DAOFornecedor();
			listagemFornecedores = d.findAll();
		}
		catch(Exception e){
			//pilha (descri��o) do erro no log do tomcat (servidor)
			e.printStackTrace();
		}
		
		return listagemFornecedores;
	}	
	
}
