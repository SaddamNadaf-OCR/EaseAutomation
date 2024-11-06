package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgencyMiscCodeTypePage  extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRsearchbtn="(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn="(//button[@class='primary-btn'])[2]";
	public static final String OCRCountryCode="//select[@id='resultAgencyMiscCodeTypes_agencyMiscCodeTypes_countryCode']";
	public static final String OCRCodeType="//input[@id='resultAgencyMiscCodeTypes_agencyMiscCodeTypes_codeType']";
	public static final String OCRCodeDescription="//textarea[@id='resultAgencyMiscCodeTypes_agencyMiscCodeTypes_codeTypeDesc']";
	public static final String OCRSortby="//select[@id='resultAgencyMiscCodeTypes_sortBy']";
	public static final String OCRStatus="//select[@id='resultAgencyMiscCodeTypes_agencyMiscCodeTypes_status']";
	public static final String OCRDirection="//select[@id='resultAgencyMiscCodeTypes_direction']";
	
	//------------------------------------------add locators--------------------------------------------------------------------------------------------\
	public static final String OCRsavebtn="(//input[@id='mybuttonsmall'])[1]";
	public static final String OCRcountrycode1="(//input[@id='editAgencyMiscCodeTypes_countryName'])[1]";
	public static final String OCRCodetype1="(//input[@id='editAgencyMiscCodeTypes_agencyMiscCodeTypes_codeType'])[1]";
	public static final String OCRCodeDescription1="(//textarea[@id='editAgencyMiscCodeTypes_agencyMiscCodeTypes_codeTypeDesc'])[1]";
	
	
	//--------------------Constructor------------------------------------
	
	public AgencyMiscCodeTypePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
			
	}
	//....................click on search button......................
	public void searchbutton() {
		clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
			}
	
	public void savebutton() {
		clickElement(driver, test, OCRsavebtn, "clicking on save button :");
			}
	
	public void addmiscagencytype() {
		clickElement(driver, test, OCRAddAgencybtn, "clicking on add button :");
			}
	//.....................searchParameter...............................//
	public void searchbyParameters(String CodeType, String CodeDescription, String ConutryCode, String Status, String SortBy, String Direction) {
			typeText(driver, test, OCRCodeType, "Entering codetype :", CodeType);
			Wait.waitfor(2);
			typeText(driver, test, OCRCodeDescription, "Entering code description", CodeDescription);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRCountryCode,"selecting Country code from dropdown", ConutryCode);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRStatus, "selecting Status by dropdown :", Status );
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRSortby,"selecting Config For by dropdown", SortBy);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRDirection, "selecting Status by dropdown :", Direction );
			Wait.waitfor(2);
			
	}

//.....................AddParameter...............................//
	
public void AddbyParameters(String ConutryCode, String CodeType, String CodeDescription ) {
	
	typeText(driver, test, OCRCodetype1, "Entering codetype :", CodeType);
	Wait.waitfor(2);
	typeText(driver, test, OCRCodeDescription1, "Entering code description", CodeDescription);
	Wait.waitfor(2);
	selectByVisibleText(driver, test, OCRcountrycode1,"selecting Country code from dropdown", ConutryCode);
	Wait.waitfor(2);
}}

