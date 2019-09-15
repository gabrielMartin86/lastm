package com.lastm.bean;

/**
 * Bean of Abstract Fare Object
 * 
 * @author Gabriel Martin
 *
 */
public class AbstractFareObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String name;
	protected String type;
	protected Double fare;
	private Double totalFare;
	protected Double tax;
	protected Double taxValue;
	protected Double additionalTax;
	protected Double additionalTaxValue;
	private Double totalTax;
	protected int number;
	protected boolean isImported;
	
	public AbstractFareObject(String name, Double fare) {
		this.name = name;
		this.fare = fare;
	}
	
	public AbstractFareObject(String name, Double fare, String type) {
		this.name = name;
		this.fare = fare;
		this.type = type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the fare
	 */
	public Double getFare() {
		return fare;
	}
	
	/**
	 * @param fare the fare to set
	 */
	public void setFare(Double fare) {
		this.fare = fare;
	}

	/**
	 * @return the totalFare
	 */
	public Double getTotalFare() {
		return totalFare;
	}

	/**
	 * @param totalFare the totalFare to set
	 */
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	/**
	 * @return the tax
	 */
	public Double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Double tax) {
		this.tax = tax;
	}

	/**
	 * @return the totalTax
	 */
	public Double getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the additionalTax
	 */
	public Double getAdditionalTax() {
		return additionalTax;
	}

	/**
	 * @param additionalTax the additionalTax to set
	 */
	public void setAdditionalTax(Double additionalTax) {
		this.additionalTax = additionalTax;
	}

	/**
	 * @return the additionalVAlue
	 */
	public Double getAdditionalTaxValue() {
		return additionalTaxValue;
	}

	/**
	 * @param additionalValue the additionalVAlue to set
	 */
	public void setAdditionalValue(Double additionalValue) {
		this.additionalTaxValue = additionalValue;
	}

	/**
	 * @return the taxValue
	 */
	public Double getTaxValue() {
		return taxValue;
	}

	/**
	 * @param taxValue the taxValue to set
	 */
	public void setTaxValue(Double taxValue) {
		this.taxValue = taxValue;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the isImported
	 */
	public boolean isImported() {
		return isImported;
	}

	/**
	 * @param isImported the isImported to set
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
}
