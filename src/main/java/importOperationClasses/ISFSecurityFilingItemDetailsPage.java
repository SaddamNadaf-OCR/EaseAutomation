package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ISFSecurityFilingItemDetailsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */ 
	public static final String OCR_ISFSecurityFilingItemDetails_BillNo = "//select[@id='editIsf10Items_importIsf10ItemsValue_billNo']";
	public static final String OCR_ISFSecurityFilingItemDetails_PartNoLink = "//a[@id='isfPartNoPopup']";
	public static final String OCR_ISFSecurityFilingItemDetails_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ISFSecurityFilingItemDetails_SearchPopUp = "//button[@name='Search']";
	public static final String OCR_ISFSecurityFilingItemDetails_SelectPopUp = "//button[contains(text(),'Select')][1]";
	public static final String OCR_ISFSecurityFilingItemDetails_ClosePopUp = "//button[@class='close']";
	public static final String OCR_ISFSecurityFilingItemDetails_SourceSystemPartNumber = "//input[@id='editIsf10Items_importIsf10ItemsValue_sourceSystemPartNo']";
	public static final String OCR_ISFSecurityFilingItemDetails_ManufacturerPartNumber = "//input[@id='editIsf10Items_importIsf10ItemsValue_mfgCode']";
	public static final String OCR_ISFSecurityFilingItemDetails_HsNoLink = "//a[@id='isfHsNoPopup']";
	public static final String OCR_ISFSecurityFilingItemDetails_HsNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_ISFSecurityFilingItemDetails_SearchHsNo = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_ISFSecurityFilingItemDetails_SelectHsNo = "//button[@id='slctBtn']";
	public static final String OCR_ISFSecurityFilingItemDetails_PartDescription = "//textarea[@id='editIsf10Items_importIsf10ItemsValue_partDescription']";
	public static final String OCR_ISFSecurityFilingItemDetails_ProductName = "//textarea[@id='editIsf10Items_importIsf10ItemsValue_productName']";
	public static final String OCR_ISFSecurityFilingItemDetails_CountryofOrigin = "//input[@id='editIsf10Items_importIsf10ItemsValue_countryOfOrigin']";
	public static final String OCR_ISFSecurityFilingItemDetails_UseSupplierManuf = "//select[@id='editIsf10Items_importIsf10ItemsValue_useSuplrOrMftr']";
	public static final String OCR_ISFSecurityFilingItemDetails_SaveAndReturn = "//button[@id='saveAndReturn']";
	public static final String OCR_ISFSecurityFilingItemDetails_Save = "//button[@id='save']";
	
	/* ******************** Constructor ***************************** */
	public ISFSecurityFilingItemDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Add Item Details
	public void addItem(String BillNoIt, String PartNo, String SourceSystemPartNumber, String ManufacturerPartNumber, String HSNo, String PartDescription,
						String ProductName, String CountryofOrigin, String UseSupplierManuf) {
		selectByVisibleText(driver, test, OCR_ISFSecurityFilingItemDetails_BillNo, "Select Bill No : ", BillNoIt);
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_PartNoLink, "Click on Part No Link");
			try {
				typeText(driver, test, OCR_ISFSecurityFilingItemDetails_PartNo, "Add Part No : ", PartNo);
				clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_SearchPopUp, "Click On Search");
				String Part = "//td[contains(text(),'" + PartNo + "')]";
				clickElement(driver, test, Part, "Select Part No : " + PartNo);
				clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_SelectPopUp, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Part No");
				clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_ClosePopUp, "Click on Close");
			}
		}
		typeText(driver, test, OCR_ISFSecurityFilingItemDetails_SourceSystemPartNumber, "Add Source System Part Number : ", SourceSystemPartNumber);
		typeText(driver, test, OCR_ISFSecurityFilingItemDetails_ManufacturerPartNumber, "Add Manufacturer Part Number : ", ManufacturerPartNumber);
		Wait.waitfor(3);
		if (HSNo.length() > 0) {
			clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_HsNoLink, "Click on Hs no Link");
			try {
				typeText(driver, test, OCR_ISFSecurityFilingItemDetails_HsNo, "Add HS no : ", HSNo);
				clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_SearchHsNo, "Click On Search");
				String Hs = "//div[contains(text(),'" + HSNo + "')]";
				Wait.waitfor(4);
				clickElement(driver, test, Hs, "Select Hs NO : " + HSNo);
				Wait.waitfor(4);
				clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_SelectHsNo, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Primary Hs No");
				clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_ClosePopUp, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_ISFSecurityFilingItemDetails_PartDescription, "Add Part Description : ", PartDescription);
		typeText(driver, test, OCR_ISFSecurityFilingItemDetails_ProductName, "Add Product Name : ", ProductName);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ISFSecurityFilingItemDetails_CountryofOrigin, "Add Country of Origin : ", CountryofOrigin);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ISFSecurityFilingItemDetails_UseSupplierManuf, "Select Use Supplier/Manuf : ", UseSupplierManuf);
	}
	
	//Click on Save & Return
	public void saveAndReturn() {
		clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_SaveAndReturn, "Click on Save and Return");
	}
	
	//Click on save
	public void clickSave() {
		clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_Save, "Click on Save");
	}
	
	//Validation Buyer Part No, HS No, Country of Origin
	public void validationISFPartNoHSNoCountryofOrigin() {
		clickElement(driver, test, OCR_ISFSecurityFilingItemDetails_Save, "Click on Save");
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Buyer Part No. is required')]")) {
					test.log(LogStatus.INFO, "Buyer Part No. is required");
				}
				if (isDisplayed(driver,"//li[contains(text(),'HS No. is required')]")) {
					test.log(LogStatus.INFO, "HS No. is required");
				} 
				if (isDisplayed(driver,"//li[contains(text(),'Country of Origin is required')]")) {
					test.log(LogStatus.INFO, "Country of Origin is required");
				} 
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Item Details for Security Filing (ISF)");
		}
	}
}
