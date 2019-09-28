package utility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.*;

public class TLDriverFactory {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	protected static WebDriverWait wait;
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;

	public synchronized static void setTLDriver(String browser) throws MalformedURLException {

		if (browser.equals("firefox")) {
			
			if(prop.getProperty("Execution").equalsIgnoreCase("remote")){	
				System.out.println("Executing Selenium Web Automation on node - "+prop.getProperty("nodeURL"));
				driver.set(new RemoteWebDriver(new URL(prop.getProperty("nodeURL")), OptionsManager.getFirefoxRemoteCapability()));
			}else{
				driver.set(new FirefoxDriver(OptionsManager.getFirefoxOptions()));	
			}
			
			wait = new WebDriverWait(driver.get(), Integer.parseInt(prop.getProperty("webDriverWait")));
			//driver.get().navigate().to(prop.getProperty("WebURL"));
		} else if (browser.equals("chrome")) {
			
			if(prop.getProperty("Execution").equalsIgnoreCase("remote")){	
				System.out.println("Executing Selenium Web Automation on node - "+prop.getProperty("nodeURL"));
				driver.set(new RemoteWebDriver(new URL(prop.getProperty("nodeURL")), OptionsManager.getChromeRemoteCapability()));
			}else{
			driver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
			}
			
			wait = new WebDriverWait(driver.get(), Integer.parseInt(prop.getProperty("webDriverWait")));
			//driver.get().navigate().to(prop.getProperty("WebURL"));
		} else if (browser.equals("android")) {
				driver.set(new AndroidDriver<AndroidElement>(new URL(prop.getProperty("AndroidURL")),
				OptionsManager.getAndroidCapabilities()));
				wait = new WebDriverWait(driver.get(), Integer.parseInt(prop.getProperty("androidDriverWait")));
		
		} else if (browser.equals("api")) {
			driver.set(null);
		} else {
			System.out.println("please select a valid browser");
		}
		}

	public synchronized static WebDriver getTLDriver() {
		return driver.get();
	}

}
