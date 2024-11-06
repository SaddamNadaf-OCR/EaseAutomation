package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class createNewProgramPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ------------------------------Locator---------------------------------------------//

	public static final String Create_ProgramCode = "//input[@name='programTab.programCode']";
	public static final String Create_Description = "//textarea[@name='programTab.description']";
	public static final String OCR_Save = "//button[contains(text(),'Save')][1]";
	public static final String OCR_SaveandReturn = "//button[contains(text(),'Save & Return')]";

	// ----------------------------Constructor-------------------------------------------//

	public createNewProgramPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	// -----------------------------ProgramCode-------------------------------------------//

	public void enterProgramCode(String ProgramCode, String Description) {

		typeText(driver, test, Create_ProgramCode, "Enter ProgramCode :", ProgramCode);
		typeText(driver, test, Create_Description, "Enter Description :", Description);
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
