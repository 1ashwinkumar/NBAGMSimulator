package com.nbagmsimulator.springmvc.view;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nbagmsimulator.springmvc.api.model.User;
import com.nbagmsimulator.springmvc.model.PlayerImpl;

public class UserView implements User{
	@JsonProperty("id")
	private Long id;

	@JsonProperty("username")
	private String username;

	@JsonProperty("address")
	private String address;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("team")
	private String team;

	@JsonProperty("playersMoved")
	private List<PlayerImpl> playersMoved;
	
	public UserView() {}
	
	//copy constructor
	public UserView(User user) {
		BeanUtils.copyProperties(user, this);
	}
	
	public UserView(long id, String username, String address, String email, String team, List<PlayerImpl> playersMoved) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
		this.team = team;
		this.playersMoved = playersMoved;
	}
	
	public static UserView convert(User user) {
		if(user == null) {
			return null;
		}
		else if(user instanceof UserView) {
			return (UserView) user;
		}
		return new UserView(user);
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username=username;
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public void setAddress(String address) {
		this.address=address;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email=email;
	}

	@Override
	public String getTeam() {
		return this.team;
	}

	@Override
	public void setTeam(String team) {
		this.team=team;
	}

	@Override
	public List<PlayerImpl> getPlayersMoved() {
		return this.playersMoved;
	}

	@Override
	public void setPlayersMoved(List<PlayerImpl> playersMoved) {
		this.playersMoved=playersMoved;
	}

}
