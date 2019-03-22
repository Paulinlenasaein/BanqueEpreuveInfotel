package com.infotel.bank.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class Recevoir implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(optional = false)
    private Etudiant etudiant;
    
    @ManyToOne(optional = false)
    private Fichier fichier;
    
    @Column(columnDefinition = "INT(1) NOT NULL DEFAULT 1")
    private int status;
}
