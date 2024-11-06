package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAuthorizationInformationReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_AuthorizationNo = "//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String AuthMana_Report_AuthorizationTypePopup="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[contains(text(),'Search')])[2]";
	public static final String AuthMana_Report_SelectPopUp="(//button[contains(text(),'Select')])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextbox ="//textarea[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_Status="//select[@name='licenseHeader.licenseStatus']";
	public static final String AuthMana_Report_Agency ="//select[@name='licenseHeader.controllingAgency']";
	public static final String AuthMana_Report_Program = "(//a[contains(text(),' Program')])";
	public static final String AuthMana_Report_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String AuthMana_Report_ProgramTextbox = "//textarea[@id='reportLicExpire_licenseHeader_programCode']";
	public static final String AuthMana_Report_ReferanceNo = "//input[@name='licenseHeader.referenceNo']";
	public static final String AuthMana_Report_ContractNo ="//input[@name='licenseHeader.contractNo']";
	public static final String AuthMana_Report_ExpiryDateFrom = "//input[@id='reportLicExpire_fromExpireDate']";
	public static final String AuthMana_Report_ExpiryDateTo = "//input[@id='reportLicExpire_toExpireDate']";
	public static final String AuthMana_Report_UltimateConsignee ="//input[@name='licUltCons']";
	public static final String AuthMana_Report_Country ="(//input[@name=''])[1]";
	public static final String AuthMana_Report_EndUser = "//input[@name='licEuCons']";
	public static final String AuthMana_Report_sbucode = "//select[@name='licenseHeader.sbuCode']";
	public static final String AuthMana_Report_Country1 = "(//input[@name=''])[2]";
	public static final String AuthMana_Report_PartNo ="//a[contains(text(),'Part No.')]";
	public static final String AuthMana_Report_ProductCode ="//input[@name='product.productCode']";
	public static final String AuthMana_Report_PartNoTextBox = "//input[@name='licenseItem.productCd']";	
	public static final String AuthMana_Report_ItemValue = "//input[@name='licenseValue']";	
	public static final String AuthMana_Report_description = "//textarea[@name='licenseItem.description']";	
	public static final String AuthMana_Report_ItemDetailsY = "(//input[@name='showDetails'])[1]";	
	public static final String AuthMana_Report_ItemDetailsN = "(//input[@name='showDetails'])[2]";	
	public static final String AuthMana_Report_CreatedBy = "//select[@name='licenseHeader.createdBy']";	
	public static final String AuthMana_Report_sortBy = "(//select[@name='sortBy'])[1]";	
	public static final String AuthMana_Report_direction = "(//select[@name='direction'])[1]";	
	
	
	//..................................Constructors..................................//
	public SearchAuthorizationInformationReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String AuthorizationNo, String AuthorizationType, String Status, String Agency, String Program, 
			String ReferanceNo, String ContractNo, String ExpiryDateFrom, String ExpiryDateTo, String UltimateConsignee, 
			String Country, String EndUser) {
		
		typeText(driver, test, AuthMana_Report_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
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
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Statux :", Status);
		selectByVisibleText(driver, test, AuthMana_Report_Agency, "Selecting Agency :", Agency);
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
		typeText(driver, test, AuthMana_Report_ReferanceNo, "Entering Referance No :", ReferanceNo);
		typeText(driver, test, AuthMana_Report_ContractNo, "Entering Contract No :", ContractNo);
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateFrom, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateTo, "Clicking on Expiry Date to :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		typeText(driver, test, AuthMana_Report_UltimateConsignee, "Entering Ultimate Consignee :", UltimateConsignee);
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		typeText(driver, test, AuthMana_Report_EndUser, "Entering End User :", EndUser);
	}
}
