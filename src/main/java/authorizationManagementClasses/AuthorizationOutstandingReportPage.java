package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AuthorizationOutstandingReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
		public static final String AuthMana_Report_Search ="//button[contains(text(),'Search')]";
		public static final String AuthMana_Report_Reset ="//button[contains(text(),'Reset')]";
		public static final String AuthMana_Report_SBUCode ="//select[@name='licenseTransaction.sbuCode']";
		public static final String AuthMana_Report_ActivityType ="//select[@name='licenseTransaction.activityType']";
		public static final String AuthMana_Report_OriginatingTransaction ="//select[@name='licenseTransaction.shipmentType']";
		public static final String AuthMana_Report_AuthorizationType ="(//a[contains(text(),'Authorization Type')])[2]";
		public static final String AuthMana_Report_AuthorizationTypePopup ="//textarea[@name='licenseTypes.licenseType']";
		public static final String AuthMana_Report_SearchPopup = "(//button[@name='Search'])[2]";
		public static final String AuthMana_Report_SelectPopup = "(//button[@name='Ok'])[1]";
		public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
		public static final String AuthMana_Report_AuthorizationTypeTextbox = "//textarea[@name='licenseTransaction.licenseType']";
		public static final String AuthMana_Report_AuthorizationNo ="//a[contains(text(),'Authorization No.')]";
		public static final String AuthMana_Report_AuthorizationtNoPopup ="//input[@name='licenseHeaderDTO.licenseNo']";
		public static final String AuthMana_Report_AuthorizationNoTextbox = "//input[@name='licenseTransaction.licenseNo']";
		public static final String AuthMana_Report_ReferanceNo = "//input[@name='licenseTransaction.referenceNo']";
		public static final String AuthMana_Report_EntryNo = "//input[@name='licenseTransaction.entryNo']";
		public static final String AuthMana_Report_PartyName = "//input[@name='licenseTransaction.partyName']";	
		public static final String AuthMana_Report_TravelerName ="//a[contains(text(),'Traveler Name')]";
		public static final String AuthMana_Report_UserFirstNamePopup ="//input[@name='userProfile.userFirstname']";
		public static final String AuthMana_Report_TravelerNameTextbox = "//input[@name='licenseTransaction.travelerName']";
		public static final String AuthMana_Report_TransactionDateFrom ="//input[@name='transactionDate']";
		public static final String AuthMana_Report_TransactionDateTo = "//input[@name='transactionDateTo']";
		public static final String AuthMana_Report_ExpiryDateFrom ="//input[@name='expiryDate']";
		public static final String AuthMana_Report_ExpiryDateTo = "//input[@name='expiryDateTo']";
		public static final String AuthMana_Report_CountryShippedFrom = "//input[@name='licenseTransaction.countryNameFrom']";
		public static final String AuthMana_Report_PortofExport ="//a[contains(text(),'Port of Export')]";
		public static final String AuthMana_Report_PortCode ="//input[@name='ports.portCode']";
		public static final String AuthMana_Report_PortOfExportTextbox = "//input[@name='portOfExport']";	
		public static final String AuthMana_Report_CountryShippedTo = "//input[@name='licenseTransaction.countryName']";
		public static final String AuthMana_Report_PortofImport ="//a[contains(text(),'Port of Import')]";
		public static final String AuthMana_Report_PortOfImportTextbox = "//input[@name='portOfImport']";
		public static final String AuthMana_Report_PartNumber ="//a[contains(text(),'Part Number')]";
		public static final String AuthMana_Report_PartNoPopup ="//input[@name='product.productCode']";
		public static final String AuthMana_Report_PartNoTextbox = "//input[@name='licenseTransaction.productCd']";
		public static final String AuthMana_Report_SerialNo = "//input[@name='licenseTransaction.serialNo']";
		public static final String AuthMana_Report_ExportClassification ="//a[contains(text(),'Export Classification')]";
		public static final String AuthMana_Report_ECCNUSMLPopup ="//input[@name='productClazz.prodClassification']";
		public static final String AuthMana_Report_ExportClassificationTextbox = "//input[@name='licenseTransaction.productClass']";
		public static final String AuthMana_Report_ImportClassification ="//a[contains(text(),'Import Classification')]";
		public static final String AuthMana_Report_HSNoPopup ="//input[@name='hsNo']";
		public static final String AuthMana_Report_ImportClassificationTextbox = "//input[@name='licenseTransaction.importClassification']";
		public static final String AuthMana_Report_ExportShipmentNo = "//input[@name='licenseTransaction.exportShipmentNo']";
		public static final String AuthMana_Report_ExpiresIn ="(//select[@name='expiresIn'])[1]";
		public static final String AuthMana_Report_IncludeLicense = "(//select[@name='includeLicense'])[1]";
		public static final String AuthMana_Report_OrderNo = "(//input[@name='licenseTransaction.orderNo'])[1]";
		public static final String AuthMana_Report_Program ="(//a[contains(text(),'Program')])[3]";
		public static final String AuthMana_Report_programCodePopup ="(//input[@name='programTab.programCode'])[1]";
		public static final String AuthMana_Report_ProgramTextbox = "(//textarea[@name='licenseTransaction.programCode'])[1]";
		public static final String AuthMana_Report_Segment ="(//a[contains(text(),'Segment')])[2]";
		public static final String AuthMana_Report_SegmentTextbox = "(//textarea[@name='licenseTransaction.segmentName'])[1]";
		public static final String AuthMana_Report_Site ="(//a[contains(text(),'Site')])";
		public static final String AuthMana_Report_SiteIDPopup ="(//input[@name='dosSite.siteId'])[1]";
		public static final String AuthMana_Report_SiteTextbox = "(//textarea[@name='licenseTransaction.siteName'])[1]";
		public static final String AuthMana_Report_Region ="(//a[contains(text(),'Region')])";
		public static final String AuthMana_Report_RegionTextbox = "(//input[@name='licenseTransaction.regionName'])[1]";
		public static final String AuthMana_Report_SortBy ="(//select[@name='sortBy'])[1]";
		public static final String AuthMana_Report_Direction = "(//select[@name='direction'])[1]";
	
	//..................................Constructors..................................//
	public AuthorizationOutstandingReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, AuthMana_Report_Reset, "Clicking on Reset Button :");
	}
	
	//..................................Search By Parameters......................................//
	public void searchByParameters(String SBUCode, String ActivityType, String OriginatingTransaction, String AuthorizationType, String AuthorizationNo, 
			 String ReferanceNo, String EntryNo, String PartyName, String TravelerName, String TransactionDateFrom, String TransactionDateTo, 
			String ExpiryDateFrom, String ExpiryDateTo, String CountryShippedFrom, String PortOfExport, String CountryShippedTo, String PortOfImport, 
			String PartNo, String SerialNo, String ExportClassification, String ImportClassification, String ExportShipmentNo, String ExpiresIn, 
			String IncludeLicense, String OrderNo, String Program, String Segment, String Site, String Region,  String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_ActivityType, "Selecting Activity Type :", ActivityType);
		selectByVisibleText(driver, test, AuthMana_Report_OriginatingTransaction, "Selecting Originating Transaction :", OriginatingTransaction);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationTypePopup, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextbox, "Entering Authorization Type :", AuthorizationType);
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationtNoPopup, "Entering Authorization No :", AuthorizationNo);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationNoTextbox, "Entering Authorization No :", AuthorizationNo);
		}
		typeText(driver, test, AuthMana_Report_ReferanceNo, "Entering Referance No :", ReferanceNo);
		typeText(driver, test, AuthMana_Report_EntryNo, "Entering Entry No :", EntryNo);
		typeText(driver, test, AuthMana_Report_PartyName, "Entering Party Name :", PartyName);
		if(TravelerName.length() > 0) {
			clickElement(driver, test, AuthMana_Report_TravelerName, "Clicking on Traveler Name :");
			try {
				typeText(driver, test, AuthMana_Report_UserFirstNamePopup, "Entering Traveler Name :", TravelerName);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TravelerName+"')]", "Selecting Traveler Name :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_TravelerNameTextbox, "Entering Traveler Name :", TravelerName);
		}
		if(TransactionDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_TransactionDateFrom, "Clicking on Transaction Date From :");
			dateOfMonthName(driver, test, "Selecting Transaction Date From :", TransactionDateFrom);
		}
		if(TransactionDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_TransactionDateTo, "Clicking on Transaction Date To :");
			dateOfMonthName(driver, test, "Selecting Transaction Date To :", TransactionDateTo);
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateFrom, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateTo, "Clicking on Expiry Date To :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		typeText(driver, test, AuthMana_Report_CountryShippedFrom, "Entering Country Shipped From :", CountryShippedFrom);
		if(PortOfExport.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PortofExport, "Clicking on Port Of Export :");
			try {
				typeText(driver, test, AuthMana_Report_PortCode, "Entering Port Of Export :", PortOfExport);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PortOfExport+"')]", "Selecting Port Of Export :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_PortOfExportTextbox, "Entering Port Of Export :", PortOfExport);
		}
		typeText(driver, test, AuthMana_Report_CountryShippedTo, "Entering Country Shipped To :", CountryShippedTo);
		if(PortOfImport.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PortofImport, "Clicking on Port Of Import :");
			try {
				typeText(driver, test, AuthMana_Report_PortCode, "Entering Port Of Import :", PortOfImport);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PortOfImport+"')]", "Selecting Port Of Import :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_PortOfImportTextbox, "Entering Port Of Import :", PortOfImport);
		}
		if(PartNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PartNumber, "Clicking on Part No :");
			try {
				typeText(driver, test, AuthMana_Report_PartNoPopup, "Entering Part No :", PartNo);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PartNo+"')]", "Selecting Part No :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_PartNoTextbox, "Entering Part No :", PartNo);
		}
		typeText(driver, test, AuthMana_Report_SerialNo, "Entering Serial No :", SerialNo);
		if(ExportClassification.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExportClassification, "Clicking on Export Classification :");
			try {
				typeText(driver, test, AuthMana_Report_ECCNUSMLPopup, "Entering Export Classification :", ExportClassification);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportClassification+"')]", "Selecting Export Classification :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ExportClassificationTextbox, "Entering Export Classification :", ExportClassification);
		}
		if(ImportClassification.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ImportClassification, "Clicking on Import Classification :");
			try {
				typeText(driver, test, AuthMana_Report_HSNoPopup, "Entering Import Classification :", ImportClassification);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ImportClassification+"')]", "Selecting Import Classification :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ImportClassificationTextbox, "Entering Import Classification :", ImportClassification);
		}
		typeText(driver, test, AuthMana_Report_ExportShipmentNo, "Entering Export Shipment No :", ExportShipmentNo);
		selectByVisibleText(driver, test, AuthMana_Report_ExpiresIn, "Selecting Expires In :", ExpiresIn);
		selectByVisibleText(driver, test, AuthMana_Report_IncludeLicense, "Selecting Include License :", IncludeLicense);
		typeText(driver, test, AuthMana_Report_OrderNo, "Entering Order No :", OrderNo);
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_programCodePopup, "Entering Program :", Program);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextbox, "Entering Program :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_SegmentTextbox, "Entering Segment :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Site, "Clicking on Site :");
			try {
				typeText(driver, test, AuthMana_Report_SiteIDPopup, "Entering Site :", Site);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_SiteTextbox, "Entering Site :", Site);
		}
		if(Region.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Region, "Clicking on Region :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Region+"')]", "Selecting Region :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_RegionTextbox, "Entering Region :", Region);
		}
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_Direction, "Selecting Direction :", Direction);
	}
}