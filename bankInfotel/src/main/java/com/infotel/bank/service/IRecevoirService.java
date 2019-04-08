package com.infotel.bank.service;

import com.infotel.bank.entities.Recevoir;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulinlenasaein
 */
public interface IRecevoirService {

    /**
     * stocke un fichier envoyé à un étudiant dans la base de données
     *
     * @param receive fichier envoyé à un étudiant
     * @return le compte crée
     * @throws DataAccessException si un événement non prévu survient
     */
    public Recevoir createOne(Recevoir receive) throws DataAccessException;

    /**
     * recherche les fichiers reçus par un étudiant donné
     *
     * @param idUser compte étudiant concerné
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les objets Recevoir
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Recevoir> findAllByEtudiant(Long idUser, int from, int to) throws DataAccessException;

    /**
     * recherche les étudiants ayant reçus un fichier donné
     *
     * @param id_fich fichier envoyé à un étudiant donné
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les objets Recevoir
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Recevoir> findAllByFichier(Long id_fich, int from, int to) throws DataAccessException;

    /**
     * vérifie le status d'un post fait à un étudiant
     *
     * @param idUser etudiant concerné
     * @param id_fich fichier envoyé
     * @return les objets Recevoir
     * @throws DataAccessException si un événement non prévu survient
     */
    public Recevoir findAllByEtudiantAndFichier(Long idUser, Long id_fich) throws DataAccessException;

    /**
     * vérifie les post faits à un étudiant et aant un status donné
     *
     * @param idUser etudiant concerné
     * @param status status du post (vu ou non)
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return les objets Recevoir
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Recevoir> findAllByEtudiantAndStatus(Long idUser, int status, int from, int to) throws DataAccessException;

    /**
     * renvoie tous les postes déjà fait
     *
     * @param from numéro de la page initiale
     * @param to taille de la page
     * @return un objet Recevoir
     * @throws DataAccessException si un événement non prévu survient
     */
    public Page<Recevoir> findAll(int from, int to) throws DataAccessException;

    /**
     * met à jour le fichier envoyé à un étudiant passé en paramètre. Le compte
     * doit être déjà présent dans la BDD
     *
     * @param receive objet Recevoir à mettre à jour
     * @return l'objet Recevoir mis à jour
     * @throws DataAccessException si un événement non prévu survient
     */
    public Recevoir updateOne(Recevoir receive) throws DataAccessException;
    
     /**
     * supprime le post passé en paramètre de la base de données
     *
     * @param id_rec identifiant du post
     * @throws DataAccessException si un événement non prévu survient
     */
    public void deleteOne(Long id_rec) throws DataAccessException;
}
