package PageObjects;



import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPageObject {
	
	private enum Month{
		
		ENERO(0),
		FEBRERO(1),
		MARZO(2),
		ABRIL(3),
		MAYO(4),
		JUNIO(5),
		JULIO(6),
		AGOSTO(7),
		SEPTIEMBRE(8),
		OCTUBRE(9),
		NOVIEMBRE(10),
		DICIEMBRE(11);
		
	    private final int number;
		 
	    Month(int number) {
	        this.number = number;
	    }
	 
	    public int getValue() {
	        return this.number;
	    }
	}
	
	
	
    private final String buttonNext = "mb-range-month-view .mb-calendar-header__next";
    private final String buttonPrev="mb-range-month-view .mb-calendar-header__prev";
    private final String departure="#departure-date";
    private final String cssHeader= "mb-range-month-view .mb-calendar-header__title";
    private final String fullMonthButtons =".calendar-range-view__page:nth-of-type(1) .mb-calendar-body__btn";
    private final String arrival="#arrival-date";
    private final String undefDate = ".flights-searchbox__form-inputs-group-date .mb-checkbox__mark";
	
	
	 private WebDriver driver;
	 private boolean undefinedDate;


public CalendarPageObject(WebDriver driver) {

	this.driver =driver;
    this.undefinedDate=false;
   
    
}
	
	
public Calendar setDate(int days) {
	Calendar c= Calendar.getInstance();
	c.add(Calendar.DAY_OF_MONTH, days);
	return c;
}


private void selectDate( Calendar c, String departureOrArrival) {
	
this.driver.findElement(By.cssSelector(departureOrArrival)).click();


//obtain month and year of the calendar from the header
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssHeader)));


findYear(c);
findMonth(c);	
findDay(c);


}

public void selectDepartureDate(int days) {
	Calendar c =setDate(days);
selectDate(c,this.departure);
findDay(c);
}

public void selectArrivalDate(int days) {
	Calendar c =setDate(days);
selectDate(c,this.arrival);

}

private void findCalendarPosition(String strObjectCalendar, int objectCalendar, int headerCalendar) {
	
	String header= this.driver.findElement(By.cssSelector(this.cssHeader)).getText();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	while(!(header.contains(strObjectCalendar))) {
			
			if (objectCalendar > headerCalendar) {
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(this.buttonNext)));
			this.driver.findElement(By.cssSelector(this.buttonNext)).click();
		
			} else {
				
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(this.buttonPrev)));
				this.driver.findElement(By.cssSelector(this.buttonPrev)).click();
			
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssHeader)));
		   header = this.driver.findElement(By.cssSelector(this.cssHeader)).getText();
		}
	
	
}
	private void findYear(Calendar c) {
		
		//obtain c's year
	int yearOfObjectCalendar = c.get(Calendar.YEAR);
	String strYearOfObjectCalendar= Integer.toString(yearOfObjectCalendar);
		
	int yearOfCalendarHeader = getYearOfHeader();
	

	findCalendarPosition(strYearOfObjectCalendar, yearOfObjectCalendar, yearOfCalendarHeader);

		
	}
	
	

	private void findMonth( Calendar c) {
		
		
	int monthOfObjectCalendar = c.get(Calendar.MONTH)+1;
	
String 	strMonthOfObjectCalendar = getMonthFromInt(monthOfObjectCalendar).toUpperCase();

	
int monthOfCalendarHeader =getMonthOfHeader();		

	findCalendarPosition(strMonthOfObjectCalendar, monthOfObjectCalendar, monthOfCalendarHeader);

	
	}
	
	
	private int getMonthOfHeader() {
		
		String header= this.driver.findElement(By.cssSelector(this.cssHeader)).getText();
		//obtain last index of the month
				int aux = header.indexOf("2")-2;

				//obtain month of the header
				String strMonthOfHeader= header.substring(0,aux+1);
				
				Month enume = Month.valueOf(strMonthOfHeader);
				int monthOfHeader = enume.getValue();
			
				return monthOfHeader;
		
	}
	
	private int getYearOfHeader() {
		
		String header= this.driver.findElement(By.cssSelector(this.cssHeader)).getText();
		//obtain index of the first number of the year
		int aux = header.indexOf("2");

		//obtain year of the header
		String strYearOfHeader= header.substring(aux,aux+4);
		int yearOfHeader = Integer.parseInt(strYearOfHeader);
			
		return yearOfHeader;
	}



private String getMonthFromInt(int month) {
	
	return (Month.values()[month-1]).toString();
	
}


private void findDay(Calendar c) {
	
	
	int day = c.get(Calendar.DAY_OF_MONTH);

	
	this.driver.findElements(By.cssSelector(this.fullMonthButtons)).get(day-1).click();
	
	
}



public void exploreWithoutDate(boolean b) {
	 
	 
	 if(this.undefinedDate != b) {
		 clickCheckBoxDestinaton();
		 this.undefinedDate = b;
	 }
}

	 private void clickCheckBoxDestinaton(){
		 
		 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(undefDate)));
		 this.driver.findElement(By.cssSelector(undefDate)).click();
		 
	 }



}
