package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportSelectCountryToImportPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SelectCountryToImp_ImportBtn = "//input[@name='select']";
	public static final String OCR_SelectCountryToImp_ReturnBtn = "//input[@name='cancel']";

	/* ******************** Constructor ***************************** */

	public ImportSelectCountryToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Import button
	public void click_CountryImport() {
		clickElement(driver, test, OCR_SelectCountryToImp_ImportBtn, "Click on Import button");
	}

	//Click on Return button
	public void click_CountryReturn() {
		clickElement(driver, test, OCR_SelectCountryToImp_ReturnBtn, "Click on Import button");
	}

}
