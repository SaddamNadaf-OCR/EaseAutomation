package productClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ProductExportClassReportpage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */


	/* ******************************* Constructor ****************************** */

	public ProductExportClassReportpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */


	//Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {				
			if(isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Search Product Page is Dispalyed");	
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Search Product Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
}}