package br.com.gerenciadorAulas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private EntityManagerFactory emf;
	private static JpaUtil instance;
	
	public JpaUtil(){
		this.emf = Persistence.createEntityManagerFactory("gerenciadorAulas");
	}

	public static synchronized JpaUtil getInstance() {

		if (instance == null) {
			instance = new JpaUtil();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
