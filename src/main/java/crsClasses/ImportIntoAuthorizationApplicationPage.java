package crsClasses;

import org.openqa.selenium.WebDriver;
//Added By Saddam
//On 02/04/2024
//Import All Document in Export Authorization Request Page
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ImportIntoAuthorizationApplicationPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/********************** Loactors *******************************/
	public static final String OCR_ImportIntoAuthApplication_Save = "//input[@name='saveImportInfo']";
	public static final String OCR_ImportIntoAuthApplication_Cancel = "(//button[@name='cancel'])[17]";
	public static final String OCR_ImportIntoAuthApplication_Unlink = "//input[@name='unlink']";
	public static final String OCR_ImportIntoAuthApplication_LicenseType = "//select[@name='licenseType']";
	public static final String OCR_ImportIntoAuthApplication_TemplateName = "//input[@id='editExportRequest1_exportRequestValue_template']";
	public static final String OCR_ImportIntoAuthApplication_LicenseTransactionID = "//input[@id='editExportRequest1_exportRequestValue_licenseTransactionId']";
	public static final String OCR_ImportIntoAuthApplication_UseRequestID = "//input[@name='useExpId']";
	public static final String OCR_ImportIntoAuthApplication_ApplicationDateInitiated = "//input[@id='editExportRequest1_applicationDateInitiated']";
	public static final String OCR_ImportIntoAuthApplication_Country = "//input[@id='editExportRequest1_exportRequestValue_importCountry-1']";
	public static final String OCR_ImportIntoAuthApplication_Party = "//input[@id='editExportRequest1_exportRequestValue_importConsignee-1']";
	public static final String OCR_ImportIntoAuthApplication_Items = "//input[@id='editExportRequest1_exportRequestValue_importItems-1']";
	public static final String OCR_ImportIntoAuthApplication_FreightForwarder = "//input[@id='editExportRequest1_exportRequestValue_importFf-1']";
	public static final String OCR_ImportIntoAuthApplication_SourceManu = "//input[@id='editExportRequest1_exportRequestValue_importSourceMfg-1']";
	public static final String OCR_ImportIntoAuthApplication_Notes = "//input[@id='editExportRequest1_exportRequestValue_importAll-1']";
	public static final String OCR_ImportIntoAuthApplication_Document = "//input[@id='editExportRequest1_exportRequestValue_importDocument-1']";
	public static final String OCR_ImportIntoAuthApplication_ImportAllButton = "//input[@name='imprtAll']";
	public static final String OCR_ImportIntoAuthApplication_Select = "//button[@name='Ok']";
	public static final String OCR_ImportIntoAuthApplication_CancelPopup = "//button[@class='btn-close']";
	public static final String OCR_ImportIntoAuthApplication_TemplateNameLink = "//a[@id='templateNameHREFId']";
	public static final String OCR_ImportIntoAuthApplication_LicenseTransactionIDLink = "//a[@id='AggTransactionHREFId']";
	public static final String OCR_ImportIntoAuthApplication_Searchpopup = "//button[@name='Search']";

	/* ******************** Constructor ***************************** */

	public ImportIntoAuthorizationApplicationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_ImportIntoAuthApplication_Save, "Clicking on Save Button :");
	}
	
	//Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_ImportIntoAuthApplication_Cancel, "Clicking on Cancel button :");
	}
	
	//Select License Type
	public void licenceType(String LicenseType) {
		selectByVisibleText(driver, test, OCR_ImportIntoAuthApplication_LicenseType, "Selecting License type :", LicenseType);
	}
	
	//Use Request ID
	public void userequestID() {
		clickElement(driver, test, OCR_ImportIntoAuthApplication_UseRequestID, "Clicking on Use Request ID :");
		Wait.waitfor(3);
	}
	
	//Template Name
	public void templatenameForm() {
		clickElement(driver, test, OCR_ImportIntoAuthApplication_TemplateNameLink, "Clicking on Template name Link :");
		try {
			mouseOverAndClick(driver, test, "//td[@aria-describedby='gridPopup_templateName']", "Selecting Template Name Format :");
			clickElement(driver, test, OCR_ImportIntoAuthApplication_Select, "Clicking on Select button :");
		}catch(Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ImportIntoAuthApplication_CancelPopup, "Clicking on Cancel popup Icon :");
		}
	}
	
	//License Transaction ID
	public void licensetransactionID() {
		clickElement(driver, test, OCR_ImportIntoAuthApplication_LicenseTransactionIDLink, "Clicking on License transaction ID :");
		try {
			clickElement(driver, test, OCR_ImportIntoAuthApplication_Searchpopup, "Clicking on Search Popup Button :");
			mouseOverAndClick(driver, test, "//td[@aria-describedby='gridPopup_templateName']", "Selecting Transaction Id :");
			clickElement(driver, test, OCR_ImportIntoAuthApplication_Select, "Clicking on Select button :");
		}catch(Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ImportIntoAuthApplication_CancelPopup, "Clicking on Cancel popup Icon :");
		}
	}
	
	//Import
	public void importall() {
		clickElement(driver, test, OCR_ImportIntoAuthApplication_ImportAllButton, "Clicking on Import All Button :");
		AlertPopUp(driver, test, "OK");
	}
}
