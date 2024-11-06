package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CargoReleasePartyDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_PartyDeatils_OrderNoLink = "//a[contains(text(),'Order No')]";
	public static final String OCR_PartyDeatils_OrderNo = "//input[@id='resultOrderNoPopup_purchaseOrderItemDTO_poNo']";
	public static final String OCR_PartyDeatils_Search = "//button[@name='Search']";
	public static final String OCR_PartyDeatils_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_PartyDeatils_PartyType = "//select[@id='partyTypeSelect']";
	public static final String OCR_PartyDeatils_PartyCodeLink = "//a[@id='partyPopup']";
	public static final String OCR_PartyDeatils_BrokerID = "//input[@id='searchForm_broker_brokerId']";
	public static final String OCR_PartyDeatils_ImporterCode = "//input[@id='searchForm_importer_importerCode']";
	public static final String OCR_PartyDeatils_ConsigneeIdCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_PartyDeatils_VendorCode = "//input[@id='searchForm_vendor_vendorCode']";
	public static final String OCR_PartyDeatils_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_PartyDeatils_Save = "//form[@id='editSimplifiedEntryParties']//button[1]";
	public static final String OCR_PartyDeatils_ClosePopup = "//button[@class='close']";
	public static final String OCR_PartyDeatils_AddContactName = "//input[@id='editSimplifiedEntryParties_importSePartiesValue_contactName']";
	public static final String OCR_PartyDeatils_AddContactPhone = "//input[@id='editSimplifiedEntryParties_importSePartiesValue_contactPhone']";

	/* ******************** Constructor ***************************** */
	public CargoReleasePartyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Add Order No
	public void addOrderNo(String OrderNo) {
		if (OrderNo.length() > 0) {
			clickElement(driver, test, OCR_PartyDeatils_OrderNoLink, "Click on order no link");
			try {
				typeText(driver, test, OCR_PartyDeatils_OrderNo, "Add Order no : ", OrderNo);
				clickElement(driver, test, OCR_PartyDeatils_Search, "Click On Search");
				String SGNTemp = "//td[contains(text(),'" + OrderNo + "')]";
				clickElement(driver, test, SGNTemp, "Select SGN Templates: " + OrderNo);
				clickElement(driver, test, OCR_PartyDeatils_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Order No");
				clickElement(driver, test, OCR_PartyDeatils_ClosePopup, "Click on Close");
			}
		}
	}

	// Add Importer From PopUp
	public void addImporter(String ImporterCode) {
		clickElement(driver, test, OCR_PartyDeatils_PartyCodeLink, "Click on Party Code");
		try {
			typeText(driver, test, OCR_PartyDeatils_ImporterCode, "Add Importer Code : ", ImporterCode);
			clickElement(driver, test, OCR_PartyDeatils_Search, "Click On Search");
			String SGNTemp = "//td[contains(text(),'" + ImporterCode + "')]";
			clickElement(driver, test, SGNTemp, "Select SGN Templates: " + ImporterCode);
			clickElement(driver, test, OCR_PartyDeatils_Select, "Click on select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to ADD Importer");
			clickElement(driver, test, OCR_PartyDeatils_ClosePopup, "Click on Close");
		}
	}

	// Add Consignee PopUp
	public void addConsignee(String ConsigneeIdCode) {
		clickElement(driver, test, OCR_PartyDeatils_PartyCodeLink, "Click on Party Code");
		try {
			typeText(driver, test, OCR_PartyDeatils_ConsigneeIdCode, "Add Consignee Code/ID : ", ConsigneeIdCode);
			clickElement(driver, test, OCR_PartyDeatils_Search, "Click On Search");
			String SGNTemp = "//td[contains(text(),'" + ConsigneeIdCode + "')]";
			clickElement(driver, test, SGNTemp, "Select SGN Templates: " + ConsigneeIdCode);
			clickElement(driver, test, OCR_PartyDeatils_Select, "Click on select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to ADD Consignee");
			clickElement(driver, test, OCR_PartyDeatils_ClosePopup, "Click on Close");
		}
	}

	// Add Vendor Popup
	public void addVendor(String VendorCode) {
		clickElement(driver, test, OCR_PartyDeatils_PartyCodeLink, "Click on Party Code");
		try {
			typeText(driver, test, OCR_PartyDeatils_VendorCode, "Add Vendor Code : ", VendorCode);
			clickElement(driver, test, OCR_PartyDeatils_Search, "Click On Search");
			String SGNTemp = "//td[contains(text(),'" + VendorCode + "')]";
			clickElement(driver, test, SGNTemp, "Select SGN Templates: " + VendorCode);
			clickElement(driver, test, OCR_PartyDeatils_Select, "Click on select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to ADD Vendor");
			clickElement(driver, test, OCR_PartyDeatils_ClosePopup, "Click on Close");
		}
	}

	// Click on Save & Return
	public void saveandReturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_PartyDeatils_SaveAndReturn, "Click on save and return");
	}

	// Add Party Details
	public void addImporterOfRecord(String PartyType) {
		selectByVisibleText(driver, test, OCR_PartyDeatils_PartyType, "select party type : ", PartyType);
	}

	// Add Contact Name AND Contact Phone
	public void addContactNameAndPhone(String ContactName, String ContactPhone) {
		typeText(driver, test, OCR_PartyDeatils_AddContactName, "Add Contact Name : ", ContactName);
		typeText(driver, test, OCR_PartyDeatils_AddContactPhone, "Add Contact Phone : ", ContactPhone);
	}

}
