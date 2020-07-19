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
public class ConnectionFactoryBuilder {
    
    
    private ConnectionFactoryBuilder() {
    }
    
    
    
    public static ConnectionFactoryBuilder getInstance() {
        return ConnectionFactoryBuilderHolder.INSTANCE;
    }
    
    private static class ConnectionFactoryBuilderHolder {
        public static ConnectionFactoryBuilder INSTANCE = new ConnectionFactoryBuilder();
    }
}
