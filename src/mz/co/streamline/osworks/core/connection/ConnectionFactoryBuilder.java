/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.core.connection;


/**
 *
 * @author edmilson.cassecasse
 */
public interface ConnectionFactoryBuilder {
    
    @Deprecated
    static ConnectionFactory CONNECTION_FACTORY = ConnectionFactory.getInstance();
 
    public static ConnectionFactory createPersistenceUnit(String persistence_unit) {
        CONNECTION_FACTORY.setPersistence_unit(persistence_unit);
        return CONNECTION_FACTORY;
    }
}
