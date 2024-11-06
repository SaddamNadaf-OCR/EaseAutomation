package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultElectronicExportInformationTransactionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String Report = "//h3[@class='page-heading']";
	public static final String First_Record = "(//a[@class='ead-eei-tooltip'])[1]";
	public static final String OCR_ResultEEI_AddDocpopUpDocTypeDropdwn = "//select[@id='requiredDocTypeId']";
	public static final String OCR_ResultEEI_AddDocpopUpUploadFile = "//input[@id='fileAttach']";
	public static final String OCR_ResultEEI_AddDescriptionBox = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_ResultEEI_AddDocpopUpSavendReturnBtn = "//button[@id='saveButton']";

	/* ******************************* Constructor ****************************** */

	public ResultElectronicExportInformationTransactionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Action ****************************** */

	// Title of the page is Displayed or not
	public void titleIsDisplayed() {
		try {
			if (isDisplayed(driver, Report)) {
				test.log(LogStatus.PASS, "Title is Displayed : Result Electronic ExportInformation Transactions Page");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Result Electronic ExportInformation Transactions Page");
		}
	}
	
	//Click on Copy Icon
	public void click_Copy() {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-copy']", "Click on Copy icon : ");
	}
	
	//Click on attach document icon ----Added by Devanand for (VerifyAttachFilesResultAndEEISubmission)
	public void attach_docIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//i[@class='fa fa-upload'])[1]", "Click on attach doc icon : ");
	}
	
	// Uploading the Document
	public void ResultuploadDoc(String DocType, String DocDesc, String UploadfileName) {
		try {
			selectByVisibleText(driver, test, OCR_ResultEEI_AddDocpopUpDocTypeDropdwn,
					"Select the document type from dropdown :", DocType);
			typeText(driver, test, OCR_ResultEEI_AddDescriptionBox, "Add Description in box :", DocDesc);
			mouseOverAndClick(driver, test, OCR_ResultEEI_AddDocpopUpUploadFile, "click on Upload File :");
			Wait.waitfor(4);
			uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ResultEEI_AddDocpopUpSavendReturnBtn, "Clicking on Save Button in Popup :");
			clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close :");
		}
	}
	
	//Click on First Record
	public void openShipment() {
		clickElement(driver, test, First_Record, "Clicking on First Shipment No to open :");
	}
	
	public void click_EEINo(String EEINum) {
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'"+ EEINum +"')]", "CLicking on EEI Number : ");
		
	}
	
	//clicking on first record shipment number
	public void click_ShipNumber() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//a[@class='ead-eei-tooltip'])[1]", "Click on first record :");
	}

	
	
}