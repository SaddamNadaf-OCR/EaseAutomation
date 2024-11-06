package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorsDiscrepancyReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitorsDiscrepancyReport_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_VisitorsDiscrepancyReport_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_VisitorsDiscrepancyReport_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_VisitorsDiscrepancyReport_VisitRequestFrom = "//input[@id='resultVisitorDiscrepancyReport_visitDateFrom']";
	public static final String OCR_VisitorsDiscrepancyReport_VisitDateTo = "//input[@id='resultVisitorDiscrepancyReport_visitDateTo']";
	public static final String OCR_VisitorsDiscrepancyReport_VisitorRequestId = "//input[@id='resultVisitorDiscrepancyReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_VisitorsDiscrepancyReport_VisitorName = "//input[@id='resultVisitorDiscrepancyReport_visitorSearchView_firstName']";
	public static final String OCR_VisitorsDiscrepancyReport_VisitorDomesticForeign = "//select[@name='visitorPersonVal.domesticorForeign']";
	public static final String OCR_VisitorsDiscrepancyReport_VisitorCategory = "//select[@id='resultVisitorDiscrepancyReport_visitCategory']";
	public static final String OCR_VisitorsDiscrepancyReport_OrganizationDomesticForeign_ = "//select[@name='visitorCompanyValue.usForeign']";
	public static final String OCR_VisitorsDiscrepancyReport_Country = "//input[@id='resultVisitorDiscrepancyReport_visitorCompanyValue_country']";
	public static final String OCR_VisitorsDiscrepancyReport_CountryOfIncorporation = "//input[@id='resultVisitorDiscrepancyReport_visitorCompanyValue_countryIncorp']";
	public static final String OCR_VisitorsDiscrepancyReport_PrimaryHostName = "//input[@id='primaryHostUserFullName']";
	public static final String OCR_VisitorsDiscrepancyReport_RequesterName = "//input[@id='resultVisitorDiscrepancyReport_visitorGeneralInfoValue_requestorName']";
	public static final String OCR_VisitorsDiscrepancyReport_SortBy = "//select[@name='sortBy']";
	public static final String OCR_VisitorsDiscrepancyReport_Direction = "//select[@name='direction']";
	public static final String OCR_VisitorsDiscrepancyReport_SiteTextBox="//input[@xpath='1']";
	public static final String OCR_VisitorsDiscrepancyReport_TitleofReport ="//h3[@xpath='1']";

	/* ******************** Constructor ***************************** */

	public SearchVisitorsDiscrepancyReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_VisitorsDiscrepancyReport_Search);
		clickElement(driver, test, OCR_VisitorsDiscrepancyReport_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_VisitorsDiscrepancyReport_Reset, "Click on reset button");
	}
	public void clickHeaderDiscrepancy() {
		clickElement(driver, test, OCR_VisitorsDiscrepancyReport_TitleofReport, "Click Result Visitors Discrepancy Report");
	}
	public void searchParameters(String SBUCode,String VisitRequestFrom, String VisitRequestTo, String RequestID, String VisitorName,   
			String VisitorCategory, String site, String SortBy, String Direction)

	{
		selectByVisibleText(driver, test, OCR_VisitorsDiscrepancyReport_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_VisitorsDiscrepancyReport_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(2);
		typeText(driver, test, OCR_VisitorsDiscrepancyReport_VisitorName, "Add visitor name", VisitorName);

		// Add Visit request from (mm-dd-yyyy)
		Wait.waitfor(2);
		if (VisitRequestFrom.length() > 0) {
			clickElement(driver, test, OCR_VisitorsDiscrepancyReport_VisitRequestFrom, "Click on from date");
			date(driver, test, "select date", VisitRequestFrom);
		}

		// typeText(driver, test, OCR_VisitorsDiscrepancyReport_VisitRequestFrom, "Add visit from date",
		// VisitRequestFrom);

		Wait.waitfor(2);
		if (VisitRequestTo.length() > 0) {
			clickElement(driver, test, OCR_VisitorsDiscrepancyReport_VisitDateTo, "Click on from date");
			// typeText(driver, test,OCR_VisitorsDiscrepancyReport_VisitDateTo, "Add visit from date",
			// VisitRequestTo);
			date(driver, test, "select date", VisitRequestTo);
		}
		Wait.waitfor(2);
		
		selectByVisibleText(driver, test, OCR_VisitorsDiscrepancyReport_VisitorCategory, "Selecting Visitor Category", VisitorCategory);
		scrollToBottom(driver);
		if (site.length() > 0) {
			typeText(driver, test, OCR_VisitorsDiscrepancyReport_SiteTextBox, "Type site name", site);
			
		}

		selectByVisibleText(driver, test, OCR_VisitorsDiscrepancyReport_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_VisitorsDiscrepancyReport_Direction, "select Direction ", Direction);
		scrollToElement(driver, OCR_VisitorsDiscrepancyReport_Search);
		
		
	}

}

