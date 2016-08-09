package com.xyz.common.controller;

import java.util.ArrayList;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.common.model.CurrencyExchangeRate;
import com.test.common.service.ExchangeService;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
	
	@Autowired
	ExchangeService exchangeService;

	
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public 
	CurrencyExchangeRate listExchangeRates() {
System.out.println("Inside List method");
		return exchangeService.listExchangeRates().get(0);

	}
	
	@RequestMapping(value = "convert/{fromCurrency}/{toCurrency}", method = RequestMethod.GET)
	public 
	double convertCurrency(@PathVariable String fromCurrency,@PathVariable String toCurrency) {

		

		return exchangeService.convertCurrency(fromCurrency, toCurrency);

	}
	
	@RequestMapping(value = "search/{currencyName}", method = RequestMethod.GET)
	public 
	List<CurrencyExchangeRate> search(@PathVariable String currencyName) {

		

		return exchangeService.search(currencyName);

	}
	
	
	
}