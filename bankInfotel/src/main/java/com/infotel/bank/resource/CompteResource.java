package com.infotel.bank.resource;

import com.infotel.bank.entities.Compte;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.ICompteService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulinlenasaein
 */
@Path("/compte")
@Component
public class CompteResource {
    
    @Autowired
    private ICompteService compteService;
    
    @GET
    @Path("{matricule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Compte returnOne(@PathParam("matricule") String matricule) throws DataAccessException {
        return compteService.findOne(matricule);
    }

    @GET
    @Path("/email/{email}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Compte returnOneByEmail(@PathParam("email") String email) throws DataAccessException {
        return compteService.findOneByEmail(email);
    }
    
    @GET
    @Path("/cni/{cni}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Compte returnOneByCni(@PathParam("cni") String cni) throws DataAccessException {
        return compteService.findOneByCni(cni);
    }
    
    @GET
    @Path("/auth/{email}/{password}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Compte returnOneByEmailAndPassword(@PathParam("email") String email, @PathParam("password") String password) throws DataAccessException {
        return compteService.findOneByEmailAndPassword(email, password);
    }
    
    @GET
    @Path("/auth1/{cni}/{matricule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Compte returnOneByCniAndMatricule(@PathParam("cni") String cni, @PathParam("matricule") String matricule) throws DataAccessException {
        return compteService.findOneByCniAndMatricule(cni, matricule);
    }
    
    @GET
    @Path("/role/{role}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Compte> returnAllByRole(@PathParam("role") String role, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return compteService.findAllByRole(role.toUpperCase().trim(), from, to);
    }
    
    @GET
    @Path("/sendmail/{email}/{lastname}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public String sendAuthMailToUser(@PathParam("email") String email, @PathParam("lastname") String lastname) throws DataAccessException {
        return compteService.sendEmail(email, lastname);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Compte> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return compteService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Compte createCompte(Compte compte) throws DataAccessException {
        return compteService.createOne(compte);
    }

    @PUT
    @Path("{matricule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Compte modifierCompte(@PathParam("matricule") String matricule, Compte compte) throws DataAccessException {
        return compteService.updateOne(compte);
    }

    @DELETE
    @Path("{matricule}")
    public void deleteOne(@PathParam("matricule") String matricule) throws DataAccessException {
        compteService.deleteOne(matricule);
    }
}
