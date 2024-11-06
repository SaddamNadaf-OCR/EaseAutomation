package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchExportRequestDetailsReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String CRS_Report_Search ="//button[contains(text(),'Search')]";
	public static final String CRS_Report_Reset ="//button[contains(text(),'Reset')]";
	public static final String CRS_Report_SBUCode ="//select[@name='exportRequestValue.sbuCode']";
	public static final String CRS_Report_RequestID ="//input[@name='exportRequestValue.expReqId']";
	public static final String CRS_Report_RequesterName = "//input[@name='exportRequestValue.nameOfRequestor']";
	public static final String CRS_Report_Approver = "//a[contains(text(),'Approver')]";
	public static final String CRS_Report_UserFirstName = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Report_SearchPopup = "//button[@name='Search']";
	public static final String CRS_Report_SelectPopup = "(//button[@name='Ok'])[1]";
	public static final String CRS_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String CRS_Reports_Status = "//select[@name='exportRequestValue.status']";
	public static final String CRS_Reports_Determination = "//select[@name='exportRequestValue.disposition']";
	public static final String CRS_Reports_Customer_Consignee = "//a[contains(text(),'Customer/Consignee   :')]";
	public static final String CRS_Reports_Customer_ConsigneeTextbox = "//input[@name='exportConsigneeValue.consigneeName']";
	public static final String CRS_Reports_USParty = "//input[@name='exportSourceMfgValue.sourceMfgName']";
	public static final String CRS_Reports_PartyCountry = "//input[@name='exportConsigneeValue.consigneeCountryName']";
	public static final String CRS_Reports_ExportAuthorizationID = "//input[@name='exportRequestValue.expAuthId']";
	public static final String CRS_Reports_STALetterObtained = "//select[@name='exportConsigneeValue.staLetterObtained']";
	public static final String CRS_Reports_Purpose = "//select[@name='exportRequestValue.licPurpose']";
	public static final String CRS_Reports_RequestDateFrom = "//input[@name='exportDateFrom']";
	public static final String CRS_Reports_RequestDateTo = "//input[@name='exportDateTo']";
	public static final String CRS_Reports_Segment = "//a[contains(text(),' Segment')]";
	public static final String CRS_Reports_SegmentTextbox = "//textarea[@name='exportRequestValue.segment']";
	public static final String CRS_Reports_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String CRS_Reports_SiteTextbox = "//textarea[@name='exportRequestValue.site']";
	public static final String CRS_Reports_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String CRS_Reports_programCode = "//input[@name='programTab.programCode']";
	public static final String CRS_Reports_ProgramTextBox = "//textarea[@name='exportRequestValue.program']";
	public static final String CRS_Reports_Department = "(//a[contains(text(),'Department')])[2]";
	public static final String CRS_Reports_EDepartmentTextbox = "//textarea[@name='exportRequestValue.department']";
	public static final String CRS_Reports_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String CRS_Reports_prodFamilyTextBox = "//textarea[@name='exportRequestValue.prodFamily']";
	public static final String CRS_Reports_ProductDescription = "//input[@name='exportItemValue.description']";
	public static final String CRS_Reports_salesOrderNo = "//input[@name='exportRequestValue.salesOrderNo']";
	public static final String CRS_Reports_purchaseOrderNo = "//input[@name='exportRequestValue.purchaseOrderNo']";
	public static final String CRS_Reports_sortBy = "//select[@name='sortBy']";
	public static final String CRS_Reports_direction = "//select[@name='direction']";
	
	//..................................Constructors..................................//
	public SearchExportRequestDetailsReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, CRS_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, CRS_Report_Reset, "Clicking on Reset Button :");
	}
	
	//....................................Search By Parameters......................................//
	public void searchByParameters(String SBUCode, String RequestID, String RequesterName, String Approver, 
			String Status, String Determination, String Consignee_Customer, String USParty, String PartyCountry, 
			String ExportAuthID, String STALetterObtained, String Purpose, String RequestDateFrom, String RequestDateTo, 
			String Segment, String Site, String Program, String Department, String ProductFamily, String ProductDescription, 
			String SalesOrderNo, String PurchaseOrderNo, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, CRS_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, CRS_Report_RequestID, "Entering Request ID :", RequestID);
		typeText(driver, test, CRS_Report_RequesterName, "Entering Requester Name :", RequesterName);
		if(Approver.length() > 0) {
			clickElement(driver, test, CRS_Report_Approver, "Clicking on Approver :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Approver User First Name :", Approver);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Approver+"')]", "Selecting Approver :"+Approver);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		selectByVisibleText(driver, test, CRS_Reports_Status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, CRS_Reports_Determination, "Selecting Determination :", Determination);
		if(Consignee_Customer.length() > 0) {
			clickElement(driver, test, CRS_Report_Approver, "Clicking on Consignee_Customer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Consignee_Customer Name :", Consignee_Customer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Consignee_Customer+"')]", "Selecting Consignee_Customer :"+Consignee_Customer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_Customer_ConsigneeTextbox, "Entering Customer_Consingee :", Consignee_Customer);
		}
		typeText(driver, test, CRS_Reports_USParty, "Entering US Party :", USParty);
		typeText(driver, test, CRS_Reports_PartyCountry, "Entering Party Country :", PartyCountry);
		typeText(driver, test, CRS_Reports_ExportAuthorizationID, "Entering Export Authorization ID :", ExportAuthID);
		selectByVisibleText(driver, test, CRS_Reports_STALetterObtained, "Selecting STA Letter Obtained :", STALetterObtained);
		selectByVisibleText(driver, test, CRS_Reports_Purpose, "Selecting Purpose :", Purpose);
		if(RequestDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_RequestDateFrom, "Clicking on Request Date From :");
			dateOfMonthName(driver, test, "Selecting Request Date From :", RequestDateFrom);
		}
		if(RequestDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_RequestDateTo, "Clicking on Request Date To :");
			dateOfMonthName(driver, test, "Selecting Request Date To :", RequestDateTo);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, CRS_Reports_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :"+Segment);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_SegmentTextbox, "Entering Segment :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, CRS_Reports_Site, "Clicking on Site :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :"+Site);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_SiteTextbox, "Entering Site :", Site);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, CRS_Reports_Program, "Clicking on Program :");
			try {
				typeText(driver, test, CRS_Reports_programCode, "Entering Program Name :", Program);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :"+Program);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ProgramTextBox, "Entering Program :", Program);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, CRS_Reports_Department, "Clicking on Department :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Department+"')]", "Selecting Department :"+Department);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_EDepartmentTextbox, "Entering Department :", Department);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, CRS_Reports_ProductFamily, "Clicking on Product Family :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :"+ProductFamily);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_prodFamilyTextBox, "Entering Product Family :", ProductFamily);
		}
		typeText(driver, test, CRS_Reports_ProductDescription, "Entering Product Description :", ProductDescription);
		typeText(driver, test, CRS_Reports_salesOrderNo, "Entering Sales Order No :", SalesOrderNo);
		typeText(driver, test, CRS_Reports_purchaseOrderNo, "Entering Purchase Order No :", PurchaseOrderNo);
		selectByVisibleText(driver, test, CRS_Reports_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CRS_Reports_direction, "Selecting Direction :", Direction);
	}

}
