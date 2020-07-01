
  package test;
  
  
  
  
  
  import org.junit.After; import org.junit.Before; import org.junit.Test;
  import org.openqa.selenium.JavascriptExecutor; import
  org.openqa.selenium.Point; import org.openqa.selenium.WebDriver; import
  org.openqa.selenium.chrome.ChromeDriver;
  
  import Flights.Flight; import PageObjects.PassengersPageObject.Age; import
  io.github.bonigarcia.wdm.WebDriverManager;
  
  public class Test0 {
  
  Flight f; WebDriver driver;
  
  @Before public void before() {
  
  
  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
  
  f = new Flight(driver);
  
  
  }
  
  @Test public void test() throws InterruptedException {
  
  f.selectOrigin("Londres",0); f.selectDestination("Brasil",0);
  f.swapAirports(0); f.selectDepartureDate(15,0);
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  f.addChildPassenger(Age.MajorThan2MinorThan11);
  f.addChildPassenger(Age.MajorThan2MinorThan11); f.selectArrivalDate(20); ;
  f.selectClass(PageObjects.ClassPageObject.Classes.Business); f.search();
  
  }
  
  @After public void close() {
  f.close();
	 
  }
  
  }
 
 
 