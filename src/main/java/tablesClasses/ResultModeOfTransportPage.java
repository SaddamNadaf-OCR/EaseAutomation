package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultModeOfTransportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ModeOfTransport_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultModeOfTransportPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
					
/* ******************** Actions ********************************* */
// Title of ModeOfTransport page is displaying or not
	public void ModeOfTransportIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ModeOfTransport_Title);
				test.log(LogStatus.PASS, "ModeOfTransport Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "ModeOfTransport  Is Not Displayed");

				}
			}

}
