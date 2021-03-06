package com.jukegym.workoutservice.security;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
@CORSBinding
public class CrossDomainFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext creq, ContainerResponseContext cres) {
        Logger.getLogger("com.jukegym").log(Level.INFO, "before:", cres.getHeaders());
        cres.getHeaders().add("Access-Control-Allow-Origin", "*");
        cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
        cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        cres.getHeaders().add("Access-Control-Max-Age", "1209600");
        Logger.getLogger("com.jukegym").log(Level.INFO, "after:", cres.getHeaders());
    }
}