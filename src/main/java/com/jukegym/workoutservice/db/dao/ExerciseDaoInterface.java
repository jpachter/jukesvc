package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.jukegym.workoutservice.db.dto.Exercise;



public interface ExerciseDaoInterface {
	public List<Exercise> getExercises();
	public Exercise getExerciseByKey(Key key);
	public Exercise getExerciseById(long id);
	public Exercise addMuscleGroup(long exerciseId, long muscleGroupId);
	public Exercise addPrimaryMuscle(long exerciseId, long primaryMuscleId);
	public Exercise addSecondaryMuscle(long exerciseId, long secondaryMuscleId);
	public Exercise addExercise(String name);
	public void deleteExercise(long id);	
}
