package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorFrontDeskResultsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VFD_AdvancedSearchBtn = "//button[@id='dashboardAdvSearch']";
	public static final String OCR_VFD_NewVisitorBtn = "//i[@class='icon ocr-android-add']";
	public static final String OCR_VFD_VisitorDetilsTab = "//button[contains(text(),'Visit Details')]";
	public static final String OCR_VFD_VisitorReqID = "//input[@id='resultVisitorForDashboard_visitorSearchView_requestId']";
	public static final String OCR_VFD_Search = "//button[@name='advSearch']";
	public static final String OCR_VFD_AllCheckBox = "//input[@id='selectAllChk']";
	public static final String OCR_VFD_CheckInBtn = "//button[@class='c-btn with-icon sm']";
	public static final String OCR_VFD_CheckOutBtn = "//button[@class='c-btn col-red with-icon sm']";
	public static final String OCR_VFD_SaveAndReturn = "//button[@id='mybutton']";
	public static final String OCR_VFD_CLosePopUp = "//button[@class='close']";

	/* ******************** Constructor ***************************** */

	public VisitorFrontDeskResultsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click on Advanced Search Button
	public void click_AdvSearchBtn() {
		clickElement(driver, test, OCR_VFD_AdvancedSearchBtn, "Click on Advanced Search");
	}

	// click on New Visitor
	public void click_NewVisitor() {
		clickElement(driver, test, OCR_VFD_NewVisitorBtn, "Click on New Visitor");
	}

	// Search By Visitor Request ID
	public void searchVReqID(String VisitorReqID) {
		Wait.waitfor(6);
		clickElement(driver, test, OCR_VFD_VisitorDetilsTab, "Click on Visitor Details Tab");
		Wait.waitfor(3);
		typeText(driver, test, OCR_VFD_VisitorReqID, "Enter the Visitor Request ID : ", VisitorReqID);
	}

	// Search By Visitor Request ID
	public void searchVID(String VisitorID) {
		Wait.waitfor(6);
		clickElement(driver, test, OCR_VFD_VisitorDetilsTab, "Click on Visitor Details Tab");
		Wait.waitfor(3);
		typeText(driver, test, "//input[@id='resultVisitorForDashboard_visitorSearchView_visitorCode']",
				"Enter the Visitor ID : ", VisitorID);
	}

	// Click Search button
	public void clickSearch() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VFD_Search, "Click on Search button");
	}

	// Click on select all Check box and check in
	public void clickCheckIN() {
		clickElement(driver, test, OCR_VFD_AllCheckBox, "click on Select all Check Box");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VFD_CheckInBtn, "Click on Check In button");
	}

	// Click on Select all Check box and check out
	public void clickCheckOut() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VFD_AllCheckBox, "click on Select all Check Box");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VFD_CheckOutBtn, "Click on Check Out button");
		Wait.waitfor(4);
		try {
			clickElement(driver, test, OCR_VFD_SaveAndReturn, "Click on Save and Return");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VFD_CLosePopUp, "Click on Close PopUP");
		}
	}

	// Click on Select Check box and check out
	public void click_CheckOut(String vid) {
		Wait.waitfor(3);
		String check = "//input[@id='selectVisitor_" + vid + "1']";
		clickElement(driver, test, check, "click on " + vid + " Check Box");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VFD_CheckOutBtn, "Click on Check Out button");
		Wait.waitfor(3);
		try {
			clickElement(driver, test, OCR_VFD_SaveAndReturn, "Click on Save and Return");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_VFD_CLosePopUp, "Click on Close PopUP");
		}
	}

	// Click on Visitor Link
	public void clickVisitorLink(String VisitorName) {
		Wait.waitfor(3);
		clickElement(driver, test, "//a[contains(text(),'" + VisitorName + "')]",
				"Click on Visitor link : " + VisitorName);
	}

}
