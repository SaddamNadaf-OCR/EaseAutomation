package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HazmatPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRhazmatId="//input[@id='searchHazmat_hazmat_ocrHazmatUnqId']";
	public static final String OCRhazIdno="//input[@id='searchHazmat_hazmat_identificationNumber']";
	public static final String OCRcountry="//select[@id='countrydropdown']";
	public static final String OCRsymbol="//input[@id='searchHazmat_hazmat_hazmatSymbol']";
	public static final String OCRRegulation="//select[@id='regulationId']";
	public static final String OCRststyus="//select[@id='searchHazmat_hazmat_status']";
	public static final String OCRortby="//select[@name='sortBy']";
	public static final String OCRdirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
	public static final String OCRHazmatId="//input[@id='editHazmat_hazmat_ocrHazmatUnqId']";
	public static final String OCRCountry="//input[@id='editHazmat_']";
	public static final String OCRSymbol="//input[@id='editHazmat_hazmat_hazmatSymbol']";
	public static final String OCRDesrndShippingName="//textarea[@id='editHazmat_hazmat_desProperShippingName']";
	public static final String OCRregulation="//input[@id='editHazmat_hazmat_regulation']";
	public static final String OCRsavebtn="//button[@name='save']";
	
	
	// --------------------Constructor------------------------------------
	

	public HazmatPage(WebDriver driver, ExtentTest test) {
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

	public void searchbyParameters(String HazmatID, String IdentificationNo, String Country, String Symbol, String Regulation, String Status, String sortby, String direction) {

		typeText(driver, test, OCRhazmatId, "Entering doc type code :", HazmatID);
		Wait.waitfor(2);	
		typeText(driver, test, OCRhazIdno, "Entering doc type description :", IdentificationNo);
		Wait.waitfor(2);	
		selectByVisibleText(driver, test, OCRcountry, "selecting set id For by dropdown", Country);
		Wait.waitfor(2);
		typeText(driver, test, OCRsymbol, "Entering doc type description :", Symbol);
		Wait.waitfor(2);	
		selectByVisibleText(driver, test, OCRRegulation, "selecting Status by dropdown :", Regulation);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRststyus, "selecting created by dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRortby, "selecting sortby  dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRdirection, "selecting direction by dropdown :", direction);
		Wait.waitfor(2);
	}
	// .....................addParameter...............................//

	public void addbyParameters(String Country, String Description, String Regulation) {

		typeText(driver, test, OCRHazmatId, "Entering hazmat ID:", randomnumbers());
		Wait.waitfor(2);	
		typeText(driver, test, OCRCountry, "Entering country :", Country);
		Wait.waitfor(2);
		typeText(driver, test, OCRDesrndShippingName, "Entering Description and shipping name:", Description);
		Wait.waitfor(2);	
		scrollToElement(driver, OCRregulation);
		typeText(driver, test, OCRregulation, "Entering Regulation:", Regulation);
		Wait.waitfor(2);
	
		
	}
	public void scrolltosavebtn() {
		scrollToElement(driver, OCRsavebtn);
	}
}
	
	
	