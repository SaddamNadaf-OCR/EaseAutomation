package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationBalanceSummaryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SBU = "//select[@id='generateReport_licenseHeader_sbuCode']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_ActivityType = "//select[@id='generateReport_activityType']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthStatus = "//select[@name='licenseStatus']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthType = "//a[contains(text(),' Authorization Type')]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_PopUpSearchBtn = "(//button[@name='Search'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_PopUpSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_PopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SearchBtn = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_ValidateHeading = "//h3[contains(text(),'Authorization Balance Summary Report')]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_EnterAuthType = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	
	/* ******************************* Constructor ****************************** */

	public SearchAuthorizationBalanceSummaryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SBU, "Select SBU Code : ", sbu);

	}
	
	public void selectActivity(String ActivityStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_ActivityType, "Select Activity Status : ", ActivityStatus);
	}
	
	public void selectAuthStatus(String AuthStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthStatus, "Select Authorization Status : ", AuthStatus);
	}
	
	public void enterAuthType(String AuthTypeLink) {
		try {
			if (AuthTypeLink.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthType, "Click on Authorization Type Link");
				typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_EnterAuthType, "Enter Authorization Type : ", AuthTypeLink);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_PopUpSearchBtn, "Click on Pop-Up Search button");
				clickElement(driver, test, "//td[contains(text(),'"+ AuthTypeLink +"')]", "Select the Authorization Type : " + AuthTypeLink);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_PopUpSelectBtn, "Click on Select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_PopUpCloseBtn, "Click on Close popup icon");
		}
	}
	
	public void clickSearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SearchBtn, "Click on Search button");
	}
	
	public void validateHeading() {
	Wait.waitfor(2);
	isDisplayed(driver, OCR_SearchAuthorizationBalanceSummaryPage_ValidateHeading);
	Wait.waitfor(3);
	test.log(LogStatus.PASS, "Authorization Balance Summary Report Page is Displayed");
	Wait.waitfor(3);
	}
}
