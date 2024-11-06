package globalTradeControlClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class ResultTradeCotrolPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GtcResultSearch_ReferenceNo = "//table[@id='grid']/tbody/tr[2]/td[2]";

	/* ******************************* Constructor ****************************** */

	public ResultTradeCotrolPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click Screen
	public void click_ResultSearchReferenceNo(){
		clickElement(driver, test, OCR_GtcResultSearch_ReferenceNo, "Click on Result Search ReferenceNo");
	}

	//Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {				
			if(isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Trade Control Screening is Dispalyed");	
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Trade Control Screening is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}
}
