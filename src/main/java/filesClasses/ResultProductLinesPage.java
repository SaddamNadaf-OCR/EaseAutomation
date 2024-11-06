package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultProductLinesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultSearchProductLine_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultProductLinesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Product Lines page is displaying or not
	public void ResultSearchProductLineIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultSearchProductLine_Title);
			test.log(LogStatus.PASS, "Result Product Lines Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Product Lines Is Not Displayed");

		}
	}


}
