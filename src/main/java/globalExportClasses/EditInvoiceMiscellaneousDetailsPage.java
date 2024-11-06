package globalExportClasses;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class EditInvoiceMiscellaneousDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Inovice_MD_ShippingPoint = "//input[@id='invoice_shippingPoint']";
	public static final String OCR_Inovice_MD_AirwayBillNumber = "//input[@id='invoice_airwayBillNo']";
	public static final String OCR_Inovice_MD_BillOfLading = "//input[@id='invoice_billOfLading']";
	public static final String OCR_Inovice_MD_MaterialGroup = "//input[@id='invoice_materialGroup']";
	public static final String OCR_Inovice_MD_Hazardous = "//select[@id='invoice_hazardous']";
	public static final String OCR_Inovice_MD_InBondCodeLink = "(//a[contains(text(),'InBond Code')])[2]";
	public static final String OCR_Inovice_MD_BondNumber = "//input[@id='invoice_bondNo']";
	public static final String OCR_Inovice_MD_GrossWeight = "//input[@id='invoice_grossWeight']";
	public static final String OCR_Inovice_MD_NetWeight = "//input[@id='invoice_netWeight']";
	public static final String OCR_Inovice_MD_RoutingCode1 = "//input[@id='invoice_routingCode1']";
	public static final String OCR_Inovice_MD_RoutingCode2 = "//input[@id='invoice_routingCode2']";
	public static final String OCR_Inovice_MD_ShipmentType = "//input[@id='invoice_shipmentType']";
	public static final String OCR_Inovice_MD_CertificateOfReg = "//font[contains(text(),'Certificate Of Registration')]";
	public static final String OCR_Inovice_MD_Alteration = "//input[@id='alterationFlag']";
	public static final String OCR_Inovice_MD_Repair = "//input[@id='repairFlag']";
	public static final String OCR_Inovice_MD_UseAbroad = "//input[@id='useabroadFlag']";
	public static final String OCR_Inovice_MD_Replacement = "//input[@id='replacementFlag']";
	public static final String OCR_Inovice_MD_Processing = "//input[@id='processingFlag']";
	public static final String OCR_Inovice_MD_OtherUnknown = "//input[@id='othersFlag']";
	public static final String OCR_Inovice_MD_Specify = "//input[@id='invoice_othersDetail']";
	public static final String OCR_Inovice_MD_AccountingInfo = "//font[contains(text(),'Accounting Information')]";
	public static final String OCR_Inovice_MD_TransactionSMECode = "//input[@id='invoice_transactionCode']";
	public static final String OCR_Inovice_MD_RegisterNo = "//input[@id='invoice_registerNo']";
	public static final String OCR_Inovice_MD_GLACode = "//input[@id='invoice_gla']";
	public static final String OCR_Inovice_MD_SourceCode = "//input[@id='invoice_sourceCode']";
	public static final String OCR_Inovice_MD_Save = "//div[@class='row btn-row']//button[3]";
	public static final String OCR_Inovice_MD_SaveAndReturn = "//button[@id='saveandreturn']";
	public static final String OCR_Invoice_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_Invoice_InvoiceInstructionsNotes = "//a[contains(text(),'Invoice Instructions & Notes')]";
	public static final String OCR_Invoice_MD_PopUpClose = "//div[@id='ocrModal']//button[@class='close']";
	public static final String OCR_Invoice_MD_Regres_CanadianCustomDetails = "//a[contains(text(),'Canadian Customs Details')]";

	public static final String OCR_Invoice_MD_Regres_ShipPoint = "//input[@id='invoice_shippingPoint']";
	public static final String OCR_Invoice_MD_Regres_AWBNo = "//input[@id='invoice_airwayBillNo']";
	public static final String OCR_Invoice_MD_Regres_BOLading = "//input[@id='invoice_billOfLading']";
	public static final String OCR_Invoice_MD_Regres_MaterialGRP = "//input[@id='invoice_materialGroup']";
	public static final String OCR_Invoice_MD_Regres_SelectHaz = "//select[@id='invoice_hazardous']";
	public static final String OCR_Invoice_MD_Regres_BONDNo = "//input[@id='invoice_bondNo']";
	public static final String OCR_Invoice_MD_Regres_ROuting1 = "//input[@id='invoice_routingCode1']";
	public static final String OCR_Invoice_MD_Regres_ROuting2 = "//input[@id='invoice_routingCode2']";
	public static final String OCR_Invoice_MD_Regres_ShipType = "//input[@id='invoice_shipmentType']";
	public static final String OCR_Invoice_MD_Regres_GrossWeight = "//input[@id='invoice_grossWeight']";
	public static final String OCR_Invoice_MD_Regres_NetWeight = "//input[@id='invoice_netWeight']";

	/* ******************************* Constructor ****************************** */

	public EditInvoiceMiscellaneousDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add Shipment Details
	public void addShipmentDetails(String ShippingPoint, String AirwayBillNumber, String BillOfLading,
			String MaterialGroup, String Hazardous, String InBondCode, String BondNumber, String GrossWeight,
			String NetWeight, String RoutingCode1, String RoutingCode2, String ShipmentType) {
		typeText(driver, test, OCR_Inovice_MD_ShippingPoint, "Enter the Shipping Point : ", ShippingPoint);
		typeText(driver, test, OCR_Inovice_MD_AirwayBillNumber, "Enter the Airway Bill Number : ", AirwayBillNumber);
		typeText(driver, test, OCR_Inovice_MD_BillOfLading, "Enter the Bill Of Lading : ", BillOfLading);
		typeText(driver, test, OCR_Inovice_MD_MaterialGroup, "Enter the Material Group : ", MaterialGroup);
		selectByVisibleText(driver, test, OCR_Inovice_MD_Hazardous, "Select the Hazardous : ", Hazardous);
		if (InBondCode.length() > 0) {
			Wait.waitfor(2);
			try {
				clickElement(driver, test, OCR_Inovice_MD_InBondCodeLink, "Click on InBond Code Link");
				Wait.waitfor(2);
				clickElement(driver, test, "//td[contains(text(),'" + InBondCode + "')]",
						"Select the InBond Code : " + InBondCode);
				clickElement(driver, test, "(//button[contains(text(),'Select')])[2]", "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Invoice_MD_PopUpClose, "CLick on Pop Up close ");
			}
		}
		typeText(driver, test, OCR_Inovice_MD_BondNumber, "Enter the Bond Number : ", BondNumber);
		typeText(driver, test, OCR_Inovice_MD_GrossWeight, "Enter the Gross Weight : ", GrossWeight);
		typeText(driver, test, OCR_Inovice_MD_NetWeight, "Enter the Net Weight : ", NetWeight);
		typeText(driver, test, OCR_Inovice_MD_RoutingCode1, "Enter the Routing Code 1 :", RoutingCode1);
		typeText(driver, test, OCR_Inovice_MD_RoutingCode2, "Enter the Routing Code 2 : ", RoutingCode2);
		typeText(driver, test, OCR_Inovice_MD_ShipmentType, "Enter the Shipment Type : ", ShipmentType);
	}

	

	// Add the Certificate of Registration
	public void addCertificateOfReg(String CertificateofRegistration, String Specify) {
		ArrayList<String> certificate = GenericMethods.stringtoken(CertificateofRegistration);
//		clickElement(driver, test, "//font[contains(text(),'Certificate Of Registration')]",
//				"Click on Certificate Of Registration");
		if (CertificateofRegistration.length() > 0) {
			for (int i = 0; i < certificate.size(); i++) {
				if (certificate.get(i).contains("Alteration"))
					clickElement(driver, test, OCR_Inovice_MD_Alteration, "Click on Alteration Check Box");
				if (certificate.get(i).contains("Repair"))
					clickElement(driver, test, OCR_Inovice_MD_Repair, "Click on Repair Check Box");
				if (certificate.get(i).contains("Use Abroad"))
					clickElement(driver, test, OCR_Inovice_MD_UseAbroad, "Click on Use Abroad Check box");
				if (certificate.get(i).contains("Replacement"))
					clickElement(driver, test, OCR_Inovice_MD_Replacement, "Click on Replacement Check Box");
				if (certificate.get(i).contains("Processing"))
					clickElement(driver, test, OCR_Inovice_MD_Processing, "Click on Processing Check Box");
				if (certificate.get(i).contains("Other"))
					clickElement(driver, test, OCR_Inovice_MD_OtherUnknown, "Click on Other/Unknown Check Box");
			}
		}
		typeText(driver, test, OCR_Inovice_MD_Specify, "Enter the Specify : ", Specify);
	}

	// Add the Accounting Information
	public void addAccountingInfo(String TransactionSMECode, String RegisterNo, String GLACode, String SourceCode) {
		scrollToBottom(driver);
//		clickElement(driver, test, "//font[contains(text(),'Accounting Information')]",
//				"Click on Accounting Information");
		typeText(driver, test, OCR_Inovice_MD_TransactionSMECode, "Enter the Transaction #/ SME/ SAM Code : ",
				TransactionSMECode);
		typeText(driver, test, OCR_Inovice_MD_RegisterNo, "Enter the Register No : ", RegisterNo);
		typeText(driver, test, OCR_Inovice_MD_GLACode, "Enter the GLA Code : ", GLACode);
		typeText(driver, test, OCR_Inovice_MD_SourceCode, "Enter the Source Code : ", SourceCode);
	}

	// click on Save in Edit Invoice - Miscellaneous Details
	public void click_SaveMiscellaneousDetails() {
		scrollToElement(driver, OCR_Inovice_MD_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Inovice_MD_Save, "Click on save in Edit Invoice - Miscellaneous Details");
	}

	// click on Save and return in Edit Invoice - Miscellaneous Details
	public void click_SaveAndReturnMiscellaneousDetails() {
		scrollToElement(driver, OCR_Inovice_MD_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Inovice_MD_SaveAndReturn,
				"Click on Save and Return in Edit Invoice - Miscellaneous Details");
	}

	// click on Canadian Customs Details for US Regression
	public void canadianCustoms() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_Invoice_MD_Regres_CanadianCustomDetails, "Click on Canadian Customs Details :");
	}

	// Click on Additional Transaction Details and Invoice Instructions & Notes
	public void select_InvoiceInstructionsNotes() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_Invoice_InvoiceInstructionsNotes, "Click on Invoice Instructions & Notes");
	}

}
