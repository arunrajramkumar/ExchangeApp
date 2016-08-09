package com.test.common.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement (name = "exchangeRate")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyExchangeRate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement
	private String currencyName;
	@XmlElement
	private double valueForUSD;
	@XmlElement
	private double inverse;
	
	
	/**
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}
	/**
	 * @param currencyName the currencyName to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	/**
	 * @return the valueForUSD
	 */
	public double getValueForUSD() {
		return valueForUSD;
	}
	/**
	 * @param valueForUSD the valueForUSD to set
	 */
	public void setValueForUSD(double valueForUSD) {
		this.valueForUSD = valueForUSD;
	}
	/**
	 * @return the inverse
	 */
	public double getInverse() {
		return inverse;
	}
	/**
	 * @param inverse the inverse to set
	 */
	public void setInverse(double inverse) {
		this.inverse = inverse;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currencyName == null) ? 0 : currencyName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyExchangeRate other = (CurrencyExchangeRate) obj;
		if (currencyName == null) {
			if (other.currencyName != null)
				return false;
		} else if (!currencyName.equals(other.currencyName))
			return false;
		return true;
	}
	
	
}
