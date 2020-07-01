package Flights;




import org.openqa.selenium.WebDriver;

import PageObjects.AirportPageObject;
import PageObjects.CalendarPageObject;
import PageObjects.ClassPageObject;
import PageObjects.ClassPageObject.Classes;
import PageObjects.HomePageObject;
import PageObjects.PassengersPageObject;
import PageObjects.PassengersPageObject.Age;





public class Flight {

	private WebDriver driver;

	private PassengersPageObject passenger;
	private CalendarPageObject date;
	private AirportPageObject airport;
	private ClassPageObject classes;
private HomePageObject home;


	public Flight(WebDriver driver) {

		this.driver = driver;

		this.passenger = new PassengersPageObject(driver);
		this.airport = new AirportPageObject(driver);
		this.date = new CalendarPageObject(driver);
		this.classes = new ClassPageObject(driver);
		this.home= new HomePageObject(driver);
		driver.get("https://almundo.com.ar/");
		driver.manage().window().maximize();

	}

	public void selectOrigin(String city, int indexOfFlight) {

		this.airport.setOrigin(city,indexOfFlight);

	}

	public void selectDestination(String city, int indexOfFlight) {

		this.airport.setDestination(city, indexOfFlight);

	}

	public void selectNoDestination(boolean b) {

		this.airport.exploreWithoutDestination(b);

	}

	public void selectDepartureDate(int days, int indexOfFlight) {

		this.date.selectDepartureDate(days, indexOfFlight);

	}

	public void selectArrivalDate(int days) {

		this.date.selectArrivalDate(days);

	}

	public void selectDepartureAndArrivalDate(int daysDeparture, int daysArrival) {

		this.date.selectDepartureAndArrivalDate(daysDeparture, daysArrival);
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


	public void addChildPassenger(Age age) throws InterruptedException {
		this.passenger.addChildPassenger(age);

	}
	
	public void addChildPassenger(int qty, Age [] age) throws InterruptedException {
		
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

	public void swapAirports(int indexOfFlight) {
	
		this.airport.swapAirports(indexOfFlight);
	}
	
	
	public void search() {

		this.home.search();
	}
	
	public void selectRoundTrip() {

	this.home.selectRoundTrip();
	}

	public void selectOneWayTrip() {
	
		this.home.selectOneWayTrip();
	}

	public void selectMultiDestinationTrip() {
		
		this.home.selectMultiDestinationTrip();
	}
	
	

	public void addFlight() {

		this.home.addFlight();
	}
	
	
	
	
	public void close() {

		driver.quit();
	
	}

}
