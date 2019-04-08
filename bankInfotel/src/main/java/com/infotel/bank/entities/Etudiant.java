package com.infotel.bank.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class Etudiant extends Compte {
    
    @ManyToOne(optional = false)
    private Niveau niveau;
    
}
