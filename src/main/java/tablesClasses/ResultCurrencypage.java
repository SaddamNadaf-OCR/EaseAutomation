package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCurrencypage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_Currency_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

		public ResultCurrencypage(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
		}
					
	/* ******************** Actions ********************************* */
	// Title of Currency page is displaying or not
		public void CurrencyIsDisplayed() {
			try {
				isDisplayed(driver, OCR_Currency_Title);
					test.log(LogStatus.PASS, "Result Currency Is Displayed");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Result Currency   Is Not Displayed");

					}
				}


}