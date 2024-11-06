package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CargoReleaseFormPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddNewCR_SelectSBU = "//select[@id='createNewSimplifiedEntry_selSbu']";
	public static final String OCR_AddNewCR_ClickOnGo = "//button[@class='primary-btn']";

	/* ******************** Constructor ***************************** */

	public CargoReleaseFormPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select SBU & Click on Go
	public void SelectSbu(String SBU) {
		selectByVisibleText(driver, test, OCR_AddNewCR_SelectSBU, "select SBU : ", SBU);
	}

	public void clickGo() {
		clickElement(driver, test, OCR_AddNewCR_ClickOnGo, "click on Go");
	}

}
