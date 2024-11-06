package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationOwnersPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_AuthorizationMangentModule = "(//a[contains (text(),'Authorization Management')])[2]";
	public static final String OCR_SearchFiles = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_authorizationOwners = "(//a[@class='dropdown-item'][@data-ocr-role='menu-link'])[22]";
	public static final String OCR_SelectSBUCode = "//select[@id='resultDosLicenseOwner_dosLicenseOwner_sbuCode']";
	public static final String OCR_ownerID="//input[@id='resultDosLicenseOwner_dosLicenseOwner_ownerId']";
	public static final String OCR_OwnerEmpID="//input[@id='resultDosLicenseOwner_dosLicenseOwner_ownerEmpId']";
	public static final String OCR_MainSearch = "//button[contains(text(),'Search')]";
	
	/*
	 * ****************************** Constructor *********************************
	 */
	public SearchAuthorizationOwnersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	
	public void SearchAuthowner(String SBUCode, String OwnerID, String OwnerEmpID) {
		
		selectByVisibleText(driver, test, OCR_SelectSBUCode, "Select SBU Code", SBUCode);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ownerID, "enter ID", OwnerID);
		Wait.waitfor(2);
		typeText(driver, test, OCR_OwnerEmpID, "enter ID", OwnerEmpID);
		Wait.waitfor(2);
	}
	// Click on Search Button
		public void Click_search() {
			clickElement(driver, test, OCR_MainSearch, "Click on Search Button");
	
	
		}
	
}