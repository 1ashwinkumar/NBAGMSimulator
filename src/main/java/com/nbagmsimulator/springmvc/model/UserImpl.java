package com.nbagmsimulator.springmvc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.nbagmsimulator.springmvc.api.model.User;

@Entity
@Table(name = "user")
public class UserImpl implements Serializable, User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TEAM")
	private String team;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "generalManager", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<PlayerImpl> playersMoved;

	public UserImpl(){}

	public UserImpl(Long id, String username, String address, String email, String team, List<PlayerImpl> playersMoved) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
		this.team = team;
		this.playersMoved = playersMoved;
	}

	//copy constructor
	public UserImpl(User user) {
		BeanUtils.copyProperties(user, this);
	}
	
	public static UserImpl convert(User user) {
		if(user == null) {
			return null;
		}
		else if(user instanceof UserImpl) {
			return (UserImpl) user;
		}
		return new UserImpl(user);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public List<PlayerImpl> getPlayersMoved(){
		return playersMoved;
	}
	
	public void setPlayersMoved(List<PlayerImpl> playersMoved) {
		this.playersMoved = playersMoved;
	}
}
