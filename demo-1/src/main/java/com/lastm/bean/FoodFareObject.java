package com.lastm.bean;

/**
 * Bean of Food Fare Object
 * 
 * @author Gabriel Martin
 *
 */
public class FoodFareObject extends AbstractFareObject{

	public FoodFareObject(String name, Double fare, int number, boolean imported) {
		super(name, fare);
		type = "FOOD";
		tax = new Double(0);
		additionalTax = new Double(5);
		this.number = number;
		isImported = imported;
	}
}
