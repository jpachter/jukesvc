package com.jukegym.workoutservice.db.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import com.google.appengine.api.datastore.Key;
import com.jukegym.workoutservice.db.model.MuscleEnum;

@Entity   
@NamedQueries({
    @NamedQuery(name="Muscle.findAll",
                query="SELECT m FROM Muscle m"),
}) 
public class Muscle {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Key muscleKey;  
	
	private String name;
	
	@Transient
	Set<String> error;
	
	public Muscle(){
	}

	public Key getMuscleKey() {
		return muscleKey;
	}

	public void setMuscleKey(Key muscleKey) {
		this.muscleKey = muscleKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		if(MuscleEnum.forValue(name) == null){
			throw new Exception("Invalid Muscle '" + name + "'.");
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
	