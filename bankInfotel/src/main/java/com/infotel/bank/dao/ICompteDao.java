package com.infotel.bank.dao;

import com.infotel.bank.entities.Compte;
import com.infotel.bank.entities.Niveau;
import com.infotel.bank.entities.RoleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author paulinlenasaein
 */
@Repository
public interface ICompteDao extends JpaRepository<Compte, Long> {

    /**
     * retourne le compte d'un étudiant ayant un matricule donné
     *
     * @param matricule matricule de l'étudiant recherché
     * @return un objet Compte
     */
    public Compte findByMatricule(String matricule);

    /**
     * retourne le compte d'un étudiant ayant un email donné
     *
     * @param email emaile de l'étudiant recherché
     * @return un objet Compte
     */
    public Compte findByEmail(String email);

    /**
     * retourne le compte d'un étudiant ayant un numéro de CNI donné
     *
     * @param cni numéro de CNI de l'étudiant recherché
     * @return un objet Compte
     */
    public Compte findByCni(String cni);

    /**
     * retourne le compte d'un étudiant ayant un numéro de CNI et matricule
     * donnés
     *
     * @param cni numéro de CNI de l'étudiant recherché
     * @param matricule matricule de l'étudiant recherché
     * @return un objet Compte
     */
    public Compte findByCniAndMatricule(String cni, String matricule);

    /**
     * retourne le compte d'un étudiant ayant un email donné
     *
     * @param email email de l'étudiant recherché
     * @param password mot de passe du compte
     * @return un objet Compte
     */
    public Compte findByEmailAndPassword(String email, String password);

    /**
     * retourne les compte des étudiants ayant un role donné
     *
     * @param role role des étudiants recherchés
     * @param page pagination du résultat
     * @return une page d'objets Compte
     */
    public Page<Compte> findByRole(RoleName role, Pageable page);
}
