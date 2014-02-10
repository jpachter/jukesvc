package com.jukegym.workoutservice.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.jukegym.workoutservice.security.CrossDomainFilter;


public class WorkoutApp extends Application {
     public Set<Class<?>> getClasses() {
         Set<Class<?>> s = new HashSet<Class<?>>();
         s.add(ExerciseService.class);
         s.add(MuscleService.class);
         s.add(MuscleGroupService.class);
         s.add(CrossDomainFilter.class);
         return s;
     }
}