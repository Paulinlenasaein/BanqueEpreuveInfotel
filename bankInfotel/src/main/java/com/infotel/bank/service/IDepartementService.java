package com.infotel.bank.service;

import com.infotel.bank.entities.Departement;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IDepartementService {

    /**
     * stocke un département dans la base de données
     *
     * @param departement departement à stocker
     * @return le departement enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public Departement createOne(Departement departement) throws DataAccessException;

    /**
     * recherche le departement passé en paramètre dans la base de données
     *
     * @param code code du département
     * @return le departement correspondant
     * @throws DataAccessException si un événement non prévu survient
     */
    public Departement findOne(String code) throws DataAccessException;

    /**
     * renvoie tous les departements
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les departements d'un département
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Departement> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime le département passé en paramètre de la base de données
     *
     * @param code code du département dans la BDD
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(String code) throws DataAccessException;

    /**
     * met à jour de le département passé en paramètre. Le departement doit être
     * déjà présent dans la BDD
     *
     * @param departement departement à mettre à jour
     * @return le département mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Departement updateOne(Departement departement) throws DataAccessException;
}
