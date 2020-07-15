

package test;


import Flights.Flight;
import Flights.FlightExpectedResults;
import WebDriverFactory.DriverFactory;
import WebDriverFactory.DriverFactory.DriverType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;






  public class Test0 {
  
  
  
  Flight f; WebDriver driver;
  
  @Before public void before() {
  
  driver = DriverFactory.getDriver(DriverType.CHROME);
  
  f = new Flight(driver);
  
  }
  
  @Test public void test() { f.selectMultiDestinationTrip();
  f.selectOrigin("Londres", 0); f.selectDestination("Brasil", 0);
  
  f.addFlight();
  
  f.swapAirports(0); f.selectDepartureDate(21, 0);
  
  f.selectOrigin("Buzios", 1); f.selectDestination("Buenos aires", 1);
  
  f.selectDepartureDate(25, 1);
  
  f.addFlight();
  
  f.selectOrigin("Berlin", 2); f.selectDestination("Frank", 2);
  
  f.addFlight();
  
  f.selectOrigin("Nueva", 3); f.selectDestination("pap", 3);
  
  f.addFlight();
  
  f.selectOrigin("lar", 4); f.selectDestination("tan", 4);
  
  // f.addFlight();
  
  // f.selectOrigin("aus",5); f.selectDestination("vien",5);
  
  f.selectClass(PageObjects.ClassPageObject.Classes.Business);
  
  f.search();
  
  
  Assert.assertTrue(FlightExpectedResults.notificationIsShown());
  
   Assert.assertTrue(FlightExpectedResults.breadcrumbsMatchesWithFlights(f));
  }
  
  
  
  
  
  @After public void close() { f.close();}
  
  
  }
  