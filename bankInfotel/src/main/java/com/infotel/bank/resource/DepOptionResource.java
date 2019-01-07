package com.infotel.bank.resource;

import com.infotel.bank.entities.DepOption;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IDepOptionService;
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
@Path("/option")
@Component
public class DepOptionResource {
    
    @Autowired
    private IDepOptionService optionService;
    
    @GET
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public DepOption returnOne(@PathParam("code") String code) throws DataAccessException {
        return optionService.findOne(code);
    }

    @GET
    @Path("/departement/{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<DepOption> returnAllByRole(@PathParam("code") String code, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return optionService.findAllByDepartement(code, from, to);
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<DepOption> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return optionService.findAll(from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public DepOption createDepOption(DepOption option) throws DataAccessException {
        return optionService.createOne(option);
    }

    @PUT
    @Path("{code}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public DepOption modifierDepOption(@PathParam("code") String code, DepOption option) throws DataAccessException {
        return optionService.updateOne(option);
    }

    @DELETE
    @Path("{code}")
    public void deleteOne(@PathParam("code") String code) throws DataAccessException {
        optionService.deleteOne(code);
    }
}
