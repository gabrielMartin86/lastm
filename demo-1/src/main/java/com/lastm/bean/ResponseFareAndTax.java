package com.lastm.bean;

import java.util.List;


/**
 * Response with all Fare and Tax information
 * 
 * @author Gabriel Martin
 *
 */
public class ResponseFareAndTax{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private List<String> objectList;
	private Double total;
	private Double salesTaxes;
	private String status;
	private String error;
	
	public ResponseFareAndTax(List<String> objectList, 
								Double total, 
								Double salesTaxes, 
								String status, 
								String error) {
		
		this.objectList = objectList;
		this.total = total;
		this.salesTaxes = salesTaxes;
		this.status = status;
		this.error = error;
	}
	
	/**
	 * @return the objectList
	 */
	public List<String> getObjectList() {
		return objectList;
	}

	/**
	 * @param objectList the objectList to set
	 */
	public void setObjectList(List<String> objectList) {
		this.objectList = objectList;
	}

	/**
	 * @return the salesTaxes
	 */
	public Double getSalesTaxes() {
		return salesTaxes;
	}

	/**
	 * @param salesTaxes the salesTaxes to set
	 */
	public void setSalesTaxes(Double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

}
