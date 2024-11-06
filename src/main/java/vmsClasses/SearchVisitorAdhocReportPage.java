package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorAdhocReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SVAR_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_SVAR_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_SVAR_SBUcode = "//select[@id='resultVrsAdhocReport_visitorGeneralInfoValue_sbuCode']";
	public static final String OCR_SVAR_VisitorRequestId = "//input[@id='resultVrsAdhocReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_SVAR_VisitorName = "//input[@id='resultVrsAdhocReport_visitorName']";
	public static final String OCR_SVAR_VisitRequestFrom = "//input[@id='resultVrsAdhocReport_visitDateFrom']";
	public static final String OCR_SVAR_VisitDateTo = "//input[@id='resultVrsAdhocReport_visitDateTo']";
	public static final String OCR_SVAR_CountryOfCitizenship = "//input[@id='resultVrsAdhocReport_visitorPersonVal_countryOfCitizenship']";
	public static final String OCR_SVAR_VisitPurpose = "//select[@id='resultVrsAdhocReport_visitPurpose']";
	public static final String OCR_SVAR_ClassificationLevel = "//select[@id='resultVrsAdhocReport_visitorGeneralInfoValue_classification']";
	public static final String OCR_SVAR_TypeOfperson = "//select[@id='resultVrsAdhocReport_typeOfPerson']";
	public static final String OCR_SVAR_VisitorRequestStatus = "//option[contains(text(),'VRequestStatus')]";
	public static final String OCR_SVAR_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_SVAR_VisitorCategory = "//select[@id='resultVrsAdhocReport_visitCategory']";
	// public static final String OCR_SVAR_MeetingCategory =
	// "//div[@class='ms-trigger'][1])";
	public static final String OCR_SVAR_CompanyName = "//input[@id='resultVrsAdhocReport_visitorCompanyValue_companyName']";
	public static final String OCR_SVAR_ORGtype = "//select[@id='resultVrsAdhocReport_orgType']";
	public static final String OCR_SVAR_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
	public static final String OCR_SVAR_Country = "//input[@id='resultVrsAdhocReport_visitorCompanyValue_country']";
	public static final String OCR_SVAR_CountryOfIncorporation = "//input[@id='resultVrsAdhocReport_visitorCompanyValue_countryIncorp']";
	public static final String OCR_SVAR_SecurityReviewer = "//input[@id='securityUserFullName']";
	public static final String OCR_SVAR_ExportReviewer = "//input[@id='exportUserFullName']";
	public static final String OCR_SVAR_TDFPReviewer = "//input[@id='tdfpUserFullName']";
	public static final String OCR_SVAR_ManagerReviewer = "//input[@id='managerUserFullName']";
	public static final String OCR_SVAR_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
	public static final String OCR_SVAR_RequesterName = "//input[@id='resultVrsAdhocReport_visitorGeneralInfoValue_requestorName']";
	public static final String OCR_SVAR_BuildingName = "//input[@name='building']";
	public static final String OCR_SVAR_Programs = "//textarea[@id='resultVrsAdhocReport_visitorGeneralInfoValue_program']";
	public static final String OCR_SVAR_TDYSegment = "//textarea[@id='resultVrsAdhocReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_SVAR_ProductFamily = "//textarea[@id='resultVrsAdhocReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_SVAR_ProductLine = "//textarea[@id='resultVrsAdhocReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_SVAR_Sites = "//div[@class='ms-trigger'][1])";
	public static final String OCR_SVAR_ActivityType = "//select[@id='activityId']";
	public static final String OCR_SVAR_AuthorizationType = "//textarea[@id='resultVrsAdhocReport_visitorAdditionalInfoValue_exemptionNo']";
	public static final String OCR_SVAR_AuthorizationNo = "//input[@id='resultVrsAdhocReport_visitorAdditionalInfoValue_expAuthority']";
	public static final String OCR_SVAR_AgreementNo = "//input[@id='resultVrsAdhocReport_visitorAdditionalInfoValue_agreementNo']";
	public static final String OCR_SVAR_ExportAuthority = "//select[@id='resultVrsAdhocReport_exportAuthority']";
	public static final String OCR_SVAR_VISITREQUESTCreatedDateFrom = "//input[@id='resultVrsAdhocReport_visitRequestCreatedDateFrom']";
	public static final String OCR_SVAR_VISITREQUESTCreatedDateTo = "//input[@id='resultVrsAdhocReport_visitRequestCreatedDateTo']";
	public static final String OCR_SVAR_VISITREQUESTSubmittedDateFrom = "//input[@id='resultVrsAdhocReport_visitRequestSubmittedDateFrom']";
	public static final String OCR_SVAR_VISITREQUESTSubmittedDateTo = "//input[@id='resultVrsAdhocReport_visitRequestSubmittedDateTo']";
	public static final String OCR_SVAR_visitorRequestApprovedDateFrom = "//input[@id='resultVrsAdhocReport_visitorRequestApprovedDateFrom']";
	public static final String OCR_SVAR_visitorRequestApprovedDateTo = "//input[@id='resultVrsAdhocReport_visitorRequestApprovedDateTo']";
	public static final String OCR_SVAR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SVAR_Direction = "//select[@name='direction']";
	public static final String OCR_SVAR_SiteTextBox="//input[@xpath='1']";
	public static final String OCR_SVAR_TitleofReport ="//h3[contains(text(),'Visitor Request AdHoc Report')]";

	/* ******************** Constructor ***************************** */

	public SearchVisitorAdhocReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_SVAR_Search);
		clickElement(driver, test, OCR_SVAR_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_SVAR_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
			String VisitRequestTo, String VisitPurpose, String ClassificationLevel, String TypeOfPerson, String VisitorCategory, String site,
			String FromDate, String ToDate, String SToDate, String SFromDate, String AFromDate, String AToDate,
			String SortBy, String Direction)

	{
		selectByVisibleText(driver, test, OCR_SVAR_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_SVAR_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(2);
		typeText(driver, test, OCR_SVAR_VisitorName, "Add visitor name", VisitorName);

		// Add Visit request from (mm-dd-yyyy)
		Wait.waitfor(2);
		if (VisitRequestFrom.length() > 0) {
			clickElement(driver, test, OCR_SVAR_VisitRequestFrom, "Click on from date");
			date(driver, test, "select date", VisitRequestFrom);
		}

		// typeText(driver, test, OCR_SVAR_VisitRequestFrom, "Add visit from date",
		// VisitRequestFrom);

		Wait.waitfor(2);
		if (VisitRequestTo.length() > 0) {
			clickElement(driver, test, OCR_SVAR_VisitDateTo, "Click on from date");
			// typeText(driver, test,OCR_SVAR_VisitDateTo, "Add visit from date",
			// VisitRequestTo);
			date(driver, test, "select date", VisitRequestTo);
		}
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_SVAR_VisitPurpose, "", VisitPurpose);
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_SVAR_ClassificationLevel, "Add Classification Level",
				ClassificationLevel);

		Wait.waitfor(2);

		
		selectByVisibleText(driver, test, OCR_SVAR_TypeOfperson , "Add Type of person",
				TypeOfPerson);

		Wait.waitfor(2);
		
		selectByVisibleText(driver, test, OCR_SVAR_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
		scrollToBottom(driver);
		if (site.length() > 0) {
			typeText(driver, test, OCR_SVAR_SiteTextBox, "Type site name", site);
			
			
			/*clickElement(driver, test, OCR_SVAR_Sites, "click on Site down arrow");
			site = "//div[contains(text(),'" + site + "')]";
			clickElement(driver, test, site, "click on Required Site : " + site);*/
		}

		Wait.waitfor(2);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_SVAR_VISITREQUESTCreatedDateFrom, "Click on from date");
			// typeText(driver, test,OCR_SVAR_VISITREQUESTCreatedDateFrom , "Add visit from
			// date", FromDate);
			date(driver, test, "select date", FromDate);
		}

		Wait.waitfor(2);
		if (ToDate.length() > 0) {
			clickElement(driver, test, OCR_SVAR_VISITREQUESTCreatedDateTo, "Click on from date");
			// typeText(driver, test,OCR_SVAR_VISITREQUESTCreatedDateTo , "Add visit to
			// date", ToDate);
			date(driver, test, "select date", ToDate);
		}

		Wait.waitfor(2);
		if (SToDate.length() > 0) {
			clickElement(driver, test, OCR_SVAR_VISITREQUESTSubmittedDateTo, "Click on from date");
			// typeText(driver, test, OCR_SVAR_VISITREQUESTSubmittedDateTo , "Add visit To
			// date", SToDate);
			date(driver, test, "select date", SToDate);
		}

		Wait.waitfor(2);
		if (SFromDate.length() > 0) {
			clickElement(driver, test, OCR_SVAR_VISITREQUESTSubmittedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_SVAR_VISITREQUESTSubmittedDateFrom , "Add visit
			// from date", SFromDate);
			date(driver, test, "select date", SFromDate);
		}

		Wait.waitfor(2);

		if (AFromDate.length() > 0) {
			clickElement(driver, test, OCR_SVAR_visitorRequestApprovedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_SVAR_visitorRequestApprovedDateFrom , "Add visit
			// from date", AFromDate);
			date(driver, test, "select date", AFromDate);
		}

		Wait.waitfor(2);
		if (AToDate.length() > 0) {
			clickElement(driver, test, OCR_SVAR_visitorRequestApprovedDateTo, "Click on from date");
			// typeText(driver, test, OCR_SVAR_visitorRequestApprovedDateTo , "Add visit to
			// date", AToDate);
			date(driver, test, "select date", AToDate);
		}

		selectByVisibleText(driver, test, OCR_SVAR_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_SVAR_Direction, "select Direction ", Direction);
		scrollToElement(driver, OCR_SVAR_Search);

	}
	
}
