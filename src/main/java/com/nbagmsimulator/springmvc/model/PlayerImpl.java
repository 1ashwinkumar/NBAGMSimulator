package com.nbagmsimulator.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nbagmsimulator.springmvc.api.model.Player;

@Entity
@Table(name = "player")
public class PlayerImpl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "POSITION")
	private String position;
	
	@Column(name = "TEAM")
	private String team;
	
	@Column(name = "AGE")
	private Integer age;
	
	@Column(name = "CONTRACTLENGTH")
	private Integer contractLength;
	
	@Column(name = "SALARY")
	private Integer salary;
	
	@Embedded
	private Stats stats; // points, rebounds, blocks, steals, assists, turnovers;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "GENERAL_MANAGER", referencedColumnName = "USERNAME")
	@JsonBackReference
	private UserImpl generalManager;

	public PlayerImpl() {}
	
	//copy constructor
	public PlayerImpl(Player player) {
		BeanUtils.copyProperties(player, this);
	}
	
	public PlayerImpl(Long id, String name, String position, String team, Integer age,
			Integer contractLength, Integer salary, Stats stats, UserImpl generalManager) {
		this.id=id;
		this.name=name;
		this.position=position;
		this.team=team;
		this.age=age;
		this.contractLength=contractLength;
		this.salary=salary;
		this.stats=stats;
		this.generalManager=generalManager;
	}
	
	public static PlayerImpl convert(Player player) {
		if(player == null) {
			return null;
		}
		else if(player instanceof PlayerImpl) {
			return (PlayerImpl) player;
		}
		return new PlayerImpl(player);
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public void setPosition(String position) {
		this.position=position;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public void setTeam(String team) {
		this.team=team;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public Integer getContractLength() {
		return this.contractLength;
	}
	
	public void setContractLength(Integer contractLength) {
		this.contractLength=contractLength;
	}
	
	public Integer getSalary() {
		return this.salary;
	}
	
	public void setSalary(Integer salary) {
		this.salary=salary;
	}
	
	public Stats getStats() {
		return this.stats;
	}
	
	public void setStats(Stats stats) {
		this.stats=stats;
	}
	
	public UserImpl getGeneralManager() {
		return this.generalManager;
	}
	
	public void setGeneralManager(UserImpl generalManager) {
		this.generalManager=generalManager;
	}

}
