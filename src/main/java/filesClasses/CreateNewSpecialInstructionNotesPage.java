package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewSpecialInstructionNotesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------//

	public static final String Create_Category = "//input[@name='notes.category']";
	public static final String Create_Notes = "//textarea[@name='notes.notes']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[contains(text(),'Save & Return')]";

	// ----------------------------Constructor-------------------------------------------//

	public CreateNewSpecialInstructionNotesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// ---------------------------Category---------------------------------------------//

	public void enterCategory(String Category, String Notes) {

		typeText(driver, test, Create_Category, "Enter ProgramCode :", Category);
		typeText(driver, test, Create_Notes, "Enter Description :", Notes);
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
