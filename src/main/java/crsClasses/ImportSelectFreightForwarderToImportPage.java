package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportSelectFreightForwarderToImportPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SelectFFtoImp_ImportBtn = "//button[@name='select']";
	public static final String OCR_SelectFFtoImp_ReturnBtn = "//button[@name='cancel']";

	/* ******************** Constructor ***************************** */

	public ImportSelectFreightForwarderToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Import button
	public void click_FFImport() {
		clickElement(driver, test, OCR_SelectFFtoImp_ImportBtn, "Click on Import button");
	}
	
	//Click on Return button
	public void click_FFReturn() {
		clickElement(driver, test, OCR_SelectFFtoImp_ReturnBtn, "Click on Return button");
	}

}
