package com.xyz.common.service;

import java.util.List;

import com.xyz.common.model.CurrencyExchangeRate;



public interface ExchangeService {

	
	List<CurrencyExchangeRate> listExchangeRates();
	
	List<CurrencyExchangeRate> search(String currencyName);
	
	double convertCurrency(String currencyFrom,String currencyTo);
}
