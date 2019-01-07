package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IDepOptionDao;
import com.infotel.bank.dao.IDepartementDao;
import com.infotel.bank.entities.DepOption;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IDepOptionService;
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
public class DepOptionServiceImpl implements IDepOptionService {
    
    @Autowired
    private IDepOptionDao optionDao;
    @Autowired
    private IDepartementDao departementDao;

    @Override
    public DepOption createOne(DepOption option) throws DataAccessException {
        return optionDao.save(option);
    }

    @Override
    public DepOption findOne(String codeOption) throws DataAccessException {
       return optionDao.getOne(codeOption);
    }
    
     @Override
    public Page<DepOption> findAllByDepartement(String departement, int from, int to) throws DataAccessException {
        return optionDao.findByDepartement(departementDao.getOne(departement), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "codeOption")));
    }

    @Override
    public Page<DepOption> findAll(int from, int to) throws DataAccessException {
        return optionDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "codeOption")));
    }

    @Override
    public void deleteOne(String matricule) throws DataAccessException {
        DepOption option = optionDao.getOne(matricule);
        if (option != null) {
            optionDao.delete(option);
        } else {
            throw new WebApplicationException("Option innexistante", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public DepOption updateOne(DepOption option) throws DataAccessException {
        return optionDao.save(option);
    }

}
