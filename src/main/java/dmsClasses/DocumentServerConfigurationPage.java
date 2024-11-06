package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class DocumentServerConfigurationPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AddNewDocServer = "//button[contains(text(),'Add New Document Server')]";

	/* ******************************* Constructor ****************************** */

	public DocumentServerConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void addnewdocserver() {
		clickElement(driver, test, OCR_AddNewDocServer, "Clicking on Add New Document Server");
	}

}
