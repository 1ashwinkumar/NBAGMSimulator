package com.nbagmsimulator.springmvc.model;

import java.util.Objects;

public class Player {
	
	private long id;
	
	private String name;
	
	private String position;
	
	private String team;
	
	private int age;
	
	private int contractLength;
	
	private int salary;
	
	private double[] stats; // points, rebounds, blocks, steals, assists, turnovers;
	
	public Player() {}
	
	public Player(long id, String name, String position, String team, int age,
			int contractLength, int salary, double[] stats) {
		this.id=id;
		this.name=name;
		this.position=position;
		this.team=team;
		this.age=age;
		this.contractLength=contractLength;
		this.salary=salary;
		this.stats=stats;
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
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age=age;
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
	
	public double[] getStats() {
		return this.stats;
	}
	
	public void setStats(double[] stats) {
		this.stats=stats;
	}
	
	public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player))
            return false;
        Player p = (Player) o;
        return Objects.equals(id, p.id) && Objects.equals(name, p.name) && Objects.equals(position, p.position) &&
        		Objects.equals(team, p.team) && Objects.equals(age, p.age) && Objects.equals(contractLength, p.contractLength)
        		&& Objects.equals(salary, p.salary) && Objects.equals(stats, p.stats);
    }

    public int hashCode() {
        return Objects.hash(id, name, position, team, age, contractLength, salary, stats);
    }

    @Override
    public String toString() {
        return "Player info and statistics: [" +
            " id=" + id + ", " +
            "name=" + name + ", " +
            "position=" + position + ", " +
            "team=" + team + ", " +
            "age=" + age + ", " +
            "contract length=" + contractLength + ", " +
            "salary=$" + salary + " million, " +
            "points=" + stats[0] + ", " +
            "rebounds=" + stats[1] + ", " +
            "blocks=" + stats[2] + ", " +
            "steals=" + stats[3] + ", " +
            "assists=" + stats[4] + ", " +
            "turnovers=" + stats[5] + "]";
    }

}
