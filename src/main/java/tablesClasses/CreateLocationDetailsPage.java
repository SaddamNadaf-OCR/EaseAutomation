package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateLocationDetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_CountryGroupCode = "//input[@name='comLocationDetailsValue.countryGroupCode']";
	public static final String OCR_LocationType = "//input[@name='comLocationDetailsValue.locationType']";
	public static final String OCR_LocationCode = "//input[@name='comLocationDetailsValue.locationCode']";
	public static final String OCR_LanguageCode = "//input[@name='comLocationDetailsValue.languageCode']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='saveandreturn']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateLocationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_LocationCode(String CountryGroupCode, String LocationType, String LocationCode, String LanguageCode) {
		Wait.waitfor(3);
			typeText(driver, test, OCR_CountryGroupCode, "Enter Code :",CountryGroupCode);
			typeText(driver, test, OCR_LocationType, "enter Description", LocationType);
			typeText(driver, test, OCR_LocationCode, "Enter LocationCode :", LocationCode);
			typeText(driver, test, OCR_LanguageCode, "Enter LanguageCode :", LanguageCode);
			

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
