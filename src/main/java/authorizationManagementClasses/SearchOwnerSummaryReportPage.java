package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchOwnerSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_AuthorizationType ="//select[@name='applFormType']";
	public static final String AuthMana_Report_TransactionID ="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_AuthorizationNo ="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_Status="//select[@name='postLicenseStatus']";
	public static final String AuthMana_Report_Owner ="//a[contains(text(),'  Owner')]";
	public static final String AuthMana_Report_userFirstname = "//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_SearchPopUp="(//button[contains(text(),'Search')])[2]";
	public static final String AuthMana_Report_SelectPopUp="(//button[contains(text(),'Select')])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_OwnerTextbox ="//input[@name='licenseOwner']";
	public static final String AuthMana_Report_POC ="//a[contains(text(),' POC')]";
	public static final String AuthMana_Report_POCTextbox = "//input[@name='licPoc']";
	public static final String AuthMana_Report_Purpose = "//a[contains(text(),'  Purpose')]";
	public static final String AuthMana_Report_PurposeID = "//input[@name='dosLicensePurposeValue.purposeId']";
	public static final String AuthMana_Report_ProductLine = "(//input[@name=''])[2]";
	public static final String AuthMana_Report_ProductLineTextBox ="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_ProductFamily ="//a[contains(text(),' Product Family')]";
	public static final String AuthMana_Report_ProductFamilyTextBox = "//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_sortBy = "(//select[@name='sortBy'])[1]";	
	public static final String AuthMana_Report_direction = "(//select[@name='direction'])[1]";	
	
	
	//..................................Constructors..................................//
	public SearchOwnerSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String AuthorizationType, String TransactionID, String AuthorizationNo, 
			String Status, String Owner, String POC, String Purpose, String ProductLine, String ProductFamily, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationType, "Selecting Authorization Type :", AuthorizationType);
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction ID :", TransactionID);
		typeText(driver, test, AuthMana_Report_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status :", Status);
		if(Owner.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Owner, "Clicking on Owner :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Owner :", Owner);
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
		if(POC.length() > 0) {
			clickElement(driver, test, AuthMana_Report_POC, "Clicking on POC :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering POC :", POC);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+POC+"')]", "Selecting POC :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_POCTextbox, "Entering POC :", POC);
		}
		if(Purpose.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Purpose, "Clicking on Purpose :");
			try {
				typeText(driver, test, AuthMana_Report_PurposeID, "Entering Purpose :", Purpose);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Purpose+"')]", "Selecting Purpose :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductLine, "Clicking on Product Line :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProductLineTextBox, "Entering Product Line :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductFamily, "Clicking on ProductFamily :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProductFamilyTextBox, "Entering Product Family :", ProductFamily);
		}
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting Direction :", Direction);
	}
}