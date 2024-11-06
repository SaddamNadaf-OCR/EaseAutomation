package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewGroundCarrierPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -----------------------------------------Locator-----------------------------------------//

	public static final String GroundCarrierCode = "//input[@name='groundCarrier.grCarrierCode']";
	public static final String Name = "//input[@name='groundCarrier.grCarrierName']";
	public static final String Code = "//input[@name='groundCarrier.carrierId']";
	public static final String OCR_Save = "//button[contains(text(),'Save')][1]";
	public static final String OCR_SaveandReturn = "//button[contains(text(),'Save & Return')]";

	// -------------------------------------------Constructor-----------------------------------------//

	public CreateNewGroundCarrierPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// --------------------------Ground Carrier Code----------------------//
	public void enter_GroundCarrierCode(String GroundCarrierCode, String GroundCarriername, String IATACode) {

		// typeText(driver, test,GroundCarrierCode, "EnterGroundCarrierCode :",
		// GroundCarrierCode+randomnumbers());
		Wait.waitfor(3);
		typeText(driver, test, Name, "Enter Name :", GroundCarriername);
		typeText(driver, test, Code, "Enter Code :", IATACode);

	}

	// --------------------------------Save--------------------------------------------//

	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}
	// -------------------------------------SaveandReturn---------------------//

	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}

}