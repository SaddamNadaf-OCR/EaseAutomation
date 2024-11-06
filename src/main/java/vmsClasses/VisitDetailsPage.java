/*-----------------------Page added by Nancy --------------------------*/
package vmsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_All_Day_Access = "//input[@id='VMM_FLD_10']";
	public static final String OCR_247_Acess = "//input[@id='VMM_FLD_11']";
	public static final String OCR_WeekendAcess = "//input[@id='VMM_FLD_12']";
	public static final String OCR_Button_AddHost = "//button[@name='localHost']";
	public static final String OCR_AddHostName = "//input[@id='VMM_FLD_200']";
	public static final String OCR_AddHostEmail = "//input[@id='VMM_FLD_201']";
	public static final String OCR_AddHostPhone = "//input[@id='VMM_FLD_193']";
	public static final String OCR_LocalHost = "//input[@id='localHostCheck']";
	public static final String OCR_PrimaryHost = "//input[@id='primaryHostCheck']";
	public static final String OCR_PrimaryHostLink = "//a[contains(text(),'Primary Host')]";
	public static final String OCR_AddHostUserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Button_AddHostSearch = "//button[contains(text(),'Search')]";
	public static final String OCR_AddHostSearchRecord = "//table[@id='gridPopup']//tr[@id='1']";
	public static final String OCR_Button_AddHostSelect = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_AddHostAdd = "//button[@id='mybutton']";
	public static final String OCR_Button_AddHostCancel = "//button[@id='cancel']";
	public static final String OCR_HostQuestions = "//a[@id='hostQuestion']";
	public static final String OCR_SiteNavigationArrow = "(//div[@class='ms-trigger'])[1]";
	public static final String OCR_Site_BuildingNameNavigationArrow = "(//div[@class='ms-trigger'])[2]";
	public static final String OCR_Site_EntranceLobbyNavigationArrow = "(//div[@class='ms-trigger'])[3]";
	public static final String OCR_Site_RoomNoDescriptionNavigationArrow = "(//div[@class='ms-trigger'])[4]";
	public static final String OCR_Site_BuildingName = "//input[@placeholder='Please select Building Name...']";
	public static final String OCR_Site_EntranceLobby = "//input[@placeholder='Please select Entrance / Lobby...']";
	public static final String OCR_Site_RoomNoDescription = "//input[@placeholder='Please select Room No / Description...']";
	public static final String OCR_Button_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_ClassificationLevel = "//select[@id='VMM_FLD_24']";
	public static final String OCR_VisitPurpose = "//select[@id='VMM_FLD_26']";
	public static final String OCR_DescriptionOfVisit = "//textarea[@id='VMM_FLD_27']";
	public static final String OCR_TechnicalDiscussions = "//input[@id='VMM_FLD_28']";
	public static final String OCR_Program = "//textarea[@id='VMM_FLD_49']";
	public static final String OCR_Segment = "//textarea[@id='VMM_FLD_50']";
	public static final String OCR_ProductFamily = "//textarea[@id='VMM_FLD_51']";
	public static final String OCR_ProductLine = "//textarea[@id='VMM_FLD_52']";
	public static final String OCR_ChargeNumber = "//input[@id='VMM_FLD_53']";
	public static final String OCR_NA = "//input[@id='VMM_FLD_54']";
	public static final String OCR_OnLoanDept = "//input[@id='VMM_FLD_111']";
	public static final String OCR_Button_Save = "(//button[@name='save'])[2]";
	public static final String OCR_Button_ForwardNavigation = "//button[contains(text(),'Save')]/preceding::button[1]";
	public static final String OCR_VD_SiteGrid = "//button[@name='saveLocation']/following::div[1]";
	public static final String OCR_Button_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_SendInvite_Button = "//button[@id='sendInviteId']";
	public static final String OCR_AddHost_NewField_DateOLastCTraining = "//input[@id='dateOfExportTraining']";
	public static final String OCR_Visit_Date_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_Visit_TemplateName = "//input[@id='VMM_FLD_188']";
	public static final String OCR_SaveTemplate = "//div[@class='row btn-row']//button[3]";
	public static final String OCR_CancleVR = "(//button[@name='cancelRequest'])[1]";
	public static final String OCR_VisitorInfo_Status = "(//span[@class='additional-value'])[2]";
	public static final String OCR_VisitorInfo_Menugrid ="//i[@class='fa fa-th']";
	public static final String OCR_VisitorInfo_GridVisitors ="(//a[contains(text(), 'Visitors')])[2]";

	/*--------------------------------Constructor------------------------------------------*/

	public VisitDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	// Enter Template name
	public void select_Templatename(String TemplateName) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_Visit_TemplateName, "Entering Template name : ", TemplateName);
	}

	// Click on save button
	public void click_TemplateSavebtn() {
		clickElement(driver, test, "//div[@class='row btn-row']//button[3]", "click on Save button");
		Wait.waitfor(4);
	}

	// select 24/7
	public void select_247() {
		clickElement(driver, test, OCR_247_Acess, "Clicking on 24/7 checkbox");
	}

	// Enable AllDayAcess Checkbox
	public void enable_AllDayAcess() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_All_Day_Access, "click on all days acess");
	}

	// Selecting the WeekendAccess
	public void select_WeekendAccess() {
		clickElement(driver, test, OCR_WeekendAcess, "click on WeekendAccess");
	}

	// Adding Host Details
	public void add_Host(String HostName, String HostEmail, String LastCompliancedate, String PhoneNo) {
		clickElement(driver, test, OCR_Button_AddHost, "Clicking Add Host Button");
		try {
			Wait.waitfor(3);
			typeText(driver, test, OCR_AddHostName, "Entering Host Name:", HostName);
			typeText(driver, test, OCR_AddHostEmail, "Entering Host Email", HostEmail);
			typeText(driver, test, "//input[@id='VMM_FLD_193']", "Enter the Phone no : ", PhoneNo);
			clickElement(driver, test, OCR_LocalHost, "Check Local Host: ");
			Wait.waitfor(4);
			clickElement(driver, test, OCR_AddHost_NewField_DateOLastCTraining,
					"Click on Date of Last Compliance Training ");
			Wait.waitfor(4);
			if (LastCompliancedate.contains("Today")) {
				clickElement(driver, test, OCR_Visit_Date_Today, "Clicking on Today Button");
			} else {
				date(driver, test, "Selecting the From date : ", LastCompliancedate);
			}
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_AddHostAdd, "Clicking on Add Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "(//button[@class='close'])[1]", "Click on pop close");
		}

	}

	// Click on Add host button
	public void click_AddHost() {
		clickElement(driver, test, OCR_Button_AddHost, "Clicking Add Host Button");
	}

	// Verify Requestor check box is displayed or not in add/edit host popup
	public void Displayed_Requestor() {
		if (isDisplayed(driver, "//input[@name='requestor']")) {
			Wait.waitfor(3);
			test.log(LogStatus.FAIL, "Requestor check box is displayed under Add/Edit host popup");
		} else {
			test.log(LogStatus.PASS, "Requestor check box is not displayed under Add/Edit host popup ");
		}
	}

	// Changing Primary Host functionality is not Working as Expected in add host
	// Pop up
	public void add_PrimaryHost(String HostName, String HostEmail, String HostPhone) {
		// clickElement(driver, test, OCR_Button_AddHost,"Clicking Add Host Button");
		// Wait.waitfor(3);
		typeText(driver, test, OCR_AddHostName, "Entering Host Name:", HostName);
		Wait.waitfor(3);
		typeText(driver, test, OCR_AddHostEmail, "Entering Host Email", HostEmail);
		Wait.waitfor(3);
		typeText(driver, test, OCR_AddHostPhone, "Entering Host Phone", HostPhone);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_PrimaryHost, "Check Primary Host ");
		/*
		 * clickElement(driver, test,OCR_AddHost_NewField_DateOLastCTraining,
		 * "Click on Date of Last Compliance Training "); Wait.waitfor(4);
		 * if(LastCompliancedate.contains("Today")) { clickElement(driver, test,
		 * OCR_Visit_Date_Today, "Clicking on Today Button"); }else { date(driver, test,
		 * "Selecting the From date : " , LastCompliancedate); }
		 */
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Button_AddHostAdd, "Clicking on Add Button");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_PrimaryHostLink, "Click Primary Host Link");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_PrimaryHost, "UnCheck the Primary Host check box: ");
		clickElement(driver, test, OCR_LocalHost, "Check Local Host: ");
		clickElement(driver, test, OCR_Button_AddHostAdd, "Clicking on Add Button");
		try {
			if (isDisplayed(driver, "//button[@name='localHost']")) {
				test.log(LogStatus.PASS, "Successfully changing the Primary host to local host");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.PASS, "Please Check Primary Host. Error Vaildation is not showing ");
		}
	}

	// verify delete icon is enable or not
	public void Enabled_HostDeleteIcon() {
		if (isEnabled(driver, "//i[@class='fa fa-trash-o']")) {
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "Host delete icon is Enabled");
		} else {
			test.log(LogStatus.PASS, "Host delete icon is Disabled");
		}
	}

	// Adding Site Details
	public void add_Site(String Site, String BuildingName, String EntranceLobby, String RoomNoDescription) {
		scrollToElement(driver, "(//label[contains(text(),'Meeting Location')])[2]");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_SiteNavigationArrow, "click on Site arrow");
		String site = "//div[contains(text(),'" + Site.trim() + "')]";
		Wait.waitfor(5);
		clickElement(driver, test, site, "Select the site : " + Site);
		clickElement(driver, test, OCR_Site_BuildingNameNavigationArrow, "click on Building Name arrow");
		typeText(driver, test, OCR_Site_BuildingName, "Enter building name : ", BuildingName);
		clickElement(driver, test, OCR_Site_EntranceLobbyNavigationArrow, "click on Entrance Lobby arrow");
		typeText(driver, test, OCR_Site_EntranceLobby, "Enter building name : ", EntranceLobby);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Site_RoomNoDescriptionNavigationArrow, "click on Room No arrow");
		typeText(driver, test, OCR_Site_RoomNoDescription, "Enter building name : ", RoomNoDescription);
	}

	// Selecting the Classification Level
	public void select_classificationlevel(String ClassificationLevel) {
		String scroll = "//label[contains(text(),'Meeting Information')]";
		GenericMethods.scrollToElement(driver, scroll);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ClassificationLevel, "Selecting Classification Level : ",
				ClassificationLevel);
	}

	// Select the Visit Purpose
	public void select_visitpurpose(String VisitPurpose) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_VisitPurpose, "Selecting Visit Purpose : ", VisitPurpose);
	}

	// Select the Description Of Visit
	public void select_descriptionofvisit(String DescriptionOfVisit) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_DescriptionOfVisit, "Entering Description of Visit : ", DescriptionOfVisit);
	}

	// Select the Meeting Categories
	public void select_meetingcategories(String MeetingCategories) {
		clickElement(driver, test, "(//div[@class='ms-trigger-ico'])[5]", "Click on  Meeting categories");
		Wait.waitfor(2);
		typeText(driver, test, "//input[@placeholder='Please select Category...']", "Enter the meeting categories : ",
				MeetingCategories);
		Wait.waitfor(3);
		clickElement(driver, test, "(//div/em[contains(text(),'" + MeetingCategories + "')])[1]",
				"Select the Meeting categories : " + MeetingCategories);
	}

	// Select the Program
	public void select_program(String Program) {
		String scrollto_otherdetails = "//label[contains(text(),'Other Details')]";
		GenericMethods.scrollToElement(driver, scrollto_otherdetails);
		typeText(driver, test, OCR_Program, "Entering Program : ", Program);
	}

	// Enter Segment
	public void select_segment(String Segment) {
		typeText(driver, test, OCR_Segment, "Enter Segment : ", Segment);
	}

	// Enter Product Family
	public void select_productfamily(String ProductFamily) {
		typeText(driver, test, OCR_ProductFamily, "Enter Product Family : ", ProductFamily);
	}

	// Enter Product Line
	public void select_productline(String ProductLine) {
		typeText(driver, test, OCR_ProductLine, "Enter Product Line : ", ProductLine);
	}

	// Enter ChargeNumber
	public void select_chargenumber(String ChargeNumber) {
		typeText(driver, test, OCR_ChargeNumber, "Enter ChargeNumber : ", ChargeNumber);
	}

	// Adding the On loan Department
	public void select_onloandepartment(String OnLoanDepartment) {
		typeText(driver, test, OCR_OnLoanDept, "Enter OnLoanDepartment : ", OnLoanDepartment);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
		Wait.waitfor(5);
		// clickElement(driver, test, OCR_Button_ForwardNavigation,"Click on forward
		// navigation button");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}

	// To verify Send invite button is disabled or not
	public void click_SendInviteDisbled() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_Menugrid, "click on menu grid");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_GridVisitors, "Click on visitor option from menu grid");
		Wait.waitfor(3);
		if (!isEnabled(driver, OCR_SendInvite_Button)) {
			test.log(LogStatus.PASS, "Request visitor Information button is disabled");
		} else {
			test.log(LogStatus.FAIL, "Request visitor Information is enabled");
			testFailSshot(driver, test);
		}
	}

	// Validate Visit Details Save buttton
	public void validate_VisitDetailsMeetingInfo() throws Exception {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Classification Level is required.')]")) {
					test.log(LogStatus.INFO, "Classification Level is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Description of Visit is required.')]")) {
					test.log(LogStatus.INFO, "Description of Visit is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for Meeting Information is not Displayed by clicking on SAVE button");
		}
	}

	// Validate Visit Details Save buttton
	public void validate_OtherDetails() throws Exception {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//span[contains(text(),'Charge Number is required.')]")) {
					test.log(LogStatus.INFO, "Charge Number is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error Vaildation for OtherDetails is not Displayed by clicking on SAVE button");
		}
	}

	// validate add site pop up
	public void validate_AddSite() {
		Wait.waitfor(4);
		// scrollToElement(driver, OCR_Button_AddHost);
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Site Name is required')]")) {
					test.log(LogStatus.INFO, "Site is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Building Name is required')]")) {
					test.log(LogStatus.INFO, "Building is required");
				}
				Wait.waitfor(3);
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for ADD Site is not Displayed by clicking on SAVE & Return button");
			clickElement(driver, test, "//button[@class='close closeWindow']", "click on cancle button");
		}
	}

	// click on Save Button
	public void click_Savebtn() {
		Wait.waitfor(4);
		String save = "//h3[@class='page-heading']";
		scrollToElement(driver, save);
		clickElement(driver, test, "//div[@class='row btn-row']//button[3]", "click on Save button");
	}

	public boolean check_sitegrid() {
		scrollToElement(driver, "//button[@name='saveLocation']");
		return isEnabled(driver, OCR_VD_SiteGrid);
	}

	// click on Forword to visitor
	public void forwardToVisitors() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "(//a[contains(text(), 'Visitors')])[2]", "click on visitor");
	}
	
	public String getVisitorCode() {
		return getText(driver, test, "//td[@aria-describedby='grid_visitorCode']", "Get visitor code");
	}
	
	public void moveToVisitorstab() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on Menu icon");
		clickElement(driver, test, "(//a[contains(text(), 'Visitors')])[2]", "click on visitor");
	}
	
	// click on Forword to VisitDetails
	public void forwardToVisitDetails() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "//a[@class='generalInfoTab selected']", "click on VisitDetails");
	}

	// click on Forword to Questionnaire
	public void forwardToQuestionnaire() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "//a[@class='vmctQuestionnaireTab']", "click on Questionnaire");
	}

	// click on Forword to Document
	public void forwardToDocument() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "//a[@class='attachmentsTab']", "click on Document");
	}

	// click on Forword to Notes
	public void forwardToNotes() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "//a[@class='notesTab']", "click on Notes");
	}

	// click on Forword to Submit
	public void forwardToSubmit() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		Wait.waitfor(3);
		clickElement(driver, test, "//a[@class='submissionTab']", "click on Submit");
	}

	// click on Forword to Review Tab
	public void forwardToReviewTab() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "//a[@class='reviewTab']", "click on Review Tab");
		Wait.waitfor(3);
	}

	// click on Forword to Change Review Tab
	public void forwardToChangeRequestTab() {
		Wait.waitfor(3);
		scrollToElement(driver, "//div[@class='form-content top-empty-row']");
		clickElement(driver, test, "//i[@class='fa fa-th']", "click on forward");
		clickElement(driver, test, "//a[@class='changeRequestTab']", "click on Change Review Tab");
	}

	// Alert of Request ID created successfully
	public void alertReqIDCreated(String RequestID) {
		String alert = "//h4[contains(text(),'You Created Request ID " + RequestID + " successfully.')]";

		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO, "You Created Request ID " + RequestID + " successfully!");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Alert message is not displayed by clicking on Create button");
			testFailSshot(driver, test);
		}
	}

	// Select Visit Date From
	public void select_VisitDateFrom(String VisitDateFrom) {
		if (VisitDateFrom.length() > 0) {
			clickElement(driver, test, "//input[@id='VMM_FLD_4']", "Clicking on from date");
			if (VisitDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_Visit_Date_Today, "Clicking on Today Button");
			} else {

				date(driver, test, "Selecting the From date : ", VisitDateFrom);
			}
		}
	}

	// Select Visit Date To
	public void select_VisitDateTo(String VisitDateTo) {
		if (VisitDateTo.length() > 0) {
			clickElement(driver, test, "//input[@id='VMM_FLD_5']", "Clicking on to date");
			date(driver, test, "Selecting the To date : ", VisitDateTo);
			test.log(LogStatus.PASS, "Selecting the To date : " + VisitDateTo);
		}
	}
	// Validate Change Request Page for Approved Visit
			public void validateChangeReqIcon() throws Exception {
				try {
					if (isDisplayed(driver, "//h3[contains(text(),'Change Request')]")) {
						test.log(LogStatus.INFO, "Change Request Icon available.");
						}
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Change Request Icon Not available.");
				}
			}


	// Click on Cancle the Visit Request
	public void validateCancleButton() {
		clickElement(driver, test, OCR_CancleVR, "Click on Cancle Visitor Request");
		AlertPopUp(driver, test, "This action will Cancel your request. Do you wish to continue?");
		AlertPopUp(driver, test, "Your request is cancelled. Thank you.");
		String status = getText(driver, test, OCR_VisitorInfo_Status, "Request status : ");
		if (status.equals("Cancelled")) {
			test.log(LogStatus.PASS, "Status Changed to Cancle");
		}else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Status Changed to "+status);
		}
	}

}
