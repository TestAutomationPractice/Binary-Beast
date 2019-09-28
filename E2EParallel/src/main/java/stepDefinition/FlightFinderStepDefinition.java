package stepDefinition;



import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.FlightFinder;
import objects.Login;
import objects.TestBase;
import utility.TLDriverFactory;

public class FlightFinderStepDefinition{
	private static FlightFinder FF;
	private static WebDriver driver;
	private static ExtentTest logger;

	@When("The user enters '(.*)' and '(.*)' and clicks on login button")
	
	public void the_user_enters_valid_user_name_and_password_and_click_on_login_button(String UserName, String Password) throws Exception {
		logger = TestBase.getScenario();
		logger.info("Step: The user enters UserName and Password and clicks on login button");
		driver = TLDriverFactory.getTLDriver();
		Login loginpage = new Login(driver,logger);
		loginpage.login(UserName, Password);		
	}
	
	@When("^User enters Flight details and clicks Continue$")
	public void user_enters_Flight_details_and_clicks_Continue(Map<String, String> testdata) throws Throwable {
		logger.info("Step: User enters Flight details and clicks Continue");
		FF = new FlightFinder(driver,logger);
		FF.searchFlight(testdata);		
	}

	@Then("^User is Navigated to Select Flight page$")
	public void user_is_Navigated_to_Select_Flight_page() throws Throwable {
		logger.info("Step: User is Navigated to Select Flight page");
		FF.verifySelectFlightPage();
	}

}
