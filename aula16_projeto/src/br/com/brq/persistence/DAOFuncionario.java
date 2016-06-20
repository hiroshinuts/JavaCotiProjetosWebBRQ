package br.com.brq.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.brq.entities.Funcionario;

public class DAOFuncionario {

	private Session session;
	private Transaction transaction;
	private Query query;
	
	public void saveOrUpdate(Funcionario f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.saveOrUpdate(f);
		transaction.commit();
		
		session.close();
	}
	
	public void delete(Funcionario f) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(f);
		transaction.commit();
		
		session.close();
	}
	
	public List<Funcionario> findAll() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		@SuppressWarnings("unchecked")
		List<Funcionario> lista = session.createCriteria(Funcionario.class).list();
		
		session.close();
		return lista;
	}
	
	public Funcionario findById(Integer idFuncionario) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		Funcionario f = (Funcionario) session.get(Funcionario.class, idFuncionario);
		
		session.close();
		return f;
	}
	
}












