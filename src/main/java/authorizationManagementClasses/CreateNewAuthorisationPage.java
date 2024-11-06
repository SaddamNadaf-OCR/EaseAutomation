package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewAuthorisationPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Save="//button[@name='Save']";
	public static final String Auth_Mana_Cancel="//button[@name='Cancel.x']";
	public static final String Auth_Mana_AuthorizationTypeHyperLink="//a[@id='licenseType']";
	public static final String Autn_Mana_AuthorizationTypePopup="//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String Auth_Mana_SearchPopUp="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_AuthorizationType="//textarea[@id='editLicenseUS_licenseHeader_licenseType']";
	public static final String Auth_Mana_ActivityType="//select[@name='licenseHeader.activityType']";
	public static final String Auth_Mana_RequestID="//input[@name='licenseHeader.expReqId']";
	public static final String Auth_Mana_ReferenceID="//input[@name='licenseHeader.referenceNo']";
	public static final String Auth_Mana_Status="//select[@name='licenseStatus']";
	public static final String Auth_Mana_AuthorizationPurposeHyperLink="(//a[contains(text(),'Authorization Purpose')])[2]";
	public static final String Auth_Mana_PurposeID="//input[@name='dosLicensePurposeValue.purposeId']";
	public static final String Auth_Mana_PurposeIdPopup="//input[@name='dosLicensePurposeValue.purposeId']";
	public static final String Auth_Mana_SearchButtonPopup="//button[@name='Search']";
	public static final String Auth_Mana_SelectButtonPopup="//button[@name='Ok']";
	public static final String Auth_Mana_AuthorisationPurpose="//input[@name='licenseHeader.authorisationPurpose']";
	public static final String Auth_Mana_FolderIDPopup="//a[contains(text(),'Folder ID')]";
	public static final String Auth_Mana_FolderIdTextPopup="//input[@name='authorisationHeaderDTO.folderId']";
	public static final String Auth_Mana_FolderId="//input[@class='ocr-cache-search-dynamic-class']";
	public static final String Auth_Mana_Summary="//textarea[@id='editLicenseUS_licenseHeader_licenseSummary']";
	public static final String Auth_Mana_Programme="(//a[contains(text(),'Program')])[3]";
	public static final String Auth_Mana_ProgramCode="//input[@name='programTab.programCode']";
	public static final String Auth_Mana_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_SegmenttextBox="//textarea[@id='editLicenseUS_licenseHeader_segmentCode']";
	public static final String Auth_Mana_SitePopup="//a[contains(text(),'Site')]";
	public static final String Auth_Mana_SiteID="//input[@name='dosSite.siteId']";
	public static final String Auth_Mana_Site="//textarea[@id='editLicenseUS_licenseHeader_site']";
	public static final String Auth_Mana_Country="//input[@id='editLicenseUS_licenseCountry_countryDescription']";
	public static final String Auth_Mana_salesOrderNo="//input[@id='editLicenseUS_licenseHeader_salesOrderNo']";
	public static final String Auth_Mana_contractNo="//input[@id='editLicenseUS_licenseHeader_contractNo']";
	public static final String Auth_Mana_requestorName="//input[@id='editLicenseUS_licenseHeader_requestorName']";
	public static final String Auth_Mana_OwnerNamePopUp="//a[contains(text(),'Owner Name')]";
	public static final String Auth_Mana_UserFirstName="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_ownerName="//input[@id='editLicenseUS_licenseHeader_ownerName']";
	public static final String Auth_Mana_requestorEmail="//input[@id='editLicenseUS_licenseHeader_requestorEmail']";
	public static final String Auth_Mana_ownerEmail="//input[@id='editLicenseUS_licenseHeader_ownerEmail']";
	public static final String Auth_Mana_requestorPhone="//input[@id='editLicenseUS_licenseHeader_requestorPhone']";
	public static final String Auth_Mana_ownerPhone="//input[@id='editLicenseUS_licenseHeader_ownerPhone']";
	public static final String Auth_Mana_Agency="//input[@id='editLicenseUS_licenseHeader_controllingAgency']";
	public static final String Auth_Mana_dateInitiated="//input[@name='dateInitiated']";
	public static final String Auth_Mana_signatureDate="//input[@id='editLicenseUS_signatureDate']";
	public static final String Auth_Mana_submitDate="//input[@id='editLicenseUS_submitDate']";
	public static final String Auth_Mana_caseNo="//input[@id='editLicenseUS_licenseHeader_caseNo']";
	public static final String Auth_Mana_AuthorizationNoPopup="//a[contains(text(),'Authorization No.')]";
	public static final String Auth_Mana_Template="//input[@name='uniqueId.templateName']";
	public static final String Auth_Mana_licenseNo="//input[@id='editLicenseUS_licenseHeader_licenseNo']";
	public static final String Auth_Mana_relatedAuthorisation="//input[@id='editLicenseUS_licenseHeader_relatedAuthorisation']";
	public static final String Auth_Mana_issueDate="//input[@id='editLicenseUS_issueDate']";
	public static final String Auth_Mana_expireDate="//input[@id='editLicenseUS_expireDate']";
	public static final String Auth_Mana_closeOutDate="//input[@id='editLicenseUS_closeOutDate']";
	public static final String Auth_Mana_ClosePopup="//button[@class='btn-close']";
	public static final String Auth_Mana_AuthorizationDetails="//button[@id='myApplbutton1']";
	
	//..................................Constructors..................................//
	public CreateNewAuthorisationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.................................Header Details .................................//
	public void headerDetails(String ActivityType,String RequestID,String ReferenceID,String Status,String AuthorisationPurpose,
			String FolderId,String Summary,String Programme,String Segment,String Site,String Country,String SalesOrderNo,String ContractNo,
			String RequestorName,String OwnerName,String RequestorEmail,String OwnerEmail,String RequestorPhone,String OwnerPhone) {
		
		 selectByVisibleText(driver, test, Auth_Mana_ActivityType, "Selecting Activity type", ActivityType);
		 Wait.waitfor(2);
		 typeText(driver, test, Auth_Mana_RequestID, "Entering Request ID :", RequestID);
		 Wait.waitfor(2);
		 typeText(driver, test, Auth_Mana_ReferenceID, "Entering the ReferenceID : ", ReferenceID+randomnumbers());
		 Wait.waitfor(2);
		 selectByVisibleText(driver, test, Auth_Mana_Status, "Selecting Status :", Status);
		 Wait.waitfor(2);
		 if(AuthorisationPurpose.length() > 0) {
			 clickElement(driver, test, Auth_Mana_AuthorizationPurposeHyperLink, "Entering Authorisation Purpose :"+AuthorisationPurpose);
			 try {
				 typeText(driver, test, Auth_Mana_PurposeID, "Entering Authorization Purpose :", AuthorisationPurpose);
				 clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				 mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorisationPurpose+"')]", "Selecting Authorisation Purpose Code :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }else {
			 typeText(driver, test, Auth_Mana_AuthorisationPurpose, "Entering Authorisation Purpose :", AuthorisationPurpose);
		 }
		 if(FolderId.length() > 0) {
			 clickElement(driver, test, Auth_Mana_FolderIDPopup, "Clicking on Folder Id :"+FolderId);
			 try {
				 typeText(driver, test, Auth_Mana_FolderIdTextPopup, "Entering Folder Id Code :", FolderId);
				 clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				 mouseOverAndClick(driver, test, "//td[contains(text(),'"+FolderId+"')]", "Selecting Folder Id :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }else {
			 typeText(driver, test, Auth_Mana_FolderId, "Entering Folder Id :", FolderId);
		 }
		 typeText(driver, test, Auth_Mana_Summary, "Entering Summary :", Summary);
		 if(Programme.length() > 0) {
			 clickElement(driver, test, Auth_Mana_Programme, "Entering Programme :"+Programme);
			 try {
				 typeText(driver, test, Auth_Mana_ProgramCode, "Entering Programe Code :", Programme);
				 clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				 mouseOverAndClick(driver, test, "//td[contains(text(),'"+Programme+"')]", "Selecting Program Code :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }
		 if(Segment.length() > 0) {
			 clickElement(driver, test, Auth_Mana_Segment, "Entering Segment :"+Segment);
			 try {
				 mouseOverAndClick(driver, test, "//tbody/tr[@id='1']/td[3]", "Selecting Segment Code :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }else {
			 typeText(driver, test, Auth_Mana_SegmenttextBox, "Entering Segment :", Segment);
		 }
		 if(Site.length() > 0) {
			 clickElement(driver, test, Auth_Mana_SitePopup, "Clicking on Site Id :"+Site);
			 try {
				 typeText(driver, test, Auth_Mana_SiteID, "Entering Site Id Code :", Site);
				 clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				 mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site Id :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }else {
			 typeText(driver, test, Auth_Mana_Site, "Entering Site :", Site);
		 }
		 typeText(driver, test, Auth_Mana_Country, "Entering Country :", Country);
		 typeText(driver, test, Auth_Mana_salesOrderNo, "Entering Sales Order No :", SalesOrderNo+randomnumbers());
		 typeText(driver, test, Auth_Mana_contractNo, "Entering Contact No :", ContractNo);
		 typeText(driver, test, Auth_Mana_requestorName, "Entering Requiestor Name :", RequestorName);
		 if(OwnerName.length() > 0) {
			 clickElement(driver, test, Auth_Mana_OwnerNamePopUp, "Clicking on Owner Name :"+OwnerName);
			 try {
				 typeText(driver, test, Auth_Mana_UserFirstName, "Entering Owner Name :", OwnerName);
				 clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				 mouseOverAndClick(driver, test, "(//td[contains(text(),'"+OwnerName+"')])[1]", "Selecting Owner Name :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }else {
			 typeText(driver, test, Auth_Mana_ownerName, "Entering Owner Name :", OwnerName);
		 }
		 typeText(driver, test, Auth_Mana_requestorEmail, "Entering Requestor Email :", RequestorEmail);
		 typeText(driver, test, Auth_Mana_ownerEmail, "Entering Owner Email :", OwnerEmail);
		 typeText(driver, test, Auth_Mana_requestorPhone, "Entering Requestor Phone :", RequestorPhone);
		 typeText(driver, test, Auth_Mana_ownerPhone, "Entering Owner Phone :", OwnerPhone);
		 scrollToBottom(driver);
	}
	
	//.....................................Agency Authorization .....................................//
	public void agencyAuthorization(String Agency,String dateinitiated,String Signaturedate,String Submitdate,String CaseNo,String LicenseNo,
			String RelatedAuth,String Issuedate,String Expirydate,String Closuredate) {
		
		typeText(driver, test, Auth_Mana_Agency, "Entering Agency :", Agency);
		if(dateinitiated.length() > 0) {
			clickElement(driver, test, Auth_Mana_dateInitiated, "Clicking on Date Initiated :");
			dateOfMonthName(driver, test, "Selecting Date :", dateinitiated);
		}
		if(Signaturedate.length() > 0) {
			clickElement(driver, test, Auth_Mana_signatureDate, "Clicking on Signature Date :");
			dateOfMonthName(driver, test, "Selecting Signature Date :", Signaturedate);
		}
		if(Submitdate.length() > 0) {
			clickElement(driver, test, Auth_Mana_submitDate, "Clicking on Application Submitted Date :");
			dateOfMonthName(driver, test, "Selecting Date :", Submitdate);
		}
		scrollToBottom(driver);
		typeText(driver, test, Auth_Mana_caseNo, "Entering Case No :", CaseNo);
		if(LicenseNo.length() > 0) {
			 clickElement(driver, test, Auth_Mana_AuthorizationNoPopup, "Entering License No :"+LicenseNo);
			 try {
				 typeText(driver, test, Auth_Mana_Template, "Entering License No Code :", LicenseNo);
				 clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				 mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicenseNo+"')]", "Selecting License No Code :");
				 clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Search Button :");
			 }catch(Exception e) {
				 e.printStackTrace();
				 testFailSshot(driver, test);
				 clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on CLose PopUp :");
			 }
		 }else {
			 typeText(driver, test, Auth_Mana_licenseNo, "Entering Auth Licence No :", LicenseNo);
		 }
		typeText(driver, test, Auth_Mana_relatedAuthorisation, "Entering Related Authorization :", RelatedAuth);
		if(Issuedate.length() > 0) {
			clickElement(driver, test, Auth_Mana_issueDate, "Clicking on Issue Date :");
			dateOfMonthName(driver, test, "Selecting Issue Date :", Issuedate);
		}
		if(Expirydate.length() > 0) {
			clickElement(driver, test, Auth_Mana_expireDate, "Clicking on Expiry Date :");
			dateOfMonthName(driver, test, "Selecting Expiry Date", Expirydate);
		}
		if(Closuredate.length() > 0) {
			clickElement(driver, test, Auth_Mana_closeOutDate, "Clicking on Closure Date :");
			dateOfMonthName(driver, test, "Selecting Closure Date", Closuredate);
		}
		scrollToTop(driver);
	}
	
	//.............................Click on Save Button .................................//
	public void save() {
		scrollToElement(driver, Auth_Mana_Save);
		clickElement(driver, test, Auth_Mana_Save, "Clicking on Save Button :");
		Wait.waitfor(3);
	}
	
	//.............................Click on Cancel Button ..............................//
	public void cancel() {
		clickElement(driver, test, Auth_Mana_Cancel, "Clicking on Cacncel Button");
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, Auth_Mana_Country, "Getting Country First Value :");
	}
	
	//.......................Click on Authorization Details ..............................//
	public void authDetails() {
		clickElement(driver, test, Auth_Mana_AuthorizationDetails, "Clicking on Authorization Details :");
	}
}
