
package globalExportClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class LogisticsAndShippingShipmentDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LSDetails_FedExPackageType = "//select[@id='fedexPackage']";
	//public static final String OCR_LSDetails_DHLPackageType = "//select[@id='fedexAccountNo']";
	public static final String OCR_LSDetails_FedExAccounts = "//select[@id='fedexAccountNo']";
	public static final String OCR_LSDetails_DHLAccounts = "//select[@id='dhlAccountNo']";
	public static final String OCR_LSDetails_Save = "//button[@id='shipmentHeaderSave']";
	public static final String OCR_LSDetails_SService = "//a[contains(text(),'Special Services')]";

	/* ******************************* Constructor ****************************** */

	public LogisticsAndShippingShipmentDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Selct the FedEx Package Type ,DHL Package Type, FedEx Accounts and DHL
	// Accounts
	public void selctFDPT(String FedExPackageType, String DHLPackageType) {
		selectByVisibleText(driver, test, OCR_LSDetails_FedExPackageType, "Select the FedEx Package Type : ",
				FedExPackageType);
		//selectByVisibleText(driver, test, OCR_LSDetails_DHLPackageType, "Select the DHL Package Type : ",
				//DHLPackageType);
		new Select(driver.findElement(By.xpath(OCR_LSDetails_FedExAccounts))).selectByIndex(0);
		new Select(driver.findElement(By.xpath(OCR_LSDetails_DHLAccounts))).selectByIndex(0);
	}

	// Click on Save button
	public void clickSave() {
		scrollToElement(driver, OCR_LSDetails_Save);
		clickElement(driver, test, OCR_LSDetails_Save, "Click on Save");
	}

	// Click on Special Services (Optional)
	public void clickSService() {
		//scrollToElement(driver, OCR_LSDetails_SService);
		mouseOverAndClick(driver, test, OCR_LSDetails_SService, "Click on Special Services (Optional)");
		Wait.waitfor(2);
		//clickElement(driver, test, OCR_LSDetails_SService, "");
	}

}
