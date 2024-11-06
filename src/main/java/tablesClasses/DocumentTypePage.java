package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DocumentTypePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRDocTyepcode="//input[@id='resultDocumentType_documentType_docTypeCode']";
	public static final String OCRDocTypedescription="//input[@id='resultDocumentType_documentType_docTypeDesc']";
	public static final String OCRsetid="//select[@id='resultDocumentType_documentType_setId']";
	public static final String OCRstatus="//select[@id='resultDocumentType_documentType_status']";
	public static final String OCRcreatedby="//select[@id='resultDocumentType_documentType_createdBy']";
	public static final String OCRsortby="//select[@name='sortBy']";
	public static final String OCRdirection="//select[@name='direction']";
	public static final String OCRsave="//button[@name='save']";
	
	//--------------------------------Add Locators--------------------------------------------
	
	public static final String OCRDocTypeCode="//input[@id='editDocumentType_documentType_docTypeCode']";
	public static final String OCRdocTypeDescription1="//input[@id='editDocumentType_documentType_docTypeDesc']";
	public static final String OCRsetId1="//select[@id='editDocumentType_documentType_setId']";
	public static final String OCRstatus1="//select[@id='editDocumentType_status']";
	
	// --------------------Constructor------------------------------------
	

				public DocumentTypePage(WebDriver driver, ExtentTest test) {
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

				public void searchbyParameters(String DocTypeCode, String DocTypeDescription, String SetId, String Status, String CreatedBy, String sortby, String direction) {

					typeText(driver, test, OCRDocTyepcode, "Entering doc type code :", DocTypeCode);
					Wait.waitfor(2);	
					typeText(driver, test, OCRDocTypedescription, "Entering doc type description :", DocTypeDescription);
					Wait.waitfor(2);	
					selectByVisibleText(driver, test, OCRsetid, "selecting set id For by dropdown", SetId);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRstatus, "selecting Status by dropdown :", Status);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRcreatedby, "selecting created by dropdown :", CreatedBy);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRsortby, "selecting sortby  dropdown :", sortby);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRdirection, "selecting direction by dropdown :", direction);
					Wait.waitfor(2);
				}
				// .....................searchParameter...............................//

				public void addbyParameters(String DocTypeDescription, String SetId, String Status) {

					typeText(driver, test, OCRDocTypeCode, "Entering doc type code :", randomnumbers());
					Wait.waitfor(2);	
					typeText(driver, test, OCRdocTypeDescription1, "Entering doc type description :", DocTypeDescription);
					Wait.waitfor(2);	
					selectByVisibleText(driver, test, OCRsetId1, "selecting set id For by dropdown", SetId);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRstatus1, "selecting Status by dropdown :", Status);
					Wait.waitfor(2);
					
				}
}