package com.infotel.bank.resource;

import com.infotel.bank.entities.Recevoir;
import com.infotel.bank.service.DataAccessException;
import com.infotel.bank.service.IEtudiantService;
import com.infotel.bank.service.IFichierService;
import com.infotel.bank.service.IRecevoirService;
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
@Path("receive")
@Component
public class RecevoirResource {
    
    @Autowired
    private IRecevoirService recService;
    
    @Autowired
    private IEtudiantService etudService;
    
    @Autowired
    private IFichierService fichService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Recevoir> returnAll(@DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return recService.findAll(from, to);
    }

    @GET
    @Path("/recevoir/{idUser}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Recevoir> returnByEtudiant(@PathParam("idUser") Long idUser, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return recService.findAllByEtudiant(idUser, from, to);
    }
    
    @GET
    @Path("/fichier/{id_fich}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Recevoir> returnByFichier(@PathParam("id_fich") Long id_fich, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return recService.findAllByFichier(id_fich, from, to);
    }
    
    @GET
    @Path("/etudfich/{idUser}/{id_fich}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Recevoir returnByEtudiantAndFichier(@PathParam("idUser") Long idUser, @PathParam("id_fich") Long id_fich, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return recService.findAllByEtudiantAndFichier(idUser, id_fich);
    }
    
    @GET
    @Path("/etudstate/{idUser}/{status}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Page<Recevoir> returnByEtudiantAndStatus(@PathParam("idUser") Long id_fich, @PathParam("status") int status, @DefaultValue("0") @QueryParam("from") int from, @DefaultValue("50") @QueryParam("to") int to) throws DataAccessException {
        return recService.findAllByEtudiantAndStatus(id_fich, status, from, to);
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Recevoir createRecevoir(Recevoir recevoir) throws DataAccessException {
        return recService.createOne(recevoir);
    }

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Recevoir modifierRecevoir(Recevoir recevoir) throws DataAccessException {
        return recService.updateOne(recevoir);
    }
}
