package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.IEtudiantDao;
import com.infotel.bank.dao.IFichierDao;
import com.infotel.bank.dao.IRecevoirDao;
import com.infotel.bank.entities.Recevoir;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IRecevoirService;
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
public class RecevoirServiceImpl implements IRecevoirService {

    @Autowired
    private IRecevoirDao recDao;
    
    @Autowired
    private IEtudiantDao etudDao;
    
    @Autowired
    private IFichierDao fichDao;
    
    @Override
    public Recevoir createOne(Recevoir receive) throws DataAccessException {
        return recDao.save(receive);
    }

    @Override
    public Page<Recevoir> findAllByEtudiant(Long idUser, int from, int to) throws DataAccessException {
        return recDao.findByEtudiant(etudDao.getOne(idUser), PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id_rec")));
    }

    @Override
    public Page<Recevoir> findAllByFichier(Long id_fich, int from, int to) throws DataAccessException {
        return recDao.findByFichier(fichDao.getOne(id_fich), PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id_rec")));
    }

    @Override
    public Recevoir findAllByEtudiantAndFichier(Long idUser, Long id_fich) throws DataAccessException {
        return recDao.findByEtudiantAndFichier(etudDao.getOne(idUser), fichDao.getOne(id_fich));
    }

    @Override
    public Page<Recevoir> findAllByEtudiantAndStatus(Long idUser, int status, int from, int to) throws DataAccessException {
        return recDao.findByEtudiantAndStatus(etudDao.getOne(idUser), status, PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "id_rec")));
    }

    @Override
    public Page<Recevoir> findAll(int from, int to) throws DataAccessException {
        return recDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id_rec")));
    }

    @Override
    public Recevoir updateOne(Recevoir receive) throws DataAccessException {
        return recDao.save(receive);
    }

    @Override
    public void deleteOne(Long id_rec) throws DataAccessException {
        Recevoir rec = recDao.getOne(id_rec);
        if (rec != null) {
            recDao.delete(rec);
        } else {
            throw new WebApplicationException("Objet innexistant", Response.Status.NO_CONTENT);
        }
    }
    
}
