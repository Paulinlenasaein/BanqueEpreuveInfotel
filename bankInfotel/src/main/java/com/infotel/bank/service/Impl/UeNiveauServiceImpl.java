package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.INiveauDao;
import com.infotel.bank.dao.IUEDao;
import com.infotel.bank.dao.IUeNiveauDao;
import com.infotel.bank.entities.UeNiveau;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IUeNiveauService;
import java.util.Optional;
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
public class UeNiveauServiceImpl implements IUeNiveauService {
    
    @Autowired
    private IUeNiveauDao ueNivDao;
    @Autowired
    private IUEDao ueDao;
    @Autowired
    private INiveauDao niveauDao;

    @Override
    public UeNiveau createOne(UeNiveau ueniveau) throws DataAccessException {
        return ueNivDao.save(ueniveau);
    }

    @Override
    public UeNiveau findOne(Long id) throws DataAccessException {
        Optional<UeNiveau> ueniv = ueNivDao.findById(id);
        UeNiveau ueniveau = ueniv.isPresent()? ueniv.get() : null;
        return ueniveau;
    }

    @Override
    public Page<UeNiveau> findAllByNiveau(String codeNiveau, int from, int to) throws DataAccessException {
        return ueNivDao.findByNiveau(niveauDao.getOne(codeNiveau), PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id")));
    }

    @Override
    public Page<UeNiveau> findAllByUe(String codeUE, int from, int to) throws DataAccessException {
        return ueNivDao.findByUe(ueDao.getOne(codeUE), PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id")));
    }

    @Override
    public Page<UeNiveau> findAll(int from, int to) throws DataAccessException {
        return ueNivDao.findAll(PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id")));
    }

    @Override
    public void deleteOne(Long id) throws DataAccessException {
        UeNiveau ueniv = ueNivDao.getOne(id);
        if (ueniv != null) {
            ueNivDao.delete(ueniv);
        } else {
            throw new WebApplicationException("Objet innexistant", Response.Status.NO_CONTENT);
        }
    }

    @Override
    public UeNiveau updateOne(UeNiveau ueniveau) throws DataAccessException {
        return ueNivDao.save(ueniveau);
    }
}
