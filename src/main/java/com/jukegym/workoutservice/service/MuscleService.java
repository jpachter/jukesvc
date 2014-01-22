package com.jukegym.workoutservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jukegym.workoutservice.db.dao.ExerciseDaoImp;
import com.jukegym.workoutservice.db.dao.MuscleDaoImp;
import com.jukegym.workoutservice.db.dto.Exercise;
import com.jukegym.workoutservice.db.dto.Muscle;
import com.jukegym.workoutservice.db.dto.MuscleGroup;


@Path("/muscles")
public class MuscleService {
    
    @GET
    @Path("/groups")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MuscleGroup> getAllMuscleGroups() {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.getMuscleGroups();
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Muscle> getAllMuscles() {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.getMuscles();
    }
    
    @POST
    @Path("/groups/add")
    @Produces(MediaType.APPLICATION_JSON)
    public MuscleGroup addMuscleGroup(@FormParam("name") String name) throws Exception {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.createMuscleGroup(name);
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Muscle addMuscle(@FormParam("name") String name) throws Exception {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.createMuscle(name);
    }
}