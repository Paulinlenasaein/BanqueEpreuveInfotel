package com.infotel.bank.service;

import com.infotel.bank.entities.UE;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IUEService {

    /**
     * stocke l'UE dans la base de données
     *
     * @param ue l'unité d'enseignement
     * @return l'UE enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public UE createOne(UE ue) throws DataAccessException;

    /**
     * recherche l'UE passé en paramètre dans la base de données
     *
     * @param codeUE code du l'unité d'enseignement
     * @return l'UE correspondant
     * @throws DataAccessException si un événement non prévu survient
     */
    public UE findOne(String codeUE) throws DataAccessException;

    /**
     * recherche l'UE donné
     *
     * @param intitule intitulé du l'unité d'enseignement
     * @return l'UE dont l'intitulé est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public UE findOneByIntitule(String intitule) throws DataAccessException;

    /**
     * renvoie tous les UEs
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les UEs
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<UE> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime l'UE passé en paramètre de la base de données
     *
     * @param codeUE code de l'unité d'enseignement
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(String codeUE) throws DataAccessException;

    /**
     * met à jour de l'ue passé en paramètre. L'ue doit être déjà présent dans
     * la BDD
     *
     * @param ue l'unité d'enseignement à mettre à jour
     * @return l'UE mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public UE updateOne(UE ue) throws DataAccessException;
}
