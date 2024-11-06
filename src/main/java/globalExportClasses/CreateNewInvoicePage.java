package globalExportClasses;

import java.awt.Checkbox;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.python.antlr.PythonParser.testlist_gexp_return;

import com.gargoylesoftware.htmlunit.html.DisabledElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewInvoicePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewInvoicePage_OrderNo = "//input[@name='invoice.invoiceNo']";
	public static final String OCR_CreateNewInvoicePage_UltDestination = "//input[@name='invoice.countryOfUltDest']";
	public static final String OCR_CreateNewInvoicePage_MOT = "(//a[contains(text(),'Mode of Transport')])[2]";
	public static final String OCR_CreateNewInvoicePage_SelectMOT = "//button[contains(@name,'Ok')]";
	public static final String OCR_CreateNewInvoicePage_CloseMOTPopUp = "//button[contains(@class,'btn-close')]";
	public static final String OCR_CreateNewInvoicePage_AddPartyBtn = "//button[@id='addPartyBtn']";
	public static final String OCR_CreateNewInvoicePage_SelectEntityType = "//select[@id='selectedParty']";
	public static final String OCR_CreateNewInvoicePage_EntityCode = "//a[contains(@name,'entityCodeLink')]";
	public static final String OCR_CreateNewInvoicePage_Status = "//select[@name='popupValue.status']";
	public static final String OCR_CreateNewInvoicePage_FFCode = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewInvoicePage_SearchConsignee = "//button[@name='Search']";
	public static final String OCR_CreateNewInvoicePage_SelectConsignee = "//button[@name='Ok']";
	public static final String OCR_CreateNewInvoicePage_CloseBtnConsignee = "//button[@class='btn-close']";
	public static final String OCR_CreateNewInvoicePage_AddPartySaveBtn = "//button[@id='entitySave']";
	public static final String OCR_CreateNewInvoicePage_AddMorePartiesBtn = "//button[@id='addPartyBtn']";
	public static final String OCR_CreateNewInvoicePage_AddContainerBtn = "//button[@id='addCartonBtn']";
	public static final String OCR_CreateNewInvoicePage_MarkingContainerID = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_marking']";
	public static final String OCR_CreateNewInvoicePage_DimensionUOM = "//select[@id='dimensionUom']";
	public static final String OCR_CreateNewInvoicePage_DimInchesL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_length']";
	public static final String OCR_CreateNewInvoicePage_DimInchesW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_width']";
	public static final String OCR_CreateNewInvoicePage_DimInchesH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_height']";
	public static final String OCR_CreateNewInvoicePage_WeightUOM = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_widthUom']";
	public static final String OCR_CreateNewInvoicePage_WeightKG_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightKg']";
	public static final String OCR_CreateNewInvoicePage_WeightKG_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeightKg']";
	public static final String OCR_CreateNewInvoicePage_ContainerSubmit = "//button[@id='btnSave']";
	public static final String OCR_CreateNewInvoicePage_InvPageSaveBtn = "//button[contains(text(),'Save')]";
	public static final String OCR_CreateNewInvoicePage_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_CreateNewInvoicePage_Items = "//a[@class='eo-tab'][contains(text(),'Items')]";

	// Locators for Regression use Cases
	public static final String OCR_CreateNewInvoicePage_Regres_AssignedTo = "//a[@id='assignedTo-popup']";
	public static final String OCR_CreateNewInvoicePage_Regres_userFT = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_CreateNewInvoicePage_Regres_userSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewInvoicePage_Regres_userSelect = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_userPopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_ExportDate = "//input[@id='editInvoice_exportDate']";
	public static final String OCR_CreateNewInvoicePage_Regres_Region = "(//a[contains(text(),'Region')])[4]";
	public static final String OCR_CreateNewInvoicePage_Regres_RegionSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_RegionSelect = "(//td[@aria-describedby='gridPopup_regionName'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_RegionPopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_CreateNewInvoicePage_Regres_SegmentSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_SegmentPopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_Site = "(//a[contains(text(),'Site')])[4]";
	public static final String OCR_CreateNewInvoicePage_Regres_SiteEnter = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String OCR_CreateNewInvoicePage_Regres_SiteSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewInvoicePage_Regres_SiteSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_SitePopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_ChargeNo = "//input[@id='editInvoice_invoice_chargeNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_ContractNo = "//input[@id='editInvoice_invoice_contractNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_orderCategory = "//select[@id='editInvoice_invoice_orderCategory']";
	public static final String OCR_CreateNewInvoicePage_Regres_Priority = "//select[@id='editInvoice_invoice_priority']";
	public static final String OCR_CreateNewInvoicePage_Regres_RMANo = "//input[@id='editInvoice_invoice_rmaNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_SalesOrderNo = "//input[@id='editInvoice_invoice_orderNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_SalesOrderDate = "//input[@id='editInvoice_orderDate']";
	public static final String OCR_CreateNewInvoicePage_Regres_CustOrderNo = "//input[@id='editInvoice_invoice_customerOrderNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_CustOrderDate = "//input[@id='editInvoice_customerOrderDate']";
	public static final String OCR_CreateNewInvoicePage_Regres_LOC = "//input[@id='editInvoice_invoice_letterOfCredit']";
	public static final String OCR_CreateNewInvoicePage_Regres_LOCExpiryDate = "//input[@id='editInvoice_letterOfCreditExpDate']";
	public static final String OCR_CreateNewInvoicePage_Regres_NotifypartyInst = "//textarea[@id='editInvoice_invoice_notifyPartyAddress']";
	public static final String OCR_CreateNewInvoicePage_Regres_PaymentLink = "//a[contains(text(), 'Payment Terms')]";
	public static final String OCR_CreateNewInvoicePage_Regres_Payment = "//input[@id='editInvoice_invoice_terms']";
	public static final String OCR_CreateNewInvoicePage_Regres_PaymentSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_PaymentPopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_IncotermsLink = "(//a[contains(text(),'Incoterms')])[2]";
	public static final String OCR_CreateNewInvoicePage_Regres_IncotermSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_IncotermPopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_IncotermPlace = "//input[@id='editInvoice_invoice_deliveryLocation']";
	public static final String OCR_CreateNewInvoicePage_Regres_ShipToCode = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewInvoicePage_Regres_BillToCode = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";

	public static final String OCR_CreateNewInvoicePage_Regres_AdditionalCharge = "//button[@id='addChargesBtn']";
	public static final String OCR_CreateNewInvoicePage_Regres_ChargesDesc = "//a[contains(text(),'Charge Description')]";
	public static final String OCR_CreateNewInvoicePage_Regres_ChargesSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_ChargesPopClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_Amount = "//input[@name='invoiceCharge.chargeAmount']";
	public static final String OCR_CreateNewInvoicePage_Regres_ChargingAccnt = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_chargingAccount']";
	public static final String OCR_CreateNewInvoicePage_Regres_GLACode = "//input[@id='editTabbedInvoiceCharges_invoiceCharge_glaCode']";
	public static final String OCR_CreateNewInvoicePage_Regres_WholesaleCharge = "//input[@id='editTabbedInvoiceCharges_internalCost']";
	public static final String OCR_CreateNewInvoicePage_Regres_PrintDoc = "//input[@id='editTabbedInvoiceCharges_printOnForm']";
	public static final String OCR_CreateNewInvoicePage_Regres_ChargeSubmitBtn = "//button[@id='invChargesSubmit']";
	public static final String OCR_CreateNewInvoicePage_Regres_SealNo = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_sealNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_ConsolPackNo = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_consolidatedPackNo']";
	public static final String OCR_CreateNewInvoicePage_Regres_RadioActiAmnt = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_radioactivityAmt']";
	public static final String OCR_CreateNewInvoicePage_Regres_DryIceQty = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_dryIceQty']";
	public static final String OCR_CreateNewInvoicePage_Regres_GrossCartonWt = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_cartonWeight']";
	public static final String OCR_CreateNewInvoicePage_Regres_PackType = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_packageType']";
	public static final String OCR_CreateNewInvoicePage_Regres_Model = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_model']";
	public static final String OCR_CreateNewInvoicePage_Regres_TareWt = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_tareWeight']";
	public static final String OCR_CreateNewInvoicePage_Regres_SKUQty = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_skuQuantity']";
	public static final String OCR_CreateNewInvoicePage_Regres_Class = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_cartonClass']";
	public static final String OCR_CreateNewInvoicePage_Regres_BOLText = "//textarea[@id='editTabbedInvoiceCarton_invoiceCarton_bolText']";
	public static final String OCR_CreateNewInvoicePage_Regres_ReturnPackge = "//button[contains(text(),'Add Returnable Package')]";
	public static final String OCR_CreateNewInvoicePage_Regres_PackgeID = "//input[@id='packingDetailForm_returnablePackingDetail_returnableItemId']";
	public static final String OCR_CreateNewInvoicePage_Regres_ContID = "(//input[@id='returnablePackingDetail.huNum'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_NoOfPack = "(//input[@id='packingDetailForm_returnablePackingDetail_noOfPackages'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_TypeOfPack = "(//input[@id='packingDetailForm_returnablePackingDetail_typeOfPack'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_UnitPrice = "(//input[@id='packingDetailForm_returnablePackingDetail_unitPrice'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_COO = "(//input[@id='packingDetailForm_countryOfOriginName'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_SaveReturnPackage = "(//button[@name='Save'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_EntityScreeningStatus = "(//i[@class='fa fa-user'])";
	public static final String OCR_CreateNewInvoicePage_Regres_ExpoAuthScreeningStatus = "(//i[@class='fa fa-legal'])";
	public static final String OCR_CreateNewInvoicePage_Regres_IconPopUpClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_GenerateDocs = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_CreateNewInvoicePage_Regres_ComplianceSummReport = "//i[@class='fa fa-file-text-o']";
	public static final String OCR_CreateNewInvoicePage_Regres_UploadFileAttachment = "//i[@class='fa fa-upload']";
	public static final String OCR_CreateNewInvoicePage_Regres_navigateToContDetails = "(//button[@class='primary-btn ocr-cache-search-dynamic-class'])[3]";
	public static final String OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusIcon = "//i[@class='fa fa-user']";
	public static final String OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewInvoicePage_Regres_ExportAuthScreeningToNo = "(//div[@class='lcs_cursor'])[3]";
	public static final String OCR_CreateNewInvoicePage_Regres_SelectOrderTitle = "//select[@id='editInvoice_invoice_invoiceTitle']";
	public static final String OCR_EditShipment_AddShipmentButton = "//button[@name='addshipment']";
	
	
	
	/* ******************************* Constructor ****************************** */

	public CreateNewInvoicePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void invoice_Details(String orderNo, String ultDest, String ModeOfTransport) {
		typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter Order Number : ", orderNo);
		typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter  Random ShipmentNo : ", randomnumbers());
		typeText(driver, test, OCR_CreateNewInvoicePage_UltDestination, "Enter Ultimate Destination : ", ultDest);

		try {
			if (ModeOfTransport.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_MOT, "Click on Mode Of Transport");
				clickElement(driver, test, "//td[contains(text(),'" + ModeOfTransport + "')]",
						"Click on Mode Of transport : " + ModeOfTransport);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectMOT, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_CloseMOTPopUp, "Click on Pop up Close button");
		}

	}

	// Regression Invoice Header Details
	public void invoice_Details(String orderNo, String AssignedTo, String ExportDate, String ultDest,
			String ModeOfTransport) {
		clearText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Clear invoice no :");
		typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter Order Number : ", orderNo);
		typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter  Random Invoice No : ", randomnumbers());
		try {
			if (AssignedTo.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_AssignedTo, "Click on Assigned To");
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_userFT, "Enter User First name : ", AssignedTo);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userSearch, "Click on Seach button");
				clickElement(driver, test, "//td[contains(text(),'" + AssignedTo + "')]",
						"Click on User : " + AssignedTo);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userSelect, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userPopClose, "Click on Pop up Close button");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ExportDate, "Click on Export Date :");
		date(driver, test, "Select the Date : ", ExportDate);
		typeText(driver, test, OCR_CreateNewInvoicePage_UltDestination, "Enter Ultimate Destination : ", ultDest);

		try {
			if (ModeOfTransport.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_MOT, "Click on Mode Of Transport");
				clickElement(driver, test, "//td[contains(text(),'" + ModeOfTransport + "')]",
						"Click on Mode Of transport : " + ModeOfTransport);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectMOT, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_CloseMOTPopUp, "Click on Pop up Close button");
		}

	}
	
	// Regression Invoice Header Details
		public void invoice_Details(String orderNo, String AssignedTo, String OrderTitle, String ExportDate, String ultDest,
				String ModeOfTransport) {
			clearText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Clear invoice no :");
			typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter Order Number : ", orderNo);
			typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter  Random Invoice No : ", randomnumbers());
			try {
				if (AssignedTo.length() > 0) {
					Wait.waitfor(2);
					clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_AssignedTo, "Click on Assigned To");
					typeText(driver, test, OCR_CreateNewInvoicePage_Regres_userFT, "Enter User First name : ", AssignedTo);
					clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userSearch, "Click on Seach button");
					clickElement(driver, test, "//td[contains(text(),'" + AssignedTo + "')]",
							"Click on User : " + AssignedTo);
					clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userSelect, "Click on Select button");

				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userPopClose, "Click on Pop up Close button");
			}
			Wait.waitfor(2);
			
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SelectOrderTitle, "Click on Order Title :");
			selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Regres_SelectOrderTitle, "Select Order Title : ", OrderTitle);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ExportDate, "Click on Export Date :");
			date(driver, test, "Select the Date : ", ExportDate);
			typeText(driver, test, OCR_CreateNewInvoicePage_UltDestination, "Enter Ultimate Destination : ", ultDest);

			try {
				if (ModeOfTransport.length() > 0) {
					Wait.waitfor(2);
					clickElement(driver, test, OCR_CreateNewInvoicePage_MOT, "Click on Mode Of Transport");
					clickElement(driver, test, "//td[contains(text(),'" + ModeOfTransport + "')]",
							"Click on Mode Of transport : " + ModeOfTransport);
					clickElement(driver, test, OCR_CreateNewInvoicePage_SelectMOT, "Click on Select button");

				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseMOTPopUp, "Click on Pop up Close button");
			}

		}
	

	// Invoice Details for Authorization for Regression US
	public void invoice_Details(String orderNo, String AssignedTo, String ExportDate, String ModeOfTransport) {
		clearText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Clear invoice no :");
		typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter Order Number : ", orderNo);
		typeText(driver, test, OCR_CreateNewInvoicePage_OrderNo, "Enter  Random Invoice No : ", randomnumbers());
		try {
			if (AssignedTo.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_AssignedTo, "Click on Assigned To");
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_userFT, "Enter User First name : ", AssignedTo);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userSearch, "Click on Seach button");
				clickElement(driver, test, "//td[contains(text(),'" + AssignedTo + "')]",
						"Click on User : " + AssignedTo);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userSelect, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_userPopClose, "Click on Pop up Close button");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ExportDate, "Click on Export Date :");
		date(driver, test, "Select the Date : ", ExportDate);

		try {
			if (ModeOfTransport.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_MOT, "Click on Mode Of Transport");
				clickElement(driver, test, "//td[contains(text(),'" + ModeOfTransport + "')]",
						"Click on Mode Of transport : " + ModeOfTransport);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectMOT, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_CloseMOTPopUp, "Click on Pop up Close button");
		}

	}

	// Additional Order Details
	public void addOrderDetails(String Program, String Segment, String Site, String ChargeNo, String ContractNo,
			String OrderCategory, String Priority, String RMANo, String SalesOrderNo, String SalesOrderDate,
			String CustOrderNo, String CustOrderDate, String LOC, String LOCExpiryDate, String NotifyParty) {
		clickElement(driver, test, "(//a[contains(text(),'Program')])[3]", "Click on Program Link");
		try {
			typeText(driver, test, "//input[@id='searchForm_programTab_programCode']", "Enter the Program Code : ",
					Program);
			clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Select");
			clickElement(driver, test, "//td[contains(text(),'" + Program + "')]", "Select the Consignee : " + Program);
			clickElement(driver, test, OCR_CreateNewInvoicePage_SelectMOT, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_CloseMOTPopUp, "Click on Close popup icon");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_Region, "Click on Region Link");
		try {
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_RegionSelect, "Select the Region : ");
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_RegionSelectBtn, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_RegionPopClose, "Click on Close popup icon");
		}

		try {
			if (Segment.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_Segment, "Click on Segment Link");
				Wait.waitfor(2);
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_segmentCode'])[1]",
						"Select the Segment : ");
				// System.out.println("Print segment");
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SegmentSelectBtn, "Click on Select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SegmentPopClose, "Click on Close popup icon");
		}

		try {
			if (Site.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_Site, "Click on Site Link");
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_SiteEnter, "Enter the Site : ", Site);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SiteSearch, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + Site + "')]", "Select the Site : " + Site);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SiteSelectBtn, "Click on Select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SitePopClose, "Click on Close popup icon");
		}
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ChargeNo, "Enter Charge No : ", ChargeNo);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ContractNo, "Enter Contract No : ", ContractNo);
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Regres_orderCategory, "Select Order Category : ",
				OrderCategory);
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Regres_Priority, "Select Priority : ", Priority);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_RMANo, "Enter RMA No : ", RMANo);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_SalesOrderNo, "Enter Sales order no : ", SalesOrderNo);

		if (SalesOrderDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SalesOrderDate, "Click on Sales Order Date");
			date(driver, test, "Select the Sales Order Date : ", SalesOrderDate);
		}
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_CustOrderNo, "Enter Customer Order No : ", CustOrderNo);
		if (CustOrderDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_CustOrderDate, "Click on Customer Order Date");
			date(driver, test, "Select the Customer Order Date : ", CustOrderDate);
		}
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_LOC, "Enter LOC : ", LOC);
		if (LOCExpiryDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_LOCExpiryDate, "Click on LOC Expiry Date");
			date(driver, test, "Select the LOC Expiry Date : ", LOCExpiryDate);
		}
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_NotifypartyInst, "Enter Notify Party Instructions : ",
				NotifyParty);
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_PaymentLink);
	}

	// Currency & payment terms
	public void payment(String Payment, String PaymentText, String Incoterms, String IncotermPlace) {
		Wait.waitfor(2);
		try {
			if (Payment.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_PaymentLink,
						"Click on Payment Terms link : ");
				clickElement(driver, test, "//td[contains(text(),'" + Payment + "')]", "Select Payment : " + Payment);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_PaymentSelectBtn, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_PaymentPopClose, "Click on Pop up Close button");
		}
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_Payment, "Enter payment : ", PaymentText);

		try {
			if (Incoterms.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IncotermsLink, "Click on Incoterms link : ");
				clickElement(driver, test, "//td[contains(text(),'" + Incoterms + "')]",
						"Click on incoterms Link : " + Incoterms);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IncotermSelectBtn, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IncotermPopClose,
					"Click on Pop up Close button");
		}
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_IncotermPlace, "Enter Incoterm place : ", IncotermPlace);
	}

	// Adding the Parties to the Transaction
	public void addPartiesToTheTransaction(String EntityType, String entityCode, String Status) {

		scrollToElement(driver, OCR_CreateNewInvoicePage_AddPartyBtn);

		clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartyBtn, "Click on Add Party Button");

		// Select Entity Type -> Bill To
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_SelectEntityType, "Select Entity Type : ",
				EntityType);

		if (entityCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewInvoicePage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Status, "Select Status : ", Status);
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_BillToCode, "Enter Consignee Code : ",
						entityCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + entityCode + "')]",
						"Select the Consignee : " + entityCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseBtnConsignee, "Click on Close popup icon");
			}

		}
	}

	// Adding the Parties to the Transaction for Regression US
	public void addPartiesToTheTransaction(String BillTo, String BillToCode, String BillStatus, String ShipTo,
			String ShipToCode, String ShipStatus, String FreightForwarder, String FrghtFwdCode, String FFStatus) {

		scrollToElement(driver, OCR_CreateNewInvoicePage_AddPartyBtn);

		clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartyBtn, "Click on Add Party Button");

		// Select Entity Type -> Bill To
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_SelectEntityType, "Select Entity Type : ", BillTo);

		if (BillToCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewInvoicePage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Status, "Select Status : ", BillStatus);
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_BillToCode, "Enter Bill To Code : ", BillToCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + BillToCode + "')]",
						"Select the Consignee : " + BillToCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseBtnConsignee, "Click on Close popup icon");
			}

		}
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewInvoicePage_AddMorePartiesBtn);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_AddMorePartiesBtn, "Click on Add More Parties Button :");
		Wait.waitfor(2);
		// Select Entity Type -> Ship To
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_SelectEntityType, "Select Entity Type : ", ShipTo);
		Wait.waitfor(2);

		if (ShipToCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewInvoicePage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Status, "Select Status : ", ShipStatus);
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ShipToCode, "Enter Ship To Code : ", ShipToCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + ShipToCode + "')]",
						"Select the Consignee : " + ShipToCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseBtnConsignee, "Click on Close popup icon");
			}

		}

		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewInvoicePage_AddMorePartiesBtn);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_AddMorePartiesBtn, "Click on Add More Parties Button :");
		Wait.waitfor(2);
		// Select Entity Type -> Freight Forwarder
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_SelectEntityType, "Select Entity Type : ",
				FreightForwarder);
		Wait.waitfor(2);

		if (FrghtFwdCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewInvoicePage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Status, "Select Status : ", FFStatus);
				typeText(driver, test, OCR_CreateNewInvoicePage_FFCode, "Enter FF Code : ", FrghtFwdCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + FrghtFwdCode + "')]",
						"Select the Consignee : " + FrghtFwdCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseBtnConsignee, "Click on Close popup icon");
			}

		}

	}
	
	//Skip Export Authorization Screening to No
	public void skipExportAuthToNo() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_ExportAuthScreeningToNo);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ExportAuthScreeningToNo, "Set Export Authorization Screening to No :");
	}

	// Adding the Parties to the Transaction for Regression US
	public void addShipDetailsPartiesToTheTransaction(String ShipTo, String ShipToCode, String ShipStatus) {

		scrollToElement(driver, OCR_CreateNewInvoicePage_AddPartyBtn);
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'Ship To')]", "Click on Ship To link :");
		Wait.waitfor(2);

		if (ShipToCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewInvoicePage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Status, "Select Status : ", ShipStatus);
				typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ShipToCode, "Enter Ship To Code : ", ShipToCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + ShipToCode + "')]",
						"Select the Consignee : " + ShipToCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseBtnConsignee, "Click on Close popup icon");
			}

		}

	}

	public void addFreightForwarderForAuthInv(String FreightForwarder, String FrghtFwdCode, String FFStatus) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewInvoicePage_AddMorePartiesBtn);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_AddMorePartiesBtn, "Click on Add More Parties Button :");
		Wait.waitfor(2);
		// Select Entity Type -> Freight Forwarder
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_SelectEntityType, "Select Entity Type : ",
				FreightForwarder);
		Wait.waitfor(2);

		if (FrghtFwdCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewInvoicePage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_Status, "Select Status : ", FFStatus);
				typeText(driver, test, OCR_CreateNewInvoicePage_FFCode, "Enter FF Code : ", FrghtFwdCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + FrghtFwdCode + "')]",
						"Select the Consignee : " + FrghtFwdCode);
				clickElement(driver, test, OCR_CreateNewInvoicePage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewInvoicePage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewInvoicePage_CloseBtnConsignee, "Click on Close popup icon");
			}

		}

	}

	// Additional Charges
	public void additionalCharge(String ChargeDesc, String Amount, String ChargingAccnt, String GLA) {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_AdditionalCharge);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_AdditionalCharge,
				"Click on Additional Charges button");

		try {
			if (ChargeDesc.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ChargesDesc,
						"Click on Charges Description link : ");
				clickElement(driver, test, "//td[contains(text(),'" + ChargeDesc + "')]",
						"Enter Charges : " + ChargeDesc);
				clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ChargesSelectBtn, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ChargesPopClose, "Click on Pop up Close button");
		}

		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_Amount, "Enter Amount : ", Amount);

		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ChargingAccnt, "Enter charging account : ",
				ChargingAccnt);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_GLACode, "Enter GLA Code : ", GLA);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_WholesaleCharge,
				"Click on WholeSaler Charge checkbox");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_PrintDoc, "Click on Print On Documents");
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ChargeSubmitBtn, "Click on Submit Button");
		if (isDisplayed(driver, "//div[@id='gbox_grid-charges']")) {
			Wait.fluwait(driver, "//div[@id='gbox_grid-charges']");
			test.log(LogStatus.PASS,
					"Additional Charge Details added to result grid table : " + "//div[@id='gbox_grid-charges']");
		} else {
			test.log(LogStatus.FAIL, "Failed to Add Additional Charge Details in result grid table : "
					+ "//div[@id='gbox_grid-charges']");
		}
	}

	// Adding Container/Packing Details
	public void containerDetails(String containerID, String DimensionUOM, String LenghtWidthHight, String WeightUOM,
			String GrossNet) {
		scrollToElement(driver, OCR_CreateNewInvoicePage_AddContainerBtn);
		clickElement(driver, test, OCR_CreateNewInvoicePage_AddContainerBtn,
				"Click on Add Container/packing Details button");
		typeText(driver, test, OCR_CreateNewInvoicePage_MarkingContainerID, "Enter Markings/container ID : ",
				containerID);
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_DimensionUOM, "Select the Dimension UOM : ",
				DimensionUOM);
		ArrayList<String> LWH = GenericMethods.stringtoken(LenghtWidthHight);
		if (DimensionUOM.contains("Inches")) {
			typeText(driver, test, OCR_CreateNewInvoicePage_DimInchesL, "Enter the inches(lenght) : ", LWH.get(0));
			typeText(driver, test, OCR_CreateNewInvoicePage_DimInchesW, "Enter the inches(width) : ", LWH.get(1));
			typeText(driver, test, OCR_CreateNewInvoicePage_DimInchesH, "Enter the inches(Height) : ", LWH.get(2));
		}

		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_WeightUOM, "Select the Weight UOM : ", WeightUOM);
		ArrayList<String> GN = GenericMethods.stringtoken(GrossNet);
		if (WeightUOM.contains("Kilograms")) {
			typeText(driver, test, OCR_CreateNewInvoicePage_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
			typeText(driver, test, OCR_CreateNewInvoicePage_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
		}

		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateNewInvoicePage_ContainerSubmit,
				"click on Container/Packing Details Submit button");

	}

	// Adding Container/Packing Details
	public void containerDetails(String containerID, String SealNo, String ConsoPackNo, String RadioActAmnt,
			String DryIceQty, String GrossCartWt, String PackType, String Model, String TareWt, String DimensionUOM,
			String LenghtWidthHight, String WeightUOM, String GrossNet, String SKU, String Class, String BOLText) {
		scrollToElement(driver, OCR_CreateNewInvoicePage_AddContainerBtn);
		clickElement(driver, test, OCR_CreateNewInvoicePage_AddContainerBtn,
				"Click on Add Container/packing Details button");
		typeText(driver, test, OCR_CreateNewInvoicePage_MarkingContainerID, "Enter Markings/container ID : ",
				containerID);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_SealNo, "Enter Seal No : ", SealNo);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ConsolPackNo, "Enter consolidated Pack No : ",
				ConsoPackNo);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_RadioActiAmnt, "Enter Radio Activity Amount : ",
				RadioActAmnt);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_DryIceQty, "Enter Dry Ice Quantity : ", DryIceQty);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_GrossCartonWt, "Enter Gross Carton Weight : ",
				GrossCartWt);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_PackType, "Enter package Type : ", PackType);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_Model, "Enter Model : ", Model);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_TareWt, "Enter Tare Weight : ", TareWt);
		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_DimensionUOM, "Select the Dimension UOM : ",
				DimensionUOM);
		ArrayList<String> LWH = GenericMethods.stringtoken(LenghtWidthHight);
		if (DimensionUOM.contains("Inches")) {
			typeText(driver, test, OCR_CreateNewInvoicePage_DimInchesL, "Enter the inches(lenght) : ", LWH.get(0));
			typeText(driver, test, OCR_CreateNewInvoicePage_DimInchesW, "Enter the inches(width) : ", LWH.get(1));
			typeText(driver, test, OCR_CreateNewInvoicePage_DimInchesH, "Enter the inches(Height) : ", LWH.get(2));
		}

		selectByVisibleText(driver, test, OCR_CreateNewInvoicePage_WeightUOM, "Select the Weight UOM : ", WeightUOM);
		ArrayList<String> GN = GenericMethods.stringtoken(GrossNet);
		if (WeightUOM.contains("Kilograms")) {
			typeText(driver, test, OCR_CreateNewInvoicePage_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
			typeText(driver, test, OCR_CreateNewInvoicePage_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
		}

		Wait.waitfor(3);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_SKUQty, "Enter SKu Quantity : ", SKU);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_Class, "Enter Class : ", Class);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_BOLText, "Enter BOL Text : ", BOLText);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_ContainerSubmit,
				"click on Container/Packing Details Submit button");
		// if(isDisplayed(driver, "//div[@id='cartons-div']")) {
		// Wait.fluwait(driver, "//div[@id='cartons-div']");
		// test.log(LogStatus.PASS,
		// "Container Details added to result grid table : " +
		// "//div[@id='cartons-div']");
		// }
		// else {
		// test.log(LogStatus.FAIL,
		// "Failed to Add Container Details in result grid table : " +
		// "//div[@id='cartons-div']");
		// }
	}

	// Returnable packages
	public void returnPack(String PackId, String ContainerID, String NoOfPack, String TypeOfPack, String UnitPrice,
			String COO) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_ReturnPackge);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ReturnPackge,
				"Click on Add Returnable package button : ");
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_PackgeID, "Enter package ID : ", PackId);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_ContID, "Enter Container ID : ", ContainerID);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_NoOfPack, "Enter No of Package : ", NoOfPack);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_TypeOfPack, "Enter Type of Packing : ", TypeOfPack);

		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_COO, "Enter Country Of Origin : ", COO);
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewInvoicePage_Regres_UnitPrice, "Enter Unit Price : ", UnitPrice);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_SaveReturnPackage, "Click on Save Button");
		if (isDisplayed(driver, "//div[@id='ReturnablePacking-div']")) {
			Wait.fluwait(driver, "//div[@id='ReturnablePacking-div']");
			test.log(LogStatus.PASS,
					"Returnable packages added to result grid table : " + "//div[@id='ReturnablePacking-div']");
		} else {
			test.log(LogStatus.FAIL,
					"Failed to Add Returnable packages in result grid table : " + "//div[@id='ReturnablePacking-div']");
		}
		scrollToTop(driver);
	}

	// Click on Save button on Invoice Page
	public void saveBtn() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_CreateNewInvoicePage_InvPageSaveBtn);
		clickElement(driver, test, OCR_CreateNewInvoicePage_InvPageSaveBtn, "Click on Save button on Invoice Page");
	}

	public void validate_Icons() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatus,
				"Click on Entity Screening Status Icon : ");
		if (isDisplayed(driver, "//h4[contains(text(),'Entity Screening Status')]")) {
			Wait.fluwait(driver, "//h4[contains(text(),'Entity Screening Status')]");
			test.log(LogStatus.PASS,
					"Entity Screening Status icon is working : " + "//h4[contains(text(),'Entity Screening Status')]");
		} else {
			test.log(LogStatus.FAIL, "Entity Screening Status icon is not working : "
					+ "//h4[contains(text(),'Entity Screening Status')]");
		}

		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IconPopUpClose, "Close the pop up");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ExpoAuthScreeningStatus,
				"Click on Export Authorization Screening Status Icon : ");
		if (isDisplayed(driver, "//h4[contains(text(),'Export Control Screening')]")) {
			Wait.fluwait(driver, "//h4[contains(text(),'Export Control Screening')]");
			test.log(LogStatus.PASS, "Export Control Screening icon is working : "
					+ "//h4[contains(text(),'Export Control Screening')]");
		} else {
			test.log(LogStatus.FAIL, "Export Control Screening icon is not working : "
					+ "//h4[contains(text(),'Export Control Screening')]");
		}

		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IconPopUpClose, "Close the pop up");
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_ExpoAuthScreeningStatus);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_GenerateDocs, "Click on Generate Documents Icon : ");
		if (isDisplayed(driver, "//h4[contains(text(),'Generate Documents')]")) {
			Wait.fluwait(driver, "//h4[contains(text(),'Generate Documents')]");
			test.log(LogStatus.PASS,
					"Generate Documents icon is working : " + "//h4[contains(text(),'Generate Documents')]");
		} else {
			test.log(LogStatus.FAIL,
					"Generate Documents icon is not working : " + "//h4[contains(text(),'Generate Documents')]");
		}

		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IconPopUpClose, "Close the pop up");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_ComplianceSummReport,
				"Click on Compliance Summary Report Icon : ");
		if (isDisplayed(driver, "//h4[@id='myModalLabel']")) {
			Wait.fluwait(driver, "//h4[@id='myModalLabel']");
			test.log(LogStatus.PASS, "Compliance Summary Report icon is working : " + "//h4[@id='myModalLabel']");
		} else {
			test.log(LogStatus.FAIL, "Compliance Summary Report is not working : " + "//h4[@id='myModalLabel']");
		}

		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IconPopUpClose, "Close the pop up");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_UploadFileAttachment,
				"Click on Upload File attachment Icon :");
		if (isDisplayed(driver, "//h4[@id='myModalLabelCreateNew']")) {
			Wait.fluwait(driver, "//h4[@id='myModalLabelCreateNew']");
			test.log(LogStatus.PASS, "Upload File Attachment icon is working : " + "//h4[@id='myModalLabelCreateNew']");
		} else {
			test.log(LogStatus.FAIL, "Upload File Attachment is not working : " + "//h4[@id='myModalLabelCreateNew']");
		}
		System.out.println("Upload File Attachment is displayed upon clicking");
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_IconPopUpClose, "Close the pop up");
		Wait.waitfor(2);
	}

	// click on Additional Information icon and select Items option
	public void select_Items() {
		scrollToElement(driver, OCR_CreateNewInvoicePage_AdditionalInformation);

		clickElement(driver, test, OCR_CreateNewInvoicePage_AdditionalInformation,
				"Click on Additional Information tab");
		clickElement(driver, test, OCR_CreateNewInvoicePage_Items,
				"Select Items option from Additional Information tab");
	}

	public String gettingInvoiceOrderNo() {
		return getAttribute(driver, test, "//span[@class='heading-additional']/span", "innerText",
				"Get the Invoice Order Number :");

	}

	public void ContDetails() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_navigateToContDetails);
		try {
			clickElement(driver, test, "OCR_CreateNewInvoicePage_Regres_navigateToContDetails",
					"Click on Add Container Details button :");
			Wait.waitfor(2);
			test.log(LogStatus.FAIL, "Add Container Details button is enabled :");
			testFailSshot(driver, test);
		} catch (Exception e) {
			test.log(LogStatus.PASS, "Add Container Details Button is disabled");
		}
	}

	// click on Entity Screening Status for On Hold for Regression US
	public void EntityScreenStatusOnHold() {
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusIcon);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusIcon,
				"Click on Entity Screening Status to check WLS status");
		if (isDisplayed(driver, "//td[contains(text(),'On Hold')]")) {
			Wait.fluwait(driver, "//td[contains(text(),'On Hold')]");
			test.log(LogStatus.PASS, "Entity Screening Status is On Hold : " + "//td[contains(text(),'On Hold')]");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusCloseBtn, "Close the pop up :");
	}

	// click on Entity Screening Status for Approved Regression US
	public void EntityScreenStatusApproved() {
		scrollToElement(driver, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusIcon);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusIcon,
				"Click on Entity Screening Status to check WLS status");
		if (isDisplayed(driver, "//td[contains(text(),'Approved')]")) {
			Wait.fluwait(driver, "//td[contains(text(),'Approved')]");
			test.log(LogStatus.PASS, "Entity Screening Status is Approved : " + "//td[contains(text(),'Approved')]");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewInvoicePage_Regres_EntityScreeningStatusCloseBtn, "Close the pop up :");
	}
	
	//click on Add Shipment Button
	public void addShipmentButton() {
		clickElement(driver, test, OCR_EditShipment_AddShipmentButton, "Clicking on Add Shipment Button :");
	}
	
	//Change Status
	// Clicking on Change Status button to select Shipment Approved for Regression US
	public void changeStatusToShipmentApproved(String ShipmentApproved) {
		clickElement(driver, test, "//button[contains(text(),'Change Status')]", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ShipmentApproved + "')]", "Select Shipment Approved : " + ShipmentApproved);
	}

}
