package br.com.brq.persistence;

import java.util.List;

import br.com.brq.entities.Editora;
import br.com.brq.persistence.generics.DAOGeneric;

public class DAOEditora extends DAOGeneric<Editora> {

	public Editora findById(Integer idEditora) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		Editora e = (Editora) session.get(Editora.class, idEditora);

		session.close();
		return e; 
	}

	public List<Editora> findAll() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery("editora.findall");
		List<Editora> lista = query.list();

		session.close();
		return lista; // retornando a lista..
	}

}
