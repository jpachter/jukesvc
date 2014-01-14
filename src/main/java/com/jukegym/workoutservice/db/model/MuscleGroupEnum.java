package com.jukegym.workoutservice.db.model;

import java.util.HashMap;
import java.util.Map;

public enum MuscleGroupEnum {
	Chest("Chest"),
	Back("Back"),
	Arms("Arms"),
	Legs("Legs"),
	Biceps("Biceps"),
	Triceps("Triceps"),
	Calves("Calves");
	
    private static final Map<String, MuscleGroupEnum> typesByValue = new HashMap<String, MuscleGroupEnum>();

    static {
        for (MuscleGroupEnum group : MuscleGroupEnum.values()) {
            typesByValue.put(group.muscleGroup, group);
        }
    }
	
	private String muscleGroup;

	private MuscleGroupEnum(final String muscleGroup) {
		this.muscleGroup = muscleGroup;
  }
	
    public static MuscleGroupEnum forValue(String value) {
        return typesByValue.get(value);
    }
    
  @Override
  public String toString() {
    return muscleGroup;
  }
}
