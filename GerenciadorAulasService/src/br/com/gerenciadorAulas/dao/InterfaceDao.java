package br.com.gerenciadorAulas.dao;

import java.util.List;

public interface InterfaceDao<T> {
	
	public void save(T t);
	
	public List<T> listar();
	
	public void update(T t);
	
	public void remove(Long id);
	
	public T findOne(String jpql, Object ... params);
	
	public List<T> find(String jpql, Object ... params);
	
	public T findById(Long id);

}
