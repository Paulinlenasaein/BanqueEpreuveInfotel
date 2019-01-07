package com.infotel.bank.resource;

import com.infotel.bank.entities.Epreuve;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEpreuveService;
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
@Path("/epreuve")
@Component
public class EpreuveResource {

    @Autowired
    private IEpreuveService epreuveService;

    @GET
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Epreuve returnOne(@PathParam("id") Long id) throws DataAccessException {
        return epreuveService.findOne(id);
    }

    @GET
    @Path("/ue/{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Epreuve> returnAllByUe(@PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return epreuveService.findAllByUe(code, from, to);
    }

    @GET
    @Path("/ue/session/{code}/{session}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Epreuve> returnAllByUe(@PathParam("code") String code, @PathParam("session") String session, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return epreuveService.findAllByUeAndSession(code, session, from, to);
    }
    
    @GET
    @Path("/ue/session/type/{code}/{session}/{type}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Epreuve returnAllByUeAndSessionAndType(@PathParam("code") String code, @PathParam("session") String session, @PathParam("type") String type, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return epreuveService.findOneByUeAndSessionAndType(code, session, type.toUpperCase().trim());
    }

    @GET
    @Path("/compte/{matricule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Epreuve> returnAllByRole(@PathParam("matricule") String matricule, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return epreuveService.findAllByCompte(matricule, from, to);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Epreuve> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return epreuveService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Epreuve createEpreuve(Epreuve epreuve) throws DataAccessException {
        return epreuveService.createOne(epreuve);
    }

    @PUT
    @Path("{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Epreuve modifierEpreuve(@PathParam("id") String id, Epreuve epreuve) throws DataAccessException {
        return epreuveService.updateOne(epreuve);
    }

    @DELETE
    @Path("{id}")
    public void deleteOne(@PathParam("id") Long id) throws DataAccessException {
        epreuveService.deleteOne(id);
    }
}
