package com.jukegym.workoutservice.db.dto;

import java.util.HashSet;
import java.util.Set;

import com.google.appengine.api.datastore.Key;
import com.jukegym.workoutservice.db.model.MuscleGroupEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity   
@NamedQueries({
    @NamedQuery(name="MuscleGroup.findAll",
                query="SELECT mg FROM MuscleGroup mg"),
    @NamedQuery(name="MuscleGroup.findByName",
                query="SELECT mg FROM MuscleGroup mg WHERE LOWER(mg.name) = LOWER(:name)"),
}) 
public class MuscleGroup {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Key muscleGroupKey;  
	
	private String name;
	
	@Transient
	Set<String> error;

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

	public Set<String> getError() {
		return error;
	}

	public void setError(Set<String> error) {
		this.error = error;
	}

	
	public void addError(String error){
		if(this.error == null)
			this.error = new HashSet<String>();
		this.error.add(error);
	}
	
	
}
