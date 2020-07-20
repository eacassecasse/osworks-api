/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "Contact")
@Table(name = "contact")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class Contact implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter protected Long id;
    @NotBlank(message = "Description must not be blank")
    @NotNull(message = "Description must be filled")
    @Length(min = 7, max = 18, message = "Description must contain between {min} and {max} characteres")
    @Column(name = "description", length = 18, nullable = false)
    @Getter @Setter protected String description;
    @NotNull(message = "Country must be filled")
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter protected Country country;
    
    
}
