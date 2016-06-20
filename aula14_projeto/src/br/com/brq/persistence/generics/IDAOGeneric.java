package br.com.brq.persistence.generics;

import java.io.Serializable;
import java.util.List;

//T -> generico para representar a entidade
//K -> generico para representar a chave primaria
public interface IDAOGeneric<T, K extends Serializable> {

	void insert(T obj) throws Exception;
	
	void update(T obj) throws Exception;
	
	void delete(T obj) throws Exception;
	
	List<T> findAll() throws Exception;
	
	T findById(K id) throws Exception;
	
}
