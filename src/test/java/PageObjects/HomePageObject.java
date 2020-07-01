package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {

	private final static String searchButton = ".flights-searchbox__form-flight-data button > span";
	private final static String radioButtons = "span.mb-radio__mark";
	private final static String addFlightButton = "#aggregate";

	private static boolean roundTrip;
	private boolean oneWayTrip;
	private boolean multiDestinationTrip;
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {

		this.driver = driver;
		setRoundTrip(true);
		this.oneWayTrip = false;
		this.multiDestinationTrip = false;

	}

	public void search() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchButton)));
		driver.findElement(By.cssSelector(searchButton)).click();
	}

	public void selectRoundTrip() {

		if (!isRoundTrip()) {
			driver.findElements(By.cssSelector(radioButtons)).get(0).click();
			setRoundTrip(true);
			this.oneWayTrip = false;
			this.multiDestinationTrip = false;
		}
	}

	public void selectOneWayTrip() {
		if (!this.oneWayTrip) {
			driver.findElements(By.cssSelector(radioButtons)).get(1).click();
			setRoundTrip(false);
			this.oneWayTrip = true;
			this.multiDestinationTrip = false;
		}
	}

	public void selectMultiDestinationTrip() {
		if (!this.multiDestinationTrip) {
			driver.findElements(By.cssSelector(radioButtons)).get(2).click();
		
			setRoundTrip(false);
			this.oneWayTrip = false;
			this.multiDestinationTrip = true;
		}
	}
	
	

	public void addFlight() {

		driver.findElement(By.cssSelector(addFlightButton)).click();
	}

	public static boolean isRoundTrip() {
		return roundTrip;
	}

	private static void setRoundTrip(boolean roundTrip) {
		HomePageObject.roundTrip = roundTrip;
	}
}
