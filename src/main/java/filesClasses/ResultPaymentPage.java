package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultPaymentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultListPayment_Title = "//h3[@class='page-heading']";
	public static final String OCR_AddPaymentButton = "//button[@name='Add']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultPaymentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	
	//Clicking on Add Button
	
	public void AddPayment() {
		clickElement(driver, test, OCR_AddPaymentButton, "Clicking On Add Payment Button");
	}
	/* ******************** Actions ********************************* */
	// Title of  Payment page is displaying or not
	public void ResultListPaymentIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultListPayment_Title);
			test.log(LogStatus.PASS, "Result List Payment Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result List Payment Is Not Displayed");

		}
	}

}
