/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edmilson.cassecasse
 */

@EqualsAndHashCode(of = {"id"})
public abstract class Client {
    
    @Getter
    @Setter
    protected Integer id;
    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    protected int vatNumber;
    
}
