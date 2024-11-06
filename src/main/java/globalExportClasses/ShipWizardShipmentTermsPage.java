
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardShipmentTermsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ShipmentTerms_FreightChargesPaidBy = "//select[@id='wizardShipmentTerms_shipment_ffChargesPaidBy']";
	public static final String OCR_ShipmentTerms_CustomDutiesPaidBy = "//select[@id='wizardShipmentTerms_shipment_customDutiesPaidBy']";
	public static final String OCR_ShipmentTerms_ForeignVATPaidBy = "//select[@id='wizardShipmentTerms_shipment_foreignVatPaidBy']";
	public static final String OCR_ShipmentTerms_InsuranceRequired = "//select[@id='wizardShipmentTerms_shipment_insuranceRequired']";
	public static final String OCR_ShipmentTerms_ShipmentContainsPersonalInformation = "//select[@id='wizardShipmentTerms_shipment_containsPersonalInfo']";
	public static final String OCR_ShipmentTerms_CostCenterNo = "//input[@id='wizardShipmentTerms_shipment_chargeToCostCntrNo']";
	public static final String OCR_ShipmentTerms_LineofBusinessSupported = "//input[@id='wizardShipmentTerms_shipment_businessUnitSupported']";
	public static final String OCR_ShipmentTerms_ModeofTransportationLink = "//a[contains(text(),'Mode of Transportation')]";
	public static final String OCR_ShipmentTerms_SelectBtn = "//button[@name='Ok']";
	public static final String OCR_ShipmentTerms_ManagertoApproveFreight = "//input[@id='wizardShipmentTerms_shipment_managerToApproveBill']";
	public static final String OCR_ShipmentTerms_POReferenceNo = "//input[@id='wizardShipmentTerms_shipment_consigneeRef']";
	public static final String OCR_ShipmentTerms_SpecialInstructions = "//textarea[@id='wizardShipmentTerms_shipment_specialInstructions']";
	public static final String OCR_ShipmentTerms_ShipmentSpecialInstructions = "//textarea[@id='wizardShipmentTerms_shipment_loadShInstrs']";
	public static final String OCR_ShipmentTerms_AttachedDocuments = "//textarea[@id='wizardShipmentTerms_shipment_attachedDocuments']";
	public static final String OCR_ShipmentTerms_AddNotes = "//button[@id='addNotesBtn']";
	public static final String OCR_ShipmentTerms_AddNotesSpecialInstructions = "//textarea[@id='editTabbedShipmentNotes_shipmentNotes_notes']"; 
	public static final String OCR_ShipmentTerms_SaveAndReturn = "//div[@class='ocr-modal-cont']//input[@id='saveReturnInstruction']";
	public static final String OCR_ShipmentTerms_SaveAndProceedBtn = "//button[@name='proceed']";
	/* ******************************* Constructor ****************************** */

	public ShipWizardShipmentTermsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Shipping terms
	public void addShipiigTerms(String FreightChargesPaidBy, String CustomDutiesPaidBy, String ForeignVATPaidBy,
			String InsuranceRequired, String ShipmentContainsPersonalInfo) {
		selectByVisibleText(driver, test, OCR_ShipmentTerms_FreightChargesPaidBy,
				"Select the Freight Charges Paid By : ", FreightChargesPaidBy);
		selectByVisibleText(driver, test, OCR_ShipmentTerms_CustomDutiesPaidBy, "Select the Custom Duties Paid By : ",
				CustomDutiesPaidBy);
		selectByVisibleText(driver, test, OCR_ShipmentTerms_ForeignVATPaidBy, "Select the Foreign VAT Paid By : ",
				ForeignVATPaidBy);
		selectByVisibleText(driver, test, OCR_ShipmentTerms_InsuranceRequired, "Select the Insurance Required : ",
				InsuranceRequired);
		selectByVisibleText(driver, test, OCR_ShipmentTerms_ShipmentContainsPersonalInformation,
				"Select the Shipment Contains Personal Info : ", ShipmentContainsPersonalInfo);
	}

	// Adding other Shipment Information
	public void addOtherShipInfo(String CostCenterNo, String LineofBusinessSupported, String ModeofTransportation,
			String ManagertoApproveFreight, String POReferenceNo, String SpecialInstructions,
			String ShipmentSpecialInstructions, String AttachedDocuments) {
		typeText(driver, test, OCR_ShipmentTerms_CostCenterNo, "Enter the Cost Center No : ", CostCenterNo);
		typeText(driver, test, OCR_ShipmentTerms_LineofBusinessSupported, "Enter the Line of Business Supported : ",
				LineofBusinessSupported);
		clickElement(driver, test, OCR_ShipmentTerms_ModeofTransportationLink, "Click on Mode of Transportation Link");
		Wait.waitfor(3);
		clickElement(driver, test, "//td[contains(text(),'" + ModeofTransportation + "')]",
				"Click on Mode of Transportation : " + ModeofTransportation);
		clickElement(driver, test, OCR_ShipmentTerms_SelectBtn, "Click on Select button");
		typeText(driver, test, OCR_ShipmentTerms_ManagertoApproveFreight, "Enter the Manager to Approve Freight : ",
				ManagertoApproveFreight);
		typeText(driver, test, OCR_ShipmentTerms_POReferenceNo, "Enter the PO Reference No : ", POReferenceNo);
		typeText(driver, test, OCR_ShipmentTerms_SpecialInstructions, "Enter the Special Instructions : ",
				SpecialInstructions);
		typeText(driver, test, OCR_ShipmentTerms_ShipmentSpecialInstructions,
				"Enter the Shipment Special Instructions : ", ShipmentSpecialInstructions);
		typeText(driver, test, OCR_ShipmentTerms_AttachedDocuments, "Enter the Attached Documents : ",
				AttachedDocuments);
	}
	
	//Add Notes
	public void addNotes(String AddNotesSpecialInstructions) {
		clickElement(driver, test, OCR_ShipmentTerms_AddNotes, "Click on ADD Notes button");
		typeText(driver, test, OCR_ShipmentTerms_AddNotesSpecialInstructions, "Enter the Add Notes Special Instructions : ", AddNotesSpecialInstructions);
		clickElement(driver, test, OCR_ShipmentTerms_SaveAndReturn, "Click On SaveAndReturn");
	}

	// click on Save and Proceed button
		public void clickSaveAndProceedBtn() {
			scrollToBottom(driver);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ShipmentTerms_SaveAndProceedBtn, "click on Save and Proceed button");
		}
}
