package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewProductFamilyPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ----------------------------------Locator-------------------------------------------//

	public static final String Create_ProductFamilyID = "//textarea[@name='dosProdFamily.familyId']";
	public static final String Create_ProductFamilyName = "//input[@name='dosProdFamily.prodFamilyName']";
	public static final String OCR_Save = "//input[@name='save']";
	public static final String OCR_SaveandReturn = "//input[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewProductFamilyPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------ProductFamilyID-------------------------------------------//

	public void enterProductFamilyID(String ProductFamilyID, String ProductFamilyName) {

		typeText(driver, test, Create_ProductFamilyID, "Enter ProgramCode :", ProductFamilyID);
		typeText(driver, test, Create_ProductFamilyName, "Enter Description :", ProductFamilyName);
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
