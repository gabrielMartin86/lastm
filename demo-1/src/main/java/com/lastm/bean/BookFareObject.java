package com.lastm.bean;

/**
 * Bean of Book Fare Object
 * 
 * @author Gabriel Martin
 *
 */
public class BookFareObject extends AbstractFareObject{

	public BookFareObject(String name, Double fare, int number, boolean imported) {
		super(name, fare);
		type = "BOOK";
		tax = new Double(0);
		additionalTax = new Double(5);
		this.number = number;
		isImported = imported;
	}
	
}
