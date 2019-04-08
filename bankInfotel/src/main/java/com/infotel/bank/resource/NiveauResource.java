package com.infotel.bank.resource;

import com.infotel.bank.entities.Niveau;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.INiveauService;
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
@Path("/niveau")
@Component
public class NiveauResource {
    
    @Autowired
    private INiveauService niveauService;

    @GET
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Niveau returnOne(@PathParam("code") String code) throws DataAccessException {
        return niveauService.findOne(code);
    }

    @GET
    @Path("/intitul/{intitul}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Niveau returnOneByIntitul(@PathParam("intitul") String intitul) throws DataAccessException {
        return niveauService.findOneByIntitul(intitul);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Niveau> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return niveauService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Niveau createNiveau(Niveau niveau) throws DataAccessException {
        return niveauService.createOne(niveau);
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Niveau modifierNiveau(Niveau niveau) throws DataAccessException {
        return niveauService.updateOne(niveau);
    }

    @DELETE
    @Path("{code}")
    public void deleteOne(@PathParam("code") String code) throws DataAccessException {
        niveauService.deleteOne(code);
    }
}
