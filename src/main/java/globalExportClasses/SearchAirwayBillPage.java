package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAirwayBillPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SEARCH  = "//button[@name='Search']";
	public static final String OCR_RESET  = "//button[@type='reset']";
	public static final String OCR_SBUCODE  = "//select[@name='awb.sbuCode']";
	public static final String OCR_AWBNO  = "//input[@name='awb.awbno']";
	public static final String OCR_SHIPMENTNO  = "//input[@name='awb.shipmentNo']";
	
/* ******************************* Constructor ****************************** */

	public SearchAirwayBillPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */

	//clicking on Search 
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "clicking on search button");
		
	}
	//clicking on Reset 
		public void reset() {
			clickElement(driver, test, OCR_RESET, "clicking on reset button");
			
		}
   //Search by parameter
		public void searchByParameter(String Sbu, String AWB_NO, String Shipment_no) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Selecting Sbu", Sbu);
			typeText(driver, test, OCR_AWBNO, "entering AWBNO", AWB_NO);
			typeText(driver, test, OCR_SHIPMENTNO, "entering Shipment no", Shipment_no);
		}
	
	
	
	
	
	
	
}