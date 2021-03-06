package com.infotel.bank.dao;

import com.infotel.bank.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IDepartementDao extends JpaRepository<Departement, String>{
    
}
