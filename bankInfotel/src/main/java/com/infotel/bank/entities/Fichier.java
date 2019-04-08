package com.infotel.bank.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Fichier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_fich;

    @Column(nullable = false, unique = true)
    private String fileName;
    
    @Column(nullable = false, unique = true)
    private String filePath;
    
    @Column(unique = true)
    private String fileCorrectionName;

    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double fileSize;
    
    @Column(columnDefinition = "DOUBLE")
    private Double fileCorrectionSize;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fileDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fileCorrectionDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5) NOT NULL")
    private TypeFichier type;

    @Temporal(TemporalType.DATE)
    private Date session;

    @Column(columnDefinition = "INT(11) NOT NULL DEFAULT 0")
    private Long upDow;

    @ManyToOne(optional = false)
    private UE ue;

    @ManyToOne(optional = false)
    private Enseignant enseignant;
  
}
