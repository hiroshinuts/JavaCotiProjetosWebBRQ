package br.com.brq.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	//gerenciador de entidades do Hibernate 4
	private static EntityManager entityManager;

	//método para configurar e retornar o EntityManager
	public static EntityManager getEntityManager() {
		
		//nome da configuração feita no arquivo /META-INF/persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aula");
		
		if(entityManager == null){ //se não foi incializado..
			entityManager = factory.createEntityManager();
		}
		
		return entityManager;
	}
	
	
}
