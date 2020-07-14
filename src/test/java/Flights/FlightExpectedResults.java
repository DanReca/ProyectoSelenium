package Flights;

import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.PageObject;

public class FlightExpectedResults extends PageObject {

	@FindBy(css = "#breadcrum > mb-breadcrumbs > div")
	static WebElement selectedFlights;
	
	@FindBy(css ="mb-alert")
	static WebElement notFlightsAvailable;
	

	public FlightExpectedResults(WebDriver driver) {

		super(driver);

	}

	

	
	
	
	public static boolean breadcrumbsMatchesWithFlights(Flight f) {

		boolean bool = false;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(selectedFlights, "Home"));

		String txtObtained = selectedFlights.getText();
		String[] txtExpected = { "Home", "Vuelos", "de", "a" };
		String[] airports = f.airport.obtainAirportsEntered(f);

		if (txtObtained.contains(txtExpected[0]) && txtObtained.contains(txtExpected[1])
				&& txtObtained.contains(txtExpected[2]) && txtObtained.contains(txtExpected[3])) {

			for (int i = 0; i < airports.length; i++) {

				if (txtObtained.contains(airports[i])) {

					bool = true;

				} else {

					bool = false;
					break;
				}

			}

		}

		return bool;

	}
	
	
	public static boolean notificationIsShown() {
		
	
		String aux= notFlightsAvailable.getText();
		return aux.contains("No tenemos vuelos disponibles");
		
	}

}
