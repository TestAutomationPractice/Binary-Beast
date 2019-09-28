package stepDefinition;


import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.Login;
import objects.TestBase;
import utility.ReadProperties;
import utility.TLDriverFactory;


public class LoginStepdefinition {
	
	protected static Login loginpage;
	private static WebDriver driver;
	private static ExtentTest logger;
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;
		
	@Given("The user opens mercury tour demo site")
	public void the_browser_is_open_with_URL() throws Exception {	
		logger = TestBase.getScenario();
		logger.info("Step: The user opens mercury tour demo site");		
		driver = TLDriverFactory.getTLDriver();
		loginpage = new Login(driver,logger);
		loginpage.openApplication(prop.getProperty("WebURL"));
		//loginpage.OpenApplication("http://newtours.demoaut.com/mercurysignon.php");		
	}

	@When("The user enters '(.*)' and '(.*)' and click on login button")
	public void the_user_enters_valid_user_name_and_password_and_click_on_login_button(String UserName, String Password) throws Exception {
		logger.info("Step: The user enters UserName and Password and clicks on login button");
		
		//logger = TestBase.getlogger();
		
		loginpage.login(UserName, Password);		
	}
	
	@Then("The home page should be displayed")
	public void the_home_page_should_be_displayed() throws ClassNotFoundException {
		logger.info("Step: The user enters UserName and Password and clicks on login button");
		loginpage.verifyFlightFinderPage();
	}
	
	@Then("The home page should not be displayed")
	public void the_home_page_shouldnot_be_displayed() throws ClassNotFoundException {
		logger.info("Step: The home page should not be displayed");
		loginpage.verifyFlightFinderPageInvalidLogin();;
	}


}
