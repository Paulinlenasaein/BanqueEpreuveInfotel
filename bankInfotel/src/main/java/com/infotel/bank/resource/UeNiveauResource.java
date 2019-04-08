package com.infotel.bank.resource;

import com.infotel.bank.entities.UeNiveau;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IUeNiveauService;
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
@Path("/ueniveau")
@Component
public class UeNiveauResource {
    
    @Autowired
    private IUeNiveauService ueNivService;

    @GET
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public UeNiveau returnOne(@PathParam("id") Long id) throws DataAccessException {
        return ueNivService.findOne(id);
    }

    @GET
    @Path("/ue/{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<UeNiveau> returnAllByUe(@PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return ueNivService.findAllByUe(code, from, to);
    }

    @GET
    @Path("/niveau/{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<UeNiveau> returnAllByUe(@PathParam("code") String code, @PathParam("session") String session, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return ueNivService.findAllByNiveau(code, from, to);
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<UeNiveau> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return ueNivService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public UeNiveau createUeNiveau(UeNiveau ueNiv) throws DataAccessException {
        return ueNivService.createOne(ueNiv);
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public UeNiveau modifierUeNiveau(UeNiveau ueNiv) throws DataAccessException {
        return ueNivService.updateOne(ueNiv);
    }

    @DELETE
    @Path("{id}")
    public void deleteOne(@PathParam("id") Long id) throws DataAccessException {
        ueNivService.deleteOne(id);
    }
}
