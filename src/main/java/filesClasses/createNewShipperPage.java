package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class createNewShipperPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------------Locator----------------------------------//

	public static final String Create_Code = "//input[@name='shipperData.shipperCode']";
	public static final String Create_Name = "//input[@name='shipperData.shipperName']";
	public static final String OCR_Save = "//button[contains(text(),'Save')][1]";
	public static final String OCR_SaveandReturn = "//button[@name='saveandreturn']";

	// -------------------------------------Constructor-------------------------------//

	public createNewShipperPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// --------------------------------------Code--------------------------------------//

	public void enterCode(String Code, String Name) {

		typeText(driver, test, Create_Code, "Enter Code :", Code);
		typeText(driver, test, Create_Name, "Enter Name :", Name);
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
