package com.nbagmsimulator.springmvc.api.model;

import java.util.List;

import com.nbagmsimulator.springmvc.model.PlayerImpl;

public interface User {
	public Long getId();

	public void setId(Long id);

	public String getUsername();

	public void setUsername(String username);

	public String getAddress();

	public void setAddress(String address);

	public String getEmail();

	public void setEmail(String email);
	
	public String getTeam();
	
	public void setTeam(String team);

	public List<PlayerImpl> getPlayersMoved();

	public void setPlayersMoved(List<PlayerImpl> playersMoved);
}
