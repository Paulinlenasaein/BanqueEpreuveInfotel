package com.infotel.bank.dao;

import com.infotel.bank.entities.Etudiant;
import com.infotel.bank.entities.Niveau;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IEtudiantDao extends JpaRepository<Etudiant, Long>{
    
    /**
     * retourne le compte des étudiants étant à un niveau donné
     *
     * @param niveau niveau des étudiants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Etudiant
     */
    public Page<Etudiant> findByNiveau(Niveau niveau, Pageable page);
}
