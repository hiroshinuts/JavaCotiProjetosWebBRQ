package br.com.brq.managedbeans;

import java.util.List;

import br.com.brq.entities.Autor;
import br.com.brq.persistence.DAOAutor;

public class ManagedBeanAutor {

	private List<Autor> listagemAutores;

	public List<Autor> getListagemAutores() {
		try{
			DAOAutor d = new DAOAutor();
			listagemAutores = d.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemAutores;
	}	
	
}
