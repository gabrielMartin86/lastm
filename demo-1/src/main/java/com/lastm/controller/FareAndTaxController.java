package com.lastm.controller;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lastm.bean.RequestFareAndTax;
import com.lastm.bean.ResponseFareAndTax;
import com.lastm.service.ManagementProcessService;

/**
 * This is the controller class to management the request.
 * 
 * @author Gabriel Martin
 *
 */
@RestController
public class FareAndTaxController {

	private static Logger log = LogManager.getLogger(FareAndTaxController.class);
	
	@Autowired
	private ManagementProcessService service;

	@PostMapping("/fare/calculateFare")
	public @ResponseBody Callable<ResponseFareAndTax> calculateFarePost(@RequestBody RequestFareAndTax request) {
		log.info("POST: Controller recieved new request");
		// Configure timeout with this property
		//spring.mvc.async.request-timeout
		return new Callable<ResponseFareAndTax>() {
			@Override
			public ResponseFareAndTax call() throws Exception {
				return service.calculateFareAndTax(request);
			}
		};
	}

	@GetMapping("/fare/calculateFare")
	public @ResponseBody Callable<ResponseFareAndTax> calculateFareGet(@RequestBody RequestFareAndTax request) {

		log.info("GET: Controller recieved new request");
		
		// Configure timeout with this property
		// spring.mvc.async.request-timeout
		return new Callable<ResponseFareAndTax>() {
			@Override
			public ResponseFareAndTax call() throws Exception {
				return service.calculateFareAndTax(request);
			}
		};
	}

	@RequestMapping("/fare/calculateFareWithOutTimeout")
	public @ResponseBody ResponseFareAndTax calculateFareWithOutTimeout(@RequestBody RequestFareAndTax request) {
		return service.calculateFareAndTax(request);
	}
	
	
	@GetMapping("/fare/calculateFareTest")
	public String searchAll(@RequestParam(name = "text", required = true) String text) {
		log.info("Test: New Get Request with parameter text="+text);
		return text;
	}
}
