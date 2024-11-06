package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultCommodityTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_CommodityType_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultCommodityTypePage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
				
/* ******************** Actions ********************************* */
// Title of Commodity Type page is displaying or not
	public void CommodityTypeIsDisplayed() {
		try {
			isDisplayed(driver, OCR_CommodityType_Title);
				test.log(LogStatus.PASS, "Result Commodity Type Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result Commodity Type  Is Not Displayed");

				}
			}


}
