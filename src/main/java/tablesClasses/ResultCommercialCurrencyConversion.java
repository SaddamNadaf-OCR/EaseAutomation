package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCommercialCurrencyConversion extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------Locators-----------------------------------------------//
	public static final String OCR_CommercialCurrencyConversion_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultCommercialCurrencyConversion(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
							
/* ******************** Actions ********************************* */
// Title of Custom Currency Conversion  page is displaying or not
	public void CommercialCurrencyConversionIsDisplayed() {
		try {
			isDisplayed(driver, OCR_CommercialCurrencyConversion_Title);
				test.log(LogStatus.PASS, "Result CustomCurrencyConversion Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result CustomCurrencyConversion Is Not Displayed");

				}
			}


}
