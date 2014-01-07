package com.jukegym.workoutservice.db.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.Key;
import javax.jdo.Query;
import com.google.appengine.api.datastore.KeyFactory;
import com.jukegym.workoutservice.PMF;
import com.jukegym.workoutservice.db.dto.Exercise;



public class ExerciseDaoImp {
		
	public Exercise addExercise(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Exercise e = new Exercise();
		e.setName("Sup fucker");

        try {
            pm.makePersistent(e);
        
        } finally {
            pm.close();
        }
        return e;
	}
	
	//public static void deleteExercise(Key key){
		
	//}
	
}