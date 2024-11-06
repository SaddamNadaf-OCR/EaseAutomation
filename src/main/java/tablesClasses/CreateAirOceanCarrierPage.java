package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateAirOceanCarrierPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//--------------------------------------Locators-----------------------------------------------------------//
	
	public static final String OCR_Code = "//input[@name='carrier.carrierCode']";
	public static final String OCR_SCACIATACode = "//input[@name='carrier.scacIataCode']";
	public static final String OCR_Descriptions = "//textarea[@name='carrier.description']";
	public static final String OCR_Save = "//input[@name='save']";
	public static final String OCR_SaveandReturn = "//input[@name='okx']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateAirOceanCarrierPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
// --------------------------Code----------------------//
	public void enter_Code(String Code, String SCACIATACode, String Descriptions) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_Code, "Enter Code :",Code);
		typeText(driver, test, OCR_SCACIATACode, "Enter SCACIATACode :",SCACIATACode);
		typeText(driver, test, OCR_Descriptions, "Enter Descriptions :", Descriptions);

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
