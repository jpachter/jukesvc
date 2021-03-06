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

import com.jukegym.workoutservice.db.dao.ExerciseDaoImp;
import com.jukegym.workoutservice.db.dto.Exercise;
import com.jukegym.workoutservice.security.CORSBinding;


@Path("/exercises")
public class ExerciseService {

    @POST
    @CORSBinding
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addExercise(@FormParam("name") String name){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addExercise(name);
    }
    
    @GET
    @CORSBinding
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> getAllExercises() {
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.getExercises();
    }

    @GET
    @CORSBinding
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Exercise getExerciseById(@PathParam("id") String id){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.getExerciseById(Long.valueOf(id));
    }
    
    @DELETE
    @CORSBinding
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Exercise deleteExerciseById(@PathParam("id") String id){
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.deleteExerciseById(Long.valueOf(id));
    }
    
    @POST
    @CORSBinding
    @Path("/{id}/musclegroups")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addMuscleGroup(@FormParam("mgid") String muscleGroupId,
			@PathParam("id") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addMuscleGroup(Long.valueOf(exerciseId), Long.valueOf(muscleGroupId));
    }
    
    @POST
    @CORSBinding
    @Path("/{id}/primarymuscles")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addPrimaryMuscle(@FormParam("pid") String primaryMuscleId,
			@PathParam("id") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addPrimaryMuscle(Long.valueOf(exerciseId), Long.valueOf(primaryMuscleId));
    }
    
    @POST
    @CORSBinding
    @Path("/{id}/secondarymuscles")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise addSecondaryMuscle(@FormParam("sid") String secondaryMuscleId,
			@PathParam("eid") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addSecondaryMuscle(Long.valueOf(exerciseId), Long.valueOf(secondaryMuscleId));
    }
    
    @DELETE
    @CORSBinding
    @Path("/{id}/musclegroups/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise removeMuscleGroup(@PathParam("mid") String muscleGroupId,
			@PathParam("id") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.removeMuscleGroupFromExercise(Long.valueOf(exerciseId), Long.valueOf(muscleGroupId));
    }
    
    @DELETE
    @CORSBinding
    @Path("/{id}/primarymuscles/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise removePrimaryMuscle(@PathParam("pid") String primaryMuscleId,
			@PathParam("id") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.removePrimaryMuscleFromExercise(Long.valueOf(exerciseId), Long.valueOf(primaryMuscleId));
    }
    
    @DELETE
    @CORSBinding
    @Path("/{id}/secondarymuscles/{sid}")
    @Produces(MediaType.APPLICATION_JSON)
	public Exercise removeSecondaryMuscle(@PathParam("sid") String secondaryMuscleId,
			@PathParam("id") String exerciseId) throws Exception{
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.removeSecondaryMuscleFromExercise(Long.valueOf(exerciseId), Long.valueOf(secondaryMuscleId));
    }
}