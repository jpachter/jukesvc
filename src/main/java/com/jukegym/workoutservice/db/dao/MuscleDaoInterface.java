package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.jukegym.workoutservice.db.dto.Muscle;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public interface MuscleDaoInterface {
	public List<MuscleGroup> getMuscleGroups();	
	public MuscleGroup getMuscleGroupById(long id);
	public MuscleGroup createMuscleGroup(String name);
	public MuscleGroup getMuscleGroupByName(String name);
	public Muscle getMuscleByName(String name);
	public List<Muscle> getMuscles();	
	public Muscle getMuscleById(long id);
	public Muscle createMuscle(String name);
	public Muscle deleteMuscleById(long id);	
	public MuscleGroup deleteMuscleGroupById(long id);
}