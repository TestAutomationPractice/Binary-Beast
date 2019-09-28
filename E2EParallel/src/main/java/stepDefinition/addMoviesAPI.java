package stepDefinition;

import java.util.Properties;

import org.json.simple.JSONObject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.restAssuredLibrary;
import io.restassured.response.Response;
import objects.TestBase;
import utility.ReadProperties;

public class addMoviesAPI {
	
	
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;
	
	
	@Given("^User want to add a new movie$")
	public void user_want_to_add_a_new_movie() throws Throwable {

	}

	@SuppressWarnings("unchecked")
	@When("^User adds movie with \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_adds_movie_with(String arg1, String arg2, String arg3, String arg4, String arg5,String arg6) throws Throwable {
		String Url = "http://autothon-nagarro-backend-w10.azurewebsites.net";
		JSONObject requestParams = new JSONObject();
		requestParams.put("title", arg1); 
		requestParams.put("director", arg2);
		requestParams.put("description", arg3);
		requestParams.put("categories", arg4);	
		requestParams.put("image", arg5);	
		requestParams.put("rating", arg6);	
		ExtentTest logger = TestBase.getScenario();
		restAssuredLibrary RA = new restAssuredLibrary(logger);
		Response response = restAssuredLibrary.getResponce(Url, "POST", "movies", requestParams); 
		System.out.println(response.body().asString());
		logger.log(Status.INFO, "Response is "+response.body().asString());
	}

	@Then("^Movie is added successfully$")
	public void movie_is_added_successfully() throws Throwable {

	}

}
