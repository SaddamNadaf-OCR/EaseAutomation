package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ISFSearchSecurityFilingPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchISF_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchISF_ResetBtn = "//button[contains(text(),'Reset')]";
	public static final String OCR_SearchISF_AddISFBtn = "//button[@id='mybutton']";
	public static final String OCR_SearchISF_SBUCode = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_sbuCode']";
	public static final String OCR_SearchISF_Status = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_workStatus']";
	public static final String OCR_SearchISF_ISFNo = "//input[@id='resultImporterSecurityFiling_importIsf10DetailsValue_isfNo']";
	public static final String OCR_SearchISF_InternalRefNo = "//input[@id='resultImporterSecurityFiling_importIsf10DetailsValue_intrnlRefNo']";
	public static final String OCR_SearchISF_ModeofTransport = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_transportMode']";
	public static final String OCR_SearchISF_CarrierSCACCodelink = "//a[@id='isfCarrierPopup']";
	public static final String OCR_SearchISF_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_SearchISF_PopUpSearchBtn = "//button[@name='Search']";
	public static final String OCR_SearchISF_PopUpSelectBtn = "//button[contains(text(),'Select')][1]";
	public static final String OCR_SearchISF_PopUpCloseBtn = "//button[@class='close']";
	public static final String OCR_SearchISF_ShipmentType = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_shipmentType']";
	public static final String OCR_SearchISF_ShipmentSubType = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_shipmentSubType']";
	public static final String OCR_SearchISF_SubmissionType = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_isfSubmissionType']";
	public static final String OCR_SearchISF_ActionReason = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_actionResn']";
	public static final String OCR_SearchISF_CustomsTransactionNo = "//input[@id='resultImporterSecurityFiling_importIsf10DetailsValue_transNo']";
	public static final String OCR_SearchISF_FilingPortLink = "//a[@id='isfFilingPort']";
	public static final String OCR_SearchISF_PortID = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_SearchISF_FilingStatus = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_abiStatus']";
	public static final String OCR_SearchISF_BillStatus = "//select[@id='resultImporterSecurityFiling_billStatus']";
	public static final String OCR_SearchISF_CreatedBy = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_createdBy']";
	public static final String OCR_SearchISF_CreateDateFrom = "//input[@id='resultImporterSecurityFiling_fromDate']";
	public static final String OCR_SearchISF_CreateDateTo = "//input[@id='resultImporterSecurityFiling_toDate']";
	public static final String OCR_SearchISF_ImportCoordinatorReviewer = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_importReviewerId']";
	public static final String OCR_SearchISF_CorpComplianceReviewer = "//select[@id='resultImporterSecurityFiling_importIsf10DetailsValue_corpImportReviewerId']";
	public static final String OCR_SearchISF_SortBy = "//select[@id='sortBy']";
	public static final String OCR_SearchISF_Direction = "//select[@id='direction']";
	public static final String OCR_SearchISF_BillNo = "//input[@id='resultImporterSecurityFiling_importIsf10BolValue_bolNo']";
	public static final String OCR_SearchISF_BillType = "//select[@id='resultImporterSecurityFiling_importIsf10BolValue_bolType']";
	public static final String OCR_SearchISF_ParentBillNo = "//input[@id='resultImporterSecurityFiling_importIsf10BolValue_parentBolNo']";
	public static final String OCR_SearchISF_PartyType = "//select[@id='resultImporterSecurityFiling_importIsf10PartiesValue_partyType']";
	public static final String OCR_SearchISF_PartyCodeLink = "//a[@id='isfPartyPopup']";
	public static final String OCR_SearchISF_VendorCode = "//input[@id='searchForm_vendor_vendorCode']";
	public static final String OCR_SearchISF_ImporterCode = "//input[@id='searchForm_importer_importerCode']";
	public static final String OCR_SearchISF_IdentifierType = "//select[@id='resultImporterSecurityFiling_importIsf10PartiesValue_identityNo']";
	public static final String OCR_SearchISF_IdentificationNo = "//input[@id='resultImporterSecurityFiling_importIsf10PartiesValue_identityDetails']";
	public static final String OCR_SearchISF_PartNoLink = "//a[@id='isfPartNoPopup']";
	public static final String OCR_SearchISF_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_SearchISF_ProductName = "//textarea[@id='resultImporterSecurityFiling_importIsf10ItemsValue_productName']";
	public static final String OCR_SearchISF_PartDescription = "//textarea[@id='resultImporterSecurityFiling_importIsf10ItemsValue_partDescription']";
	public static final String OCR_SearchISF_HsNoLink = "//a[@id='impClassId']";
	public static final String OCR_SearchISF_HsNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_SearchISF_SelectPopUpHs = "//button[@id='slctBtn']";
	public static final String OCR_SearchISF_CountryofOrigin = "//input[@id='resultImporterSecurityFiling_importIsf10ItemsValue_countryOfOrigin']";
	public static final String OCR_SearchISF_BillNoLine = "//input[@id='resultImporterSecurityFiling_importIsf10ItemsValue_billNo']";
	public static final String OCR_SearchISF_ManufactureLink = "//a[@id='isfManuPopup']";

	/* ******************** Constructor ***************************** */

	public ISFSearchSecurityFilingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Add new ISF
	public void addNew() {
		clickElement(driver, test, "//input[@id='resultImporterSecurityFiling_importIsf10DetailsValue_intrnlRefNo']",
				"");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchISF_AddISFBtn, "click on Add New ISF");
	}

	// Click on Search button
	public void click_SearchBtn() {
		clickElement(driver, test, OCR_SearchISF_SearchBtn, "Click on Search Btn");
	}

	// Selecting the options in Search tab
	public void commonSearch(String SBUCode, String Status, String ISFNo, String InternalRefNo, String MOT,
			String CarrierCode, String ShipmentType, String ShipmentSubType, String SubmissionType, String ActionReason,
			String CustomsTransactionNo, String PortID, String FilingStatus, String BillStatus, String CreatedBy,
			String CreateDateFrom, String CreateDateTo, String ImportCoordinatorReviewer, String CorpComplianceReviewer,
			String SortBy, String Direction) {
		selectByVisibleText(driver, test, OCR_SearchISF_SBUCode, "Select SBU : ", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchISF_Status, "Select Status: ", Status);
		typeText(driver, test, OCR_SearchISF_ISFNo, "Add ISF No: ", ISFNo);
		typeText(driver, test, OCR_SearchISF_InternalRefNo, "Add Internal Ref No : ", InternalRefNo);
		selectByVisibleText(driver, test, OCR_SearchISF_ModeofTransport, "Select Mode of Transport : ", MOT);
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_SearchISF_CarrierSCACCodelink, "Click on CarrierSCACCodelink");
			try {
				typeText(driver, test, OCR_SearchISF_CarrierCode, "Add Carrier Code : ", CarrierCode);
				clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
				String Carrier = "//td[contains(text(),'" + CarrierCode + "')]";
				clickElement(driver, test, Carrier, "Select Carrier : " + CarrierCode);
				clickElement(driver, test, OCR_SearchISF_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Carrier Code");
				clickElement(driver, test, OCR_SearchISF_PopUpCloseBtn, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchISF_ShipmentType, "Select Shipment Type : ", ShipmentType);
		selectByVisibleText(driver, test, OCR_SearchISF_ShipmentSubType, "Select Shipment Sub Type :", ShipmentSubType);
		selectByVisibleText(driver, test, OCR_SearchISF_SubmissionType, "Select Submission Type : ", SubmissionType);
		selectByVisibleText(driver, test, OCR_SearchISF_ActionReason, "Select Action Reason : ", ActionReason);
		typeText(driver, test, OCR_SearchISF_CustomsTransactionNo, "Add Customs Transaction No : ",
				CustomsTransactionNo);
		if (PortID.length() > 0) {
			clickElement(driver, test, OCR_SearchISF_FilingPortLink, "Click on Filing port link");
			try {
				typeText(driver, test, OCR_SearchISF_PortID, "Add Carrier Code : ", PortID);
				clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
				String Port = "//td[contains(text(),'" + PortID + "')]";
				clickElement(driver, test, Port, "Select Port ID : " + PortID);
				clickElement(driver, test, OCR_SearchISF_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Filing Port");
				clickElement(driver, test, OCR_SearchISF_PopUpCloseBtn, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchISF_FilingStatus, "Select Filing Status: ", FilingStatus);
		selectByVisibleText(driver, test, OCR_SearchISF_BillStatus, "Select Bill Status : ", BillStatus);
		selectByVisibleText(driver, test, OCR_SearchISF_CreatedBy, "Select Created By : ", CreatedBy);
		typeText(driver, test, OCR_SearchISF_CreateDateFrom, "Add Create Date From : ", CreateDateFrom);
		typeText(driver, test, OCR_SearchISF_CreateDateTo, "Add Create Date To", CreateDateTo);
		selectByVisibleText(driver, test, OCR_SearchISF_ImportCoordinatorReviewer,
				"Select Import Coordinator Reviewer : ", ImportCoordinatorReviewer);
		selectByVisibleText(driver, test, OCR_SearchISF_CorpComplianceReviewer, "Select Corp Compliance Reviewer",
				CorpComplianceReviewer);
		selectByVisibleText(driver, test, OCR_SearchISF_SortBy, "Select SortBy: ", SortBy);
		selectByVisibleText(driver, test, OCR_SearchISF_Direction, "Select Direction : ", Direction);
	}

	// Search Criteria Based on Bill Details
	public void billDetailsSearch(String BillNo, String BillType, String ParentBillNo) {
		typeText(driver, test, OCR_SearchISF_BillNo, "Add Bill No : ", BillNo);
		selectByVisibleText(driver, test, OCR_SearchISF_BillType, "Select Bill Type : ", BillType);
		typeText(driver, test, OCR_SearchISF_ParentBillNo, "Add Parent Bill No : ", ParentBillNo);
	}

	// Search Criteria Based on Party Details
	public void partyDetailsSearch(String PartyType, String PartyCodeType, String PartyCode, String IdentifierType,
			String IdentificationNo) {
		selectByVisibleText(driver, test, OCR_SearchISF_PartyType, "Select Party Type : ", PartyType);
		if (PartyCode.length() > 0) {
			clickElement(driver, test, OCR_SearchISF_PartyCodeLink, "Click on Party Code Link");
			try {
				if (PartyCodeType.equalsIgnoreCase("Vendor")) {
					typeText(driver, test, OCR_SearchISF_VendorCode, "Add Vendor Code : ", PartyCode);
					clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
					String party = "//td[contains(text(),'" + PartyCode + "')]";
					clickElement(driver, test, party, "Select Party Code : " + PartyCode);
					clickElement(driver, test, OCR_SearchISF_PopUpSelectBtn, "Click on select");
				}
				if (PartyCodeType.equalsIgnoreCase("Importer")) {
					typeText(driver, test, OCR_SearchISF_ImporterCode, "Add Importer Code : ", PartyCode);
					clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
					String party = "//td[contains(text(),'" + PartyCode + "')]";
					clickElement(driver, test, party, "Select Party Code : " + PartyCode);
					clickElement(driver, test, OCR_SearchISF_PopUpSelectBtn, "Click on select");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Party Code");
				clickElement(driver, test, OCR_SearchISF_PopUpCloseBtn, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchISF_IdentifierType, "Select Identifier Type", IdentifierType);
		typeText(driver, test, OCR_SearchISF_IdentificationNo, "Add Identification No", IdentificationNo);
	}

	// Search Criteria Based on Line Details
	public void lineDetailsSearch(String PartNo, String ProductName, String PartDescription, String HsNo,
			String CountryofOrigin, String BillNoLine, String Manufacture) {
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_SearchISF_PartNoLink, "Click on Part No Link");
			try {
				typeText(driver, test, OCR_SearchISF_PartNo, "Add Part No : ", PartNo);
				clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
				String part = "//td[contains(text(),'" + PartNo + "')]";
				clickElement(driver, test, part, "Select Party Code : " + PartNo);
				clickElement(driver, test, OCR_SearchISF_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Part No");
				clickElement(driver, test, OCR_SearchISF_PopUpCloseBtn, "Click on Close");
			}
		}
		typeText(driver, test, OCR_SearchISF_ProductName, "Add Product Name", ProductName);
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchISF_PartDescription, "Add Part Description", PartDescription);
		Wait.waitfor(2);
		if (HsNo.length() > 0) {
			clickElement(driver, test, OCR_SearchISF_HsNoLink, "Click on Hs No Link");
			try {
				typeText(driver, test, OCR_SearchISF_HsNo, "Add Hs No : ", HsNo);
				clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
				String hs = "//td[contains(text(),'" + HsNo + "')]";
				clickElement(driver, test, hs, "Select Hs No : " + HsNo);
				clickElement(driver, test, OCR_SearchISF_SelectPopUpHs, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Hs No");
				clickElement(driver, test, OCR_SearchISF_PopUpCloseBtn, "Click on Close");
			}
		}
		typeText(driver, test, OCR_SearchISF_CountryofOrigin, "Add Country of Origin", CountryofOrigin);
		typeText(driver, test, OCR_SearchISF_BillNoLine, "Add Bill No Line", BillNoLine);
		if (Manufacture.length() > 0) {
			clickElement(driver, test, OCR_SearchISF_ManufactureLink, "Click on Hs No Link");
			try {
				typeText(driver, test, OCR_SearchISF_VendorCode, "Add Manufacture : ", Manufacture);
				clickElement(driver, test, OCR_SearchISF_PopUpSearchBtn, "Click On Search");
				String manf = "//td[contains(text(),'" + Manufacture + "')]";
				clickElement(driver, test, manf, "Select Vendor : " + Manufacture);
				clickElement(driver, test, OCR_SearchISF_PopUpSelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Manufacture");
				clickElement(driver, test, OCR_SearchISF_PopUpCloseBtn, "Click on Close");
			}
		}
	}

}
