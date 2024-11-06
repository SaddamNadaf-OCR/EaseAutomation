package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CustomStatisticalDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRExportTarrifCode = "//input[@id='searchCustomStatsDetail_custStats_exportTariffCode']";
	public static final String OCRDescription = "//textarea[@id='searchCustomStatsDetail_custStats_description']";
	public static final String OCRstatus = "//select[@id='searchCustomStatsDetail_custStats_status']";
	public static final String OCRsortBy = "//select[@id='searchCustomStatsDetail_sortedBy']";
	public static final String OCRDirection = "//select[@name='direction']";

	// ------------------------------Add
	// locators----------------------------------------
	public static final String OCRaddbtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRExportTarrifCode1 = "//input[@id='_custStats_exportTariffCode']";
	public static final String OCRdescription1 = "//textarea[@id='_custStats_description']";
	public static final String OCRlanguage = "//select[@id='_languageCode']";
	public static final String OCRcountry = "//input[@id='_countryName']";
	public static final String OCRsave = "//button[@name='save']";

	// --------------------Constructor------------------------------------

	public CustomStatisticalDetailsPage(WebDriver driver, ExtentTest test) {
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

	public void searchbyParameters(String ExpTrafficCode, String Description, String Status, String SortBy,
			String Direction) {

		typeText(driver, test, OCRExportTarrifCode, "Entering codetype :", ExpTrafficCode);
		Wait.waitfor(2);
		typeText(driver, test, OCRDescription, "Entering codetype :", Description);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRstatus, "selecting Status by dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRsortBy, "selecting Config For by dropdown", SortBy);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRDirection, "selecting Status by dropdown :", Direction);
		Wait.waitfor(2);

	}

	public void ADDbyParameters( String Description, String Language, String Country) {

		typeText(driver, test, OCRExportTarrifCode1, "Entering codetype :",  randomnumbers());
		Wait.waitfor(2);
		typeText(driver, test, OCRdescription1, "Entering codetype :", Description);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRlanguage, "selecting Status by dropdown :", Language);
		Wait.waitfor(2);
		typeText(driver, test, OCRcountry, "Entering country :", Country);
		Wait.waitfor(2);
	}
}
