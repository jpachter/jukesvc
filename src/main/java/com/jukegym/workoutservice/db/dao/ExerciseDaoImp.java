package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jukegym.workoutservice.EMF;
import com.jukegym.workoutservice.db.dto.Exercise;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public class ExerciseDaoImp {
	private EntityManager em;
	
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
	
	public Exercise addMuscleGroupTo(long id, String muscleGroup) throws Exception{		
		Exercise e = getExerciseById(id);
		
		if (e == null)
			return null;
		
		MuscleGroup mg = new MuscleGroup();
		mg.setName(muscleGroup);

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
	
	//public static void deleteExercise(Key key){
		
	//}
	
}