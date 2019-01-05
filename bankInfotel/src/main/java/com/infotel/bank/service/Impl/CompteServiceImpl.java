package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.ICompteDao;
import com.infotel.bank.entities.Compte;
import com.infotel.bank.entities.RoleName;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.ICompteService;
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
public class CompteServiceImpl implements ICompteService {
    
    @Autowired
    private ICompteDao compteDao;

    @Override
    public Compte createOne(Compte compte) throws DataAccessException {
        return compteDao.save(compte);
    }

    @Override
    public Compte findOne(String matricule) throws DataAccessException {
       return compteDao.findByMatricule(matricule);
    }

    @Override
    public Compte findOneByEmail(String email) throws DataAccessException {
        return compteDao.findByEmail(email);
    }

    @Override
    public Compte findOneByEmailAndPassword(String email, String password) throws DataAccessException {
        return compteDao.findByEmailAndPassword(email, password);
    }

    @Override
    public Page<Compte> findAllByRole(String role, int from, int to) throws DataAccessException {
        return compteDao.findByRole(RoleName.valueOf(role).name(), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "matricule")));
    }

    @Override
    public Page<Compte> findAll(int from, int to) throws DataAccessException {
        return compteDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "matricule")));
    }

    @Override
    public void deleteOne(String matricule) throws DataAccessException {
        Compte compte = compteDao.findByMatricule(matricule);
        if (compte != null) {
            compteDao.delete(compte);
        } else {
            throw new WebApplicationException("Compte innexistant", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public Compte updateOne(Compte compte) throws DataAccessException {
        return compteDao.save(compte);
    }
}
