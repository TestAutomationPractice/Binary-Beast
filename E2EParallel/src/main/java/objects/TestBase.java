package objects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utility.ExtentManager;
import utility.ReadProperties;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;

public class TestBase {
	
    //Extent Report Declarations
    protected static ExtentReports extent = ExtentManager.createInstance();
    protected static ThreadLocal<ExtentTest> feature = new ThreadLocal<>();
    protected static ThreadLocal<ExtentTest> scenario = new ThreadLocal<>();
    protected WebDriver TLdriver;
    public static String browser;
    protected static ReadProperties R = new ReadProperties();
    protected static Properties prop = R.prop;
    //Do the test setup
    @BeforeMethod
    @Parameters(value={"browser"})
    public void beforeMethod(String browser,Method method) {
    	this.browser=browser;
    	Test test = method.getAnnotation(Test.class);
        String featureName = test.description();
        ExtentTest extentTest = extent.createTest(featureName);
	    feature.set(extentTest);
    }
                     
  
   @AfterMethod
    public synchronized void tearDown() throws Exception {
	   //TLdriver.quit();
	  
    }   
   
   
	public synchronized static  ExtentTest getScenario() {
		return scenario.get();
	}
}
