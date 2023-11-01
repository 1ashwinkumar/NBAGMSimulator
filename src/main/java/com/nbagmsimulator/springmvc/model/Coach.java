package com.nbagmsimulator.springmvc.model;

import java.util.Objects;

public class Coach {
	
	private Long id;
	
	private String name;
	
	private boolean isHeadCoach;
	
	private String team;
	
	private Integer offRating;
	
	private Integer defRating;
	
	private Integer contractLength;
	
	private Integer salary;
	
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
	
	public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coach))
            return false;
        Coach c = (Coach) o;
        return Objects.equals(id, c.id) && Objects.equals(name, c.name) && Objects.equals(isHeadCoach, c.isHeadCoach) &&
        		Objects.equals(team, c.team) && Objects.equals(offRating, c.offRating)  && Objects.equals(defRating, c.defRating)
        		&& Objects.equals(contractLength, c.contractLength) && Objects.equals(salary, c.salary);
    }

    public int hashCode() {
        return Objects.hash(id, name, isHeadCoach, team, offRating, defRating, contractLength, salary);
    }

    @Override
    public String toString() {
        return "Coach info: [" +
            " id=" + id + ", " +
            "name=" + name + ", " +
            "isHeadCoach=" + isHeadCoach + ", " +
            "team=" + team + ", " +
            "offensive rating=" + offRating + ", " +
            "defensive rating=" + defRating + ", " +
            "contract length=" + contractLength + ", " +
            "salary=$" + salary + " million]";
    }

}
