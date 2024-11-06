package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultsearchFlagRsnPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchRsltFlagRsn_Header = "//h3[contains (text(),'Result Flag Reason')]";
	public static final String OCR_logout="//i[@class='fa fa-sign-out']";
	public static final String OCR_AddAuthOwner_Header = "//h3[contains (text(),'Authorization Owner')]";
	/* ******************************* Constructor ****************************** */

	public ResultsearchFlagRsnPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	// Verify the Page Title is Displayed or not
		public void displayOfTitle() {
			try {
				if (isDisplayed(driver, OCR_SearchRsltFlagRsn_Header)) {
					test.log(LogStatus.PASS, "Result flag reason search page is Dispalyed");
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Result flag reason search page is not Dispalyed");
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}
		}
		
		public void logout() {
		clickElement(driver, test, OCR_logout, "click on logout");
		}
	
		
}
