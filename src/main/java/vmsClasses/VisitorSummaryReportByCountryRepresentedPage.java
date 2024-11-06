package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorSummaryReportByCountryRepresentedPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test; 


	//-----------------------------Locators--------------
	
	public static final String OCR_MetrixByCountryRepresented_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_MetrixByCountryRepresented_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_MetrixByCountryRepresented_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_MetrixByCountryRepresented_VisitorRequestId = "//input[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_MetrixByCountryRepresented_VisitorName = "//input[@id='resultVisitorMetricesSubReport_visitorName']";
	public static final String OCR_MetrixByCountryRepresented_VisitRequestFrom = "//input[@id='resultVisitorMetricesSubReport_visitDateFrom']";
	public static final String OCR_MetrixByCountryRepresented_VisitDateTo = "//input[@id='resultVisitorMetricesSubReport_visitDateTo']";
    public static final String OCR_MetrixByCountryRepresented_RepresentingCountry = "//input[@id='resultVisitorMetricesSubReport_visitorPersonVal_repCountry']";
	public static final String OCR_MetrixByCountryRepresented_VisitorCategory = "//select[@id='resultVisitorMetricesSubReport_visitCategory']";
	public static final String OCR_MetrixByCountryRepresented_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_MetrixByCountryRepresented_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
	public static final String OCR_MetrixByCountryRepresented_Programs = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_program']";
	public static final String OCR_MetrixByCountryRepresented_TDYSegment = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_MetrixByCountryRepresented_ProductFamily = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_MetrixByCountryRepresented_ProductLine = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_MetrixByCountryRepresented_Sites = "//div[@class='ms-trigger'][1])";
	public static final String OCR_MetrixByCountryRepresented_VISITREQUESTCreatedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateFrom']";
	public static final String OCR_MetrixByCountryRepresented_VISITREQUESTCreatedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateTo']";
	public static final String OCR_MetrixByCountryRepresented_VISITREQUESTSubmittedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateFrom']";
	public static final String OCR_MetrixByCountryRepresented_VISITREQUESTSubmittedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateTo']";
	public static final String OCR_MetrixByCountryRepresented_visitorRequestApprovedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateFrom']";
	public static final String OCR_MetrixByCountryRepresented_visitorRequestApprovedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateTo']";
	public static final String OCR_MetrixByCountryRepresented_SiteTextBox="//input[@xpath='1']";
	public static final String OCR_MetrixVisitor_VisitorSummaryReportByCountryRepresented_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Representing Country')]";
	
	public VisitorSummaryReportByCountryRepresentedPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_MetrixByCountryRepresented_Search);
		clickElement(driver, test, OCR_MetrixByCountryRepresented_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_MetrixByCountryRepresented_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
			String VisitRequestTo, String VisitorCategory, String site,
			String FromDate, String ToDate,  String SFromDate, String SToDate, String AFromDate, String AToDate)

	{
		selectByVisibleText(driver, test, OCR_MetrixByCountryRepresented_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_MetrixByCountryRepresented_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(1);
		typeText(driver, test, OCR_MetrixByCountryRepresented_VisitorName, "Add visitor name", VisitorName);

		// Add Visit request from (mm-dd-yyyy)
		Wait.waitfor(1);
		if (VisitRequestFrom.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_VisitRequestFrom, "Click on from date");
			date(driver, test, "select date", VisitRequestFrom);
		}
		Wait.waitfor(1);
		if (VisitRequestTo.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_VisitDateTo, "Click on from date");
			// typeText(driver, test,OCR_MetrixByCountryRepresented_VisitDateTo, "Add visit from date",
			// VisitRequestTo);
			date(driver, test, "select date", VisitRequestTo);
		}
		Wait.waitfor(1);

		

		Wait.waitfor(1);
		
		selectByVisibleText(driver, test, OCR_MetrixByCountryRepresented_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
		scrollToBottom(driver);
		if (site.length() > 0) {
			typeText(driver, test, OCR_MetrixByCountryRepresented_SiteTextBox, "Type site name", site);
			
		}

		Wait.waitfor(1);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_VISITREQUESTCreatedDateFrom, "Click on from date");
			// typeText(driver, test,OCR_MetrixByCountryRepresented_VISITREQUESTCreatedDateFrom , "Add visit from
			// date", FromDate);
			date(driver, test, "select date", FromDate);
		}

		Wait.waitfor(1);
		if (ToDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_VISITREQUESTCreatedDateTo, "Click on from date");
			// typeText(driver, test,OCR_MetrixByCountryRepresented_VISITREQUESTCreatedDateTo , "Add visit to
			// date", ToDate);
			date(driver, test, "select date", ToDate);
		}

		Wait.waitfor(1);
		if (SToDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_VISITREQUESTSubmittedDateTo, "Click on from date");
			// typeText(driver, test, OCR_MetrixByCountryRepresented_VISITREQUESTSubmittedDateTo , "Add visit To
			// date", SToDate);
			date(driver, test, "select date", SToDate);
		}

		Wait.waitfor(1);
		if (SFromDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_VISITREQUESTSubmittedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_MetrixByCountryRepresented_VISITREQUESTSubmittedDateFrom , "Add visit
			// from date", SFromDate);
			date(driver, test, "select date", SFromDate);
		}

		Wait.waitfor(1);

		if (AFromDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_visitorRequestApprovedDateFrom, "Click on from date");
			// typeText(driver, test, OCR_MetrixByCountryRepresented_visitorRequestApprovedDateFrom , "Add visit
			// from date", AFromDate);
			date(driver, test, "select date", AFromDate);
		}

		Wait.waitfor(1);
		if (AToDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByCountryRepresented_visitorRequestApprovedDateTo, "Click on from date");
			// typeText(driver, test, OCR_MetrixByCountryOfIncorporation_visitorRequestApprovedDateTo , "Add visit to
			// date", AToDate);
			date(driver, test, "select date", AToDate);
		}

		scrollToElement(driver, OCR_MetrixByCountryRepresented_Search);

	}
	
}



