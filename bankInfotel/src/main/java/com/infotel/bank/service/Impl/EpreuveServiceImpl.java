package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.ICompteDao;
import com.infotel.bank.dao.IEpreuveDao;
import com.infotel.bank.dao.IUEDao;
import com.infotel.bank.entities.Epreuve;
import com.infotel.bank.entities.TypeEpreuve;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEpreuveService;
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
public class EpreuveServiceImpl implements IEpreuveService {
    
    @Autowired
    private IEpreuveDao epreuveDao;
    @Autowired
    private IUEDao ueDao;
    @Autowired
    private ICompteDao compteDao;

    @Override
    public Epreuve createOne(Epreuve epreuve) throws DataAccessException {
        return epreuveDao.save(epreuve);
    }

    @Override
    public Epreuve findOne(Long id) throws DataAccessException {
        Optional<Epreuve> epreuve = epreuveDao.findById(id);
        Epreuve ep = epreuve.isPresent()? epreuve.get() : null;
        return ep;
    }

    @Override
    public Page<Epreuve> findAllByUe(String codeUE, int from, int to) throws DataAccessException {
        return epreuveDao.findByUe(ueDao.getOne(codeUE), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public Page<Epreuve> findAllByUeAndSession(String codeUE, String session, int from, int to) throws DataAccessException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(session);
        } catch (ParseException ex) {
            Logger.getLogger(EpreuveServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return epreuveDao.findByUeAndSession(ueDao.getOne(codeUE), date, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public Epreuve findOneByUeAndSessionAndType(String codeUE, String session, String type) throws DataAccessException {
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(session);
        } catch (ParseException ex) {
            Logger.getLogger(EpreuveServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return epreuveDao.findByUeAndSessionAndType(ueDao.getOne(codeUE), date, TypeEpreuve.valueOf(type));
    }

    @Override
    public Page<Epreuve> findAllByCompte(String matricule, int from, int to) throws DataAccessException {
        return epreuveDao.findByCompte(compteDao.findByMatricule(matricule), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public Page<Epreuve> findAll(int from, int to) throws DataAccessException {
        return epreuveDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "fileName")));
    }

    @Override
    public void deleteOne(Long id) throws DataAccessException {
        Epreuve ep = epreuveDao.getOne(id);
        if (ep != null) {
            epreuveDao.delete(ep);
        } else {
            throw new WebApplicationException("Épreuve Inexistante", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public Epreuve updateOne(Epreuve epreuve) throws DataAccessException {
        return epreuveDao.save(epreuve);
    }
}
