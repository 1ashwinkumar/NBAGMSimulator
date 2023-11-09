package com.nbagmsimulator.springmvc.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "coach")
public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ISHEADCOACH")
	private boolean isHeadCoach;
	
	@Column(name = "TEAM")
	private String team;
	
	@Column(name = "OFFRATING")
	private Integer offRating;
	
	@Column(name = "DEFRATING")
	private Integer defRating;
	
	@Column(name = "CONTRACTLENGTH")
	private Integer contractLength;
	
	@Column(name = "SALARY")
	private Integer salary;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "GENERAL_MANAGER", referencedColumnName = "USERNAME")
	@JsonBackReference
	private User generalManager;

	public Coach() {}

	public Coach(Long id, String name, boolean isHeadCoach, String team, Integer offRating, Integer defRating,
			Integer contractLength, Integer salary) {
		this.id=id;
		this.name=name;
		this.isHeadCoach=isHeadCoach;
		this.team=team;
		this.offRating=offRating;
		this.defRating=defRating;
		this.contractLength=contractLength;
		this.salary=salary;
	}
	
	public Long getId() {
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
	
	public boolean getIsHeadCoach() {
		return this.isHeadCoach;
	}
	
	public void setIsHeadCoach(boolean isHeadCoach) {
		this.isHeadCoach=isHeadCoach;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public void setTeam(String team) {
		this.team=team;
	}
	
	public Integer getOffRating() {
		return this.offRating;
	}
	
	public void setOffRating(Integer offRating) {
		this.offRating=offRating;
	}
	
	public Integer getDefRating() {
		return this.defRating;
	}
	
	public void setDefRating(Integer defRating) {
		this.defRating=defRating;
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

}
