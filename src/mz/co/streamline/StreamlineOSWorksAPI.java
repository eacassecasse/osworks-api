/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline;

import javax.persistence.Persistence;
import mz.co.streamline.osworks.core.connection.ConnectionFactoryBuilder;
import mz.co.streamline.osworks.domain.model.Client;
import mz.co.streamline.osworks.domain.model.Physical;

/**
 *
 * @author edmilson.cassecasse
 */
public class StreamlineOSWorksAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(ConnectionFactoryBuilder.CONNECTION_FACTORY);
    }
    
}
