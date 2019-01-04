package com.infotel.bank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author paulinlenasaein
 */
@Entity
public class UeNiveau {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(optional = false)
    private Niveau niveau;
    
    @ManyToOne(optional = false)
    private UE ue;
}
