package testRunner;

import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import objects.TestBase;



@CucumberOptions(features={"src/test/java/features/SearchFlight.feature"},glue={"stepDefinition"},plugin={"pretty","html:HTML_Reports/"})

public class searchFlightTestRunner extends TestBase {		
	 private TestNGCucumberRunner testNGCucumberRunner;
	public static Properties prop;
@BeforeSuite
public static void initialize() throws IOException {
	
//archive all reports to Archive folder
//UtilityFunctions.archievReport();		
} 

@AfterSuite
public void PrepareReport(){
	//ExtentManager.flush();	
}

@BeforeClass(alwaysRun = true)
public void setUpClass() throws Exception {
	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	
}

@Test(groups = "cucumber", description = "SearchFlight", dataProvider = "features")
public void SearchFlight(CucumberFeatureWrapper cucumberFeature) {
	 testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
}

@DataProvider(parallel=true)
public Object[][] features() {
	  return testNGCucumberRunner.provideFeatures();
}

@AfterClass(alwaysRun = true)
public void tearDownClass() throws Throwable {
	  testNGCucumberRunner.finish();
}
}


