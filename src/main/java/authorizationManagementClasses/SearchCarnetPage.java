package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchCarnetPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//....................................Locators ......................................//

	public static final String Auth_Mana_Search="(//button[@name='Search'])[1]";
	public static final String Auth_Mana_Reset="(//button[@type='reset'])[1]";
	public static final String Auth_Mana_AddCarnet="//button[contains(text(),'Add Carnet')]";
	public static final String Auth_Mana_CarnetNo="//input[@id='searchCarnet_carnetHeader_carnetNo']";
	public static final String Auth_Mana_CarnetIssueDate="//input[@id='searchCarnet_carnetIssueDate']";
	public static final String Auth_Mana_CarnetExpiryDate="//input[@id='searchCarnet_carnetExpirationDate']";
	public static final String Auth_Mana_SBUCODE="(//select[@name='carnetHeader.sbuCode'])[1]";
	public static final String Auth_Mana_CreatedByPopUp="(//a[contains(text(),'Created By')])[1]";
	public static final String Auth_Mana_SearchPopUp="(//button[@name='Search'])[3]";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_UserFirstNamePopUp="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_CreatedBy="(//input[@name='carnetHeader.createdBy'])[1]";
	public static final String Auth_Mana_SortBy="(//select[@name='sortBy'])[1]";
	public static final String Auth_Mana_Direction="(//select[@name='direction'])[1]";

	public static final String Auth_Mana_Search1="(//button[@name='Search'])[2]";
	public static final String Auth_Mana_Reset1="(//button[@type='reset'])[2]";
	public static final String Auth_Mana_CarnetItemNo="//input[@id='searchCarnetItem_carnetItem_carnetItemNo']";
	public static final String Auth_Mana_InitialQuantity="//input[@id='searchCarnetItem_carnetItem_carnetQuantity']";
	public static final String Auth_Mana_InitialValue="//input[@id='searchCarnetItem_carnetValue']";
	public static final String Auth_Mana_BalanceQuantity="//input[@id='searchCarnetItem_carnetItem_carnetTransactionQuantity']";
	public static final String Auth_Mana_BalanceValue="//input[@id='searchCarnetItem_carnetTransactionValue']";
	public static final String Auth_Mana_SbuCode="(//select[@name='carnetHeader.sbuCode'])[2]";
	public static final String Auth_Mana_CreatedBy2="(//a[contains(text(),'Created By')])[2]";
	public static final String Auth_Mana_CreatedBy3="(//input[@name='carnetHeader.createdBy'])[2]";
	public static final String Auth_Mana_SortBy1="(//select[@name='sortBy'])[2]";
	public static final String Auth_Mana_Direction1="(//select[@name='direction'])[2]";
	
	//...................................Constructors............................................//
	public SearchCarnetPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...............................Click on Add Carnet Button................................//
	public void addCarnet() {
		clickElement(driver, test, Auth_Mana_AddCarnet, "Clicking on Add Carnet");
	}
	
	//...............................Click on Search Tab .................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//..............................Click on Resest Tab ........................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Clicking on Reset Tab");
	}
	
	//............................Search By Parameters....................................//
	public void searchByParameters(String carnetNo,String issuedate,String expirydate,String sbu,String CreatedBy,
			String sortBy,String direction, String CarnetItemNo, String InitialQuantity, String InitialValue, 
			String BalanceQuantity, String BalanceValue, String sbuCode, String CreatedBy1, String sortBy1, String direction1) {
		
		typeText(driver, test, Auth_Mana_CarnetNo,"Entering value in carnet Number :", carnetNo);
		if(issuedate.length() > 0) {
			clickElement(driver, test, Auth_Mana_CarnetIssueDate, "Clicking on Carnet Issue Date :");
			dateOfMonthName(driver, test, "Selecting Date From PopUp :", issuedate);
		}
		if(expirydate.length() > 0) {
			clickElement(driver, test, Auth_Mana_CarnetExpiryDate, "Clicking on Carnet Expiry Date :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From PopUp :", expirydate);
		}
		selectByVisibleText(driver, test, Auth_Mana_SBUCODE, "Selecting SBU From DropDown :", sbu);
		if(CreatedBy.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedByPopUp, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Created By Name :", CreatedBy);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy+"')]", "Clicking on Created By name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_CreatedBy, "Entering Created By Name in TextBox :", CreatedBy);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", sortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction From DropDown :", direction);
		scrollToBottom(driver);
		
		//....................Selection Criteria based on Carnet Item........................//
		typeText(driver, test, Auth_Mana_CarnetItemNo, "Entering Carnet Item No :", CarnetItemNo);
		typeText(driver, test, Auth_Mana_InitialQuantity, "Entering Initial Quantity :", InitialQuantity);
		typeText(driver, test, Auth_Mana_InitialValue, "Entering Initial value :", InitialValue);
		typeText(driver, test, Auth_Mana_BalanceQuantity, "Entering Balance Quantity :", BalanceQuantity);
		typeText(driver, test, Auth_Mana_BalanceValue, "Entering Balance Value :", BalanceValue);
		selectByVisibleText(driver, test, Auth_Mana_SbuCode, "Selecting SBU Code :", sbuCode);
		if(CreatedBy1.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedBy2, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Created By Name :", CreatedBy1);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy1+"')]", "Clicking on Created By name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_CreatedBy3, "Entering Created By Name in TextBox :", CreatedBy1);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy1, "Selecting Sort By :", sortBy1);
		selectByVisibleText(driver, test, Auth_Mana_Direction1, "Selecting Direction From DropDown :", direction1);
		scrollToTop(driver);
	}
}
