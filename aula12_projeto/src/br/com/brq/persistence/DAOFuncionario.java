package br.com.brq.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.brq.entities.Funcionario;

public class DAOFuncionario {

	// atributos..
	private Session session; // utilizado para armazenar a conexão..
	private Transaction transaction; // commit ou rollback (transações)
	private Query query; // executar consultas
	// HQL - Hibernate Query Language (sintaxe para consultas..)

	// método para inserir um cliente na base de dados..
	public void insert(Funcionario f) throws Exception {
		// abrir conexão..
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction(); // abrir transação..
		session.save(f); // inserindo..
		transaction.commit(); // executando..

		// fechar a conexão..
		session.close();
	}

	// método para atualizar um cliente na base de dados..
	public void update(Funcionario f) throws Exception {
		// abrir conexão..
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction(); // abrir transação..
		session.update(f); // atualizando..
		transaction.commit(); // executando..

		// fechar a conexão..
		session.close();
	}

	// método para excluir um cliente na base de dados..
	public void delete(Funcionario f) throws Exception {
		// abrir conexão..
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction(); // abrir transação..
		session.delete(f); // excluindo..
		transaction.commit(); // executando..

		// fechar a conexão..
		session.close();
	}
	
	//método para buscar 1 cliente pelo id..
	public Funcionario findById(Integer idFuncionario) throws Exception{		
		//abrir conexão..
		session = HibernateUtil.getSessionFactory().openSession();
		
		//método para buscar 1 objeto pela chave..
		Funcionario f = (Funcionario) session.get(Funcionario.class, idFuncionario);
		
		session.close();
		return f; //retornar o objeto..
	}
	
	
	//método para executar a consulta findall..
	public List<Funcionario> findAll() throws Exception{
		//abrir conexão..
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery("funcionario.findall"); //nome da consulta..
		List<Funcionario> lista = query.list();
		
		session.close(); //fechar a conexão..
		return lista; //retornando a lista.
	}
	
	//método para executar a consulta findbydata..
	public List<Funcionario> findByData(Date dataIni, Date dataFim) throws Exception{
		//abrir conexão..
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery("funcionario.findbydata");
		query.setDate("p1", dataIni); //passagem de parametro
		query.setDate("p2", dataFim); //passagem de parametro
		
		List<Funcionario> lista = query.list(); //executando..
		
		session.close(); //fechar conexão..
		return lista; //retornando a lista..
	}
	
}








