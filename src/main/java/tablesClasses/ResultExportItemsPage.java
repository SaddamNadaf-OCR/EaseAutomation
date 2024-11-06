package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultExportItemsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ExportItems_Title = "//h3[@class='page-heading']";

// ----------------------------------Constructor------------------------------------------//

	public ResultExportItemsPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}
					
/* ******************** Actions ********************************* */
// Title of Export Items page is displaying or not
	public void ExportItemsIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ExportItems_Title);
				test.log(LogStatus.PASS, "Result Export Items Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result Export Items   Is Not Displayed");

				}
			}



}
