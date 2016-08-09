package com.test.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.common.dao.ExchangeDao;
import com.test.common.model.CurrencyExchangeRate;

@Service
public class ExchangeServiceImpl implements ExchangeService{

	@Autowired
	private ExchangeDao exchangeDao;
	
	@Override
	public List<CurrencyExchangeRate> listExchangeRates() {
		// TODO Auto-generated method stub
		List<CurrencyExchangeRate> lstExch = new ArrayList<CurrencyExchangeRate>();
		
		CurrencyExchangeRate currExRate = new CurrencyExchangeRate();
		currExRate.setCurrencyName("INR");
		currExRate.setValueForUSD(68.2d);
		
		CurrencyExchangeRate currExRate1 = new CurrencyExchangeRate();
		currExRate1.setCurrencyName("AED");
		currExRate1.setValueForUSD(712.2d);
		
		CurrencyExchangeRate currExRateEuro = new CurrencyExchangeRate();
		currExRateEuro.setCurrencyName("EUR");
		currExRateEuro.setValueForUSD(0.898242d);
		
		CurrencyExchangeRate currExRateGBP = new CurrencyExchangeRate();
		currExRateGBP.setCurrencyName("GBP");
		currExRateGBP.setValueForUSD(0.683926d);
		
		lstExch.add(currExRate);
		lstExch.add(currExRate1);
		lstExch.add(currExRateEuro);
		lstExch.add(currExRateGBP);
		
		/*try{
			lstExch = exchangeDao.listExchangeRates();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("exception --> ");
		}*/
		
		
		
		return lstExch;
	}

	@Override
	public List<CurrencyExchangeRate> search(String currencyName) {
		// TODO Auto-generated method stub
		List<CurrencyExchangeRate> lstExch = listExchangeRates();
		List<CurrencyExchangeRate> searchResults = new ArrayList<CurrencyExchangeRate>();
		
		try{
			searchResults = exchangeDao.search(currencyName);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("exception --> ");
		}
		
/*CurrencyExchangeRate currSearchRate = null;
		
		for(CurrencyExchangeRate currRate:lstExch)
		{
			if(currRate.getCurrencyName().toLowerCase().startsWith(currencyName.toLowerCase()))
			{
				currSearchRate = currRate;
				searchResults.add(currSearchRate); 	
			}
			
			
			
		}*/
		
		return searchResults;
	}

	@Override
	@Cacheable(value = { "currencyCache" })
	public double convertCurrency(String currencyFrom, String currencyTo) {
		// TODO Auto-generated method stub
		System.out.println("Inside convertCurrency");
		List<CurrencyExchangeRate> lstExch = listExchangeRates();
		
		CurrencyExchangeRate currFrom = null;
		
		CurrencyExchangeRate currTo = null;
		
		for(CurrencyExchangeRate currRate:lstExch)
		{
			if(currRate.getCurrencyName().equalsIgnoreCase(currencyFrom))
				currFrom = currRate;
			
			if(currRate.getCurrencyName().equalsIgnoreCase(currencyTo))
				currTo = currRate;
			
		}
		
		double convValue = currFrom.getInverse()/currTo.getInverse();
		
		return convValue;
	}

	

}

