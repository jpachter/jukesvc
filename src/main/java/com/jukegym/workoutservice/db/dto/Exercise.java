package com.jukegym.workoutservice.db.dto;

import java.util.HashSet;
import java.util.Set;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity  
@NamedQueries({
    @NamedQuery(name="Exercise.findAll",
                query="SELECT e FROM Exercise e"),
    @NamedQuery(name="Exercise.findByMuscleGroup",
                query="SELECT e FROM Exercise e WHERE e.muscleGroup in :muscleGroups"),
}) 
public class Exercise {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Key exerciseKey;  

	private String name;
	
	@Basic
	@Unowned
	private Set<MuscleGroup> muscleGroups;
	
	@Basic
	@Unowned
	private Set<Muscle> primaryMuscles;
	
	@Basic
	@Unowned
	private Set<Muscle> secondaryMuscles;

	
	public Exercise(){
		this.muscleGroups = new HashSet<MuscleGroup>();
		this.primaryMuscles = new HashSet<Muscle>();
		this.secondaryMuscles = new HashSet<Muscle>();
	}
	
	public Key getExerciseKey() {
		return exerciseKey;
	}

	public void setExerciseKey(Key exerciseKey) {
		this.exerciseKey = exerciseKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MuscleGroup> getMuscleGroups() {
		return muscleGroups;
	}
	
	public void addMuscleGroup(MuscleGroup muscleGroup){
		if(this.muscleGroups == null)
			this.muscleGroups = new HashSet<MuscleGroup>();
		this.muscleGroups.add(muscleGroup);
	}

	public void setMuscleGroups(Set<MuscleGroup> muscleGroups) {
		this.muscleGroups = muscleGroups;
	}

	
	
	
	public Set<Muscle> getPrimaryMuscles() {
		return primaryMuscles;
	}
	
	public void addPrimaryMuscle(Muscle muscle){
		if(this.primaryMuscles == null)
			this.primaryMuscles = new HashSet<Muscle>();
		this.primaryMuscles.add(muscle);
	}

	public void setPrimaryMuscles(Set<Muscle> muscles) {
		this.primaryMuscles = muscles;
	}

	public Set<Muscle> getSecondaryMuscles() {
		return secondaryMuscles;
	}
	
	public void addSecondaryMuscle(Muscle muscle){
		if(this.secondaryMuscles == null)
			this.secondaryMuscles = new HashSet<Muscle>();
		this.secondaryMuscles.add(muscle);
	}

	public void setSecondaryMuscles(Set<Muscle> secondaryMuscles) {
		this.secondaryMuscles = secondaryMuscles;
	}

	

}
