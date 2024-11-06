package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class StateProvincePgae extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRcountryname="//input[@id='resultStateProvince_stateProvince_countryName']";
	public static final String OCRstatecode="//input[@id='resultStateProvince_stateProvince_stateCode']";
	public static final String OCRstatename="//input[@id='resultStateProvince_stateProvince_stateName']";
	public static final String OCRststyus="//select[@id='resultStateProvince_stateProvince_status']";
	public static final String OCRortby="//select[@name='sortBy']";
	public static final String OCRdirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
	public static final String OCRcountryname1="//input[@id='editStateProvince_countryName']";
	public static final String OCRstatecode1="//input[@id='editStateProvince_stateProvince_stateCode']";
	public static final String OCRStatename="//input[@id='editStateProvince_stateProvince_stateName']";
	public static final String OCRsavebtn="//input[@name='save']";
	
	
	// --------------------Constructor------------------------------------
	

	public StateProvincePgae(WebDriver driver, ExtentTest test) {
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
		clickElement(driver, test, OCRsavebtn, "clicking on save button :");
	}

	// .....................searchParameter...............................//

	public void searchbyParameters(String CountryName, String StateCode, String StateName, String Status, String sortby, String direction) {

		typeText(driver, test, OCRcountryname, "Entering country name :", CountryName);
		Wait.waitfor(2);	
		typeText(driver, test, OCRstatecode, "Entering state code:", StateCode);
		Wait.waitfor(2);	
		typeText(driver, test, OCRstatename, "Entering state name :", StateName);
		Wait.waitfor(2);	
		selectByVisibleText(driver, test, OCRststyus, "selecting created by dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRortby, "selecting sortby  dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRdirection, "selecting direction by dropdown :", direction);
		Wait.waitfor(2);
	}
	// .....................addParameter...............................//

	public void addbyParameters(String Countryname, String statecode, String statename) {

		typeText(driver, test, OCRcountryname1, "Entering country name:", Countryname);
		Wait.waitfor(2);	
		typeText(driver, test, OCRstatecode1, "Entering statecode:", statecode);
		Wait.waitfor(2);
		typeText(driver, test, OCRStatename, "Entering statename:", statename);
		Wait.waitfor(2);	
		
	
	
		
	}
	public void scrolltosavebtn() {
		scrollToElement(driver, OCRsavebtn);
	}
}
	
	
