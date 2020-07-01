package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class AirportPageObject {

	private final String origin ="#flight-from";
	private final String destination = "#flight-to";
	private final String option = "div:nth-child(2) > div.autocomplete_items"; 
private final String undefinedDestination = ".flights-searchbox__form-inputs-group-location .mb-checkbox__mark";
private final String swapButton= "#airplane";	
	 private WebDriver driver;	
	
	 private boolean undefDestination;

 public AirportPageObject(WebDriver driver) {
	 
	 this.driver=driver;
	
	 this.undefDestination= false;
 }
 
 
 private void setAirport (String field, String city, int indexOfFlight) {
	 
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
	 
	 this.driver.findElements(By.cssSelector(field)).get(indexOfFlight).click();
	 this.driver.findElements(By.cssSelector(field)).get(indexOfFlight).sendKeys(city); 
	 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(this.option)));
	 this.driver.findElement(By.cssSelector(this.option)).click(); 
	 
 }
 
 public void setOrigin(String city, int indexOfFlight) {
	 
	 
	 setAirport(this.origin, city, indexOfFlight);
 }
	
 
 public void setDestination( String city, int indexOfFlight) {
	 
	 
	 setAirport( this.destination, city, indexOfFlight);
 }
 
 
 

 
 
 
 public void exploreWithoutDestination(boolean b) {
	 
	 
	 if(this.undefDestination != b) {
		 clickCheckBoxDestination();
		 this.undefDestination = b;
	 }
 }
 
	 private void clickCheckBoxDestination(){
		 
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(undefinedDestination)));
		 this.driver.findElement(By.cssSelector(undefinedDestination)).click();
		 
	 }
	 
	 public void swapAirports(int indexOfFlight) {
		 
		 this.driver.findElements(By.cssSelector(swapButton)).get(indexOfFlight).click();
		 
	 }
 }
 

