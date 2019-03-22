package com.infotel.bank.dao;

import com.infotel.bank.entities.Enseignant;
import com.infotel.bank.entities.Fichier;
import com.infotel.bank.entities.TypeFichier;
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
public interface IFichierDao extends JpaRepository<Fichier, Long>{
    
    /**
     * retourne les fichiers d'une UE donné
     *
     * @param ue UE dont les fichiers sont recherchées
     * @param page pagination du résultat
     * @return une page d'objets Fichier
     */
    public Page<Fichier> findByUe(UE ue, Pageable page);
    
    /**
     * retourne les fichiers d'une session d'une UE donné
     *
     * @param ue UE dont les fichiers sont recherchées
     * @param session session de déroulement de le fichier
     * @param page pagination du résultat
     * @return une page d'objets Fichier
     */
    public Page<Fichier> findByUeAndSession(UE ue, Date session, Pageable page);
    
    /**
     * retourne les fichiers d'une session et d'un type précis d'une UE donné
     *
     * @param ue UE dont les fichiers sont recherchées
     * @param session session de déroulement de le fichier
     * @param type CC, TP, TPE, EE ou RTPGE
     * @return une page d'objets Fichier
     */
    public Fichier findByUeAndSessionAndType(UE ue, Date session, TypeFichier type);
    
    /**
     * retourne les fichiers postées par un utilisateur donné
     *
     * @param enseignant enseignant ayant posté le fichier
     * @param page pagination du résultat
     * @return une page d'objets Fichier
     */
    public Page<Fichier> findByEnseignant(Enseignant enseignant,  Pageable page);
}
