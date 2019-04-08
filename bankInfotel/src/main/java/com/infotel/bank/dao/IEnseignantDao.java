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
     * retourne le compte d'un étudiant ayant un matricule donné
     *
     * @param matricule matricule de l'étudiant recherché
     * @return un objet Enseignant
     */
    public Enseignant findByMatricule(String matricule);

    /**
     * retourne le compte d'un étudiant ayant un email donné
     *
     * @param email emaile de l'étudiant recherché
     * @return un objet Enseignant
     */
    public Enseignant findByEmail(String email);

    /**
     * retourne le compte d'un étudiant ayant un numéro de CNI donné
     *
     * @param cni numéro de CNI de l'étudiant recherché
     * @return un objet Enseignant
     */
    public Enseignant findByCni(String cni);

    /**
     * retourne le compte d'un enseignant ayant un matricule et un numéro de CNI
     * donnés
     *
     * @param matricule matricule de l'étudiant recherché
     * @param cni numéro de CNI de l'étudiant recherché
     * @param departement département concerné
     * @param regist status d'inscription (1: inscrit, 0: pas inscrit)
     * @return un objet Enseignant
     */
    public Enseignant findByMatriculeAndCniAndDepartementAndIsRegister(String matricule, String cni, Departement departement, int regist);

    /**
     * retourne le compte d'un étudiant ayant un matricule et password donnés
     *
     * @param matricule matricule de l'étudiant recherché
     * @param password mot de passe du compte
     * @param departement département concerné
     * @param regist status d'inscription (1: inscrit, 0: pas inscrit)
     * @return un objet Enseignant
     */
    public Enseignant findByMatriculeAndPasswordAndDepartementAndIsRegister(String matricule, String password, Departement departement, int regist);

    /**
     * retourne le compte des enseignants inscrit d'un département
     *
     * @param isRegister status d'inscription (1: oui, 0: non)
     * @param departement département des enseignants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Enseignant
     */
    public Page<Enseignant> findByIsRegisterAndDepartement(int isRegister, Departement departement, Pageable page);

    /**
     * retourne le compte des enseignants appartement à un département donné
     *
     * @param departement département des enseignants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Enseignant
     */
    public Page<Enseignant> findByDepartement(Departement departement, Pageable page);

}
