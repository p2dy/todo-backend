package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bye")
public class Bye {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bye(String name) {
        return "Bye " + name;
    }
}