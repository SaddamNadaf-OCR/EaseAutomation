package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;


public class BondedCarrierPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// --------------------------------------Locators------------------------------------------------//

	public static final String OCR_BondedCarrier_Title = "//h3[contains(text(),'Bonded Carrier')]";

	// ----------------------------------Constructor------------------------------------------//

	public BondedCarrierPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	// Title of Bonded Carrier page is displaying or not
	public void BondedCarrierIsDisplayed() {
		try {
			isDisplayed(driver, OCR_BondedCarrier_Title);
			test.log(LogStatus.PASS, "Bonded Carrier page is displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Bonded Carrier page is displayed");

		}
	}

}
