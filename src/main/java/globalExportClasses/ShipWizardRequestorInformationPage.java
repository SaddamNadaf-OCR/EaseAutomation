
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardRequestorInformationPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_RequestorInfo_ShipmentNo = "//input[@id='wizardRequestorInfo_shipment_shipmentNo']";
	public static final String OCR_RequestorInfo_PhoneNo = "//input[@id='wizardRequestorInfo_shipment_intConsContactPhone']";
	public static final String OCR_RequestorInfo_SaveAndProceedBtn = "//button[@name='save']";
	
	/* ******************************* Constructor ****************************** */

	public ShipWizardRequestorInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Requestor information
	public void addRequestorInfo(String ShipmentNo, String PhoneNo) {
		clearText(driver, test, OCR_RequestorInfo_ShipmentNo, "Clear existing text :");
		Wait.waitfor(2);
		typeText(driver, test, OCR_RequestorInfo_ShipmentNo, "Enter the Shipment No : ", ShipmentNo+randomnumbers());
		typeText(driver, test, OCR_RequestorInfo_PhoneNo, "Enter the Phone No : ", PhoneNo);
	}
	
	//click on Save and proceed button
	public void click_SaveAndProceed() {
		clickElement(driver, test, OCR_RequestorInfo_SaveAndProceedBtn, "Click on Save and Proceed Button");
	}
	
	public void validate_RequestorInformation() {
			try {
				if (isDisplayed(driver, "//input[@value='CR Deva']")) {
					if (isDisplayed(driver, "//input[@value='+918999231451']")) {
						if (isDisplayed(driver, "//input[@value='devanand.metangale@ocr-inc.com']")) {
						test.log(LogStatus.INFO, "Requestor Information is getting displayed");
					}
				}
			}
				} catch (Exception e) {
				test.log(LogStatus.FAIL,"Requestor Information is not getting displayed");
				testFailSshot(driver, test);		
	  }
	}

}
