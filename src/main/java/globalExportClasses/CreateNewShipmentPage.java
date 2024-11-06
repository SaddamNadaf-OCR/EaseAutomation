package globalExportClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewShipmentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreatNewShipment_ShipmentNo = "//input[@id='editShipment_shipment_shipmentNo']";
	public static final String OCR_CreateNewShipment_UltDest = "//input[@id='editShipment_shipment_countryOfUltDest']";
	public static final String OCR_CreateNewShipment_DateOfExport = "//input[@id='dateOfExport']";
	public static final String OCR_CreateNewShipment_RegionLink = "//a[@id='region-popup']";
	public static final String OCR_CreateNewShipment_SLIDate = "//input[@id='editShipment_sliDate']";
	public static final String OCR_CreateNewShipment_SiteLink = "//a[@id='site-popup']";
	public static final String OCR_CreateNewShipment_SiteID = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String OCR_CreateNewShipment_SegmentLink = "//a[@id='segment-popup']";
	public static final String OCR_CreateNewShipment_Program = "//a[@id='program-popup']";
	public static final String OCR_CreateNewShipment_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_CreateNewShipment_ProductFamily = "//a[@id='prodFamily-popup']";
	public static final String OCR_CreateNewShipment_MOT = "(//a[contains(text(),'Mode of Transport')])[2]";
	public static final String OCR_CreateNewShipment_DateOfArrival = "//input[@id='dateOfArrivalMainPage']";
	public static final String OCR_CreateNewShipment_ReportMonth = "//select[@id='editShipment_shipment_reportMonth']";
	public static final String OCR_CreateNewShipment_ReportYear = "//input[@id='editShipment_shipment_reportYear']";
	public static final String OCR_CreateNewShipment_DutyReliefType = "//select[@id='reliefTypeId']";
	public static final String OCR_CreateNewShipment_ReliefAuthorizationNoLink = "//a[@id='dutyreliefAuthNo']";
	public static final String OCR_CreateNewShipment_ReliefAuthorizationNo = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_CreateNewShipment_ReliefActivityType = "//select[@name='shipment.reliefActivityType']";
	public static final String OCR_CreateNewShipment_DueDate = "//input[@id='dueDateMainPage']";
	public static final String OCR_CreateNewShipment_Select = "//button[@name='Ok']";
	public static final String OCR_CreateNewShipment_Exporter = "//table[@id='entityTable']//a[contains(text(),'Exporter')]";
	public static final String OCR_CreateNewShipment_Exporter_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewShipment_Exporter_ExpSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewShipment_Exporter_ExpCode = "//input[@id='searchForm_popupValue_code']";
	public static final String OCR_CreateNewShipment_Exporter_ExpSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipment_Exporter_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipment_Exporter_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewShipment_UltConsignee = "//a[contains(text(),'Ult. Consignee')]";
	public static final String OCR_CreateNewShipment_UltConsignee_Code = "//a[contains(text(),'Ult. Consignee')]";
	public static final String OCR_CreateNewShipment_UltConsignee_ID = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewShipment_UltConsignee_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewShipment_UltConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipment_UltConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipment_UltConsignee_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewShipment_EndUserLink = "//a[contains(text(),'End User')]";
	public static final String OCR_CreateNewShipment_FreightForwarder = "//table[@id='entityTable']//a[contains(text(),'Freight Forwarder')]";
	public static final String OCR_CreateNewShipment_FF_Code = "(//a[contains(text(),'Freight Forwarder')])[2]";
	public static final String OCR_CreateNewShipment_FF_FFCode = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewShipment_FF_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewShipment_FF_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipment_FF_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipment_FF_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewShipment_IntConsignee = "//a[contains(text(),'Intermediate Consignee')]";
	public static final String OCR_CreateNewShipment_IntConsignee_Code = "//a[contains(text(),'Intermediate Consignee')]";
	public static final String OCR_CreateNewShipment_IntConsignee_Id = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewShipment_IntConsignee_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewShipment_IntConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewShipment_IntConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewShipment_IntConsignee_PopUpClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewShipment_IntConsignee_FFRadio = "//input[@id='intConsEntitySourceF']";
	public static final String OCR_CreateNewShipment_IntConsignee_FFCode = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewShipment_IntConsignee_FFCodeE = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewShipment_TravelerNameLink = "//a[@id='travelerName-popup']";
	public static final String OCR_CreateNewShipment_TravelerUserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_CreateNewShipment_TravelerName = "//input[@id='editShipment_shipment_travelerName']";
	public static final String OCR_CreateNewShipment_TravelerEmail = "//input[@id='editShipment_shipment_travelerEmail']";
	public static final String OCR_CreateNewShipment_TravelerPhone = "//input[@id='editShipment_shipment_travelerPhone']";
	public static final String OCR_CreateNewShipment_FreightChargesPaidBY = "//select[@id='editShipment_shipment_ffChargesPaidBy']";
	public static final String OCR_CreateNewShipment_CustomDutiesPaidBy = "//select[@id='editShipment_shipment_customDutiesPaidBy']";
	public static final String OCR_CreateNewShipment_ForeignVatPaidBy = "//select[@id='editShipment_shipment_foreignVatPaidBy']";
	public static final String OCR_CreateNewShipment_CostCeneterNo = "//input[@id='editShipment_shipment_chargeToCostCntrNo']";
	public static final String OCR_CreateNewShipment_LineOfBusinessSupport = "//input[@id='editShipment_shipment_businessUnitSupported']";
	public static final String OCR_CreateNewShipment_AddMoreEquipmentBtn = "//button[@id='addEquipmentsBtn']";
	public static final String OCR_CreateNewShipment_EquipmentNo = "//input[@id='editTabbedEquipment_equipmentDetail_equipmentNo']";
	public static final String OCR_CreateNewShipment_SealNo = "//input[@id='editTabbedEquipment_equipmentDetail_sealNo']";
	public static final String OCR_CreateNewShipment_EquipmentSubmitBtn = "//button[@id='btnSave']";
	public static final String OCR_CreateNewShipment_AddContainerPackingDetailsBtn = "//button[@id='addCartonBtn']";
	public static final String OCR_CreateNewShipment_MarkingsContainerID = "//input[@id='editTabbedShipmentCarton_shipmentCarton_marking']";
	public static final String OCR_CreateNewShipment_SealNumber = "//input[@id='editTabbedShipmentCarton_shipmentCarton_sealNo']";
	public static final String OCR_CreateNewShipment_ConsolidatedPackNumber = "//input[@id='editTabbedShipmentCarton_shipmentCarton_consolidatedPackNo']";
	public static final String OCR_CreateNewShipment_Hazardous = "//select[@id='editTabbedShipmentCarton_shipmentCarton_hazFlag']";
	public static final String OCR_CreateNewShipment_RadioActivityAmnt = "//input[@id='editTabbedShipmentCarton_shipmentCarton_radioactivityAmt']";
	public static final String OCR_CreateNewShipment_DryIce = "//select[@id='editTabbedShipmentCarton_shipmentCarton_dryIceFlag']";
	// public static final String OCR_CreateNewShipment_DryIceQty =
	// "//input[@id='editTabbedShipmentCarton_shipmentCarton_dryIceQty']";
	public static final String OCR_CreateNewShipment_GrossCartonWeight = "//input[@id='editTabbedShipmentCarton_shipmentCarton_cartonWeight']";
	public static final String OCR_CreateNewShipment_PackageType = "//input[@id='editTabbedShipmentCarton_shipmentCarton_packageType']";
	public static final String OCR_CreateNewShipment_Model = "//input[@id='editTabbedShipmentCarton_shipmentCarton_model']";
	public static final String OCR_CreateNewShipment_TareWeight = "//input[@id='editTabbedShipmentCarton_shipmentCarton_tareWeight']";
	public static final String OCR_CreateNewShipment_DimensionUOM = "//select[@id='dimensionUom']";
	public static final String OCR_CreateNewShipment_Dim_ML = "//input[@id='editTabbedShipmentCarton_shipmentCarton_lengthMt']";
	public static final String OCR_CreateNewShipment_Dim_MW = "//input[@id='editTabbedShipmentCarton_shipmentCarton_widthMt']";
	public static final String OCR_CreateNewShipment_Dim_MH = "//input[@id='editTabbedShipmentCarton_shipmentCarton_heightMt']";
	public static final String OCR_CreateNewShipment_Dim_CmL = "//input[@id='editTabbedShipmentCarton_shipmentCarton_lengthCm']";
	public static final String OCR_CreateNewShipment_Dim_CmW = "//input[@id='editTabbedShipmentCarton_shipmentCarton_widthCm']";
	public static final String OCR_CreateNewShipment_Dim_CmH = "//input[@id='editTabbedShipmentCarton_shipmentCarton_heightCm']";
	public static final String OCR_CreateNewShipment_Dim_InchesL = "//input[@id='editTabbedShipmentCarton_shipmentCarton_length']";
	public static final String OCR_CreateNewShipment_Dim_InchesW = "//input[@id='editTabbedShipmentCarton_shipmentCarton_width']";
	public static final String OCR_CreateNewShipment_Dim_InchesH = "//input[@id='editTabbedShipmentCarton_shipmentCarton_height']";
	public static final String OCR_CreateNewShipment_WeightUOM = "//select[@id='editTabbedShipmentCarton_shipmentCarton_widthUom']";
	public static final String OCR_CreateNewShipment_WeightKG_Gross = "//input[@id='editTabbedShipmentCarton_shipmentCarton_grossWeightKg']";
	public static final String OCR_CreateNewShipment_WeightKG_Net = "//input[@id='editTabbedShipmentCarton_shipmentCarton_netWeightKg']";
	public static final String OCR_CreateNewShipment_WeightLbs_Gross = "//input[@id='editTabbedShipmentCarton_shipmentCarton_grossWeightLbs']";
	public static final String OCR_CreateNewShipment_WeightLbs_Net = "//input[@id='editTabbedShipmentCarton_shipmentCarton_netWeight']";
	public static final String OCR_CreateNewShipment_SKUQuantity = "//input[@id='editTabbedShipmentCarton_shipmentCarton_skuQuantity']";
	public static final String OCR_CreateNewShipment_Class = "//input[@id='editTabbedShipmentCarton_shipmentCarton_cartonClass']";
	public static final String OCR_CreateNewShipment_BOLText = "//textarea[@id='editTabbedShipmentCarton_shipmentCarton_bolText']";
	public static final String OCR_CreateNewShipment_ContainerSubmit = "//button[@id='btnSave']";
	public static final String OCR_CreateNewShipment_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_CreateNewShipment_ShipmentForm = "//a[contains(text(),'Shipment Form')]";
	public static final String OCR_CreateNewShipment_items = "//a[@class='eo-tab'][contains(text(),'Items')]";
	public static final String OCR_CreateNewShipment_BookingDetails = "//a[contains(text(),'Booking Details')]";
	public static final String OCR_CreateNewShipment_HazmatDetails = "//a[contains(text(),'Hazmat Details')]";
	public static final String OCR_CreateNewShipment_AssociatedLinked = "//a[contains(text(),'Associated/ Linked Orders')]";
	public static final String OCR_CreateNewShipment_Instructions = "//a[@class='eo-tab'][contains(text(),'Instructions')]";
	public static final String OCR_CreateNewShipment_Questionnaire = "//a[@class='eo-tab'][contains(text(),'Questionnaire')]";
	public static final String OCR_CreateNewShipment_Reviewer = "//a[contains(text(),'Reviewer Details')]";
	public static final String OCR_CreateNewShipment_CustomsFilingView = "//a[contains(text(),'Customs Filing View')]";
	public static final String OCR_CreateNewShipment_ShipmentID = "//span[@class='heading-additional']/span";
	public static final String OCR_CreateNewShipment_Status = "(//span[@class='heading-additional']/span)[2]";
	public static final String OCR_CreateNewShipment_ChangeStatus = "//button[@class='primary-btn dropdown-toggle shipment']";
	public static final String OCR_CreateNewShipment_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_CreateNewShipment_SaveAndReturn = "//button[@name='saveandreturn']";
	public static final String OCR_CreateNewShipment_EntityIcon = "//i[@class='fa fa-user']";
	public static final String OCR_CreateNewShipment_CloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewShipment_ComplianceSummary = "//i[@class='fa fa-file-text-o']";
	public static final String OCR_CreateNewShipment_GenerateDocument = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_CreateNewShipment_GenerateAllDocumentBtn = "//button[contains(text(),'Generate All Documents')]";
	public static final String OCR_CreateNewShipment_EmailGroup = "//select[@id='sendEadPdfEmails_selectedGroup']";
	public static final String OCR_CreateNewShipment_EmailGroupDocumentTO = "//input[@id='sendEadPdfEmails_groupEmailId']/../div/div/input";
	public static final String OCR_CreateNewShipment_EmailGroupDocumentIcon = "//button[@id='groupEmailBtn']//i[@class='fa fa-envelope']";
	public static final String OCR_CreateNewShipment_EmailWithLink = "//button[@id='docEmailAsLink']";
	public static final String OCR_CreateNewShipment_EmailWithAttachment = "//button[@id='docEmailAsAttachment']";

	public static final String OCR_CreateNewShipment_Regres_EnterShipment = "//input[@id='editShipment_shipment_shipmentNo']";
	public static final String OCR_CreateNewShipment_Regres_changeStatToShippingReview = "//button[@class='primary-btn dropdown-toggle shipment shipment-review']";
	public static final String OCR_CNOItem_Regres_DutyReliefDueDate = "//input[@id='dueDateMainPage']";
	
	public static final String OCR_CNOItem_Regres_GenerateDocBtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCR_CNOItem_Regres_SelectNoneOption = "//a[@id='none-doc-select']";
	public static final String OCR_CreateNewShipment_Regres_CloseBtn = "//button[@id='cancelBtn']";
	public static final String OCR_CreateNewShipment_Regres_CustomFilingView = "//a[contains(text(),'Customs Filing View')]";
	public static final String OCR_CreateNewShipment_Regres_ChangeStatusBtn = "//button[@class='primary-btn dropdown-toggle shipment shipment-review ocr-cache-search-dynamic-class']";
	public static final String OCR_createNewShipment_FTANo= "(//div[contains(text(),'No')])[3]";
	public static final String OCR_createNewShipment_FTAYes= "(//div[contains(text(),'Yes')])[3]";
	public static final String OCR_createNewShipment_Close = "//button[contains(text(),'Close')]";	
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public CreateNewShipmentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Header Information
	public void shipHeaderInfo(String ShipmentNo, String UltDestination, String DateOfExport, String Region,
			String SLIDate, String SiteID, String Segment, String Program, String ProductFamily, String MotId,
			String DateofArrival, String ReportMonthAndYear, String DutyReliefType, String ReliefAuthorizationNo,
			String ReliefActivityType, String DueDate) {
		typeText(driver, test, OCR_CreatNewShipment_ShipmentNo, "Enter ShipmentNo : ", ShipmentNo);
		typeText(driver, test, OCR_CreatNewShipment_ShipmentNo, "Enter  Random ShipmentNo : ", randomnumbers());
		typeText(driver, test, OCR_CreateNewShipment_UltDest, "Select UltDestination : ", UltDestination);
		try {
			if (DateOfExport.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_DateOfExport, "Click on Date Of Export");
				date(driver, test, "Select the Date of Export : ", DateOfExport);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		try {
			if (Region.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_RegionLink, "Click on Region link");
				clickElement(driver, test, "//td[contains(text(),'" + Region + "')]",
						"Click on Region Name : " + Region);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		if (SLIDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_SLIDate, "Click on SLIDate");
			date(driver, test, "Select the Date of Export : ", SLIDate);
		}
		try {
			if (SiteID.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_SiteLink, "Click on Site Link");
				typeText(driver, test, OCR_CreateNewShipment_SiteID, "Enter the Site Name : ", SiteID);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + SiteID + "')]", "Select the Site : " + SiteID);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		try {
			if (Segment.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_SegmentLink, "Click on Segment link");
				clickElement(driver, test, "//td[contains(text(),'" + Segment + "')]",
						"Select the Segment : " + Segment);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		try {
			if (Program.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_Program, "Click on Program link");
				typeText(driver, test, OCR_CreateNewShipment_ProgramCode, "Enter the Program Code : ", Program);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click On Search");
				clickElement(driver, test, "//td[contains(text(),'" + Program + "')]",
						"Select the Program : " + Program);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		try {
			if (ProductFamily.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_ProductFamily, "Click on Product Family link");
				clickElement(driver, test, "//td[contains(text(),'" + ProductFamily + "')]",
						"Select the Product Family : " + ProductFamily);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(2);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		try {
			if (MotId.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_MOT, "Click on MOT Link");
				clickElement(driver, test, "//td[contains(text(),'" + MotId + "')]", "Select Mot ID: " + MotId);
				clickElement(driver, test, OCR_CreateNewShipment_Select, "Click on Select Btn");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		if (DateofArrival.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_DateOfArrival, "Click on Date of Arrival");
			date(driver, test, "Select the Date of Arrival : ", DateofArrival);
		}
		if (ReportMonthAndYear.length() > 0) {
			ArrayList<String> reportMonthAndYear = GenericMethods.stringtoken(ReportMonthAndYear);
			selectByVisibleText(driver, test, OCR_CreateNewShipment_ReportMonth, "Select the Report Month : ",
					reportMonthAndYear.get(0));
			typeText(driver, test, OCR_CreateNewShipment_ReportYear, "Enter the Report year : ",
					reportMonthAndYear.get(1));
		}
		scrollToElement(driver, OCR_CreateNewShipment_DutyReliefType);
		selectByVisibleText(driver, test, OCR_CreateNewShipment_DutyReliefType, "Select the Duty Relief Type : ",
				DutyReliefType);
		scrollToElement(driver, OCR_CreateNewShipment_ReliefAuthorizationNoLink);
		try {
			if (ReliefAuthorizationNo.length() > 0) {
				clickElement(driver, test, OCR_CreateNewShipment_ReliefAuthorizationNoLink,
						"Click on Relief Authorization No.");
				typeText(driver, test, OCR_CreateNewShipment_ReliefAuthorizationNo,
						"Enter the ReliefAuthorizationNo : ", ReliefAuthorizationNo);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click On Search");
				clickElement(driver, test, "//td[contains(text(),'" + ReliefAuthorizationNo + "')]",
						"Select Relief Authorization No : " + ReliefAuthorizationNo);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(3);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		scrollToElement(driver, OCR_CreateNewShipment_ReliefActivityType);
		selectByVisibleText(driver, test, OCR_CreateNewShipment_ReliefActivityType,
				"Select the Relief Activity Type : ", ReliefActivityType);
		if (DueDate.length() > 0) {
			scrollToElement(driver, OCR_CreateNewShipment_DueDate);
			clickElement(driver, test, OCR_CreateNewShipment_DueDate, "Click on Due Date");
			date(driver, test, "Select the Due Date : ", DueDate);
		}
	}

	// Adding only duty relief info for creating shipment for invoice for Regression
	// US
	public void dutyReliefAuth_Invoice(String ReliefAuthorNo, String RfDueDate, String ReliefActType) {
		scrollToElement(driver, OCR_CreateNewShipment_ReliefAuthorizationNoLink);
		Wait.waitfor(2);
		try {
			if (ReliefAuthorNo.length() > 0) {
				clickElement(driver, test, OCR_CreateNewShipment_ReliefAuthorizationNoLink,
						"Click on Relief Authorization No.");
				typeText(driver, test, OCR_CreateNewShipment_ReliefAuthorizationNo,
						"Enter the ReliefAuthorizationNo : ", ReliefAuthorNo);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click On Search");
				clickElement(driver, test, "//td[contains(text(),'" + ReliefAuthorNo + "')]",
						"Select Relief Authorization No : " + ReliefAuthorNo);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(3);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNOItem_Regres_DutyReliefDueDate, "Click on Due Date field :");
		date(driver, test, "Select Date : ", RfDueDate);
		selectByVisibleText(driver, test, OCR_CreateNewShipment_ReliefActivityType,
				"Select the Relief Activity Type : ", ReliefActType);

	}

	// Adding Exporter details for Invoice-Shipment for Regression US
	public void addExporterDetails(String ExporterCode) {
		Wait.waitfor(2);
		scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
		Wait.waitfor(3);
		if (ExporterCode.length() > 0) {
			clickElement(driver, test, OCR_CreateNewShipment_Exporter, "click on Exporter link");
			try {
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_Code, "click on exporter code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(5);
				typeText(driver, test, OCR_CreateNewShipment_Exporter_ExpCode, "Enter Exporter Code : ", ExporterCode);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click On Search");
				String ExpCode = "//td[contains(text(),'" + ExporterCode.trim() + "')]";
				clickElement(driver, test, ExpCode, "Select Exporter Code : " + ExporterCode);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_Save, "Click on Save");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
			}
		}

	}

	// Clicking on Change Status button to select Submitted for Shipping Review for Regression US
	public void changeStatusToShipReview(String ShippingReviewStat) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ShippingReviewStat + "')]", "Select Submitted For Shipping Review : " + ShippingReviewStat);
	}
	
	// Clicking on Change Status button to select Shipment Approved for Regression US
	public void changeStatusToShipmentApproved(String ShipmentApproved) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ShipmentApproved + "')]", "Select Shipment Approved : " + ShipmentApproved);
	}
		
	// Clicking on Change Status button to select Export Approved for Regression US
	public void changeStatusToExportApproved(String ExportApproved) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ExportApproved + "')]", "Select Export Approved : " + ExportApproved);
	}
			
	// Clicking on Change Status button to select Sent To Freight Forwarder for Regression US
	public void changeStatusToFreightForwarder(String FrieghtForwarder) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + FrieghtForwarder + "')]", "Select Sent to Freight Forwarder : " + FrieghtForwarder);
	}
						
	//Clicking on Change Status button to select Booked for Regression US
	public void changeStatusToBooked(String Booked) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'"+ Booked +"')]", "Select Booked : " +Booked);
	}
						
	// Clicking on Change Status button to select Shipped for Regression US
	public void changeStatusToShipped(String Shipped) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + Shipped + "')]", "Select Shipped : " + Shipped);
	}

	// Adding the Parties to the Transaction
	public void partiesToTheTransaction(String ExporterCode, String ConsigneeId, String FFCode,
		String IntConsigneePartyType) {
		scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
		Wait.waitfor(3);
		if (ExporterCode.length() > 0) {
			clickElement(driver, test, OCR_CreateNewShipment_Exporter, "click on Exporter link");
			try {
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_Code, "click on exporter code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(5);
				typeText(driver, test, OCR_CreateNewShipment_Exporter_ExpCode, "Enter Exporter Code : ", ExporterCode);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click On Search");
				String ExpCode = "//td[contains(text(),'" + ExporterCode.trim() + "')]";
				clickElement(driver, test, ExpCode, "Select Exporter Code : " + ExporterCode);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_Save, "Click on Save");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
			}
		}
		if (ConsigneeId.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_UltConsignee, "Click on Ult Consignee Link");
			try {
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Code, "Click on Ult Consignee Code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				typeText(driver, test, OCR_CreateNewShipment_UltConsignee_ID, "Enter Consignee Id : ", ConsigneeId);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Search, "Click On Search Button");
				String ConsCode = "//td[contains(text(),'" + ConsigneeId.trim() + "')]";
				clickElement(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Save, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_PopupClose, "Click on cancel popup icon");
			}
		}
		if (FFCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_FreightForwarder, "Click on Freight Forwarder Link");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_FF_Code, "Click on Freight forwarder code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				typeText(driver, test, OCR_CreateNewShipment_FF_FFCode, "Enter FF Code : ", FFCode);
				clickElement(driver, test, OCR_CreateNewShipment_FF_Search, "Click On Search Button");
				String FFCodeSel = "//td[contains(text(),'" + FFCode.trim() + "')]";
				clickElement(driver, test, FFCodeSel, "Select FF Code : " + FFCode);
				clickElement(driver, test, OCR_CreateNewShipment_FF_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_FF_Save, "Click on save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
		if (IntConsigneePartyType.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_IntConsignee, "Click On IntConsignee Link");
			Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
			Wait.waitfor(3);
			try {
				isSelected(driver, "//input[@id='intConsEntitySourceC']");
				if (IntConsigneePartyType.equalsIgnoreCase("Consignee")) {
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Code,
							"Click on IntConsignee code Link");
					Wait.waitfor(3);
					typeText(driver, test, OCR_CreateNewShipment_IntConsignee_Id, "Enter Consignee Id : ", ConsigneeId);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Search, "Click on Search Button");
					Wait.waitfor(3);
					String ConsCode = "//table[@id='gridPopup']/tbody//tr/td[contains(text(),'" + ConsigneeId.trim()
							+ "')]";
					isDisplayed(driver, ConsCode);
					mouseOverAndClick(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Select, "Click on Select Button");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Save, "CLick on Save Button");
				} else {
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_FFRadio, "click on FF Radio button");
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_FFCode, "Click on FF Code Link");
					Wait.waitfor(5);
					typeText(driver, test, OCR_CreateNewShipment_IntConsignee_FFCodeE, "Enter FF Code", FFCode);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Search, "Click On Search Button");
					Wait.waitfor(4);
					String FFIntCode = "//tr[@id='1']//td[contains(text(),'" + FFCode + "')]";
					clickElement(driver, test, FFIntCode, "Select FF code : " + FFCode);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Select, "Click on Select Button");
					Wait.waitfor(2);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Save, "CLick on Save Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
	}
	
	// Adding the Parties to the Transaction for Regression US
		public void partyToTheTransaction(String ExporterCode, String ConsigneeId, String FFCode,
				String IntConsigneePartyType) {
			scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
			Wait.waitfor(3);
			if (ExporterCode.length() > 0) {
				clickElement(driver, test, OCR_CreateNewShipment_Exporter, "click on Exporter link");
				try {
					clickElement(driver, test, OCR_CreateNewShipment_Exporter_Code, "click on exporter code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(5);
					typeText(driver, test, OCR_CreateNewShipment_Exporter_ExpCode, "Enter Exporter Code : ", ExporterCode);
					clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click On Search");
					String ExpCode = "//td[contains(text(),'" + ExporterCode.trim() + "')]";
					clickElement(driver, test, ExpCode, "Select Exporter Code : " + ExporterCode);
					clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSelect, "Click on Select");
					Wait.waitfor(2);
					clickElement(driver, test, OCR_CreateNewShipment_Exporter_Save, "Click on Save");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Cancel popup icon");
				}
			}
			if (ConsigneeId.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee, "Click on Ult Consignee Link");
				try {
					clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Code, "Click on Ult Consignee Code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(3);
					typeText(driver, test, OCR_CreateNewShipment_UltConsignee_ID, "Enter Consignee Id : ", ConsigneeId);
					clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Search, "Click On Search Button");
					String ConsCode = "//td[contains(text(),'" + ConsigneeId.trim() + "')]";
					clickElement(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
					clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Save, "Click on Save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_PopupClose, "Click on cancel popup icon");
				}
			}
			if (FFCode.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_FreightForwarder, "Click on Freight Forwarder Link");
				try {
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_FF_Code, "Click on Freight forwarder code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(3);
					typeText(driver, test, OCR_CreateNewShipment_FF_FFCode, "Enter FF Code : ", FFCode);
					clickElement(driver, test, OCR_CreateNewShipment_FF_Search, "Click On Search Button");
					String FFCodeSel = "//td[contains(text(),'" + FFCode.trim() + "')]";
					clickElement(driver, test, FFCodeSel, "Select FF Code : " + FFCode);
					clickElement(driver, test, OCR_CreateNewShipment_FF_Select, "Click on Select Button");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_FF_Save, "Click on save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipment_FF_PopupClose, "Click on Cancel popup icon");
				}
			}
			if (IntConsigneePartyType.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_IntConsignee, "Click On IntConsignee Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				try {
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Code, "Click on Intermediate Consignee code Link");
					Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
					Wait.waitfor(3);
					typeText(driver, test, OCR_CreateNewShipment_IntConsignee_Id, "Enter Intermediate consignee Code : ", IntConsigneePartyType);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Search, "Click On Search Button");
					Wait.waitfor(2);
//					String IntConsCodeSel = "//td[contains(text(),'"+IntConsigneePartyType+"')]";
//					mouseOverAndClick(driver, test, IntConsCodeSel, "Select Intermediate Consignee : " + IntConsigneePartyType);
					mouseOverAndClick(driver, test, "//td[@aria-describedby='gridPopup_code']", "Select Intermediate Consignee :");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Select, "Click on Select Button");
					Wait.waitfor(3);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_Save, "Click on save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_CreateNewShipment_IntConsignee_PopUpClose, "Click on Cancel popup icon");
				}
				
			}
		}

	// Add party details of End User
	public void addPartiesEndUser(String EndUser) {
		if (EndUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_EndUserLink, "Click on End User Link");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Code, "Click on Consignee Code Link");
				typeText(driver, test, OCR_CreateNewShipment_UltConsignee_ID, "Enter Consignee Id : ", EndUser);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Search, "Click On Search Button");
				String ConsCode = "//td[contains(text(),'" + EndUser.trim() + "')]";
				clickElement(driver, test, ConsCode, "Select Consignee Code : " + EndUser);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Save, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_PopupClose, "Click on cancel popup icon");
			}
		}
	}

	// Adding the Traveler Details
	public void addTravelerDetails(String TravelerUserFirstName, String TravelerName, String TravelerEmail,
			String TravelerPhone) {
		if (TravelerUserFirstName.length() > 0) {
			scrollToBottom(driver);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_TravelerNameLink, "Click on Traveler Name Link");
			try {
				typeText(driver, test, OCR_CreateNewShipment_TravelerUserFirstName, "Enter Traveler First Name : ",
						TravelerUserFirstName);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_ExpSearch, "Click on Search button");
				clickElement(driver, test, "(//td[contains(text(),'" + TravelerUserFirstName + "')])[1]",
						"Select the User First Name : " + TravelerUserFirstName);
				clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_Select, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_FF_PopupClose, "Click on Cancel popup icon");
			}
		} else {
			typeText(driver, test, OCR_CreateNewShipment_TravelerName, "Enter the Traveler Name : ", TravelerName);
			typeText(driver, test, OCR_CreateNewShipment_TravelerEmail, "Enter the Traveler Email : ", TravelerEmail);
			typeText(driver, test, OCR_CreateNewShipment_TravelerPhone, "Enter the Traveler Phone : ", TravelerPhone);
		}
	}

	// Adding the Miscellaneous Information
	public void addMiscellaneousInfo(String FreightChargesPaidBY, String CustomDutiesPaidBy, String ForeignVatPaidBy,
			String CostCeneterNo, String LineOfBusinessSupport) {
		selectByVisibleText(driver, test, OCR_CreateNewShipment_FreightChargesPaidBY,
				"Select the Freight Charges Paid BY : ", FreightChargesPaidBY);
		selectByVisibleText(driver, test, OCR_CreateNewShipment_CustomDutiesPaidBy,
				"Select the Custom Duties Paid By : ", CustomDutiesPaidBy);
		selectByVisibleText(driver, test, OCR_CreateNewShipment_ForeignVatPaidBy, "Select the Foreign Vat Paid By : ",
				ForeignVatPaidBy);
		typeText(driver, test, OCR_CreateNewShipment_CostCeneterNo, "Enter the Cost Ceneter No : ", CostCeneterNo);
		typeText(driver, test, OCR_CreateNewShipment_LineOfBusinessSupport, "Enter the Line Of Business Supported : ",
				LineOfBusinessSupport);
	}

	// Adding Equipments
	public void addEquipment(String EquipmentNo, String SealNo) {
		if (EquipmentNo.length() > 0) {
			scrollToBottom(driver);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_AddMoreEquipmentBtn, "Click on Add More Equipment");
			try {
				typeText(driver, test, OCR_CreateNewShipment_EquipmentNo, "Enter the Equipment No : ", EquipmentNo);
				typeText(driver, test, OCR_CreateNewShipment_SealNo, "Enter the Seal No : ", SealNo);
				clickElement(driver, test, OCR_CreateNewShipment_EquipmentSubmitBtn, "Click on Equipment Submit");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_FF_PopupClose, "Click on Cancel popup icon");
			}
			Wait.waitfor(2);
			String equipmentNo = "//table[@id='grid-equipments']/tbody/tr/td//a[contains(text(),'" + EquipmentNo
					+ "')]";
			try {
				if (isDisplayed(driver, equipmentNo)) {
					test.log(LogStatus.PASS, "Add EquipmentNo in add to result grid table : " + EquipmentNo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add EquipmentNo in result grid table : " + EquipmentNo);
			}
		}
	}

	// Adding the Container/Packing Details
	public void addContainerPackingDetails(String MarkingsContainerID, String SealNumber, String ConsolidatedPackNumber,
			String Hazardous, String RadioActivityAmnt, String DryIce, String GrossCartonWeight, String PackageType,
			String Model, String TareWeight, String DimensionUOM, String LenghtWidthHight, String WeightUOM,
			String GrossNet, String SKUQuantity, String Class, String BOLText) {
		if (MarkingsContainerID.length() > 0) {
			scrollToElement(driver, OCR_CreateNewShipment_AddContainerPackingDetailsBtn);
			scrollToBottom(driver);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_AddContainerPackingDetailsBtn,
					"Click on Add Container Packing Details ");
			try {
				Wait.waitfor(3);
				typeText(driver, test, OCR_CreateNewShipment_MarkingsContainerID, "Enter the Marking Container ID : ",
						MarkingsContainerID);
				typeText(driver, test, OCR_CreateNewShipment_SealNumber, "Enter the Seal Number : ", SealNumber);
				typeText(driver, test, OCR_CreateNewShipment_ConsolidatedPackNumber,
						"Enter the Consolidated Pack Number : ", ConsolidatedPackNumber);
				selectByVisibleText(driver, test, OCR_CreateNewShipment_Hazardous, "Select the Hazardous : ",
						Hazardous);
				typeText(driver, test, OCR_CreateNewShipment_RadioActivityAmnt, "Enter the Radio Activity Amnt : ",
						RadioActivityAmnt);
				selectByVisibleText(driver, test, OCR_CreateNewShipment_DryIce, "Select the Dry Ice : ", DryIce);
				// typeText(driver, test, OCR_CreateNewShipment_DryIceQty, "Enter the Dry ice
				// quantity : ", DryIceQty);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Wait.waitfor(3);
				typeText(driver, test, OCR_CreateNewShipment_GrossCartonWeight, "Enter the Gross Carton Weight : ",
						GrossCartonWeight);
				typeText(driver, test, OCR_CreateNewShipment_PackageType, "Enter the Package Type : ", PackageType);
				typeText(driver, test, OCR_CreateNewShipment_Model, "Enter the MOdel : ", Model);
				typeText(driver, test, OCR_CreateNewShipment_TareWeight, "Enter the Tare Weight : ", TareWeight);

				selectByVisibleText(driver, test, OCR_CreateNewShipment_DimensionUOM, "Select the Dimension UOM : ",
						DimensionUOM);
				ArrayList<String> LWH = GenericMethods.stringtoken(LenghtWidthHight);
				if (DimensionUOM.contains("Inches")) {
					typeText(driver, test, OCR_CreateNewShipment_Dim_InchesL, "Enter the inches(lenght) : ",
							LWH.get(0));
					typeText(driver, test, OCR_CreateNewShipment_Dim_InchesW, "Enter the inches(width) : ", LWH.get(1));
					typeText(driver, test, OCR_CreateNewShipment_Dim_InchesH, "Enter the inches(Height) : ",
							LWH.get(2));
				}
				if (DimensionUOM.contains("Centimeters")) {
					typeText(driver, test, OCR_CreateNewShipment_Dim_CmL, "Enter the CM(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_CreateNewShipment_Dim_CmW, "Enter the CM(width) : ", LWH.get(1));
					typeText(driver, test, OCR_CreateNewShipment_Dim_CmH, "Enter the CM(Height) : ", LWH.get(2));
				}
				if (DimensionUOM.contains("Meters")) {
					typeText(driver, test, OCR_CreateNewShipment_Dim_ML, "Enter the M(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_CreateNewShipment_Dim_MW, "Enter the M(width) : ", LWH.get(1));
					typeText(driver, test, OCR_CreateNewShipment_Dim_MH, "Enter the M(Height) : ", LWH.get(2));
				}
				selectByVisibleText(driver, test, OCR_CreateNewShipment_WeightUOM, "Select the Weight UOM : ",
						WeightUOM);
				ArrayList<String> GN = GenericMethods.stringtoken(GrossNet);
				if (WeightUOM.contains("Kilograms")) {
					typeText(driver, test, OCR_CreateNewShipment_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
					typeText(driver, test, OCR_CreateNewShipment_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
				}
				if (WeightUOM.contains("Pounds")) {
					typeText(driver, test, OCR_CreateNewShipment_WeightLbs_Gross, "Enter the Pounds(Gross) : ",
							GN.get(0));
					typeText(driver, test, OCR_CreateNewShipment_WeightLbs_Net, "Enter the Pounds(Net) : ", GN.get(1));
				}
				typeText(driver, test, OCR_CreateNewShipment_SKUQuantity, "Enter the SKU Quantity : ", SKUQuantity);
				typeText(driver, test, OCR_CreateNewShipment_Class, "Enter the Class : ", Class);
				typeText(driver, test, OCR_CreateNewShipment_BOLText, "Enter the BOL Text : ", BOLText);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_ContainerSubmit,
						"click on Container/Packing Details Submit button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
	}

	// validating Container and Packing Details or Added to resukt grid or not
	public void validateContainerPackingDeatils(String MarkingsContainerID) {
		Wait.waitfor(4);
		if (MarkingsContainerID.length() > 0) {
			scrollToBottom(driver);
			String containergrid = "//table[@id='grid-cartons']/tbody/tr/td[contains(text(),'" + MarkingsContainerID
					+ "')]";
			try {
				if (isDisplayed(driver, containergrid)) {
					Wait.fluwait(driver, containergrid);
					test.log(LogStatus.PASS,
							"Add Container and Packing Details in added to result grid table : " + MarkingsContainerID);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL,
						"Fail to Add Container and Packing Details in result grid table : " + MarkingsContainerID);
			}
		}
	}

	// Getting the shipment ID
	public String get_shipmentID() {
		return getAttribute(driver, test, OCR_CreateNewShipment_ShipmentID, "innerText", "Get the Shipment ID : ");
	}

	// Getting the Country Shipped From
	public String get_CountryShippedFrom() {
		return getAttribute(driver, test, "//input[@id='editShipment_shipment_countryShippedFrom']", "value",
				"Get the Country Shipped From : ");
	}

	// Getting the shipment Status
	public String get_shipmentStatus() {
		return getText(driver, test, OCR_CreateNewShipment_Status, "Get the Shipment Status : ");
	}

	// Click on Additional Transaction Details and Select Shipment Form
	public void select_ShipmentForm() {
		scrollToElement(driver, OCR_CreateNewShipment_AdditionalInformation);
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_ShipmentForm, "Click on Shipment Form");
	}

	// Click on Additional Transaction Details and Select items
	public void select_additems() {
		scrollToElement(driver, OCR_CreateNewShipment_AdditionalInformation);
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_items, "Click on Items");
	}

	// Click on Additional Transaction Details and Select Booking Details
	public void select_BookingDetails() {
		scrollToElement(driver, OCR_CreateNewShipment_AdditionalInformation);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_BookingDetails, "Click on Booking Details");
	}

	// Click on Additional Transaction Details and Select Hazmat Details
	public void select_HazmatDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_HazmatDetails, "Click on Hazmat Details");
	}

	// Click on Additional Transaction Details and Select Associated / Linked order
	public void select_AssociatedLinked() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_AssociatedLinked, "Click on Associated Linked Order");
	}

	// Click on Additional Transaction Details and Select Instructions
	public void select_Instructions() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_Instructions, "Click on Instructions");
	}

	// Click on Additional Transaction Details and Select Questionnaire
	public void select_Questionnaire() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_Questionnaire, "Click on Questionnaire");
	}

	// Click on Additional Transaction Details and Select Reviewer Details
	public void select_ReviewerDetails() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_Reviewer, "Click on Reviewer Details");
	}

	// Click on Additional Transaction Details and Select Customs Filing View
	public void select_CustomsFilingView() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_CreateNewShipment_CustomsFilingView, "Click on Customs Filing View");
	}

	// click on Change Status button
	public void click_ChangeStatus(String Status) {
		clickElement(driver, test, OCR_CreateNewShipment_ChangeStatus, "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + Status + "')]", "Click on " + Status);
	}

	// click on Change Status button US
	public void click_ChangeStatusUS(String Status) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + Status + "')]", "Click on " + Status);
	}

	// click on save button
	public void click_SaveBtn() {
		scrollToElement(driver, OCR_CreateNewShipment_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewShipment_Save, "Click on Save button");
	}

	// click on save and return button
	public void click_SaveReturn() {
		scrollToElement(driver, OCR_CreateNewShipment_SaveAndReturn);
		clickElement(driver, test, OCR_CreateNewShipment_SaveAndReturn, "Click on Save and Return Button");

	}

	// Enter Shipment number when adding shipment to invoice for Regression US
	public void enter_ShipNo(String InvShipmntNo) {
		Wait.waitfor(2);
		clearText(driver, test, OCR_CreateNewShipment_Regres_EnterShipment, "Clear existing Shipment number :");
		typeText(driver, test, OCR_CreateNewShipment_Regres_EnterShipment, "Enter Shipment Number : ", InvShipmntNo);
		typeText(driver, test, OCR_CreatNewShipment_ShipmentNo, "Enter  Random ShipmentNo : ", randomnumbers());
	}
	
	public void scrollToShip() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewShipment_Regres_EnterShipment);
	}

	// Validating the Header details in create new Shipment Page
	public void validateHeaderInfo() {

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Shipment No. Required.')]")) {
					test.log(LogStatus.INFO, "Shipment No. Required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Country of Ult. Destination required.')]")) {
					test.log(LogStatus.INFO, "Country of Ult. Destination required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Exporter is required.')]")) {
					test.log(LogStatus.INFO, "Exporter is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Create new shipment page");
		}
	}

	// Getting the color of flag
	public String gettingColor() {
		Wait.waitfor(3);
		String color = driver.findElement(By.xpath("//i[@class='fa fa-flag']")).getCssValue("color");
		String code = Color.fromString(color).asHex();
		if (code.equalsIgnoreCase("#228b22"))
			return "Green";
		if (code.equalsIgnoreCase("#d43f3a"))
			return "Red";
		return null;
	}

	// Validating the entity Screeing status
	public void validateEntityScreeing(String Status, String EntityType) {
		scrollToElement(driver, "//span[@class='heading-additional']");
		Wait.waitfor(2);
		if (Status.equalsIgnoreCase("Approved")) {
			try {
				if (isDisplayed(driver, "//i[@class='fa fa-user']//i[@class='fa fa-check-circle green']")) {
					test.log(LogStatus.PASS, "Entity Screeing Icon : Green");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Entity Screeing Icon : Not Green");
			}
			clickElement(driver, test, OCR_CreateNewShipment_EntityIcon, "Click on Entity Screeing Icon");
			Wait.waitfor(2);
			String entityStatus = getText(driver, test,
					"//table[@class='table table-striped table-bordered table-condensed']/tbody/tr/td[contains(text(),'"
							+ EntityType + "')]/../td[3]",
					"Get Entity Status of " + EntityType + " : ");
			if (!entityStatus.equals("Approved"))
				testFailSshot(driver, test);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
		}
		if (Status.equalsIgnoreCase("OnHold")) {
			try {
				if (isDisplayed(driver, "//i[@class='fa fa-user']//i[@class='fa fa-exclamation-circle red']")) {
					test.log(LogStatus.PASS, "Entity Screeing Icon : RED");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Entity Screeing Icon : Not RED");
			}
			clickElement(driver, test, OCR_CreateNewShipment_EntityIcon, "Click on Entity Screeing Icon");
			Wait.waitfor(2);
			String entityStatus = getText(driver, test,
					"//table[@class='table table-striped table-bordered table-condensed']/tbody/tr/td[contains(text(),'"
							+ EntityType + "')]/../td[3]",
					"Get Entity Status of " + EntityType + " : ");
			if (!entityStatus.equals("On Hold"))
				testFailSshot(driver, test);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");

		}
		if (Status.equalsIgnoreCase("Overridden")) {
			try {
				if (isDisplayed(driver, "//i[@class='fa fa-user']//i[@class='fa fa-check-circle green']")) {
					test.log(LogStatus.PASS, "Entity Screeing Icon : Green");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Entity Screeing Icon : Not Green");
			}
			clickElement(driver, test, OCR_CreateNewShipment_EntityIcon, "Click on Entity Screeing Icon");
			Wait.waitfor(2);
			String entityStatus = getText(driver, test,
					"//table[@class='table table-striped table-bordered table-condensed']/tbody/tr/td[contains(text(),'"
							+ EntityType + "')]/../td[3]",
					"Get Entity Status of " + EntityType + " : ");
			if (!entityStatus.equals("Overridden"))
				testFailSshot(driver, test);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
		}
	}

	// Validating the Entity Compliance Summary
	public void validateComplianceSummary(String Status) {
		scrollToElement(driver, "//span[@class='heading-additional']");
		Wait.waitfor(2);
		if (Status.equalsIgnoreCase("Approved")) {
			clickElement(driver, test, OCR_CreateNewShipment_ComplianceSummary, "Click on Compliance Summary Report");
			String CountryConcerns = getText(driver, test,
					"//label[contains(text(),'Embargoed country concerns :')]/../div[1]",
					"Getting the country concerns :");
			if (CountryConcerns.equalsIgnoreCase("Possible Concern")) {
				try {
					if (isDisplayed(driver,
							"//label[contains(text(),'Embargoed country concerns :')]/../div[2]/i[@class='fa fa-exclamation-triangle yellow']")) {
						test.log(LogStatus.PASS, "Embargoed country concerns : Possible Concern");
						Wait.waitfor(3);
						clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
					}
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Embargoed country concerns : None");
					clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
				}
				try {
					if (isDisplayed(driver,
							"//i[@class='fa fa-file-text-o']//i[@class='fa fa-exclamation-circle yellow']"))
						test.log(LogStatus.PASS, "Compliance Summary Icon : Yellow");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Compliance Summary Icon Color : Not Yellow ");
				}
			} else {
				try {
					if (isDisplayed(driver, "//i[@class='fa fa-file-text-o']//i[@class='fa fa-check-circle green']")) {

						test.log(LogStatus.PASS, "Compliance Summary Icon : Green");
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Compliance Summary Icon Color : Not Green ");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
			}

			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreateNewShipment_ComplianceSummary, "Click on Compliance Summary Report");
			Wait.waitfor(2);
			String color = driver
					.findElement(By.xpath("//label[contains(text(),'Shipment Entity Screening :')]/../div[2]/i"))
					.getCssValue("color");
			String code = Color.fromString(color).asHex();
			if (code.equals("#008000"))
				test.log(LogStatus.PASS, "Shipment Entity Screening : Green ICON");
			else
				testFailSshot(driver, test);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
		}
		if (Status.equalsIgnoreCase("OnHold")) {
			try {
				if (isDisplayed(driver, "//i[@class='fa fa-file-text-o']//i[@class='fa fa-exclamation-circle red']")) {
					test.log(LogStatus.PASS, "Compliance Summary Icon : RED");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Compliance Summary Icon Color : Not RED ");
			}
			clickElement(driver, test, OCR_CreateNewShipment_ComplianceSummary, "Click on Compliance Summary Report");
			Wait.waitfor(2);
			String color = driver
					.findElement(By.xpath("//label[contains(text(),'Shipment Entity Screening :')]/../div[2]/i"))
					.getCssValue("color");
			String code = Color.fromString(color).asHex();
			if (code.equals("#ff0000"))
				test.log(LogStatus.PASS, "Shipment Entity Screening : OnHold ICON");
			else
				testFailSshot(driver, test);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
		}
		if (Status.equalsIgnoreCase("Overridden")) {
			try {
				if (isDisplayed(driver,
						"//i[@class='fa fa-file-text-o']//i[@class='fa fa-exclamation-circle yellow']")) {
					test.log(LogStatus.PASS, "Compliance Summary Icon : Yellow");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Compliance Summary Icon Color : Not Yellow ");
			}
			clickElement(driver, test, OCR_CreateNewShipment_ComplianceSummary, "Click on Compliance Summary Report");
			Wait.waitfor(2);
			String color = driver
					.findElement(By.xpath("//label[contains(text(),'Shipment Entity Screening :')]/../div[2]/i"))
					.getCssValue("color");
			String code = Color.fromString(color).asHex();
			if (code.equals("#008000"))
				test.log(LogStatus.PASS, "Shipment Entity Screening : Overridden ICON");
			else
				testFailSshot(driver, test);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_CloseBtn, "Click on Close Button");
		}
	}

	// Get the Ult.consignee
	public String getUltConsignee() {
		return getText(driver, test, "//table[@id='entityTable']//tr[2]/td[2]", "Get the utl Consignee : ");
	}

	// Get the Ult.consignee Name
	public String getUltConsigneeName() {
		return getText(driver, test, "//table[@id='entityTable']//tr[2]/td[3]", "Get the utl Consignee Name : ");
	}

	// click on Generate document icon
	public void Click_GenerateDocument() {
		clickElement(driver, test, OCR_CreateNewShipment_GenerateDocument, "Click on Document Icon");
	}
	
	
	
	//select bill of lading, certificate of origin and international shipping authorizatrion checkbox
	public void selectDocs()
	{
		Wait.waitfor(2);
		clickElement(driver, test, "(//input[@name='docSelected'])[1]", "Select Bill Of Lading-Straight :");
		Wait.waitfor(2);
		clickElement(driver, test, "(//input[@name='docSelected'])[9]", "Select Certificate Of Origin :");
		Wait.waitfor(2);
		scrollToElement(driver, "(//input[@name='docSelected'])[31]");
		clickElement(driver, test, "(//input[@name='docSelected'])[31]", "Select International Shipping Authorization :");
	}
	
	//select commercial invoice checkbox
		public void selectCommInvoice()
		{
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CNOItem_Regres_SelectNoneOption, "Deselect all options :");
			scrollToElement(driver, "(//input[@name='docSelected'])[17]");
			clickElement(driver, test, "(//input[@name='docSelected'])[17]", "Select Commercial Invoice option :");
			scrollToElement(driver, "(//i[@class='fa fa-download'])[17]");
			clickElement(driver, test, "(//i[@class='fa fa-download'])[17]", "Download Commercial Invoice pdf");
		}
	
	//scroll to generate documents button and click on it
	public void generateDocBtn() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNOItem_Regres_GenerateDocBtn);
		clickElement(driver, test, OCR_CNOItem_Regres_GenerateDocBtn, "Click on Generate All Documents button :");
		}
	
	//Enter email id for all 3 docs selected
	public void enterEmailID(String emailID1, String emailID2, String emailID3) {
		Wait.waitfor(2);
		scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[1]");
		Wait.waitfor(2);
		clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[1]", "Enter Email ID 1");
		Wait.waitfor(2);
		typeText(driver, test, "(//input[@autocomplete='new-password'])[3]", "Enter Email ID to send the link : ", emailID1);
		
		scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[2]");
		Wait.waitfor(2);
		clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[2]", "Enter Email ID 2");
		Wait.waitfor(2);
		typeText(driver, test, "(//input[@autocomplete='new-password'])[4]", "Enter Email ID to send the link : ", emailID2);
		
		scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[3]");
		Wait.waitfor(2);
		clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[3]", "Enter Email ID 3");
		Wait.waitfor(2);
		typeText(driver, test, "(//input[@autocomplete='new-password'])[5]", "Enter Email ID to send the link : ", emailID3);
		
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewShipment_EmailWithLink);
		clickElement(driver, test, OCR_CreateNewShipment_EmailWithLink, "click on Send email with link");
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
		clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Pop up Close button");
		
	}


	// Validating the Generate Document
	public void validateDocument(String EmailGroup, String EmailDocumentTo) {
		clickElement(driver, test, OCR_CreateNewShipment_GenerateAllDocumentBtn,
				"CLick on Generate All Document Button");
		Wait.waitfor(30);
		try {
			selectByVisibleText(driver, test, OCR_CreateNewShipment_EmailGroup, "Select the Email Group : ",
					EmailGroup);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewShipment_EmailGroupDocumentTO, "Click Eamil Document To");
			typeText(driver, test, OCR_CreateNewShipment_EmailGroupDocumentTO, "Enter the Eamil Document to : ",
					EmailDocumentTo);
			clickElement(driver, test, OCR_CreateNewShipment_EmailGroupDocumentIcon, "Click on Email Document Icon");
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
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Pop up Close button");
		}
	}

	// Click on Send email with link
	public void clickSendEmailWithLink(String emailID) {

		try {
			List<WebElement> listOfElements = driver
					.findElements(By.xpath("//div[@class='ocr-modal-cont']//input[@class='docSelectedSet']"));
			for (int i = 1; i <= listOfElements.size(); i++) {
				clickElement(driver, test,
						"(//div[@class='ocr-modal-cont']//input[@class='docSelectedSet'])" + "[" + i + "]",
						"Deselect the Documents check box : " + i);
			}
			clickElement(driver, test, "(//div[@class='ocr-modal-cont']//input[@class='docSelectedSet'])[1]",
					"Select the Simple Invoice");
			Wait.waitfor(2);
			scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[1]");
			Wait.waitfor(2);
			clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[1]", "Enter Email ID");
			Wait.waitfor(2);
			
			typeText(driver, test, "(//input[@autocomplete='new-password'])[3]", "Enter Email ID to send the link : ", emailID);
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewShipment_EmailWithLink);
			clickElement(driver, test, OCR_CreateNewShipment_EmailWithLink, "click on Send email with link");
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
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Pop up Close button");
			
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Pop up Close button");
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
				scrollToElement(driver, OCR_CreateNewShipment_EmailWithAttachment);
				clickElement(driver, test, OCR_CreateNewShipment_EmailWithAttachment, "click on Send email with Attachment");
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
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Pop up Close button");
				
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewShipment_Exporter_PopupClose, "Click on Pop up Close button");
			}
		}
	

	// Getting the ship validation text
	public String getshipvalidate() {
		String shipValidate = "//table[@class='table table-condensed table-bordered']//tr/td/b[contains(text(),'Ship to Details are required.')]/../../td[2]";
		return getText(driver, test, shipValidate, "Get the ship to details Status : ");
	}

	// validating Part Number Screening status
	public String getPartNumberStatus() {
		String partNo = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'Missing or Incomplete Part Number details.')]/../../td[2]";
		return getText(driver, test, partNo, "Get the Part Number Status : ");
	}

	// Validating Incomplete HTS/ScheduleB Number details
	public String getHTSNumber() {
		String hts = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'Missing or Incomplete HTS')]/../../td[2]";
		return getText(driver, test, hts, "Get the Incomplete HTS/ScheduleB Number details : ");
	}

	// validating the Primary Unit is missing on Screening Status screen
	public String getPrimaryUnits() {
		String primaryUnits = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'Primary Unit is missing.')]/../../td[2]";
		return getText(driver, test, primaryUnits, "Get the Primary Unit on Screening Status : ");
	}

	// validating USML/ECCN is missing on Screening Status screen
	public String getECCN() {
		String ECCN = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'USML')]/../../td[2]";
		return getText(driver, test, ECCN, "Get the USML/ECCN on Screening Status : ");
	}

	// validating US ECCN is missing on Screening Status screen
	public String getUSECCN() {
		String ECCN = "//table[@class='table table-condensed table-bordered']//b[contains(text(),'US ECCN is missing.')]/../../td[2]";
		return getText(driver, test, ECCN, "Get the US ECCN on Screening Status : ");
	}

	//verify Edit Shipment page from invoice no with shipped status
	public void verifyShipmentHeader() {
		try {
			if(isDisplayed(driver, "//h3[contains(text(),'Edit Shipment')]")) {
				test.log(LogStatus.INFO, "Shipment Page is opened successfully .");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Shipment Page is not opened successfully .");
		}
	}
	
	//click on close button of Shipment header page
	public void ShipPagecloseBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewShipment_Regres_CloseBtn, "Close the Edit Shipment page :");
	}
	
	//click on Custom filing view from Shipment header page
		public void customFilingView() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewShipment_AdditionalInformation);
			scrollToTop(driver);
			clickElement(driver, test, OCR_CreateNewShipment_AdditionalInformation,
					"Click on Additional Transaction Details");
			clickElement(driver, test, OCR_CreateNewShipment_Regres_CustomFilingView, "Select Custom Filing View :");
		}
	public void Shipment_NoAdd(String ShipmentNo) {
		typeText(driver, test, OCR_CreatNewShipment_ShipmentNo, "Enter ShipmentNo : ", ShipmentNo+randomnumbers());
		//typeText(driver, test, OCR_CreatNewShipment_ShipmentNo, "Enter  Random ShipmentNo : ", randomnumbers());
	}
	public void ShipmentSave() {
		clickElement(driver, test, OCR_CreateNewShipment_Save, "click on save button");
	}
	
	//FTA Yes and No 
	public void FTA() {
		clickElement(driver, test, OCR_createNewShipment_FTANo, "Clicking On FTA no :");
	}
	
	public void contactFullName() {
		scrollToElement(driver, OCR_CreateNewShipment_UltConsignee);
		clickElement(driver, test, OCR_CreateNewShipment_UltConsignee, "Click on Ult Consignee link : ");
		String contactFullName = getText(driver, test, "//a[contains(text(),'Contact Full Name')]", "Fetch the contact full name field : ");
		if(contactFullName.equalsIgnoreCase("Contact Full Name")) {
			test.log(LogStatus.PASS, "Contact Full name is displayed on Ultimate Consignee pop up :");
		}
		else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Contact Full name is not displayed on Ultimate Consignee pop up :");
			
		}
		clickElement(driver, test, OCR_CreateNewShipment_UltConsignee_PopupClose, "Close the pop up :");
		scrollToElement(driver, OCR_CreateNewShipment_Save);
	}
	
	// Get the Shipment NO
	public String getShipNo() {
		return getText(driver, test, "(//span[@class='additional-value'])[1]", "Get the Shipment No : ");
	}

	// Get the Shipment Status
	public String getShipStatus() {
		return getText(driver, test, "(//span[@class='additional-value'])[2]", "Get the Shipment Work Status : ");
	}
	
	//Click on Close button
	public void closeButton() {
		clickElement(driver, test, OCR_createNewShipment_Close, "Clicking on Close Button :");
	}
		
		//change status to return for rework
		public void changeStatusToReturnForRework(String ReturnRework) {
			Wait.waitfor(2);
			clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
			Wait.waitfor(2);
			clickElement(driver, test, "//a[contains(text(),'" + ReturnRework + "')]", "Select status as Return For Review : " + ReturnRework);
		
		}
		
	
		public void scrollToExporterDetails() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewShipment_Exporter_Code);
		}
		
		public void scrollToUltConsigneeDetails() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewShipment_UltConsignee_Code);
		}
		
		public void scrollToIntConsigneeDetails() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewShipment_IntConsignee_Code);
		}

		public void scrollToEndUserDetails() {
			Wait.waitfor(2);
			scrollToElement(driver, "//a[contains(text(),'End User')]");
		}

		public void scrollToFFDetails() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_CreateNewShipment_FF_Code);
		}
		
		public void shipNum(String shipNum) {
			Wait.waitfor(2);
			clearText(driver, test, "//input[@id='editShipment_shipment_shipmentNo']", "");
			typeText(driver, test, "//input[@id='editShipment_shipment_shipmentNo']", "Enter Shipment Number : ", shipNum + randomnumbersbetween1_1000());
		}


}

