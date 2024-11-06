package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ExportInfoCountry extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*********************** Locators ************************/

	public static final String OCR_ExportInfoCountry_CountryTypeDropdwn = "//select[@id='editExportCountry_exportCountry_countryType']";
	public static final String OCR_ExportInfoCountry_AddCountry = "//select[@id='editExportCountry_exportCountry_countryCode']";
	public static final String OCR_ExportInfoCountry_MoveRightselectBtn = "//button[@name='move-right']";
	public static final String OCR_ExportInfoCountry_MoveLeftselectBtn = "//button[@name='move-left']";
	public static final String OCR_ExportInfoCountry_SaveandReturnBtn = "//input[@name='OK.x']";
	public static final String OCR_ExportInfoCountry_SaveBtn = "//input[@name='Save.x']";
	public static final String OCR_ExportInfoCountry_CancelBtn = "//input[@name='Cancel.x']";

	/************************* constructor ***********************/

	public ExportInfoCountry(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding the Country
	public void addCountry(String CountryType, String AddCountry) {
		selectByVisibleText(driver, test, OCR_ExportInfoCountry_CountryTypeDropdwn, "Select Export country : ",
				CountryType);
		selectByVisibleText(driver, test, OCR_ExportInfoCountry_AddCountry, "Select Add country : ", AddCountry);
		clickElement(driver, test, OCR_ExportInfoCountry_MoveRightselectBtn, "Move selected country to Right ");
		clickElement(driver, test, OCR_ExportInfoCountry_SaveBtn, "Click on Save Button");
		clickElement(driver, test, OCR_ExportInfoCountry_SaveandReturnBtn, "Click on Save and Return Button");
	}

}