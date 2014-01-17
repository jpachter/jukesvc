package com.jukegym.workoutservice.db.dao;

import java.util.List;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public interface MuscleDaoInterface {
	public List<MuscleGroup> getMuscleGroups();	
	public MuscleGroup getMuscleGroupById(long id);
	public MuscleGroup createMuscleGroup(String name);
	
}