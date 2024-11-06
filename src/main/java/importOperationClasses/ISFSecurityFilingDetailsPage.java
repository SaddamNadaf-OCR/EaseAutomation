package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ISFSecurityFilingDetailsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SecurityFilingDetails_SaveBtn = "//button[@id='save']";
	public static final String OCR_SecurityFilingDetails_ISFNoLink = "//a[contains(text(),'ISF No')]";
	public static final String OCR_SecurityFilingDetails_Template = "//input[@id='searchForm_uniqueId_templateName']";
	public static final String OCR_SecurityFilingDetails_PopUpSearchBtn = "//button[@name='Search']";
	public static final String OCR_SecurityFilingDetails_PopUpClose = "//button[@class='close']";
	public static final String OCR_SecurityFilingDetails_PopUpSelectBtn = "//button[contains(text(),'Select')][1]";
	public static final String OCR_SecurityFilingDetails_InternalRefNoLink = "//a[contains(text(),'Internal Ref. No')]";
	public static final String OCR_SecurityFilingDetails_CustomsTransactionNo = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_transNo']";  
	public static final String OCR_SecurityFilingDetails_ModeofTransport = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_transportMode']";
	public static final String OCR_SecurityFilingDetails_CarrierSCACCodeLink = "//a[@id='isfCarrierPopup']";
	public static final String OCR_SecurityFilingDetails_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_SecurityFilingDetails_ShipmentType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_shipmentType']";
	public static final String OCR_SecurityFilingDetails_ShipmentSubType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_shipmentSubType']";
	public static final String OCR_SecurityFilingDetails_ShippingDate = "//input[@id='editImporterSecurityFiling_shipDate']";
	public static final String OCR_SecurityFilingDetails_EstimatedArrivalDate = "//input[@id='editImporterSecurityFiling_arrivalDate']";
	public static final String OCR_SecurityFilingDetails_FilingMode = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_filingMode']";
	public static final String OCR_SecurityFilingDetails_FilingSystem = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_filingSystem']";
	public static final String OCR_SecurityFilingDetails_Action = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_actionDone']";
	public static final String OCR_SecurityFilingDetails_ActionReason = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_actionResn']";
	public static final String OCR_SecurityFilingDetails_FiledBy = "//select[@id='iba']";
	public static final String OCR_SecurityFilingDetails_SubmissionType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_isfSubmissionType']";
	public static final String OCR_SecurityFilingDetails_FilerCodeLink = "//a[@id='filerCode']";
	public static final String OCR_SecurityFilingDetails_ImporterCode = "//input[@id='searchForm_importer_importerCode']";
	public static final String OCR_SecurityFilingDetails_FilerName = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_filerName']";
	public static final String OCR_SecurityFilingDetails_FilerIDType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_filerIdType']";
	public static final String OCR_SecurityFilingDetails_FilerIDNo = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_isfFilerNo']";
	public static final String OCR_SecurityFilingDetails_FilingPortLink = "//a[@id='isfFilingPort']";
	public static final String OCR_SecurityFilingDetails_PortId = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_SecurityFilingDetails_BondHolderType = "//select[@id='bondHolderPartyType']";
	public static final String OCR_SecurityFilingDetails_BondHolderCodeLink = "//a[@id='bondHolderCode']";
	public static final String OCR_SecurityFilingDetails_BrokerID = "//input[@id='searchForm_broker_brokerId']";
	public static final String OCR_SecurityFilingDetails_BondHolderName = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_bondHolderName']";
	public static final String OCR_SecurityFilingDetails_BondHolderIDType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_bondHolderIdType']";
	public static final String OCR_SecurityFilingDetails_BondHolderIDNo = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_bondHolderIdNo']";
	public static final String OCR_SecurityFilingDetails_BondType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_bondType']";
	public static final String OCR_SecurityFilingDetails_BondActivityType = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_bondActivity']";
	public static final String OCR_SecurityFilingDetails_SuretyNo = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_suretyNo']";
	public static final String OCR_SecurityFilingDetails_BondReferenceNumber = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_bondRefNo']";
	public static final String OCR_SecurityFilingDetails_AddPartyLink = "//button[@id='addParty']";
	public static final String OCR_SecurityFilingDetails_EstimatedValue = "//input[@id='editImporterSecurityFiling_estimatedValue']";
	public static final String OCR_SecurityFilingDetails_EstimatedNoofPackages = "//input[@id='editImporterSecurityFiling_estimatedNoOfPackages']";
	public static final String OCR_SecurityFilingDetails_EstimatedQty = "//input[@id='editImporterSecurityFiling_estimatedQuantity']";
	public static final String OCR_SecurityFilingDetails_UOM = "//input[@id='editImporterSecurityFiling_importIsf10DetailsValue_uom']";
	public static final String OCR_SecurityFilingDetails_EstimatedWeight = "//input[@id='editImporterSecurityFiling_estimatedWeight']";
	public static final String OCR_SecurityFilingDetails_UOM1 = "//select[@id='editImporterSecurityFiling_importIsf10DetailsValue_unitOfWeight']";
	public static final String OCR_SecurityFilingDetails_UnladingPortCodeType = "//select[@id='portOfUnladingCodeType']";
	public static final String OCR_SecurityFilingDetails_UnladingPortName = "//input[@id='portOfUnladingName']";
	public static final String OCR_SecurityFilingDetails_UnladingPortCode = "//input[@id='portOfUnladingCode']";
	public static final String OCR_SecurityFilingDetails_PlaceofDeliveryCodeType = "//select[@id='placeOfDeliveryCodeType']";
	public static final String OCR_SecurityFilingDetails_PlaceofDeliveryName = "//input[@id='placeOfDelivery']";
	public static final String OCR_SecurityFilingDetails_PlaceofDeliveryCode = "//input[@id='placeOfDeliveryCode']";
	public static final String OCR_SecurityFilingDetails_ItemDeatilsTab = "//a[contains(text(),'ISF Item Details')]";
	public static final String OCR_SecurityFilingDetails_AlertIconClk = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_SecurityFilingDetails_CloseAlertIcon = "//button[@class='close']";
	
	/* ******************** Constructor ***************************** */
	public ISFSecurityFilingDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//General Information
	public void generalInformationISF(String TemplatesISFNo, String TemplatesIntRefNo, String CustomsTransactionNo, String ModeofTransport,
				String CarrierSCACCode, String ShipmentType, String ShipmentSubType, String ShippingDate, String EstimatedArrivalDate) {
		if (TemplatesISFNo.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingDetails_ISFNoLink, "Click on ISF No. Link");
			try {
				typeText(driver, test, OCR_SecurityFilingDetails_Template, "Add System Generated Number : ", TemplatesISFNo);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSearchBtn, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + TemplatesISFNo + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates : " + TemplatesISFNo);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD ISF No");
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpClose, "Click on Close");
			}
		}
		Wait.waitfor(3);
		if (TemplatesIntRefNo.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingDetails_InternalRefNoLink, "Click on Internal Ref No. Link");
			try {
				typeText(driver, test, OCR_SecurityFilingDetails_Template, "Add System Generated Number : ", TemplatesIntRefNo);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSearchBtn, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + TemplatesIntRefNo + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates : " + TemplatesIntRefNo);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Internal Ref No");
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpClose, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_SecurityFilingDetails_CustomsTransactionNo, "Add Customs Transaction No : ", CustomsTransactionNo);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_ModeofTransport, "Select Mode of Transport : ", ModeofTransport);
		Wait.waitfor(3);
		if (CarrierSCACCode.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingDetails_CarrierSCACCodeLink, "Click on Internal Ref No. Link");
			try {
				typeText(driver, test, OCR_SecurityFilingDetails_CarrierCode, "Add Carrier SCAC Code : ", CarrierSCACCode);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSearchBtn, "Click On Search");
				String Carrier = "//td[contains(text(),'" + CarrierSCACCode + "')]";
				clickElement(driver, test, Carrier, "Select SGN Templates : " + CarrierSCACCode);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Carrier SCAC Code");
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpClose, "Click on Close");
			}
		}
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_ShipmentType, "Select Shipment Type : ", ShipmentType);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_ShipmentSubType, "Select Shipment Sub Type : ", ShipmentSubType);
		clickElement(driver, test, OCR_SecurityFilingDetails_ShippingDate, "Select Shipping Date :");
		date(driver, test, "Shipping Date : ", ShippingDate);
		clickElement(driver, test, OCR_SecurityFilingDetails_EstimatedArrivalDate, "Select Estimated Arrival Date : ");
		date(driver, test, "Estimated Arrival Date : ", EstimatedArrivalDate);	
	}
	
	//Click on Save
	public void clickSave() {
		clickElement(driver, test, OCR_SecurityFilingDetails_SaveBtn, "Click on Save");
	}
	
	//Filing Details
	public void filingDetails(String FilingMode, String FilingSystem, String Action, String ActionReason, String FiledBy, String SubmissionType,
			String ImporterCode, String FilerName, String FilerIDType, String FilerIDNo, String PortID) {
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_FilingMode, "Select Filing Mode : ", FilingMode);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_FilingSystem, "Select Filing System : ", FilingSystem);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_Action, "Select Action : ", Action);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_ActionReason, "Select Action Reason : ", ActionReason);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_FiledBy, "Select Filed By : ", FiledBy);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_SubmissionType, "Select Submission Type : ", SubmissionType);
		Wait.waitfor(3);
		if (ImporterCode.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingDetails_FilerCodeLink, "Click on Filer Code Link");
			try {
				typeText(driver, test, OCR_SecurityFilingDetails_ImporterCode, "Add Importer Code : ", ImporterCode);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSearchBtn, "Click On Search");
				String Importer = "//td[contains(text(),'" + ImporterCode + "')]";
				clickElement(driver, test, Importer, "Select Importer Code : " + ImporterCode);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Filer Code");
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpClose, "Click on Close");
			}
		}
		typeText(driver, test, OCR_SecurityFilingDetails_FilerName, "Add Filer Name : ", FilerName);
		typeText(driver, test, OCR_SecurityFilingDetails_FilerIDType, "Add Filer ID Type : ", FilerIDType);
		typeText(driver, test, OCR_SecurityFilingDetails_FilerIDNo, "Add Filer ID No : ", FilerIDNo);
		Wait.waitfor(3);
		if (PortID.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingDetails_FilingPortLink, "Click on Filer Code Link");
			try {
				typeText(driver, test, OCR_SecurityFilingDetails_PortId, "Add Port ID : ", PortID);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSearchBtn, "Click On Search");
				String Port = "//td[contains(text(),'" + PortID + "')]";
				clickElement(driver, test, Port, "Select Port ID : " + PortID);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Filing Port");
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpClose, "Click on Close");
			}
		}
	}
	
	//Bond Details
	public void bondDetails(String BondHolderType, String ImporterCode1, String BondHolderName, String BondHolderIDType, String BondHolderIDNo,
							String BondType, String BondActivityType, String SuretyNo, String BondReferenceNumber) {
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_BondHolderType, "Select Bond Holder Type : ", BondHolderType);
		Wait.waitfor(3);
		if (ImporterCode1.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingDetails_BondHolderCodeLink, "Click on Bond Holder Code Link");
			try {
				typeText(driver, test, OCR_SecurityFilingDetails_ImporterCode, "Add Importer : ", ImporterCode1);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSearchBtn, "Click On Search");
				String Imp = "//td[contains(text(),'" + ImporterCode1 + "')]";
				clickElement(driver, test, Imp, "Select Importer Code : " + ImporterCode1);
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Bond Holder Code");
				clickElement(driver, test, OCR_SecurityFilingDetails_PopUpClose, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_SecurityFilingDetails_BondHolderName, "Add Bond Holder Name : ", BondHolderName);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_BondHolderIDType, "Select Bond Holder ID Type : ", BondHolderIDType);
		typeText(driver, test, OCR_SecurityFilingDetails_BondHolderIDNo, "Add Bond Holder ID No : ", BondHolderIDNo);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_BondType, "Select Bond Type : ", BondType);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_BondActivityType, "Select Bond Activity Type : ", BondActivityType);
		typeText(driver, test, OCR_SecurityFilingDetails_SuretyNo, "Add Surety No", SuretyNo);
		typeText(driver, test, OCR_SecurityFilingDetails_BondReferenceNumber, "Add Bond Reference Number : ", BondReferenceNumber);
	}
	
	// Click Add Party 
	public void addParty() {
		clickElement(driver, test, OCR_SecurityFilingDetails_AddPartyLink, "Click on Add Party Btn");	
	}
	
	//Summary
	public void summary(String EstimatedValue, String EstimatedNoofPackages, String EstimatedQty, String EstimatedUOM, String EstimatedWeight,
						String EstimatedUOM1, String UnladingPortCodeType, String UnladingPortName, String UnladingPortCode, String PlaceofDeliveryCodeType,
						String PlaceofDeliveryName, String PlaceofDeliveryCode) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_SecurityFilingDetails_EstimatedValue, "Add Estimated Value : ", EstimatedValue);
		typeText(driver, test, OCR_SecurityFilingDetails_EstimatedNoofPackages, "Add Estimated No of Packages : ", EstimatedNoofPackages);
		typeText(driver, test, OCR_SecurityFilingDetails_EstimatedQty, "Add Estimated Qty : ", EstimatedQty);
		typeText(driver, test, OCR_SecurityFilingDetails_UOM, "Add Estimated UOM : ", EstimatedUOM);
		typeText(driver, test, OCR_SecurityFilingDetails_EstimatedWeight, "Add Estimated Weight : ", EstimatedWeight);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_UOM1, "Select Estimated UOM1 : ", EstimatedUOM1);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_UnladingPortCodeType, "Select Unlading Port Code Type : ", UnladingPortCodeType);
		typeText(driver, test, OCR_SecurityFilingDetails_UnladingPortName, "Add Unlading Port Name : ", UnladingPortName); //Pop up said enter data Manually
		typeText(driver, test, OCR_SecurityFilingDetails_UnladingPortCode, "Add Unlading Port Code : ", UnladingPortCode);
		selectByVisibleText(driver, test, OCR_SecurityFilingDetails_PlaceofDeliveryCodeType, "Add Place of Delivery Code Type : ", PlaceofDeliveryCodeType);
		typeText(driver, test, OCR_SecurityFilingDetails_PlaceofDeliveryName, "Add Place of Delivery Name : ", PlaceofDeliveryName); //Pop up said enter data Manually
		typeText(driver, test, OCR_SecurityFilingDetails_PlaceofDeliveryCode, "Add Place of Delivery Code : ", PlaceofDeliveryCode);
	}

	//Click on Item Details Tab
	public void itemDeatilsTab() {
		clickElement(driver, test, OCR_SecurityFilingDetails_ItemDeatilsTab, "Click on Item Details Tab");
	}
	
	//Click on Alert Icon
	public void clickAlert() {
		clickElement(driver, test, OCR_SecurityFilingDetails_AlertIconClk, "Click on Alert Icon");
	}
	
	//Close Alert Icon
	public void closeAlert() {
		clickElement(driver, test, OCR_SecurityFilingDetails_CloseAlertIcon, "Close Alert Icon");
	}

//***************************************Validation Security Filing (ISF) Details Tab********************************//
	
	//Validation for Security Filing (ISF) Details
	public void validationISFDetails() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Mode of Transport is required')]")) {
					test.log(LogStatus.INFO, "Mode of Transport is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Header Details for Security Filing (ISF)");
		}
	}
	
	//Validation for General Information
	public void validationGeneralInformation() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Shipment type is required')]")) {
				test.log(LogStatus.INFO, "Shipment type is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}

	}
	
	//Validation Filing Details
	public void validationFilingDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filing Mode is required')]")) {
				test.log(LogStatus.INFO, "Filing Mode is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filing System is required')]")) {
				test.log(LogStatus.INFO, "Filing System is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filing Port is required')]")) {
				test.log(LogStatus.INFO, "Filing Port is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filer Code is required')]")) {
				test.log(LogStatus.INFO, "Filer Code is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filer ID No is required')]")) {
				test.log(LogStatus.INFO, "Filer ID No is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}

	}
	
	//Validation for Bond Details
	public void validationBondDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Activity is required')]")) {
				test.log(LogStatus.INFO, "Bond Activity is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond holder is required')]")) {
				test.log(LogStatus.INFO, "Bond holder is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Type is required')]")) {
				test.log(LogStatus.INFO, "Bond Type is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}

	}
	
	//Validation for Party Details
	public void validationPartyDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Party Details are missing')]")) {
				test.log(LogStatus.INFO, "Party Details are missing");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}

	}
	
	// Validation for Party details Manufacturer / Supplier
	public void validationPartyDetailsManufacturer() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Manufacturer / Supplier is required')]")) {
				test.log(LogStatus.INFO, "Manufacturer / Supplier is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}

	}
	
	// Validation for Party details Seller 
	public void validationPartyDetailsSeller() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Seller is required')]")) {
				test.log(LogStatus.INFO, "Seller is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}
	}
	
	// Validation for Party details Buyer
	public void validationPartyDetailsBuyer() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Buyer is required')]")) {
				test.log(LogStatus.INFO, "Buyer is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
			closeAlert();
		}
	}
	
	// Validation for Party details Ship To 
		public void validationPartyDetailsShipTo() {
			try {
				if (isDisplayed(driver,
						"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Ship To is required')]")) {
					test.log(LogStatus.INFO, "Ship To is required");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
				closeAlert();
			}
		}
		
	// Validation for Party details Consolidator 
		public void validationPartyDetailsConsolidator() {
			try {
				if (isDisplayed(driver,
						"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Consolidator required')]")) {
					test.log(LogStatus.INFO, "Consolidator required");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
				closeAlert();
			}
		}
	
		// Validation for Party details Consignee 
		public void validationPartyDetailsConsignee() {
			try {
				if (isDisplayed(driver,
						"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Consignee is required')]")) {
					test.log(LogStatus.INFO, "Consignee is required");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
				closeAlert();
			}
		}
		
		// Validation for Party details Container Stuffing Location 
		public void validationPartyDetailsContainerStuffingLocation() {
			try {
				if (isDisplayed(driver,
						"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Container Stuffing Location is required')]")) {
					test.log(LogStatus.INFO, "Container Stuffing Location is required");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Security Filing (ISF)");
				closeAlert();
			}
		}
}
