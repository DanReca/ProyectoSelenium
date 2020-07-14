package PageObjects;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;


public abstract class PageObject {

	protected static WebDriver driver;
	
	protected PageObject(WebDriver driver){
		
		PageObject.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
