
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class LogisticsAndShippingPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_LShipment_ShipNo = "//td[@aria-describedby='bookedShipmentsGrid_shipmentNo']";
	public static final String OCR_LShipment_EnterShipNo = "//input[@id='gs_pendingShipmentsGrid_shipmentNo']";
	public static final String OCR_LShipment_Booked = "//a[contains(text(),'Booked')]";
	
	/* ******************************* Constructor ****************************** */

	public LogisticsAndShippingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// enter Shipment Number
	public void enter_ShipNo(String ShipNo) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_LShipment_EnterShipNo, "Enter Shipment No : ", ShipNo);
		Wait.waitfor(3);
		
			if (ShipNo.length() > 0) {
				Wait.waitfor(2);
				//clickElement(driver, test, OCR_CreateNewShipment_RegionLink, "Click on Region link");
				clickElement(driver, test, "//a[contains(text(),'" +ShipNo+ "')]",
						"Click on Shipment Number : " + ShipNo);
			}
	}
	
	//Click on First Shipment NO
	public void clickShipNo() {
		clickElement(driver, test, OCR_LShipment_ShipNo, "Click on Shipment No");
	}
	
	//Click on Booked
	public void booked() {
		clickElement(driver, test, OCR_LShipment_Booked, "Clicking on Booked :");
	}
}
