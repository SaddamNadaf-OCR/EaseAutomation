package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class FTAdditionalInfoDocumentsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ViewAddDocuments = "//button[@id='documentAttachId']";
	public static final String OCR_DocumentType = "//select[@id='docTypeId']";
	public static final String OCR_Document_Description = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_UploadFile = "//input[@id='fileAttach']";
	public static final String OCR_KeyWords = "//input[@id='keyWord']";
	public static final String OCR_Button_Add = "//input[@name='ok']";
	public static final String OCR_SourceSystemDocNumber = "//input[@id='editDCSFileAttach_documentDetail_systemDocNumber']";
	public static final String OCR_PostApproval = "//input[@id='postApprovalId']";
	public static final String OCR_TransmitToGovernmentAgency = "//input[@id='trnsGovAgency']";
	public static final String OCR_AdditionalFields = "//label[contains(text(),'Additional Fields')]";
	public static final String OCR_Button_SaveandReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_Button_Cancel = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_Button_Save = "//button[@id='saveButton']";

	/* ******************** Constructor ***************************** */
	public FTAdditionalInfoDocumentsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	// Click View/Add Document
	public void click_viewadddocument() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ViewAddDocuments)));
	}

	// Add Document
	public void add_Document(String DocumentType, String DocumentDescription, String UploadFile, String DocKeywords,
			String SourceSystemDocNumber) {
		try {
			Wait.waitfor(3);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ViewAddDocuments)));
			//clickElement(driver, test, OCR_Button_ViewAddDocuments,"Clicking on	View/AddDocument Button");
			//Wait.waitfor(3);
			selectByVisibleText(driver, test, OCR_DocumentType, "Enter Document Type : ", DocumentType);
			typeText(driver, test, OCR_Document_Description, "Enter Description : ", DocumentDescription);
			Wait.waitfor(5);
			clickElement(driver, test, "//span[@class='btn fileinput-button']", "click on upload file");
			Wait.waitfor(5);
			uploadFile(driver, test, UploadFile, "upload document");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_AdditionalFields, "Clicking on Additional Fields section");
			typeText(driver, test, OCR_KeyWords, "Enter Keywords : ", DocKeywords);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_Add, "Clicking on Add Button");
			Wait.waitfor(5);
			typeText(driver, test, OCR_SourceSystemDocNumber, "Enter Source System Doc Number : ",
					SourceSystemDocNumber);
			clickElement(driver, test, OCR_PostApproval, "Check Post Approval checkbox");
			clickElement(driver, test, OCR_TransmitToGovernmentAgency, "Check Transmit To Government Agency checkbox ");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Cancel, "click on cancel");
			Wait.waitfor(5);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_Cancel, "click on cancel");
			test.log(LogStatus.FAIL, "Document is Not Added :");
		}
	}

	// Click on Save and Return Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	// Click on Forward Navigation Button
	public void Forword() {
		clickElement(driver, test, OCR_Button_ForwardNavigation, "Click on Forward Navigation Button");
	}

	// Validate Documents Error
	public void validate_documenterror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

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
					"Error Validation is not Displayed by clicking on SAVE button in Create New File Attachment Page");
		}
	}

	// Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, "(//button[contains(text(),'Cancel')])[2]", "Click on Cancel Button");
	}

}
