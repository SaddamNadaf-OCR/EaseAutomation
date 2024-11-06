
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class LogisticsAndShippingBookedPackagesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LSBooking_Title = "//h3[contains(text(),'Booked Packages')]";
	public static final String OCR_LSBooking_Tracking = "//li[@id='5']/a";

	/* ******************************* Constructor ****************************** */

	public LogisticsAndShippingBookedPackagesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Title of the page is displayed
	public void titleDisplayedLSBookingDetails() {
		isDisplayed(driver, OCR_LSBooking_Title);
		test.log(LogStatus.PASS, "Logistics & Shipping - Booked Packages Page is Displyed");
	}

	// Click on Tracking
	public void clickTracking() {
		clickElement(driver, test, OCR_LSBooking_Tracking, "Click on Tracking");
	}

}
