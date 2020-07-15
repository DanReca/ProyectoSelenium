
  package test; import static org.junit.Assert.assertTrue; import
  org.junit.After; import org.junit.Assert; import org.junit.Before; import
  org.junit.Test; import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.chrome.ChromeDriver;
  
  import Flights.Flight; import Flights.FlightExpectedResults; import
  io.github.bonigarcia.wdm.WebDriverManager;
  
  public class Test2 {
  
  Flight f; WebDriver driver;
  
  @Before public void before() {
  
  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
  
  f = new Flight(driver);
  
  }
  
  @Test public void test() {
  
  f.selectOneWayTrip(); f.selectOrigin("Londres", 0);
  f.selectDestination("Brasil", 0);
  
  f.selectDepartureDate(234, 0);
  
  f.addAdultPassenger(3); f.substractAdultPassenger();
  f.selectClass(PageObjects.ClassPageObject.Classes.Turista); f.search();
  Assert.assertTrue(FlightExpectedResults.breadcrumbsMatchesWithFlights(f)); }
  
  @After public void close() { f.close(); }
  
  
  }
 
