package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewCurrencyExchangeRateRulesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-----------------------------------------Locators-----------------------------------------------------------------//
	public static final String OCR_CustomCountry = "//input[@name='currencyExchangeRates.countryCode']";
	public static final String OCR_StandardRateType = "//select[@name='currencyExchangeRates.standardRateType']";
	public static final String OCR_RateAsOn = "//select[@name='currencyExchangeRates.rateAsOn']";
	public static final String OCR_Type = "//select[@name='currencyExchangeRates.action']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok.x']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateNewCurrencyExchangeRateRulesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
//--------------------------Code------------------------------------------------//
	public void enter_Country(String CustomCountry, String StandardRateType, String RateAsOn, String Type) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_CustomCountry, "Enter CustomCountry :",CustomCountry);
			selectByVisibleText(driver, test, OCR_StandardRateType, "enter StandardRateType", StandardRateType);
			selectByVisibleText(driver, test, OCR_RateAsOn, "Enter RateAsOn :", RateAsOn);
			selectByVisibleText(driver, test, OCR_Type, "Enter Type :", Type);
			

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
