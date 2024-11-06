package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultAESDirectInvalidHTSCodesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_AESDirectInvalidHTS_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultAESDirectInvalidHTSCodesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
		
	/* ******************** Actions ********************************* */
	// Title of AESDirectInvalidHTS page is displaying or not
	public void AESDirectInvalidHTSIsDisplayed() {
		try {
			isDisplayed(driver, OCR_AESDirectInvalidHTS_Title);
			test.log(LogStatus.PASS, "Result AESDirectInvalidHTS Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result AESDirectInvalidHTS  Is Not Displayed");

			}
		}

}
