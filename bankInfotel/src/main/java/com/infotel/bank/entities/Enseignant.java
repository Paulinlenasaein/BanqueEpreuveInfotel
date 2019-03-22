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
public class Enseignant extends Compte {
    
    @ManyToOne(optional = false)
    private Departement departement;
    
    @OneToMany(mappedBy = "enseignant")
    private List<Fichier> Fichiers;
}
