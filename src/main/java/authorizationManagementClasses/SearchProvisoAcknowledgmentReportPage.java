package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchProvisoAcknowledgmentReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='licenseReviewValue.sbuCode']";
	public static final String AuthMana_Report_LicenseNo="//input[@name='licenseReviewValue.licenseNo']";
	public static final String AuthMana_Report_TransactionID ="//input[@name='licenseReviewValue.transactionId']";
	public static final String AuthMana_Report_NotificationDateFrom ="//input[@name='loaNotificationDateFrom']";
	public static final String AuthMana_Report_NotificationDateTo ="//input[@name='loaNotificationDateTo']";
	public static final String AuthMana_Report_AuthorizationOwner ="//a[contains(text(),' Authorization Owner')]";
	public static final String AuthMana_Report_userFirstname="//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationOwnerTextbox ="//input[@name='licenseReviewValue.curLicOwner']";
	public static final String AuthMana_Report_LicensePOC = "//a[contains(text(),'License POC')]";
	public static final String AuthMana_Report_LicensePOCTextbox = "//input[@name='licenseReviewValue.licPoc']";
	public static final String AuthMana_Report_ProductLine ="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_ProductLineTextbox = "//textarea[@name='licenseReviewValue.productLine']";
	public static final String AuthMana_Report_ProductFamily = "//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_ProductFamilyTextbox = "//textarea[@name='licenseReviewValue.productFamily']";
	public static final String AuthMana_Report_SortBy = "//select[@name='sortBy']";
	public static final String AuthMana_Report_Direction = "//select[@name='direction']";
	
	
	//..................................Constructors..................................//
	public SearchProvisoAcknowledgmentReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String LicenseNo, String TransactionID, String NotificationDateFrom, 
			String NotificationDateTo, String AuthorizationOwner, String LicensePOC, String ProductLine, String ProductFamily, 
			String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, AuthMana_Report_LicenseNo, "Entering License No :", LicenseNo);
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction ID :", TransactionID);
		if(NotificationDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_NotificationDateFrom, "Clicking on Notification Date From :");
			dateOfMonthName(driver, test, "Selecting Notification Date From :", NotificationDateFrom);
		}
		if(NotificationDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_NotificationDateTo, "Clicking on Notification Date To :");
			dateOfMonthName(driver, test, "Selecting Notification Date To :", NotificationDateTo);
		}
		if(AuthorizationOwner.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationOwner, "Clicking on License Type :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Authorization Owner :", AuthorizationOwner);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationOwner+"')]", "Selecting Authorization Owner :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationOwnerTextbox, "Entering Authorization Owner :", AuthorizationOwner);
		}
		if(LicensePOC.length() > 0) {
			clickElement(driver, test, AuthMana_Report_LicensePOC, "Clicking on License POC :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering License POC :", LicensePOC);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicensePOC+"')]", "Selecting License POC :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_LicensePOCTextbox, "Entering License POC :", LicensePOC);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductLine, "Clicking on Product Line :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProductLineTextbox, "Entering Product Line :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductFamily, "Clicking on Product Family :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProductFamilyTextbox, "Entering Product Family :", ProductFamily);
		}
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_Direction, "Selecting Direction :", Direction);
	}
}