package com.infotel.bank.service;

import com.infotel.bank.entities.Compte;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface ICompteService {

    /**
     * stocke le compte d'un utilisateur passé en paramètre dans la base de
     * données
     *
     * @param compte compte de l'utilisateur
     * @return le compte enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte createOne(Compte compte) throws DataAccessException;

    /**
     * recherche le compte passé en paramètre dans la base de données
     *
     * @param matricule matricule d'un utilisateur
     * @return le compte correspondante
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte findOne(String matricule) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail
     *
     * @param email email du compte à rechercher
     * @return l'utilisateur dont l'email est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte findOneByEmail(String email) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail
     *
     * @param cni numéro de CNI du compte à rechercher
     * @return l'utilisateur dont le numéro de CNI est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte findOneByCni(String cni) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son matricule et CNI
     *
     * @param matricule matricule de l'utilisateur du compte recherché
     * @param cni numéro de CNI du compte à rechercher
     * @return l'utilisateur dont la cni et son matricule est passés en
     * paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte findOneByMatriculeAndCni(String matricule, String cni) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son matricule et de son mot de
     * passe
     *
     * @param matricule matricule du compte à rechercher
     * @param password mot de passe du compte de l'utilisateur
     * @return l'utilisateur dont l'email et le mot de passeest passés en
     * paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte findOneByMatriculeAndPassword(String matricule, String password) throws DataAccessException;

    /**
     * recherche un compte ayant un privilège donné
     *
     * @param role privilège ou rôle du compte de l'étudiant
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return l'utilisateur dont le rôle est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Compte> findAllByRole(String role, int from, int to) throws DataAccessException;

    /**
     * Envoi un mail d'authentification à un utilisateur
     *
     * @param toEmail adresse mail du client
     * @param lastname lastname du futur utilisateur
     * @return le code d'authentification généré
     * @throws DataAccessException si un événement non prévu survient
     */
    public String sendEmail(String toEmail, String lastname) throws DataAccessException;

    /**
     * renvoie tous les comptes utilisateurs
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return le compte de tout les utilisateurs
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Compte> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime le compte passé en paramètre dans la base de données
     *
     * @param matricule matricule du compte dans la BDD
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(String matricule) throws DataAccessException;

    /**
     * met à jour le compte passé en paramètre. Le compte doit être déjà présent
     * dans la BDD
     *
     * @param compte compte de l'utilisateur à mettre à jour
     * @return compte mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Compte updateOne(Compte compte) throws DataAccessException;

}
