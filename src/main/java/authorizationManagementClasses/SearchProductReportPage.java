package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchProductReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
		public static final String AuthMana_Report_Search ="//button[contains(text(),'Search')]";
		public static final String AuthMana_Report_Reset ="//button[contains(text(),'Reset')]";
		public static final String AuthMana_Report_SBUCode ="//select[@name='product.sbuCode']";
		public static final String AuthMana_Report_status ="//select[@name='product.status']";
		public static final String AuthMana_Report_PartNo ="//input[@name='product.productCode']";
		public static final String AuthMana_Report_skuNo ="//input[@name='product.skuNo']";
		public static final String AuthMana_Report_PartNoManufPartNoModelNoNSN = "//input[@name='partNoManuPartNoNSNModel']";
		public static final String AuthMana_Report_SourceSystemPartNo = "//input[@name='product.sourceProductId']";
		public static final String AuthMana_Report_Description = "//textarea[@name='product.productDesc']";
		public static final String AuthMana_Report_ModelNo = "//input[@name='product.modelNo']";
		public static final String AuthMana_Report_ProductName = "//input[@name='product.productName']";
		public static final String AuthMana_Report_CommonityType = "//select[@name='product.productType']";
		public static final String AuthMana_Report_MaterialType = "//input[@name='product.bomType']";
		public static final String AuthMana_Report_ProductLine ="//a[contains(text(),' Product Line')]";
		public static final String AuthMana_Report_SearchPopup = "//button[@name='Search']";
		public static final String AuthMana_Report_SelectPopup = "(//button[@name='Ok'])[1]";
		public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
		public static final String AuthMana_Report_ProductLineTextbox = "//textarea[@name='product.prodLineId']";
		public static final String AuthMana_Report_Program = "(//a[contains(text(),'Program')])[3]";
		public static final String AuthMana_Report_ProgramCode = "//input[@name='programTab.programCode']";
		public static final String AuthMana_Report_ProgramTextbox = "//textarea[@name='foreignTravelGeneralInfoValue.program']";
		public static final String AuthMana_Report_Site = "(//a[contains(text(),'Site')])[1]";
		public static final String AuthMana_Report_SiteID = "//input[@name='dosSite.siteId']";
		public static final String AuthMana_Report_SiteTextbox = "//textarea[@name='product.workSite']";
		public static final String AuthMana_Report_Hazardous = "//select[@name='product.hazardous']";
		public static final String AuthMana_Report_FlagReason = "(//a[contains(text(),'Flag Reason')])[2]";
		public static final String AuthMana_Report_ReasonCode = "//input[@name='flagReason.reasonCode']";
		public static final String AuthMana_Report_NationalStockNumber = "//input[@name='product.nationalStockNumber']";
		public static final String AuthMana_Report_CreatedBy = "(//a[contains(text(),'Created By')])[1]";
		public static final String AuthMana_Report_CreatedBytextbox = "//input[@name='product.createdBy']";
		public static final String AuthMana_Report_CreatedDateFrom = "//input[@name='fromPrdCrdOn']";
		public static final String AuthMana_Report_CreatedDateTo = "//input[@name='toPrdCrdOn']";
		public static final String AuthMana_Report_ModifiedBy = "(//a[contains(text(),'Modified By')])[1]";
		public static final String AuthMana_Report_userFirstname = "//input[@name='userProfile.userFirstname']";
		public static final String AuthMana_Report_ModifiedByTextbox = "//input[@name='product.modifiedBy']";	
		public static final String AuthMana_Report_ModifyDateFrom = "//input[@name='fromPrdMfdOn']";
		public static final String AuthMana_Report_ModifyDateTo = "//input[@name='toPrdMfdOn']";		
		public static final String AuthMana_Report_sortBy = "//select[@name='sortBy']";
		public static final String AuthMana_Report_direction = "//select[@name='direction']";
		
	
	//..................................Constructors..................................//
	public SearchProductReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String Status, String PartNo, String SKNNo, String PartNoManufNo, 
			String SourceSystemNo, String Description, String ModelNo, String ProductName, String CommodityType, 
			String MaterialType, String ProductLine, String Program, String Site, String Hazardous, String FlagReason, 
			String NationalStockNumber, String CreatedBy, String CreatedDateFrom, String CreatedDateTo, String ModifiedBy, 
			String ModifiedDateFrom, String ModifiedDateTo, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_status, "Selecting Status :", Status);
		typeText(driver, test, AuthMana_Report_PartNo, "Entering Part No :", PartNo);
		typeText(driver, test, AuthMana_Report_skuNo, "Entering SKN No :", SKNNo);
		typeText(driver, test, AuthMana_Report_PartNoManufPartNoModelNoNSN, "Entering Part No manu No :", PartNoManufNo);
		typeText(driver, test, AuthMana_Report_SourceSystemPartNo, "Entering Source Syatem Part No :", SourceSystemNo);
		typeText(driver, test, AuthMana_Report_Description, "Entering Description :", Description);
		typeText(driver, test, AuthMana_Report_ModelNo, "Entering Model No :", ModelNo);	
		typeText(driver, test, AuthMana_Report_ProductName, "Entering Product Name :", ProductName);
		selectByVisibleText(driver, test, AuthMana_Report_CommonityType, "Selecting Commodity type :", CommodityType);
		typeText(driver, test, AuthMana_Report_MaterialType, "Entering Material Type :", MaterialType);
		if(ProductLine.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductLine, "Clicking on Product Line :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProductLineTextbox, "Entering Product Line :", ProductLine);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_ProgramCode, "Entering Program Code :", Program);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Programe :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextbox, "Entering Program :", Program);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Site, "Clicking on Site :");
			try {
				typeText(driver, test, AuthMana_Report_SiteID, "Entering Site Code :", Site);
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
		selectByVisibleText(driver, test, AuthMana_Report_Hazardous, "Selecting Hazardous :", Hazardous);
		if(FlagReason.length() > 0) {
			clickElement(driver, test, AuthMana_Report_FlagReason, "Clicking on Flag Reason :");
			try {
				typeText(driver, test, AuthMana_Report_ReasonCode, "Entering Flag Reason :", FlagReason);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+FlagReason+"')]", "Selecting Flag Reason :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		typeText(driver, test, AuthMana_Report_NationalStockNumber, "Entering National Stock Number :", NationalStockNumber);
		if(CreatedBy.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CreatedBy, "Clicking on Created By :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Created By :", CreatedBy);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy+"')]", "Selecting Created By :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_CreatedBytextbox, "Entering Created By :", CreatedBy);
		}
		if(CreatedDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CreatedDateFrom, "Clicking on Created Date From :");
			dateOfMonthName(driver, test, "Selecting Created Date From :", CreatedDateFrom);
		}
		if(CreatedDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CreatedDateTo, "Clicking on Created Date To :");
			dateOfMonthName(driver, test, "Selecting Created Date To :", CreatedDateTo);
		}
		if(ModifiedBy.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ModifiedBy, "Clicking on Modified By :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Modified By :", ModifiedBy);
				clickElement(driver, test, AuthMana_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ModifiedBy+"')]", "Selecting Modified By :");
				clickElement(driver, test, AuthMana_Report_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ModifiedByTextbox, "Entering Modified By :", ModifiedBy);
		}
		if(ModifiedDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ModifyDateFrom, "Clicking on Modified Date From :");
			dateOfMonthName(driver, test, "Selecting Modified Date From :", ModifiedDateFrom);
		}
		if(ModifiedDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ModifyDateTo, "Clicking on Modified Date To :");
			dateOfMonthName(driver, test, "Selecting Modified Date to :", ModifiedDateTo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting Direction :", Direction);
	}
}