package com.infotel.bank.dao;

import com.infotel.bank.entities.Etudiant;
import com.infotel.bank.entities.Fichier;
import com.infotel.bank.entities.Recevoir;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface RecevoirDao extends JpaRepository<Recevoir, Long>{
    
    /**
     * retourne le compte des étudiants étant à un niveau donné
     *
     * @param etudiant étudiants concerné
     * @param page pagination du résultat
     * @return une page d'objets Recevoir
     */
    public Page<Etudiant> findByEtudiant(Etudiant etudiant, Pageable page);
    
    /**
     * retourne le compte des étudiants étant à un niveau donné
     *
     * @param fichier fichier concerné
     * @param page pagination du résultat
     * @return une page d'objets Recevoir
     */
    public Page<Etudiant> findByFichier(Fichier fichier, Pageable page);
    
    /**
     * retourne le compte des étudiants étant à un niveau donné
     *
     * @param status status de post (vu ou non vu)
     * @param page pagination du résultat
     * @return une page d'objets Recevoir
     */
    public Page<Etudiant> findByStatus(int status, Pageable page);
    
}
