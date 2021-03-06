package com.infotel.bank.service.Impl;

import com.infotel.bank.dao.ICompteDao;
import com.infotel.bank.entities.Compte;
import com.infotel.bank.entities.RoleName;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.ICompteService;
import com.infotel.bank.service.SendEmailService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
    public Compte findOneByMatriculeAndPassword(String matricule, String password) throws DataAccessException {
        return compteDao.findByMatriculeAndPassword(matricule, password);
    }

    @Override 
    public Page<Compte> findAllByRole(String role, int from, int to) throws DataAccessException {
        return compteDao.findByRole(RoleName.valueOf(role), PageRequest.of(from, to, Sort.by(Sort.Direction.ASC, "matricule")));
    }
    
     @Override
    public String sendEmail(String toEmail, String lastname) throws DataAccessException {
        try {
            return SendEmailService.generateAndSendEmail(toEmail, lastname);
        } catch (MessagingException ex) {
            Logger.getLogger(CompteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Echec de l'énvoi de l'email, veuillez vérifier que votre adresse email est correcte ou que vous êtes bien connecté...";
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

    @Override
    public Compte findOneByCni(String cni) throws DataAccessException {
        return compteDao.findByCni(cni);
    }

    @Override
    public Compte findOneByMatriculeAndCni(String cni, String matricule) throws DataAccessException {
        return compteDao.findByMatriculeAndCni(matricule, cni);
    }
}
