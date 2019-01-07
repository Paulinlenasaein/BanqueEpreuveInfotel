package com.infotel.bank.resource;

import com.infotel.bank.entities.UE;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IUEService;
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
@Path("/ue")
@Component
public class UEResource {
    
    @Autowired
    private IUEService ueService;

    @GET
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public UE returnOne(@PathParam("code") String code) throws DataAccessException {
        return ueService.findOne(code);
    }

    @GET
    @Path("/intitule/{intitule}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public UE returnOneByIntitul(@PathParam("intitule") String intitule) throws DataAccessException {
        return ueService.findOneByIntitule(intitule);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<UE> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return ueService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public UE createUE(UE ue) throws DataAccessException {
        return ueService.createOne(ue);
    }

    @PUT
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public UE modifierUE(@PathParam("code") String code, UE ue) throws DataAccessException {
        return ueService.updateOne(ue);
    }

    @DELETE
    @Path("{code}")
    public void deleteOne(@PathParam("code") String code) throws DataAccessException {
        ueService.deleteOne(code);
    }
}
