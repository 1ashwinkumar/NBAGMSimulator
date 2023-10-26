package com.nbagmsimulator.springmvc.service;

import java.util.List;

import com.nbagmsimulator.springmvc.model.Coach;

public interface CoachService {
	
	Coach findById(Long id);
	
	Coach findByName(String name);
	
	Coach hireCoach(Coach coach);

	Coach fireCoach(Long id);

	List<Coach> getAllCoaches(); 

	List<Coach> clearStaff();

	boolean isCoachExist(Coach coach);
	
	Coach getHeadCoach();
	
	boolean deleteCoach(Long id);

}
