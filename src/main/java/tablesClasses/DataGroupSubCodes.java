package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DataGroupSubCodes extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRsearch="//button[@name='save']";
	public static final String OCRaddbutton="//button[@name='Ok']";
	public static final String OCRroupcode="//input[@id='resultDataGroupSubCodes_dataGroupSubCodesValue_groupCode']";
	public static final String OCRsubcode="//input[@id='resultDataGroupSubCodes_dataGroupSubCodesValue_subCode']";
	public static final String OCRstatus="//select[@id='resultDataGroupSubCodes_dataGroupSubCodesValue_status']";
	public static final String OCRcoutrycode="//input[@id='resultDataGroupSubCodes_country']";
	public static final String OCRdescription="//input[@id='resultDataGroupSubCodes_dataGroupSubCodesValue_description']";
	public static final String OCRregulatorycode="//input[@id='resultDataGroupSubCodes_dataGroupSubCodesValue_regulatoryCode']";
	public static final String OCRsortby="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	
	//--------------------Constructor------------------------------------
	
	public DataGroupSubCodes(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
			
	}

//....................click on search button......................
	public void searchbutton() {
		clickElement(driver, test, OCRsearch, "clicking on search button :");
		
			}
	
	public void addbutton() {
		clickElement(driver, test, OCRaddbutton, "clicking on add button :");
		
			}
	//.....................searchParameter...............................//
	public void searchbyParameters(String GroupCode, String Subcode, String status, String SortBy, String direction) {
			typeText(driver, test, OCRroupcode, "Entering group code :", GroupCode);
			Wait.waitfor(2);
			typeText(driver, test, OCRsubcode, "Entering description", Subcode);
			Wait.waitfor(2);
			
			selectByVisibleText(driver, test, OCRstatus, "selecting Status by dropdown :", status );
			Wait.waitfor(2);
			
			selectByVisibleText(driver, test, OCRsortby, "selecting SortBy by dropdown :", SortBy );
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction );
			Wait.waitfor(2);
							
			}
}
	