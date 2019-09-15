package com.ing;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lastm.ApplicationBootStarter;
import com.lastm.bean.RequestFareAndTax;
import com.lastm.bean.RequestFareAndTaxObject;

/**
 * Application Tester Starter
 * 
 * @author Gabriel
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootStarter.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Test
	public void initTest() {
		assertTrue(true);
	}
	
	protected RequestFareAndTax generateRequestTest1() {
		RequestFareAndTax rq = new RequestFareAndTax();
		
		RequestFareAndTaxObject obj1 = new RequestFareAndTaxObject();
		obj1.setFare(new Double("12.49"));
		obj1.setName("Book");
		obj1.setType("BOOK");
		obj1.setNumber(1);
		obj1.setImported(false);
		
		RequestFareAndTaxObject obj2 = new RequestFareAndTaxObject();
		obj2.setFare(new Double("14.99"));
		obj2.setName("Music CD");
		obj2.setType("MUSIC");
		obj2.setNumber(1);
		obj2.setImported(false);
		
		RequestFareAndTaxObject obj3 = new RequestFareAndTaxObject();
		obj3.setFare(new Double("0.85"));
		obj3.setName("Chocolate bar");
		obj3.setType("FOOD");
		obj3.setNumber(1);
		obj3.setImported(false);
		
		
		rq.getObjectList().add(obj1);
		rq.getObjectList().add(obj2);
		rq.getObjectList().add(obj3);
		
		return rq;
	}
	
	protected RequestFareAndTax generateRequestTest2() {
		RequestFareAndTax rq = new RequestFareAndTax();
		
		RequestFareAndTaxObject obj1 = new RequestFareAndTaxObject();
		obj1.setFare(new Double("10"));
		obj1.setName("Imported Box of chocolates");
		obj1.setType("FOOD");
		obj1.setNumber(1);
		obj1.setImported(true);
		
		RequestFareAndTaxObject obj2 = new RequestFareAndTaxObject();
		obj2.setFare(new Double("47.50"));
		obj2.setName("Imported bottle of perfume");
		obj2.setType("PERFUME");
		obj2.setNumber(1);
		obj2.setImported(true);
		
		rq.getObjectList().add(obj1);
		rq.getObjectList().add(obj2);
		
		return rq;
	}
	
	protected RequestFareAndTax generateRequestTest3() {
		RequestFareAndTax rq = new RequestFareAndTax();
		
		RequestFareAndTaxObject obj1 = new RequestFareAndTaxObject();
		obj1.setFare(new Double("27.99"));
		obj1.setName("Imported bottle of perfume");
		obj1.setType("PERFUME");
		obj1.setNumber(1);
		obj1.setImported(true);
		
		RequestFareAndTaxObject obj2 = new RequestFareAndTaxObject();
		obj2.setFare(new Double("18.99"));
		obj2.setName("bottle of perfume");
		obj2.setType("PERFUME");
		obj2.setNumber(1);
		
		RequestFareAndTaxObject obj3 = new RequestFareAndTaxObject();
		obj3.setFare(new Double("9.75"));
		obj3.setName("packet of headeche pills");
		obj3.setType("MEDICAL");
		obj3.setNumber(1);
		
		RequestFareAndTaxObject obj4 = new RequestFareAndTaxObject();
		obj4.setFare(new Double("11.25"));
		obj4.setName("Box of chocolates imported chocolate");
		obj4.setType("FOOD");
		obj4.setNumber(1);
		obj4.setImported(true);
		
		
		rq.getObjectList().add(obj1);
		rq.getObjectList().add(obj2);
		rq.getObjectList().add(obj3);
		rq.getObjectList().add(obj4);
		
		return rq;
	}

}
