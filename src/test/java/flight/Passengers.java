package flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Passengers {

	 private WebDriver driver;
	 private String passengers;
	 private String substract; 
	 private String add;
		/*
		 * private String minorAge; private String minorThanTwo; private String
		 * majTTwoMinTEleven; private String majorThanEleven;
		 */ 
	 private String okButton; 
	
	
	public Passengers(WebDriver driver, String passengers, String substract, String add, String okButton) {
		
	this.driver=driver;	
    this.passengers=passengers;
	this.substract=substract; 
	this.add=add;
	/*
	 * this.minorAge=minorAge; this.minorThanTwo=minorThanTwo;
	 * this.majTTwoMinTEleven=majTTwoMinTEleven;
	 * this.majorThanEleven=majorThanEleven;
	 */
	this.okButton=okButton; 
	}
	
	
	
	public void addMajor() {
		
		
		operation(0,true);
	}
	
	
	

	
	
	
	
	public void addMinor() { 
		
		
		operation(2,true);
	}
	

	

	public void substractMajor(){
		
		
		operation(0,false);
	}
	
	public void substractMinor(){
		
		
		operation(1,false);
	}
	
	
	
	private void operation(int index, boolean sum)  {
		this.driver.findElement(By.cssSelector(this.passengers)).click();
		
		if(sum) {	
			
			this.driver.findElements(By.cssSelector(this.add)).get(index).click();
			} else {
			
				this.driver.findElements(By.cssSelector(this.substract)).get(index).click();
		}
		
		this.driver.findElement(By.cssSelector(this.okButton)).click();
	}
	
}
