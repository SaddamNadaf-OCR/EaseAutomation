package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchAuthorisationPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	//.................................Meta Data Search.................................//
	public static final String Auth_Mana_Search="//button[@name='Search.x']";
	public static final String Auth_Mana_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String Auth_Mana_AddAuthorization="//button[@id='mybutton']";
	public static final String Auth_Mana_AutoGenereatedByCountry="//select[@id='encryptedCountryCode']";
	public static final String Auth_Mana_SBU="//select[@id='licenseHeader.sbuCodetop']";
	public static final String Auth_Mana_AuthorizationNo="//a[contains(text(),'Authorization No.')]";
	public static final String Auth_Mana_AuthorizationNoPopUp="//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String Auth_Mana_SearchPopUp="//button[@id='searchAuth']";
	public static final String Auth_Mana_Select="//button[@name='Ok']";
	public static final String Auth_Mana_AuthorizationNo1="//input[@id='License_licenseHeader_licenseNo']";
	public static final String Auth_Mana_AuthorizationStatus="//select[@name='licenseStatus']";
	public static final String Auth_Mana_CaseNo="//input[@id='License_licenseHeader_caseNo']";
	public static final String Auth_Mana_ContactNumber="//input[@id='License_licenseHeader_contractNo']";
	public static final String Auth_Mana_RefNo="//input[@id='License_licenseHeader_referenceNo']";
	public static final String Auth_Mana_RequestID="//input[@id='License_licenseHeader_expReqId']";
	public static final String Auth_Mana_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String Auth_Mana_AuthorizationTypePopUp="//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String Auth_Mana_SearchPopup="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopup="//button[@name='Ok']";
	public static final String Auth_Mana_AuthorizationType1="//textarea[@id='License_licenseHeader_licenseType']";
	public static final String Auth_Mana_ActivityType="//select[@id='License_licenseHeader_activityType']";
	public static final String Auth_Mana_SITE="//a[contains(text(),'Site')]";
	public static final String Auth_Mana_SiteIDPopUp="//input[@name='dosSite.siteId']";
	public static final String Auth_Mana_SITE1="//textarea[@id='License_licenseHeader_site']";
	public static final String Auth_Mana_Auth_Will_Expire_Within="//input[@name='noofdays']";
	public static final String Auth_Mana_Commodity="//input[@id='License_hw']";
	public static final String Auth_Mana_Commodity1="//input[@id='License_td']";
	public static final String Auth_Mana_IssueDateFrom="//input[@id='License_fromIssueDate']";
	public static final String Auth_Mana_IssueDateTo="//input[@id='License_toIssueDate']";
	public static final String Auth_Mana_ExpirationDate="//input[@id='License_expireDate']";
	public static final String Auth_Mana_ExpirationDateto="//input[@id='License_toExpireDate']";
	public static final String Auth_Mana_FolderID="//a[contains(text(),'Folder ID')]";
	public static final String Auth_Mana_FolderIDPopup="//input[@id='searchForm_authorisationHeaderDTO_folderId']";
	public static final String Auth_Mana_SearchFolderId="//button[@name='Search']";
	public static final String Auth_Mana_SelectFolderId="//button[@name='Ok']";
	public static final String Auth_Mana_FolderID1="//input[@placeholder='Please select folder id...']";
	public static final String Auth_Mana_FolderID2="//div[@class='ms-trigger']";
	public static final String Auth_Mana_PartyName="//a[contains(text(),'Party Name')]";
	public static final String Auth_Mana_PartiesConsignee="(//input[@name='userDTO.sourceMfgType'])[1]";
	public static final String Auth_Mana_PartiesSellor="(//input[@name='userDTO.sourceMfgType'])[2]";
	public static final String Auth_Mana_PartiesSource="(//input[@name='userDTO.sourceMfgType'])[3]";
	public static final String Auth_Mana_PartiesManufacturer="(//input[@name='userDTO.sourceMfgType'])[4]";
	public static final String Auth_Mana_PartiesFraightForworder="(//input[@name='userDTO.sourceMfgType'])[5]";
	public static final String Auth_Mana_PartyCode="//input[@name='userDTO.userCode']";
	public static final String Auth_Mana_PartyName1="//input[@id='License_ultimateConsignee_licConsName']";
	public static final String Auth_Mana_Country="//input[@id='License_licenseCountry_countryDescription']";
	public static final String Auth_Mana_Agency="(//a[contains(text(),'Agency')])[2]";
	public static final String Auth_Mana_Agency1="//input[@id='License_licenseHeader_controllingAgency']";
	public static final String Auth_Mana_AuthorizationOwner="//a[contains(text(),'Authorization Owner')]";
	public static final String Auth_Mana_OwnerFirstName="//input[@name='dosLicenseOwnerPopupDTO.ownerFirstName']";
	public static final String Auth_Mana_AuthorizationOwner1="//input[@id='License_licenseHeader_licenseOwner']";
	public static final String Auth_Mana_TECC="//input[@id='License_licenseHeader_tecc']";
	public static final String Auth_Mana_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_Segment1="//textarea[@id='License_licenseHeader_segmentCode']";
	public static final String Auth_Mana_Originator="//input[@id='License_licenseHeader_originator']";
	public static final String Auth_Mana_CreatedBy="//select[@id='License_licenseHeader_createdBy']";
	public static final String Auth_Mana_SortBy="(//select[@name='sortBy'])[1]";
	public static final String Auth_Mana_Direction="(//select[@name='direction'])[1]";
	
	//................................Item Search ...............................................//
	public static final String Auth_Mana_Search1="//button[@id='item-submit']";
	public static final String Auth_Mana_Reset1="(//button[contains(text(),'Reset')])[2]";
	public static final String Auth_Mana_ItemNo="//input[@id='itemNo']";
	public static final String Auth_Mana_PartNo="//input[@id='productCd']";
	public static final String Auth_Mana_ExportClassification="//a[contains(text(),'Export Classification')]";
	public static final String Auth_Mana_ECCN_UCML="//input[@name='productClazz.prodClassification']";
	public static final String Auth_Mana_ExportClassification1="//input[@id='prodClassification']";
	public static final String Auth_Mana_Description="//input[@id='description']";
	public static final String Auth_Mana_Quantity="//input[@id='licenseQuantity']";
	public static final String Auth_Mana_Value="//input[@id='licenseValue']";
	public static final String Auth_Mana_AuthorizationQuantityUsed="//input[@id='transactionQuantity']";
	public static final String Auth_Mana_AuthorizationValueUsed="//input[@id='transactionValue']";
	public static final String Auth_Mana_SBUCODE="//select[@id='licenseHeader.sbuCodebottom']";
	public static final String Auth_Mana_CreatedBy1="//a[contains(text(),'Created By')]";
	public static final String Auth_Mana_SearchUser="//input[@name='userProfile.username']";
	public static final String Auth_Mana_CreatedBy2="//input[@id='createdBy']";
	public static final String Auth_Mana_SortBy1="(//select[@name='sortBy'])[2]";
	public static final String Auth_Mana_Direction1="(//select[@name='direction'])[2]";
	public static final String Auth_Mana_ClosePopup="//button[@class='btn-close']";
	
	//..................................Constructors..................................//
	public SearchAuthorisationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Click on Search Tab ..................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Reset Tab ..................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Clicking on Reset Tab");
	}
	
	//.............................Click on Add Authorization Tab ..................................//
	public void addAuthorization() {
		clickElement(driver, test, Auth_Mana_AddAuthorization, "Clicking on Add Authorization Tab");
	}
	
	//.............................Search By Authorization ...................................//
	public void searchByParameters(String AuthGrantedCountry,String sbuCode,String authorizationNo,String authorizationStatus,
			String caseNo,String ContactNumber,String refNo,String RequestID,String authorizationType,String ActivityType,
			String Site,String AuthExpiry,String Commodity,String IssueDateFrom,String IssueDateTo,String ExpirationDateFrom,
			String ExpirationDateTo,String folderID,String PartyName,String Parties,String Country,String Agency,String AuthOwner,
			String TECC,String Segment,String Originator,String CreatedBy,String SortBy,String Direction,String ItemNo,String PartNo,
			String ExportClassification,String Description,String Quantity,String Value,String AuthQunatityUsed,String AuthValueUsed,
			String SBUCODE,String CREATEDBY,String SortBy1,String Direction1) {
		
		selectByVisibleText(driver, test, Auth_Mana_AutoGenereatedByCountry, "Select Authorization Country :", AuthGrantedCountry);
		selectByVisibleText(driver, test, Auth_Mana_SBU, "Selecting SBU Code", sbuCode);
		if(authorizationNo.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationNo, "Clicking on Authorization No.");
			try {
				typeText(driver, test, Auth_Mana_AuthorizationNoPopUp, "Entering Data Into Authorization No", authorizationNo);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ authorizationNo+"')]", "Clicking on Authorization No."+ authorizationNo);
				clickElement(driver, test, Auth_Mana_Select, "Clicking on Select Tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationNo1, "Clicking on Authorization No.", authorizationNo);
		}
		selectByVisibleText(driver, test, Auth_Mana_AuthorizationStatus, "Selecting on Authorization Status", authorizationStatus);
		typeText(driver, test, Auth_Mana_CaseNo, "Entering Case No. :", caseNo);
		typeText(driver, test, Auth_Mana_ContactNumber, "Entering Contact Number :", ContactNumber);
		typeText(driver, test, Auth_Mana_RefNo, "Entering Ref. No. :", refNo);
		typeText(driver, test, Auth_Mana_RequestID, "Entering Request ID :", RequestID);
		if(authorizationType.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationType, "Clicking on Authorization Type HyperLink");
			try {
				typeText(driver, test, Auth_Mana_AuthorizationTypePopUp, "Entering Data Into Authorization Type", authorizationType);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ authorizationType+"')]", "Clicking on Authorization No."+ authorizationType);
				clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationType1, "Clicking on Authorization Type", authorizationType);
		}
		selectByVisibleText(driver, test, Auth_Mana_ActivityType, "Selecting Activity Type :", ActivityType);
		if(Site.length() > 0) {
			clickElement(driver, test, Auth_Mana_SITE, "Clicking on Folder ID HyperLink");
			try {
				typeText(driver, test, Auth_Mana_SiteIDPopUp, "Entering Data Into Site :", Site);
				clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Site+"')]", "Clicking on Site."+ Site);
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_SITE1, "Selecting Site :", Site);
		}
		typeText(driver, test, Auth_Mana_Auth_Will_Expire_Within, "Entering Auth Will Expiry :", AuthExpiry);
		if(Commodity.contains("HW")) {
			clickElement(driver, test, Auth_Mana_Commodity, "Clicking on HW :");
		}else if(Commodity.contains("TD")){
			clickElement(driver, test, Auth_Mana_Commodity1, "Clicking on TD :");
		}
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, Auth_Mana_IssueDateFrom, "Clicking on Issue Date :");
			dateOfMonthName(driver, test, "Selecting Issue Date :", IssueDateFrom);
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, Auth_Mana_IssueDateTo, "Clicking on Issue Date To :");
			dateOfMonthName(driver, test, "Selecting Issue Date To :", IssueDateTo);
		}
		if(ExpirationDateFrom.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExpirationDate, "Clicking on Expiration Date From :");
			dateOfMonthName(driver, test, "Selecting Expiration Date :", ExpirationDateFrom);
		}
		if(ExpirationDateTo.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExpirationDateto, "Clicking on Expiration Date To :");
			dateOfMonthName(driver, test, "Selecting Expiration Date To :", ExpirationDateTo);
		}
		scrollToBottom(driver);
		if(folderID.length() > 0) {
			clickElement(driver, test, Auth_Mana_FolderID, "Clicking on Folder ID HyperLink");
			try {
				typeText(driver, test, Auth_Mana_FolderIDPopup, "Entering Data Into Folder ID", folderID);
				clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ folderID+"')]", "Clicking on Folder ID."+ folderID);
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			selectByVisibleText(driver, test, Auth_Mana_FolderID2, "Selecting Folder Id ", folderID);
		}
		if(PartyName.length() > 0) {
			clickElement(driver, test, Auth_Mana_PartyName, "Clicking on Folder ID HyperLink");
			try {
				if(Parties.contains("Consignee")) {
					clickElement(driver, test, Auth_Mana_PartiesConsignee, "Clicking on Consignee :");
					typeText(driver, test, Auth_Mana_PartyCode, "Entering Party Code :", PartyName);
					clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartyName+"')]", "Clicking on Party Name :"+ PartyName);
					clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
				}
				if(Parties.contains("Seller")) {
					clickElement(driver, test, Auth_Mana_PartiesConsignee, "Clicking on Consignee :");
					typeText(driver, test, Auth_Mana_PartyCode, "Entering Party Code :", PartyName);
					clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartyName+"')]", "Clicking on Party Name :"+ PartyName);
					clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
				}else if(Parties.contains("Source")) {
					clickElement(driver, test, Auth_Mana_PartiesConsignee, "Clicking on Consignee :");
					typeText(driver, test, Auth_Mana_PartyCode, "Entering Party Code :", PartyName);
					clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartyName+"')]", "Clicking on Party Name :"+ PartyName);
					clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
				}else if(Parties.contains("Manufacturer")) {
					clickElement(driver, test, Auth_Mana_PartiesConsignee, "Clicking on Consignee :");
					typeText(driver, test, Auth_Mana_PartyCode, "Entering Party Code :", PartyName);
					clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartyName+"')]", "Clicking on Party Name :"+ PartyName);
					clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
				}else if(Parties.contains("Freight Forwarder")) {
					clickElement(driver, test, Auth_Mana_PartiesConsignee, "Clicking on Consignee :");
					typeText(driver, test, Auth_Mana_PartyCode, "Entering Party Code :", PartyName);
					clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartyName+"')]", "Clicking on Party Name :"+ PartyName);
					clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, Auth_Mana_PartyName1, "Selecting Party Name :", PartyName);
		}
		typeText(driver, test, Auth_Mana_Country, "Entering Country :", Country);
		if(Agency.length() > 0) {
			clickElement(driver, test, Auth_Mana_Agency, "Clicking on Agency :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Agency+"')]", "Clicking on Agency");
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_Agency1, "Entering Agency :", Agency);
		}
		if(AuthOwner.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationOwner, "Clicking on Auth. Owner :");
			try {
				typeText(driver, test, Auth_Mana_OwnerFirstName, "Entering Owner First Name :", AuthOwner);
				clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "(//td[contains(text(),'"+AuthOwner+"')])[1]", "Selecting Owner First Name");
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizationOwner1, "Entering Authorization Owner", AuthOwner);
		}
		typeText(driver, test, Auth_Mana_TECC, "Entering TECC", TECC);
		if(Segment.length() > 0) {
			clickElement(driver, test, Auth_Mana_Agency, "Clicking on Agency :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Clicking on Agency");
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_Agency1, "Entering Agency :", Segment);
		}
		typeText(driver, test, Auth_Mana_Originator, "Entering Originator :", Originator);
		selectByVisibleText(driver, test, Auth_Mana_CreatedBy, "Selecting Created by :", CreatedBy);
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction :", Direction);
		
		//..................................Item Search ..................................//
		typeText(driver, test, Auth_Mana_ItemNo, "Entering Item No :", ItemNo);
		typeText(driver, test, Auth_Mana_PartNo, "Entering Part no :", PartNo);
		if(ExportClassification.length() > 0) {
			clickElement(driver, test, Auth_Mana_ExportClassification, "Clicking on Export Classification");
			try {
				typeText(driver, test, Auth_Mana_ECCN_UCML, "Entering ECCN/UCNL :", ExportClassification);
				clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportClassification+"')]", "Selecting Export Classification");
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_ExportClassification1, "Entering Export Classification", ExportClassification);
		}
		scrollToBottom(driver);
		typeText(driver, test, Auth_Mana_Description, "Entering Description :", Description);
		typeText(driver, test, Auth_Mana_Quantity, "Entering Quantity :", Quantity);
		typeText(driver, test, Auth_Mana_Value, "Entering Value :", Value);
		typeText(driver, test, Auth_Mana_AuthorizationQuantityUsed, "Entering Auth. Quantity Used", AuthQunatityUsed);
		typeText(driver, test, Auth_Mana_AuthorizationValueUsed, "Entering Auth. Quantity Used", AuthValueUsed);
		selectByVisibleText(driver, test, Auth_Mana_SBUCODE, "Selecting SBU CODE :", SBUCODE);
		if(CREATEDBY.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedBy1, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_SearchUser, "Entering CREATED BY :", CREATEDBY);
				clickElement(driver, test, Auth_Mana_SearchFolderId, "Clicking on Search Tab");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CREATEDBY+"')]", "Selecting CREATEDBY");
				clickElement(driver, test, Auth_Mana_SelectFolderId, "Clicking on Select Tab");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, Auth_Mana_ExportClassification1, "Entering CREATED BY", CREATEDBY);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy1, "Selecting Sort By :", SortBy1);
		selectByVisibleText(driver, test, Auth_Mana_Direction1, "Selecting Direction :", Direction1);
		scrollToElement(driver, Auth_Mana_Search);
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		String Country=getSelectFirstText(driver, test, Auth_Mana_Country, "Getting Country First Value :");
		System.out.println(Country);
	}
}
