package vmsClasses;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;
public class VisitorSummaryReportByExportAuthorityPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	// -----------------------------locators--------------
	public static final String OCR_MetrixByExportAuthority_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_MetrixByExportAuthority_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_MetrixByExportAuthority_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_MetrixByExportAuthority_VisitorRequestId = "//input[@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_MetrixByExportAuthority_VisitorName = "//input[@id='resultVisitorMetricesSubReport_visitorName']";
	public static final String OCR_MetrixByExportAuthority_VisitRequestFrom = "//input[@id='resultVisitorMetricesSubReport_visitDateFrom']";
	public static final String OCR_MetrixByExportAuthority_VisitDateTo = "//input[@id='resultVisitorMetricesSubReport_visitDateTo']";
	public static final String OCR_MetrixByExportAuthority_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_MetrixByExportAuthority_VisitorCategory = "//select[@id='resultVisitorMetricesSubReport_visitCategory']";
	public static final String OCR_MetrixByExportAuthority_MeetingCategory = "(//div[@class='ms-trigger'])[1]";
	public static final String OCR_MetrixByExportAuthority_OrganizationDomesticForeign_ = "//select [@name='visitorCompanyValue.usForeign']";
	public static final String OCR_MetrixByExportAuthority_Programs = "//textarea [@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_program']";
	public static final String OCR_MetrixByExportAuthority_TDYSegment = "//textarea [@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_MetrixByExportAuthority_ProductFamily = "//textarea [@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_MetrixByExportAuthority_ProductLine = "//textarea [@id='resultVisitorMetricesSubReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_MetrixByExportAuthority_Sites = "(//div[@class='ms-trigger'])[2]";
	public static final String OCR_MetrixByExportAuthority_VISITREQUESTCreatedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateFrom']";
	public static final String OCR_MetrixByExportAuthority_VISITREQUESTCreatedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestCreatedDateTo']";
	public static final String OCR_MetrixByExportAuthority_VISITREQUESTSubmittedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateFrom']";
	public static final String OCR_MetrixByExportAuthority_VISITREQUESTSubmittedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitRequestSubmittedDateTo']";
	public static final String OCR_MetrixByExportAuthority_visitorRequestApprovedDateFrom = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateFrom']";
	public static final String OCR_MetrixByExportAuthority_visitorRequestApprovedDateTo = "//input[@id='resultVisitorMetricesSubReport_visitorRequestApprovedDateTo']";
	private static final String OCR_MetrixByExportAuthority_SiteTextBox = null;
	public VisitorSummaryReportByExportAuthorityPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}

	/* ******************** Actions ********************************* */

	public void clicksearchbutton() {

		scrollToElement(driver, OCR_MetrixByExportAuthority_Search);

		clickElement(driver, test, OCR_MetrixByExportAuthority_Search, "click on Search button");

	}

	public void clickResetButton() {

		clickElement(driver, test, OCR_MetrixByExportAuthority_Reset, "click on Reset button");

	}

	public void searchParameters(String SBUCode, String RequestID, String VisitorName, String VisitRequestFrom,
			String VisitRequestTo, String VisitorCategory, String Site, String FromDate, String ToDate,
			String SFromDate, String SToDate, String AFromDate, String AToDate)
	{
		selectByVisibleText(driver, test, OCR_MetrixByExportAuthority_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_MetrixByExportAuthority_VisitorRequestId, "Add Visitor request ID", RequestID);
		Wait.waitfor(1);
		typeText(driver, test, OCR_MetrixByExportAuthority_VisitorName, "Add visitor name", VisitorName);
		// Add Visit request from (mm-dd-yyyy)
		Wait.waitfor(1);
		if (VisitRequestFrom.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_VisitRequestFrom, "Click on from date");
			date(driver, test, "select date", VisitRequestFrom);
		}
		Wait.waitfor(1);
		if (VisitRequestTo.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_VisitDateTo, "Click on from date");
			date(driver, test, "select date", VisitRequestTo);
		}
		Wait.waitfor(1);
		Wait.waitfor(1);
		selectByVisibleText(driver, test, OCR_MetrixByExportAuthority_VisitorCategory, "Selecting Visitor Category",
				VisitorCategory);
		scrollToBottom(driver);
		if (Site.length() > 0) {
			typeText(driver, test, OCR_MetrixByExportAuthority_SiteTextBox, "Type site name", Site);
		}
		Wait.waitfor(1);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_VISITREQUESTCreatedDateFrom, "Click on from date");
			date(driver, test, "select date", FromDate);
		}
		Wait.waitfor(1);
		if (ToDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_VISITREQUESTCreatedDateTo, "Click on from date");
			date(driver, test, "select date", ToDate);
		}

		Wait.waitfor(1);
		if (SToDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_VISITREQUESTSubmittedDateTo, "Click on from date");
			date(driver, test, "select date", SToDate);
		}
		Wait.waitfor(1);
		if (SFromDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_VISITREQUESTSubmittedDateFrom, "Click on from date");
			date(driver, test, "select date", SFromDate);
		}
		Wait.waitfor(1);
		if (AFromDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_visitorRequestApprovedDateFrom, "Click on from date");
			date(driver, test, "select date", AFromDate);
		}
		Wait.waitfor(1);
		if (AToDate.length() > 0) {
			clickElement(driver, test, OCR_MetrixByExportAuthority_visitorRequestApprovedDateTo, "Click on from date");
			date(driver, test, "select date", AToDate);
		}
		scrollToElement(driver, OCR_MetrixByExportAuthority_Search);
	}
}