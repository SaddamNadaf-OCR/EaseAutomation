package globalExportClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipmentWorkQueuePage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ShipmentWorkQueuePage_MyQueue = "//select[@id='getShipmentWorkQueueFilter_myQueue']";
	public static final String OCR_ShipmentWorkQueuePage_GoBtn = "(//button[contains(text(),'Go')])[1]";
	public static final String OCR_ShipmentWorkQueuePage_ValidateShipment = "//h3[contains(text(),'Edit Shipment')]";
	public static final String OCR_ShipmentWorkQueuePage_FilterOptionLabel = "//label[contains(text(),'Filter Options')]";
	public static final String OCR_ShipmentWorkQueuePage_SBU = "//select[@id='getShipmentWorkQueueFilter_sbuListFilter']";
	public static final String OCR_ShipmentWorkQueuePage_Site = "//select[@id='getShipmentWorkQueueFilter_siteList']";
	public static final String OCR_ShipmentWorkQueuePage_Region = "//select[@id='getShipmentWorkQueueFilter_regionList']";
	public static final String OCR_ShipmentWorkQueuePage_ApplyFilterButton = "//button[contains(text(),'Apply Filter')]";
	public static final String OCR_ShipmentWorkQueuePage_ShippingQueue = "//select[@id='getShipmentWorkQueueFilter_shippingQueue']";
	public static final String OCR_ShipmentWorkQueuePage_ShippingQueueGoButton = "(//button[contains(text(),'Go')])[2]";
	public static final String OCR_ShipmentWorkQueuePage_ExportQueue = "//select[@id='getShipmentWorkQueueFilter_exportQueue']";
	public static final String OCR_ShipmentWorkQueuePage_ExportQueueGoButton = "(//button[contains(text(),'Go')])[3]";
	public static final String OCR_ShipmentWorkQueuePage_TransportationQueue = "//select[@id='getShipmentWorkQueueFilter_transportQueue']";
	public static final String OCR_ShipmentWorkQueuePage_TransportationQueueGoButton = "(//button[contains(text(),'Go')])[4]";
	public static final String OCR_ShipmentWorkQueuePage_PendingCancellation = "//select[@id='getShipmentWorkQueueFilter_pendingCancellation']";
	public static final String OCR_ShipmentWorkQueuePage_PendingCancellationGoButton = "(//button[contains(text(),'Go')])[5]";

	/* ******************************* Constructor ****************************** */

	public ShipmentWorkQueuePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void myQueue_Selection(String WorkQueue) {
		Wait.waitfor(3);
		System.out.println(WorkQueue);
		/*new Select(driver.findElement(By.xpath(OCR_ShipmentWorkQueuePage_MyQueue))).selectByValue(WorkQueue);
		test.log(LogStatus.PASS, "Select from My Queue List drop-down : " + WorkQueue);*/
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_MyQueue, "Select from My Queue List drop-down : ", WorkQueue);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_GoBtn, "Click on Go button");
	}
	
	public void validate_WorkQueue() {
		Wait.waitfor(3);
			isDisplayed(driver, OCR_ShipmentWorkQueuePage_ValidateShipment);
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "Edit Shipment is Displayed");
			Wait.waitfor(3);
		
	}
	
	//Click on Filter Options Label
	public void filterOptionLabel() {
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_FilterOptionLabel, "Clicking on Filter Option Label :");
	}
	
	//Select SBU
	public void selectSBU(String SelectSBU) {
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_SBU, "Selecting the SBU :", SelectSBU);
	}
	
	//Select Site
	public void selectSite(String SelectSite) {
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_Site, "Selecting the SBU :", SelectSite);
	}
		
	//Select Region
	public void selectRegion(String SelectRegion) {
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_Region, "Selecting the SBU :", SelectRegion);
	}
	
	//Click on Apply Filter Button
	public void applyFilter() {
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_ApplyFilterButton, "Clicking on Apply Filter Button :");
	}
	
	public void shippingQueue_Selection(String ShippingQueue) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_ShippingQueue, "Select from Shipping Queue List drop-down : ", ShippingQueue);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_ShippingQueueGoButton, "Click on Go button");
	}
	
	public void exportQueue_Selection(String ExportQueue) {
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_ExportQueue, "Select from Export Queue List drop-down : ", ExportQueue);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_ExportQueueGoButton, "Click on Go button");
	}
	
	public void transportationQueue_Selection(String TransportationQueue) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_TransportationQueue, "Select from Transportation Queue List drop-down : ", TransportationQueue);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_TransportationQueueGoButton, "Click on Go button");
	}
	
	public void pendingCancellationQueue_Selection(String PendingCancellationQueue) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ShipmentWorkQueuePage_PendingCancellation, "Select from Pending Cancellation Queue List drop-down : ", PendingCancellationQueue);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentWorkQueuePage_PendingCancellationGoButton, "Click on Go button");
	}
}
