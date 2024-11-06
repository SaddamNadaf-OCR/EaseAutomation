package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateForm7GeneralInformationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateForm7GI_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_CreateForm7GI_TransactionId = "//input[@id='editNrcDosGeneralInfo_dosGeneralInfo_transactionId']";
	public static final String OCR_CreateForm7GI_StatusChangeDate = "//input[@id='editNrcDosGeneralInfo_statusChangeDate']";
	public static final String OCR_CreateForm7GI_Phone = "//input[@id='editNrcDosGeneralInfo_dosGeneralInfo_poaTelNo']";
	public static final String OCR_CreateForm7GI_TypeofAction = "//select[@id='editNrcDosGeneralInfo_typeOfAction']";
	public static final String OCR_CreateForm7GI_USGDateSubmitted = "//input[@id='editNrcDosGeneralInfo_fromDateToState']";
	public static final String OCR_CreateForm7GI_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String OCR_CreateForm7GI_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_CreateForm7GI_Department = "(//a[contains(text(),'Department')])[2]";
	public static final String OCR_CreateForm7GI_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String OCR_CreateForm7GI_Requestor = "//a[contains(text(),'Requestor')]";
	public static final String OCR_CreateForm7GI_Reviewer = "(//a[contains(text(),'Reviewer')])[2]";
	public static final String OCR_CreateForm7GI_Select = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateForm7GI_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_CreateForm7GI_Search = "//button[@name='Search']";
	public static final String OCR_CreateForm7GI_SiteID = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String OCR_CreateForm7GI_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_CreateForm7GI_PopUPClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateForm7GI_GeneratePDF = "//button[contains(text(),'Generate PDF')]";
	public static final String OCR_CreateForm7GI_Form7Details = "//button[contains(text(),'Form 7 Details')]";
	public static final String OCR_CreateForm7GI_Status = "//select[@name='status']";
	public static final String OCR_CreateForm7GI_licenseNo = "//input[@id='editNrcDosGeneralInfo_dosGeneralInfo_licenseNo']";
	public static final String OCR_CreateForm7GI_IssueDate = "//input[@id='editNrcDosGeneralInfo_fromIssueDate']";
	public static final String OCR_CreateForm7GI_ExpiryDate = "//input[@id='editNrcDosGeneralInfo_fromExpiryDate']";

	/* ******************** Constructor ***************************** */

	public CreateForm7GeneralInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Add create new form
	public void addFormDetails(String TransactionId, String StatusChangeDate, String Phone, String TypeofAction,
			String USGDateSubmitted, String ProgramCode, String Segment, String Department, String SiteID,
			String RequestorUserFirstName, String ReviewerUserFirstName) {
		
		typeText(driver, test, OCR_CreateForm7GI_TransactionId, "Enter the Transaction ID : ", TransactionId + randomnumbers());
		clickElement(driver, test, OCR_CreateForm7GI_StatusChangeDate, "Click on Status Change Date");
		date(driver, test, "Select the Date : ", StatusChangeDate);
		typeText(driver, test, OCR_CreateForm7GI_Phone, "Enter the Phone : ", Phone);
		selectByVisibleText(driver, test, OCR_CreateForm7GI_TypeofAction, "Select the Type of Action : ", TypeofAction);
		if (USGDateSubmitted.length() > 0) {
			clickElement(driver, test, OCR_CreateForm7GI_USGDateSubmitted, "Click on USG Date Submitted");
			date(driver, test, "Select the USG Date Submitted : ", USGDateSubmitted);
		}
		if (ProgramCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateForm7GI_Program, "click on Program Link");
			try {
				//typeText(driver, test, OCR_CreateForm7GI_ProgramCode, "Enter the Program Code : ", ProgramCode);
				clickElement(driver, test, OCR_CreateForm7GI_Search, "Click on Search");
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_programCode'])[1]",
						"Click on Program code : " + ProgramCode);
				clickElement(driver, test, OCR_CreateForm7GI_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateForm7GI_PopUPClose, "Click on POP UP Close");
			}
		}
		if (Segment.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateForm7GI_Segment, "Click on Segment Link");
			try {
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_segmentCode'])[1]",
						"Click on Program code : " + Segment);
				clickElement(driver, test, OCR_CreateForm7GI_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateForm7GI_PopUPClose, "Click on POP UP Close");
			}
		}
		if (Department.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateForm7GI_Department, "Click on Department");
			try {
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_centerId'])[1]",
						"Click on Program code : " + Department);
				clickElement(driver, test, OCR_CreateForm7GI_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateForm7GI_PopUPClose, "Click on POP UP Close");
			}
		}
		if (SiteID.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateForm7GI_Site, "Click on Site Link");
			try {
				//typeText(driver, test, OCR_CreateForm7GI_SiteID, "Enter the Site ID : ", SiteID);
				clickElement(driver, test, OCR_CreateForm7GI_Search, "Click on Search");
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_siteId'])[1]",
						"Click on Program code : " + SiteID);
				clickElement(driver, test, OCR_CreateForm7GI_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateForm7GI_PopUPClose, "Click on POP UP Close");
			}
		}
		if (RequestorUserFirstName.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateForm7GI_Requestor, "Click on Requestor");
			try {
				typeText(driver, test, OCR_CreateForm7GI_UserFirstName, "Enter the UserFirstName : ",
						RequestorUserFirstName);
				clickElement(driver, test, OCR_CreateForm7GI_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + RequestorUserFirstName + "')]",
						"Click on Program code : " + RequestorUserFirstName);
				clickElement(driver, test, OCR_CreateForm7GI_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateForm7GI_PopUPClose, "Click on POP UP Close");
			}
		}
		if (ReviewerUserFirstName.length() > 0) {
			Wait.waitfor(3);
			scrollToBottom(driver);
			clickElement(driver, test, OCR_CreateForm7GI_Reviewer, "Click on Reviewer");
			try {
				typeText(driver, test, OCR_CreateForm7GI_UserFirstName, "Enter the UserFirstName : ",
						ReviewerUserFirstName);
				clickElement(driver, test, OCR_CreateForm7GI_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + ReviewerUserFirstName + "')]",
						"Click on Program code : " + ReviewerUserFirstName);
				clickElement(driver, test, OCR_CreateForm7GI_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateForm7GI_PopUPClose, "Click on POP UP Close");
			}
		}
	}

	// Click on Save button
	public void clickSave() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_CreateForm7GI_Save);
		clickElement(driver, test, OCR_CreateForm7GI_Save, "Click on Save Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateForm7GI_Phone, "");
	}

	// click on Generate PDF
	public void clickGeneratePDF() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateForm7GI_GeneratePDF, "Click on Generate PDF");
	}

	// click on Generate PDF
	public void clickForm7Details() {
		//scrollToElement(driver, OCR_CreateForm7GI_Form7Details);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateForm7GI_Form7Details, "Click on Form 7 Details");
		AlertPopUp(driver, test,"WARNING: To prevent loss of data, please save the Form 7 before adding Additionals. Click OK to continue without saving.");
		Wait.waitfor(2);
	}

	// Select the Status
	public void selectStatus(String Status, String ChangeStatus, String ChangeStatusUSG, String ChangeStatusApproved,
			String licenseNo, String IssueDate, String ExpiryDate) throws Exception {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_CreateForm7GI_Status, "Select the Status : ", Status);
		clickElement(driver, test, OCR_CreateForm7GI_Save, "Click on Save");
		clickEnter();
		Wait.waitfor(3);
		//selectByVisibleText(driver, test, OCR_CreateForm7GI_Status, "Select the Status : ", ChangeStatus);
		//clickElement(driver, test, OCR_CreateForm7GI_Save, "Click on Save");
		clickEnter();
		//selectByVisibleText(driver, test, OCR_CreateForm7GI_Status, "Select the Status : ", ChangeStatusUSG);
		//clickElement(driver, test, OCR_CreateForm7GI_Save, "Click on Save");
		clickEnter();
		//sssselectByVisibleText(driver, test, OCR_CreateForm7GI_Status, "Select the Status : ", ChangeStatusApproved);
		Wait.waitfor(3);
		typeText(driver, test, OCR_CreateForm7GI_licenseNo, "Enter the License No : ", licenseNo);
		clickElement(driver, test, OCR_CreateForm7GI_IssueDate, "Click on Issue Date");
		/*
		 * date(driver, test, "Select the Date : ", IssueDate); Wait.waitfor(3);
		 * clickElement(driver, test, OCR_CreateForm7GI_ExpiryDate,
		 * "click on Expiry Date"); date(driver, test, "Select the Expiry Date : ",
		 * ExpiryDate); */
		clickElement(driver, test, OCR_CreateForm7GI_Save,"Click on Save");
		clickEnter();
	}

	// Valikdations of General Info
	public void validateGeneralInfo() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Reference No is required.')]")) {
					test.log(LogStatus.INFO, "Reference No is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Type of Action is required')]")) {
					test.log(LogStatus.INFO, "Type of Action is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in General Information");
		}
	}

}
