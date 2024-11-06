package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAuthorizationExpiringReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="(//select[@name='licenseHeader.sbuCode'])[1]";
	public static final String AuthMana_Report_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String AuthMana_Report_AuthorizationTypePopup="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[contains(text(),'Search')])[2]";
	public static final String AuthMana_Report_SelectPopUp="(//button[contains(text(),'Select')])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextBox="//textarea[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_AuthorizationNo = "//a[contains(text(),'Authorization No')]";
	public static final String AuthMana_Report_ReferanceNo = "//input[@id='searchForm_dosGeneralInfoDTO_transactionId']";
	public static final String AuthMana_Report_AuthorizationNoTextbox ="//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_Country ="//input[@id='reportLicExpire_licenseCountry_countryDescription']";
	public static final String AuthMana_Report_Program = "(//a[contains(text(),' Program')])";
	public static final String AuthMana_Report_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String AuthMana_Report_ProgramTextbox = "//textarea[@id='reportLicExpire_licenseHeader_programCode']";
	public static final String AuthMana_Report_Segment ="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentTextBox ="//textarea[@id='reportLicExpire_licenseHeader_segmentCode']";
	public static final String AuthMana_Report_Site = "//a[contains(text(),'Site')]";
	public static final String AuthMana_Report_SiteID = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String AuthMana_Report_SiteTextbox = "//textarea[@id='reportLicExpire_siteCode']";
	public static final String AuthMana_Report_Department ="//a[contains(text(),'Department')]";
	public static final String AuthMana_Report_DepartmentTextbox ="//textarea[@id='reportLicExpire_department']";
	public static final String AuthMana_Report_ExpiryDateFrom = "//input[@id='reportLicExpire_fromExpireDate']";
	public static final String AuthMana_Report_ExpiryDateTo = "//input[@id='reportLicExpire_toExpireDate']";
	public static final String AuthMana_Report_createdBy = "//select[@id='reportLicExpire_licenseHeader_createdBy']";	
	
	//..................................Constructors..................................//
	public SearchAuthorizationExpiringReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//................................Click on Search Tab ...............................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_Search, "Clicking on Search Tab");
	}
	
	//................................Click on Reset Tab ...............................//
	public void reset() {
		clickElement(driver, test, AuthMana_Report_Reset, "Clicking on Reset Tab");
	}
	
	//............................Search By Parameters.................................//
	public void searchByParameters(String SBUCode, String AuthorizationType, String AuthorizationNo, String Country, 
			String Program, String Segment, String Site, String Department, String ExpiryDateFrom, String ExpiryDateTo, String CreatedBy) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code :", SBUCode);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationTypePopup, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextBox, "Entering Authorization Type :", AuthorizationType);
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, AuthMana_Report_ReferanceNo, "Entering Authorization No :", AuthorizationNo);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationNoTextbox, "Entering Authorization No :", AuthorizationNo);
		}
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_ProgramCode, "Entering Program :", Program);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextbox, "Entering Program :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_segmentTextBox, "Entering Segment :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Site, "Clicking on Site :");
			try {
				typeText(driver, test, AuthMana_Report_SiteID, "Entering Site :", Site);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_SiteTextbox, "Entering Site :", Site);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Department, "Clicking on Department :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Department+"')]", "Selecting Department :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_DepartmentTextbox, "Entering Department :", Department);
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateFrom, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateTo, "Clicking on Expiry Date to :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_createdBy, "Selecting Created By :", CreatedBy);
	}

}
