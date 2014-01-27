package com.jukegym.workoutservice.db.dao;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jukegym.workoutservice.EMF;
import com.jukegym.workoutservice.db.dto.Exercise;
import com.jukegym.workoutservice.db.dto.Muscle;
import com.jukegym.workoutservice.db.dto.MuscleGroup;

public class ExerciseDaoImp implements ExerciseDaoInterface{
	private MuscleDaoImp muscleDao;
	
	public ExerciseDaoImp(){
		muscleDao = new MuscleDaoImp();
	}

	public Exercise addExercise(String name){
		EntityManager em = EMF.get().createEntityManager();
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
		EntityManager em = EMF.get().createEntityManager();
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

	@Override
	public Exercise addPrimaryMuscle(long exerciseId, long primaryMuscleId) {	
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = getExerciseById(exerciseId);
		Muscle muscle = muscleDao.getMuscleById(primaryMuscleId);
		
		if(e == null){
			e = new Exercise();
			e.addError("Error: Unable to find exercise id #(" + exerciseId + ").");
		}
		
		if(muscle == null){
			e.addError("Error: Unable to find muscle id #(" + primaryMuscleId + ").");
		}
		
		if(e.getError() != null && e.getError().size() > 0)
			return e;
		
		try {
			em.getTransaction().begin();  
			e.addPrimaryMuscle(muscle);
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

	@Override
	public Exercise addSecondaryMuscle(long exerciseId, long secondaryMuscleId) {
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = getExerciseById(exerciseId);
		Muscle muscle = muscleDao.getMuscleById(secondaryMuscleId);
		
		if(e == null){
			e = new Exercise();
			e.addError("Error: Unable to find exercise id #(" + exerciseId + ").");
		}
		
		if(muscle == null){
			e.addError("Error: Unable to find muscle id #(" + secondaryMuscleId + ").");
		}
		
		if(e.getError() != null && e.getError().size() > 0)
			return e;
		
		try {
			em.getTransaction().begin();  
			e.addSecondaryMuscle(muscle);
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

	@Override
	public Exercise deleteExerciseById(long id) {
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = getExerciseById(id);

		if(e == null){
			e = new Exercise();
			e.addError("Error: Unable to find exercise id #(" + id + ").");
			return e;
		}
		
		try {			
			em.getTransaction().begin();  
			em.remove(e);
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
	public Exercise removeMuscleGroupFromExercise(long exerciseId, long muscleGroupId){
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = getExerciseById(exerciseId);
		MuscleGroup mg = muscleDao.getMuscleGroupById(muscleGroupId);
		boolean found = false;
		
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
			found = e.removeMuscleGroup(mg);
			if(found){
				em.merge(e);
				em.getTransaction().commit();  
				return e;
			}
			e.addError("Error: Exercise does not contain muscle group id #(" + muscleGroupId + ")." );
			em.getTransaction().rollback();
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

	@Override
	public Exercise removePrimaryMuscleFromExercise(long exerciseId, long primaryMuscleId){
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = getExerciseById(exerciseId);
		Muscle muscle = muscleDao.getMuscleById(primaryMuscleId);
		boolean found = false;
		
		if(e == null){
			e = new Exercise();
			e.addError("Error: Unable to find exercise id #(" + exerciseId + ").");
		}
		
		if(muscle == null){
			e.addError("Error: Unable to find primary muscle id #(" + primaryMuscleId + ").");
		}
		
		if(e.getError() != null && e.getError().size() > 0)
			return e;
		
		try {
			em.getTransaction().begin();  
			found = e.removePrimaryMuscle(muscle);
			if(found){
				em.merge(e);
				em.getTransaction().commit();  
				return e;
			}
			e.addError("Error: Exercise does not contain primary muscle id #(" + primaryMuscleId + ")." );
			em.getTransaction().rollback();
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

	@Override
	public Exercise removeSecondaryMuscleFromExercise(long exerciseId, long secondaryMuscleId){
		EntityManager em = EMF.get().createEntityManager();
		Exercise e = getExerciseById(exerciseId);
		Muscle muscle = muscleDao.getMuscleById(secondaryMuscleId);
		boolean found = false;
		
		if(e == null){
			e = new Exercise();
			e.addError("Error: Unable to find exercise id #(" + exerciseId + ").");
		}
		
		if(muscle == null){
			e.addError("Error: Unable to find secondary muscle id #(" + secondaryMuscleId + ").");
		}
		
		if(e.getError() != null && e.getError().size() > 0)
			return e;
		
		try {
			em.getTransaction().begin();  
			found = e.removeSecondaryMuscle(muscle);
			if(found){
				em.merge(e);
				em.getTransaction().commit();  
				return e;
			}
			e.addError("Error: Exercise does not contain secondary muscle id #(" + secondaryMuscleId + ")." );
			em.getTransaction().rollback();
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


	
}