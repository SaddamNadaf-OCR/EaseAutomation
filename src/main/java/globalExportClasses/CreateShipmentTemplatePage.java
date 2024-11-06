package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateShipmentTemplatePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateShipmentTemplatePage_CreateShipBtn  = "//button[@class='primary-btn ocr-cache-search-dynamic-class']";
	public static final String OCR_CreateShipmentTemplatePage_CancelBtn = "//button[@id='cancelAddShipment']";
	public static final String OCR_CreateShipmentTemplatePage_SBUCode = "//select[@id='selectedSbuCode']";


/* ******************************* Constructor ****************************** */

public CreateShipmentTemplatePage(WebDriver driver, ExtentTest test) {
	this.driver = driver;
	this.test = test;
}

/* ******************************* Actions ********************************* */
public void createShipTemplate() {
	Wait.waitfor(2);
	clickElement(driver, test, OCR_CreateShipmentTemplatePage_CreateShipBtn, "Click on Create Shipment Template button : ");
}

public void select_SBUCode(String SBUCode) {
	Wait.waitfor(2);
	selectByVisibleText(driver, test, OCR_CreateShipmentTemplatePage_SBUCode, "Select sbu code: ", SBUCode);
}


public void cancelBtn() {
	Wait.waitfor(2);
	clickElement(driver, test, OCR_CreateShipmentTemplatePage_CancelBtn, "Click on Cancel Button : ");
}
	
	

}
