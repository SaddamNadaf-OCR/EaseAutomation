package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class createNewSystemGeneratedNumberpage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ---------------------------Locator------------------------------------------------//

	public static final String Create_DatabaseName = "//select[@name='uniqueId.templateId']";
	public static final String Create_Template = "//input[@name='uniqueId.templateName']";
	public static final String Create_Width = "//input[@name='uniqueId.idWidth']";
	public static final String Create_LastNumberGenerated = "//input[@name='uniqueId.lastId']";
	public static final String Create_DefaultFlag = "//input[@name='uniqueId.defaultFlag'][1]";
	public static final String OCR_Save = "//button[contains(text(),'Save')][1]";
	public static final String OCR_SaveandReturn = "//button[@name='OK']";

	// -------------------------Constructor--------------------------------------------//

	public createNewSystemGeneratedNumberpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------DatabaseName----------------------------------//

	public void enterDatabaseName(String DatabaseName, String Template, String Width, String LastNumberGenerated) {
		selectByVisibleText(driver, test, Create_DatabaseName, "selecting DatabaseName by dropdown :", DatabaseName);
		typeText(driver, test, Create_Template, "Enter Template :", Template);
		typeText(driver, test, Create_Width, "Enter Width :", Width);
		typeText(driver, test, Create_LastNumberGenerated, "Enter LastNumberGenerated :", LastNumberGenerated);

	}

	// -------------------------------Save----------------------------------//

	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	// --------------------------------Save&Return-------------------------------------------//
	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}

}
