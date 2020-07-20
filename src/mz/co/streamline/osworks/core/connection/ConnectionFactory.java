/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.core.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author edmilson.cassecasse
 */
public class ConnectionFactory {
    
    private static String persistence_unit;
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
   
    
    private ConnectionFactory() {
    }
    
    protected void setPersistence_unit(String persistence_unit) {
        ConnectionFactory.persistence_unit = persistence_unit;
    }
    
    public EntityManager build() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistence_unit);
        }
        
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
    
        
    

    @Override
    public String toString() {
        return persistence_unit;
    }
    public static ConnectionFactory getInstance() {
        return ConnectionFactoryHolder.INSTANCE;
    }
    
    private static class ConnectionFactoryHolder {
        public static ConnectionFactory INSTANCE = new ConnectionFactory();
    }
}
