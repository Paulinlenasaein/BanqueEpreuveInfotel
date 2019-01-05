package com.infotel.bank.service;

import com.infotel.bank.entities.UeNiveau;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IUeNiveauService {
    
    /**
     * stocke l'ue d'un niveau d'étude dans la base de données
     *
     * @param ueniveau ue d'un niveau d'étude
     * @return l'ue d'un niveau enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public UeNiveau createOne(UeNiveau ueniveau) throws DataAccessException;

    /**
     * recherche l'ue d'un niveau dans la base de données
     *
     * @param id identifiant
     * @return l'ue d'un niveau d'étude
     * @throws DataAccessException si un événement non prévu survient
     */
    public UeNiveau findOne(Long id) throws DataAccessException;

    /**
     * recherche les ues d'un niveau d'étude donné
     *
     * @param codeNiveau code du niveau d'étude
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les ues d'un niveau passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<UeNiveau> findAllByNiveau(String codeNiveau, int from, int to) throws DataAccessException;
    
    /**
     * recherche les ues d'un niveau d'étude donné
     *
     * @param codeUE code d'une unité d'enseignement
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les niveaux qui font une UE donné
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<UeNiveau> findAllByUe(String codeUE, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les ues des niveaux d'étude
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les ues des niveaux d'étude
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<UeNiveau> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime un objet UeNiveau de la base de données
     *
     * @param id identifiant de l'objet à supprimé
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(Long id) throws DataAccessException;

    /**
     * met à jour objet ueNiveau passé en paramètre. L'objet doit être déjà
     * présent dans la BDD
     *
     * @param ueniveau ueniveau d'étude à mettre à jour
     * @return l'objet ueNiveau mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public UeNiveau updateOne(UeNiveau ueniveau) throws DataAccessException;
}
