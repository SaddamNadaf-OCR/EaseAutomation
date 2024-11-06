package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class AddFFresultPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddResultFF_Header = "//h3[@class='page-heading']";

	/* ******************************* Constructor ****************************** */

	public AddFFresultPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, OCR_AddResultFF_Header)) {
				test.log(LogStatus.PASS, "Result add Freight forwarder page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result add Freight forwarder page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

}
