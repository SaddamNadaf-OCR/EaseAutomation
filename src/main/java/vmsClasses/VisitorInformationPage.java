package vmsClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class VisitorInformationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitorInfo_HostSBU = "//select[@id='VMM_FLD_112']";
	public static final String OCR_VisitorInfo_FromDate = "//label[contains(text(),'Visit Date From')]/following-sibling::div/input";
	public static final String OCR_VisitorInfo_ToDate = "//label[contains(text(),'Visit Date To')]/following-sibling::div/input";
	public static final String OCR_VisitorInfo_StartTime = "//select[@id='VMM_FLD_115']";
	public static final String OCR_VisitorInfo_EndTime = "//select[@id='VMM_FLD_116']";
	public static final String OCR_VisitorInfo_AllDayAccess = "//input[@id='VMM_FLD_117']";
	public static final String OCR_VisitorInfo_SiteArrow = "//div[@class='ms-trigger']";
	public static final String OCR_VisitorInfo_BuildingName = "//input[@placeholder='Please select Building Name...']";
	public static final String OCR_VisitorInfo_AddSite = "//button[@id='saveLocation']";
	public static final String OCR_VisitorInfo_AddHost = "//button[contains(text(),'Add Host')]";
	public static final String OCR_VisitorInfo_HostName = "//input[@id='editKioskVisitorLocalHost_hostName']";
	public static final String OCR_VisitorInfo_HostEmail = "//input[@id='editKioskVisitorLocalHost_hostEmail']";
	public static final String OCR_VisitorInfo_HostPhNO = "//input[@id='editKioskVisitorLocalHost_hostPhNo']";
	public static final String OCR_VisitorInfo_HostSave = "//button[@name='save']";
	public static final String OCR_VisitorInfo_HostCancle = "//button[@id='cancel']";
	public static final String OCR_VisitorInfo_RequestId = "(//span[@class='heading-additional']/span)[1]";
	public static final String OCR_VisitorInfo_Status = "(//span[@class='additional-value'])[2]";
	public static final String OCR_VisitorInfo_VisitorName = "//td[@aria-describedby='gridPerson_firstName']";
	public static final String OCR_VisitorInfo_Status1 = "//a[contains(text(),'Approved')]";
	public static final String OCR_VisitorInfo_AddOrganization = "//button[contains(text(),'Add Organization')]";
	public static final String OCR_VisitorInfo_MeetingCatgIntern = "//input[@id='VMM_FLD_181']";
	public static final String OCR_VisitorInfo_DatePickerYear = "//select[@class='ui-datepicker-year']";
	public static final String OCR_VisitorInfo_DatePickerMonth = "//select[@class='ui-datepicker-month']";
	public static final String OCR_VisitorInfo_AddVisitor = "//button[contains(text(),'Add Visitor')]";
	public static final String OCR_VisitorInfo_SendConfrmtn = "//button[@id='sendConfirmationId']";
	public static final String OCR_VisitorInfo_DplStatusRed = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-red']";
	public static final String OCR_VisitorInfo_DplStatusGreen = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-green']";
	public static final String OCR_VisitorInfo_ViewDetailOverride = "//button[contains(text(),'Override')]";
	public static final String OCR_VisitorInfo_DisptnReasonMatrix = "(//input[@name='dplreasons'])[5]";
	public static final String OCR_VisitorInfo_DisptnReasonMatxSave = "(//button[@type='submit'])[1]"; //(//button[text()='Save'])[2]
	public static final String OCR_VisitorInfo_Save = "//button[@name='save.x']";
	public static final String OCR_VisitorInfo_SaveAndReturn = "//button[@name='Ok.x']";
	public static final String OCR_VisitorInfo_DisclaimerDetails = "//input[@id='VMM_FLD_120']";
	public static final String OCR_VisitorInfo_DRMclose = "(//button[@class='close'])[1]";
	public static final String OCR_VisitorInfo_CheckIn = "//button[contains(text(),'Check In')]";
	public static final String OCR_VisitorInfo_PrintBadge = "//button[@id='printBadge']";
	public static final String OCR_VisitorInfo_Cancle = "//button[@id='mybuttonsmall']";
	public static final String OCR_loadinglocator = "//label[contains(text(),'Loading Content')]";
	public static final String OCR_VisitorInfo_Error1 = "//h4[contains(text(),'Error!')]";
	public static final String OCR_VisitorInfo_Error2 = "(//h4[contains(text(),'Error!')])[2]";
	public static final String OCR_VisitorInfo_AddHostDropDown = "//input[@id='hostNameId-selectized']";
	public static final String OCR_VisitorInfo_AcknwlegmntAndDocTable = "//table[@id='tableGrid1']";
	public static final String OCR_VisitorInfo_AcknwlegmntAndDocAgreeBtn = "//button[@class='pull-right primary-btn agreeBtn']";
	public static final String OCR_VisitorInfo_Close = "//button[@name='cancel.x']";
	public static final String OCR_VisitInfo_IDoc_ErrorV = "//span[contains(text(),'One Identifying Document is required.')]";
	public static final String OCR_VisitInfo_NotifyReview = "//button[@id='notifyReviewer']";
	public static final String OCR_VisitInfo_EmailReviewer = "//button[@type='submit']";
	public static final String OCR_VisitInfo_NotifyWLSReviewer="//button[contains(text(), 'Notify WLS Reviewer')]";
	public static final String OCR_VisitInfo_NotifyFVReviewer="//button[contains(text(), 'Notify FV Reviewer')]";
	public static final String OCR_VisitInfo_ChangeStatus="//button[@class='primary-btn dropdown-toggle shipment']";
	public static final String OCR_VisitInfo_DPLRedFlag="//i[@class='fa ocr-flag-field fa-flag ocr-flag-red']";
	public static final String OCR_VisitInfo_ReSendConfirmation="//button[@id='sendConfirmationId']";
	public static final String OCR_VisitInfo_RequestVisitorInformation="//button[@id='sendInviteId']";
	public static final String OCR_VisitInfo_Exit="//button[@onclick='retunPage()']";
	public static final String OCR_VisitInfo_AddFromExcel="//button[@id='attachExcelFile']";
	public static final String OCR_VisitInfo_Approved="//a[contains(text(),'Approved')]";
	public static final String OCR_VisitInfo_UploadFile="//span[@class='btn fileinput-button']";
	public static final String OCR_VisitInfo_SubmitButton="//button[@id='submit-btn']";
	public static final String OCR_VisitInfo_VisitorWorkflowType="//td[@aria-describedby='gridPerson_domesticorForeign']";
	

	
	/* ******************** Constructor ***************************** */

	public VisitorInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//	// Verify request Re-Send confirmation popup working.
	public void validate_ReSendConfirmationpopup() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_VisitInfo_ReSendConfirmation);
		clickElement(driver, test, "//input[@id='cb_gridPerson']", "Select the Visitor");
		clickElement(driver, test, OCR_VisitInfo_ReSendConfirmation, "Click on Send Invite");

		try {
			
			Wait.waitfor(4);
			clickElement(driver, test, "//button[@id='sendMail']", "Click on Send button");
			Wait.waitfor(4);
			isDisplayed(driver, "//label[contains(text(),'Deva M')]");
			Wait.waitfor(4);
			clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@id='cancel']", "Click on Cancle");
			}
	}

	// Adding data from excel
		public void addfromexcel() {
			scrollToElement(driver, OCR_VisitInfo_AddFromExcel);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_VisitInfo_AddFromExcel, "Adding From Excel");
			Wait.waitfor(5);
			try {
				clickElement(driver, test, OCR_VisitInfo_UploadFile, " click on Uploading the excel");
				Wait.waitfor(2);
				uploadFile(driver, test, "Add_Rapid_Visitor_Info.xlsx", "Uploading the excel : Add_Rapid_Visitor_Info.xlsx");
				Wait.waitfor(20);
				
				if (isEnabled(driver, OCR_VisitInfo_SubmitButton)) {
					clickElement(driver, test, OCR_VisitInfo_SubmitButton, "Clicking on Ok Button");
				}}
			 catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//button[@class='close closet']", "Clicking on cancle icon");
			}
		}
	

	// Select Approved status
	
	public void changeStatus() {
		clickElement(driver, test, OCR_VisitInfo_ChangeStatus, "Clicking on change status button");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_VisitInfo_Approved, "Clicking on change to approved");
	}
	// Select From date
	public void select_FromDate(String FromDate) {
		clickElement(driver, test, OCR_VisitorInfo_FromDate, "Clicking on from date");
		date(driver, test, "Selecing the From date : ", FromDate);
	}

	// Select To date
	public void select_ToDate(String ToDate) {
		clickElement(driver, test, OCR_VisitorInfo_ToDate, "Clicking on To date");
		date(driver, test, "Selecing the to date : ", ToDate);
	}

	// Select Start time
	public void select_StartTime(String StartTime) {
		selectByVisibleText(driver, test, OCR_VisitorInfo_StartTime, "Select Start time : ", StartTime);
	}

	// Select End time
	public void select_EndTime(String EndTime) {
		selectByVisibleText(driver, test, OCR_VisitorInfo_EndTime, "Select end time : ", EndTime);
	}

	// Select the Site
	public void select_Site(String Site) {
		GenericMethods.scrollToElement(driver, "(//a[@class='accordion-toggle'])[2]");
		Wait.waitfor(3);
		if (Site.length() > 0) {
			clickElement(driver, test, OCR_VisitorInfo_SiteArrow, "click on Site");
			String site = "//div[contains(text(),'" + Site.trim() + "')]";
			clickElement(driver, test, site, "Select the site : " + Site);
		}
	}

	// Enter Building Name
	public void type_BuildingName(String BuildingName) throws Exception {
		if (BuildingName.length() > 0) {
			clickElement(driver, test, OCR_VisitorInfo_BuildingName, "Click on building arrow");
			typeText(driver, test, OCR_VisitorInfo_BuildingName, "Enter building Name : ", BuildingName);
			Wait.waitfor(2);
			clickElement(driver, test, "//input[@placeholder='Please select Entrance / Lobby...']", "");

		}
	}

	// Click on add site
	public void clickAddSite() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_AddSite, "Click on ADD Site button");
	}

	// Clicking on Add Host
	public void click_AddHost() throws InterruptedException {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_VisitorInfo_AddHost, "Clicking on Add Host");
		Wait.waitfor(5);
	}

	// Enter Host Name
	public void type_HostName(String HostName) {
		Wait.waitfor(5);
		try {
			typeText(driver, test, OCR_VisitorInfo_HostName, "Enter Host Name : ", HostName);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Enter Host Name : ");
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VisitorInfo_HostCancle, "click on cancle icon");
		}
	}

	// Enter Host Email
	public void type_HostEmail(String HostEmail) {
		Wait.waitfor(3);
		try {
			typeText(driver, test, OCR_VisitorInfo_HostEmail, "Enter Host Email : ", HostEmail);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Enter Host Email : " + HostEmail);
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VisitorInfo_HostCancle, "click on cancle icon");
		}
	}

	// Enter Host PhoneNo
	public void type_HostPhNo(String HostPhNo) {
		try {
			typeText(driver, test, OCR_VisitorInfo_HostPhNO, "Enter Host PhoneNo : ", HostPhNo);
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Enter Host PhoneNo : ");
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VisitorInfo_HostCancle, "click on cancle icon");
		}
	}

	// Clicking on Host Save
	public void click_HostAdd() throws InterruptedException {
		clickElement(driver, test, OCR_VisitorInfo_HostSave, "Clicking on Host Save");
		Wait.waitfor(3);
	}

	// select drop down of add host
	public void Select_HostAdd(String VisitHost) {
		Wait.waitfor(3);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_AddHostDropDown, "click on HostAdd");
		String host = "//span[contains(text(),'" + VisitHost.trim() + "')]";
		Wait.waitfor(3);
		clickElement(driver, test, host, "Selected the AddHost" + VisitHost);
	}

	// Clicking on Send confirmations
	public void click_SendConfirmation() throws InterruptedException {
		clickElement(driver, test, OCR_VisitorInfo_SendConfrmtn, "Clicking on Send confirmations");
		Wait.waitfor(3);
	}

	// Getting the Request ID
	public String get_RequestID() throws InterruptedException {
		Wait.waitfor(5);
		return getAttribute(driver, test, OCR_VisitorInfo_RequestId, "innerText", "Request ID : ");
	}

	// Getting the Request status
	public String get_RequestStatus() {
		Wait.waitfor(3);
		return getAttribute(driver, test, OCR_VisitorInfo_Status, "innerText", "Request status : ");
		
	}
	// Getting the Request status1
	public String get_RequestStatus1() {
		Wait.waitfor(3);
		return getAttribute(driver, test, OCR_VisitorInfo_Status1, "innerText", "Request status : ");
		
	}
	

	// click on Add Organization
	public void click_AddOrganization() {
		scrollToElement(driver, "//label[contains(text(),'Visit Information')]");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_AddOrganization, "Clicking on Add Organization");
	}

	// click on the checkbox of Intern
	public void click_MeetingCatgIntern() {
		clickElement(driver, test, OCR_VisitorInfo_MeetingCatgIntern, "Clicking on MeetingCatgIntern");
	}

	// click on save button
	public void click_Save() throws InterruptedException {
		scrollToElement(driver,OCR_VisitorInfo_Save );
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_Save, "Clicking on Save");
	}

	// click on save and return
	public void click_SaveAndReturn() {
		scrollToElement(driver,OCR_VisitorInfo_SaveAndReturn );
		scrollToTop(driver);
		Wait.waitfor(5);
		clickElement(driver, test, OCR_VisitorInfo_SaveAndReturn, "Clicking on Save and Return");
	}

	// click on add visitor
	public void click_AddVisitor() {
		scrollToElement(driver, "//label[contains(text(),'Visit Information')]");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_AddVisitor, "Clicking on Add Visitor");
	}

	// DPL status Override method
	public void click_Override() throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_ViewDetailOverride, "Clicking on Override");
	}

	// Select the check box of Disposition Reason
	public void Select_DispositionReason() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VisitorInfo_DisptnReasonMatrix, "Select the Disposition Reason Matrix");
	}

	// Disposition Reason Matrix Save method
	public void click_DisptnReasonMatxSave() {
		clickElement(driver, test, OCR_VisitorInfo_DisptnReasonMatxSave, "Clicking on Disposition Reason Matrix Save");
	}

	// Getting the no of organization added in the result grid
	public int orgcount() {
		String orgtable = "//table[@id='gridOrg']/tbody/tr";
		List<WebElement> orgrows = driver.findElements(By.xpath(orgtable));
		if (orgrows.size() > 0) {
			return orgrows.size() - 1;
		} else {
			return 0;
		}
	}

	// change the DPL status if required
	public void click_DplStatus() throws InterruptedException {
		try {
			String flag = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-red' or @class='fa ocr-flag-field fa-flag ocr-flag-green']";
			String persontable = "//table[@id='gridPerson']/tbody/tr";
			Wait.wait(driver, OCR_loadinglocator);
			Wait.waitfor(3);
			List<WebElement> flags = driver.findElements(By.xpath(flag));
			List<WebElement> personrows = driver.findElements(By.xpath(persontable));
			int flagcount = flags.size();
			int personcount = personrows.size() - 1;
			int rowscount = personcount + orgcount();
			if (rowscount == flagcount) {
				if (OCR_VisitorInfo_DplStatusRed != null) {
					List<WebElement> row = driver.findElements(By.xpath(OCR_VisitorInfo_DplStatusRed));
					Iterator<WebElement> i = row.iterator();
					while (i.hasNext()) {
						i.next();
						Wait.waitfor(2);
						Wait.wait(driver, OCR_VisitorInfo_DplStatusRed);
						Wait.waitfor(3);
						String scroll = "(//a[@class='accordion-toggle'])[2]";
						GenericMethods.scrollToElement(driver, scroll);
						clickElement(driver, test, OCR_VisitorInfo_DplStatusRed, "Click DPL flag");
						Wait.waitfor(3);
						click_Override();
						Wait.waitfor(2);
						Select_DispositionReason();
						Wait.waitfor(3);
						click_DisptnReasonMatxSave();
						Wait.waitfor(3);
						test.log(LogStatus.PASS, "Change the DPL Status from Red to Green");
					}
				} else {
					isDisplayed(driver, OCR_VisitorInfo_DplStatusGreen);
					test.log(LogStatus.PASS, "DPL Status is Green");
				}
			} else {
				test.log(LogStatus.FAIL, "DPl Flag is missing");
				testFailSshot(driver, test);
			}
		} catch (Exception e) {
			e.printStackTrace();
			clickElement(driver, test, OCR_VisitorInfo_DRMclose, "click on cancle");
			test.log(LogStatus.FAIL, "Click on cancle");
		}
	}

	// Clicking on check In Button
	public void click_CheckIn() throws InterruptedException {
		if (isDisplayed(driver, OCR_VisitorInfo_CheckIn)) {
			//scrollToElement(driver, OCR_VisitorInfo_CheckIn);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_VisitorInfo_CheckIn, "Click on Check In Button");
		} else {
			test.log(LogStatus.FAIL, "Check In Button is not Present");
		}
	}

	// Capture the identifying document error message
	public void idocErrorDisplayed() {
		try {
			if (isDisplayed(driver, OCR_VisitInfo_IDoc_ErrorV)) {
				test.log(LogStatus.FAIL, "One Identifying Document is required. error message is Displayed");
				testFailSshot(driver, test);
			}
		} catch (Exception e) {
			test.log(LogStatus.PASS, "One Identifying Document is required. error message is not Displayed");
		}
	}

	// select the Disclaimer checkbox
	public void disclaimerDetails() {
		try {
			isSelected(driver, OCR_VisitorInfo_DisclaimerDetails);
			test.log(LogStatus.PASS, "Disclaimer Details is selected ");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Disclaimer Details is not selected ");
		}
	}

	// Clicking on Print Badge
	public void click_PrintBadge() throws IOException, InterruptedException, Exception {
		String str = driver.toString();
		if (str.contains("internet")) {
			Wait.wait(driver, OCR_VisitorInfo_PrintBadge);
			new Actions(driver).moveToElement(driver.findElement(By.xpath(OCR_VisitorInfo_PrintBadge))).build()
					.perform();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Wait.waitfor(3);
			Runtime.getRuntime().exec("D:\\AutoIT\\IESave.exe");
			Wait.waitfor(45);
			test.log(LogStatus.PASS, "Click on Print Badge");
		} else {
			Wait.wait(driver, OCR_VisitorInfo_PrintBadge);
			driver.findElement(By.xpath(OCR_VisitorInfo_PrintBadge)).click();
			Wait.waitfor(2);
			Runtime.getRuntime().exec("D:\\AutoIT\\downloadchrome.exe");
			Wait.waitfor(5);
			test.log(LogStatus.PASS, "Click on Print Badge");
		}
	}

	// Get text of visit Start time
	public String get_StartTime() {
		return getSelectFirstText(driver, test, OCR_VisitorInfo_StartTime, "Selected text of Start Time");
	}

	// Get text of visit End Time
	public String get_endTime() {
		return getSelectFirstText(driver, test, OCR_VisitorInfo_EndTime, "Selected text of End Time");
	}

	// Clicking on Organization name in the Visit Details Tab
	public void click_OrgName(String OrgName) {
		String OrgnztnName = "//a[contains(text(),'" + OrgName + "')]";
		clickElement(driver, test, OrgnztnName, "click on Org Name :" + OrgName);
	}

	/*
	 * ****************** Validations in Visit Information page
	 * *****************************
	 */

	// Validating All Days Access checkbox is selected or not
	public void validate_AllDaysAccess() {
		try {
			isSelected(driver, OCR_VisitorInfo_AllDayAccess);
			test.log(LogStatus.PASS, "All Days Access checkbox is selected ");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "All Days Access checkbox is not selected ");
			testFailSshot(driver, test);
		}
	}

	// validating add host, add Organizations is created or not
	public void validating_AddHostAndAddOrgCreated() throws InterruptedException {
		try {
			if (isDisplayed(driver, "//span[@class='host-data ']")) {
				test.log(LogStatus.PASS, "Add Host is Added Successfully");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Add Host Edit mode is not displayed under add host button ");
			testFailSshot(driver, test);
		}
		try {
			if (isDisplayed(driver, "//div[@id='gbox_gridOrg']")) {
				test.log(LogStatus.PASS, "Add Organizations is Added Successfully");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Add Organizations Edit mode is not displayed under Add Organizations button ");
			testFailSshot(driver, test);
		}
	}

	// validations site and building on clicking on AddHost Button
	public void validations_AddHostBtn() {
		try {
			if (isDisplayed(driver, OCR_VisitorInfo_Error1)) {
				if (isDisplayed(driver, "//li[contains(text(),'Host is required.')]")) {
					test.log(LogStatus.PASS, "Host is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Building Name is required.')]")) {
					test.log(LogStatus.PASS, "Building Name is required");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed by clicking on save button");
			testFailSshot(driver, test);
		}
	}

	// Validating Add Host
	public void validating_AddHostSave() throws InterruptedException {
		try {
			if (isDisplayed(driver, OCR_VisitorInfo_Error2)) {
				if (isDisplayed(driver, "//li[contains(text(),'Please Enter Name of Host')]")) {
					test.log(LogStatus.PASS, "Please Enter Name of Host");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please Enter Email of Host')]")) {
					test.log(LogStatus.PASS, "Please Enter Email of Host");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Add Host ");
			testFailSshot(driver, test);
		}
	}

	// Validating invalid Email.
	public void validating_Email() throws InterruptedException {
		try {
			if (isDisplayed(driver, OCR_VisitorInfo_Error2)) {
				if (isDisplayed(driver, "//li[contains(text(),'Invalid  Email Address')]")) {
					test.log(LogStatus.PASS, "Invalid Email Address");
				}
				clickElement(driver, test, OCR_VisitorInfo_HostCancle, "click on cancle");
				Wait.waitfor(3);
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Invalid  Email Address");
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VisitorInfo_HostCancle, "click on cancle");
		}
	}

	// Validating send Email Button
	public void validating_SendConfirmationBtn() throws InterruptedException {
		try {
			Wait.fluwait(driver, OCR_VisitorInfo_Error1);
			if (isDisplayed(driver, OCR_VisitorInfo_Error1)) {
				if (isDisplayed(driver, "//li[contains(text(),'Please save the information before send Invite ')]")) {
					test.log(LogStatus.PASS, "Please save the information before send Invite ");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Send Email Confirmation");
			testFailSshot(driver, test);
		}
	}

	// Validating Save button
	public void validating_SaveBtn() throws InterruptedException {
		try {
			Wait.fluwait(driver, OCR_VisitorInfo_Error1);
			if (isDisplayed(driver, OCR_VisitorInfo_Error1)) {
				if (isDisplayed(driver, "//li[contains(text(),'Host is required.')]")) {
					test.log(LogStatus.PASS, "Host is required. ");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Save button");
			testFailSshot(driver, test);
		}
	}

	// Validating Save and Return button
	public void validating_SaveAndReturnBtn() throws InterruptedException {
		try {
			Wait.fluwait(driver, OCR_VisitorInfo_Error1);
			if (isDisplayed(driver, OCR_VisitorInfo_Error1)) {
				if (isDisplayed(driver, "//li[contains(text(),'Host is required.')]")) {
					test.log(LogStatus.PASS, "Host is required. ");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed: Save and Return button");
			testFailSshot(driver, test);
		}
	}
	
	// validating the Request status final
		public void get_RequestStatusFinal() {
			Wait.wait(driver, OCR_VisitorInfo_Status);
			String Actualtext = getAttribute(driver, test, OCR_VisitorInfo_Status, "innerText", "Get the Status : ");
			if (Actualtext.equalsIgnoreCase("Approved")) {
				test.log(LogStatus.PASS, "Request status : " + Actualtext);
			} else {
				test.log(LogStatus.FAIL, "Request status : " + Actualtext);
			}
		}
		
		// validating the Visitor name from excel
				public void validate_VisitorName() {
					scrollToBottom(driver);
         	    	Wait.waitfor(2);
					Wait.wait(driver, OCR_VisitorInfo_VisitorName);
					String Actualtext = getAttribute(driver, test, OCR_VisitorInfo_VisitorName, "innerText", "Get the Visitor Name : ");
					if (Actualtext.equalsIgnoreCase("Devanand b Metangale")) {
						test.log(LogStatus.PASS, "Visitor Name : " + Actualtext);
					} else {
						test.log(LogStatus.FAIL, "Visitor Name : " + Actualtext);
					}
				}
	// validating the Request status
	public String get_RequestStatusAfterAddingVisitor() {
		scrollToTop(driver);
		Wait.wait(driver, OCR_VisitorInfo_Status);
		return  getAttribute(driver, test, OCR_VisitorInfo_Status, "innerText", "Get the Status : ");
	
		
	}	
	
	// validating the Visitor Workflow Type
		public String get_VisitorWorkflowType() {
			scrollToTop(driver);
			Wait.wait(driver, OCR_VisitInfo_VisitorWorkflowType);
			return  getAttribute(driver, test, OCR_VisitInfo_VisitorWorkflowType, "innerText", "Get the Visitor WorkFlow Type : ");

		}	
		// validating the Visitor Workflow Type as foreign
		public void validate_Foreign() {
			
				try {
					if(isDisplayed(driver, OCR_VisitInfo_VisitorWorkflowType)) {
						test.log(LogStatus.PASS, "Visitor WorkFlow Type is : Foreign");
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Visitor WorkFlow Type is : Domestic");
				
				
			} 
		}
		// validating the Visitor Workflow Type Domestic
		public void validate_Domestic() {
			
			try {
				if(isDisplayed(driver, OCR_VisitInfo_VisitorWorkflowType)) {
					test.log(LogStatus.PASS, "Visitor WorkFlow Type is : Domestic");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Visitor WorkFlow Type is : foreign");
			
		} 
	}

	
	// Validating Print Badge Button
	public void PrintBadge() {
		if (isDisplayed(driver, OCR_VisitorInfo_PrintBadge)) {
			test.log(LogStatus.PASS, "Click on Print Badge is Displayed");
		}
	}

	// Validating Available block list in visitor Information page.
	public void validating_AvailBlklist(String CheckAvailBlkList) throws InterruptedException {
		try {
			String availBlklist = "label[contains(text(),'" + CheckAvailBlkList.trim() + "')]"
					+ "/../../../following-sibling::div";
			if (isDisplayed(driver, availBlklist)) {
				test.log(LogStatus.FAIL, CheckAvailBlkList + " is Displayed");
				testFailSshot(driver, test);
			}
		} catch (Exception e) {
			test.log(LogStatus.PASS, CheckAvailBlkList + " is not Displayed");
		}
	}

	// Validating Available Field list in visitor Information page.
	public void validAvailFildLabel(String CheckAvailFieldList) {
		validating_AvailFieldlist(driver, test, CheckAvailFieldList);
	}

	// Validating Available Field list with check box label in visitor Information
	// page.
	public void validAvailFildLabelWithcheckBox(String CheckAvailFieldList) {
		validating_AvailFieldlistWithcheckBox(driver, test, CheckAvailFieldList);
	}

	// Validating Acknowledgement and Documentation for policy Document and
	// Accepting the Document.
	public void validAckwAndDoc(String DocmentName) {
		ArrayList<String> DocName = stringtoken(DocmentName);
		for (int i = 0; i < DocName.size(); i++) {
			Wait.waitfor(3);
			Wait.wait(driver, OCR_VisitorInfo_SiteArrow);
			GenericMethods.scrollToElement(driver, OCR_VisitorInfo_SiteArrow);
			isDisplayed(driver, OCR_VisitorInfo_AcknwlegmntAndDocTable);
			test.log(LogStatus.PASS, "Acknowledgement and Documentation Table is Displayed");
			String locPDF = "//td[contains(text(),'" + DocName.get(i).trim() + "')]/following-sibling::td/a";
			Wait.waitfor(5);
			clickElement(driver, test, locPDF, "click on PDF Document : " + DocName.get(i));
			Wait.waitfor(3);
			clickElement(driver, test, OCR_VisitorInfo_AcknwlegmntAndDocAgreeBtn, "click on Agree button ");
			String locAccepted = "//td[contains(text(),'" + DocName.get(i).trim()
					+ "')]/following-sibling::td[2]/input";
			isSelected(driver, locAccepted);
			test.log(LogStatus.PASS, DocName.get(i) + " Check box is Selected in Accepted Columns");
		}
	}

	// validating Dpl status flag
	public void ValidateDPLStatus() throws Exception {
		try {
			isDisplayed(driver, OCR_VisitorInfo_DplStatusGreen);
			test.log(LogStatus.PASS, "Flag is Displayed");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Flag colour is changed");
			testFailSshot(driver, test);
		}
	}

	// Clicking on Organization Dpl Flag
	public void click_VisitorInfoDplStatusRed() throws InterruptedException {
		Wait.waitfor(4);
		String scroll = "(//a[@class='accordion-toggle'])[2]";
		GenericMethods.scrollToElement(driver, scroll);
		clickElement(driver, test, OCR_VisitorInfo_DplStatusRed,
				"Clicking on Organization Dpl Flag in rapid visit information ");
		Wait.waitfor(3);

	}

	// Validating View All OCR Hits in view detail hits popup
	public void validating_ViewAllOCRHits() throws InterruptedException {
		try {
			if (isDisplayed(driver, "//label[contains(text(),'View All OCR Hits')]")) {
				test.log(LogStatus.PASS, "View All OCR Hits label is displayed in view detail hits popup ");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "View All OCR Hits label is not displayed in view detail hits popup ");
		}
	}

	// Validating Acknowledgement and Documentation kiosk request policy Document in
	// Rapid request visit information page.
	public void kReqvalidAckwAndDocinrapid(String AcknowledgementAndDoc) {
		ArrayList<String> DocName = stringtoken(AcknowledgementAndDoc);
		for (int i = 0; i < DocName.size(); i++) {
			Wait.waitfor(3);
			Wait.wait(driver, OCR_VisitorInfo_SiteArrow);
			GenericMethods.scrollToElement(driver, OCR_VisitorInfo_SiteArrow);
			if (driver.findElement(By.xpath(OCR_VisitorInfo_AcknwlegmntAndDocTable)).isDisplayed()) {
				test.log(LogStatus.PASS,
						"Acknowledgement and Documentation Table is Displayed in Rapid Request visit information screen");
			}
			Wait.waitfor(3);
			String locAccepted = "//td[contains(text(),'" + DocName.get(i).trim()
					+ "')]/following-sibling::td[2]/input";
			if (isSelected(driver, locAccepted)) {
				test.log(LogStatus.PASS, DocName.get(i) + " Check box is already Selected in Accepted Columns");
			}
		}
	}

	// Clicking on close button in rapid visit information page
	public void click_RapidClose() throws InterruptedException {
		clickElement(driver, test, OCR_VisitorInfo_Close, "Clicking on Add Host");
	}

	// Alert of Request ID created successfully
	public void alertReqIDCreated(String RequestID) {
		String alert = "//h4[contains(text(),'Request ID " + RequestID + " created successfully!')]";

		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO, "Request ID " + RequestID + " created successfully!");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Alert message is not displayed by clicking on Save and Return button");
			testFailSshot(driver, test);
		}
	}

	// Click on Notify WLS reviewer
	public void checkNotifyWLSReview() {
		clickElement(driver, test, OCR_VisitInfo_NotifyWLSReviewer, "Click on Notify Reviewer");
		clickElement(driver, test, OCR_VisitInfo_EmailReviewer, "Click on Email Reviewer");
		String alert = "//h4[contains(text(),'You successfully submitted the request for review.')]";
		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO, "You successfully submitted the request for review.");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Alert message is not displayed by clicking on Notify Reviewer button");
			testFailSshot(driver, test);
		}}

		// Click on Notify FV reviewer
		public void checkNotifyFVReview() {
			clickElement(driver, test, OCR_VisitInfo_NotifyFVReviewer, "Click on Notify FV Reviewer");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_VisitInfo_EmailReviewer, "Click on Email FV Reviewer");
		//	String alert = "//h4[contains(text(),'You successfully submitted the request for review.')]";
			/*try {
				Wait.fluwait(driver, alert);
				if (isDisplayed(driver, alert)) {
					test.log(LogStatus.INFO, "You successfully submitted the request for review.");
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Alert message is not displayed by clicking on Notify Reviewer button");
				testFailSshot(driver, test);
			}
*/
	}

	// Validating the Created BY and Updated By
	public void validateCreatedByAndUpdatedBy() {
		String createdBy = getText(driver, test, "//label[contains(text(),'Created By')]/../label[2]",
				"Get the Created By : ");
		String updatedBy = getText(driver, test, "//label[contains(text(),'Updated By')]/../label[2]",
				"Get the Updated By : ");
		if (createdBy.equals(updatedBy)) {
			test.log(LogStatus.INFO, "Created By and Updated By Values are Same");
		} else {
			test.log(LogStatus.FAIL, "Created By and Updated By Values are not Same");
			testFailSshot(driver, test);
		}
	}

}
