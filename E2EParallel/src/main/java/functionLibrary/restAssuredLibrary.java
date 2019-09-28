package functionLibrary;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class restAssuredLibrary {

    public static RequestSpecification Request;
    public static ExtentTest logger;
    	
    	
    public restAssuredLibrary(ExtentTest logger){
    	this.logger = logger;
    }

    public restAssuredLibrary(String URI) {
        //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(URI);
        builder.setContentType(ContentType.JSON);
         RequestSpecification requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams) {
        //Act
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GetOps(String url) {
        //Act
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> GetOpsWithToken(String url, String token) {
        //Act
        try {
            Request.header(new Header("Authorization", "Bearer " + token));
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String,String> body, Map<String,String> pathParams) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.put(url);
    }

    public ResponseOptions<Response> GetOpsQueryParams(String url, String queryParams) {
        try {
            Request.queryParam(queryParams);
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body)  {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PostOpsWithBody(String url,Map<String, String> body)  {
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.delete(url);
    }

    public static ResponseOptions<Response> GetWithPathParams(String url,Map<String, String> pathParams)  {
        Request.pathParams(pathParams);
        return Request.get(url);
    }
    
    public static String jsonToString(String filepath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
          Object obj = parser.parse(new FileReader(filepath));
          jsonObject = (JSONObject) obj;
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ParseException e) {
          e.printStackTrace();
        }

        return jsonObject.toString();
      }
    
    public static Response getResponce(String strURL, String strMethod,String requestVariable, JSONObject requestParams){   
		logger.log(Status.INFO, "Sending "+strMethod+" request to "+strURL+"/"+requestVariable+" with parameter ");
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = strURL;
		RequestSpecification request = RestAssured.given();
		request.body(requestParams.toJSONString());
		Response response = null;
		
		switch (strMethod.toUpperCase()) {
		case "GET":
			response = request.get("/"+requestVariable);
			break;
			
		case "PUT":
			response = request.put("/"+requestVariable);			
			break;
			
		case "POST":
			response = request.post("/"+requestVariable);
			break;	
		case "DELETE":
			response = request.delete("/"+requestVariable);
			break;	
			
		case "PATCH":
			response = request.patch("/"+requestVariable);
			break;	
		}

		return response;
	}


}
