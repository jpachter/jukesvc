package com.jukegym.workoutservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class WorkoutService extends Application {
     public Set<Class<?>> getClasses() {
         Set<Class<?>> s = new HashSet<Class<?>>();
         s.add(TestJerseyWS.class);
         return s;
     }
}