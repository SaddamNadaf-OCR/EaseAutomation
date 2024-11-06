package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DocumentationReqFormLevel  extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@name='Search.x'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@name='add'])[1]";
	public static final String OCRcountry = "//input[@id='searchDocumentReqFormLevel_country']";
	public static final String OCRstatus="(//select[@id='searchDocumentReqFormLevel_cmnDocumentReqFormLevel_status'])[1]";
	public static final String OCRform="(//select[@id='searchDocumentReqFormLevel_cmnDocumentReqFormLevel_formId'])[1]";
	public static final String OCRdocuId="(//input[@id='searchDocumentReqFormLevel_cmnDocumentReqFormLevel_documentId'])[1]";
	public static final String OCRsortBy="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	public static final String OCRsave="//button[@id='mybuttonsmall']";
	public static final String OCRmodule="//select[@name='cmnDocumentReqFormLevel.moduleId']";
	
	//---------------------------------------Add Locator-----------------------------------
	public static final String OCRmodule1="//select[@id='editDocumentReqFormLevel_cmnDocumentReqFormLevel_moduleId']";
	public static final String OCRCountry="//input[@id='editDocumentReqFormLevel_country']";
	public static final String OCRdocId="//input[@id='editDocumentReqFormLevel_cmnDocumentReqFormLevel_documentId']";
	public static final String OCRfromid="//select[@id='formId']";
	public static final String OCRReckeeping="//select[@id='editDocumentReqFormLevel_cmnDocumentReqFormLevel_recordKeepingType']";
	public static final String OCRRemarks="//textarea[@id='editDocumentReqFormLevel_cmnDocumentReqFormLevel_remarks']";
	
	
	
	// --------------------Constructor------------------------------------
	

	public DocumentationReqFormLevel (WebDriver driver, ExtentTest test) {
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

	public void searchbyParameters( String Country, String Status, String Module, String Form, String DocumentId ,String sortby, String direction) {

		typeText(driver, test, OCRcountry, "Entering doc type code :", Country);
		Wait.waitfor(2);				
		selectByVisibleText(driver, test, OCRstatus, "selecting set id For by dropdown", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRmodule, "selecting Status by dropdown :", Module);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRform, "selecting created by dropdown :", Form);
		Wait.waitfor(2);
		typeText(driver, test, OCRdocuId, "Entering doc type code :", DocumentId);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRsortBy, "selecting sortby  dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction);
		Wait.waitfor(2);
	}
	
	public void AddbyParameters(String Module, String Country, String DocId, String Form, String RecordKeepingType, String Remarks ) {
		
		selectByVisibleText(driver, test, OCRmodule1, "selecting set id For by dropdown", Module);
		Wait.waitfor(2);
		typeText(driver, test, OCRCountry, "Entering doc type code :", Country);
		Wait.waitfor(2);				
		typeText(driver, test, OCRdocId, "Entering doc type code :", DocId);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRfromid, "selecting Status by dropdown :", Form);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRReckeeping, "selecting created by dropdown :", RecordKeepingType);
		Wait.waitfor(2);
		typeText(driver, test, OCRRemarks, "Entering doc type code :", Remarks);
		Wait.waitfor(2);
		
	}
	
}