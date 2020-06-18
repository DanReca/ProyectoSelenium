package Flights;




import org.openqa.selenium.WebDriver;


import PageObjects.AirportPageObject;
import PageObjects.CalendarPageObject;
import PageObjects.ClassPageObject;
import PageObjects.ClassPageObject.Classes;
import PageObjects.PassengersPageObject;
import PageObjects.PassengersPageObject.Age;
import PageObjects.SearchPageObject;


public class Flight {

	private WebDriver driver;

	private PassengersPageObject passenger;
	private CalendarPageObject date;
	private AirportPageObject airport;
	private ClassPageObject classes;
private SearchPageObject search;


	public Flight(WebDriver driver) {

		this.driver = driver;

		this.passenger = new PassengersPageObject(driver);
		this.airport = new AirportPageObject(driver);
		this.date = new CalendarPageObject(driver);
		this.classes = new ClassPageObject(driver);
		this.search= new SearchPageObject(driver);
		driver.get("https://almundo.com.ar/");
		driver.manage().window().maximize();

	}

	public void selectOrigin(String city) {

		this.airport.setOrigin(city);

	}

	public void selectDestination(String city) {

		this.airport.setDestination(city);

	}

	public void selectNoDestination(boolean b) {

		this.airport.exploreWithoutDestination(b);

	}

	public void selectDepartureDate(int days) {

		this.date.selectDepartureDate(days);

	}

	public void selectArrivalDate(int days) {

		this.date.selectArrivalDate(days);

	}

	public void selectDepartureAndArrivalDate(int daysDeparture, int daysArrival) {

		selectDepartureDate(daysDeparture);
		selectArrivalDate(daysArrival);
	}

	public void selectNoDate(boolean b) {

		this.date.exploreWithoutDate(b);

	}

	public void selectClass(Classes enumC) {

		this.classes.SelectClass(enumC);

	}

	public void addAdultPassenger() {
		this.passenger.addAdultPassenger();
	}

	public void addAdultPassenger(int qty) {
		
		this.passenger.addAdultPassenger(qty);
	}

	public void substractAdultPassenger() {
		this.passenger.substractAdultPassenger();
	}

	public void substractAdultPassenger(int qty) {

		this.passenger.substractAdultPassenger(qty);
	}


	public void addChildPassenger(Age age) {
		this.passenger.addChildPassenger(age);

	}
	
	public void addChildPassenger(int qty, Age [] age) {
		
		this.passenger.addChildPassenger(qty, age);

	}

	public void substractChildPassenger() {
		this.passenger.substractChildPassenger();
	}

	public void substractChildPassenger(int qty) {

		this.passenger.substractChildPassenger(qty);
	}

	/**
	 * 
	 * @param childNumber
	 * @param age
	 */
	public void modifyChildAge(int childNumber, Age age) {
		this.passenger.modifyChildAge(childNumber, age);
	}

	
	
	public void search() {

		this.search.search();
	}
	
	
	public void close() {

		driver.quit();
	
	}

}
