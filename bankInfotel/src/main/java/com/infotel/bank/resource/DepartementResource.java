package com.infotel.bank.resource;

import com.infotel.bank.entities.Departement;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IDepartementService;
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
@Path("/departement")
@Component
public class DepartementResource {
    
    @Autowired
    private IDepartementService departementService;
    
    @GET
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Departement returnOne(@PathParam("code") String code) throws DataAccessException {
        return departementService.findOne(code);
    }
    
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Departement> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return departementService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Departement createDepartement(Departement departement) throws DataAccessException {
        return departementService.createOne(departement);
    }

    @PUT
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Departement modifierDepartement(@PathParam("code") String code, Departement departement) throws DataAccessException {
        return departementService.updateOne(departement);
    }

    @DELETE
    @Path("{code}")
    public void deleteOne(@PathParam("code") String code) throws DataAccessException {
        departementService.deleteOne(code);
    }
}
