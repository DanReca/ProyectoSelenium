package PageObjects;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPageObject {

	@FindBy(css = "#departure-date")
	WebElement departureDateFieldRoundTrip;

	@FindBy(css = "#arrival-date")
	WebElement arrivalDateFieldRoundTrip;

	@FindBys(@FindBy(css = "#departureDate"))
	List<WebElement> departureDateField;

	@FindBy(css = ".flights-searchbox__form-inputs-group-date .mb-checkbox__mark")
	WebElement undefinedDateCheckBox;

	@FindBys(@FindBy(css = ".mb-calendar-body__btn"))
	List<WebElement> fullMonthButtons;

	@FindBys(@FindBy(css = ".calendar-range-view__page:nth-of-type(1) .mb-calendar-body__btn"))
	List<WebElement> fullMonthButtonsRoundTrip;

	@FindBy(css = "mb-range-month-view .mb-calendar-header__next")
	WebElement nextButtonRoundTrip;

	@FindBy(css = "mb-range-month-view .mb-calendar-header__prev")
	WebElement prevButtonRoundTrip;

	@FindBy(css = "mb-range-month-view :nth-child(1) > mb-calendar-header")
	WebElement leftHeaderRoundTrip;

	@FindBy(css = ".mb-calendar-header__next")
	WebElement nextButton;

	@FindBy(css = ".mb-calendar-header__prev")
	WebElement prevButton;

	@FindBy(css = ".mb-calendar-header__title")
	WebElement header;

	private enum Month {

		ENERO(0), FEBRERO(1), MARZO(2), ABRIL(3), MAYO(4), JUNIO(5), JULIO(6), AGOSTO(7), SEPTIEMBRE(8), OCTUBRE(9),
		NOVIEMBRE(10), DICIEMBRE(11);

		private final int number;

		Month(int number) {
			this.number = number;
		}

		public int getValue() {
			return this.number;
		}
	}

	private WebDriver driver;
	private boolean undefinedDate;

	public CalendarPageObject(WebDriver driver) {

		this.driver = driver;
		this.undefinedDate = false;
		PageFactory.initElements(driver, this);

	}

	public Calendar setDate(int days) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);
		return c;
	}

	private void selectDate(Calendar c, List<WebElement> departureOrArrival, int indexOfFlight) {

		departureOrArrival.get(indexOfFlight).click();

		obtainDateOfHeader(c);
	}

	private void selectDate(Calendar c, WebElement departureOrArrival) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(departureOrArrival));
		departureOrArrival.click();
		obtainDateOfHeader(c);
	}

	private void obtainDateOfHeader(Calendar c) {

		WebElement auxHeader = header;

		if (HomePageObject.isRoundTrip()) {

			auxHeader = leftHeaderRoundTrip;
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(auxHeader));
		findYear(c);
		findMonth(c);
		findDay(c);
	}

	public void selectDepartureAndArrivalDate(int daysDeparture, int daysArrival) {

		selectDepartureDate(daysDeparture, 0);
		selectArrivalDate(daysArrival);
	}

	public void selectDepartureDate(int days, int indexOfFlight) {
		Calendar c = setDate(days);

		if (HomePageObject.isRoundTrip()) {

			selectDate(c, departureDateFieldRoundTrip);
			findDay(c);

		} else {

			selectDate(c, departureDateField, indexOfFlight);
		}

	}

	public void selectArrivalDate(int days) {
		Calendar c = setDate(days);
		selectDate(c, arrivalDateFieldRoundTrip);

	}

	private void findCalendarPosition(String strObjectCalendar, int objectCalendar, int headerCalendar) {

		WebElement auxHeader = header;
		WebElement auxPrevButton = prevButton;
		WebElement auxNextButton = nextButton;

		if (HomePageObject.isRoundTrip()) {

			auxHeader = leftHeaderRoundTrip;
			auxPrevButton = prevButtonRoundTrip;
			auxNextButton = nextButtonRoundTrip;
		}

		String strHeader = auxHeader.getText();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		while (!(strHeader.contains(strObjectCalendar))) {

			if (objectCalendar > headerCalendar) {
				wait.until(ExpectedConditions.elementToBeClickable(auxNextButton));
				auxNextButton.click();

			} else {

				wait.until(ExpectedConditions.elementToBeClickable(auxPrevButton));
				auxPrevButton.click();

			}
			wait.until(ExpectedConditions.elementToBeClickable(auxHeader));
			strHeader = auxHeader.getText();
		}

	}

	private void findYear(Calendar c) {

		// obtain c's year
		int yearOfObjectCalendar = c.get(Calendar.YEAR);
		String strYearOfObjectCalendar = Integer.toString(yearOfObjectCalendar);

		int yearOfCalendarHeader = getYearOfHeader();

		findCalendarPosition(strYearOfObjectCalendar, yearOfObjectCalendar, yearOfCalendarHeader);

	}

	private void findMonth(Calendar c) {

		int monthOfObjectCalendar = c.get(Calendar.MONTH) + 1;

		String strMonthOfObjectCalendar = getMonthFromInt(monthOfObjectCalendar).toUpperCase();

		int monthOfCalendarHeader = getMonthOfHeader();

		findCalendarPosition(strMonthOfObjectCalendar, monthOfObjectCalendar, monthOfCalendarHeader);

	}

	private int getMonthOfHeader() {

		WebElement auxHeader = header;

		if (HomePageObject.isRoundTrip()) {

			auxHeader = leftHeaderRoundTrip;

		}

		String strHeader = auxHeader.getText();
		// obtain last index of the month
		int aux = strHeader.indexOf("2") - 2;

		// obtain month of the header
		String strMonthOfHeader = strHeader.substring(0, aux + 1);

		Month enume = Month.valueOf(strMonthOfHeader);
		int monthOfHeader = enume.getValue();

		return monthOfHeader;

	}

	private int getYearOfHeader() {

		WebElement auxHeader = header;

		if (HomePageObject.isRoundTrip()) {

			auxHeader = leftHeaderRoundTrip;

		}

		String strHeader = auxHeader.getText();
		// obtain index of the first number of the year
		int aux = strHeader.indexOf("2");

		// obtain year of the header
		String strYearOfHeader = strHeader.substring(aux, aux + 4);
		int yearOfHeader = Integer.parseInt(strYearOfHeader);

		return yearOfHeader;
	}

	private String getMonthFromInt(int month) {

		return (Month.values()[month - 1]).toString();

	}

	private void findDay(Calendar c) {

		int day = c.get(Calendar.DAY_OF_MONTH);

		List<WebElement> auxFullMonthButtons = fullMonthButtons;

		if (HomePageObject.isRoundTrip()) {

			auxFullMonthButtons = fullMonthButtonsRoundTrip;
		}

		auxFullMonthButtons.get(day - 1).click();

	}
	

	public void exploreWithoutDate(boolean b) {

		if (this.undefinedDate != b) {
			clickCheckBoxDestinaton();
			this.undefinedDate = b;
		}
	}

	
	private void clickCheckBoxDestinaton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(undefinedDateCheckBox));
		undefinedDateCheckBox.click();

	}

}
