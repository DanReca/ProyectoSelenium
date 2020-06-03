package flight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class {
	

	 private WebDriver driver;
	 private WebDriverWait wait;
	 private String classes;


	 
	 public Class(WebDriver driver, WebDriverWait wait, String classes ) {
		 
		 this.driver=driver;
		 this.wait=wait;
		 this.classes=classes;
		
		 
	 }
	
	 
	 public void SelectAClass(String typeOfClass) {
		 
		 driver.findElement(By.cssSelector(this.classes)).click();
		 this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(typeOfClass)));
		 this.driver.findElement(By.cssSelector(typeOfClass)).click();
		 
	 }
	 

}
