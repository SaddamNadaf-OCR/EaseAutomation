package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultSystemGeneratedNumberPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultResultSystemGeneratedNumber_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultSystemGeneratedNumberPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of System Generated Number is displaying or not
	public void ResultSystemGeneratedNumberIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultResultSystemGeneratedNumber_Title);
			test.log(LogStatus.PASS, "Result System Generated Number Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result System Generated Number Is Not Displayed");

		}
	}

}
