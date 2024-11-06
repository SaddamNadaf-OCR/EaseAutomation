package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewImporterPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// --------------------------------Locators---------------------------------------------------//

	public static final String Create_ImporterCode = "//input[@name='importer.importerCode']";
	public static final String Create_ImporterName = "//input[@name='importer.importerName']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewImporterPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------ImporterCode-------------------------------------------//

	public void enterImporterCode(String ImporterCode, String ImporterName) {

		typeText(driver, test, Create_ImporterCode, "Enter OrderCategory Type :", ImporterCode);
		typeText(driver, test, Create_ImporterName, "Enter Name :", ImporterName);
	}

	// -------------------------------Save-------------------------------------------------//
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
