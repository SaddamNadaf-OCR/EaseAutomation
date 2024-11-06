package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateDeliveryOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DO_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_DO_CreateDO = "//button[contains(text(),'Create')]";

	/* ******************************* Constructor ****************************** */

	public CreateDeliveryOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Select the SBU code
	public void selectSBUcode(String SBUCode) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_DO_SBUCode, "Select the SBU Code : ", SBUCode);
	}

	// Click on Create Delivery Order
	public void clickCreateDO() {
		clickElement(driver, test, OCR_DO_CreateDO, "Click on Create Delivery Order");
	}

}
