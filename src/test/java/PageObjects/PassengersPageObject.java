package PageObjects;


import java.time.Duration;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengersPageObject extends PageObject{

	@FindBy(css = "#passengers")
	WebElement passengersField;

	@FindBy(css = "#sub")
	List<WebElement> substractPassengerButton;

	@FindBy(css = "#add")
	List<WebElement> addPassengerButton;

	@FindBy(css = "[data-au='age-child']")
	List<WebElement> children;
	
	@FindBy(css = "am-passengers-dialog button")
	WebElement okButton;

	public enum Age {

		MinorThan2(1), MajorThan2MinorThan11(2), MajorThan11(3);

		private final int number;

		Age(int number) {
			this.number = number;
		}

		public int getValue() {
			return this.number;
		}
	}



	



	private int childQTY;

	public PassengersPageObject(WebDriver driver) {

		super(driver);
		this.childQTY = 0;

	}

	private void addAdult() {

		operation(0, true);

	}

	private void addChild(Age age) {

		operation(2, true);
		this.childQTY++;

		selectChildAge(childQTY, age);

	}

	private void substractAdult() {

		operation(0, false);

	}

	private void substractChild() {

		operation(1, false);
		this.childQTY--;

	}

	private void selectPassengerField() {

		passengersField.click();

	}

	private void clickOK() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(okButton));

		okButton.click();

	}

	private void operation(int index, boolean sum) {

		if (sum) {

			addPassengerButton.get(index).click();
		} else {

			substractPassengerButton.get(index).click();
		}

	}

	private void selectChildAge(int numberOfChildField, Age age) {

		WebElement aux= selectAgeMenu(numberOfChildField);
		selectAge(aux, age);

	}

	private WebElement selectAgeMenu(int number) {
		
	
		
		WebElement aux = children.get(number-1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(aux));
		
		aux.click();

		return aux;

	}

	private void selectAge(WebElement child, Age age) {

		
	Select auxSelect =new Select(child);
		
		auxSelect.selectByIndex(age.getValue());

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

	public void addChildPassenger(Age age){

		selectPassengerField();

		addChild(age);

		clickOK();

	}

	public void addChildPassenger(int qty, Age age[])  {

		selectPassengerField();

		for (int i = 0; i < qty; i++) {

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
		selectChildAge(childNumber, age);
		clickOK();
	}

}
