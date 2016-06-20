package br.com.brq.persistence;

import br.com.brq.entities.Usuario;
import br.com.brq.generics.DAOGeneric;

public class DAOUsuario extends DAOGeneric<Usuario, Integer>{

	public DAOUsuario() {
		super(Usuario.class);
	}
	
	public boolean hasLogin(String login) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Usuario.HAS_LOGIN);
		query.setString("p1", login);
		Long qtd = (Long) query.uniqueResult();
		
		session.close();
		return qtd > 0; //true / false..
	}
	
	public Usuario authenticate(String login, String senha) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Usuario.AUTHENTICATE);
		query.setString("p1", login);
		query.setString("p2", senha);
		Usuario u = (Usuario) query.uniqueResult();
		
		session.close();
		return u; //retornando o usuario..
	}
	
}











