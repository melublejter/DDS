package main.scala.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ModelManager {

    private static EntityManagerFactory emf;

    private static ThreadLocal<EntityManager> threadLocal;

    static {
    	try {
			emf = Persistence.createEntityManagerFactory("db");
			threadLocal = new ThreadLocal<EntityManager>();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static EntityManager getManager() {
		EntityManager manager = threadLocal.get();
		if (manager == null || !manager.isOpen()) {
		    manager = emf.createEntityManager();
		    threadLocal.set(manager);
		}
		return manager;
    }

    public static void closeEntityManager() {
		EntityManager em = threadLocal.get();
		threadLocal.set(null);
		em.close();
    }

    public static void beginTransaction() {
    	EntityManager em = getManager();
		EntityTransaction tx = em.getTransaction();
		
		if(!tx.isActive()){
			tx.begin();
		}
    }

    public static void commit() {
    	EntityManager em = getManager();
		EntityTransaction tx = em.getTransaction();
		if(tx.isActive()){
			tx.commit();
		}

    }

    public static void rollback(){
    	EntityManager em = getManager();
		EntityTransaction tx = em.getTransaction();
		if(tx.isActive()){
			tx.rollback();
		}
    }
    
    public static Query createQuery(String query) {
    	return getManager().createQuery(query);
    }

}
