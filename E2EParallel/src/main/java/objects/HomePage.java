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

import functionLibrary.functionLibrary;
import utility.ScreenshotUtility;
import utility.TLDriverFactory;


public class HomePage{
	private ExtentTest logger;
	private WebDriver localdriver;

	@FindBy(xpath = "//a[@id='navLink' and @name='Login']")

	WebElement lnkLogin;

	@FindBy(xpath = "//a[text()='Profile']")

	WebElement lnkProfile;

	@FindBy(name = "search")

	WebElement txtInputSearch;

	@FindBy(xpath = "//input[@type='checkbox']")

	WebElement chkBoxShowAVailable;

	@FindBy(xpath = "//div[@class='mycard']")

	List<WebElement> listMovieCards;

	@FindBy(xpath = "//href[text()='View more']")

	WebElement lnkViewMore;

	@FindBy(xpath = "//input[@name='password']")

	WebElement txtInputUserName;

	@FindBy(xpath = "//input[@name='username']")

	WebElement txtInputPassword;

	@FindBy(xpath = "//button[@type='button' and @name='Cancel']")

	WebElement btnLogin;

	
	public void openApplication(String URL){
		logger.log(Status.INFO, "Navigating to  - "+URL);
		localdriver.get(URL);
		localdriver.manage().window().maximize();
	}
	
	
	
	
	public HomePage(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.localdriver=driver;
	// This initElements method will create all WebElements		
		
		PageFactory.initElements(driver, this);

	}

	// Select trip type from list
	public void loginUser(String uName, String pWord) {
		try {
			logger.log(Status.INFO, "Validating the User Login");
			functionLibrary.clickWebelement(lnkLogin);
			functionLibrary.sendText(txtInputUserName, uName);
			functionLibrary.sendText(txtInputPassword, pWord);
			functionLibrary.clickWebelement(btnLogin);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Trip Type failed due to " + e.getMessage());
		}
	}
}

	

	