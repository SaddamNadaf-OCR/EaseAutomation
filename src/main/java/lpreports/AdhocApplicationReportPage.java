package lpreports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AdhocApplicationReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AdhocReport_SBUCode = "//select[@id='resultAdhocApplReport_authorisationHeaderValue_sbuCode']";
	public static final String OCR_AdhocReport_ReferenceID = "//input[@name='authorisationHeaderValue.referenceId']";
	public static final String OCR_AdhocReport_AuthorizationNo = "//a[@id='licenseNo-Popup']";
	public static final String OCR_AdhocReport_Agency = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Agency')]";
	public static final String OCR_AdhocReport_AgencySelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_AdhocReport_AgencyCancel = "(//button[contains(text(),'Cancel')])[1]";
	public static final String OCR_AdhocReport_AuthGrantCountryName = "//input[@id='resultAdhocApplReport_authGrantCountryName']";
	public static final String OCR_AdhocReport_Program = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Program')]";
	public static final String OCR_AdhocReport_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_AdhocReport_ProgramSearch = "//button[@name='Search']";
	public static final String OCR_AdhocReport_ProgramCancel = "(//button[contains(@name,'cancel')])[2]";
	public static final String OCR_AdhocReport_RelatedAuthorisation = "//input[@name='authorisationHeaderValue.relatedAuthorisation']";
	public static final String OCR_AdhocReport_PrimaryApplicant = "//a[contains(text(),'Primary Applicant')]";
	public static final String OCR_AdhocReport_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_AdhocReport_Segment = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Segment')]";
	public static final String OCR_AdhocReport_Role = "//select[@name='authorisationAggValue.licAddrrole']";
	public static final String OCR_AdhocReport_RequestorName = "//a[contains(text(),'Requestor Name')]";
	public static final String OCR_AdhocReport_UserEmailid = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR_AdhocReport_DateInitiatedFrom = "//input[@name='dateInitiatedFrom']";
	public static final String OCR_AdhocReport_DateInitiatedTo = "//input[@name='dateInitiatedTo']";
	public static final String OCR_AdhocReport_FromIssueDate = "//input[@name='fromIssueDate']";
	public static final String OCR_AdhocReport_ToIssueDate = "//input[@name='toIssueDate']";
	public static final String OCR_AdhocReport_SubmitDateFrom = "//input[@name='submitDateFrom']";
	public static final String OCR_AdhocReport_SubmitDateTo = "//input[@name='submitDateTo']";
	public static final String OCR_AdhocReport_FromExpireDate = "//input[@name='fromExpireDate']";
	public static final String OCR_AdhocReport_ToExpireDate = "//input[@name='toExpireDate']";
	public static final String OCR_AdhocReport_SearchButton = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";

	/* ******************** Constructor ***************************** */
	public AdhocApplicationReportPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Search Products
	public void searchAdhocApplicationReport(String SBUCode, String ReferenceID, String AuthorizationType,
			String Status, String AuthorizationNo, String AuthorizationCountry, String AgencyCode, String ProgramCode,
			String RelatedAuthorisation, String ExporterCode, String SegmentCode, String Role, String UserEmailId,
			String DateInitiatedFrom, String DateInitiatedTo, String IssueDateFrom, String IssueDateTo,
			String DateSubmitFrom, String DateSubmitTo, String ExpiryDateFrom, String ExpiryDateTo)
			throws InterruptedException {

		selectByVisibleText(driver, test, OCR_AdhocReport_SBUCode, "Select Sbu Code :", SBUCode);
		Wait.waitfor(3);
		typeText(driver, test, OCR_AdhocReport_ReferenceID, "Enter the ReferenceID :", ReferenceID);
		if (AuthorizationType.length() > 0) {
			String authType = "//option[contains(text(),'" + AuthorizationType + "')]";
			clickElement(driver, test, authType, "Click Authorization Type :" + AuthorizationType);
		}
		if (Status.length() > 0) {
			String status = "//option[contains(text(),'" + Status + "')]";
			clickElement(driver, test, status, "Click Status Type :" + Status);
		}
		if (AgencyCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AdhocReport_Agency, "Click Agency Link");
				String controllingAgencyCode = "//td[contains(text(),'" + AgencyCode + "')]";
				clickElement(driver, test, controllingAgencyCode, "Controlling Agency Code :" + AgencyCode);
				clickElement(driver, test, OCR_AdhocReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AdhocReport_AgencyCancel, "Close the Agency Pop UP");
			}
		}
		typeText(driver, test, OCR_AdhocReport_AuthGrantCountryName, "Enter the ReferenceID :", AuthorizationCountry);
		if (ProgramCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AdhocReport_Program, "Click Program Link");
				typeText(driver, test, OCR_AdhocReport_ProgramCode, "Enter Program Code :", ProgramCode);
				clickElement(driver, test, OCR_AdhocReport_ProgramSearch, "Click Search Button");
				String programCode = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, programCode, "Program Code :" + ProgramCode);
				clickElement(driver, test, OCR_AdhocReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AdhocReport_ProgramCancel, "Close the Program Pop UP");
			}
		}
		typeText(driver, test, OCR_AdhocReport_RelatedAuthorisation, "Enter the Related Authorisation :",
				RelatedAuthorisation);
		if (ExporterCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AdhocReport_PrimaryApplicant, "Click Primary Applicant Link");
				typeText(driver, test, OCR_AdhocReport_ExporterCode, "Enter the Exporter Code :", ExporterCode);
				clickElement(driver, test, OCR_AdhocReport_ProgramSearch, "Click Search Button");
				String programCode = "//td[contains(text(),'" + ExporterCode + "')]";
				clickElement(driver, test, programCode, "Exporter Code :" + ExporterCode);
				clickElement(driver, test, OCR_AdhocReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AdhocReport_ProgramCancel, "Close the Exporter Pop UP");
			}
		}
		if (SegmentCode.length() > 0) {
			try {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_AdhocReport_Segment, "Click Segment Link");
				String segmentCode = "//td[contains(text(),'" + SegmentCode + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_segmentCode'])[1]", "Segment Code :" + SegmentCode);
				clickElement(driver, test, OCR_AdhocReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AdhocReport_AgencyCancel, "Close the Segment Pop UP");
			}
		}
		typeText(driver, test, OCR_AdhocReport_Role, "Enter the Role :", Role);
		if (UserEmailId.length() > 0) {
			try {
				clickElement(driver, test, OCR_AdhocReport_RequestorName, "Click Requestor Name Link");
				typeText(driver, test, OCR_AdhocReport_UserEmailid, "Enter the User EmailId :", UserEmailId);
				clickElement(driver, test, OCR_AdhocReport_ProgramSearch, "Click Search Button");
				String email = "//tr[@id='1']//td[contains(text(),'" + UserEmailId + "')]";
				clickElement(driver, test, email, "Email Id :" + UserEmailId);
				clickElement(driver, test, OCR_AdhocReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AdhocReport_ProgramCancel, "Close the User Pop UP");
			}
		}
		if(DateInitiatedFrom.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_DateInitiatedFrom, "Clicking on Date Initiated From");
			if (DateInitiatedFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Date Initiated From : ", DateInitiatedFrom);
				}
		}
		if(DateInitiatedTo.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_DateInitiatedTo, "Clicking on Date Initiated To");
			if (DateInitiatedTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Date Initiated To : ", DateInitiatedTo);
				}
		}
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_FromIssueDate, "Clicking on Issue Date From");
			if (IssueDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date From : ", IssueDateFrom);
				}
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_ToIssueDate, "Clicking on Issue Date To");
			if (IssueDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date To : ", IssueDateTo);
				}
		}
		if(DateSubmitFrom.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_SubmitDateFrom, "Clicking on Date Submit From");
			if (DateSubmitFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Date Submit From : ", DateSubmitFrom);
				}
		}
		if(DateSubmitTo.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_SubmitDateTo, "Clicking on Date Submit To");
			if (DateSubmitTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Date Submit To : ", DateSubmitTo);
				}
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_FromExpireDate, "Clicking on Expiry Date From");
			if (ExpiryDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date From : ", ExpiryDateFrom);
				}
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_ToExpireDate, "Clicking on Expiry Date To");
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
		clickElement(driver, test, OCR_AdhocReport_SearchButton, "Click on Search Button");
	}

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Adhoc Application Report Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Adhoc Application Report Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}
	// Enter Search Products
		public void searchAdhocApplicationReport(String SBUCode, String ReferenceID, String AuthorizationType,
				String Status) throws InterruptedException {

			selectByVisibleText(driver, test, OCR_AdhocReport_SBUCode, "Select Sbu Code :", SBUCode);
			Wait.waitfor(3);
			typeText(driver, test, OCR_AdhocReport_ReferenceID, "Enter the ReferenceID :", ReferenceID);
			if (AuthorizationType.length() > 0) {
				String authType = "//option[contains(text(),'" + AuthorizationType + "')]";
				clickElement(driver, test, authType, "Click Authorization Type :" + AuthorizationType);
			}
			if (Status.length() > 0) {
				String status = "//option[contains(text(),'" + Status + "')]";
				clickElement(driver, test, status, "Click Status Type :" + Status);
			}
		}
}
