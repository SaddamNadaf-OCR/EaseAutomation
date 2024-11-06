package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchForm7Page extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchForm7_SBUCode = "//select[@id='resultNrcGeneralInfo_dosGeneralInfo_sbuCode']";
	public static final String OCR_SearchForm7_Status = "//select[@id='resultNrcGeneralInfo_status']";
	public static final String OCR_SearchForm7_TransactionIdPopup = "//a[@id='transactionPopup']";
	public static final String OCR_SearchForm7_TransactionId = "//input[@id='searchForm_dosGeneralInfoDTO_transactionId']";
	public static final String OCR_SearchForm7_TransactionSearch = "//button[@id='searchAgreementNoPopUp']";
	public static final String OCR_SearchForm7_TransactionSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_SearchForm7_SegmentPopup = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_SearchForm7_WlsStatus = "//select[@id='resultNrcGeneralInfo_dosGeneralInfo_dplStatus']";
	public static final String OCR__SearchForm7_ProgramPoup = "(//a[contains(text(),'Program')])[2]";
	public static final String OCR__SearchForm7_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR__SearchForm7_ProgramSearch = "(//button[@name='Search'])[2]";
	public static final String OCR__SearchForm7_PoaNamePoup = "//a[contains(text(),'POA Name')]";
	public static final String OCR__SearchForm7_PoaEmail = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR__SearchForm7_TypeAction = "//select[@id='resultNrcGeneralInfo_typeOfAction']";
	public static final String OCR__SearchForm7_AuhorizatonNoPoup = "//a[contains(text(),'Authorization No')]";
	public static final String OCR__SearchForm7_AuhorizatonNo = "//input[@id='searchForm_dosGeneralInfoDTO_licenseNo']";
	public static final String OCR__SearchForm7_SitePoup = "(//a[contains(text(),'Site')])[2]";
	public static final String OCR__SearchForm7_SiteName = "//input[@id='dosSitePopupForm_dosSite_siteName']";
	public static final String OCR__SearchForm7_DateInitiatedFrom = "//input[@name='fromDateInitiated']";
	public static final String OCR__SearchForm7_DateInitiatedTo = "//input[@name='toDateInitiated']";
	public static final String OCR__SearchForm7_DateUsgFrom = "//input[@name='fromDateToState']";
	public static final String OCR__SearchForm7_DateUsgTo = "//input[@name='toDateToState']";
	public static final String OCR__SearchForm7_IssueDateFrom = "//input[@name='fromIssueDate']";
	public static final String OCR__SearchForm7_IssueDateTo = "//input[@name='toIssueDate']";
	public static final String OCR__SearchForm7_ExpiryDateFrom = "//input[@name='fromExpiryDate']";
	public static final String OCR__SearchForm7_ExpiryDateTo = "//input[@name='toExpiryDate']";
	public static final String OCR__SearchForm7_RequestorPoup = "//a[contains(text(),'Requestor')]";
	public static final String OCR__SearchForm7_RequestorEmail = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR__SearchForm7_ReviewerPoup = "(//a[contains(text(),'Reviewer')])[2]";
	public static final String OCR__SearchForm7_ReviewerEmail = "//input[@id='searchForm_userProfile_emailId']";
	public static final String OCR__SearchForm7_SortBy = "(//select[contains(@name,'sortBy')])[1]";
	public static final String OCR__SearchForm7_Direction = "(//select[contains(@name,'direction')])[1]";
	public static final String OCR__SearchForm7_PopupClose = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR__SearchForm7_SearchButton = "//button[contains(text(),'Search')]";
	public static final String OCR__ResultHeading = "//h3[contains(text(),'List Form 7')]";

	/* ******************** Constructor ***************************** */
	public SearchForm7Page(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void searchForm7(String SBUCode, String Status, String TransactionId, String SegmentName, String WlsStatus,
			String ProgramCode, String PoaEmailId, String TypeOfAction, String AuhorizatonNo, String SiteName,
			String DateInitiatedFrom, String DateInitiatedTo, String DateUsgFrom, String DateUsgTo,
			String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo,
			String RequestorEmailId, String ReviewerEmailId, String SortBy, String Direction) {

		selectByVisibleText(driver, test, OCR_SearchForm7_SBUCode, "Select SBU Code ", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchForm7_Status, "Select Status ", Status);

		if (TransactionId.length() > 0) {
			clickElement(driver, test, OCR_SearchForm7_TransactionIdPopup, "Click TransactionId Popup");
			try {
				//typeText(driver, test, OCR_SearchForm7_TransactionId, "Enter Transaction Id ", TransactionId);
				clickElement(driver, test, OCR_SearchForm7_TransactionSearch, "Click on Search Button");
				String trans = "//td[contains(text(),'" + TransactionId + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_transactionId'])[1]", "Click Transaction Id :" + TransactionId);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Transaction Id");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		if (SegmentName.length() > 0) {
			clickElement(driver, test, OCR_SearchForm7_SegmentPopup, "Click Segment Popup");
			try {
				String segment = "//td[contains(text(),'" + SegmentName + "')]";
				clickElement(driver, test, segment, "Click on SegmentName :" + SegmentName);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Segment");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR_SearchForm7_WlsStatus, "Select Wls Status", WlsStatus);

		if (ProgramCode.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_ProgramPoup, "Click Program Popup");
			try {
				typeText(driver, test, OCR__SearchForm7_ProgramCode, "Enter Program Code ", ProgramCode);
				clickElement(driver, test, OCR__SearchForm7_ProgramSearch, "Click on Search Button");
				String prgrm = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, prgrm, "Click Program Code :" + ProgramCode);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Program Code");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		if (PoaEmailId.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_PoaNamePoup, "Click POA Name Popup");
			try {
				typeText(driver, test, OCR__SearchForm7_PoaEmail, "Enter Poa EmailId ", PoaEmailId);
				clickElement(driver, test, OCR__SearchForm7_ProgramSearch, "Click on Search Button");
				String poa = "//td[contains(text(),'" + PoaEmailId + "')]";
				clickElement(driver, test, poa, "Click Poa EmailId :" + PoaEmailId);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Poa Email");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR__SearchForm7_TypeAction, "Select Type of Action ", TypeOfAction);

		if (AuhorizatonNo.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_AuhorizatonNoPoup, "Click Authorization No Popup");
			try {
				typeText(driver, test, OCR__SearchForm7_AuhorizatonNo, "Enter AuhorizatonNo ", AuhorizatonNo);
				clickElement(driver, test, OCR__SearchForm7_ProgramSearch, "Click on Search Button");
				String auth = "(//td[contains(text(),'" + AuhorizatonNo + "')])[1]";
				clickElement(driver, test, auth, "Click Auhorizaton No :" + AuhorizatonNo);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Autorization No");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		if (SiteName.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_SitePoup, "Click Site Popup");
			try {
				typeText(driver, test, OCR__SearchForm7_SiteName, "Enter Site Name ", SiteName);
				clickElement(driver, test, OCR__SearchForm7_ProgramSearch, "Click on Search Button");
				String site = "//td[contains(text(),'" + SiteName + "')]";
				clickElement(driver, test, site, "Click Site Name :" + SiteName);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Site Name");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		if (DateInitiatedFrom.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_DateInitiatedFrom, "Click on Date Initiated From");
			date(driver, test, "Selected on Date Initiated From : ", DateInitiatedFrom);
			test.log(LogStatus.PASS, "Selected on Date Initiated From : " + DateInitiatedFrom);
			clickElement(driver, test, OCR__SearchForm7_DateInitiatedTo, "Click on Date Initiated To");
			date(driver, test, "Selected on Date Initiated To : ", DateInitiatedTo);
			test.log(LogStatus.PASS, "Selected on Date Initiated To : " + DateInitiatedTo);
		}

		if (DateUsgFrom.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_DateUsgFrom, "Click on Date Usg From");
			date(driver, test, "Selected on Date Usg From : ", DateUsgFrom);
			test.log(LogStatus.PASS, "Selected on Date Usg From : " + DateUsgFrom);
			clickElement(driver, test, OCR__SearchForm7_DateUsgTo, "Click on Date Usg To");
			date(driver, test, "Selected on Date Usg To : ", DateUsgTo);
			test.log(LogStatus.PASS, "Selected on Date Usg To : " + DateUsgTo);
		}

		if (IssueDateFrom.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_IssueDateFrom, "Click on Issue Date From");
			date(driver, test, "Selected on Issue Date From : ", IssueDateFrom);
			test.log(LogStatus.PASS, "Selected on Issue Date From : " + IssueDateFrom);
			clickElement(driver, test, OCR__SearchForm7_IssueDateTo, "Click on Issue Date To");
			date(driver, test, "Selected on Issue Date To : ", IssueDateTo);
			test.log(LogStatus.PASS, "Selected on Issue Date To : " + IssueDateTo);
		}

		if (ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_ExpiryDateFrom, "Click on Expiry Date From");
			date(driver, test, "Selected on Expiry Date From : ", ExpiryDateFrom);
			test.log(LogStatus.PASS, "Selected on Expiry Date From : " + ExpiryDateFrom);
			clickElement(driver, test, OCR__SearchForm7_ExpiryDateTo, "Click on Expiry Date To");
			date(driver, test, "Selected on Expiry Date To : ", ExpiryDateTo);
			test.log(LogStatus.PASS, "Selected on Expiry Date To : " + ExpiryDateTo);
		}

		if (RequestorEmailId.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_RequestorPoup, "Click Requestor Popup");
			try {
				typeText(driver, test, OCR__SearchForm7_RequestorEmail, "Enter Requestor Email ", RequestorEmailId);
				clickElement(driver, test, OCR__SearchForm7_ProgramSearch, "Click on Search Button");
				String reqstor = "//td[contains(text(),'" + RequestorEmailId + "')]";
				clickElement(driver, test, reqstor, "Click Requestor Email :" + RequestorEmailId);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Requestor Email Id");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		if (ReviewerEmailId.length() > 0) {
			clickElement(driver, test, OCR__SearchForm7_ReviewerPoup, "Click Reviewer Popup");
			try {
				typeText(driver, test, OCR__SearchForm7_ReviewerEmail, "Enter Reviewer Email ", ReviewerEmailId);
				clickElement(driver, test, OCR__SearchForm7_ProgramSearch, "Click on Search Button");
				String review = "//td[contains(text(),'" + ReviewerEmailId + "')]";
				clickElement(driver, test, review, "Click Reviewer Email :" + ReviewerEmailId);
				clickElement(driver, test, OCR_SearchForm7_TransactionSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Reviewer Email Id");
				clickElement(driver, test, OCR__SearchForm7_PopupClose, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR__SearchForm7_SortBy, "Select SortBy ", SortBy);
		selectByVisibleText(driver, test, OCR__SearchForm7_Direction, "Select Direction ", Direction);

	}

	public void click_NrcLicenseSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR__SearchForm7_SearchButton, "Click on Search Button");
	}
	
	//Validating Heading
	public void headingValidation() {
		try {
			if(isDisplayed(driver, OCR__ResultHeading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}
	}

}
