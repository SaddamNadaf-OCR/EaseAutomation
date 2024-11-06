package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateModeOfPaymentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_PaymentCode = "//input[@name='sdMethodsOfPaymentValue.paymentCode']";
	public static final String OCR_Description = "//textarea[@name='sdMethodsOfPaymentValue.description']";
	public static final String OCR_CountryCode = "//input[@name='sdMethodsOfPaymentValue.countryCode']";
	public static final String OCR_Qualifier = "//input[@name='sdMethodsOfPaymentValue.qualifer']";
	public static final String OCR_Notes = "//textarea[@name='sdMethodsOfPaymentValue.notes']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='saveandreturn']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateModeOfPaymentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_MOPCode(String PaymentCode, String Description, String CountryCode, String Qualifier, String Notes) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_PaymentCode, "Enter Code :",PaymentCode);
		typeText(driver, test, OCR_Description, "enter Description", Description);
		typeText(driver, test, OCR_CountryCode, "Enter CountryCode :", CountryCode);
		typeText(driver, test, OCR_Qualifier, "Enter Qualifier :", Qualifier);
		typeText(driver, test, OCR_Notes, "Enter Notes :", Notes);

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
