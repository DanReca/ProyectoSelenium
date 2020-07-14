package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ClassPageObject extends PageObject {
	
	
	@FindBy(css = "#classes")
	WebElement classField;
	
	public enum Classes{
		
		Todas("#classes > option:nth-child(1)"),
		Primera("#classes > option:nth-child(2)"),
		Business("#classes > option:nth-child(3)"),
		Premium("#classes > option:nth-child(4)"),
		Turista("#classes > option:nth-child(5)");
		
		 private final String selector;
		 
	    Classes(String selector) {
	        this.selector = selector;
	    }
	 
	    private String getSelector() {
	        return this.selector;
	    }
		
	}

	



	 
	 public ClassPageObject(WebDriver driver ) {
		 
		super(driver);
		
		
		 
	 }
	
	 
	 private void SelectAClass(String typeOfClass) {
		 
		 classField.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(typeOfClass)));
		 this.driver.findElement(By.cssSelector(typeOfClass)).click();
		 
	 }
	 
	 
		public void SelectClass(Classes enumC) {
			
		
			SelectAClass(enumC.getSelector());
			
		}

}
