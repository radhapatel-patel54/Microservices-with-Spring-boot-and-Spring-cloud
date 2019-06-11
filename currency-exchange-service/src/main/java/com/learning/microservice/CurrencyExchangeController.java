package com.learning.microservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
//import org.springframework.cloud.config.environment.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeBusiness currencyExchangeBusiness;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		ExchangeValue exchangeValue = currencyExchangeBusiness.retriveExchangeValue(from, to);
		

		exchangeValue.setPort(Integer.parseInt
				
				(env.getProperty("local.server.port")));

		return exchangeValue;
	}
	
	

}
