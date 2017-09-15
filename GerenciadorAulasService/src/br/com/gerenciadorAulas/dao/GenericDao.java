package br.com.gerenciadorAulas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gerenciadorAulas.util.JpaUtil;

public abstract class GenericDao <T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Class<T> aClass;
	
	protected GenericDao(Class<T> aClass){
		this.aClass = aClass;
	}
	
	protected EntityManager getEntityManager(){
		return JpaUtil.getInstance().getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public T findOne(String jpql, Object ... params){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery(jpql);
		
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		
		T entity = (T) query.getSingleResult();
		
		manager.getTransaction().commit();
		manager.close();
		
		return entity;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> find(String jpql, Object ... params){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery(jpql);
		
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		
		List<T> entities = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		
		return entities;
	}
	
	
	public T findById(Long id){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		T entity = (T) manager.find(aClass, id);
		
		manager.getTransaction().commit();
		manager.close();
		
		return entity;
	}
	
	public void save(T entity){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		Query query = manager.createQuery("from " + aClass.getSimpleName());
		List<T> entities = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		
		return entities;
	}
	
	public void update(T entity){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void remove(Long id){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.getReference(aClass, id));
		manager.getTransaction().commit();
		manager.close();
	}
	
	
}
