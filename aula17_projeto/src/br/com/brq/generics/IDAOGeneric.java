package br.com.brq.generics;

import java.io.Serializable;
import java.util.List;

public interface IDAOGeneric<T, K extends Serializable> {

	void saveOrUpdate(T obj) throws Exception;
	
	void delete(T obj) throws Exception;
	
	List<T> findAll() throws Exception;
	
	T findById(K id) throws Exception;
	
}
