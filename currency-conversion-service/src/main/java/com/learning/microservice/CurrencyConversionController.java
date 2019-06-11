package com.learning.microservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrency(@PathVariable String from, @PathVariable String to ,@PathVariable BigDecimal quantity ) {
		Map<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class , uriVariables);
		
		CurrencyConversionBean currencyConversionBean =responseEntity.getBody();
		currencyConversionBean.setQuantity(currencyConversionBean.getConversionMultiple().multiply(quantity));
		
		
		return  currencyConversionBean;
	}
	
	@GetMapping("/currency-convert-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrencyFiegn(@PathVariable String from, @PathVariable String to ,@PathVariable BigDecimal quantity ) {
		Map<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		
		CurrencyConversionBean currencyConversionBean =proxy.retriveExchangeValue(from, to);
		currencyConversionBean.setQuantity(currencyConversionBean.getConversionMultiple().multiply(quantity));
		
		
		return  currencyConversionBean;
	}
	
}
