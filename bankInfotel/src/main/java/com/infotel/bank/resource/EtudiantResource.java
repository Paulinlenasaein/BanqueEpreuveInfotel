package com.infotel.bank.resource;

import com.infotel.bank.entities.Etudiant;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEtudiantService;
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
@Path("/etudiant")
@Component
public class EtudiantResource {

    @Autowired
    private IEtudiantService etudiantService;

    @GET
    @Path("{matricule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Etudiant returnOne(@PathParam("matricule") String matricule) throws DataAccessException {
        return etudiantService.findOne(matricule);
    }

    @GET
    @Path("/email/{email}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Etudiant returnOneByEmail(@PathParam("email") String email) throws DataAccessException {
        return etudiantService.findOneByEmail(email);
    }

    @GET
    @Path("/cni/{cni}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Etudiant returnOneByCni(@PathParam("cni") String cni) throws DataAccessException {
        return etudiantService.findOneByCni(cni);
    }

    @GET
    @Path("/auth/{code}/{matricule}/{password}/{regist}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Etudiant returnOneByMatriculeAndPasswordAndDepartementAndIsRegister(@PathParam("matricule") String matricule, @PathParam("password") String password, @PathParam("code") String code, @PathParam("regist") int regist) throws DataAccessException {
        return etudiantService.findOneByMatriculeAndPasswordAndDepartementAndIsRegister(matricule, password, code, regist);
    }

    @GET
    @Path("/auth1/{code}/{matricule}/{cni}/{regist}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Etudiant returnOneByMatriculeAndCniAndDepartementAndIsRegister(@PathParam("matricule") String matricule, @PathParam("cni") String cni, @PathParam("code") String code, @PathParam("regist") int regist) throws DataAccessException {
        return etudiantService.findOneByMatriculeAndCniAndDepartementAndIsRegister(matricule, cni, code, regist);
    }
    
    @GET
    @Path("/inscript/{code}/{regist}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Etudiant> returnAllByIsRegisterAndNiveau(@PathParam("regist") int regist, @PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return etudiantService.findAllByIsRegisterAndNiveau(regist, code, from, to);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Etudiant> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return etudiantService.findAll(from, to);
    }

    @GET
    @Path("/department/{codeNiveau}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Etudiant> returnByNiveau(@PathParam("codeNiveau") String codeNiveau, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return etudiantService.findAllByNiveau(codeNiveau, from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Etudiant createEtudiant(Etudiant etudiant) throws DataAccessException {
        return etudiantService.createOne(etudiant);
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Etudiant modifierEtudiant(Etudiant etudiant) throws DataAccessException {
        return etudiantService.updateOne(etudiant);
    }
}
