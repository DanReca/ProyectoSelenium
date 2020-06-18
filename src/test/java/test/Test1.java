
package test;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Flights.Flight;
import PageObjects.ClassPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	Flight f;
	WebDriver driver;

	@Before
	public void before() {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		f = new Flight(driver);

	}

	@Test
	public void test() {

	f.selectOrigin("Londres");
		f.selectDestination("Brasil");
		f.selectDepartureDate(15);

		f.selectArrivalDate(20);
		f.addAdultPassenger(3);
		f.substractAdultPassenger();
		f.selectClass(ClassPageObject.Classes.Turista);
		f.search();

	}

	@After
	public void close() {

		f.close();
	}

}
