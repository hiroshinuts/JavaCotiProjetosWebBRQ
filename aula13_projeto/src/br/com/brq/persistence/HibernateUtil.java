package br.com.brq.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//classe simples com a finalidade de ler o arquivo de configura��o
//config.xml e produzir conex�es com a base de dados
public class HibernateUtil {

	private static final SessionFactory sessionFactory; //conex�o..

	static {
		try {
			sessionFactory = new AnnotationConfiguration()
					.configure("br/com/brq/config/mysql_hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
