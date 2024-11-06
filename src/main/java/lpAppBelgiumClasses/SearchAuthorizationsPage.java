package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddAuthz_button = "//button[contains(text(),'Add Authorization')]";
	public static final String OCR_AddNewAuthButton = "//button[contains(text(), 'New')]";
	public static final String OCR_SAuth_Status = "//select[@name='authorisationHeader.status']";
	public static final String OCR_SAuth_SearchBtn = "(//button[@name='Search'])[1]";
	public static final String OCR_SAuth_AuthGrantedByCountry = "//input[@name='authGrantedByCountryName']";
	public static final String OCR_SAuth_AuthType = "//input[@name='authorisationHeader.authorisationType']";
	public static final String OCR_SAuth_Country = "//select[@id='encryptedCountryCode']";
	public static final String OCR_SAuth_SbuCode = "//select[@name='authorisationHeader.sbuCode']";
	public static final String OCR_SAuth_ReferenceID = "//input[@name='authorisationHeader.referenceId']";
	public static final String OCR_SAuth_WlsStatus = "//select[@name='authorisationHeader.dplStatus']";
	public static final String OCR_SAuth_AuthPurpose = "//input[@name='authorisationHeader.authorisationPurpose']";
	public static final String OCR_SAuth_Program = "//textarea[@id='searchAuthorisation_authorisationHeader_programCode']";
	public static final String OCR_SAuth_Segment = "//textarea[@id='searchAuthorisation_authorisationHeader_segmentCode']";
	public static final String OCR_SAuth_CaseNo = "//input[@name='authorisationHeader.caseNumber']";
	public static final String OCR_SAuth_AuthorizationNo = "//input[@name='authorisationHeader.authorisationNumber']";
	public static final String OCR_SAuth_RequestorName = "//input[@name='authorisationHeader.requestorName']";
	public static final String OCR_SAuth_ReviewerName = "//input[@name='authorisationHeader.reviewerName']";
	public static final String OCR_SAuth_SubmitReviewDateFrom = "//input[@name='reviewSubmitDateFrom']";
	public static final String OCR_SAuth_SubmitReviewDateTo = "//input[@name='reviewSubmitDateTo']";
	public static final String OCR_SAuth_ReviewCompletedDateFrom = "//input[@name='reviewCompleteDateFrom']";
	public static final String OCR_SAuth_ReviewCompletedDateTo = "//input[@name='reviewCompleteDateTo']";
	public static final String OCR_SAuth_ApplctionSubmtDateFrom = "//input[@name='submitDateFrom']";
	public static final String OCR_SAuth_ApplctionSubmtDateTo = "//input[@name='submitDateTo']";
	public static final String OCR_SAuth_IssueDateFrom = "//input[@name='issueDateFrom']";
	public static final String OCR_SAuth_IssueDateTo = "//input[@name='issueDateTo']";
	public static final String OCR_SAuth_ExpiryDateFrom = "//input[@name='expiryDateFrom']";
	public static final String OCR_SAuth_ExpiryDateTo = "//input[@name='expiryDateTo']";
	public static final String OCR_SAuth_CreatedDateFrom = "//input[@name='createdDateFrom']";
	public static final String OCR_SAuth_CreatedDateTo = "//input[@name='createdDateTo']";
	public static final String OCR_SAuth_ModifiedDateFrom = "//input[@name='modifiedDateFrom']";
	public static final String OCR_SAuth_ModifiedDateTo = "//input[@name='modifiedDateTo']";
	public static final String OCR_SAuth_CreatedBY = "//input[@name='authorisationHeader.createdBy']";
	public static final String OCR_SAuth_ModifiedBy = "//input[@name='authorisationHeader.modifiedBy']";
	public static final String OCR_SAuth_AuthDetails_Country = "//input[@name='authorisationCountryName']";
	public static final String OCR_SAuth__AuthDetails_PartNo = "//input[@name='authorisationItem.partNo']";
	public static final String OCR_SAuth__AuthDetails_Consignee = "//input[@name='authorisationConsignee.licConsName']";
	public static final String OCR_SAuth__AuthDetails_PartDescription = "//input[@id='searchAuthorisation_"
			+ "authorisationItem_description']";
	public static final String OCR_SAuth__AuthDetails_ApplicantName = "//input[@id='applicant_id']";
	public static final String OCR_SAuth__AuthDetails_SelectBtn = "//div[@id='resultDIV']//button[1]";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";

	/* ******************** Constructor ***************************** */

	public SearchAuthorizationsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click on Add Authorization button
	public void click_AddAuthorization() {
		clickElement(driver, test, OCR_AddAuthz_button, "click on Add Authorization button");
		try {
			if (isDisplayed(driver, OCR_AddNewAuthButton)) {
				clickElement(driver, test, OCR_AddNewAuthButton, "Click on New Button in Add template");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "ADD from template is Disable");
		}
	}

	//Selecting from Template
	public void addfromTemplate(String TemplateName) {
		clickElement(driver, test, OCR_AddAuthz_button, "click on Add Authorization button");
		if (isDisplayed(driver, OCR_AddNewAuthButton)) {
			String templatename = "//td[contains(text(),'"+TemplateName+"')]";
			clickElement(driver, test, templatename, "click on Template name : "+TemplateName);
			clickElement(driver, test, OCR_SAuth__AuthDetails_SelectBtn, "click on Select button");
		}
	}

	// select the Status in common Search
	public void status(String status) {
		selectByVisibleText(driver, test, OCR_SAuth_Status, "Select : ", status);
	}

	// Click on Search button
	public void click_SearchBtn() {
		scrollToElement(driver, OCR_SAuth_SearchBtn);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SAuth_SearchBtn, "click on Search Button");
	}

	// selecting the options in Common Search tab
	public void commonSearch(String AuthGrantedByCountry, String AuthorizationType, String CSCountry, String CSSbuCode,
			String RefereneceID, String Status, String WlsStatus, String AuthPurpose, String Program, String Segment,
			String CaseNo, String AuthorizationNo, String RequestorName, String ReviewerName, String ReviewDateFrom,
			String ReviewDateTo, String ReviewCompletedDateFrom, String ReviewCompletedDateTo,
			String ApplctionSubmtDateFrom, String ApplctionSubmtDateTo, String IssueDateFrom, String IssueDateTo,
			String ExpiryDateFrom, String ExpiryDateTo, String CreatedDateFrom, String CreatedDateTo,
			String ModifiedDateFrom, String ModifiedDateTo, String CreatedBy, String ModifiedBy) {

		typeText(driver, test, OCR_SAuth_AuthGrantedByCountry, "Enter Authorization Granted by country : ",
				AuthGrantedByCountry);
		typeText(driver, test, OCR_SAuth_AuthType, "Enter Authorization Type : ", AuthorizationType);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_SAuth_Country, "Select Country in common Search : ", CSCountry);
		selectByVisibleText(driver, test, OCR_SAuth_SbuCode, "select the SBU Code : ", CSSbuCode);
		typeText(driver, test, OCR_SAuth_ReferenceID, "Enter the Reference ID : ", RefereneceID);
		selectByVisibleText(driver, test, OCR_SAuth_Status, "select Status : ", Status);
		selectByVisibleText(driver, test, OCR_SAuth_WlsStatus, "Select the WLS Status : ", WlsStatus);
		typeText(driver, test, OCR_SAuth_AuthPurpose, "Enter Authorization purpose : ", AuthPurpose);
		typeText(driver, test, OCR_SAuth_Program, "Enter program : ", Program);
		typeText(driver, test, OCR_SAuth_Segment, "Enter Segment : ", Segment);
		typeText(driver, test, OCR_SAuth_CaseNo, "Enter Case No : ", CaseNo);
		typeText(driver, test, OCR_SAuth_AuthorizationNo, "Enter Authorization No : ", AuthorizationNo);
		typeText(driver, test, OCR_SAuth_RequestorName, "Enter Requestor Name : ", RequestorName);
		typeText(driver, test, OCR_SAuth_ReviewerName, "Enter Reviewer Name : ", ReviewerName);
		if(ReviewDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_SubmitReviewDateFrom, "Clicking on Review Date From");
			if (ReviewDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Date From : ", ReviewDateFrom);
				}
		}
		if(ReviewDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_SubmitReviewDateTo, "Clicking on Review Date To");
			if (ReviewDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Date To : ", ReviewDateTo);
				}
		}
		if(ReviewCompletedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ReviewCompletedDateFrom, "Clicking on Review Completed Date From");
			if (ReviewCompletedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Completed Date From : ", ReviewCompletedDateFrom);
				}
		}
		if(ReviewCompletedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ReviewCompletedDateTo, "Clicking on Review Completed Date To");
			if (ReviewCompletedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Completed Date To : ", ReviewCompletedDateTo);
				}
		}
		if(ApplctionSubmtDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ApplctionSubmtDateFrom, "Clicking on Applction Submit Date From");
			if (ApplctionSubmtDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Applction Submit Date From : ", ApplctionSubmtDateFrom);
				}
		}
		if(ApplctionSubmtDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ApplctionSubmtDateTo, "Clicking on Applction Submit Date To");
			if (ApplctionSubmtDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Applction Submit Date To : ", ApplctionSubmtDateTo);
				}
		}
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_IssueDateFrom, "Clicking on Issue Date From");
			if (IssueDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date From : ", IssueDateFrom);
				}
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_IssueDateTo, "Clicking on Issue Date To");
			if (IssueDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Issue Date To : ", IssueDateTo);
				}
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ExpiryDateFrom, "Clicking on Expiry Date From");
			if (ExpiryDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date From : ", ExpiryDateFrom);
				}
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ExpiryDateTo, "Clicking on Expiry Date To");
			if (ExpiryDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Expiry Date To : ", ExpiryDateTo);
				}
		}
		if(CreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_CreatedDateFrom, "Clicking on Created Date From");
			if (CreatedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Created Date From : ", CreatedDateFrom);
				}
		}
		if(CreatedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_CreatedDateTo, "Clicking on Created Date To");
			if (CreatedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Created Date To : ", CreatedDateTo);
				}
		}
		if(ModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ModifiedDateFrom, "Clicking on Modified Date From");
			if (ModifiedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Modified Date From : ", ModifiedDateFrom);
				}
		}
		if(ModifiedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ModifiedDateTo, "Clicking on Modified Date To");
			if (ModifiedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Modified Date To : ", ModifiedDateTo);
				}
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_SAuth_CreatedBY, "Enter CreatedBy : ", CreatedBy);
		typeText(driver, test, OCR_SAuth_ModifiedBy, "Enter ModifiedBy : ", ModifiedBy);
	}

	// selecting the options in Authorization Details Search Tab
	public void authorizationDetailSearch(String Country, String PartNo, String Consignee, String PartDescription,
			String ApplicantName) {
		scrollToBottom(driver);
		scrollToElement(driver,OCR_SAuth_ModifiedBy);
		typeText(driver, test, OCR_SAuth_AuthDetails_Country, "Enter the Country : ", Country);
		typeText(driver, test, OCR_SAuth__AuthDetails_PartNo, "Enter the PartNo : ", PartNo);
		typeText(driver, test, OCR_SAuth__AuthDetails_Consignee, "Enter Consignee : ", Consignee);
		typeText(driver, test, OCR_SAuth__AuthDetails_PartDescription, "Enter the Part Description : ",
				PartDescription);
		typeText(driver, test, OCR_SAuth__AuthDetails_ApplicantName, "Enter the Applicant Name : ", ApplicantName);
	}

	// Enter the Reference ID
	public void referenceID(String RefereneceID) {
		typeText(driver, test, OCR_SAuth_ReferenceID, "Enter the Reference ID : ", RefereneceID);
	}

}