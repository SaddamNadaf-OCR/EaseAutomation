package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummaryDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EntrySummaryDetails_EntryNoLink = "//a[contains(text(),'Entry No')]";
	public static final String OCR_EntrySummaryDetails_EnTemplate = "//input[@id='searchForm_uniqueId_templateName']";
	public static final String OCR_EntrySummaryDetails_PopUpSearch = "//button[@name='Search']";
	public static final String OCR_EntrySummaryDetails_PopUpSelect = "//button[contains(text(),'Select')][1]";
	public static final String OCR_EntrySummaryDetails_ClosePopUp = "//button[@class='close']";
	public static final String OCR_EntrySummaryDetails_InternalRefNoLink = "//a[contains(text(),'Internal Ref. No.')]";
	public static final String OCR_EntrySummaryDetails_RefTemplate = "//input[@id='searchForm_uniqueId_templateName']";
	public static final String OCR_EntrySummaryDetails_SaveBtn = "//button[@name='save']";
	public static final String OCR_EntrySummaryDetails_SummaryDate = "//input[@id='editImport7501Details_summaryDate']";
	public static final String OCR_EntrySummaryDetails_FilingMode = "//select[@id='editImport7501Details_import7501DetailsValue_filingMode']";
	public static final String OCR_EntrySummaryDetails_System = "//select[@id='editImport7501Details_import7501DetailsValue_submissionType']";
	public static final String OCR_EntrySummaryDetails_Action = "//select[@id='actionId']";
	public static final String OCR_EntrySummaryDetails_EntryTypeLink = "(//a[contains(text(),'Entry Type')])[2]";
	public static final String OCR_EntrySummaryDetails_ShipmentUsageType = "//select[@id='editImport7501Details_import7501DetailsValue_shipmentUsageType']";
	public static final String OCR_EntrySummaryDetails_MutipleReliefAuthorizations = "//select[@id='editImport7501Details_import7501DetailsValue_multipleReliefAuth']";
	public static final String OCR_EntrySummaryDetails_DutyReliefType = "//select[@id='reliefTypeId']";
	public static final String OCR_EntrySummaryDetails_ReliefAuthorizationNoLink = "//a[@id='dutyreliefAuthNo']";
	public static final String OCR_EntrySummaryDetails_ReliefAuthorizationNo = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_EntrySummaryDetails_ReliefActivityType = "//select[@id='actType']";
	public static final String OCR_EntrySummaryDetails_DueDate = "//input[@id='editImport7501Details_dutyReliefDueDate']";
	public static final String OCR_EntrySummaryDetails_ElectronicSignature = "//select[@id='editImport7501Details_import7501DetailsValue_electronicSignature']";
	public static final String OCR_EntrySummaryDetails_LiveEntry = "//select[@id='editImport7501Details_import7501DetailsValue_liveEntry']";
	public static final String OCR_EntrySummaryDetails_MissingDocs = "//input[@id='editImport7501Details_import7501DetailsValue_missingDocsCode']";
	public static final String OCR_EntrySummaryDetails_TeamNumber = "//input[@id='editImport7501Details_import7501DetailsValue_teamNo']";
	public static final String OCR_EntrySummaryDetails_FTAReconciliation = "//select[@id='editImport7501Details_import7501DetailsValue_natfaReconciliation']";
	public static final String OCR_EntrySummaryDetails_ReconciliationIssues = "//select[@id='editImport7501Details_import7501DetailsValue_reconciliationIssues']";
	public static final String OCR_EntrySummaryDetails_Filer = "//select[@id='editImport7501Details_import7501DetailsValue_filer']";
	public static final String OCR_EntrySummaryDetails_BondandPaymentDetailsTab = "//label[contains(text(),'Bond & Payment Details')]";
	public static final String OCR_EntrySummaryDetails_BondWaived = "//select[@id='editImport7501Details_import7501DetailsValue_bondWaived']";
	public static final String OCR_EntrySummaryDetails_BondWaiverReasonLink = "//a[@id='bondWaiverReasonPopup']";
	public static final String OCR_EntrySummaryDetails_BondType = "//select[@id='editImport7501Details_import7501DetailsValue_bondType']";
	public static final String OCR_EntrySummaryDetails_UseContinuousBond = "//select[@id='editImport7501Details_import7501DetailsValue_useContinuousBond']";
	public static final String OCR_EntrySummaryDetails_SuretyCompanyNo = "//input[@id='editImport7501Details_import7501DetailsValue_suretyNo']";
	public static final String OCR_EntrySummaryDetails_STBAmount = "//input[@id='editImport7501Details_singleTranBondAmt']";
	public static final String OCR_EntrySummaryDetails_BondAccountNo = "//input[@id='editImport7501Details_import7501DetailsValue_bondRefNo']";
	public static final String OCR_EntrySummaryDetails_AddtlSTBCompanyNo = "//input[@id='editImport7501Details_import7501DetailsValue_addtlSuretyNo']";
	public static final String OCR_EntrySummaryDetails_AddtlSTBAmount = "//input[@id='editImport7501Details_addtlBondAmt']";
	public static final String OCR_EntrySummaryDetails_AddtlSTBAccountNo = "//input[@id='editImport7501Details_import7501DetailsValue_addtlBondRefNo']";
	public static final String OCR_EntrySummaryDetails_BondDesignationTypeCode = "//select[@id='editImport7501Details_import7501DetailsValue_bondDesignationTypeCode']";
	public static final String OCR_EntrySummaryDetails_PaymentModeLink = "//a[@id='paymentModePopup']";
	public static final String OCR_EntrySummaryDetails_PaymentTypeLink = "//a[@id='paymentType']";
	public static final String OCR_EntrySummaryDetails_PaymentTermType = "//select[@id='editImport7501Details_import7501DetailsValue_paymentTermType']";
	public static final String OCR_EntrySummaryDetails_PaymentTermsLink = "//a[@id='paymentTermPopup']";
	public static final String OCR_EntrySummaryDetails_INCOTerms = "//a[@id='incoTermPopup']";
	public static final String OCR_EntrySummaryDetails_INCOLocationIdentifier = "//select[@id='editImport7501Details_import7501DetailsValue_incoTermLocation']";
	public static final String OCR_EntrySummaryDetails_PreliminaryStatementPrintDate = "//input[@id='editImport7501Details_pspDate']";
	public static final String OCR_EntrySummaryDetails_AccountInPeriodicStatement = "//input[@id='editImport7501Details_apsDate']";
	public static final String OCR_EntrySummaryDetails_DeferredTaxPayment = "//select[@id='editImport7501Details_import7501DetailsValue_deferredTaxPayment']";
	public static final String OCR_EntrySummaryDetails_StatementClientBranch = "//input[@id='editImport7501Details_import7501DetailsValue_stmtClientBranch']";
	public static final String OCR_EntrySummaryDetails_RequestAcceleratedLiquidation = "//select[@id='editImport7501Details_import7501DetailsValue_reqAcceleratedLiq']";
	public static final String OCR_EntrySummaryDetails_ElectronicInvoice = "//select[@id='editImport7501Details_import7501DetailsValue_electronicInvoice']";
	public static final String OCR_EntrySummaryDetails_ConsolidateSummary = "//select[@id='editImport7501Details_import7501DetailsValue_consolidatedSummary']";
	public static final String OCR_EntrySummaryDetails_CertifyCargoRelease = "//select[@id='editImport7501Details_import7501DetailsValue_certifyCargoRelease']";
	public static final String OCR_EntrySummaryDetails_KnownImporterIndicator = "//select[@id='editImport7501Details_import7501DetailsValue_knownImpIndicator']";
	public static final String OCR_EntrySummaryDetails_INCOTermsLocation = "//textarea[@id='editImport7501Details_import7501DetailsValue_incoTermsLocation']";
	public static final String OCR_EntrySummaryDetails_ModeofTransportLink = "//a[@id='motPopup']";
	public static final String OCR_EntrySummaryDetails_CarrierCodeLink = "//a[@id='carrierPopup']";
	public static final String OCR_EntrySummaryDetails_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_EntrySummaryDetails_VesselName = "//input[@id='editImport7501Details_import7501DetailsValue_vessel']";
	public static final String OCR_EntrySummaryDetails_VesselCode = "//input[@id='editImport7501Details_import7501DetailsValue_vesselCode']";
	public static final String OCR_EntrySummaryDetails_VoyageFlightTripNo = "//input[@id='editImport7501Details_import7501DetailsValue_voyageFlightNo']";
	public static final String OCR_EntrySummaryDetails_ForeignTradeZone = "//input[@id='editImport7501Details_import7501DetailsValue_foreignTradeZone']";
	public static final String OCR_EntrySummaryDetails_EstimatedArrivalDate = "//input[@id='editImport7501Details_estArrivalDate']";
	public static final String OCR_EntrySummaryDetails_EstimatedEntryDate = "//input[@id='editImport7501Details_estEntryeDate']";
	public static final String OCR_EntrySummaryDetails_DateofImportation = "//input[@id='editImport7501Details_importDate']";
	public static final String OCR_EntrySummaryDetails_ITDate = "//input[@id='editImport7501Details_itDate']";
	public static final String OCR_EntrySummaryDetails_PortofEntryLink = "//a[@id='portsPopup1']";
	public static final String OCR_EntrySummaryDetails_PortID = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_EntrySummaryDetails_PortofUnladingLink = "//a[@id='portsPopup3']";
	public static final String OCR_EntrySummaryDetails_PortIDUnlading = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_EntrySummaryDetails_LocationofGoods = "//input[@id='editImport7501Details_import7501DetailsValue_locationOfGoods']";
	public static final String OCR_EntrySummaryDetails_FIRMSCode = "//input[@id='editImport7501Details_import7501DetailsValue_firmsCode']";
	public static final String OCR_EntrySummaryDetails_RemoteLocationFiling = "//select[@id='editImport7501Details_import7501DetailsValue_remoteLocationFiling']";
	public static final String OCR_EntrySummaryDetails_DesignatedExamPortLink = "//a[@id='desgExmPort']";
	public static final String OCR_EntrySummaryDetails_PortIDesignated = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_EntrySummaryDetails_OtherMiscDetails = "//label[contains(text(),'Other Misc Details')]";
	public static final String OCR_EntrySummaryDetails_ProgramLink = "//a[@id='program']";
	public static final String OCR_EntrySummaryDetails_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_EntrySummaryDetails_RegionLink = "//a[@id='region']";
	public static final String OCR_EntrySummaryDetails_SegmentLink = "//a[@id='segment']";
	public static final String OCR_EntrySummaryDetails_SiteLink = "//a[@id='site']";
	public static final String OCR_EntrySummaryDetails_WarehouseEntryFilerCode = "//input[@id='editImport7501Details_import7501DetailsValue_whEntryFilerCode']";
	public static final String OCR_EntrySummaryDetails_WarehouseEntryNo = "//input[@id='editImport7501Details_import7501DetailsValue_whEntryNo']";
	public static final String OCR_EntrySummaryDetails_WarehouseEntryPort = "//a[@id='portsPopup4']";
	public static final String OCR_EntrySummaryDetails_WarehouseFinalWithdrawal = "//select[@id='editImport7501Details_import7501DetailsValue_whFinalWithdrawal']";
	public static final String OCR_EntrySummaryDetails_PartyTypeBtn = "//button[@id='addEntParty']";
	public static final String OCR_EntrySummaryDetails_SaveAndProceed = "//button[contains(text(),'Save & Proceed')]";
	public static final String OCR_EntrySummaryDetails_SubmitTab = "//a[contains(text(),'Submit')]";
	public static final String OCR_EntrySummaryDetails_CloseAlert = "(//button[@class='btn-close'])[1]";

	/* ******************** Constructor ***************************** */
	public EntrySummaryDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Add Header Details
	public void headerDeatils(String TemplatesEN, String TemplatesRefN, String SummaryDate, String FilingMode,
			String FilingSystem, String Action, String EntryNumber, String ShipmentUsageType,
			String MutipleReliefAuthorizations, String DutyReliefType, String ReliefActivityType, String DueDate,
			String ElectronicSignature, String LiveEntry, String TeamNumber, String FTAReconciliation,
			String ReconciliationIssues, String Filer) {
		if (TemplatesEN.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_EntryNoLink, "Click on Entry Number");
			try {
				typeText(driver, test, OCR_EntrySummaryDetails_EnTemplate, "Add System Generated Number : ",
						TemplatesEN);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSearch, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + TemplatesEN + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates: " + TemplatesEN);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD ENTRY NUMBER");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		if (TemplatesRefN.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_InternalRefNoLink, "Click on Internal Ref No Link");
			try {
				typeText(driver, test, OCR_EntrySummaryDetails_RefTemplate, "Add System Generated Number : ",
						TemplatesRefN);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSearch, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + TemplatesRefN + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates: " + TemplatesRefN);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD ENTRY NUMBER");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		clickElement(driver, test, OCR_EntrySummaryDetails_SaveBtn, "Click on Save");
		clickElement(driver, test, OCR_EntrySummaryDetails_SummaryDate, "Select Summary Date");
		Wait.waitfor(3);
		date(driver, test, "Summary Date : ", SummaryDate);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_FilingMode, "Select the Filing Mode : ", FilingMode);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_System, "Select the Filing System : ", FilingSystem);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_Action, "Select the Action : ", Action);
		if (EntryNumber.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_EntrySummaryDetails_EntryTypeLink, "Click on Entry type link");
			try {
				String EntryNo = "//td[contains(text(),'" + EntryNumber + "')]";
				clickElement(driver, test, EntryNo, "Select Entry Number: " + EntryNumber);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Entry type");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_ShipmentUsageType, "Select Shipment Usage Type",
				ShipmentUsageType);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_MutipleReliefAuthorizations,
				"Select Mutiple Relief Authorizations", MutipleReliefAuthorizations);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_DutyReliefType, "Select Duty Relief Type",
				DutyReliefType);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_ReliefActivityType, "Select Relief Activity Type",
				ReliefActivityType);
		if(DueDate.length()>0) {
		clickElement(driver, test, OCR_EntrySummaryDetails_DueDate, "Select Due Date");
		date(driver, test, "Select Due Date : ", DueDate);
		}
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_ElectronicSignature, "Select ElectronicSignature",
				ElectronicSignature);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_LiveEntry, "Select LiveEntry", LiveEntry);
		typeText(driver, test, OCR_EntrySummaryDetails_TeamNumber, "Add Team Number", TeamNumber);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_FTAReconciliation, "Select FTAReconciliation",
				FTAReconciliation);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_ReconciliationIssues, "Select Reconciliation Issues",
				ReconciliationIssues);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_Filer, "Select Filer", Filer);
	}

	// Click on Save
	public void clickSave() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_EntrySummaryDetails_SaveBtn);
		clickElement(driver, test, OCR_EntrySummaryDetails_SaveBtn, "Click on Save Button");
	}

	// Add Bond Details
	public void bondDetails(String BondWaived, String BondWaiverReason, String BondType, String UseContinuousBond,
			String SuretyCompanyNo, String STBAmount, String BondAccountNo, String AddtlSTBCompanyNo,
			String AddtlSTBAmount, String AddtlSTBAccountNo, String BondDesignationTypeCode) {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_EntrySummaryDetails_BondandPaymentDetailsTab);
		Wait.waitfor(5);
		clickElement(driver, test, OCR_EntrySummaryDetails_BondandPaymentDetailsTab,
				"Click on Bondand Payment Details Tab ");
		Wait.waitfor(5);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_BondWaived, "Select Bond Waived ", BondWaived);
		if (BondWaiverReason.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_BondWaiverReasonLink, "Click Bond Waiver Reason link");
			try {
				String BondWaiverR = "//td[contains(text(),'" + BondWaiverReason + "')]";
				clickElement(driver, test, BondWaiverR, "Select Bond Waiver Reason: " + BondWaiverReason);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Bond Waiver Reason");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_BondType, "Select Bond Type", BondType);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_UseContinuousBond, "Select Use Continuous Bond",
				UseContinuousBond);
		typeText(driver, test, OCR_EntrySummaryDetails_SuretyCompanyNo, "Add Surety Company No", SuretyCompanyNo);
		typeText(driver, test, OCR_EntrySummaryDetails_STBAmount, "Add STB Amount", STBAmount);
		typeText(driver, test, OCR_EntrySummaryDetails_BondAccountNo, "Add Bond Account No", BondAccountNo);
		typeText(driver, test, OCR_EntrySummaryDetails_AddtlSTBCompanyNo, "Add Addtl STB Company No",
				AddtlSTBCompanyNo);
		typeText(driver, test, OCR_EntrySummaryDetails_AddtlSTBAmount, "Add Addtl STB Amount", AddtlSTBAmount);
		typeText(driver, test, OCR_EntrySummaryDetails_AddtlSTBAccountNo, "Add Addtl STB Account No",
				AddtlSTBAccountNo);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_BondDesignationTypeCode,
				"Select Bond Designation Type Code ", BondDesignationTypeCode);
	}

	// Payment Details
	public void paymentDetails(String PaymentMode, String PaymentType, String PaymentTermType, String PaymentTerms,
			String INCOTerms, String INCOLocationIdentifier, String PreliminaryStatementPrintDate,
			String AccountInPeriodicStatement, String DeferredTaxPayment, String StatementClientBranch,
			String RequestAcceleratedLiquidation, String ElectronicInvoice, String ConsolidateSummary,
			String CertifyCargoRelease, String KnownImporterIndicator, String INCOTermsLocation) {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_EntrySummaryDetails_BondandPaymentDetailsTab);
		Wait.waitfor(5);
		clickElement(driver, test, OCR_EntrySummaryDetails_BondandPaymentDetailsTab,
				"Click on Bondand Payment Details Tab ");
		Wait.waitfor(5);
		if (PaymentMode.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_PaymentModeLink, "Click Bond Waiver Reason link");
			try {
				String PaymentM = "//td[contains(text(),'" + PaymentMode + "')]";
				clickElement(driver, test, PaymentM, "Select Payment Mode : " + PaymentMode);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Payment Mode ");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		if (PaymentType.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_PaymentTypeLink, "Click Bond Waiver Reason link");
			try {
				String PaymentT = "//td[contains(text(),'" + PaymentType + "')]";
				clickElement(driver, test, PaymentT, "Select Payment Type : " + PaymentType);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Payment Type");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_PaymentTermType, "Select Payment Term",
				PaymentTermType);
		Wait.waitfor(3);
		if (PaymentTerms.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_PaymentTermsLink, "Click Bond Payment Terms Link");
			try {
				String PaymentTe = "//td[contains(text(),'" + PaymentTerms + "')]";
				clickElement(driver, test, PaymentTe, "Select Payment Type : " + PaymentTerms);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Payment Terms");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		if (INCOTerms.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_INCOTerms, "Click INCO Terms Link");
			try {
				String PaymentTe = "//td[contains(text(),'" + INCOTerms + "')]";
				clickElement(driver, test, PaymentTe, "Select Payment Type : " + INCOTerms);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD INCO Terms");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		scrollToElement(driver, OCR_EntrySummaryDetails_INCOLocationIdentifier);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_INCOLocationIdentifier,
				"Add INCO Location Identifier", INCOLocationIdentifier);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_PreliminaryStatementPrintDate,
				"Select Preliminary Statement Print Date");
		date(driver, test, "Preliminary Statement Print Date : ", PreliminaryStatementPrintDate);
		clickElement(driver, test, OCR_EntrySummaryDetails_AccountInPeriodicStatement,
				"Select Account In Periodic Statement");
		date(driver, test, "Account In Periodic Statement : ", AccountInPeriodicStatement);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_DeferredTaxPayment, "Select Deferred Tax Payment",
				DeferredTaxPayment);
		typeText(driver, test, OCR_EntrySummaryDetails_StatementClientBranch, "Add Statement Client Branch",
				StatementClientBranch);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_RequestAcceleratedLiquidation,
				"Select Request Accelerated Liquidation", RequestAcceleratedLiquidation);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_ElectronicInvoice, "Select Electronic Invoice",
				ElectronicInvoice);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_ConsolidateSummary, "Select Consolidate Summary ",
				ConsolidateSummary);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_CertifyCargoRelease, "Select Certify Cargo Release",
				CertifyCargoRelease);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_KnownImporterIndicator,
				"Select Known Importer Indicator", KnownImporterIndicator);
		typeText(driver, test, OCR_EntrySummaryDetails_INCOTermsLocation, "Add INCO Terms Location", INCOTermsLocation);
	}

	// Add Shipment Details
	public void shipmentDetails(String ModeofTransport, String CarrierCode, String VesselName, String VesselCode,
			String VoyageFlightTripNo, String ForeignTradeZone, String EstimatedArrivalDate, String EstimatedEntryDate,
			String DateofImportation, String ITDate, String PortofEntry, String PortofUnlading, String LocationofGoods,
			String FIRMSCode, String RemoteLocationFiling, String DesignatedExamPort) {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_EntrySummaryDetails_ModeofTransportLink);
		Wait.waitfor(5);
		if (ModeofTransport.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_ModeofTransportLink, "Click Mode of Transport link");
			try {
				String MOT = "//td[contains(text(),'" + ModeofTransport + "')]";
				clickElement(driver, test, MOT, "Select Mode of Transport: " + ModeofTransport);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Mode of Transport");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(5);
		scrollToElement(driver, OCR_EntrySummaryDetails_CarrierCodeLink);
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_CarrierCodeLink, "Click on Carrier Code Link");
			try {
				typeText(driver, test, OCR_EntrySummaryDetails_CarrierCode, "Add Carrier Code : ", CarrierCode);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSearch, "Click On Search");
				String Carrier = "//td[contains(text(),'" + CarrierCode + "')]";
				clickElement(driver, test, Carrier, "Select Carrier Code: " + CarrierCode);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Carrier Code");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_EntrySummaryDetails_VesselName, "Add Vessel Name :", VesselName);
		typeText(driver, test, OCR_EntrySummaryDetails_VesselCode, "Add Vessel Code :", VesselCode);
		typeText(driver, test, OCR_EntrySummaryDetails_VoyageFlightTripNo, "Add Voyage / Flight / Trip No : ",
				VoyageFlightTripNo);
		typeText(driver, test, OCR_EntrySummaryDetails_ForeignTradeZone, "Add Foreign Trade Zone :", ForeignTradeZone);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_EstimatedArrivalDate, "Select EstimatedArrivalDate");
		date(driver, test, "Estimated Arrival Date : ", EstimatedArrivalDate);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_EstimatedEntryDate, "Select Estimated Entry Date");
		date(driver, test, "Estimated Entry Date : ", EstimatedEntryDate);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_DateofImportation, "Select Date of Importation");
		date(driver, test, "Date of Importation : ", DateofImportation);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_ITDate, "Select IT Date");
		date(driver, test, "IT Date : ", ITDate);
		Wait.waitfor(3);
		if (PortofEntry.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_PortofEntryLink, "Click on Port of Entry  Link");
			try {
				typeText(driver, test, OCR_EntrySummaryDetails_PortID, "Add Port of Entry  : ", PortofEntry);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSearch, "Click On Search");
				String PortEntry = "//td[contains(text(),'" + PortofEntry + "')]";
				clickElement(driver, test, PortEntry, "Select Carrier Code: " + PortofEntry);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Port of Entry ");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		if (PortofUnlading.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_PortofUnladingLink, "Click on Port of Unlading   Link");
			try {
				typeText(driver, test, OCR_EntrySummaryDetails_PortID, "Add Port of Unlading   : ", PortofUnlading);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSearch, "Click On Search");
				String PortUn = "//td[contains(text(),'" + PortofUnlading + "')]";
				clickElement(driver, test, PortUn, "Select Carrier Code: " + PortofUnlading);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[@name='Ok'])[1]", "Click on select");
				/*Actions act = new Actions(driver);
				act.doubleClick(driver.findElement(By.xpath("(//button[@name='Ok'])[1]"))).perform();*/
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Port of Unlading  ");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_EntrySummaryDetails_LocationofGoods, "Add Location of Goods:", LocationofGoods);
		typeText(driver, test, OCR_EntrySummaryDetails_FIRMSCode, "Add FIRMS Code", FIRMSCode);
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_RemoteLocationFiling, "Select Remote Location Filing",
				RemoteLocationFiling);
		if (DesignatedExamPort.length() > 0) {
			clickElement(driver, test, OCR_EntrySummaryDetails_DesignatedExamPortLink, "Click on Designated Exam Port Link");
			try {
				typeText(driver, test, OCR_EntrySummaryDetails_PortID, "Add Designated Exam Port : ",
						DesignatedExamPort);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSearch, "Click On Search");
				String PortEx = "//td[contains(text(),'" + DesignatedExamPort + "')]";
				clickElement(driver, test, PortEx, "Select Carrier Code: " + DesignatedExamPort);
				clickElement(driver, test, OCR_EntrySummaryDetails_PopUpSelect, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Designated Exam Port");
				clickElement(driver, test, OCR_EntrySummaryDetails_ClosePopUp, "Click on Close");
			}
		}
	}

	// Click on Add Party
	public void clickAddparty() {
		scrollToElement(driver, OCR_EntrySummaryDetails_PartyTypeBtn);
		Wait.waitfor(5);
		clickElement(driver, test, OCR_EntrySummaryDetails_PartyTypeBtn, "Click on Add Party");
	}

	// Click on Save and Proceed button
	public void clickSaveAndProceed() throws InterruptedException {
		scrollToElement(driver, OCR_EntrySummaryDetails_SaveAndProceed);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_SaveAndProceed, "Click on Save and Proceed");
	}

	// Click on Submit tab
	public void clickSubmitTab() {
		scrollToElement(driver, OCR_EntrySummaryDetails_SubmitTab);
		clickElement(driver, test, OCR_EntrySummaryDetails_SubmitTab, "Click on Submit Tab");
	}

	// Click on Alert Popup Close
	public void alertClose() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_EntrySummaryDetails_CloseAlert, "Click Alert Popup Close");
	}

	// Click on alert icon
	public void clickalertIcon() {
		Wait.waitfor(5);
		clickElement(driver, test, "//i[@class='fa fa-exclamation-triangle']", "Click on triangle icon Alert");
	}

	// Validation for Entry Summary Details
	public void validationEntrySummaryDetails() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Filer Code/Entry No is required')]")) {
					test.log(LogStatus.INFO, "Filer Code/Entry No is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Header Details for Entry Summary Details");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryDetails_SummaryDate, "");
		Wait.waitfor(3);
	}

	// Validation for Header Details
	public void validationHeaderDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Entry Type is required')]")) {
				test.log(LogStatus.INFO, "Entry Type is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filer is required')]")) {
				test.log(LogStatus.INFO, "Filer is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Filing Mode/System is Required')]")) {
				test.log(LogStatus.INFO, "Filing Mode/System is Required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Summary Date is required')]")) {
				test.log(LogStatus.INFO, "Summary Date is required");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}

	}

	// Validation for Action
	public void validationAction() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Action code is required')]")) {
				test.log(LogStatus.INFO, "Action code is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on Alert Icon for Action code is required in Entry Summary");
			alertClose();
		}
	}

	// Validation for Bond type
	public void validationBondType() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Type is required')]")) {
				test.log(LogStatus.INFO, "Bond Type is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// Validation for Payment type
	public void validationPaymentType() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Payment Type is required.')]")) {
				test.log(LogStatus.INFO, "Payment Type is required.");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// Validation for Bond details
	public void validationBondDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'is missing for Continuous Trans')]")) {
				test.log(LogStatus.INFO, "Surety Company No is missing for Continuous Transaction Bond");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Bond Designation Type Code is missing')]")) {
				test.log(LogStatus.INFO, "Bond Designation Type Code is missing");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// Validation for Shipment Details
	public void validationShipmentDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Mode of Transport is required for entry type: 01')]")) {
				test.log(LogStatus.INFO, "Mode of Transport is required for entry type: 01");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Port Of Entry and Port of Unlading is Required')]")) {
				test.log(LogStatus.INFO, "Port Of Entry and Port of Unlading is Required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Voyage/Flight/Trip No. is Required')]")) {
				test.log(LogStatus.INFO, "Voyage/Flight/Trip No. is Required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// Validation for Based On MOT 10
	public void validationCarrierAndConveyance() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Carrier is required for Mode Of Transport 10')]")) {
				test.log(LogStatus.INFO, "Carrier is required for Mode Of Transport 10");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// select the Action
	public void selectAction(String Action) {
		selectByVisibleText(driver, test, OCR_EntrySummaryDetails_Action, "Select the Action", Action);
	}

}
