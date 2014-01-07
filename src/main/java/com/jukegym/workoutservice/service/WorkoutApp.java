package com.jukegym.workoutservice.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class WorkoutApp extends Application {
     public Set<Class<?>> getClasses() {
         Set<Class<?>> s = new HashSet<Class<?>>();
         s.add(TestJerseyWS.class);
         return s;
     }
}