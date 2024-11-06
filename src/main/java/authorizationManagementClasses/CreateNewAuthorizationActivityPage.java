package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewAuthorizationActivityPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Save="//button[@id='savex']";
	public static final String Auth_Mana_SaveandReturn="//button[@id='okx']";
	public static final String Auth_Mana_Cancel="//button[contains(text(),'Cancel')]";
	
	//.............................Authorization Details ..................................//
	public static final String Auth_Mana_Activitytype="//select[@id='activityDropId']";
	public static final String Auth_Mana_AuthorTypePopup="//a[@id='authorTypePopup']";
	public static final String Auth_Mana_AuthorizationTypePopUp="//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String Auth_Mana_SearchPopUp="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_ClosePopup="(//button[@class='btn-close'])[1]";
	public static final String Auth_Mana_authorizationId="//a[@id='authorizationId']";
	public static final String Auth_Mana_AuthorizationNo="//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String Auth_Mana_SearchPopAuth="//button[@id='searchAuth']";
	public static final String Auth_Mana_SelectPopAuth="//button[@name='Ok']";
	public static final String Auth_Mana_AuthorizationLineItemNo="//a[contains(text(),'Authorization Line Item No.')]";
	public static final String Auth_Mana_RequestID="//input[@id='editLicenseTransaction_licenseTransaction_requestNo']";
	
	//.................................Shipment Details.......................................//
	public static final String Auth_Mana_ShipmentFLAG="//select[@id='editLicenseTransaction_licenseTransaction_shipmentType']";
	public static final String Auth_Mana_TransactionDate="//input[@name='transactionDate']";
	public static final String Auth_Mana_referenceNo="//input[@id='editLicenseTransaction_licenseTransaction_referenceNo']";
	public static final String Auth_Mana_referenceItemNo="//input[@id='editLicenseTransaction_licenseTransaction_referenceItemNo']";
	public static final String Auth_Mana_entryNo="//input[@id='editLicenseTransaction_licenseTransaction_entryNo']";
	public static final String Auth_Mana_exportShipmentNo="//input[@id='editLicenseTransaction_licenseTransaction_exportShipmentNo']";
	public static final String Auth_Mana_internalRefNo="//input[@id='editLicenseTransaction_licenseTransaction_internalRefNo']";
	public static final String Auth_Mana_CustomsReferenceNo="//input[@id='editLicenseTransaction_licenseTransaction_itnNo']";
	public static final String Auth_Mana_CountryShippedFrom="//input[@id='editLicenseTransaction_licenseTransaction_countryNameFrom']";
	public static final String Auth_Mana_CountryShippedTo="//input[@id='editLicenseTransaction_licenseTransaction_countryName']";
	public static final String Auth_Mana_PortOfExport="//input[@id='editLicenseTransaction_licenseTransaction_portOfTransaction']";
	public static final String Auth_Mana_PortOfImport="//input[@id='editLicenseTransaction_licenseTransaction_portOfImport']";
	public static final String Auth_Mana_PartyName="//input[@id='editLicenseTransaction_licenseTransaction_partyName']";
	public static final String Auth_Mana_TravelerName="//input[@id='editLicenseTransaction_licenseTransaction_travelerName']";
	public static final String Auth_Mana_PartyType="//select[@id='partyType']";
	
	//.......................................Item Details ..........................................//
	public static final String Auth_Mana_PartNo="//a[contains(text(),'Part Number')]";
	public static final String Auth_Mana_PartNoPopUp="//input[@name='product.productCode']";
	public static final String Auth_Mana_SearchButton="//button[@name='Search']";
	public static final String Auth_Mana_PartNoTextBox="//input[@name='licenseTransaction.productCd']";
	public static final String Auth_Mana_orderNo="//input[@name='licenseTransaction.orderNo']";
	public static final String Auth_Mana_orderItemNo="//input[@name='licenseTransaction.orderItemNo']";
	public static final String Auth_Mana_ExportClassification="(//a[contains(text(),'Export Classification')])[1]";
	public static final String Auth_Mana_ECCNUSMLNo="//input[@name='productClazz.prodClassification']";
	public static final String Auth_Mana_ExportClassificationTextBox="//input[@name='licenseTransaction.productClass']";
	public static final String Auth_Mana_ImportClassification="(//a[contains(text(),'Import Classification')])[1]";
	public static final String Auth_Mana_HSNo="//input[@name='hsNo']";
	public static final String Auth_Mana_importClassificationTextBox="//input[@name='licenseTransaction.importClassification']";
	public static final String Auth_Mana_Value="//input[@name='value']";
	public static final String Auth_Mana_Quantity="//input[@name='licenseTransaction.quantity']";
	public static final String Auth_Mana_salesOrderNo="//input[@name='licenseTransaction.salesOrderNo']";
	public static final String Auth_Mana_salesOrderLineItem="//input[@name='licenseTransaction.salesOrderLineItem']";
	public static final String Auth_Mana_serialNo="//textarea[@name='licenseTransaction.serialNo']";
	public static final String Auth_Mana_subCompLicenses="//textarea[@name='licenseTransaction.subCompLicenses']";
	public static final String Auth_Mana_remarks="//textarea[@name='licenseTransaction.remarks']";
	
	//....................................Original Shipment Details ...................................//
	public static final String Auth_Mana_OriginalReferenceNo="//a[@id='origRefNoId']";
	public static final String Auth_Mana_RefNoPopup="//input[@name='licenseTransactionDTO.referenceNo']";
	public static final String Auth_Mana_OriginalReferenceItemNo="//a[contains(text(),'Original Reference Item No.')]";
	
	//.....................................Miscellaneous Details.......................................//
	public static final String Auth_Mana_Programme="(//a[contains(text(),'Programme')])[2]";
	public static final String Auth_Mana_programCode="//input[@name='programTab.programCode']";
	public static final String Auth_Mana_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_Site="//a[contains(text(),'Site')]";
	public static final String Auth_Mana_SiteId="//input[@name='dosSite.siteId']";
	public static final String Auth_Mana_Region="//a[contains(text(),'Region')]";
	public static final String Auth_Mana_UserField1="//input[@name='licenseTransaction.userField1']";
	public static final String Auth_Mana_UserField2="//input[@name='licenseTransaction.userField2']";
	public static final String Auth_Mana_UserField3="//input[@name='licenseTransaction.userField3']";
	public static final String Auth_Mana_UserField4="//input[@name='licenseTransaction.userField4']";
	public static final String Auth_Mana_SourceSystemId="//input[@name='licenseTransaction.sourceSystemId']";
	
	//...................................Constructor......................................//
	public CreateNewAuthorizationActivityPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//............................Click on Save Button ............................//
	public void save() {
		scrollToTop(driver);
		clickElement(driver, test, Auth_Mana_Save, "Clicking on Save Button :");
	}
	
	//.......................Click on Save and Return Button ............................//
	public void saveandReturn() {
		clickElement(driver, test, Auth_Mana_SaveandReturn, "Clicking on Save and Return Button :");
	}
	
	//.......................Click on Cancel Button ............................//
	public void cancel() {
		clickElement(driver, test, Auth_Mana_Cancel, "Clicking on Cancel Button :");
	}
	
	//..........................Add Authorization Details .................................//
	public void authorizationDetails(String activityType,String authorizationType,String AuthorizationNo,String itemNo,String requestID) {
		
		selectByVisibleText(driver, test, Auth_Mana_Activitytype, "Selecting Activity Type :", activityType);
		if(authorizationType.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorTypePopup, "Clicking on Authorization PopUp :");
			try {
				typeText(driver, test, Auth_Mana_AuthorizationTypePopUp, "Entering Authorization Type :", authorizationType);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ authorizationType +"')]", "Selecting Code :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_authorizationId, "Clicking on Authorization No :");
			try {
				typeText(driver, test, Auth_Mana_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
				clickElement(driver, test, Auth_Mana_SearchPopAuth, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ AuthorizationNo +"')]", "Selecting Authorization No :");
				clickElement(driver, test, Auth_Mana_SelectPopAuth, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
		}
		if(itemNo.length() > 0) {
		clickElement(driver, test, Auth_Mana_AuthorizationLineItemNo, "Clicking on Authorization No :");
		try {
			Wait.waitfor(3);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+ itemNo +"')]", "Selecting item No :");
			clickElement(driver, test, Auth_Mana_SelectPopAuth, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			e.printStackTrace();
		}
	}
		typeText(driver, test, Auth_Mana_RequestID, "Entering Request ID :", requestID);
	}
	
	
	//..............................ADD Shipment Details .....................................//
	public void ShipmentDetails(String shipmentFlag,String transactiondate,String referenceNo,String referenceItemNo,String entryNo,
			String exportShipmentNo,String internalRefNo,String CustomsReferenceNo,String CountryShippedFrom,String CountryShippedTo,
			String PortOfExport,String PortOfImport,String PartyName,String TravelerName,String PartyType) {
		
		selectByVisibleText(driver, test, Auth_Mana_ShipmentFLAG, "Selecting Shipment Flag :", shipmentFlag);
		if(transactiondate.length() > 0) {
			clickElement(driver, test, Auth_Mana_TransactionDate, "Clicking on Transaction Date :");
			dateOfMonthName(driver, test, "Selecting Transaction Date :", transactiondate);
		}
		typeText(driver, test, Auth_Mana_referenceNo, "Entering Reference No :", referenceNo);
		typeText(driver, test, Auth_Mana_referenceItemNo, "Entering Reference Item No :", referenceItemNo);
		typeText(driver, test, Auth_Mana_entryNo, "Entering Entry No :", entryNo);
		typeText(driver, test, Auth_Mana_exportShipmentNo, "Entering Export Shipment No", exportShipmentNo);
		typeText(driver, test, Auth_Mana_internalRefNo, "Entering Internal Ref No :", internalRefNo);
		typeText(driver, test, Auth_Mana_CustomsReferenceNo, "Entering Customs Reference No :", CustomsReferenceNo);
		clearText(driver, test, Auth_Mana_CountryShippedFrom, "Clearing the text :");
		typeText(driver, test, Auth_Mana_CountryShippedFrom, "Entering Country Shipped From :", CountryShippedFrom);
		typeText(driver, test, Auth_Mana_CountryShippedTo, "Entering Country Shipped To :", CountryShippedTo);
		typeText(driver, test, Auth_Mana_PortOfExport, "Entering Port Of Export :", PortOfExport);
		typeText(driver, test, Auth_Mana_PortOfImport, "Entering Port Of Import :", PortOfImport);
		typeText(driver, test, Auth_Mana_PartyName, "Entering Party Name :", PartyName);
		typeText(driver, test, Auth_Mana_TravelerName, "Entering Traveler Name :", TravelerName);
		selectByVisibleText(driver, test, Auth_Mana_PartyType, "Selecting Party Type :", PartyType);
	}
	
	//...................................Item Details .................................//
	public void itemDetails(String OrderNo,String OrderItemNo, String ImportClassification,String Value, 
			String Quentity, String SalesOrderNO, String SalesOrderLineItem,String SerialNo, String SubCompLicenses, String Remarks) {
		
		scrollToBottom(driver);
		typeText(driver, test, Auth_Mana_orderNo, "Entering Order No :", OrderNo);
		typeText(driver, test, Auth_Mana_orderItemNo, "Entering Order Item No :", OrderItemNo);
		if(ImportClassification.length() > 0) {
			clickElement(driver, test, Auth_Mana_ImportClassification, "Clicking on Import Classification :");
			try {
				typeText(driver, test, Auth_Mana_HSNo, "Entering Import Classification No :", ImportClassification);
				clickElement(driver, test, "//button[@id='searchHsDtlBtn']", "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//div[contains(text(),'"+ImportClassification+"')]", "Selecting Import Classification No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_importClassificationTextBox, "Entering Import Classification No in TextBox :", ImportClassification);
		}
		typeText(driver, test, Auth_Mana_Value, "Entering Total Item Value :", Value);
		typeText(driver, test, Auth_Mana_Quantity, "Entering Quentity :", Quentity);
		Wait.waitfor(2);
		typeText(driver, test, Auth_Mana_salesOrderNo, "Entering Sales Order No :", SalesOrderNO);
		typeText(driver, test, Auth_Mana_salesOrderLineItem, "Entering Sales Order Line Item :", SalesOrderLineItem);
		Wait.waitfor(2);
		typeText(driver, test, Auth_Mana_serialNo, "Entering Serial No :", SerialNo);
		typeText(driver, test, Auth_Mana_subCompLicenses, "Entering Sub Comp Licenses :", SubCompLicenses);
		Wait.waitfor(2);
		typeText(driver, test, Auth_Mana_remarks, "Entering Remarks :", Remarks);
		
		scrollToTop(driver);
		scrollToElement(driver, Auth_Mana_Save);
	}
	
	//.................................Original Shipment Details......................................//
	public void originalShipmentDetails(String ReferanceNo, String ReferanceItemNo) {
		if(ReferanceNo.length() > 0) {
		clickElement(driver, test, Auth_Mana_OriginalReferenceNo, "Clicking on Original Referance No :");
			try {
				typeText(driver, test, Auth_Mana_RefNoPopup, "Entering Referance No :", ReferanceNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ReferanceNo+"')]", "Selecting Referance No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Button :");
			}
		}
		if(ReferanceItemNo.length() > 0) {
		clickElement(driver, test, Auth_Mana_OriginalReferenceItemNo, "Clicking on Original Referance Item No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ReferanceItemNo+"')]", "Selecting Referance No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Button :");
			}
		}
	}
	
	//...................................Miscellaneous Details..........................................//
	public void miscellaneousDetails(String Programme, String Segment, String Site, String Region, String UserField1, String UserField2, String UserField3, String UserField4, String SourceSystemID) {
		if(Programme.length() > 0) {
			clickElement(driver, test, Auth_Mana_Programme, "Clicking on Programme No :");
			try {
				typeText(driver, test, Auth_Mana_programCode, "Entering Programme No :", Programme);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Programme+"')]", "Selecting Programme No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Button :");
			}
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, Auth_Mana_Segment, "Clicking on Segment No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Button :");
			}
		}
		if(Site.length() > 0) {
			clickElement(driver, test, Auth_Mana_Site, "Clicking on Site No :");
			try {
				typeText(driver, test, Auth_Mana_SiteId, "Entering Site No :", Site);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Button :");
			}
		}
		if(Region.length() > 0) {
			clickElement(driver, test, Auth_Mana_Region, "Clicking on Region No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Region+"')]", "Selecting Region No :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Button :");
			}
		}
		typeText(driver, test, Auth_Mana_UserField1, "Entering User Field 1 :", UserField1);
		typeText(driver, test, Auth_Mana_UserField2, "Entering User Field 2 :", UserField2);
		typeText(driver, test, Auth_Mana_UserField3, "Entering User Field 3 :", UserField3);
		typeText(driver, test, Auth_Mana_UserField4, "Entering User Field 4 :", UserField4);
		typeText(driver, test, Auth_Mana_SourceSystemId, "Entering Source System ID :", SourceSystemID);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, Auth_Mana_CountryShippedFrom, "Getting Country First Value :");
		getSelectFirstText(driver, test, Auth_Mana_CountryShippedTo, "Getting Country Shipped To :");
	}
}
