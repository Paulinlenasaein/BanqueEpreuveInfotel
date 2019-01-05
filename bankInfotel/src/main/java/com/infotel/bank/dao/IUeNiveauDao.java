package com.infotel.bank.dao;

import com.infotel.bank.entities.Niveau;
import com.infotel.bank.entities.UE;
import com.infotel.bank.entities.UeNiveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IUeNiveauDao extends JpaRepository<UeNiveau, Long>{
    
    /**
     * retourne les UEs d'un niveau donné
     *
     * @param niveau niveau dont les UEs sont recherchées
     * @param page pagination du résultat
     * @return une page d'objets UeNiveau
     */
    public Page<UeNiveau> findByNiveau(Niveau niveau, Pageable page);
    
    /**
     * retourne les niveaux qui font une UE donné
     *
     * @param ue l'unité d'enseignement
     * @param page pagination du résultat
     * @return une page d'objets UeNiveau
     */
    public Page<UeNiveau> findByUe(UE ue, Pageable page);
}
