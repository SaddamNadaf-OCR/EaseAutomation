package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchBOMPage extends GenericMethods {
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
	public static final String OCR_SearchManufacturer="//input[@id='mfrName']/../../label/a";
	public static final String OCR_SearchManufacturer_ManufacturerUserName = "//input[@id='searchForm_userDTO_userName']";
	public static final String OCR_ManSearchButton = "(//button[@name='Search'])[2]";
	public static final String OCR_manSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_POPupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_PartNo="//input[@id='searchBOM_partNo']";
	/*
	 * ****************************** Constructor *********************************
	 */
	public SearchBOMPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	
	public void SearchBoM(String PartNO, String ManufacturerUserName)
	
	{
		typeText(driver, test, OCR_PartNo, "Enter Part no ", PartNO);
		if (ManufacturerUserName.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturer, "Click on Manufacturer");
			try {
				typeText(driver, test, OCR_SearchManufacturer_ManufacturerUserName, "Enter Manufacturer UserName ",
						ManufacturerUserName);
				clickElement(driver, test, OCR_ManSearchButton, "Click Search Button");
				String manufactureruser = "//div[contains(text(),'" + ManufacturerUserName + "')]";
				clickElement(driver, test, manufactureruser, "Click Manufacturer User :" + ManufacturerUserName);
				clickElement(driver, test, OCR_manSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		
	}
	// Click on Search Button
		public void Click_search() {
			clickElement(driver, test, OCR_MainSearch, "Click on Search Button");
	
	
		}
	
}
