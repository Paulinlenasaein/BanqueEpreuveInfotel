package com.infotel.bank.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class Niveau implements Serializable {

    @Id
    @Length(min = 2, max = 15)
    private String codeNiveau;

    @Column(nullable = false)
    private String intitul;

    @Column(columnDefinition = "INT(2) UNSIGNED NOT NULL DEFAULT 0")
    private int nbreUE;

    @OneToOne
    private DepOption option;

    @OneToMany(mappedBy = "niveau")
    private List<Etudiant> etudiant;

    @OneToMany(mappedBy = "niveau")
    private List<UeNiveau> ueNiveau;
}
