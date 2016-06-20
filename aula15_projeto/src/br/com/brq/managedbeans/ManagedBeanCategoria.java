package br.com.brq.managedbeans;

import java.util.ArrayList;
import java.util.List;

import br.com.brq.entities.types.Categoria;

public class ManagedBeanCategoria {

	private List<String> listagemCategorias;

	public List<String> getListagemCategorias() {
		
		listagemCategorias = new ArrayList<String>();
		
		//varrendo cada item (constante) do enum
		for(Categoria c : Categoria.values()){
			listagemCategorias.add(c.name());
		}
		
		return listagemCategorias;
	}
	
}
