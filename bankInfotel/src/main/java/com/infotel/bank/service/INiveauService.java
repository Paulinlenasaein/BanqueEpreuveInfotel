package com.infotel.bank.service;

import com.infotel.bank.entities.Niveau;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface INiveauService {
    
    /**
     * stocke le niveau d'étude dans la base de données
     *
     * @param niveau niveau d'étude
     * @return le niveau enregistré dans l'entrepot
     * @throws DataAccessException si un événement non prévu survient
     */
    public Niveau createOne(Niveau niveau) throws DataAccessException;

    /**
     * recherche le niveau passé en paramètre dans la base de données
     *
     * @param codeNiveau code du niveau d'étude
     * @return le niveau d'étude correspondant
     * @throws DataAccessException si un événement non prévu survient
     */
    public Niveau findOne(String codeNiveau) throws DataAccessException;

    /**
     * recherche le niveau d'étude donné
     *
     * @param intitul intitulé du niveau d'étude
     * @return le niveau dont l'intitulé est passée en paramètre
     * @throws DataAccessException si un événement non prévu survient
     */
    public Niveau findOneByIntitul(String intitul) throws DataAccessException;

    /**
     * renvoie tous les niveaux d'étude
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les niveaux d'étude
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Niveau> findAll(int from, int to) throws DataAccessException;

    /**
     * supprime le niveau passé en paramètre de la base de données
     *
     * @param codeNiveau code du niveau d'étude
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(String codeNiveau) throws DataAccessException;

    /**
     * met à jour du niveau passé en paramètre. Le niveau doit être déjà
     * présent dans la BDD
     *
     * @param niveau niveau d'étude à mettre à jour
     * @return le niveau mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Niveau updateOne(Niveau niveau) throws DataAccessException;
}
