package com.nbagmsimulator.springmvc.model;

public class Stats{
	public double pts;
	public double rebds;
	public double blks;
	public double stls;
	public double asts;
	public double tos;
	
	public Stats() {}
	
	public Stats(double pts, double rebds, double blks, double stls, double asts, double tos) {
		this.pts=pts;
		this.rebds=rebds;
		this.blks=blks;
		this.stls=stls;
		this.asts=asts;
		this.tos=tos;
	}
}