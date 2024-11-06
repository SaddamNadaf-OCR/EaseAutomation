package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCustomCurrencyRateRulesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-------------------------------Locators-----------------------------------------------//
	public static final String OCR_CurrencyRules_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultCustomCurrencyRateRulesPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
					
/* ******************** Actions ********************************* */
// Title of Currency Rules page is displaying or not
		public void CurrencyRulesIsDisplayed() {
			try {
				isDisplayed(driver, OCR_CurrencyRules_Title);
					test.log(LogStatus.PASS, "Result CurrencyRules Is Displayed");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Result CurrencyRules   Is Not Displayed");

					}
				}


}
