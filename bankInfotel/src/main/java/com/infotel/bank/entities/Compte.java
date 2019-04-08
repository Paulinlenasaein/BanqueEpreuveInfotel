package com.infotel.bank.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(unique = true, nullable = false)
    @Length(min = 7, max = 8)
    private String matricule;

    @Column(unique = true, nullable = false)
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", 
            message = "Adresse mail invalide, veuillez le vérifier")
    private String email;

    @Column(unique = true, nullable = false)
    @Length(min = 8)
    private String password;
    
    @Column(unique = true, nullable = false)
    @Length(min = 8)
    private String cni;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7) NOT NULL DEFAULT 'STUDENT'")
    private RoleName role;
    
    @ManyToOne(optional = false)
    private Departement departement;
    
    @Column(nullable = true, columnDefinition = "INT(1) NOT NULL DEFAULT 0")
    private int isRegister;
}
