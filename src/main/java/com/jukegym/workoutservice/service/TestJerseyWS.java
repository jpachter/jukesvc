package com.jukegym.workoutservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jukegym.workoutservice.db.dao.ExerciseDaoImp;
import com.jukegym.workoutservice.db.dto.Exercise;


@Path("/exercises")
public class TestJerseyWS {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Exercise testMethod() {
    	ExerciseDaoImp dao = new ExerciseDaoImp();
    	return dao.addExercise();
    }
}