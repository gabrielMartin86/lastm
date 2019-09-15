package com.lastm.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import com.lastm.bean.AbstractFareObject;
import com.lastm.utils.NumberFormatUtils;

/**
 * 
 * This Service Load tax and fare
 * 
 * @author Gabriel Martin
 *
 */
@Service
public class LoadService {

	private static Logger log = LogManager.getLogger(LoadService.class);



	/**
	 * This method Load tax and fare of AbstractFareObject
	 * 
	 * @param terms
	 * @return
	 */
	public AbstractFareObject loadFareAndTax(AbstractFareObject obj) {
		
		log.info("Load process start, Object: "+obj.getName()+", type:"+obj.getType()+"and with fare:"+obj.getFare());
		calculateTaxValue(obj);
		calculateAdditionalTaxValue(obj);
		calculateTotalTax(obj);
		calculateTotalFare(obj);
		return obj;
	}
	
	private void calculateTaxValue(AbstractFareObject obj) {
		if(obj.getTax() != null && obj.getTax() != 0) {
			Double taxDouble = new Double(obj.getTax()/100);
			Double result = new Double(obj.getFare() * taxDouble);
			obj.setTaxValue(result);
		}
		else {
			obj.setTaxValue(new Double(0));
		}
	}
	
	private void calculateAdditionalTaxValue(AbstractFareObject obj) {
		if(obj.getAdditionalTax() != null && obj.getAdditionalTax() != 0 && obj.isImported()) {
			Double taxDouble = new Double(obj.getAdditionalTax()/100);
			Double result = new Double(obj.getFare() * taxDouble);
			obj.setAdditionalValue(result);
		}
		else {
			obj.setAdditionalValue(new Double(0));
		}
	}
	
	private void calculateTotalTax(AbstractFareObject obj) {
		Double d = new Double((obj.getTaxValue()+obj.getAdditionalTaxValue())* obj.getNumber());
		obj.setTotalTax(NumberFormatUtils.round05(d));
	}
	
	private void calculateTotalFare(AbstractFareObject obj) {
		Double d = new Double(obj.getTotalTax()+(obj.getFare()*obj.getNumber()));
		obj.setTotalFare(NumberFormatUtils.round05(d));
	}
}