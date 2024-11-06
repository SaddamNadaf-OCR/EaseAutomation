package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultShippersPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultShipperData_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultShippersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Shipper is displaying or not
	public void ResultShipperDataIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultShipperData_Title);
			test.log(LogStatus.PASS, "Result Shipper Data Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Shipper Data Is Not Displayed");

		}
	}

}
