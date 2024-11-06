package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultProgramPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultProgram_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultProgramPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Program is displaying or not
	public void ResultProgramIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultProgram_Title);
			test.log(LogStatus.PASS, "Result Program Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Program Is Not Displayed");

		}
	}


}
