package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportSelectDocumentToImportPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SelectDocumentToImp_ImportBtn = "//button[@name='select']";
	public static final String OCR_SelectDocumentToImp_ReturnBtn = "//input[@name='cancel']";

	/* ******************** Constructor ***************************** */

	public ImportSelectDocumentToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Import button
	public void click_Import() {
		clickElement(driver, test, OCR_SelectDocumentToImp_ImportBtn, "Click on Import button");
	}

	//Click on Return button
	public void click_Return() {
		clickElement(driver, test, OCR_SelectDocumentToImp_ReturnBtn, "Click on Return button");
	}

}
