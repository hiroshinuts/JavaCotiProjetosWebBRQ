package br.com.brq.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.brq.entities.Cliente;

public class DAOCliente {

	private Session session;
	private Transaction transaction;
	private Query query;
	
	public void saveOrUpdate(Cliente c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.saveOrUpdate(c);
		transaction.commit();
		
		session.close();
	}
		
	public void delete(Cliente c) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();
		
		session.close();
	}
	
	public List<Cliente> findAll() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Cliente.FIND_ALL);
		List<Cliente> lista = query.list();
		
		session.close();
		return lista;
	}
	
	public Cliente findById(Integer idCliente) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		Cliente c = (Cliente) session.get(Cliente.class, idCliente);
		session.close();
		
		return c;
	}
	
	
}




