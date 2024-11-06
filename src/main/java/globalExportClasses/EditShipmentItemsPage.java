package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentItemsPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ShipmentItems_Additems = "//button[contains(text(),'Add Item')]";
	public static final String OCR_CreateNewShipment_ComplianceSummary = "//i[@class='fa fa-file-text-o']";
	public static final String OCR_CreateNewShipment_POPupClose = "//div[@id='alertModal']//button[@class='close']";
	public static final String OCR_CreateNewShipment_AdditionalTransacDetails = "//i[@class='fa fa-th']";
	public static final String OCR_CreateNewShipment_ReviewerDetails = "//a[contains(text(),'Reviewer Details')]";
	public static final String OCR_ShipmentItems_BookingDetails = "//a[contains(text(),'Booking Details')]";
	
	/* ******************************* Constructor ****************************** */

	public EditShipmentItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//Click on Add Items
	public void click_AddItem() {
		clickElement(driver, test, OCR_ShipmentItems_Additems, "Click on Add Item");
	}
	
	//Click on Order No
	public void click_OrderNo(String OrderNO) {
		clickElement(driver, test, "//table[@id='grid-items']//tr//a[contains(text(),'"+OrderNO+"')]", "click on Order No : "+OrderNO);
	}
	
	//click on Compliance summary icon
	public void clickComplianceSummaryIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateNewShipment_ComplianceSummary, "Click on Compliance Summary Report");
	}
	
	//click on POp up close icon
	public void click_POPupClose() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateNewShipment_POPupClose, "Click on POP up Close");
	}
	
	
//click on Additional Tranasaction Details for Invoice-Shipment for Regression US
	public void click_AdditionalTransacDetails() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalTransacDetails, "Click on Additional Transaction Details :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewShipment_ReviewerDetails, "Click on Reviewer Details :");
	}
	
	//click on Additional Tranasaction Details for Booking Details for Regression US
	public void click_BookingDetails() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalTransacDetails, "Click on Additional Transaction Details :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ShipmentItems_BookingDetails, "Click on Booking Details :");
	}
	
	//click on Additional Transaction Details for Instruction Details for Regression US
		public void click_InstructionDetails() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_AdditionalTransacDetails, "Click on Additional Transaction Details :");
			Wait.waitfor(2);
			clickElement(driver, test, "(//a[contains(text(),'Instructions')])[2]", "Click on Instruction Details :");
		}
		
		//click on Additonal transaction and select EEI form
		public void click_EEIForm() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_AdditionalTransacDetails, "Click on Additional Transaction Details :");
			Wait.waitfor(2);
			clickElement(driver, test, "(//a[contains(text(),'EEI Form')])[1]", "Click on EEi Form :");
		}
		
		
		
}
