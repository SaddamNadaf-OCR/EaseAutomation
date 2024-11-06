 package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorsLogReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitorsLogReport_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_VisitorsLogReport_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_VisitorsLogReport_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_VisitorsLogReport_VisitorRequestId = "//input[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_VisitorsLogReport_VisitorCategory = "//select[@id='resultVistorsLogVrsReport_visitCategory']";
	public static final String OCR_VisitorsLogReport_ACSBadgeID="//input[@id='resultVistorsLogVrsReport_visitorPersonVal_acsBadgeId']";
	public static final String OCR_VisitorsLogReport_CompanyName = "//input[@id='resultVistorsLogVrsReport_visitorCompanyValue_companyName']";
	public static final String OCR_VisitorsLogReport_VisitRecordsFor= "//select[@id='resultVistorsLogVrsReport_allVisitors']";
	public static final String OCR_VisitorsLogReport_VisitorName = "//input[@id='resultVistorsLogVrsReport_visitorName']";
	public static final String OCR_VisitorsLogReport_VisitRequestFrom = "//input[@id='resultVistorsLogVrsReport_visitDateFrom']";
	public static final String OCR_VisitorsLogReport_VisitDateTo = "//input[@id='resultVistorsLogVrsReport_visitDateTo']";
	public static final String OCR_VisitorsLogReport_CountryOfCitizenship = "//input[@id='resultVistorsLogVrsReport_visitorPersonVal_countryOfCitizenship']";
	public static final String OCR_VisitorsLogReport_VisitPurpose = "//select[@id='resultVistorsLogVrsReport_visitPurpose']";
	public static final String OCR_VisitorsLogReport_ClassificationLevel = "//select[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_classification']";
	public static final String OCR_VisitorsLogReport_TypeOfperson = "//select[@id='resultVistorsLogVrsReport_typeOfPerson']";
	public static final String OCR_VisitorsLogReport_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_VisitorsLogReport_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
	public static final String OCR_VisitorsLogReport_Country = "//input[@id='resultVistorsLogVrsReport_visitorCompanyValue_country']";
	public static final String OCR_VisitorsLogReport_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
	public static final String OCR_VisitorsLogReport_RequesterName = "//input[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_requestorName']";
	public static final String OCR_VisitorsLogReport_Programs = "//textarea[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_program']";
	public static final String OCR_VisitorsLogReport_TDYSegment = "//textarea[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_VisitorsLogReport_ProductFamily = "//textarea[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_VisitorsLogReport_ProductLine = "//textarea[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_VisitorsLogReport_Sites = "//div[@class='ms-trigger'][1])";
	public static final String OCR_VisitorsLogReport_ActivityType = "//select[@id='activityId']";
	public static final String OCR_VisitorsLogReport_AuthorizationType = "//textarea[@id='resultVistorsLogVrsReport_visitorAdditionalInfoValue_exemptionNo']";
	public static final String OCR_VisitorsLogReport_AuthorizationNo = "//input[@id='resultVistorsLogVrsReport_visitorAdditionalInfoValue_expAuthority']";
	public static final String OCR_VisitorsLogReport_AgreementNo = "//input[@id='resultVistorsLogVrsReport_visitorAdditionalInfoValue_agreementNo']";
	public static final String OCR_VisitorsLogReport_ExportAuthority = "//select[@id='resultVistorsLogVrsReport_exportAuthority']";
	public static final String OCR_VisitorsLogReport_VISITDateFrom = "//input[@id='dp1690539641960']";
	public static final String OCR_VisitorsLogReport_VISITDateTo = "//input[@id='dp1690539641962']";
	public static final String OCR_VisitorsLogReport_CheckINDateFrom = "//input[@id='dp1690539641964']";
	public static final String OCR_VisitorsLogReport_CheckINDateTo = "//input[@id='dp1690539641966']";
	public static final String OCR_VisitorsLogReport_SortBy = "//select[@name='sortBy']";
	public static final String OCR_VisitorsLogReport_Direction = "//select[@name='direction']";
	public static final String OCR_VisitorsLogReport_SiteTextBox="//input[@xpath='1']";
	public static final String OCR_VisitorsLogReport_TitleofReport ="//h3[contains(text(),'Visitor Log Report')]";

	/* ******************** Constructor ***************************** */

	public SearchVisitorsLogReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_VisitorsLogReport_Search);
		clickElement(driver, test, OCR_VisitorsLogReport_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_VisitorsLogReport_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitPurpose, String ClassificationLevel, String TypeOfPerson, String VisitorCategory, String site,
			String FromDate, String ToDate, String SToDate, String SFromDate, String SortBy, String Direction)

	{
		selectByVisibleText(driver, test, OCR_VisitorsLogReport_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_VisitorsLogReport_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(2);
		typeText(driver, test, OCR_VisitorsLogReport_VisitorName, "Add visitor name", VisitorName);

		// Add Visit request from (mm-dd-yyyy)
			selectByVisibleText(driver, test, OCR_VisitorsLogReport_VisitPurpose, "", VisitPurpose);
		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_VisitorsLogReport_ClassificationLevel, "Add Classification Level",
				ClassificationLevel);

		Wait.waitfor(2);

		
		selectByVisibleText(driver, test, OCR_VisitorsLogReport_TypeOfperson , "Add Type of person",
				TypeOfPerson);

		Wait.waitfor(2);
		
		selectByVisibleText(driver, test, OCR_VisitorsLogReport_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
		scrollToBottom(driver);
		if (site.length() > 0) {
			typeText(driver, test, OCR_VisitorsLogReport_SiteTextBox, "Type site name", site);
			
			
			/*clickElement(driver, test, OCR_VisitorsLogReport_Sites, "click on Site down arrow");
			site = "//div[contains(text(),'" + site + "')]";
			clickElement(driver, test, site, "click on Required Site : " + site);*/
		}

		Wait.waitfor(2);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorsLogReport_VISITDateFrom, "Click on from date");
			// typeText(driver, test,OCR_VisitorsLogReport_VISITREQUESTCreatedDateFrom , "Add visit from
			// date", FromDate);
			date(driver, test, "select date", FromDate);
		}

		Wait.waitfor(2);
		if (ToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorsLogReport_VISITDateTo, "Click on from date");
			// typeText(driver, test,OCR_VisitorsLogReport_VISITREQUESTCreatedDateTo , "Add visit to
			// date", ToDate);
			date(driver, test, "select date", ToDate);
		}

		Wait.waitfor(2);
		if (SToDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorsLogReport_CheckINDateFrom, "Check on from date");
			// typeText(driver, test, OCR_VisitorsLogReport_VISITREQUESTSubmittedDateTo , "Add visit To
			// date", SToDate);
			date(driver, test, "select date", SToDate);
		}

		Wait.waitfor(2);
		if (SFromDate.length() > 0) {
			clickElement(driver, test, OCR_VisitorsLogReport_CheckINDateTo, "Click on from date");
			// typeText(driver, test, OCR_VisitorsLogReport_VISITREQUESTSubmittedDateFrom , "Add visit
			// from date", SFromDate);
			date(driver, test, "select date", SFromDate);
		}


		selectByVisibleText(driver, test, OCR_VisitorsLogReport_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_VisitorsLogReport_Direction, "select Direction ", Direction);
		scrollToElement(driver, OCR_VisitorsLogReport_Search);

	}
	
}
