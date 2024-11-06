package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DeliveryOrderCreateNewOrderItemPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DOCNOItem_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_DOCNOItem_HazmatDetails = "//a[contains(text(),'Hazmat Details')]";
	public static final String OCR_DOCNOItem_SubComponent = "//a[contains(text(),'Sub Component')]";
	public static final String OCR_DOCNOItem_Save = "//button[@id='saveSubmitBtn']";
	public static final String OCR_DOCNOItem_SaveAndReturn = "//button[@id='saveAndReturnInvoiceItem']";
	public static final String OCR_DOCNOItem_Close = "//button[@id='cancelInvoiceItem']";
	public static final String OCR_DOCNOItem_PartNoLink = "//a[@id='partno-popup']";
	public static final String OCR_DOCNOItem_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_DOCNOItem_SearchBtn = "//div[@id='searchDIV']//button[2]";
	public static final String OCR_DOCNOItem_ClassificationInfoSearchBtn = "//div[@id='searchDIV']//button[1]";
	public static final String OCR_DOCNOItem_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_DOCNOItem_ClosePopUp = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_DOCNOItem_SourceSystemPartNumber = "//input[@id='editInvoiceItem_invoiceItem_sourceSystemPart']";
	public static final String OCR_DOCNOItem_ProductDescription = "//textarea[@id='editInvoiceItem_invoiceItem_description']";
	public static final String OCR_DOCNOItem_SerialNumbers = "//textarea[@id='editInvoiceItem_invoiceItem_serialNo']";
	public static final String OCR_DOCNOItem_PONumber = "//input[@id='editInvoiceItem_invoiceItem_poNumber']";
	public static final String OCR_DOCNOItem_CustomerPartNumber = "//input[@id='editInvoiceItem_invoiceItem_custPartNo']";
	public static final String OCR_DOCNOItem_SalesOrderNo = "//input[@id='editInvoiceItem_invoiceItem_salesOrderNo']";
	public static final String OCR_DOCNOItem_SalesOrderItemNo = "//input[@id='editInvoiceItem_invoiceItem_salesOrderItemNo']";
	public static final String OCR_DOCNOItem_DeliveryOrderNo = "//input[@id='editInvoiceItem_invoiceItem_deliveryOrderNo']";
	public static final String OCR_DOCNOItem_DeliveryOrderItemNo = "//input[@id='editInvoiceItem_invoiceItem_deliveryOrderItemNo']";
	public static final String OCR_DOCNOItem_ManufacturerLink = "//a[@id='getManufacturer']";
	public static final String OCR_DOCNOItem_Manufacturer = "//input[@id='editInvoiceItem_invoiceItem_manufacturer']";
	public static final String OCR_DOCNOItem_CountryOfOrigin = "//input[@id='cooName']";
	public static final String OCR_DOCNOItem_CountryOriginDropDown = "//select[@id='editInvoiceItem_invoiceItem_domesticForeign']";
	public static final String OCR_DOCNOItem_FTAApplicable = "//select[@id='editInvoiceItem_invoiceItem_naftaReportable']";
	public static final String OCR_DOCNOItem_NetworkOrderNumber = "//input[@id='editInvoiceItem_invoiceItem_orderNetworkNo']";
	public static final String OCR_DOCNOItem_EngineLine = "//input[@id='editInvoiceItem_invoiceItem_engineLine']";
	public static final String OCR_DOCNOItem_MTFNumber = "//input[@id='editInvoiceItem_invoiceItem_mtfNo']";
	public static final String OCR_DOCNOItem_Remarks = "//textarea[@id='editInvoiceItem_invoiceItem_itemsRemarks']";
	public static final String OCR_DOCNOItem_QuantityPricingInformationLabel = "//font[contains(text(),'Quantity & Pricing Information')]";
	public static final String OCR_DOCNOItem_CustomsInvoiceQuantity = "//input[@id='primaryNetQuantity']";
	public static final String OCR_DOCNOItem_QuantityUOM = "//input[@id='editInvoiceItem_invoiceItem_invoiceUnitOfQuantity']";
	public static final String OCR_DOCNOItem_ItemUnitPrice = "//input[@id='editInvoiceItem_invoiceItem_prodUnitPrice']";
	public static final String OCR_DOCNOItem_ItemUnitPriceCurrency = "//input[@id='editInvoiceItem_invoiceItem_itemCurrency']";
	public static final String OCR_DOCNOItem_RepairValue = "//input[@id='editInvoiceItem_invoiceItem_repairValue']";
	public static final String OCR_DOCNOItem_DiscountRate = "//input[@id='editInvoiceItem_invoiceItem_discount']";
	public static final String OCR_DOCNOItem_WholesaleRate = "//input[@id='editInvoiceItem_invoiceItem_wholesaleRate']";
	public static final String OCR_DOCNOItem_ClassificationInformationLabel = "//font[contains(text(),'Classification Information')]";
	public static final String OCR_DOCNOItem_ControllingAgencyLink = "//a[@id='controllingAgency-Popup']";
	public static final String OCR_DOCNOItem_ExportClassificationLink = "(//a[contains(text(),'Export Classification')])[1]";
	public static final String OCR_DOCNOItem_ExportClassificationItem = "//input[@id='searchForm_ukItemsDTO_prodClassification']";
	public static final String OCR_DOCNOItem_HTSPrimaryUOM = "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']";
	public static final String OCR_DOCNOItem_SecondaryCustomsQuantityUOMLink = "//a[contains(text(),'& UOM')]";
	public static final String OCR_DOCNOItem_SecondaryCustomsQuantity = "//input[@id='editInvoiceItem_invoiceItem_secondaryNetQuantity']";
	public static final String OCR_DOCNOItem_SCQ_UOM = "//input[@id='editInvoiceItem_invoiceItem_secondaryUnit']";
	public static final String OCR_DOCNOItem_ImportHTSUOMLink = "//a[@id='htsImportPopup']";
	public static final String OCR_DOCNOItem_ImportHTS = "//input[@id='editInvoiceItem_invoiceItem_importHts']";
	public static final String OCR_DOCNOItem_ImportUOM = "//input[@id='editInvoiceItem_invoiceItem_importUnit']";
	public static final String OCR_DOCNOItem_USExportClassificationLink = "//a[@id='productClass-us-Popup']";
	public static final String OCR_DOCNOItem_USExportClassificationECCN = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_DOCNOItem_StatisticalCodeLink = "//a[@id='statisticalPopup']";
	public static final String OCR_DOCNOItem_StatisticalCode = "//input[@id='editInvoiceItem_invoiceItem_schBORStatisticalCode']";
	public static final String OCR_DOCNOItem_ClassificationInformationSave = "//button[@id='saveFromClassBlock']";
	public static final String OCR_DOCNOItem_CIApplyAuthorization = "//button[@id='applyExport']";
	public static final String OCR_DOCNOItem_ExportAuthorisationInformationLabel = "//font[contains(text(),'Export Authorisation Information')]";
	public static final String OCR_DOCNOItem_BISLicenseExceptionLink = "//a[contains(text(),'BIS License Exception')]";
	public static final String OCR_DOCNOItem_AuthorisationNoLink = "//a[@id='licenseNo-Popup']";
	public static final String OCR_DOCNOItem_AuthorisationItemNoLink = "//a[@id='licenseItemNo']";
	public static final String OCR_DOCNOItem_InternalAuthNoLink = "//a[contains(text(),'Internal Auth. No.')]";
	public static final String OCR_DOCNOItem_InternalAuthNoPopUp = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_DOCNOItem_InternalAuthItemNoLink = "//a[@id='internalAuthorizationItemNo']";
	public static final String OCR_DOCNOItem_AuthorisationTypeLink = "//a[@id='licenseType-Popup']";
	public static final String OCR_DOCNOItem_AuthorisationNoPopUP = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_DOCNOItem_EAI_TransactionTypeLink = "(//a[contains(text(),'Transaction Type')])[2]";
	public static final String OCR_DOCNOItem_AuthorisationExpiryDate = "//input[@id='editInvoiceItem_licenseDate']";
	public static final String OCR_DOCNOItem_MLCategory = "//a[contains(text(),'ML Category')]";
	public static final String OCR_DOCNOItem_EUSNo = "//input[@id='editInvoiceItem_invoiceItem_eusLicense']";
	public static final String OCR_DOCNOItem_AdditionalAuthorisationLabel = "//font[contains(text(),'Additional Authorisation')]";
	public static final String OCR_DOCNOItem_AddAdditionalAuthorisationBtn = "//button[@id='addAuthorisation']";
	public static final String OCR_DOCNOItem_AA_AuthorisationNoLink = "//a[@id='licenseNo-Popup-authorisation']";
	public static final String OCR_DOCNOItem_AA_AuthorisationItemNoLink = "//a[@id='licenseItemNo-authorisation']";
	public static final String OCR_DOCNOItem_AA_SaveBtn = "//button[@name='Save']";
	public static final String OCR_DOCNOItem_PackingInformationLabel = "//font[contains(text(),'Packing Information')]";
	public static final String OCR_DOCNOItem_HUNoContainerId = "//input[@id='invoiceItem.huNum']";
	public static final String OCR_DOCNOItem_HUNoSubLevel = "//input[@id='invoiceItem.huSubLevel']";
	public static final String OCR_DOCNOItem_GrossWeight = "//input[@id='editInvoiceItem_invoiceItem_grossWeight']";
	public static final String OCR_DOCNOItem_NetWeight = "//input[@id='editInvoiceItem_invoiceItem_netWeight']";
	public static final String OCR_DOCNOItem_TotalNetWeight = "//input[@id='editInvoiceItem_totalNetWt']";
	public static final String OCR_DOCNOItem_Markings = "//input[@id='editInvoiceItem_invoiceItem_marksAndNos']";
	public static final String OCR_DOCNOItem_Dimensions = "//input[@id='editInvoiceItem_invoiceItem_dimensions']";
	public static final String OCR_DOCNOItem_NoOfPkgs = "//input[@id='editInvoiceItem_invoiceItem_noOfPackages']";
	public static final String OCR_DOCNOItem_AlternateUOM = "//input[@id='editInvoiceItem_invoiceItem_alternateUom']";
	public static final String OCR_DOCNOItem_Skids = "//input[@id='editInvoiceItem_invoiceItem_skids']";
	public static final String OCR_DOCNOItem_Length = "//input[@id='editInvoiceItem_invoiceItem_length']";
	public static final String OCR_DOCNOItem_Width = "//input[@id='editInvoiceItem_invoiceItem_width']";
	public static final String OCR_DOCNOItem_Height = "//input[@id='editInvoiceItem_invoiceItem_height']";
	public static final String OCR_DOCNOItem_Weight = "//input[@id='editInvoiceItem_invoiceItem_weight']";
	public static final String OCR_DOCNOItem_ExtendedWeight = "//input[@id='editInvoiceItem_invoiceItem_extendedWeight']";
	public static final String OCR_DOCNOItem_Factor = "//input[@id='editInvoiceItem_invoiceItem_factor']";
	public static final String OCR_DOCNOItem_Cubic = "//input[@id='editInvoiceItem_invoiceItem_cubic']";
	public static final String OCR_DOCNOItem_MultiplePackageSwitch = "//div[@class='hRow']//div//div[@class='lcs_cursor']";
	public static final String OCR_DOCNOItem_MP_AddPackageBtn = "//button[@id='addPackingDetail']";
	public static final String OCR_DOCNOItem_MP_HUNoContainerId = "//input[@id='packingDetail.huNum']";
	public static final String OCR_DOCNOItem_MP_HUNoSubLevel = "//input[@id='packingDetail.huSubLevel']";
	public static final String OCR_DOCNOItem_MP_GrossWeight = "//input[@id='packingDetailForm_packingDetail_grossWeight']";
	public static final String OCR_DOCNOItem_MP_NetWeight = "//input[@id='packingDetailForm_packingDetail_netWeight']";
	public static final String OCR_DOCNOItem_MP_MarksAndNos = "//input[@id='packingDetailForm_packingDetail_marksAndNo']";
	public static final String OCR_DOCNOItem_MP_Dimensions = "//input[@id='packingDetailForm_packingDetail_dimensions']";
	public static final String OCR_DOCNOItem_MP_NoOfPkgs = "//input[@id='packingDetailForm_packingDetail_noOfPackages']";
	public static final String OCR_DOCNOItem_MP_TypeOfPacking = "//input[@id='packingDetailForm_packingDetail_typeOfPackDesc']";
	public static final String OCR_DOCNOItem_MP_Skids = "//input[@id='packingDetailForm_packingDetail_skids']";
	public static final String OCR_DOCNOItem_MP_Length = "//input[@id='packingDetailForm_packingDetail_length']";
	public static final String OCR_DOCNOItem_MP_Width = "//input[@id='packingDetailForm_packingDetail_width']";
	public static final String OCR_DOCNOItem_MP_Height = "//input[@id='packingDetailForm_packingDetail_height']";
	public static final String OCR_DOCNOItem_MP_Weight = "//input[@id='packingDetailForm_packingDetail_weight']";
	public static final String OCR_DOCNOItem_MP_ExtendedWeight = "//input[@id='packingDetailForm_packingDetail_extendedWeight']";
	public static final String OCR_DOCNOItem_MP_Factor = "//input[@id='packingDetailForm_packingDetail_factor']";
	public static final String OCR_DOCNOItem_MP_Cubic = "//input[@id='packingDetailForm_packingDetail_cubic']";
	public static final String OCR_DOCNOItem_MP_QuantityUOM = "//input[@id='packingDetailForm_packingDetail_primaryNetQuantity']";
	public static final String OCR_DOCNOItem_MP_AlternateUOM = "//input[@id='packingDetailForm_packingDetail_alternateUom']";
	public static final String OCR_DOCNOItem_MP_SaveBtn = "//button[@name='Save']";
	public static final String OCR_DOCNOItem_BatchInformationLabel = "//font[contains(text(),'Batch Information')]";
	public static final String OCR_DOCNOItem_AddBatchInfo = "//button[@id='addBatch']";
	public static final String OCR_DOCNOItem_BatchInfo_BatchNumber = "//input[@id='editBatchHeader_batchDetailValue_batchNo']";
	public static final String OCR_DOCNOItem_BatchInfo_CountryOfOrigin = "//input[@id='editBatchHeader_']";
	public static final String OCR_DOCNOItem_BatchInfo_Quantity = "//input[@id='editBatchHeader_batchDetailValue_batchPrimaryQty']";
	public static final String OCR_DOCNOItem_BatchInfo_ExpiryDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark1']";
	public static final String OCR_DOCNOItem_BatchInfo_SterilityDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark2']";
	public static final String OCR_DOCNOItem_BatchInfo_Submit = "//button[@id='save']";
	public static final String OCR_DOCNOItem_CustomsFilingInformationLabel = "//font[contains(text(),'Customs Filing Information')]";
	public static final String OCR_DOCNOItem_ReExportInformationLabel = "//font[contains(text(),'Re-Export Information')]";
	public static final String OCR_DOCNOItem_ImportShipmentType = "//select[@id='editInvoiceItem_invoiceItem_impInvoiceType']";
	public static final String OCR_DOCNOItem_InbondTypeLink = "//a[contains(text(),'Inbond Type')]";
	public static final String OCR_DOCNOItem_EntryImportInvoiceNoLink = "//a[@id='impInvoice-Popup']";
	public static final String OCR_DOCNOItem_EntryNo = "//input[@id='resultEntryPopupData_import7501DetailsDTO_entryNo']";
	public static final String OCR_DOCNOItem_ItemNoLink = "//a[@id='itemNo']";
	public static final String OCR_DOCNOItem_ImportIdentificationNoLink = "//a[@id='importIdentityNo']";
	public static final String OCR_DOCNOItem_RateofYield = "//input[@id='editInvoiceItem_invoiceItem_rateOfYield']";
	public static final String OCR_DOCNOItem_ReliefAuthorizationNoLink = "//a[contains(text(),'Relief Authorization No.')]";
	public static final String OCR_DOCNOItem_ReliefAuthorizationNo = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_DOCNOItem_ReliefAuthItemNoLink = "//input[@id='editInvoiceItem_invoiceItem_reliefAuthItemNo']";
	public static final String OCR_DOCNOItem_ExportAuthScreeningIconGreen = "//i[@class='fa fa-check-circle green']";
	public static final String OCR_DOCNOItem_ExportAuthScreeningIconRed = "//i[@class='fa fa-exclamation-circle red']";

	/* ******************************* Constructor ****************************** */

	public DeliveryOrderCreateNewOrderItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Save Button
	public void click_SaveBtn() {
		scrollToElement(driver, OCR_DOCNOItem_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_DOCNOItem_Save, "Click on Save Butoon in order items");
	}

	// Click on Save And Return
	public void click_SaveAndReturn() {
		scrollToElement(driver, OCR_DOCNOItem_SaveAndReturn);
		scrollToTop(driver);
		clickElement(driver, test, OCR_DOCNOItem_SaveAndReturn, "Click on Save And Return");
	}

	// Click on Close
	public void click_Close() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_DOCNOItem_Close, "Click on Close");
	}

	// Adding the General information details
	public void AddGeneralInformation(String PartNo, String SourceSystemPartNumber, String SerialNumbers,
			String PONumber, String CustomerPartNumber, String SalesOrderNo, String SalesOrderItemNo,
			String DeliveryOrderNo, String DeliveryOrderItemNo, String ManufacturerID, String CountryOfOrigin,
			String CountryOfOriginType, String FTAApplicable, String NetworkOrderNumber, String EngineLine,
			String MTFNumber, String Remarks) {
		clickElement(driver, test, OCR_DOCNOItem_PartNoLink, "Click on Part No link");
		try {
			Wait.waitfor(3);
			typeText(driver, test, OCR_DOCNOItem_PartNo, "Enter the Part No : ", PartNo);
			clickElement(driver, test, OCR_DOCNOItem_SearchBtn, "Click on Search button");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Select the PartNo : " + PartNo);
			clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_DOCNOItem_SourceSystemPartNumber, "Enter the Source System Part Number : ",
				SourceSystemPartNumber);
		typeText(driver, test, OCR_DOCNOItem_SerialNumbers, "Enter the Serial Numbers : ", SerialNumbers);
		typeText(driver, test, OCR_DOCNOItem_PONumber, "Enter the PO Number : ", PONumber);
		typeText(driver, test, OCR_DOCNOItem_CustomerPartNumber, "Enter the Customer Part No : ", CustomerPartNumber);
		typeText(driver, test, OCR_DOCNOItem_SalesOrderNo, "Enter the Sales Order NO : ", SalesOrderNo);
		typeText(driver, test, OCR_DOCNOItem_SalesOrderItemNo, "Enter the Sales Order Item No : ", SalesOrderItemNo);
		typeText(driver, test, OCR_DOCNOItem_DeliveryOrderNo, "Enter the Delivery Order No : ", DeliveryOrderNo);
		typeText(driver, test, OCR_DOCNOItem_DeliveryOrderItemNo, "Enter the Delivery Order Item No : ",
				DeliveryOrderItemNo);
		Wait.waitfor(3);
		if (ManufacturerID.length() > 0) {
			clickElement(driver, test, OCR_DOCNOItem_ManufacturerLink, "Click on Manufacturer link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ManufacturerID + "')]",
						"Select the Manufacturer ID : " + ManufacturerID);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		typeText(driver, test, OCR_DOCNOItem_CountryOfOrigin, "Enter the Country Of Origin : ", CountryOfOrigin);
		selectByVisibleText(driver, test, OCR_DOCNOItem_CountryOriginDropDown, "Select the Country of Origin Type : ",
				CountryOfOriginType);
		selectByVisibleText(driver, test, OCR_DOCNOItem_FTAApplicable, "Select the FTA Applicable : ", FTAApplicable);
		typeText(driver, test, OCR_DOCNOItem_NetworkOrderNumber, "Enter the Network Order Number : ",
				NetworkOrderNumber);
		typeText(driver, test, OCR_DOCNOItem_EngineLine, "Enter the Engine Line : ", EngineLine);
		typeText(driver, test, OCR_DOCNOItem_MTFNumber, "Enter the MTFNumber : ", MTFNumber);
		typeText(driver, test, OCR_DOCNOItem_Remarks, "Enter the Remarks : ", Remarks);
		Wait.waitfor(3);
	}

	// Add the Description
	public void addProductDescription(String ProductDescription) {
		typeText(driver, test, "//textarea[@id='editInvoiceItem_invoiceItem_description']",
				"Enter the Product Description : ", ProductDescription);
	}

	// Adding the Quantity And Pricing Information
	public void addQuantityAndPricingInfo(String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice,
			String ItemUnitPriceCurrency, String RepairValue, String DiscountRate, String WholesaleRate) {
		scrollToElement(driver, OCR_DOCNOItem_Remarks);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_DOCNOItem_QuantityPricingInformationLabel,
				"Click on Quantity Pricing Information Label");
		clearText(driver, test, OCR_DOCNOItem_CustomsInvoiceQuantity, "Clear the Customs Invoice Qty");
		typeText(driver, test, OCR_DOCNOItem_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ",
				CustomsInvoiceQuantity);
		typeText(driver, test, OCR_DOCNOItem_QuantityUOM, "Enter the Quantity UOM : ", QuantityUOM);
		typeText(driver, test, OCR_DOCNOItem_ItemUnitPrice, "Enter the Item Unit Price : ", ItemUnitPrice);
		if (ItemUnitPriceCurrency.length() > 0) {
			clearText(driver, test, OCR_DOCNOItem_ItemUnitPriceCurrency, "Clear the text in Item Unit Price Currency");
			typeText(driver, test, OCR_DOCNOItem_ItemUnitPriceCurrency, "Enter the Item Unit Price Currency : ",
					ItemUnitPriceCurrency);
		}
		Wait.waitfor(3);
		clearText(driver, test, OCR_DOCNOItem_RepairValue, "Clear the text in Repair value");
		typeText(driver, test, OCR_DOCNOItem_RepairValue, "Enter thr Repair Value : ", RepairValue);
		typeText(driver, test, OCR_DOCNOItem_DiscountRate, "Enter the Discount Rate : ", DiscountRate);
		typeText(driver, test, OCR_DOCNOItem_WholesaleRate, "Enter the Whole sale Rate : ", WholesaleRate);
	}

	// Adding the Classification Information
	public void addClassifacationInfo(String ControllingAgencycode, String ExportClassificationItem,
			String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM,
			String ImportHTS, String ImportUOM, String USExportECCN, String StatisticalCode) {
		scrollToElement(driver, OCR_DOCNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_DOCNOItem_ClassificationInformationLabel,
				"Click on Classifaction Information label");
		if (ControllingAgencycode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_DOCNOItem_ControllingAgencyLink, "Click on Controlling Agency Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ControllingAgencycode + "')]",
						"Select the Controlling Agency code : " + ControllingAgencycode);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select Button");
				scrollToBottom(driver);
				scrollToBottom(driver);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (ExportClassificationItem.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_DOCNOItem_ExportClassificationLink, "Click on Export Classification Link");
			try {
				typeText(driver, test, OCR_DOCNOItem_ExportClassificationItem,
						"Enter the Export Classification item : ", ExportClassificationItem);
				clickElement(driver, test, OCR_DOCNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + ExportClassificationItem + "')]",
						"Select the Export Classification Item : " + ExportClassificationItem);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_DOCNOItem_HTSPrimaryUOM, "Enter the HTS & Primary UOM : ", HtsAndPrimaryUMO);
		typeText(driver, test, OCR_DOCNOItem_SecondaryCustomsQuantity, "Enter the Secondary Customs Quantity : ",
				SecondaryCustomsQuantity);
		typeText(driver, test, OCR_DOCNOItem_SCQ_UOM, "Enter the Secondary Customs Quantity UOM : ",
				SecondaryCustomsQuantityUOM);
		typeText(driver, test, OCR_DOCNOItem_ImportHTS, "Enter the Import HTS : ", ImportHTS);
		typeText(driver, test, OCR_DOCNOItem_ImportUOM, "Enter the Import UOM : ", ImportUOM);
		if (USExportECCN.length() > 0) {
			clickElement(driver, test, OCR_DOCNOItem_USExportClassificationLink,
					"Click on US Export Classification Link");
			try {
				typeText(driver, test, OCR_DOCNOItem_USExportClassificationECCN, "Enter the USExportECCN : ",
						USExportECCN);
				clickElement(driver, test, OCR_DOCNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + USExportECCN + "')]",
						"Select the US Export Classification ECCN : " + USExportECCN);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
				scrollToBottom(driver);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//div[@id='ocrModal']//button[@class='cancelPopup']",
						"Click on Cancel popup icon");
			}
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_DOCNOItem_StatisticalCode, "Enter the Statistical Code : ", StatisticalCode);
		scrollToBottom(driver);
		scrollToBottom(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_DOCNOItem_ClassificationInformationSave,
				"Click on Classification Information Save button");
	}

	// Adding the Classification Information
	public void addClassifacationInfoUS(String ControllingAgencycode, String ExportClassificationItem,
			String HtsAndPrimaryUMO, String SecondaryCustomsQuantity, String SecondaryCustomsQuantityUOM,
			String ImportHTS, String ImportUOM) {
		scrollToElement(driver, OCR_DOCNOItem_QuantityPricingInformationLabel);
		clickElement(driver, test, OCR_DOCNOItem_ClassificationInformationLabel,
				"Click on Classifaction Information label");
		if (ControllingAgencycode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_DOCNOItem_ControllingAgencyLink, "Click on Controlling Agency Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + ControllingAgencycode + "')]",
						"Select the Controlling Agency code : " + ControllingAgencycode);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select Button");
				scrollToBottom(driver);
				scrollToBottom(driver);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (ExportClassificationItem.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_DOCNOItem_ExportClassificationLink, "Click on Export Classification Link");
			try {
				typeText(driver, test, OCR_DOCNOItem_ExportClassificationItem,
						"Enter the Export Classification item : ", ExportClassificationItem);
				clickElement(driver, test, OCR_DOCNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + ExportClassificationItem + "')]",
						"Select the Export Classification Item : " + ExportClassificationItem);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		scrollToBottom(driver);
		typeText(driver, test, OCR_DOCNOItem_HTSPrimaryUOM, "Enter the HTS & Primary UOM : ", HtsAndPrimaryUMO);
		typeText(driver, test, OCR_DOCNOItem_SecondaryCustomsQuantity, "Enter the Secondary Customs Quantity : ",
				SecondaryCustomsQuantity);
		typeText(driver, test, OCR_DOCNOItem_SCQ_UOM, "Enter the Secondary Customs Quantity UOM : ",
				SecondaryCustomsQuantityUOM);
		typeText(driver, test, OCR_DOCNOItem_ImportHTS, "Enter the Import HTS : ", ImportHTS);
		typeText(driver, test, OCR_DOCNOItem_ImportUOM, "Enter the Import UOM : ", ImportUOM);
		clickElement(driver, test, OCR_DOCNOItem_ClassificationInformationSave,
				"Click on Classification Information Save button");
	}

	// Adding Export Authorisation Information
	public void addExportAuthorisationInfo(String BISLicenseException, String AuthorisationNo,
			String AuthorisationItemNo, String InternalAuthNo, String AuthorisationExpiryDate, String MLCategoryCode,
			String EUSNo) {
		scrollToElement(driver, OCR_DOCNOItem_ClassificationInformationLabel);
		clickElement(driver, test, OCR_DOCNOItem_ExportAuthorisationInformationLabel,
				"Click on Export Authorisation Information Label");
		if (BISLicenseException.length() > 0) {
			clickElement(driver, test, OCR_DOCNOItem_BISLicenseExceptionLink, "Click on BIS License Exception Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + BISLicenseException + "')]",
						"Select the BIS License Exception : " + BISLicenseException);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (AuthorisationNo.length() > 0) {
			scrollToElement(driver, OCR_DOCNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_DOCNOItem_AuthorisationNoLink, "Click on Authorisation No Link");
			try {
				typeText(driver, test, OCR_DOCNOItem_AuthorisationNoPopUP, "Enter the Authorisation No : ",
						AuthorisationNo);
				clickElement(driver, test, OCR_DOCNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				Wait.waitfor(4);
				clickElement(driver, test, "//td[contains(text(),'" + AuthorisationNo + "')]",
						"Select the Authorisation No : " + AuthorisationNo);
				Wait.waitfor(4);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (AuthorisationItemNo.length() > 0) {
			scrollToElement(driver, OCR_DOCNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_DOCNOItem_AuthorisationItemNoLink, "Click on Authorisation Item No Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + AuthorisationItemNo + "')]",
						"Select the Authorisation Item No : " + AuthorisationItemNo);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		if (InternalAuthNo.length() > 0) {
			scrollToElement(driver, OCR_DOCNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_DOCNOItem_InternalAuthNoLink, "Click on Internal Auth No");
			try {
				typeText(driver, test, OCR_DOCNOItem_InternalAuthNoPopUp, "Enter the Internal Auth No : ",
						InternalAuthNo);
				clickElement(driver, test, OCR_DOCNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + InternalAuthNo + "')]",
						"Select the Internal Auth No : " + InternalAuthNo);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		scrollToElement(driver, OCR_DOCNOItem_ClassificationInformationLabel);
		clickElement(driver, test, OCR_DOCNOItem_AuthorisationExpiryDate, "Click on Authorisation Expiry Date");
		date(driver, test, "Select the Authorisation Expiry Date : ", AuthorisationExpiryDate);
		if (MLCategoryCode.length() > 0) {
			scrollToElement(driver, OCR_DOCNOItem_ClassificationInformationLabel);
			clickElement(driver, test, OCR_DOCNOItem_MLCategory, "Click on ML Category");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + MLCategoryCode + "')]",
						"Select the ML Category Code : " + MLCategoryCode);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
		typeText(driver, test, OCR_DOCNOItem_EUSNo, "Enter the EUS No : ", EUSNo);
	}

	// Adding the Additional Authorization
	public void addAdditionalAuthorization(String AdditionalAuthorisationNo, String AdditionalAuthorisationItemNo) {
		scrollToElement(driver, OCR_DOCNOItem_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_DOCNOItem_Save, "Click on Save in Items page");
		scrollToElement(driver, OCR_DOCNOItem_ExportAuthorisationInformationLabel);
		if (AdditionalAuthorisationNo.length() > 0) {
			clickElement(driver, test, OCR_DOCNOItem_AdditionalAuthorisationLabel,
					"Click on Additional Authorisation Label");
			clickElement(driver, test, OCR_DOCNOItem_AddAdditionalAuthorisationBtn,
					"Click on Add Additional Authorisation");
			try {
				clickElement(driver, test, OCR_DOCNOItem_AA_AuthorisationNoLink,
						"Click on Additional Authorisation No");
				typeText(driver, test, OCR_DOCNOItem_AuthorisationNoPopUP, "Enter the Authorisation No : ",
						AdditionalAuthorisationNo);
				clickElement(driver, test, OCR_DOCNOItem_ClassificationInfoSearchBtn, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalAuthorisationNo + "')]",
						"Select the Additional Authorisation No : " + AdditionalAuthorisationNo);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_DOCNOItem_AA_AuthorisationItemNoLink,
						"Click on Additional Authorisation Item No Link");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalAuthorisationItemNo + "')]",
						"Select the Additional Authorisation item No : " + AdditionalAuthorisationItemNo);
				clickElement(driver, test, OCR_DOCNOItem_SelectBtn, "Click on Select button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_DOCNOItem_AA_SaveBtn, "Click on Save button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_DOCNOItem_ClosePopUp, "Click on Cancel popup icon");
			}
		}
	}

	// Adding the Packing Information
	public void addPackingDetails(String HUNoContainerID, String HUNoSubLevel, String GrossWeight, String NetWeight,
			String Markings, String Dimensions, String NoOfPkgs, String AlternateUOM, String Skids, String Length,
			String Width, String Height, String Weight, String ExtendedWeight, String Factor, String Cubic) {
		scrollToElement(driver, OCR_DOCNOItem_PackingInformationLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_DOCNOItem_PackingInformationLabel, "Click on Packing Information Label");
		typeText(driver, test, OCR_DOCNOItem_HUNoContainerId, "Enter the HUNo/ContainerId : ", HUNoContainerID);
		typeText(driver, test, OCR_DOCNOItem_HUNoSubLevel, "Enter the HU No Sub Level : ", HUNoSubLevel);
		typeText(driver, test, OCR_DOCNOItem_GrossWeight, "Enter the Gross Weight : ", GrossWeight);
		typeText(driver, test, OCR_DOCNOItem_NetWeight, "Enter the Net Weight : ", NetWeight);
		typeText(driver, test, OCR_DOCNOItem_Markings, "Enter the Markings : ", Markings);
		typeText(driver, test, OCR_DOCNOItem_Dimensions, "Enter the Dimensions : ", Dimensions);
		typeText(driver, test, OCR_DOCNOItem_NoOfPkgs, "Enter the No Of Pkgs : ", NoOfPkgs);
		typeText(driver, test, OCR_DOCNOItem_AlternateUOM, "Enter the Alternate UOM : ", AlternateUOM);
		typeText(driver, test, OCR_DOCNOItem_Skids, "Enter the Skids : ", Skids);
		typeText(driver, test, OCR_DOCNOItem_Length, "Enter the Length : ", Length);
		typeText(driver, test, OCR_DOCNOItem_Width, "Enter the Width : ", Width);
		typeText(driver, test, OCR_DOCNOItem_Height, "Enter the Height : ", Height);
		typeText(driver, test, OCR_DOCNOItem_Weight, "Enter the Weight : ", Weight);
		typeText(driver, test, OCR_DOCNOItem_ExtendedWeight, "Enter the Extended Weight : ", ExtendedWeight);
		typeText(driver, test, OCR_DOCNOItem_Factor, "Enter the Factor : ", Factor);
		typeText(driver, test, OCR_DOCNOItem_Cubic, "Enter the Cubic : ", Cubic);
	}

	// Adding the Batch Information
	public void addBatchInfo(String BatchNumber, String BatchInfoCountryOfOrigin, String BatchInfoQuantity) {
		scrollToElement(driver, OCR_DOCNOItem_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_DOCNOItem_Save, "Click on Save in Items page");
		scrollToElement(driver, OCR_DOCNOItem_PackingInformationLabel);
		clickElement(driver, test, OCR_DOCNOItem_BatchInformationLabel, "Click on Batch Information Label");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_DOCNOItem_AddBatchInfo, "Click on Add Batch Info");
		typeText(driver, test, OCR_DOCNOItem_BatchInfo_BatchNumber, "Enter the Batch Number : ", BatchNumber);
		typeText(driver, test, OCR_DOCNOItem_BatchInfo_CountryOfOrigin, "Enter the Batch Info Country Of Origin : ",
				BatchInfoCountryOfOrigin);
		clickElement(driver, test, OCR_DOCNOItem_BatchInfo_Quantity, "");
		typeText(driver, test, OCR_DOCNOItem_BatchInfo_Quantity, "Enter the Batch Info Quantity : ", BatchInfoQuantity);
		clickElement(driver, test, OCR_DOCNOItem_BatchInfo_Submit, "Click on Batch info Submit");
	}

	// Select the Hazmat Details
	public void select_HazmatDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_DOCNOItem_AdditionalTransactionDetails,
				"Click on Addtional Transaction Details");
		clickElement(driver, test, OCR_DOCNOItem_HazmatDetails, "Click on Hazmat Details");
	}

}
