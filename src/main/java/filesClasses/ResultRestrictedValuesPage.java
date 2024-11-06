package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultRestrictedValuesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultSearchRestrictedIds_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultRestrictedValuesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Restricted Values is displaying or not
	public void ResultSearchRestrictedIdsIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultSearchRestrictedIds_Title);
			test.log(LogStatus.PASS, "Result Search Restricted Ids Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Search Restricted Ids Is Not Displayed");

		}
	}

}
