package com.infotel.bank.dao;

import com.infotel.bank.entities.Compte;
import com.infotel.bank.entities.Epreuve;
import com.infotel.bank.entities.TypeEpreuve;
import com.infotel.bank.entities.UE;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IEpreuveDao extends JpaRepository<Epreuve, Long>{
    
    /**
     * retourne les épreuves d'une UE donné
     *
     * @param ue UE dont les épreuves sont recherchées
     * @param page pagination du résultat
     * @return une page d'objets Epreuve
     */
    public Page<Epreuve> findByUe(UE ue, Pageable page);
    
    /**
     * retourne les épreuves d'une session d'une UE donné
     *
     * @param ue UE dont les épreuves sont recherchées
     * @param session session de déroulement de l'épreuve
     * @param page pagination du résultat
     * @return une page d'objets Epreuve
     */
    public Page<Epreuve> findByUeAndSession(UE ue, Date session, Pageable page);
    
    /**
     * retourne les épreuves d'une session et d'un type précis d'une UE donné
     *
     * @param ue UE dont les épreuves sont recherchées
     * @param session session de déroulement de l'épreuve
     * @param type CC, TP, TPE, EE ou RTPGE
     * @return une page d'objets Epreuve
     */
    public Epreuve findByUeAndSessionAndType(UE ue, Date session, TypeEpreuve type);
    
    /**
     * retourne les épreuves postées par un utilisateur donné
     *
     * @param compte compte d'un utilisateur
     * @param page pagination du résultat
     * @return une page d'objets Epreuve
     */
    public Page<Epreuve> findByCompte(Compte compte,  Pageable page);
}
