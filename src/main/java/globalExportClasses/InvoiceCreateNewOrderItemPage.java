package globalExportClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ClickElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class InvoiceCreateNewOrderItemPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	private String validLicense;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_InvoiceCreateNewOrderItemPage_ProdDesc = "//textarea[@id='editInvoiceItem_invoiceItem_description']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_COO = "//input[@id='cooName']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_QtyPricingLabel = "//font[contains(text(),'Quantity & Pricing Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_CustomInvQty = "//input[@id='primaryNetQuantity']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_UOM = "//input[@id='editInvoiceItem_invoiceItem_invoiceUnitOfQuantity']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_ItemUnitPrice = "//input[@id='editInvoiceItem_invoiceItem_prodUnitPrice']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoLabel = "//font[contains(text(),'Classification Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_ExportClassification = "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_HTS = "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_PrimaryUOM = "//input[@id='editInvoiceItem_invoiceItem_primaryUnit']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_USExportClass = "//input[@id='editInvoiceItem_invoiceItem_usExportClass']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoSaveBtn = "//button[@id='saveFromClassBlock']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel = "//font[contains(text(),'Export Authorization Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AuthorisationNo = "//input[@id='editInvoiceItem_invoiceItem_licenseNo']";

	public static final String OCR_InvoiceCreateNewOrderItemPage_AuthItemNo = "//input[@id='editInvoiceItem_invoiceItem_licenseItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AuthType = "//textarea[@id='editInvoiceItem_invoiceItem_licenseType']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AuthTxnType = "//input[@id='editInvoiceItem_invoiceItem_licenseTxnType']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AuthExpiryDate = "//input[@id='editInvoiceItem_licenseDate']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_SMEIndicator = "//select[@id='editInvoiceItem_invoiceItem_smeIndicator']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel = "//font[contains(text(),'Additional Authorization')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AddAdditionalAuthBtn = "//button[@id='addAuthorisation']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthNo = "//input[@id='invoiceItem.licenseNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthItemNo = "//input[@id='invoiceItem.licenseItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_PopUpSaveBtn = "//button[@name='Save']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_PackingInfoLabel = "//font[contains(text(),'Packing Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Link = "//a[@id='getHuNoBasePopUp']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_InvCartonRadioBtn = "//input[@id='searchForm_cartonTypeinvoiceCarton']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_SelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_ContainerIDClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_BatchInfoLabel = "//font[contains(text(),'Batch Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AddbatchInfoBtn = "//button[@id='addBatch']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_BatchNo = "//input[@id='editBatchHeader_batchDetailValue_batchNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_BatchCOO = "//input[@id='editBatchHeader_']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_BatchSaveBtn = "//button[@id='save']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_SaveBtn = "//button[@id='saveSubmitBtn']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_HazmatDetails = "//a[contains(text(),'Hazmat Details')]";

	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_PartNoLink = "//a[@id='partno-popup']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SearchBtn = "//button[@name='Search']";
	// public static final String OCR_InvoiceCreateNewOrderItemPage_SelectBtn =
	// "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ClosePopUp = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SourceSystemPartNumber = "//input[@id='editInvoiceItem_invoiceItem_sourceSystemPart']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SerialNumbers = "//textarea[@id='editInvoiceItem_invoiceItem_serialNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_PONumber = "//input[@id='editInvoiceItem_invoiceItem_poNumber']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_POLineNo = "//input[@id='editInvoiceItem_invoiceItem_poLineNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SchedulingAgreement = "//input[@id='editInvoiceItem_invoiceItem_schedulingAgreement']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_CustomerPartNumber = "//input[@id='editInvoiceItem_invoiceItem_custPartNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SalesOrderNo = "//input[@id='editInvoiceItem_invoiceItem_salesOrderNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SalesOrderItemNo = "//input[@id='editInvoiceItem_invoiceItem_salesOrderItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DeliveryOrderNo = "//input[@id='editInvoiceItem_invoiceItem_deliveryOrderNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DeliveryOrderItemNo = "//input[@id='editInvoiceItem_invoiceItem_deliveryOrderItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_COO = "//input[@id='cooName']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Vendor = "//input[@id='editInvoiceItem_invoiceItem_vendor']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_VendorPartNo = "//input[@id='editInvoiceItem_invoiceItem_vendorPartNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_NetOrderNo = "//input[@id='editInvoiceItem_invoiceItem_orderNetworkNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_WBSElement = "//input[@id='editInvoiceItem_invoiceItem_wbs']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_OrgPONo = "//input[@id='editInvoiceItem_invoiceItem_originalPoNumber']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_EngineLine = "//input[@id='editInvoiceItem_invoiceItem_engineLine']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_MTFNumber = "//input[@id='editInvoiceItem_invoiceItem_mtfNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Remarks = "//textarea[@id='editInvoiceItem_invoiceItem_itemsRemarks']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_QuantityPricingInformationLabel = "//font[contains(text(),'Quantity & Pricing Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_CustomsInvoiceQuantity = "//input[@id='primaryNetQuantity']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_QuantityUOM = "//input[@id='editInvoiceItem_invoiceItem_invoiceUnitOfQuantity']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ItemUnitPrice = "//input[@id='editInvoiceItem_invoiceItem_prodUnitPrice']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ItemUnitPriceCurrency = "//input[@id='editInvoiceItem_invoiceItem_itemCurrency']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_RepairValue = "//input[@id='editInvoiceItem_invoiceItem_repairValue']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DiscountRate = "//input[@id='editInvoiceItem_invoiceItem_discount']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_WholesaleRate = "//input[@id='editInvoiceItem_invoiceItem_wholesaleRate']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SecondaryCustoms = "//a[contains(text(),'& UOM')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Select = "(//button[@name='Ok'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportHTS = "//a[contains(text(),'Import HTS/ UOM')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportHTSSearch = "(//button[@id='searchHsDtlBtn'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportErrorMsg = "//li[contains(text(),'HS data not available for the selected Country/Cou')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_InputHSNo = "(//input[@id='hsNo_resultStdHsPopup'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportSearchBtn = "(//button[@id='searchHsDtlBtn'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportSelectBtn = "(//button[@id='slctBtn'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_AuthTransactionType = "//input[@id='invoiceItem.licenseTxnType']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_AuthType = "//textarea[@id='invoiceItem.licenseType']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ControllingAgency = "//input[@id='invoiceItem.controllingAgency']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_CountryOfIssue = "//input[@name='countryOfOriginName']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Currency = "//input[@id='customsCurrency']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ExportClassfication = "//input[@id='exportClassEccnUsml']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SubCompItemNo = "//input[@id='subcomponentItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_HuSublevel = "//input[@id='invoiceItem.huSubLevel']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_GrossWt = "//input[@name='invoiceItem.grossWeight']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_NetWt = "//input[@name='invoiceItem.netWeight']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_MarksNos = "//input[@id='editInvoiceItem_invoiceItem_marksAndNos']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Dimension = "//input[@id='editInvoiceItem_invoiceItem_dimensions']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_UOM = "//input[@id='editInvoiceItem_invoiceItem_packageQuantity']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_NoPackage = "//input[@id='editInvoiceItem_invoiceItem_noOfPackages']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_AltUOM = "//input[@id='editInvoiceItem_invoiceItem_alternateUom']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Skid = "//input[@id='editInvoiceItem_invoiceItem_skids']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Length = "//input[@id='editInvoiceItem_invoiceItem_length']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Width = "//input[@id='editInvoiceItem_invoiceItem_width']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_height = "//input[@id='editInvoiceItem_invoiceItem_height']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_factor = "//input[@id='editInvoiceItem_invoiceItem_factor']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Cubic = "//input[@id='editInvoiceItem_invoiceItem_cubic']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_HuContainerID = "//input[@id='invoiceItem.huNum']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_BatchQty = "//input[@id='editBatchHeader_batchDetailValue_batchPrimaryQty']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_BatchExpiryDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark1']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_BatchSterilityDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark2']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_BatchGrid = "//div[@id='gbox_grid-batchDetail']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_CustomFilingInfoLabel = "//font[contains(text(),'Customs Filing Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_TempExportInfoLabel = "//font[contains(text(),'Temp. Export/Re-Export Information')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportShipType = "//select[@id='editInvoiceItem_invoiceItem_impInvoiceType']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportInvNo = "//input[@id='editInvoiceItem_invoiceItem_entryCode']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportIdNo = "//input[@id='editInvoiceItem_invoiceItem_importInvoiceItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ImportDueDate = "//input[@id='dueDateMainPage']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DutyReliefType = "//select[@id='reliefTypeId']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_InboundType = "//a[contains(text(),'Inbond Type')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_InboundTypeSelect = "(//button[@name='Ok'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ItemNo = "//input[@id='editInvoiceItem_invoiceItem_impItemNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_InboundTypeClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ReliefActivityType = "//select[@id='editInvoiceItem_invoiceItem_reliefActivityType']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_NotesLabel = "//font[contains(text(),'Notes')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_PackingNote = "//textarea[@id='editInvoiceItem_invoiceItem_packingNote']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ContractLineNote = "//textarea[@id='editInvoiceItem_invoiceItem_contractLineNote']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_OracleAttachment = "//textarea[@id='editInvoiceItem_invoiceItem_oracleAttachment']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DeliveryAttachment = "//textarea[@id='editInvoiceItem_invoiceItem_deliveryAttachment']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_PartNum = "//input[@id='editInvoiceItem_invoiceItem_partNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_Description = "//textarea[@id='editInvoiceItem_invoiceItem_description']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_LineItemCLoseBtn = "//button[@id='cancelInvoiceItem']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCQty = "//input[@id='odtcQuantity']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM = "//select[@id='editInvoiceItem_invoiceItem_odtcUnitOfMeasure']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_OrderItemCloseBtn = "//button[@id='cancelInvoiceItem']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon = "//i[@class='fa fa-legal']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningPopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ControllAgencyNextBtn = "(//span[@class='ui-icon ui-icon-seek-next'])[8]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCRegNo = "//input[@id='editInvoiceItem_invoiceItem_registrationNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn = "//button[@id='authOverride']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_ITARExemption = "//input[@id='editInvoiceItem_invoiceItem_itarExemptionNo']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCEligibleParty = "//select[@id='editInvoiceItem_invoiceItem_eligiblePartyIndicator']";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SelectBIS = "//a[contains(text(),'BIS License Exception')]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SearchBIS = "(//button[@name='Search'])[1]";
	public static final String OCR_InvoiceCreateNewOrderItemPage_Regres_SelectBISBtn = "(//button[@name='Ok'])[1]";
	
	
	/* ******************************* Constructor ****************************** */

	public InvoiceCreateNewOrderItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// General information section
	public void generalInformation(String ProductDesc, String COO) {

		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_ProdDesc, "Enter Product description : ", ProductDesc);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_COO, "Enter Country of Origin : ", COO);

	}

	// Adding General Information for Regression
	public void generalInformation(String PartNo, String PartNum, String Desc, String SourceSystemPartNumber,
			String POLineNo, String ScheduleAgreement, String SerialNumbers, String PONumber, String CustomerPartNumber,
			String SalesOrderNum, String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo,
			String PartCOO, String Vendor, String VendorPN, String NetOrderNo, String EngineLine, String WBS,
			String MTFNumber, String Remarks, String OrgPONo) {
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_PartNoLink, "Click on Part No link");
			try {
				typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_PartNo, "Enter the Part No : ", PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SearchBtn,
						"Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Select the PartNo : " + PartNo);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ClosePopUp,
						"Click on Cancel popup icon");
			}
		} else {
			typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_PartNum, "Enter Part Number : ", PartNum);
		}
		scrollToBottom(driver);
		// typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Description,
		// "Enter Description : ", Desc);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SourceSystemPartNumber,
				"Enter the Source System Part Number : ", SourceSystemPartNumber);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_POLineNo, "ENter PO Line Number : ", POLineNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SchedulingAgreement,
				"Enter Scheduling Agreement : ", ScheduleAgreement);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SerialNumbers, "Enter the Serial Numbers : ",
				SerialNumbers);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_PONumber, "Enter the PO Number : ", PONumber);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CustomerPartNumber,
				"Enter the Customer Part No : ", CustomerPartNumber);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SalesOrderNo, "Enter the Sales Order NO : ",
				SalesOrderNum);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SalesOrderItemNo,
				"Enter the Sales Order Item No : ", SalesOrderItemNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DeliveryOrderNo,
				"Enter the Delivery Order No : ", DeliveryOrderNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DeliveryOrderItemNo,
				"Enter the Delivery Order Item No : ", DeliveryOrderItemNo);
		Wait.waitfor(3);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_COO, "Enter Country of Origin : ", PartCOO);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Vendor, "Enter Vendor : ", Vendor);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_VendorPartNo, "Enter Vendor Part Number : ",
				VendorPN);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_NetOrderNo, "Enter Network Order Number : ",
				NetOrderNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_EngineLine, "Enter the Engine Line : ",
				EngineLine);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_WBSElement, "Enter WBS Element : ", WBS);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_MTFNumber, "Enter the MTFNumber : ", MTFNumber);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Remarks, "Enter the Remarks : ", Remarks);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OrgPONo, "Original PO Number : ", OrgPONo);
		Wait.waitfor(3);
	}

	// enter Part COO again for Regression US
	public void enterPartCOO(String PartCOOrigin) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_COO);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_COO, "Enter Country of Origin : ",
				PartCOOrigin);
	}

	// Quantity and pricing information
	public void qytPricingInfo(String CustInvQty, String UOM, String UnitPrice) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_QtyPricingLabel);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_QtyPricingLabel,
				" Click on Quantity & Pricing Information");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_CustomInvQty, "Enter Custom invoice Quantity : ",
				CustInvQty);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_UOM, "Enter Unit Of Measure : ", UOM);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_ItemUnitPrice, "Enter Item Unit Price : ", UnitPrice);

	}

	// Adding the Quantity And Pricing Information for Regression
	public void qytPricingInfo(String CustomsInvoiceQuantity, String QuantityUOM, String ItemUnitPrice,
			String ItemUnitPriceCurrency, String RepairValue, String DiscountRate, String WholesaleRate) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_Remarks);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_QuantityPricingInformationLabel,
				"Click on Quantity Pricing Information Label");
		clearText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CustomsInvoiceQuantity,
				"Clear the Customs Invoice Qty");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CustomsInvoiceQuantity,
				"Enter the Customs Invoice Quantity : ", CustomsInvoiceQuantity);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_QuantityUOM, "Enter the Quantity UOM : ",
				QuantityUOM);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ItemUnitPrice, "Enter the Item Unit Price : ",
				ItemUnitPrice);
		if (ItemUnitPriceCurrency.length() > 0) {
			clearText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ItemUnitPriceCurrency,
					"Clear the text in Item Unit Price Currency");
			typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ItemUnitPriceCurrency,
					"Enter the Item Unit Price Currency : ", ItemUnitPriceCurrency);
		}
		Wait.waitfor(3);
		clearText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_RepairValue, "Clear the text in Repair value");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_RepairValue, "Enter thr Repair Value : ",
				RepairValue);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DiscountRate, "Enter the Discount Rate : ",
				DiscountRate);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_WholesaleRate, "Enter the Whole sale Rate : ",
				WholesaleRate);
	}

	// Adding the Quantity And Pricing Information for Invoice Authorization for
	// Regression US
	public void qytPricingInfo(String CustomsInvoiceQuantity, String ItemUnitPrice) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_Remarks);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_QuantityPricingInformationLabel,
				"Click on Quantity Pricing Information Label");
		clearText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CustomsInvoiceQuantity,
				"Clear the Customs Invoice Qty");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CustomsInvoiceQuantity,
				"Enter the Customs Invoice Quantity : ", CustomsInvoiceQuantity);
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ItemUnitPrice, "Enter the Item Unit Price : ",
				ItemUnitPrice);

		Wait.waitfor(3);

	}

	// classification information
	public void classificationInfo(String ExportClassification, String HTS, String PrimaryUOM, String USExport) {

		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoLabel,
				"Click on Classification Information Label");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportClassification, "Enter Export Classification : ",
				ExportClassification);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_HTS, "Enter HTS : ", HTS);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_PrimaryUOM, "Enter Primary UOM : ", PrimaryUOM);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_USExportClass, "Enter US Export Classification : ",
				USExport);
	}

	// classification information US
	public void classificationInfoUS(String ControllingAgency, String ExportClassification, String HTS,
			String PrimaryUOM) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoLabel);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoLabel,
				"Click on Classification Information Label");
		clickElement(driver, test, "//a[@id='controllingAgency-Popup']", "Click on Controlling Agency");
		try {
			clickElement(driver, test, "//td[contains(text(),'" + ControllingAgency + "')]",
					"Select the Controlling Agency : " + ControllingAgency);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_SelectBtn, "Click on select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ContainerIDClosePopUp,
					"Click on POP up Close");
		}
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ExportClassification);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportClassification, "Enter Export Classification : ",
				ExportClassification);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_HTS, "Enter HTS : ", HTS);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_PrimaryUOM, "Enter Primary UOM : ", PrimaryUOM);
	}

	// DOS classification information US
	public void classificationInfoUS(String ControllingAgency, String ExportClassification) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoLabel);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoLabel,
				"Click on Classification Information Label");
		clickElement(driver, test, "//a[@id='controllingAgency-Popup']", "Click on Controlling Agency");
		try {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ControllAgencyNextBtn,
					"Click on next arrow button :");
			clickElement(driver, test, "//td[contains(text(),'" + ControllingAgency + "')]",
					"Select the Controlling Agency : " + ControllingAgency);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_SelectBtn, "Click on select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ContainerIDClosePopUp,
					"Click on POP up Close");
		}
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ExportClassification);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportClassification, "Enter Export Classification : ",
				ExportClassification);

	}

	public void classificationInfoSaveBtn() {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoSaveBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ClassificationInfoSaveBtn,
				"Click On Classification Info Save Button");

	}

	// Export Authorization information
	public void exportAuthInfo(String AuthNo, String AuthItemNo, String AuthType, String AuthTxnType,
			String AuthExpiryDate, String SMEIndicator) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel,
				"Click on Export Authorization Informatio label");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AuthorisationNo, "Enter Authorization Number : ",
				AuthNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AuthItemNo, "Enter Authorization Item No : ",
				AuthItemNo);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AuthType, " ");
		Wait.waitfor(3);
		// Alert a1 = driver.switchTo().alert();
		// a1.accept();
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AuthType, "Enter Authorization Type : ", AuthType);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AuthTxnType, "Enter Authorization Transaction Type : ",
				AuthTxnType);

		if (AuthExpiryDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AuthExpiryDate,
					"Click on Authorization Expiry Date");
			date(driver, test, "Select the Date of Export : ", AuthExpiryDate);
			Wait.waitfor(2);
		}

		selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_SMEIndicator, "Select SME Indicator : ",
				SMEIndicator);

	}
	
	//Selecting BIS Exception ->CTP exception
	
	public void selectBISLicenseExp(String BIS) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel,
				"Click on Export Authorization Informatio label");
		if(BIS.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SelectBIS, "Click on BIS License Exception link");
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SearchBIS, "CLick on Search Button :");
			clickElement(driver, test, "//td[contains(text(),'"+BIS+"')]", BIS);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_SelectBISBtn, "Click on Select button :");
		}

	}
	

	// Export Authorization information for Invoice Authorization for Regression US
	public void exportAuthInfo(String DDTCQty, String DDTCUOM) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel,
				"Click on Export Authorization Informatio label");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCQty, "Enter DDTC Quantity : ", DDTCQty);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM, "Select DDTC UOM : ",
				DDTCUOM);

	}

	// Export Authorization AddDDTCQty, DDTC UOM and DDTC Registration number
	public void exportAuthInfo(String DDTCQty, String DDTCUOM, String DDTCRegNo) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCQty);
		Wait.waitfor(3);
		// clickElement(driver, test,
		// OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel,
		// "Click on Export Authorization Information label");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCQty, "Enter DDTC Quantity : ", DDTCQty);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM, "Select DDTC UOM : ",
				DDTCUOM);

		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCRegNo, "Enter Registration Number : ",
				DDTCRegNo);
	}
	
	// Export Authorization ITARExemption, AddDDTCQty, DDTC UOM and DDTC Registration number, Eligible DDTC party
		public void exportAuthInfo( String ITARExemption, String DDTCQty, String DDTCUOM, String DDTCEligibleParty, String DDTCRegNo) {
			Wait.waitfor(3);
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel,
					"Click on Export Authorization Informatio label");
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_ITARExemption);
			typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ITARExemption, "Enter ITAR Exemption : ", ITARExemption);
			Wait.waitfor(3);
			// clickElement(driver, test,
			// OCR_InvoiceCreateNewOrderItemPage_ExportAuthInfoLabel,
			// "Click on Export Authorization Information label");
			typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCQty, "Enter DDTC Quantity : ", DDTCQty);
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCUOM, "Select DDTC UOM : ",
					DDTCUOM);
			Wait.waitfor(2);
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCEligibleParty);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCEligibleParty, "Select DDTC Eligible Party : ", DDTCEligibleParty);
			typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DDTCRegNo, "Enter Registration Number : ",
					DDTCRegNo);
			Wait.waitfor(2);
		}

	// Additional Authorization Information
	public void additionalAuthInfo(String AdditionalAuthNo, String AdditionalAuthItemNo) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel);

		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel,
				"Click on Additional Authorization information label");
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AddAdditionalAuthBtn,
				"Click on Add Additional Authorization button");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthNo,
				"Enter Additional Authorization No : ", AdditionalAuthNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthItemNo,
				"Enter Additional Authorization Item no : ", AdditionalAuthItemNo);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_PopUpSaveBtn, "Click on Save Button");

	}

	// Additional Authorization Information for regression US
	public void additionalAuthInfo(String AdditionalAuthNo, String AdditionalAuthItemNo, String AuthTransType,
			String AddAuthType, String ControlAgency, String CountryOfIssue) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel);

		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel,
				"Click on Additional Authorization information label");
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AddAdditionalAuthBtn,
				"Click on Add Additional Authorization button");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthNo,
				"Enter Additional Authorization No : ", AdditionalAuthNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthItemNo,
				"Enter Additional Authorization Item no : ", AdditionalAuthItemNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_AuthTransactionType,
				"Enter Authorization Transaction Type : ", AuthTransType);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_AuthType, "Enter Authorization Type : ",
				AddAuthType);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ControllingAgency,
				"Enter Controlling Agency : ", ControlAgency);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CountryOfIssue, "Enter Country Of Issue : ",
				CountryOfIssue);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_PopUpSaveBtn, "Click on Save Button");
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalAuthLabel,
				"Click on Additional Authorization label :");
		if (isDisplayed(driver, "//div[@id='gbox_gridAuthorisation']")) {
			Wait.fluwait(driver, "//div[@id='gbox_gridAuthorisation']");
			test.log(LogStatus.PASS, "Additional Authorization Details added to result grid table : "
					+ "//div[@id='gbox_gridAuthorisation']");
		} else {
			test.log(LogStatus.FAIL, "Failed to Add Additional Authorization Details in result grid table : "
					+ "//div[@id='gbox_gridAuthorisation']");
		}
	}

	// Packing Details Information
	public void packingInfo(String HUContainerID) {

		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_PackingInfoLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_PackingInfoLabel,
				"Click on Packing information label");

		if (HUContainerID.length() > 0) {
			Wait.waitfor(5);
			try {
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Link,
						"select HU No/ Container ID from link");
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_InvCartonRadioBtn,
						"Click on Invoice Carton Radio Button");

				// for selecting HU No/ContainerID among various options
				String ContID = "//td[contains(text(),'" + HUContainerID + "')]";
				clickElement(driver, test, ContID,
						"select the HU No/ContainerID among various options : " + HUContainerID);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_SelectBtn, "click on Select button");

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ContainerIDClosePopUp,
						"Click on Close popup icon");
			}

		}
	}

	// packing details information for regression US

	public void packingInfo(String HUContainerID, String HUNo, String HSLevel, String GrossWt, String NetWt,
			String MarkNos, String Dimension, String UOM, String NoPack, String AltUOM, String Skids, String length,
			String width, String height, String Factor, String Cubic) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_PackingInfoLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_PackingInfoLabel,
				"Click on Packing information label");

		if (HUContainerID.length() > 0) {
			Wait.waitfor(5);
			try {
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Link,
						"select HU No/ Container ID from link");
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_InvCartonRadioBtn,
						"Click on Invoice Carton Radio Button");

				// for selecting HU No/ContainerID among various options
				String ContID = "//td[contains(text(),'" + HUContainerID + "')]";
				clickElement(driver, test, ContID,
						"select the HU No/ContainerID among various options : " + HUContainerID);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_SelectBtn, "click on Select button");

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_ContainerIDClosePopUp,
						"Click on Close popup icon");
			}
		} else {
			Wait.waitfor(2);
			typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_HuContainerID, "Enter HU COntanier ID : ",
					HUNo);

		}
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_HuSublevel, "Enter HS Sub level  : ", HSLevel);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_GrossWt, "Enter Gross Weight : ", GrossWt);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_NetWt, "Enter Net Weight : ", NetWt);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_MarksNos, "Enter marks and nos : ", MarkNos);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Dimension, "Enter Dimesion : ", Dimension);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_UOM, "Enter UOM : ", UOM);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_NoPackage, "Enter Number Of Packages : ",
				NoPack);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_AltUOM, "Enter alternate UOM : ", AltUOM);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Skid, "Enter Skids : ", Skids);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Length, "Enter Length : ", length);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Width, "Enter Width : ", width);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_height, "Enter Height : ", height);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_factor, "Enter Factor : ", Factor);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_Cubic, "Enter Cubic : ", Cubic);
	}

	// Batch Information
	public void batchInfo(String BatchNo, String BatchCOO) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_BatchInfoLabel);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchInfoLabel,
				"Click on Batch information label");
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AddbatchInfoBtn, "Click on Add Batch Info Button");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchNo, "Enter Batch No : ", BatchNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchCOO, "Enter COuntry Of Origin : ", BatchCOO);
		clickElement(driver, test, "//input[@id='editBatchHeader_batchDetailValue_batchPrimaryQty']", "");
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchSaveBtn, "Click on Submit Button");
	}

	// Batch Information Regression US
	public void batchInfo(String BatchNo, String BatchCOO, String BatchQty, String BatchExpiryDate,
			String BatchSterilityDate) {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_BatchInfoLabel);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchInfoLabel,
				"Click on Batch information label");
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AddbatchInfoBtn, "Click on Add Batch Info Button");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchNo, "Enter Batch No : ", BatchNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchCOO, "Enter COuntry Of Origin : ", BatchCOO);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_BatchQty, "Enter Batch Quantity : ", BatchQty);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_BatchExpiryDate,
				"Click on Batch Expiry Date :");
		date(driver, test, "Select the Date of Expiry : ", BatchExpiryDate);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_BatchSterilityDate,
				"Click on Sterility Date :");
		date(driver, test, "Select the Date of Sterility : ", BatchSterilityDate);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_BatchSaveBtn, "Click on Submit Button");
		Wait.waitfor(2);
		if (isDisplayed(driver, "//div[@id='gbox_grid-batchDetail']")) {
			Wait.fluwait(driver, "//div[@id='gbox_grid-batchDetail']");
			test.log(LogStatus.PASS,
					"Batch Information added to result grid table : " + "//div[@id='gbox_grid-batchDetail']");
		} else {
			test.log(LogStatus.FAIL,
					"Failed to Add Batch Information in result grid table : " + "//div[@id='gbox_grid-batchDetail']");
		}
	}

	// Customs Filing Information US
	public void customFilingInfo() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_CustomFilingInfoLabel,
				"Click on Custom Filing Information label :");
		Wait.waitfor(2);
	}

	// Temp Export/Re-Export Information Regression US
	public void tempExportInfo(String ImportShipType, String ImportInvNo, String ImportIDNo, String DueDate,
			String DutyReliefType, String inboundType, String ItemNo, String ReliefActivityType) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_TempExportInfoLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_TempExportInfoLabel,
				"Click on Temp Export/Re-Export Information label :");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ImportShipType,
				"Select the Import Shipment Type : ", ImportShipType);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ImportInvNo, "Enter Import Invoice Number : ",
				ImportInvNo);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ImportIdNo,
				"Enter Import Identification Number", ImportIDNo);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ImportDueDate,
				"Click on Import Due Date :");
		date(driver, test, "Select Due Date : ", DueDate);
		selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DutyReliefType,
				"Select Duty Relief Type : ", DutyReliefType);
		try {
			if (inboundType.length() > 0) {
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_InboundType,
						"Click on Inbound Type Link :");
				Wait.waitfor(2);
				clickElement(driver, test, "//td[contains(text(),'" + inboundType + "')]",
						"Select Inbound Type : " + inboundType);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_InboundTypeSelect,
						"Click on Select button :");
				scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_InboundType);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_InboundTypeClosePopUp,
					"Click on CLose popup icon");
		}
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ItemNo, "Enter Item Number : ", ItemNo);
		selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ReliefActivityType,
				"Select Relief Activity Type : ", ReliefActivityType);
	}

	// Notes for Regression US
	public void notes(String PackNote, String ContractNote, String OracleAttachment, String DelAttachment) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_NotesLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_NotesLabel, "Click on Notes Label");
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_PackingNote, "Enter Packing Notes : ",
				PackNote);
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ContractLineNote, "Enter Contract Notes : ",
				ContractNote);
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OracleAttachment, "Enter Oracle Attachment : ",
				OracleAttachment);
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_DeliveryAttachment,
				"Enter Delivery Attachment : ", DelAttachment);
		Wait.waitfor(2);

	}

	public void saveBtn() {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_SaveBtn);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_SaveBtn,
				"Click on Save button on invoice Create Order Item Page");

	}

	public void gotoInvoiceItems() {
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_LineItemCLoseBtn);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_LineItemCLoseBtn,
				"Click on Close button on invoice Create Order Item Page");

	}

	public void hazmatDetails() {
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_AdditionalTransactionDetails,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_HazmatDetails, "Click on Hazmat Details");

	}

	public void closebtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OrderItemCloseBtn,
				"Click on Close button :");
	}

	// select valid license option from Override Export Hold button
	public void selectValidLicense(String validLicense) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn, "Click on Override Export Hold button :");
		clickElement(driver, test, "//a[contains(text(),'"+validLicense+"')]", "Selecting Valid License option :");
		//selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn, "Select valid License option : ", validLicense);
	}
	
	// select license exemption option from Override Export Hold button
		public void selectLicenseExemption(String LicenseExemption) {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn, "Click on Override Export Hold button :");
			clickElement(driver, test, "//a[contains(text(),'"+LicenseExemption+"')]", "Selecting License Exemption option :");
			//selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn, "Select valid License option : ", validLicense);
		}

		// select License Exception option from Override Export Hold button
		public void selectLicenseException(String LicenseExp) {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn, "Click on Override Export Hold button :");
			clickElement(driver, test, "(//a[contains(text(),'"+LicenseExp+"')])[2]", "Selecting License Exception option :");
			//selectByVisibleText(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_OverrideExportHoldBtn, "Select valid License option : ", validLicense);
		}
		 
	// verify Valid License from Export AUthorization Screening Pop-Up
	public void verifyValidLicense() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon,
				"Click on Export Authorization Screening Status icon :");
		String getExportScreeningStatus = getText(driver, test, "//td[contains(text(),'Valid License')]",
				"Getting the status from Export Control Screening Pop up :");
		try {
			if (getExportScreeningStatus.equalsIgnoreCase("Valid License")) {
				test.log(LogStatus.PASS, "Valid License is displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Valid License is not displayed :");
			;
		}
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningPopUpCloseBtn,
				"Close the Export Screening Status PopUp :");
	}
	
	//verify No License Required from Export AUthorization Screening Pop-Up
	public void verifyNLR() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon);
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon,
				"Click on Export Authorization Screening Status icon :");
		String getExportScreeningStatus = getText(driver, test, "//td[contains(text(),'No License Required')]",
				"Getting the status from Export Control Screening Pop up :");
		try {
			if (getExportScreeningStatus.equalsIgnoreCase("No License Required")) {
				test.log(LogStatus.PASS, "No License Required is displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "No License Required is not displayed :");
			;
		}
		clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningPopUpCloseBtn,
				"Close the Export Screening Status PopUp :");
	}
	
	//verify ITAR Exemption from Export AUthorization Screening Pop-Up
		public void verifyITARExemption() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon);
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon,
					"Click on Export Authorization Screening Status icon :");
			String getExportScreeningStatus = getText(driver, test, "//td[contains(text(),'License Exception/Itar Exemption')]",
					"Getting the status from Export Control Screening Pop up :");
			try {
				if (getExportScreeningStatus.equalsIgnoreCase("License Exception/Itar Exemption")) {
					test.log(LogStatus.PASS, "License Exception/Itar Exemption is displayed :");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "License Exception/Itar Exemption is not displayed :");
				
			}
			clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningPopUpCloseBtn,
					"Close the Export Screening Status PopUp :");
		}
		
		//verify License Exception from Export AUthorization Screening Pop-Up
				public void verifyLicenseException() {
					Wait.waitfor(2);
					scrollToElement(driver, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon);
					clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningStatusIcon,
							"Click on Export Authorization Screening Status icon :");
					String getExportScreeningStatus = getText(driver, test, "//td[contains(text(),'Valid License Exception')]",
							"Getting the status from Export Control Screening Pop up :");
					try {
						if (getExportScreeningStatus.equalsIgnoreCase("Valid License Exception")) {
							test.log(LogStatus.PASS, "Valid License Exception is displayed :");
						}
					} catch (Exception e) {
						testFailSshot(driver, test);
						test.log(LogStatus.FAIL, "Valid License Exception is not displayed :");
						
					}
					clickElement(driver, test, OCR_InvoiceCreateNewOrderItemPage_Regres_ExportAuthScreeningPopUpCloseBtn,
							"Close the Export Screening Status PopUp :");
				}
				
		
		

}
