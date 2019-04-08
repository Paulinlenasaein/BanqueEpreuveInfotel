package com.infotel.bank.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class UE implements Serializable {

    @Id
    @Length(min = 2, max = 10)
    private String codeUE;

    @Column(nullable = false)
    private String intitule;
    
    @Column(nullable = false, columnDefinition = "int(2) not null")
    private int semestre;

    @Column(nullable = false)
    private String shared;
    
}
