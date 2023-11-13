package com.nbagmsimulator.springmvc.view;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nbagmsimulator.springmvc.api.model.Player;
import com.nbagmsimulator.springmvc.model.Stats;

public class PlayerView implements Player{
	@JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private String position;

    @JsonProperty("team")
    private String team;
    
    @JsonProperty("age")
    private Integer age;
    
    @JsonProperty("contractLength")
    private Integer contractLength;
    
    @JsonProperty("salary")
    private Integer salary;
    
    @JsonProperty("stats")
    private Stats stats;
    
    public PlayerView() {}

	//copy constructor
	public PlayerView(Player player) {
		BeanUtils.copyProperties(player, this);
	}
    
	public PlayerView(Long id, String name, String position, String team, Integer age,
			Integer contractLength, Integer salary, Stats stats) {
		this.id=id;
		this.name=name;
		this.position=position;
		this.team=team;
		this.age=age;
		this.contractLength=contractLength;
		this.salary=salary;
		this.stats=stats;
	}
	
	public static PlayerView convert(Player player) {
		if(player == null) {
			return null;
		}
		else if(player instanceof PlayerView) {
			return (PlayerView) player;
		}
		return new PlayerView(player);
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
}
