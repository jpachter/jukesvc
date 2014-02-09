package com.jukegym.workoutservice.db.dto;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Transient;

import com.google.appengine.datanucleus.annotations.Unowned;

public class ExerciseResponse {
	
	@Transient
	private String status;
	
	@Transient
	private Set<String> error;
	
	@Basic
	@Unowned
	private Set<Exercise> exercises;


}
