package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultClassificationChangeHistoryPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_Classification_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultClassificationChangeHistoryPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
			
	/* ******************** Actions ********************************* */
	// Title of Classification Change History page is displaying or not
	public void ClassificationCHIsDisplayed() {
		try {
			isDisplayed(driver, OCR_Classification_Title);
				test.log(LogStatus.PASS, "Result ClassificationCH Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result ClassificationCH  Is Not Displayed");

				}
			}

}
