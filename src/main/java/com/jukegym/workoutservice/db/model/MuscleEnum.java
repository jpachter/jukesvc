package com.jukegym.workoutservice.db.model;

import java.util.HashMap;
import java.util.Map;

public enum MuscleEnum {
	Biceps("Biceps"),
	Triceps("Triceps"),
	Chest("Chest"),
	Abs("Abs"),
	Calves("Calves"),
	Glutes("Glutes");
	
    private static final Map<String, MuscleEnum> typesByValue = new HashMap<String, MuscleEnum>();

    static {
        for (MuscleEnum group : MuscleEnum.values()) {
            typesByValue.put(group.muscle, group);
        }
    }
	
	private String muscle;

	private MuscleEnum(final String muscle) {
		this.muscle = muscle;
		
  }
	
    public static MuscleEnum forValue(String value) {
        return typesByValue.get(value);
    }
    
  @Override
  public String toString() {
    return muscle;
  }
}
