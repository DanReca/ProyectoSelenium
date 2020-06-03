package seleniumClases;

import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Date {
	
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
	
	
	 private WebDriver driver;
     private Calendar today;
	 private String buttonNext;
	 private String buttonPrev;
	 private String departure;
	 private String cssHeader;
	 private String fullMonthButtons;
	 private String arrival;
	 private boolean undefinedDate;
	 private String undefDate;
	 private WebDriverWait wait;


public Date(WebDriver driver, String buttonNext, String buttonPrev, String departure, String cssHeader, String fullM, String arrival, 
		String undefDate, WebDriverWait wait) {

	this.driver =driver;
	this.today=Calendar.getInstance();
	this.buttonNext = buttonNext;
	this.buttonPrev = buttonPrev;
	this.departure = departure;
	this.cssHeader=cssHeader;
	this.fullMonthButtons=fullM;
	this.arrival=arrival;
    this.undefinedDate=false;
    this.undefDate =undefDate;
    this.wait= wait;
    
}
	
	



private void selectDate( Calendar c, String departureOrArrival) {
	
this.driver.findElement(By.cssSelector(departureOrArrival)).click();

//obtain month and year of the calendar from the header
	String calendarMY = this.driver.findElement(By.cssSelector(this.cssHeader)).getText();

findYear(c,calendarMY);
findMonth(c,calendarMY);	
findDay(c);


}

public void selectDepartureDate(Calendar c) {
	
selectDate(c,this.departure);
findDay(c);
}

public void selectArrivalDate(Calendar c) {
	
selectDate(c,this.arrival);

}

private void findCalendarPosition(String strC, int intC, int intCalendar, String calendarMY) {
	
	String header= calendarMY;


	while(!(header.contains(strC))) {
			
			if (intC > intCalendar) {
				
			this.driver.findElement(By.cssSelector(this.buttonNext)).click();
			
			} else if(intC < intCalendar) {
				
				this.driver.findElement(By.cssSelector(this.buttonPrev)).click();
			}
		   header = this.driver.findElement(By.cssSelector(this.cssHeader)).getText();
		}
	
	
}
	private void findYear(Calendar c, String calendarMY) {
		
		//obtain c's year
	int intYearC = c.get(Calendar.YEAR);
	String 	strYearC = Integer.toString(intYearC);
		
	int intCalendarYear = getYearOfHeader(calendarMY);
	
	
	findCalendarPosition(strYearC, intYearC, intCalendarYear,calendarMY);

		
	}
	
	

	private void findMonth( Calendar c, String calendarMY) {
		
		
	int intMonthC = c.get(Calendar.MONTH)+1;
	
String 	strMonthC = getMonthFromInt(intMonthC).toUpperCase();

	
	int intCalendarMonth =getMonthOfHeader(calendarMY);		
	
	findCalendarPosition(strMonthC, intMonthC, intCalendarMonth,calendarMY);

		
	}
	
	
	private int getMonthOfHeader(String calendarMY) {
		
		//obtain last index of the month
				int aux = calendarMY.indexOf("2")-2;

				//obtain month of the header
				String strCalendarMonth= calendarMY.substring(0,aux+1);
				
				Month enume = Month.valueOf(strCalendarMonth);
				int intCalendarMonth = enume.getValue();
			
				return intCalendarMonth;
		
	}
	
	private int getYearOfHeader(String calendarMY) {
		
		//obtain index of the first number of the year
		int aux = calendarMY.indexOf("2");

		//obtain year of the header
		String strCalendarYear= calendarMY.substring(aux,aux+4);
		int intCalendarYear = Integer.parseInt(strCalendarYear);
		
		return intCalendarYear;
	}



private String getMonthFromInt(int month) {
	
	return (Month.values()[month-1]).toString();
	
}


private void findDay(Calendar c) {
	
	
	int day = c.get(Calendar.DAY_OF_MONTH);

	
	this.driver.findElements(By.cssSelector(this.fullMonthButtons)).get(day-1).click();
	
	
}

public void exploreWithoutDate() {
	 

	 this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(undefDate)));
	 this.driver.findElement(By.cssSelector(undefDate)).click();
	 this.undefinedDate = true;
}

}
