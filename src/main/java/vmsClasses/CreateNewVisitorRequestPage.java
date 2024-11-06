/*-----------------------Page added by Nancy --------------------------*/
package vmsClasses;

import org.openqa.selenium.WebDriver;
import utilities.GenericMethods;
import utilities.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateNewVisitorRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_Select_SBU = "//select[@id='createNewVisitorRequest_selSbu']";
	public static final String OCR_Button_Go = "//button[contains(text(),'GO')]";
	public static final String OCR_Button_RequestorName = "//a[@id='reqLink']";
	public static final String OCR_FirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Host_SBU = "//select[@id='sbuCode']";
	public static final String OCR_Meeting_Location_SBU = "//select[@id='visitorRequestInformation_hostSbu']";
	public static final String OCR_Requestor_Name = "//a[@id='reqLink']";
	public static final String OCR_Requestor_User_First_Name = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Requestor_Button_Search = "//button[@name='Search']";
	public static final String OCR_Requestor_SearchRecord = "//table[@id='gridPopup']//tr[@id='1']";
	public static final String OCR_Requestor_SelectButton = "//button[@name='Ok']";
	public static final String OCR_Email = "//input[@id='visitorRequestInformation_visitorGeneralInfoValue_requestorEmail']";
	public static final String OCR_Visit_Date_From = "//input[@id='VMM_FLD_4']";
	public static final String OCR_Visit_Date_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_Visit_Date_To = "//input[@id='VMM_FLD_5']";
	public static final String OCR_Phone = "//input[@id='VMM_FLD_193']";
	public static final String OCR_Employee_Id = "//input[@id='VMM_FLD_202']";
	public static final String OCR_Visit_Time_From = "//select[@id='visitorRequestInformation_visitorGeneralInfoValue_scheduledTimeFrom']";
	public static final String OCR_Visit_Time_To = "//select[@id='visitorRequestInformation_visitorGeneralInfoValue_scheduledTimeTo']";
	public static final String OCR_Local_Host = "//input[@name='sameLocalHost']";
	public static final String OCR_Primary_Host = "//input[@name='sameRequestor']";
	public static final String OCR_Requestor = "//input[@name='sameRequestor']";
	public static final String OCR_Create = "//button[@id='submitForm']";
	public static final String OCR_CreateExistingReq = "(//input[@name='newVisitor'])[2]";
	public static final String OCR_EmailAddress = "//input[@id='createNewVisitorRequest_visitorEmail']";

	/*--------------------------------Constructor------------------------------------------*/

	public CreateNewVisitorRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-----------------------------------------------Actions-------------------------------------*/

	// Select SBU from the dropdown
	public void select_sbu(String SelectSBU) {
		if (OCR_Select_SBU != null) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_Go, "Clicking on Go Button");
		} else {
			selectByVisibleText(driver, test, OCR_Select_SBU, "Select SBU : ", SelectSBU);
			clickElement(driver, test, OCR_Button_Go, "Clicking on Go Button");
		}
	}

	// Select the Host SBU
	public void select_HostSbu(String HostSBU) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_Host_SBU, "Selecting the Host SBU : ", HostSBU);
	}

	// Select Meeting Location SBU
	public void select_MeetingLocationSBU(String MeetingLocationSBU) {
		selectByVisibleText(driver, test, OCR_Meeting_Location_SBU, "Selecting the Meeting Location SBU : ",
				MeetingLocationSBU);
	}

	// Select Requestor name
	public void select_RequestorName(String RequestorFirstName) {
		clickElement(driver, test, OCR_Requestor_Name, "Click Requestor Name");
		try {
			typeText(driver, test, OCR_Requestor_User_First_Name, "Enter First Name : ", RequestorFirstName);
			clickElement(driver, test, OCR_Requestor_Button_Search, "Click Search Button");
			clickElement(driver, test, OCR_Requestor_SearchRecord, "Click searched record");
			clickElement(driver, test, OCR_Requestor_SelectButton, "Click  Select Button");
		} catch (Exception e) {
			clickElement(driver, test, "(//button[@class='close'])[1]", "Click on Close POP up");
		}
	}

	// Select Visit Date From
	public void select_VisitDateFrom(String VisitDateFrom) {
		if (VisitDateFrom.length() > 0) {
			clickElement(driver, test, OCR_Visit_Date_From, "Clicking on from date");
			if (VisitDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_Visit_Date_Today, "Clicking on Today Button");
			} else {

				date(driver, test, "Selecting the From date : ", VisitDateFrom);
			}
		}
	}

	// Select Visit Date From
	public void select_VisitDateTo(String VisitDateTo) {
		if (VisitDateTo.length() > 0) {
			clickElement(driver, test, OCR_Visit_Date_To, "Clicking on to date");
			if (VisitDateTo.contains("Today")) {
				clickElement(driver, test, OCR_Visit_Date_Today, "Clicking on Today Button");
			} else {

				date(driver, test, "Selecting the To date : ", VisitDateTo);
			}
		}
	}
			
			/*	}
	
	 * } // Select Visit Date To public void select_VisitDateTo(String VisitDateTo)
	 * { if (VisitDateTo.length() > 0) { clickElement(driver, test,
	 * OCR_Visit_Date_To, "Clicking on to date"); date(driver, test,
	 * "Selecting the To date : ", VisitDateTo); test.log(LogStatus.PASS,
	 * "Selecting the To date : " + VisitDateTo); } }
	 */

	// Enter Email
	public void type_Email(String Email) {
		clearText(driver, test, OCR_Email, "Clear the Email : " + Email);
		typeText(driver, test, OCR_Email, "Typing Email : ", Email);
	}

	// Enter Phone No
	public void type_Phone(String Phone) {
		typeText(driver, test, OCR_Phone, "Typing Phone No : ", Phone);
	}

	// Enter Employee Id
	public void type_EmployeeId(String EmployeeId) {
		typeText(driver, test, OCR_Employee_Id, "Typing EmployeeId : ", EmployeeId);
	}

	// Check Local Host Checkbox
	public void check_LocalHost(String LocalHost) {
		clickElement(driver, test, OCR_Local_Host, "click on local host");
	}

	// Check PrimaryHost Checkbox
	public void check_PrimaryHost(String PrimaryHost) {
		clickElement(driver, test, OCR_Primary_Host, "click on primary host");
	}

	// Click on Create Button
	public void click_Create() {
		clickElement(driver, test, OCR_Create, "click on create button");
	}

	// Validate Add visitor Create buttton
	public void validate_CreatNewVR(String HostSBU, String MeetingLocationSBU) throws Exception {

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (HostSBU.equalsIgnoreCase("SELECT")) {
					if (isDisplayed(driver, "//li[contains(text(),'Phone is required.')]")) {
						test.log(LogStatus.INFO, "Phone no is required");
					}
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on CREATE button");
		}
	}

	// Validate Add visitor Create Time and Date
	public void validate_CreatNewVRTimeDate(String HostSBU, String MeetingLocationSBU) throws Exception {

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (HostSBU.equalsIgnoreCase("SELECT")) {
					if (isDisplayed(driver, "//li[text()='Host SBU is required']")) {
						test.log(LogStatus.INFO, "Host SBU is required");
					}
				}
				if (HostSBU.equalsIgnoreCase("SELECT")) {
					if (isDisplayed(driver, "//li[text()='Meeting Location SBU is required']")) {
						test.log(LogStatus.INFO, "Meeting Location SBU is required");
					}
				}

				if (isDisplayed(driver, "//li[text()='']")) {
					test.log(LogStatus.INFO, "Visit Date From is required.");
				}
				if (isDisplayed(driver, "//li[text()='Visit Date To is required.']")) {
					test.log(LogStatus.INFO, "Visit Date To is required.");
				}

			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on CREATE button");
		}
	}

	// Click on Create Visitor Request From an Existing Request
	public void clickExistingReq() {
		clickElement(driver, test, OCR_CreateExistingReq,
				"Click on Create Visitor Request From an Existing Request Radio button");
	}

	// Check the Change Icon issue
	public void checkChangeIcon(String EmailAddress, String VID) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_EmailAddress, "Enter the Email : ", EmailAddress);
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'Search')]", "Click on Search");
		clickElement(driver, test, "//a[contains(text(),'" + VID + "')]/../../td[10]/div/div[3]//i",
				"Click on Visitor Request ID : " + VID + " Change Icon Link");
		clickElement(driver, test, "//button[contains(text(),'Add Change Request')]", "Click on Change Request Button");
		clickElement(driver, test, "//button[@name='save']", "Click on Save");
	}

	// Validate Employee ID
	public void validate_EmployeeID() throws Exception {

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Employee Id  is required.')]")) {
					test.log(LogStatus.INFO, "Employee Id  is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Employee Id  is marked as mandatory");
		}
	}

}