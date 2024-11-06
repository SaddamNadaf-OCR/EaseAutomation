
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class LogisticsAndShippingPackagesAndRatesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LSPackingRate_Title = "//h3[contains(text(),'Logistics & Shipping - Packages & Rates')]"; 
	public static final String OCR_LSPackingRate_BookingDetails = "//li[@id='4']/a";

	/* ******************************* Constructor ****************************** */

	public LogisticsAndShippingPackagesAndRatesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Title of the Logistics & Shipping - Packages & Rates page is displayed
	public void titleDisplayedPacking() {
		Wait.waitfor(3);
		//scrollToElement(driver, OCR_LSPackingRate_Title);
		isDisplayed(driver, OCR_LSPackingRate_Title);
		test.log(LogStatus.PASS, "Logistics & Shipping - Packages & Rates Page is Displyed");
	}

	// Click on Booked Packages
	public void clickBooked() {
		clickElement(driver, test, OCR_LSPackingRate_BookingDetails, "Click on Booked Packages");
	}

}
