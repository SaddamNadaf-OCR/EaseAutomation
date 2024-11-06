package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewInstructionsAndStatementsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ------------------------------------Locators-----------------------------------------------------//

	public static final String Create_InstructionsID = "//input[@name='instrcts.instructionsId']";
	public static final String Create_Descriptions = "//textarea[@name='instrcts.description']";
	public static final String OCR_Save = "//button[@name='save.x']";
	public static final String OCR_SaveandReturn = "//button[@name='okx']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewInstructionsAndStatementsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------InstructionsID-------------------------------------------//

	public void enterInstructionsID(String InstructionsID, String Descriptions) {

		typeText(driver, test, Create_InstructionsID, "Enter ProgramCode :", InstructionsID);
		typeText(driver, test, Create_Descriptions, "Enter Description :", Descriptions);
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
