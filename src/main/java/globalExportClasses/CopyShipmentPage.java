package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Copy Shipment Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CopyShipmentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_CopyShipment_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_CopyShipment_Saveandreturn = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_CopyShipment_Cancel = "//button[contains(text(),'Close')]";
	public static final String OCR_CopyShipment_ShipmentNo = "(//span[@class='additional-value'])[1]";
	public static final String OCR_CopyShipment_Status = "(//span[@class='additional-value'])[2]";
	public static final String OCR_CopyShipment_UltimateDestination = "//input[@id='editShipment_shipment_countryOfUltDest']";
	public static final String OCR_CopyShipment_AdditinalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_CopyShipment_ShipmentForm = "//a[contains(text(),'Shipment Form')]";
	public static final String OCR_CopyShipment_Items = "(//a[contains(text(),'Items')])[2]";
	public static final String OCR_CopyShipment_ReviewerDetails = "//a[contains(text(),'Reviewer Details')]";

	/* ******************************* Constructor ****************************** */

	public CopyShipmentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_CopyShipment_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return button
	public void saveandreturn() {
		clickElement(driver, test, OCR_CopyShipment_Saveandreturn, "Clicking on Save and Retur button :");
	}

	// Click on Cancel button
	public void cancel() {
		clickElement(driver, test, OCR_CopyShipment_Cancel, "Clicking on Cancel Button :");
	}

	// Get Shipment Id
	public String ShipmentNo() {
		return getText(driver, test, OCR_CopyShipment_ShipmentNo, "Getting Shipment No :");
	}

	// Get Status
	public String status() {
		return getText(driver, test, OCR_CopyShipment_Status, "Getting the Status :");
	}

	// Ultimate Destination is Displayed
	public void ultimateDestination() {
		try {
			isDisplayed(driver, OCR_CopyShipment_UltimateDestination);
			test.log(LogStatus.PASS, "Ultimate Destination is Displayed :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Ultimate Destination is Not Displayed :");
		}
	}

	// Click on Additional Transaction Details
	public void additionalTransaction() {
		clickElement(driver, test, OCR_CopyShipment_AdditinalTransactionDetails,
				"Clicking on Additional Transaction Details :");
		Wait.waitfor(3);
	}

	// Click on Shipment Form section
	public void shipmentFormSection() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CopyShipment_ShipmentForm, "Clicking on Shipment Form Section :");
	}

	// Click on item section
	public void itemsection() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CopyShipment_Items, "Clicking on Items Section :");
	}

	// Click on item section
	public void reviwerection() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CopyShipment_ReviewerDetails, "Clicking on Reviwer Details Section :");
	}

}
