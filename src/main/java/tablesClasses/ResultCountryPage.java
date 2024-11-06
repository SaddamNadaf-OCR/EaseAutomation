package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCountryPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_Country_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultCountryPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
				
/* ******************** Actions ********************************* */
// Title of  Country page is displaying or not
	public void CountryIsDisplayed() {
		try {
			isDisplayed(driver, OCR_Country_Title);
				test.log(LogStatus.PASS, "Result Country Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result Country  Is Not Displayed");

				}
			}


}
