package br.com.brq.manager;

import java.util.List;

import br.com.brq.entities.Funcionario;
import br.com.brq.persistence.DAOFuncionario;

public class ManagedBeanFuncionario {

	//atributo que retorne para a página uma lista de funcionarios
	//que será obtida pelo Hibernate...
	private List<Funcionario> listagemFuncionarios;

	public List<Funcionario> getListagemFuncionarios() {
		
		try{
			DAOFuncionario d = new DAOFuncionario();
			listagemFuncionarios = d.findAll();
		}
		catch(Exception e){
			e.printStackTrace(); //console do servidor..
		}
		
		return listagemFuncionarios;
	}
	
	
}
