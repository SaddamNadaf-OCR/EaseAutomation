package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class AddflagresultPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchResultflagreason_Header = "//h3[contains (text(),'Edit Flag Reason')]";
	public static final String OCR_logout = "//i[@class='fa fa-sign-out']";

	/* ******************************* Constructor ****************************** */

	public AddflagresultPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, OCR_SearchResultflagreason_Header)) {
				test.log(LogStatus.PASS, "Result Add flagreason page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Add flagreason page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

	public void logout() {
		clickElement(driver, test, OCR_logout, "click on logout");
	}

}