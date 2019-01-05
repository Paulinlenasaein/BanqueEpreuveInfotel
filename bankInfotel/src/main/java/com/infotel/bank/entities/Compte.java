package com.infotel.bank.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(unique = true, nullable = false)
    @Length(min = 8, max = 8)
    private String matricule;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    @Length(min = 8)
    private String password;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String lastName;
    
    @Column(columnDefinition = "VARCHAR(7) NOT NULL DEFAULT 'STUDENT'")
    private RoleName role;

    @ManyToOne(optional = false)
    private Niveau niveau;

    @OneToMany(mappedBy = "compte")
    private List<Epreuve> epreuves;
}
