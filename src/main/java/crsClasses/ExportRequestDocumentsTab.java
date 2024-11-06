package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportRequestDocumentsTab extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/******************* Locators **********************************************/
	public static final String OCR_ExportRequestAddDocBtn = "//button[@id='addDocumentId']";
	public static final String OCR_ExportRequestCancelBtn = "//div[@id='10']//button[@name='cancel'][contains(text(),'Cancel')]";
	public static final String OCR_ExportRequestAddDocpopUpSaveBtn = "//button[@id='saveButton']";
	public static final String OCR_ExportRequestAddDocpopUpSavendReturnBtn = "//button[@id='dmsaveReturn']";
	public static final String OCR_ExportRequestAddDocpopUpCancelBtn = "//button[@id='cancel']";
	public static final String OCR_ExportRequestAddDocpopUpEASERadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeeaseStore']";
	public static final String OCR_ExportRequestAddDocpopUpLocalFolderRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisLocalFtp']";
	public static final String OCR_ExportRequestAddDocpopUpLinkRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisLink']";
	public static final String OCR_ExportRequestAddDocpopUpServerRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisFtp']";
	public static final String OCR_ExportRequestAddDocpopUpDocTypeDropdwn = "//select[@id='docTypeId']";
	public static final String OCR_ExportRequestAddDocpopUpUploadFile = "//i[@class='fa fa-upload']";
	public static final String OCR_ExportRequestAddDescriptionBox = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_ExportRequestAddKeywords = "//input[@id='keyWord']";
	public static final String OCR_ExportRequestAddSystemDocNumber = "//input[@id='editDCSFileAttach_documentDetail_systemDocNumber']";

	/************************* constructor ***********************/
	public ExportRequestDocumentsTab(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Uploading the Document
	public void uploadDoc(String DocType, String DocDesc, String UploadfileName) {
		try {
			selectByVisibleText(driver, test, OCR_ExportRequestAddDocpopUpDocTypeDropdwn,
					"Select the document type from dropdown", DocType);
			typeText(driver, test, OCR_ExportRequestAddDescriptionBox, "Add Description in box", DocDesc);
			mouseOverAndClick(driver, test, OCR_ExportRequestAddDocpopUpUploadFile, "click on Upload File");
			Wait.waitfor(4);
			uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
			Wait.waitfor(3);
			SaveaAndReturn();
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close");
		}
	}

	// click on Save and return button
	public void SaveaAndReturn() {
		clickElement(driver, test, OCR_ExportRequestAddDocpopUpSavendReturnBtn, "click on Save and Return button");
	}

	// click on Cancle button
	public void click_CancleDocBtn() {
		clickElement(driver, test, OCR_ExportRequestAddDocpopUpCancelBtn, "click on Cancle button");
	}

	// Error validation in Document page
	public void validate_Document() {
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Document Type is required.')]")) {
					test.log(LogStatus.INFO, "Document Type is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Add Document");
		}
	}
	
	public void adddocument() {
		clickElement(driver, test, "OCR_ExportRequestAddDocBtn","Click on Add Document Button:");
	}

}
