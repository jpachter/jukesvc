package com.jukegym.workoutservice.db.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;
import com.jukegym.workoutservice.db.model.MuscleEnum;

@Entity
public class Muscle {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Key muscleKey;  
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Exercise exercise;
	
	public Muscle(){
	}

	public Key getMuscleKey() {
		return muscleKey;
	}

	public void setMuscleGroupKey(Key muscleKey) {
		this.muscleKey = muscleKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if(MuscleEnum.forValue(name) == null){
			throw new Exception("Invalid Muscle Group '" + name + "'.");
		}
		else
			this.name = name;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	
}
	