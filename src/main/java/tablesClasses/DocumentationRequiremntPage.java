package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class DocumentationRequiremntPage  extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRcountry="//input[@id='searchDocumentRequirement_country']";
	public static final String OCReffectivedate="//input[@name='effectiveDate']";
	public static final String OCRstatus="//select[@id='searchDocumentRequirement_cmnDocumentReq_status']";
	public static final String OCReffectivestatus="//select[@id='searchDocumentRequirement_cmnDocumentReq_effectiveStatus']";
	public static final String OCRlanguagecode="//select[@id='lanCode']";
	public static final String OCRDocumentID="//input[@id='searchDocumentRequirement_cmnDocumentReq_documentId']";
	public static final String OCRdocumentName="//input[@id='searchDocumentRequirement_cmnDocumentReq_documentName']";
	public static final String OCRsortby="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	public static final String OCRsave="//button[@name='save']";
	
	//------------------------------Add Locator-------------------------------------------
	public static final String OCRountry="//input[@id='editDocumentRequired_country']";
	public static final String OCRStatus="//select[@id='editDocumentRequired_cmnDocumentReqValue_status']";
	public static final String OCReffectivedate1="//input[@id='editDocumentRequired_effectiveDate']";
	public static final String OCReffectivestatus1="//select[@id='editDocumentRequired_cmnDocumentReqValue_effectiveStatus']";
	public static final String OCRshipmenttype="//select[@id='editDocumentRequired_cmnDocumentReqValue_shipmentType']";
	public static final String OCRdocumentId="//input[@id='editDocumentRequired_cmnDocumentReqValue_documentId']";
	public static final String OCRlanguageocde="//select[@id='lanCode']";
	public static final String OCRDocumentName="//input[@id='editDocumentRequired_cmnDocumentReqValue_documentName']";
	
	
	// --------------------Constructor------------------------------------

			public DocumentationRequiremntPage(WebDriver driver, ExtentTest test) {
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

			public void searchbyParameters(String Country, String status, String EffectiveStatus, String language, String sortby, String direction) {

				typeText(driver, test, OCRcountry, "Entering codetype :", Country);
				Wait.waitfor(2);	
				selectByVisibleText(driver, test, OCRstatus, "selecting status For by dropdown", status);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCReffectivestatus, "selecting effective Status by dropdown :", EffectiveStatus);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRlanguagecode, "selecting language by dropdown :", language);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRsortby, "selecting sortby by dropdown :", sortby);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction);
				Wait.waitfor(2);
			}
			public void AddbyParameters(String Country,  String status,String EffectiveDate,String DocumentId, String EffectiveStatus, String ShipmentType,  String Languagecode, String DocumentName) {

				typeText(driver, test, OCRountry, "Entering country :", Country);
				Wait.waitfor(2);	
				selectByVisibleText(driver, test, OCRStatus, "selecting status For by dropdown", status);
				Wait.waitfor(2);
				if (EffectiveDate.length() > 0) {
					clickElement(driver, test, OCReffectivedate1, "Click on Effetive date");
					date(driver, test, "Selected on effective date : ", EffectiveDate);
					test.log(LogStatus.PASS, "Selected on effective date : " + EffectiveDate);
				}
				Wait.waitfor(2);
				typeText(driver, test, OCRdocumentId, "Entering document id :", DocumentId);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCReffectivestatus1, "selecting effective Status by dropdown :", EffectiveStatus);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRshipmenttype, "selecting shipment type by dropdown :", ShipmentType);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRlanguageocde, "selecting language by dropdown :", Languagecode);
				Wait.waitfor(2);
				typeText(driver, test, OCRDocumentName, "Entering document name :", DocumentName);
				Wait.waitfor(2);
			
}}