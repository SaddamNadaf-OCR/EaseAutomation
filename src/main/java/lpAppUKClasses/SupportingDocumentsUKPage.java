package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SupportingDocumentsUKPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/******************************** Locators ************************************/

	public static final String OCR_SupportingDocTab = "//i[@id='SUPPORTING_DOC']";
	public static final String OCR_SupportingDocuments_AddSupportingDocumentsbtn = "//button[@id='documentAttachId']";
	public static final String OCR_SupportingDocuments_SaveBtn = "//button[@id='saveButton']";
	public static final String OCR_SupportingDocuments_DocumentType = "//select[@id='docTypeId']";
	public static final String OCR_SupportingDocuments_UploadFileBtn = "(//i[@class='fa fa-upload'])[1]";
	public static final String OCR_SupportingDocuments_LocalFolderRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisLocalFtp']";
	public static final String OCR_SupportingDocuments_LocalPath = "//input[@id='textUrl']";
	public static final String OCR_SupportingDocuments_UploadDocSaveBtn = "//button[@id='saveButton']";
	public static final String OCR_SupportingDocuments_cancelbtn = "//button[@id='cancel']";
	public static final String OCR_SupportingDocuments_TechnicalSpecification = "//select[@id='technicalSpec']";
	public static final String OCR_SupportingDocuments_TechnicalSpecificationReason = "//textarea[@id='explanationTec']";
	public static final String OCR_SupportingDocuments_EndUserDocumentation = "//select[@id='euDocumentation']";
	public static final String OCR_SupportingDocuments_EndUserDocumentationReason = "//textarea[@id='explanationEu']";
	public static final String OCR_SupportingDocuments_clicksavebtn = "//input[@id='submitAppl']";

	/* ************************ Constructor ********************** */

	public SupportingDocumentsUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	public void clickOnSupportingDocTab() {
		clickElement(driver, test, OCR_SupportingDocTab, "Click on Supporting Document Tab");
	}

	// click on add supporting document button
	public void addsupportingdocument() {
		clickElement(driver, test, OCR_SupportingDocuments_AddSupportingDocumentsbtn, "click on add supporting doc");
	}

	// click on cancel button
	public void cancelBtn() {
		clickElement(driver, test, OCR_SupportingDocuments_cancelbtn, "click on cancel button ");
	}

	// Upload document type
	public void uploaddocument(String SupportingDocumentType, String SupportingDocUploadfileName, String SupportingDocumentLocationPath) {
		try {
			if (SupportingDocUploadfileName.length() > 0) {
				selectByVisibleText(driver, test, OCR_SupportingDocuments_DocumentType, "Select the Document : ", SupportingDocumentType);
				mouseOverAndClick(driver, test, OCR_SupportingDocuments_UploadFileBtn, "click on Upload File button");
				Wait.waitfor(3);
				uploadFile(driver, test, SupportingDocUploadfileName, "Document is Added : " + SupportingDocUploadfileName);
				Wait.waitfor(3);
			}
			if (SupportingDocumentLocationPath.length() > 0) {
				clickElement(driver, test, OCR_SupportingDocuments_LocalFolderRadioBtn,
						"click on Local Folder Radio button");
				selectByVisibleText(driver, test, OCR_SupportingDocuments_DocumentType, "Select the Document : ",
						SupportingDocumentType);
				typeText(driver, test, OCR_SupportingDocuments_LocalPath, "Enter local path : ", SupportingDocumentLocationPath);
				Wait.waitfor(2);
			}
			clickElement(driver, test, OCR_SupportingDocuments_SaveBtn, "click on Document save ");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SupportingDocuments_cancelbtn, "Click on Cancel Button");
			
		} catch (Exception e) {
			testFailSshot(driver, test);
			cancelBtn();
		}
	}

	// add value to Technical Specification and End User Documentation
	public void technicalSpecification(String TechnicalSpecification, String TechnicalSpecificationReason) {
		if(TechnicalSpecification.contains("No")) {
			selectByVisibleText(driver, test, OCR_SupportingDocuments_TechnicalSpecification, "Select Technical Specification ", TechnicalSpecification);
			Wait.waitfor(3);
			typeText(driver, test, OCR_SupportingDocuments_TechnicalSpecificationReason, "Enter TechnicalSpecification Reason", TechnicalSpecificationReason);
		}
	}

	public void endUserDocuments(String EndUserDocumentation, String EndUserDocumentationReason) {
		if(EndUserDocumentation.contains("No")) {
			selectByVisibleText(driver, test, OCR_SupportingDocuments_EndUserDocumentation, "Select End User Documentation", EndUserDocumentation);
			Wait.waitfor(3);
			typeText(driver, test, OCR_SupportingDocuments_EndUserDocumentationReason, "Enter EndUserDocumentation Reason", EndUserDocumentationReason);
		}
	}

	// click on save
	public void clicksavebtn() {
		clickElement(driver, test, OCR_SupportingDocuments_clicksavebtn, "click on save option");
	}

	// validations in Supporting Documents Tab
	public void validateSupportingDocumentsError() {
		try {
			Wait.waitfor(4);
			clickElement(driver, test, OCR_SupportingDocuments_clicksavebtn, "Click on Save Button");
			if (isDisplayed(driver, "//div[@class='form-content']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Technical Specification required!']")) {
					test.log(LogStatus.INFO, "Technical Specification required");
				}
				if (isDisplayed(driver, "//li[text()='End User Documentation required!']")) {
					test.log(LogStatus.INFO, "End User Documentation required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

	// validations in Supporting Documents Tab
	public void validateCreateNewAttachmentError() {
		try {
			Wait.waitfor(4);
			clickElement(driver, test, OCR_SupportingDocuments_SaveBtn, "Click on Save Button");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Document Type is required.')]")) {
					test.log(LogStatus.INFO, "Document Type is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required");
				}
				clickElement(driver, test, OCR_SupportingDocuments_cancelbtn, "Click on Cancel Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_SupportingDocuments_cancelbtn, "Click on Cancel Button");
		}
	}

}
