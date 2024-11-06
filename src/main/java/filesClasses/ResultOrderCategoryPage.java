package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultOrderCategoryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ListOrderCategory_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultOrderCategoryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	// Title of Order Category page is displaying or not
	public void ResultListOrderCategoryIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ListOrderCategory_Title);
			test.log(LogStatus.PASS, "Result List Order Category Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result List Order Category Is Not Displayed");

		}
	}

}
