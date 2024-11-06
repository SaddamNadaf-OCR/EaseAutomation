package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;


public class SearchAuthorizationStorePage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;
	
	//................................Locators.......................................//
	public static final String Auth_Mana_Search="//button[contains(text(),'Search')]";
	public static final String Auth_Mana_Reset="//button[contains(text(),'Reset')]";
	public static final String Auth_Mana_SBUCODE="//select[@id='dosGeneralInfo.sbuCode']";
	public static final String Auth_Mana_Type="//select[@id='resultLicenseStore_applFormType']";
	public static final String Auth_Mana_TransactionID="//input[@id='resultLicenseStore_dosGeneralInfo_transactionId']";
	public static final String Auth_Mana_AuthorizationNo="//input[@id='resultLicenseStore_dosGeneralInfo_licenseNo']";
	public static final String Auth_Mana_CaseNo="//input[@id='resultLicenseStore_dosGeneralInfo_caseNo']";
	public static final String Auth_Mana_Status="//select[@name='postLicenseStatus']";
	public static final String Auth_Mana_Segement="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_SegementPopUp="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_SearchPopUp="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_Segement1="//textarea[@id='resultLicenseStore_dosGeneralInfo_segmentCode']";
	public static final String Auth_Mana_Program="(//a[contains(text(),'Program')])[3]";
	public static final String Auth_Mana_ProgramPopUp="(//a[contains(text(),'Programme')])[2]";
	public static final String Auth_Mana_ProgramCodePopUp="//input[@name='programTab.programCode']";
	public static final String Auth_Mana_Program1="//textarea[@id='resultLicenseStore_dosGeneralInfo_programTab']";
	public static final String Auth_Mana_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String Auth_Mana_ProductLinePopUp="//a[contains(text(),'Product Line')]";
	public static final String Auth_Mana_ProductLine1="//textarea[@id='resultLicenseStore_dosGeneralInfo_prodLine']";
	public static final String Auth_Mana_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String Auth_Mana_ProductFamilyPopUp="//a[contains(text(),'Product Family')]";
	public static final String Auth_Mana_ProductFamily1="///textarea[@id='resultLicenseStore_dosGeneralInfo_prodFamily']";
	public static final String Auth_Mana_SortBy="//select[@name='sortBy']";
	public static final String Auth_Mana_Direction="//select[@name='direction']";

	//...................................Constructor...........................................//
	public SearchAuthorizationStorePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Search.............................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Button");
	}
	
	//...................................Reset .............................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Clicking on Reset Button");
	}
	
	//...................................Search Parameters...........................................//
	public void searchBYParameters(String sbu,String type, String TransactionID, String authorizationNo, String caseNo, 
			String status,String Segment,String Program,String ProductLine,String ProductFamily, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, Auth_Mana_SBUCODE, "Selecting SBU From Dropdown :", sbu);
		selectByVisibleText(driver, test, Auth_Mana_Type, "Selecting Type From Dropdown :", type);
		typeText(driver, test, Auth_Mana_TransactionID, "Entering Transaction Id :", TransactionID);
		typeText(driver, test, Auth_Mana_AuthorizationNo, "Entering Transaction Id :", authorizationNo);
		typeText(driver, test, Auth_Mana_CaseNo, "Entering Case No :", caseNo);
		selectByVisibleText(driver, test, Auth_Mana_Status, "Selecting Status :", status);
		if(Segment.length() > 0) {
			clickElement(driver, test, Auth_Mana_SegementPopUp, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Clicking on Segment name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_Segement, "Entering Segment Name in TextBox :", Segment);
		}
		scrollToBottom(driver);
		if(Program.length() > 0) {
			clickElement(driver, test, Auth_Mana_ProgramPopUp, "Clicking on Program :");
			try {
				typeText(driver, test, Auth_Mana_ProgramCodePopUp, "Entering Program Name :", Program);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Clicking on Program name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_Program, "Entering Program Name in TextBox :", Program);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, Auth_Mana_ProductLinePopUp, "Clicking on Product Line :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Clicking on ProductLine name :"+ProductLine);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ProductLine, "Entering ProductLine Name in TextBox :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, Auth_Mana_ProductFamilyPopUp, "Clicking on Created By :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Clicking on Product Family name :"+ProductFamily);
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ProductFamily, "Entering Product Family Name in TextBox :", ProductFamily);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction :", Direction);
	}
}
