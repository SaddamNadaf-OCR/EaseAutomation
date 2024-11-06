package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CargoReleaseLineItemPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ItemDetails_CommercialInvoiceNo = "//input[@id='editSeItems_importSeItemsValue_invoiceNo']";
	public static final String OCR_ItemDetails_InvoiceItemNolink = "//a[@id='invoiceItemNo']";
	public static final String OCR_ItemDetails_OrderNoLink = "//a[contains(text(),'Order No')]";
	public static final String OCR_ItemDetails_OrderNo = "//input[@id='resultOrderNoPopup_purchaseOrderItemDTO_poNo']";
	public static final String OCR_ItemDetails_Search = "//button[@name='Search']";
	public static final String OCR_ItemDetails_SearchHts = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_ItemDetails_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ItemDetails_Close = "//button[@class='close']";
	public static final String OCR_ItemDetails_OrderItemNo = "//input[@id='editSeItems_importSeItemsValue_poItemNo']";
	public static final String OCR_ItemDetails_PartNoLink = "//a[@id='partNo']";
	public static final String OCR_ItemDetails_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ItemDetails_SourceSystemPartNo = "//input[@id='editSeItems_importSeItemsValue_sourceSystemPartNo']";
	public static final String OCR_ItemDetails_ManufacturerPartNumber = "//input[@id='editSeItems_importSeItemsValue_manufacturerPartNo']";
	public static final String OCR_ItemDetails_CountryofOrigin = "//input[@id='editSeItems_importSeItemsValue_countryOfOrigin']";
	public static final String OCR_ItemDetails_PartDescription = "//textarea[@id='editSeItems_importSeItemsValue_partDesc']";
	public static final String OCR_ItemDetails_ManufSupplierLink = "//a[@id='manufPopup']";
	public static final String OCR_ItemDetails_RelatedPartyBox = "//input[@id='editSeItems_relatedPartyFlag']";
	public static final String OCR_ItemDetails_FTZMerchandiseStatus = "//select[@id='editSeItems_importSeItemsValue_zoneStatus']";
	public static final String OCR_ItemDetails_Qty = "//input[@id='editSeItems_quantity']";
	public static final String OCR_ItemDetails_UOM = "//input[@id='editSeItems_importSeItemsValue_uom']";
	public static final String OCR_ItemDetails_PrivilegedFTZMerchandiseFilingDate = "//input[@id='editSeItems_privFtzMerchFilingDate']";
	public static final String OCR_ItemDetails_CurrentFTZHSNolink = "//a[@id='impClassId1']";
	public static final String OCR_ItemDetails_HSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_ItemDetails_PrimaryHSNoLink = "//a[@id='impClassId']";
	public static final String OCR_ItemDetails_PrimaryValue = "//input[@id='editSeItems_value']";
	public static final String OCR_ItemDetails_SecondaryHsNoLink = "//a[@id='impClassId2']";
	public static final String OCR_ItemDetails_SecondaryValue = "//input[@id='editSeItems_secValue']";
	public static final String OCR_ItemDetails_Consignee = "//select[@id='editSeItems_importSeItemsValue_consigneeCode']";
	public static final String OCR_ItemDetails_Save = "//button[@name='save']";
	public static final String OCR_ItemDetails_SaveAndReturn = "//button[@name='ok']";
	public static final String OCR_ItemDetails_SelectHs = "//button[@id='slctBtn']";

	/* ******************** Constructor ***************************** */
	public CargoReleaseLineItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	public void addItems(String CommercialInvoiceNo, String InvoiceItemNo, String OrderNol, String OrderItemNo,
			String PartNo, String SourceSystemPartNo, String ManufacturerPartNumber, String CountryofOrigin,
			String PartDescription, String ManufSupplier, String FTZMerchandiseStatus, String Qtyl, String UOMl,
			String PrivilegedFTZMerchandiseFilingDate, String CurrentFTZHSNo, String PrimaryHSNo, String PrimaryValue,
			String SecondaryHsNo, String SecondaryValue, String ConsigneeItem) {
		typeText(driver, test, OCR_ItemDetails_CommercialInvoiceNo, "Add Commercial Invoide NO : ",
				CommercialInvoiceNo);
		Wait.waitfor(2);
		if (InvoiceItemNo.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_InvoiceItemNolink, "Click on Invoice ItemNo link");
			try {
				String InvoiceItems = "//td[contains(text(),'" + InvoiceItemNo + "')]";
				clickElement(driver, test, InvoiceItems, "Select Invoice Item No: " + InvoiceItemNo);
				clickElement(driver, test, OCR_ItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Invoice Item No");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		Wait.waitfor(2);
		if (OrderNol.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_OrderNoLink, "Click on OrderNo Link");
			try {
				typeText(driver, test, OCR_ItemDetails_OrderNo, "Add Order NO : ", OrderNol);
				clickElement(driver, test, OCR_ItemDetails_Search, "Click On Search");
				String Order = "//td[contains(text(),'" + OrderNol + "')]";
				clickElement(driver, test, Order, "Select Order No" + OrderNol);
				clickElement(driver, test, OCR_ItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Order No");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		typeText(driver, test, OCR_ItemDetails_OrderItemNo, "Add Order Item No : ", OrderItemNo);
		Wait.waitfor(2);
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_PartNoLink, "Click on Part No Link");
			try {
				typeText(driver, test, OCR_ItemDetails_PartNo, "Add PART NO : ", PartNo);
				clickElement(driver, test, OCR_ItemDetails_Search, "Click On Search");
				String Part = "//td[contains(text(),'" + PartNo + "')]";
				clickElement(driver, test, Part, "Select Order No" + PartNo);
				clickElement(driver, test, OCR_ItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Part NO");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		typeText(driver, test, OCR_ItemDetails_SourceSystemPartNo, "ADD SourceSystemPartNo : ", SourceSystemPartNo);
		typeText(driver, test, OCR_ItemDetails_ManufacturerPartNumber, "Add ManufacturerPartNumber",
				ManufacturerPartNumber);
		typeText(driver, test, OCR_ItemDetails_CountryofOrigin, "Add Country of Origin : ", CountryofOrigin);
		typeText(driver, test, OCR_ItemDetails_PartDescription, "Add Part Description : ", PartDescription);
		Wait.waitfor(2);

		if (ManufSupplier.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_ManufSupplierLink, "Click on Manuf/supplier link");
			try {
				String InvoiceItems = "//td[contains(text(),'" + ManufSupplier + "')]";
				clickElement(driver, test, InvoiceItems, "Select Manuf/supplier: " + ManufSupplier);
				clickElement(driver, test, OCR_ItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Manuf/supplier");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		selectByVisibleText(driver, test, OCR_ItemDetails_FTZMerchandiseStatus, "Add FTZ Merchandise Status : ",
				FTZMerchandiseStatus);
		typeText(driver, test, OCR_ItemDetails_Qty, "Add Quantity : ", Qtyl);
		typeText(driver, test, OCR_ItemDetails_UOM, "Add Unit of Measure : ", UOMl);
		typeText(driver, test, OCR_ItemDetails_PrivilegedFTZMerchandiseFilingDate,
				"Add Privileged FTZ Merchandise Filing Date : ", PrivilegedFTZMerchandiseFilingDate);
		Wait.waitfor(2);
		if (CurrentFTZHSNo.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_CurrentFTZHSNolink, "Click on Current FTZ Hs no Link");
			try {
				typeText(driver, test, OCR_ItemDetails_HSNo, "Add HS no : ", CurrentFTZHSNo);
				clickElement(driver, test, OCR_ItemDetails_SearchHts, "Click On Search");
				String HsNo = "//td[contains(text(),'" + CurrentFTZHSNo + "')]";
				clickElement(driver, test, HsNo, "Select Current FTZ Hs NO :" + CurrentFTZHSNo);
				clickElement(driver, test, OCR_ItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Current FTZ HS NO");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		Wait.waitfor(4);
		if (PrimaryHSNo.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_PrimaryHSNoLink, "Click on Primary Hs no Link");
			try {
				typeText(driver, test, OCR_ItemDetails_HSNo, "Add HS no : ", PrimaryHSNo);
				clickElement(driver, test, OCR_ItemDetails_SearchHts, "Click On Search");
				String PrimaryHsNo = "//div[contains(text(),'" + PrimaryHSNo + "')]";
				Wait.waitfor(4);
				clickElement(driver, test, PrimaryHsNo, "Select Primary Hs NO :" + PrimaryHSNo);
				Wait.waitfor(4);
				clickElement(driver, test, OCR_ItemDetails_SelectHs, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Primary Hs No");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemDetails_Save, "Click on save");
		typeText(driver, test, OCR_ItemDetails_PrimaryValue, "Add Primary Value : ", PrimaryValue);
		Wait.waitfor(2);
		if (SecondaryHsNo.length() > 0) {
			clickElement(driver, test, OCR_ItemDetails_SecondaryHsNoLink, "Click on Secondary Hs no Link");
			try {
				typeText(driver, test, OCR_ItemDetails_HSNo, "Add HS no : ", SecondaryHsNo);
				clickElement(driver, test, OCR_ItemDetails_SearchHts, "Click On Search");
				String secondaryHsNo = "//div[contains(text(),'" + SecondaryHsNo + "')]";
				clickElement(driver, test, secondaryHsNo, "Select Secondary Hs NO:" + SecondaryHsNo);
				clickElement(driver, test, OCR_ItemDetails_Select, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Secondary Hs No");
				clickElement(driver, test, OCR_ItemDetails_Close, "Click on Close");
			}
		}
		typeText(driver, test, OCR_ItemDetails_SecondaryValue, "Add Secondary Value : ", SecondaryValue);
		clickElement(driver, test, OCR_ItemDetails_Save, "Click on save");
		Wait.waitfor(4);
		selectByVisibleText(driver, test, OCR_ItemDetails_Consignee, "Select Consignee : ", ConsigneeItem);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemDetails_Save, "Click on save");
	}
		

	// Click on Save & Return
	public void saveandReturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemDetails_SaveAndReturn, "Click on save and return");
	}

	// Validation for Part No and Primary HS No

	public void validationPartNoHSNo() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Part No. is required')]")) {
					test.log(LogStatus.INFO, "Part No. is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Primary HS No. is required')]")) {
					test.log(LogStatus.INFO, "Primary HS No. is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Cargo Release Line Items Details");
		}
	}
}

