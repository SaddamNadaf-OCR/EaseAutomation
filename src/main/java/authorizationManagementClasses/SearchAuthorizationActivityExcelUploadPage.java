package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationActivityExcelUploadPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//..............................Locators ..................................//
	public static final String Auth_Mana_Search="//button[contains(text(),'Search')]";
	public static final String Auth_Mana_UploadFile="//button[contains(text(),'Upload File')]";
	public static final String Auth_Mana_UploadFilePopUp="//input[@id='fileUpload']"
;	public static final String Auth_Mana_BacktoActivity="//button[contains(text(),'Back to Activity')]";
	public static final String Auth_Mana_Excel="//i[@title='common.download.samplexl']";
	public static final String Auth_Mana_FileName="//input[@id='resultAuthActivityExcelUpload_authActivityExcelUploadValue_fileName']";
	public static final String Auth_Mana_Status="//select[@id='resultAuthActivityExcelUpload_authActivityExcelUploadValue_status']";
	public static final String Auth_Mana_SBUCode="//select[@id='resultAuthActivityExcelUpload_authActivityExcelUploadValue_sbuCode']";
	public static final String Auth_Mana_UploadedBy="//select[@id='resultAuthActivityExcelUpload_authActivityExcelUploadValue_uploadedBy']";
	public static final String Auth_Mana_UploadStartDate="//input[@name='uploadStartDate']";
	public static final String Auth_Mana_UploadEndDate="//input[@name='uploadEndDate']";
	public static final String Auth_Mana_SortBy="//select[@name='sortBy']";
	public static final String Auth_Mana_Direction="//select[@name='direction']";
	
	
	//.............................Constructors.....................................//
	public SearchAuthorizationActivityExcelUploadPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Click on Search ..................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Upload File ..................................//
	public void uploadFile() {
		clickElement(driver, test, Auth_Mana_UploadFile, "Clicking on Upload File Tab");
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_UploadFilePopUp, "Clicking for File Upload");
	}
	
	//.............................Click on Back To Activity ..................................//
	public void backtoActivity() {
		clickElement(driver, test, Auth_Mana_BacktoActivity, "Clicking on Back to Activity Tab");
	}
	
	//.............................Click on DownLoad Excel ..................................//
	public void downLoadExcel() {
		clickElement(driver, test, Auth_Mana_Excel, "Clicking on DownLoad Excel");
	}
	
	//.............................Click on Search By File Name ..................................//
	public void searchByFileName(String fileName) {
		typeText(driver, test, Auth_Mana_FileName, "Entering File Name", fileName);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Search By Status ..................................//
	public void searchByStatus(String status) {
		selectByVisibleText(driver, test, Auth_Mana_Status, "Selecting Status", status);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Search By SBU Code ..................................//
	public void searchBySBUCode(String SBUCode) {
		selectByVisibleText(driver, test, Auth_Mana_SBUCode, "Selecting SBU Code", SBUCode);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Search By Uploaded By ..................................//
	public void searchByUploadedBy(String UploadedBy) {
		selectByVisibleText(driver, test, Auth_Mana_UploadedBy, "Selecting Uploaded By", UploadedBy);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
		
	//.............................Click on Search By Upload Start Date..................................//
	public void searchByUploadStartDate(String uploadStartdate) {
		clickElement(driver, test, Auth_Mana_UploadStartDate, "Clicking on Start Date");
		dateOfMonthName(driver, test, "Selecting Start Date", uploadStartdate);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Search By Upload End Date..................................//
	public void searchByUploadEndDate(String uploadEnddate) {
		clickElement(driver, test, Auth_Mana_UploadEndDate, "Clicking on End Date");
		dateOfMonthName(driver, test, "Selecting End Date", uploadEnddate);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
		
	//.............................Click on Search By Sort By ..................................//
	public void searchBySortBy(String sortBy) {
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Direction", sortBy);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
		
	//.............................Click on Search By Direction ..................................//
	public void searchByDirection(String direction) {
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction", direction);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
}
