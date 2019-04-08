package com.infotel.bank.service;

import com.infotel.bank.entities.Enseignant;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IEnseignantService {

    /**
     * stocke le compte d'un utilisateur passé en paramètre dans la base de
     * données
     *
     * @param enseignant compte de l'enseignant à creer
     * @return le compte crée
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant createOne(Enseignant enseignant) throws DataAccessException;

    /**
     * recherche le compte passé en paramètre dans la base de données
     *
     * @param matricule matricule d'un utilisateur
     * @return le compte correspondante
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant findOne(String matricule) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail
     *
     * @param email email du compte à rechercher
     * @return l'utilisateur dont l'email est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant findOneByEmail(String email) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail
     *
     * @param cni numéro de CNI du compte à rechercher
     * @return l'utilisateur dont le numéro de CNI est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant findOneByCni(String cni) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son matricule et CNI
     *
     * @param matricule matricule de l'utilisateur du compte recherché
     * @param cni numéro de CNI du compte à rechercher
     * @param code code du département
     * @param regist status d'inscription
     * @return l'utilisateur dont la cni et son matricule est passés en
     * paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant findOneByMatriculeAndCniAndDepartementAndIsRegister(String matricule, String cni, String code, int regist) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail et de son mot
     * de passe
     *
     * @param matricule matricule du compte à rechercher
     * @param password mot de passe du compte de l'utilisateur
     * @param code code du département
     * @param regist status d'inscription
     * @return l'utilisateur dont l'email et le mot de passeest passés en
     * paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant findOneByMatriculeAndPasswordAndDepartementAndIsRegister(String matricule, String password, String code, int regist) throws DataAccessException;

    /**
     * recherche tous les compte des enseignants inscrits ou non d'un
     * département
     *
     * @param regist status d'inscription
     * @param code code du département
     * @param from page de depart
     * @param to taille de la page
     * @return l'utilisateur dont l'email et le mot de passeest passés en
     * paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Enseignant> findAllByIsRegisterAndDepartement(int regist, String code, int from, int to) throws DataAccessException;

    /**
     * recherche un compte suivant un département
     *
     * @param code département de l'enseignant recherché
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les enseignant d'un département donné
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Enseignant> findAllByDepartement(String code, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les comptes utilisateurs
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return le compte de tout les utilisateurs
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Enseignant> findAll(int from, int to) throws DataAccessException;

    /**
     * met à jour le compte passé en paramètre. Le compte doit être déjà présent
     * dans la BDD
     *
     * @param enseignant compte enseignant à mettre à jour
     * @return enseignant mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Enseignant updateOne(Enseignant enseignant) throws DataAccessException;
}
