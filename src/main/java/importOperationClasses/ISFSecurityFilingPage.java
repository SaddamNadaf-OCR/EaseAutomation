package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ISFSecurityFilingPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SecurityFiling_GoBtn = "//button[contains(text(),'Go')]";
	public static final String OCR_SecurityFiling_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_SecurityFiling_SelectSBU = "//select[@id='createNewImporterSecurityFiling_selSbu']";

	/* ******************** Constructor ***************************** */

	public ISFSecurityFilingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	public void clickOnGo() {
		clickElement(driver, test, OCR_SecurityFiling_GoBtn, "Click on Go");
	}
}
