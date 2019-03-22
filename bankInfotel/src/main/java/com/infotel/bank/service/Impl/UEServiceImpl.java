package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IUEDao;
import com.infotel.bank.entities.UE;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IUEService;
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
public class UEServiceImpl implements IUEService {
    
    @Autowired
    private IUEDao ueDao;

    @Override
    public UE createOne(UE ue) throws DataAccessException {
        return ueDao.save(ue);
    }

    @Override
    public UE findOne(String codeUE) throws DataAccessException {
        return ueDao.getOne(codeUE);
    }

    @Override
    public UE findOneByIntitule(String intitule) throws DataAccessException {
        return ueDao.findByIntitule(intitule);
    }

    @Override
    public Page<UE> findAll(int from, int to) throws DataAccessException {
        return ueDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "codeUE")));
    }

    @Override
    public void deleteOne(String codeUE) throws DataAccessException {
        UE ue = ueDao.getOne(codeUE);
        if (ue != null) {
            ueDao.delete(ue);
        } else {
            throw new WebApplicationException("UE innexistante", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public UE updateOne(UE ue) throws DataAccessException {
        return ueDao.save(ue);
    }

    @Override
    public Page<UE> findAllBySemestre(int semestre, int from, int to) throws DataAccessException {
        return ueDao.findBySemestre(semestre, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "codeUE")));
    }
    
    
}
