package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PassengersPageObject {

	public enum Age {

		MinorThan2(0), MajorThan2MinorThan11(1), MajorThan11(2);

		private final int number;

		Age(int number) {
			this.number = number;
		}

		public int getValue() {
			return this.number;
		}
	}

	private final String passengers = "#passengers";
	private final String substract = "#sub";
	private final String add = "#add";
	private final String minorAge1 = "#child-0";
	private final String minorAge2 = "#child-1";
	private final String minorAge3 = "#child-2";
	private final String minorAge4 = "#child-3";
	private final String minorAge5 = "#child-4";
	private final String minorAge6 = "#child-5";
	private final String minorAge7 = "#child-6";
	private final String minorAge8 = "#child-7";
	private final String minorThanTwo = " > option:nth-child(2)";
	private final String majTwoMinEleven = " > option:nth-child(3)";
	private final String majorThanEleven = " > option:nth-child(4)";
	private final String okButton = "am-passengers-dialog button";
	private final String minorAge = "div:nth-of-type(3) .selector__content div";

	private WebDriver driver;

	private int childQTY;

	public PassengersPageObject(WebDriver driver) {

		this.driver = driver;
		this.childQTY = 0;

	}

	private void addAdult() {

		operation(0, true);

	}

	private void addChild(Age age) n {

		operation(2, true);
		this.childQTY++;
		
	System.out.println(childQTY);
	

				selectChildAge(childQTY, age.getValue());
		
		
		
		
	}

	private void substractAdult() {

		operation(0, false);

	}

	private void substractChild() {

		operation(1, false);
		this.childQTY--;

	}

	private void selectPassengerField() {

		this.driver.findElement(By.cssSelector(this.passengers)).click();

	}

	private void clickOK() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(okButton)));
		
		this.driver.findElement(By.cssSelector(this.okButton)).click();

	}

	private void operation(int index, boolean sum) {

		if (sum) {

			this.driver.findElements(By.cssSelector(this.add)).get(index).click();
		} else {

			this.driver.findElements(By.cssSelector(this.substract)).get(index).click();
		}

	}

	private void selectChildAge(int numberOfChildField, int age) {
		
	
	
		String aux;

			aux = selectAgeMenu(numberOfChildField);
			selectAge(aux, age);
	

	}

	private String selectAgeMenu(int number) {

		String minorAge = "";

		switch (number) {

		case 1:
			minorAge = this.minorAge1;
			break;

		case 2:
			minorAge = this.minorAge2;
			
			break;

		case 3:
			minorAge = this.minorAge3;
		
			break;

		case 4:
			minorAge = this.minorAge4;
			
			break;

		case 5:
			minorAge = this.minorAge5;
			
			break;

		case 6:
			minorAge = this.minorAge6;
			
			break;

		case 7:
			minorAge = this.minorAge7;
			
			break;

		case 8:
			minorAge = this.minorAge8;
			
			break;

		}

		this.driver.findElement(By.cssSelector(minorAge)).click();

		return minorAge;
	}

	private void selectAge(String field, int age) {

		String selector = "";
		switch (age) {

		case 0:
			selector = field + this.minorThanTwo;
		
			break;

		case 1:
			selector = field + this.majTwoMinEleven;
		
			break;

		case 2:
			selector = field + this.majorThanEleven;
		
			break;

		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
	
		this.driver.findElement(By.cssSelector(selector)).click();
		this.driver.findElement(By.cssSelector("#cdk-overlay-0")).click();
		

	}

	public void addAdultPassenger() {
		selectPassengerField();
		addAdult();
		clickOK();
	}

	public void addAdultPassenger(int qty) {

		selectPassengerField();

		for (int i = 0; i < qty; i++) {
			addAdult();
		}

		clickOK();
	}

	public void substractAdultPassenger() {
		selectPassengerField();
		substractAdult();
		clickOK();
	}

	public void substractAdultPassenger(int qty) {
		selectPassengerField();
		for (int i = 0; i < qty; i++) {
			substractAdult();
			clickOK();

		}
	}

	public void addChildPassenger(Age age) throws InterruptedException {

		selectPassengerField();

		addChild(age);

		clickOK();

	}
	
	
	public void addChildPassenger(int qty, Age age []) throws InterruptedException {

		selectPassengerField();

		for(int i=0; i<qty;i++) {
			
		addChild(age[i]);
		
		}
		clickOK();

	}
	

	public void substractChildPassenger() {
		selectPassengerField();

		substractChild();

		clickOK();
	}

	public void substractChildPassenger(int qty) {

		selectPassengerField();

		for (int i = 0; i < qty; i++) {

			substractChild();

		}

		clickOK();
	}
	
	
	public void modifyChildAge(int childNumber, Age age) {
		selectPassengerField();
		selectChildAge(childNumber,age.getValue());
		clickOK();
	}

	

}
