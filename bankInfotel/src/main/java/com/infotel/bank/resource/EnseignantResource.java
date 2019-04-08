package com.infotel.bank.resource;

import com.infotel.bank.entities.Enseignant;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEnseignantService;
import javax.ws.rs.Consumes;
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
@Path("/enseignant")
@Component
public class EnseignantResource {

    @Autowired
    private IEnseignantService enseignantService;
    
    @GET
    @Path("{matricule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enseignant returnOne(@PathParam("matricule") String matricule) throws DataAccessException {
        return enseignantService.findOne(matricule);
    }

    @GET
    @Path("/email/{email}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enseignant returnOneByEmail(@PathParam("email") String email) throws DataAccessException {
        return enseignantService.findOneByEmail(email);
    }

    @GET
    @Path("/cni/{cni}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enseignant returnOneByCni(@PathParam("cni") String cni) throws DataAccessException {
        return enseignantService.findOneByCni(cni);
    }

    @GET
    @Path("/auth/{code}/{matricule}/{password}/{regist}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enseignant returnOneByMatriculeAndPasswordAndDepartementAndIsRegister(@PathParam("matricule") String matricule, @PathParam("password") String password, @PathParam("code") String code, @PathParam("regist") int regist) throws DataAccessException {
        return enseignantService.findOneByMatriculeAndPasswordAndDepartementAndIsRegister(matricule, password, code, regist);
    }

    @GET
    @Path("/auth1/{code}/{matricule}/{cni}/{regist}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Enseignant returnOneByMatriculeAndCniAndDepartementAndIsRegister(@PathParam("matricule") String matricule, @PathParam("cni") String cni, @PathParam("code") String code, @PathParam("regist") int regist) throws DataAccessException {
        return enseignantService.findOneByMatriculeAndCniAndDepartementAndIsRegister(matricule, cni, code, regist);
    }
    
    @GET
    @Path("/inscript/{code}/{regist}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Enseignant> returnAllByIsRegisterAndDepartement(@PathParam("regist") int regist, @PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return enseignantService.findAllByIsRegisterAndDepartement(regist, code, from, to);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Enseignant> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return enseignantService.findAll(from, to);
    }
    
    @GET
    @Path("/department/{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Enseignant> returnByDepartement(@PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return enseignantService.findAllByDepartement(code, from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Enseignant createEnseignant(Enseignant enseignant) throws DataAccessException {
        return enseignantService.createOne(enseignant);
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Enseignant modifierEnseignant(Enseignant enseignant) throws DataAccessException {
        return enseignantService.updateOne(enseignant);
    }
}
