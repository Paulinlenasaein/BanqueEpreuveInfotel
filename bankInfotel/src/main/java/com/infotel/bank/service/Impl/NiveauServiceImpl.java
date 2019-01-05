package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.INiveauDao;
import com.infotel.bank.entities.Niveau;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.INiveauService;
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
public class NiveauServiceImpl implements INiveauService {
    
    @Autowired
    private INiveauDao niveauDao;

    @Override
    public Niveau createOne(Niveau niveau) throws DataAccessException {
        return niveauDao.save(niveau);
    }

    @Override
    public Niveau findOne(String codeNiveau) throws DataAccessException {
        return niveauDao.getOne(codeNiveau);
    }

    @Override
    public Niveau findOneByIntitul(String intitul) throws DataAccessException {
        return niveauDao.findByIntitul(intitul);
    }

    @Override
    public Page<Niveau> findAll(int from, int to) throws DataAccessException {
        return niveauDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "codeNiveau")));
    }

    @Override
    public void deleteOne(String codeNiveau) throws DataAccessException {
        Niveau niveau = niveauDao.getOne(codeNiveau);
        if (niveau != null) {
            niveauDao.delete(niveau);
        } else {
            throw new WebApplicationException("Niveau innexistant", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public Niveau updateOne(Niveau niveau) throws DataAccessException {
        return niveauDao.save(niveau);
    }
}
