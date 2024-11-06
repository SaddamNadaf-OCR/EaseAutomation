package lpreports;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePageReport extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='nav-link dropdown-item'])[2]";
	public static final String OCR_HomePage_ModuleLP = "//a[contains(text(),'License/Permit Application')]";
	public static final String OCR_HomePage_ModuleLP2 = "(//a[contains(text(),'License/Permit Application')])[2]";
	public static final String OCR_HomePage_LpReport = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_AdhocApplicationReport = "//a[contains(text(),'Ad hoc Application Report')]";
	public static final String OCR_HomePage_AuthorisationDetails = "//a[contains(text(),'Authorisation Details')]";
	public static final String OCR_HomePage_AuthorisationSummary = "//a[contains(text(),'Authorisation Summary')]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_WebServiceAuditReport = "//a[contains(text(),'Web Service Audit Report')]";

	/* ******************** Constructor ***************************** */

	public HomePageReport(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// MouseOver to SBU Select and Module Selection and Click on Add/View/Edit
	// License Permit
	public void moveTo_SBUSelection(String SBU) {
		//Wait.waitfor(8);
		/*
		 * mouseOver(driver, test, OCR_HomePage_SBU, "Mouseover to SBU selection");
		 * Wait.waitfor(5); String SBUName = "//label[contains(text(),'" + SBU + "')]";
		 * clickElement(driver, test, SBUName, "Click on " + SBU); Wait.waitfor(2);
		 */
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleLP, "Click on LP Module");
		Wait.waitfor(3);
	}

	// Click on Reports
	public void movetoAdhocReports() {
		mouseOver(driver, test, OCR_HomePage_LpReport, "Mouseover to LP Report");
		clickElement(driver, test, OCR_HomePage_AdhocApplicationReport, "Click on Adhoc Application Report");
	}

	// Click on Reports
	public void movetoAuthorisationDetailsReports() {
		mouseOver(driver, test, OCR_HomePage_LpReport, "Mouseover to LP Report");
		clickElement(driver, test, OCR_HomePage_AuthorisationDetails, "Click on Authorisation Details Report");
	}

	// Click on Reports
	public void movetoAuthorisationSummaryReports() {
		mouseOver(driver, test, OCR_HomePage_LpReport, "Mouseover to LP Report");
		clickElement(driver, test, OCR_HomePage_AuthorisationSummary, "Click on Authorisation Summary Report");
	}

	// Click on Reports
	public void movetoProductReports() {
		mouseOver(driver, test, OCR_HomePage_LpReport, "Mouseover to LP Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report");
	}

	// Click on Reports
	public void movetoWebServiceAuditReports() {
		mouseOver(driver, test, OCR_HomePage_LpReport, "Mouseover to LP Report");
		clickElement(driver, test, OCR_HomePage_WebServiceAuditReport, "Click on WebService Audit Report");
	}

	// Return to LP Home page
	public void returnHomepageLP() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleLP2, "Click on LP Module");
	}

}
