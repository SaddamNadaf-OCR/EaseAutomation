package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportsNotReexportedReportpage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Importshipmentcode = "//input[@id='searchImportNotReexported_itarImportExport_importShipmentNo']";
	public static final String OCR_ImportdtFrom="//input[@id='searchImportNotReexported_importFromDate']";
	public static final String OCR_IImportdtTO="//input[@id='searchImportNotReexported_importToDate']";
	public static final String OCR_shippername="//input[@id='searchImportNotReexported_itarImportExport_shipperName']";
	public static final String OCR_shippercountrycode="//input[@id='searchImportNotReexported_itarImportExport_shipperCountryCode']";
	public static final String OCR_Importlicenses="//input[@id='searchImportNotReexported_itarImportExport_importLicense']";
	public static final String OCR_ImportItarExemptionNo="//input[@id='searchImportNotReexported_itarImportExport_importItarExemptionNo']";
	public static final String OCR_serach="//input[@name='Search']";
	public static final String OCR_EXportNotExportedheader="//h3[contains(text(),'IMPORTS UNDER ITAR EXEMPTIONS NOT RE-EXPORTED')]";
	
	
	
	/* ******************************* Constructor ****************************** */

	public ExportsNotReexportedReportpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void ImpoemptionNotReexported(String ImportShipNO, String ImportDateFrom, String ImportDateTo, String ShipperCountryode, String ImportLicenses, String ImportExemptionNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Importshipmentcode, "Enter the import shipment no : ", ImportShipNO);
		
		if (ImportDateFrom.length() > 0) {
            Wait.waitfor(4);
            clickElement(driver, test, OCR_ImportdtFrom, "Click on  Date From");
            date(driver, test, "Selected on  Date From : ", ImportDateFrom);
            test.log(LogStatus.PASS, "Selected on Date From : " + ImportDateFrom);
            clickElement(driver, test, OCR_IImportdtTO, "Click on Uploaded Date To");
            date(driver, test, "Selected on  Date To : ", ImportDateTo);
            test.log(LogStatus.PASS, "Selected on Date To : " + ImportDateTo);
            
        }
		Wait.waitfor(2);

		typeText(driver, test, OCR_shippercountrycode, "Enter shipper country code : ", ShipperCountryode);
		Wait.waitfor(2);
		typeText(driver, test, OCR_Importlicenses, "Enter importlicenses : ", ImportLicenses);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ImportItarExemptionNo, "Enter importITARExemptionNo : ", ImportExemptionNo);
		Wait.waitfor(2);
	}
public void clickonSearch() {
	clickElement(driver, test, OCR_serach, "Enter shipper country code ");
	
	
}
public void validateHeading() {
	Wait.waitfor(2);
	isDisplayed(driver, OCR_EXportNotExportedheader);
	Wait.waitfor(3);
	test.log(LogStatus.PASS, "IMPORTS UNDER ITAR EXEMPTIONS NOT RE-EXPORTED page is Displayed");
	Wait.waitfor(3);

}
}





