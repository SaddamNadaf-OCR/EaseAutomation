package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultConfidenceLevelPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ConfidenceLevel_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultConfidenceLevelPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
				
/* ******************** Actions ********************************* */
// Title of Commodity Type page is displaying or not
	public void ConfidenceLevelIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ConfidenceLevel_Title);
				test.log(LogStatus.PASS, "Result ConfidenceLevel Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result ConfidenceLevel  Is Not Displayed");

				}
			}


}
