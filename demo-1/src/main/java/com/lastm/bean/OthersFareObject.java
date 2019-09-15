package com.lastm.bean;

/**
 * Bean of Others Fare Object
 * 
 * @author Gabriel Martin
 *
 */
public class OthersFareObject extends AbstractFareObject{

	public OthersFareObject(String name, Double fare, int number, boolean imported) {
		super(name, fare);
		tax = new Double(10);
		additionalTax = new Double(5);
		type = "OTHERS";
		this.number = number;
		isImported = imported;
	}
}
