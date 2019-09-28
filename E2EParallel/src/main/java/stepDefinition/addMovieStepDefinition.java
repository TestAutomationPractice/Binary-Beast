package stepDefinition;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.AddMovie;
import objects.HomePage;
import objects.TestBase;
import utility.ReadProperties;
import utility.TLDriverFactory;


public class addMovieStepDefinition {
	protected static AddMovie addMovie;
	protected static HomePage HomePage;
	private static WebDriver driver;
	private static ExtentTest logger;
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;
	
	@Given("^The admin open Movie Rental site$")
	public void the_user_opens_Movie_Rental_site() throws Throwable {
		logger = TestBase.getScenario();
		logger.info("Step: The user opens Ticket Site");		
		driver = TLDriverFactory.getTLDriver();
		HomePage = new HomePage(driver,logger);
		HomePage.openApplication(prop.getProperty("WebURL"));
	}
	
	
	@Given("^The admin open Movie Rental site Parallely$")
	public void the_admin_opens_Movie_Rental_site() throws Throwable {
		logger = TestBase.getScenario();
		logger.info("Step: The user opens Ticket Site");	
		TLDriverFactory.setTLDriver(prop.getProperty("browser"));
		driver = TLDriverFactory.getTLDriver();
		HomePage = new HomePage(driver,logger);
		HomePage.openApplication(prop.getProperty("WebURL"));
	}

	@When("^Admin user login$")
	public void admin_user_logins() throws Throwable {
		HomePage.loginUser(prop.getProperty("UserName"), prop.getProperty("Password"));
		
		
	}
	

	@When("^Admin adds movie with \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_adds_movie_with(String Title, String Director, String Description, String Categories, String ImageUrl, String Rating) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addMovie = new AddMovie(driver,logger);
		addMovie.clickAddMovie();
		addMovie.addDetails(Title, Director, Description, Categories, ImageUrl, Rating);
	}



}
