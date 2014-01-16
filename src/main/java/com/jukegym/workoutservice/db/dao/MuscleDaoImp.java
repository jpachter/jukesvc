package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jukegym.workoutservice.EMF;
import com.jukegym.workoutservice.db.dto.Exercise;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public class MuscleDaoImp {
	private EntityManager em;
	
	public MuscleDaoImp(){
		em = EMF.get().createEntityManager();
	}

	public List<MuscleGroup> getMuscleGroups(){
		EntityManager em = EMF.get().createEntityManager();
		List<MuscleGroup> results = null;
		
		try {
			TypedQuery<MuscleGroup> query =
				      em.createNamedQuery("MuscleGroup.findAll", MuscleGroup.class);
			results = query.getResultList();
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return results;
	}
	
	public MuscleGroup getMuscleGroupById(long id){
		EntityManager em = EMF.get().createEntityManager();
		MuscleGroup result = null;
		
		Key key = KeyFactory.createKey(MuscleGroup.class.getSimpleName(), id);
		try {
			result = em.find(MuscleGroup.class, key);
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return result;
	}
	
	public MuscleGroup createMuscleGroup(String name) throws Exception{

		MuscleGroup mg = new MuscleGroup();
		mg.setName(name);	
		
		try {
			em.getTransaction().begin();
			em.persist(mg);  
			em.getTransaction().commit();  
			return mg;
        }
		catch(Exception ex){     
			ex.printStackTrace();
			em.getTransaction().rollback();
			return null;
         } finally {
        	em.close();
        }
	}
	
}