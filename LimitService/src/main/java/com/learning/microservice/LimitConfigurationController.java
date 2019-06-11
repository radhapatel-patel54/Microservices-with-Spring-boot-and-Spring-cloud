package com.learning.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	private Configuration config;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfigurations() {
		
		return new LimitConfiguration(config.getMinlimit(),config.getMaxlimit());
	}

}
