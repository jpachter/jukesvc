package com.jukegym.workoutservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exercises")
public class TestJerseyWS {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Test testMethod() {
        Test t = new Test();
        t.setFuck("FUCK");
        return t;
    }
}