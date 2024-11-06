package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchAuthorizationCloseOutPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..........................................Locators ...........................................//*
	public static final String Auth_Mana_Search="//button[contains(text(),'Search')]";
	public static final String Auth_Mana_Reset="//button[contains(text(),'Reset')]";
	public static final String Auth_Mana_AddToCloseOut="//button[contains(text(),'Add Close-Out')]";
	public static final String Auth_Mana_SBUCODE="//select[@name='licenseExpiry.sbuCode']";
	public static final String Auth_Mana_CloseOutID="//input[@name='licenseExpiry.licenseCloseOutId']";
	public static final String Auth_Mana_TransactionID="//input[@id='resultLicenseExpiry_licenseExpiry_transactionId']";
	public static final String Auth_Mana_AuthorizationNumber="//a[contains(text(),'Authorization Number')]";
	public static final String Auth_Mana_ReferanceNo="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String Auth_Mana_SearchPopUp="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String Auth_Mana_AuthorizationNoTextBox="//input[@id='resultLicenseExpiry_licenseExpiry_licenseNo']";
	public static final String Auth_Mana_ActivityType="//select[@id='resultLicenseExpiry_licenseExpiry_activityType']";
	public static final String Auth_Mana_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String Auth_Mana_AuthoTypePopUp="//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String Auth_Mana_AuthorizationTypeTextBox="//input[@id='resultLicenseExpiry_licenseExpiry_licenseType']";
	public static final String Auth_Mana_Status="//select[@name='status']";
	public static final String Auth_Mana_ExpiryDateFrom="//input[@id='resultLicenseExpiry_fromExpiryDate']";
	public static final String Auth_Mana_ExpiryDateto="//input[@id='resultLicenseExpiry_toExpiryDate']";
	public static final String Auth_Mana_USGSubmittedDateFrom="//input[@id='resultLicenseExpiry_fromUsgSubmittalDate']";
	public static final String Auth_Mana_USGSubmitterDateTo="//input[@id='resultLicenseExpiry_fromUsgSubmittalDate']";
	public static final String Auth_Mana_LicenseCloserReportSubmitted="//input[@id='lic']";
	public static final String Auth_Mana_Owner="//input[@id='resultLicenseExpiry_licenseExpiry_licenseOwner']";
	public static final String Auth_Mana_Manager="//input[@id='resultLicenseExpiry_licenseExpiry_managerName']";
	public static final String Auth_Mana_Requester="//input[@id='resultLicenseExpiry_licenseExpiry_requestorName']";
	public static final String Auth_Mana_SortBy="//select[@id='resultLicenseExpiry_sortBy']";
	public static final String Auth_Mana_Direction="//select[@name='direction']";
	
	//..................................Constructor............................................//
	public SearchAuthorizationCloseOutPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//................................Click on Search ..........................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.................................Click on Reset Tab ......................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Clicking on Reset Tab");
	}
	
	//.................................Click on ADD Close Out Tab.......................................//
	public void addCloseOut() {
		clickElement(driver, test, Auth_Mana_AddToCloseOut, "Clicking on Add Close Out Tab");
	}
	
	//.....................................Search Parameters............................................//
	public void searchByParameters(String sbu,String closeOutID,String transactionID,String AuthorizationNo,String ActivityType,
			String AuthorizationType,String Status,String ExpiryDateFrom,String ExpiryDateTo,String USGSubmittedDateFrom,
			String USGSubmittedDateTo,String LicenseClosure,String Owner,String Manager,String Requester,String SortBy,String Direction) {
		
		selectByVisibleText(driver, test, Auth_Mana_SBUCODE, "Selecting SBU From DropDown :", sbu);
		typeText(driver, test, Auth_Mana_CloseOutID, "Selecting SBU From DropDown :", closeOutID);
		typeText(driver, test, Auth_Mana_TransactionID, "Selecting SBU From DropDown :", transactionID);
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationNumber, "Clicking on Authorization No :");
			try {
				typeText(driver, test, Auth_Mana_ReferanceNo, "Entering Referance No :", AuthorizationNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationNoTextBox, "Selecting SBU From DropDown", AuthorizationNo);
		}
		selectByVisibleText(driver, test, Auth_Mana_ActivityType, "Selecting Activity Type :", ActivityType);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationType, "Clicking on Authorization No :");
			try {
				typeText(driver, test, Auth_Mana_AuthoTypePopUp, "Entering Referance No :", AuthorizationType);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationTypeTextBox, "Selecting SBU From DropDown", AuthorizationType);
		}
		selectByVisibleText(driver, test, Auth_Mana_Status, "Selecting Status From DropDown", Status);
		clickElement(driver, test, Auth_Mana_ExpiryDateFrom, "Clicking on Expiry Date From :");
		dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		clickElement(driver, test, Auth_Mana_ExpiryDateto, "Clicking on Expiry Date to :");
		dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		clickElement(driver, test, Auth_Mana_USGSubmittedDateFrom, "Clicking on USG Submitted Date From :");
		dateOfMonthName(driver, test, "Selecting USG Submitted Date From :", USGSubmittedDateFrom);
		clickElement(driver, test, Auth_Mana_USGSubmitterDateTo, "Clicking on USG Submitted Date To :");
		dateOfMonthName(driver, test, "Selecting USG Submitted Date To :", USGSubmittedDateTo);
		if(LicenseClosure.contains("y")) {
			clickElement(driver, test, Auth_Mana_LicenseCloserReportSubmitted, "Clicking on License Closure Report Submitted To USG :");
		}else if(LicenseClosure.contains("n")) {
			
		}
		typeText(driver, test, Auth_Mana_Owner, "Entering Owner :", Owner);
		typeText(driver, test, Auth_Mana_Manager, "Entering Manager :", Manager);
		typeText(driver, test, Auth_Mana_Requester, "Entering Requestor :", Requester);
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction :", Direction);
	}
}
