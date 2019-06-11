package com.learning.microservice;

public class LimitConfiguration {

	private int minlimit;
	private int maxlimit;
	
	
	
	public LimitConfiguration() {
		super();
	}
	public LimitConfiguration(int minlimit, int maxlimit) {
		super();
		this.minlimit = minlimit;
		this.maxlimit = maxlimit;
	}
	public int getMinlimit() {
		return minlimit;
	}
	public void setMinlimit(int minlimit) {
		this.minlimit = minlimit;
	}
	public int getMaxlimit() {
		return maxlimit;
	}
	public void setMaxlimit(int maxlimit) {
		this.maxlimit = maxlimit;
	}
	
	
	
}
