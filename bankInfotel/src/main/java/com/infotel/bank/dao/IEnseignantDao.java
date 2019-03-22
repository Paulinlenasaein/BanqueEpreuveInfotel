package com.infotel.bank.dao;

import com.infotel.bank.entities.Departement;
import com.infotel.bank.entities.Enseignant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IEnseignantDao extends JpaRepository<Enseignant, Long> {

    /**
     * retourne le compte des enseignants appartement à un département donné
     *
     * @param departement département des enseignants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Enseignant
     */
    public Page<Enseignant> findByDepartement(Departement departement, Pageable page);

}
