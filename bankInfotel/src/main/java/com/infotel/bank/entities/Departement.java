package com.infotel.bank.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Departement implements Serializable {

    @Id
    @Length(min = 2, max = 15)
    private String code;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String chefDep;
    
    @Column(nullable = false)
    private String image;
    
}
