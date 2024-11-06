package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class EntrySummarySearchPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchEntrySummary_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchEntrySummary_ResetBtn = "//button[contains(text(),'Reset')]";
	public static final String OCR_SearchEntrySummary_AddEntrySummaryBtn = "//button[contains(text(),'Add Entry Summary')]";
	public static final String OCR_SearchEntrySummary_AddFromExcel = "//button[contains(text(),'Add From Excel')]";
	public static final String OCR_SearchEntrySummary_QueryEntryStatusBtn = "//button[contains(text(),'Query Entry Status')]";
	public static final String OCR_SearchEntrySummary_SBUCode = "//select[@id='searchImport7501_import7501DetailsValue_sbuCode']";
	public static final String OCR_SearchEntrySummary_EntryNoLink = "//a[contains(text(),'Entry No')]";
	public static final String OCR_SearchEntrySummary_EntryNo = "//input[@id='resultEntryPopupData_import7501DetailsDTO_entryNo']";
	public static final String OCR_SearchEntrySummary_ClkSearchInPopuUp = "//button[@name='Search']";
	public static final String OCR_SearchEntrySummary_ClkSelectInPopUp = "//button[contains(text(),'Select')][1]";
	public static final String OCR_SearchEntrySummary_ClosePopUp = "//button[@class='close']";
	public static final String OCR_SearchEntrySummary_InternalRefNo = "//input[@id='searchImport7501_import7501DetailsValue_intRefNo']";
	public static final String OCR_SearchEntrySummary_WorkStatus = "//select[@id='searchImport7501_import7501DetailsValue_workStatus']";
	public static final String OCR_SearchEntrySummary_EntryTypeLink = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[3]/label[1]/a[1]";
	public static final String OCR_SearchEntrySummary_SubmissionType = "//select[@id='searchImport7501_import7501DetailsValue_submissionType']";
	public static final String OCR_SearchEntrySummary_ImporterCoordinatorReviewer = "//select[@id='searchImport7501_import7501DetailsValue_importReviewerId']";
	public static final String OCR_SearchEntrySummary_CorpComplianceReviewer = "//select[@id='searchImport7501_import7501DetailsValue_corpImportReviewerId']";
	public static final String OCR_SearchEntrySummary_FTAReconciliation = "//select[@id='searchImport7501_import7501DetailsValue_natfaReconciliation']";
	public static final String OCR_SearchEntrySummary_ReconciliationIssue = "//select[@id='searchImport7501_import7501DetailsValue_reconciliationIssues']";
	public static final String OCR_SearchEntrySummary_ReleaseStatus = "//select[@id='searchImport7501_importEntrySummaryStatusValue_releaseStatus']";
	public static final String OCR_SearchEntrySummary_ReleaseDateFrom = "//input[@id='searchImport7501_releaseDate']";
	public static final String OCR_SearchEntrySummary_ReleaseDateTo = "//input[@id='searchImport7501_releaseDateTo']";
	public static final String OCR_SearchEntrySummary_CollectionStatus = "//select[@id='searchImport7501_importEntrySummaryStatusValue_collectionStatus']";
	public static final String OCR_SearchEntrySummary_CollectionDateFrom = "//input[@id='searchImport7501_collectionDate']";
	public static final String OCR_SearchEntrySummary_CollectionDateTo = "//input[@id='searchImport7501_collectionDateTo']";
	public static final String OCR_SearchEntrySummary_LiquidationStatus = "//select[@id='searchImport7501_importEntrySummaryStatusValue_liquidationStatus']";
	public static final String OCR_SearchEntrySummary_LiquidationDateFrom = "//input[@id='searchImport7501_liquidationDate']";
	public static final String OCR_SearchEntrySummary_LiquidationDateTo = "//input[@id='searchImport7501_liquidationDateTo']";
	public static final String OCR_SearchEntrySummary_FiledBy = "//select[@id='searchImport7501_import7501DetailsValue_filer']";
	public static final String OCR_SearchEntrySummary_EstimatedEntryDateFrom = "//input[@id='searchImport7501_estEntryeDate']";
	public static final String OCR_SearchEntrySummary_EstimatedEntryDateTo = "//input[@id='searchImport7501_estEntryeDateTo']";
	public static final String OCR_SearchEntrySummary_ProgramLink = "//a[@id='program']";
	public static final String OCR_SearchEntrySummary_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_SearchEntrySummary_SegmentLink = "//a[@id='segment']";
	public static final String OCR_SearchEntrySummary_RegionLink = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[11]/label[1]/a[1]";
	public static final String OCR_SearchEntrySummary_SiteLink = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[11]/label[2]/a[1]";
	public static final String OCR_SearchEntrySummary_SiteId = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String OCR_SearchEntrySummary_BondWaived = "//select[@id='searchImport7501_import7501DetailsValue_bondWaived']";
	public static final String OCR_SearchEntrySummary_BondType = "//select[@id='searchImport7501_import7501DetailsValue_bondType']";
	public static final String OCR_SearchEntrySummary_SuretyCompanyNo = "//input[@id='searchImport7501_import7501DetailsValue_suretyNo']";
	public static final String OCR_SearchEntrySummary_BondAccountNo = "//input[@id='searchImp//select[@id='searchImport7501_import7501DetailsValue_certifyCargoRelease']ort7501_import7501DetailsValue_bondRefNo']";
	public static final String OCR_SearchEntrySummary_CertifyCargoRelease = "//select[@id='searchImport7501_import7501DetailsValue_certifyCargoRelease']";
	public static final String OCR_SearchEntrySummary_LiveEntry = "//select[@id='searchImport7501_import7501DetailsValue_liveEntry']";
	public static final String OCR_SearchEntrySummary_paymentTypelink = "//a[@id='paymentType']";
	public static final String OCR_SearchEntrySummary_AccountInPeriodicStatementFrom = "//input[@id='searchImport7501_apsDate']";
	public static final String OCR_SearchEntrySummary_AccountInPeriodicStatementTo = "//input[@id='searchImport7501_apsDateTo']";
	public static final String OCR_SearchEntrySummary_ModeOfTransport = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[16]/label[1]/a[1]";
	public static final String OCR_SearchEntrySummary_RemoteLocationFiling = "//select[@id='searchImport7501_import7501DetailsValue_remoteLocationFiling']";
	public static final String OCR_SearchEntrySummary_PortOfEntryLink = "//a[@id='portsPopup2']";
	public static final String OCR_SearchEntrySummary_PortID = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_SearchEntrySummary_PortOfUnladingLink = "//a[@id='portsPopup3']";
	public static final String OCR_SearchEntrySummary_DesignatedExamPortLink = "//a[@id='portsPopup4']";
	public static final String OCR_SearchEntrySummary_SummaryDateFrom = "//input[@id='searchImport7501_summaryDate']";
	public static final String OCR_SearchEntrySummary_SummaryDateTo = "//input[@id='searchImport7501_summaryDateTo']";
	public static final String OCR_SearchEntrySummary_RequestAcceleratedLiquidation = "//select[@id='searchImport7501_import7501DetailsValue_reqAcceleratedLiq']";
	public static final String OCR_SearchEntrySummary_DeferredTaxPayment = "//select[@id='searchImport7501_import7501DetailsValue_deferredTaxPayment']";
	public static final String OCR_SearchEntrySummary_ElectronicSignature = "//select[@id='searchImport7501_import7501DetailsValue_electronicSignature']";
	public static final String OCR_SearchEntrySummary_ElectronicInvoice = "//select[@id='searchImport7501_import7501DetailsValue_electronicInvoice']";
	public static final String OCR_SearchEntrySummary_CarrierCodeLink = "//a[@id='carrierPopup']";
	public static final String OCR_SearchEntrySummary_CarrierCode = "//input[@id='searchForm_groundCarrier_grCarrierCode']";
	public static final String OCR_SearchEntrySummary_VoyageFlightTripNo = "//input[@id='searchImport7501_import7501DetailsValue_voyageFlightNo']";
	public static final String OCR_SearchEntrySummary_TotalDutyFrom = "//input[@id='searchImport7501_dutyFrom']";
	public static final String OCR_SearchEntrySummary_TotalDutyTo = "//input[@id='searchImport7501_dutyTo']";
	public static final String OCR_SearchEntrySummary_TotalTaxFrom = "//input[@id='searchImport7501_taxFrom']";
	public static final String OCR_SearchEntrySummary_TotalTaxTo = "//input[@id='searchImport7501_taxTo']";
	public static final String OCR_SearchEntrySummary_TotalOtherFeesFrom = "//input[@id='searchImport7501_otherFeeFrom']";
	public static final String OCR_SearchEntrySummary_TotalOtherFeesTo = "//input[@id='searchImport7501_otherFeeTo']";
	public static final String OCR_SearchEntrySummary_TotalEnteredValueFrom = "//input[@id='searchImport7501_totalEntFrom']";
	public static final String OCR_SearchEntrySummary_TotalEnteredValueTo = "//input[@id='searchImport7501_totalEntTo']";
	public static final String OCR_SearchEntrySummary_ReleaseNote = "//input[@id='searchImport7501_import7501DetailsValue_releaseBrokerNotes']";
	public static final String OCR_SearchEntrySummary_AdditionalReleaseNote = "//input[@id='searchImport7501_import7501DetailsValue_releaseAddtlNotes']";
	public static final String OCR_SearchEntrySummary_DutyReliefType = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[25]/div[1]/select[1]";
	public static final String OCR_SearchEntrySummary_ReliefAuthorizationNo = "//a[@id='dutyreliefAuthNo']";
	public static final String OCR_SearchEntrySummary_ShortBy = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[25]/div[1]/select[1]";
	public static final String OCR_SearchEntrySummary_Direction = "//select[@id='searchImport7501_direction']";
	public static final String OCR_SearchEntrySummary_SearchPartyDetailsTab = "//label[contains(text(),'Search Party Details')]";
	public static final String OCR_SearchEntrySummary_PartyType = "//select[@id='searchImport7501_import7501PartiesValue_partyType']";
	public static final String OCR_SearchEntrySummary_PartyName = "//input[@id='searchImport7501_import7501PartiesValue_partyName']";
	public static final String OCR_SearchEntrySummary_PartyCountry = "//input[@id='searchImport7501_import7501PartiesValue_partyCountryName']";
	public static final String OCR_SearchEntrySummary_PartyIdentificationNo = "//input[@id='searchImport7501_import7501PartiesValue_identityNo']";
	public static final String OCR_SearchEntrySummary_SearchBillOfLadingDetails = "//label[contains(text(),'Search Bill of Lading Details')]";
	public static final String OCR_SearchEntrySummary_BillNo = "//input[@id='searchImport7501_import7501BolValue_bolNo']";
	public static final String OCR_SearchEntrySummary_ParentBillNo = "//input[@id='searchImport7501_import7501BolValue_masterBolNo']";
	public static final String OCR_SearchEntrySummary_BillType = "//select[@id='searchImport7501_import7501BolValue_bolType']";
	public static final String OCR_SearchEntrySummary_SearchLineItemDetails = "//label[contains(text(),'Search Line Item Details')]";
	public static final String OCR_SearchEntrySummary_PartNoLink = "//a[@id='partno']";
	public static final String OCR_SearchEntrySummary_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_SearchEntrySummary_IdentificationNo = "//textarea[@id='searchImport7501_import7501ItemDetailsValue_serialNo']";
	public static final String OCR_SearchEntrySummary_ProductName = "//textarea[@id='searchImport7501_import7501ItemDetailsValue_productName']";
	public static final String OCR_SearchEntrySummary_PartDescription = "//textarea[@id='searchImport7501_import7501ItemDetailsValue_descOfMerch']";
	public static final String OCR_SearchEntrySummary_PrimaryHSLink = "//a[@id='impClassId']";
	public static final String OCR_SearchEntrySummary_HsNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_SearchEntrySummary_SecondaryHSLink = "//a[@id='impClassId1']";
	public static final String OCR_SearchEntrySummary_CountryofExport = "//input[@id='searchImport7501_import7501ItemDetailsValue_countryOfExportName']";
	public static final String OCR_SearchEntrySummary_CountryofOrigin = "//input[@id='searchImport7501_import7501ItemDetailsValue_countryOfOriginName']";
	public static final String OCR_SearchEntrySummary_ForeignPortofLadingLink = "//a[@id='portsPopup1']";
	public static final String OCR_SearchEntrySummary_SupplierManuf = "//input[@id='searchImport7501_import7501ItemDetailsValue_manufacturerName']";
	public static final String OCR_SearchEntrySummary_ExportShipmentNolink = "//a[@id='exportShipmentNo']";
	public static final String OCR_SearchEntrySummary_ExportShipmentNo = "//input[@id='resultExpShipmentPopupData_shipmentDTO_shipmentNo']";
	public static final String OCR_SearchEntrySummary_TradeProgramSPILink = "//a[@id='ftaSpiPopUp']";
	public static final String OCR_SearchEntrySummary_CommercialInvoiceNoLink = "//a[contains(text(),'Commercial Invoice No')]";
	public static final String OCR_SearchEntrySummary_InvoiceNo = "//input[@id='resultImportInvoicePopup_importInvoiceItemDTO_invoiceNo']";
	public static final String OCR_SearchEntrySummary_OrderRMALink = "//a[contains(text(),'Order / RMA')]";
	public static final String OCR_SearchEntrySummary_OrderNo = "//input[@id='resultOrderNoPopup_purchaseOrderItemDTO_poNo']";
	public static final String OCR_SearchEntrySummary_AD = "//select[@id='searchImport7501_add']";
	public static final String OCR_SearchEntrySummary_CVD = "//select[@id='searchImport7501_cvd']";
	public static final String OCR_SearchEntrySummary_ADCaseNo = "//input[@id='searchImport7501_import7501ItemDetailsValue_adaNo']";
 	public static final String OCR_SearchEntrySummary_CVDCaseNo = "//input[@id='searchImport7501_import7501ItemDetailsValue_cvdNo']";
	public static final String OCR_SearchEntrySummary_PermitCertificateTypeLink = "//a[contains(text(),'Permit/ Certificate Type')]";
	public static final String OCR_SearchEntrySummary_PermitCertificateNo = "//input[@id='searchImport7501_import7501ItemDetailsValue_licCertPermitNo']";
	public static final String OCR_SearchEntrySummary_OtherGovtAgency = "//option[contains(text(),'ATF')]";
	public static final String OCR_SearchEntrySummary_ActivityType = "//select[@id='searchImport7501_import7501ItemDetailsValue_activityType']";
	public static final String OCR_SearchEntrySummary_AgencyLink = "//a[@id='agency']";
	public static final String OCR_SearchEntrySummary_AuthorizationLink = "//body/div[@id='content-cont']/form[@id='searchImport7501']/div[3]/div[1]/div[9]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/a[1]/label[1]";
	public static final String OCR_SearchEntrySummary_Agency = "//input[@id='licTypePopupForm_licenseTypes_agencyCode']";
	public static final String OCR_SearchEntrySummary_AuthorizationNoLink = "//a[@id='authNoPopup']";
	public static final String OCR_SearchEntrySummary_AuthorizationNo = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_SearchEntrySummary_AuthorizationItemNoLink = "//a[@id='authItemPopup']";
	public static final String OCR_SearchEntrySummary_ATFPermitNo = "//input[@id='searchImport7501_import7501ItemDetailsValue_atfPermitNo']";
	public static final String OCR_SearchEntrySummary_ATFExemptionLink = "//a[@id='atfExemption']";
	public static final String OCR_SearchEntrySummary_ATFExemptionNo = "//input[@id='searchForm_atfExemption_atfExemptionNo']";
	public static final String OCR_SearchEntrySummary_DutyReliefTyp = "//select[@name='import7501ItemDetailsValue.reliefType']";
	public static final String OCR_SearchEntrySummary_ReliefAuthorizationNoLink = "//a[@id='dutyreliefAuthItemNo']";
	public static final String OCR_SearchEntrySummary_ReliefAuthorizatioNo = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	
	/* ******************** Constructor ***************************** */

	public EntrySummarySearchPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Click On Add Entry Summary 
	public void addEntrySummary() {
		clickElement(driver, test, OCR_SearchEntrySummary_AddEntrySummaryBtn, "Click Add Entry Summary Btn");
	}
	
	//Click on Search Button
	public void clkSearchBtn() {
		clickElement(driver, test, OCR_SearchEntrySummary_SearchBtn, "Click on Search Button");
	}
	
	//
	
	
}
