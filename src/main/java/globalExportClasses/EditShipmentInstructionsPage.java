package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentInstructionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Shipment_Inst_SpecialInstructions = "//textarea[@id='shipment_specialInstructions']";
	public static final String OCR_Shipment_Inst_ShipmentSpecialInstructions = "//textarea[@id='shipment_loadShInstrs']";
	public static final String OCR_Shipment_Inst_AttachedDocuments = "//textarea[@id='shipment_attachedDocuments']";
	public static final String OCR_Shipment_Inst_ExemptionStatementRoutingInfo = "//textarea[@id='shipment_routingInfo']";
	public static final String OCR_Shipment_Inst_DestinationControlStatement = "//textarea[@id='shipment_dosDestCtrl']";
	public static final String OCR_Shipment_Inst_ComplianceCertificateText = "//textarea[@id='shipment_cocText']";
	public static final String OCR_Shipment_Inst_BD_Incoterm = "//input[@id='shipment_salesTerms']";
	public static final String OCR_Shipment_Inst_BD_IncoNamedForDestination = "//input[@id='shipment_deliveryLocation']";
	public static final String OCR_Shipment_Inst_BD_MasterAWBNumber = "//input[@id='shipment_mawbNo']";
	public static final String OCR_Shipment_Inst_BD_HouseAirwayBillNumber = "//input[@id='shipment_hawbNo']";
	public static final String OCR_Shipment_Inst_BD_NextFlightOut = "//select[@id='shipment_nextFlightOut']";
	public static final String OCR_Shipment_Inst_BD_ConsolidateShip = "//select[@id='shipment_consolidateShipment']";
	public static final String OCR_Shipment_Inst_BD_InsuranceRequired = "//select[@id='shipment_insuranceRequired']";
	public static final String OCR_Shipment_Inst_BD_InsuranceAmount = "//input[@id='shipment_insuranceAmount']";
	public static final String OCR_Shipment_Inst_BD_Prepaid = "//select[@id='shipment_prepaid']";
	public static final String OCR_Shipment_Inst_BD_Collect = "//select[@id='shipment_collect']";
	public static final String OCR_Shipment_Inst_BD_NoofPackages = "//input[@id='shipment_packageNos']";
	public static final String OCR_Shipment_Inst_BD_Dimension = "//input[@id='shipment_dimension']";
	public static final String OCR_Shipment_Inst_BD_TotalShipmentWeight = "//input[@id='shipment_totalShipmentWeight']";
	public static final String OCR_Shipment_Inst_Save = "//form[@id='editShipment']//button[3]";
	public static final String OCR_Shipment_Inst_SaveAndReturn = "//button[@id='saveandreturn']";
	public static final String OCR_Shipment_Inst_ConsigneePONumber = "//textarea[@id='shipment_consigneeRef']";
	public static final String OCR_Shipment_Inst_EEIHeader = "//textarea[@id='shipment_sedItemsHeader']";
	public static final String OCR_Shipment_Inst_EEIFooter = "//textarea[@id='shipment_sedItemsFooter']";
	public static final String OCR_Shipment_Inst_EEIDOCHeader = "//textarea[@id='shipment_itemsHeaderDoc']";
	public static final String OCR_Shipment_Inst_EEIDOCFooter = "//textarea[@id='shipment_itemsFooterDoc']";
	public static final String OCR_Shipment_Inst_EEIDOSHeader = "//textarea[@id='shipment_itemsHeaderDos']";
	public static final String OCR_Shipment_Inst_EEIDOSFooter = "//textarea[@id='shipment_itemsFooterDos']";
	public static final String OCR_Shipment_Inst_AddNotesBtn = "//button[@id='addNotesBtn']";
	public static final String OCR_Shipment_Inst_AddNotes = "//textarea[@id='editTabbedShipmentNotes_shipmentNotes_notes']";
	public static final String OCR_Shipment_Inst_SaveNotes = "//input[@id='saveInstruction']";
	public static final String OCR_Shipment_Inst_CloseNotes = "(//button[@class='btn-close'])[1]";
	public static final String OCR_Shipment_Inst_AdditionalTransaction = "//i[@class='fa fa-th']";
	public static final String OCR_Shipment_Inst_AssociatedLinkedOrder = "//a[contains(text(),'Associated/ Linked Orders')]";
	

	/* ******************************* Constructor ****************************** */

	public EditShipmentInstructionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Edit Shipment-Instruction
	public void add_Instruction(String SpecialInstructions, String ShipmentSpecialInstructions,
			String AttachedDocuments, String ExemptionStatementRoutingInfo, String DestinationControlStatement,
			String ComplianceCertificateText) {
		typeText(driver, test, OCR_Shipment_Inst_SpecialInstructions, "Enter the Special Instructions : ",
				SpecialInstructions);
		typeText(driver, test, OCR_Shipment_Inst_ShipmentSpecialInstructions,
				"Enter the Shipment Special Instructions : ", ShipmentSpecialInstructions);
		typeText(driver, test, OCR_Shipment_Inst_AttachedDocuments, "Enter the Attached Documents : ",
				AttachedDocuments);
		typeText(driver, test, OCR_Shipment_Inst_ExemptionStatementRoutingInfo,
				"Enter the Exemption Statement Routing Info : ", ExemptionStatementRoutingInfo);
		typeText(driver, test, OCR_Shipment_Inst_DestinationControlStatement,
				"Enter the Destination Control Statement: ", DestinationControlStatement);
		typeText(driver, test, OCR_Shipment_Inst_ComplianceCertificateText, "Enter the Compliance Certificate Text : ",
				ComplianceCertificateText);
	}

	// Adding the Edit Shipment-Instruction
	public void add_Instruction(String SpecialInstructions, String ShipmentSpecialInstructions,
			String AttachedDocuments, String ExemptionStatementRoutingInfo, String CustPONo,
			String DestinationControlStatements, String EEIHeader, String EEIFooter, String EEIDOCHeader,
			String EEIDOCFooter, String EEIDOSHeader, String EEIDOSFooter, String ComplianceCertificateText) {
		typeText(driver, test, OCR_Shipment_Inst_SpecialInstructions, "Enter the Special Instructions : ",
				SpecialInstructions);
		typeText(driver, test, OCR_Shipment_Inst_ShipmentSpecialInstructions,
				"Enter the Shipment Special Instructions : ", ShipmentSpecialInstructions);
		typeText(driver, test, OCR_Shipment_Inst_AttachedDocuments, "Enter the Attached Documents : ",
				AttachedDocuments);
		typeText(driver, test, OCR_Shipment_Inst_ExemptionStatementRoutingInfo,
				"Enter the Exemption Statement Routing Info : ", ExemptionStatementRoutingInfo);
		typeText(driver, test, OCR_Shipment_Inst_ConsigneePONumber, "Enter Customer PO Number : ", CustPONo);
//		typeText(driver, test, OCR_Shipment_Inst_DestinationControlStatement,
//				"Enter the Destination Control Statement: ", DestinationControlStatements);
		typeText(driver, test, OCR_Shipment_Inst_EEIHeader, "Enter EEI Header : ", EEIHeader);
		typeText(driver, test, OCR_Shipment_Inst_EEIFooter, "Enter EEI Footer : ", EEIFooter);
		typeText(driver, test, OCR_Shipment_Inst_EEIDOCHeader, "Enter EEI DOC Header : ", EEIDOCHeader);
		typeText(driver, test, OCR_Shipment_Inst_EEIDOCFooter, "Enter EEI DOC Footer : ", EEIDOCFooter);
		typeText(driver, test, OCR_Shipment_Inst_EEIDOSHeader, "Enter EEI DOS Header : ", EEIDOSHeader);
		typeText(driver, test, OCR_Shipment_Inst_EEIDOSFooter, "Enter EEI DOS Footer : ", EEIDOSFooter);
		typeText(driver, test, OCR_Shipment_Inst_ComplianceCertificateText, "Enter the Compliance Certificate Text : ",
				ComplianceCertificateText);
	}

	// Adding the Booking Details and Miscellaneous Terms
	public void add_BookingDetailsandMisTerms(String InstructIncoterm, String IncoNamedForDestination,
			String MasterAWBNum, String HouseAirwayBillNumber, String NextFlightOut, String ConsolidateShip,
			String InsuranceReq, String InsuranceAmt, String prepaid, String collect, String NoofPackages,
			String Dimension, String TotalShipmentWeight) {
		scrollToElement(driver, OCR_Shipment_Inst_BD_Incoterm);
		typeText(driver, test, OCR_Shipment_Inst_BD_Incoterm, "Enter the Incoterm : ", InstructIncoterm);
		typeText(driver, test, OCR_Shipment_Inst_BD_IncoNamedForDestination, "Enter the Inco Named For Destination",
				IncoNamedForDestination);
		typeText(driver, test, OCR_Shipment_Inst_BD_MasterAWBNumber, "Enter the Master AWB Number : ", MasterAWBNum);
		typeText(driver, test, OCR_Shipment_Inst_BD_HouseAirwayBillNumber, "Enter the House Airway Bill Number : ",
				HouseAirwayBillNumber);
		selectByVisibleText(driver, test, OCR_Shipment_Inst_BD_NextFlightOut, "Select the Next Flight Out : ",
				NextFlightOut);
		selectByVisibleText(driver, test, OCR_Shipment_Inst_BD_ConsolidateShip, "Select the Consolidate Ship : ",
				ConsolidateShip);
		selectByVisibleText(driver, test, OCR_Shipment_Inst_BD_InsuranceRequired, "Select the Insurance Required : ",
				InsuranceReq);
		typeText(driver, test, OCR_Shipment_Inst_BD_InsuranceAmount, "Enter the Insurance Amount : ", InsuranceAmt);
		selectByVisibleText(driver, test, OCR_Shipment_Inst_BD_Prepaid, "Select the Prepaid : ", prepaid);
		selectByVisibleText(driver, test, OCR_Shipment_Inst_BD_Collect, "Select the Collect : ", collect);
		typeText(driver, test, OCR_Shipment_Inst_BD_NoofPackages, "Enter the No of Packages / Pieces : ", NoofPackages);
		typeText(driver, test, OCR_Shipment_Inst_BD_Dimension, "Enter the Dimension : ", Dimension);
		typeText(driver, test, OCR_Shipment_Inst_BD_TotalShipmentWeight, "Enter the Total Shipment Weight : ",
				TotalShipmentWeight);
	}

	// Click on Save
	public void click_save() {
		scrollToElement(driver, OCR_Shipment_Inst_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Shipment_Inst_Save, "Click on Save button in Instructions");
	}

	// click on Save and Return
	public void click_SaveAndReturn() {
		scrollToElement(driver, OCR_Shipment_Inst_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Shipment_Inst_SaveAndReturn, "Click on Save and Return button in Instructions");
	}

	// Get the Duly authorized officer or employee
	public String getEmployee() {
		scrollToBottom(driver);
		return getAttribute(driver, test, "//input[@id='shipment_userName']", "value",
				"Getting the Duly authorized officer or employee :");
	}

	// Get the Email
	public String getEmail() {
		return getAttribute(driver, test, "//input[@id='shipment_userEmail']", "value", "Getting the Email :");
	}
	
	//click on notes button
	public void click_Notes() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_Shipment_Inst_AddNotesBtn);
		clickElement(driver, test, OCR_Shipment_Inst_AddNotesBtn, "Click on Notes button");
	}


	//Add Notes
	public void addNotes(String addNotes) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Shipment_Inst_AddNotes, "Enter Notes : ",addNotes);
		clickElement(driver, test, OCR_Shipment_Inst_SaveNotes, "Save Notes : ");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Shipment_Inst_CloseNotes, "CLose the Notes Pop Up :");
	}
	
	//Select Associated Linked Orders from Additional Transaction details
	public void select_LinkedOrder() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_Shipment_Inst_AdditionalTransaction);
		clickElement(driver, test, OCR_Shipment_Inst_AdditionalTransaction, "Click on Additional Transaction Details :");
		clickElement(driver, test, OCR_Shipment_Inst_AssociatedLinkedOrder, "Select Associated /Linked Orders : ");
	}
	
}
