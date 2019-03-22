package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IEnseignantDao;
import com.infotel.bank.dao.IFichierDao;
import com.infotel.bank.dao.IUEDao;
import com.infotel.bank.entities.Enseignant;
import com.infotel.bank.entities.Fichier;
import com.infotel.bank.entities.TypeFichier;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IFichierService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author paulinlenasaein
 */
@Service
@Transactional
public class FichierServiceImpl implements IFichierService {
    
    @Autowired
    private IFichierDao fichierDao;
    @Autowired
    private IUEDao ueDao;
    @Autowired
    private IEnseignantDao enseignantDao;

    @Override
    public Fichier createOne(Fichier Fichier) throws DataAccessException {
        return fichierDao.save(Fichier);
    }

    @Override
    public Fichier findOne(Long id) throws DataAccessException {
        Optional<Fichier> fichier = fichierDao.findById(id);
        Fichier ep = fichier.isPresent()? fichier.get() : null;
        return ep;
    }

    @Override
    public Page<Fichier> findAllByUe(String codeUE, int from, int to) throws DataAccessException {
        return fichierDao.findByUe(ueDao.getOne(codeUE), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public Page<Fichier> findAllByUeAndSession(String codeUE, String session, int from, int to) throws DataAccessException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(session);
        } catch (ParseException ex) {
            Logger.getLogger(FichierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fichierDao.findByUeAndSession(ueDao.getOne(codeUE), date, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public Fichier findOneByUeAndSessionAndType(String codeUE, String session, String type) throws DataAccessException {
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(session);
        } catch (ParseException ex) {
            Logger.getLogger(FichierServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fichierDao.findByUeAndSessionAndType(ueDao.getOne(codeUE), date, TypeFichier.valueOf(type));
    }

    @Override
    public Page<Fichier> findAllByEnseignant(Long id, int from, int to) throws DataAccessException {
        Optional<Enseignant> opEnseignant = enseignantDao.findById(id);
        Enseignant ens = opEnseignant.isPresent()? opEnseignant.get() : null;
        return fichierDao.findByEnseignant(ens, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public Page<Fichier> findAll(int from, int to) throws DataAccessException {
        return fichierDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public void deleteOne(Long id) throws DataAccessException {
        Fichier ep = fichierDao.getOne(id);
        if (ep != null) {
            fichierDao.delete(ep);
        } else {
            throw new WebApplicationException("Fichier Inexistant", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public Fichier updateOne(Fichier Fichier) throws DataAccessException {
        return fichierDao.save(Fichier);
    }
}
