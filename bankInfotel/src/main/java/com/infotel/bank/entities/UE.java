package com.infotel.bank.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class UE {
    
    @Id
    @Length(min = 2, max = 10)
    private String codeUE;
    
    @Column(nullable = false)
    private String intitule;
    
    @Column(nullable = false)
    private String shared;
    
    @ManyToMany
    private List<Niveau> niveaux;
    
    @OneToMany(mappedBy = "ue")
    private List<Epreuve> epreuve;
}
