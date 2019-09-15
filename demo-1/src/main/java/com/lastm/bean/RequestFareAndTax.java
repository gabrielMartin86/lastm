package com.lastm.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Bean of Request Object
 * 
 * @author Gabriel Martin
 *
 */
public class RequestFareAndTax{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private List<RequestFareAndTaxObject> objectList;

	/**
	 * @return the objectList
	 */
	public List<RequestFareAndTaxObject> getObjectList() {
		if(objectList == null)
			objectList = new ArrayList<RequestFareAndTaxObject>();
		return objectList;
	}

	/**
	 * @param objectList the objectList to set
	 */
	public void setObjectList(List<RequestFareAndTaxObject> objectList) {
		this.objectList = objectList;
	}

}
