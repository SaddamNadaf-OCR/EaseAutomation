package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchHouseairwaybillPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SEARCH  = "//button[@name='Search']";
	public static final String OCR_RESET  =  "//button[@type='reset']";
	public static final String OCR_SBUCODE =  "//select[@name='hawb.sbuCode']";
	public static final String OCR_HAWBNO = "//input[@name='hawb.hawbno']";
	public static final String OCR_ShipmentNo ="//input[@name='hawb.shipmentNo']";
	
	/* ******************************* Constructor ****************************** */

	public SearchHouseairwaybillPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */

	//clicking on Search 
	public void search  () {
		clickElement(driver, test, OCR_SEARCH, "clicking on search button");
	}
	// Clicking on Reset
	public void Reset () {
		clickElement(driver, test, OCR_RESET, "clicking on Reset button");
	}
	//Search by parameter
	public void parameter (String sbu,String HAWB_NO, String Shipment_No) {
		selectByVisibleText(driver, test, OCR_SBUCODE, "Selecting Sbu", sbu);
		typeText(driver, test, OCR_HAWBNO, "Enter HAWBNO", HAWB_NO);
		typeText(driver, test, OCR_ShipmentNo, "Enter ShipmentNo", Shipment_No);
	}
	
	

}
