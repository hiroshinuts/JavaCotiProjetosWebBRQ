package br.com.brq.managebeans;

import java.util.List;

import br.com.brq.entities.Fornecedor;
import br.com.brq.persistence.DAOFornecedor;

//classe para entregar dados de fornecedores para as páginas JSP
public class ManagedBeanFornecedor {

	//lista de fornecedores..
	private List<Fornecedor> listagemFornecedores;

	//método para retornar uma lista com os fornecedores..
	public List<Fornecedor> getListagemFornecedores() {
		
		try{
			DAOFornecedor d = new DAOFornecedor();
			listagemFornecedores = d.findAll();
		}
		catch(Exception e){
			//pilha (descrição) do erro no log do tomcat (servidor)
			e.printStackTrace();
		}
		
		return listagemFornecedores;
	}	
	
}
