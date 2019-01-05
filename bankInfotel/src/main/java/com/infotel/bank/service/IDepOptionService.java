package com.infotel.bank.service;

import com.infotel.bank.entities.DepOption;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IDepOptionService {

    /**
     * stocke l'option d'un département dans la base de données
     *
     * @param option option d'un département
     * @return le option enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public DepOption createOne(DepOption option) throws DataAccessException;

    /**
     * recherche le option passé en paramètre dans la base de données
     *
     * @param code code du département
     * @return le option correspondante
     * @throws DataAccessException si un événement non prévu survient
     */
    public DepOption findOne(String code) throws DataAccessException;

    /**
     * recherche les options d'un département donné
     *
     * @param departement département dont les options sont recherchés
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les options dont le département est passé en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<DepOption> findOneByDepartement(String departement, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les options d'un département
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les options d'un département
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<DepOption> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime l'option passé en paramètre dans la base de données
     *
     * @param code code de l'option dans la BDD
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(String code) throws DataAccessException;

    /**
     * met à jour de l'option passé en paramètre. Le option doit être déjà présent
     * dans la BDD
     *
     * @param option option d'un département à mettre à jour
     * @return l'option mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public DepOption updateOne(DepOption option) throws DataAccessException;
}
