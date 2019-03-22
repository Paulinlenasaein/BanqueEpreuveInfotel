package com.infotel.bank.service;

import com.infotel.bank.entities.Fichier;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IFichierService {

    /**
     * stocke le fichier d'une UE dans la base de données
     *
     * @param fichier fichier d'une UE
     * @return le fichier enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public Fichier createOne(Fichier fichier) throws DataAccessException;

    /**
     * recherche le fichier passé en paramètre dans la base de données
     *
     * @param id identifiant de le fichier
     * @return le fichier correspondante
     * @throws DataAccessException si un événement non prévu survient
     */
    public Fichier findOne(Long id) throws DataAccessException;

    /**
     * recherche les Fichiers d'une UE donné
     *
     * @param codeUE code de l'UE dont les Fichiers sont recherchés
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les Fichiers dont l'UE est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Fichier> findAllByUe(String codeUE, int from, int to) throws DataAccessException;

    /**
     * recherche les Fichiers d'une UE donné
     *
     * @param codeUE code de l'UE dont les fichiers sont recherchés
     * @param session date de passage de ces fichiers
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les Fichiers dont l'UE est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Fichier> findAllByUeAndSession(String codeUE, String session, int from, int to) throws DataAccessException;

    /**
     * recherche les Fichiers d'une UE donné
     *
     * @param codeUE code de l'UE dont les fichiers sont recherchés
     * @param session date de passage de ces fichiers
     * @param type type de le fichier CC, TP, TPE, EE ou RTPGE 
     * @return les Fichiers dont l'UE est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Fichier findOneByUeAndSessionAndType(String codeUE, String session, String type) throws DataAccessException;
    
    /**
     * recherche les Fichiers posté par un utilisateur
     *
     * @param id identifiant de l'enseignant
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les Fichiers postés par l'utilisateur fourni
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Fichier> findAllByEnseignant(Long id, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les fichiers d'une UE
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les Fichiers d'une UE
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Fichier> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime le fichier passé en paramètre dans la base de données
     *
     * @param id identifiant de le fichier dans la BDD
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(Long id) throws DataAccessException;

    /**
     * met à jour de le fichier passé en paramètre. L'Fichier doit être déjà
     * présent dans la BDD
     *
     * @param fichier Fichier d'une UE à mettre à jour
     * @return le fichier mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Fichier updateOne(Fichier fichier) throws DataAccessException;
}
