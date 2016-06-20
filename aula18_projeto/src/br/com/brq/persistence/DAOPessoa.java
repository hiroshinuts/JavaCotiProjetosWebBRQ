package br.com.brq.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brq.entities.Pessoa;

public class DAOPessoa {

	//declarar o EntityManager...
	private EntityManager entityManager;
	
	//construtor..
	public DAOPessoa() {
		//inicializar o entityManager..
		entityManager = HibernateUtil.getEntityManager();
	}
	
	//m�todo para gravar uma pessoa..
	public void insert(Pessoa p) throws Exception{
		entityManager.getTransaction().begin();
		entityManager.persist(p); //gravando..
		entityManager.getTransaction().commit();
	}
	
	//m�todo para atualizar..
	public void update(Pessoa p) throws Exception{
		entityManager.getTransaction().begin();
		entityManager.merge(p); //atualizando..
		entityManager.getTransaction().commit();
	}
	
	//m�todo para excluir..
	public void delete(Pessoa p) throws Exception{
		entityManager.getTransaction().begin();
		entityManager.remove(p); //excluindo..
		entityManager.getTransaction().commit();
	}
	
	//m�todo para buscar 1 pessoa pelo id..
	public Pessoa findById(Integer idPessoa) throws Exception{
		return entityManager.find(Pessoa.class, idPessoa);
	}
	
	//m�todo para executar a namedquery..
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll() throws Exception{
		return entityManager.createNamedQuery(Pessoa.FIND_ALL)
				.getResultList();
	}
	
}




