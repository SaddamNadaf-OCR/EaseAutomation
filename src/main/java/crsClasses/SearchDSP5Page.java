package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchDSP5Page extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchDSP5_Features = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_SearchDSP5_Agreements = "//a[contains(text(),'Agreements')]/i";
	public static final String OCR_SearchDSP5_Agreement = "//li[3]//ul[1]//li[4]//div[1]//ul[1]//li[1]//a[1]";
	public static final String OCR_SearchDSP5_SBU = "//select[@id='resultDosGeneralInfo_dosGeneralInfo_sbuCode']";
	public static final String OCR_SearchDSP5_TransationID = "//input[@id='resultDosGeneralInfo_dosGeneralInfo_transactionId']";
	public static final String OCR_SearchDSP5_SearchBtn = "//button[@name='Search']";

	/* ******************** Constructor ***************************** */

	public SearchDSP5Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to features and click Compliance Request
	public void moveTo_Features() {
		mouseOver(driver, test, OCR_SearchDSP5_Features, "Mouse over on Features");
	}

	// click on Requests
	public void click_Agreements() throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchDSP5_Agreements, "Clicking on Agreements");
	}

	// click on Agreement
	public void click_Agreement() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchDSP5_Agreement, "Clicking on Agreement ");
	}

	// Select Sbu
	public void select_SBU(String SBU, String TransationID) {
		selectByVisibleText(driver, test, OCR_SearchDSP5_SBU, "Select the SBU : ", SBU);
		typeText(driver, test, OCR_SearchDSP5_TransationID, "Enter the Transation ID: ", TransationID);
	}

	// Click on Search button
	public void click_SearchBtn() {
		clickElement(driver, test, OCR_SearchDSP5_SearchBtn, "Click on Search  button");
	}

}
