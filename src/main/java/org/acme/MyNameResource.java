package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/myname")
public class MyNameResource {
    @ConfigProperty(name = "myname")
    String myname;

    @ConfigProperty(name = "mynameDefaultTest")
    String mynameDefaultTest;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String myname() {
        return "Hello myname: " + myname + "\n" + "Hello mynameDefaultTest: " + mynameDefaultTest;
    }
}