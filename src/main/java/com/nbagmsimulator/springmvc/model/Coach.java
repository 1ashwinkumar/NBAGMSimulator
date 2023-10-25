package com.nbagmsimulator.springmvc.model;

import java.util.Objects;

public class Coach {
	
	private long id;
	
	private String name;
	
	private boolean isHeadCoach;
	
	private String team;
	
	private int offRating;
	
	private int defRating;
	
	private int contractLength;
	
	private int salary;
	
	public Coach() {}
	
	public Coach(long id, String name, boolean isHeadCoach, String team, int offRating, int defRating,
			int contractLength, int salary) {
		this.id=id;
		this.name=name;
		this.isHeadCoach=isHeadCoach;
		this.team=team;
		this.offRating=offRating;
		this.defRating=defRating;
		this.contractLength=contractLength;
		this.salary=salary;
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
	
	public int getOffRating() {
		return this.offRating;
	}
	
	public void setOffRating(int offRating) {
		this.offRating=offRating;
	}
	
	public int getdefRating() {
		return this.defRating;
	}
	
	public void setDefRating(int defRating) {
		this.defRating=defRating;
	}
	
	public int getContractLength() {
		return this.contractLength;
	}
	
	public void setContractLength(int contractLength) {
		this.contractLength=contractLength;
	}
	
	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int salary) {
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
