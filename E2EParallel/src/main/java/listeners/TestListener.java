package listeners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import objects.TestBase;
import utility.ExtentManager;
import utility.ScreenshotUtility;
import utility.TLDriverFactory;


public class TestListener extends TestBase implements ITestListener {
	 
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
    	try {
    		 Date date= new Date();
    		 long time = date.getTime();
    		String  screenshotPath = ScreenshotUtility.getScreenshot(TLDriverFactory.getTLDriver(), "Fail"+time);
			feature.get().log(Status.FAIL, result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        feature.get().fail(result.getThrowable());
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        feature.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}
