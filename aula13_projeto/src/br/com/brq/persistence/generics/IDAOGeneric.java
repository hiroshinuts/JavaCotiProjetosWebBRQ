package br.com.brq.persistence.generics;

public interface IDAOGeneric<T> {

	void insert(T obj) throws Exception; //m�todo abstrato.
	 
	void update(T obj) throws Exception; //m�todo abstrato.
	
	void delete(T obj) throws Exception; //m�todo abstrato.
	
}
