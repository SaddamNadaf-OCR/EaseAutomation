package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationsPageUK extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AddAuthz_button = "//button[contains(text(),'Add Authorization')]";
	public static final String OCR_AddNewAuthButton = "//button[contains(text(), 'New')]";
	public static final String OCR_SAuth_Status = "//select[@name='authorisationHeader.status']";
	public static final String OCR_SAuth_SearchBtn = "(//button[@id='mybutton'])[1]";
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
	public static final String OCR_SAuth_AuthorizationNo = "(//input[@name='authorisationHeader.authorisationNumber'])[1]";
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
	public static final String OCR_SAuth_ClickAuthorizationTypeLink = "//a[@id='stdLicenseTypes-popup']";
	public static final String OCR_SAuth_AddAuthorizationType = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_SAuth_ClickOnSearch = "(//button[contains(text(),'Search')])[3]";
	public static final String OCR_SAuth_ClickOnSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_SAuth_ClickOnCloseBtn = "//button[@class='btn-close']";
	public static final String OCR_SAuth_ClickOnAuthorizationPurposeLink = "//a[@id='purposeId']";
	public static final String OCR_SAuth_AddPurposeDescription = "//input[@id='dosSitePopupForm_dosLicensePurposeValue_purposeDescription']";
	public static final String OCR_SAuth_ClickProgramLink = "(//a[contains(text(),'Program')])[3]";
	public static final String OCR_SAuth_AddProgramDescription = "//input[@id='searchForm_programTab_description']";
	public static final String OCR_SAuth_ClickSegmentLink = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_SAuth_ClickAuthorizationNoLink = "//a[@id='licenseNo-Popup']";
	public static final String OCR_SAuth_ClickOnRequestorNameLink = "//a[contains(text(),'Requestor Name')]";
	public static final String OCR_SAuth_AddUserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_SAuth_ClickOnReviewerNameLink = "//a[contains(text(),'Reviewer Name')]";
	public static final String OCR_SAuth_ClickOnCreatedByLink = "//a[contains(text(),'Created By')]";
	public static final String OCR_SAuth_AddUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SAuth_ClickOnModifiedByLink = "//a[contains(text(),'Modified By')]";
	public static final String OCR_SAuth_ClickOnPartNoLink = "//a[contains(text(),'Part No.')]";
	public static final String OCR_SAuth_AddPartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_SAuth_ClickOnConsigneeLink = "(//a[contains(text(),'Consignee')])[3]";
	public static final String OCR_SAuth_AddConsigneeID = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";

	/* ******************** Constructor ***************************** */

	public SearchAuthorizationsPageUK(WebDriver driver, ExtentTest test) {
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

	// Selecting from Template
	public void addfromTemplate(String TemplateName) {
		clickElement(driver, test, OCR_AddAuthz_button, "click on Add Authorization button");
		if (isDisplayed(driver, OCR_AddNewAuthButton)) {
			String templatename = "//td[contains(text(),'" + TemplateName + "')]";
			clickElement(driver, test, templatename, "click on Template name : " + TemplateName);
			clickElement(driver, test, OCR_SAuth__AuthDetails_SelectBtn, "click on Select button");
		}
	}

	// select the Status in common Search
	public void status(String status) {
		selectByVisibleText(driver, test, OCR_SAuth_Status, "Select the status: ", status);
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
		if (AuthorizationType.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickAuthorizationTypeLink, "Click on AuthorizationType Link");
			try {
				typeText(driver, test, OCR_SAuth_AddAuthorizationType, "Add AuthorizationType : ", AuthorizationType);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Type = "//td[contains(text(),'" + AuthorizationType + "')]";
				clickElement(driver, test, Type, "Select the Authorization Type" + AuthorizationType);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add AuthorizationType");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		Wait.waitfor(2);
		if (AuthGrantedByCountry.length() > 0) {
			String country = "(//div[contains(text(),'" + AuthGrantedByCountry + "')])[1]";
			clickElement(driver, test, country, "Click on country : " + AuthGrantedByCountry);
		}
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_SAuth_Country, "Select the Country in common Search : ", CSCountry);
		selectByVisibleText(driver, test, OCR_SAuth_SbuCode, "select the SBU Code : ", CSSbuCode);
		typeText(driver, test, OCR_SAuth_ReferenceID, "Enter the Reference ID : ", RefereneceID);
		selectByVisibleText(driver, test, OCR_SAuth_Status, "select the Status : ", Status);
		selectByVisibleText(driver, test, OCR_SAuth_WlsStatus, "Select the WLS Status : ", WlsStatus);
		Wait.waitfor(2);
		if (AuthPurpose.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnAuthorizationPurposeLink,
					"Click on Authorization Purpose Link");
			try {
				typeText(driver, test, OCR_SAuth_AddPurposeDescription, "Add the AuthorizationPurpose : ", AuthPurpose);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Purpose = "//td[contains(text(),'" + AuthPurpose + "')]";
				clickElement(driver, test, Purpose, "Select the Authorization Purpose" + AuthPurpose);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Authorization Purpose");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		if (Program.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickProgramLink, "Click on AProgram Link");
			try {
				typeText(driver, test, OCR_SAuth_AddProgramDescription, "Enter the Program :", Program);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Pgm = "//td[contains(text(),'" + Program + "')]";
				clickElement(driver, test, Pgm, "Select Program " + Program);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Program");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		if (Segment.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickSegmentLink, "Click on Segment Link");
			try {
				String Seg = "//td[contains(text(),'" + Segment + "')]";
				clickElement(driver, test, Seg, "Select the Segment" + Segment);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Segment");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		typeText(driver, test, OCR_SAuth_CaseNo, "Enter the Case No : ", CaseNo);
		typeText(driver, test, OCR_SAuth_AuthorizationNo, "Enter the Authorization No : ", AuthorizationNo);
		Wait.waitfor(3);
		if (RequestorName.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnRequestorNameLink, "Click on RequestorName Link");
			try {
				typeText(driver, test, OCR_SAuth_AddUserFirstName, "Enter the  Order NO", RequestorName);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Req = "//td[contains(text(),'" + RequestorName + "')]";
				clickElement(driver, test, Req, "Select Program " + RequestorName);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Requestor Name");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		if (ReviewerName.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnReviewerNameLink, "Click on Reviewer Name Link");
			try {
				typeText(driver, test, OCR_SAuth_AddUserFirstName, "Enter the  Order NO", ReviewerName);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Rev = "//td[contains(text(),'" + ReviewerName + "')]";
				clickElement(driver, test, Rev, "Select Program " + ReviewerName);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Reviewer Name");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
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
		if (CreatedBy.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnCreatedByLink, "Click on Created By Link");
			try {
				typeText(driver, test, OCR_SAuth_AddUser, "Add Order NO", CreatedBy);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Crt = "//td[contains(text(),'" + CreatedBy + "')]";
				clickElement(driver, test, Crt, "Select user" + CreatedBy);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Created By");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		if (ModifiedBy.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnModifiedByLink, "Click on Modified By Link");
			try {
				typeText(driver, test, OCR_SAuth_AddUserFirstName, "Enter the  Order NO", ModifiedBy);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Mod = "//td[contains(text(),'" + ModifiedBy + "')]";
				clickElement(driver, test, Mod, "Select user" + ModifiedBy);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Modified By");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
	}

	// selecting the options in Authorization Details Search Tab
	public void authorizationDetailSearch(String Country, String PartNo, String Consignee, String PartDescription,
			String ApplicantName) {
		typeText(driver, test, OCR_SAuth_AuthDetails_Country, "Enter the Country : ", Country);

		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnPartNoLink, "Click on Part No Link");
			try {
				typeText(driver, test, OCR_SAuth_AddPartNo, "Enter the  Order NO", PartNo);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Prt = "//td[contains(text(),'" + PartNo + "')]";
				clickElement(driver, test, Prt, "Select user" + PartNo);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Part No");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		if (Consignee.length() > 0) {
			clickElement(driver, test, OCR_SAuth_ClickOnConsigneeLink, "Click on Consignee Link");
			try {
				typeText(driver, test, OCR_SAuth_AddConsigneeID, "Enter the  Consignee NO", Consignee);
				clickElement(driver, test, OCR_SAuth_ClickOnSearch, "Click On Search");
				String Con = "//td[contains(text(),'" + Consignee + "')]";
				clickElement(driver, test, Con, "Select user" + Consignee);
				clickElement(driver, test, OCR_SAuth_ClickOnSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Consignee");
				clickElement(driver, test, OCR_SAuth_ClickOnCloseBtn, "Click on Close");
			}
		}
		typeText(driver, test, OCR_SAuth__AuthDetails_PartDescription, "Enter the Part Description : ",
				PartDescription);
		typeText(driver, test, OCR_SAuth__AuthDetails_ApplicantName, "Enter the Applicant Name : ", ApplicantName);
	}

	// Enter the Reference ID
	public void referenceID(String RefereneceID) {
		typeText(driver, test, OCR_SAuth_ReferenceID, "Enter the Reference ID : ", RefereneceID);
	}

}