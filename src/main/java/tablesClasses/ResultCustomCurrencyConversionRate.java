package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCustomCurrencyConversionRate extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------Locators-----------------------------------------------//
	public static final String OCR_CustomCurrencyConversionRate_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultCustomCurrencyConversionRate(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
						
/* ******************** Actions ********************************* */
// Title of Custom Currency Conversion Rate page is displaying or not
	public void CustomCurrencyConversionRateIsDisplayed() {
		try {
			isDisplayed(driver, OCR_CustomCurrencyConversionRate_Title);
				test.log(LogStatus.PASS, "Result CustomCurrencyConversionRate Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result CustomCurrencyConversionRate   Is Not Displayed");

				}
			}
}
