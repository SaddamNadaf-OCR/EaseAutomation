package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ImportIntoAgreementPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/********************** Loactors *******************************/
	public static final String OCR_ImportIntoAgreement_Save = "//button[@name='save']";
	public static final String OCR_ImportIntoAgreement_Cancel = "//button[@name='cancel']";
	public static final String OCR_ImportIntoAgreement_LicenseType = "//select[@name='licenseType']";
	public static final String OCR_ImportIntoAgreement_TemplateName = "//input[@name='exportRequestValue.template']";
	public static final String OCR_ImportIntoAgreement_LicenseTransactionID = "//input[@name='exportRequestValue.licenseTransactionId']";
	public static final String OCR_ImportIntoAgreement_UseRequestID = "//button[@name='useExpId']";
	public static final String OCR_ImportIntoAgreement_ApplicationDateInitiated = "//input[@name='applicationDateInitiated']";
	public static final String OCR_ImportIntoAgreement_Country = "//input[@name='exportRequestValue.importCountry']";
	public static final String OCR_ImportIntoAgreement_ForeignParty = "//input[@name='exportRequestValue.importConsignee']";
	public static final String OCR_ImportIntoAgreement_USParty = "//input[@name='exportRequestValue.importUsParty']";
	public static final String OCR_ImportIntoAgreement_Notes = "//input[@name='exportRequestValue.importAll']";
	public static final String OCR_ImportIntoAgreement_Document = "//input[@name='exportRequestValue.importDocument']";
	public static final String OCR_ImportIntoAgreement_ImportAllButton = "//button[@name='imprtAll']";
	public static final String OCR_ImportIntoAgreement_Select = "//button[@name='Ok']";
	public static final String OCR_ImportIntoAgreement_CancelPopup = "//button[@class='btn-close']";
	public static final String OCR_ImportIntoAgreement_TemplateNameLink = "//a[@id='templateNameHREFId']";
	public static final String OCR_ImportIntoAgreement_LicenseTransactionIDLink = "//a[@id='AggTransactionHREFId']";
	public static final String OCR_ImportIntoAgreement_Searchpopup = "//button[@name='Search']";

	/* ******************** Constructor ***************************** */

	public ImportIntoAgreementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_ImportIntoAgreement_Save, "Clicking on Save Button :");
	}
	
	//Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_ImportIntoAgreement_Cancel, "Clicking on Cancel button :");
	}
	
	//Select License Type
	public void licenceType(String LicenseType) {
		selectByVisibleText(driver, test, OCR_ImportIntoAgreement_LicenseType, "Selecting License type :", LicenseType);
	}
	
	//Use Request ID
	public void userequestID() {
		clickElement(driver, test, OCR_ImportIntoAgreement_UseRequestID, "Clicking on Use Request ID :");
		Wait.waitfor(3);
	}
	
	//Template Name
	public void templatenameForm() {
		clickElement(driver, test, OCR_ImportIntoAgreement_TemplateNameLink, "Clicking on Template name Link :");
		try {
			mouseOverAndClick(driver, test, "//td[@aria-describedby='gridPopup_templateName']", "Selecting Template Name Format :");
			clickElement(driver, test, OCR_ImportIntoAgreement_Select, "Clicking on Select button :");
		}catch(Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ImportIntoAgreement_CancelPopup, "Clicking on Cancel popup Icon :");
		}
	}
	
	//License Transaction ID
	public void licensetransactionID() {
		clickElement(driver, test, OCR_ImportIntoAgreement_LicenseTransactionIDLink, "Clicking on License transaction ID :");
		try {
			clickElement(driver, test, OCR_ImportIntoAgreement_Searchpopup, "Clicking on Search Popup Button :");
			mouseOverAndClick(driver, test, "//td[@aria-describedby='gridPopup_templateName']", "Selecting Transaction Id :");
			clickElement(driver, test, OCR_ImportIntoAgreement_Select, "Clicking on Select button :");
		}catch(Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ImportIntoAgreement_CancelPopup, "Clicking on Cancel popup Icon :");
		}
	}
	
	//Import
	public void importall() {
		clickElement(driver, test, OCR_ImportIntoAgreement_ImportAllButton, "Clicking on Import All Button :");
		Wait.waitfor(5);
		AlertPopUp(driver, test, "OK");
	}
}
