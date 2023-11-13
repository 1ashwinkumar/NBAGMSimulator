package com.nbagmsimulator.springmvc.api.model;

import com.nbagmsimulator.springmvc.model.Stats;

public interface Player {
	public long getId();
	
	public void setId(Long id);
	
	public String getName();
	
	public void setName(String name);
	
	public String getPosition();
	
	public void setPosition(String position);
	
	public String getTeam();
	
	public void setTeam(String team);
	
	public Integer getAge();
	
	public void setAge(int age);
	
	public Integer getContractLength();
	
	public void setContractLength(Integer contractLength);
	
	public Integer getSalary();
	
	public void setSalary(Integer salary);
	
	public Stats getStats();
	
	public void setStats(Stats stats);
}
