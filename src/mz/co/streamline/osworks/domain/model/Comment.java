/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name = "Comment")
@Table(name = "comment")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Comment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @NotBlank(message = "Description must not be blank")
    @NotNull(message = "Description must be filled")
    @Length(min = 3, max = 250, message = "Description must contain between {min} and {max} characteres")
    @Column(name = "description", length = 250, nullable = false)
    @Getter @Setter private String description;
    @NotNull(message = "Send Time must be filled")
    @Column(name = "sendTime", columnDefinition = "datetime", nullable = false)
    @Getter @Setter private OffsetDateTime sendTime;
    @NotNull(message = "Service Order must be filled")
    @ManyToOne
    @JoinColumn(name = "serviceOrder_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter private ServiceOrder serviceOrder;
    
}
