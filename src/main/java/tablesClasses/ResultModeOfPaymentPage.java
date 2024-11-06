package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultModeOfPaymentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ModeOfPayment_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultModeOfPaymentPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
					
/* ******************** Actions ********************************* */
// Title of ModeOfPayment page is displaying or not
	public void ModeOfPaymentIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ModeOfPayment_Title);
				test.log(LogStatus.PASS, "ModeOfPayment Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "ModeOfPayment  Is Not Displayed");

				}
			}


}
