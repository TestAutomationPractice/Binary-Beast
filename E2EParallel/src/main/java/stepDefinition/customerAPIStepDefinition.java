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


public class customerAPIStepDefinition{
	
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;
	String Url =  prop.getProperty("customerBaseURL");
	
	@Given("^User want to add a new customer$")
	public void user_want_to_add_a_new_customer() throws Throwable {
	    	   
		}

	@Then("^Customer is added successfully$")
	public void customer_is_added_successfully() throws Throwable {
	   	   
	}


	@Given("^User want to Get customer details$")
	public void user_want_to_Get_customer_details() throws Throwable {
	   	   
	}

	

	@SuppressWarnings("unchecked")
	@When("^Customer details are \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_details_are_and_and_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {		
	
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", arg1); 
		requestParams.put("LastName", arg2);
		requestParams.put("UserName", arg3);
		requestParams.put("Password", arg4);	
		requestParams.put("Email",  arg1+"@gmail.com");
		ExtentTest logger = TestBase.getScenario();
		restAssuredLibrary RA = new restAssuredLibrary(logger);
		Response response = restAssuredLibrary.getResponce(Url, "POST", "register", requestParams); 
		System.out.println(response.body().asString());
		logger.log(Status.INFO, "Response is "+response.body().asString());
   
	}

}
