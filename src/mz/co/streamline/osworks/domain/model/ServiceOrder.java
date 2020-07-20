/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.streamline.osworks.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Entity(name = "ServiceOrder")
@Table(name = "serviceOrder")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ServiceOrder implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @NotBlank(message = "Description must not be blank")
    @NotNull(message = "Description must be filled")
    @Length(min = 2, max = 120, message = "Description must contain between {min} and {max} characteres")
    @Column(name = "description", length = 120, nullable = false)
    @Getter @Setter private String description;
    @NotNull(message = "Price must be filled")
    @Column(name = "price", columnDefinition = "decimal", length = 14, precision = 2, nullable = false)
    @Getter @Setter private BigDecimal price;
    @NotNull(message = "Open Date must be filled")
    @Column(name = "openDate", columnDefinition = "datetime", nullable = false)
    @Getter @Setter private OffsetDateTime openDate;
    @NotNull(message = "Status must be filled")
    @Column(name = "status", columnDefinition = "enum('OPEN','FINALIZED','ON_HOLD','CANCELED')", length = 9, nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter @Setter private ServiceOrderStatus status;
    @NotNull(message = "Client must be filled")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter private Client client;
    @OneToMany(mappedBy = "serviceOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Getter @Setter private List<Comment> comments;
     
}
