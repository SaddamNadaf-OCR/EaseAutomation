package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : saddam
 * created date : May 2024
 * Descriptions : Report Shipment Details Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ReportShipmentDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "(//button[contains(text(),'Search')])";
	public static final String OCR_RESET = "(//button[@type='reset'])";
	public static final String OCR_Country = "//select[@name='encryptedCountryCode']";
	public static final String OCR_SBUCODE = "//select[@name='shipment.sbuCode']";
	public static final String OCR_ShipmentNo = "//input[@name='shipment.shipmentNo']";
	public static final String OCR_ExporterCode = "//a[contains(text(),'Exporter Code')]";
	public static final String OCR_ExporterCodePopup = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_Searchpopup = "//button[@name='Search']";
	public static final String OCR_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ExporeterCodeTextbox = "//input[@name='shipment.exporterCode']";
	public static final String OCR_EEINo = "//input[@name='shipment.sedNo']";
	public static final String OCR_ExporterCountry = "//input[@name='shipment.expCountryName']";
	public static final String OCR_WorkStatus = "//select[@name='shipment.shipmentWorkStatus']";
	public static final String OCR_AES_STATUS = "//select[@name='shipment.shipmentCustomFilingStatus']";
	public static final String OCR_Ult_ConsigneeName = "//a[contains(text(),'Ult. Consignee Name')]";
	public static final String OCR_consigneeId = "//input[@name='consignee.consigneeId']";
	public static final String OCR_Ult_ConsigneeNameTextbox = "//input[@name='shipment.ultConsName']";
	public static final String OCR_Inter_ConsigneeName = "//a[contains(text(),'Inter. Consignee Name')]";
	public static final String OCR_Inter_ConsigneeNameTextbox = "//input[@name='shipment.intConsName']";
	public static final String OCR_UltDestination = "//input[@name='shipment.countryOfUltDest']";
	public static final String OCR_transportRefNo = "//input[@name='shipment.transportRefNo']";
	public static final String OCR_ForwardingAgentName = "//a[contains(text(),'Forwarding Agent Name')]";
	public static final String OCR_ffCode = "//input[@name='freightForwarder.ffCode']";
	public static final String OCR_ForwardingAgentNametextbox = "//input[@name='shipment.ffAgentName']";
	public static final String OCR_carrierName = "//input[@name='shipment.carrierName']";
	public static final String OCR_fromDateOfExport = "//input[@name='fromDateOfExport']";
	public static final String OCR_toDateOfExport = "//input[@name='toDateOfExport']";
	public static final String OCR_sliFromDate = "//input[@name='sliFromDate']";
	public static final String OCR_sliToDate = "//input[@name='sliToDate']";
	public static final String OCR_billOfLading = "//input[@name='shipment.billOfLading']";
	public static final String OCR_bookingNo = "//input[@name='shipment.bookingNo']";
	public static final String OCR_hazardous = "//select[@name='shipment.hazardous']";
	public static final String OCR_AESExemptionStatement = "//input[@name='shipment.routingInfo']";
	public static final String OCR_reportMonth = "//select[@name='shipment.reportMonth']";
	public static final String OCR_carnetNo = "//input[@name='shipment.carnetNo']";
	public static final String OCR_mawbNo = "//input[@name='shipment.mawbNo']";
	public static final String OCR_hawbNo = "//input[@name='shipment.hawbNo']";
	public static final String OCR_aesOption = "//select[@name='shipment.aesOption']";
	public static final String OCR_awbNo = "//input[@name='shipment.awbNo']";
	public static final String OCR_prepaid = "//select[@name='shipment.prepaid']";
	public static final String OCR_collect = "//select[@name='shipment.collect']";
	public static final String OCR_Invoice = "//input[@name='invoiceNo']";
	public static final String OCR_gla = "//input[@name='gla']";
	public static final String OCR_sourceCode = "//input[@name='sourceCode']";
	public static final String OCR_programCode = "//input[@name='programCode']";
	public static final String OCR_fromOrderDate = "//input[@name='fromOrderDate']";
	public static final String OCR_toOrderDate = "//input[@name='toOrderDate']";
	public static final String OCR_packingSheetNo = "//input[@name='packingSheetNo']";
	public static final String OCR_AuthorizationNo = "//input[@name='licenseNo']";
	public static final String OCR_DOS_DOC_Code = "//input[@name='controllingAgency']";
	public static final String OCR_grossWeights = "//input[@name='grossWeights']";
	public static final String OCR_contractNo = "//input[@name='contractNo']";
	public static final String OCR_htsNo = "//input[@name='htsScheduleBNo']";
	public static final String OCR_productClassification = "//input[@name='productClassification']";
	public static final String OCR_itarNo = "//input[@name='itarNo']";
	public static final String OCR_createdBy = "//select[@name='shipment.createdBy']";
	public static final String OCR_sortBy = "//select[@name='sortBy']";
	public static final String OCR_direction = "//select[@name='direction']";
	public static final String OCR_Today = "//button[contains(text(),'Today')]";

	// * ******************************* Constructor *****************************//

	public ReportShipmentDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}

	// Search by parameter
	public void parameter(String Sbu, String ShipmentNo, String WorkStatus, String UltDestination, String AESStatus,
			String Invoice_No) {
		selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
		typeText(driver, test, OCR_ShipmentNo, "Enter Shipment No", ShipmentNo);
		selectByVisibleText(driver, test, OCR_WorkStatus, "Select Work Status", WorkStatus);
		typeText(driver, test, OCR_UltDestination, "Enter ULt Destination", UltDestination);
		selectByVisibleText(driver, test, OCR_AES_STATUS, "Select AES status", AESStatus);
		typeText(driver, test, OCR_Invoice, "Enter Invoice No", Invoice_No);
		scrollToElement(driver, OCR_SEARCH);
	}

	// Search by parameter
	public void parameter(String Country, String Sbu, String ShipmentNo, String ExporterCode, String EEINo, 
			String ExporterCountry, String WorkStatus, String AESStatus, String Ult_ConsigneeName, 
			String Inter_ConsigneeName, String UltDestination, String TransportRefNo, String ForwardingAgentName, 
			String carrierName, String DateOfExportFrom, String DateOfExportTo, String SLIDateFrom, String SLIDateTo, 
			String billOfLading, String bookingNo, String hazardous, String AESExemptionStatement, String reportMonth, 
			String carnetNo, String mawbNo, String hawbNo, String aesOption, String awbNo, String prepaid, String collect, 
			String Invoice_No, String glaCode, String sourceCode, String programCode, String fromOrderDate, String toOrderDate, 
			String packingSheetNo, String AuthorizationNo, String DOS_DOC_Code, String grossWeights, String contractNo, 
			String htsNo, String productClassification, String itarNo, String createdBy, String sortBy, String direction) {
		
		if(Country.length() > 0) {
			selectByVisibleText(driver, test, OCR_Country, "Selecting Country :", Country);
		}
		if(Sbu.length() > 0) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
		}
		if(ShipmentNo.length() > 0) {
			typeText(driver, test, OCR_ShipmentNo, "Enter Shipment No", ShipmentNo);
		}
		if(ExporterCode.length() > 0) {
			clickElement(driver, test, OCR_ExporterCode, "Clicking on Exporetr Code :");
			try {
				typeText(driver, test, OCR_ExporterCodePopup, "Entering Exporter Code :", ExporterCode);
				clickElement(driver, test, OCR_Searchpopup, "Clicking on Search Popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExporterCode+"')]", "Selecting Exporter Code :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Exporetr Code :");
			}
		}else {
			typeText(driver, test, OCR_ExporeterCodeTextbox, "Entering Exporter Code :", ExporterCode);
		}
		if(EEINo.length() > 0) {
			typeText(driver, test, OCR_EEINo, "Entering EEI no :", EEINo);
		}
		if(ExporterCountry.length() > 0) {
			typeText(driver, test, OCR_ExporterCountry, "Entering Exporter Country :", ExporterCountry);
		}
		if(WorkStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_WorkStatus, "Select Work Status", WorkStatus);
		}
		if(AESStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_AES_STATUS, "Select AES status", AESStatus);
		}
		if(Ult_ConsigneeName.length() > 0) {
			clickElement(driver, test, OCR_Ult_ConsigneeName, "Clicking on Ult_Consignee Name :");
			try {
				typeText(driver, test, OCR_consigneeId, "Entering Ult_ConsigneeName :", Ult_ConsigneeName);
				clickElement(driver, test, OCR_Searchpopup, "Clicking on Search Popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Ult_ConsigneeName+"')]", "Selecting Ult_Consignee Name :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Ult_Consignee Name :");
			}
		}else {
			typeText(driver, test, OCR_Ult_ConsigneeNameTextbox, "Entering Ult_Consignee Name :", Ult_ConsigneeName);
		}
		if(Inter_ConsigneeName.length() > 0) {
			clickElement(driver, test, OCR_Inter_ConsigneeName, "Clicking on Inter_Consignee Name :");
			try {
				typeText(driver, test, OCR_consigneeId, "Entering Inter_Consignee Name :", Inter_ConsigneeName);
				clickElement(driver, test, OCR_Searchpopup, "Clicking on Search Popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Inter_ConsigneeName+"')]", "Selecting Inter_Consignee Name :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Inter_Consignee Name :");
			}
		}else {
			typeText(driver, test, OCR_Inter_ConsigneeNameTextbox, "Entering Inter_Consignee Name :", Inter_ConsigneeName);
		}
		if(UltDestination.length() > 0) {
			typeText(driver, test, OCR_UltDestination, "Enter ULt Destination", UltDestination);
		}
		
		if(TransportRefNo.length() > 0) {
			typeText(driver, test, OCR_transportRefNo, "Enter Transport Ref No", TransportRefNo);
		}
		if(ForwardingAgentName.length() > 0) {
			clickElement(driver, test, OCR_ForwardingAgentName, "Clicking on Forwarding Agent Name :");
			try {
				typeText(driver, test, OCR_ffCode, "Entering Forwarding Agent Name :", ForwardingAgentName);
				clickElement(driver, test, OCR_Searchpopup, "Clicking on Search Popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Inter_ConsigneeName+"')]", "Selecting Forwarding Agent Name :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Forwarding Agent Name :");
			}
		}else {
			typeText(driver, test, OCR_ForwardingAgentNametextbox, "Entering Forwarding Agent Name :", ForwardingAgentName);
		}
		if(carrierName.length() > 0) {
			typeText(driver, test, OCR_carrierName, "Enter carrier Name :", carrierName);
		}
		if(DateOfExportFrom.length() > 0) {
			clickElement(driver, test, OCR_fromDateOfExport, "Clicking on Date Of Export From :");
			try {
				if(DateOfExportFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting Date Of Export From :", DateOfExportFrom);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date Of Export From :");
			}
		}
		if(DateOfExportTo.length() > 0) {
			clickElement(driver, test, OCR_toDateOfExport, "Clicking on Date Of Export To :");
			try {
				if(DateOfExportTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting Date Of Export To :", DateOfExportTo);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date Of Export To :");
			}
		}
		if(SLIDateFrom.length() > 0) {
			clickElement(driver, test, OCR_sliFromDate, "Clicking on SLI Date From :");
			try {
				if(SLIDateFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting SLI Date From :", SLIDateFrom);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the SLI Date From :");
			}
		}
		if(SLIDateTo.length() > 0) {
			clickElement(driver, test, OCR_toDateOfExport, "Clicking on SLI Date To :");
			try {
				if(SLIDateTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting SLI Date To :", SLIDateTo);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select SLI Date To :");
			}
		}
		if(billOfLading.length() > 0) {
			typeText(driver, test, OCR_billOfLading, "Enter bill Of Lading :", billOfLading);
		}
		if(bookingNo.length() > 0) {
			typeText(driver, test, OCR_bookingNo, "Enter booking No :", bookingNo);
		}
		if(hazardous.length() > 0) {
			selectByVisibleText(driver, test, OCR_hazardous, "Select hazardous :", hazardous);
		}
		if(AESExemptionStatement.length() > 0) {
			typeText(driver, test, OCR_AESExemptionStatement, "Enter AES Exemption Statement :", AESExemptionStatement);
		}
		if(reportMonth.length() > 0) {
			selectByVisibleText(driver, test, OCR_reportMonth, "Select report Month :", reportMonth);
		}
		if(carnetNo.length() > 0) {
			typeText(driver, test, OCR_carnetNo, "Enter carnet No :", carnetNo);
		}
		if(mawbNo.length() > 0) {
			typeText(driver, test, OCR_mawbNo, "Enter mawb No :", mawbNo);
		}
		if(hawbNo.length() > 0) {
			typeText(driver, test, OCR_hawbNo, "Enter hawb No :", hawbNo);
		}
		if(aesOption.length() > 0) {
			selectByVisibleText(driver, test, OCR_aesOption, "Select aes Option :", aesOption);
		}
		if(awbNo.length() > 0) {
			typeText(driver, test, OCR_awbNo, "Enter awb No :", awbNo);
		}
		if(prepaid.length() > 0) {
			selectByVisibleText(driver, test, OCR_prepaid, "Select prepaid :", prepaid);
		}
		if(collect.length() > 0) {
			selectByVisibleText(driver, test, OCR_collect, "Select collect :", collect);
		}
		if(Invoice_No.length() > 0) {
			typeText(driver, test, OCR_Invoice, "Enter Invoice No", Invoice_No);
		}
		if(glaCode.length() > 0) {
			typeText(driver, test, OCR_gla, "Enter gla No", glaCode);
		}
		if(sourceCode.length() > 0) {
			typeText(driver, test, OCR_sourceCode, "Enter source Code :", sourceCode);
		}
		if(programCode.length() > 0) {
			typeText(driver, test, OCR_programCode, "Enter program Code :", programCode);
		}
		if(fromOrderDate.length() > 0) {
			clickElement(driver, test, OCR_fromOrderDate, "Clicking on from Order Date :");
			try {
				if(fromOrderDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting from Order Date :", fromOrderDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select from Order Date :");
			}
		}
		if(toOrderDate.length() > 0) {
			clickElement(driver, test, OCR_toOrderDate, "Clicking on to Order Date :");
			try {
				if(toOrderDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					dateOfMonthName(driver, test, "Selecting to Order Date :", toOrderDate);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select to Order Date :");
			}
		}
		if(packingSheetNo.length() > 0) {
			typeText(driver, test, OCR_packingSheetNo, "Enter packing Sheet No :", packingSheetNo);
		}
		if(AuthorizationNo.length() > 0) {
			typeText(driver, test, OCR_AuthorizationNo, "Enter Authorization No :", AuthorizationNo);
		}
		if(DOS_DOC_Code.length() > 0) {
			typeText(driver, test, OCR_DOS_DOC_Code, "Enter DOS_DOC Code :", DOS_DOC_Code);
		}
		if(grossWeights.length() > 0) {
			typeText(driver, test, OCR_grossWeights, "Enter gross Weights :", grossWeights);
		}
		if(contractNo.length() > 0) {
			typeText(driver, test, OCR_contractNo, "Enter contract No :", contractNo);
		}
		if(htsNo.length() > 0) {
			typeText(driver, test, OCR_htsNo, "Enter hts No :", htsNo);
		}
		if(productClassification.length() > 0) {
			typeText(driver, test, OCR_productClassification, "Enter product Classification :", productClassification);
		}
		if(itarNo.length() > 0) {
			typeText(driver, test, OCR_itarNo, "Enter itar No :", itarNo);
		}
		if(createdBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_createdBy, "Select created By :", createdBy);
		}
		if(sortBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_sortBy, "Select sort By :", sortBy);
		}
		if(direction.length() > 0) {
			selectByVisibleText(driver, test, OCR_direction, "Select direction :", direction);
		}
		scrollToElement(driver, OCR_SEARCH);
	}
}
