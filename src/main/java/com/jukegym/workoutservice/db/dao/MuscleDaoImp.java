package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.jukegym.workoutservice.EMF;
import com.jukegym.workoutservice.db.dto.Muscle;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public class MuscleDaoImp implements MuscleDaoInterface{
	
	public MuscleDaoImp(){
		
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
	
	public MuscleGroup createMuscleGroup(String name){
		MuscleGroup mg = getMuscleGroupByName(name);
		EntityManager em;
		
		if(mg != null)
			return mg;
		
		em = EMF.get().createEntityManager();
		mg = new MuscleGroup();
		
		try {
			mg.setName(name);
		} catch (Exception e) {
			mg.addError("Invalid muscle group name '" + name + "'.");
			return mg;
		}	
		
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

	@Override
	public List<Muscle> getMuscles() {
		EntityManager em = EMF.get().createEntityManager();
		List<Muscle> results = null;
		
		try {
			TypedQuery<Muscle> query =
				      em.createNamedQuery("Muscle.findAll", Muscle.class);
			results = query.getResultList();
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return results;
	}

	@Override
	public Muscle getMuscleById(long id) {
		EntityManager em = EMF.get().createEntityManager();
		Muscle result = null;
		
		Key key = KeyFactory.createKey(Muscle.class.getSimpleName(), id);
		try {
			result = em.find(Muscle.class, key);
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return result;
	}

	@Override
	public Muscle createMuscle(String name) {
		Muscle muscle = getMuscleByName(name);
		EntityManager em;
		
		if(muscle != null)
			return muscle;
		
		em = EMF.get().createEntityManager();
		muscle = new Muscle();
		
		try {
			muscle.setName(name);
		} catch (Exception e) {
			muscle.addError("Invalid muscle name '" + name + "'.");
			return muscle;
		}	
		
		try {
			em.getTransaction().begin();
			em.persist(muscle);  
			em.getTransaction().commit();  
			return muscle;
        }
		catch(Exception ex){     
			ex.printStackTrace();
			em.getTransaction().rollback();
			return null;
         } finally {
        	em.close();
        }
	}

	@Override
	public Muscle deleteMuscleById(long id) {
		EntityManager em = EMF.get().createEntityManager();
		Muscle m = getMuscleById(id);

		if(m == null){
			m = new Muscle();
			m.addError("Error: Unable to find muscle id #(" + id + ").");
			return m;
		}
		
		try {			
			em.getTransaction().begin();  
			em.remove(m);
			em.getTransaction().commit();  
			return null;
        }
		catch(Exception ex){     
			ex.printStackTrace();
			return null;
         } finally {
        	em.close();
        }
	}

	@Override
	public MuscleGroup deleteMuscleGroupById(long id) {
		EntityManager em = EMF.get().createEntityManager();
		MuscleGroup mg = getMuscleGroupById(id);

		if(mg == null){
			mg = new MuscleGroup();
			mg.addError("Error: Unable to find muscle group id #(" + id + ").");
			return mg;
		}
		
		try {			
			em.getTransaction().begin();  
			em.remove(mg);
			em.getTransaction().commit();  
			return null;
        }
		catch(Exception ex){     
			ex.printStackTrace();
			return null;
         } finally {
        	em.close();
        }
	}

	@Override
	public MuscleGroup getMuscleGroupByName(String name) {
		EntityManager em = EMF.get().createEntityManager();
		MuscleGroup result = null;
		
		try {
			TypedQuery<MuscleGroup> query =
				      em.createNamedQuery("MuscleGroup.findByName", MuscleGroup.class);
			query.setParameter("name", name);
			result = query.getSingleResult();
        }
		catch(NoResultException ex){
			
		}
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return result;
	}

	@Override
	public Muscle getMuscleByName(String name) {
		EntityManager em = EMF.get().createEntityManager();
		Muscle result = null;
		
		try {
			TypedQuery<Muscle> query =
				      em.createNamedQuery("MuscleGroup.findByName", Muscle.class);
			query.setParameter("name", name);
			result = query.getSingleResult();
        }
		catch(Exception ex){     
			ex.printStackTrace();
         } finally {
        	em.close();
        }

		return result;
	}	
}