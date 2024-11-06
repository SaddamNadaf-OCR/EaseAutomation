package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCorrectiveActionPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultCorrectiveAction_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultCorrectiveActionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Corrective Action page is displaying or not
	public void ResultCorrectiveActionIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultCorrectiveAction_Title);
			test.log(LogStatus.PASS, "Result Corrective Action Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Corrective Action Is Not Displayed");

		}
	}

}



