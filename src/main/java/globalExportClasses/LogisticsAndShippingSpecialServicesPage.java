
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class LogisticsAndShippingSpecialServicesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LSSServices_Title = "//h3[contains(text(),'Special Services')]";
	public static final String OCR_LSSServices_PackingRates = "//a[contains(text(),'Packaging & Rates')]";

	/* ******************************* Constructor ****************************** */

	public LogisticsAndShippingSpecialServicesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Title of the page is displayed
	public void titleDisplayedLSSS() {
		isDisplayed(driver, OCR_LSSServices_Title);
		test.log(LogStatus.PASS, "Logistics & Shipping - Special Services (Optional) Page is Displyed");
	}

	// Click on Packaging & Rates
	public void clickPackingRate() {
		//scrollToElement(driver, OCR_LSSServices_PackingRates);
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_LSSServices_PackingRates, "Mouse over on Packaging & Rates");
		//clickElement(driver, test, OCR_LSSServices_PackingRates, "");
		
		// clickElement(driver, test, OCR_LSSServices_PackingRates, "Click on Packaging & Rates");
		
	}

}
