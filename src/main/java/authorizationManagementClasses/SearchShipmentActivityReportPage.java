package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchShipmentActivityReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
		public static final String AuthMana_Report_Search ="//button[contains(text(),'Search')]";
		public static final String AuthMana_Report_Reset ="//button[contains(text(),'Reset')]";
		public static final String AuthMana_Report_SBUCode ="//select[@name='licenseTransaction.sbuCode']";
		public static final String AuthMana_Report_serialNo ="//input[@name='licenseTransaction.serialNo']";
		public static final String AuthMana_Report_PartNo ="//a[contains(text(),'Part No.')]";
		public static final String AuthMana_Report_PartNoPopup ="//input[@name='product.productCode']";
		public static final String AuthMana_Report_SearchPopup = "//button[@name='Search']";
		public static final String AuthMana_Report_SelectPopup = "(//button[@name='Ok'])[1]";
		public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
		public static final String AuthMana_Report_PartNoTextbox = "//input[@name='licenseTransaction.productCd']";
		public static final String AuthMana_Report_ReferenceNo = "//input[@name='licenseTransaction.referenceNo']";
		public static final String AuthMana_Report_LicenseNo = "//input[@name='licenseTransaction.licenseNo']";
		public static final String AuthMana_Report_LicenseType = "//a[contains(text(),'License Type')]";
		public static final String AuthMana_Report_LicenseTypePopup = "//textarea[@name='licenseTypes.licenseType']";
		public static final String AuthMana_Report_LicenseTypeTextbox = "//input[@name='licenseTransaction.licenseType']";
		public static final String AuthMana_Report_TransactionType = "//a[contains(text(),'  Transaction Type')]";
		public static final String AuthMana_Report_TransactionTypeTextbox ="//input[@name='licenseTransaction.transactionType']";
		public static final String AuthMana_Report_CountryShippedFrom = "(//input[@name=''])[1]";
		public static final String AuthMana_Report_CountryShippedTo = "(//input[@name=''])[2]";
		public static final String AuthMana_Report_CreatedBy = "//a[contains(text(),'Created By')]";
		public static final String AuthMana_Report_User = "//input[@name='userProfile.username']";
		public static final String AuthMana_Report_CreatedByTextbox = "//input[@name='licenseTransaction.createdBy']";
		public static final String AuthMana_Report_SortBy ="(//select[@name='sortBy'])[1]";
	
	//..................................Constructors..................................//
	public SearchShipmentActivityReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, AuthMana_Report_Reset, "Clicking on Reset Button :");
	}
	
	//..................................Search By Parameters......................................//
	public void searchByParameters(String SBUCode, String serialNo, String PartNo, String ReferenceNo, String LicenseNo, 
			String LicenseType, String TransactionType, String CountryShippedFrom, String CountryShippedTo, String CreatedBY, 
			String SortBy) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, AuthMana_Report_serialNo, "Entering serial No :", serialNo);
		if(PartNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PartNo, "Clicking on Part No :");
			try {
				typeText(driver, test, AuthMana_Report_PartNoPopup, "Entering Part No :", PartNo);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PartNo+"')]", "Selecting Part No :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_PartNoTextbox, "Entering Part No :", PartNo);
		}
		typeText(driver, test, AuthMana_Report_ReferenceNo, "Entering Reference No :", ReferenceNo);
		typeText(driver, test, AuthMana_Report_LicenseNo, "Entering License No :", LicenseNo);
		if(LicenseType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_LicenseType, "Clicking on License Type :");
			try {
				typeText(driver, test, AuthMana_Report_LicenseTypePopup, "Entering License Type :", LicenseType);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicenseType+"')]", "Selecting License Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_LicenseTypeTextbox, "Entering License Type :", LicenseType);
		}
		if(TransactionType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_TransactionType, "Clicking on Transaction Type :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TransactionType+"')]", "Selecting Transaction Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_TransactionTypeTextbox, "Entering Transaction Type :", TransactionType);
		}
		typeText(driver, test, AuthMana_Report_CountryShippedFrom, "Entering Country Shipped From :", CountryShippedFrom);
		typeText(driver, test, AuthMana_Report_CountryShippedTo, "Entering Country Shipped To :", CountryShippedTo);
		if(CreatedBY.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CreatedBy, "Clicking on Created BY :");
			try {
				typeText(driver, test, AuthMana_Report_User, "Entering Created BY :", CreatedBY);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBY+"')]", "Selecting Created BY :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_CreatedByTextbox, "Entering Created BY :", CreatedBY);
		}
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting Sort By :", SortBy);
	}
}