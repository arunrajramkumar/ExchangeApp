package com.test.common.service;

import java.util.List;

import com.test.common.model.CurrencyExchangeRate;



public interface ExchangeService {

	
	List<CurrencyExchangeRate> listExchangeRates();
	
	List<CurrencyExchangeRate> search(String currencyName);
	
	double convertCurrency(String currencyFrom,String currencyTo);
}
