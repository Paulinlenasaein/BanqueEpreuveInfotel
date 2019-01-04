package com.infotel.bank.dao;

import com.infotel.bank.entities.DepOption;
import com.infotel.bank.entities.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface IDepOptionDao extends JpaRepository<DepOption, String>{
    
    /**
     * retourne les options d'un département donné
     *
     * @param departement département dont les options sont recherchées
     * @param page pagination du résultat
     * @return une page d'objets DepOption
     */
    public Page<DepOption> findByDepartement(Departement departement, Pageable page);
}
