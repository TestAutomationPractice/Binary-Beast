package objects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utility.ScreenshotUtility;
import utility.TLDriverFactory;


public class FlightFinder{
	private ExtentTest logger;
	private WebDriver localdriver;

	@FindBy(name = "tripType")

	List<WebElement> radTripType;

	@FindBy(name = "passCount")

	WebElement listPassCount;

	@FindBy(name = "fromPort")

	WebElement listFromPort;

	@FindBy(name = "fromMonth")

	WebElement listFromMonth;

	@FindBy(name = "fromDay")

	WebElement listFromDay;

	@FindBy(name = "toPort")

	WebElement listArrivingIn;

	@FindBy(name = "toMonth")

	WebElement listReturningMonth;

	@FindBy(name = "toDay")

	WebElement listReturningDay;

	@FindBy(name = "servClass")

	List<WebElement> radServiceClass;

	@FindBy(name = "airline")

	WebElement listAirline;

	@FindBy(name = "findFlights")

	WebElement btnContinue;

	@FindBy(xpath = "//img[contains(@src,'selectflight')]")
	WebElement imgSelectFlight;

	// constructor

	public FlightFinder(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.localdriver=driver;
	// This initElements method will create all WebElements		
		
		PageFactory.initElements(driver, this);

	}

	// Select trip type from list
	public void selectTripType(String TripType) {
		try {
			for (int i = 0; i < radTripType.size(); i++) {
				if (radTripType.get(i).getAttribute("value").contains(TripType)) {
					radTripType.get(i).click();
					break;
				}
			}
			logger.log(Status.INFO, "Selected Trip Type " + TripType);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Trip Type failed due to " + e.getMessage());
		}
	}

	// Select Passengers count
	public void selectPassanger(String Passanger) {
		try {
			Select sel = new Select(listPassCount);
			sel.selectByVisibleText(Passanger);
			logger.log(Status.INFO, "select Passanger: " + Passanger);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Passanger failed due to " + e.getMessage());
		}
	}

	// Select Departing From
	public void selectDepartingFrom(String DepartingFrom) {
		try {
			Select sel = new Select(listFromPort);
			sel.selectByVisibleText(DepartingFrom);
			logger.log(Status.INFO, "Selected Departing From: " + DepartingFrom);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Departing From failed due to " + e.getMessage());
		}
	}

	// Select Month on
	public void selectMonthOn(String MonthOn) {
		try {
			Select sel = new Select(listFromMonth);
			sel.selectByVisibleText(MonthOn);
			logger.log(Status.INFO, "Select Month On: " + MonthOn);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Month On failed due to " + e.getMessage());
		}
	}

	// Select from Day
	public void selectFromDay(String FromDay) {
		try {
			Select sel = new Select(listFromDay);
			sel.selectByVisibleText(FromDay);
			logger.log(Status.INFO, "Select From Day: " + FromDay);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of From Day failed due to " + e.getMessage());
		}
	}

	// Select Arriving In
	public void ArrivingIn(String ArrivingIn) {
		try {
			Select sel = new Select(listArrivingIn);
			sel.selectByVisibleText(ArrivingIn);
			logger.log(Status.INFO, "Entered Arriving In: " + ArrivingIn);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Arriving In failed due to " + e.getMessage());
		}
	}

	// Select Returning Month
	public void selectReturningMonth(String ReturningMonth) {
		try {
			Select sel = new Select(listReturningMonth);
			sel.selectByVisibleText(ReturningMonth);
			logger.log(Status.INFO, "Select Returning Month: " + ReturningMonth);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Returning Month failed due to " + e.getMessage());
		}
	}

	// Select Returning Day
	public void selectReturningDay(String ReturningDay) {
		try {
			Select sel = new Select(listReturningDay);
			sel.selectByVisibleText(ReturningDay);
			logger.log(Status.INFO, "Select Returning Day: " + ReturningDay);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Returning Day failed due to " + e.getMessage());
		}
	}

	// Select Airlines
	public void selectAirline(String Airline) {
		try {
			Select sel = new Select(listAirline);
			sel.selectByVisibleText(Airline);
			logger.log(Status.INFO, "Select Airline: " + Airline);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Airline failed due to " + e.getMessage());
		}
	}

	// Select Service Class
	public void selectServClass(String ServClass) {
		try {
			for (int i = 0; i < radServiceClass.size(); i++) {
				System.out.println(radServiceClass.get(i).getAttribute("value"));
				if (radServiceClass.get(i).getAttribute("value").contains(ServClass)) {

					radServiceClass.get(i).click();

					break;
				}
			}
			logger.log(Status.INFO, "Selected Serv Class: " + ServClass);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Departing From failed due to " + e.getMessage());
		}
	}

	// Click Continue button
	public void clickContinue() {
		try {
			btnContinue.click();
			logger.log(Status.INFO, "Clicked on Continue button");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Clicking on Continue button failed due to " + e.getMessage());
		}
	}

	// Search flight
	public void searchFlight(Map<String, String> testdata){
			String TripType = testdata.get("TripType");
			String Passanger = testdata.get("Passanger");
			String DepartingFrom = testdata.get("DepartingFrom");
			String MonthOn = testdata.get("MonthOn");
			String FromDay = testdata.get("FromDay");
			String ArrivingIn = testdata.get("ArrivingIn");
			String ReturningMonth = testdata.get("ReturningMonth");
			String ReturningDay = testdata.get("ReturningDay");
			String ServClass = testdata.get("ServClass");
			String Airline = testdata.get("Airline");

			//logger = ExtentManager.logger(ScenarioName);
		try {			
			selectTripType(TripType);			
			selectPassanger(Passanger);
			selectDepartingFrom(DepartingFrom);
			selectMonthOn(MonthOn);
			selectFromDay(FromDay);
			ArrivingIn(ArrivingIn);
			if (TripType.equalsIgnoreCase("roundtrip")){
			selectReturningMonth(ReturningMonth);
			selectReturningDay(ReturningDay);
			}
			selectServClass(ServClass);
			selectAirline(Airline);
			clickContinue();
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.log(Status.FAIL, "Search Flight failed due to " + e.getMessage());
		}
	}

	// verify flight finder page is open
	public void verifySelectFlightPage() {

		try {
			if (imgSelectFlight.isDisplayed()) {
				
				logger.log(Status.PASS, "Navigated to Select Flight page");
			} else {
				String screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "FlightFinder_SearchUnsuccessful");
				logger.log(Status.FAIL, "Not Navigated to Select Flight", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Navigated to Select Flight failed due to " + e.getMessage());
		}
	}

}
