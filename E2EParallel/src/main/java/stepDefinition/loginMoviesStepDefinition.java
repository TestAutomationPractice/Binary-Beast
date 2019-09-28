package stepDefinition;

import cucumber.api.java.en.Given;
import objects.TestBase;
import utility.TLDriverFactory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.HomePage;
import objects.TestBase;
import utility.ReadProperties;
import utility.TLDriverFactory;


public class loginMoviesStepDefinition {
	protected static HomePage HomePage;
	private static WebDriver driver;
	private static ExtentTest logger;
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;

	
	@Given("^The user opens Movie Rental site$")
	public void the_user_opens_Movie_Rental_site() throws Throwable {
		logger = TestBase.getScenario();
		logger.info("Step: The user opens mercury tour demo site");		
		driver = TLDriverFactory.getTLDriver();
		HomePage = new HomePage(driver,logger);
		HomePage.openApplication(prop.getProperty("WebURL"));
	}

	@When("^Admin user logins$")
	public void admin_user_logins() throws Throwable {
		HomePage.loginUser(prop.getProperty("UserName"), prop.getProperty("Password"));
	}

	@Then("^add movie page is open$")
	public void add_movie_page_is_open() throws Throwable {

	}
	
	@When("^The user enters \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
	public void the_user_enters_and_and_click_on_login_button(String arg1, String arg2) throws Throwable {
		HomePage.loginUser(arg1, arg2);
	}
}
