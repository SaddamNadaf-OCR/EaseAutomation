package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DataEntryCentrePage  extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRDecCode="//input[@id='searchDataEntryCenter_dataEntryCenter_decCode']";
	public static final String OCRDecName="//input[@id='searchDataEntryCenter_dataEntryCenter_decName']";
	public static final String OCRCountry="//input[@id='searchDataEntryCenter_dataEntryCenter_decCountryName']";
	public static final String OCRsortby="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	
	//------------------------------Add locator------------------------------------
	public static final String OCRsave="//button[@name='save.x']";
	public static final String OCRDecCode1="//input[@id='editDataEntryCenter_dataEntryCenter_decCode']";
	public static final String OCRfilterId="//input[@id='editDataEntryCenter_dataEntryCenter_filerId']";
	public static final String OCRaddress="//input[@id='editDataEntryCenter_dataEntryCenter_decAddr1']";
	public static final String OCRcity="//input[@id='editDataEntryCenter_dataEntryCenter_decCity']";
	
	// --------------------Constructor------------------------------------

		public DataEntryCentrePage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;

		}

		// ....................click on search button......................
		public void searchbutton() {
			clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
		}

		public void addbutton() {
			clickElement(driver, test, OCRAddAgencybtn, "clicking on Add button :");
		}

		public void savebtn() {
			clickElement(driver, test, OCRsave, "clicking on save button :");
		}
	
		// .....................searchParameter...............................//

		public void searchbyParameters(String DecCode, String DecName, String Country, String SortBy, String Direction) {

			typeText(driver, test, OCRDecCode, "Entering codetype :", DecCode);
			Wait.waitfor(2);
			typeText(driver, test, OCRDecName, "Entering codetype :", DecName);
			Wait.waitfor(2);
			typeText(driver, test, OCRCountry, "Entering codetype :", Country);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRsortby, "selecting Config For by dropdown", SortBy);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRDirection, "selecting Status by dropdown :", Direction);
			Wait.waitfor(2);

		}
		public void AddbyParameters(String DecAddress, String FilterId) {

			typeText(driver, test, OCRDecCode1, "Entering codetype :", randomnumbers());
			Wait.waitfor(2);
			typeText(driver, test, OCRaddress, "Entering codetype :", DecAddress);
			Wait.waitfor(2);
			typeText(driver, test, OCRfilterId, "Entering codetype :", FilterId);
			Wait.waitfor(2);
		}
		}
	