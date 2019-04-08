package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IDepartementDao;
import com.infotel.bank.dao.IEtudiantDao;
import com.infotel.bank.dao.INiveauDao;
import com.infotel.bank.entities.Etudiant;
import com.infotel.bank.entities.Niveau;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEtudiantService;
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
public class EtudiantServiceImpl implements IEtudiantService {
    
    @Autowired
    private IEtudiantDao etudDao;
    
    @Autowired
    private INiveauDao nivDao;
    
    @Autowired
    private IDepartementDao depDao;

    @Override
    public Etudiant createOne(Etudiant etudiant) throws DataAccessException {
        return etudDao.save(etudiant);
    }

    @Override
    public Etudiant findOne(String matricule) throws DataAccessException {
       return etudDao.findByMatricule(matricule);
    }
    
    @Override
    public Etudiant findOneByCni(String cni) throws DataAccessException {
        return etudDao.findByCni(cni);
    }

    @Override
    public Etudiant findOneByEmail(String email) throws DataAccessException {
        return etudDao.findByEmail(email);
    }
    
    @Override
    public Etudiant findOneByMatriculeAndCniAndDepartementAndIsRegister(String matricule, String cni, String code, int regist) throws DataAccessException {
        return etudDao.findByMatriculeAndCniAndDepartementAndIsRegister(matricule, cni, depDao.getOne(code), regist);
    }

    @Override
    public Etudiant findOneByMatriculeAndPasswordAndDepartementAndIsRegister(String matricule, String password, String code, int regist) throws DataAccessException {
        return etudDao.findByMatriculeAndPasswordAndDepartementAndIsRegister(matricule, password, depDao.getOne(code), regist);
    }
    
    @Override
    public Page<Etudiant> findAllByIsRegisterAndNiveau(int regist, String code, int from, int to) throws DataAccessException {
        return etudDao.findByIsRegisterAndNiveau(regist, nivDao.getOne(code), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "idUser")));
    }

    @Override
    public Page<Etudiant> findAllByNiveau(String codeNiveau, int from, int to) throws DataAccessException {
        Niveau niveau = nivDao.getOne(codeNiveau);
        return etudDao.findByNiveau(niveau, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "idUser")));
    }

    @Override
    public Page<Etudiant> findAll(int from, int to) throws DataAccessException {
        return etudDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "idUser")));
    }

    @Override
    public Etudiant updateOne(Etudiant etudiant) throws DataAccessException {
        return etudDao.save(etudiant);
    }
    
}
