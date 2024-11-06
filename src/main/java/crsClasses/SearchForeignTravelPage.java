package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchForeignTravelPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchForeignTravel_Features = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_SearchForeignTravel_Requests = "//a[contains(text(),'Requests')]/i";
	public static final String OCR_SearchForeignTravel_ForeignTravel = "//ul[@class='nav navbar-nav']//li[1]//div[1]//ul[1]//li[3]//a[1]";
	public static final String OCR_SearchForeignTravel_AddRequest = "//button[@name='newFTF']";
	public static final String OCR_SearchForeignTravel_SBUCode = "//select[@id='resultForeignTravel_foreignTravelGeneralInfoValue_sbuCode']";
	public static final String OCR_SearchForeignTravel_ForeignTravelId = "//input[@id='resultForeignTravel_foreignTravelGeneralInfoValue_foreignTravelId']";
	public static final String OCR_SearchForeignTravel_RequesterName = "//input[@id='resultForeignTravel_foreignTravelGeneralInfoValue_requesterName']";
	public static final String OCR_SearchForeignTravel_ExportReviewer = "//a[@id='tdfpLink']";
	public static final String OCR_SearchForeignTravel_SecurityReviewer = "//a[contains(text(),'Security Reviewer')]";
	public static final String OCR_SearchForeignTravel_ManagerReviewer = "//a[contains(text(),'Manager Reviewer')]";
	public static final String OCR_SearchForeignTravel_DirectorReviewer = "//a[contains(text(),'Director Reviewer')]";
	public static final String OCR_SearchForeignTravel_TravelDeskName = "//input[@id='resultForeignTravel_foreignTravelGeneralInfoValue_travelDeskName']";
	public static final String OCR_SearchForeignTravel_Status = "//select[@name='foreignTravelGeneralInfoValue.status']";
	public static final String OCR_SearchForeignTravel_ManagerName = "//input[@id='resultForeignTravel_foreignTravelGeneralInfoValue_reportingToName']";
	public static final String OCR_SearchForeignTravel_TravelDateFrom = "//input[@id='resultForeignTravel_travelDateFrom']";
	public static final String OCR_SearchForeignTravel_TravelDateTo = "//input[@id='resultForeignTravel_travelDateTo']";
	public static final String OCR_SearchForeignTravel_Country = "//input[@id='resultForeignTravel_country']";
	public static final String OCR_SearchForeignTravel_Company = "//input[@id='resultForeignTravel_company']";
	public static final String OCR_SearchForeignTravel_CitiesVisiting = "//input[@id='resultForeignTravel_cities']";
	public static final String OCR_SearchForeignTravel_DepartureCity = "//input[@id='resultForeignTravel_port']";
	public static final String OCR_SearchForeignTravel_ActivityType = "//select[@id='activityId']";
	public static final String OCR_SearchForeignTravel_AuthorizationType = "//input[@id='resultForeignTravel_foreignTravelGeneralInfoValue_itarExemptionNo']";
	public static final String OCR_SearchForeignTravel_AuthorizationNo_AgrNo = "//input[@id='resultForeignTravel_foreignTravelGeneralInfoValue_licenseNo']";
	public static final String OCR_SearchForeignTravel_Trip = "//select[@name='trip']";
	public static final String OCR_SearchForeignTravel_InitiatedDateFrom = "//input[@id='resultForeignTravel_initiatedDateFrom']";
	public static final String OCR_SearchForeignTravel_InitiatedDateTo = "//input[@id='resultForeignTravel_initiatedDateTo']";
	public static final String OCR_SearchForeignTravel_Segment = "//textarea[@id='resultForeignTravel_foreignTravelGeneralInfoValue_segment']";
	public static final String OCR_SearchForeignTravel_Site = "//textarea[@id='resultForeignTravel_foreignTravelGeneralInfoValue_site']";
	public static final String OCR_SearchForeignTravel_ProductLine = "//textarea[@id='resultForeignTravel_foreignTravelGeneralInfoValue_productLine']";
	public static final String OCR_SearchForeignTravel_ProductFamily = "//textarea[@id='resultForeignTravel_foreignTravelGeneralInfoValue_productFamily']";
	public static final String OCR_SearchForeignTravel_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SearchForeignTravel_Program = "//textarea[@id='resultForeignTravel_foreignTravelGeneralInfoValue_program']";
	public static final String OCR_SearchForeignTravel_Direction = "//select[@id='resultForeignTravel_direction']";
	public static final String OCR_SearchForeignTravel_PrimaryPurpose = "//select[@name='primaryPurpose']";
	public static final String OCR_SearchForeignTravel_ReviewPending_ExpReview = "//input[@name='exportCompleted']";
	public static final String OCR_SearchForeignTravel_ReviewPending_SecReview = "//input[@name='securityCompleted']";
	public static final String OCR_SearchForeignTravel_ReviewPending_ManReview = "//input[@name='managerCompleted']";
	public static final String OCR_SearchForeignTravel_ReviewPending_DirReview = "//input[@name='vpCompleted']";
	public static final String OCR_SearchForeignTravel_SearchBtn = "//button[contains(text(),'Search')]";

	/* ******************** Constructor ***************************** */

	public SearchForeignTravelPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Move to features and click Compliance Request
	public void moveTo_Features() {
		mouseOver(driver, test, OCR_SearchForeignTravel_Features, "Mouse over on Features");
	}

	// click on Requests
	public void click_Requests() throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchForeignTravel_Requests, "Clicking on Requests");
	}

	// click on Foreign Travel Request
	public void click_ForeignTravel() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchForeignTravel_ForeignTravel,
				"Clicking on Foreign Travel Request under Requests");
	}

	// click on Add Request
	public void click_AddRequestBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchForeignTravel_AddRequest, "Click on Add Request");
	}

	// Search results with different parameters(Smoke Level Test Cases)
	public void searchParameters(String SBUCode, String Status, String Country,String ActivityType, String AuthorizationType, 
			String AuthorizationNo_AgrNo) {

		selectByVisibleText(driver, test, OCR_SearchForeignTravel_SBUCode, "Select the SBU Code : ", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchForeignTravel_Status, "Select the Status : ", Status);
		typeText(driver, test, OCR_SearchForeignTravel_Country, "Enter Country: ", Country);
		selectByVisibleText(driver, test, OCR_SearchForeignTravel_ActivityType, "Select the ActivityType : ",
				ActivityType);
		typeText(driver, test, OCR_SearchForeignTravel_AuthorizationType, "Enter Authorization Type : ",
				AuthorizationType);
		typeText(driver, test, OCR_SearchForeignTravel_AuthorizationNo_AgrNo, "Enter AuthorizationNo/AgrNo : ",
				AuthorizationNo_AgrNo);
	}
	
	// Search results with different parameters(Regression Level Test Cases)
		public void searchParameters(String SBUCode, String ForeignTravelId, String RequesterName, String ExportReviewer,
				String SecurityReviewer, String ManagerReviewer, String DirectorReviewer, String TravelDeskName,
				String Status, String ManagerName, String TravelDateFrom, String TravelDateTo, String Country,
				String Company, String CitiesVisiting, String DepartureCity, String ActivityType, String AuthorizationType,
				String AuthorizationNo_AgrNo, String Trip, String InitiatedDateFrom, String InitiatedDateTo, String Segment,
				String Site, String ProductLine, String ProductFamily, String SortBy, String Program, String Direction,
				String PrimaryPurpose, String ReviewPending_ExpReview, String ReviewPending_SecReview,
				String ReviewPending_ManReview, String ReviewPending_DirReview) {

			selectByVisibleText(driver, test, OCR_SearchForeignTravel_SBUCode, "Select the SBU Code : ", SBUCode);
			typeText(driver, test, OCR_SearchForeignTravel_ForeignTravelId, "Enter Foreign Travel Id : ", ForeignTravelId);
			typeText(driver, test, OCR_SearchForeignTravel_RequesterName, "Enter Requester Name : ", RequesterName);
			if (ExportReviewer.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_ExportReviewer, "Click on Export Reviewer link");
				Wait.waitfor(3);
				typeText(driver, test, "//input[@id='searchForm_userProfile_userFirstname']", "Type Export Reviewer Name",
						ExportReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[@name='Search'])[2]", "Click on Search Button: ");
				Wait.waitfor(3);
				clickElement(driver, test,
						"//tr[@id='1']//td[@class='ui-state-default jqgrid-rownum'][contains(text(),'1')]",
						"Click on Searched record: ");
				Wait.waitfor(3);
				clickElement(driver, test, "//button[contains(text(),'Select')]", "Click on Select Button: ");
			}
			if (SecurityReviewer.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_SecurityReviewer, "Click on Security Reviewer link");
				Wait.waitfor(3);
				typeText(driver, test, "//input[@id='searchForm_userProfile_userFirstname']", "Type Security Reviewer Name",
						SecurityReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[@name='Search'])[2]", "Click on Search Button: ");
				Wait.waitfor(3);
				clickElement(driver, test,
						"//tr[@id='1']//td[@class='ui-state-default jqgrid-rownum'][contains(text(),'1')]",
						"Click on Searched record: ");
				Wait.waitfor(3);
				clickElement(driver, test, "//button[contains(text(),'Select')]", "Click on Select Button: ");
			}
			if (ManagerReviewer.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_ManagerReviewer, "Click on Manager Reviewer link");
				Wait.waitfor(3);
				typeText(driver, test, "//input[@id='searchForm_userProfile_userFirstname']", "Type Manager Reviewer Name",
						ManagerReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[@name='Search'])[2]", "Click on Search Button: ");
				Wait.waitfor(3);
				clickElement(driver, test,
						"//tr[@id='1']//td[@class='ui-state-default jqgrid-rownum'][contains(text(),'1')]",
						"Click on Searched record: ");
				Wait.waitfor(3);
				clickElement(driver, test, "//button[contains(text(),'Select')]", "Click on Select Button: ");
			}
			if (DirectorReviewer.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_DirectorReviewer, "Click on Director Reviewer link");
				Wait.waitfor(3);
				typeText(driver, test, "//input[@id='searchForm_userProfile_userFirstname']", "Type Director Reviewer Name",
						DirectorReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[@name='Search'])[2]", "Click on Search Button: ");
				Wait.waitfor(3);
				clickElement(driver, test,
						"//tr[@id='1']//td[@class='ui-state-default jqgrid-rownum'][contains(text(),'1')]",
						"Click on Searched record: ");
				Wait.waitfor(3);
				clickElement(driver, test, "//button[contains(text(),'Select')]", "Click on Select Button: ");
			}
			typeText(driver, test, OCR_SearchForeignTravel_TravelDeskName, "Enter Travel Desk Name", TravelDeskName);
			selectByVisibleText(driver, test, OCR_SearchForeignTravel_Status, "Select the Status : ", Status);
			typeText(driver, test, OCR_SearchForeignTravel_ManagerName, "Enter Requestor Name : ", ManagerName);

			if (TravelDateFrom.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_TravelDateFrom, "Click on Requestor Date From");
				date(driver, test, "Select the Travel Date From : ", TravelDateFrom);
				clickElement(driver, test, OCR_SearchForeignTravel_TravelDateTo, "Click on Requestor Date To");
				date(driver, test, "Select the Travel Date To : ", TravelDateTo);
			}
			typeText(driver, test, OCR_SearchForeignTravel_Country, "Enter Country: ", Country);
			typeText(driver, test, OCR_SearchForeignTravel_Company, "Enter the Company : ", Company);
			typeText(driver, test, OCR_SearchForeignTravel_CitiesVisiting, "Enter the Cities Visiting : ", CitiesVisiting);
			typeText(driver, test, OCR_SearchForeignTravel_DepartureCity, "Enter the Departure City : ", DepartureCity);
			selectByVisibleText(driver, test, OCR_SearchForeignTravel_ActivityType, "Select the ActivityType : ",
					ActivityType);
			typeText(driver, test, OCR_SearchForeignTravel_AuthorizationType, "Enter Authorization Type : ",
					AuthorizationType);
			typeText(driver, test, OCR_SearchForeignTravel_AuthorizationNo_AgrNo, "Enter AuthorizationNo/AgrNo : ",
					AuthorizationNo_AgrNo);
			selectByVisibleText(driver, test, OCR_SearchForeignTravel_Trip, "Select Trip : ", Trip);
			if (InitiatedDateFrom.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_InitiatedDateFrom, "Click on Initiated Date From From");
				date(driver, test, "Select the Initiated Date From : ", InitiatedDateFrom);
				clickElement(driver, test, OCR_SearchForeignTravel_InitiatedDateTo, "Click on Initiated Date To");
				date(driver, test, "Select the Initiated Date To : ", InitiatedDateTo);
			}
			typeText(driver, test, OCR_SearchForeignTravel_Segment, "Enter Segment: ", Segment);
			typeText(driver, test, OCR_SearchForeignTravel_Site, "Enter Site: ", Site);
			typeText(driver, test, OCR_SearchForeignTravel_ProductLine, "Enter ProductLine: ", ProductLine);
			typeText(driver, test, OCR_SearchForeignTravel_ProductFamily, "Enter ProductFamily: ", ProductFamily);
			selectByVisibleText(driver, test, OCR_SearchForeignTravel_SortBy, "Select the SortBy : ", SortBy);
			typeText(driver, test, OCR_SearchForeignTravel_Program, "Enter Program: ", Program);
			selectByVisibleText(driver, test, OCR_SearchForeignTravel_Direction, "Select Direction : ", Direction);
			selectByVisibleText(driver, test, OCR_SearchForeignTravel_PrimaryPurpose, "Select Primary Purpose: ",
					PrimaryPurpose);
			if (ReviewPending_ExpReview.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_ReviewPending_ExpReview,
						"Click on Export Review Checkbox");
			}
			if (ReviewPending_SecReview.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_ReviewPending_SecReview,
						"Click on Security Review Checkbox");
			}
			if (ReviewPending_ManReview.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_ReviewPending_ManReview,
						"Click on Manager Review Checkbox");
			}
			if (ReviewPending_DirReview.length() > 0) {
				clickElement(driver, test, OCR_SearchForeignTravel_ReviewPending_DirReview,
						"Click on Director Review Checkbox");
			}

		}

	// Select the SBUID and Request ID
	public void selectSbuID(String SbuID, String RequestID) {
		selectByVisibleText(driver, test, OCR_SearchForeignTravel_SBUCode, "Select the SBU ID : ", SbuID);
		typeText(driver, test, OCR_SearchForeignTravel_ForeignTravelId, "Enter the Request ID : ", RequestID);
	}

	// Click on Search button
	public void click_SearchBtn() {
		clickElement(driver, test, OCR_SearchForeignTravel_SearchBtn, "Click on Search button");
	}
}
