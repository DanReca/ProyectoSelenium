package test;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Flights.Flight;
import Flights.FlightExpectedResults;
import WebDriverFactory.DriverFactory;
import WebDriverFactory.DriverFactory.DriverType;



public class Test4 {
	
	
	
	  Flight f; WebDriver driver;
	  
	  @Before public void before() {
	  
	  driver = DriverFactory.getDriver(DriverType.CHROME);
	  
	  f = new Flight(driver);
	  
	  }
	  
	  @Test public void test() {
	  
	  f.selectOrigin("Londres", 0); f.selectDestination("Brasil", 0);
	  
	  
	  
	  
	  
	  f.selectDepartureDate(207,0);
	  
	  
	  
	  f.selectArrivalDate(208);
	  
	  
	  
	  f.selectClass(PageObjects.ClassPageObject.Classes.Business);
	  
	  f.search();
	
	  
	   Assert.assertTrue(FlightExpectedResults.breadcrumbsMatchesWithFlights(f));
	  
	  
	  }
	  
	  @After public void close() { f.close();
	  
	  }
	 
	  
	  
	  }
	  
	  
	  
	  
	  

	 

