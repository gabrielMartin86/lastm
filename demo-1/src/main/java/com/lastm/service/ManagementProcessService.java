package com.lastm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lastm.bean.AbstractFareObject;
import com.lastm.bean.RequestFareAndTax;
import com.lastm.bean.RequestFareAndTaxObject;
import com.lastm.bean.ResponseFareAndTax;
import com.lastm.utils.NumberFormatUtils;

/**
 * 
 * This Services has business core
 * 
 * @author Gabriel Martin
 *
 */
@Service
public class ManagementProcessService {

	private static Logger log = LogManager.getLogger(ManagementProcessService.class);
	
	private static String statusOK = "OK";
	private static String statusKO = "KO";
	
	@Autowired
	TransformService transformService;
	@Autowired
	LoadService loadService;
	
	/**
	 * This method do async call for transform the objects
	 * 
	 * @param terms
	 * @return
	 */
	private CompletableFuture<AbstractFareObject> asyncTransformProcess(RequestFareAndTaxObject obj) {

		CompletableFuture<AbstractFareObject> future = CompletableFuture.supplyAsync(new Supplier<AbstractFareObject>() {
			@Override
			public AbstractFareObject get() {
				return transformService.convertRequestToFareObject(obj);
			}
		});

		return future;
	}
	
	/**
	 * This method do async call for Load Tax and Fare
	 * 
	 * @param terms
	 * @return
	 */
	private CompletableFuture<AbstractFareObject> asyncLoadProcess(AbstractFareObject obj) {

		CompletableFuture<AbstractFareObject> future = CompletableFuture.supplyAsync(new Supplier<AbstractFareObject>() {
			@Override
			public AbstractFareObject get() {
				return loadService.loadFareAndTax(obj);
			}
		});

		return future;
	}

	/**
	 * This method do async transform process
	 * 
	 * @param request
	 * @return List <AbstractFareObject>
	 */
	@SuppressWarnings("finally")
	private List <AbstractFareObject> asyncRequestTranformProcess(RequestFareAndTax request) throws InterruptedException,ExecutionException {

		
		List <CompletableFuture<AbstractFareObject>> futureList = new ArrayList<>();
		
		for(RequestFareAndTaxObject obj : request.getObjectList()) {
			CompletableFuture<AbstractFareObject> future = asyncTransformProcess(obj);
			futureList.add(future);
		}
		
		List <AbstractFareObject> abstractFareObj = new ArrayList<>();

		try {
			for(CompletableFuture<AbstractFareObject> ft : futureList) {
				abstractFareObj.add(ft.get());
			}
		} catch (InterruptedException e) {
			log.error("Error during Transform Process" + e);
			e.printStackTrace();
			throw e;
		} catch (ExecutionException e) {
			log.error("Error during Transform Process" + e);
			e.printStackTrace();
			throw e;
		} finally {
			if(!abstractFareObj.isEmpty())
				return abstractFareObj;
			return new ArrayList<>();
		}
	}

	
	/**
	 * This method do async load process
	 * 
	 * @param request
	 * @return List <AbstractFareObject>
	 */
	@SuppressWarnings("finally")
	private List <AbstractFareObject> asyncRequestLoadProcess(List <AbstractFareObject> abstractObjects) throws InterruptedException,ExecutionException {

		
		List <CompletableFuture<AbstractFareObject>> futureList = new ArrayList<>();
		
		for(AbstractFareObject obj : abstractObjects) {
			CompletableFuture<AbstractFareObject> future = asyncLoadProcess(obj);
			futureList.add(future);
		}
		
		List <AbstractFareObject> abstractFareObj = new ArrayList<>();

		try {
			for(CompletableFuture<AbstractFareObject> ft : futureList) {
				abstractFareObj.add(ft.get());
			}
		} catch (InterruptedException e) {
			log.error("Error during Load Process" + e);
			e.printStackTrace();
			throw e;
		} catch (ExecutionException e) {
			log.error("Error during Load Process" + e);
			e.printStackTrace();
			throw e;
		} finally {
			if(!abstractFareObj.isEmpty())
				return abstractFareObj;
			return new ArrayList<>();
		}
	}
	
	private ResponseFareAndTax managementProcess(RequestFareAndTax request) {
		try {
			List<AbstractFareObject> abstractObjs = asyncRequestTranformProcess(request);
			List<AbstractFareObject> result =  asyncRequestLoadProcess(abstractObjs);
			return generateOKResponse(result);
		}
		catch (Exception e) {
			return generateKOResponse();
		}
	}


	private ResponseFareAndTax generateOKResponse(List<AbstractFareObject> abstractObjects) {
		Double totalSales = new Double(0);
		Double totalFare = new Double(0);
		
		for(AbstractFareObject obj : abstractObjects) {
			totalSales = totalSales + obj.getTotalTax();
			totalFare = totalFare + obj.getTotalFare();
		}
		
		ResponseFareAndTax response = new ResponseFareAndTax(convertObjectToString(abstractObjects),NumberFormatUtils.round05(totalFare),NumberFormatUtils.round05(totalSales), statusOK, null);
		return response;
	}
	
	private List<String> convertObjectToString(List<AbstractFareObject> abstractObjects){
		List <String> result = new ArrayList<>();
		for(AbstractFareObject obj : abstractObjects) {
			result.add(obj.getNumber()+" "+obj.getName()+" :"+obj.getTotalFare());
		}
		return result;
		
	}
	
	private ResponseFareAndTax generateKOResponse() {
		
		ResponseFareAndTax response = new ResponseFareAndTax(null,null,null, statusKO, "Error during the fare calculation process");
		return response;
	}
	
	/**
	 * This method start the fare calculation process
	 * 
	 * @param request
	 * @return
	 */
	public ResponseFareAndTax calculateFareAndTax(RequestFareAndTax request) {
		return managementProcess(request);
	}

}