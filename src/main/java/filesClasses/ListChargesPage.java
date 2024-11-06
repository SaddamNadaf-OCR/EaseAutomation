package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ListChargesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	// --------------------------------------Locators------------------------------------------------//

		public static final String OCR_Charges_Title = "//h3[@class='page-heading']";
		
	// ----------------------------------Constructor------------------------------------------//

	public ListChargesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of Charges page is displaying or not
	public void ChargesIsDisplayed() {
		try {
			isDisplayed(driver, OCR_Charges_Title);
			test.log(LogStatus.PASS, "Charges page is displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Charges page is Not displayed");

		}
	}




}
