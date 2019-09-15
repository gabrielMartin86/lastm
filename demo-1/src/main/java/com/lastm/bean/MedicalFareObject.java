package com.lastm.bean;

/**
 * Bean of Medical Fare Object
 * 
 * @author Gabriel Martin
 *
 */
public class MedicalFareObject extends AbstractFareObject{

	public MedicalFareObject(String name, Double fare, int number, boolean imported) {
		super(name, fare);
		type = "MEDICAL";
		tax = new Double(0);
		additionalTax= new Double(5);
		this.number = number;
		isImported = imported;
	}
}
