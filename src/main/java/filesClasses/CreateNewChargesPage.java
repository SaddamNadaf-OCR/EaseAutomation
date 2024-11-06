package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewChargesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------------------Locators----------------------------------------//

	public static final String Create_ChargeCode = "//input[@name='chargeDetailsValue.chargeCode']";
	public static final String Create_ChargeDescription = "//input[@name='chargeDetailsValue.chargeDescription']";
	public static final String Create_ChargeIncurredAt = "//select[@name='chargeDetailsValue.incurredAt']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewChargesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------ChargeCode-------------------------------------------//

	public void enterChargeCode(String ChargeCode, String ChargeDescription, String ChargeIncurredAt) {

		typeText(driver, test, Create_ChargeCode, "Enter ChargeCode :", ChargeCode);
		typeText(driver, test, Create_ChargeDescription, "Enter Name :", ChargeDescription);
		selectByVisibleText(driver, test, Create_ChargeIncurredAt, "selecting ChargeIncurredAt by dropdown :",
				ChargeIncurredAt);
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
