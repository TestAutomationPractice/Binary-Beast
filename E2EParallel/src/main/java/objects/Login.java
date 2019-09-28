package objects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utility.ScreenshotUtility;
import utility.TLDriverFactory;

public class Login{
	private ExtentTest logger;
	private WebDriver localdriver;
	
	@FindBy(name = "userName")

	WebElement txtUserName;

	@FindBy(name = "password")

	WebElement txtPassword;

	@FindBy(name = "login")

	WebElement btnLogin;
	
	
	@FindBy(xpath = "//img[contains(@src,'signon')]")
	WebElement imgSignOn;
	
	@FindBy(xpath = "//img[contains(@src,'flightfinder')]")
	WebElement imgFlightFinder;

	
	public Login(WebDriver driver, ExtentTest logger){
		this.localdriver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements		
			
			PageFactory.initElements(driver, this);
	}
	
	// Set user name in textbox

	public void setUserName(String strUserName) {

		txtUserName.sendKeys(strUserName);

	}
	// Set password in password textbox

	public void setPassword(String strPassword) {

		txtPassword.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		btnLogin.click();

	}
	
	public void login(String strUserName, String strPasword) throws Exception {

		try {
			
			//logger = ExtentManager.logger(ScenarioName);
			// Fill user name

			setUserName(strUserName);
			
			logger.log(Status.INFO, "Entered User name: " + strUserName);
			// Fill password

			setPassword(strPasword);
			logger.log(Status.INFO, "Entered Password: " + strPasword);
			// Click Login button

			clickLogin();
			
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Login Failed due to " + e.getMessage());
		}

	}
	public void verifyFlightFinderPage() {

		try {
			if (imgFlightFinder.isDisplayed()) {
				String  screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "FlightFinder_NavSuccessful");
				logger.log(Status.PASS, "Navigated to Flight Finder page",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				String  screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "FlightFinder_NavigationUnsuccessful");
				logger.log(Status.FAIL, "Not Navigated to Flight Finder page", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Navigated toFlight Finder failed due to " + e.getMessage());
		}
}
	
	public void verifyFlightFinderPageInvalidLogin() {

		try {
			if (imgSignOn.isDisplayed()) {
			String  screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "FlightFinder_NavigationSuccessful");
			logger.log(Status.PASS, "Not Navigated to Flight Finder page",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} else {
				
				String  screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "FlightFinder_NavigationUnsuccessful");
				logger.log(Status.FAIL, "Navigated to Flight Finder page", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Navigated toFlight Finder failed due to " + e.getMessage());
		}
}
	
	public void openApplication(String URL){
		logger.log(Status.INFO, "Navigating to  - "+URL);
		localdriver.get(URL);
		localdriver.manage().window().maximize();
	}
	
	
	

public void loginOut() throws IOException {
	
	//driver.quit();
}
}
