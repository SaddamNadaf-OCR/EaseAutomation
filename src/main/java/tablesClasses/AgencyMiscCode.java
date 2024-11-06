package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgencyMiscCode extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRCountryCode = "//select[@id='resultAgencyMiscCodes_agencyMiscCodes_countryCode']";
	public static final String OCRCodeType = "//input[@id='resultAgencyMiscCodes_agencyMiscCodes_codeType']";
	public static final String OCRSortby = "//select[@id='resultAgencyMiscCodes_sortBy']";
	public static final String OCRStatus = "//select[@id='resultAgencyMiscCodes_agencyMiscCodes_status']";
	public static final String OCRDirection = "//select[@id='resultAgencyMiscCodes_direction']";
	
	//------------------------------------------add locators--------------------------------------------------------------------------------------------\
	public static final String OCRsavebtn="(//input[@id='mybuttonsmall'])[1]";
	public static final String OCRcountrycode1="(//input[@id='editAgencyMiscCodes_countryName'])[1]";
	public static final String OCRCodetype1="(//a[@id='codeTypePopup'])[1]";
	public static final String OCRbtnClose="(//button[@class='btn-close'])[1]";
	public static final String OCRCodeDescription1="(//textarea[@id='editAgencyMiscCodeTypes_agencyMiscCodeTypes_codeTypeDesc'])[1]";
	public static final String OCRselectbtn	="(//button[@name='Ok'])[1]";
	public static final String OCRcode="(//input[@id='editAgencyMiscCodes_agencyMiscCodes_code'])[1]";
	public static final String OCRregulatorycode="(//input[@id='editAgencyMiscCodes_agencyMiscCodes_regulatoryCode'])[1]";

	// --------------------Constructor------------------------------------

	public AgencyMiscCode(WebDriver driver, ExtentTest test) {
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

	// .....................searchParameter...............................//
	public void searchbyParameters(String ConutryCode, String CodeType, String Status, String SortBy,
			String Direction) {
		selectByVisibleText(driver, test, OCRCountryCode, "selecting Country code from dropdown", ConutryCode);
		Wait.waitfor(2);
		typeText(driver, test, OCRCodeType, "Entering codetype :", CodeType);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRStatus, "selecting Status by dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRSortby, "selecting Config For by dropdown", SortBy);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRDirection, "selecting Status by dropdown :", Direction);
		Wait.waitfor(2);

	}
	public void ADDCodeType(String CodeType) {
		Wait.waitfor(3);
		String addCA = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + CodeType + "')]";
		try {
			if (isDisplayed(driver, addCA)) {
				clickElement(driver, test, addCA, "Click on search record");
				test.log(LogStatus.PASS, "Add code type in add to result grid table : " + CodeType);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add country grp code in result grid table : " + CodeType);
			clickElement(driver, test, OCRbtnClose, "Click on POP up close Icon");
		}}
	public void clickcodeType() {
		Wait.waitfor(3);
		clickElement(driver, test, OCRCodetype1, "Click on codeType: ");
	}
	public void select() {
		// TODO Auto-generated method stub
		clickElement(driver, test, OCRselectbtn, "Clicking on Select Button");
	}
	public void save() {
		clickElement(driver, test, OCRsavebtn, "Clicking on save Button");
	}
	//--------------------------------Add controlling agency parameter----------------------------------------------------
	
	public void AddAgencymiscCodeParameters(String CountryCode, String Code,String RegulatoryCode) {
		typeText(driver, test, OCRcountrycode1, "Enteringcountrycode:", CountryCode);
		Wait.waitfor(2);
		typeText(driver, test, OCRcode, "Entering Name", Code);
		Wait.waitfor(2);
		typeText(driver, test, OCRregulatorycode, "Entering Country:", RegulatoryCode);
		Wait.waitfor(2);

	}
	
}