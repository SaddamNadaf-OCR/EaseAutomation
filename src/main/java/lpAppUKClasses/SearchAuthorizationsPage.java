package lpAppUKClasses;

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
	public static final String OCR_SAuth_SearchBtn = "//div[@class='col-xs-8 tp-icons']//button[1]";
	public static final String OCR_SAuth_AuthGrantedByCountry = "//input[@name='authGrantedByCountryName']";
	public static final String OCR_SAuth_AuthType = "//input[@name='authorisationHeader.authorisationType']";
	public static final String OCR_SAuth_Country = "//select[@id='encryptedCountryCode']";
	public static final String OCR_SAuth_SbuCode = "//select[@name='authorisationHeader.sbuCode']";
	public static final String OCR_SAuth_ReferenceID = "//input[@name='authorisationHeader.referenceId']";
	public static final String OCR_SAuth_WlsStatus = "//select[@name='authorisationHeader.dplStatus']";
	public static final String OCR_SAuth_AuthPurpose = "//input[@name='authorisationHeader.authorisationPurpose']";
	public static final String OCR_SAuth_Program = "//input[@name='authorisationHeader.programCode']";
	public static final String OCR_SAuth_Segment = "//input[@name='authorisationHeader.segmentCode']";
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
		selectByVisibleText(driver, test, OCR_SAuth_Status, "Select the status : ", status);
	}

	// Click on Search button
	public void click_SearchBtn() {
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

		typeText(driver, test, OCR_SAuth_AuthGrantedByCountry, "Enter the Authorization Granted by country : ",
				AuthGrantedByCountry);
		typeText(driver, test, OCR_SAuth_AuthType, "Enter the Authorization Type : ", AuthorizationType);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_SAuth_Country, "Select the  Country in common Search : ", CSCountry);
		selectByVisibleText(driver, test, OCR_SAuth_SbuCode, "Select the SBU Code : ", CSSbuCode);
		typeText(driver, test, OCR_SAuth_ReferenceID, "Enter the Reference ID : ", RefereneceID);
		selectByVisibleText(driver, test, OCR_SAuth_Status, "Select the Status : ", Status);
		selectByVisibleText(driver, test, OCR_SAuth_WlsStatus, "Select the WLS Status : ", WlsStatus);
		typeText(driver, test, OCR_SAuth_AuthPurpose, "Enter the Authorization purpose : ", AuthPurpose);
		typeText(driver, test, OCR_SAuth_Program, "Enter the program : ", Program);
		typeText(driver, test, OCR_SAuth_Segment, "Enter the Segment : ", Segment);
		typeText(driver, test, OCR_SAuth_CaseNo, "Enter the Case No : ", CaseNo);
		typeText(driver, test, OCR_SAuth_AuthorizationNo, "Enter the Authorization No : ", AuthorizationNo);
		typeText(driver, test, OCR_SAuth_RequestorName, "Enter the Requestor Name : ", RequestorName);
		typeText(driver, test, OCR_SAuth_ReviewerName, "Enter the Reviewer Name : ", ReviewerName);
		if (ReviewDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_SubmitReviewDateFrom, "click on Submit Review Date From");
			date(driver, test, "Selected on Submit Review Date From : " , ReviewDateFrom);
			test.log(LogStatus.PASS, "Selected on Submit Review Date From : " + ReviewDateFrom);
			clickElement(driver, test, OCR_SAuth_SubmitReviewDateTo, "click on Submit Review Date To");
			date(driver, test, "Selected on Submit Review Date To : " , ReviewDateTo);
		}
		if (ReviewCompletedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ReviewCompletedDateFrom, "click on Review Completed Date From");
			date(driver, test, "Selected on Review Completed Date From : " , ReviewCompletedDateFrom);
			clickElement(driver, test, OCR_SAuth_ReviewCompletedDateTo, "click on Review Completed Date To");
			date(driver, test, "Selected on Review Completed Date To : " , ReviewCompletedDateTo);
		}
		if (ApplctionSubmtDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ApplctionSubmtDateFrom, "click on Applction Submit Date From");
			date(driver, test, "Selected on Applction Submit Date From : " , ApplctionSubmtDateFrom);
			clickElement(driver, test, OCR_SAuth_ApplctionSubmtDateTo, "click on Review Completed Date To");
			date(driver, test, "Selected on Applction Submit Date To : " , ApplctionSubmtDateTo);
		}
		if (IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_IssueDateFrom, "click on Issue Date From");
			date(driver, test, "Selected on Issue Date From : " , IssueDateFrom);
			clickElement(driver, test, OCR_SAuth_IssueDateTo, "click on Issue Date To");
			date(driver, test, "Selected on Issue Date To : " , IssueDateTo);
		}
		if (ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ExpiryDateFrom, "click on Expiry Date From");
			date(driver, test, "Selected on Review Completed Date From : " , ExpiryDateFrom);
			test.log(LogStatus.PASS, "Selected on Review Completed Date From : " + ExpiryDateFrom);
			clickElement(driver, test, OCR_SAuth_ExpiryDateTo, "click on Review Completed Date To");
			date(driver, test, "Selected on Review Completed Date To : " , ExpiryDateTo);
		}
		if (CreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_CreatedDateFrom, "click on Created Date From");
			date(driver, test, "Selected on Created Date From : " , CreatedDateFrom);
			clickElement(driver, test, OCR_SAuth_CreatedDateTo, "click on Created Date To");
			date(driver, test, "Selected on Created Date To : " , CreatedDateTo);
		}
		if (ModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ModifiedDateFrom, "click on Modified Date From");
			date(driver, test, "Selected on Review Completed Date From : " , ModifiedDateFrom);
			clickElement(driver, test, OCR_SAuth_ModifiedDateTo, "click on Review Completed Date To");
			date(driver, test, "Selected on Review Completed Date To : " , ModifiedDateTo);
		}
		typeText(driver, test, OCR_SAuth_CreatedBY, "Enter the CreatedBy : ", CreatedBy);
		typeText(driver, test, OCR_SAuth_ModifiedBy, "Enter the ModifiedBy : ", ModifiedBy);
	}

	// selecting the options in Authorization Details Search Tab
	public void authorizationDetailSearch(String Country, String PartNo, String Consignee, String PartDescription,
			String ApplicantName) {
		typeText(driver, test, OCR_SAuth_AuthDetails_Country, "Enter the Country : ", Country);
		typeText(driver, test, OCR_SAuth__AuthDetails_PartNo, "Enter the PartNo : ", PartNo);
		typeText(driver, test, OCR_SAuth__AuthDetails_Consignee, "Enter the Consignee : ", Consignee);
		typeText(driver, test, OCR_SAuth__AuthDetails_PartDescription, "Enter the Part Description : ",
				PartDescription);
		typeText(driver, test, OCR_SAuth__AuthDetails_ApplicantName, "Enter the Applicant Name : ", ApplicantName);
	}

	// Enter the Reference ID
	public void referenceID(String RefereneceID) {
		typeText(driver, test, OCR_SAuth_ReferenceID, "Enter the Reference ID : ", RefereneceID);
	}

}