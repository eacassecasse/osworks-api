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
import javax.validation.constraints.Size;
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

@Entity(name = "Address")
@Table(name = "address")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter protected Long id;
    @NotBlank(message = "Neighborhood must not be blank")
    @NotNull(message = "Neighborhood must be filled")
    @Size(min = 2, max = 95, message = "Neighborhood must contain between {min} and {max} characteres")
    @Column(name = "neighborhood", length = 95, nullable = false)
    @Getter @Setter protected String neighborhood;
    @NotBlank(message = "House number must not be blank")
    @NotNull(message = "House number must be filled")
    @Length(min = 1, max = 8, message = "House number must contain between {min} and {max} characteres")
    @Column(name = "house_no", length = 8, nullable = false)
    @Getter @Setter protected String no;
    @NotNull(message = "Province must be filled")
    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter protected Province province;
    
}
