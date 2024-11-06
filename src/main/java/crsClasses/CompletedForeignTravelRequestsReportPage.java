package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CompletedForeignTravelRequestsReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String CRS_Report_Search ="//button[contains(text(),'Search')]";
	public static final String CRS_Report_Reset ="//button[contains(text(),'Reset')]";
	public static final String CRS_Report_SBUCode ="//select[@name='foreignTravelGeneralInfoValue.sbuCode']";
	public static final String CRS_Report_foreignTravelId ="//input[@name='foreignTravelGeneralInfoValue.foreignTravelId']";
	public static final String CRS_Report_TravelDateFrom ="//input[@name='travelDateFrom']";
	public static final String CRS_Report_TravelDateTo ="//input[@name='travelDateTo']";
	public static final String CRS_Report_RequesterName = "//input[@name='foreignTravelGeneralInfoValue.requesterName']";
	public static final String CRS_Reports_ExportReviewer = "//a[contains(text(),'Export Reviewer')]";
	public static final String CRS_Report_UserFirstName = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Report_SearchPopup = "//button[@name='Search']";
	public static final String CRS_Report_SelectPopup = "(//button[@name='Ok'])[1]";
	public static final String CRS_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String CRS_Reports_SecurityReviewer = "//a[contains(text(),'Security Reviewer')]";
	public static final String CRS_Report_ManagerReviewer ="//a[contains(text(),'Manager Reviewer')]";
	public static final String CRS_Reports_DirectorReviewer = "//a[contains(text(),'Director Reviewer')]";
	public static final String CRS_Reports_Country = "//input[@name='country']";
	public static final String CRS_Reports_Company = "//input[@name='company']";
	public static final String CRS_Reports_CitiesVisiting = "//input[@name='cities']";
	public static final String CRS_Reports_DepartureCity = "//input[@name='port']";
	public static final String CRS_Report_AuthorizationNo_AgreementNumber = "//a[contains(text(),'Authorization No./Agreement Number')]";
	public static final String CRS_Reports_AuthorizationNoPopup = "//input[@name='dosGeneralInfoDTO.licenseNo']";
	public static final String CRS_Reports_AuthNoTextbox = "//input[@name='foreignTravelGeneralInfoValue.licenseNo']";
	public static final String CRS_Reports_ActivityType = "//select[@name='activityType']";
	public static final String CRS_Reports_AuthorizationType = "(//a[contains(text(),'Authorization Type')])[2]";
	public static final String CRS_Reports_descriptionPopup = "//textarea[@name='licenseTypes.description']";
	public static final String CRS_Reports_AuthTypeTextBox = "//input[@name='foreignTravelGeneralInfoValue.itarExemptionNo']";
	public static final String CRS_Reports_Travel_SecurityName = "//a[contains(text(),'Travel/Security Name')]";
	public static final String CRS_Reports_TravelSecurityNameTextbox = "//input[@name='foreignTravelGeneralInfoValue.travelDeskName']";
	public static final String CRS_Reports_ManagerName = "//a[contains(text(),'Manager Name')]";
	public static final String CRS_Reports_ManagerNameTextBox = "//input[@name='foreignTravelGeneralInfoValue.reportingToName']";
	public static final String CRS_Reports_Trip = "//select[@name='trip']";
	public static final String CRS_Reports_initiatedDateFrom = "//input[@name='initiatedDateFrom']";
	public static final String CRS_Reports_initiatedDateTo = "//input[@name='initiatedDateTo']";
	public static final String CRS_Reports_sortBy = "//select[@name='sortBy']";
	public static final String CRS_Reports_direction = "//select[@name='direction']";
	public static final String CRS_Reports_primaryPurpose = "//select[@name='primaryPurpose']";
	
	
	//..................................Constructors..................................//
	public CompletedForeignTravelRequestsReportPage(WebDriver driver,ExtentTest test) {
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
	
	//....................................Search By Parameters....................................//
	public void searchByParameters(String SBUCode, String ForeignTravelID, String TravelDateFrom, String TravelDateTo, 
			String RequesterName, String ExportReviewer, String SecurityReviewer, String ManagerReviewer, String DirectorReviewer, 
			String Country, String Company, String CitiesVisiting, String DepartureCity, String AuthNoAgreeNo, String ActivityType, 
			String AuthorizationType, String TravelSecurityName, String ManagerName, String Trip, String InitiatedDateFrom, 
			String InitiatedDateTo, String SortBy, String PrimaryPurpose, String Direction) {
		
		selectByVisibleText(driver, test, CRS_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, CRS_Report_foreignTravelId, "Entering Foreign Travel ID :", ForeignTravelID);
		if(TravelDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Report_TravelDateFrom, "Clicking on Travel Date From :");
			dateOfMonthName(driver, test, "Selecting Travel Date From :", TravelDateFrom);
		}
		if(TravelDateTo.length() > 0) {
			clickElement(driver, test, CRS_Report_TravelDateTo, "Clicking on Travel Date To :");
			dateOfMonthName(driver, test, "Selecting Travel Date To :", TravelDateTo);
		}
		typeText(driver, test, CRS_Report_RequesterName, "Entering Requester Name :", RequesterName);
		if(ExportReviewer.length() > 0) {
			clickElement(driver, test, CRS_Reports_ExportReviewer, "Clicking on Export Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Export Reviewer Name :", ExportReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportReviewer+"')]", "Selecting Export Reviewer :"+ExportReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(SecurityReviewer.length() > 0) {
			clickElement(driver, test, CRS_Reports_SecurityReviewer, "Clicking on Security Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Security Reviewer Name :", SecurityReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+SecurityReviewer+"')]", "Selecting Security Reviewer :"+SecurityReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(ManagerReviewer.length() > 0) {
			clickElement(driver, test, CRS_Report_ManagerReviewer, "Clicking on Manager Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Manager Reviewer Name :", ManagerReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ManagerReviewer+"')]", "Selecting Manager Reviewer :"+ManagerReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(DirectorReviewer.length() > 0) {
			clickElement(driver, test, CRS_Reports_DirectorReviewer, "Clicking on Director Reviewer :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Director Reviewer Name :", DirectorReviewer);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+DirectorReviewer+"')]", "Selecting Director Reviewer :"+DirectorReviewer);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		typeText(driver, test, CRS_Reports_Country, "Entering Country :", Country);
		typeText(driver, test, CRS_Reports_Company, "Entering Company :", Company);
		typeText(driver, test, CRS_Reports_CitiesVisiting, "Entering Cities Visiting :", CitiesVisiting);
		typeText(driver, test, CRS_Reports_DepartureCity, "Entering Departure City :", DepartureCity);
		if(AuthNoAgreeNo.length() > 0) {
			clickElement(driver, test, CRS_Report_AuthorizationNo_AgreementNumber, "Clicking on Authorization No/Agreement No :");
			try {
				typeText(driver, test, CRS_Reports_AuthorizationNoPopup, "Entering Authorization No/Agreement No :", AuthNoAgreeNo);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthNoAgreeNo+"')]", "Selecting Authorization No/Agreement No :"+AuthNoAgreeNo);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_AuthNoTextbox, "Entering Authorization No :", AuthNoAgreeNo);
		}
		selectByVisibleText(driver, test, CRS_Reports_ActivityType, "Selecting Activity Type :", ActivityType);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, CRS_Reports_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, CRS_Reports_descriptionPopup, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :"+AuthorizationType);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_AuthTypeTextBox, "Entering Authorization Type :", AuthorizationType);
		}
		if(TravelSecurityName.length() > 0) {
			clickElement(driver, test, CRS_Reports_Travel_SecurityName, "Clicking on Travel Security Name :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Travel Security Name :", TravelSecurityName);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TravelSecurityName+"')]", "Selecting Travel Security Name :"+TravelSecurityName);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_TravelSecurityNameTextbox, "Entering Travel Security Name :", TravelSecurityName);
		}
		if(ManagerName.length() > 0) {
			clickElement(driver, test, CRS_Reports_ManagerName, "Clicking on Manager Name :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Manager Name :", ManagerName);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ManagerName+"')]", "Selecting Manager Name :"+ManagerName);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ManagerNameTextBox, "Entering Manager Name :", ManagerName);
		}
		selectByVisibleText(driver, test, CRS_Reports_Trip, "Selecting Trip :", Trip);
		if(InitiatedDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_initiatedDateFrom, "Clicking on Initiated Date From :");
			dateOfMonthName(driver, test, "Selecting Initiated Date From :", InitiatedDateFrom);
		}
		if(InitiatedDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_initiatedDateTo, "Clicking on Initiated Date To :");
			dateOfMonthName(driver, test, "Selecting Initiated Date to :", InitiatedDateTo);
		}
		selectByVisibleText(driver, test, CRS_Reports_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CRS_Reports_primaryPurpose, "Selecting Primary Purpose :", PrimaryPurpose);
		selectByVisibleText(driver, test, CRS_Reports_direction, "Selecting Direction :", Direction);
	}

}
