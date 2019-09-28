package objects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import functionLibrary.functionLibrary;
import utility.ScreenshotUtility;

public class AddMovie {

		private ExtentTest logger;
		private WebDriver localdriver;
		private functionLibrary FunctionLibrary;

		@FindBy(name = "title")
		WebElement txtTitle;
		
		@FindBy(xpath = "//a[text()='add movie']")
		WebElement lnkAddMovie;		

		@FindBy(name = "director")
		WebElement txtDirector;
		
		@FindBy(xpath = "//textarea[@name='description']")
		WebElement txtDescription;
		
		@FindBy(name = "file")
		WebElement txtFile;
		
		
		@FindBy(xpath = "//label[@for='title']")
		WebElement lblTitle;
		
		@FindBy(xpath = "//option[@value='Comedy']")
		WebElement txtComedy;
		
		@FindBy(xpath = "//button[text()='Save Movie']")
		WebElement btnSave;
		
		@FindBy(xpath = "//*[name()='svg']")
		List<WebElement> btnRatings;
		
		@FindBy(xpath = "//select[@name='categories']")
		WebElement listCatogery;
		

		// constructor

		public AddMovie(WebDriver driver, ExtentTest logger) {
			this.logger = logger;
			this.localdriver = driver;
			
			// This initElements method will create all WebElements
			PageFactory.initElements(driver, this);
			FunctionLibrary = new functionLibrary(driver,logger);
		}

		// Click on Add movie
		public void clickAddMovie() {
			try {
				FunctionLibrary.waitTillElementFound(lnkAddMovie, 3);
				lnkAddMovie.click();
				FunctionLibrary.waitTillElementFound(lblTitle, 10);
				if (lblTitle.isDisplayed()) {
					String  screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "AddMoviePageOpened_Successful");
					logger.log(Status.PASS, "Add movie Page is opened",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} else {
					String  screenshotPath = ScreenshotUtility.getScreenshot(localdriver, "AddMoviePageOpened_Unsuccessful");
					logger.log(Status.FAIL, "Add movie Page is not opened",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.FAIL, "Add movie page is not opened " + e.getMessage());
			}
		}
		
		//Add all Details
		public void addDetails(String Title, String Director, String Description, String Categories, String ImageUrl, String Rating) {
			try {
				txtTitle.sendKeys(Title);
				txtDirector.sendKeys(Director);
				txtDescription.sendKeys(Description);
				txtFile.sendKeys(ImageUrl);
				FunctionLibrary.selectElementByNameMethod(listCatogery, Categories);
				if(Categories=="Comedy") {
					txtComedy.click();
				}
		
				btnRatings.get( Integer.parseInt( Rating)).click();
				btnSave.click();
				
			}catch (Exception e) {
				e.printStackTrace();
				logger.log(Status.FAIL, "All details are not Entered " + e.getMessage());
			}
		}
	}
