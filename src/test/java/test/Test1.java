
  
  
  package test;
  
  import org.junit.After; import org.junit.Assert; import org.junit.Before;
  import org.junit.Test; import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.chrome.ChromeDriver;
  
  import Flights.Flight; import Flights.FlightExpectedResults; import
  io.github.bonigarcia.wdm.WebDriverManager;
  
  public class Test1 {
  
  
  
  Flight f; WebDriver driver;
  
  @Before public void before() {
  
  
  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
  
  f = new Flight(driver);
  
  }
  
  @Test public void test() {
  
  f.selectOrigin("Londres",0); f.selectDestination("Brasil",0);
  f.selectOneWayTrip(); f.selectNoDate(true); f.search();
  
  
  Assert.assertTrue(FlightExpectedResults.breadcrumbsMatchesWithFlights(f));
  
  }
  
  
  @After public void close() { f.close(); }
  
  
  
  }
 
  
 