package com.test.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.test.common.model.CurrencyExchangeRate;

@Repository
public class ExchangeDaoImpl implements ExchangeDao{

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<CurrencyExchangeRate> listExchangeRates() {
		// TODO Auto-generated method stub
		List<CurrencyExchangeRate> lst = new ArrayList<CurrencyExchangeRate>();
		      String SQL = "select * from exchange_rate_details";
		      lst = jdbcTemplateObject.query(SQL, 
		                        new CurrencyExchangeRateMapper());
		      System.out.println("list size --> "+lst.size());
		      return lst;
		  
	}

	@Override
	public List<CurrencyExchangeRate> search(String currencyName) {
		// TODO Auto-generated method stub
		List<CurrencyExchangeRate> lst = new ArrayList<CurrencyExchangeRate>();
	      String SQL = "select * from exchange_rate_details where LOWER(currency_Name) like :param ";
	      
	      String finalName= currencyName.toLowerCase().trim() + "%";

	      MapSqlParameterSource namedParams= new MapSqlParameterSource();
	      namedParams.addValue("param", finalName);
	      
	      lst = namedParameterJdbcTemplate.query(SQL, namedParams,
	                        new CurrencyExchangeRateMapper());
	     
	      
	      System.out.println("search list size --> "+lst.size());
	      return lst;
	}

	@Override
	public double convertCurrency(String currencyFrom, String currencyTo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	/**
	 * @return the jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		
		return jdbcTemplateObject;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	      this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	   }
	
	

}

class CurrencyExchangeRateMapper implements RowMapper<CurrencyExchangeRate> {
	   public CurrencyExchangeRate mapRow(ResultSet rs, int rowNum) throws SQLException {
		   CurrencyExchangeRate currExchRate = new CurrencyExchangeRate();
	      currExchRate.setCurrencyName(rs.getString("CURRENCY_NAME"));
	      currExchRate.setValueForUSD(rs.getDouble("VALUE_FOR_USD"));
	     
	      return currExchRate;
	   }
}
