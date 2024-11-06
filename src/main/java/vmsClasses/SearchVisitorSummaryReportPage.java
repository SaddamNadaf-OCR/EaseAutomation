package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorSummaryReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitoSummaryReport_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_VisitoSummaryReport_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_VisitoSummaryReport_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_VisitoSummaryReport_VisitorRequestId = "//input[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_VisitoSummaryReport_VisitorName = "//input[@id='resultVisitorSummaryJasperReport_visitorName']";
	public static final String OCR_VisitoSummaryReport_VisitRequestFrom = "//input[@id='resultVisitorSummaryJasperReport_visitDateFrom']";
	public static final String OCR_VisitoSummaryReport_VisitDateTo = "//input[@id='resultVisitorSummaryJasperReport_visitDateTo']";
	public static final String OCR_VisitoSummaryReport_CountryOfCitizenship = "//input[@id='resultVisitorSummaryJasperReport_visitorPersonVal_countryOfCitizenship']";
	public static final String OCR_VisitoSummaryReport_VisitPurpose = "//select[@id='resultVisitorSummaryJasperReport_visitPurpose']";
	public static final String OCR_VisitoSummaryReport_ClassificationLevel = "//select[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_classification']";
	public static final String OCR_VisitoSummaryReport_TypeOfperson = "//select[@id='resultVisitorSummaryJasperReport_typeOfPerson']";
	public static final String OCR_VisitoSummaryReport_VisitorRequestStatus = "//option[contains(text(),'VRequestStatus')]";
	public static final String OCR_VisitoSummaryReport_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_VisitoSummaryReport_VisitorCategory = "//select[@id='resultVisitorSummaryJasperReport_visitCategory']";
	public static final String OCR_VisitoSummaryReport_CompanyName = "//input[@id='resultVisitorSummaryJasperReport_visitorCompanyValue_companyName']";
	public static final String OCR_VisitoSummaryReport_ORGtype = "//select[@id='resultVisitorSummaryJasperReport_orgType']";
	public static final String OCR_VisitoSummaryReport_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
	public static final String OCR_VisitoSummaryReport_Country = "//input[@id='resultVisitorSummaryJasperReport_visitorCompanyValue_country']";
	public static final String OCR_VisitoSummaryReport_CountryOfIncorporation = "//input[@id='resultVisitorSummaryJasperReport_visitorCompanyValue_countryIncorp']";
	public static final String OCR_VisitoSummaryReport_SecurityReviewer = "//input[@id='securityUserFullName']";
	public static final String OCR_VisitoSummaryReport_ExportReviewer = "//input[@id='exportUserFullName']";
	public static final String OCR_VisitoSummaryReport_TDFPReviewer = "//input[@id='tdfpUserFullName']";
	public static final String OCR_VisitoSummaryReport_ManagerReviewer = "//input[@id='managerUserFullName']";
	public static final String OCR_VisitoSummaryReport_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
	public static final String OCR_VisitoSummaryReport_RequesterName = "//input[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_requestorName']";
	public static final String OCR_VisitoSummaryReport_BuildingName = "//input[@name='building']";
	public static final String OCR_VisitoSummaryReport_Programs = "//textarea[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_program']";
	public static final String OCR_VisitoSummaryReport_TDYSegment = "//textarea[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_VisitoSummaryReport_ProductFamily = "//textarea[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_VisitoSummaryReport_ProductLine = "//textarea[@id='resultVisitorSummaryJasperReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_VisitoSummaryReport_Sites = "//div[@class='ms-trigger'][1])";
	public static final String OCR_VisitoSummaryReport_ActivityType = "//select[@id='activityId']";
	public static final String OCR_VisitoSummaryReport_AuthorizationType = "//textarea[@id='resultVisitorSummaryJasperReport_visitorAdditionalInfoValue_exemptionNo']";
	public static final String OCR_VisitoSummaryReport_AuthorizationNo = "//input[@id='resultVisitorSummaryJasperReport_visitorAdditionalInfoValue_expAuthority']";
	public static final String OCR_VisitoSummaryReport_AgreementNo = "//input[@id='resultVisitorSummaryJasperReport_visitorAdditionalInfoValue_agreementNo']";
	public static final String OCR_VisitoSummaryReport_ExportAuthority = "//select[@id='resultVisitorSummaryJasperReport_exportAuthority']";
	public static final String OCR_VisitoSummaryReport_VISITREQUESTCreatedDateFrom = "//input[@id='resultVisitorSummaryJasperReport_visitRequestCreatedDateFrom']";
	public static final String OCR_VisitoSummaryReport_VISITREQUESTCreatedDateTo = "//input[@id='resultVisitorSummaryJasperReport_visitRequestCreatedDateTo']";
	public static final String OCR_VisitoSummaryReport_VISITREQUESTSubmittedDateFrom = "//input[@id='resultVisitorSummaryJasperReport_visitRequestSubmittedDateFrom']";
	public static final String OCR_VisitoSummaryReport_VISITREQUESTSubmittedDateTo = "//input[@id='resultVisitorSummaryJasperReport_visitRequestSubmittedDateTo']";
	public static final String OCR_VisitoSummaryReport_visitorRequestApprovedDateFrom = "//input[@id='resultVisitorSummaryJasperReport_visitorRequestApprovedDateFrom']";
	public static final String OCR_VisitoSummaryReport_visitorRequestApprovedDateTo = "//input[@id='resultVisitorSummaryJasperReport_visitorRequestApprovedDateTo']";
	public static final String OCR_VisitoSummaryReport_SortBy = "//select[@name='sortBy']";
	public static final String OCR_VisitoSummaryReport_Direction = "//select[@name='direction']";
	public static final String OCR_VisitoSummaryReport_SiteTextBox="//input[@xpath='1']";
	public static final String OCR_VisitoSummaryReport_TitleofReport ="//h3[contains(text(),'Visitor Request AdHoc Report')]";

	/* ******************** Constructor ***************************** */

	public SearchVisitorSummaryReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_VisitoSummaryReport_Search);
		clickElement(driver, test, OCR_VisitoSummaryReport_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_VisitoSummaryReport_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
			String VisitRequestTo, String VisitPurpose, String ClassificationLevel, String TypeOfPerson, String VisitorCategory, String site,
			String FromDate, String ToDate, String SToDate, String SFromDate, String AFromDate, String AToDate,
			String SortBy, String Direction)

	{
		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_VisitoSummaryReport_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(2);
		typeText(driver, test, OCR_VisitoSummaryReport_VisitorName, "Add visitor name", VisitorName);

		// Add Visit request from (mm-dd-yyyy)
		Wait.waitfor(2);
		if (VisitRequestFrom.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_VisitRequestFrom, "Click on from date");
			date(driver, test, "select date", VisitRequestFrom);
		}

		// typeText(driver, test, OCR_VisitoSummaryReport_VisitRequestFrom, "Add visit from date",
		// VisitRequestFrom);

		Wait.waitfor(2);
		if (VisitRequestTo.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_VisitDateTo, "Click on from date");
			// typeText(driver, test,OCR_VisitoSummaryReport_VisitDateTo, "Add visit from date",
			// VisitRequestTo);
			date(driver, test, "select date", VisitRequestTo);
		}
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_VisitPurpose, "", VisitPurpose);
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_ClassificationLevel, "Add Classification Level",
				ClassificationLevel);

		Wait.waitfor(2);

		
		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_TypeOfperson , "Add Type of person",
				TypeOfPerson);

		Wait.waitfor(2);
		
		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
		scrollToBottom(driver);
		if (site.length() > 0) {
			typeText(driver, test, OCR_VisitoSummaryReport_SiteTextBox, "Type site name", site);
			
			
			/*clickElement(driver, test, OCR_VisitoSummaryReport_Sites, "click on Site down arrow");
			site = "//div[contains(text(),'" + site + "')]";
			clickElement(driver, test, site, "click on Required Site : " + site);*/
		}

		Wait.waitfor(2);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_VISITREQUESTCreatedDateFrom, "Click on from date");
			// typeText(driver, test,OCR_VisitoSummaryReport_VISITREQUESTCreatedDateFrom , "Add visit from
			// date", FromDate);
			date(driver, test, "select date", FromDate);
		}

		Wait.waitfor(2);
		if (ToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_VISITREQUESTCreatedDateTo, "Click on from date");
			// typeText(driver, test,OCR_VisitoSummaryReport_VISITREQUESTCreatedDateTo , "Add visit to
			// date", ToDate);
			date(driver, test, "select date", ToDate);
		}

		Wait.waitfor(2);
		if (SToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_VISITREQUESTSubmittedDateTo, "Click on from date");
			// typeText(driver, test, OCR_VisitoSummaryReport_VISITREQUESTSubmittedDateTo , "Add visit To
			// date", SToDate);
			date(driver, test, "select date", SToDate);
		}

		Wait.waitfor(2);
		if (SFromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_VISITREQUESTSubmittedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_VisitoSummaryReport_VISITREQUESTSubmittedDateFrom , "Add visit
			// from date", SFromDate);
			date(driver, test, "select date", SFromDate);
		}

		Wait.waitfor(2);

		if (AFromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_visitorRequestApprovedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_VisitoSummaryReport_visitorRequestApprovedDateFrom , "Add visit
			// from date", AFromDate);
			date(driver, test, "select date", AFromDate);
		}

		Wait.waitfor(2);
		if (AToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitoSummaryReport_visitorRequestApprovedDateTo, "Click on from date");
			// typeText(driver, test, OCR_VisitoSummaryReport_visitorRequestApprovedDateTo , "Add visit to
			// date", AToDate);
			date(driver, test, "select date", AToDate);
		}

		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_VisitoSummaryReport_Direction, "select Direction ", Direction);
		scrollToElement(driver, OCR_VisitoSummaryReport_Search);

	}

}
