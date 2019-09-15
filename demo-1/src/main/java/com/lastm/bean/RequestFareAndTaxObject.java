package com.lastm.bean;

/**
 * Bean of Request Object
 * 
 * @author Gabriel Martin
 *
 */
public class RequestFareAndTaxObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String type;
	private Double fare;
	private int number;
	private boolean imported;
	
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
	 * @return the imported
	 */
	public boolean isImported() {
		return imported;
	}

	/**
	 * @param imported the imported to set
	 */
	public void setImported(boolean imported) {
		this.imported = imported;
	}
}
