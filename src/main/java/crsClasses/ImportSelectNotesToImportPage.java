package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportSelectNotesToImportPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SelectNotesToImp_Import = "//button[@name='select']";
	public static final String OCR_SelectNotesToImp_Return = "//button[@name='cancel']";

	/* ******************** Constructor ***************************** */
	public ImportSelectNotesToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Import button
	public void click_NoteImport() {
		clickElement(driver, test, OCR_SelectNotesToImp_Import, "Click on Import button");
	}

	//Click on Import button
	public void click_NoteReturn() {
		clickElement(driver, test, OCR_SelectNotesToImp_Return, "Click on Return button");
	}
}
