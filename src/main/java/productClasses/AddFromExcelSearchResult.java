package productClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class AddFromExcelSearchResult extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AddExcSerchResult_title="//h3[@class='page-heading']";

	/* ******************** Constructor ***************************** */
	public AddFromExcelSearchResult(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
		/* ******************************* Actions ********************************* */

	//Verify the Page Title is Displayed or not
			public void displayOfTitle() {
				try {				
					if(isDisplayed(driver, OCR_AddExcSerchResult_title)) {
						test.log(LogStatus.PASS, "Result Search add from excel page is Dispalyed");	
					}
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "ResultSearch add from excel  Page is not Dispalyed");
					testFailSshot(driver, test);
					Assert.assertTrue(false);
				}
		}
			
}