package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchListOfAuthorizationsPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='licenseHeader.sbuCode']";
	public static final String AuthMana_Report_AuthorizationType ="//a[contains(text(),' Authorization Type')]";
	public static final String AuthMana_Report_AuthorizationTypePopup ="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextbox ="//textarea[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_AuthorizationNo ="//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_Site="//a[contains(text(),' Site')]";
	public static final String AuthMana_Report_SiteID ="//input[@name='dosSite.siteId']";
	public static final String AuthMana_Report_SiteIDTextbox ="//textarea[@name='licenseHeader.site']";
	public static final String AuthMana_Report_ActivityType="//select[@name='activityType']";
	public static final String AuthMana_Report_AuthorizationStatus ="//select[@name='licenseStatus']";
	public static final String AuthMana_Report_ContractNo = "//input[@name='licenseHeader.contractNo']";
	public static final String AuthMana_Report_Agency ="//select[@name='licenseHeader.controllingAgency']";
	public static final String AuthMana_Report_ReferanceID ="//input[@name='licenseHeader.referenceNo']";
	public static final String AuthMana_Report_UltimateConsignee = "//input[@name='licenseConsignee.licConsName']";
	public static final String AuthMana_Report_FromIssueDate = "//input[@name='fromIssueDate']";
	public static final String AuthMana_Report_ToIssueDate = "//input[@name='toIssueDate']";
	public static final String AuthMana_Report_Country = "(//input[@name=''])[1]";
	public static final String AuthMana_Report_TECC ="//input[@name='licenseHeader.tecc']";
	public static final String AuthMana_Report_AuthWillExpiry ="//input[@name='noofdays']";
	public static final String AuthMana_Report_Segment = "//a[contains(text(),' Segment')]";
	public static final String AuthMana_Report_SegmentTextBox = "//textarea[@name='licenseHeader.segmentCode']";
	public static final String AuthMana_Report_FromExpireDate = "//input[@name='fromExpireDate']";	
	public static final String AuthMana_Report_ToExpireDate = "//input[@name='toExpireDate']";	
	public static final String AuthMana_Report_Originator = "//input[@name='licenseHeader.originator']";
	public static final String AuthMana_Report_CreatedBy = "(//select[@name='licenseHeader.createdBy'])[1]";
	public static final String AuthMana_Report_CaseNo = "//input[@name='licenseHeader.caseNo']";
	public static final String AuthMana_Report_SBUCode1 = "(//select[@name='licenseHeader.sbuCode'])[2]";
	public static final String AuthMana_Report_ItemNo = "//input[@name='licenseItem.itemNo']";
	public static final String AuthMana_Report_PartNo = "//a[@id='partNoPopup']";
	public static final String AuthMana_Report_PartNoPopup = "//input[@name='product.productCode']";
	public static final String AuthMana_Report_PartNotextBox = "//input[@name='licenseItem.productCd']";
	public static final String AuthMana_Report_ECCNUSML = "//input[@name='licenseItem.prodClassification']";
	public static final String AuthMana_Report_ActivityType2 = "//select[@name='activityTypeItem']";
	public static final String AuthMana_Report_Quantity = "//input[@name='licenseItem.licenseQuantity']";
	public static final String AuthMana_Report_Value = "//input[@name='licenseValue']";
	public static final String AuthMana_Report_AuthQuantityUsed = "//input[@name='licenseItem.transactionQuantity']";
	public static final String AuthMana_Report_AuthValueUsed = "//input[@name='transactionValue']";
	public static final String AuthMana_Report_CreatedBy1 = "(//select[@name='licenseHeader.createdBy'])[2]";
	public static final String AuthMana_Report_SalesOrderNo = "//input[@name='licenseItem.salesOrderNo']";
	public static final String AuthMana_Report_SalesOrderLineItem = "//input[@name='licenseItem.salesOrderLineItem']";
	public static final String AuthMana_Report_Description = "//textarea[@name='licenseItem.description']";
	public static final String AuthMana_Report_Country1 = "(//input[@name=''])[2]";
	
	
	//..................................Constructors..................................//
	public SearchListOfAuthorizationsPage(WebDriver driver,ExtentTest test) {
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
	
	//............................Search By Parameters.................................//
	public void searchByParameters(String SBUCode, String AuthorizationType, String AuthorizationNo, String Site, String ActivityType, 
			String AuthorizationStatus, String ContractNo, String Agency, String ReferanceID, String UltimateConsignee, 
			String IssueDateFrom, String IssueDateTo, String Country, String TECC, String AuthWillExpiry, String Segment, 
			String ExpiryDateFrom, String ExpiryDateTo, String Originator, String CreatedBy, String CaseNo, String SBUCode1, 
			String ItemNo, String PartNo, String ECCNUSML, String ActivityType1, String Quantity, String Value, String AuthQuantutyUsed, 
			String AuthValueUsed, String CreatedBy1, String SalesOrderNo, String SalesOrderLineItemNo, String Description, String Country1) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
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
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextbox, "Entering Authorization Type :", AuthorizationType);
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
			typeText(driver, test, AuthMana_Report_SiteIDTextbox, "Entering Site :", Site);
		}
		selectByVisibleText(driver, test, AuthMana_Report_ActivityType, "Selecting Activity Type :", ActivityType);
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationStatus, "Selecting Authorization Status :", AuthorizationStatus);
		typeText(driver, test, AuthMana_Report_ContractNo, "Entering Contract No :", ContractNo);
		selectByVisibleText(driver, test, AuthMana_Report_Agency, "Selecting Agency Type :", Agency);
		typeText(driver, test, AuthMana_Report_ReferanceID, "Entering Referance ID :", ReferanceID);
		typeText(driver, test, AuthMana_Report_UltimateConsignee, "Entering Ultimate Consignee :", UltimateConsignee);
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_FromIssueDate, "Clicking on Issue From Date :");
			dateOfMonthName(driver, test, "Selecting Isssue From Date :", IssueDateFrom);
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ToIssueDate, "Clicking on Isuue Date To :");
			dateOfMonthName(driver, test, "Selecting Issue Date To :", IssueDateTo);
		}
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		typeText(driver, test, AuthMana_Report_TECC, "Entering TECC :", TECC);
		typeText(driver, test, AuthMana_Report_AuthWillExpiry, "Entering Auth Will Expiry :", AuthWillExpiry);
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
			typeText(driver, test, AuthMana_Report_SegmentTextBox, "Entering Segment :", Segment);
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_FromExpireDate, "Clicking on Expiry From Date :");
			dateOfMonthName(driver, test, "Selecting Expiry From Date :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ToExpireDate, "Clicking on Expiry Date To :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		typeText(driver, test, AuthMana_Report_Originator, "Entering Originator :", Originator);
		selectByVisibleText(driver, test, AuthMana_Report_CreatedBy, "Selecting Created By :", CreatedBy);
		typeText(driver, test, AuthMana_Report_CaseNo, "Entering Case No :", CaseNo);
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode1, "Selecting SBU Code :", SBUCode1);
		typeText(driver, test, AuthMana_Report_ItemNo, "Entering Item No :", ItemNo);
		if(PartNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PartNo, "Clicking on Part No :");
			try {
				typeText(driver, test, AuthMana_Report_PartNoPopup, "Entering Part No :", PartNo);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PartNo+"')]", "Selecting Part No :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_PartNotextBox, "Entering Part No :", PartNo);
		}
		typeText(driver, test, AuthMana_Report_ECCNUSML, "Entering ECCNUSML No :", ECCNUSML);
		selectByVisibleText(driver, test, AuthMana_Report_ActivityType2, "Selecting Activity Type :", ActivityType1);
		typeText(driver, test, AuthMana_Report_Quantity, "Entering Quantity :", Quantity);
		typeText(driver, test, AuthMana_Report_Value, "Entering Value :", Value);
		typeText(driver, test, AuthMana_Report_AuthQuantityUsed, "Entering Auth Quantity Used :", AuthQuantutyUsed);
		typeText(driver, test, AuthMana_Report_AuthValueUsed, "Entering Auth Value Used :", AuthValueUsed);
		selectByVisibleText(driver, test, AuthMana_Report_CreatedBy1, "Selecting Created By :", CreatedBy1);
		typeText(driver, test, AuthMana_Report_SalesOrderNo, "Entering Sales Order No :", SalesOrderNo);
		typeText(driver, test, AuthMana_Report_SalesOrderLineItem, "Entering Sales Order Line Item Number :", SalesOrderLineItemNo);
		typeText(driver, test, AuthMana_Report_Description, "Entering Description :", Description);
		typeText(driver, test, AuthMana_Report_Country1, "Entering Country :", Country1);
	}
}