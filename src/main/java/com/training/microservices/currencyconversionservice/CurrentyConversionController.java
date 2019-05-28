package com.training.microservices.currencyconversionservice;

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
public class CurrentyConversionController {
	
	@Autowired
	private CurrencyExchangeSericeProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVar = new HashMap<>();
		uriVar.put("from", from);
		uriVar.put("to", to);
		 																						
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVar);
		
		CurrencyConversionBean response=responseEntity.getBody();

		return new CurrencyConversionBean(response.
				getId(),from,to,response.getConversionRate(), quantity,quantity.multiply(response.getConversionRate()), response.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
	
		CurrencyConversionBean response=proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversionBean(response.
				getId(),from,to,response.getConversionRate(), quantity,quantity.multiply(response.getConversionRate()), response.getPort());
	}
	
}
