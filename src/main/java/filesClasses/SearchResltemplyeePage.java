package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchResltemplyeePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchRsltEmployee_Header = "//h3[contains (text(),'Employees')]";
	public static final String OCR_logout="//i[@class='fa fa-sign-out']";
	public static final String OCR_AddAuthOwner_Header = "//h3[contains (text(),'Authorization Owner')]";
	/* ******************************* Constructor ****************************** */

	public SearchResltemplyeePage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	// Verify the Page Title is Displayed or not
		public void displayOfTitle() {
			try {
				if (isDisplayed(driver, OCR_SearchRsltEmployee_Header)) {
					test.log(LogStatus.PASS, "Result employee search page is Dispalyed");
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Result  employee search page is not Dispalyed");
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}
		}
		
		public void logout() {
		clickElement(driver, test, OCR_logout, "click on logout");
		}
	
		
}
