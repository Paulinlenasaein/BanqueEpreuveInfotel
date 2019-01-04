package com.infotel.bank.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class Epreuve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String file_name;

    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double file_size;

    @Temporal(TemporalType.TIMESTAMP)
    private Date file_date;

    @Column(columnDefinition = "VARCHAR(5) NOT NULL")
    private TypeEpreuve type;

    @Temporal(TemporalType.DATE)
    private Date session;

    @Column(columnDefinition = "INT(11) NOT NULL DEFAULT 0")
    private Long up_dow;

    @ManyToOne(optional = false)
    private UE ue;

    @ManyToOne(optional = false)
    private Compte compte;
}
