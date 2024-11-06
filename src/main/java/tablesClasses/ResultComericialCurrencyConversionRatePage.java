package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultComericialCurrencyConversionRatePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_Commercial_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultComericialCurrencyConversionRatePage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
			}
						
	/* ******************** Actions ********************************* */
	// Title of Commercial page is displaying or not
		public void CommercialIsDisplayed() {
			try {
				isDisplayed(driver, OCR_Commercial_Title);
					test.log(LogStatus.PASS, "Result Commercial Is Displayed");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Result Commercial   Is Not Displayed");

					}
				}



}
