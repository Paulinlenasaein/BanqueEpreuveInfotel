package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IDepartementDao;
import com.infotel.bank.entities.Departement;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IDepartementService;
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
public class DepartementServiceImpl implements IDepartementService {
    
    @Autowired
    private IDepartementDao departementDao;

    @Override
    public Departement createOne(Departement departement) throws DataAccessException {
        return departementDao.save(departement);
    }

    @Override
    public Departement findOne(String code) throws DataAccessException {
        return departementDao.getOne(code);            
    }

    @Override
    public Page<Departement> findAll(int from, int to) throws DataAccessException {
        return departementDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "code")));
    }

    @Override
    public void deleteOne(String code) throws DataAccessException {
        Departement dep = departementDao.getOne(code);
        if (dep != null) {
            departementDao.delete(dep);
        } else {
            throw new WebApplicationException("Département innexistant", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public Departement updateOne(Departement departement) throws DataAccessException {
        return departementDao.save(departement);
    }
}
