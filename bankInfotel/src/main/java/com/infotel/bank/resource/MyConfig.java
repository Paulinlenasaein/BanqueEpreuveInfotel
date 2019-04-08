package com.infotel.bank.resource;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulinlenasaein
 */
@Component
@ApplicationPath("/bank-api")
public class MyConfig extends ResourceConfig {
    
    public MyConfig(){
        register(CompteResource.class);
        register(DepOptionResource.class);
        register(DepartementResource.class);
        register(EnseignantResource.class);
        register(EtudiantResource.class);
        register(FichierResource.class);
        register(NiveauResource.class);
        register(RecevoirResource.class);
        register(UEResource.class);
        register(UeNiveauResource.class);
    }
}
