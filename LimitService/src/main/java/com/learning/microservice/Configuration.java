package com.learning.microservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties("limit-service")
public class Configuration {
	
	private int minlimit;
	private int maxlimit;
	
	
	public Configuration() {
		super();
	}
	public Configuration(int minlimit, int maxlimit) {
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
