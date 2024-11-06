
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class LogisticsAndShippingAdvanceTrackingPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LSTracking_Title = "//h3[contains(text(),'Advance Tracking')]";
	public static final String OCR_LSTracking_DBIcon = "//i[@id='logisticsDashboard']";

	/* ******************************* Constructor ****************************** */

	public LogisticsAndShippingAdvanceTrackingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Title of the page is displayed
	public void titleDisplayedLSTracking() {
		isDisplayed(driver, OCR_LSTracking_Title);
		test.log(LogStatus.PASS, "Logistics & Shipping - Advance Tracking Page is Displyed");
	}

	// Click on DashBoard ICon
	public void clickDashBoardICon() {
		clickElement(driver, test, OCR_LSTracking_DBIcon, "Click on DashBoard ICon");
	}

}
