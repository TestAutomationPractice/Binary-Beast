package utility;

import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OptionsManager {
	public static ReadProperties R = new ReadProperties();
	public static Properties prop = R.prop;
	

    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chrome/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        return options;
        /*ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeDriver driver = new ChromeDriver(service, options);*/
    }

    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions () {
    	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/firefox/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }
    
    
    public static DesiredCapabilities getFirefoxRemoteCapability () {
    	DesiredCapabilities Capabalities = DesiredCapabilities.firefox();
    	Capabalities.setBrowserName("firefox");
    	Capabalities.setPlatform(Platform.XP);
    	return Capabalities;
    }
    
    public static DesiredCapabilities getChromeRemoteCapability () {
    	DesiredCapabilities Capabalities = DesiredCapabilities.chrome();
    	Capabalities.setBrowserName("chrome");
    	Capabalities.setPlatform(Platform.XP);
    	return Capabalities;
    }
    
    
    public static DesiredCapabilities getAndroidCapabilities(){
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", prop.getProperty("PlatformName"));
		caps.setCapability("deviceName", prop.getProperty("Device"));
		caps.setCapability("app", prop.getProperty("appPath"));
		//com.flipkart.android/com.flipkart.android.activity.HomeFragmentHolderActivity}
		caps.setCapability("appActivity", prop.getProperty("appActivity"));
		caps.setCapability("appPackage", prop.getProperty("appPackage"));
		return caps;
    }
    
    
}
