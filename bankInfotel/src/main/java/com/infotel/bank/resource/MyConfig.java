package com.infotel.bank.resource;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author paulinlenasaein
 */
@Component
@ApplicationPath("/bank")
public class MyConfig extends ResourceConfig {
    
    public MyConfig(){
        register(CompteResource.class);
    }
}
