/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.core.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author edmilson.cassecasse
 */
public interface InstanceFactory {
    
    static Object build(Class c) {
        Constructor<?> constructor;
        
        try {
            constructor = c.getConstructors()[0];
            Object object = constructor.newInstance();
            return object;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException 
                | SecurityException | InvocationTargetException e) {
            System.err.println(e);
        }
        return null;
    }
}
