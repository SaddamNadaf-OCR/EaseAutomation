package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : April 2024
 * Descriptions : Edit Shipment - Associated/Linked Orders Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentAssociatedLinkedOrdersPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Shipment_InoviceNO = "//a[@class='ead-invoice-tooltip']";
	public static final String OCR_Shipment_AdditionalTransaction = "//i[@class='fa fa-th']";
	public static final String OCR_Shipment_ReviewerDetails = "//a[contains(text(),'Reviewer Details')]";
	
	
	
	/* ******************************* Constructor ****************************** */

	public EditShipmentAssociatedLinkedOrdersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************************* Actions ********************************* */

	// click on Invoice No
		public void click_InvoiceNo(String InvoiceNo) {
			clickElement(driver, test, OCR_Shipment_InoviceNO, "Click on Invoice No : " + InvoiceNo);
		}
		
	//select reviewer details from additional transaction details
		public void click_ReviewerDetails() {
			scrollToElement(driver, OCR_Shipment_AdditionalTransaction);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_AdditionalTransaction, "Click on Additional Transaction Details :");
			clickElement(driver, test, OCR_Shipment_ReviewerDetails, "Click on Reviewer Details :");
		}
		
}
