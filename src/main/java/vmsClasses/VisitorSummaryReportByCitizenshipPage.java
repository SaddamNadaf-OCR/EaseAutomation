package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorSummaryReportByCitizenshipPage  extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------locators--------------
	
			public static final String OCR_MetrixByCitizenship_Search = "//button[contains(text(),'Search')]";
			public static final String OCR_MetrixByCitizenship_Reset = "//button[contains(text(),'Reset')]";
			public static final String OCR_MetrixByCitizenship_SBUcode = "//select[@id='sbuCode']";
			public static final String OCR_MetrixByCitizenship_VisitorRequestId = "//input[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_visitorId']";
			public static final String OCR_MetrixByCitizenship_VisitorName = "//input[@id='resultVisitorMetricesSubReport_visitorName']";
			public static final String OCR_MetrixByCitizenship_VisitRequestFrom = "//input[@id='resultVisitorMetricesSubReport_visitDateFrom']";
			public static final String OCR_MetrixByCitizenship_VisitDateTo = "//input[@id='resultVisitorMetricesSubReport_visitDateTo']";
			public static final String OCR_MetrixByCitizenship_CountryOfCitizenship = "//input[@id='resultVisitorMetricesSubReport_visitorPersonVal_countryOfCitizenship']";
			public static final String OCR_MetrixByCitizenship_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
			public static final String OCR_MetrixByCitizenship_VisitorCategory = "//select[@id='resultVisitorMetricesSubReport_visitCategory']";
			public static final String OCR_MetrixByCitizenship_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
			public static final String OCR_MetrixByCitizenship_Programs = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_program']";
			public static final String OCR_MetrixByCitizenship_TDYSegment = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_segment']";
			public static final String OCR_MetrixByCitizenship_ProductFamily = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productFamily']";
			public static final String OCR_MetrixByCitizenship_ProductLine = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productLine']";
			public static final String OCR_MetrixByCitizenship_Sites = "//div[@class='ms-trigger'][1])";
			public static final String OCR_MetrixByCitizenship_VISITREQUESTCreatedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateFrom']";
			public static final String OCR_MetrixByCitizenship_VISITREQUESTCreatedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateTo']";
			public static final String OCR_MetrixByCitizenship_VISITREQUESTSubmittedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateFrom']";
			public static final String OCR_MetrixByCitizenship_VISITREQUESTSubmittedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateTo']";
			public static final String OCR_MetrixByCitizenship_visitorRequestApprovedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateFrom']";
			public static final String OCR_MetrixByCitizenship_visitorRequestApprovedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateTo']";
			public static final String OCR_MetrixByCitizenship_SiteTextBox="//input[@xpath='1']";
			public static final String OCR_MetrixVisitor_SummaryReportByCountryofCitizenship_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Country of Citizenship')]";

			public VisitorSummaryReportByCitizenshipPage(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
			}
			
			/* ******************** Actions ********************************* */

			public void clickSearchbutton() {
				scrollToElement(driver, OCR_MetrixByCitizenship_Search);
				clickElement(driver, test, OCR_MetrixByCitizenship_Search, "Click on search button");
			}

			public void clickResetButton() {
				clickElement(driver, test, OCR_MetrixByCitizenship_Reset, "Click on reset button");
			}

			public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
					String VisitRequestTo, String VisitorCategory, String site,
					String FromDate, String ToDate,  String SFromDate, String SToDate, String AFromDate, String AToDate)

			{
				selectByVisibleText(driver, test, OCR_MetrixByCitizenship_SBUcode, "Select SBU code", SBUCode);
				Wait.waitfor(4);
				typeText(driver, test, OCR_MetrixByCitizenship_VisitorRequestId, "Add Visitor request ID", RequestID);

				Wait.waitfor(1);
				typeText(driver, test, OCR_MetrixByCitizenship_VisitorName, "Add visitor name", VisitorName);

				// Add Visit request from (mm-dd-yyyy)
				Wait.waitfor(1);
				if (VisitRequestFrom.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_VisitRequestFrom, "Click on from date");
					date(driver, test, "select date", VisitRequestFrom);
				}
				Wait.waitfor(1);
				if (VisitRequestTo.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_VisitDateTo, "Click on from date");
					// typeText(driver, test,OCR_MetrixByCitizenship_VisitDateTo, "Add visit from date",
					// VisitRequestTo);
					date(driver, test, "select date", VisitRequestTo);
				}
				Wait.waitfor(1);

				

				Wait.waitfor(1);
				
				selectByVisibleText(driver, test, OCR_MetrixByCitizenship_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
				scrollToBottom(driver);
				if (site.length() > 0) {
					typeText(driver, test, OCR_MetrixByCitizenship_SiteTextBox, "Type site name", site);
					
				}

				Wait.waitfor(1);
				if (FromDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_VISITREQUESTCreatedDateFrom, "Click on from date");
					// typeText(driver, test,OCR_MetrixByCitizenship_VISITREQUESTCreatedDateFrom , "Add visit from
					// date", FromDate);
					date(driver, test, "select date", FromDate);
				}

				Wait.waitfor(1);
				if (ToDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_VISITREQUESTCreatedDateTo, "Click on from date");
					// typeText(driver, test,OCR_MetrixByCitizenship_VISITREQUESTCreatedDateTo , "Add visit to
					// date", ToDate);
					date(driver, test, "select date", ToDate);
				}

				Wait.waitfor(1);
				if (SToDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_VISITREQUESTSubmittedDateTo, "Click on from date");
					// typeText(driver, test, OCR_MetrixByCitizenship_VISITREQUESTSubmittedDateTo , "Add visit To
					// date", SToDate);
					date(driver, test, "select date", SToDate);
				}

				Wait.waitfor(1);
				if (SFromDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_VISITREQUESTSubmittedDateFrom, "Click on from date");
					// typeText(driver, test, OCR_MetrixByCitizenship_VISITREQUESTSubmittedDateFrom , "Add visit
					// from date", SFromDate);
					date(driver, test, "select date", SFromDate);
				}

				Wait.waitfor(1);

				if (AFromDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_visitorRequestApprovedDateFrom, "Click on from date");
					// typeText(driver, test, OCR_MetrixByCitizenship_visitorRequestApprovedDateFrom , "Add visit
					// from date", AFromDate);
					date(driver, test, "select date", AFromDate);
				}

				Wait.waitfor(1);
				if (AToDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixByCitizenship_visitorRequestApprovedDateTo, "Click on from date");
					// typeText(driver, test, OCR_MetrixByCitizenship_visitorRequestApprovedDateTo , "Add visit to
					// date", AToDate);
					date(driver, test, "select date", AToDate);
				}

				scrollToElement(driver, OCR_MetrixByCitizenship_Search);

			}
			
		}


