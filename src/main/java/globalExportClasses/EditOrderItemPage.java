package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Edit Order Item Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class EditOrderItemPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_EditOrderItem_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_EditOrderItem_Saveandreturn = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_EditOrderItem_ApplyAuthorization = "(//button[contains(text(),'Apply Authorization')])[1]";
	public static final String OCR_EditOrderItem_OverrideExportHold = "(//button[contains(text(),'Override Export Hold')])[1]";
	public static final String OCR_EditOrderItem_Cancel = "//button[contains(text(),'Close')]";
	public static final String OCR_EditOrderItem_ShipmentNo = "(//span[@class='additional-value'])[1]";
	public static final String OCR_EditOrderItem_Status = "(//span[@class='additional-value'])[2]";
	public static final String OCR_EditOrderItem_UltimateDestination = "//input[@id='editShipment_shipment_countryOfUltDest']";
	public static final String OCR_EditOrderItem_AdditinalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_EditOrderItem_Items = "(//a[contains(text(),'Items')])[2]";
	public static final String OCR_EditOrderItem_Headings = "//h3[contains(text(),'Edit Order Item')]";

	/* ******************************* Constructor ****************************** */

	public EditOrderItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_EditOrderItem_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return button
	public void saveandreturn() {
		clickElement(driver, test, OCR_EditOrderItem_Saveandreturn, "Clicking on Save and Retur button :");
	}

	// Click on Save Button
	public void applyauthorization() {
		clickElement(driver, test, OCR_EditOrderItem_ApplyAuthorization, "Clicking on Apply Authorization Button :");
	}

	// Click on Save and Return button
	public void OverrideExportHold() {
		clickElement(driver, test, OCR_EditOrderItem_OverrideExportHold, "Clicking on Override Export Hold button :");
	}

	// Click on Cancel button
	public void cancel() {
		clickElement(driver, test, OCR_EditOrderItem_Cancel, "Clicking on Cancel Button :");
	}

	// Verify the heading
	public void heading() {
		try {
			isDisplayed(driver, OCR_EditOrderItem_Headings);
			test.log(LogStatus.PASS, "Heading is Displayed :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}
	}

}
