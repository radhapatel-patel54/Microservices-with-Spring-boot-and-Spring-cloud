package com.learning.microservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface ExchangeValueRepo extends CrudRepository<ExchangeValue, Long> {
	


}
