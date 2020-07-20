/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author edmilson.cassecasse
 */
@Entity(name = "Legal")
@Table(name = "legal")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Legal extends Client implements Serializable {
    
    @NotBlank(message = "Licence number must not be blank")
    @NotNull(message = "Licence number must be filled")
    @Length(min = 2, max = 21, message = "Licence number must contain between {min} and {max} characteres")
    @Column(name = "licenceNo", length = 21, nullable = false, unique = true)
    @Getter @Setter private String licenceNo;
    
}
