package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class TempAuthorizationCloseOUTPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...............................Locators ...................................//
	public static final String Auth_Mana_Search="//button[contains(text(),'Search')]";
	public static final String Auth_Mana_Reset="//button[contains(text(),'Reset')]";
	public static final String Auth_Mana_SBUCode="//select[@name='licenseTransaction.sbuCode']";
	public static final String Auth_Mana_ShipmentFlagExport="//select[@name='licenseTransaction.shipmentType']";
	public static final String Auth_Mana_ShipmentFlagSelect="//select[@id='searchAuthorizationCloseout_licenseTransaction_shipmentSubType']";
	public static final String Auth_Mana_CountryOfAuthorization="//input[@id='searchAuthorizationCloseout_authGrantCountryName']";
	public static final String Auth_Mana_ActivityType="//select[@name='activityType']";
	public static final String Auth_Mana_AuthorizationNo="//a[@id='authorizationNo']";
	public static final String Auth_Mana_AuthNoPopUp="//input[@name='licenseHeaderDTO.licenseNo']";
	public static final String Auth_Mana_SearchPopup="(//button[@name='Search'])[2]";
	public static final String Auth_Mana_SelectPopUp="(//button[@name='Ok'])";
	public static final String Auth_Mana_AuthorizationNoTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_licenseNo']";
	public static final String Auth_Mana_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String Auth_Mana_AuthTypePopUp="//textarea[@name='licenseTypes.licenseType']";
	public static final String Auth_Mana_AuthorizationTypeTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_licenseType']";
	public static final String Auth_Mana_RefNo="//input[@id='searchAuthorizationCloseout_licenseTransaction_referenceNo']";
	public static final String Auth_Mana_TransactionID="//input[@id='searchAuthorizationCloseout_licenseTransaction_transactionId']";
	public static final String Auth_Mana_ExportShipmentNo="//a[contains(text(),'Export Shipment No')]";
	public static final String Auth_Mana_ExportShipmenTNoPopUp="//input[@name='shipmentDTO.shipmentNo']";
	public static final String Auth_Mana_ExportShipmentNoTextBox="//a[contains(text(),'Export Shipment No')]";
	public static final String Auth_Mana_CustomsRefNo="//input[@id='searchAuthorizationCloseout_licenseTransaction_itnNo']";
	public static final String Auth_Mana_EntryNo="//input[@id='searchAuthorizationCloseout_licenseTransaction_entryNo']";
	public static final String Auth_Mana_InternalRefNo="//input[@id='searchAuthorizationCloseout_licenseTransaction_internalRefNo']";
	public static final String Auth_Mana_PartyName="//input[@id='searchAuthorizationCloseout_licenseTransaction_partyName']";
	public static final String Auth_Mana_TravelerName="//a[contains(text(),'Traveler Name')]";
	public static final String Auth_Mana_UserFirstNamePopup="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_TravelerNameTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_travelerName']";
	public static final String Auth_Mana_TransactionDate="//input[@id='searchAuthorizationCloseout_transactionDateFrom']";
	public static final String Auth_Mana_TransactionDateTo="//input[@id='searchAuthorizationCloseout_transactionDateTo']";
	public static final String Auth_Mana_StopTracking="//select[@id='searchAuthorizationCloseout_licenseTransaction_stopTracking']";
	public static final String Auth_Mana_CountryShippedFrom="//input[@id='searchAuthorizationCloseout_licenseTransaction_countryNameFrom']";
	public static final String Auth_Mana_PortOfExport="//a[contains(text(),'Port of Export')]";
	public static final String Auth_Mana_PortID="//input[@name='ports.portId']";
	public static final String Auth_Mana_PortOfExportTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_portOfTransaction']";
	public static final String Auth_Mana_CountryShippedTo="//input[@id='searchAuthorizationCloseout_licenseTransaction_countryName']";
	public static final String Auth_Mana_PortOfImport="//a[contains(text(),'Port of Import')]";
	public static final String Auth_Mana_PortOfImportTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_portOfimport']";
	public static final String Auth_Mana_PartNo="//a[contains(text(),'Part Number')]";
	public static final String Auth_Mana_PartNoPopUp="//input[@name='product.productCode']";
	public static final String Auth_Mana_PartNoTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_productCd']";
	public static final String Auth_Mana_SerialNo="//input[@id='searchAuthorizationCloseout_licenseTransaction_serialNo']";
	public static final String Auth_Mana_ExportClassification="//a[contains(text(),'Export Classification')]";
	public static final String Auth_Mana_ECCNUSMLPopup="//input[@name='productClazz.prodClassification']";
	public static final String Auth_Mana_ExportClassificationTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_productClass']";
	public static final String Auth_Mana_importClassification="//a[contains(text(),'Import Classification')]";
	public static final String Auth_Mana_HSNoPopup="//input[@name='hsNo']";
	public static final String Auth_Mana_importClassificationTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_importClassification']";
	public static final String Auth_Mana_OrderNo="//input[@id='searchAuthorizationCloseout_licenseTransaction_orderNo']";
	public static final String Auth_Mana_Program="(//a[contains(text(),'Program')])[3]";
	public static final String Auth_Mana_ProgramCodePopup="//input[@name='programTab.programCode']";
	public static final String Auth_Mana_ProgramTextBox="//textarea[@id='searchAuthorizationCloseout_licenseTransaction_programCode']";
	public static final String Auth_Mana_Segement="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_SegementTextBox="//textarea[@id='searchAuthorizationCloseout_licenseTransaction_segmentName']";
	public static final String Auth_Mana_Site="//a[contains(text(),'Site')]";
	public static final String Auth_Mana_SiteID="//input[@name='dosSite.siteId']";
	public static final String Auth_Mana_SiteTextBox="//textarea[@id='searchAuthorizationCloseout_licenseTransaction_siteName']";
	public static final String Auth_Mana_Region="//a[contains(text(),'Region')]";
	public static final String Auth_Mana_RegionTextBox="//input[@id='searchAuthorizationCloseout_licenseTransaction_regionName']";
	
	public static final String Auth_Mana_SortBy="//select[@id='searchAuthorizationCloseout_sortBy']";
	public static final String Auth_Mana_Direction="//select[@name='direction']";
	
	//......................................Constructor ...............................................//
	public TempAuthorizationCloseOUTPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..................................Click on Search Tab .................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab :");
	}
	
	//..................................Click on Reset Tab .................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Clicking on Reset Tab :");
	}
	
	//.............................Search By Parameters ...................................//
	public void searchByParameters(String sbu,String ShipmentFlagExport,String ShipmentFlag, String CountryOfAuthorization, String ActivityType,
			String AuthorizationNo, String AuthorizationType, String ReferanceID, String TransactionID, String ExportShipmentNo, String CustomRefNo, 
			String EntryNo, String InternalRefNo, String PartyName, String TravelerName, String TransactionDate, String TransactionDateTo, 
			String StopTracking, String CountryShippedFrom, String PortOfExport, String CountryShippedTo, String PortOfImport, String PartNo,
			String SerialNo, String ExportClassification, String ImportClassification, String OrderNo, String Program, String Segment, 
			String Site, String Region, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, Auth_Mana_SBUCode, "Selecting SBU :", sbu);
		if(ShipmentFlagExport.contains("Import")) {
			selectByVisibleText(driver, test, Auth_Mana_ShipmentFlagSelect, "Selecting Shipment Flag :", ShipmentFlag);
		}else {
			selectByVisibleText(driver, test, Auth_Mana_ShipmentFlagExport, "Selecting Shipment Flag :", ShipmentFlagExport);
		}
		clearText(driver, test, Auth_Mana_CountryOfAuthorization, "Clearing Country of Authorization :");
		typeText(driver, test, Auth_Mana_CountryOfAuthorization, "Entering Country of Authorization :", CountryOfAuthorization);
		selectByVisibleText(driver, test, Auth_Mana_ActivityType, "Selecting Activity Type :", ActivityType);
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, Auth_Mana_AuthNoPopUp, "Entering Authorization No :", AuthorizationNo);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :"+AuthorizationNo);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationNoTextBox, "Entering Authorization No in Textbox :", AuthorizationNo);
		}
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, Auth_Mana_AuthTypePopUp, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :"+AuthorizationType);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationTypeTextBox, "Entering Authorization Type in Textbox :", AuthorizationType);
		}
		typeText(driver, test, Auth_Mana_RefNo, "Entering Referance ID :", ReferanceID);
		typeText(driver, test, Auth_Mana_TransactionID, "Entering Transaction ID :", TransactionID);
		if(ExportShipmentNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExportShipmentNo, "Clicking on ExportShipment No :");
			try {
				typeText(driver, test, Auth_Mana_ExportShipmenTNoPopUp, "Entering AExportShipment No :", ExportShipmentNo);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportShipmentNo+"')]", "Selecting ExportShipment No :"+ExportShipmentNo);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ExportShipmentNoTextBox, "Entering ExportShipment No in Textbox :", ExportShipmentNo);
		}
		typeText(driver, test, Auth_Mana_CustomsRefNo, "Entering Customs Referance No :", CustomRefNo);
		typeText(driver, test, Auth_Mana_EntryNo, "Entering Entry No :", EntryNo);
		typeText(driver, test, Auth_Mana_InternalRefNo, "Entering Internal Referance No :", InternalRefNo);
		typeText(driver, test, Auth_Mana_PartyName, "Entering Party Name :", PartyName);
		if(TravelerName.length() > 0) {
			clickElement(driver, test, Auth_Mana_TravelerName, "Clicking on Traveler Name :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopup, "Entering Traveler Name :", TravelerName);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "(//td[contains(text(),'"+TravelerName+"')])[1]", "Selecting Traveler Name :"+TravelerName);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_TravelerNameTextBox, "Entering Traveler Name in Textbox :", TravelerName);
		}
		if(TransactionDate.length() > 0) {
			clickElement(driver, test, Auth_Mana_TransactionDate, "Clicking on Transactin Date From :");
			dateOfMonthName(driver, test, "Selecting Transaction Date From :", TransactionDate);
		}
		if(TransactionDateTo.length() > 0) {
			clickElement(driver, test, Auth_Mana_TransactionDateTo, "Clicking on Transaction Date To :");
			dateOfMonthName(driver, test, "Selecting Transaction Date To :", TransactionDateTo);
		}
		selectByVisibleText(driver, test, Auth_Mana_StopTracking, "Selecting Stop Tracking :", StopTracking);
		typeText(driver, test, Auth_Mana_CountryShippedFrom, "Entering Country Shipped From :", CountryShippedFrom);
		if(PortOfExport.length() > 0) {
			clickElement(driver, test, Auth_Mana_PortOfExport, "Clicking on Port Of Export :");
			try {
				typeText(driver, test, Auth_Mana_PortID, "Entering Port Of Export :", PortOfExport);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PortOfExport+"')]", "Selecting Port Of Export :"+PortOfExport);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_PortOfExportTextBox, "Entering Port Of Export in Textbox :", PortOfExport);
		}
		typeText(driver, test, Auth_Mana_CountryShippedTo, "Entering Country Shipped From :", CountryShippedTo);
		if(PortOfImport.length() > 0) {
			clickElement(driver, test, Auth_Mana_PortOfImport, "Clicking on Port Of Import :");
			try {
				typeText(driver, test, Auth_Mana_PortID, "Entering Port Of Import :", PortOfImport);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PortOfImport+"')]", "Selecting Port Of Import :"+PortOfImport);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_PortOfImportTextBox, "Entering Port Of Import in Textbox :", PortOfImport);
		}
		if(PartNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_PartNo, "Clicking on Part No :");
			try {
				typeText(driver, test, Auth_Mana_PartNoPopUp, "Entering Part No :", PartNo);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PartNo+"')]", "Selecting Part No :"+PartNo);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_PartNoTextBox, "Entering Part No in Textbox :", PartNo);
		}
		typeText(driver, test, Auth_Mana_SerialNo, "Entering Serial No :", SerialNo);
		if(ExportClassification.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExportClassification, "Clicking on Export Classification :");
			try {
				typeText(driver, test, Auth_Mana_ECCNUSMLPopup, "Entering Export Classification :", ExportClassification);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportClassification+"')]", "Selecting Export Classification :"+ExportClassification);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ExportClassificationTextBox, "Entering Export Classification in Textbox :", ExportClassification);
		}
		if(ImportClassification.length() > 0) {
			clickElement(driver, test, Auth_Mana_importClassification, "Clicking on Import Classification :");
			try {
				typeText(driver, test, Auth_Mana_HSNoPopup, "Entering Import Classification :", ImportClassification);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ImportClassification+"')]", "Selecting Import Classification :"+ImportClassification);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_importClassificationTextBox, "Entering Import Classification in Textbox :", ImportClassification);
		}
		typeText(driver, test, Auth_Mana_OrderNo, "Entering Order No :", OrderNo);
		if(Program.length() > 0) {
			clickElement(driver, test, Auth_Mana_Program, "Clicking on Program :");
			try {
				typeText(driver, test, Auth_Mana_ProgramCodePopup, "Entering Program :", Program);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :"+Program);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ProgramTextBox, "Entering Program in Textbox :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, Auth_Mana_Segement, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :"+Segment);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_SegementTextBox, "Entering Segment in Textbox :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, Auth_Mana_Site, "Clicking on Site :");
			try {
				typeText(driver, test, Auth_Mana_SiteID, "Entering Site :", Site);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :"+Site);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_SiteTextBox, "Entering Site in Textbox :", Site);
		}
		if(Region.length() > 0) {
			clickElement(driver, test, Auth_Mana_Region, "Clicking on Region :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Region+"')]", "Selecting Region :"+Region);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on select Button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_RegionTextBox, "Entering Region in Textbox :", Region);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction :", Direction);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, Auth_Mana_CountryOfAuthorization, "Getting Country First Value :");
		getSelectFirstText(driver, test, Auth_Mana_CountryShippedFrom, "Getting Country Shipped From :");
		getSelectFirstText(driver, test, Auth_Mana_CountryShippedTo, "Getting Country Shipped To :");
	}
}
