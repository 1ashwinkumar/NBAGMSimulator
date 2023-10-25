package com.nbagmsimulator.springmvc.service;

import java.util.List;

import com.nbagmsimulator.springmvc.model.Coach;

public interface CoachService {
	
	Coach findById(long id);
	
	Coach findByName(String name);
	
	Coach hireCoach(Coach coach);

	Coach fireCoach(long id);

	List<Coach> getAllCoaches(); 

	List<Coach> clearStaff();

	boolean isCoachExist(Coach coach);
	
	Coach getHeadCoach();

}
