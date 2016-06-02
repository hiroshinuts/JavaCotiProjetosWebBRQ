package br.com.brq.managedbeans;

import java.util.List;

import br.com.brq.entities.Editora;
import br.com.brq.persistence.DAOEditora;

public class ManagedBeanEditora {

	private List<Editora> listagemEditoras;

	public List<Editora> getListagemEditoras() {
		try{
			DAOEditora d = new DAOEditora();
			listagemEditoras = d.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return listagemEditoras;
	}	
}
