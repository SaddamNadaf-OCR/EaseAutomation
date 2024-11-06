package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CargoReleaseDeatilsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_CRDetails_ClickEntryNolink = "//a[contains(text(),'Entry Number')]";
	public static final String OCR_CRDetails_SGNTemplates = "//input[@id='searchForm_uniqueId_templateName']";
	public static final String OCR_CRDetails_Search = "//button[@name='Search']";
	public static final String OCR_CRDetails_Select = "//div[3]//div[1]//button[1]";
	public static final String OCR_CRDetails_ClosePopUp = "//button[@class='close']";
	public static final String OCR_CRDetails_ClickIntRefNo = "//a[contains(text(),'Internal Ref. No')]";
	public static final String OCR_CRDetails_SaveTransaction = "//button[@name='Save.x']";
	public static final String OCR_CRDetails_CountryOfImport = "//input[@id='editSimplifiedEntry_importSeDetailsValue_countryOfImport']";
	public static final String OCR_CRDetails_Filer = "//select[@id='editSimplifiedEntry_importSeDetailsValue_filer']";
	public static final String OCR_CRDetails_Action = "//select[@id='editSimplifiedEntry_importSeDetailsValue_actionDone']";
	public static final String OCR_CRDetails_clickEntryTypelink = "//label[@class='col-xs-2 control-label']//a[contains(text(),'Entry Type')]";
	public static final String OCR_CRDetails_ClickOnSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CRDetails_ClickOnPortOfEntryLink = "//a[@id='portsPopup1']";
	public static final String OCR_CRDetails_PortIDAdd = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_CRDetails_ClkSearch = "//button[@name='Search']";
	public static final String OCR_CRDetails_ClkSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CRDetails_ClkMOTLink = "//a[@class='motPopup']";
	public static final String OCR_CRDetails_SelectMOT = "//button[@name='Ok']";
	public static final String OCR_CRDetails_PortOfUnladingLink = "//a[@id='portsPopup3']";
	public static final String OCR_CRDetails_AddPortID = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_CRDetails_ClickSearch = "//button[@name='Search']";
	public static final String OCR_CRDetails_ClickSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CRDetails_BondHolderIDType = "//select[@id='editSimplifiedEntry_importSeDetailsValue_bondHolderIdType']";
	public static final String OCR_CRDetails_CarrierLink = "//a[@id='carrierPopup']";
	public static final String OCR_CRDetails_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_CRDetails_SelectCarrier = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CRDetails_BondType = "//select[@id='editSimplifiedEntry_importSeDetailsValue_bondType']";
	public static final String OCR_CRDetails_BondHolderIDNo = "//input[@id='editSimplifiedEntry_importSeDetailsValue_bondHolderIdNo']";
	public static final String OCR_CRDetails_BondAccountNo = "//input[@id='editSimplifiedEntry_importSeDetailsValue_bondRefNo']";
	public static final String OCR_CRDetails_SuretyCompanyNo = "//input[@id='editSimplifiedEntry_importSeDetailsValue_suretyNo']";
	public static final String OCR_CRDetails_BondAmount = "//input[@id='editSimplifiedEntry_importSeDetailsValue_bondAmount']";
	public static final String OCR_CRDetails_EstimatedShipmentValue = "//input[@id='editSimplifiedEntry_estmtValue']";
	public static final String OCR_CRDetails_FTZId = "//input[@id='editSimplifiedEntry_importSeDetailsValue_ftzId']";
	public static final String OCR_CRDetails_ImmediateDlvryIndicator = "//select[@id='editSimplifiedEntry_importSeDetailsValue_ImmediateDeliveryIndicator']";
	public static final String OCR_CRDetails_DISIndicator = "//select[@id='editSimplifiedEntry_importSeDetailsValue_disInd']";
	public static final String OCR_CRDetails_CancellationCode = "//select[@id='editSimplifiedEntry_importSeDetailsValue_reasonCode']";
	public static final String OCR_CRDetails_LocationofGoods = "//input[@id='editSimplifiedEntry_importSeDetailsValue_locationofGoods']";
	public static final String OCR_CRDetails_MultiCargoDispositionsInd = "//select[@id='editSimplifiedEntry_importSeDetailsValue_multiCargoDisInd']";
	public static final String OCR_CRDetails_DISRefNumber = "//input[@id='editSimplifiedEntry_importSeDetailsValue_referenceIdentifier']";
	public static final String OCR_CRDetails_ElectedExamSite = "//input[@id='editSimplifiedEntry_importSeDetailsValue_electedExamSiteName']";
	public static final String OCR_CRDetails_ElectedEntryDate = "//input[@id='editSimplifiedEntry_electedEntryDate']";
	public static final String OCR_CRDetails_WarehouseEntryFilerCode = "//input[@id='editSimplifiedEntry_importSeDetailsValue_origWarehouseEFCode']";
	public static final String OCR_CRDetails_WarehouseEntryPortLink = "//a[@id='portsPopup4']";
	public static final String OCR_CRDetails_GeneralOrderNo = "//input[@id='editSimplifiedEntry_importSeDetailsValue_generalOrdeNumber']";
	public static final String OCR_CRDetails_WarehouseEntryNo = "//input[@id='editSimplifiedEntry_importSeDetailsValue_origWarehouseEntryNO']";
	public static final String OCR_CRDetails_AddParty = "//button[@name='Add Party']";
	public static final String OCR_CRDetails_ClickLineItemTab = "//a[@class='simplifiedlineItem']";
	public static final String OCR_CRDetails_ClickSubmitTab = "//a[@class='submit']";
	public static final String OCR_CRDetails_ClickAlertIcon = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_CRDetails_ClickImporter = "//a[contains(text(),'1')]";
	public static final String OCR_CRDetails_ClickAlertPopupClose = "//button[@class='close']";
	public static final String OCR_CRDetails_SelectRadiBroker = "//input[@id='editSimplifiedEntry_importSeDetailsValue_filerB']";

	/* ******************** Constructor ***************************** */
	public CargoReleaseDeatilsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Add General Information
	public void generalInformation(String TemplatesEN, String TemplatesRefN, String CountryOfImp, String Filer,
			String Action, String EntryNumber, String PortEntryId, String MOTDesc, String PortUnladingId,
			String BondHolderIDType, String Carrier, String BondType, String BondHolderIDNo, String BondAccountNo,
			String SuretyCompanyNo, String BondAmount, String EstimatedShipmentValue) {

		if (TemplatesEN.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_ClickEntryNolink, "Click on Entry Number");
			try {
				typeText(driver, test, OCR_CRDetails_SGNTemplates, "Add System Generated Number : ", TemplatesEN);
				clickElement(driver, test, OCR_CRDetails_Search, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + TemplatesEN + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates: " + TemplatesEN);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD ENTRY NUMBER");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		if (TemplatesRefN.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_ClickIntRefNo, "Click on Entry Number");
			try {
				typeText(driver, test, OCR_CRDetails_SGNTemplates, "Add System Generated Number : ", TemplatesRefN);
				clickElement(driver, test, OCR_CRDetails_Search, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + TemplatesRefN + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates: " + TemplatesRefN);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD ENTRY NUMBER");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_CRDetails_CountryOfImport, "add Country of Import : ", CountryOfImp);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CRDetails_SaveTransaction, "Click on Save");
		selectByVisibleText(driver, test, OCR_CRDetails_Filer, "select filer : ", Filer);
		//if (Filer.length() > 0) {
		//	if (Filer.contains("Importer"))
		//		clickElement(driver, test, OCR_CRDetails_Filer, "Select Filer as Importer");
		//	else {
				//clickElement(driver, test, OCR_CRDetails_SelectRadiBroker, "Select Filer as Broker");
		//	}
		//}
		selectByVisibleText(driver, test, OCR_CRDetails_Action, "Select action : ", Action);
		Wait.waitfor(3);
		if (EntryNumber.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_clickEntryTypelink, "Click entry type link");
			try {
				String EntryNo = "//td[contains(text(),'" + EntryNumber + "')]";
				clickElement(driver, test, EntryNo, "Select Entry Number: " + EntryNumber);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Entry type");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		if (PortEntryId.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_ClickOnPortOfEntryLink, "Click on Port of Entry Link");
			try {
				typeText(driver, test, OCR_CRDetails_AddPortID, "Add Port ID : ", PortEntryId);
				clickElement(driver, test, OCR_CRDetails_Search, "Click On Search");
				String Port = "//td[contains(text(),'" + PortEntryId + "')]";
				clickElement(driver, test, Port, "Select Port of entry: " + PortEntryId);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Port of Entry");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(2);
		if (MOTDesc.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_ClkMOTLink, "Click on Mode Of Transport Link");
			try {
				String MOT = "(//td[contains(text(),'" + MOTDesc + "')])[1]";
				clickElement(driver, test, MOT, "Select MOT: " + MOTDesc);
				clickElement(driver, test, OCR_CRDetails_SelectMOT, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add MOT");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(2);
		if (PortUnladingId.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_PortOfUnladingLink, "Click on Port of Unlading");
			try {
				typeText(driver, test, OCR_CRDetails_AddPortID, "Add Port ID : ", PortUnladingId);
				clickElement(driver, test, OCR_CRDetails_Search, "Click On Search");
				String PortUn = "//td[contains(text(),'" + PortUnladingId + "')]";
				clickElement(driver, test, PortUn, "Select Port of Unlading: " + PortUnladingId);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Port of Unlading");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_CRDetails_BondHolderIDType, "Select Bond Holder ID Type",
				BondHolderIDType);
		Wait.waitfor(3);
		if (Carrier.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_CarrierLink, "Click on Carrier Link");
			try {
				typeText(driver, test, OCR_CRDetails_CarrierCode, "Add Port ID : ", Carrier);
				clickElement(driver, test, OCR_CRDetails_Search, "Click On Search");
				String CarrierCode = "//td[contains(text(),'" + Carrier + "')]";
				clickElement(driver, test, CarrierCode, "Select Carrier: " + Carrier);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Carrier");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_CRDetails_BondType, "Select Bond Type : ", BondType);
		typeText(driver, test, OCR_CRDetails_BondHolderIDNo, "Add Bond Holder ID No : ", BondHolderIDNo);
		typeText(driver, test, OCR_CRDetails_BondAccountNo, "Add Bond Account No : ", BondAccountNo);
		typeText(driver, test, OCR_CRDetails_SuretyCompanyNo, "Add Surety Company No : ", SuretyCompanyNo);
		typeText(driver, test, OCR_CRDetails_BondAmount, "Add Bond Amount : ", BondAmount);
		typeText(driver, test, OCR_CRDetails_EstimatedShipmentValue, "Add Estimated Shipment Value : ",
				EstimatedShipmentValue);
		clickElement(driver, test, OCR_CRDetails_SaveTransaction, "save transaction");
	}

	// Additional Information
	public void AdditionalInformation(String FTZId, String ImmediateDlvryIndicator, String DISIndicator,
			String CancellationCode, String LocationofGoods, String MultiCargoDispositionsInd, String DISRefNumber,
			String ElectedExamSite, String ElectedEntryDate, String WarehouseEntryFilerCode, String WarehouseEntryPort,
			String GeneralOrderNo, String WarehouseEntryNo) {
		typeText(driver, test, OCR_CRDetails_FTZId, "Add FTZ id : ", FTZId);
		selectByVisibleText(driver, test, OCR_CRDetails_ImmediateDlvryIndicator, "Select Immediate Delivery Indicator",
				ImmediateDlvryIndicator);
		selectByVisibleText(driver, test, OCR_CRDetails_DISIndicator, "Select DIS Indicator : ", DISIndicator);
		selectByVisibleText(driver, test, OCR_CRDetails_CancellationCode, "Select Cancellation Code : ",
				CancellationCode);
		typeText(driver, test, OCR_CRDetails_LocationofGoods, "Add Location of Goods : ", LocationofGoods);
		selectByVisibleText(driver, test, OCR_CRDetails_MultiCargoDispositionsInd,
				"Select Multiple Cargo Dispositions Indicator : ", MultiCargoDispositionsInd);
		typeText(driver, test, OCR_CRDetails_DISRefNumber, "Add DIS Reference Number : ", DISRefNumber);
		typeText(driver, test, OCR_CRDetails_ElectedExamSite, "Add Elected Exam Site : ", ElectedExamSite);
		clickElement(driver, test, OCR_CRDetails_ElectedEntryDate, "Select Elected Entry Date");
		date(driver, test, "Elecetd Entry DATE : ", ElectedEntryDate);
		typeText(driver, test, OCR_CRDetails_WarehouseEntryFilerCode, "Add Warehouse Entry Filer Code : ",
				WarehouseEntryFilerCode);
		Wait.waitfor(2);
		if (WarehouseEntryPort.length() > 0) {
			clickElement(driver, test, OCR_CRDetails_WarehouseEntryPortLink, "Click on Carrier Link");
			try {
				typeText(driver, test, OCR_CRDetails_AddPortID, "Add Port ID : ", WarehouseEntryPort);
				clickElement(driver, test, OCR_CRDetails_Search, "Click On Search");
				String Warehouse = "//td[contains(text(),'" + WarehouseEntryPort + "')]";
				clickElement(driver, test, Warehouse, "Select Carrier: " + WarehouseEntryPort);
				clickElement(driver, test, OCR_CRDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Warehouse Entry Port");
				clickElement(driver, test, OCR_CRDetails_ClosePopUp, "Click on Close");
			}
		}
		typeText(driver, test, OCR_CRDetails_GeneralOrderNo, "Add General Order Number : ", GeneralOrderNo);
		typeText(driver, test, OCR_CRDetails_WarehouseEntryNo, "Add Warehouse Entry Number : ", WarehouseEntryNo);
		clickElement(driver, test, OCR_CRDetails_SaveTransaction, "save transaction");
	}

	// Add Party Details
	public void addPartyDetails() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CRDetails_AddParty, "Click On Add Party");
	}

	// Click on Impporter of record
	public void clickImporter() {
		clickElement(driver, test, OCR_CRDetails_ClickImporter, "Click on Importer");

	}

	// Click on Line Item Details Tab
	public void lineitemdetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CRDetails_ClickLineItemTab, "Click on Line Item Details Tab");
	}

	// Click on Submit Tab
	public void submitTab() {
		clickElement(driver, test, OCR_CRDetails_ClickSubmitTab, "Click on submit tab");
	}

	// Click on Alert Icon
	public void alertIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CRDetails_ClickAlertIcon, "Click on alert icon");
	}

	// Click on Save

	public void clickOnSave() {
		clickElement(driver, test, OCR_CRDetails_SaveTransaction, "Click on Save");
	}

	// Click on Alert Popup Close
	public void alertClose() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_CRDetails_ClickAlertPopupClose, "Click Alert Popup Close");
	}

	// Validation for Cargo Details
	public void validationCargoDetails() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Entry Number should be required')]")) {
					test.log(LogStatus.INFO, "Entry Number should be required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Header Details for Cargo Release");
		}
	}

	// Validation for General information
	public void validationGeneralInformation() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Action is required')]")) {
				test.log(LogStatus.INFO, "Action is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filer is required')]")) {
				test.log(LogStatus.INFO, "Fileris required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Entry Type is required')]")) {
				test.log(LogStatus.INFO, "Entry Type is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Mode of transportation (MOT) code is required')]")) {
				test.log(LogStatus.INFO, "Mode of transportation (MOT) code is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Holder ID Type is required')]")) {
				test.log(LogStatus.INFO, "Bond Holder ID Type is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Holder ID Number is required')]")) {
				test.log(LogStatus.INFO, "Bond Holder ID Number is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Type is required')]")) {
				test.log(LogStatus.INFO, "Bond Type is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Estimated Shipment Value is required')]")) {
				test.log(LogStatus.INFO, "Estimated Shipment Value is required");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
			alertClose();
		}

	}

	// Validation for Party details Importer
	public void validationPartyDeatilsImporter() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Importer Details is required')]")) {
				test.log(LogStatus.INFO, "Importer Details is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Party details Consignee
	public void validationPartyDeatilsConsignee() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Consignee is missing')]")) {
				test.log(LogStatus.INFO, "Consignee is missing");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Party details Manuf./Supplier
	public void validationPartyDeatilsManufSupplier() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Manuf./Supplier is required')]")) {
				test.log(LogStatus.INFO, "Manuf./Supplier is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Party details Selling Party
	public void validationPartyDeatilsSellingParty() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Selling Party is missing')]")) {
				test.log(LogStatus.INFO, "Selling Party is missing");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Party details Buying Party
	public void validationPartyDeatilsBuyingParty() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Buying Party is required')]")) {
				test.log(LogStatus.INFO, "Buying Party is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Contact name and Contact phone
	public void validationContactNameAndPhone() {
				try {
					if (isDisplayed(driver,"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Contact name missing for party type Importer of Re')]")) {
						test.log(LogStatus.INFO, "Contact name missing for party type Importer of Record");
						}
					if (isDisplayed(driver,"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Contact phone missing for party type Importer of R')]")) {
						test.log(LogStatus.INFO, "Contact phone missing for party type Importer of Record");
						}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");					
						}
					}
			
}
