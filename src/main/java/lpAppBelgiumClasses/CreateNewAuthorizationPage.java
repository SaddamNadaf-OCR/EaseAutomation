package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewAuthorizationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CNewAuth_AuthorizationGrantedByCountry = "//input[@id='authGrantedByCountryName']";
	public static final String OCR_CNewAuth_AuthorizationTypeLink = "//a[contains(text(),'Authorization Type')]";
	public static final String OCR_CNewAuth_AuthorizationTypeLinkSearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_CNewAuth_AuthorizationTypeLinkSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CNewAuth_AuthorizationRefId = "//input[@id='referenceId']";
	public static final String OCR_CNewAuth_AgencyAuthorization_Agency = "//input[@id='agencyCode']";
	public static final String OCR_CNewAuth_Save = "(//button[@id='mybuttonSave'])[2]";
	public static final String OCR_CNewAuth_Authorization_AppDetails = "(//button[contains(text(),'Authorization Details')])[3]";
	public static final String OCR_CNewAuth_Application_AppDetails = "(//button[contains(text(),'Application Details')])[1]";
	public static final String OCR_CNewAuth_AuthorizationPurposeLink = "//a[contains(text(),'Authorization Purpose')]";
	public static final String OCR_CNewAuth_AuthorizationPurpose_Status = "//select[@id='dosSitePopupForm_dosLicensePurposeValue_status']";
	public static final String OCR_CNewAuth_AuthorizationPurpose_SearchBtn = "//button[@name='Search']";
	public static final String OCR_CNewAuth_AuthorizationPurpose_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CNewAuth_ProgramCode = "//textarea[@name='authorisationHeader.programCode']";
	public static final String OCR_CNewAuth_SegmentCode = "//textarea[@name='authorisationHeader.segmentCode']";
	public static final String OCR_CNewAuth_OwnerName = "";
	public static final String OCR_CNewAuth_OwnerEmail = "//input[@name='authorisationHeader.ownerEmail']";
	public static final String OCR_CNewAuth_RequestorPhnNo = "//input[@name='authorisationHeader.requestorPhone']";
	public static final String OCR_CNewAuth_OwnerPhnNo = "//input[@name='authorisationHeader.ownerPhone']";
	public static final String OCR_CNewAuth_WlsStatusText = "//span[@class='heading-additional']/span";
	public static final String OCR_CNewAuth_ReviewerNotes = "//textarea[@id='editAuthorisation_authorisationHeader_reviewerNotes']";
	public static final String OCR_CNewAuth_ProviosTab = "//label[contains(text(),'Provisos/Conditions')]";
	public static final String OCR_CNewAuth_AddProvisosBtn = "//button[contains(text(),'Add Provisos/Conditions')]";
	public static final String OCR_CNewAuth_ProvisosDescription = "//textarea[@id='editAuthorisationProvisoConditions_authorisationProvisoValue_provisoDescription']";
	public static final String OCR_CNewAuth_ProvisosSaveandReturnBtn = "//button[@id='saveAndReturn']";
	public static final String OCR_CNewAuth_NotesTab = "//a[@class='accordion-toggle']//label[contains(text(),'Notes')]";
	public static final String OCR_CNewAuth_AddNoteBtn = "//button[contains(text(),'Add Note')]";
	public static final String OCR_CNewAuth_AddNotesField = "//textarea[@id='getNotesPopup_authorisationNotesValue_notes']";
	public static final String OCR_CNewAuth_NotesSaveReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_CNewAuth_Reviewerlink = "//a[contains(text(),'Reviewer Name')]";
	public static final String OCR_CNewAuth_ReviewerFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_CNewAuth_ReviewerSearchBtn = "//button[@name='Search']";
	public static final String OCR_CNewAuth_ReviewerSelectBtn = "//button[contains(text(),'Select')]";
	public static final String OCR_CNewAuth_Status = "//select[@id='authorisationHeader.status']";
	public static final String OCR_CNewAuth_AgencyAuthNo = "//input[@id='authorisationHeader.authorisationNumber']";
	public static final String OCR_CNewAuth_AgencyIssueDate = "//input[@id='issueDate']";
	public static final String OCR_CNewAuth_AgencyExpiryDate = "//input[@id='expiryDate']";
	public static final String OCR_CNewAuth_CloseBtn = "//button[@class='btn-close']";
	public static final String OCR_CNewAuth_DocumentType = "//select[@id='docTypeId']";
	public static final String OCR_CNewAuth_UploadFileBtn = "(//i[@class='fa fa-upload'])[2]";
	public static final String OCR_CNewAuth_UploadDocSaveBtn = "//button[@id='saveButton']";
	public static final String OCR_CNewAuth_AddDocumentIcon = "//a[@id='documentAttachId']//i[@class='fa fa-upload']";
	public static final String OCR_CNewAuth_AddDocCancleBtn = "//button[@name='cancel'][contains(text(),'Cancel')]";
	public static final String OCR_CNewAuth_LocalFolderRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisLocalFtp']";
	public static final String OCR_CNewAuth_LocalPath = "//input[@id='textUrl']";
	public static final String OCR_CNewAuth_SnapShotIcon = "//i[@class='fa fa-camera']";
	public static final String OCR_CNewAuth_SnapShotRefID = "(//label[contains(text(),'Reference ID')])[2]/../div";
	public static final String OCR_CNewAuth_SnapShotAuthoType = "(//label[contains(text(),'Authorization Type')])[2]/../div";
	public static final String OCR_CNewAuth_SnapShotStatus = "(//label[contains(text(),'Status')])[2]/../div[3]";
	public static final String OCR_ClosePopup = "//button[@class='btn-close']";

	/* ******************** Constructor ***************************** */

	public CreateNewAuthorizationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// create Header Details function
	public void headerDetails(String AuthGrantByCountry, String AuthorizationCode, String RefrenceId,
			String ProgramCode, String SegmentCode) {
		typeText(driver, test, OCR_CNewAuth_AuthorizationGrantedByCountry, "Enter the country Name : ",
				AuthGrantByCountry);
		String country = "//div[contains(text(),'" + AuthGrantByCountry + "')]";
		clickElement(driver, test, country, "Click on country Name from Dropdown : " + AuthGrantByCountry);
		Wait.waitfor(2);
		try {
			clickElement(driver, test, OCR_CNewAuth_AuthorizationTypeLink, "Click on Authorization Type Link :");
			typeText(driver, test, "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']", "Entering Authorization Code :", AuthorizationCode);
			clickElement(driver, test, OCR_CNewAuth_AuthorizationTypeLinkSearchBtn, "Click on Search button :");
			String AuthorisationType = "//td[contains(text(),'" + AuthorizationCode + "')]";
			clickElement(driver, test, AuthorisationType, "Select the Code :"+AuthorisationType);
			clickElement(driver, test, OCR_CNewAuth_AuthorizationTypeLinkSelectBtn, "Click on Select :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			closeBtn();
		}
		typeText(driver, test, OCR_CNewAuth_AuthorizationRefId, "Enter the Refrence Id : ", RefrenceId+randomnumbers());
		Wait.waitfor(2);
		typeText(driver, test, OCR_CNewAuth_ProgramCode, "Enter Program Code : ", ProgramCode);
		typeText(driver, test, OCR_CNewAuth_SegmentCode, "Enter Segment Code : ", SegmentCode);
	}

	// Creating Header details for non mandatory fields
	public void headerDetailsUnMandatory(String AuthPurposeStatus, String AuthorizationPurposeId) {

		clickElement(driver, test, OCR_CNewAuth_AuthorizationPurposeLink, "Click on Authorization purpose link");
		Wait.waitfor(5);
		try {
			selectByVisibleText(driver, test, OCR_CNewAuth_AuthorizationPurpose_Status,
					"Select Userdefined from Pop up : ", AuthPurposeStatus);
			clickElement(driver, test, OCR_CNewAuth_AuthorizationPurpose_SearchBtn, "Click on Search Button");
			String AuthorizationPurpose = "//td[contains(text(),'" + AuthorizationPurposeId + "')]";
			clickElement(driver, test, AuthorizationPurpose,
					"Click on Authorisation Purpose :  " + AuthorizationPurposeId);
			clickElement(driver, test, OCR_CNewAuth_AuthorizationPurpose_SelectBtn, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			closeBtn();
		}
		Wait.waitfor(3);
		/*scrollToElement(driver, OCR_CNewAuth_Save);
		scrollToTop(driver);
		Wait.waitfor(3);
		click_Save();*/
	}

	// Getting the value of Agency Authorization Function
	public String agencyAuthorization() {
		Wait.waitfor(5);
		return getAttribute(driver, test, OCR_CNewAuth_AgencyAuthorization_Agency, "value",
				"Getting the value of Agency Authorization :");
	}

	// Get text of WLS status
	public String wlsStatus() {
		return getText(driver, test, OCR_CNewAuth_WlsStatusText, "WLS Status : ");
	}

	// Enter the Reference Id
	public String typereferenceid() {
		String Refid = randomnumbers();
		typeText(driver, test, OCR_CNewAuth_AuthorizationRefId, "enter the Reference id : ", Refid);
		return Refid;
	}

	// click on Reviewer link and select the Reviewer from table
	public void click_reviewerlink(String ReviewerFName, String ReviewerNotes) {
		clickElement(driver, test, OCR_CNewAuth_Reviewerlink, "click on reviewer link");
		try {
			typeText(driver, test, OCR_CNewAuth_ReviewerFirstName, "Enter Reviewer User First Name : ", ReviewerFName);
			clickElement(driver, test, OCR_CNewAuth_ReviewerSearchBtn, "click on Reviewer Search button");
			String user = "//td[contains(text(),'" + ReviewerFName + "')]";
			clickElement(driver, test, user, "select the Reviewer : " + ReviewerFName);
			clickElement(driver, test, OCR_CNewAuth_ReviewerSelectBtn, "click on Select button ");
		} catch (Exception e) {
			testFailSshot(driver, test);
			closeBtn();
		}
		typeText(driver, test, OCR_CNewAuth_ReviewerNotes, "Reviewer Notes : ", ReviewerNotes);
	}

	// Add Provios/Conditions
	public void add_ProviosConditions(String ProviosDescription) {
		scrollToElement(driver, "//input[@name='authorisationHeader.reviewerPhone']");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewAuth_ProviosTab, "click on provios Tab");
		clickElement(driver, test, OCR_CNewAuth_AddProvisosBtn, "Click on Add Provios Button ");
		try {
			typeText(driver, test, OCR_CNewAuth_ProvisosDescription, "Add Description : ", ProviosDescription);
			clickElement(driver, test, OCR_CNewAuth_ProvisosSaveandReturnBtn, "Click on Save and Return");
		} catch (Exception e) {
			testFailSshot(driver, test);
			closeBtn();
		}
	}

	// Add Notes
	public void add_Note(String Notes) {
		scrollToElement(driver, OCR_CNewAuth_NotesTab);
		scrollToBottom(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewAuth_NotesTab, "Click on Notes :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewAuth_AddNoteBtn, "Click on Add Notes Button :");
		try {
			typeText(driver, test, OCR_CNewAuth_AddNotesField, "Add Notes to the field : ", Notes);
			clickElement(driver, test, OCR_CNewAuth_NotesSaveReturn, "click on save and return :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			closeBtn();
		}
		Wait.waitfor(3);
		scrollToTop(driver);
	}

	// click on Application Details Button
	public void click_ApplicationDetails() {
		scrollToElement(driver, OCR_CNewAuth_Application_AppDetails);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, "//textarea[@id='editAuthorisation_authorisationHeader_segmentCode']", "");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewAuth_Application_AppDetails, "click on Application Details Button :");
		Wait.waitfor(2);
	}
	
	// click on Application Details Button
		public void click_AutorizationDetails() {
			scrollToElement(driver, OCR_CNewAuth_Authorization_AppDetails);
			scrollToTop(driver);
			Wait.waitfor(2);
			clickElement(driver, test, "//textarea[@id='editAuthorisation_authorisationHeader_segmentCode']", "");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CNewAuth_Authorization_AppDetails, "click on Authorization Details Button :");
			Wait.waitfor(2);
		}

	// click on Save Button
	public void click_Save() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNewAuth_Save);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewAuth_SegmentCode, "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNewAuth_Save, "click on Save Button");
	}
	
	// click on Save Button
		public void click_SaveButton() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CNewAuth_Save);
			Wait.waitfor(3);
			scrollToTop(driver);
			clickElement(driver, test, OCR_CNewAuth_Save, "click on Save Button");
		}

	// select status
	public void select_status(String HDstatus) {
		clickElement(driver, test, OCR_CNewAuth_Status, "Click on Status");
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_CNewAuth_Status, "select Status : ", HDstatus);
	}

	// click on Reviewer link and select the Reviewer from table
	public void click_reviewerlink(String ReviewerFName) {
		Wait.waitfor(4);
		scrollToElement(driver, OCR_CNewAuth_SegmentCode);
		clickElement(driver, test, OCR_CNewAuth_Reviewerlink, "click on reviewer link");
		try {
			typeText(driver, test, OCR_CNewAuth_ReviewerFirstName, "Enter Reviewer User First Name : ", ReviewerFName);
			clickElement(driver, test, OCR_CNewAuth_ReviewerSearchBtn, "click on Reviewer Search button");
			String user = "//table[@id='gridPopup']//tbody/tr[2]/td[2]";
			Wait.waitfor(4);
			clickElement(driver, test, user, "select the Reviewer : " + ReviewerFName);
			clickElement(driver, test, OCR_CNewAuth_ReviewerSelectBtn, "click on Select button ");
		} catch (Exception e) {
			testFailSshot(driver, test);
			closeBtn();
		}
	}

	// Adding Agency authorizations Details
	public void agencyAuthoNo(String AgencyAuthorizationsNo, String AgencyIssueDate, String AgencyExpiryDate) {
		if (AgencyIssueDate.length() > 0) {
			Wait.waitfor(3);
			scrollToElement(driver, OCR_CNewAuth_SegmentCode);
			String agencyAuthNo = randomnumbers();
			typeText(driver, test, OCR_CNewAuth_AgencyAuthNo, "Enter Authorizations no : ", agencyAuthNo);
			clickElement(driver, test, OCR_CNewAuth_AgencyIssueDate, "click on Agency Issue Date");
			date(driver, test, "Select the Agency Issue Date : ", AgencyIssueDate);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CNewAuth_AgencyExpiryDate, "click on Agency Expiry Date");
			date(driver, test, "Select the Agency Expiry Date : ", AgencyExpiryDate);
		}
	}

	// click on close button
	public void closeBtn() {
		clickElement(driver, test, OCR_CNewAuth_CloseBtn, "click on close button ");
	}

	// PDF file is generated or not
	public void pdfFile() {
		try {
			String pdf = "//i[@class='fa fa-file-pdf-o fa-2x']";
			if (isDisplayed(driver, pdf)) {
				test.log(LogStatus.PASS, "PDF file is generated");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "PDF file is not generated");
		}
	}

	// Adding a document
	public void addDocument(String DocumentType, String UploadfileName, String DocumentLocationPath) {
		clickElement(driver, test, OCR_CNewAuth_AddDocumentIcon, "click on Add Document Icon");
		try {
			if (UploadfileName.length() > 0) {
				selectByVisibleText(driver, test, OCR_CNewAuth_DocumentType, "Select the Document : ", DocumentType);
				//Wait.waitfor(4);
				typeText(driver, test, "//textarea[@id='editDCSFileAttach_documentDetail_comments']", "Add Description in box :", "DOCDESK");
				mouseOverAndClick(driver, test, OCR_CNewAuth_UploadFileBtn, "click on Upload File button :");
				Wait.waitfor(3);
				uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
				Wait.waitfor(2);
				clickElement(driver, test, "(//button[@name='Save'])[7]", "Clicking on Save Button :");
				Wait.waitfor(2);
			}
			if (DocumentLocationPath.length() > 0) {
				clickElement(driver, test, OCR_CNewAuth_LocalFolderRadioBtn, "click on Local Folder Radio button");
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCR_CNewAuth_DocumentType, "Select the Document : ", DocumentType);
				Wait.waitfor(2);
				typeText(driver, test, OCR_CNewAuth_LocalPath, "Enter local path : ", DocumentLocationPath);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CNewAuth_UploadDocSaveBtn, "click on Document save");
			}
			Wait.waitfor(2);
			String resultGid = "//table[@id='gridPopup']//tr//td[contains(text(),'" + UploadfileName + "')]";
			Wait.waitfor(2);
			isDisplayed(driver, resultGid);
			test.log(LogStatus.PASS, "Document type is added in the Grid table : " + UploadfileName);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CNewAuth_UploadDocSaveBtn, "click on Document save");
			Wait.waitfor(2);
			closeBtn();
		} catch (Exception e) {
			e.printStackTrace();
			testFailSshot(driver, test);
			closeBtn();
		}
	}

	// Get the First selected text from Status
	public String getStatus() {
		return getSelectFirstText(driver, test, OCR_CNewAuth_Status, "Selected options in Status");
	}

	// validations in create new authorization
	public void validateHeaderDetailsError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Authorization Granted by Country required']")) {
					test.log(LogStatus.INFO, "Authorization Granted by Country required");
				}
				if (isDisplayed(driver, "//li[text()='Authorization Type  required']")) {
					test.log(LogStatus.INFO, "Authorization Type  required");
				}
				if (isDisplayed(driver, "//li[text()='Reference ID is  required']")) {
					test.log(LogStatus.INFO, "Reference ID is  required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Agency required')]")) {
					test.log(LogStatus.INFO, "Agency required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Header Details");
		}
	}

	// validations in Reviewer Details
	public void validateReviewerDetailsError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()=' Reviewer Name required']")) {
					test.log(LogStatus.INFO, "Reviewer Name required");
				}
				if (isDisplayed(driver, "//li[text()=' Reviewer E-mail required']")) {
					test.log(LogStatus.INFO, " Reviewer E-mail required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Header Details for Reviewer");
		}
	}

	// validations in Approved for Submission
	public void validateApprovedforSubmissionError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//span[text()='Please complete the Country section.']")) {
					test.log(LogStatus.INFO, "Please complete the Country section.");
				}
				if (isDisplayed(driver,
						"//span[text()='You must enter one Foreign Consignee in the Foreign Party Details section.']")) {
					test.log(LogStatus.INFO,
							"You must enter one Foreign Consignee in the Foreign Party Details section.");
				}
				if (isDisplayed(driver, "//span[text()='You must enter one item.']")) {
					test.log(LogStatus.INFO, "You must enter one item.");
				}
				if (isDisplayed(driver,
						"//span[text()='Please complete the End Use & Additional Information section.']")) {
					test.log(LogStatus.INFO, "Please complete the End Use & Additional Information section.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Errors is not Displayed by clicking on SAVE button for status: Approved for Submission ");
		}
	}

	// validate Check Circle is green or not
	public void checkCircle() {
		try {
			Wait.waitfor(4);
			if (isDisplayed(driver, "//i[@class='fa fa-check-circle green']")) {
				test.log(LogStatus.PASS, "Check circle Icon is display as green ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors check circle Icon is RED ");
		}
	}

	// validations in Approved for Submission
	public void validateAgencyApprovedError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Agency Authorization Number is  required']")) {
					test.log(LogStatus.INFO, "Agency Authorization Number is  required");
				}
				if (isDisplayed(driver, "//li[text()='Agency Issue Date required']")) {
					test.log(LogStatus.INFO, "Agency Issue Date required");
				}
				if (isDisplayed(driver, "//li[text()='Agency Expiry Date  required']")) {
					test.log(LogStatus.INFO, "Agency Expiry Date  required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

	// validating the snap shot data is displaying or not
	public void validateSnapshot(String ReferenceID, String AuthorizationCode, String HDstatusAgencyApproved) {
		SoftAssert softAssertion = new SoftAssert();
		clickElement(driver, test, OCR_CNewAuth_SnapShotIcon, "click on SnapShot icon");
		try {
			String refid = getText(driver, test, OCR_CNewAuth_SnapShotRefID, "Actual Referance ID : ");
			String authorType = getText(driver, test, OCR_CNewAuth_SnapShotAuthoType, "Actual Authorization Type : ");
			String status = getText(driver, test, OCR_CNewAuth_SnapShotStatus, "Actual Status : ");
			if (refid.equalsIgnoreCase(ReferenceID)) {
				test.log(LogStatus.PASS, "Expected ReferenceID : " + refid);
			} else {
				test.log(LogStatus.FAIL, "Expected ReferenceID : " + refid);
				testFailSshot(driver, test);
				softAssertion.assertTrue(false);
			}
			if (authorType.equalsIgnoreCase(AuthorizationCode)) {
				test.log(LogStatus.PASS, "Expected AuthorizationCode : " + authorType);
			} else {
				test.log(LogStatus.FAIL, "Expected AuthorizationCode : " + authorType);
				testFailSshot(driver, test);
				softAssertion.assertTrue(false);
			}
			if (status.equalsIgnoreCase(HDstatusAgencyApproved)) {
				test.log(LogStatus.PASS, "Expected AuthorizationCode : " + status);
			} else {
				test.log(LogStatus.FAIL, "Expected AuthorizationCode : " + status);
				testFailSshot(driver, test);
				softAssertion.assertTrue(false);
			}
			Wait.waitfor(3);
			clickElement(driver, test, "//div[@class='modal-header']//button[@class='close']", "click on close");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//div[@class='modal-header']//button[@class='close']", "click on close");
			softAssertion.assertTrue(false);
		}
	}

}
