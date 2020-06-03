package homePage;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import flight.Airport;
import flight.Class;
import flight.Date;
import flight.Passengers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage{
	
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

	private static WebDriver driver;
    private static WebDriverWait wait;
    private Passengers passenger;
    private Date date;
    private Airport airport;
    private Class classes;
    
    
  //Pick Airport
  	private final String origin ="#flight-from";
  	private final String destination = "#flight-to";
  	private final String options = "div:nth-child(2) > div.autocomplete_items"; 
    private final String undefDestination = ".flights-searchbox__form-inputs-group-location .mb-checkbox__mark";
  	
  	
  	//Calendar
    private final String buttonNext = "mb-range-month-view .mb-calendar-header__next";
    private final String buttonPrev="mb-range-month-view .mb-calendar-header__prev";
    private final String departure="#departure-date";
    private final String cssHeader= "mb-range-month-view .mb-calendar-header__title";
    private final String fullMonthButtons =".calendar-range-view__page:nth-of-type(1) .mb-calendar-body__btn";
    private final String arrival="#arrival-date";
    private final String undefDate = ".flights-searchbox__form-inputs-group-date .mb-checkbox__mark";
  	
  	
  	//Passengers
  	
    private final String pass = "#passengers";
    private final String substract = "#sub";
    private final String add = "#add";
	/*
	 * private final String minorAge =
	 * ".last.ng-star-inserted .mb-form-field__icon"; private final String
	 * minorThanTwo = "#child-0 > option:nth-child(2)"; private final String
	 * majTTwoMinTEeleven = "#child-0 > option:nth-child(3)"; private final String
	 * majorThanEleven = "#child-0 > option:nth-child(4)";
	 */
    private final String okButton = "am-passengers-dialog button";
  	
   //Classes
    
   private final String classField = "#classes";
  



//Search
    private final String searchButton = ".flights-searchbox__form-flight-data button > span";
    
	public HomePage() {
		
         setUp();
         this.passenger = new Passengers (driver,pass,substract,add,okButton);
         this.airport = new Airport (driver,origin,destination,wait,options,undefDestination);
         this.date = new Date(driver,buttonNext,buttonPrev,departure,cssHeader,fullMonthButtons,arrival,undefDate,wait);
         this.classes= new Class (driver,wait,classField);
         driver.get("https://almundo.com.ar/");

	}	
	
		
	
	private static void setUp () {

		if(driver==null ) {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        }
		 
		if(wait==null) {
	
			wait= new WebDriverWait(driver, Duration.ofSeconds(30));
	 
		}	
		
	}
	
	
	
	public void selectOrigin(String city) {
		
		this.airport.setOrigin(city);
			
	}
	
	
	public void selectDestination(String city) {
		
		this.airport.setDestination(city);
			
	}
	
	public void selectNoDestination(boolean b) {
		
		this.airport.exploreWithoutDestination( b);
			
	}
public void selectDepartureDate(Calendar c) {
		
		this.date.selectDepartureDate(c);
			
	}

public void selectArrivalDate(Calendar c) {
	
	this.date.selectArrivalDate(c);
		
}

public void selectDepartureAndArrivalDate(Calendar departure, Calendar arrival) {
	
	selectDepartureDate(departure);
	selectArrivalDate(arrival);
}

public void selectNoDate(boolean b) {

	this.date.exploreWithoutDate(b);
		
}

	
	public void selectAClass(Classes enumC) {
		this.classes.SelectAClass(this.classField);
		this.classes.SelectAClass(enumC.getSelector());
		
	}
	
	public void addAdultPassenger() {
		this.passenger.addMajor();	
	}
	
	
	public void addAdultPassenger(int qty) {
		
		for (int i=0;i<qty;i++) {
			addAdultPassenger();
			
		}	
	}
	
	public void substractAdultPassenger() {
		this.passenger.substractMajor();	
	}
	
	
	public void substractAdultPassenger(int qty) {
		
		for (int i=0;i<qty;i++) {
			substractAdultPassenger();
			
		}	
	}
	public void search() {
		
		driver.findElement(By.cssSelector(searchButton)).click();
	}
	
	
	public void close(){

	driver.quit();
HomePage.driver = null;
HomePage.wait = null;	
	}

	

	
    
	
	
	
}
	



