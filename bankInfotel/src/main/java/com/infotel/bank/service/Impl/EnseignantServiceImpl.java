package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IDepartementDao;
import com.infotel.bank.dao.IEnseignantDao;
import com.infotel.bank.entities.Departement;
import com.infotel.bank.entities.Enseignant;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEnseignantService;
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
public class EnseignantServiceImpl implements IEnseignantService {

    @Autowired
    private IEnseignantDao ensDao;
    
    @Autowired
    private IDepartementDao depDao;

    @Override
    public Enseignant createOne(Enseignant enseignant) throws DataAccessException {
        return ensDao.save(enseignant);
    }
    
    @Override
    public Enseignant findOne(String matricule) throws DataAccessException {
       return ensDao.findByMatricule(matricule);
    }
    
    @Override
    public Enseignant findOneByCni(String cni) throws DataAccessException {
        return ensDao.findByCni(cni);
    }

    @Override
    public Enseignant findOneByEmail(String email) throws DataAccessException {
        return ensDao.findByEmail(email);
    }
    
    @Override
    public Enseignant findOneByMatriculeAndCniAndDepartementAndIsRegister(String matricule, String cni, String code, int regist) throws DataAccessException {
        return ensDao.findByMatriculeAndCniAndDepartementAndIsRegister(matricule, cni, depDao.getOne(code), regist);
    }

    @Override
    public Enseignant findOneByMatriculeAndPasswordAndDepartementAndIsRegister(String matricule, String password, String code, int regist) throws DataAccessException {
        return ensDao.findByMatriculeAndPasswordAndDepartementAndIsRegister(matricule, password, depDao.getOne(code), regist);
    }
    
    @Override
    public Page<Enseignant> findAllByIsRegisterAndDepartement(int regist, String code, int from, int to) throws DataAccessException {
        return ensDao.findByIsRegisterAndDepartement(regist, depDao.getOne(code), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "idUser")));
    }

    @Override
    public Page<Enseignant> findAllByDepartement(String code, int from, int to) throws DataAccessException {
        Departement departement = depDao.getOne(code);
        return ensDao.findByDepartement(departement, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "idUser")));
    }

    @Override
    public Page<Enseignant> findAll(int from, int to) throws DataAccessException {
        return ensDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "idUser")));
    }

    @Override
    public Enseignant updateOne(Enseignant enseignant) throws DataAccessException {
        return ensDao.save(enseignant);
    }

}
