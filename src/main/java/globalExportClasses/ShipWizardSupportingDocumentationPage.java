
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardSupportingDocumentationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SupportingDoc_AddDocumentation = "//button[@id='documentAttachId']";
	public static final String OCR_SupportingDoc_DocumentType = "//select[@id='requiredDocTypeId']";
	public static final String OCR_SupportingDoc_UploadFileBtn = "//i[@class='fa fa-upload']";
	public static final String OCR_SupportingDoc_Description = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_SupportingDoc_SaveAndReturn = "//button[@id='saveButton']";
	public static final String OCR_SupportingDoc_LocalFolderRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisLocalFtp']";
	public static final String OCR_SupportingDoc_LocalPath = "//input[@id='textUrl']";
	public static final String OCR_SupportingDoc_PopUpClose = "//button[@id='closeTop']";
	public static final String OCR_SupportingDoc_ShippingReviewerLink = "//a[@id='shippingDeptReviewer-popup']";
	public static final String OCR_SupportingDoc_ExportReviewerLink = "//a[@id='expCompReviewer-popup']";
	public static final String OCR_SupportingDoc_TransportationLink = "//a[@id='transportationreviewer-popup']";
	public static final String OCR_SupportingDoc_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_SupportingDoc_Search = "//button[@name='Search']";
	public static final String OCR_SupportingDoc_Select = "//div[@id='resultDIV']//div[3]//div[1]//button[1]";
	public static final String OCR_SupportingDoc_closePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SupportingDoc_Save = "//button[@id='wizardSave']";
	public static final String OCR_SupportingDoc_SubmitForReviewer = "//button[@id='wizardReview']";

	/* ******************************* Constructor ****************************** */

	public ShipWizardSupportingDocumentationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding a document
	public void addDocument(String DocumentType, String UploadfileName, String DocumentLocationPath) {
		clickElement(driver, test, OCR_SupportingDoc_AddDocumentation, "click on Add Document Icon");
		try {
			if (UploadfileName.length() > 0) {
				selectByVisibleText(driver, test, OCR_SupportingDoc_DocumentType, "Select the Document Type : ",
						DocumentType);
				mouseOverAndClick(driver, test, OCR_SupportingDoc_UploadFileBtn, "click on Upload File button");
				uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SupportingDoc_SaveAndReturn, "click on Document save");
				clickElement(driver, test, OCR_SupportingDoc_PopUpClose, "Click on PopUp Close");
			}
			if (DocumentLocationPath.length() > 0) {
				clickElement(driver, test, OCR_SupportingDoc_LocalFolderRadioBtn, "click on Local Folder Radio button");
				selectByVisibleText(driver, test, OCR_SupportingDoc_DocumentType, "Select the Document Type : ",
						DocumentType);
				typeText(driver, test, OCR_SupportingDoc_LocalPath, "Enter local path : ", DocumentLocationPath);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SupportingDoc_SaveAndReturn, "click on Document save");
				clickElement(driver, test, OCR_SupportingDoc_PopUpClose, "Click on PopUp Close");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_SupportingDoc_PopUpClose, "Click on PopUp Close");
		}
		Wait.waitfor(3);
		String resultGid = "//table[@id='exporterGrid']//tr//td[contains(text(),'" + DocumentType + "')]";
		isDisplayed(driver, resultGid);
		test.log(LogStatus.PASS, "Document type is added in the Grid table : " + DocumentType);
	}

	// Submit Shipment to the Reviewer details
	public void submitShipReviewer(String ShippingDeptReviewer, String ExportComplianceReviewer,
			String TransportGatekeeperExportOps) {
		if (ShippingDeptReviewer.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SupportingDoc_ShippingReviewerLink, "Click on Shipping Dept Reviewer Link");
			try {
				typeText(driver, test, OCR_SupportingDoc_UserFirstName, "Enter the User First Name : ",
						ShippingDeptReviewer);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SupportingDoc_Search, "Click on Search button");
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + ShippingDeptReviewer + "')]",
						"Select the Shipping Dept Reviewer : " + ShippingDeptReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SupportingDoc_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SupportingDoc_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (ExportComplianceReviewer.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SupportingDoc_ExportReviewerLink,
					"Click on Export Compliance Reviewer Link");
			try {
				typeText(driver, test, OCR_SupportingDoc_UserFirstName, "Enter the User First Name : ",
						ExportComplianceReviewer);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SupportingDoc_Search, "Click on Search button");
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + ExportComplianceReviewer + "')]",
						"Select the Export Compliance Reviewer : " + ExportComplianceReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SupportingDoc_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SupportingDoc_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (TransportGatekeeperExportOps.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SupportingDoc_TransportationLink,
					"Click on Transport Gate Keeper Export Ops Link");
			try {
				typeText(driver, test, OCR_SupportingDoc_UserFirstName, "Enter the User First Name : ",
						TransportGatekeeperExportOps);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SupportingDoc_Search, "Click on Search button");
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + TransportGatekeeperExportOps
								+ "')]",
						"Select the Transport Gate keeper Export Ops : " + TransportGatekeeperExportOps);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SupportingDoc_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SupportingDoc_closePopUp, "Click on Cancel popup icon");
			}
		}
	}

	// Click on Save button
	public void click_Save() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SupportingDoc_Save, "Click on Save");
	}

	// click on Submit for Reviewer
	public void click_SubmitForReviewer() {
		clickElement(driver, test, OCR_SupportingDoc_SubmitForReviewer, "click on Submit for Reviewer");
	}

	// Validating the Submit for Reviewer error
	public void validateReviwer() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please select a Shipping Department Reviewer')]")) {
					test.log(LogStatus.INFO,
							"Please select a Shipping Department Reviewer, an Export Compliance Reviewer and a Transportation Gatekeeper Reviewer to submit this Shipment Request");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on Submit for Reviewer button in Reviewer page");
		}
	}

	// Validating the Questionnaire error
	public void validateQuestionnaire() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver,
						"//span[contains(text(),'Questionnaire Tab - Please provide responses to al')]")) {
					test.log(LogStatus.INFO,
							"Questionnaire Tab - Please provide responses to all mandatory questions.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Questionnaire Tab error is not Displayed by clicking on Submit for Reviewer button in Reviewer page");
		}
	}

}
