package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultFTADetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_FTADetails_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultFTADetailsPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
					
/* ******************** Actions ********************************* */
// Title of FTA Details page is displaying or not
	public void FTADetailsIsDisplayed() {
		try {
			isDisplayed(driver, OCR_FTADetails_Title);
				test.log(LogStatus.PASS, "FTA Details Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "FTA Details  Is Not Displayed");

				}
			}



}
