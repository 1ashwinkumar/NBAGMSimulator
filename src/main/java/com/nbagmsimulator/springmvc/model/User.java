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

@Entity
@Table(name = "user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TEAM")
	private String team;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "generalManager", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Player> playersMoved;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "generalManager", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Coach> coachesMoved;

	public User(){}

	public User(long id, String username, String address, String email, String team, List<Player> playersMoved,
			List<Coach> coachesMoved) {
		this.id = id;
		this.username = username;
		this.address = address;
		this.email = email;
		this.team = team;
		this.playersMoved = playersMoved;
		this.coachesMoved = coachesMoved;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public List<Player> getPlayersMoved(){
		return playersMoved;
	}
	
	public void setPlayersMoved(List<Player> playersMoved) {
		this.playersMoved = playersMoved;
	}
	
	public List<Coach> getCoachesMoved(){
		return coachesMoved;
	}
	
	public void setCoachesMoved(List<Coach> coachesMoved) {
		this.coachesMoved = coachesMoved;
	}
}
