package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateCommercialCurrencyConversionPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-----------------------------------------Locators-----------------------------------------------------------------//
	public static final String OCR_CurrencyFrom = "//input[@name='conversionBusinessValue.currencyFrom']";
	public static final String OCR_CurrencyTo = "//input[@name='conversionBusinessValue.currencyTo']";
	public static final String OCR_CountryCode = "//input[@name='conversionBusinessValue.countryCode']";
	public static final String OCR_ConversionRate = "//input[@name='conversionRate']";
	public static final String OCR_ValidFrom = "//input[@name='validFrom']";
	public static final String OCR_ValidTo = "//input[@name='validTo']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateCommercialCurrencyConversionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
		
//--------------------------Code------------------------------------------------//
	public void enter_Code(String CurrencyFrom, String CurrencyTo, String CountryCode, String ConversionRate, String ValidFrom, String ValidTo) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_CurrencyFrom, "Enter CurrencyFrom :",CurrencyFrom);
		typeText(driver, test, OCR_CurrencyTo, "enter CurrencyTo", CurrencyTo);
		typeText(driver, test, OCR_CountryCode, "enter CountryCode", CountryCode);
		typeText(driver, test, OCR_ConversionRate, "Enter ConversionRate :", ConversionRate);
		clickElement(driver, test, OCR_ValidFrom, "Clicking On Valid From Date");
		date(driver, test, "Entering Valid From Date ", ValidFrom);
		clickElement(driver, test, OCR_ValidTo, "Clicking On Valid To Date");
		date(driver, test, "Entering Valid To Date ", ValidTo);
			

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
