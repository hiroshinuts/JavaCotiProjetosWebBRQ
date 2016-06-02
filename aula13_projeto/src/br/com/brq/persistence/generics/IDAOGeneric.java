package br.com.brq.persistence.generics;

public interface IDAOGeneric<T> {

	void insert(T obj) throws Exception; //método abstrato.
	 
	void update(T obj) throws Exception; //método abstrato.
	
	void delete(T obj) throws Exception; //método abstrato.
	
}
