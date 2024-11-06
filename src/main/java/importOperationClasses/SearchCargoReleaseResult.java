package importOperationClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchCargoReleaseResult extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Search_CR_ResultTitle = "//h3[@class='page-heading']";

	/* ******************** Constructor ***************************** */

	public SearchCargoReleaseResult(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// verify the Search Authorization Page is Display or not
	public void searchCargoReleaseDisplay() {
		String pageTitle = getText(driver, test, OCR_Search_CR_ResultTitle, "Title of the Page : ");
		if (pageTitle.contains("List Cargo Release")) {
			test.log(LogStatus.PASS, "Search Cargo Release Results Page is Display");
		} else {
			test.log(LogStatus.FAIL, "Search Cargo Release Results Fail");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}
}
