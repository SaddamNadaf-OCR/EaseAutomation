package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class createNewRestrictedIdsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ------------------------------------Locator-----------------------------------//

	public static final String Create_AccountNumber = "//input[@name='restrictedValueTab.accountNumber']";
	public static final String Create_RestrictedValues = "//input[@name='restrictedValueTab.restPrefixText']";
	public static final String OCR_Save = "//button[contains(text(),'Save')][1]";
	public static final String OCR_SaveandReturn = "//button[contains(text(),'Save & Return')]";

	// -----------------------------Constructor-------------------------------------------//

	public createNewRestrictedIdsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// ------------------------------------AccountNumber------------------------------------//

	public void enterAccountNumber(String AccountNumber, String RestrictedValues) {

		typeText(driver, test, Create_AccountNumber, "Enter AccountNumber :", AccountNumber);
		typeText(driver, test, Create_RestrictedValues, "Enter RestrictedValues :", RestrictedValues);
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
