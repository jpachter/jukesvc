package com.jukegym.workoutservice.db.dto;


import java.util.Date;
import com.google.appengine.api.datastore.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  
public class Exercise {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Key id;  
	   
	private Date requestTime;  

	public Exercise(){}
	
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
}
