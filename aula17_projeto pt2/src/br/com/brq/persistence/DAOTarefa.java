package br.com.brq.persistence;

import java.util.Date;
import java.util.List;

import br.com.brq.entities.Tarefa;
import br.com.brq.generics.DAOGeneric;

public class DAOTarefa extends DAOGeneric<Tarefa, Integer>{

	public DAOTarefa() {
		super(Tarefa.class);
	}
	
	public List<Tarefa> findByData(Date dataIni, Date dataFim, Integer idUsuario) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Tarefa.FINDBY_DATA);
		query.setDate("p1", dataIni);
		query.setDate("p2", dataFim);
		query.setInteger("p3", idUsuario);
		List<Tarefa> lista = query.list();
		
		session.close();
		return lista;
	}
	
}
