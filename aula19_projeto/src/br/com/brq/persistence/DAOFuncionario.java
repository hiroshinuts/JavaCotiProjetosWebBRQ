package br.com.brq.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.brq.entities.Funcionario;

public class DAOFuncionario {

	//gerenciador de entidades (Hibernate 4)
	private EntityManager manager; //null..
	
	//construtor..
	public DAOFuncionario() {
		//inicializar o entitymanager..
		manager = Persistence.createEntityManagerFactory("aula")
					.createEntityManager();
	}
	
	public void insert(Funcionario f) throws Exception{
		manager.getTransaction().begin();
		manager.persist(f); //gravando..
		manager.getTransaction().commit();
	}
	
	public void update(Funcionario f) throws Exception{
		manager.getTransaction().begin();
		manager.merge(f); //alterando..
		manager.getTransaction().commit();
	}
	
	public void delete(Funcionario f) throws Exception{
		manager.getTransaction().begin();
		manager.remove(f); //excluindo..
		manager.getTransaction().commit();
	}
	
	public Funcionario findById(Integer idFuncionario) throws Exception{
		return manager.find(Funcionario.class, idFuncionario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() throws Exception{
		return manager.createNamedQuery(Funcionario.FIND_ALL)
				.getResultList();
	}
}




