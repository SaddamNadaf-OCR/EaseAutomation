package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAdhocApplicationReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
		public static final String NRC_Report_Search ="//button[contains(text(),'Search')]";
		public static final String NRC_Report_Reset ="//button[contains(text(),'Reset')]";
		public static final String NRC_Report_SBUCode ="//select[@name='dosGeneralInfo.sbuCode']";
		public static final String NRC_Report_TransactionId = "(//a[contains(text(),'Transaction Id')])";
		public static final String NRC_Report_TransactionIdPopup = "//input[@name='dosGeneralInfoDTO.transactionId']";
		public static final String NRC_Report_SearchPopup = "//button[@name='Search']";
		public static final String NRC_Report_SelectPopup = "(//button[contains(text(),'Select')])[1]";
		public static final String NRC_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
		public static final String NRC_ReportTransactionIdTextbox = "//input[@name='dosGeneralInfo.transactionId']";
		public static final String NRC_Report_status ="//select[@name='status']";
		public static final String NRC_Report_TypeOfAction ="//select[@name='typeOfAction']";
		public static final String NRC_Report_ContractNo ="(//a[contains(text(),'Contract No')])";
		public static final String NRC_Report_ContractNoPopup = "//input[@name='contract.contractNo']";
		public static final String NRC_Report_ContractNoTextBox = "//input[@name='dosGeneralInfo.contractNo']";
		public static final String NRC_Report_POAName = "(//a[contains(text(),'POA Name')])";
		public static final String NRC_Report_userFirstname = "//input[@name='userProfile.userFirstname']";
		public static final String NRC_Report_poaNameTextbox = "//input[@name='dosGeneralInfo.poaName']";
		public static final String NRC_Report_Program = "(//a[contains(text(),'Program')])[2]";
		public static final String NRC_Report_ProgramCode = "//input[@name='programTab.programCode']";
		public static final String NRC_Report_ProgramTextbox = "//textarea[@name='dosGeneralInfo.programTab']";
		public static final String NRC_Report_Segment = "(//a[contains(text(),'Segment')])[2]";
		public static final String NRC_Report_SegmentTextBox = "//textarea[@name='dosGeneralInfo.segmentCode']";
		public static final String NRC_Report_Site = "(//a[contains(text(),'Site')])[2]";
		public static final String NRC_Report_SiteID = "//input[@name='dosSite.siteId']";
		public static final String NRC_Report_SiteTextbox = "//textarea[@name='dosGeneralInfo.site']";
		public static final String NRC_Report_Department = "(//a[contains(text(),'Department')])[2]";
		public static final String NRC_Report_DepartmentTextbox = "//textarea[@name='dosGeneralInfo.department']";
		public static final String NRC_Report_Requestor = "(//a[contains(text(),'Requestor')])";
		public static final String NRC_Report_RequesterTextbox = "//input[@name='dosGeneralInfo.licenseRequestor']";
		public static final String NRC_Report_Reviewer = "(//a[contains(text(),'Reviewer')])[2]";
		public static final String NRC_Report_ReviewerTextbox = "//input[@name='dosGeneralInfo.reviewer']";
		public static final String NRC_Report_Notes = "//textarea[@name='dosSecureNotes.secureNotes']";
		public static final String NRC_Report_Consignee = "(//a[contains(text(),'Consignee')])[3]";
		public static final String NRC_Report_consigneeIdPopup ="//input[@name='consignee.consigneeId']";
		public static final String NRC_Report_ConsigneeTextBox = "//input[@name='consigneeName']";
		public static final String NRC_Report_fromDateInitiated = "//input[@name='fromDateInitiated']";
		public static final String NRC_Report_toDateInitiated = "//input[@name='toDateInitiated']";
		public static final String NRC_Report_fromDateSubmitted = "//input[@name='fromDateSubmitted']";
		public static final String NRC_Report_toDateSubmitted = "//input[@name='toDateSubmitted']";
		public static final String NRC_Report_fromIssueDate = "//input[@name='fromIssueDate']";
		public static final String NRC_Report_toIssueDate = "//input[@name='toIssueDate']";
		public static final String NRC_Report_fromExpiryDate = "//input[@name='fromExpiryDate']";
		public static final String NRC_Report_toExpiryDate = "//input[@name='toExpiryDate']";
		public static final String NRC_Report_sortBy = "//select[@name='sortBy']";
		public static final String NRC_Report_direction = "//select[@name='direction']";
		
	
	//..................................Constructors..................................//
	public SearchAdhocApplicationReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, NRC_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, NRC_Report_Reset, "Clicking on Reset Button :");
	}
	
	//..................................Search By Parameters....................................//
	public void searchbyParameters(String SBUCode, String TransactionID, String Status, String TypeOfAction, String ContractNo, 
			String POA_Name, String Program, String Segment, String Site, String Department, String Requester, String Reviewer, 
			String Notes, String Consignee, String InitiatedDateFrom, String InitiatedDateTo, String SubmitedDateFrom, 
			String SubmitedDateTo, String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo, 
			String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, NRC_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		if(TransactionID.length() > 0) {
			clickElement(driver, test, NRC_Report_TransactionId, "Clicking on transaction ID :");
			try {
				typeText(driver, test, NRC_Report_TransactionIdPopup, "Entering Transaction ID :", TransactionID);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TransactionID+"')]", "Selecting Transaction ID :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_ReportTransactionIdTextbox, "Entering Transaction ID :", TransactionID);
		}
		selectByVisibleText(driver, test, NRC_Report_status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, NRC_Report_TypeOfAction, "Selecting Type Of Action :", TypeOfAction);
		if(ContractNo.length() > 0) {
			clickElement(driver, test, NRC_Report_ContractNo, "Clicking on Contract No :");
			try {
				typeText(driver, test, NRC_Report_ContractNoPopup, "Entering Contract No :", ContractNo);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ContractNo+"')]", "Selecting Transaction ID :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_ContractNoTextBox, "Entering Contract No :", ContractNo);
		}
		if(POA_Name.length() > 0) {
			clickElement(driver, test, NRC_Report_POAName, "Clicking on POA_Name :");
			try {
				typeText(driver, test, NRC_Report_userFirstname, "Entering POA_Name :", POA_Name);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+POA_Name+"')]", "Selecting POA_Name :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_poaNameTextbox, "Entering POA_Name :", POA_Name);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, NRC_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, NRC_Report_ProgramCode, "Entering Program :", Program);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_ProgramTextbox, "Entering Program :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, NRC_Report_Segment, "Clicking on Program :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_SegmentTextBox, "Entering Segment :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, NRC_Report_Site, "Clicking on Site :");
			try {
				typeText(driver, test, NRC_Report_SiteID, "Entering Site :", Site);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_SiteTextbox, "Entering Site :", Site);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, NRC_Report_Department, "Clicking on Department :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Department+"')]", "Selecting Department :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_DepartmentTextbox, "Entering Department :", Department);
		}
		if(Requester.length() > 0) {
			clickElement(driver, test, NRC_Report_Requestor, "Clicking on Requester :");
			try {
				typeText(driver, test, NRC_Report_userFirstname, "Entering Requester :", Requester);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Requester+"')]", "Selecting Requester :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_RequesterTextbox, "Entering Requester :", Requester);
		}
		if(Reviewer.length() > 0) {
			clickElement(driver, test, NRC_Report_Reviewer, "Clicking on Reviewer :");
			try {
				typeText(driver, test, NRC_Report_userFirstname, "Entering Reviewer :", Reviewer);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Reviewer+"')]", "Selecting Reviewer :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_ReviewerTextbox, "Entering Reviewer :", Reviewer);
		}
		typeText(driver, test, NRC_Report_Notes, "Entering Notes :", Notes);
		if(Consignee.length() > 0) {
			clickElement(driver, test, NRC_Report_Consignee, "Clicking on Consignee :");
			try {
				typeText(driver, test, NRC_Report_consigneeIdPopup, "Entering Consignee :", Consignee);
				clickElement(driver, test, NRC_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Consignee+"')]", "Selecting Consignee :");
				clickElement(driver, test, NRC_Report_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, NRC_Report_ClosePopup, "Clicking on Close Popup Icon :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, NRC_Report_ConsigneeTextBox, "Entering Consignee :", Consignee);
		}
		if(InitiatedDateFrom.length() > 0) {
			clickElement(driver, test, NRC_Report_fromDateInitiated, "Clicking on Date Initiated From :");
			dateOfMonthName(driver, test, "Selecting Date Initiated From :", InitiatedDateFrom);
		}
		if(InitiatedDateTo.length() > 0) {
			clickElement(driver, test, NRC_Report_toDateInitiated, "Clicking on Date Initiated To :");
			dateOfMonthName(driver, test, "Selecting Date Initiated To :", InitiatedDateTo);
		}
		if(SubmitedDateFrom.length() > 0) {
			clickElement(driver, test, NRC_Report_fromDateSubmitted, "Clicking on Date Submited From :");
			dateOfMonthName(driver, test, "Selecting Date Submitted From :", SubmitedDateFrom);
		}
		if(SubmitedDateTo.length() > 0) {
			clickElement(driver, test, NRC_Report_toDateSubmitted, "Clicking on Submited Date To :");
			dateOfMonthName(driver, test, "Selecting Submited Date To :", SubmitedDateTo);
		}
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, NRC_Report_fromIssueDate, "Clicking on Issue Date From :");
			dateOfMonthName(driver, test, "Selecting Issue Date From :", IssueDateFrom);
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, NRC_Report_toIssueDate, "Clicking on Issue Date To :");
			dateOfMonthName(driver, test, "Selecting Issue Date To :", IssueDateTo);
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, NRC_Report_fromExpiryDate, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, NRC_Report_toExpiryDate, "Clicking on Expiry Date To :");
			dateOfMonthName(driver, test, "Selecting expiry Date To :", ExpiryDateTo);
		}
		selectByVisibleText(driver, test, NRC_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, NRC_Report_direction, "Selecting Dirextion :", Direction);
	}

}
