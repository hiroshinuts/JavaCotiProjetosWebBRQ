package br.com.brq.persistence;

import java.util.List;

import br.com.brq.entities.Autor;
import br.com.brq.persistence.generics.DAOGeneric;

public class DAOAutor extends DAOGeneric<Autor>{

	//método para buscar 1 autor pelo id..
	public Autor findById(Integer idAutor) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();

		Autor a = (Autor) session.get(Autor.class, idAutor);
		
		session.close();
		return a; //retornando o objeto..
	}
	
	//método para listar todos os autores..
	public List<Autor> findAll() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery("autor.findall");
		List<Autor> lista = query.list();
		
		session.close();
		return lista; //retornando a lista..
	}	
}




