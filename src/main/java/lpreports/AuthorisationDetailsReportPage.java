package lpreports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AuthorisationDetailsReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AuthDetailsReport_SBUCode = "//select[@id='authDetailReport_authorisationHeaderValue_sbuCode']";
	public static final String OCR_AuthDetailsReport_ReferenceID = "//input[@name='authorisationHeaderValue.referenceId']";
	public static final String OCR_AuthDetailsReport_Status = "//select[@name='authorisationHeaderValue.status']";
	public static final String OCR_AuthDetailsReport_FolderId = "//input[@name='authorisationHeaderValue.folderId']";
	public static final String OCR_AuthDetailsReport_AuthorizationTypeLink = "//a[contains(text(),'Authorization Type')]";
	public static final String OCR_AuthDetailsReport_AuthorizationCode = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_AuthDetailsReport_AuthorizationSearch = "(//button[@name='Search'])[1]";
	public static final String OCR_AuthDetailsReport_AuthorizationSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_AuthDetailsReport_AuthorizationCancel = "(//button[contains(text(),'Cancel')])[3]";
	public static final String OCR_AuthDetailsReport_AuthorizationNoLink = "//a[contains(text(),'Authorization No')]";
	public static final String OCR_AuthDetailsReport_AuthorizationNo = "//input[@id='resultLicensePopupData_authorisationHeader_authorisationNumber']";
	public static final String OCR_AuthDetailsReport_AuthorizationNoSearch = "//button[@id='searchAuth']";
	public static final String OCR_AuthDetailsReport_AuthorizationNoCancel = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_AuthDetailsReport_AuthGrantCountryName = "//input[@name='nousecountryName']";
	public static final String OCR_AuthDetailsReport_RelatedAuthorisationLink = "//a[contains(text(),'Related Authorization')]";
	public static final String OCR_AuthDetailsReport_RelatedAuthorisationCode = "//input[@id='searchForm_code']";
	public static final String OCR_AuthDetailsReport_AgencyLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Agency')]";
	public static final String OCR_AuthDetailsReport_AgencySelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_AuthDetailsReport_AgencyCancel = "(//button[contains(text(),'Cancel')])[1]";
	public static final String OCR_AuthDetailsReport_ProgramLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Program')]";
	public static final String OCR_AuthDetailsReport_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_AuthDetailsReport_ProgramSearch = "//button[@name='Search']";
	public static final String OCR_AuthDetailsReport_ProgramCancel = "(//button[contains(@name,'cancel')])[2]";
	public static final String OCR_AuthDetailsReport_SegmentLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Segment')]";
	public static final String OCR_AuthDetailsReport_SegmentCancel = "(//button[contains(@name,'cancel')])[1]";
	public static final String OCR_AuthDetailsReport_RequestorName = "//input[@name='authorisationHeaderValue.requestorName']";
	public static final String OCR_AuthDetailsReport_ReviewerName = "//input[@name='authorisationHeaderValue.reviewerName']";
	public static final String OCR_AuthDetailsReport_ReviewSubmitDateFrom = "//input[@name='reviewSubmitDateFrom']";
	public static final String OCR_AuthDetailsReport_ReviewSubmitDateTo = "//input[@name='reviewSubmitDateTo']";
	public static final String OCR_AuthDetailsReport_ReviewCompleteDateFrom = "//input[@name='reviewCompleteDateFrom']";
	public static final String OCR_AuthDetailsReport_ReviewCompleteDateTo = "//input[@name='reviewCompleteDateTo']";
	public static final String OCR_AuthDetailsReport_AppSubmitDateFrom = "//input[@name='submitDateFrom']";
	public static final String OCR_AuthDetailsReport_AppSubmitDateTo = "//input[@name='submitDateTo']";
	public static final String OCR_AuthDetailsReport_FromIssueDate = "//input[@name='fromIssueDate']";
	public static final String OCR_AuthDetailsReport_ToIssueDate = "//input[@name='toIssueDate']";
	public static final String OCR_AuthDetailsReport_FromExpireDate = "//input[@name='fromExpireDate']";
	public static final String OCR_AuthDetailsReport_ToExpireDate = "//input[@name='toExpireDate']";
	public static final String OCR_AuthDetailsReport_Country = "//input[@name='authorisationCountryValue.countryCode']";
	public static final String OCR_AuthDetailsReport_PartNoLink = "//a[contains(text(),'Part No.')]";
	public static final String OCR_AuthDetailsReport_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_AuthDetailsReport_ConsigneeLink = "//label[@class='col-xs-4 control-label']//a[contains(text(),'Consignee')]";
	public static final String OCR_AuthDetailsReport_ConsigneeId = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_AuthDetailsReport_PartDescription = "//input[@id='authDetailReport_authorisationItemValue_description']";
	public static final String OCR_AuthDetailsReport_DomesticPartyLink = "//a[contains(text(),'Domestic Party')]";
	public static final String OCR_AuthDetailsReport_ManufactureCode = "//input[@id='searchForm_userDTO_userCode']";
	public static final String OCR_AuthDetailsReport_SearchButton = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";

	/* ******************** Constructor ***************************** */
	public AuthorisationDetailsReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Search Products
	public void searchAuthorisationDetailsReport(String SBUCode, String ReferenceID, String Status, String FolderID,
			String AuthorizationCode, String AuthorizationNo, String AuthorizationCountry, String Code,
			String AgencyCode, String ProgramCode, String SegmentCode, String RequestorName, String ReviewerName,
			String SubmitReviewDateFrom, String SubmitReviewDateTo, String ReviewCompletedDateFrom,
			String ReviewCompletedDateTo, String ApplicationSubmitDateFrom, String ApplicationSubmitDateTo,
			String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo, String Country,
			String PartNo, String ConsigneeId, String PartDescription, String ManufactureCode)
			throws InterruptedException {

		selectByVisibleText(driver, test, OCR_AuthDetailsReport_SBUCode, "Select Sbu Code :", SBUCode);
		Wait.waitfor(3);
		typeText(driver, test, OCR_AuthDetailsReport_ReferenceID, "Enter the  ReferenceID :", ReferenceID);
		selectByVisibleText(driver, test, OCR_AuthDetailsReport_Status, "Select Status :", Status);
		typeText(driver, test, OCR_AuthDetailsReport_FolderId, "Enter the  FolderId :", FolderID);
		if (AuthorizationCode.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationTypeLink,"Click Authorization Type Link");
			try {
				typeText(driver, test, OCR_AuthDetailsReport_AuthorizationCode, "Enter the  Authorization Code :",AuthorizationCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSearch, "Click Search Button");
				String authorizationCode = "//td[contains(text(),'" + AuthorizationCode + "')]";
				clickElement(driver, test, authorizationCode, "Authorization Code :" + AuthorizationCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationCancel,
						"Close the Authorization Type Pop UP");
			}
		}
		if (AuthorizationNo.length() > 0) {
			typeText(driver, test, OCR_AuthDetailsReport_AuthGrantCountryName, "Enter the  Authorization Country :",AuthorizationCountry);
			clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoLink, "Click Authorization No Link");
			try {
				typeText(driver, test, OCR_AuthDetailsReport_AuthorizationNo, "Enter the  Authorization Code :",AuthorizationNo);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoSearch, "Click Search Button");
				String authorizationNo = "//td[contains(text(),'" + AuthorizationNo + "')]";
				clickElement(driver, test, authorizationNo, "Authorization Code :" + AuthorizationNo);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoCancel,
						"Close the Authorization No Pop UP");
			}
		}
		typeText(driver, test, OCR_AuthDetailsReport_AuthGrantCountryName, "Enter the Authorization Country :",AuthorizationCountry);
		if (Code.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_RelatedAuthorisationLink,
						"Click Related Authorization Link");
				typeText(driver, test, OCR_AuthDetailsReport_RelatedAuthorisationCode, "Enter Code :", Code);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSearch, "Click Search Button");
				String authcode = "//td[contains(text(),'" + Code + "')]";
				clickElement(driver, test, authcode, "Related Authorization Code :" + Code);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoCancel,
						"Close the Authorization No Pop UP");
			}
		}
		if (AgencyCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_AgencyLink, "Click Agency Link");
				String controllingAgencyCode = "//td[contains(text(),'" + AgencyCode + "')]";
				clickElement(driver, test, controllingAgencyCode, "Controlling Agency Code :" + AgencyCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AgencyCancel, "Close the Agency Pop UP");
			}
		}
		if (ProgramCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_ProgramLink, "Click Program Link");
				typeText(driver, test, OCR_AuthDetailsReport_ProgramCode, "Enter the  Program Code :", ProgramCode);
				clickElement(driver, test, OCR_AuthDetailsReport_ProgramSearch, "Click Search Button");
				String programCode = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, programCode, "Program Code :" + ProgramCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_ProgramCancel, "Close the Program Pop UP");
			}
		}
		if (SegmentCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_SegmentLink, "Click Segment Link");
				String segmentCode = "//td[contains(text(),'" + SegmentCode + "')]";
				clickElement(driver, test, segmentCode, "Segment Code :" + SegmentCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AgencySelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_SegmentCancel, "Close the Segment Pop UP");
			}
		}
		typeText(driver, test, OCR_AuthDetailsReport_RequestorName, "Enter the  Requestor Name :", RequestorName);
		typeText(driver, test, OCR_AuthDetailsReport_ReviewerName, "Enter the  Reviewer Name :", ReviewerName);
		if(SubmitReviewDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_ReviewSubmitDateFrom, "Clicking on Submit Review Date From");
			if (SubmitReviewDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Submit Review Date From : ", SubmitReviewDateFrom);
				}
		}
		if(SubmitReviewDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_ReviewSubmitDateTo, "Clicking on Submit Review Date To");
			if (SubmitReviewDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Submit Review Date To : ", SubmitReviewDateTo);
				}
		}
		if(ReviewCompletedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_ReviewCompleteDateFrom, "Clicking on Review Completed Date From");
			if (ReviewCompletedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Completed Date From : ", ReviewCompletedDateFrom);
				}
		}
		if(ReviewCompletedDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_ReviewCompleteDateTo, "Clicking on Review Completed Date To");
			if (ReviewCompletedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Completed Date To : ", ReviewCompletedDateTo);
				}
		}
		if(ApplicationSubmitDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_AppSubmitDateFrom, "Clicking on Application Submit Date From");
			if (ApplicationSubmitDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Application Submit Date From : ", ApplicationSubmitDateFrom);
				}
		}
		if(ApplicationSubmitDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_AppSubmitDateTo, "Clicking on Application Submit Date To");
			if (ApplicationSubmitDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Application Submit Date To : ", ApplicationSubmitDateTo);
				}
		}
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_FromIssueDate, "Clicking on Issue Date From");
			if (IssueDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date From : ", IssueDateFrom);
				}
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_ToIssueDate, "Clicking on Issue Date To");
			if (IssueDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date To : ", IssueDateTo);
				}
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_FromExpireDate, "Clicking on Expiry Date From");
			if (ExpiryDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date From : ", ExpiryDateFrom);
				}
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, OCR_AuthDetailsReport_ToExpireDate, "Clicking on Expiry Date To");
			if (ExpiryDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date To : ", ExpiryDateTo);
				}
		}
		typeText(driver, test, OCR_AuthDetailsReport_Country, "Enter the  Country", Country);
		if (PartNo.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_PartNoLink, "Click Part No Link");
				typeText(driver, test, OCR_AuthDetailsReport_PartNo, "Enter the  PartNo :", PartNo);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSearch, "Click Search Button");
				String partno = "//td[contains(text(),'" + PartNo + "')]";
				clickElement(driver, test, partno, "PartNo :" + PartNo);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoCancel,
						"Close the PartNo Product Pop UP");
			}
		}
		if (ConsigneeId.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_ConsigneeLink, "Click Consignee Link");
				typeText(driver, test, OCR_AuthDetailsReport_ConsigneeId, "Enter the  ConsigneeId :", ConsigneeId);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSearch, "Click Search Button");
				String consignee = "//td[contains(text(),'" + ConsigneeId + "')]";
				clickElement(driver, test, consignee, "ConsigneeId :" + ConsigneeId);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoCancel, "Close the Consignee Pop UP");
			}
		}
		typeText(driver, test, OCR_AuthDetailsReport_PartDescription, "Enter the  Part Description :", PartDescription);
		if (ManufactureCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_AuthDetailsReport_DomesticPartyLink, "Click Domestic Party Link");
				typeText(driver, test, OCR_AuthDetailsReport_ManufactureCode, "Enter the  ManufactureCode :",
						ManufactureCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSearch, "Click Search Button");
				String manufacturecode = "//td[contains(text(),'" + ManufactureCode + "')]";
				clickElement(driver, test, manufacturecode, "ManufactureCode :" + ManufactureCode);
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationSelect, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Agency");
				clickElement(driver, test, OCR_AuthDetailsReport_AuthorizationNoCancel, "Close the Manufacture Pop UP");
			}
		}
	}

	// Click on Search Button
	public void click_ReportSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AuthDetailsReport_SearchButton, "Click on Search Button");
	}

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Authorisation Detail Report Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Authorisation Detail Report Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}
	
	// Enter Search Products
	public void searchAuthorisationDetailsReport(String SBUCode, String ReferenceID, String Status, String FolderID)
			throws InterruptedException {

		selectByVisibleText(driver, test, OCR_AuthDetailsReport_SBUCode, "Select Sbu Code :", SBUCode);
		Wait.waitfor(3);
		typeText(driver, test, OCR_AuthDetailsReport_ReferenceID, "Enter the  ReferenceID :", ReferenceID);
		selectByVisibleText(driver, test, OCR_AuthDetailsReport_Status, "Select Status :", Status);
		typeText(driver, test, OCR_AuthDetailsReport_FolderId, "Enter the  FolderId :", FolderID);
	}

}
