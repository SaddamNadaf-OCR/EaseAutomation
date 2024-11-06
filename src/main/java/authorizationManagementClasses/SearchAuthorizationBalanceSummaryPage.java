package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAuthorizationBalanceSummaryPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="(//select[@name='licenseHeader.sbuCode'])[1]";
	public static final String AuthMana_Report_AuthorizationType="//a[contains(text(),' Authorization Type')]";
	public static final String AuthMana_Report_AuthorizationTypePopup="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextBox="//textarea[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_AuthorizationNo ="//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_Site = "//a[contains(text(),'Site')]";
	public static final String AuthMana_Report_SiteID = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String AuthMana_Report_SiteTextbox = "//textarea[@id='generateReport_licenseHeader_site']";
	public static final String AuthMana_Report_activityType ="//select[@name='activityType']";
	public static final String AuthMana_Report_AuthorizationStatus ="//select[@name='licenseStatus']";
	public static final String AuthMana_Report_Owner = "(//a[contains(text(),'Owner')])[4]";
	public static final String AuthMana_Report_OwnerFirstName = "//input[@id='searchForm_dosLicenseOwnerPopupDTO_ownerFirstName']";
	public static final String AuthMana_Report_OwnerTextbox = "//input[@id='generateReport_licenseHeader_licenseOwner']";
	public static final String AuthMana_Report_Program = "(//a[contains(text(),' Program')])[2]";
	public static final String AuthMana_Report_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String AuthMana_Report_ProgramTextbox = "//textarea[@id='generateReport_licenseHeader_programCode']";
	public static final String AuthMana_Report_contractNo ="//input[@name='licenseHeader.contractNo']";
	public static final String AuthMana_Report_Agency = "//select[@name='licenseHeader.controllingAgency']";
	public static final String AuthMana_Report_referenceNo ="//input[@name='licenseHeader.referenceNo']";
	public static final String AuthMana_Report_UltimateConsignee ="//input[@name='licenseConsignee.licConsName']";
	public static final String AuthMana_Report_fromIssueDate ="//input[@name='fromIssueDate']";
	public static final String AuthMana_Report_toIssueDate ="//input[@name='toIssueDate']";
	public static final String AuthMana_Report_Country ="//input[@name='']";
	public static final String AuthMana_Report_tecc ="//input[@name='licenseHeader.tecc']";
	public static final String AuthMana_Report_AuthWillExpiry = "//input[@name='noofdays']";
	public static final String AuthMana_Report_Segment ="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentTextBox ="//textarea[@name='licenseHeader.segmentDesc']";
	public static final String AuthMana_Report_ExpiryDateFrom = "//input[@id='generateReport_fromExpireDate']";
	public static final String AuthMana_Report_ExpiryDateTo = "//input[@id='generateReport_toExpireDate']";
	public static final String AuthMana_Report_originator = "//input[@id='generateReport_licenseHeader_originator']";
	public static final String AuthMana_Report_createdBy = "//select[@id='generateReport_licenseHeader_createdBy']";
	public static final String AuthMana_Report_salesOrderNo = "//input[@id='generateReport_licenseHeader_salesOrderNo']";
	public static final String AuthMana_Report_caseNo = "//input[@id='generateReport_licenseHeader_caseNo']";
	public static final String AuthMana_Report_sbuCode = "//select[@id='generateReport1_licenseHeader_sbuCode']";
	public static final String AuthMana_Report_itemNo = "//input[@id='generateReport1_licenseItem_itemNo']";
	public static final String AuthMana_Report_partNo = "//a[@id='partNoPopup']";
	public static final String AuthMana_Report_productCode = "//input[@id='searchForm_product_productCode']";
	public static final String AuthMana_Report_productCd = "//input[@id='generateReport1_licenseItem_productCd']";
	public static final String AuthMana_Report_ECCN_USML = "//input[@id='generateReport1_licenseItem_prodClassification']";
	public static final String AuthMana_Report_activityTypeItem = "//select[@id='generateReport1_activityTypeItem']";
	public static final String AuthMana_Report_Quantity = "//input[@id='generateReport1_licenseItem_licenseQuantity']";
	public static final String AuthMana_Report_Value = "//input[@id='generateReport1_licenseValue']";
	public static final String AuthMana_Report_transactionQuantity = "//input[@id='generateReport1_licenseItem_transactionQuantity']";
	public static final String AuthMana_Report_transactionValue = "//input[@id='generateReport1_transactionValue']";
	public static final String AuthMana_Report_createdBy1 = "//select[@id='generateReport1_licenseHeader_createdBy']";
	public static final String AuthMana_Report_salesOrderNo1 = "//input[@id='generateReport1_licenseItem_salesOrderNo']";
	public static final String AuthMana_Report_salesOrderLineItem = "//input[@id='generateReport1_licenseItem_salesOrderLineItem']";
	public static final String AuthMana_Report_description = "//textarea[@id='generateReport1_licenseItem_description']";
	public static final String AuthMana_Report_country = "(//input[@name=''])[2]";
	
	
	//..................................Constructors..................................//
	public SearchAuthorizationBalanceSummaryPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//................................Click on Search Tab ...............................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_Search, "Clicking on Search Tab");
	}
	
	//................................Click on Reset Tab ...............................//
	public void reset() {
		clickElement(driver, test, AuthMana_Report_Reset, "Clicking on Reset Tab");
	}
	
	//...............................Search By Parameters...............................//
	public void searchByParameters(String SBUCode, String AuthorizationType, String AuthorizationNo, String Site, 
			String ActivityType, String Status, String Owner, String Program, String ContractNo, String Agency, 
			String ReferanceNo, String UltimateConsignee, String IssueDateFrom, String IssueDateTo, String Country, 
			String TECC, String AuthWillExpiry, String Segment, String ExpiryDateFrom, String ExpiryDateTo, 
			String Originator, String CreatedBy1, String SalesOrderNo1, String CaseNo) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code :", SBUCode);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationTypePopup, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextBox, "Entering Authorization Type :", AuthorizationType);
		}
		typeText(driver, test, AuthMana_Report_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
		if(Site.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Site, "Clicking on Site :");
			try {
				typeText(driver, test, AuthMana_Report_SiteID, "Entering Site :", Site);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_SiteTextbox, "Entering Site :", Site);
		}
		selectByVisibleText(driver, test, AuthMana_Report_activityType, "Selecting Activity Type :", ActivityType);
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationStatus, "Selecting Authorization Status :", Status);
		if(Owner.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Owner, "Clicking on Owner :");
			try {
				typeText(driver, test, AuthMana_Report_OwnerFirstName, "Entering Owner :", Owner);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Owner+"')]", "Selecting Owner :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_OwnerTextbox, "Entering Owner :", Owner);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_ProgramCode, "Entering Program :", Program);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextbox, "Entering Program :", Program);
		}
		typeText(driver, test, AuthMana_Report_contractNo, "Entering Contract No :", ContractNo);
		selectByVisibleText(driver, test, AuthMana_Report_Agency, "Selecting Agency :", Agency);
		typeText(driver, test, AuthMana_Report_referenceNo, "Entering Referance No :", ReferanceNo);
		typeText(driver, test, AuthMana_Report_UltimateConsignee, "Entering Ultimate Consignee :", UltimateConsignee);
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_fromIssueDate, "Clicking on Issue Date From :");
			dateOfMonthName(driver, test, "Selecting Issue Date From :", IssueDateFrom);
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_toIssueDate, "Clicking on Issue Date to :");
			dateOfMonthName(driver, test, "Selecting Issue Date To :", IssueDateTo);
		}
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		typeText(driver, test, AuthMana_Report_tecc, "Entering TECC :", TECC);
		typeText(driver, test, AuthMana_Report_AuthWillExpiry, "Entering Auth Will Expiry Within :", AuthWillExpiry);
		if(Segment.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_segmentTextBox, "Entering Segment :", Segment);
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateFrom, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateTo, "Clicking on Expiry Date to :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		typeText(driver, test, AuthMana_Report_originator, "Entering Originator :", Originator);
		selectByVisibleText(driver, test, AuthMana_Report_createdBy, "Selecting Created By :", CreatedBy1);
		typeText(driver, test, AuthMana_Report_salesOrderNo, "Entering Sales Order No :", SalesOrderNo1);
		typeText(driver, test, AuthMana_Report_caseNo, "Entering Case No :", CaseNo);
	}
}