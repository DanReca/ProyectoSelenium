package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageObject {



		private final static String searchButton = ".flights-searchbox__form-flight-data button > span";
		private WebDriver driver;

		public SearchPageObject(WebDriver driver) {
			
			this.driver=driver;
			
		}
		
		public void search() {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchButton)));
			driver.findElement(By.cssSelector(searchButton)).click();
		}

	

}
