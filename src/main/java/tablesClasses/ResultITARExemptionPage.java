package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultITARExemptionPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ITARExemption_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultITARExemptionPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
					
/* ******************** Actions ********************************* */
// Title of ITARExemption page is displaying or not
	public void ITARExemptionIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ITARExemption_Title);
				test.log(LogStatus.PASS, "ITARExemption Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "ITARExemption  Is Not Displayed");

				}
			}


}
