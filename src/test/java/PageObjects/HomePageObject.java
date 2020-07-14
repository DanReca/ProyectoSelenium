package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends PageObject {

	@FindBy(css=".flights-searchbox__form-flight-data button > span")
	WebElement searchButton;
	
	@FindBy(css = "[data-au='addTravelDetail'] mb-icon")
	List <WebElement> addFlightButton;
	
	@FindBy(css = "span.mb-radio__mark")
	List <WebElement> typeOfFlightRadioButtons ;
	
	@FindBy(css = "div.flights-searchbox__form-multiple-actions > div:nth-child(1)")
	WebElement removeFlight;

	private static boolean roundTrip;
	private boolean oneWayTrip;
	private boolean multiDestinationTrip;
public int QTYOfFlights;

	public HomePageObject(WebDriver driver) {

		super(driver);
		setRoundTrip(true);
		this.oneWayTrip = false;
		this.multiDestinationTrip = false;
		this.QTYOfFlights=1;

	}

	public void search() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}

	public void selectRoundTrip() {

		if (!isRoundTrip()) {
			typeOfFlightRadioButtons.get(0).click();
			setRoundTrip(true);
			this.oneWayTrip = false;
			this.multiDestinationTrip = false;
		}
	}

	public void selectOneWayTrip() {
		if (!this.oneWayTrip) {
			typeOfFlightRadioButtons.get(1).click();
			setRoundTrip(false);
			this.oneWayTrip = true;
			this.multiDestinationTrip = false;
		}
	}

	public void selectMultiDestinationTrip() {
		if (!this.multiDestinationTrip) {
			typeOfFlightRadioButtons.get(2).click();
		
			setRoundTrip(false);
			this.oneWayTrip = false;
			this.multiDestinationTrip = true;
		}
	}
	
	

	public void addFlight() {
		
	
		
		for(WebElement icon : addFlightButton ) {
			
			
			if(icon.isDisplayed()) {
				
				
				icon.click();
			
				break;
			}
			
		}
		
		this.QTYOfFlights++;
		
	}
	
	public void removeFlight() {
		 
		 removeFlight.click();
		 this.QTYOfFlights--;
		 
	 }
	public static boolean isRoundTrip() {
		return roundTrip;
	}

	private static void setRoundTrip(boolean roundTrip) {
		HomePageObject.roundTrip = roundTrip;
	}
}
