package com.infotel.bank.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class Departement implements Serializable {
    
    @Id
    @Length(min = 2, max = 15)
    private String code;
    
    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "departement")
    private List<DepOption> options;
}
