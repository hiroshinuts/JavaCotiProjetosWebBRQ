package br.com.brq.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import br.com.brq.entities.Pessoa;

public class DAOPessoa {

	//Hibernate embedded no spring...
	private HibernateTemplate hibernate; //null.
	
	//INJE��O DE DEPENDENCIA!!
	//m�todo para receber a configura��o de SessionFactory do applicationContext.xml
	//esta configura��o ser� enviada por inje��o de dependencia, atrav�s do Spring..
	public void setSessionFactory(SessionFactory sessionFactory){
		//utilizar este sessionFactory recebido para inicializar o HibernateTemplate..
		hibernate = new HibernateTemplate(sessionFactory);
	}
	
	
	//m�todo para cadastrar pessoa..
	public void insert(Pessoa p) throws Exception{
		hibernate.persist(p); //gravando..
	}
	
	//m�todo para atualizar pessoa..
	public void update(Pessoa p) throws Exception{
		hibernate.merge(p); //atualizando..
	}
	
	//m�todo para excluir pessoa..
	public void delete(Pessoa p) throws Exception{
		hibernate.delete(p); //excluindo..
	}
	
	//m�todo para buscar 1 pessoa pelo id..
	public Pessoa findById(Integer idPessoa) throws Exception{
		return (Pessoa) hibernate.get(Pessoa.class, idPessoa);
	}
	
	//m�todo para listar todos os registros..
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() throws Exception{
		return hibernate.findByNamedQuery(Pessoa.FIND_ALL);
	}
}



