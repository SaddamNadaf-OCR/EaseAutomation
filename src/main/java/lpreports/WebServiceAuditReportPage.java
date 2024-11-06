package lpreports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class WebServiceAuditReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_WebServiceAuditReport_SBUCode = "//select[@id='searchWsReport_sbuCode']";
	public static final String OCR_WebServiceAuditReport_UserId = "//input[@id='searchWsReport_userID']";
	public static final String OCR_WebServiceAuditReport_RequestType = "//select[@id='searchWsReport_requestType']";
	public static final String OCR_WebServiceAuditReport_RequestDateFrom = "//input[@id='searchWsReport_requestDateFrom']";
	public static final String OCR_WebServiceAuditReport_MessageType = "//select[@id='searchWsReport_messageType']";
	public static final String OCR_WebServiceAuditReport_RequestDateTo = "//input[@id='searchWsReport_requestDateTo']";
	public static final String OCR_WebServiceAuditReport_RequestStatus = "//select[@id='searchWsReport_status']";
	public static final String OCR_WebServiceAuditReport_ReferenceNo = "//input[@id='searchWsReport_referenceNo']";
	public static final String OCR_WebServiceAuditReport_AuditId = "//input[@id='searchWsReport_wsAuditId']";
	public static final String OCR_WebServiceAuditReport_SearchButton = "//button[@id='searchWSReportBtn']";

	/* ******************** Constructor ***************************** */
	public WebServiceAuditReportPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Search Products
	public void searchAuthorizationSummaryReport(String SBUCode, String UserID, String RequestType,
			String RequestDateFrom, String MessageType, String RequestDateTo, String RequestStatus, String ReferenceNo,
			String AuditID) throws InterruptedException {

		selectByVisibleText(driver, test, OCR_WebServiceAuditReport_SBUCode, "Select Sbu Code :", SBUCode);
		typeText(driver, test, OCR_WebServiceAuditReport_UserId, "Enter UserID :", UserID);
		selectByVisibleText(driver, test, OCR_WebServiceAuditReport_RequestType, "Select Request Type :", RequestType);

		if (RequestDateFrom.length() > 0) {
			typeText(driver, test, OCR_WebServiceAuditReport_RequestDateFrom, "Selected on Request Date From : ",
					RequestDateFrom);
		}

		selectByVisibleText(driver, test, OCR_WebServiceAuditReport_MessageType, "Select Message Type :", MessageType);

		if (RequestDateTo.length() > 0) {
			typeText(driver, test, OCR_WebServiceAuditReport_RequestDateTo, "Selected on Request Date To : ",
					RequestDateTo);
		}

		selectByVisibleText(driver, test, OCR_WebServiceAuditReport_RequestStatus, "Select Request Status :",
				RequestStatus);

		typeText(driver, test, OCR_WebServiceAuditReport_ReferenceNo, "Enter Reference No :", ReferenceNo);
		typeText(driver, test, OCR_WebServiceAuditReport_AuditId, "Enter Audit Id :", AuditID);

	}
	
	// Enter Search Products
		public void searchAuthorizationSummaryReport(String SBUCode, String UserID, String RequestType,
				String RequestDateFrom) throws InterruptedException {

			selectByVisibleText(driver, test, OCR_WebServiceAuditReport_SBUCode, "Select Sbu Code :", SBUCode);
			typeText(driver, test, OCR_WebServiceAuditReport_UserId, "Enter UserID :", UserID);
			selectByVisibleText(driver, test, OCR_WebServiceAuditReport_RequestType, "Select Request Type :", RequestType);

			if (RequestDateFrom.length() > 0) {
				typeText(driver, test, OCR_WebServiceAuditReport_RequestDateFrom, "Selected on Request Date From : ",
						RequestDateFrom);
			}
		}


	// Click on Search Button
	public void click_ReportSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_WebServiceAuditReport_SearchButton, "Click on Search Button");
	}

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Web Service Audit Report Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Web Service Audit Report Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}
}
