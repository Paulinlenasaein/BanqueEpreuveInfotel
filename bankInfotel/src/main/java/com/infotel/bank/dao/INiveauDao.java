package com.infotel.bank.dao;

import com.infotel.bank.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface INiveauDao extends JpaRepository<Niveau, String>{
    
    /**
     * retourne le niveau ayant l'intitulé donné
     *
     * @param intitule intitulé du niveau
     * @return un objet Niveau
     */
    public Niveau findByIntitul(String intitule);
}
