package globalExportClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewOrderItemPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;


	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_CNOItem_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_CNOItem_HazmatDetails = "//a[contains(text(),'Hazmat Details')]";
	public static final String OCR_CNOItem_SubComponent = "//a[contains(text(),'Sub Component')]";
	public static final String OCR_CNOItem_Save = "//button[@id='saveSubmitBtn']";
	public static final String OCR_CNOItem_SaveAndReturn = "//button[@id='saveAndReturnInvoiceItem']";
	public static final String OCR_CNOItem_ApplyAuthorisation = "//button[@id='applyExportMain']";
	public static final String OCR_CNOItem_OverrideExportHold = "//button[@id='authOverride']";
	public static final String OCR_CNOItem_Close = "//button[@id='cancelInvoiceItem']";
	public static final String OCR_CNOItem_PartNoLink = "//a[@id='partno-popup']";
	public static final String OCR_CNOItem_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_CNOItem_Desc = "//textarea[@id='editInvoiceItem_invoiceItem_description']";
	public static final String OCR_CNOItem_SearchBtn = "//div[@id='searchDIV']//button[2]";
	public static final String OCR_CNOItem_ClassificationInfoSearchBtn = "//div[@id='searchDIV']//button[1]";
	public static final String OCR_CNOItem_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CNOItem_ClosePopUp = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CNOItem_SourceSystemPartNumber = "//input[@id='editInvoiceItem_invoiceItem_sourceSystemPart']";
	public static final String OCR_CNOItem_ProductDescription = "//textarea[@id='editInvoiceItem_invoiceItem_description']";
	public static final String OCR_CNOItem_SerialNumbers = "//textarea[@id='editInvoiceItem_invoiceItem_serialNo']";
	public static final String OCR_CNOItem_PONumber = "//input[@id='editInvoiceItem_invoiceItem_poNumber']";
	public static final String OCR_CNOItem_CustomerPartNumber = "//input[@id='editInvoiceItem_invoiceItem_custPartNo']";
	public static final String OCR_CNOItem_SalesOrderNo = "//input[@id='editInvoiceItem_invoiceItem_salesOrderNo']";
	public static final String OCR_CNOItem_SalesOrderItemNo = "//input[@id='editInvoiceItem_invoiceItem_salesOrderItemNo']";
	public static final String OCR_CNOItem_DeliveryOrderNo = "//input[@id='editInvoiceItem_invoiceItem_deliveryOrderNo']";
	public static final String OCR_CNOItem_DeliveryOrderItemNo = "//input[@id='editInvoiceItem_invoiceItem_deliveryOrderItemNo']";
	public static final String OCR_CNOItem_ManufacturerLink = "//a[@id='getManufacturer']";
	public static final String OCR_CNOItem_Manufacturer = "//input[@id='editInvoiceItem_invoiceItem_manufacturer']";
	public static final String OCR_CNOItem_CountryOfOrigin = "//input[@id='cooName']";
	public static final String OCR_CNOItem_CountryOriginDropDown = "//select[@id='editInvoiceItem_invoiceItem_domesticForeign']";
	public static final String OCR_CNOItem_FTAApplicable = "//select[@id='editInvoiceItem_invoiceItem_naftaReportable']";
	public static final String OCR_CNOItem_NetworkOrderNumber = "//input[@id='editInvoiceItem_invoiceItem_orderNetworkNo']";
	public static final String OCR_CNOItem_EngineLine = "//input[@id='editInvoiceItem_invoiceItem_engineLine']";
	public static final String OCR_CNOItem_MTFNumber = "//input[@id='editInvoiceItem_invoiceItem_mtfNo']";
	public static final String OCR_CNOItem_Remarks = "//textarea[@id='editInvoiceItem_invoiceItem_itemsRemarks']";
	public static final String OCR_CNOItem_QuantityPricingInformationLabel = "//font[contains(text(),'Quantity & Pricing Information')]";
	public static final String OCR_CNOItem_CustomsInvoiceQuantity = "//input[@id='primaryNetQuantity']";
	public static final String OCR_CNOItem_QuantityUOM = "//input[@id='editInvoiceItem_invoiceItem_invoiceUnitOfQuantity']";
	public static final String OCR_CNOItem_ItemUnitPrice = "//input[@id='editInvoiceItem_invoiceItem_prodUnitPrice']";
	public static final String OCR_CNOItem_ItemUnitPriceCurrency = "//input[@id='editInvoiceItem_invoiceItem_itemCurrency']";
	public static final String OCR_CNOItem_RepairValue = "//input[@id='editInvoiceItem_invoiceItem_repairValue']";
	public static final String OCR_CNOItem_DiscountRate = "//input[@id='editInvoiceItem_invoiceItem_discount']";
	public static final String OCR_CNOItem_WholesaleRate = "//input[@id='editInvoiceItem_invoiceItem_wholesaleRate']";
	public static final String OCR_CNOItem_ClassificationInformationLabel = "//font[contains(text(),'Classification Information')]";
	public static final String OCR_CNOItem_ControllingAgencyLink = "//a[@id='controllingAgency-Popup']";
	public static final String OCR_CNOItem_ExportClassificationLink = "(//a[contains(text(),'Export Classification')])[1]";
	public static final String OCR_CNOItem_ExportClassificationItem = "//input[@id='searchForm_ukItemsDTO_prodClassification']";
	public static final String OCR_CNOItem_HTSPrimaryUOM = "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']";
	public static final String OCR_CNOItem_SecondaryCustomsQuantityUOMLink = "//a[contains(text(),'& UOM')]";
	public static final String OCR_CNOItem_SecondaryCustomsQuantity = "//input[@id='editInvoiceItem_invoiceItem_secondaryNetQuantity']";
	public static final String OCR_CNOItem_SCQ_UOM = "//input[@id='editInvoiceItem_invoiceItem_secondaryUnit']";
	public static final String OCR_CNOItem_ImportHTSUOMLink = "//a[@id='htsImportPopup']";
	public static final String OCR_CNOItem_ImportHTS = "//input[@id='editInvoiceItem_invoiceItem_importHts']";
	public static final String OCR_CNOItem_ImportUOM = "//input[@id='editInvoiceItem_invoiceItem_importUnit']";
	public static final String OCR_CNOItem_USExportClassificationLink = "//a[@id='productClass-us-Popup']";
	public static final String OCR_CNOItem_USExportClassificationECCN = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_CNOItem_StatisticalCodeLink = "//a[@id='statisticalPopup']";
	public static final String OCR_CNOItem_StatisticalCode = "//input[@id='editInvoiceItem_invoiceItem_schBORStatisticalCode']";
	public static final String OCR_CNOItem_ClassificationInformationSave = "//button[@id='saveFromClassBlock']";
	public static final String OCR_CNOItem_CIApplyAuthorization = "//button[@id='applyExport']";
	public static final String OCR_CNOItem_ExportAuthorisationInformationLabel = "//font[contains(text(),'Export Authorisation Information')]";
	public static final String OCR_CNOItem_ExportAuthorizationInformationLabel = "//font[contains(text(),'Export Authorization Information')]";
	public static final String OCR_CNOItem_AdditionalAuthorizationInformationLabel = "//font[contains(text(),'Additional Authorization')]";
	public static final String OCR_CNOItem_BISLicenseExceptionLink = "//a[contains(text(),'BIS License Exception')]";
	public static final String OCR_CNOItem_AuthorisationNoLink = "//a[@id='licenseNo-Popup']";
	public static final String OCR_CNOItem_AuthorisationItemNoLink = "//a[@id='licenseItemNo']";
	public static final String OCR_CNOItem_InternalAuthNoLink = "//a[contains(text(),'Internal Auth. No.')]";
	public static final String OCR_CNOItem_InternalAuthNoPopUp = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_CNOItem_InternalAuthItemNoLink = "//a[@id='internalAuthorizationItemNo']";
	public static final String OCR_CNOItem_AuthorisationTypeLink = "//a[@id='licenseType-Popup']";
	public static final String OCR_CNOItem_AuthorisationNoPopUP = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_CNOItem_EAI_TransactionTypeLink = "(//a[contains(text(),'Transaction Type')])[2]";
	public static final String OCR_CNOItem_AuthorisationExpiryDate = "//input[@id='editInvoiceItem_licenseDate']";
	public static final String OCR_CNOItem_MLCategory = "//a[contains(text(),'ML Category')]";
	public static final String OCR_CNOItem_EUSNo = "//input[@id='editInvoiceItem_invoiceItem_eusLicense']";
	public static final String OCR_CNOItem_AdditionalAuthorisationLabel = "//font[contains(text(),'Additional Authorisation')]";
	public static final String OCR_CNOItem_AddAdditionalAuthorisationBtn = "//button[@id='addAuthorisation']";
	public static final String OCR_CNOItem_AA_AuthorisationNoLink = "//a[@id='licenseNo-Popup-authorisation']";
	public static final String OCR_CNOItem_AA_AuthorisationItemNoLink = "//a[@id='licenseItemNo-authorisation']";
	public static final String OCR_CNOItem_AA_SaveBtn = "//button[@name='Save']";
	public static final String OCR_CNOItem_PackingInformationLabel = "//font[contains(text(),'Packing Information')]";
	public static final String OCR_CNOItem_HUNoContainerId = "//input[@id='invoiceItem.huNum']";
	public static final String OCR_CNOItem_HUNoSubLevel = "//input[@id='invoiceItem.huSubLevel']";
	public static final String OCR_CNOItem_GrossWeight = "//input[@id='editInvoiceItem_invoiceItem_grossWeight']";
	public static final String OCR_CNOItem_NetWeight = "//input[@id='editInvoiceItem_invoiceItem_netWeight']";
	public static final String OCR_CNOItem_TotalNetWeight = "//input[@id='editInvoiceItem_totalNetWt']";
	public static final String OCR_CNOItem_Markings = "//input[@id='editInvoiceItem_invoiceItem_marksAndNos']";
	public static final String OCR_CNOItem_Dimensions = "//input[@id='editInvoiceItem_invoiceItem_dimensions']";
	public static final String OCR_CNOItem_NoOfPkgs = "//input[@id='editInvoiceItem_invoiceItem_noOfPackages']";
	public static final String OCR_CNOItem_AlternateUOM = "//input[@id='editInvoiceItem_invoiceItem_alternateUom']";
	public static final String OCR_CNOItem_Skids = "//input[@id='editInvoiceItem_invoiceItem_skids']";
	public static final String OCR_CNOItem_Length = "//input[@id='editInvoiceItem_invoiceItem_length']";
	public static final String OCR_CNOItem_Width = "//input[@id='editInvoiceItem_invoiceItem_width']";
	public static final String OCR_CNOItem_Height = "//input[@id='editInvoiceItem_invoiceItem_height']";
	public static final String OCR_CNOItem_Weight = "//input[@id='editInvoiceItem_invoiceItem_weight']";
	public static final String OCR_CNOItem_ExtendedWeight = "//input[@id='editInvoiceItem_invoiceItem_extendedWeight']";
	public static final String OCR_CNOItem_Factor = "//input[@id='editInvoiceItem_invoiceItem_factor']";
	public static final String OCR_CNOItem_Cubic = "//input[@id='editInvoiceItem_invoiceItem_cubic']";
	public static final String OCR_CNOItem_MultiplePackageSwitch = "//div[@class='hRow']//div//div[@class='lcs_cursor']";
	public static final String OCR_CNOItem_MP_AddPackageBtn = "//button[@id='addPackingDetail']";
	public static final String OCR_CNOItem_MP_HUNoContainerId = "//input[@id='packingDetail.huNum']";
	public static final String OCR_CNOItem_MP_HUNoSubLevel = "//input[@id='packingDetail.huSubLevel']";
	public static final String OCR_CNOItem_MP_GrossWeight = "//input[@id='packingDetailForm_packingDetail_grossWeight']";
	public static final String OCR_CNOItem_MP_NetWeight = "//input[@id='packingDetailForm_packingDetail_netWeight']";
	public static final String OCR_CNOItem_MP_MarksAndNos = "//input[@id='packingDetailForm_packingDetail_marksAndNo']";
	public static final String OCR_CNOItem_MP_Dimensions = "//input[@id='packingDetailForm_packingDetail_dimensions']";
	public static final String OCR_CNOItem_MP_NoOfPkgs = "//input[@id='packingDetailForm_packingDetail_noOfPackages']";
	public static final String OCR_CNOItem_MP_TypeOfPacking = "//input[@id='packingDetailForm_packingDetail_typeOfPackDesc']";
	public static final String OCR_CNOItem_MP_Skids = "//input[@id='packingDetailForm_packingDetail_skids']";
	public static final String OCR_CNOItem_MP_Length = "//input[@id='packingDetailForm_packingDetail_length']";
	public static final String OCR_CNOItem_MP_Width = "//input[@id='packingDetailForm_packingDetail_width']";
	public static final String OCR_CNOItem_MP_Height = "//input[@id='packingDetailForm_packingDetail_height']";
	public static final String OCR_CNOItem_MP_Weight = "//input[@id='packingDetailForm_packingDetail_weight']";
	public static final String OCR_CNOItem_MP_ExtendedWeight = "//input[@id='packingDetailForm_packingDetail_extendedWeight']";
	public static final String OCR_CNOItem_MP_Factor = "//input[@id='packingDetailForm_packingDetail_factor']";
	public static final String OCR_CNOItem_MP_Cubic = "//input[@id='packingDetailForm_packingDetail_cubic']";
	public static final String OCR_CNOItem_MP_QuantityUOM = "//input[@id='packingDetailForm_packingDetail_primaryNetQuantity']";
	public static final String OCR_CNOItem_MP_AlternateUOM = "//input[@id='packingDetailForm_packingDetail_alternateUom']";
	public static final String OCR_CNOItem_MP_SaveBtn = "//button[@name='Save']";
	public static final String OCR_CNOItem_BatchInformationLabel = "//font[contains(text(),'Batch Information')]";
	public static final String OCR_CNOItem_AddBatchInfo = "//button[@id='addBatch']";
	public static final String OCR_CNOItem_BatchInfo_BatchNumber = "//input[@id='editBatchHeader_batchDetailValue_batchNo']";
	public static final String OCR_CNOItem_BatchInfo_CountryOfOrigin = "//input[@id='editBatchHeader_']";
	public static final String OCR_CNOItem_BatchInfo_Quantity = "//input[@id='editBatchHeader_batchDetailValue_batchPrimaryQty']";
	public static final String OCR_CNOItem_BatchInfo_ExpiryDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark1']";
	public static final String OCR_CNOItem_BatchInfo_SterilityDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark2']";
	public static final String OCR_CNOItem_BatchInfo_Submit = "//button[@id='save']";
	public static final String OCR_CNOItem_CustomsFilingInformationLabel = "//font[contains(text(),'Customs Filing Information')]";
	public static final String OCR_CNOItem_ReExportInformationLabel = "//font[contains(text(),'Re-Export Information')]";
	public static final String OCR_CNOItem_ImportShipmentType = "//select[@id='editInvoiceItem_invoiceItem_impInvoiceType']";
	public static final String OCR_CNOItem_InbondTypeLink = "//a[contains(text(),'Inbond Type')]";
	public static final String OCR_CNOItem_EntryImportInvoiceNoLink = "//a[@id='impInvoice-Popup']";
	public static final String OCR_CNOItem_EntryNo = "//input[@id='resultEntryPopupData_import7501DetailsDTO_entryNo']";
	public static final String OCR_CNOItem_ItemNoLink = "//a[@id='itemNo']";
	public static final String OCR_CNOItem_ImportIdentificationNoLink = "//a[@id='importIdentityNo']";
	public static final String OCR_CNOItem_RateofYield = "//input[@id='editInvoiceItem_invoiceItem_rateOfYield']";
	public static final String OCR_CNOItem_ReliefAuthorizationNoLink = "//a[contains(text(),'Relief Authorization No.')]";
	public static final String OCR_CNOItem_ReliefAuthorizationNo = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_CNOItem_ReliefAuthItemNoLink = "//input[@id='editInvoiceItem_invoiceItem_reliefAuthItemNo']";
	public static final String OCR_CNOItem_ExportAuthScreeningIconGreen = "//i[@class='fa fa-check-circle green']";
	public static final String OCR_CNOItem_ExportAuthScreeningIconRed = "//i[@class='fa fa-exclamation-circle red']";

	public static final String OCR_CNOItem_Regres_POLineNo = "//input[@id='editInvoiceItem_invoiceItem_poLineNo']";
	public static final String OCR_CNOItem_Regres_SchedulingAgreement = "//input[@id='editInvoiceItem_invoiceItem_schedulingAgreement']";
	public static final String OCR_CNOItem_Regres_Vendor = "//input[@id='editInvoiceItem_invoiceItem_vendor']";
	public static final String OCR_CNOItem_Regres_VendorPartNo = "//input[@id='editInvoiceItem_invoiceItem_vendorPartNo']";
	public static final String OCR_CNOItem_Regres_NetOrderNo = "//input[@id='editInvoiceItem_invoiceItem_orderNetworkNo']";
	public static final String OCR_CNOItem_Regres_WBSElement = "//input[@id='editInvoiceItem_invoiceItem_wbs']";
	public static final String OCR_CNOItem_Regres_OrgPONo = "//input[@id='editInvoiceItem_invoiceItem_originalPoNumber']";
	public static final String OCR_CNOItem_Regres_QtyOrdered = "//input[@id='editInvoiceItem_invoiceItem_qtyOrdered']";
	public static final String OCR_CNOItem_Regres_DutyReliefAuthNo = "//a[contains(text(),'Relief Authorization No.')]";
	public static final String OCR_CNOItem_Regres_EnterDutyReliefAuthNo = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_CNOItem_Regres_DutyReliefAUthSearchBtn = "//button[@name='Search']";
	public static final String OCR_CNOItem_Regres_DutyReliefAUthSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CNOItem_Regres_DutyReliefDueDate = "//input[@id='dueDateMainPage']";
	public static final String OCR_CNOItem_Regres_SaveReturnBtn = "//button[@id='saveAndReturnInvoiceItem']";
	public static final String OCR_CNOItem_Regres_ReliefActivityType = "//select[@id='editInvoiceItem_invoiceItem_reliefActivityType']";
	public static final String OCR_CNOItem_Regres_ItemPageCloseBtn = "//button[@id='cancelInvoiceItem']";
	public static final String OCR_CNOItem_Regres_COO = "//input[@id='cooName']";

	public static final String OCR_CNOItem_Regres_NotesLabel = "//font[contains(text(),'Notes')]";
	public static final String OCR_CNOItem_Regres_PackingNote = "//textarea[@id='editInvoiceItem_invoiceItem_packingNote']";
	public static final String OCR_CNOItem_Regres_ContractLineNote = "//textarea[@id='editInvoiceItem_invoiceItem_contractLineNote']";
	public static final String OCR_CNOItem_Regres_OracleAttachment = "//textarea[@id='editInvoiceItem_invoiceItem_oracleAttachment']";
	public static final String OCR_CNOItem_Regres_DeliveryAttachment = "//textarea[@id='editInvoiceItem_invoiceItem_deliveryAttachment']";
	public static final String OCR_CNOItem_Regres_PartNoLink = "//a[contains(text(),'Part No')]";
	public static final String OCR_CNOItem_Regres_EnterpartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_CNOItem_Regres_SearchpartNo = "//button[@name='Search']";
	public static final String OCR_CNOItem_Regres_SelectpartNo = "(//button[@name='Ok'])[1]";
	public static final String OCR_CNOItem_Regres_ClosepartNo = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CNOItem_Regres_TransactionType = "//input[@id='editInvoiceItem_invoiceItem_licenseTxnType']";
	public static final String OCR_CNOItem_Regres_DDTCNumber = "//input[@id='editInvoiceItem_invoiceItem_registrationNo']";
	public static final String OCR_CNOItem_ITARException = "(//a[contains(text(),'ITAR Exemption')])[3]";
	public static final String OCR_CNOItem_AuthorizationType = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_CNOItem_EntryNotextbox = "//input[@id='editInvoiceItem_invoiceItem_entryCode']";

	// public static final String OCR_CNOItem_Regres_DutyReliefDueDate =
	// "//input[@id='dueDateMainPage']";

	/* ******************************* Constructor ****************************** */

	public CreateNewOrderItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Fetch the item of an existing shipment transaction from authorization

	public void click_InvItem(String Item) {
		Wait.waitfor(2);
		// clickElement(driver, test, "//a[contains(text(),'"+ Item +"')]", Item);
		clickElement(driver, test, "//table[@id='grid-items']//tr//a[contains(text(),'" + Item + "')]",
				"click on Item No : " + Item);
	}

	// Click on Save Button
	public void click_SaveBtn() {
		scrollToElement(driver, OCR_CNOItem_Save);
		// scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_Save, "Click on Save Button in order items");
	}

	// Click on Save And Return
	public void click_SaveAndReturn() {
		scrollToElement(driver, OCR_CNOItem_SaveAndReturn);
		scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_SaveAndReturn, "Click on Save And Return");
	}

	// Click on Apply Authorization
	public void click_ApplyAuthorisation() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_ApplyAuthorisation, "Click on Apply Authorisation");
	}

	// Click on Override Export Hold
	public void click_OverrideExportHold() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_OverrideExportHold, "Click on Override Export Hold");
	}

	// Click on Close
	public void click_Close() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_Close, "Click on Close");
	}

	// Enter the part descripition
	public void typeDesc(String ProductDescription) {
		typeText(driver, test, OCR_CNOItem_Desc, "Enter the Product Description : ", ProductDescription);
	}

	// Adding the General information details
	public void AddGeneralInformation(String PartNo, String SourceSystemPartNumber, String SerialNumbers,
			String PONumber, String CustomerPartNumber, String SalesOrderNo, String SalesOrderItemNo,
			String DeliveryOrderNo, String DeliveryOrderItemNo, String ManufacturerID, String CountryOfOrigin,
			String CountryOfOriginType, String FTAApplicable, String NetworkOrderNumber, String EngineLine,
			String MTFNumber, String Remarks) {
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_PartNoLink, "Click on Part No link");
			try {
				typeText(driver, test, OCR_CNOItem_PartNo, "Enter the Part No : ", PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CNOItem_SearchBtn, "Click on Search button");
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Select the PartNo : " + PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_CNOItem_SourceSystemPartNumber, "Enter the Source System Part Number : ",
				SourceSystemPartNumber);
		typeText(driver, test, OCR_CNOItem_SerialNumbers, "Enter the Serial Numbers : ", SerialNumbers);
		typeText(driver, test, OCR_CNOItem_PONumber, "Enter the PO Number : ", PONumber);
		typeText(driver, test, OCR_CNOItem_CustomerPartNumber, "Enter the Customer Part No : ", CustomerPartNumber);
		typeText(driver, test, OCR_CNOItem_SalesOrderNo, "Enter the Sales Order NO : ", SalesOrderNo);
		typeText(driver, test, OCR_CNOItem_SalesOrderItemNo, "Enter the Sales Order Item No : ", SalesOrderItemNo);
		typeText(driver, test, OCR_CNOItem_DeliveryOrderNo, "Enter the Delivery Order No : ", DeliveryOrderNo);
		typeText(driver, test, OCR_CNOItem_DeliveryOrderItemNo, "Enter the Delivery Order Item No : ",
				DeliveryOrderItemNo);
		Wait.waitfor(3);
		if (ManufacturerID.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_ManufacturerLink, "Click on Manufacturer link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ManufacturerID + "')]",
						"Select the Manufacturer ID : " + ManufacturerID);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		typeText(driver, test, OCR_CNOItem_CountryOfOrigin, "Enter the Country Of Origin : ", CountryOfOrigin);
		selectByVisibleText(driver, test, OCR_CNOItem_CountryOriginDropDown, "Select the Country of Origin Type : ",
				CountryOfOriginType);
		selectByVisibleText(driver, test, OCR_CNOItem_FTAApplicable, "Select the FTA Applicable : ", FTAApplicable);
		typeText(driver, test, OCR_CNOItem_NetworkOrderNumber, "Enter the Network Order Number : ", NetworkOrderNumber);
		typeText(driver, test, OCR_CNOItem_EngineLine, "Enter the Engine Line : ", EngineLine);
		typeText(driver, test, OCR_CNOItem_MTFNumber, "Enter the MTFNumber : ", MTFNumber);
		typeText(driver, test, OCR_CNOItem_Remarks, "Enter the Remarks : ", Remarks);
		Wait.waitfor(3);
	}

	// Adding General Information for Regression
	public void AddGeneralInformation(String PartNo, String SourceSystemPartNumber, String POLineNo,
			String ScheduleAgreement, String SerialNumbers, String PONumber, String CustomerPartNumber,
			String SalesOrderNo, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo,
			String Vendor, String VendorPN, String NetOrderNo, String EngineLine, String WBS, String MTFNumber,
			String Remarks, String OrgPONo) {

		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_Regres_PartNoLink, "Click on Part No link");
			try {
				typeText(driver, test, OCR_CNOItem_Regres_EnterpartNo, "Enter the Part No : ", PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CNOItem_Regres_SearchpartNo, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Select the PartNo : " + PartNo);
				clickElement(driver, test, OCR_CNOItem_Regres_SelectpartNo, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_Regres_ClosepartNo, "Click on Cancel popup icon");
			}
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_CNOItem_SourceSystemPartNumber, "Enter the Source System Part Number : ",
				SourceSystemPartNumber);
		typeText(driver, test, OCR_CNOItem_Regres_POLineNo, "ENter PO Line Number : ", POLineNo);
		typeText(driver, test, OCR_CNOItem_Regres_SchedulingAgreement, "Enter Scheduling Agreement : ",
				ScheduleAgreement);
		typeText(driver, test, OCR_CNOItem_SerialNumbers, "Enter the Serial Numbers : ", SerialNumbers);
		typeText(driver, test, OCR_CNOItem_PONumber, "Enter the PO Number : ", PONumber);
		typeText(driver, test, OCR_CNOItem_CustomerPartNumber, "Enter the Customer Part No : ", CustomerPartNumber);
		typeText(driver, test, OCR_CNOItem_SalesOrderNo, "Enter the Sales Order NO : ", SalesOrderNo);
		typeText(driver, test, OCR_CNOItem_SalesOrderItemNo, "Enter the Sales Order Item No : ", SalesOrderItemNo);
		typeText(driver, test, OCR_CNOItem_DeliveryOrderNo, "Enter the Delivery Order No : ", DeliveryOrderNo);
		typeText(driver, test, OCR_CNOItem_DeliveryOrderItemNo, "Enter the Delivery Order Item No : ",
				DeliveryOrderItemNo);
		Wait.waitfor(3);
		typeText(driver, test, OCR_CNOItem_Regres_Vendor, "Enter Vendor : ", Vendor);
		typeText(driver, test, OCR_CNOItem_Regres_VendorPartNo, "Enter Vendor Part Number : ", VendorPN);
		typeText(driver, test, OCR_CNOItem_Regres_NetOrderNo, "Enter Network Order Number : ", NetOrderNo);
		typeText(driver, test, OCR_CNOItem_EngineLine, "Enter the Engine Line : ", EngineLine);
		typeText(driver, test, OCR_CNOItem_Regres_WBSElement, "Enter WBS Element : ", WBS);
		typeText(driver, test, OCR_CNOItem_MTFNumber, "Enter the MTFNumber : ", MTFNumber);
		typeText(driver, test, OCR_CNOItem_Remarks, "Enter the Remarks : ", Remarks);
		typeText(driver, test, OCR_CNOItem_Regres_OrgPONo, "Original PO Number : ", OrgPONo);
		Wait.waitfor(3);
	}

	public void enterPrCoo(String PrCoo) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNOItem_Regres_COO);
		typeText(driver, test, OCR_CNOItem_Regres_COO, "Enter Country Of Origin : ", PrCoo);
	}

	// Adding the Quantity And Pricing Information
	public void addQuantityAndPricingInfo(String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice,
			String ItemUnitPriceCurrency, String RepairValue, String DiscountRate, String WholesaleRate) {
		scrollToElement(driver, OCR_CNOItem_Remarks);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNOItem_QuantityPricingInformationLabel,
				"Click on Quantity Pricing Information Label");
		clearText(driver, test, OCR_CNOItem_CustomsInvoiceQuantity, "Clear the Customs Invoice Qty");
		typeText(driver, test, OCR_CNOItem_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ",
				CustomsInvoiceQuantity);
		typeText(driver, test, OCR_CNOItem_QuantityUOM, "Enter the Quantity UOM : ", QuantityUOM);
		typeText(driver, test, OCR_CNOItem_ItemUnitPrice, "Enter the Item Unit Price : ", ItemUnitPrice);
		if (ItemUnitPriceCurrency.length() > 0) {
			clearText(driver, test, OCR_CNOItem_ItemUnitPriceCurrency, "Clear the text in Item Unit Price Currency");
			typeText(driver, test, OCR_CNOItem_ItemUnitPriceCurrency, "Enter the Item Unit Price Currency : ",
					ItemUnitPriceCurrency);
		}
		Wait.waitfor(3);
		clearText(driver, test, OCR_CNOItem_RepairValue, "Clear the text in Repair value");
		typeText(driver, test, OCR_CNOItem_RepairValue, "Enter thr Repair Value : ", RepairValue);
		typeText(driver, test, OCR_CNOItem_DiscountRate, "Enter the Discount Rate : ", DiscountRate);
		typeText(driver, test, OCR_CNOItem_WholesaleRate, "Enter the Whole sale Rate : ", WholesaleRate);
	}

	// Enter only Invoice Quantity when creating shipment from authorization

	public void addQuantityAndPricingInfo(String CustomsInvoiceQuantity) {
		scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNOItem_QuantityPricingInformationLabel,
				"Click on Quantity Pricing Information Label");
		clearText(driver, test, OCR_CNOItem_CustomsInvoiceQuantity, "Clear the Customs Invoice Qty");
		typeText(driver, test, OCR_CNOItem_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ",
				CustomsInvoiceQuantity);
	}

	// Adding the Classification Information
	public void addClassifacationInfo(String ControllingAgencycode, String ExportClassificationItem,
			String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM,
			String ImportHTS, String ImportUOM, String USExportECCN, String StatisticalCode) {
		scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ClassificationInformationLabel,"Click on Classifaction Information label");
		if (ControllingAgencycode.length() > 0) {
			Wait.waitfor(3);
			clearText(driver, test, "//input[@name='invoiceItem.controllingAgency']", "Clear the Controlling agency :"); // Clear
																															// CTRL
																															// AGENCY//
			clickElement(driver, test, OCR_CNOItem_ControllingAgencyLink, "Click on Controlling Agency Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ControllingAgencycode + "')]",
						"Select the Controlling Agency code : " + ControllingAgencycode);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select Button");
				scrollToBottom(driver);
				scrollToBottom(driver);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (ExportClassificationItem.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
			Wait.waitfor(3);

			clearText(driver, test, "//input[@name='invoiceItem.exportClassEccnUsml']", "Clear ECCN : "); // for CLear
																											// ECCN //
			clickElement(driver, test, OCR_CNOItem_ExportClassificationLink, "Click on Export Classification Link");
			try {

				if (ControllingAgencycode.equalsIgnoreCase("DOC")) {
					typeText(driver, test, OCR_CNOItem_USExportClassificationECCN,
							"Enter the Export Classification item : ", ExportClassificationItem);
				} else if (ControllingAgencycode.equalsIgnoreCase("ACE")) { /// AMAR
					typeText(driver, test, OCR_CNOItem_USExportClassificationECCN,
							"Enter the Export Classification item : ", ExportClassificationItem);

				} else {
					typeText(driver, test, OCR_CNOItem_ExportClassificationItem,
							"Enter the Export Classification item : ", ExportClassificationItem);
				}
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + ExportClassificationItem + "')]",
						"Select the Export Classification Item : " + ExportClassificationItem);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(3);
				if(!ControllingAgencycode.equalsIgnoreCase("DOC")) {
					try {
						AlertPopUp(driver, test, "OK");
						clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
					} catch (Exception n) {
						testFailSshot(driver, test);
						test.log(LogStatus.FAIL, "Alert not Accpeted :");
					}
				}
				
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}

			scrollToBottom(driver);
			typeText(driver, test, OCR_CNOItem_HTSPrimaryUOM, "Enter the HTS & Primary UOM : ", HtsAndPrimaryUMO);
			typeText(driver, test, OCR_CNOItem_SecondaryCustomsQuantity, "Enter the Secondary Customs Quantity : ",
					SecondaryCustomsQuantity);
			typeText(driver, test, OCR_CNOItem_SCQ_UOM, "Enter the Secondary Customs Quantity UOM : ",
					SecondaryCustomsQuantityUOM);
			typeText(driver, test, OCR_CNOItem_ImportHTS, "Enter the Import HTS : ", ImportHTS);
			typeText(driver, test, OCR_CNOItem_ImportUOM, "Enter the Import UOM : ", ImportUOM);
			if (USExportECCN.length() > 0) {
				clickElement(driver, test, OCR_CNOItem_USExportClassificationLink,
						"Click on US Export Classification Link");
				try {
					typeText(driver, test, OCR_CNOItem_USExportClassificationECCN, "Enter the USExportECCN : ",
							USExportECCN);
					clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
					clickElement(driver, test, "//td[contains(text(),'" + USExportECCN + "')]",
							"Select the US Export Classification ECCN : " + USExportECCN);
					clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
					scrollToBottom(driver);
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, "//div[@id='ocrModal']//button[@class='cancelPopup']",
							"Click on Cancel popup icon");
				}
			}

			scrollToBottom(driver);
			typeText(driver, test, OCR_CNOItem_StatisticalCode, "Enter the Statistical Code : ", StatisticalCode);
			scrollToBottom(driver);
			scrollToBottom(driver);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CNOItem_ClassificationInformationSave,
					"Click on Classification Information Save button");
		}

	}

	// Entering only HTS/Schedule b & Primary UOM
	// Adding the Classification Information
	public void addClassifacationInfo(String HtsAndPrimaryUMO) {
		scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ClassificationInformationLabel,
				"Click on Classifaction Information label");
		scrollToElement(driver, OCR_CNOItem_HTSPrimaryUOM);
		typeText(driver, test, OCR_CNOItem_HTSPrimaryUOM, "Enter the HTS & Primary UOM : ", HtsAndPrimaryUMO);

		clickElement(driver, test, OCR_CNOItem_ClassificationInformationSave,
				"Click on Classification Information Save button");
	}

	// Adding Export Authorisation Information
	public void addExportAuthorisationInfo(String BISLicenseException, String AuthorisationNo,
			String AuthorisationItemNo, String InternalAuthNo, String AuthorisationExpiryDate, String MLCategoryCode,
			String EUSNo) {
		scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ExportAuthorisationInformationLabel,
				"Click on Export Authorisation Information Label");
		if (BISLicenseException.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_BISLicenseExceptionLink, "Click on BIS License Exception Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + BISLicenseException + "')]",
						"Select the BIS License Exception : " + BISLicenseException);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (AuthorisationNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_AuthorisationNoLink, "Click on Authorisation No Link");
			try {
				typeText(driver, test, OCR_CNOItem_AuthorisationNoPopUP, "Enter the Authorisation No : ",
						AuthorisationNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				Wait.waitfor(4);
				clickElement(driver, test, "//td[contains(text(),'" + AuthorisationNo + "')]",
						"Select the Authorisation No : " + AuthorisationNo);
				Wait.waitfor(4);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (AuthorisationItemNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_AuthorisationItemNoLink, "Click on Authorisation Item No Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + AuthorisationItemNo + "')]",
						"Select the Authorisation Item No : " + AuthorisationItemNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (InternalAuthNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_InternalAuthNoLink, "Click on Internal Auth No");
			try {
				typeText(driver, test, OCR_CNOItem_InternalAuthNoPopUp, "Enter the Internal Auth No : ",
						InternalAuthNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + InternalAuthNo + "')]",
						"Select the Internal Auth No : " + InternalAuthNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
		clickElement(driver, test, OCR_CNOItem_AuthorisationExpiryDate, "Click on Authorisation Expiry Date");
		date(driver, test, "Select the Authorisation Expiry Date : ", AuthorisationExpiryDate);
		if (MLCategoryCode.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_MLCategory, "Click on ML Category");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + MLCategoryCode + "')]",
						"Select the ML Category Code : " + MLCategoryCode);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		typeText(driver, test, OCR_CNOItem_EUSNo, "Enter the EUS No : ", EUSNo);
	}

	// Adding Export Authorization Information US
	public void addExportAuthorizationInfoUS(String BISLicenseException, String AuthorisationNo,
			String AuthorisationItemNo, String InternalAuthNo, String AuthorisationExpiryDate, String MLCategoryCode,
			String EUSNo, String SMEIndicator) {
		scrollToElement(driver, OCR_CNOItem_ExportAuthorizationInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ExportAuthorizationInformationLabel,
				"Click on Export Authorisation Information Label");
		if (BISLicenseException.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_BISLicenseExceptionLink, "Click on BIS License Exception Link");
			try {
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				Wait.waitfor(4);
				clickElement(driver, test, "//td[contains(text(),'" + BISLicenseException + "')]",
						"Select the BIS License Exception : " + BISLicenseException);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (AuthorisationNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_AuthorisationNoLink, "Click on Authorisation No Link");
			try {
				typeText(driver, test, OCR_CNOItem_AuthorisationNoPopUP, "Enter the Authorisation No : ",
						AuthorisationNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				Wait.waitfor(4);
				clickElement(driver, test, "//td[contains(text(),'" + AuthorisationNo + "')]",
						"Select the Authorisation No : " + AuthorisationNo);
				Wait.waitfor(4);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (AuthorisationItemNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_AuthorisationItemNoLink, "Click on Authorisation Item No Link");
			try {
				Wait.waitfor(2);
				clickElement(driver, test, "(//td[contains(text(),'" + AuthorisationItemNo + "')])[2]",
						"Select the Authorisation Item No : " + AuthorisationItemNo);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(2);

				String alertmsg = "OK";

				try {
					if (alertmsg.equalsIgnoreCase("OK")) {
						clickElement(driver, test, "//span[contains(text(),'OK')]", "CLicking on OK :");
					} else {
						clickElement(driver, test, "//span[contains(text(),'Cancel')]", "Clicking on Cancel button :");
					}
				} catch (Exception e) {
					// testFailSshot(driver, test);
					test.log(LogStatus.INFO, "Added Auth item no");
				}

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}

		}

		if (InternalAuthNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_InternalAuthNoLink, "Click on Internal Auth No");
			try {
				typeText(driver, test, OCR_CNOItem_InternalAuthNoPopUp, "Enter the Internal Auth No : ",
						InternalAuthNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + InternalAuthNo + "')]",
						"Select the Internal Auth No : " + InternalAuthNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
		if (AuthorisationExpiryDate.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_AuthorisationExpiryDate, "Click on Authorisation Expiry Date");
			date(driver, test, "Select the Authorisation Expiry Date : ", AuthorisationExpiryDate);
		}
		if (MLCategoryCode.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_MLCategory, "Click on ML Category");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + MLCategoryCode + "')]",
						"Select the ML Category Code : " + MLCategoryCode);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		typeText(driver, test, OCR_CNOItem_EUSNo, "Enter the EUS No : ", EUSNo);
		selectByVisibleText(driver, test, "//select[@id='editInvoiceItem_invoiceItem_smeIndicator']",
				"Select the Indicator : ", SMEIndicator);
	}

	// clicking on Export authorization info label to verify transaction type of
	// DSP61 is IX
	public void addExportAuthorizationInfoUS() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNOItem_ExportAuthorizationInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ExportAuthorizationInformationLabel,
				"Click on Export Authorisation Information Label");
		Wait.waitfor(2);
		String transactionType = getText(driver, test, OCR_CNOItem_Regres_TransactionType,
				"Get the text of Transaction type :");

		try {
			if (transactionType.equalsIgnoreCase("IX")) {
				test.log(LogStatus.PASS, "The transaction type is IX : ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "The transaction type is not IX : ");
		}

	}

	// Adding the Additional Authorization
	public void addAdditionalAuthorization(String AdditionalAuthorisationNo, String AdditionalAuthorisationItemNo) {
		scrollToElement(driver, OCR_CNOItem_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_Save, "Click on Save in Items page");
		scrollToElement(driver, OCR_CNOItem_ExportAuthorisationInformationLabel);
		if (AdditionalAuthorisationNo.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_AdditionalAuthorisationLabel,
					"Click on Additional Authorisation Label");
			clickElement(driver, test, OCR_CNOItem_AddAdditionalAuthorisationBtn,
					"Click on Add Additional Authorisation");
			try {
				clickElement(driver, test, OCR_CNOItem_AA_AuthorisationNoLink, "Click on Additional Authorisation No");
				typeText(driver, test, OCR_CNOItem_AuthorisationNoPopUP, "Enter the Authorisation No : ",
						AdditionalAuthorisationNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalAuthorisationNo + "')]",
						"Select the Additional Authorisation No : " + AdditionalAuthorisationNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CNOItem_AA_AuthorisationItemNoLink,
						"Click on Additional Authorisation Item No Link");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalAuthorisationItemNo + "')]",
						"Select the Additional Authorisation item No : " + AdditionalAuthorisationItemNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CNOItem_AA_SaveBtn, "Click on Save button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
	}

	// Adding the Additional Authorization US
	public void addAdditionalAuthorizationUS(String AdditionalAuthorisationNo, String AdditionalAuthorisationItemNo) {
		scrollToElement(driver, OCR_CNOItem_Save);
		// scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_Save, "Click on Save in Items page");
		scrollToElement(driver, OCR_CNOItem_AdditionalAuthorizationInformationLabel);
		if (AdditionalAuthorisationNo.length() > 0) {
			// scrollToElement(driver, OCR_CNOItem_ExportAuthorizationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_AdditionalAuthorizationInformationLabel,
					"Click on Additional Authorisation Label");
			clickElement(driver, test, OCR_CNOItem_AddAdditionalAuthorisationBtn,
					"Click on Add Additional Authorisation");
			try {
				clickElement(driver, test, OCR_CNOItem_AA_AuthorisationNoLink, "Click on Additional Authorisation No");
				typeText(driver, test, OCR_CNOItem_AuthorisationNoPopUP, "Enter the Authorisation No : ",
						AdditionalAuthorisationNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalAuthorisationNo + "')]",
						"Select the Additional Authorisation No : " + AdditionalAuthorisationNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CNOItem_AA_AuthorisationItemNoLink,
						"Click on Additional Authorisation Item No Link");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalAuthorisationItemNo + "')]",
						"Select the Additional Authorisation item No : " + AdditionalAuthorisationItemNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CNOItem_AA_SaveBtn, "Click on Save button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
	}

	// Adding the Packing Information
	public void addPackingDetails(String HUNoContainerID, String HUNoSubLevel, String GrossWeight, String NetWeight,
			String Markings, String Dimensions, String NoOfPkgs, String AlternateUOM, String Skids, String Length,
			String Width, String Height, String Weight, String ExtendedWeight, String Factor, String Cubic) {
		scrollToElement(driver, OCR_CNOItem_AdditionalAuthorisationLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNOItem_PackingInformationLabel, "Click on Packing Information Label");
		typeText(driver, test, OCR_CNOItem_HUNoContainerId, "Enter the HUNo/ContainerId : ", HUNoContainerID);
		typeText(driver, test, OCR_CNOItem_HUNoSubLevel, "Enter the HU No Sub Level : ", HUNoSubLevel);
		typeText(driver, test, OCR_CNOItem_GrossWeight, "Enter the Gross Weight : ", GrossWeight);
		typeText(driver, test, OCR_CNOItem_NetWeight, "Enter the Net Weight : ", NetWeight);
		typeText(driver, test, OCR_CNOItem_Markings, "Enter the Markings : ", Markings);
		typeText(driver, test, OCR_CNOItem_Dimensions, "Enter the Dimensions : ", Dimensions);
		typeText(driver, test, OCR_CNOItem_NoOfPkgs, "Enter the No Of Pkgs : ", NoOfPkgs);
		typeText(driver, test, OCR_CNOItem_AlternateUOM, "Enter the Alternate UOM : ", AlternateUOM);
		typeText(driver, test, OCR_CNOItem_Skids, "Enter the Skids : ", Skids);
		typeText(driver, test, OCR_CNOItem_Length, "Enter the Length : ", Length);
		typeText(driver, test, OCR_CNOItem_Width, "Enter the Width : ", Width);
		typeText(driver, test, OCR_CNOItem_Height, "Enter the Height : ", Height);
		typeText(driver, test, OCR_CNOItem_Weight, "Enter the Weight : ", Weight);
		typeText(driver, test, OCR_CNOItem_ExtendedWeight, "Enter the Extended Weight : ", ExtendedWeight);
		typeText(driver, test, OCR_CNOItem_Factor, "Enter the Factor : ", Factor);
		typeText(driver, test, OCR_CNOItem_Cubic, "Enter the Cubic : ", Cubic);
	}

	// Adding the Multiple Packing Information
	public void addMultiplePackinges(String M_HUNoContainerId, String M_HUNoSubLevel, String M_GrossWeight,
			String M_NetWeight, String M_MarksAndNos, String M_Dimensions, String M_NoOfPkgs, String M_TypeOfPacking,
			String M_Skids, String M_Length, String M_Width, String M_Height, String M_Weight, String M_ExtendedWeight,
			String M_Factor, String M_Cubic, String M_QuantityUOM, String M_AlternateUOM) {
		clickElement(driver, test, OCR_CNOItem_MultiplePackageSwitch, "Click on Multiple Package Switch");
		clickElement(driver, test, OCR_CNOItem_PackingInformationLabel, "Click on Packing Information Label");
		clickElement(driver, test, OCR_CNOItem_MP_AddPackageBtn, "Click on Add Package");
		typeText(driver, test, OCR_CNOItem_MP_HUNoContainerId, "Enter the HUNo/ContainerId : ", M_HUNoContainerId);
		typeText(driver, test, OCR_CNOItem_MP_HUNoSubLevel, "Enter the HU No Sub Level : ", M_HUNoSubLevel);
		typeText(driver, test, OCR_CNOItem_MP_GrossWeight, "Enter the Gross Weight : ", M_GrossWeight);
		typeText(driver, test, OCR_CNOItem_MP_NetWeight, "Enter the Net Weight", M_NetWeight);
		typeText(driver, test, OCR_CNOItem_MP_MarksAndNos, "Enter the Marks And Nos : ", M_MarksAndNos);
		typeText(driver, test, OCR_CNOItem_MP_Dimensions, "Enter the Dimensions : ", M_Dimensions);
		typeText(driver, test, OCR_CNOItem_MP_NoOfPkgs, "Enter the No Of Pkgs : ", M_NoOfPkgs);
		typeText(driver, test, OCR_CNOItem_MP_TypeOfPacking, "Enter the Type Of Packing : ", M_TypeOfPacking);
		typeText(driver, test, OCR_CNOItem_MP_Skids, "Enter the Skids : ", M_Skids);
		typeText(driver, test, OCR_CNOItem_MP_Length, "Enter the Length : ", M_Length);
		typeText(driver, test, OCR_CNOItem_MP_Width, "Enter the Width : ", M_Width);
		typeText(driver, test, OCR_CNOItem_MP_Height, "Enter the Height : ", M_Height);
		typeText(driver, test, OCR_CNOItem_MP_Weight, "Enter the Weight : ", M_Weight);
		typeText(driver, test, OCR_CNOItem_MP_ExtendedWeight, "Enter the Extended Weight : ", M_ExtendedWeight);
		typeText(driver, test, OCR_CNOItem_MP_Factor, "Enter the Factor : ", M_Factor);
		typeText(driver, test, OCR_CNOItem_MP_Cubic, "Enter the Cubic : ", M_Cubic);
		typeText(driver, test, OCR_CNOItem_MP_QuantityUOM, "Enter the Quantity UOM : ", M_QuantityUOM);
		typeText(driver, test, OCR_CNOItem_MP_AlternateUOM, "Enter the Alternate UOM : ", M_AlternateUOM);
		clickElement(driver, test, OCR_CNOItem_MP_SaveBtn, "Click on Add Package Save button");
	}

	// Adding the Batch Information
	public void addBatchInfo(String BatchNumber, String BatchInfoCountryOfOrigin, String BatchInfoQuantity,
			String BatchInfoExpiryDate, String BatchInfoSterilityDate) {
		// Wait.waitfor(2);
		// scrollToElement(driver, OCR_CNOItem_Save);
		// scrollToTop(driver);
		// Wait.waitfor(2);
		// clickElement(driver, test, OCR_CNOItem_Save, "Click on Save in Items page");
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNOItem_PackingInformationLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNOItem_BatchInformationLabel, "Click on Batch Information Label");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNOItem_AddBatchInfo, "Click on Add Batch Info");
		typeText(driver, test, OCR_CNOItem_BatchInfo_BatchNumber, "Enter the Batch Number : ", BatchNumber);
		typeText(driver, test, OCR_CNOItem_BatchInfo_CountryOfOrigin, "Enter the Batch Info Country Of Origin : ",
				BatchInfoCountryOfOrigin);
		typeText(driver, test, OCR_CNOItem_BatchInfo_Quantity, "Enter the Batch Info Quantity : ", BatchInfoQuantity);
		clickElement(driver, test, OCR_CNOItem_BatchInfo_ExpiryDate, "Click on Batch Info Expiry Date");
		date(driver, test, "Select the Batch Info Expiry Date : ", BatchInfoExpiryDate);
		clickElement(driver, test, OCR_CNOItem_BatchInfo_SterilityDate, "Click on Batch Info Sterility Date");
		date(driver, test, "Select the Batch Info Sterility Date : ", BatchInfoSterilityDate);
		clickElement(driver, test, OCR_CNOItem_BatchInfo_Submit, "Click on Batch info Submit");
	}

	// Adding the Re-Export Information
	public void addReExportInfo(String ImportShipmentType, String InbondCode, String EntryNo, String ItemNO,
			String ImportIdentificationNo, String RateofYield, String ReliefAuthorizationNo) {
		scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ReExportInformationLabel, "Click on Re Export Information Label");
		selectByVisibleText(driver, test, OCR_CNOItem_ImportShipmentType, "Selct the Import Shipment Type : ",
				ImportShipmentType);
		if (InbondCode.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_InbondTypeLink, "Click on Inbond Type Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + InbondCode + "')]",
						"Select the Inbond Code : " + InbondCode);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (EntryNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
			clickElement(driver, test, OCR_CNOItem_EntryImportInvoiceNoLink, "Enter the Entry Import Invoice No Link");
			try {
				typeText(driver, test, OCR_CNOItem_EntryNo, "Enter the Entry NO : ", EntryNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				Wait.waitfor(4);
				clickElement(driver, test, "//td[contains(text(),'" + EntryNo + "')]",
						"Select the EntryNo : " + EntryNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
			scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
			clickElement(driver, test, OCR_CNOItem_ItemNoLink, "Click on Item NO link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ItemNO + "')]", "Select the ItemNO : " + ItemNO);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (ImportIdentificationNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
			clickElement(driver, test, OCR_CNOItem_ImportIdentificationNoLink,
					"Click on Import Identification No Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ImportIdentificationNo + "')]",
						"Select the ImportIdentificationNo : " + ImportIdentificationNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		typeText(driver, test, OCR_CNOItem_RateofYield, "Enter the Rate of Yield : ", RateofYield);

	}

	// Adding the Re-Export Information
	public void addReExportInfo(String ImportShipmentType, String InbondCode, String EntryNo, String ItemNO,
			String RelDueDate) {
		scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ReExportInformationLabel, "Click on Re Export Information Label");
		selectByVisibleText(driver, test, OCR_CNOItem_ImportShipmentType, "Selct the Import Shipment Type : ",
				ImportShipmentType);
		if (InbondCode.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_InbondTypeLink, "Click on Inbond Type Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + InbondCode + "')]",
						"Select the Inbond Code : " + InbondCode);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (EntryNo.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
			clickElement(driver, test, OCR_CNOItem_EntryImportInvoiceNoLink, "Enter the Entry Import Invoice No Link");
			try {
				typeText(driver, test, OCR_CNOItem_EntryNo, "Enter the Entry NO : ", EntryNo);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + EntryNo + "')]",
						"Select the EntryNo : " + EntryNo);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
			scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
			clickElement(driver, test, OCR_CNOItem_ItemNoLink, "Click on Item NO link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ItemNO + "')]", "Select the ItemNO : " + ItemNO);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (RelDueDate.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_Regres_DutyReliefDueDate);
			clickElement(driver, test, OCR_CNOItem_Regres_DutyReliefDueDate, "Click on Due Date");
			Wait.waitfor(2);
			date(driver, test, "Select the Due Date : ", RelDueDate);
			Wait.waitfor(2);
		}

	}

	// Notes for Regression US
	public void notes(String PackNote, String ContractNote, String OracleAttachment, String DelAttachment) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNOItem_Regres_NotesLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNOItem_Regres_NotesLabel, "Click on Notes Label");
		typeText(driver, test, OCR_CNOItem_Regres_PackingNote, "Enter Packing Notes : ", PackNote);
		Wait.waitfor(2);
		typeText(driver, test, OCR_CNOItem_Regres_ContractLineNote, "Enter Contract Notes : ", ContractNote);
		Wait.waitfor(2);
		typeText(driver, test, OCR_CNOItem_Regres_OracleAttachment, "Enter Oracle Attachment : ", OracleAttachment);
		Wait.waitfor(2);
		typeText(driver, test, OCR_CNOItem_Regres_DeliveryAttachment, "Enter Delivery Attachment : ", DelAttachment);
		Wait.waitfor(2);

	}

	// Adding Duty Relief Info for Invoice-Shipment for Regression US
	public void enter_DutyReliefDetails(String dutyReliefAuth, String dutyReliefType) {
		scrollToElement(driver, OCR_CNOItem_ReExportInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ReExportInformationLabel, "Click on Re Export Information Label");
		if (dutyReliefAuth.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_Regres_DutyReliefAuthNo,
					"Click on Duty Relief Authorization  Number Link :");
			typeText(driver, test, OCR_CNOItem_Regres_EnterDutyReliefAuthNo,
					"Enter Duty Relief Authorization Number : ", dutyReliefAuth);
			clickElement(driver, test, OCR_CNOItem_Regres_DutyReliefAUthSearchBtn, "Click on Search Button :");
			clickElement(driver, test, "(//td[@aria-describedby='gridPopup_reliefAuthNo'])[1]",
					"Click on Duty Relief AUthorization Number :" + dutyReliefAuth);
			clickElement(driver, test, OCR_CNOItem_Regres_DutyReliefAUthSelectBtn, "Click on Select button :");
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_CNOItem_Regres_ReliefActivityType, "Select Duty Relief Type : ",
					dutyReliefType);
			scrollToTop(driver);
			scrollToElement(driver, OCR_CNOItem_Regres_SaveReturnBtn);
			clickElement(driver, test, OCR_CNOItem_Regres_SaveReturnBtn, "Click on Save & Return Button :");
		}
	}
	/*
	 * if (ReliefAuthorizationNo.length() > 0) { clickElement(driver, test,
	 * OCR_CNOItem_ReliefAuthorizationNoLink,
	 * "Click on Relief Authorization No Link"); try { typeText(driver, test,
	 * OCR_CNOItem_ReliefAuthorizationNo, "Enter the Relief Authorization No : ",
	 * ReliefAuthorizationNo); clickElement(driver, test,
	 * OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
	 * clickElement(driver, test, "//td[contains(text(),'" + ReliefAuthorizationNo +
	 * "')]", "Select the Relief Authorization No : " + ReliefAuthorizationNo);
	 * clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
	 * } catch (Exception e) { testFailSshot(driver, test); clickElement(driver,
	 * test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon"); } }
	 * 
	 * clickElement(driver, test, OCR_CNOItem_ReliefAuthItemNoLink,
	 * "Click on Relief Auth. Item No Link");
	 */

	// Select the Hazmat Details
	public void select_HazmatDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CNOItem_AdditionalTransactionDetails, "Click on Addtional Transaction Details");
		clickElement(driver, test, OCR_CNOItem_HazmatDetails, "Click on Hazmat Details");
	}

	// Select the Subcomponent
	public void select_SubComponent() {
		scrollToTop(driver);
		clickElement(driver, test, "//input[@id='editInvoiceItem_invoiceItem_unIdNo']", "");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNOItem_AdditionalTransactionDetails, "Click on Addtional Transaction Details");
		clickElement(driver, test, OCR_CNOItem_SubComponent, "Click on Sub Component");
	}

	// validating the item details
	public void validateItemDetails() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Product Description (General Information) is requi')]")) {
					test.log(LogStatus.INFO, "Product Description (General Information) is required.");
				}
				if (isDisplayed(driver,
						"//li[contains(text(),'Invoice unit of quantity (Quantity & Pricing Infor')]")) {
					test.log(LogStatus.INFO, "Invoice unit of quantity (Quantity & Pricing Information) is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Item Unit Price is required.')]")) {
					test.log(LogStatus.INFO, "Item Unit Price is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Create new Order Item page");
		}
	}

	// validating the country of origin
	public String validateCountryOfOrigin() {
		return getSelectFirstText(driver, test, OCR_CNOItem_CountryOriginDropDown,
				"Auto populate the Country of Origin as : ");
	}

	// validate the customs filing Export Classification
	public String validateCustomsExportClassfictn() {
		scrollToElement(driver, "//font[contains(text(),'Customs Filing Information')]");
		Wait.waitfor(2);
		clickElement(driver, test, "//font[contains(text(),'Customs Filing Information')]",
				"click on customs filing Tab");
		return getText(driver, test, "//table[@class='table table-bordered table-condensed']/tbody/tr/td[2]",
				"Getting the Export Classifations in Customs Filing Tab : ");
	}

	// validate the customs filing Export Authorisation
	public String validateCustomsExportAuth() {
		return getText(driver, test, "//table[@class='table table-bordered table-condensed']/tbody/tr/td[3]",
				"Getting the Export Authorisation in Customs Filing Tab : ");
	}

	// validate the customs filing Quantity / Units
	public String validateQuantityUnits() {
		return getText(driver, test, "//table[@class='table table-bordered table-condensed']/tbody/tr/td[6]",
				"Getting the Quantity/ Units in Customs Filing Tab : ");
	}

	// Validate the total Statistical Value
	public String validateTotalStatisticalValue() {
		return getAttribute(driver, test, "//input[@id='editInvoiceItem_invoiceItem_sedValue']", "value",
				"Getting the Total Statistical value in Customs Filing Tab : ");
	}

	// Getting the value of Export classifications
	public String getExportClassfictn() {
		return getAttribute(driver, test, "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']", "value",
				"Getting the Export Classification : ");
	}

	// Getting the Autorization No
	public String getAutorizationNo() {
		return getAttribute(driver, test, "//input[@id='editInvoiceItem_invoiceItem_licenseNo']", "value",
				"Getting the Authorization No : ");
	}

	// Getting the Quantity and Units
	public String getQuantityUnits() {
		return getText(driver, test, "//span[@id='qtyInfo']", "Getting the Quantity and Units : ");
	}

	// Getting the total Statistical Value
	public String getTotalStatisticalValue() {
		return getText(driver, test, "//span[@id='totPriceInfo']", "Getting the Total Statistical value : ");
	}

	// Getting the Export Authorization from Export Control Screening
	public String getExportAuth() {
		return getText(driver, test, "//table[@class='table table-striped table-bordered table-condensed']//tr/td[4]",
				"Getting the Export Authorization from Export Control Screening : ");
	}

	// Getting the Screening Determinations
	public String getScreeningDetermination() {
		return getText(driver, test, "//table[@class='table table-striped table-bordered table-condensed']//tr/td[5]",
				"Getting the Screening Determination: ");
	}

	// Getting the Export Authorization from Export Control Screening
	public String getAdditionalExportAuthorization() {
		return getText(driver, test, "//table[@class='table table-striped table-bordered table-condensed']//tr/td[6]",
				"Getting the Additional Export Authorization from Export Control Screening : ");
	}

	// Getting the Additional Screening Determination
	public String getAdditionalScreeningDetermination() {
		return getText(driver, test, "//table[@class='table table-striped table-bordered table-condensed']//tr/td[7]",
				"Getting the Additional Screening Determination : ");
	}

	// Click on Export Authorisation Screening Status Icon Green
	public void click_ExportAuthScreeningIconGreen() {
		try {
			clickElement(driver, test, OCR_CNOItem_ExportAuthScreeningIconGreen,
					"Click on Export Authorisation Screening Status Icon Green");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Export Authorisation Screening Status Icon RED");
		}
	}

	// Click on Export Authorisation Screening Status Icon Red
	public void click_ExportAuthScreeningIconRed() {
		try {
			clickElement(driver, test, OCR_CNOItem_ExportAuthScreeningIconRed,
					"Click on Export Authorisation Screening Status Icon Red");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Export Authorisation Screening Status Icon Green");
		}
	}

	// Click on close button
	public void click_PopUpClose() {
		clickElement(driver, test, "//div[@id='view-single-hit']//button[@class='close']", "click on pop up close");
		Wait.waitfor(3);
	}

	// Adding the mandatory fields in Item details part
	public void itemDetailsMandatory(String ProductDescription, String CustomsInvoiceQuantity, String QuantityUOM,
			String ItemUnitPrice) {
		typeText(driver, test, OCR_CNOItem_ProductDescription, "Enter the Product Description : ", ProductDescription);
		scrollToElement(driver, OCR_CNOItem_Remarks);
		clickElement(driver, test, OCR_CNOItem_QuantityPricingInformationLabel,
				"Click on Quantity Pricing Information Label");
		typeText(driver, test, OCR_CNOItem_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ",
				CustomsInvoiceQuantity);
		typeText(driver, test, OCR_CNOItem_QuantityUOM, "Enter the Quantity UOM : ", QuantityUOM);
		typeText(driver, test, OCR_CNOItem_ItemUnitPrice, "Enter the Item Unit Price : ", ItemUnitPrice);
	}

	// Get the Export Authorization Screening Status
	public String getStatus() {
		return getText(driver, test, "//td[contains(text(),'No License Required')]", "Getting the Status :");
	}

	// Search and Select part No
	public void searchpartNo(String PartNo) {
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_Regres_PartNoLink, "Click on Part No link");
			try {
				typeText(driver, test, OCR_CNOItem_Regres_EnterpartNo, "Enter the Part No : ", PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CNOItem_Regres_SearchpartNo, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Select the PartNo : " + PartNo);
				clickElement(driver, test, OCR_CNOItem_Regres_SelectpartNo, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_Regres_ClosepartNo, "Click on Cancel popup icon");
			}
		}
	}

	// Error message validation AES : amar
	public String InvaildAgencyError() {
		return getText(driver, test,
				"//span[contains(text(),'Selected Controlling Agency is not valid for AES submission.')]",
				"Getting Error Message : ");
	}

	// Enter Export classification by Type text : amar 47
	public void ExportClassification(String ControllingAgencycode, String ExportClassificationItem,
			String HtsAndPrimaryUMO) {

		scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ClassificationInformationLabel,
				"Click on Classifaction Information label");
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_controllingAgency']",
				"Enter Controlling Agen :", ControllingAgencycode);
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']", "Enter ECCN CODE : ",
				ExportClassificationItem);
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']", "Enter HTS NO :",
				HtsAndPrimaryUMO);
	}

	// Enter Vaild ECCN FOR AES : amar 47
	public void ExportClassificationWithoutVal(String ControllingAgencycode1, String ExportClassificationItem1,
			String HtsAndPrimaryUMO1) {
		scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ClassificationInformationLabel,
				"Click on Classifaction Information label");
		clearText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_controllingAgency']",
				"Clear Controlling Agency :");
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_controllingAgency']",
				"Enter Controlling Agen :", ControllingAgencycode1);
		clearText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']", "Clear ECCN :");
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']", "Enter ECCN CODE : ",
				ExportClassificationItem1);
		clearText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']", "Clear hts no :");
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']", "Enter HTS NO :",
				HtsAndPrimaryUMO1);
	}

	// Click on Export Authorization Label
	public void clickExportAuthLabel() {
		scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ExportAuthorizationInformationLabel,
				"Click on Export Authorisation Information Label");
	}
	
	//get the USML Category
	public String getUSMLCategory() {
		return getText(driver, test, "//input[@name='invoiceItem.usmlCategoryCode']", "Getting the USML Category Name :");
	}
	
	//Validation For USML Category
	public void usmlValidation() {
		try {
			if(isDisplayed(driver, getUSMLCategory())){
				test.log(LogStatus.PASS, "USML Category is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "USML Category is Not Displayed :");
		}
		
	}
	
	//DDTC Number and ITAR Exception
	public void ddtcNumberITARException(String DDTCNumber, String ITARException) {
		typeText(driver, test, OCR_CNOItem_Regres_DDTCNumber, "Entering DDTC Number :", DDTCNumber);
		if (ITARException.length() > 0) {
			scrollToElement(driver, OCR_CNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_CNOItem_ITARException, "Click on ITAR Exception Link :");
			try {
				typeText(driver, test, OCR_CNOItem_AuthorizationType, "Enter the ITAR Exception Type No : ",
						ITARException);
				clickElement(driver, test, OCR_CNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + ITARException + "')]",
						"Select the Internal Auth No : " + ITARException);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
	}
	
	//Click on Classification Information Label
	public void classificationInformationLabel() {
		scrollToElement(driver, OCR_CNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ClassificationInformationLabel,
				"Click on Classifaction Information label");
	}
	
	//Get HTS/Schedule B Unit Of Measure
	public String getUnitOfMeasure() {
		return getTextfromTextbox(driver, test, "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']", "Getting the HTS/Schedule B Unit Of Measure :");
	}
	
	//Add Entry No
	public void entryNumber(String importShipmentType, String inbondCode, String entryNo) {
		scrollToElement(driver, OCR_CNOItem_BatchInformationLabel);
		clickElement(driver, test, OCR_CNOItem_ReExportInformationLabel, "Click on Re Export Information Label");
		selectByVisibleText(driver, test, OCR_CNOItem_ImportShipmentType, "Selct the Import Shipment Type : ",
				importShipmentType);
		if (inbondCode.length() > 0) {
			clickElement(driver, test, OCR_CNOItem_InbondTypeLink, "Click on Inbond Type Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + inbondCode + "')]",
						"Select the Inbond Code : " + inbondCode);
				clickElement(driver, test, OCR_CNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (entryNo.length() > 0) {
			typeText(driver, test, OCR_CNOItem_EntryNotextbox, "Enter the Entry NO : ", entryNo);
			}
	}
	
	// Getting the Line Item No Required Error Msg
	public String lineItemNoError() {
		return getText(driver, test,"//span[contains(text(),'License Item No is required.')]","Getting the Line item No Required Error Message : ");
	}
	
	//Validating the Line Item No Required Error Msg
	public void lineItemNoErrorValidation() {
		try {
			if(isDisplayed(driver, lineItemNoError())) {
				test.log(LogStatus.PASS, "Line Item No Required Error Msg is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Line Item No Required Error Msg is Not Displayed :");
		}
	}

}