package com.infotel.bank.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "etudiant")
    private List<Recevoir> receive;
}
