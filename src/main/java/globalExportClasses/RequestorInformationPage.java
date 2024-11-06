package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class RequestorInformationPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ShipmentWizardRequestorInfo_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_ShipmentWizardRequestorInfo_ShipmentNo = "//input[@id='wizardRequestorInfo_shipment_shipmentNo']";
	public static final String OCR_ShipmentWizardRequestorInfo_requestorName="//input[@id='wizardRequestorInfo_shipment_intConsContactName']";
	public static final String OCR_ShipmentWizardRequestorInfo_requestorPhone="//input[@id='wizardRequestorInfo_shipment_intConsContactPhone']";
	public static final String OCR_ShipmentWizardRequestorInfo_requestorEmail="//input[@id='wizardRequestorInfo_shipment_requestorEmail']";
	public static final String OCR_ShipmentWizardRequestorInfo_SaveAndProceed="//button[contains(text(),'Save & Proceed')]";
	public static final String OCR_ShipmentWizardRequestorInfo_Reset="//button[@id='resetRequestor']";
	public static final String OCR_ShipmentWizardRequestorInfo_Cancel="//button[@id='btnCancel']";
	public static final String OCR_ShipmentWizardRequestorInfo_ShipmentNoHyperlink="//a[@id='shipmentNo-popup']";
	
	
	/* ******************************* Constructor ****************************** */

	public RequestorInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}


/* ******************************* Actions ********************************* */
	// Add shipment number on requestor information page
	public void add_ShipmentNo(String ShipmentNo) {
	typeText(driver, test, OCR_ShipmentWizardRequestorInfo_ShipmentNo, "Enter ShipmentNo : ", ShipmentNo);
	typeText(driver, test, OCR_ShipmentWizardRequestorInfo_ShipmentNo, "Enter  Random ShipmentNo : ", randomnumbers());
	
	}
	
	// Click on Save and Proceed button
	public void click_SaveAndProceed() {
		clickElement(driver, test, OCR_ShipmentWizardRequestorInfo_SaveAndProceed, "Click on Save and Proceed button");
	}
}

