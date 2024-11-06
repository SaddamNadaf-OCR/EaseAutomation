package authorizationManagementClasses;



import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;


public class SearchTIBPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//......................................Locators..........................................//
	public static final String Auth_Mana_Search="(//button[@name='Search'])[1]";
	public static final String Auth_Mana_Reset="(//button[@type='reset'])[1]";
	public static final String Auth_Mana_AddTIB="//button[contains(text(),'Add TIB')]";
	public static final String Auth_Mana_TIBNo="//input[@id='searchTib_tib_tibNo']";
	public static final String Auth_Mana_TIBIssueDate="//input[@id='searchTib_tibIssueDate']";
	public static final String Auth_Mana_ExportPackingSheetNo="//input[@id='searchTib_tib_exportPackingSheetNo']";
	public static final String Auth_Mana_ExpirationDate="//input[@id='searchTib_tibCancelDate']";
	public static final String Auth_Mana_SelectSBU="(//select[@name='tib.sbuCode'])[1]";
	public static final String Auth_Mana_CreatedBy="(//a[contains(text(),'Created By')])[1]";
	public static final String Auth_Mana_SearchPopUp="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_UserFirstNamePopUp="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_CreatedBy1="//input[@id='searchTib_tib_createdBy']";
	public static final String Auth_Mana_SortBy="(//select[@name='sortBy'])[1]";
	public static final String Auth_Mana_Direction="(//select[@name='direction'])[1]";
	public static final String Auth_Mana_Heading1="//h3[contains(text(),'Selection Criteria Based On Tib Item')]";
	public static final String Auth_Mana_Search1="(//button[@type='submit'])[2]";
	public static final String Auth_Mana_Reset1="(//button[@type='reset'])[2]";
	public static final String Auth_Mana_TIBItemNo="//input[@name='tibItem.tibItemNo']";
	public static final String Auth_Mana_initialQuentity="//input[@name='tibItem.tibQuantity']";
	public static final String Auth_Mana_initialValue="//input[@name='tibValue']";
	public static final String Auth_Mana_BalanceQuentity="//input[@name='tibItem.tibTransactionQuantity']";
	public static final String Auth_Mana_BalanceValue="//input[@name='tibTransactionValue']";
	public static final String Auth_Mana_SBUCode="(//select[@name='tib.sbuCode'])[2]";
	public static final String Auth_Mana_CreatedBy2="(//a[contains(text(),'Created By')])[2]";
	public static final String Auth_Mana_CreatedBy3="//input[@id='searchTibItem_tib_createdBy']";
	public static final String Auth_Mana_SortBy1="(//select[@name='sortBy'])[2]";
	public static final String Auth_Mana_Direction1="(//select[@name='direction'])[2]";
	public static final String Auth_Mana_ClosePopup="//button[@class='btn-close']";
	
	//...............................Constructor ..................................//
	public SearchTIBPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..............................Click on Search Tab............................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Please Click On Search Tab");
	}
	
	//.............................Click on Reset Tab..............................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Please Click on Reset Tab");
	}
	
	//.............................Click on Add TIB................................//
	public void addTIB() {
		clickElement(driver, test, Auth_Mana_AddTIB, "Click On Add TIB Button");
	}
	
	//........................Search By TIB No....................................//
	public void searchByParameters(String TIBNumber,String TIBIIssuedate,String packegingNumber,String ExpirationDate,String sbu,
			String CreatedBy, String sortBy, String direction) {
		
		typeText(driver, test, Auth_Mana_TIBNo, "Enter TIB Number", TIBNumber);
		if(TIBIIssuedate.length() > 0) {
		clickElement(driver, test, Auth_Mana_TIBIssueDate, "Click On Issue Date PopUp");
		dateOfMonthName(driver, test, "Selecting Date From Date PopUp", TIBIIssuedate);
		typeText(driver, test, Auth_Mana_ExportPackingSheetNo, "Click On Issue Date PopUp", packegingNumber);
		}
		if(ExpirationDate.length() > 0) {
		clickElement(driver, test, Auth_Mana_ExpirationDate, "Click On Issue Date PopUp");
		dateOfMonthName(driver, test, "Selecting Date From Date PopUp", ExpirationDate);
		}
		selectByVisibleText(driver, test, Auth_Mana_SelectSBU, "Selecting SBU", sbu);
		if(CreatedBy.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedBy, "Clicking on Created By :"+CreatedBy);
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Created By :", CreatedBy);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy+"')]", "Selecting Created By name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, Auth_Mana_CreatedBy1, "Entering Created By Name in TextBox :", CreatedBy);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Select SortBy", sortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Select Direction", direction);
	}
	
	public void searchParameter(String TIBItemNO, String InitialQuantity, String InitialValue, String BalanceQuentity, 
			String BalanceValue, String SBUCODE, String SortBy, String Direction, String CreatedBy) {
		
		typeText(driver, test, Auth_Mana_TIBItemNo, "Entering TIB Item No :", TIBItemNO);
		typeText(driver, test, Auth_Mana_initialQuentity, "Entering Initial Quentity :", InitialQuantity);
		typeText(driver, test, Auth_Mana_initialValue, "Entering Initial Value :", InitialValue);
		typeText(driver, test, Auth_Mana_BalanceQuentity, "Entering Balance Quentity :", BalanceQuentity);
		typeText(driver, test, Auth_Mana_BalanceValue, "Entering Balance Value :", BalanceValue);
		selectByVisibleText(driver, test, Auth_Mana_SBUCode, "Selecting SBU Code :", SBUCODE);
		if(CreatedBy.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedBy2, "Clicking on Created By :"+CreatedBy);
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Created By :", CreatedBy);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy+"')]", "Clicking on Created By name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, Auth_Mana_CreatedBy3, "Entering Created By Name in TextBox :", CreatedBy);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy1, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction1, "Selecting Direction :", Direction);
	}
}
