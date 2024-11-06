package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewCorrectiveActionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------------Locators-----------------------------------------------//

	public static final String Create_SBUCode = "//select[@id='sbuCode']";
	public static final String Create_Code = "//input[@name='correctiveAction.code']";
	public static final String Create_Description = "//textarea[@name='correctiveAction.description']";
	public static final String Create_Title = "//input[@name='correctiveAction.title']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewCorrectiveActionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------Code-------------------------------------------//

	public void enterSBUCode(String SBUCode, String Code, String Description, String Title) {

		selectByVisibleText(driver, test, Create_SBUCode, "Enter SBUCode :", SBUCode);
		typeText(driver, test, Create_Code, "Enter Code :", Code);
		typeText(driver, test, Create_Description, "Enter Name :", Description);
		typeText(driver, test, Create_Title, "Enter Title :", Title);

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
