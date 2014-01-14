package com.jukegym.workoutservice.db.dto;

import com.google.appengine.api.datastore.Key;
import com.jukegym.workoutservice.db.model.MuscleGroupEnum;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity   
public class MuscleGroup {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Key muscleGroupKey;  
	
	private String name;

	
	public MuscleGroup(){
	}

	public Key getMuscleGroupKey() {
		return muscleGroupKey;
	}

	public void setMuscleGroupKey(Key muscleGroupKey) {
		this.muscleGroupKey = muscleGroupKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if(MuscleGroupEnum.forValue(name) == null){
			throw new Exception("Invalid Muscle Group '" + name + "'.");
		}
		else
			this.name = name;
	}

	
	
	
}
