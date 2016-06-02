package br.com.brq.persistence;

import java.util.List;

import br.com.brq.entities.Livro;
import br.com.brq.persistence.generics.DAOGeneric;

public class DAOLivro extends DAOGeneric<Livro>{

	public Livro findById(Integer idLivro) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		Livro l = (Livro) session.get(Livro.class, idLivro);

		session.close();
		return l; 
	}

	public List<Livro> findAll() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery("livro.findall");
		List<Livro> lista = query.list();

		session.close();
		return lista; 
	}
	
}
