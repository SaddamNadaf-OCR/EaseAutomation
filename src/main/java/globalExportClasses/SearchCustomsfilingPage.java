package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchCustomsfilingPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "(//input[@id='searchCustomsFillingViewForm_Search'])[2]";
	public static final String OCR_RESET = "(//input[@type='reset'])[1]";
	public static final String OCR_SBUCODE = "//select[@name='shipment.sbuCode']";
	public static final String OCR_EXPORTERCODE = "//input[@name='shipment.exporterCode']";
	public static final String OCR_CustomFilingStatus = "//select[@name='customsFilingStatus']";
	public static final String OCR_UltimateConsigneeName = "//input[@name='shipment.ultConsName']";
	public static final String OCR_PARTYTYPE = "//select[@name='partyType']";
	public static final String OCR_PartNo = "//input[@name='itemPartNo']";
	public static final String OCR_ShipmentNo = "//input[@name='shipment.shipmentNo']";

	// * ******************************* Constructor ******************************
	// *//

	public SearchCustomsfilingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset");
	}
	
	// Search by parameter
	public void searchByParameter(String Sbu, String EXPORTERCODE, String CustomsFilingStatus,
			String UltimateConsigneeName, String PartyType, String PartNo, String ShipmentNo) {

		selectByVisibleText(driver, test, OCR_SBUCODE, "Selecting SBU", Sbu);
		typeText(driver, test, OCR_EXPORTERCODE, "Enter Exporter Code", EXPORTERCODE);
		selectByVisibleText(driver, test, OCR_CustomFilingStatus, "Selecting CustomsFiling status",
				CustomsFilingStatus);
		typeText(driver, test, OCR_UltimateConsigneeName, "Enter Ult.Consinee", UltimateConsigneeName);
		scrollToElement(driver, OCR_PartNo);
		selectByVisibleText(driver, test, OCR_PARTYTYPE, "Select Party type", PartyType);
		typeText(driver, test, OCR_PartNo, "Enter PartNo", PartNo);
		scrollToElement(driver, OCR_SEARCH);
		typeText(driver, test, OCR_ShipmentNo, "enterShipment No", ShipmentNo);

	}
}