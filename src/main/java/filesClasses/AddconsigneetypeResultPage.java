package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class AddconsigneetypeResultPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AddResultConsigneetype_Header = "//h3[contains (text(),'Edit Consignee Type')]";
	public static final String OCR_SearchresultConsignee_ID = "//a[contains (text(),'112NEW')]";
	public static final String OCR_logout = "//i[@class='fa fa-sign-out']";
	/* ******************************* Constructor ****************************** */

	public AddconsigneetypeResultPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, OCR_AddResultConsigneetype_Header)) {
				test.log(LogStatus.PASS, "Result add Consigneetype Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result add consigneetype Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

	public void logout() {
		clickElement(driver, test, OCR_logout, "click on logout");
	}

}
