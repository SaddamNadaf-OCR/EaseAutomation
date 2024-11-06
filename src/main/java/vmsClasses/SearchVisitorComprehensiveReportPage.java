package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorComprehensiveReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitorComprehensiveReport_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_VisitorComprehensiveReport_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_VisitorComprehensiveReport_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_VisitorComprehensiveReport_VisitorRequestId = "//input[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_VisitorComprehensiveReport_VisitorName = "//input[@id='resultComprehensiveVisitorReport_visitorPersonValue_firstName']";
	public static final String OCR_VisitorComprehensiveReport_VisitRequestFrom = "//input[@id='resultComprehensiveVisitorReport_visitDateFrom']";
	public static final String OCR_VisitorComprehensiveReport_VisitDateTo = "//input[@id='resultComprehensiveVisitorReport_visitDateTo']";
	public static final String OCR_VisitorComprehensiveReport_CountryOfCitizenship = "//input[@id='resultComprehensiveVisitorReport_visitorPersonVal_countryOfCitizenship']";
	public static final String OCR_VisitorComprehensiveReport_VisitPurpose = "//select[@id='resultComprehensiveVisitorReport_visitPurpose']";
	public static final String OCR_VisitorComprehensiveReport_ClassificationLevel = "//select[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_classification']";
	public static final String OCR_VisitorComprehensiveReport_TypeOfperson = "//select[@id='resultComprehensiveVisitorReport_typeOfPerson']";
	public static final String OCR_VisitorComprehensiveReport_VisitorRequestStatus = "//option[contains(text(),'VRequestStatus')]";
	public static final String OCR_VisitorComprehensiveReport_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_VisitorComprehensiveReport_VisitorCategory = "//select[@id='resultComprehensiveVisitorReport_visitCategory']";
	public static final String OCR_VisitorComprehensiveReport_CompanyName = "//input[@id='resultComprehensiveVisitorReport_visitorCompanyValue_companyName']";
	public static final String OCR_VisitorComprehensiveReport_ORGtype = "//select[@id='resultComprehensiveVisitorReport_orgType']";
	public static final String OCR_VisitorComprehensiveReport_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
	public static final String OCR_VisitorComprehensiveReport_Country = "//input[@id='resultComprehensiveVisitorReport_visitorCompanyValue_country']";
	public static final String OCR_VisitorComprehensiveReport_CountryOfIncorporation = "//input[@id='resultComprehensiveVisitorReport_visitorCompanyValue_countryIncorp']";
	public static final String OCR_VisitorComprehensiveReport_SecurityReviewer = "//input[@id='securityUserFullName']";
	public static final String OCR_VisitorComprehensiveReport_ExportReviewer = "//input[@id='exportUserFullName']";
	public static final String OCR_VisitorComprehensiveReport_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
	public static final String OCR_VisitorComprehensiveReport_RequesterName = "//input[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_requestorName']";
	public static final String OCR_VisitorComprehensiveReport_BuildingName = "//input[@name='building']";
	public static final String OCR_VisitorComprehensiveReport_Programs = "//textarea[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_program']";
	public static final String OCR_VisitorComprehensiveReport_TDYSegment = "//textarea[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_VisitorComprehensiveReport_ProductFamily = "//textarea[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_VisitorComprehensiveReport_ProductLine = "//textarea[@id='resultComprehensiveVisitorReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_VisitorComprehensiveReport_Sites = "//div[@class='ms-trigger'][1])";
	public static final String OCR_VisitorComprehensiveReport_VISITREQUESTCreatedDateFrom = "//input[@id='resultComprehensiveVisitorReport_visitRequestCreatedDateFrom']";
	public static final String OCR_VisitorComprehensiveReport_VISITREQUESTCreatedDateTo = "//input[@id='resultComprehensiveVisitorReport_visitRequestCreatedDateTo']";
	public static final String OCR_VisitorComprehensiveReport_VISITREQUESTSubmittedDateFrom = "//input[@id='resultComprehensiveVisitorReport_visitRequestSubmittedDateFrom']";
	public static final String OCR_VisitorComprehensiveReport_VISITREQUESTSubmittedDateTo = "//input[@id='resultComprehensiveVisitorReport_visitRequestSubmittedDateTo']";
	public static final String OCR_VisitorComprehensiveReport_visitorRequestApprovedDateFrom = "//input[@id='resultComprehensiveVisitorReport_visitorRequestApprovedDateFrom']";
	public static final String OCR_VisitorComprehensiveReport_visitorRequestApprovedDateTo = "//input[@id='resultComprehensiveVisitorReport_visitorRequestApprovedDateTo']";
	public static final String OCR_VisitorComprehensiveReport_SortBy = "//select[@name='sortBy']";
	public static final String OCR_VisitorComprehensiveReport_Direction = "//select[@name='direction']";
	public static final String OCR_VisitorComprehensiveReport_SiteTextBox="//input[@xpath='1']";
	public static final String OCR_VisitorComprehensiveReport_TitleofReport ="//h3[contains(text(),'Visitor Comprehensive Report')]";

	/* ******************** Constructor ***************************** */

	public SearchVisitorComprehensiveReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_VisitorComprehensiveReport_Search);
		clickElement(driver, test, OCR_VisitorComprehensiveReport_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_VisitorComprehensiveReport_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
			String VisitRequestTo, String VisitPurpose, String ClassificationLevel, String TypeOfPerson, String VisitorCategory, String site,
			String FromDate, String ToDate, String SToDate, String SFromDate, String AFromDate, String AToDate,
			String SortBy, String Direction)

	{
		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_VisitorComprehensiveReport_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(2);
		typeText(driver, test, OCR_VisitorComprehensiveReport_VisitorName, "Add visitor name", VisitorName);

		// Add Visit request from (mm-dd-yyyy)
		Wait.waitfor(2);
		if (VisitRequestFrom.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_VisitRequestFrom, "Click on from date");
			date(driver, test, "select date", VisitRequestFrom);
		}

		// typeText(driver, test, OCR_VisitorComprehensiveReport_VisitRequestFrom, "Add visit from date",
		// VisitRequestFrom);

		Wait.waitfor(2);
		if (VisitRequestTo.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_VisitDateTo, "Click on from date");
			// typeText(driver, test,OCR_VisitorComprehensiveReport_VisitDateTo, "Add visit from date",
			// VisitRequestTo);
			date(driver, test, "select date", VisitRequestTo);
		}
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_VisitPurpose, "", VisitPurpose);
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_ClassificationLevel, "Add Classification Level",
				ClassificationLevel);

		Wait.waitfor(2);

		
		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_TypeOfperson , "Add Type of person",
				TypeOfPerson);

		Wait.waitfor(2);
		
		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
		scrollToBottom(driver);
		if (site.length() > 0) {
			typeText(driver, test, OCR_VisitorComprehensiveReport_SiteTextBox, "Type site name", site);
			
			
			/*clickElement(driver, test, OCR_VisitorComprehensiveReport_Sites, "click on Site down arrow");
			site = "//div[contains(text(),'" + site + "')]";
			clickElement(driver, test, site, "click on Required Site : " + site);*/
		}

		Wait.waitfor(2);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_VISITREQUESTCreatedDateFrom, "Click on from date");
			// typeText(driver, test,OCR_VisitorComprehensiveReport_VISITREQUESTCreatedDateFrom , "Add visit from
			// date", FromDate);
			date(driver, test, "select date", FromDate);
		}

		Wait.waitfor(2);
		if (ToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_VISITREQUESTCreatedDateTo, "Click on from date");
			// typeText(driver, test,OCR_VisitorComprehensiveReport_VISITREQUESTCreatedDateTo , "Add visit to
			// date", ToDate);
			date(driver, test, "select date", ToDate);
		}

		Wait.waitfor(2);
		if (SToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_VISITREQUESTSubmittedDateTo, "Click on from date");
			// typeText(driver, test, OCR_VisitorComprehensiveReport_VISITREQUESTSubmittedDateTo , "Add visit To
			// date", SToDate);
			date(driver, test, "select date", SToDate);
		}

		Wait.waitfor(2);
		if (SFromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_VISITREQUESTSubmittedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_VisitorComprehensiveReport_VISITREQUESTSubmittedDateFrom , "Add visit
			// from date", SFromDate);
			date(driver, test, "select date", SFromDate);
		}

		Wait.waitfor(2);

		if (AFromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_visitorRequestApprovedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_VisitorComprehensiveReport_visitorRequestApprovedDateFrom , "Add visit
			// from date", AFromDate);
			date(driver, test, "select date", AFromDate);
		}

		Wait.waitfor(2);
		if (AToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorComprehensiveReport_visitorRequestApprovedDateTo, "Click on from date");
			// typeText(driver, test, OCR_VisitorComprehensiveReport_visitorRequestApprovedDateTo , "Add visit to
			// date", AToDate);
			date(driver, test, "select date", AToDate);
		}

		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_VisitorComprehensiveReport_Direction, "select Direction ", Direction);
		scrollToElement(driver, OCR_VisitorComprehensiveReport_Search);

	}

}

