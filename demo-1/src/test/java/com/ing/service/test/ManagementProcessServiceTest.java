package com.ing.service.test;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.ApplicationTests;
import com.lastm.bean.RequestFareAndTax;
import com.lastm.bean.ResponseFareAndTax;
import com.lastm.service.ManagementProcessService;

/**
 * 
 * This test for  ManagementProcessService
 * 
 * @author GAbriel Martin
 *
 */
public class ManagementProcessServiceTest  extends ApplicationTests{

	private static Logger log = LogManager.getLogger(ManagementProcessServiceTest.class);

	@Autowired
	private ManagementProcessService service;
	
	
	@Test
	public void responseOK() {
		RequestFareAndTax request1 = generateRequestTest1();
		RequestFareAndTax request2 = generateRequestTest2();
		RequestFareAndTax request3 = generateRequestTest3();
		
		
		ResponseFareAndTax response1 = service.calculateFareAndTax(request1);
		ResponseFareAndTax response2 = service.calculateFareAndTax(request2);
		ResponseFareAndTax response3 = service.calculateFareAndTax(request3);
		
		
		ObjectMapper objMapper = new ObjectMapper();
		String json1 = "";
		String json2 = "";
		String json3 = "";
		try {
			json1 = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response1);
			json2 = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response2);
			json3 = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response3);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		assertTrue("Total Fare error respnse 1 ", response1.getTotal().equals(new Double("29.85")));
		assertTrue("Total Fare error response 2 ", response2.getTotal().equals(new Double("65.15")));
		assertTrue("Total Fare error response 3", response3.getTotal().equals(new Double("74.65")));
		
		assertTrue("Sales Tax error respnse 1 ", response1.getSalesTaxes().equals(new Double("1.5")));
		assertTrue("Sales Tax error response 2 ", response2.getSalesTaxes().equals(new Double("7.65")));
		assertTrue("Sales Tax error response 3", response3.getSalesTaxes().equals(new Double("6.65")));
		
		System.out.println("Respuesta 1 : "+json1);
		System.out.println("Respuesta 2 ; "+json2);
		System.out.println("Respuesta 2 ; "+json3);
	}
	
	
		

	
	
	@Test
	public void responseEmpty() {
		RequestFareAndTax request = new RequestFareAndTax();
		ResponseFareAndTax response = service.calculateFareAndTax(request);
		assertTrue("STATUS ERROR ",response.getStatus().equals("OK"));
		assertTrue("TOTAL FARE ERROR",response.getTotal().equals(new Double(0)));
		assertTrue("SALES TAX ERROR",response.getSalesTaxes().equals(new Double(0)));
	}
	
}