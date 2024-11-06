/* Project : EASE
 * Author  : Maheswara
 * Created date : SEP 2018
 * Descriptions : Test Base class
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenericMethods {

	public static final String OCR_VisitorInfo_DatePickerYear = "//select[@class='ui-datepicker-year']";
	public static final String OCR_VisitorInfo_DatePickerMonth = "//select[@class='ui-datepicker-month']";

	public static final String OCR_VisitorInfo_Year = "(//select[@class='yearselect'])[1]";
	public static final String OCR_VisitorInfo_Month = "(//select[@class='monthselect'])[1]";

	// Selecting the Date
	public static void date(WebDriver driver, ExtentTest test, String logger, String date) {
		if (date.length() > 0) {
			StringTokenizer st = new StringTokenizer(date, "/");
			String[] str = new String[3];
			int i = 0;
			while (st.hasMoreElements()) {
				str[i] = st.nextToken();
				i++;
			}
			String day = null;
			if (str[0].charAt(0) == '0') {
				day = str[0].substring(1, str[0].length());
			} else {
				day = str[0];
			}
			String month = null;
			if (str[1].charAt(0) == '0') {
				month = str[1].substring(1, str[1].length());
			} else {
				month = str[1];
			}
			String dayLocator = "//a[contains(text(),'" + Integer.parseInt(day) + "')]";
			new Select(driver.findElement(By.xpath(OCR_VisitorInfo_DatePickerYear))).selectByVisibleText(str[2]);
			new Select(driver.findElement(By.xpath(OCR_VisitorInfo_DatePickerMonth)))
					.selectByIndex(Integer.parseInt(month) - 1);
			driver.findElement(By.xpath(dayLocator)).click();
			test.log(LogStatus.PASS, logger + date);
		}
	}

	// Selecting the Date From Pop Up
	public static void dateInPopUp(WebDriver driver, ExtentTest test, String logger, String date) {
		if (date.length() > 0) {
			StringTokenizer st = new StringTokenizer(date, "/");
			String[] str = new String[3];
			int i = 0;
			while (st.hasMoreElements()) {
				str[i] = st.nextToken();
				i++;
			}
			String day = null;
			if (str[0].charAt(0) == '0') {
				day = str[0].substring(1, str[0].length());
			} else {
				day = str[0];
			}
			String month = null;
			if (str[1].charAt(0) == '0') {
				month = str[1].substring(1, str[1].length());
			} else {
				month = str[1];
			}
			String dayLocator = "(//table[@class='table-condensed']//tr/td[contains(text(),'" + Integer.parseInt(day)
					+ "')])[1]";
			new Select(driver.findElement(By.xpath(OCR_VisitorInfo_Year))).selectByVisibleText(str[2]);
			new Select(driver.findElement(By.xpath(OCR_VisitorInfo_Month))).selectByIndex(Integer.parseInt(month) - 1);
			driver.findElement(By.xpath(dayLocator)).click();
			test.log(LogStatus.PASS, logger + date);
		}
	}

	// Selecting the Date
	public static void dateOfMonthName(WebDriver driver, ExtentTest test, String logger, String date) {
		if (date.length() > 0) {
			StringTokenizer st = new StringTokenizer(date, "/");
			String[] str = new String[3];
			int i = 0;
			while (st.hasMoreElements()) {
				str[i] = st.nextToken();
				i++;
			}
			String day = null;
			if (str[0].charAt(0) == '0') {
				day = str[0].substring(1, str[0].length());
			} else {
				day = str[0];
			}
			String dayLocator = "//a[contains(text(),'" + Integer.parseInt(day) + "')]";
			new Select(driver.findElement(By.xpath(OCR_VisitorInfo_DatePickerYear))).selectByVisibleText(str[2]);
			new Select(driver.findElement(By.xpath(OCR_VisitorInfo_DatePickerMonth))).selectByVisibleText(str[1]);
			Wait.waitfor(3);
			driver.findElement(By.xpath(dayLocator)).click();
			test.log(LogStatus.PASS, logger + date);
		}
	}

	// Scroll up to element method.
	public static void scrollToElement(WebDriver driver, String locator) {
		Wait.wait(driver, locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(locator)));
		Wait.waitfor(3);
	}

	// Scroll up to Top of Page.
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");
		Wait.waitfor(3);
	}

	// Scroll up to Bottom of Page.
	public static void scrollToBottom(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Wait.waitfor(3);
	}

	// Splitting the strings into Array List.
	public static ArrayList<String> stringtoken(String StringName) {
		StringTokenizer st1 = new StringTokenizer(StringName, "|");
		ArrayList<String> listofNames = new ArrayList<String>();

		while (st1.hasMoreElements()) {
			listofNames.add(st1.nextToken());
		}
		return listofNames;
	}

	// Select By Visible Text for list of Drop Down values method.
	public void selectByVisibleText(WebDriver driver, ExtentTest test, String locator, String logger,
			String SelectList) {
		try {
			if (SelectList.length() > 0) {
				ArrayList<String> select = stringtoken(SelectList);
				for (int i = 0; i < select.size(); i++) {
					Wait.wait(driver, locator);
					new Select(driver.findElement(By.xpath(locator))).selectByVisibleText(select.get(i).trim());
					test.log(LogStatus.PASS, logger + select.get(i));
				}
			} else {
				test.log(LogStatus.INFO, logger + "Not Required");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Select option is not avaliable for " + logger + " : " + SelectList);
			testFailSshot(driver, test);
		}
	}

	// Getting the first value selected in the Drop down
	public String getSelectFirstText(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		test.log(LogStatus.PASS, logger + defaultItem);
		return defaultItem;
	}

	// Clicking on web element method
	public void clickElement(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		driver.findElement(By.xpath(locator)).click();
		test.log(LogStatus.PASS, logger);
	}

	// Enter the Description in the Text field method
	public void typeText(WebDriver driver, ExtentTest test, String locator, String logger, String Text) {
		if (Text.length() > 0) {
			Wait.wait(driver, locator);
			driver.findElement(By.xpath(locator)).sendKeys(Text);
			test.log(LogStatus.PASS, logger + Text);
		} else {
			test.log(LogStatus.INFO, logger + "Not Required");
		}
	}

	// Getting the Text from the HTML Page method
	public String getText(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		String text = driver.findElement(By.xpath(locator)).getText();
		test.log(LogStatus.PASS, logger + text);
		return text;
	}

	// Checking the checkBox and Radio Button isSelected or not method.
	public boolean isSelected(WebDriver driver, String locator) {
		Wait.wait(driver, locator);
		return driver.findElement(By.xpath(locator)).isSelected();
	}

	// Checking the webElement isDisplayed or not method.
	public boolean isDisplayed(WebDriver driver, String locator) {
		Wait.wait(driver, locator);
		return driver.findElement(By.xpath(locator)).isDisplayed();
	}

	// Checking the webElement isEnabled or not method.
	public boolean isEnabled(WebDriver driver, String locator) {
		Wait.wait(driver, locator);
		return driver.findElement(By.xpath(locator)).isEnabled();
	}

	// Mouse over to web Element
	public void mouseOver(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		new Actions(driver).moveToElement(driver.findElement(By.xpath(locator))).build().perform();
		test.log(LogStatus.PASS, logger);
	}

	// Mouse over to web Element and Click
	public void mouseOverAndClick(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		new Actions(driver).moveToElement(driver.findElement(By.xpath(locator))).click().build().perform();
		test.log(LogStatus.PASS, logger);
	}

	// Switch to alert and Accepting the Alert
	public void AlertPopUp(WebDriver driver, ExtentTest test, String Text) {
		Alert a1 = driver.switchTo().alert();
		String text = a1.getText();
		if (text.contains(Text)) {
			a1.accept();
			test.log(LogStatus.PASS, Text + " : Accept the alert");
		} else {
			testFailSshot(driver, test);
			a1.dismiss();
			test.log(LogStatus.FAIL, Text + " : Dismiss the alert");
		}
	}

	// Validating Available Field list "labels" is Displayed or not in the web Page
	// Method.
	public void validating_AvailFieldlist(WebDriver driver, ExtentTest test, String CheckFieldLabel) {

		ArrayList<String> FieldList = stringtoken(CheckFieldLabel);
		Wait.waitfor(3);
		for (int i = 0; i < FieldList.size(); i++) {
			try {
				String availFieldlist = "//label[contains(text(),' " + FieldList.get(i).trim() + "')]";
				if (isDisplayed(driver, availFieldlist)) {
					test.log(LogStatus.FAIL, FieldList.get(i) + " is Displayed");
					testFailSshot(driver, test);
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, FieldList.get(i) + " is not Displayed");
			}
		}
	}

	// Validating Available Field list "labels with Following DIV" is Displayed or
	// not in the web Page Method.
	public void validating_AvailFieldlistWithcheckBox(WebDriver driver, ExtentTest test, String CheckFieldLabel) {

		ArrayList<String> FieldList = stringtoken(CheckFieldLabel);
		Wait.waitfor(3);
		for (int i = 0; i < FieldList.size(); i++) {
			try {
				String availFieldlist = "//label[@class='col-xs-3 control-label fieldset-label']"
						+ "/div[contains(text(),'" + FieldList.get(i).trim() + "')]";
				if (isDisplayed(driver, availFieldlist)) {
					test.log(LogStatus.FAIL, FieldList.get(i) + " is Displayed");
					testFailSshot(driver, test);
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, FieldList.get(i) + " is not Displayed");
			}
		}
	}

	// Clear the text field
	public void clearText(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		driver.findElement(By.xpath(locator)).clear();
		test.log(LogStatus.PASS, logger);
	}

	// Get the value by using Get Attribute method
	public String getAttribute(WebDriver driver, ExtentTest test, String locator, String value, String logger) {
		Wait.wait(driver, locator);
		String val = driver.findElement(By.xpath(locator)).getAttribute(value);
		test.log(LogStatus.PASS, logger + val);
		return val;
	}

	// No of options present in dropDown and return the count.
	public int dropDownCount(WebDriver driver, String locator) {
		Wait.wait(driver, locator);
		Select sbu = new Select(driver.findElement(By.xpath(locator)));
		List<WebElement> lsbu = sbu.getOptions();
		return lsbu.size();
	}

	// verify if options in the Drop Down are sorted as Ascending order
	public static void sortDropDown(WebDriver driver, ExtentTest test, String locator, String RemoveOption) {
		Wait.wait(driver, locator);
		SoftAssert softAssertion = new SoftAssert();
		Select dropdown = new Select(driver.findElement(By.xpath(locator)));
		List<String> ActualList = new ArrayList<String>();
		List<WebElement> allOptionsElement = dropdown.getOptions();

		for (WebElement optionElement : allOptionsElement) {
			String Data = optionElement.getText();
			ActualList.add(Data);
		}
		// Removing "RemoveOption" option as it is not actual option (_-All- ,-Select-
		// ..etc)
		ActualList.remove(RemoveOption);
		// Creating a temp list to sort
		List<String> tempList = new ArrayList<String>(ActualList);
		// Sort list ascending
		Collections.sort(tempList);
		boolean ifSortedAscending = ActualList.equals(tempList);
		if (ifSortedAscending) {
			test.log(LogStatus.PASS, "List is sorted");
			softAssertion.assertTrue(true);
		} else {
			test.log(LogStatus.FAIL, "List is not sorted" + ActualList);
			softAssertion.assertTrue(false);
		}
		softAssertion.assertAll();
	}

	// To take Screenshot and attached to the Extent Report after test fail.
	public void testFailSshot(WebDriver driver, ExtentTest test) {
		try {
			Wait.capture(driver, getClass().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, "Failed to run : " + getClass().getSimpleName() + " "
				+ test.addScreenCapture(System.getProperty("user.dir") + "\\Screenshots\\" + Wait.screenshotname));
	}

	// Generating random numbers
	public String randomnumbers() {
		Random rand = new Random();
		int min = 100;
		int max = 100000;
		int RandomNo = rand.nextInt(max - min + 1) + min;
		String number = Integer.toString(RandomNo);
		return number;
	}

	// Generating random numbers
	public String randomnumbersbetween1_1000() {
		Random rand = new Random();
		int min = 1;
		int max = 1000;
		int RandomNo = rand.nextInt(max - min + 1) + min;
		String number = Integer.toString(RandomNo);
		return number;
	}
	
	// Generating random numbers
		public String randomnumbersbetween1_100() {
			Random rand = new Random();
			int min = 1;
			int max = 100;
			int RandomNo = rand.nextInt(max - min + 1) + min;
			String number = Integer.toString(RandomNo);
			return number;
		}

	// Uploading a file from windows
	public void uploadFile(WebDriver driver, ExtentTest test, String uploadfileName, String logger) {

		Screen s = new Screen();
		String filepath = System.getProperty("user.dir") + "\\config\\";
		Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
		Pattern openButton = new Pattern(filepath + "OpenButton.PNG");
		try {
			s.wait(fileInputTextBox, 20);
			s.type(fileInputTextBox, filepath + uploadfileName);
			s.click(openButton);
			test.log(LogStatus.PASS, logger);
		} catch (FindFailed e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, logger);
		}

	}

	// Uploading a file from windows
	public void addFromExcel(WebDriver driver, ExtentTest test, String uploadfileName, String logger) {

		Screen s = new Screen();
		String filepath = System.getProperty("user.dir") + "\\config\\";
		Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
		Pattern openButton = new Pattern(filepath + "OpenButton.PNG");
		try {
			s.wait(fileInputTextBox, 20);
			s.type(fileInputTextBox, filepath + uploadfileName);
			s.click(openButton);
			test.log(LogStatus.PASS, logger);
		} catch (FindFailed e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, logger);
		}
	}

	// Robot key to press enter
	public void clickEnter() throws Exception {
		Robot robot = new Robot(); // Robot class throws AWT Exception
		robot.delay(5000); // Thread.sleep throws InterruptedException
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(4000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// Validate the default Text of Element
	public void validate_FieldText(WebDriver driver, ExtentTest test, String locator, String logger,
			String CheckFieldText) {

		Wait.wait(driver, locator);
		String ActualFieldText = driver.findElement(By.xpath(locator)).getText();
		if (CheckFieldText.equals(ActualFieldText)) {
			test.log(LogStatus.PASS, logger + CheckFieldText + " is matching");

		} else {
			test.log(LogStatus.FAIL, logger + "Field text is not matching");
		}
	}

	// Clear text field value and set new ---added by Shelma
	public void clearAndSet(WebDriver driver, ExtentTest test, String locator, String logger, String Text) {
		Wait.wait(driver, locator);
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(Text);
		test.log(LogStatus.PASS, logger + Text);
	}

	// Validate the default Text in Field
	public void validate_FieldValue(WebDriver driver, ExtentTest test, String locator, String logger,
			String CheckFieldValue) {

		Wait.wait(driver, locator);
		String ActualFieldValue = driver.findElement(By.xpath(locator)).getAttribute("value");

		if (CheckFieldValue.equals(ActualFieldValue)) {
			test.log(LogStatus.PASS, logger + CheckFieldValue);

		} else {
			test.log(LogStatus.FAIL, logger + "Field value is not matching");
		}
	}

	// Deselect all option from dropdown
	public void deSelectAll(WebDriver driver, ExtentTest test, String locator, String logger) {
		Wait.wait(driver, locator);
		Select selectObject = new Select(driver.findElement(By.xpath(locator)));
		selectObject.deselectAll();
		test.log(LogStatus.PASS, logger);
	}

	// Upload File to application
	public void uploadFile(WebDriver driver, ExtentTest test, String locator, String logger, String Text) {
		Wait.wait(driver, locator);
		String DataPath = System.getProperty("user.dir") + "\\testdata\\Documents\\";
		System.out.println(DataPath);
		driver.findElement(By.xpath(locator)).sendKeys(DataPath + Text);
		Wait.waitfor(8);
		test.log(LogStatus.PASS, logger + Text);
	}
	
	//Get the Text from textBox     ...............Added by Saddam
	public static String getTextfromTextbox(WebDriver driver,ExtentTest test, String locator, String logger) {
		WebElement textbox = driver.findElement(By.xpath(locator));
		String typedText = textbox.getAttribute("value");
		test.log(LogStatus.PASS, logger + typedText);
		return typedText;
	}
	
	// Download a file from windows     ..............Added By Saddam
	public void downloadFile(WebDriver driver, ExtentTest test, String logger) {

		Screen s = new Screen();
		String filepath = System.getProperty("user.dir") + "\\config\\";
		Pattern SaveButton = new Pattern(filepath + "OpenButton.PNG");
		try {
			s.click(SaveButton);
			test.log(LogStatus.PASS, logger);
		} catch (FindFailed e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, logger);
		}
	}

}
