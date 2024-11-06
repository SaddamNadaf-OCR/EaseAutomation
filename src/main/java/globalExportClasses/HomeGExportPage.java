package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomeGExportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='nav-link dropdown-item'])[2]";
	public static final String OCR_HomePage_ModuleGExport = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_HomePage_Feature = "//i[@class='fa fa-pencil']";
	public static final String OCR_HomePage_Orders_Deliveries = "//a[contains(text(),'Orders & Deliveries')]";
	public static final String OCR_HomePage_Invoice_Order = "//a[contains(text(),'Invoice Order')]";
	public static final String OCR_HomePage_SalesOrder = "//a[contains(text(),'Sales Order')]";
	public static final String OCR_HomePage_ShippingTrans = "//a[contains(text(),'Shipping Transactions')]";
	public static final String OCR_HomePage_Shipments = "(//a[contains(text(),'Shipments')])[1]";
	public static final String OCR_HomePage_ShipWizard = "//a[contains(text(),'Ship Request Wizard')]";
	public static final String OCR_HomePage_TransactionWorkQueue = "//a[contains(text(),'Transaction Work Queues')]";
	public static final String OCR_HomePage_PackingList = "(//a[contains(text(),'Packing List')])[1]";
	public static final String OCR_HomePage_ModuleExport = "(//a[contains(text(),'Export Operations')])[2]";
	public static final String OCR_HomePage_ShipmentNo = "//input[@id='searchShipment_shipment_shipmentNo']";
	public static final String OCR_HomePage_Search = "//button[@id='shipment-submit']";
	public static final String OCR_HomePage_SettingsIcon = "//i[@class='fa fa-wrench']";
	public static final String OCR_HomePage_LicenseDecision = "//a[contains(text(),'License Decision Table')]";
	public static final String OCR_HomePage_Help = "//i[@class='fa fa-question-circle']";
	public static final String OCR_HomePage_WhoAmI = "//a[contains(text(),'Who Am I?')]";
	public static final String OCR_HomePage_Order = "//a[contains(text(),'Orders & Deliveries')]";
	public static final String OCR_HomePage_DeliveryOrder = "//a[contains(text(),'Delivery Order')]";
	public static final String OCR_HomePage_LetterOfCredit = "//a[contains(text(),'Letter of Credit')]";
	public static final String OCR_HomePage_Logistics = "(//a[contains(text(),'Logistics')])[1]";
	public static final String OCR_HomePage_Billsofladings = "(//i[@class='fa fa-plus-square'])[3]";
	public static final String OCR_HomePage_Airwaybill = "(//a[contains(text(),'Airway Bill')])[1]";
	public static final String OCR_HomePage_HouseAirwayBill = "//a[contains(text(),'House Airway Bill')]";
	public static final String OCR_HomePage_OceanBillOfLading = "//a[contains(text(),'Ocean Bill of Lading')]";
	public static final String OCR_HomePage_MasterAirwaybill = "//a[contains(text(),'Master Airway Bill')]";
	public static final String OCR_HomePage_OrderConsolidation = "//a[text()='Order Consolidation']";
	public static final String OCR_HomePage_CustomsFiling = "(//a[contains(text(),'Customs Filing')])[1]";
	public static final String OCR_HomePage_DFA = "//a[contains(text(),'Duty Relief Authorizations')]";

	/* ******************************* REPORT ****************************** */
	public static final String OCR_HomePage_Reports = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_Report_Invoice = "(//a[contains (text(),'Invoice')])[2]";
	public static final String OCR_HomePage_Report_IDetails = "//a[@href='/gead/createSearchInvoiceReport.ocr']";
	public static final String OCR_HomePage_Report_IOn_hold_Orders = "(//a[contains (text(),'On-hold Orders Report')])";
	public static final String OCR_HomePage_Report_ISummary = "//a[@href='/gead/createSearchInvoiceReportSummary.ocr']";
	public static final String OCR_HomePage_Report_Shipment = "(//a[contains (text(),'Shipment Reports')])";
	public static final String OCR_HomePage_Report_SDetails = "(//a[contains (text(),'Details')])[3]";
	public static final String OCR_HomePage_Report_SAgainst_Licenses = "(//a[contains (text(),'Shipments against Licenses')])";
	public static final String OCR_HomePage_Report_Ship_Summary = "(//a[contains (text(),'Summary')])[11]";
	public static final String OCR_HomePage_Report_AES_Response = "(//a[contains (text(),'AES Responses')])";
	public static final String OCR_HomePage_Report_Authorization_Reports = "//a[contains (text(),'Authorization Reports')]";
	public static final String OCR_HomePage_Report_Auth_Bal_Pend = "//a[contains (text(),'AUTH. Balance & Pending Transaction Summary')]";
	public static final String OCR_HomePage_Report_Auth_Activity = "(//a[contains (text(),'Authorization Activity')])[1]";
	public static final String OCR_HomePage_Report = "//i[@class='fa fa-bar-chart']";
	public static final String OCR_HomePage_ExpandAuditReports = "(//a[contains(text(),'Audit Reports')])[1]";
	public static final String OCR_HomePage_AESReport = "//a[contains(text(),'AES Status Change Report')]";
	public static final String OCR_HomePage_OrdWLSReport = "//a[contains(text(),'Order Wls Audit Report')]";
	public static final String OCR_HomePage_CommodClassChange = "//a[contains(text(),'Commodity Classification Change')]";
	public static final String OCR_HomePage_ShipmentStatusReport = "//a[contains(text(),'Shipment Status Report')]";
	public static final String OCR_HomePage_ShipmentWLSReport = "//a[contains(text(),'Shipment WLS Audit Report')]";
	public static final String OCR_HomePage_ShipAdhocReport = "//a[contains(text(),'Shipment Adhoc Report')]";
	public static final String OCR_HomePage_AuthReport = "//a[contains(text(),'Authorization Reports')]";
	public static final String OCR_HomePage_AuthbalanceSummary = "//a[contains(text(),'Authorization Balance Summary')]";
	public static final String OCR_HomePage_AuthExpiry = "//a[contains(text(),'Authorization Expiry')]";
	public static final String OCR_HomePage_AuthInfo = "//a[contains(text(),'Authorization Information')]";
	public static final String OCR_HomePage_DutyReleifReports = "//a[contains(text(),'Duty Relief Activity & Balance Report')]";
	public static final String OCR_HomePage_Incoterms = "//a[contains(text(),'Incoterm Report')]";
	public static final String OCR_HomePage_PackingListReport = "(//a[contains(text(),'Packing List')])[2]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_MISREPORT = "//a[contains(text(),'MIS Reports')]";
	public static final String OCR_HomePage_DisapprovalMetrics = "//a[contains(text(),'Disapproval Metrics')]";
	public static final String OCR_HomePage_Shipt_Pro_Stat_BySBUSiteRegion = "//a[contains(text(),'Shipment Processing Statistics By SBU/Site/Region')]";
	public static final String OCR_HomePage_ShipmentSummaryByRegion = "//a[contains(text(),'Shipment Summary By Region')]";
	public static final String OCR_HomePage_ShipSumBySBUForFinalShipment = "//a[contains(text(),'Shipment Summary By SBU For Final Shipments')]";

	// For ITAR Exemption Reports

	public static final String OCR_HomePage_ITARExemptionReports = "//a[contains(text(),'ITAR Exemption Reports')]";
	public static final String OCR_HomePage_CanadianExemptionReports = "//a[contains(text(),'ITAR Exemption Reports')]/../div//a[contains(text(),'Canadian Exemption Summary Report')]";
	public static final String OCR_HomePage_ITARDetailsReports = "//a[contains(text(),'ITAR Exemption Reports')]/../div//a[contains(text(),'Details')]";
	public static final String OCR_HomePage_ITARExpNotReExportedReports = "//a[contains(text(),'ITAR Exemption Reports')]/../div//a[contains(text(),'Exports not Reexported')]";
	public static final String OCR_HomePage_ITARExpSummaryReports = "(//a[contains(text(),'ITAR Exemption Reports')]/../div//a[contains(text(),'Summary')])[2]";
	public static final String OCR_HomePage_AuthExceptionReports = "//a[contains(text(),'Authorization Exception Reports')]";
	public static final String OCR_HomePage_ENCExceptionReports = "//a[contains(text(),'ENC Exception')]";
	public static final String OCR_HomePage_LVSExceptionReports = "//a[contains(text(),'LVS Exception Report')]";
	public static final String OCR_HomePage_LicenseExceptionReports = "(//a[contains(text(),'Summary Report')])[2]";
	public static final String OCR_HomePage_WassenaarReports = "//a[contains(text(),'Wassenaar')]";
	public static final String OCR_HomePage_TempAuthTracking = "//a[contains(text(),'Temp. Authorization Tracking')]";
	public static final String OCR_HomePage_AuthActivityReport = "//a[contains(text(),'Authorization Activity Report')]";
	public static final String OCR_HomePage_AuthOutstandingReport = "//a[contains(text(),'Authorization Outstanding Report')]";
	public static final String OCR_HomePage_WebServiceAuditReport = "//a[contains(text(),'Web Service Audit Report')]";

	// For MIS Reports

	public static final String OCR_HomePage_MISReports = "//a[contains(text(),'MIS Reports')]";
	public static final String OCR_HomePage_DisapprovalReportBySBU = "//a[contains(text(),'Disapproval Reason Metrics By SBU')]";
	public static final String OCR_HomePage_ShipmentStatisticsReport = "//a[contains(text(),'Shipment Processing Statistics Report')]";
	public static final String OCR_HomePage_ShipSummarySBU = "(//a[contains(text(),'Shipment Summary By SBU')])[1]";
	public static final String OCR_HomePage_ShipSummaryBySite = "//a[contains(text(),'Shipment Summary By Site')]";
	
	
	//Tools
	
	public static final String OCR_HomePage_Tools = "(//a[@class='nav-link dropdown-item'])[7]";
	public static final String OCR_HomePage_ToolsSearchField = "(//ul[@id='toolSortListId']  //input[@class='box'])[2]";
	public static final String OCR_HomePage_SBUConfiguration = "//a[contains(text(),'SBU Configuration')]";
	
	//Files
	public static final String OCR_HomePage_Files = "(//li[@class='nav-item dropdown'])[2]";
	public static final String OCR_HomePage_AESExemptionStatement = "//a[contains(text(),'AES Exemption Statement')]";
	public static final String OCR_HomePage_BillOfMaterial = "//a[contains(text(),'Bill Of Material')]";
	public static final String OCR_HomePage_ConsigneeType = "//a[contains(text(),'Consignee Type')]";
	public static final String OCR_HomePage_Consignee = "(//a[contains(text(),'Consignee')])[1]";
	public static final String OCR_HomePage_DCS = "(//a[contains(text(),'DCS')])[1]";
	public static final String OCR_HomePage_Exporters = "(//a[contains(text(),'Exporters')])[1]";
	public static final String OCR_HomePage_FTAAttributes = "(//a[contains(text(),'FTA Attributes')])[1]";
	public static final String OCR_HomePage_FlagReasons = "(//a[contains(text(),'Flag Reasons')])[1]";
	public static final String OCR_HomePage_FreightContracts = "(//a[contains(text(),'Freight Contracts')])[1]";
	public static final String OCR_HomePage_AirContract = "(//a[contains(text(),'Air Contract')])[1]";
	public static final String OCR_HomePage_GroundContract = "(//a[contains(text(),'Ground Contract')])[1]";
	public static final String OCR_HomePage_OceanContract = "(//a[contains(text(),'Ocean Contract')])[1]";
	public static final String OCR_HomePage_FreightForwarders = "//a[contains(text(),'Freight Forwarders')]";
	public static final String OCR_HomePage_GroundCarriers = "//a[contains(text(),'Ground Carriers')]";
	public static final String OCR_HomePage_OceanCharges = "//a[contains(text(),'Ocean Charges')]";
	public static final String OCR_HomePage_OrderCategory = "//a[contains(text(),'Order Category')]";
	public static final String OCR_HomePage_Payments = "//a[contains(text(),'Payments')]";
	public static final String OCR_HomePage_Priority = "//a[contains(text(),'Priority')]";
	public static final String OCR_HomePage_ProductFamily = "(//a[contains(text(),'Product Family')])[1]";
	public static final String OCR_HomePage_ProductLines = "(//a[contains(text(),'Product Lines')])[1]";
	public static final String OCR_HomePage_Products = "(//a[contains(text(),'Products')])[1]";
	public static final String OCR_HomePage_Programs = "(//a[contains(text(),'Programs')])[1]";
	public static final String OCR_HomePage_Region = "(//a[contains(text(),'Region')])[1]";
	public static final String OCR_HomePage_RestrictedValues = "//a[contains(text(),'Restricted Values')]";
	public static final String OCR_HomePage_SchedulingAgreementConsignee = "//a[contains(text(),'Scheduling Agreement Consignee')]";
	public static final String OCR_HomePage_Segments = "//a[contains(text(),'Segments')]";
	public static final String OCR_HomePage_Site = "(//a[contains(text(),'Site')])[3]";
	public static final String OCR_HomePage_Source_Manufacturer = "//a[contains(text(),'Source/Manufacturers')]";
	public static final String OCR_HomePage_SpecialInstructionsNotes = "//a[contains(text(),'Special Instructions Notes')]";
	public static final String OCR_HomePage_SystemGeneratedNumbers = "//a[contains(text(),'System Generated Numbers')]";
	public static final String OCR_HomePage_Templates = "//a[contains(text(),'Templates')]";
	public static final String OCR_HomePage_AWBNumber = "//a[contains(text(),'AWB Number')]";
	public static final String OCR_HomePage_CertificateofOrigin = "(//a[contains(text(),'Certificate of Origin')])[2]";
	public static final String OCR_HomePage_EEI = "//a[contains(text(),'EEI')]";
	public static final String OCR_HomePage_Invoice = "(//a[contains(text(),'Invoice')])[3]";
	public static final String OCR_HomePage_Shipment = "(//a[contains(text(),'Shipment')])[13]";
	public static final String OCR_HomePage_USGSelfLimitingProvisos = "(//a[contains(text(),'USG Self Limiting Provisos')])";
	public static final String OCR_HomePage_HoldTypes = "(//a[contains(text(),'Hold Types')])";
	
	//Tables
	
	public static final String OCR_HomePage_Tables = "(//li[@class='nav-item dropdown'])[3]";
	public static final String OCR_HomePage_Tables_CustomFilingExemptionStatements = "//a[contains(text(),'Customs Filing Exemption Statements')]";
	public static final String OCR_HomePage_Tables_Codes = "//a[contains(text(),'Codes')]//i[@class='fa fa-plus-square']";
	public static final String OCR_HomePage_Tables_Codes_AESCorrection = "//a[contains(text(),'AES Correction')]//i[@class='fa fa-caret-right']";
	public static final String OCR_HomePage_Tables_Codes_ExportInformation = "//a[contains(text(),'Export Information')]//i[@class='fa fa-caret-right']";
	public static final String OCR_HomePage_Tables_InBondCode = "//a[contains(text(),'InBond Code')]";
	
	/* ******************************* Constructor ****************************** */

	public HomeGExportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleGExport, "Click on Global Export Module");
	}
	

	// Selecting Orders and Deliveries
	public void OCR_HomePage_Orders_Deliveries() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Orders_Deliveries, "Mouseover to Orders and Deliveries");
		clickElement(driver, test, OCR_HomePage_Orders_Deliveries, "Click to expand Orders and Deliveries");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_SalesOrder, "Click on Sales Order");
	}

	// Selecting Invoice Order
	public void OCR_HomePage_Invoice_Order() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Orders_Deliveries, "Mouseover to Orders and Deliveries");
		clickElement(driver, test, OCR_HomePage_Orders_Deliveries, "Click to expand Orders and Deliveries");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Invoice_Order, "Click on Invoice Order");
	}

	// Selecting Order Consolidation----Pooja
	public void OCR_HomePage_OrderConsolidation() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Orders_Deliveries, "Mouseover to Orders and Deliveries");
		clickElement(driver, test, OCR_HomePage_Orders_Deliveries, "Click to expand Orders and Deliveries");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_OrderConsolidation, "Click on Order Consolidation");
	}

	// Selecting Packing List----Pooja
	public void OCR_HomePage_PackingList() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ShippingTrans, "Click on Shipping Transactions");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_PackingList, "Click on Packing List");
	}

	// Selecting the Shipping Transaction
	public void featuresShippingTrans() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ShippingTrans, "Click on Shipping Transactions");
	}

	// Selecting the features Orders Deliveries
	public void featuresOrdersDeliveries() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Order, "Click on Orders & Deliveries");
	}

	// Click the Sales order
	public void clickSalesOrder() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_SalesOrder, "Click on Sales Order");
	}

	// Click on Delivery order
	public void clickDeliveryOrder() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_DeliveryOrder, "Click on Delivery order");
	}

	// Click on Letter of Credit
	public void clickLetterOfCredit() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_LetterOfCredit, "Click on Letter of Credit");
	}

	// click on shipment
	public void click_shipments() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Shipments, "click on shipments");
	}

	// click on Transaction Work Queues--------Pooja
	public void click_TransactioWorkQueue() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ShippingTrans, "Click on Shipping Transactions");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_TransactionWorkQueue, "Click on Transaction Work Queues");

	}

	// click on Ship request Wizard
	public void click_ShipWizard() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ShipWizard, "Click on Ship Request Wizard");
	}

	// Enter the Shipment NO
	public void type_ShipmentNo(String ShipmentNO) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_HomePage_ShipmentNo, "Enter the Shipment No : ", ShipmentNO);
	}

	// click on Search
	public void click_Search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Search, "click on Search");
	}

	// Return to Create shipment home page
	public void return_ExportHome() {
		scrollToElement(driver, OCR_HomePage_ModuleSelection);
		scrollToTop(driver);
		Wait.waitfor(4);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_HomePage_ModuleExport, "Click on Export Operation");
	}

	// Mouse over to setting and click on License Decision Table
	public void select_LicenseDecisionTable() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_SettingsIcon, "Mouse over to Setting Icon");
		scrollToElement(driver, OCR_HomePage_LicenseDecision);
		clickElement(driver, test, OCR_HomePage_LicenseDecision, "click on License Decision Table");
	}

	// mouse over to Help and select who am I
	public void select_Help() {
		mouseOver(driver, test, OCR_HomePage_Help, "Mouse over to Help");
		clickElement(driver, test, OCR_HomePage_WhoAmI, "Click on Who am I");
	}

	// Get the userid
	public String getUserID() {
		String firstName = getText(driver, test,
				"//table[@class='table table-condensed table-bordered table-striped']/tbody/tr[6]/td[1]",
				"Geting the UserId :");
		String LastName = getText(driver, test,
				"//table[@class='table table-condensed table-bordered table-striped']/tbody/tr[5]/td[1]",
				"Geting the LastName :");
		return firstName + " " + LastName;
	}

	// Get the Email id
	public String getEmail() {
		return getText(driver, test,
				"//table[@class='table table-condensed table-bordered table-striped']/tbody/tr[9]/td[1]",
				"Geting the Email Id :");
	}

	// Click on Pop up Close
	public void clickPopClose() {
		clickElement(driver, test, "//div[@id='ocrModal']//button[@class='btn-close']", "Click on PopUp close");
	}

	// Click on Logistics And Shipping
	public void clickLogistic() {
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Logistics, "Click on Logistics And Shipping");
	}

	// Clicking on Bills of lading and airway bill
	public void airwaybill() {
		mouseOverAndClick(driver, test, OCR_HomePage_Feature, "clicking on feature");
		mouseOverAndClick(driver, test, OCR_HomePage_Billsofladings, "Mouseover and CLick on billof lading");
		Wait.waitfor(4);
		mouseOverAndClick(driver, test, OCR_HomePage_Airwaybill, "Mouseover and CLick on airway bill");
	}
	


	// Module selection //
	public void moduleselection() {
		mouseOverAndClick(driver, test, OCR_HomePage_ModuleSelection, "Selecting Module");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ModuleGExport, "Selecting export Operation");

	}

	// Clicking on Bills of lading and House airway bill
	public void HouseAirwayBill() {
		mouseOverAndClick(driver, test, OCR_HomePage_Feature, "clicking on feature");
		mouseOverAndClick(driver, test, OCR_HomePage_Billsofladings, "Mouseover and CLick on billof lading");
		Wait.waitfor(4);
		mouseOverAndClick(driver, test, OCR_HomePage_HouseAirwayBill, "Mouseover and CLick on House airway bill");
	}

	// Clicking on Bills of lading and Ocean Bill Of Lading
	public void OceanBill() {
		mouseOverAndClick(driver, test, OCR_HomePage_Feature, "clicking on feature");
		mouseOverAndClick(driver, test, OCR_HomePage_Billsofladings, "Mouseover and CLick on billof lading");
		Wait.waitfor(4);
		mouseOverAndClick(driver, test, OCR_HomePage_OceanBillOfLading, "Mouseover and CLick on Ocean bill");
	}

	// Clicking on Bills of lading and Master Airway bill
	public void MasterAirwaybill() {
		mouseOverAndClick(driver, test, OCR_HomePage_Feature, "clicking on feature");
		mouseOverAndClick(driver, test, OCR_HomePage_Billsofladings, "Mouseover and CLick on billof lading");
		Wait.waitfor(4);
		mouseOverAndClick(driver, test, OCR_HomePage_MasterAirwaybill, "Mouseover and CLick on Master Airway bill");
	}

	// Clicking on Customs Filing
	public void CustomsFiling() {
		mouseOverAndClick(driver, test, OCR_HomePage_Feature, "clicking on feature");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_CustomsFiling, "Mouseover and CLick on Customs Filing ");
	}

	// Click on Duty Relief Authorizations
	public void clickDutyRAuth() {
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to Feature");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_DFA, "Click on Duty Relief Authorizations");
	}

	// Clicking on REPORT and Invoice---->Details
	public void ReportInvoice() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Invoice, "Mouseover and click on Invoice");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Report_IDetails, "click on Details");
	}

	// Clicking on REPORT and Invoice---->OnHold
	public void ReportInvoiceOnHold() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Invoice, "Mouseover and click on Invoice");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_IOn_hold_Orders, "Click on OnHold Report ");
	}

	// Clicking on REPORT and Invoice---->Summary
	public void ReportInvoiceSummary() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Invoice, "Mouseover and click on Invoice");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_ISummary, "Mouseover and click on Summary Report");

	}

	// Clicking on REPORT and Shipment---->Details
	public void ReportShipment() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Shipment, "Mouseover and click on Shipment");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_SDetails, "Mouseover and click on Shipment Details");
	}

	// Clicking on REPORT and Shipment---->AES
	public void ReportShipmentAES() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Shipment, "Mouseover and click on Shipment");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_AES_Response, "Mouseover and click on AES");
	}

	// Clicking on REPORT and Shipment---->AgainstLic
	public void ReportShipmentAgainstLic() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Shipment, "Mouseover and click on Shipment");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_SAgainst_Licenses, "Mouseover and click on Aginstlic");
	}

	// Clicking on REPORT and Shipment---->Summary
	public void ReportShipmentSummary() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Shipment, "Mouseover and click on Shipment");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Ship_Summary, "Click on Summary");
	}

	// Clicking on REPORT and Authorization Report---->Balance & Pending
	public void ReportAuthorizationBal_Pend() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Authorization_Reports, "CLick on auth report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Auth_Bal_Pend, "Click on BAl and Pend report");
	}

	// Clicking on REPORT and Authorization Report---->Activity
	public void ReportAuthorizationActivity() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Authorization_Reports, "CLick on auth report");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Report_Auth_Activity, "Click on Auth Activity ");
	}

	// Navigate to Reports ----------Pooja
	public void moveToReports() {
		mouseOver(driver, test, OCR_HomePage_Reports, "Move Over on Reports tab");

	}

	public void auditReports() {
		mouseOver(driver, test, OCR_HomePage_ExpandAuditReports, "MouseOver to Audit Reports");
		clickElement(driver, test, OCR_HomePage_ExpandAuditReports, "Click to expand Audit Reports section");
		Wait.waitfor(2);
	}

	public void AESStatusChangeReports() {

		mouseOver(driver, test, OCR_HomePage_AESReport, "Mouse over to AES Status Change Report");
		clickElement(driver, test, OCR_HomePage_AESReport, "Click on AES Status Change Report");
		Wait.waitfor(2);
	}

	public void OrderWLSSAuditReport() {

		mouseOver(driver, test, OCR_HomePage_OrdWLSReport, "Mouse over to Order WLS Audit Report");
		clickElement(driver, test, OCR_HomePage_OrdWLSReport, "Click on Order WLS Audit Report");
		Wait.waitfor(2);

	}

	public void CommodityClfChange() {

		mouseOver(driver, test, OCR_HomePage_CommodClassChange, "Mouse over to Commodity Classification Change");
		clickElement(driver, test, OCR_HomePage_CommodClassChange, "Click on Commodity Classification Change");
		Wait.waitfor(2);
	}

	public void ShipStatusReport() {
		mouseOver(driver, test, OCR_HomePage_ShipmentStatusReport, "Mouse Over to Shipment Status Report");
		clickElement(driver, test, OCR_HomePage_ShipmentStatusReport, "Click on Shipment Status Report");
		Wait.waitfor(2);

	}

	public void ShipWLSReport() {
		mouseOver(driver, test, OCR_HomePage_ShipmentWLSReport, "Mouse over to Shipment WLS Audit Report");
		clickElement(driver, test, OCR_HomePage_ShipmentWLSReport, "Click on Shipment WLS Audit Report");
		Wait.waitfor(2);

	}

	public void ShipAdhocReport() {
		mouseOver(driver, test, OCR_HomePage_ShipAdhocReport, "Mouse over to Shipment Adhoc Report");
		clickElement(driver, test, OCR_HomePage_ShipAdhocReport, "Click on Shipment Adhoc Report");
		Wait.waitfor(2);
	}

	public void AuthorizationReport() {
		mouseOver(driver, test, OCR_HomePage_AuthReport, "Mouse Over to Authorization Reports");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AuthReport, "Expand Authorization Reports section");
	}

	public void AuthbalanceSumm() {
		mouseOver(driver, test, OCR_HomePage_AuthbalanceSummary, "Mouseover to Authorization Summary Report");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AuthbalanceSummary, "CLick on Authorization Summary Report");

	}

	public void AuthExpiry() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_AuthExpiry, "Mouse over to Authorization Expiry");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AuthExpiry, "Click on Authorization Expiry");
	}

	public void AuthInfo() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_AuthInfo, "Mouse over to Authorization Information");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AuthInfo, "Click on Authorization Information");
	}

	public void DRAReports() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_DutyReleifReports, "Mouse over to Duty Relief Activity & Balance Report");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_DutyReleifReports, "Click on Duty Relief Activity & Balance Report");

	}

	public void Incoterm() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_Incoterms, "Mouse over on Incoterm Report");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Incoterms, "Click on Incoterm Report");
	}

	public void PackingList() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_PackingListReport, "Mouse over to Packing List Report");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_PackingListReport, "Click on Packing List Report");
	}

	public void ProductReport() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_ProductReport, "Mouse over to Product Report");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report");
	}

	// .......................Clicking on ITAR Exemption
	// Reports.......................//

	public void click_ITARExemptionReport() {
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		mouseOver(driver, test, OCR_HomePage_ITARExemptionReports, "Mouse over to ITAR Exemption Reports");
		clickElement(driver, test, OCR_HomePage_ITARExemptionReports, "Clicking on ITAR Exemption Reports :");
		

	}

	// .......................Clicking on Canadian Exemption Summary
	// Reports........................//
	public void click_CanadianExemptionSummaryReports() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CanadianExemptionReports,
				"Mouse over on Canadian Exemption Summary Reports :");
		clickElement(driver, test, OCR_HomePage_CanadianExemptionReports,
				"Clicking on Canadian Exemption Summary Reports :");
		
	}

	// .......................Clicking on Details Reports........................//
	public void click_DetailsReports() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ITARDetailsReports, "Mouse over on Details Reports");
		clickElement(driver, test, OCR_HomePage_ITARDetailsReports, "Clicking on Details Reports :");
	}

	// .......................Clicking on Exports not Reexported
	// Reports........................//
	public void click_ExportsnotReexportedReports() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ITARExpNotReExportedReports,
				"Mouse over on Exports Not Reexported Reports");
		clickElement(driver, test, OCR_HomePage_ITARExpNotReExportedReports,
				"Clicking on Exports not Reexported Reports :");
	}

	// .......................Clicking on Summary Reports........................//
	public void click_SummaryReports() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ITARExpSummaryReports, "Mouse Over on Summary Reports");
		clickElement(driver, test, OCR_HomePage_ITARExpSummaryReports, "Clicking on Summary Reports :");
	}

	// .......................Clicking on Authorization Exception
	// Reports.....................//
	// .......................Clicking on ENC Exception
	// Reports........................//
	public void click_ENCExceptionReports() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_AuthExceptionReports, "Mouse over to Authorization Exception Reports");
		clickElement(driver, test, OCR_HomePage_AuthExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ENCExceptionReports, "Clicking on ENC Exception Reports :");
	}

	// .......................Clicking on LVS Exception
	// Reports........................//
	public void click_LVSExceptionReports() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_AuthExceptionReports, "Mouse over to Authorization Exception Reports");
		clickElement(driver, test, OCR_HomePage_AuthExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_LVSExceptionReports, "Clicking on LVS Exception Reports :");
	}

	// .......................Clicking on AE Summary
	// Reports........................//
	public void click_AESummaryReports() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Mouseover to Report");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_AuthExceptionReports, "Mouse over to Authorization Exception Reports");
		clickElement(driver, test, OCR_HomePage_AuthExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_LicenseExceptionReports, "Clicking on AE Summary Reports :");
	}

	// .......................Clicking on Wassenaar
	// Reports........................//
	public void click_WassenaarReports() {
		mouseOver(driver, test, OCR_HomePage_AuthExceptionReports, "Mouse over to Authorization Exception Reports");
		clickElement(driver, test, OCR_HomePage_AuthExceptionReports, "Clicking on Authorization Exception Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WassenaarReports, "Clicking on Wassenaar Reports :");
	}

	// .......................Clicking on Temp_Authorization Tracking
	// Reports...............................//
	// .......................Clicking on Authorization
	// Activity........................//
	public void click_Authorization_Activity() {
		mouseOver(driver, test, OCR_HomePage_TempAuthTracking, "Mouse Over to Temp. Authorization Tracking Reports");
		clickElement(driver, test, OCR_HomePage_TempAuthTracking, "Clicking on Temp_Authorization Tracking Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_AuthActivityReport, "Clicking on Authorization_Activity Report :");
	}

	// .......................Clicking on Authorization
	// Outstanding........................//
	public void click_AuthorizationOutstanding() {
		mouseOver(driver, test, OCR_HomePage_TempAuthTracking, "Mouse Over to Temp. Authorization Tracking Reports");
		clickElement(driver, test, OCR_HomePage_TempAuthTracking, "Clicking on Temp_Authorization Tracking Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_AuthOutstandingReport, "Clicking on Authorization Outstanding :");
	}

	// .......................Clicking on Web Service Audit
	// Report........................//
	public void click_WebServiceAudit() {
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WebServiceAuditReport, "Clicking on Web Service Audit Report :");
	}

	// ...........CLicking on MIS Reports..........................
	public void click_MISReports() {
		mouseOver(driver, test, OCR_HomePage_MISReports, "Mouse over to MIS Reports");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_MISReports, "Click on MIS Reports");

	}

	public void disapprovalMetricsBySBU() {
		mouseOver(driver, test, OCR_HomePage_DisapprovalReportBySBU, "Mouse over to Disapproval Reason Metrics By SBU");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_DisapprovalReportBySBU,
				"Click on to Disapproval Reason Metrics By SBU");
	}

	public void statisticsReport() {
		mouseOver(driver, test, OCR_HomePage_ShipmentStatisticsReport,
				"Mouse Over to Shipment Processing Statistics Report");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ShipmentStatisticsReport,
				"Click on to Shipment Processing Statistics Report");
	}

	public void ShipSummarySBU() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_ShipSummarySBU, "Mouse over to Shipment Summary By SBU");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ShipSummarySBU, "Click on to Shipment Summary By SBU");
	}

	public void ShipSummarySite() {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_ShipSummaryBySite, "Mouse Over to Shipment Summary By Site");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ShipSummaryBySite, "Click on to Shipment Summary By Site");

	}

	// Clicking on REPORT and MIS REPORT---->Disapproval Metrics
	public void DisapprovalMetrics() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Click on report :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_MISREPORT, "Mouse over and click on MISREPORT");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_DisapprovalMetrics, "Click on Disapproval Metrics");

	}

	// Clicking on REPORT and MIS REPORT---->Statistics By SBU/Site/Region Report
	public void StatisticsSBUSiteRegion() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Click on report :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_MISREPORT, "Mouse over and click on MISREPORT");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_Shipt_Pro_Stat_BySBUSiteRegion,
				"CLick on Statistics By SBU/Site/Region Report");

	}

	// Clicking on REPORT and MIS REPORT---->ShipmentSummaryByRegion
	public void ShipmentSummaryByRegion() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Click on report :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_MISREPORT, "Mouse over and click on MISREPORT");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_ShipmentSummaryByRegion, "Click on ShipmentSummaryByRegion ");
	}

	// Clicking on REPORT and MIS REPORT---->Shipment Summary By SBU For Final
	// Shipments
	public void ShipSumBySBUFinalShip() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Click on report :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_MISREPORT, "Mouse over and click on MISREPORT");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_ShipSumBySBUForFinalShipment,
				"Mouse over and click on ShipSumBySBUForFinalShipment");

	}
	
	//go to tools
	public void tools(String Text) {
		mouseOverAndClick(driver, test, OCR_HomePage_Tools, "Go to Tools :");
		scrollToElement(driver, OCR_HomePage_ToolsSearchField);
		clickElement(driver, test, OCR_HomePage_ToolsSearchField, "Click on Search placeholder :");
		typeText(driver, test, OCR_HomePage_ToolsSearchField, "Enter the text : ", Text);
		
		
	}
	
	// Go To Files
	//Click on AES Exception Statement
	public void aesExceptionStatement() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AESExemptionStatement, "Clicking on AES Exemption Statement :");
	}
	
	//Click on Bill Of Material
	public void billOfMaterial() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_BillOfMaterial, "Clicking on Bill Material :");
	}
	
	//Click on Consignee Type
	public void consigneeType() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ConsigneeType, "Clicking on Consignee type :");
	}
	
	//Click on Consignee
	public void consignee() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Consignee, "Clicking on Consignee :");
	}
	
	//Click on DCS
	public void dcs() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_DCS, "Clicking on DCS :");
	}
	
	//Click on Exporters
	public void exporters() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Exporters, "Clicking on Exporters :");
	}
	
	//Click on FTA Attributes
	public void fTAAttributes() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_FTAAttributes, "Clicking on FTA Attributes :");
	}
		
	//Click on Flag Reasons
	public void flagReasons() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_FlagReasons, "Clicking on Flag Reasons :");
	}
		
	//Click on Air Contract
	public void airContract() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_FreightContracts, "Clicking on Freight Contracts :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AirContract, "Clicking on Air Contract :");
	}
		
	//Click on Ground Contract
	public void groundContract() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_FreightContracts, "Clicking on Freight Contracts :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_GroundContract, "Clicking on Ground Contract :");
	}
	
	//Click on Ocean Contract
	public void oceanContract() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_FreightContracts, "Clicking on Freight Contracts :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_OceanContract, "Clicking on Ocean Contract :");
	}
	
	//Click on Freight Forwarders
	public void freightForwarders() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_FreightForwarders, "Clicking on Freight Forwarders :");
	}
		
	//Click on Ground Carriers
	public void groundCarriers() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_GroundCarriers, "Clicking on Ground Carriers :");
	}
		
	//Click on Ocean Charges
	public void oceanCharges() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_OceanCharges, "Clicking on Ocean Charges :");
	}
		
	//Click on Order Category
	public void orderCategory() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_OrderCategory, "Clicking on Order Category :");
	}
		
	//Click on Payments
	public void payments() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Payments, "Clicking on Payments :");
	}
		
	//Click on Priority
	public void priority() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Priority, "Clicking on Priority :");
	}
		
	//Click on Product Family
	public void productFamily() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ProductFamily, "Clicking on Product Family :");
	}
		
	//Click on Product Lines
	public void productLines() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_ProductLines, "Clicking on Product Lines :");
	}
		
	//Click on Products
	public void products() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Products, "Clicking on Products :");
	}
		
	//Click on Programs
	public void programs() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Programs, "Clicking on Programs :");
	}
	
	//Click on Region
	public void region() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Region, "Clicking on Region :");
	}
		
	//Click on Restricted Values
	public void restrictedValues() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_RestrictedValues, "Clicking on Restricted Values :");
	}
		
	//Click on Scheduling Agreement Consignee
	public void schedulingAgreementConsignee() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_SchedulingAgreementConsignee, "Clicking on Scheduling Agreement Consignee :");
	}
		
	//Click on Segments
	public void segments() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Segments, "Clicking on Segments :");
	}
	
	//Click on Site
	public void site() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Site, "Clicking on Site :");
	}
		
	//Click on Source_Manufacturer
	public void Source_Manufacturer() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Source_Manufacturer, "Clicking on Source_Manufacturer :");
	}
		
	//Click on Special Instructions Notes
	public void SpecialInstructionsNotes() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_SpecialInstructionsNotes, "Clicking on Special Instructions Notes :");
	}
		
	//Click on System Generated Numbers
	public void SystemGeneratedNumbers() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_SystemGeneratedNumbers, "Clicking on System Generated Numbers :");
	}
		
	//Click on AWB Number
	public void AWBNumber() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Templates, "Clicking on Templates :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_AWBNumber, "Clicking on AWB Number :");
	}
		
	//Click on Certificate of Origin
	public void CertificateofOrigin() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Templates, "Clicking on Templates :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_CertificateofOrigin, "Clicking on Certificate of Origin :");
	}
		
	//Click on EEI
	public void EEI() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Templates, "Clicking on Templates :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_EEI, "Clicking on EEI :");
	}
		
	//Click on Invoice
	public void Invoice() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Templates, "Clicking on Templates :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Invoice, "Clicking on Invoice :");
	}
		
	//Click on Shipment
	public void Shipment() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Templates, "Clicking on Templates :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Shipment, "Clicking on Shipment :");
	}
		
	//Click on USG Self Limiting Provisos
	public void USGSelfLimitingProvisos() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_USGSelfLimitingProvisos, "Clicking on USG Self Limiting Provisos :");
	}
	
	//Click on Hold Types
	public void HoldTypes() {
		clickElement(driver, test, OCR_HomePage_Files, "Clicking on Files :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_HoldTypes, "Clicking on HoldT ypes :");
	}
	
	//Click on Custom filing exemption statements
	public void customFilingExemptionStatement() {
		clickElement(driver, test, OCR_HomePage_Tables, "Clicking on Tables");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Tables_CustomFilingExemptionStatements, "Clicking on Custom Filing Exemption Statements :");
	}
	
	//click on Codes -> AES Correction
	public void codes_AESCorrection() {
		clickElement(driver, test, OCR_HomePage_Tables, "Clicking on Tables");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Tables_Codes, "Expand Codes");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_Tables_Codes_AESCorrection, "Click on AES Correction");
		
	}
	
	//click on Codes -> Export information
		public void codes_ExportInformation() {
			clickElement(driver, test, OCR_HomePage_Tables, "Clicking on Tables");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_HomePage_Tables_Codes, "Expand Codes");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_HomePage_Tables_Codes_ExportInformation, "Click on Export Information");
			
		}
		
		//click on InBond Code
		public void click_InBondCode() {
			clickElement(driver, test, OCR_HomePage_Tables, "Clicking on Tables");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_HomePage_Tables_InBondCode, "Click on Inbond Code");
			
		}
		
		//click on LogOut icon
		public void logOut() {
			scrollToElement(driver, "//i[@class='fa fa-sign-out']");
			Wait.waitfor(2);
			clickElement(driver, test, "//i[@class='fa fa-sign-out']", "log out of the application :");
		}
		
		//Click on SBU Configation
		public void sbuConfiguration() {
			mouseOverAndClick(driver, test, OCR_HomePage_SBUConfiguration, "Clicking on SBU Configuration :");
		}
}
