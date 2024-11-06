package productClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ProductReportResultPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */


	/* ******************************* Constructor ****************************** */

	public ProductReportResultPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	//Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {				
			if(isDisplayed(driver, "//h3[contains(text(),'Product Report')]")) {
				test.log(LogStatus.PASS, "Product report Result  Page is Dispalyed");	
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Product Report Result Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}

}
}
