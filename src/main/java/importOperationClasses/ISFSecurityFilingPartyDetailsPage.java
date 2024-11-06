package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ISFSecurityFilingPartyDetailsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_SecurityFilingPartyDetails_ImportOrderNoLink = "//a[@id='importOrderNoPopup']";
	public static final String OCR_SecurityFilingPartyDetails_OrderNo = "//input[@id='resultOrderNoPopup_purchaseOrderItemDTO_poNo']";
	public static final String OCR_SecurityFilingPartyDetails_SearchPopUp = "//button[@name='Search']";
	public static final String OCR_SecurityFilingPartyDetails_SelectPopUp = "//button[contains(text(),'Select')][1]";
	public static final String OCR_SecurityFilingPartyDetails_ClosePopUp = "//button[@class='close']";
	public static final String OCR_SecurityFilingPartyDetails_PartyType = "//select[@id='partyTypeSelect']";
	public static final String OCR_SecurityFilingPartyDetails_PartyCode = "//a[@id='isfPartyPopup']";
	public static final String OCR_SecurityFilingPartyDetails_VendorCode = "//input[@id='searchForm_vendor_vendorCode']";
	public static final String OCR_SecurityFilingPartyDetails_ImporterCode = "//input[@id='searchForm_importer_importerCode']";
	public static final String OCR_SecurityFilingPartyDetails_Save = "//button[@id='save']";
	public static final String OCR_SecurityFilingPartyDetails_SaveandReturn = "//button[@id='saveAndReturn']";
	
	/* ******************** Constructor ***************************** */
	public ISFSecurityFilingPartyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Add Import Order No
	public void addimportOrderNo(String OrderNo) {
		Wait.waitfor(3);
		if (OrderNo.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingPartyDetails_ImportOrderNoLink , "Click on order no link");
			try {
				typeText(driver, test, OCR_SecurityFilingPartyDetails_OrderNo, "Add Order no : ", OrderNo);
				clickElement(driver, test, OCR_SecurityFilingPartyDetails_SearchPopUp, "Click On Search");
				String Order = "//td[contains(text(),'" + OrderNo + "')]";
				clickElement(driver, test, Order, "Select Order : " + OrderNo);
				clickElement(driver, test, OCR_SecurityFilingPartyDetails_SelectPopUp, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Order No");
				clickElement(driver, test, OCR_SecurityFilingPartyDetails_ClosePopUp, "Click on Close");
			}
		}
	}
	
	// Add Importer From PopUp
	public void addImporter(String ImporterCode) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SecurityFilingPartyDetails_PartyCode, "Click on Party Code");
		try {
			typeText(driver, test, OCR_SecurityFilingPartyDetails_ImporterCode, "Add Importer Code : ", ImporterCode);
			clickElement(driver, test, OCR_SecurityFilingPartyDetails_SearchPopUp, "Click On Search");
			String Imp = "//td[contains(text(),'" + ImporterCode + "')]";
			clickElement(driver, test, Imp, "Select Importer : " + ImporterCode);
			clickElement(driver, test, OCR_SecurityFilingPartyDetails_SelectPopUp, "Click on select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to ADD Importer");
			clickElement(driver, test, OCR_SecurityFilingPartyDetails_ClosePopUp, "Click on Close");
		}
	}
	
	// Add Vendor PopUup
	public void addVendor(String VendorCode) {
		clickElement(driver, test, OCR_SecurityFilingPartyDetails_PartyCode, "Click on Party Code");
		try {
			typeText(driver, test, OCR_SecurityFilingPartyDetails_VendorCode, "Add Vendor Code : ", VendorCode);
			clickElement(driver, test, OCR_SecurityFilingPartyDetails_SearchPopUp, "Click On Search");
			String Vdr = "//td[contains(text(),'" + VendorCode + "')]";
			clickElement(driver, test, Vdr, "Select Vendor : " + VendorCode);
			clickElement(driver, test, OCR_SecurityFilingPartyDetails_SelectPopUp, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Vendor");
				clickElement(driver, test, OCR_SecurityFilingPartyDetails_ClosePopUp, "Click on Close");
			}
		}
		
	//Click on Save & Return
	public void saveandReturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SecurityFilingPartyDetails_SaveandReturn, "Click on save and return");
	}

	// Add Party Details
	public void addImporterOfRecord(String PartyType) {
		selectByVisibleText(driver, test, OCR_SecurityFilingPartyDetails_PartyType, "select party type : ", PartyType);
	}
}
