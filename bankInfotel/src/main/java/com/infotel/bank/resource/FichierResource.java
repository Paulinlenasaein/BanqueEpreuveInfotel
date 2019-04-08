package com.infotel.bank.resource;

import com.infotel.bank.entities.Fichier;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IFichierService;
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
@Path("/fichier")
@Component
public class FichierResource {

    @Autowired
    private IFichierService FichierService;

    @GET
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Fichier returnOne(@PathParam("id") Long id) throws DataAccessException {
        return FichierService.findOne(id);
    }

    @GET
    @Path("/ue/{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Fichier> returnAllByUe(@PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return FichierService.findAllByUe(code, from, to);
    }

    @GET
    @Path("/ue/session/{code}/{session}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Fichier> returnAllByUe(@PathParam("code") String code, @PathParam("session") String session, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return FichierService.findAllByUeAndSession(code, session, from, to);
    }
    
    @GET
    @Path("/ue/session/type/{code}/{session}/{type}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Fichier returnAllByUeAndSessionAndType(@PathParam("code") String code, @PathParam("session") String session, @PathParam("type") String type, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return FichierService.findOneByUeAndSessionAndType(code, session, type.toUpperCase().trim());
    }

    @GET
    @Path("/compte/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Fichier> returnAllByEnseignant(@PathParam("id") Long id, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return FichierService.findAllByEnseignant(id, from, to);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Fichier> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return FichierService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Fichier createFichier(Fichier Fichier) throws DataAccessException {
        return FichierService.createOne(Fichier);
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Fichier modifierFichier(Fichier Fichier) throws DataAccessException {
        return FichierService.updateOne(Fichier);
    }

    @DELETE
    @Path("{id}")
    public void deleteOne(@PathParam("id") Long id) throws DataAccessException {
        FichierService.deleteOne(id);
    }
}
