package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchDutyReliefActivityLogPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchDRA_ReliefAuthorizationNo = "//input[@id='searchReliefActivity_activityLogValue_reliefAuthNo']";
	public static final String OCR_SearchDRA_ReliefType = "//select[@id='searchReliefActivity_activityLogValue_reliefType']";
	public static final String OCR_SearchDRA_ActivityStatus = "//select[@id='searchReliefActivity_activityLogValue_activityStatus']";
	public static final String OCR_SearchDRA_PartNumber = "//input[@id='searchReliefActivity_activityLogValue_partNo']";
	public static final String OCR_SearchDRA_ShipmentType = "//select[@id='searchReliefActivity_activityLogValue_shipmentType']";
	public static final String OCR_SearchDRA_Search = "//button[@id='searchBtn']";
	public static final String OCR_SearchDRA_AddActivityBtn = "//button[@id='addActivityLogBtn']";

	/* ******************************* Constructor ****************************** */

	public SearchDutyReliefActivityLogPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//click on Search
	public void clickSearch() {
		clickElement(driver, test, OCR_SearchDRA_Search, "Click on Search");
	}
	
	//Search the Duty Relief Activity Log
	public void searchDFAlog(String ReliefAuthorizationNo, String ReliefType, String ActivityStatus, String PartNumber, String ShipmentType) {
		typeText(driver, test, OCR_SearchDRA_ReliefAuthorizationNo, "Enter the Relief Authorization No : ", ReliefAuthorizationNo);
		selectByVisibleText(driver, test, OCR_SearchDRA_ReliefType, "Select the Relief Type : ", ReliefType);
		selectByVisibleText(driver, test, OCR_SearchDRA_ActivityStatus, "Select the Activity Status : ", ActivityStatus);
		typeText(driver, test, OCR_SearchDRA_PartNumber, "Enter the Part Number : ", PartNumber);
		selectByVisibleText(driver, test, OCR_SearchDRA_ShipmentType, "Select the Shipment Type : ", ShipmentType);
	}

	public void addActivity() {
		clickElement(driver, test, OCR_SearchDRA_AddActivityBtn, "Click on Add Activity button");
	}
}
