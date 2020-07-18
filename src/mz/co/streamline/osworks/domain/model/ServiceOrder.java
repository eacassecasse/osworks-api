/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 *
 * @author edmilson.cassecasse
 */
public class ServiceOrder {
    
    private Integer id;
    private String description;
    private BigDecimal price;
    private OffsetDateTime openDate;
    private ServiceOrderStatus status;
    private Client client;
    
    
}
