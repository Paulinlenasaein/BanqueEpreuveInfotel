package com.infotel.bank.service;

import com.infotel.bank.entities.Epreuve;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IEpreuveService {

    /**
     * stocke l'épreuve d'une UE dans la base de données
     *
     * @param epreuve epreuve d'une UE
     * @return l'épreuve enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public Epreuve createOne(Epreuve epreuve) throws DataAccessException;

    /**
     * recherche l'épreuve passé en paramètre dans la base de données
     *
     * @param id identifiant de l'épreuve
     * @return l'épreuve correspondante
     * @throws DataAccessException si un événement non prévu survient
     */
    public Epreuve findOne(Long id) throws DataAccessException;

    /**
     * recherche les epreuves d'une UE donné
     *
     * @param codeUE code de l'UE dont les epreuves sont recherchés
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les epreuves dont l'UE est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Epreuve> findAllByUe(String codeUE, int from, int to) throws DataAccessException;

    /**
     * recherche les epreuves d'une UE donné
     *
     * @param codeUE code de l'UE dont les epreuves sont recherchés
     * @param session date de passage de ces épreuves
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les epreuves dont l'UE est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Epreuve> findAllByUeAndSession(String codeUE, String session, int from, int to) throws DataAccessException;

    /**
     * recherche les epreuves d'une UE donné
     *
     * @param codeUE code de l'UE dont les epreuves sont recherchés
     * @param session date de passage de ces épreuves
     * @param type type de l'épreuve CC, TP, TPE, EE ou RTPGE 
     * @return les epreuves dont l'UE est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Epreuve findOneByUeAndSessionAndType(String codeUE, String session, String type) throws DataAccessException;
    
    /**
     * recherche les epreuves posté par un utilisateur
     *
     * @param id identifiant de l'utilisateur
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les epreuves postés par l'utilisateur fourni
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Epreuve> findAllByCompte(Long id, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les epreuves d'une UE
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les epreuves d'une UE
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Epreuve> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime l'épreuve passé en paramètre dans la base de données
     *
     * @param code code de l'épreuve dans la BDD
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(String code) throws DataAccessException;

    /**
     * met à jour de l'épreuve passé en paramètre. L'epreuve doit être déjà
     * présent dans la BDD
     *
     * @param epreuve epreuve d'une UE à mettre à jour
     * @return l'épreuve mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Epreuve updateOne(Epreuve epreuve) throws DataAccessException;
}
