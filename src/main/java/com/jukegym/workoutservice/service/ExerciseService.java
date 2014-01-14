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
import com.jukegym.workoutservice.db.dto.Exercise;


@Path("/exercises")
public class ExerciseService {

    @POST
    @Path("/add/exercise")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addExercise(@FormParam("name") String name){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addExercise(name);
    	
    }
    
    @POST
    @Path("/add/musclegroup/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addMuscleGroup(@FormParam("musclegroup") String muscleGroup,
			@PathParam("id") String id) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addMuscleGroupTo(Long.valueOf(id), muscleGroup);
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Exercise getExerciseById(@PathParam("id") String id){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.getExerciseById(Long.valueOf(id));
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> getAllExercises() {
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.getExercises();
    }
}