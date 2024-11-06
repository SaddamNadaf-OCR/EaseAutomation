package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAuthorizationReviewDelinquencyReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_ActivityType="//select[@name='activityType']";
	public static final String AuthMana_Report_AuthorizationType ="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String AuthMana_Report_AuthorizationTypePopup ="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextbox ="//textarea[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_TransactionID ="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_LicenseNo = "//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_Owner ="(//a[contains(text(),'Owner')])[4]";
	public static final String AuthMana_Report_userFirstname ="//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_OwnerTextbox = "//input[@name='dosGeneralInfo.licenseOwner']";
	public static final String AuthMana_Report_Manager = "(//a[contains(text(),'Manager')])";
	public static final String AuthMana_Report_ManagerTextbox = "//input[@name='dosGeneralInfo.licenseManager']";
	public static final String AuthMana_Report_sortBy = "(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction ="(//select[@name='direction'])[1]";
	
	
	//..................................Constructors..................................//
	public SearchAuthorizationReviewDelinquencyReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String ActivityType, String AuthorizationType, String TransactionID, 
			String LicenseNo, String Owner, String Manager, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_ActivityType, "Selecting Activity Type :", ActivityType);
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
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextbox, "Entering Authorization Type :", AuthorizationType);
		}
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction ID :", TransactionID);
		typeText(driver, test, AuthMana_Report_LicenseNo, "Entering License No :", LicenseNo);
		if(Owner.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Owner, "Clicking on Owner :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Owner :", Owner);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Owner+"')]", "Selecting Owner :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_OwnerTextbox, "Entering Owner :", Owner);
		}
		if(Manager.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Manager, "Clicking on Manager :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Manager :", Manager);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Manager+"')]", "Selecting Manager :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ManagerTextbox, "Entering Manager :", Manager);
		}
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting Direction :", Direction);
	}
}