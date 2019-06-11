package com.learning.microservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeBusiness {

	@Autowired
	private ExchangeValueRepo exchangeValueRepo;

	public ExchangeValue retriveExchangeValue(String from, String to) {
		ExchangeValue exchangeValue = new ExchangeValue();
		List<ExchangeValue> list = (List<ExchangeValue>) exchangeValueRepo.findAll();
		list = list.stream().filter(a -> a.getFrom().equals(from) & a.getTo().equals(to)).collect(Collectors.toList());
		if (!list.isEmpty()) {
			exchangeValue = list.get(0);
		}

		return exchangeValue;
	}

}
