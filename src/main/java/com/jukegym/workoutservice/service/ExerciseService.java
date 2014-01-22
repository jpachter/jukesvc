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
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addExercise(@FormParam("name") String name){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addExercise(name);
    	
    }
    
    @GET
    @Path("/{eid}/add/muscle/group/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addMuscleGroup(@PathParam("mid") String muscleGroupId,
			@PathParam("eid") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addMuscleGroup(Long.valueOf(exerciseId), Long.valueOf(muscleGroupId));
    }
    
    @GET
    @Path("/{eid}/add/muscle/primary/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addPrimaryMuscle(@PathParam("pid") String primaryMuscleId,
			@PathParam("eid") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addPrimaryMuscle(Long.valueOf(exerciseId), Long.valueOf(primaryMuscleId));
    }
    
    @GET
    @Path("/{eid}/add/muscle/secondary/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addSecondaryMuscle(@PathParam("sid") String secondaryMuscleId,
			@PathParam("eid") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addSecondaryMuscle(Long.valueOf(exerciseId), Long.valueOf(secondaryMuscleId));
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Exercise getExerciseById(@PathParam("id") String id){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.getExerciseById(Long.valueOf(id));
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> getAllExercises() {
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.getExercises();
    }
}