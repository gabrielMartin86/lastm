package com.lastm.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import com.lastm.bean.AbstractFareObject;
import com.lastm.bean.BookFareObject;
import com.lastm.bean.FoodFareObject;
import com.lastm.bean.MedicalFareObject;
import com.lastm.bean.OthersFareObject;
import com.lastm.bean.RequestFareAndTaxObject;

/**
 * 
 * This Service transform the request to Bussines Bean
 * 
 * @author Gabriel Martin
 *
 */
@Service
public class TransformService {

	private static Logger log = LogManager.getLogger(TransformService.class);



	/**
	 * This method transform the request to business object
	 * 
	 * @param terms
	 * @return
	 */
	public AbstractFareObject convertRequestToFareObject(RequestFareAndTaxObject requestObj) {
		
		log.info("Convert Request Object: "+requestObj.getName()+", type:"+requestObj.getType()+"and with fare:"+requestObj.getFare());
		
		String type = requestObj.getType();
		switch (type) {
			case TransformServiceConstants.FOOD:
				return new FoodFareObject(requestObj.getName(),requestObj.getFare(), requestObj.getNumber(), requestObj.isImported());
			case TransformServiceConstants.BOOK:
				return new BookFareObject(requestObj.getName(),requestObj.getFare(), requestObj.getNumber(), requestObj.isImported());
			case TransformServiceConstants.MEDICAL:
				return new MedicalFareObject(requestObj.getName(),requestObj.getFare(), requestObj.getNumber(), requestObj.isImported());
		}
		
		return new OthersFareObject(requestObj.getName(),requestObj.getFare(), requestObj.getNumber(), requestObj.isImported());
	}
}