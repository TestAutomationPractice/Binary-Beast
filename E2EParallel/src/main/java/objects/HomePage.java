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
	private functionLibrary FunctionLibrary ;

	@FindBy(xpath = "//a[text()='Login']")

	WebElement lnkLogin;
	
	@FindBy(xpath = "//button[@type='button' and text()='#']")

	WebElement btnHash;

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

	WebElement txtInputPassword ;

	@FindBy(xpath = "//input[@name='username']")

	WebElement txtInputUserName;

	@FindBy(xpath = "//button[text()='Login']")

	WebElement btnLogin;
	
	
	@FindBy(xpath = "(//div[@class='form-group'])[1]")
	WebElement userName;
	
	
	@FindBy(xpath = "//div[@class='infos']/h2")
	List<WebElement> txtMovieName;

	public HomePage(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.localdriver=driver;
	// This initElements method will create all WebElements		
		
		PageFactory.initElements(driver, this);
		FunctionLibrary = new functionLibrary(driver,logger);

	}	
	public void openApplication(String URL){
		logger.log(Status.INFO, "Navigating to  - "+URL);
		localdriver.get(URL);
		localdriver.manage().window().maximize();		
	}
	
	// Select trip type from list
	public void loginUser(String uName, String pWord) {
		try {
			logger.log(Status.INFO, "Login to Application");
			FunctionLibrary.clickWebelement(btnHash);
			FunctionLibrary.clickWebelement(lnkLogin);
			FunctionLibrary.sendText(txtInputUserName, uName);
			FunctionLibrary.sendText(txtInputPassword, pWord);
			FunctionLibrary.clickWebelement(btnLogin);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Selection of Trip Type failed due to " + e.getMessage());
		}
	}
	
	public void verifyUserProfile(String User){
		logger.log(Status.INFO, "Verify User Loggedin");
		FunctionLibrary.waitTillElementFound(lnkProfile,3);
		FunctionLibrary.clickWebelement(lnkProfile);
		if(userName.getText().contains(User)){			
			logger.log(Status.PASS, "User Loggedin Successfully");
		}else{
			logger.log(Status.FAIL, "User NOT Loggedin Successfully");
		}
		
	}
	
	
	public void serachMovies(String MovieName){
		FunctionLibrary.sendText(txtInputSearch,MovieName);
		FunctionLibrary.waitMyTime(2);
		boolean bflag = false;
		for (int i = 0; i < txtMovieName.size(); i++) {
			if (txtMovieName.get(i).getText().contains(MovieName)) {
				logger.log(Status.PASS, "Mo");
				bflag = true;
				break;
			}
		}
		
		if(bflag){
			logger.log(Status.PASS, "Movie Name '"+MovieName+"' is added successfully");
		}else{
			logger.log(Status.FAIL, "Movie Name '"+MovieName+"' is NOT added successfully");
		}
	}
}

	

	