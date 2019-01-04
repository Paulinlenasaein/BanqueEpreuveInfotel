package com.infotel.bank.dao;

import com.infotel.bank.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IUEDao extends JpaRepository<UE, String>{
    
     /**
     * retourne l'UE ayant l'intitulé donné
     *
     * @param intitule intitulé de l'UE
     * @return un objet UE
     */
    public UE findByIntitule(String intitule);
}
