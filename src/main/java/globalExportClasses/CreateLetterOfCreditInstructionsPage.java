package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class CreateLetterOfCreditInstructionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_RLCI_CreateRLCI = "//button[contains(text(),'Create Letter Of Credit Instructions')]";

	/* ******************************* Constructor ****************************** */

	public CreateLetterOfCreditInstructionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Create Letter Of Credit Instructions 
	public void clickCLCI() {
		clickElement(driver, test, OCR_RLCI_CreateRLCI, "click on Create Letter Of Credit Instructions ");
	}

}
