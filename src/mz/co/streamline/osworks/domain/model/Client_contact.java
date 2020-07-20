/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author edmilson.cassecasse
 */
@Entity(name = "Client_contact")
@Table(name = "client_contact")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper = true)
public class Client_contact extends Contact implements Serializable {
    
    @NotNull(message = "Client must be filled")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter private Client client;
    
}
