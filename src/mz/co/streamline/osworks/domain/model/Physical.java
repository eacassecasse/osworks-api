/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author edmilson.cassecasse
 */
@Entity(name = "Physical")
@Table(name = "physical")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Physical extends Client implements Serializable {
    
    @NotNull(message = "Surname must be filled")
    @NotBlank(message = "Surname must not be blank")
    @Length(min = 2, max = 40, message = "Surname must contain between {min} and {max} characteres")
    @Column(name = "surname", length = 40, nullable = false)
    @Getter @Setter private String surname;
    @NotNull(message = "Identification number must be filled")
    @NotBlank(message = "Identification number must not be blank")
    @Length(min = 7, max = 21, message = "Identification number must contain between {min} and {max} characteres")
    @Column(name = "identificationNo", length = 21, nullable = false, unique = true)
    @Getter @Setter
    private String identificationNo;
    @NotNull(message = "Gender must be filled")
    @Column(name = "gender", columnDefinition = "enum('F','M')", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private Gender gender;
    
}
