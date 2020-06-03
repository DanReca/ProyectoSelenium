package flight;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class Airport {

	 private WebDriver driver;	
	 private String origin;
	 private String destination ; 
	 private WebDriverWait wait;
	 private String option; 
	 private boolean undefinedDestination;
	 private String undefDestination;

 public Airport(WebDriver driver, String origin, String destination, WebDriverWait wait, String option, String woDestination) {
	 
	 this.driver=driver;
	 this.origin=origin;
	 this.destination=destination ; 
	 this.wait=wait;
	 this.option=option; 
	 this.undefDestination=woDestination;
	 this.undefinedDestination= false;
 }
 
 
 private void setAirport (String field, String city) {
	 
	 this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	 
	 this.driver.findElement(By.cssSelector(field)).click();
	 this.driver.findElement(By.cssSelector(field)).sendKeys(city); 
	 this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(this.option)));
	 this.driver.findElement(By.cssSelector(this.option)).click(); 
	 
 }
 
 public void setOrigin(String city) {
	 
	 
	 setAirport(this.origin, city);
 }
	
 
 public void setDestination( String city) {
	 
	 
	 setAirport( this.destination, city);
 }
 
 public void exploreWithoutDestination(boolean b) {
	 
	 
	 if(this.undefinedDestination != b) {
		 clickCheckBoxDestinaton();
		 this.undefinedDestination = b;
	 }
 }
 
	 private void clickCheckBoxDestinaton(){
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(undefDestination)));
		 this.driver.findElement(By.cssSelector(undefDestination)).click();
		 
	 }
	 
	 
 }
 

