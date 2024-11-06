package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorSummaryReportBySegmentPage  extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------locators--------------
	
			public static final String OCR_MetrixBySegment_Search = "//button[contains(text(),'Search')]";
			public static final String OCR_MetrixBySegment_Reset = "//button[contains(text(),'Reset')]";
			public static final String OCR_MetrixBySegment_SBUcode = "//select[@id='sbuCode']";
			public static final String OCR_MetrixBySegment_VisitorRequestId = "//input[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_visitorId']";
			public static final String OCR_MetrixBySegment_VisitorName = "//input[@id='resultVisitorMetricesSubReport_visitorName']";
			public static final String OCR_MetrixBySegment_VisitRequestFrom = "//input[@id='resultVisitorMetricesSubReport_visitDateFrom']";
			public static final String OCR_MetrixBySegment_VisitDateTo = "//input[@id='resultVisitorMetricesSubReport_visitDateTo']";
			public static final String OCR_MetrixBySegment_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
			public static final String OCR_MetrixBySegment_VisitorCategory = "//select[@id='resultVisitorMetricesSubReport_visitCategory']";
			public static final String OCR_MetrixBySegment_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
			public static final String OCR_MetrixBySegment_Programs = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_program']";
			public static final String OCR_MetrixBySegment_TDYSegment = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_segment']";
			public static final String OCR_MetrixBySegment_ProductFamily = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productFamily']";
			public static final String OCR_MetrixBySegment_ProductLine = "//textarea[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productLine']";
			public static final String OCR_MetrixBySegment_Sites = "//div[@class='ms-trigger'][1]";
			public static final String OCR_MetrixBySegment_VISITREQUESTCreatedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateFrom']";
			public static final String OCR_MetrixBySegment_VISITREQUESTCreatedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateTo']";
			public static final String OCR_MetrixBySegment_VISITREQUESTSubmittedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateFrom']";
			public static final String OCR_MetrixBySegment_VISITREQUESTSubmittedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateTo']";
			public static final String OCR_MetrixBySegment_visitorRequestApprovedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateFrom']";
			public static final String OCR_MetrixBySegment_visitorRequestApprovedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateTo']";
			public static final String OCR_MetrixBySegment_SiteTextBox="//input[@placeholder='Please select Site...']";
			public static final String OCR_MetrixVisitor_SummaryReportBySegment_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Segment')]";

			public VisitorSummaryReportBySegmentPage(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
			}
			
			/* ******************** Actions ********************************* */

			public void clickSearchbutton() {
				scrollToElement(driver, OCR_MetrixBySegment_Search);
				clickElement(driver, test, OCR_MetrixBySegment_Search, "Click on search button");
			}

			public void clickResetButton() {
				clickElement(driver, test, OCR_MetrixBySegment_Reset, "Click on reset button");
			}

			public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
					String VisitRequestTo, String VisitorCategory, String site,
					String FromDate, String ToDate,  String SFromDate, String SToDate, String AFromDate, String AToDate)

			{
				selectByVisibleText(driver, test, OCR_MetrixBySegment_SBUcode, "Select SBU code", SBUCode);
				Wait.waitfor(4);
				typeText(driver, test, OCR_MetrixBySegment_VisitorRequestId, "Add Visitor request ID", RequestID);

				Wait.waitfor(1);
				typeText(driver, test, OCR_MetrixBySegment_VisitorName, "Add visitor name", VisitorName);

				// Add Visit request from (mm-dd-yyyy)
				Wait.waitfor(1);
				if (VisitRequestFrom.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_VisitRequestFrom, "Click on from date");
					date(driver, test, "select date", VisitRequestFrom);
				}
				Wait.waitfor(1);
				if (VisitRequestTo.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_VisitDateTo, "Click on from date");
					// typeText(driver, test,OCR_MetrixBySegment_VisitDateTo, "Add visit from date",
					// VisitRequestTo);
					date(driver, test, "select date", VisitRequestTo);
				}
				Wait.waitfor(1);

				

				Wait.waitfor(1);
				
				selectByVisibleText(driver, test, OCR_MetrixBySegment_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
				scrollToBottom(driver);
				if (site.length() > 0) {
					typeText(driver, test, OCR_MetrixBySegment_SiteTextBox, "Type site name", site);
					
				}

				Wait.waitfor(1);
				if (FromDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_VISITREQUESTCreatedDateFrom, "Click on from date");
					// typeText(driver, test,OCR_MetrixBySegment_VISITREQUESTCreatedDateFrom , "Add visit from
					// date", FromDate);
					date(driver, test, "select date", FromDate);
				}

				Wait.waitfor(1);
				if (ToDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_VISITREQUESTCreatedDateTo, "Click on from date");
					// typeText(driver, test,OCR_MetrixBySegment_VISITREQUESTCreatedDateTo , "Add visit to
					// date", ToDate);
					date(driver, test, "select date", ToDate);
				}

				Wait.waitfor(1);
				if (SToDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_VISITREQUESTSubmittedDateTo, "Click on from date");
					// typeText(driver, test, OCR_MetrixBySegment_VISITREQUESTSubmittedDateTo , "Add visit To
					// date", SToDate);
					date(driver, test, "select date", SToDate);
				}

				Wait.waitfor(1);
				if (SFromDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_VISITREQUESTSubmittedDateFrom, "Click on from date");
					// typeText(driver, test, OCR_MetrixBySegment_VISITREQUESTSubmittedDateFrom , "Add visit
					// from date", SFromDate);
					date(driver, test, "select date", SFromDate);
				}

				Wait.waitfor(1);

				if (AFromDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_visitorRequestApprovedDateFrom, "Click on from date");
					// typeText(driver, test, OCR_MetrixBySegment_visitorRequestApprovedDateFrom , "Add visit
					// from date", AFromDate);
					date(driver, test, "select date", AFromDate);
				}

				Wait.waitfor(1);
				if (AToDate.length() > 0) {
					clickElement(driver, test, OCR_MetrixBySegment_visitorRequestApprovedDateTo, "Click on from date");
					// typeText(driver, test, OCR_MetrixBySegment_visitorRequestApprovedDateTo , "Add visit to
					// date", AToDate);
					date(driver, test, "select date", AToDate);
				}

				scrollToElement(driver, OCR_MetrixBySegment_Search);

			}
			
		


}
