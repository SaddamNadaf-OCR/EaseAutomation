package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultFFpage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchResultFF_Header ="//h3[contains (text(),'Freight Forwarder')]";
	
	/* ******************************* Constructor ****************************** */

	public ResultFFpage (WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	// Verify the Page Title is Displayed or not
		public void displayOfTitle() {
			try {
				if (isDisplayed(driver, OCR_SearchResultFF_Header)) {
					test.log(LogStatus.PASS, "Result Search Consignee Page is Dispalyed");
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Result Search consignee Page is not Dispalyed");
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}
		}
		
		
		
		
		
}
