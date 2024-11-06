package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultGroundCarrierPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultGroundCarrierTable_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultGroundCarrierPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Ground Carrier page is displaying or not
	public void ResultGroundCarrierTableIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultGroundCarrierTable_Title);
			test.log(LogStatus.PASS, "Result GroundCarrier Table Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result GroundCarrier Table Is Displayed");

		}
	}


}
