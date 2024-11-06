package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateEEITransactionsTemplatePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateEEITransactionsTemplatePage_CreateEEIBtn  = "//button[@class='primary-btn ocr-cache-search-dynamic-class']";
	public static final String OCR_CreateEEITransactionsTemplatePage_CancelBtn = "//button[@id='cancelAddSed']";
	


/* ******************************* Constructor ****************************** */

public CreateEEITransactionsTemplatePage(WebDriver driver, ExtentTest test) {
	this.driver = driver;
	this.test = test;
}

/* ******************************* Actions ********************************* */
public void createEEITemplate() {
	Wait.waitfor(2);
	clickElement(driver, test, OCR_CreateEEITransactionsTemplatePage_CreateEEIBtn, "Click on Create EEI Template button : ");
}

public void cancelBtn() {
	Wait.waitfor(2);
	clickElement(driver, test, OCR_CreateEEITransactionsTemplatePage_CancelBtn, "Click on Cancel Button : ");
}

}
