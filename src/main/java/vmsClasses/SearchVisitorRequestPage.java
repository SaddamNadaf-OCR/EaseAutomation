
package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Search_Features = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_Search_VisitorRequestForms = "(//a[text()='Visitor Request Forms'])[1]";
	public static final String OCR_Search_StandardRequest = "//a[text()='Standard Request']";
	public static final String OCR_Search_RapidRequest = "//a[contains(text(),'Rapid Request')]";
	public static final String OCR_Search_FrontDeskManagement = "//a[contains(text(),'Front Desk Management')]";
	public static final String OCR_Search_Tools = "//ul[@class='nav navbar-nav navbar-right']/li[4]/a";
	public static final String OCR_Search_VMCT = "//a[contains(text(),'VM Configuration Tool')]";
	public static final String OCR_Search_SBU = "//select[@name='visitorGeneralInfoValue.sbuCode']";
	public static final String OCR_Search_VisitorSBU = "//select[@id='resultVisitorGeneralInfo_visitorGeneralInfoValue_sbuCode']";
	public static final String OCR_Search_Site = "//div[@class='ms-trigger']";
	public static final String OCR_Search_VFName = "//input[@id='resultVisitorGeneralInfo_visitorPersonVal_firstName']";
	public static final String OCR_Search_VLName = "//input[@id='resultVisitorGeneralInfo_visitorPersonVal_lastName']";
	public static final String OCR_Search_Status = "//select[@id='resultVisitorGeneralInfo_visitorGeneralInfoValue_requestStatus']";
	public static final String OCR_Search_VisitorFor = "//select[@name='allVisitors']";
	public static final String OCR_Search_Org = "//input[@id='resultVisitorGeneralInfo_visitorCompanyValue_companyName']";
	public static final String OCR_Search_VFromDate = "//input[@id='searchVisitDateFrom_startDate']";
	public static final String OCR_SearchVisitDateFrom_EndDate = "//input[@id='searchVisitDateTo_endDate']";
	public static final String OCR_Search_VToDate = "//input[@id='searchVisitDateToFrom_startDate']";
	public static final String OCR_SearchVisitDateToTo_EndDate = "//input[@id='searchVisitDateToTo_endDate']";
	public static final String OCR_SearchVisitor_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_Search_ReqFromDate = "//input[@id='searchRequestDateFrom_startDate']";
	public static final String OCR_Search_ReqToDate = "//input[@id='searchRequestDateTo_endDate']";
	public static final String OCR_Search_ReviewFromDate = "//input[@id='searchReviewdateFrom_startDate']";
	public static final String OCR_Search_ReviewToDate = "//input[@id='searchReviewdateTo_endDate']";
	public static final String OCR_Search_SButton = "//button[contains(text(),'Search')]";
	public static final String OCR_Search_AddNewStandardRequest = "//button[contains(text(),'Add New Standard Request')]";
	public static final String OCR_Search_FirstRecord = "//table[@id='grid']//tr[2]/td[2]/a";
	public static final String OCR_Search_Reports = "//ul[@class='nav navbar-nav']/li[4]/a";
	public static final String OCR_Search_Reports_VisitorRegistration = "(//li//a[contains(text(),'Visitor Registration')])[1]";
	public static final String OCR_Search_Reports_VisitorLogReport = "//a[contains(text(),'Visitor Log')]";
	public static final String OCR_Search_Files = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_Search_Files_VisitorRTemplate = "(//li//a[contains(text(),'Visitor Request Template')])";
	public static final String OCR_Search_Files_AddVisitorTemplate = "//button[@name='Add']";
	public static final String OCR_Search_VisitorID = "//input[@id='resultVisitorGeneralInfo_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_Search_ReviewerQueue = "//a[contains(text(),'Reviewer Queue')]";
	public static final String OCR_Search_AdhocReport ="(//a[contains(text(),'Adhoc Report')])";
	public static final String OCR_Search_DebriefIncident ="(//a[contains(text(),'Debrief Incidents Report')])";
	
	
	/* ******************** Constructor ***************************** */

	public SearchVisitorRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to features
	public void moveTo_Features() {
		mouseOver(driver, test, OCR_Search_Features, "Mouse over on Features");
	}

	// Move to Reports
	public void moveTo_Reports() {
		mouseOver(driver, test, OCR_Search_Reports, "Mouse over on Reports");
	}
	// Click on Adhoc Report
	public void click_AdhocReport() {
		clickElement(driver, test, OCR_Search_AdhocReport, "click on Adhoc Reports");
	}
	// Click on Debrief Incidents Report
		public void click_DebriefIncidentsReport() {
			clickElement(driver, test, OCR_Search_DebriefIncident, "click on Debrief Incidents Report");
		}
	// Click on Work Queue
	public void click_WorkQueue() {
		clickElement(driver, test, OCR_Search_ReviewerQueue, "Click on Work Queue");
	}

	// click on visitor registration under reports
	public void click_ReportsVReg() {
		clickElement(driver, test, OCR_Search_Reports_VisitorRegistration, "Select Visitor Registration under reports");
	}

	// click on Visitor log report
	public void click_VisitorLogReport() {
		clickElement(driver, test, OCR_Search_Reports_VisitorLogReport, "Select Visitor log report under reports");
	}

	// Move to Files
	public void moveTo_Files() {
		mouseOver(driver, test, OCR_Search_Files, "Mouse over on Files");
	}

	// Click on Visitor request template under files
	public void click_FilesVReqTemplate() {
		clickElement(driver, test, OCR_Search_Files_VisitorRTemplate, "Select Visitor request template under files");
	}

	// Click on Add template
	public void click_AddVReqTemplate() {
		clickElement(driver, test, OCR_Search_Files_AddVisitorTemplate, "Click on Add template");
	}

	// Move to Tools
	public void moveTo_Tools() {
		mouseOver(driver, test, OCR_Search_Tools, "Mouse over on Tools");
	}

	// Clicking on Visitor front Desk Management
	public void click_VisitorFrontDesk() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Search_FrontDeskManagement, "Clicking on Visitor Front Desk Management");
	}

	// clicking on visitor requests
	public void click_VisitorRequests() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Search_VisitorRequestForms, "Clicking on Visitor Request Forms");
	}

	// clicking on Rapid Registration
	public void click_RapidRegistaration() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Search_RapidRequest, "Clicking on Rapid Registaration");
	}

	// clicking on visitor requests
	public void click_VisitorRequest() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Search_StandardRequest, "Clicking on Standard Request");
	}

	// clicking on VMCT
	public void click_VMCT() {
		String scroll = "//a[contains(text(),'Watch List Screening Defaults')]";
		GenericMethods.scrollToElement(driver, scroll);
		clickElement(driver, test, OCR_Search_VMCT, "Clicking on VMCT");
	}

	// clicking on Add New Visitor Request
	public void click_AddNewVisitorRequest() throws InterruptedException {
		Wait.waitfor(5);
		Wait.fluwait(driver, OCR_Search_AddNewStandardRequest);
		clickElement(driver, test, OCR_Search_AddNewStandardRequest, "Clicking on Add New Visitor Request Button");
	}

	// Search Standard Req visitor Details as per the Date Send From Excel and click
	// on search button.
	public void searchVisitDetails(String SBU, String SBUCount, String Site, String VisitorFName, String VisitorLName,
			String Status, String VisitorFor, String Org, String VFromDate, String VToDate, String ReqFromDate,
			String ReqToDate, String ReviewFromDate, String ReviewToDate) {

		//sortDropDown(driver, test, OCR_Search_SBU, "-ALL-");
		if (SBUCount.length() > 0) {
			int count = dropDownCount(driver, OCR_Search_SBU);
			if (count == Integer.parseInt(SBUCount)) {
				test.log(LogStatus.PASS, "No of options are equal to SBUCount : " + SBUCount);
			} else {
				test.log(LogStatus.FAIL, "No of options are not equal to SBUCount : " + SBUCount);
			}
		}
		selectByVisibleText(driver, test, OCR_Search_SBU, "Selected SBU CODE : ", SBU);
		selectByVisibleText(driver, test, OCR_Search_Status, "Select Status : ", Status);
		if (Site.length() > 0) {
			clickElement(driver, test, OCR_Search_Site, "click on Site down arrow");
			String site = "//div[contains(text(),'" + Site + "')]";
			clickElement(driver, test, site, "click on Required Site : " + Site);
		}
		typeText(driver, test, OCR_Search_VFName, "Enter Visitor First name", VisitorFName);
		typeText(driver, test, OCR_Search_VLName, "Enter vistor Last name", VisitorLName);
		selectByVisibleText(driver, test, OCR_Search_VisitorFor, "Select VisitorFor : ", VisitorFor);
		if (VFromDate.length() > 0) {
			clickElement(driver, test, OCR_Search_VFromDate, "Click on VFrom Date");
			date(driver, test, "Selecting the VFrom date : ", VFromDate);
		}
		if (VToDate.length() > 0) {
			clickElement(driver, test, OCR_Search_VToDate, "Click on VTo Date");
			date(driver, test, "Selecting the VTo date : ", VToDate);
		}
		if (ReqFromDate.length() > 0) {
			clickElement(driver, test, OCR_Search_ReqFromDate, "Click on Request From Date");
			date(driver, test, "Selecting the Request From Date : ", ReqFromDate);
		}
		if (ReqToDate.length() > 0) {
			clickElement(driver, test, OCR_Search_ReqToDate, "Click on Request To Date");
			date(driver, test, "Selecting the Request To Date : ", ReqToDate);
		}
		if (ReviewFromDate.length() > 0) {
			clickElement(driver, test, OCR_Search_ReviewFromDate, "Click on Review From Date");
			date(driver, test, "Selecting the Review From Date : ", ReviewFromDate);
		}
		if (ReviewToDate.length() > 0) {
			clickElement(driver, test, OCR_Search_ReviewToDate, "Click on Review To Date");
			date(driver, test, "Selecting the Review To Date : ", ReviewToDate);
		}
		clickElement(driver, test, OCR_Search_SButton, "clicking on search button in SVR");
	}

	// Select Visit SearchVisitDateFrom StartDate and SearchVisitDateFrom EndDate in
	// Search Visitor Request screen
	public void select_SVisitDateFromStartDate(String visitDateFrom) {
		clickElement(driver, test, OCR_Search_VFromDate, "Clicking on SearchVisitDateFrom StartDate");
		date(driver, test, "Selecing the visit date : ", visitDateFrom);
	}

	public void select_SVisitDateFromEndDate(String visitDateFrom) {
		clickElement(driver, test, OCR_SearchVisitDateFrom_EndDate, "Clicking on SearchVisitDateFrom EndDate");
		date(driver, test, "Selecing the visit date : ", visitDateFrom);
	}

	// Select Visit SearchVisitDateTo StartDate and SearchVisitDateTo EndDate in
	// Search Visitor Request screen
	public void select_SVisitDateToStartDate(String visitDateTo) {
		clickElement(driver, test, OCR_Search_VToDate, "Clicking on SearchVisitDateTo StartDate");
		date(driver, test, "Selecing the visit date  To: ", visitDateTo);
	}

	public void select_SVisitDateToEndDate(String visitDateTo) {
		clickElement(driver, test, OCR_SearchVisitDateToTo_EndDate, "Clicking on SearchVisitDateTo EndDate");
		date(driver, test, "Selecing the visit date  To: ", visitDateTo);
	}

	// click on search button in search visitor screen
	public void click_SearchButton() {
		clickElement(driver, test, OCR_Search_SButton, "Select Search button in search visitor screen");
		Wait.waitfor(5);
	}

	// Validating Visit Date To must occur after the Visit Date From message in
	// search visit details screen
	public void validating_StandardVisitDate() throws Exception {
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error!')]")) {
				test.log(LogStatus.PASS, "Invalid Visit Date From and To range for the selected Visit Date");
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed for the selected Visit Date");
			testFailSshot(driver, test);
		}
	}

	// click on Reset button in search visitor screen
	public void click_SearchvisitorReset() {
		clickElement(driver, test, OCR_SearchVisitor_Reset, "Select Reset button in search visitor screen");
		Wait.waitfor(5);
	}

	// Select Request Date From
	public void select_SRequestDateFrom(String ReqFromDate) {
		clickElement(driver, test, OCR_Search_ReqFromDate, "Clicking on SearchRequestDateFrom StartDate");
		date(driver, test, "Selecing the visit date  To: ", ReqFromDate);
	}

	// Select Request Date To
	public void select_SRequestDateTo(String ReqToDate) {
		clickElement(driver, test, OCR_Search_ReqToDate, "Clicking on SearchRequestDateTo EndDate");
		date(driver, test, "Selecing the visit date  To: ", ReqToDate);
	}

	// Validating request Date error message in search visit details screen
	public void validating_StandardRequestDate() throws Exception {
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error!')]")) {
				test.log(LogStatus.PASS, "Invalid Request Date range. for the selected Request Date");
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed for the selected request Date");
			testFailSshot(driver, test);
		}
	}

	// Select Review Date From
	public void select_SReviewDateFrom(String ReviewFromDate) {
		clickElement(driver, test, OCR_Search_ReviewFromDate, "Clicking on SearchReviewDateFrom StartDate");
		date(driver, test, "Selecing the visit date  To: ", ReviewFromDate);
	}

	// Select Review Date To
	public void select_SReviewDateTo(String ReviewToDate) {
		clickElement(driver, test, OCR_Search_ReviewToDate, "Clicking on SearchReviewDateTo EndDate");
		date(driver, test, "Selecing the visit date  To: ", ReviewToDate);
	}

	// Validating Review Date error message in search visit details screen
	public void validating_StandardReviewDate() throws Exception {
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error!')]")) {
				test.log(LogStatus.PASS, "Invalid Review Date range. for the selected Review Date");
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error message is not displayed for the selected review Date");
			testFailSshot(driver, test);
		}
	}
	
	//Select Sbu code and Status in search visitor request screen
	public void select_VisitorSBUStatus(String VisitorSBU, String VisitorStatus) throws Exception {
		selectByVisibleText(driver, test, OCR_Search_SBU, "Selecting the SBU : ", VisitorSBU);
		Wait.waitfor(8);
		selectByVisibleText(driver, test, OCR_Search_Status, "Selecting the Status : ", VisitorStatus);
		clickElement(driver, test, OCR_Search_SButton, "Clicking on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Search_FirstRecord, "Clicking on search record");
		
	}
	// Verify visitor request header is displayed or not
	public void VisitorRequestHeader(){	
		try {
			if (isDisplayed(driver, "//h3[@class='page-heading']")) {			
				Wait.waitfor(3);
				test.log(LogStatus.PASS, "Visitor request header is displayed in search result grid ");
			}
				
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Visitor request header is not displayed in search result grid");
		}
	}
	
	public void select_VisitorSbu(String SelectSBU) {
		selectByVisibleText(driver, test, OCR_Search_VisitorSBU, "Selecting the SBU : ", SelectSBU);
		Wait.waitfor(3);
	}
	

	// Search the status and click on Search button
	public void searchthroughstatus(String SBUCode, String Status) {
		selectByVisibleText(driver, test, OCR_Search_SBU, "Selecting the SBU : ", SBUCode);
		selectByVisibleText(driver, test, OCR_Search_Status, "Selecting the Status : ", Status);
		clickElement(driver, test, OCR_Search_SButton, "Clicking on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Search_FirstRecord, "Clicking on search record");
	}

	// select the sbu and click on Search
	public void searchvisitorrequest(String SBUCode) {
		selectByVisibleText(driver, test, OCR_Search_SBU, "Selecting the SBU : ", SBUCode);
		clickElement(driver, test, OCR_Search_SButton, "Clicking on search Button");
	}
	
	//Search through visitor Request ID
	public void searchVisitorID(String VisitorID) {
		typeText(driver, test, OCR_Search_VisitorID, "Enter the Visitor ID : ", VisitorID);
	}
}
