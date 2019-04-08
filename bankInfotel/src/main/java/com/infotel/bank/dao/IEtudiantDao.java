package com.infotel.bank.dao;

import com.infotel.bank.entities.Departement;
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
     * retourne le compte d'un étudiant ayant un matricule donné
     *
     * @param matricule matricule de l'étudiant recherché
     * @return un objet Etudiant
     */
    public Etudiant findByMatricule(String matricule);

    /**
     * retourne le compte d'un étudiant ayant un email donné
     *
     * @param email emaile de l'étudiant recherché
     * @return un objet Etudiant
     */
    public Etudiant findByEmail(String email);

    /**
     * retourne le compte d'un étudiant ayant un numéro de CNI donné
     *
     * @param cni numéro de CNI de l'étudiant recherché
     * @return un objet Etudiant
     */
    public Etudiant findByCni(String cni);

    /**
     * retourne le compte d'un étudiant ayant un matricule et un numéro de CNI
     * donnés
     *
     * @param matricule matricule de l'étudiant recherché
     * @param cni numéro de CNI de l'étudiant recherché
     * @param departement département concerné
     * @param regist status d'inscription (1: inscrit, 0: pas inscrit)
     * @return un objet Enseignant
     */
    public Etudiant findByMatriculeAndCniAndDepartementAndIsRegister(String matricule, String cni, Departement departement, int regist);

    /**
     * retourne le compte d'un étudiant ayant un matricule et password doinnés
     *
     * @param matricule matricule de l'étudiant recherché
     * @param password mot de passe du compte
     * @param departement département concerné
     * @param regist status d'inscription (1: inscrit, 0: pas inscrit)
     * @return un objet Etudiant
     */
    public Etudiant findByMatriculeAndPasswordAndDepartementAndIsRegister(String matricule, String password, Departement departement, int regist);
    
    /**
     * retourne le compte des étudiants inscrit dans un niveau donné
     *
     * @param isRegister status d'inscription (1: oui, 0: non)
     * @param niveau niveau des étudiants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Etudiant
     */
    public Page<Etudiant> findByIsRegisterAndNiveau(int isRegister, Niveau niveau, Pageable page);
    
    /**
     * retourne le compte des étudiants étant à un niveau donné
     *
     * @param niveau niveau des étudiants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Etudiant
     */
    public Page<Etudiant> findByNiveau(Niveau niveau, Pageable page);
}
