/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author edmilson.cassecasse
 */


public abstract class Client {
    
    @NotNull
    protected Integer id;
    @NotNull(message = "Name must be filled")
    @NotBlank(message = "Name must not be blank")
    @Length(min = 3, max = 65, message = "Name contain between {min} and {max} characters")
    protected String name;
    @NotNull(message = "Vat Number must be filled")
    protected int vatNumber;
    
}
