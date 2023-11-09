package com.nbagmsimulator.springmvc.dao;

import java.util.List;

import com.nbagmsimulator.springmvc.model.Coach;

public interface CoachDao {
	
	public Coach findById(long id);
	
	public Coach findByName(String name);
	
	public Coach hireNewCoach(Coach coach);
	
	public Coach hireExistingCoach(Coach coach);
	
	public Coach fireCoach(long id);
	
	public List<Coach> getAllCoaches();
	
	public boolean isCoachExist(Coach coach);
	
	public boolean isHeadCoach(Coach coach);
	
	public Coach getHeadCoach();
	
	public boolean deleteCoachById(long id);
	
	public List<Coach> clearStaff();
}
