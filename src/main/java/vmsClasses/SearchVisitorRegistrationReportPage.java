package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorRegistrationReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VisitorsRegistrationReport_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_VisitorsRegistrationReport_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_VisitorsRegistrationReport_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_VisitorsRegistrationReport_VisitorRequestId = "//input[@id='resultVisitorRegistrationReport_visitorId']";
	public static final String OCR_VisitorsRegistrationReport_FirstName = "//input[@id='resultVisitorRegistrationReport_visitorRegistrationSearchView_firstName']";
	public static final String OCR_VisitorsRegistrationReport_LastName = "//input[@id='resultVisitorRegistrationReport_visitorRegistrationSearchView_lastName']";
	public static final String OCR_VisitorsRegistrationReport_EmailId = "//input[@id='resultVisitorRegistrationReport_visitorRegistrationSearchView_emailAddress']";
	public static final String OCR_VisitorsRegistrationReport_VisitorPhone = "//input[@id='resultVisitorRegistrationReport_visitorRegistrationSearchView_phone']";
	public static final String OCR_VisitorsRegistrationReport_DateRegisteredFrom = "//input[@id='resultVisitorRegistrationReport_fromCreatedDate']";
	public static final String OCR_VisitorsRegistrationReport_DateRegisteredTo = "//input[@id='resultVisitorRegistrationReport_toCreatedDate']";
	public static final String OCR_VisitorsRegistrationReport_LastUpdatedFrom = "//input[@id='resultVisitorRegistrationReport_fromUpdatedDate']";
	public static final String OCR_VisitorsRegistrationReport_LastUpdatedTo = "//input[@id='resultVisitorRegistrationReport_toUpdatedDate']";
	public static final String OCR_VisitorsRegistrationReport_SortBy = "//select[@id='resultVisitorRegistrationReport_sortBy']";
	public static final String OCR_VisitorsRegistrationReport_Direction = "//select[@id='resultVisitorRegistrationReport_direction']";
	public static final String OCR_VisitorsRegistrationReport_TitleofReport = "//h3[contains(text(),'Visitor Registration Report')]";

	/* ******************** Constructor ***************************** */

	public SearchVisitorRegistrationReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_VisitorsRegistrationReport_Search);
		clickElement(driver, test, OCR_VisitorsRegistrationReport_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_VisitorsRegistrationReport_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String RequestID, String FirstName, String LastName, String EmailID,
			String Phone, String DateRegisteredFrom, String DateRegisteredTo, String LastUpdatedFrom,
			String LastUpdatedTo, String SortBy, String Direction)

	{
		selectByVisibleText(driver, test, OCR_VisitorsRegistrationReport_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		typeText(driver, test, OCR_VisitorsRegistrationReport_VisitorRequestId, "Add Visitor request ID", RequestID);

		Wait.waitfor(2);
		typeText(driver, test, OCR_VisitorsRegistrationReport_FirstName, "Add visitor name", FirstName);
		typeText(driver, test, OCR_VisitorsRegistrationReport_LastName, "Adding Visitor Last Name", LastName);
		typeText(driver, test, OCR_VisitorsRegistrationReport_EmailId, "Adding Visitor Email ID", EmailID);
		typeText(driver, test, OCR_VisitorsRegistrationReport_VisitorPhone, "Selecting Visitor Phone", Phone);

		Wait.waitfor(2);
		if (DateRegisteredFrom.length() > 0) {
			clickElement(driver, test, OCR_VisitorsRegistrationReport_DateRegisteredFrom,
					"Click on registration from date");
			date(driver, test, "select date", DateRegisteredFrom);
		}

		Wait.waitfor(2);
		if (DateRegisteredTo.length() > 0) {
			clickElement(driver, test, OCR_VisitorsRegistrationReport_DateRegisteredTo,
					"Click on Date Registered To date");
			// typeText(driver,
			// test,OCR_VisitorsRegistrationReport_VISITREQUESTCreatedDateTo , "Add visit to
			// date", ToDate);
			date(driver, test, "select date", DateRegisteredTo);
		}

		Wait.waitfor(2);
		if (LastUpdatedFrom.length() > 0) {
			clickElement(driver, test, OCR_VisitorsRegistrationReport_LastUpdatedFrom,
					"Check on Last Updated From date");
			date(driver, test, "select date", LastUpdatedFrom);
		}

		Wait.waitfor(2);
		if (LastUpdatedTo.length() > 0) {
			clickElement(driver, test, OCR_VisitorsRegistrationReport_LastUpdatedTo, "Click on Last Updated To date");
			date(driver, test, "select date", LastUpdatedTo);
		}

		selectByVisibleText(driver, test, OCR_VisitorsRegistrationReport_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_VisitorsRegistrationReport_Direction, "select Direction ", Direction);
		scrollToElement(driver, OCR_VisitorsRegistrationReport_Search);

	}

}
