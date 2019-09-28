package functionLibrary;



import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import java.util.*;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class functionLibrary {
	
public static WebDriver driver;
public static ExtentTest logger;
	
	
public functionLibrary(WebDriver driver, ExtentTest logger){
	this.driver = driver;
	this.logger = logger;
}
	

/*==========================================================================================================================================================
Method Name: waitForElement()
Description: Method used to wait until element is found
Parameters:WebElement
Usage: 

Creation Date:
Modification History:
==========================================================================================================================================================*/
	
public static void waitForElement(WebElement element) {
	try {
		logger.log(Status.INFO, "Waiting for Element to be found");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}

/*==========================================================================================================================================================
Method Name: switchToNewWindow()
Description: Method used to switch to new window
Parameters:
Usage: 

Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void switchToNewWindow() {
	try {
		logger.log(Status.INFO, "Switching to New window");
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w2);
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}

/*==========================================================================================================================================================
Method Name: switchToOldWindow()
Description: Method used to switch back to previous Window
Parameters:
Usage: 

Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void switchToOldWindow() {
	try {
		logger.log(Status.INFO, "Switching Back to Old window");
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w1);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: switchToParentWindow()
Description: Method used to switch back to parent Window
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void switchToParentWindow() {
	try {
		logger.log(Status.INFO, "Switching to Parent window");
		driver.switchTo().defaultContent();
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}

/*==========================================================================================================================================================
Method Name: waitTillElementFound()
Description: Method use to wait for the user specified time for the element to be found
Parameters:WebElement, Time in seconds
Usage: 

Creation Date:
Modification History:
==========================================================================================================================================================*/
public void waitTillElementFound(WebElement ElementTobeFound,int seconds) {
	try {
		logger.log(Status.INFO, "Waiting for Element to be found");
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: takeScreenshotOfWebelement()
Description: Method used to take the screenshot of WebElement
Parameters:	WebDriver, WebElement, Destination
Usage: 

Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void takeScreenshotOfWebelement(WebDriver driver,
	WebElement element, String Destination) {
	try {
		logger.log(Status.INFO, "Taking the Screenshot of the Webelement");
		File v = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage bi = ImageIO.read(v);
		org.openqa.selenium.Point p = element.getLocation();
		int n = element.getSize().getWidth();
		int m = element.getSize().getHeight();
		BufferedImage d = bi.getSubimage(p.getX(), p.getY(), n, m);
		ImageIO.write(d, "png", v);
		FileUtils.copyFile(v, new File(Destination));
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: setWindowSize() 
Description: Method used to set the user specified size of the window
Parameters: Dimension1, Dimension2
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void setWindowSize(int Dimension1, int dimension2) {
	try {
		logger.log(Status.INFO, "Setting the size of the Window");
		driver.manage().window().setSize(new Dimension(Dimension1, dimension2));
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: takeScreenshotMethod()
Description: Metod used to take the screenshot of the page in view
Parameters: Destination
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void takeScreenshotMethod(String Destination) {
	try {
		logger.log(Status.INFO, "Taking the screenshot of the page in view");
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(Destination));
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: pressKeyDown()
Description: Method used to press the Down key
Parameters: WebElement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void pressKeyDown(WebElement element) {
	try {
		logger.log(Status.INFO, "Pressig the Down Key");
		element.sendKeys(Keys.DOWN);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: pressKeyEnter()
Description: Method used to Press Enter key
Parameters:	WebElement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public void pressKeyEnter(WebElement element) {
	try {
		logger.log(Status.INFO, "Pressig the Enter Key");
		element.sendKeys(Keys.ENTER);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
 }
 /*==========================================================================================================================================================
Method Name: pressKeyUp
Description: Method used to Press the Up key
Parameters:	WebElement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void pressKeyUp(WebElement element) {
	try {
		logger.log(Status.INFO, "Pressig the Up Key");
		element.sendKeys(Keys.UP);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: moveToTab()
Description: Method used to press Tab
Parameters:	WebElement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void moveToTab(WebElement element) {
	try {
		logger.log(Status.INFO, "Pressig the Tab Key");
		element.sendKeys(Keys.chord(Keys.ALT, Keys.TAB));
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: handleHTTPS_IEbrowser()
Description: 
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void handleHTTPS_IEbrowser() {
	try {
		driver.navigate().to(
		"javascript:document.getElementById('overridelink').click()");
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: handleHTTPS_Firefox()
Description: 
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void handleHTTPS_Firefox() {
	try {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(false);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: waitTillPageLoad()
Description: Method used to wait till page is loaded for user specified time
Parameters:	Int i
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void waitTillPageLoad(int i) {
	try {
		logger.log(Status.INFO, "Wait till page is loaded");
		driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: clickAllLinksInPage()
Description: Method used to click all the Links present on Page and screenshot is taken
Parameters:	String destinationofScreenshot
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void clickAllLinksInPage(String destinationOfScreenshot) {
	try {
		logger.log(Status.INFO, "Clicking on All links of Page and taking Screenshot");
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links :" + Links.size());
		for (int p = 0; p < Links.size(); p++) {
		System.out.println("Elements present the body :"
		+ Links.get(p).getText());
		Links.get(p).click();
		Thread.sleep(3000);
		System.out.println("Url of the page " + p + ")"
		+ driver.getCurrentUrl());
		takeScreenshotMethod(destinationOfScreenshot + p);
		navigate_back();
		Thread.sleep(2000);
		}
		
		}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: keyboardEvents()
Description: Method used to send keys to WebElement
Parameters: WebElement, Keys, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void keyboardEvents(WebElement webelement, Keys key,String alphabet) {
	try {
		logger.log(Status.INFO, "Sendking keys to WebElement");
		webelement.sendKeys(Keys.chord(key, alphabet));
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: navigate_forward()
Description: Method used to navigate forward from browser history
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void navigate_forward() {
	try {
		logger.log(Status.INFO, "Navigating forward from the Browser history");
		driver.navigate().forward();
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: navigate_back()
Description: Method used to navigate back from Browser History
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void navigate_back() {
	try {
		logger.log(Status.INFO, "Navigating Back from the Browser history");
		driver.navigate().back();
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: refresh()
Description: Method use to reload the current opened page
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void refresh() {
	try {
		logger.log(Status.INFO, "Reloading the current opened page");
		driver.navigate().refresh();
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: waitMyTime()
Description: Method used to wait for a given amount of time
Parameters: Int i
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void waitMyTime(int i) {
	try {
		logger.log(Status.INFO, "Waiting for a given amount of time before performing next action");
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: clearTextField()
Description: Method used to clear the text of Webelement
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void clearTextField(WebElement element) {
	try {
		logger.log(Status.INFO, "Clear the text of Webelement");
		element.clear();
	}catch(Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: clickWebelement()
Description: Method used to click on WebElement
Parameters:	WebElement element
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public void clickWebelement(WebElement element) {
	try {
		//logger.log(Status.INFO, "Clicking the Element");
		element.click();
	} catch (Exception e) {
		logger.log(Status.ERROR, "Element is not enabled");
		e.printStackTrace();
	}
}
/*==========================================================================================================================================================
Method Name: clickMultipleElements()
Description: Method used to click on multiple Element
Parameters:	WebElement, WebElement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void clickMultipleElements(WebElement someElement,WebElement someOtherElement) {
	try {
		logger.log(Status.INFO, "Clicking the Multiple Element");
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(someElement)
		.click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: highlightelement()
Description: Method used to highlight Webelement
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void highlightelement(WebElement element) {
	try {
		logger.log(Status.INFO, "Highlighting the Webelement");
		for (int i = 0; i < 4; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
			"arguments[0].setAttribute(‘style’, arguments[1]);",
			element, "color: solid red; border: 6px solid yellow;");
			js.executeScript(
			"arguments[0].setAttribute(‘style’, arguments[1]);",
			element, "");
		}
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: checkAlert_Accept()
Description: Method used to Click Accept on alert box
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static boolean checkAlert_Accept() {
	try {
		logger.log(Status.INFO, "Clicking Accept button on Alert");
		Alert a = driver.switchTo().alert();
		String str = a.getText();
		a.accept();
		return true;
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
		return false;
	}
}
/*==========================================================================================================================================================
Method Name: checkAlert_Dismiss()
Description: Method used to Click Dismiss on alert box
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static boolean checkAlert_Dismiss() {
	try {
		logger.log(Status.INFO, "Clicking Dismiss button on Alert");
		Alert a = driver.switchTo().alert();
		String str = a.getText();
		System.out.println(str);
		a.dismiss();
		return true;
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
		return false;
	}
}
/*==========================================================================================================================================================
Method Name: scrolltoElement()
Description: Method used to scroll the page to get the element into view
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void scrolltoElement(WebElement ScrolltoThisElement) {
	try {
		logger.log(Status.INFO, "Scroll the page to get element into view");
		Coordinates coordinate = ((Locatable) ScrolltoThisElement).getCoordinates();
		coordinate.onPage();
		coordinate.inViewPort();
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: checkbox_Checking()
Description: Method used to check the checkbox if not checked
Parameters:	WebElement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void checkbox_Checking(WebElement checkbox) {
	try {
		logger.log(Status.INFO, "Checking the checkbox");
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			logger.log(Status.INFO, "Checkbox is already checked");
		} else {
			checkbox.click();
			logger.log(Status.INFO, "Checked the checkbox");
		}
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: radiobutton_Select()
Description: Method used to select Radio button
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void radiobutton_Select(WebElement Radio) {
	try {
		logger.log(Status.INFO, "Selecting the Radio button");
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			Radio.click();
			System.out.println("Selected the Radiobutton");
		}
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: checkbox_Unchecking()
Description: Method used to Uncheck the checkbox if checked
Parameters: Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void checkbox_Unchecking(WebElement checkbox) {
	try {
		logger.log(Status.INFO, "Unchecking the CheckBox");
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: radioButton_Deselect()
Description: Method used to Deselect the Radio button if already selected
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void radioButton_Deselect(WebElement Radio) {
	try {
		logger.log(Status.INFO, "Deselecting the Radio Button");
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Radio.click();
			logger.log(Status.INFO, "Radio Button is deselected");
		} else {
			logger.log(Status.INFO, "Radio Button was already Deselected");
		}
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: dragAndDrop() 
Description: Method used to Drag from one webelement and drop to another Webelement
Parameters:	Webelement, Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void dragAndDrop(WebElement fromWebElement, WebElement toWebElement) {
	try {
		logger.log(Status.INFO, "Drag the element");
		Actions builder = new Actions(driver);
		builder.dragAndDrop(fromWebElement, toWebElement);
	} catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: dragAndDrop_Method2()
Description: Method used to Drag from one webelement and drop to another Webelement
Parameters:	Webelement, Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void dragAndDrop_Method2(WebElement fromWebElement, WebElement toWebElement) {
	try {
		logger.log(Status.INFO, "Drag the element");
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();
		dragAndDrop.perform();
	}catch (Exception e) {
			logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: dragAndDrop_Method3()
Description: Method used to Drag from one webelement and drop to another Webelement
Parameters:	Webelement, Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void dragAndDrop_Method3(WebElement fromWebElement, WebElement toWebElement){
	try {
		logger.log(Status.INFO, "Drag the element");
		Actions builder = new Actions(driver);
		builder.clickAndHold(fromWebElement).moveToElement(toWebElement).perform();
		Thread.sleep(2000);
		builder.release(toWebElement).build().perform();
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: hoverWebelement()
Description: Method used to Hover the Webelement
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void hoverWebelement(WebElement HovertoWebElement){
	try {
		logger.log(Status.INFO, "Hovering the WebElement");
		Actions builder = new Actions(driver);
		builder.moveToElement(HovertoWebElement).perform();
		Thread.sleep(2000);
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: doubleClickWebelement()
Description: Method used to double click on Webelement
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void doubleClickWebelement(WebElement doubleclickonWebElement) {
	try {
		logger.log(Status.INFO, "Double clicking the given Webelement");
		Actions builder = new Actions(driver);
		builder.doubleClick(doubleclickonWebElement).perform();
		Thread.sleep(2000);
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: getToolTip()
Description: Method used to get the title of tooltip
Parameters:	Webelement
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static String getToolTip(WebElement toolTipofWebElement) {
	String tooltip=null;
	try {
		logger.log(Status.INFO, "Getting the Titlte of Tooltip");
		tooltip = toolTipofWebElement.getAttribute("title");	
		
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
	return tooltip;
}
/*==========================================================================================================================================================
Method Name: selectElementByNameMethod()
Description: Method used to Select the option by Name method
Parameters:	Webelement, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void selectElementByNameMethod(WebElement element, String Name) {
	try {
		logger.log(Status.INFO, "Selecting the webelement by its Name");
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: selectElementByValueMethod()
Description: Method used to Select the option by Value method
Parameters:	Webelement, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void selectElementByValueMethod(WebElement element, String value) {
	try {
		logger.log(Status.INFO, "Selecting the webelement by its Value");
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: selectElementByIndexMethod()
Description: Method used to Select the option by Index method
Parameters:	Webelement, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void selectElementByIndexMethod(WebElement element, int index) {
	try {
		logger.log(Status.INFO, "Selecting the webelement by its Index");
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: clickCheckboxFromList()
Description: Method use to check the checkbox from the list
Parameters:	String,String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void clickCheckboxFromList(String xpathOfElement, String valueToSelect) {
	try {
		logger.log(Status.INFO, "Checking the Checkbox from the List");
		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) {
			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
			for (WebElement f : dr) {
				System.out.println("value in the list : " + f.getText());
				if (valueToSelect.equals(f.getText())) {
					f.click();
					break;
				}
			}
		}
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: downloadFile()
Description: Method used to download the file
Parameters:	String, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static void downloadFile(String href, String fileName) throws Exception {
	logger.log(Status.INFO, "Downloading the file");
	URL url = null;
	URLConnection con = null;
	int i;
	url = new URL(href);
	con = url.openConnection();
	File file = new File(".//OutputData//" + fileName);
	BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
	while ((i = bis.read()) != -1) {
		bos.write(i);
	}
	bos.flush();
	bis.close();
}
/*==========================================================================================================================================================
Method Name: navigateToEveryLinkInPage()
Description: Method used to navigate to Every link on Page
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/

public static void navigateToEveryLinkInPage() {
	try {
		logger.log(Status.INFO, "Navigating to all Links on Page");
		ArrayList<Integer> list = new ArrayList<Integer>();

		List<WebElement> linksize = driver.findElements(By.tagName("a"));
		int linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		String[] links = new String[linksCount];
		System.out.println("List of links Available: ");
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		for (int i = 0; i < linksCount; i++) {
			driver.navigate().to(links[i]);
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
		}
	}catch (Exception e) {
		logger.log(Status.ERROR, "Some Error Occured");
	}
}
/*==========================================================================================================================================================
Method Name: readingFromExcel()
Description: Method used to read the data from Excel
Parameters: String, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static List<String> readingFromExcel(String sheetName, String columnName) throws IOException {
	List<String> data = new ArrayList<>();
	Workbook wb = null;
	logger.log(Status.INFO, "Reading data from the Excel");
	try {
		FileInputStream fis = new FileInputStream("File Path");
		wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Iterator<Row> rowIterator = sh.iterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.toString().equalsIgnoreCase(columnName)) {
					int rowNum = cell.getRowIndex();
					for (int i = rowNum; i <= rowNum; i++) {
						for (int j = 1; j < sh.getRow(rowNum).getLastCellNum(); j++) {
							Row row1 = sh.getRow(i);
							Cell cell1 = row1.getCell(j);
							data.add(cell1.toString());
						}
					}
				}
			}
		}
	} catch (Exception e) {
		logger.log(Status.ERROR,"Something went wrong fetching data from Excel");
	} finally {
		wb.close();
	}
	return data;
}
/*==========================================================================================================================================================
Method Name: isPresentPDF()
Description: Method used to verify given text is present in Pdf
Parameters: String, String
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static boolean isPresentPDF(String url, String text) throws IOException {
	boolean flag = false;
	PDFTextStripper pdfStripper = null;
	PDDocument pdDoc = null;
	COSDocument cosDoc = null;
	String parsedText = null;
	logger.log(Status.INFO, "Verifying the content in Pdf");
	try {
		URL url1 = new URL(url);
		RandomAccessRead file = new RandomAccessBuffer(url1.openStream());
		PDFParser parser = new PDFParser(file);

		parser.parse();
		cosDoc = parser.getDocument();
		pdfStripper = new PDFTextStripper();
		pdfStripper.setStartPage(1);
		pdfStripper.setEndPage(1);

		pdDoc = new PDDocument(cosDoc);
		parsedText = pdfStripper.getText(pdDoc);
	} catch (MalformedURLException e2) {
		logger.log(Status.ERROR, e2);
	} catch (IOException e) {
		logger.log(Status.ERROR,"Some Error Occured");
		try {
			if (cosDoc != null)
				cosDoc.close();
			if (pdDoc != null)
				pdDoc.close();
		} catch (Exception e1) {
			logger.error(e);
		}
	}
	if (parsedText != null && parsedText.contains(text)) {
		flag = true;
		pdDoc.close();
		cosDoc.close();
	}
	return flag;
}
/*==========================================================================================================================================================
Method Name: dbConnection()
Description: Method used to create the jdbc connection
Parameters:
Usage: 
Creation Date:
Modification History:
==========================================================================================================================================================*/
public static Connection dbConnection() {
	Connection c = null;
	logger.log(Status.INFO, "Creating the JDBC connection");
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Spares", "postgres", "root");
	} catch (Exception e) {
		logger.log(Status.ERROR, e.getClass().getName() + ": " + e.getMessage());
		System.exit(0);
	}
	logger.log(Status.INFO, "Opened database successfully");
	return c;
}



public void sendText(WebElement element, String text) {
	try {
		TimeUnit.SECONDS.sleep(1);
		if (element != null && text != null) {
			element.sendKeys(text);
		} else {
			
			logger.log(Status.FAIL, "Unable not found");
		}
	} catch (Exception e) {
		logger.error(e);
		logger.log(Status.ERROR, e.getClass().getName() + ": " + e.getMessage());
	}
} 
}
