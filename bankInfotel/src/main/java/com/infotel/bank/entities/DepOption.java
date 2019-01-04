package com.infotel.bank.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class DepOption implements Serializable {

    @Id
    @Length(min = 2, max = 15)
    private String codeOption;

    @Column(nullable = false)
    @Length(min = 2, max = 25)
    private String nomOption;

    @ManyToOne(optional = false)
    private Departement departement;

}
