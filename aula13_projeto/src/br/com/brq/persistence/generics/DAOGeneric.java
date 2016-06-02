package br.com.brq.persistence.generics;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.brq.persistence.HibernateUtil;

public abstract class DAOGeneric<T> implements IDAOGeneric<T> {

	protected Session session;
	protected Transaction transaction;
	protected Query query;
	
	@Override
	public void insert(T obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
	}
	
	@Override
	public void update(T obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();		
	}
	
	@Override
	public void delete(T obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();		
	}
	
}







