package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultProductDocumentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ViewAddDoc = "//button[@id='documentAttachId']";
	public static final String OCR_DocumentType = "//select[@id='docTypeId']";
	public static final String OCR_DocDescription = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_UploadFile = "//span[@class='btn fileinput-button']";
	public static final String OCR_Button_Save = "//button[@id='saveButton']";
	public static final String OCR_Button_Cancel = "//button[@id='cancel']";

	/* ******************** Constructor ***************************** */
	public ResultProductDocumentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	public void click_viewadddocument() {
		clickElement(driver, test, OCR_ViewAddDoc, "Clicking on View Add Document Button");
	}

	// Uploading the Document
	public void add_Document(String DocType, String DocDesc, String UploadfileName) {
		try {
			selectByVisibleText(driver, test, OCR_DocumentType, "Enter Document Type : ", DocType);
			typeText(driver, test, OCR_DocDescription, "Add Description : ", DocDesc);
			clickElement(driver, test, OCR_UploadFile, "click on upload file");
			uploadFile(driver, test, UploadfileName, "upload document : "+UploadfileName);
			Wait.waitfor(5);
			cancel();
		} catch (Exception e) {
			testFailSshot(driver, test);
		//	e.printStackTrace();
			clickElement(driver, test, "(//button[@class='close'])[1]", "click on cancel");
			test.log(LogStatus.FAIL, "Click on cancel");
		}
	}

	public void save() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	public void cancel() {
		clickElement(driver, test, OCR_Button_Cancel, "Clicking on Cancel Button");
	}

	public void movetonotestab() {
		clickElement(driver, test, "//a[@id='tab7']", "Clicking on Notes Tab");
	}

	public void validate_documenterror() {
		Wait.waitfor(5);
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Document Popup");
		}
	}

}
