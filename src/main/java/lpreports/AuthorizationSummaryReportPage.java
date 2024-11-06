package lpreports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AuthorizationSummaryReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AuthSummaryReport_ReferenceID = "//input[@name='authorisationHeaderValue.referenceId']";
	public static final String OCR_AuthSummaryReport_SBUCode = "//select[@id='generateReport_authorisationHeaderValue_sbuCode']";
	public static final String OCR_AuthSummaryReport_FolderId = "//input[@name='authorisationHeaderValue.folderId']";
	public static final String OCR_AuthSummaryReport_Status = "//select[@name='authorisationHeaderValue.status']";
	public static final String OCR_AuthSummaryReport_AuthorizationNoLink = "//a[contains(text(),'Authorization No')]";
	public static final String OCR_AuthSummaryReport_AuthorizationNo = "//input[@id='resultLicensePopupData_authorisationHeader_authorisationNumber']";
	public static final String OCR_AuthSummaryReport_AuthorizationNoSearch = "//button[@id='searchAuth']";
	public static final String OCR_AuthSummaryReport_AuthorizationNoCancel = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_AuthSummaryReport_ProgramLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Program')]";
	public static final String OCR_AuthSummaryReport_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_AuthSummaryReport_ProgramSearch = "//button[@name='Search']";
	public static final String OCR_AuthSummaryReport_ProgramCancel = "(//button[contains(@name,'cancel')])[2]";
	public static final String OCR_AuthSummaryReport_AuthGrantCountryName = "//input[@name='nousecountryname']";
	public static final String OCR_AuthSummaryReport_SegmentLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Segment')]";
	public static final String OCR_AuthSummaryReport_SegmentCancel = "(//button[contains(@name,'cancel')])[1]";
	public static final String OCR_AuthSummaryReport_RelatedAuthorisationLink = "//a[contains(text(),'Related Authorization')]";
	public static final String OCR_AuthSummaryReport_RelatedAuthorisationCode = "//input[@id='searchForm_code']";
	public static final String OCR_AuthSummaryReport_AuthorizationTypeLink = "//a[contains(text(),'Authorization Type')]";
	public static final String OCR_AuthSummaryReport_AuthorizationCode = "//input[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_AuthSummaryReport_AuthorizationSearch = "(//button[@name='Search'])[1]";
	public static final String OCR_AuthSummaryReport_AuthorizationSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_AuthSummaryReport_AuthorizationCancel = "(//button[contains(text(),'Cancel')])[3]";
	public static final String OCR_AuthSummaryReport_AgencyLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Agency')]";
	public static final String OCR_AuthSummaryReport_AgencySelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_AuthSummaryReport_AgencyCancel = "(//button[contains(text(),'Cancel')])[1]";
	public static final String OCR_AuthSummaryReport_RequestorName = "//input[@name='authorisationHeaderValue.requestorName']";
	public static final String OCR_AuthSummaryReport_ReviewerName = "//input[@name='authorisationHeaderValue.reviewerName']";
	public static final String OCR_AuthSummaryReport_FromIssueDate = "//input[@name='fromIssueDate']";
	public static final String OCR_AuthSummaryReport_ToIssueDate = "//input[@name='toIssueDate']";
	public static final String OCR_AuthSummaryReport_FromExpireDate = "//input[@name='fromExpireDate']";
	public static final String OCR_AuthSummaryReport_ToExpireDate = "//input[@name='toExpireDate']";
	public static final String OCR_AuthSummaryReport_SearchButton = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";

	/* ******************** Constructor ***************************** */
	public AuthorizationSummaryReportPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Search Products
	public void searchAuthorizationSummaryReport(String ReferenceID, String SBUCode, String FolderID, String Status,
			String AuthorizationNo, String ProgramCode, String AuthorizationCountry, String SegmentCode, String Code,
			String AuthorizationCode, String AgencyCode, String RequestorName, String ReviewerName,
			String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo)
			throws InterruptedException {

		typeText(driver, test, OCR_AuthSummaryReport_ReferenceID, "Enter ReferenceID :", ReferenceID);
		selectByVisibleText(driver, test, OCR_AuthSummaryReport_SBUCode, "Select Sbu Code :", SBUCode);
		Wait.waitfor(3);
		typeText(driver, test, OCR_AuthSummaryReport_FolderId, "Enter FolderId :", FolderID);
		selectByVisibleText(driver, test, OCR_AuthSummaryReport_Status, "Select Status :", Status);

		if (AuthorizationNo.length() > 0) {
			try {
				typeText(driver, test, OCR_AuthSummaryReport_AuthGrantCountryName, "Enter Authorization Country :",
						AuthorizationCountry);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationNoLink, "Click Authorization No Link");
				typeText(driver, test, OCR_AuthSummaryReport_AuthorizationNo, "Enter Authorization Code :",
						AuthorizationNo);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationNoSearch, "Click Search Button");
				String authorizationNo = "//td[contains(text(),'" + AuthorizationNo + "')]";
				clickElement(driver, test, authorizationNo, "Authorization No :" + AuthorizationNo);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationNoCancel,
						"Close the Authorization No Pop UP");
			}
		}

		if (ProgramCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthSummaryReport_ProgramLink, "Click Program Link");
				typeText(driver, test, OCR_AuthSummaryReport_ProgramCode, "Enter Program Code :", ProgramCode);
				clickElement(driver, test, OCR_AuthSummaryReport_ProgramSearch, "Click Search Button");
				String programCode = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, programCode, "Program Code :" + ProgramCode);
				clickElement(driver, test, OCR_AuthSummaryReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthSummaryReport_ProgramCancel, "Close the Program Pop UP");
			}
		}

		typeText(driver, test, OCR_AuthSummaryReport_AuthGrantCountryName, "Enter Authorization Country :",
				AuthorizationCountry);

		if (SegmentCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthSummaryReport_SegmentLink, "Click Segment Link");
				String segmentCode = "//td[contains(text(),'" + SegmentCode + "')]";
				clickElement(driver, test, segmentCode, "Segment Code :" + SegmentCode);
				clickElement(driver, test, OCR_AuthSummaryReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthSummaryReport_SegmentCancel, "Close the Segment Pop UP");
			}
		}

		if (Code.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthSummaryReport_RelatedAuthorisationLink,
						"Click Related Authorization Link");
				typeText(driver, test, OCR_AuthSummaryReport_RelatedAuthorisationCode, "Enter Code :", Code);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationSearch, "Click Search Button");
				String authcode = "//td[contains(text(),'" + Code + "')]";
				clickElement(driver, test, authcode, "Related Authorization Code :" + Code);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationNoCancel,
						"Close the Authorization No Pop UP");
			}
		}

		if (AuthorizationCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationTypeLink,
						"Click Authorization Type Link");
				typeText(driver, test, OCR_AuthSummaryReport_AuthorizationCode, "Enter Authorization Code :",
						AuthorizationCode);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationSearch, "Click Search Button");
				String authorizationCode = "//td[contains(text(),'" + AuthorizationCode + "')]";
				clickElement(driver, test, authorizationCode, "Authorization Code :" + AuthorizationCode);
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthSummaryReport_AuthorizationCancel,
						"Close the Authorization Type Pop UP");
			}
		}

		if (AgencyCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthSummaryReport_AgencyLink, "Click Agency Link");
				String controllingAgencyCode = "//td[contains(text(),'" + AgencyCode + "')]";
				clickElement(driver, test, controllingAgencyCode, "Controlling Agency Code :" + AgencyCode);
				clickElement(driver, test, OCR_AuthSummaryReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthSummaryReport_AgencyCancel, "Close the Agency Pop UP");
			}
		}

		typeText(driver, test, OCR_AuthSummaryReport_RequestorName, "Enter Requestor Name :", RequestorName);
		typeText(driver, test, OCR_AuthSummaryReport_ReviewerName, "Enter Reviewer Name :", ReviewerName);
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthSummaryReport_FromIssueDate, "Clicking on Issue Date From");
			if (IssueDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date From : ", IssueDateFrom);
				}
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthSummaryReport_ToIssueDate, "Clicking on Issue Date To");
			if (IssueDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date To : ", IssueDateTo);
				}
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthSummaryReport_FromExpireDate, "Clicking on Expiry Date From");
			if (ExpiryDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date From : ", ExpiryDateFrom);
				}
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthSummaryReport_ToExpireDate, "Clicking on Expiry Date To");
			if (ExpiryDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date To : ", ExpiryDateTo);
				}
		}
	}

	// Click on Search Button
	public void click_ReportSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AuthSummaryReport_SearchButton, "Click on Search Button");
	}

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Authorisation Summary Report Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Authorisation Summary Report Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}
	// Enter Search Products
		public void searchAuthorizationSummaryReport(String ReferenceID, String SBUCode, String FolderID, String Status)
				throws InterruptedException {

			typeText(driver, test, OCR_AuthSummaryReport_ReferenceID, "Enter ReferenceID :", ReferenceID);
			selectByVisibleText(driver, test, OCR_AuthSummaryReport_SBUCode, "Select Sbu Code :", SBUCode);
			Wait.waitfor(3);
			typeText(driver, test, OCR_AuthSummaryReport_FolderId, "Enter FolderId :", FolderID);
			selectByVisibleText(driver, test, OCR_AuthSummaryReport_Status, "Select Status :", Status);
		}
}
