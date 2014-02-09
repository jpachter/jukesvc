package com.jukegym.workoutservice.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jukegym.workoutservice.db.dao.MuscleDaoImp;
import com.jukegym.workoutservice.db.dto.Muscle;


@Path("/muscles")
public class MuscleService {
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Muscle> getAllMuscles() {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.getMuscles();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Muscle addMuscle(@FormParam("name") String name) throws Exception {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.createMuscle(name);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Muscle getMuscleById(@PathParam("id") String id){
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.getMuscleById(Long.valueOf(id));
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Muscle deleteMuscleById(@PathParam("id") String id){
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.deleteMuscleById(Long.valueOf(id));
    }
    
}