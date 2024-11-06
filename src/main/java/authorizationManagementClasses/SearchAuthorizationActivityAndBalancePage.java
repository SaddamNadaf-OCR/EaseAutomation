package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAuthorizationActivityAndBalancePage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="(//select[@name='licenseHeader.sbuCode'])[1]";
	public static final String AuthMana_Report_AuthorizationType="//a[contains(text(),' Authorization Type')]";
	public static final String AuthMana_Report_AuthorizationTypePopup="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextBox="//textarea[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_AuthorizationNo ="//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_AuthorizationStatus ="//select[@name='licenseStatus']";
	public static final String AuthMana_Report_activityType ="//select[@name='activityType']";
	public static final String AuthMana_Report_UltimateConsignee ="//input[@name='licenseConsignee.licConsName']";
	public static final String AuthMana_Report_contractNo ="//input[@name='licenseHeader.contractNo']";
	public static final String AuthMana_Report_Country ="//input[@name='']";
	public static final String AuthMana_Report_referenceNo ="//input[@name='licenseHeader.referenceNo']";
	public static final String AuthMana_Report_tecc ="//input[@name='licenseHeader.tecc']";
	public static final String AuthMana_Report_fromIssueDate ="//input[@name='fromIssueDate']";
	public static final String AuthMana_Report_toIssueDate ="//input[@name='toIssueDate']";
	public static final String AuthMana_Report_Segment ="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentTextBox ="//textarea[@name='licenseHeader.segmentDesc']";
	
	
	//..................................Constructors..................................//
	public SearchAuthorizationActivityAndBalancePage(WebDriver driver,ExtentTest test) {
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
	
	//...............................Search By Parameters...............................//
	public void searchByParameters(String SBUCode, String AuthorizationType, String AuthorizationNo, 
			String Status, String ActivityType, String UltimateConsignee, String ContractNo, String Country, 
			String ReferanceNo, String TECC) {
		
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
		typeText(driver, test, AuthMana_Report_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationStatus, "Selecting Authorization Status :", Status);
		selectByVisibleText(driver, test, AuthMana_Report_activityType, "Selecting Activity Type :", ActivityType);
		typeText(driver, test, AuthMana_Report_UltimateConsignee, "Entering Ultimate Consignee :", UltimateConsignee);
		typeText(driver, test, AuthMana_Report_contractNo, "Entering Contract No :", ContractNo);
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		typeText(driver, test, AuthMana_Report_referenceNo, "Entering Referance No :", ReferanceNo);
		typeText(driver, test, AuthMana_Report_tecc, "Entering TECC :", TECC);
	}
}