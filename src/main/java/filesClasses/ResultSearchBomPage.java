package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultSearchBomPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchResultBom_Header = "//h3[contains (text(),'Bill Of Material Search Result')]";
	public static final String OCR_logout="//i[@class='fa fa-sign-out']";
	public static final String OCR_AddAuthOwner_Header = "//h3[contains (text(),'Authorization Owner')]";
	/* ******************************* Constructor ****************************** */

	public ResultSearchBomPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	// Verify the Page Title is Displayed or not
		public void displayOfTitle() {
			try {
				if (isDisplayed(driver, OCR_SearchResultBom_Header)) {
					test.log(LogStatus.PASS, "Result BOM page is Dispalyed");
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Result BOM page is not Dispalyed");
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}
		}
		
		public void logout() {
		clickElement(driver, test, OCR_logout, "click on logout");
		}
	
		
}
