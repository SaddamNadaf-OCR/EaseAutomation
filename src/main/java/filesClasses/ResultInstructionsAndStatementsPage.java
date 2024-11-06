package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultInstructionsAndStatementsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultInstructionsAndStatements_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultInstructionsAndStatementsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Instructions & Statements is displaying or not
	public void ResultResultInstructionsAndStatementsIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultInstructionsAndStatements_Title);
			test.log(LogStatus.PASS, "Result Instructions & Statements Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Instructions & Statements Is Not Displayed");

		}
	}


}
