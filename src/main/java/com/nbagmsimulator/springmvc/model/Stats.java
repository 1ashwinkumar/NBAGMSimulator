package com.nbagmsimulator.springmvc.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stats{
	
	@Column(name = "POINTS")
	private BigDecimal pts;  //use getters and setters and bigdecimal data type
	
	@Column(name = "REBOUNDS")
	private BigDecimal rebds;
	
	@Column(name = "BLOCKS")
	private BigDecimal blks;
	
	@Column(name = "STEALS")
	private BigDecimal stls;
	
	@Column(name = "ASSISTS")
	private BigDecimal asts;
	
	@Column(name = "TURNOVERS")
	private BigDecimal tos;
	
	public Stats() {}
	
	public Stats(BigDecimal pts, BigDecimal rebds, BigDecimal blks, BigDecimal stls, BigDecimal asts, BigDecimal tos) {
		this.pts=pts;
		this.rebds=rebds;
		this.blks=blks;
		this.stls=stls;
		this.asts=asts;
		this.tos=tos;
	}
	
	public BigDecimal getPts() {
		return this.pts;
	}
	
	public BigDecimal geRebds() {
		return this.rebds;
	}
	
	public BigDecimal getBlks() {
		return this.blks;
	}
	
	public BigDecimal getStls() {
		return this.stls;
	}
	
	public BigDecimal getAsts() {
		return this.asts;
	}
	
	public BigDecimal getTos() {
		return this.tos;
	}
}