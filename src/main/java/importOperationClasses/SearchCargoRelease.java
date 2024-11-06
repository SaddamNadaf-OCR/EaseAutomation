package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchCargoRelease extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchCR_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchCR_SbuCode = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_sbuCode']";
	public static final String OCR_SearchCR_Status = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_workStatus']";
	public static final String OCR_SearchCR_EntryNo = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_entryNo']";
	public static final String OCR_SearchCR_CustomStatus = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_abiStatus']";
	public static final String OCR_SearchCR_IntRefNo = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_intRefNo']";
	public static final String OCR_SearchCR_Filer = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_filer']";
	public static final String OCR_SearchCR_Action = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_actionDone']";
	public static final String OCR_SearchCR_EntryType = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_entryType']";
	public static final String OCR_SearchCR_PortofEntry = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_portOfEntryName']";
	public static final String OCR_SearchCR_MOT = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_modeOfTransportName']";
	public static final String OCR_SearchCR_Carrier = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_carrierName']";
	public static final String OCR_SearchCR_BondType = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_bondType']";
	public static final String OCR_SearchCR_BondHolderID = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_bondHolderIdNo']";
	public static final String OCR_SearchCR_SuretyCompanyNo = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_suretyNo']";
	public static final String OCR_SearchCR_BondAccountNo = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_bondRefNo']";
	public static final String OCR_SearchCR_EstShipmentfrom = "//input[@id='resultImportSimplifiedEntry_fromEstQty']";
	public static final String OCR_SearchCR_EstShipmentto = "//input[@id='resultImportSimplifiedEntry_toEstQty']";
	public static final String OCR_SearchCR_ImportCoordReviewer = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_importReviewerId']";
	public static final String OCR_SearchCR_CorpComplianceReviewer = "//select[@id='resultImportSimplifiedEntry_importSeDetailsValue_corpImportReviewerId']";
	public static final String OCR_SearchCR_CreatedBy = "//input[@id='resultImportSimplifiedEntry_importSeDetailsValue_createdBy']";
	public static final String OCR_SearchCR_CraeteDateFrom = "//input[@id='resultImportSimplifiedEntry_fromDate']";
	public static final String OCR_SearchCR_CraeteDdateTo = "//input[@id='resultImportSimplifiedEntry_toDate']";
	public static final String OCR_SearchCR_Direction = "//select[@name='direction']";
	public static final String OCR_SearchCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SearchCR_PartyType = "//select[@id='resultImportSimplifiedEntry_importSePartiesValue_partyType']";
	public static final String OCR_SearchCR_PartyName = "//input[@id='resultImportSimplifiedEntry_importSePartiesValue_partyName']";
	public static final String OCR_SearchCR_PartyCountry = "//input[@id='resultImportSimplifiedEntry_importSePartiesValue_partyCountryName']";
	public static final String OCR_SearchCR_PartyIdNumber = "//input[@id='resultImportSimplifiedEntry_importSePartiesValue_identityDetails']";
	public static final String OCR_SearchCR_BillNo = "//input[@id='resultImportSimplifiedEntry_importSeBolValue_bolNo']";
	public static final String OCR_SearchCR_ParentBillNo = "//input[@id='resultImportSimplifiedEntry_importSeBolValue_parentBolNo']";
	public static final String OCR_SearchCR_BillType = "//select[@id='resultImportSimplifiedEntry_importSeBolValue_bolType']";
	public static final String OCR_SearchCR_PartNo = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_partNo']";
	public static final String OCR_SearchCR_PartDesc = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_partDesc']";
	public static final String OCR_SearchCR_HtsNo = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_htsNo']";
	public static final String OCR_SearchCR_CountryOfOrigin = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_countryOfOrigin']";
	public static final String OCR_SearchCR_RelatedParty = "//select[@id='resultImportSimplifiedEntry_importSeItemsValue_relatedPartyFlag']";
	public static final String OCR_SearchCR_Manufacturer = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_manufacturerId']";
	public static final String OCR_SearchCR_ValueBetweenfrom = "//input[@id='resultImportSimplifiedEntry_betFvalue']";
	public static final String OCR_SearchCR_ValueBetweento = "//input[@id='resultImportSimplifiedEntry_betTvalue']";
	public static final String OCR_SearchCR_OrderNo = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_poNo']";
	public static final String OCR_SearchCR_CommercialInvoiceNo = "//input[@id='resultImportSimplifiedEntry_importSeItemsValue_invoiceNo']";

	/* ******************** Constructor ***************************** */

	public SearchCargoRelease(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Search button
	public void click_SearchBtn() {
		clickElement(driver, test, OCR_SearchCR_SearchBtn, "Click on Search Btn");
	}

	// Selecting the options in Search tab
	public void commonSearch(String SBUCode, String Status, String EntryNo, String CustomStatus, String IntRefNo,
			String Filer, String Action, String EntryType, String PortofEntry, String MOT, String Carrier,
			String BondType, String BondHolderID, String SuretyCompanyNo, String BondAccountNo, String EstShipmentfrom,
			String EstShipmentto, String ImportCoordReviewer, String CorpComplianceReviewer, String CreatedBy,
			String CraeteDateFrom, String CraeteDdateTo, String Direction, String SortBy) {

		selectByVisibleText(driver, test, OCR_SearchCR_SbuCode, "select SBU", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchCR_Status, "select status", Status);
		typeText(driver, test, OCR_SearchCR_EntryNo, "add entry number", EntryNo);
		selectByVisibleText(driver, test, OCR_SearchCR_CustomStatus, "select custom status", CustomStatus);
		typeText(driver, test, OCR_SearchCR_IntRefNo, "add int ref. No.", IntRefNo);
		selectByVisibleText(driver, test, OCR_SearchCR_Filer, "Select Filer", Filer);
		selectByVisibleText(driver, test, OCR_SearchCR_Action, "Select Action", Action);
		typeText(driver, test, OCR_SearchCR_EntryType, "add entry type", EntryType);
		typeText(driver, test, OCR_SearchCR_PortofEntry, "add port of entry", PortofEntry);
		typeText(driver, test, OCR_SearchCR_MOT, "enter Mode of transport", MOT);
		typeText(driver, test, OCR_SearchCR_Carrier, "add carrier", Carrier);
		selectByVisibleText(driver, test, OCR_SearchCR_BondType, "select Bond Type", BondType);
		typeText(driver, test, OCR_SearchCR_BondHolderID, "add Bond Holder ID", BondHolderID);
		typeText(driver, test, OCR_SearchCR_SuretyCompanyNo, "add surety company No", SuretyCompanyNo);
		typeText(driver, test, OCR_SearchCR_BondAccountNo, "add Bond Account No", BondAccountNo);
		typeText(driver, test, OCR_SearchCR_EstShipmentfrom, "add est. shipment value", EstShipmentfrom);
		typeText(driver, test, OCR_SearchCR_EstShipmentto, "add est. shipment value to", EstShipmentto);
		selectByVisibleText(driver, test, OCR_SearchCR_ImportCoordReviewer, "select importer cord. reviewer",
				ImportCoordReviewer);
		selectByVisibleText(driver, test, OCR_SearchCR_CorpComplianceReviewer, "select corp. reviewer",
				CorpComplianceReviewer);
		typeText(driver, test, OCR_SearchCR_CreatedBy, "add creted by", CreatedBy);
		if (CraeteDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchCR_CraeteDateFrom, "click on Created Date From");
			date(driver, test, "Selected on Created Date From : ", CraeteDateFrom);
			clickElement(driver, test, OCR_SearchCR_CraeteDdateTo, "click on Created Date To");
			date(driver, test, "Selected on Created Date To : ", CraeteDdateTo);
		}
		selectByVisibleText(driver, test, OCR_SearchCR_Direction, "select order", Direction);
		selectByVisibleText(driver, test, OCR_SearchCR_SortBy, "Short By", SortBy);
	}
	// selecting the options in Party Details Search

	public void partyDetailsSearch(String PartyType, String PartyName, String PartyCountry, String PartyIdNumber) {
		selectByVisibleText(driver, test, OCR_SearchCR_PartyType, "select party type", PartyType);
		typeText(driver, test, OCR_SearchCR_PartyName, "add party name", PartyName);
		typeText(driver, test, OCR_SearchCR_PartyCountry, "add Party country", PartyCountry);
		typeText(driver, test, OCR_SearchCR_PartyIdNumber, "add Party Identification Number ", PartyIdNumber);
	}
	// Search Criteria Based on Bill Of Lading Details

	public void searchbyBillOfLadingDetails(String BillNo, String ParentBillNo, String BillType) {
		typeText(driver, test, OCR_SearchCR_BillNo, "add bill no", BillNo);
		typeText(driver, test, OCR_SearchCR_ParentBillNo, "add parent bill no", ParentBillNo);
		selectByVisibleText(driver, test, OCR_SearchCR_BillType, "select bill type", BillType);
	}
	// Search by Item Details

	public void SearchbyItemDetails(String PartNo, String PartDesc, String HtsNo, String CountryOfOrigin,
			String RelatedParty, String Manufacturer, String ValueBetweenfrom, String ValueBetweento, String OrderNo,
			String CommercialInvoiceNo) {
		typeText(driver, test, OCR_SearchCR_PartNo, "add part no.", PartNo);
		typeText(driver, test, OCR_SearchCR_PartDesc, "add part descriptions", PartDesc);
		typeText(driver, test, OCR_SearchCR_HtsNo, "add HTS no", HtsNo);
		typeText(driver, test, OCR_SearchCR_CountryOfOrigin, "add country of origin", CountryOfOrigin);
		selectByVisibleText(driver, test, OCR_SearchCR_RelatedParty, "select releted party", RelatedParty);
		typeText(driver, test, OCR_SearchCR_Manufacturer, "add manufacturer", Manufacturer);
		typeText(driver, test, OCR_SearchCR_ValueBetweenfrom, "add value from", ValueBetweenfrom);
		typeText(driver, test, OCR_SearchCR_ValueBetweento, "add value to", ValueBetweento);
		typeText(driver, test, OCR_SearchCR_OrderNo, "add order no", OrderNo);
		typeText(driver, test, OCR_SearchCR_CommercialInvoiceNo, "add commericial invoice no", CommercialInvoiceNo);
	}

}
