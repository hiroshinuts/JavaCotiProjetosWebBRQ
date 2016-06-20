package br.com.brq.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import br.com.brq.entities.Pessoa;

public class DAOPessoa {

	//Hibernate embedded no spring...
	private HibernateTemplate hibernate; //null.
	
	//INJEÇÂO DE DEPENDENCIA!!
	//método para receber a configuração de SessionFactory do applicationContext.xml
	//esta configuração será enviada por injeção de dependencia, através do Spring..
	public void setSessionFactory(SessionFactory sessionFactory){
		//utilizar este sessionFactory recebido para inicializar o HibernateTemplate..
		hibernate = new HibernateTemplate(sessionFactory);
	}
	
	
	//método para cadastrar pessoa..
	public void insert(Pessoa p) throws Exception{
		hibernate.persist(p); //gravando..
	}
	
	//método para atualizar pessoa..
	public void update(Pessoa p) throws Exception{
		hibernate.merge(p); //atualizando..
	}
	
	//método para excluir pessoa..
	public void delete(Pessoa p) throws Exception{
		hibernate.delete(p); //excluindo..
	}
	
	//método para buscar 1 pessoa pelo id..
	public Pessoa findById(Integer idPessoa) throws Exception{
		return (Pessoa) hibernate.get(Pessoa.class, idPessoa);
	}
	
	//método para listar todos os registros..
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() throws Exception{
		return hibernate.findByNamedQuery(Pessoa.FIND_ALL);
	}
}



