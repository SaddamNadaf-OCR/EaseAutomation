package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class NrcAdhocApplicationReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AdhocReport_SBUCode = "//select[@id='resultAdhocNrcSearch_dosGeneralInfo_sbuCode']";
	public static final String OCR_AdhocReport_TransactionIdPopup = "//a[@id='transactionPopup']";
	public static final String OCR_AdhocReport_TransactionId = "//input[@id='searchForm_dosGeneralInfoDTO_transactionId']";
	public static final String OCR_AdhocReport_TransactionSearch = "//button[@name='Search']";
	public static final String OCR_AdhocReport_TransactionSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_AdhocReport_Status = "//select[@id='resultAdhocNrcSearch_status']";
	public static final String OCR__AdhocReport_TypeAction = "//select[@id='resultAdhocNrcSearch_typeOfAction']";
	public static final String OCR_AdhocReport_ContractNoPopup = "//a[contains(text(),'Contract No')]";
	public static final String OCR_AdhocReport_ContractNo = "//a[contains(text(),'Contract No')]";
	public static final String OCR_AdhocReport_ContractSearch = "//button[@name='Search']";
	public static final String OCR_AdhocReport_ContractSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR__AdhocReport_PoaNamePoup = "//a[contains(text(),'POA Name')]";
	public static final String OCR__AdhocReport_PoaEmail = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR__AdhocReport_ProgramPoup = "(//a[contains(text(),'Program')])[2]";
	public static final String OCR__AdhocReport_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR__AdhocReport_ProgramSearch = "//button[@name='Search']";
	public static final String OCR_AdhocReport_SegmentPopup = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR__AdhocReport_SitePoup = "(//a[contains(text(),'Site')])[2]";
	public static final String OCR__AdhocReport_SiteName = "//input[@id='dosSitePopupForm_dosSite_siteName']";
	public static final String OCR__AdhocReport_DepartmentPoup = "(//a[contains(text(),'Department')])[2]";
	public static final String OCR__AdhocReport_RequestorPoup = "//a[contains(text(),'Requestor')]";
	public static final String OCR__AdhocReport_RequestorEmail = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR__AdhocReport_ReviewerPoup = "(//a[contains(text(),'Reviewer')])[2]";
	public static final String OCR__AdhocReport_ReviewerEmail = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR__AdhocReport_Notes = "//textarea[@id='resultAdhocNrcSearch_dosSecureNotes_secureNotes']";
	public static final String OCR__AdhocReport_ConsigneePoup = "(//a[contains(text(),'Consignee')])[3]";
	public static final String OCR__AdhocReport_ConsigneeId = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR__AdhocReport_DateInitiatedFrom = "//input[@name='fromDateInitiated']";
	public static final String OCR__AdhocReport_DateInitiatedTo = "//input[@name='toDateInitiated']";
	public static final String OCR__AdhocReport_DateUsgFrom = "//input[@name='fromDateSubmitted']";
	public static final String OCR__AdhocReport_DateUsgTo = "//input[@name='toDateSubmitted']";
	public static final String OCR__AdhocReport_IssueDateFrom = "//input[@name='fromIssueDate']";
	public static final String OCR__AdhocReport_IssueDateTo = "//input[@name='toIssueDate']";
	public static final String OCR__AdhocReport_ExpiryDateFrom = "//input[@name='fromExpiryDate']";
	public static final String OCR__AdhocReport_ExpiryDateTo = "//input[@name='toExpiryDate']";
	public static final String OCR__AdhocReport_SortBy = "(//select[contains(@name,'sortBy')])[1]";
	public static final String OCR__AdhocReport_Direction = "(//select[contains(@name,'direction')])[1]";
	public static final String OCR__AdhocReport_PopupClose = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR__AdhocReport_SearchButton = "//button[contains(text(),'Search')]";

	/* ******************** Constructor ***************************** */
	public NrcAdhocApplicationReportPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void nrcAdhocSearch(String SBUCode, String TransactionId, String Status, String TypeOfAction,
			String ContractNo, String PoaEmailId, String ProgramCode, String SegmentName, String SiteName,
			String Department, String RequestorEmailId, String ReviewerEmailId, String Notes, String ConsigneeId,
			String DateInitiatedFrom, String DateInitiatedTo, String DateUsgFrom, String DateUsgTo,
			String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo, String SortBy,
			String Direction) {

		selectByVisibleText(driver, test, OCR_AdhocReport_SBUCode, "Select SBU Code ", SBUCode);

		if (TransactionId.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_TransactionIdPopup, "Click TransactionId Popup");
			try {
				typeText(driver, test, OCR_AdhocReport_TransactionId, "Enter Transaction Id ", TransactionId);
				clickElement(driver, test, OCR_AdhocReport_TransactionSearch, "Click on Search Button");
				String trans = "//td[contains(text(),'" + TransactionId + "')]";
				clickElement(driver, test, trans, "Click Transaction Id :" + TransactionId);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Transaction Id");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR_AdhocReport_Status, "Select Status ", Status);
		selectByVisibleText(driver, test, OCR__AdhocReport_TypeAction, "Select Type of Action ", TypeOfAction);

		if (ContractNo.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_ContractNoPopup, "Click Contract No Popup");
			try {
				typeText(driver, test, OCR_AdhocReport_ContractNo, "Enter Contract No ", ContractNo);
				clickElement(driver, test, OCR_AdhocReport_ContractSearch, "Click on Search Button");
				String contract = "//td[contains(text(),'" + ContractNo + "')]";
				clickElement(driver, test, contract, "Click on ContractNo :" + ContractNo);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add ContractNo");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (PoaEmailId.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_PoaNamePoup, "Click POA Name Popup");
			try {
				typeText(driver, test, OCR__AdhocReport_PoaEmail, "Enter Poa EmailId ", PoaEmailId);
				clickElement(driver, test, OCR_AdhocReport_ContractSearch, "Click on Search Button");
				String poa = "//td[contains(text(),'" + PoaEmailId + "')]";
				clickElement(driver, test, poa, "Click Poa EmailId :" + PoaEmailId);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Poa Email");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (ProgramCode.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_ProgramPoup, "Click Program Popup");
			try {
				typeText(driver, test, OCR__AdhocReport_ProgramCode, "Enter Program Code ", ProgramCode);
				clickElement(driver, test, OCR__AdhocReport_ProgramSearch, "Click on Search Button");
				String prgrm = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, prgrm, "Click Program Code :" + ProgramCode);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Program Code");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (SegmentName.length() > 0) {
			clickElement(driver, test, OCR_AdhocReport_SegmentPopup, "Click Segment Popup");
			try {
				String segment = "//td[contains(text(),'" + SegmentName + "')]";
				clickElement(driver, test, segment, "Click on SegmentName :" + SegmentName);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Segment");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (SiteName.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_SitePoup, "Click Site Popup");
			try {
				typeText(driver, test, OCR__AdhocReport_SiteName, "Enter Site Name ", SiteName);
				clickElement(driver, test, OCR__AdhocReport_ProgramSearch, "Click on Search Button");
				String site = "//td[contains(text(),'" + SiteName + "')]";
				clickElement(driver, test, site, "Click Site Name :" + SiteName);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Site Name");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (Department.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_DepartmentPoup, "Click Segment Popup");
			try {
				String segment = "//td[contains(text(),'" + Department + "')]";
				clickElement(driver, test, segment, "Click on Department :" + Department);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Department");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (RequestorEmailId.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_RequestorPoup, "Click Requestor Popup");
			try {
				typeText(driver, test, OCR__AdhocReport_RequestorEmail, "Enter Requestor Email ", RequestorEmailId);
				clickElement(driver, test, OCR__AdhocReport_ProgramSearch, "Click on Search Button");
				String reqstor = "//td[contains(text(),'" + RequestorEmailId + "')]";
				clickElement(driver, test, reqstor, "Click Requestor Email :" + RequestorEmailId);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Requestor Email Id");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (ReviewerEmailId.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_ReviewerPoup, "Click Reviewer Popup");
			try {
				typeText(driver, test, OCR__AdhocReport_ReviewerEmail, "Enter Reviewer Email ", ReviewerEmailId);
				clickElement(driver, test, OCR__AdhocReport_ProgramSearch, "Click on Search Button");
				String review = "//td[contains(text(),'" + ReviewerEmailId + "')]";
				clickElement(driver, test, review, "Click Reviewer Email :" + ReviewerEmailId);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Reviewer Email Id");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		typeText(driver, test, OCR__AdhocReport_Notes, "Enter Notes ", Notes);

		if (ConsigneeId.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_ConsigneePoup, "Click Reviewer Popup");
			try {
				typeText(driver, test, OCR__AdhocReport_ConsigneeId, "Enter Reviewer Email ", ConsigneeId);
				clickElement(driver, test, OCR__AdhocReport_ProgramSearch, "Click on Search Button");
				String consigne = "//td[contains(text(),'" + ConsigneeId + "')]";
				clickElement(driver, test, consigne, "Click ConsigneeId :" + ConsigneeId);
				clickElement(driver, test, OCR_AdhocReport_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add ConsigneeId");
				clickElement(driver, test, OCR__AdhocReport_PopupClose, "Close the Pop UP");
			}
		}

		if (DateInitiatedFrom.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_DateInitiatedFrom, "Click on Date Initiated From");
			date(driver, test, "Selected on Date Initiated From : ", DateInitiatedFrom);
			test.log(LogStatus.PASS, "Selected on Date Initiated From : " + DateInitiatedFrom);
			clickElement(driver, test, OCR__AdhocReport_DateInitiatedTo, "Click on Date Initiated To");
			date(driver, test, "Selected on Date Initiated To : ", DateInitiatedTo);
			test.log(LogStatus.PASS, "Selected on Date Initiated To : " + DateInitiatedTo);
		}

		if (DateUsgFrom.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_DateUsgFrom, "Click on Date Usg From");
			date(driver, test, "Selected on Date Usg From : ", DateUsgFrom);
			test.log(LogStatus.PASS, "Selected on Date Usg From : " + DateUsgFrom);
			clickElement(driver, test, OCR__AdhocReport_DateUsgTo, "Click on Date Usg To");
			date(driver, test, "Selected on Date Usg To : ", DateUsgTo);
			test.log(LogStatus.PASS, "Selected on Date Usg To : " + DateUsgTo);
		}

		if (IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_IssueDateFrom, "Click on Issue Date From");
			date(driver, test, "Selected on Issue Date From : ", IssueDateFrom);
			test.log(LogStatus.PASS, "Selected on Issue Date From : " + IssueDateFrom);
			clickElement(driver, test, OCR__AdhocReport_IssueDateTo, "Click on Issue Date To");
			date(driver, test, "Selected on Issue Date To : ", IssueDateTo);
			test.log(LogStatus.PASS, "Selected on Issue Date To : " + IssueDateTo);
		}

		if (ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR__AdhocReport_ExpiryDateFrom, "Click on Expiry Date From");
			date(driver, test, "Selected on Expiry Date From : ", ExpiryDateFrom);
			test.log(LogStatus.PASS, "Selected on Expiry Date From : " + ExpiryDateFrom);
			clickElement(driver, test, OCR__AdhocReport_ExpiryDateTo, "Click on Expiry Date To");
			date(driver, test, "Selected on Expiry Date To : ", ExpiryDateTo);
			test.log(LogStatus.PASS, "Selected on Expiry Date To : " + ExpiryDateTo);
		}

		selectByVisibleText(driver, test, OCR__AdhocReport_SortBy, "Select SortBy ", SortBy);
		selectByVisibleText(driver, test, OCR__AdhocReport_Direction, "Select Direction ", Direction);

	}

	public void click_NrcLicenseSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR__AdhocReport_SearchButton, "Click on Search Button");
	}

	public void adhocReportDisplayOfTitle() {
		try {
			if (isDisplayed(driver, "//h3[contains(text(),'Adhoc Application Report')]")) {
				test.log(LogStatus.PASS, "Result Adhoc Application Report Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Adhoc Application Report Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

}
