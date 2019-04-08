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
public interface IRecevoirDao extends JpaRepository<Recevoir, Long>{
    
    /**
     * retourne les posts fait concernant un étudiant donné
     *
     * @param etudiant étudiants concerné
     * @param page pagination du résultat
     * @return une page d'objets Recevoir
     */
    public Page<Recevoir> findByEtudiant(Etudiant etudiant, Pageable page);
    
    /**
     * retourne les posts fait concernant un fichier donné
     *
     * @param fichier fichier concerné
     * @param page pagination du résultat
     * @return une page d'objets Recevoir
     */
    public Page<Recevoir> findByFichier(Fichier fichier, Pageable page);
    
    /**
     * retourne le post fait à un étudiant concernant un fichier donné
     *
     * @param etudiant étudiants concerné
     * @param fichier fichier concerné
     * @return une page d'objets Recevoir
     */
    public Recevoir findByEtudiantAndFichier(Etudiant etudiant, Fichier fichier);
    
    /**
     * retourne les post faits à un étudiant et ayant un status donné
     *
     * @param etudiant compte étudiant concerné
     * @param status status de post (vu ou non vu)
     * @param page pagination du résultat
     * @return une page d'objets Recevoir
     */
    public Page<Recevoir> findByEtudiantAndStatus(Etudiant etudiant, int status, Pageable page);
    
}
