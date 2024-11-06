package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchReportsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------locators--------------

	public static final String OCR_Search_AdhocReport = "(//a[contains(text(),'Adhoc Report')])";
	public static final String OCR_Search_DebriefIncident = "(//a[contains(text(),'Debrief Incidents Report')])";
	public static final String OCR_Search_DebriefPending = "(//a[contains(text(),'Debrief Pending Report')])";
	public static final String OCR_Search_MetricsReport = "(//a[contains(text(),'Metrics Report')])";
	public static final String OCR_Search_MetricsByCitizenship = "(//a[contains(text(),'By Citizenship')])";
	public static final String OCR_Search_ByCountryRepresented = "(//a[contains(text(),'By Country Represented')])";
	public static final String OCR_Search_ByCountryofIncorporation = "(//a[contains(text(),'By Country of Incorporation')])";
	public static final String OCR_Search_ByExportAuthority = "(//a[contains(text(),'By Export Authority')])";
	public static final String OCR_Search_ByProgram = "(//a[contains(text(),'By Program')])";
	public static final String OCR_Search_BySegment = "(//a[contains(text(),'By Segment')])";
	public static final String OCR_Search_BySite = "(//a[contains(text(),'By Site')])";
	public static final String OCR_Search_StatusChangeReport = "(//a[contains(text(),'Status Change Report')])";
	public static final String OCR_Search_SummaryReport = "(//a[contains(text(),'Summary Report')])";
	public static final String OCR_Search_VisitorComprehensiveReport = "(//a[contains(text(),'Visitor Comprehensive Report')])";
	public static final String OCR_Search_VisitorDiscrepancyReport = "(//a[contains(text(),'Visitor Discrepancy Report')])";
	public static final String OCR_Search_VisitorLog = "(//a[contains(text(),'Visitor Log')])";
	public static final String OCR_Search_VisitorRegistration = "(//a[contains(text(),'Visitor Registration')])";

	/* ******************** Constructor ***************************** */

	public SearchReportsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Adhoc Report
	public void click_AdhocReport() {
		clickElement(driver, test, OCR_Search_AdhocReport, "click on Adhoc Reports");
	}

	// Click on Debrief Incidents Report
	public void click_DebriefIncidentsReport() {
		clickElement(driver, test, OCR_Search_DebriefIncident, "click on Debrief Incidents Report");
	}

	// Click on Debrief Pending Report
	public void click_DebriefPendingReport() {
		clickElement(driver, test, OCR_Search_DebriefPending, "click on Debrief Pending Report");
	}

	// Click on Metrics Report
	public void click_MetricsReport() {
		clickElement(driver, test, OCR_Search_MetricsReport, "click on Metrics Report");
	}

	// Click on Metrics Report By Citizenship
	public void click_ByCitizenship() {
		clickElement(driver, test, OCR_Search_MetricsByCitizenship, "Click on Metrics Report By Citizenship");
	}

	// Click on Metrics Report By Country Represented
	public void click_ByCountryRepresented() {
		clickElement(driver, test, OCR_Search_ByCountryRepresented, "Click on Metrics Report By Country Represented");
	}

	// Click on Metrics Report By Country of Incorporation
	public void click_ByCountryofIncorporation() {
		clickElement(driver, test, OCR_Search_ByCountryofIncorporation,
				"Click on Metrics Report By Country of Incorporation");
	}

	// Click on Metrics Report By Export Authority
	public void click_ByExportAuthority() {
		clickElement(driver, test, OCR_Search_ByExportAuthority, "Click on Metrics Report By Export Authority");
	}

	// Click on Metrics Report By Program
	public void click_ByProgram() {
		clickElement(driver, test, OCR_Search_ByProgram, "Click on Metrics Report By Program");
	}

	// Click on Metrics Report By Segment
	public void click_BySegment() {
		clickElement(driver, test, OCR_Search_BySegment, "Click on Metrics Report By Segment");
	}

	// Click on Metrics Report By Site
	public void click_BySite() {
		clickElement(driver, test, OCR_Search_BySite, "Click on Metrics Report By Site");
		
	}

	// Click on Status Change Report
	public void click_StatusChangeReport() {
		clickElement(driver, test, OCR_Search_StatusChangeReport, "click on Status Change Report");
	}

	// Click on Summary Report
	public void click_SummaryReport() {
		clickElement(driver, test, OCR_Search_SummaryReport, "click on Summary Report");
	}

	// Click on Visitor Comprehensive Report
	public void click_VisitorComprehensiveReport() {
		clickElement(driver, test, OCR_Search_VisitorComprehensiveReport, "click on Visitor Comprehensive Report");
	}

	// Click on Visitor Discrepancy Report
	public void click_VisitorDiscrepancyReport() {
		clickElement(driver, test, OCR_Search_VisitorDiscrepancyReport, "click on Visitor Discrepancy Report");
	}

	// Click on Visitor Log Report
	public void click_VisitorLogReport() {
		clickElement(driver, test, OCR_Search_VisitorLog, "click on Visitor Log Report");
	}

	// Click on Visitor Registration Report
	public void click_VisitorRegistration() {
		clickElement(driver, test, OCR_Search_VisitorRegistration, "click on Visitor Registration Report");
	}

}
