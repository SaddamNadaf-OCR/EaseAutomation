package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchDutyReliefAuthorizationDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchDR_Search = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_SearchDR_AddDutyReliefAuth = "//button[contains(text(),'Add Duty Relief Authorization')]";
	public static final String OCR_SearchDR_SearchDRActivity = "//button[contains(text(),'Search Duty Relief Activity')]";
	public static final String OCR_SearchDR_AddDFActivity = "//button[@id='addActivityLogBtn']";
	public static final String OCR_SearchDR_SBU = "//select[@id='editDutyLog_dutyReliAuthDetails_sbuCode']";
	public static final String OCR_SearchDR_Status = "//select[@id='editDutyLog_dutyReliAuthDetails_status']";
	public static final String OCR_SearchDR_AuthorizationNo = "//input[@id='editDutyLog_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_SearchDR_ReliefType = "//select[@id='editDutyLog_dutyReliAuthDetails_reliefType']";
	public static final String OCR_SearchDR_ReliefCategory = "//select[@id='editDutyLog_dutyReliAuthDetails_reliefCategory']";

	/* ******************************* Constructor ****************************** */

	public SearchDutyReliefAuthorizationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Search
	public void clickSearch() {
		clickElement(driver, test, OCR_SearchDR_Search, "Click on Search Button");
	}

	// click on Add Duty Relief Authorization
	public void clickAddDutyReliefAuth() {
		clickElement(driver, test, OCR_SearchDR_AddDutyReliefAuth, "Click on Add Duty Relief Authorization Button");
	}

	// click on Search Duty Relief Activity
	public void clickSearchDRActivity() {
		clickElement(driver, test, OCR_SearchDR_SearchDRActivity, "Click on Search Duty Relief Activity Button");
	}

	// click on Add Duty Relief Activity
	public void clickAddDFActivity() {
		clickElement(driver, test, OCR_SearchDR_AddDFActivity, "Click on Add Duty Relief Activity Button");
	}

	// Search Duty Relief Authorization Details
	public void searchDFAuth(String DutyRFAuthSBU, String Status, String AuthorizationNo, String ReliefType,
			String ReliefCategory) {
		selectByVisibleText(driver, test, OCR_SearchDR_SBU, "Select the SBU : ", DutyRFAuthSBU);
		selectByVisibleText(driver, test, OCR_SearchDR_Status, "Select the Status : ", Status);
		typeText(driver, test, OCR_SearchDR_AuthorizationNo, "Enter the Authorization No : ", AuthorizationNo);
		selectByVisibleText(driver, test, OCR_SearchDR_ReliefType, "Select the Relief Type : ", ReliefType);
		selectByVisibleText(driver, test, OCR_SearchDR_ReliefCategory, "Select the Relief Category : ", ReliefCategory);

	}

}
