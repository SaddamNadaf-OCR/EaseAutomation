package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : 
 * created date : 
 * Descriptions : Search Shipment Adhoc Report Page
 * changed by : Saddam
 * changed date : 14/05/2024
 * Purpose of change : Added in Regression Testcases
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchShipmentAdhocReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchShipmentAdhocReportPage_Country = "//select[@id='encryptedCountryCode']";
	public static final String OCR_SearchShipmentAdhocReportPage_SBU = "//select[@id='selectSbu']";
	public static final String OCR_SearchShipmentAdhocReportPage_Reporttype = "//select[@id='reportTypeId']";
	public static final String OCR_SearchShipmentAdhocReportPage_InvoiceNo = "//input[@id='resultAdhocReport_invoiceNo']";
	public static final String OCR_SearchShipmentAdhocReportPage_ShipNo = "//input[@id='resultAdhocReport_shipment_shipmentNo']";
	public static final String OCR_SearchShipmentAdhocReportPage_ITNNo = "//input[@id='resultAdhocReport_shipment_itn']";
	public static final String OCR_SearchShipmentAdhocReportPage_ShpWorkStatus = "(//select[@id='sel'])[1]";
	public static final String OCR_SearchShipmentAdhocReportPage_ExporterCountry = "//input[@id='resultAdhocReport_shipment_expCountryName']";
	public static final String OCR_SearchShipmentAdhocReportPage_CounryOfOrigin = "(//select[@id='sel'])[2]";
	public static final String OCR_SearchShipmentAdhocReportPage_DestinationCountry = "(//select[@id='sel'])[3]";
	public static final String OCR_SearchShipmentAdhocReportPage_USPPICode = "//a[contains(text(),'USPPI Code')]";
	public static final String OCR_SearchShipmentAdhocReportPage_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_SearchShipmentAdhocReportPage_SearchPopupButton = "//button[@name='Search']";
	public static final String OCR_SearchShipmentAdhocReportPage_SelectPopupButton = "//button[@name='Ok']";
	public static final String OCR_SearchShipmentAdhocReportPage_ClosePopup = "//button[@class='btn-close']";
	public static final String OCR_SearchShipmentAdhocReportPage_ExporterCodeTextbox = "//input[@id='resultAdhocReport_shipment_exporterCode']";
	public static final String OCR_SearchShipmentAdhocReportPage_USPPIName = "//input[@id='resultAdhocReport_shipment_expName']";
	public static final String OCR_SearchShipmentAdhocReportPage_USPPIEIN = "//input[@id='resultAdhocReport_shipment_usppiNumber']";
	public static final String OCR_SearchShipmentAdhocReportPage_Consignee = "(//a[contains(text(),'Consignee')])[4]";
	public static final String OCR_SearchShipmentAdhocReportPage_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_SearchShipmentAdhocReportPage_ConsigneeTextbox = "//input[@id='resultAdhocReport_shipment_intConsName']";
	public static final String OCR_SearchShipmentAdhocReportPage_FreightForwarder = "(//a[contains(text(),'Freight Forwarder')])[2]";
	public static final String OCR_SearchShipmentAdhocReportPage_FFCode = "//input[@id='searchForm_freightForwarder_ffCode']";
	public static final String OCR_SearchShipmentAdhocReportPage_FreightForwarderTextBox = "//input[@id='resultAdhocReport_shipment_ffAgentName']";
	public static final String OCR_SearchShipmentAdhocReportPage_Carrier = "//input[@id='resultAdhocReport_shipment_carrierName']";
	public static final String OCR_SearchShipmentAdhocReportPage_AirwayBillNo = "//input[@id='resultAdhocReport_shipment_awbNo']";
	public static final String OCR_SearchShipmentAdhocReportPage_ShippingMethod = "//a[contains(text(),'Shipping Method')]";
	public static final String OCR_SearchShipmentAdhocReportPage_ShipingMethodTextbox = "//input[@id='resultAdhocReport_shipment_modeOfTransport']";
	public static final String OCR_SearchShipmentAdhocReportPage_Region = "(//select[@id='sel'])[4]";
	public static final String OCR_SearchShipmentAdhocReportPage_Site = "(//a[contains(text(),'Site')])[4]";
	public static final String OCR_SearchShipmentAdhocReportPage_SiteID = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String OCR_SearchShipmentAdhocReportPage_SiteTextbox = "//textarea[@id='resultAdhocReport_selectSite']";
	public static final String OCR_SearchShipmentAdhocReportPage_ShippingReviewer = "(//a[contains(text(),'Shipping Reviewer')])";
	public static final String OCR_SearchShipmentAdhocReportPage_userFirstname = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_SearchShipmentAdhocReportPage_shippingReviewerNameTextbox = "//input[@id='resultAdhocReport_shipment_shippingReviewerName']";
	public static final String OCR_SearchShipmentAdhocReportPage_ExportReviewer = "(//a[contains(text(),'Export Reviewer')])";
	public static final String OCR_SearchShipmentAdhocReportPage_exportReviewerTextbox = "//input[@id='resultAdhocReport_shipment_exportReviewer']";
	public static final String OCR_SearchShipmentAdhocReportPage_TransportReviewer = "(//a[contains(text(),'Transport Reviewer')])";
	public static final String OCR_SearchShipmentAdhocReportPage_transportReviewerTextbox = "//input[@id='resultAdhocReport_shipment_transportReviewer']";
	public static final String OCR_SearchShipmentAdhocReportPage_ExportAuthority = "(//select[@id='sel'])[5]";
	public static final String OCR_SearchShipmentAdhocReportPage_activityType = "(//select[@name='activityType'])";
	public static final String OCR_SearchShipmentAdhocReportPage_AuthorizationType = "(//a[contains(text(),'Authorization Type')])[2]";
	public static final String OCR_SearchShipmentAdhocReportPage_AuthorizationTypePopupTextbox = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_SearchShipmentAdhocReportPage_AuthorizationTypeTextbox = "//textarea[@id='resultAdhocReport_licenseType']";
	public static final String OCR_SearchShipmentAdhocReportPage_AuthorizationNo = "(//a[contains(text(),'Authorization No')])";
	public static final String OCR_SearchShipmentAdhocReportPage_AuthorizationNoPopup = "//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_SearchShipmentAdhocReportPage_AuthorizationNoTextbox = "//input[@id='resultAdhocReport_licenseNo']";
	public static final String OCR_SearchShipmentAdhocReportPage_TransactionType = "(//a[contains(text(),'Transaction Type')])[2]";
	public static final String OCR_SearchShipmentAdhocReportPage_TransactionTypeTextbox = "//input[@id='resultAdhocReport_licenseTxnType']";
	public static final String OCR_SearchShipmentAdhocReportPage_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_SearchShipmentAdhocReportPage_SegmentTextbox = "//textarea[@id='resultAdhocReport_shipment_segmentName']";
	public static final String OCR_SearchShipmentAdhocReportPage_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String OCR_SearchShipmentAdhocReportPage_ProductFamilyTextbox = "//textarea[@id='resultAdhocReport_shipment_productFamilyName']";
	public static final String OCR_SearchShipmentAdhocReportPage_CostCenterNo = "//input[@id='resultAdhocReport_shipment_chargeToCostCntrNo']";
	public static final String OCR_SearchShipmentAdhocReportPage_CreatedOnFromDate = "//input[@id='resultAdhocReport_fromCreatedDate']";
	public static final String OCR_SearchShipmentAdhocReportPage_CreatedOnToDate = "//input[@id='resultAdhocReport_toCreatedDate']";
	public static final String OCR_SearchShipmentAdhocReportPage_DateOfExportFromDate = "//input[@id='resultAdhocReport_fromDateOfExport']";
	public static final String OCR_SearchShipmentAdhocReportPage_DateOfExportToDate = "//input[@id='resultAdhocReport_toDateOfExport']";
	public static final String OCR_SearchShipmentAdhocReportPage_CreatedBy = "//select[@id='resultAdhocReport_createdBy']";
	public static final String OCR_SearchShipmentAdhocReportPage_IssueFromDate = "//input[@id='resultAdhocReport_fromCarnetIssueDate']";
	public static final String OCR_SearchShipmentAdhocReportPage_IssueToDate = "//input[@id='resultAdhocReport_toCarnetIssueDate']";
	public static final String OCR_SearchShipmentAdhocReportPage_Searchbtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchShipmentAdhocReportPage_ValidateHeading = "//h3[contains(text(),'SHIPMENT LEVEL ADHOC REPORT')]";
	public static final String OCR_SearchShipmentAdhocReportPage_Today = "//button[contains(text(),'Today')]";
	/* ******************************* Constructor ****************************** */

	public SearchShipmentAdhocReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_SBU, "Select SBU Code : ", sbu);

	}

	public void selectReportType(String ReportType) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_Reporttype, "Select Report Type : ",ReportType);
	}
	
	public void enterShpNo(String ShpNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_ShipNo, "Enter Shipment No : ", ShpNo);
	}
	
	public void workStatus(String WorkStatus) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_SearchShipmentAdhocReportPage_ShpWorkStatus, "De selecting All Statuses");
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_ShpWorkStatus, "Select option : ", WorkStatus);
	}

	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Searchbtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(3);
		isDisplayed(driver, OCR_SearchShipmentAdhocReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "SHIPMENT LEVEL ADHOC REPORT page is Displayed");
		Wait.waitfor(3);
	}
	
	//Search By parameters
	public void searchByparameters(String Country, String sbu, String ReportType, String InvoiceNo, String ShpNo, String ITNNo, 
			String WorkStatus, String ExporterCountry, String CountryOfOrigin, String DestinationCountry, String USPPICode, 
			String USPPIName, String USPPIEIN, String Consignee, String FreightForwarder, String Carrier, String AirwaybillNo, 
			String ShippingMethod, String Region, String Site, String ShippingReviewer, String ExportReviewer, String TransportReviewer, 
			String ExportAuthority, String Activitytype, String AuthorizationType, String AuthorizationNo, String Transactiontype, 
			String Segment, String ProductFamily, String CostCenterNo, String CreatedOnFromDate, String CreatedOnToDate, 
			String DateOfExportFromDate, String DateOfExportToDate, String CreatedBy, String IssueFromDate, String IssueToDate) {
		
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_Country, "Selecting Country :", Country);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_SBU, "Select SBU Code : ", sbu);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_Reporttype, "Select Report Type : ",ReportType);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_InvoiceNo, "Entering Invoice No :", InvoiceNo);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_ShipNo, "Enter Shipment No : ", ShpNo);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_ITNNo, "Entering ITN No :", ITNNo);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_ShpWorkStatus, "Select option : ", WorkStatus);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_ExporterCountry, "Entering Exporter Country :", ExporterCountry);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_CounryOfOrigin, "Selecting Country of origin :", CountryOfOrigin);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_DestinationCountry, "Selecting Destination Country :", DestinationCountry);
		if(USPPICode.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_USPPICode, "Clicking on USPPI Code :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_ExporterCode, "Entering USPPI Code :", USPPICode);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+USPPICode+"')]", "Selecting USPPI Code :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select USPPI Code :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_USPPIName, "Entering USPPI Name :", USPPIName);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_USPPIEIN, "Entering USPPI EIN :", USPPIEIN);
		if(Consignee.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Consignee, "Clicking on Consignee :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_ConsigneeCode, "Entering Consignee :", Consignee);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Consignee+"')]", "Selecting Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(FreightForwarder.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_FreightForwarder, "Clicking on Freight Forwarder :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_FFCode, "Entering Freight Forwarder :", FreightForwarder);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+FreightForwarder+"')]", "Selecting Freight Forwarder :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_Carrier, "Entering Carrier :", Carrier);
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_AirwayBillNo, "Entering AirWayBillNo :", AirwaybillNo);
		if(ShippingMethod.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_FreightForwarder, "Clicking on Shipping Method :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ShippingMethod+"')]", "Selecting Shipping Method :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_Region, "Selecting Region :", Region);
		if(Site.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Site, "Clicking on Site :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_SiteID, "Entering Site :", Site);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(ShippingReviewer.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ShippingReviewer, "Clicking on Shipping Reviewer :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_userFirstname, "Entering Shipping Reviewer :", ShippingReviewer);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ShippingReviewer+"')]", "Selecting Shipping Reviewer :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(ExportReviewer.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ExportReviewer, "Clicking on Export Reviewer :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_userFirstname, "Entering Export Reviewer :", ExportReviewer);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportReviewer+"')]", "Selecting Export Reviewer :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(TransportReviewer.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_TransportReviewer, "Clicking on Transport Reviewer :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_userFirstname, "Entering Transport Reviewer :", TransportReviewer);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TransportReviewer+"')]", "Selecting Transport Reviewer :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_ExportAuthority, "Selecting Export Authority :", ExportAuthority);
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_activityType, "Selecting Activity Type :", Activitytype);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_AuthorizationTypePopupTextbox, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, OCR_SearchShipmentAdhocReportPage_AuthorizationNoPopup, "Entering Authorization No :", AuthorizationNo);
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SearchPopupButton, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(Transactiontype.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_TransactionType, "Clicking on Transaction Type :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Transactiontype+"')]", "Selecting Authorization No :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ProductFamily, "Clicking on Product Family :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_SelectPopupButton, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Consignee :");
				clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_ClosePopup, "Clicking on Close Popup button :");
			}
		}
		typeText(driver, test, OCR_SearchShipmentAdhocReportPage_CostCenterNo, "Entering Cost Center No :", CostCenterNo);
		if(CreatedOnFromDate.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_CreatedOnFromDate, "Clicking on Created On From Date :");
			try {
				if(CreatedOnFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting the From Date :", CreatedOnFromDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
		if(CreatedOnToDate.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_CreatedOnToDate, "Clicking on Created On To Date :");
			try {
				if(CreatedOnFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting the To Date :", CreatedOnToDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
		if(DateOfExportFromDate.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_DateOfExportFromDate, "Clicking on Date Of Export From Date :");
			try {
				if(CreatedOnFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting the From Date :", DateOfExportFromDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
		if(DateOfExportToDate.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_DateOfExportToDate, "Clicking on Date Of Export To Date :");
			try {
				if(CreatedOnFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting the From Date :", DateOfExportToDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
		selectByVisibleText(driver, test, OCR_SearchShipmentAdhocReportPage_CreatedBy, "Selecting Created By :", CreatedBy);
		if(IssueFromDate.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_IssueFromDate, "Clicking on Issue From Date :");
			try {
				if(CreatedOnFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting the From Date :", IssueFromDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
		if(IssueToDate.length() > 0) {
			clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_IssueToDate, "Clicking on Issue To Date :");
			try {
				if(CreatedOnFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchShipmentAdhocReportPage_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting the From Date :", IssueToDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
	}

}
