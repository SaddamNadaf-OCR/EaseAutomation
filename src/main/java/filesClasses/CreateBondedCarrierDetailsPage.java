package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateBondedCarrierDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ---------------------------------Locators--------------------------------------//

	public static final String Create_CarrierCode = "//input[@name='comBondedCarrierDtlsValue.carrierCode']";
	public static final String Create_CarrierName = "//input[@name='comBondedCarrierDtlsValue.carrierName']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='okx']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateBondedCarrierDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------BondedCarrierCode-------------------------------------------//

	public void enterCarrierCode(String CarrierCode, String CarrierName) {

		typeText(driver, test, Create_CarrierCode, "Enter CarrierCode :", CarrierCode);
		typeText(driver, test, Create_CarrierName, "Enter Name :", CarrierName);
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
