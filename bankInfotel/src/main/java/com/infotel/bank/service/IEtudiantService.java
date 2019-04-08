package com.infotel.bank.service;

import com.infotel.bank.entities.Etudiant;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IEtudiantService {

    /**
     * stocke le compte d'un utilisateur passé en paramètre dans la base de
     * données
     *
     * @param etudiant compte de l'étudiant à creer
     * @return le compte crée
     * @throws DataAccessException si un événement non prévu survient
     */
    public Etudiant createOne(Etudiant etudiant) throws DataAccessException;

    /**
     * recherche le compte passé en paramètre dans la base de données
     *
     * @param matricule matricule d'un utilisateur
     * @return le compte correspondante
     * @throws DataAccessException si un événement non prévu survient
     */
    public Etudiant findOne(String matricule) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail
     *
     * @param email email du compte à rechercher
     * @return l'utilisateur dont l'email est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Etudiant findOneByEmail(String email) throws DataAccessException;

    /**
     * recherche un compte suivant la valeur de son adresse mail
     *
     * @param cni numéro de CNI du compte à rechercher
     * @return l'utilisateur dont le numéro de CNI est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Etudiant findOneByCni(String cni) throws DataAccessException;

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
    public Etudiant findOneByMatriculeAndCniAndDepartementAndIsRegister(String matricule, String cni, String code, int regist) throws DataAccessException;

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
    public Etudiant findOneByMatriculeAndPasswordAndDepartementAndIsRegister(String matricule, String password, String code, int regist) throws DataAccessException;
    
     /**
     * recherche tous les compte des étudiants inscrits ou non d'un département
     *
     * @param regist status d'inscription
     * @param code code du niveau
     * @param from page initiale
     * @param to taille de la page
     * @return l'utilisateur dont l'email et le mot de passeest passés en
     * paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Etudiant> findAllByIsRegisterAndNiveau(int regist, String code, int from, int to) throws DataAccessException;

    /**
     * recherche un compte étudiant suivant la valeur de son adresse mail
     *
     * @param codeNiveau niveau de l'étudiant recherché
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les etudiant d'un département donné
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Etudiant> findAllByNiveau(String codeNiveau, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les comptes étudiants
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return le compte de tout les utilisateurs
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Etudiant> findAll(int from, int to) throws DataAccessException;

    /**
     * met à jour le compte passé en paramètre. Le compte doit être déjà présent
     * dans la BDD
     *
     * @param etudiant compte étudiant à mettre à jour
     * @return etudiant mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Etudiant updateOne(Etudiant etudiant) throws DataAccessException;
}
