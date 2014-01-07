package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.jukegym.workoutservice.db.dto.Exercise;



public interface ExerciseDaoInterface {
	public List<Exercise> getAllExercises();
	public Exercise getExercise(int exerciseID);
	public void addExercise(Exercise ex);
	public void deleteExercise(int id);	
}
