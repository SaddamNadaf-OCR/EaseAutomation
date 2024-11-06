package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportSelectItemToImportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SelectItemToImp_Select = "//input[@name='select']";
	public static final String OCR_SelectItemToImp_Return = "//input[@name='cancel']";
	/*
	 * public static final String OCR_SelectItemToImp_ public static final String
	 * OCR_SelectItemToImp_ public static final String OCR_SelectItemToImp_
	 */

	/* ******************** Constructor ***************************** */

	public ImportSelectItemToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Import button
	public void click_ItemImport() {
		clickElement(driver, test, OCR_SelectItemToImp_Select, "Click on Import button");
	}

	// Click on Return button
	public void click_ItemReturn() {
		clickElement(driver, test, OCR_SelectItemToImp_Return, "Click on Return button");
	}

}
