package com.infotel.bank.dao;

import com.infotel.bank.entities.UeNiveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IUeNiveauDao extends JpaRepository<UeNiveau, Long>{
    
}
