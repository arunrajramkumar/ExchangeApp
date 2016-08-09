package com.test.common.dao;

import java.util.List;

import com.test.common.model.CurrencyExchangeRate;

public interface ExchangeDao {

List<CurrencyExchangeRate> listExchangeRates();
	
List<CurrencyExchangeRate> search(String currencyName);
	
	double convertCurrency(String currencyFrom,String currencyTo);
	
}
