package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Flights.Flight;

public class AirportPageObject extends PageObject {

	@FindBy(css = "#flight-from")
	List<WebElement> originField;

	@FindBy(css = "#flight-to")
	List<WebElement> destinationField;

	@FindBy(css = "div:nth-child(2) > div.autocomplete_items")
	WebElement firstOption;

	@FindBy(css = ".flights-searchbox__form-inputs-group-location .mb-checkbox__mark")
	WebElement undefinedDestinationCheckbox;

	@FindBy(css = "#airplane")
	List<WebElement> swapButton;

	private boolean undefDestination;

	public AirportPageObject(WebDriver driver) {

		super(driver);

		this.undefDestination = false;

	}

	private void setAirport(List<WebElement> field, String city, int indexOfFlight) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		field.get(indexOfFlight).click();
		field.get(indexOfFlight).sendKeys(city);
		wait.until(ExpectedConditions.elementToBeClickable(firstOption));
		firstOption.click();

	}

	public void setOrigin(String city, int indexOfFlight) {

		setAirport(originField, city, indexOfFlight);

	}

	public void setOrigin(String city) {

		setAirport(originField, city, 0);
	}

	public void setDestination(String city, int indexOfFlight) {

		setAirport(destinationField, city, indexOfFlight);
	}

	public void exploreWithoutDestination(boolean b) {

		if (this.undefDestination != b) {
			clickCheckBoxDestination();
			this.undefDestination = b;
		}
	}

	private void clickCheckBoxDestination() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(undefinedDestinationCheckbox));
		undefinedDestinationCheckbox.click();

	}

	public void swapAirports(int indexOfFlight) {

		swapButton.get(indexOfFlight).click();

	}

	public void swapAirports() {

		swapAirports(0);

	}

	public String[] obtainAirportsEntered(Flight f) {
		
		
		String aux;
		String[] auxiliar;
		String[] airports = new String[f.home.QTYOfFlights+1];

	int i=1;
	
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(originField.get(0)));
		
			aux = originField.get(0).getAttribute("value");
	        
			if (aux.contains(",")) {
				auxiliar = aux.split(",");
				aux= auxiliar[0];
		        
			}
			
			airports[0]=aux;

		
		for (WebElement item : destinationField) {
           
			aux = item.getAttribute("value");

			if (aux.contains(",")) {
				auxiliar = aux.split(",");
				aux= auxiliar[0];
			}
			
			airports[i]=aux;
	
			 i++;
		}
		
		return airports;

	}
	
	
	
}
