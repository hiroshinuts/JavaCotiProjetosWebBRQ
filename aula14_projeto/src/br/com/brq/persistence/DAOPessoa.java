package br.com.brq.persistence;

import java.util.List;

import br.com.brq.entities.Pessoa;
import br.com.brq.persistence.generics.DAOGeneric;

public class DAOPessoa extends DAOGeneric<Pessoa, Integer>{

	public DAOPessoa() {
		super(Pessoa.class); //construtor da classe abstrata..
	}
	
	public List<Pessoa> findByNome(String nome) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Pessoa.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");
		List<Pessoa> lista = query.list();
		
		session.close();
		return lista;
	}
	
	public boolean hasEmail(String email) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Pessoa.HAS_EMAIL);
		query.setString("p1", email);
		Long qtd = (Long) query.uniqueResult();
		
		session.close();
		return qtd > 0; //true, false..
	}
	
}






