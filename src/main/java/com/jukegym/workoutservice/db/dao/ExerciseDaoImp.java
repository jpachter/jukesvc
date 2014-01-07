package com.jukegym.workoutservice.db.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Key;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.google.appengine.api.datastore.KeyFactory;
import com.jukegym.workoutservice.EMF;
import com.jukegym.workoutservice.db.dto.Exercise;



public class ExerciseDaoImp {
		
	public Exercise addExercise(){
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = new Exercise();
		e.setRequestTime(new Date());
		try {
			em.getTransaction().begin();  
			em.persist(e);  
			em.getTransaction().commit();  
        }
		catch(Exception ex){     
			System.out.println("SHIT");
			ex.printStackTrace();
			em.getTransaction().rollback();
         } finally {
        	em.close();
        }
        return e;
	}
	
	public List<Exercise> getExercises(){
		EntityManager em = EMF.get().createEntityManager();
		List<Exercise> exercises = new ArrayList<Exercise>();
		try {
			TypedQuery<Exercise> query = em.createQuery("SELECT e from Exercise e", Exercise.class);
			exercises = query.getResultList();
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return exercises;
	}
	
	//public static void deleteExercise(Key key){
		
	//}
	
}