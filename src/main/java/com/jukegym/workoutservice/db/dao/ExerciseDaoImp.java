package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jukegym.workoutservice.EMF;
import com.jukegym.workoutservice.db.dto.Exercise;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public class ExerciseDaoImp implements ExerciseDaoInterface{
	private EntityManager em;
	private MuscleDaoImp muscleDao;
	
	public ExerciseDaoImp(){
		em = EMF.get().createEntityManager();
	}

	public Exercise addExercise(String name){

		Exercise e = new Exercise();
		e.setName(name);	
		
		try {
			em.getTransaction().begin();
			em.persist(e);  
			em.getTransaction().commit();  
			return e;
        }
		catch(Exception ex){     
			ex.printStackTrace();
			em.getTransaction().rollback();
			return null;
         } finally {
        	em.close();
        }
	}
	
	public Exercise getExerciseByKey(Key key){
		EntityManager em = EMF.get().createEntityManager();
		Exercise result = null;
		
		try {
			result = em.find(Exercise.class, key);
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return result;
	}
	
	public Exercise getExerciseById(long id){
		EntityManager em = EMF.get().createEntityManager();
		Exercise result = null;
		
		Key key = KeyFactory.createKey(Exercise.class.getSimpleName(), id);
		try {
			result = em.find(Exercise.class, key);
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return result;
	}
	
	public Exercise addMuscleGroup(long exerciseId, long muscleGroupId){		
		muscleDao = new MuscleDaoImp();
		
		Exercise e = getExerciseById(exerciseId);
		MuscleGroup mg = muscleDao.getMuscleGroupById(muscleGroupId);
		
		if(e == null){
			e = new Exercise();
			e.addError("Error: Unable to find exercise id #(" + exerciseId + ").");
		}
		
		if(mg == null){
			e.addError("Error: Unable to find muscle group id #(" + muscleGroupId + ").");
		}
		
		if(e.getError() != null && e.getError().size() > 0)
			return e;
		
		try {
			em.getTransaction().begin();  
			e.addMuscleGroup(mg);
			em.merge(e);
			em.getTransaction().commit();  
			return e;
        }
		catch(Exception ex){     
			ex.printStackTrace();
			em.getTransaction().rollback();
			return null;
         } finally {
        	em.close();
        }
	}
	
	public List<Exercise> getExercises(){
		EntityManager em = EMF.get().createEntityManager();
		List<Exercise> results = null;
		
		try {
			TypedQuery<Exercise> query =
				      em.createNamedQuery("Exercise.findAll", Exercise.class);
			results = query.getResultList();
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return results;
	}
	
	public void deleteExercise(long id){
		
	}
	
}