package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class ResultDeliveryOrderPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ResultDOrder_DOTitle = "//h3[contains(text(),'Result Delivery Order')]";

	/* ******************************* Constructor ****************************** */

	public ResultDeliveryOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//  Result Delivery Order is Displayed
	public void resultDOrder() {
		isDisplayed(driver, OCR_ResultDOrder_DOTitle);
		test.log(LogStatus.PASS, "Result Delivery Order is Displayed");
	}

}
