package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateAirportsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------Locators-------------------------------------------//
	
	public static final String OCR_AirportCode = "//input[@name='airport.destinationCode']";
	public static final String OCR_CountryCode = "//input[@id='editAirport_']";
	public static final String OCR_AirportName = "//textarea[@id='editAirport_airport_destinationName']";
	public static final String OCR_Save = "//button[@name='save.x']";
	public static final String OCR_SaveandReturn = "//button[@name='ok.x']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateAirportsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
// --------------------------Code----------------------//
	public void enter_AirportCode(String AirportCode, String CountryCode, String AirportName) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_AirportCode, "Enter Code :",AirportCode);
		typeText(driver, test, OCR_CountryCode, "enter CountryCode", CountryCode);
		typeText(driver, test, OCR_AirportName, "Enter AirportName :", AirportName);

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
