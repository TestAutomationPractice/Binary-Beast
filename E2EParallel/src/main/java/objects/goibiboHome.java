package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class goibiboHome extends TestBase {

	@FindBy(xpath="//input[@id='gosuggest_inputSrc']")

	WebElement txtFrom;

	@FindBy(xpath = "//input[@id='gosuggest_inputDest']")

	WebElement txtDestination;

	@FindBy(xpath = "//input[@placeholder='Departure']")

	WebElement txtDeparture;
	
	@FindBy(xpath = "//input[@placeholder='Return']")

	WebElement txtReturn;
	
	
	@FindBy(xpath = "//span[contains(@class,'blueGrey')]")

	WebElement txtTraveller;
	
	
	@FindBy(xpath = "//button[@value='Search']")

	WebElement btnSearch;
	
	
}
