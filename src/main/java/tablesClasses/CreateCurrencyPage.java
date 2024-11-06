package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateCurrencyPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_CurrencyCode = "//input[@name='currency.currencyCode']";
	public static final String OCR_Description = "//textarea[@name='currency.description']";
	public static final String OCR_CountryCode = "//input[@name='currency.countryCode']";
	public static final String OCR_CustomCountryCode = "//input[@name='currency.customCountryCode']";
	public static final String OCR_CustomCurrencyCode = "//input[@name='currency.customCurrencyCode']";
	public static final String OCR_Save = "//button[@name='savex']";
	public static final String OCR_SaveandReturn = "//button[@name='okx']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateCurrencyPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_CurrencyCode(String CurrencyCode, String Description, String CountryCode, String CustomCountryCode, String CustomCurrencyCode) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_CurrencyCode, "Enter Code :",CurrencyCode);
		typeText(driver, test, OCR_Description, "enter Description", Description);
		typeText(driver, test, OCR_CountryCode, "Enter CountryCode :", CountryCode);
		typeText(driver, test, OCR_CustomCountryCode, "Enter CustomCountryCode :", CustomCountryCode);
		typeText(driver, test, OCR_CustomCurrencyCode, "Enter CustomCurrencyCode :", CustomCurrencyCode);

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
