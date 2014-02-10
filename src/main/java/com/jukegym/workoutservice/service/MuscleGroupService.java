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
import com.jukegym.workoutservice.db.dto.MuscleGroup;
import com.jukegym.workoutservice.security.CORSBinding;


@Path("/musclegroups")
public class MuscleGroupService {
    
    @GET
    @CORSBinding
    @Produces(MediaType.APPLICATION_JSON)
    public List<MuscleGroup> getAllMuscleGroups() {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.getMuscleGroups();
    }
    
    @POST
    @CORSBinding
    @Produces(MediaType.APPLICATION_JSON)
    public MuscleGroup addMuscleGroup(@FormParam("name") String name) throws Exception {
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.createMuscleGroup(name);
    }
    
    @GET
    @CORSBinding
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MuscleGroup getMuscleGroupById(@PathParam("id") String id){
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.getMuscleGroupById(Long.valueOf(id));
    }
    
    @DELETE
    @CORSBinding
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MuscleGroup deleteMuscleGroupById(@PathParam("id") String id){
    	MuscleDaoImp dao = new MuscleDaoImp();
    	return dao.deleteMuscleGroupById(Long.valueOf(id));
    }
    
}