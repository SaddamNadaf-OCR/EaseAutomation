package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchExportConsigneeByCountryPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='licenseHeader.sbuCode']";
	public static final String AuthMana_Report_LicenseNo="//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_ExpireDateFrom ="//input[@name='fromExpireDate']";
	public static final String AuthMana_Report_ExpireDateTo ="//input[@name='toExpireDate']";
	public static final String AuthMana_Report_LicenseType ="(//a[contains(text(),'License Type')])";
	public static final String AuthMana_Report_AuthorizationType ="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextbox ="//input[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_ProductClass = "//input[@name='licenseItem.prodClassification']";
	public static final String AuthMana_Report_Purpose ="//input[@name='licenseHeader.purpose']";
	public static final String AuthMana_Report_Country = "//input[@name='']";
	public static final String AuthMana_Report_UltimateConsignee = "//input[@name='licenseConsignee.licConsName']";
	public static final String AuthMana_Report_CreatedBy = "//select[@name='licenseHeader.createdBy']";
	
	
	//..................................Constructors..................................//
	public SearchExportConsigneeByCountryPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String LicenseNo, String ExpiryDateFrom, String ExpiryDateTo, String LicenseType, String ProductClass, String Purpose, String Country, String UltimateConsignee, String CreatedBy) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, AuthMana_Report_LicenseNo, "Entering License No :", LicenseNo);
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpireDateFrom, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpireDateTo, "Clicking on Expiry Date To :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		if(LicenseType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_LicenseType, "Clicking on License Type :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationType, "Entering Authorization Type :", LicenseType);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicenseType+"')]", "Selecting License Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextbox, "Entering License Type :", LicenseType);
		}
		typeText(driver, test, AuthMana_Report_ProductClass, "Entering Product Class :", ProductClass);
		typeText(driver, test, AuthMana_Report_Purpose, "Entering Purpose :", Purpose);
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		typeText(driver, test, AuthMana_Report_UltimateConsignee, "Entering Ultimate Consignee :", UltimateConsignee);
		selectByVisibleText(driver, test, AuthMana_Report_CreatedBy, "selecting Created By :", CreatedBy);
	}
}