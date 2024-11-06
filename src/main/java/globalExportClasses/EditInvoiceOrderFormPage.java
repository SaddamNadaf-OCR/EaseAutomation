package globalExportClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditInvoiceOrderFormPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Inovice_Save = "//div[@class='row btn-row']//button[3]";
	public static final String OCR_ALO_InoviceNO = "//a[@class='ead-invoice-tooltip']";
	public static final String OCR_Inovice_ID_SkipWatchListScreening = "//div[@class='lcs_switch lcs_off lcs_disabled lcs_checkbox_switch']";
	public static final String OCR_Inovice_ID_SubcomponentScreening = "(//div[@class='lcs_switch lcs_off lcs_checkbox_switch'])[1]";
	public static final String OCR_Inovice_ID_SkipExportAuthScreening = "(//div[@class='lcs_switch lcs_off lcs_checkbox_switch'])[2]";
	public static final String OCR_Inovice_AOD_ChargeNo = "//input[@id='editInvoice_invoice_chargeNo']";
	public static final String OCR_Inovice_AOD_ContractNo = "//input[@id='editInvoice_invoice_contractNo']";
	public static final String OCR_Inovice_AOD_OrderCategory = "//select[@id='editInvoice_invoice_orderCategory']";
	public static final String OCR_Inovice_AOD_Priority = "//select[@id='editInvoice_invoice_priority']";
	public static final String OCR_Inovice_AOD_SalesOrderNo = "//input[@id='editInvoice_invoice_orderNo']";
	public static final String OCR_Inovice_AOD_SalesOrderDate = "//input[@id='editInvoice_orderDate']";
	public static final String OCR_Inovice_AOD_CustomerOrderNo = "//input[@id='editInvoice_invoice_customerOrderNo']";
	public static final String OCR_Inovice_AOD_CustomerOrderDate = "//input[@id='editInvoice_customerOrderDate']";
	public static final String OCR_Inovice_AOD_LetterofCredit = "//input[@id='editInvoice_invoice_letterOfCredit']";
	public static final String OCR_Inovice_AOD_LetterofCreditExpiryDate = "//input[@id='editInvoice_letterOfCreditExpDate']";
	public static final String OCR_Inovice_AOD_NotifyPartyInstructions = "//textarea[@id='editInvoice_invoice_notifyPartyAddress']";
	public static final String OCR_Inovice_CPT_PaymentTermsLink = "//a[contains(text(),'Payment Terms')]";
	public static final String OCR_Inovice_CPT_SearchBTn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_Inovice_CPT_CloseIcon = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_Inovice_CPT_IncotermLink = "//label[@class='col-xs-2 control-label']//a[contains(text(),'Incoterm')]";
	public static final String OCR_Inovice_CPT_ForCustomsPurposeOnly = "(//div[@class='lcs_switch lcs_off lcs_checkbox_switch'])[3]";
	public static final String OCR_Inovice_CPT_DoNotPayInvoice = "(//div[@class='lcs_switch lcs_off lcs_checkbox_switch'])[4]";
	public static final String OCR_Inovice_CPT_IncotermPlace = "//input[@id='editInvoice_invoice_deliveryLocation']";
	public static final String OCR_Inovice_PT_AddMoreParties = "//button[@id='addPartyBtn']";
	public static final String OCR_Inovice_PT_AP_EntityType = "//select[@name='eType']";
	public static final String OCR_Inovice_PT_AP_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_Inovice_PT_C_ConsigneeID = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_Inovice_PT_C_Search = "//button[@name='Search']";
	public static final String OCR_Inovice_PT_C_Save = "//button[@id='entitySave']";
	public static final String OCR_Inovice_AC_AddMoreCharges = "//button[@id='addChargesBtn']";
	public static final String OCR_Inovice_AC_ChargeDescription = "//a[contains(text(),'Charge Description')]";
	public static final String OCR_Inovice_AC_Amount = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_chargeAmount']";
	public static final String OCR_Inovice_AC_ChargingAccount = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_chargingAccount']";
	public static final String OCR_Inovice_AC_GLACode = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_glaCode']";
	public static final String OCR_Inovice_AC_PrintonDocuments = "//input[@id='editTabbedInvoiceCharges_printOnForm']";
	public static final String OCR_Inovice_AC_WholesalerCharge = "//input[@id='editTabbedInvoiceCharges_internalCost']";
	public static final String OCR_Inovice_AC_Submit = "//button[@id='invChargesSubmit']";
	public static final String OCR_Inovice__CPD_AddContainerPackingDetails = "//button[@id='addCartonBtn']";
	public static final String OCR_Inovice_CPD_MarkingsContainerID = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_marking']";
	public static final String OCR_Inovice_CPD_SealNumber = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_sealNo']";
	public static final String OCR_Inovice_CPD_ConsolidatedPackNumber = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_consolidatedPackNo']";
	public static final String OCR_Inovice_CPD_Hazardous = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_hazardFlag']";
	public static final String OCR_Inovice_CPD_RadioActivityAmnt = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_radioactivityAmt']";
	public static final String OCR_Inovice_CPD_DryIce = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_dryIceFlag']";
	public static final String OCR_Inovice_CPD_DryIceQty = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_dryIceQty']";
	public static final String OCR_Inovice_CPD_GrossCartonWeight = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_cartonWeight']";
	public static final String OCR_Inovice_CPD_PackageType = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_packageType']";
	public static final String OCR_Inovice_CPD_Model = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_model']";
	public static final String OCR_Inovice_CPD_TareWeight = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_tareWeight']";
	public static final String OCR_Inovice_CPD_DimensionUOM = "//select[@id='dimensionUom']";
	public static final String OCR_Inovice_CPD_Dim_ML = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_lengthMt']";
	public static final String OCR_Inovice_CPD_Dim_MW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_widthMt']";
	public static final String OCR_Inovice_CPD_Dim_MH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_heightMt']";
	public static final String OCR_Inovice_CPD_Dim_CmL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_lengthCm']";
	public static final String OCR_Inovice_CPD_Dim_CmW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_widthCm']";
	public static final String OCR_Inovice_CPD_Dim_CmH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_heightCm']";
	public static final String OCR_Inovice_CPD_Dim_InchesL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_length']";
	public static final String OCR_Inovice_CPD_Dim_InchesW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_width']";
	public static final String OCR_Inovice_CPD_Dim_InchesH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_height']";
	public static final String OCR_Inovice_CPD_WeightUOM = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_widthUom']";
	public static final String OCR_Inovice_CPD_WeightKG_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightKg']";
	public static final String OCR_Inovice_CPD_WeightKG_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeightKg']";
	public static final String OCR_Inovice_CPD_WeightLbs_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightLbs']";
	public static final String OCR_Inovice_CPD_WeightLbs_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeight']";
	public static final String OCR_Inovice_CPD_SKUQuantity = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_skuQuantity']";
	public static final String OCR_Inovice_CPD_Class = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_cartonClass']";
	public static final String OCR_Inovice_CPD_BOLText = "//textarea[@id='editTabbedInvoiceCarton_invoiceCarton_bolText']";
	public static final String OCR_Inovice_CPD_ContainerSubmit = "//button[@id='btnSave']";
	public static final String OCR_Inovice_RP_AddReturnablePackage = "//button[@id='addReturnablePackingDetail']";
	public static final String OCR_Inovice_RP_PackageID = "//input[@id='packingDetailForm_returnablePackingDetail_returnableItemId']";
	public static final String OCR_Inovice_RP_HUNoContainerId = "//input[@id='returnablePackingDetail.huNum']";
	public static final String OCR_Inovice_RP_NoOfPkgs = "//input[@id='packingDetailForm_returnablePackingDetail_noOfPackages']";
	public static final String OCR_Inovice_RP_TypeOfPacking = "//input[@id='packingDetailForm_returnablePackingDetail_typeOfPack']";
	public static final String OCR_Inovice_RP_NetWeight = "//input[@id='packingDetailForm_returnablePackingDetail_netWeight']";
	public static final String OCR_Inovice_RP_TotalNetWeight = "//input[@id='packingDetailForm_returnablePackingDetail_totalNetWeight']";
	public static final String OCR_Inovice_RP_UnitPrice = "//input[@id='packingDetailForm_returnablePackingDetail_unitPrice']";
	public static final String OCR_Inovice_RP_TotalPrice = "//input[@id='packingDetailForm_returnablePackingDetail_totalPrice']";
	public static final String OCR_Inovice_RP_CountryofOrigin = "//input[@id='packingDetailForm_countryOfOriginName']";
	public static final String OCR_Inovice_RP_Save = "//button[@name='Save']";
	public static final String OCR_Invoice_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_Inovice_MiscellaneousDetails = "//a[contains(text(),'Miscellaneous Details')]";
	public static final String OCR_Inovice_InoiceIcon = "//i[@class='fa fa-link']";
	public static final String OCR_Inovice_SaveAndReturn = "//button[@id='saveandreturn']";
	
	public static final String OCR_Inovice_Regres_AddShipBtn = "//button[@id='addshipment']";
	public static final String OCR_Inovice_Regres_EnterInvoiceNo = "//input[@id='editInvoice_invoice_invoiceNo']";
	public static final String OCR_Inovice_Regres_SaveInvoiceNo = "(//button[@class='primary-btn invoice-btn ocr-cache-search-dynamic-class'])[1]";
	public static final String OCR_Inovice_Regres_ClickComplainceSummReportIcon = "//i[@class='fa fa-file-text-o']";
	public static final String OCR_Inovice_Regres_VerifyComplainceSummReportIconHeading = "//h4[@id='myModalLabel']";
	public static final String OCR_Inovice_Regres_ComplainceSummReportIconHeadingCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_Inovice_Regres_LinkedShipmentDetails = "//a[contains(text(),'Linked Shipment Details')]";
	public static final String OCR_Inovice_Regres_GenerateDoc = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_Inovice_Regres_EmailWithLink = "//button[@id='docEmailAsLink']";
	public static final String OCR_Inovice_Regres_Exporter_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_Inovice_Regres_GenerateAllDocumentBtn = "//button[contains(text(),'Generate All Documents')]";
	public static final String OCR_Inovice_Regres_EmailGroup = "//select[@id='sendEadPdfEmails_selectedGroup']";
	public static final String OCR_Inovice_Regres_EmailGroupDocumentTO = "//input[@id='sendEadPdfEmails_groupEmailId']/../div/div/input";
	public static final String OCR_Inovice_Regres_EmailGroupDocumentIcon = "//button[@id='groupEmailBtn']//i[@class='fa fa-envelope']";
	public static final String OCR_Inovice_Regres_EmailWithAttachment = "//button[@id='docEmailAsAttachment']";
	public static final String OCR_Inovice_Regres_MoveToInvNo = "//input[@id='editInvoice_invoice_invoiceNo']";
	public static final String OCR_Inovice_Regres_ChangeStatusBtn = "//button[@class='primary-btn dropdown-toggle inv ocr-cache-search-dynamic-class']";
	public static final String OCR_Inovice_Regres_CloseBtn = "//button[@id='cancelInvoice']";

	/* ******************************* Constructor ****************************** */

	public EditInvoiceOrderFormPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Invoice No
	public void click_InvoiceNo(String InvoiceNo) {
		clickElement(driver, test, OCR_ALO_InoviceNO, "Click on Invoice No : " + InvoiceNo);
	}
	
	//enter invoice number when copied from existing invoice Regression US
	public void enterInvoice(String InvNum) {
		Wait.waitfor(2);
		clearText(driver, test, OCR_Inovice_Regres_EnterInvoiceNo, "CLear the text : ");
		typeText(driver, test, OCR_Inovice_Regres_EnterInvoiceNo, "Enter Invoice Number : ", InvNum);
		typeText(driver, test, OCR_Inovice_Regres_EnterInvoiceNo, "Enter  Random Invoice No : ", randomnumbers());
	}
	
	//click onSave button for saving invoice copied from existing invoice for regression US
	public void saveBtn() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_Inovice_Regres_SaveInvoiceNo);
		clickElement(driver, test, OCR_Inovice_Regres_SaveInvoiceNo, "Click on Save button to save the invoice :");
	}

	// Click on Invoice Save
	public void click_InvoiceSave() {
		scrollToElement(driver, OCR_Inovice_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Inovice_Save, "Click on Invoice Save");
	}

	// Click on Additional Transaction Details and Miscellaneous Details
	public void select_MiscellaneousDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_Inovice_MiscellaneousDetails, "Click on Miscellaneous Details");
	}

	// Add invoice Details
	public void add_InvoiceDetails(String SkipWatchListScreening, String SubcomponentScreening,
			String SkipExportAuthScreening) {
		if (SkipWatchListScreening.equalsIgnoreCase("Yes"))
			clickElement(driver, test, OCR_Inovice_ID_SkipWatchListScreening,
					"Click on Skip Watch List Screening Switch to : Yes");
		if (SubcomponentScreening.equalsIgnoreCase("Yes"))
			clickElement(driver, test, OCR_Inovice_ID_SubcomponentScreening,
					"Click on Subcomponent Screening Switch to : Yes");
		if (SkipExportAuthScreening.equalsIgnoreCase("Yes"))
			clickElement(driver, test, OCR_Inovice_ID_SkipExportAuthScreening,
					"Click on Skip Export Authorisation Screening Switch to : Yes");
	}

	// Add Additional order Details
	public void addAdditionalOrderDetails(String InvoiceChargeNo, String InvoiceContractNo, String InoviceOrderCategory,
			String InovicePriority, String InoviceSalesOrderNo, String InoviceSalesOrderDate,
			String InvoiceCustomerOrderNo, String InoviceCustomerOrderDate, String InvoiceLetterofCredit,
			String InoviceLetterofCreditExpiryDate, String InoviceNotifyPartyInstructions) {
		scrollToElement(driver, OCR_Inovice_ID_SubcomponentScreening);
		Wait.waitfor(3);
		typeText(driver, test, OCR_Inovice_AOD_ChargeNo, "Enter the ChargeNo : ", InvoiceChargeNo);
		typeText(driver, test, OCR_Inovice_AOD_ContractNo, "Enter the Contract No : ", InvoiceContractNo);
		selectByVisibleText(driver, test, OCR_Inovice_AOD_OrderCategory, "select the Order Category : ",
				InoviceOrderCategory);
		selectByVisibleText(driver, test, OCR_Inovice_AOD_Priority, "Select the Priority : ", InovicePriority);
		typeText(driver, test, OCR_Inovice_AOD_SalesOrderNo, "Enter the Sales Order No : ", InoviceSalesOrderNo);
		clickElement(driver, test, OCR_Inovice_AOD_SalesOrderDate, "Click on Sales Order Date");
		date(driver, test, "Select the Sales Order Date : ", InoviceSalesOrderDate);
		typeText(driver, test, OCR_Inovice_AOD_CustomerOrderNo, "Enter the Customer Order No : ",
				InvoiceCustomerOrderNo);
		scrollToBottom(driver);
		scrollToBottom(driver);
		if(InoviceCustomerOrderDate.length()>0) {
		clickElement(driver, test, OCR_Inovice_AOD_CustomerOrderDate, "Click on Customer Order(PO) Date");
		date(driver, test, "Select the Customer Order (PO) Date : ", InoviceCustomerOrderDate);
		}
		typeText(driver, test, OCR_Inovice_AOD_LetterofCredit, "Enter the Letter of Credit : ", InvoiceLetterofCredit);
		if(InoviceLetterofCreditExpiryDate.length()>0) {
		clickElement(driver, test, OCR_Inovice_AOD_LetterofCreditExpiryDate, "Click on Letter of Credit Expiry Date");
		date(driver, test, "Select the Letter of Credit Expiry Date : ", InoviceLetterofCreditExpiryDate);
		}
		typeText(driver, test, OCR_Inovice_AOD_NotifyPartyInstructions, "Enter the Notify Party Instructions : ",
				InoviceNotifyPartyInstructions);
	}

	// Add currency And Payment Terms
	public void addCurrencyAndPayment(String PaymentID, String IncotermCode, String IncotermPlace) {
		if (PaymentID.length() > 0) {
			clickElement(driver, test, OCR_Inovice_CPT_PaymentTermsLink, "Click on Payment Terms Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + PaymentID + "')]",
						"select the Payment ID : " + PaymentID);
				clickElement(driver, test, OCR_Inovice_CPT_SearchBTn, "Click on Search");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on CLose pop up icon");
			}
		}
		Wait.waitfor(2);
		if (IncotermCode.length() > 0) {
			clickElement(driver, test, OCR_Inovice_CPT_IncotermLink, "Click on Incoterm Link");
			try {
				clickElement(driver, test, "//td[contains(text(),'" + IncotermCode + "')]",
						"Select the Incoterm code : " + IncotermCode);
				clickElement(driver, test, OCR_Inovice_CPT_SearchBTn, "Click on Search");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on CLose pop up icon");
			}
		}
		typeText(driver, test, OCR_Inovice_CPT_IncotermPlace, "Enter the Incoterm Place : ", IncotermPlace);
	}

	// Add Parties to the Transaction
	public void addPartiesToTransaction(String EntityType, String AddPartyConsigneeID) {
		if (EntityType.length() > 0) {
			scrollToElement(driver, OCR_Inovice_AOD_LetterofCredit);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Inovice_PT_AddMoreParties, "Click on Add More Parties");
			try {
				selectByVisibleText(driver, test, OCR_Inovice_PT_AP_EntityType, "Select the Entity Type : ",
						EntityType);
				clickElement(driver, test, OCR_Inovice_PT_AP_Code, "Click on Add Party Code");
				typeText(driver, test, OCR_Inovice_PT_C_ConsigneeID, "Enter the Add Party ConsigneeID : ",
						AddPartyConsigneeID);
				clickElement(driver, test, OCR_Inovice_PT_C_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + AddPartyConsigneeID + "')]",
						"Select the Consignee Code : " + AddPartyConsigneeID);
				clickElement(driver, test, OCR_Inovice_CPT_SearchBTn, "Click on Select button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Inovice_PT_C_Save, "Click on Add Party Save");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on CLose pop up icon");
			}
		}
	}

	// Add Additional Charges
	public void addAdditionalCharges(String AdditionalCharges, String TansAmount, String ChargingAccount,
			String GLACode, String WholesalerCharge, String PrintonDocuments) {
		if (AdditionalCharges.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Inovice_AC_AddMoreCharges, "Click on Add More Charges");
			try {
				clickElement(driver, test, OCR_Inovice_AC_ChargeDescription, "Click on Charge Description");
				clickElement(driver, test, "//td[contains(text(),'" + AdditionalCharges + "')]",
						"Select the Charges : " + AdditionalCharges);
				clickElement(driver, test, OCR_Inovice_CPT_SearchBTn, "Click on Select button");
				typeText(driver, test, OCR_Inovice_AC_Amount, "Enter the Amount : ", TansAmount);
				typeText(driver, test, OCR_Inovice_AC_ChargingAccount, "Enter the Charging Account : ",
						ChargingAccount);
				typeText(driver, test, OCR_Inovice_AC_GLACode, "Enter the GLA Code : ", GLACode);
				if (WholesalerCharge.equalsIgnoreCase("Yes"))
					clickElement(driver, test, OCR_Inovice_AC_WholesalerCharge, "Click on Wholesaler Charge Check box");
				if (PrintonDocuments.equalsIgnoreCase("yes"))
					clickElement(driver, test, OCR_Inovice_AC_PrintonDocuments,
							"Click on Print on Documents Check box");
				clickElement(driver, test, OCR_Inovice_AC_Submit, "Click on Submit in Add Transaction Charge");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on CLose pop up icon");
			}
		}
	}

	// Adding the Container/Packing Details
	public void addContainerPackingDetails(String MarkingsContainerID, String SealNumber, String ConsolidatedPackNumber,
			String Hazardous, String RadioActivityAmnt, String DryIce, String GrossCartonWeight,
			String PackageType, String Model, String TareWeight, String DimensionUOM, String LenghtWidthHight,
			String WeightUOM, String GrossNet, String SKUQuantity, String Class, String BOLText) {
		if (MarkingsContainerID.length() > 0) {
			scrollToElement(driver, OCR_Inovice__CPD_AddContainerPackingDetails);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Inovice__CPD_AddContainerPackingDetails,
					"Click on Add Container Packing Details ");
			try {
				typeText(driver, test, OCR_Inovice_CPD_MarkingsContainerID, "Enter the Marking Container ID : ",
						MarkingsContainerID);
				typeText(driver, test, OCR_Inovice_CPD_SealNumber, "Enter the Seal Number : ", SealNumber);
				typeText(driver, test, OCR_Inovice_CPD_ConsolidatedPackNumber, "Enter the Consolidated Pack Number : ",
						ConsolidatedPackNumber);
				selectByVisibleText(driver, test, OCR_Inovice_CPD_Hazardous, "Select the Hazardous : ", Hazardous);
				typeText(driver, test, OCR_Inovice_CPD_RadioActivityAmnt, "Enter the Radio Activity Amnt : ",
						RadioActivityAmnt);
				selectByVisibleText(driver, test, OCR_Inovice_CPD_DryIce, "Select the Dry Ice : ", DryIce);
		//		typeText(driver, test, OCR_Inovice_CPD_DryIceQty, "Enter the Dry ice quantity : ", DryIceQty);
				typeText(driver, test, OCR_Inovice_CPD_GrossCartonWeight, "Enter the Gross Carton Weight : ",
						GrossCartonWeight);
				typeText(driver, test, OCR_Inovice_CPD_PackageType, "Enter the Package Type : ", PackageType);
				typeText(driver, test, OCR_Inovice_CPD_Model, "Enter the MOdel : ", Model);
				typeText(driver, test, OCR_Inovice_CPD_TareWeight, "Enter the Tare Weight : ", TareWeight);

				selectByVisibleText(driver, test, OCR_Inovice_CPD_DimensionUOM, "Select the Dimension UOM : ",
						DimensionUOM);
				ArrayList<String> LWH = GenericMethods.stringtoken(LenghtWidthHight);
				if (DimensionUOM.contains("Inches")) {
					typeText(driver, test, OCR_Inovice_CPD_Dim_InchesL, "Enter the inches(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_Inovice_CPD_Dim_InchesW, "Enter the inches(width) : ", LWH.get(1));
					typeText(driver, test, OCR_Inovice_CPD_Dim_InchesH, "Enter the inches(Height) : ", LWH.get(2));
				}
				if (DimensionUOM.contains("Centimeters")) {
					typeText(driver, test, OCR_Inovice_CPD_Dim_CmL, "Enter the CM(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_Inovice_CPD_Dim_CmW, "Enter the CM(width) : ", LWH.get(1));
					typeText(driver, test, OCR_Inovice_CPD_Dim_CmH, "Enter the CM(Height) : ", LWH.get(2));
				}
				if (DimensionUOM.contains("Meters")) {
					typeText(driver, test, OCR_Inovice_CPD_Dim_ML, "Enter the M(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_Inovice_CPD_Dim_MW, "Enter the M(width) : ", LWH.get(1));
					typeText(driver, test, OCR_Inovice_CPD_Dim_MH, "Enter the M(Height) : ", LWH.get(2));
				}
				selectByVisibleText(driver, test, OCR_Inovice_CPD_WeightUOM, "Select the Weight UOM : ", WeightUOM);
				ArrayList<String> GN = GenericMethods.stringtoken(GrossNet);
				if (WeightUOM.contains("Kilograms")) {
					typeText(driver, test, OCR_Inovice_CPD_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
					typeText(driver, test, OCR_Inovice_CPD_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
				}
				if (WeightUOM.contains("Pounds")) {
					typeText(driver, test, OCR_Inovice_CPD_WeightLbs_Gross, "Enter the Pounds(Gross) : ", GN.get(0));
					typeText(driver, test, OCR_Inovice_CPD_WeightLbs_Net, "Enter the Pounds(Net) : ", GN.get(1));
				}
				typeText(driver, test, OCR_Inovice_CPD_SKUQuantity, "Enter the SKU Quantity : ", SKUQuantity);
				typeText(driver, test, OCR_Inovice_CPD_Class, "Enter the Class : ", Class);
				typeText(driver, test, OCR_Inovice_CPD_BOLText, "Enter the BOL Text : ", BOLText);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Inovice_CPD_ContainerSubmit,
						"click on Container/Packing Details Submit button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on Cancel popup icon");
			}
		}
	}

	// Add Returnable Packages
	public void addReturnablePackage(String PackageID, String HUNoContainerId, String NoOfPkgs, String TypeOfPacking,
			String NetWeight, String TotalNetWeight, String UnitPrice, String TotalPrice, String CountryofOrigin) {
		if (PackageID.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Inovice_RP_AddReturnablePackage, "Enter the Add Returnable Package");
			try {
				typeText(driver, test, OCR_Inovice_RP_PackageID, "Enter the Package ID : ", PackageID);
				typeText(driver, test, OCR_Inovice_RP_HUNoContainerId, "Enter the HUNoContainerId : ", HUNoContainerId);
				typeText(driver, test, OCR_Inovice_RP_NoOfPkgs, "Enter the No Of Pkgs :  ", NoOfPkgs);
				typeText(driver, test, OCR_Inovice_RP_TypeOfPacking, "Enter the Type Of Packing : ", TypeOfPacking);
				typeText(driver, test, OCR_Inovice_RP_NetWeight, "Enter the Net Weight : ", NetWeight);
				typeText(driver, test, OCR_Inovice_RP_TotalNetWeight, "Enter the Total Net Weight : ", TotalNetWeight);
				typeText(driver, test, OCR_Inovice_RP_UnitPrice, "Enter the Unit Price : ", UnitPrice);
				typeText(driver, test, OCR_Inovice_RP_TotalPrice, "Enter the Total Price : ", TotalPrice);
				typeText(driver, test, OCR_Inovice_RP_CountryofOrigin, "Enter the Country of Origin : ",
						CountryofOrigin);
				clickElement(driver, test, "//input[@id='packingDetailForm_returnablePackingDetail_currency']",
						"Mouse over to save button");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Inovice_RP_Save, "Click on Save in Add Returnable Package Details");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on Cancel popup icon");
			}
		}
	}

	// Click on Invoice icon
	public void click_InvoiceIcon() {
		clickElement(driver, test, OCR_Inovice_InoiceIcon, "Click on Invoice Link");
	}

	// Get the Consolidate Invoices Shipment NO
	public String getShipmentNo() {
		return getAttribute(driver, test, "//input[@id='linkInvoice_shipment_shipmentNo']", "value",
				"Get the Shipment no : ");
	}

	// Get the Consolidate Invoices Ult. Consignee Code
	public String getUltConsigneeCode() {
		return getAttribute(driver, test, "//input[@id='linkInvoice_ultConsigneeCode']", "value",
				"Get the Ult. Consignee Code : ");
	}

	// Get the Consolidate Invoices Status
	public String getStatus() {
		return getAttribute(driver, test, "//input[@id='linkInvoice_shipmentStatusLabel']", "value",
				"Get the Status : ");
	}

	// Get the Consolidate Invoices Ult. Consignee Name
	public String getUltConsigneeName() {
		return getAttribute(driver, test, "//input[@id='linkInvoice_ultConsigneeName']", "value",
				"Get the Ult. Consignee Name : ");
	}

	// Get the Invoice NO
	public String getInvoiceNo() {
		return getText(driver, test, "(//span[@class='additional-value'])[1]", "Get the Invoice No : ");
	}

	// Get the Invoice Status
	public String getInvoiceStatus() {
		return getText(driver, test, "(//span[@class='additional-value'])[2]", "Get the Work Status : ");
	}

	/*
	 * //Get the Invoice NO public void getInvoiceNo() { getText(driver, test,
	 * "//table[@id='grid-link']//tr[2]/td[2]", "Get the Invoice No : "); }
	 */

	// Click on pop close button
	public void popclose() {
		clickElement(driver, test, OCR_Inovice_CPT_CloseIcon, "Click on pop close");
	}

	// Select the linked invoice
	public String selectLinkedInvoice(String LinkedInvoice) {
		selectByVisibleText(driver, test, "//select[@id='linkedInvoices']", "Select the Linked Invoice : ", LinkedInvoice);
		Wait.waitfor(3);
		clickElement(driver, test, "//button[@class='primary-btn btn-xs multiselect_to']",
				"click on view invoice details");
		return getText(driver, test, "//div[@class='modal-body']//div[2]//div[1]//table[1]//tr/td[2]",
				"Get the Part No : ");
	}
	
	//Click on Save and return
	public void click_InoviceSaveAndReturn() {
		clickElement(driver, test, OCR_Inovice_SaveAndReturn, "Click on Save and Return");
	}
	
	//click on Add Shipment Button for Regression US
	public void addShipment() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Inovice_Regres_AddShipBtn, "Click on Add Shipment Button :");
	}
	
	//click on Complaince Summary Report for Regresison US
	public void clickCompSummReportIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Inovice_Regres_ClickComplainceSummReportIcon, "CLick on Complaince Summary Report :");
		
		if(isDisplayed(driver, OCR_Inovice_Regres_VerifyComplainceSummReportIconHeading)) {
			Wait.fluwait(driver, OCR_Inovice_Regres_VerifyComplainceSummReportIconHeading);
			test.log(LogStatus.PASS,
					"Transaction Compliance Screening Summary Report is Displayed  !!");
		}
		else {
			test.log(LogStatus.FAIL,
					"Transaction Compliance Screening Summary Report is not Displayed  !!");
		}
	}
	
	//click on close button of Compliance summary report for Regression US
	public void clickCloseBtnTransacSummReport() {
		Wait.waitfor(2);
		
		clickElement(driver, test, OCR_Inovice_Regres_ComplainceSummReportIconHeadingCloseBtn, "Click on Pop up close button :");

}
	/// Click on Additional Transaction Details and Linked Shipment Details
	public void select_LinkedShipmentDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Invoice_AdditionalInformation, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_Inovice_Regres_LinkedShipmentDetails, "Click on Linked Shipment Details");
	}
	
	// click on Generate document icon
		public void Click_GenerateDocument() {
			clickElement(driver, test, OCR_Inovice_Regres_GenerateDoc, "Click on Generate Documents Icon");
		}
	
		
		// Validating the Generate Document
		public void validateDocument(String EmailGroup, String EmailDocumentTo) {
			clickElement(driver, test, OCR_Inovice_Regres_GenerateAllDocumentBtn,
					"CLick on Generate All Document Button");
			Wait.waitfor(30);
			try {
				selectByVisibleText(driver, test, OCR_Inovice_Regres_EmailGroup, "Select the Email Group : ",
						EmailGroup);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Inovice_Regres_EmailGroupDocumentTO, "Click Eamil Document To");
				typeText(driver, test, OCR_Inovice_Regres_EmailGroupDocumentTO, "Enter the Eamil Document to : ",
						EmailDocumentTo);
				clickElement(driver, test, OCR_Inovice_Regres_EmailGroupDocumentIcon, "Click on Email Document Icon");
				Wait.waitfor(5);
				try {
					if (isDisplayed(driver, "//div[@class='row ocr-info']//h4[contains(text(),'Information!')]")) {

						if (isDisplayed(driver, "//li[contains(text(),'Email sent successfully.')]")) {
							test.log(LogStatus.INFO, "Email sent successfully.");
						}
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Email sent successfully. Information message is not Displayed ");
				}
				Wait.waitfor(3);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Inovice_Regres_Exporter_PopupClose, "Click on Pop up Close button");
			}
		}
		
		// Select Commercial invoice and Click on Send email with attachment
				public void clickSendEmailWithAttachment(String emailID) {

					try {
						List<WebElement> listOfElements = driver
								.findElements(By.xpath("//div[@class='ocr-modal-cont']//input[@class='docSelectedSet']"));
						for (int i = 1; i <= listOfElements.size(); i++) {
							clickElement(driver, test,
									"(//div[@class='ocr-modal-cont']//input[@class='docSelectedSet'])" + "[" + i + "]",
									"Deselect the Documents check box : " + i);
						}
						clickElement(driver, test, "(//div[@class='ocr-modal-cont']//input[@class='docSelectedSet'])[16]",
								"Select the Commercial Invoice");
						Wait.waitfor(2);
						scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[16]");
						Wait.waitfor(2);
						clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[16]", "Enter Email ID");
						Wait.waitfor(2);
						
						typeText(driver, test, "(//input[@autocomplete='new-password'])[18]", "Enter Email ID to send the link : ", emailID);
						Wait.waitfor(2);
						scrollToElement(driver, OCR_Inovice_Regres_EmailWithAttachment);
						clickElement(driver, test, OCR_Inovice_Regres_EmailWithAttachment, "click on Send email with Attachment");
						Wait.waitfor(5);
						try {
							if (isDisplayed(driver, "//div[@class='row ocr-info']//h4[contains(text(),'Information!')]")) {

								if (isDisplayed(driver, "//li[contains(text(),'Email sent successfully.')]")) {
									test.log(LogStatus.INFO, "Email sent successfully.");
								}
							}
						} catch (Exception e) {
							testFailSshot(driver, test);
							test.log(LogStatus.FAIL, "Email not sent successfully. Information message is not Displayed ");
						}
						Wait.waitfor(3);
						clickElement(driver, test, OCR_Inovice_Regres_Exporter_PopupClose, "Click on Pop up Close button");
						
					} catch (Exception e) {
						testFailSshot(driver, test);
						clickElement(driver, test, OCR_Inovice_Regres_Exporter_PopupClose, "Click on Pop up Close button");
					}
				}
				
				public void scrollToInvNo() {
					Wait.waitfor(2);
					scrollToElement(driver, OCR_Inovice_Regres_MoveToInvNo);
				}

		//click Change Status button on Invoice Order Form
				public void changeStatus(String ChangeStatus) {
					Wait.waitfor(2);
					scrollToElement(driver, OCR_Inovice_Regres_ChangeStatusBtn);
					clickElement(driver, test, OCR_Inovice_Regres_ChangeStatusBtn, "Click on Change Status button. :");
					Wait.waitfor(2);
					clickElement(driver, test, "//a[contains(text(),'"+ChangeStatus+"')]", "Select status : ");
				//	selectByVisibleText(driver, test, "//a[contains(text(),'"+ChangeStatus+"')]", "Select status : ", ChangeStatus);
				}
				
			//click on Close button 
				public void closeBtn() {
					Wait.waitfor(2);
					clickElement(driver, test, OCR_Inovice_Regres_CloseBtn, "Click on Close button :");
				}
}
