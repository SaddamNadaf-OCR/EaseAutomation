package filesClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultConsigneeSearchPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchResultConsignee_Header = "//h3[contains (text(),'Result Consignee')]";
public static final String OCR_SearchresultConsignee_ID="//a[contains (text(),'112NEW')]";
	/* ******************************* Constructor ****************************** */

	public ResultConsigneeSearchPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, OCR_SearchResultConsignee_Header)) {
				test.log(LogStatus.PASS, "Result Search Consignee Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Search consignee Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

	public void EditConsignee() {
		clickElement(driver, test, OCR_SearchresultConsignee_ID, "click on ID");
	}
	
	public void clickonholdId() {
		clickElement(driver, test, OCR_SearchresultConsignee_ID, "Clicking on Hold ID");
	}
	public void clickonId(String data) {
		clickElement(driver, test, "//a[contains (text(),'"+data+"')]", "Clicking on ID"+data);
	}

}
