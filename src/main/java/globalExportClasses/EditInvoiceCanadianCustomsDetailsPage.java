package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditInvoiceCanadianCustomsDetailsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Inovice_CanadianCustoms_Regres_ExporterCode = "//input[@id='invoice_exporterCode1']";
	public static final String OCR_Inovice_CanadianCustoms_Regres_OriginatorCode = "//input[@id='invoice_exporterCode2']";
	public static final String OCR_Inovice_CanadianCustoms_Regres_SaveBtn = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_Inovice_CanadianCustoms_Regres_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_Inovice_CanadianCustoms_Regres_InvoiceInstructionNotes = "//a[contains(text(),'Invoice Instructions & Notes')]";
	

	/* ******************************* Constructor ****************************** */

	public EditInvoiceCanadianCustomsDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//Add CanadianCustoms details for regression US
	public void canadianCustDetails(String ExporterCode, String OriginatorCode) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Inovice_CanadianCustoms_Regres_ExporterCode, "Enter Exporter Code : ", ExporterCode);
		typeText(driver, test, OCR_Inovice_CanadianCustoms_Regres_OriginatorCode, "Enter Originator Code : ", OriginatorCode);
	}
	
	public void saveBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Inovice_CanadianCustoms_Regres_SaveBtn, "Click on Save Button :");
	}
	
	// Click on Additional Transaction Details and Invoice Instructions & Notes
		public void select_InvoiceInstructionsNotes() {
			scrollToTop(driver);
			clickElement(driver, test, OCR_Inovice_CanadianCustoms_Regres_AdditionalTransactionDetails, "Click on Additional Transaction Details");
			clickElement(driver, test, OCR_Inovice_CanadianCustoms_Regres_InvoiceInstructionNotes, "Click on Invoice Instructions & Notes");
		}
}
