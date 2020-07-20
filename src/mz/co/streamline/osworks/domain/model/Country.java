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
@Entity(name = "Country")
@Table(name = "country")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Country implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @NotBlank(message = "Description must not be blank")
    @NotNull(message = "Description must be filled")
    @Length(min = 3, max = 75, message = "Description must contain between {min} and {max} characteres")
    @Column(name = "description", length = 75, nullable = false)
    @Getter @Setter private String description;
    @NotBlank(message = "ISO must not be blank")
    @NotNull(message = "ISO must be filled")
    @Length(min = 3, max = 10, message = "ISO must contain between {min} and {max} characteres")
    @Column(name = "ISO", length = 10, nullable = false)
    @Getter @Setter private String iso;
    @NotBlank(message = "Extension Code must not be blank")
    @NotNull(message = "Extension Code must be filled")
    @Length(min = 2, max = 6, message = "Extension Code must contain between {min} and {max} characteres")
    @Column(name = "description", length = 6, nullable = false, unique = true)
    @Getter @Setter private String extensionCode;
    
    
}
