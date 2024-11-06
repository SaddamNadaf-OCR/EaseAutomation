package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchAuthorizationActivityPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//....................Locators for WebElement Present on Search Authorization Page...............//*
	
	public static final String Auth_Mana_Search="//button[@name='Search']";
	public static final String Auth_Mana_Reset="//button[@type='reset']";
	public static final String Auth_Mana_Add_Activity="//button[contains(text(),'Add Activity')]";
	public static final String Auth_Mana_AddFromExel="//button[contains(text(),'Add From Excel')]";
	public static final String Auth_Mana_Excel="//i[@title='common.download.samplexl']";
	public static final String Auth_Mana_AuthGrantedCountry="//select[@name='encryptedCountryCode']";
	public static final String Auth_Mana_SBUCODE="//select[@id='licenseTransaction.sbuCode']";
	public static final String Auth_Mana_CreatedBy="//a[contains(text(),'Created By')]";
	public static final String Auth_Mana_UserName="//input[@name='userProfile.username']";
	public static final String Auth_Mana_SearchPopUp="(//button[@name='Search'])[2]";
	public static final String Auth_Mana_selectPopUp="(//button[@name='Ok'])";
	public static final String Auth_Mana_CreatedByTextBox="//input[@name='licenseTransaction.createdBy']";
	public static final String Auth_Mana_ShipmentFlag="//select[@id='searchLicenseTransaction_licenseTransaction_shipmentType']";
	public static final String Auth_Mana_ShipmentFlag1="//select[@id='searchLicenseTransaction_licenseTransaction_shipmentSubType']";
	public static final String Auth_Mana_CountryOfAutho="//input[@name='authGrantCountryName']";
	public static final String Auth_Mana_ActivityType="//select[@name='activityType']";
	public static final String Auth_Mana_AuthType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String Auth_Mana_AuthTypePopUp="//textarea[@name='licenseTypes.licenseType']";
	public static final String Auth_Mana_AuthTypeTextBox="//textarea[@name='licenseTransaction.licenseType']";
	public static final String Auth_Mana_AuthorizationNo="//a[@id='authId']";
	public static final String Auth_Mana_AuthNoPopUp="//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String Auth_Mana_SelectpopUp="//button[@name='Ok']";
	public static final String Auth_Mana_AuthorizationNoTextBox="//input[@name='licenseTransaction.licenseNo']";
	public static final String Auth_Mana_RefNo="//input[@name='licenseTransaction.referenceNo']";
	public static final String Auth_Mana_AuthorizationLineItemNo="//input[@name='licenseTransaction.itemNo']";
	public static final String Auth_Mana_ActivityID="//input[@name='licenseTransaction.transactionId']";
	public static final String Auth_Mana_RequestNo="//input[@name='licenseTransaction.requestNo']";
	public static final String Auth_Mana_ExportShipmentNo="//a[contains(text(),' Export Shipment No')]";
	public static final String Auth_Mana_ExportShipNoPopup="//input[@name='shipmentDTO.shipmentNo']";
	public static final String Auth_Mana_ExportShipmentNoTextBox="//input[@name='licenseTransaction.exportShipmentNo']";
	public static final String Auth_Mana_CustomRefNo="//*[@id='searchLicenseTransaction_licenseTransaction_itnNo']";
	public static final String Auth_Mana_EntryNo="//*[@id='searchLicenseTransaction_licenseTransaction_entryNo']";
	public static final String Auth_Mana_Internal_Ref_No="//input[@id='searchLicenseTransaction_licenseTransaction_internalRefNo']";
	public static final String Auth_Mana_Party_Name="//input[@id='searchLicenseTransaction_licenseTransaction_partyName']";
	public static final String Auth_Mana_Traveler_Name="//a[contains(text(),'Traveler Name')]";
	public static final String Auth_Mana_UserFirstName="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_Traveler_NameTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_travelerName']";
	public static final String Auth_Mana_Transaction_Date="//input[@id='searchLicenseTransaction_transactionDate']";
	public static final String Auth_Mana_Transaction_DateTo="//input[@id='searchLicenseTransaction_transactionDateTo']";
	public static final String Auth_Mana_Transaction_Type="(//a[contains(text(),'Transaction Type')])[2]";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_Transaction_TypeTextbox="//input[@id='searchLicenseTransaction_licenseTransaction_transactionType']";
	public static final String Auth_Mana_CountryShippedFromCountryName="//input[@id='searchLicenseTransaction_licenseTransaction_countryNameFrom']";
	public static final String Auth_Mana_CountryShippedTo="//input[@name='licenseTransaction.countryName']";
	public static final String Auth_Mana_PortOfExport="//a[contains(text(),'Port of Export')]";
	public static final String AUth_Mana_PortID="//input[@name='ports.portId']";
	public static final String Auth_Mana_PortOfTransactionTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_portOfTransaction']";
	public static final String Auth_Mana_ShippedTo="//input[@id='searchLicenseTransaction_licenseTransaction_countryName']";
	public static final String Auth_Mana_PortOfImport="//a[contains(text(),'Port of Import')]";
	public static final String Auth_Mana_PortOfImportTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_portOfImport']";
	public static final String Auth_Mana_PartNumber="//a[contains(text(),'Part Number')]";
	public static final String Auth_Mana_PartNoPopup="//input[@name='product.productCode']";
	public static final String Auth_Mana_PartNumberTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_productCd']";
	public static final String Auth_Mana_SerialNumber="//input[@id='searchLicenseTransaction_licenseTransaction_serialNo']";
	public static final String Auth_Mana_ExportClassification="//a[contains(text(),'Export Classification')]";
	public static final String Auth_Mana_ECCN_USML="//input[@name='productClazz.prodClassification']";
	public static final String Auth_Mana_ExportClassificationTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_productClass']";
	public static final String Auth_Mana_ImportClassification="//a[contains(text(),'Import Classification')]";
	public static final String Auth_Mana_HSNo="//input[@name='hsNo']";
	public static final String Auth_Mana_SearchHSNo="//button[@id='searchHsDtlBtn']";
	public static final String Auth_Mana_SelectHSNo="//button[@id='slctBtn']";
	public static final String Auth_Mana_ImportClassifiactionTextbox="//input[@id='searchLicenseTransaction_licenseTransaction_importClassification']";
	public static final String Auth_Mana_OriginalRefNo="//a[contains(text(),'Original Reference No.')]";
	public static final String Auth_Mana_RefNoPopup="//input[@id='searchOrigReferenceNoPopup_licenseTransactionDTO_referenceNo']";
	public static final String Auth_Mana_OriginalRefNoTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_origReferenceNo']";
	public static final String Auth_Mana_OrderNo="//input[@id='searchLicenseTransaction_licenseTransaction_orderNo']";
	public static final String Auth_Mana_Program="(//a[contains(text(),'Program')])[3]";
	public static final String Auth_Mana_ProgramCode="//input[@id='searchForm_programTab_programCode']";
	public static final String Auth_Mana_ProgramTextBox="//textarea[@id='searchLicenseTransaction_licenseTransaction_programCode']";
	public static final String Auth_Mana_Segement="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_SegementTextBox="//textarea[@id='searchLicenseTransaction_licenseTransaction_segmentName']";
	public static final String Auth_Mana_Site="//a[contains(text(),'Site')]";
	public static final String Auth_Mana_SiteIDPopup="//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String Auth_Mana_SiteTextBox="//textarea[@id='searchLicenseTransaction_licenseTransaction_siteName']";
	public static final String Auth_Mana_Region="//a[contains(text(),'Region')]";
	public static final String Auth_Mana_RegionTextBox="//input[@id='searchLicenseTransaction_licenseTransaction_regionName']";
	public static final String Auth_Mana_Owner="(//a[contains(text(),'Owner')])[4]";
	public static final String Auth_Mana_OwnerFirstName="//input[@id='searchForm_dosLicenseOwnerPopupDTO_ownerFirstName']";
	public static final String Auth_Mana_OwnerTextBox="//input[@id='searchLicenseTransaction_licenseOwner']";
	public static final String Auth_Mana_StopTracking="//select[@id='searchLicenseTransaction_licenseTransaction_stopTracking']";
	public static final String Auth_Mana_SubComponenentLicences="//select[@id='searchLicenseTransaction_licenseTransaction_stopTracking']";
	public static final String Auth_Mana_SortBy="//select[@name='sortBy']";
	public static final String Auth_Mana_Direction="//select[@name='direction']";
	
	//...................................Constructor......................................//
	public SearchAuthorizationActivityPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//............................Click on Search Tab ...................................//
	public void Search(){
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab :");
	}
	
	//............................Click on Reset Tab ...................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "CLicking on Reset Tab :");
	}
	
	//...........................Click on Add Activity Button ..........................//
	public void addActivity() {
		clickElement(driver, test, Auth_Mana_Add_Activity, "Clicking on Add Activity Button :");
	}
	
	//..........................Click on Add From Excel Button .........................//
	public void addFromExcel() {
		clickElement(driver, test, Auth_Mana_AddFromExel, "Clicking on Add Excel Button :");
	}
	
	//...........................Click on Download Excel ...............................//
	public void downloadExcel() {
		clickElement(driver, test, Auth_Mana_Excel, "Click for Download Excel :");
	}
	
	//...........................Search By Parameters...................................//
	public void searchByParameters(String AuthGrantCountry,String SBUCode,String CreatedBy,String ShipmentType,String ShipmentSubType,
			String CountryOfAuth,String ActivityType,String AuthType,String AuthorizarationNo,String ReferanceNo,String AuthLineItemNo,
			String ActivityID,String RequestID,String ExportShipNo,String CustomRefNo,String EntryNo,String InternalRefNo,String PartyName,
			String TravelerName,String TransactionDateFrom,String TransactionDateTo,String TransactionType,String CountryShippedFrom,
			String PortOfExport,String CountryShippedTo,String PortOfImport,String PartNo,String SerialNo,String ExportClassification,
			String ImportClassification,String OriginalRefNo,String OrderNo,String Program,String Segment,String Site,String Region,
			String Owner,String StopTracking,String SubComponenetLicense,String SortBy,String Direction) {
		
		selectByVisibleText(driver, test, Auth_Mana_AuthGrantedCountry, "Selecting Auth.Granted Country :", AuthGrantCountry);
		selectByVisibleText(driver, test, Auth_Mana_SBUCODE, "Selecting SBU Code", SBUCode);
		if(CreatedBy.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedBy, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_UserName, "Entering User Name :", CreatedBy);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy+"')]", "Selecting Created by :");
				clickElement(driver, test, Auth_Mana_selectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_CreatedByTextBox, "entering Created By :", CreatedBy);
		}
		selectByVisibleText(driver, test, Auth_Mana_ShipmentFlag, "Selecting Shipment Type :", ShipmentType);
		selectByVisibleText(driver, test, Auth_Mana_ShipmentFlag1, "Selecting Shipment Sub Type :", ShipmentSubType);
		typeText(driver, test, Auth_Mana_CountryOfAutho, "Entering Country of Authorization :", CountryOfAuth);
		selectByVisibleText(driver, test, Auth_Mana_ActivityType, "Selecting Activity Type :", ActivityType);
		if(AuthType.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthType, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_AuthTypePopUp, "Entering User Name :", AuthType);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthType+"')]", "Selecting Created by :");
				clickElement(driver, test, Auth_Mana_selectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthTypeTextBox, "entering Created By :", AuthType);
		}
		if(AuthorizarationNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationNo, "Clicking on Authorization Number Link :");
			try {
				typeText(driver, test, Auth_Mana_AuthNoPopUp, "Entering Authrization No :", AuthorizarationNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ AuthorizarationNo +"')]", "Clicking on Authorization Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_AuthorizationNoTextBox, "Entering Authorization No :", AuthorizarationNo);
	    }
		typeText(driver, test, Auth_Mana_RefNo, "Entering Referance No :", ReferanceNo);
		typeText(driver, test, Auth_Mana_AuthorizationLineItemNo, "Entering Auth Line Item No :", AuthLineItemNo);
		typeText(driver, test, Auth_Mana_ActivityID, "Entering Activity ID :", ActivityID);
		typeText(driver, test, Auth_Mana_RequestNo, "Entering Request ID :", RequestID);
		scrollToBottom(driver);
		if(ExportShipNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExportShipmentNo, "Clicking on Export Shipment No :");
			try {
				typeText(driver, test, Auth_Mana_ExportShipNoPopup, "Entering Authrization No :", ExportShipNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ ExportShipNo +"')]", "Clicking on Authorization Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_ExportShipmentNoTextBox, "Entering Authorization No :", ExportShipNo);
	    }
		typeText(driver, test, Auth_Mana_CustomRefNo, "Entering Custom Referance No :", CustomRefNo);
		typeText(driver, test, Auth_Mana_EntryNo, "Entering Entry No :", EntryNo);
		typeText(driver, test, Auth_Mana_Internal_Ref_No, "Entering Internal Ref. No.:", InternalRefNo);
		typeText(driver, test, Auth_Mana_Party_Name, "Entering Party Name :", PartyName);
		if(TravelerName.length() > 0) {
			clickElement(driver, test, Auth_Mana_Traveler_Name, "Clicking on Traveler_Name :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstName, "Entering Traveler_Name :", TravelerName);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ TravelerName +"')]", "Clicking on Traveler Name :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_Traveler_NameTextBox, "Entering Traveler_Name :", TravelerName);
	    }
		if(TransactionDateFrom.length() > 0) {
		clickElement(driver, test, Auth_Mana_Transaction_Date, "Clicking on Transaction Date From :");
		dateOfMonthName(driver, test, "Selecting Transaction Date From :", TransactionDateFrom);
		}
		if(TransactionDateTo.length() > 0) {
		clickElement(driver, test, Auth_Mana_Transaction_DateTo, "Clicking on Transaction Date To :");
		dateOfMonthName(driver, test, "Selecting Transaction Date To :", TransactionDateTo);
		}
		if(TransactionType.length() > 0) {
			clickElement(driver, test, Auth_Mana_Transaction_Type, "Clicking on Transaction Type :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ TransactionType +"')]", "Clicking on Transaction Type :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, Auth_Mana_Transaction_TypeTextbox, "Entering Transaction Type :", TransactionType);
		}
		typeText(driver, test, Auth_Mana_CountryShippedFromCountryName, "Entering Country Shipped From :", CountryShippedFrom);
		if(PortOfExport.length() > 0) {
			clickElement(driver, test, Auth_Mana_PortOfExport, "Clicking on Port Of Export :");
			try {
				typeText(driver, test, AUth_Mana_PortID, "Entering port ID :", PortOfExport);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PortOfExport +"')]", "Clicking on Port ID Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_PortOfTransactionTextBox, "Entering Port Of Export Name :", PortOfExport);
	    }
		typeText(driver, test, Auth_Mana_ShippedTo, "Entering Country Shipped To :", CountryShippedTo);
		if(PortOfImport.length() > 0) {
			clickElement(driver, test, Auth_Mana_PortOfImport, "Clicking on Port Of Import :");
			try {
				typeText(driver, test, AUth_Mana_PortID, "Entering port ID :", PortOfImport);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PortOfImport +"')]", "Clicking on Port ID Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_PortOfImportTextBox, "Entering Port Of Export Name :", PortOfImport);
	    }
		if(PartNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_PartNumber, "Clicking on Part No :");
			try {
				typeText(driver, test, Auth_Mana_PartNoPopup, "Entering port ID :", PartNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartNo +"')]", "Clicking on Port ID Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_PartNumberTextBox, "Entering Part No :", PartNo);
	    }
		typeText(driver, test, Auth_Mana_SerialNumber, "Entering Serial No :", SerialNo);
		if(ExportClassification.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExportClassification, "Clicking on Part No :");
			try {
				typeText(driver, test, Auth_Mana_ECCN_USML, "Entering Export Classification :", ExportClassification);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ ExportClassification +"')]", "Clicking on Port ID Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_ExportClassificationTextBox, "Entering Export Classification :", ExportClassification);
	    }
		if(ImportClassification.length() > 0) {
			clickElement(driver, test, Auth_Mana_ImportClassification, "Clicking on Import Classification :");
			try {
				typeText(driver, test, Auth_Mana_HSNo, "Entering Import Classification :", ImportClassification);
				clickElement(driver, test, Auth_Mana_SearchHSNo, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ ImportClassification +"')]", "Clicking on Port ID Number :");
				clickElement(driver, test, Auth_Mana_SelectHSNo, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_ImportClassifiactionTextbox, "Entering Import Classification :", ImportClassification);
	    }
		if(OriginalRefNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_OriginalRefNo, "Clicking on Original Ref. No :");
			try {
				typeText(driver, test, Auth_Mana_RefNoPopup, "Entering port ID :", OriginalRefNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ OriginalRefNo +"')]", "Clicking on Port ID Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_OriginalRefNoTextBox, "Entering Original Ref. No :", OriginalRefNo);
	    }
		typeText(driver, test, Auth_Mana_OrderNo, "Entering Order No :", OrderNo);
		if(Program.length() > 0) {
			clickElement(driver, test, Auth_Mana_Program, "Clicking on Program :");
			try {
				typeText(driver, test, Auth_Mana_ProgramCode, "Entering Program :", Program);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Program +"')]", "Clicking Program Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_ProgramTextBox, "Entering Program :", Program);
	    }
		if(Segment.length() > 0) {
			clickElement(driver, test, Auth_Mana_Segement, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Segment +"')]", "Clicking Segment Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_SegementTextBox, "Entering Segment :", Segment);
	    }
		if(Site.length() > 0) {
			clickElement(driver, test, Auth_Mana_Site, "Clicking on Site :");
			try {
				typeText(driver, test, Auth_Mana_SiteIDPopup, "Entering Site :", Site);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Site +"')]", "Clicking Site Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_SiteTextBox, "Entering Site :", Site);
	    }
		if(Region.length() > 0) {
			clickElement(driver, test, Auth_Mana_Region, "Clicking on Region :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Region +"')]", "Clicking Region Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_RegionTextBox, "Entering Region :", Region);
	    }
		if(Owner.length() > 0) {
			clickElement(driver, test, Auth_Mana_Owner, "Clicking on Owner :");
			try {
				typeText(driver, test, Auth_Mana_OwnerFirstName, "Entering Owner :", Owner);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Owner +"')]", "Clicking Owner Number :");
				clickElement(driver, test, Auth_Mana_SelectpopUp, "Click on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
	    }else {
	    	typeText(driver, test, Auth_Mana_OwnerTextBox, "Entering Owner :", Owner);
	    }
		selectByVisibleText(driver, test, Auth_Mana_StopTracking, "Selecting Stop Tracking :", StopTracking);
		typeText(driver, test, Auth_Mana_SubComponenentLicences, "Entering Sub-Component Licences :", SubComponenetLicense);
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction :", Direction);
		scrollToTop(driver);
		scrollToElement(driver, Auth_Mana_Search);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, Auth_Mana_CountryOfAutho, "Getting Country First Value :");
		getSelectFirstText(driver, test, Auth_Mana_CountryShippedFromCountryName, "Getting Country Shipped From :");
		getSelectFirstText(driver, test, Auth_Mana_CountryShippedTo, "Getting Country Shipped To :");
	}
}
