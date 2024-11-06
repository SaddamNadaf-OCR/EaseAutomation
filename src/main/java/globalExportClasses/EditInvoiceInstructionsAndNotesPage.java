package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditInvoiceInstructionsAndNotesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Inovice_IIN_Instructions = "//textarea[@id='invoice_instructions']";
	public static final String OCR_Inovice_IIN_Notes = "//textarea[@id='invoice_internalNotes']";
	public static final String OCR_Inovice_IIN_ItemsHeader = "//textarea[@id='invoice_itemsHeader']";
	public static final String OCR_Inovice_IIN_ItemsFooter = "//textarea[@id='invoice_itemsFooter']";
	public static final String OCR_Inovice_IIN_PackingDetails = "//textarea[@id='invoice_packageInfo']";
	public static final String OCR_Inovice_IIN_PackingSheetNo = "//textarea[@id='invoice_packingSheetNo']";
	public static final String OCR_Inovice_IIN_NumberofPackingSheets = "//input[@id='invoice_noOfPkg']";
	public static final String OCR_Inovice_IIN_UserName = "//input[@id='invoice_userName']";
	public static final String OCR_Inovice_IIN_UserTitle = "//input[@id='invoice_userTitle']";
	public static final String OCR_Inovice_IIN_Telephone = "//input[@id='invoice_userTelNo']";
	public static final String OCR_Inovice_IIN_Email = "//input[@id='invoice_userEmail']";
	public static final String OCR_Inovice_IIN_PickedBy = "//input[@id='invoice_pickedBy']";
	public static final String OCR_Inovice_IIN_LoadedBy = "//input[@id='invoice_loadedBy']";
	public static final String OCR_Inovice_IIN_CustomerServiceRep = "//input[@id='invoice_customerServiceRep']";
	public static final String OCR_Inovice_IIN_Notes_Notes = "//textarea[@id='invoice_notes']";
	public static final String OCR_Inovice_IIN_Save = "//div[@class='row btn-row']//button[3]";
	public static final String OCR_Invoice_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_Invoice_Customs = "//a[@id='customsFilingUrl']";
	public static final String OCR_Invoice_LinkedShipDetails = "//a[contains(text(),'Linked Shipment Details')]";
	public static final String OCR_Invoice_Regres_OrderForm = "//a[contains(text(),'Order Form')]";

	/* ******************************* Constructor ****************************** */

	public EditInvoiceInstructionsAndNotesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add the Invoice Instructions
	public void addInstructions(String InvoiceInstructions, String InvoiceInstNote, String InvoiceItemHeader,
			String InvoiceItemFooter, String InvoicePackingDetails, String InvoicePackingSheetNo,
			String InvoiceNumberofPackingSheets, String IRequestorUserName, String IRequestorUserTitle,
			String IRequestorTelephone, String IRequestorEmail, String IRequestorPickedBy, String IRequestorLoadedBy,
			String IRequestorCustomerServiceRep, String INNotes) {
		typeText(driver, test, OCR_Inovice_IIN_Instructions, "Enter the Instructions : ", InvoiceInstructions);
		typeText(driver, test, OCR_Inovice_IIN_Notes, "Enter the Notes : ", InvoiceInstNote);
		typeText(driver, test, OCR_Inovice_IIN_ItemsHeader, "Enter the Item Header : ", InvoiceItemHeader);
		typeText(driver, test, OCR_Inovice_IIN_ItemsFooter, "Enter the Item Footer :", InvoiceItemFooter);
		typeText(driver, test, OCR_Inovice_IIN_PackingDetails, "Enter the Packing Details : ", InvoicePackingDetails);
		typeText(driver, test, OCR_Inovice_IIN_PackingSheetNo, "Enter the Packing Sheet No : ", InvoicePackingSheetNo);
		typeText(driver, test, OCR_Inovice_IIN_NumberofPackingSheets, "Enter the Number of Packing Sheets : ",
				InvoiceNumberofPackingSheets);
		typeText(driver, test, OCR_Inovice_IIN_UserName, "Enter the User Name : ", IRequestorUserName);
		typeText(driver, test, OCR_Inovice_IIN_UserTitle, "Enter the User Title : ", IRequestorUserTitle);
		typeText(driver, test, OCR_Inovice_IIN_Telephone, "Enter the Telephone : ", IRequestorTelephone);
		typeText(driver, test, OCR_Inovice_IIN_Email, "Enter the Email : ", IRequestorEmail);
		typeText(driver, test, OCR_Inovice_IIN_PickedBy, "Enter the Picked By : ", IRequestorPickedBy);
		typeText(driver, test, OCR_Inovice_IIN_LoadedBy, "Enter the Loaded By : ", IRequestorLoadedBy);
		typeText(driver, test, OCR_Inovice_IIN_CustomerServiceRep, "Enter the Customer Service Rep : ",
				IRequestorCustomerServiceRep);
		typeText(driver, test, OCR_Inovice_IIN_Notes_Notes, "Enter the Notes : ", INNotes);
	}

	// Click on Save Invoice Instructions And Notes
	public void click_SaveInstructionAndNote() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Inovice_IIN_Save, "Click on save in Invoice Instructions And Notes");
	}
	
	//click on Additional Transaction Details and go to Order Form Regression US
	public void orderForm() {
	scrollToTop(driver);
	clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
	Wait.waitfor(2);
	clickElement(driver, test, OCR_Invoice_Regres_OrderForm, "Click on Order Form :");
	}
	
	// Click on Additional Transaction Details and Linked Shipment Details
		public void select_CustomsFilingDetails() {
			scrollToTop(driver);
			clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
			clickElement(driver, test, OCR_Invoice_Customs, "Click on Customs Filing Details");
		}

	// Click on Additional Transaction Details and Linked Shipment Details
	public void select_LinkedShipmentDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_Invoice_LinkedShipDetails, "Click on Linked Shipment Details");
	}

}
