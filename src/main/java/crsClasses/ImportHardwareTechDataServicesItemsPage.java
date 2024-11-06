package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ImportHardwareTechDataServicesItemsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Items_SavBtn = "//input[@name='save']";
	public static final String OCR_Items_SaveAndReturnBtn = "//input[@id='okItem']";
	public static final String OCR_Items_SearchPartNoLink = "//b[contains(text(),'Search Part No')]";
	public static final String OCR_Items_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_Items_Quantity = "//input[@id='editExportItem_exportItem_licenseQuantity']";
	public static final String OCR_Items_UnitPrice = "//input[@id='editExportItem_unitPrice']";
	public static final String OCR_Items_UnitType = "//select[@id='editExportItem_exportItem_unitOfQuantity']";
	public static final String OCR_Items_CommodityDescription = "//textarea[@id='editExportItem_exportItem_description']";
	public static final String OCR_Items_CommodityClasLink = "//a[contains(text(),'Commodity classification :')]";
	public static final String OCR_Items_ECCN_USML = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_Items_SearchBtn = "//button[@name='Search']";
	public static final String OCR_Items_SelectBtn = "//div[@id='resultDIV']//button[1]";
	public static final String OCR_Items_ArticleType = "//select[@id='editExportItem_exportItem_defenceArticleType']";
	public static final String OCR_Items_SalesOrderNo = "//input[@id='editExportItem_exportItem_salesOrderNo']";
	public static final String OCR_Items_PurchaseOrderNo = "//input[@id='editExportItem_exportItem_purchaseOrderNo']";
	public static final String OCR_Items_ContractNo = "//input[@id='editExportItem_exportItem_contractNo']";
	public static final String OCR_Items_SourceSystem = "//input[@id='editExportItem_exportItem_sourceSystem']";
	public static final String OCR_Items_SalesOrderLineItem = "//input[@id='editExportItem_exportItem_salesOrderLineItem']";
	public static final String OCR_Items_PurchaseOrderLineItem = "//input[@id='editExportItem_exportItem_purchaseOrderLineItem']";
	public static final String OCR_Items_ContractLineItem = "//input[@id='editExportItem_exportItem_contractLineItem']";
	public static final String OCR_Items_SourcePartNo = "//input[@id='editExportItem_exportItem_sourcePartNo']";
	public static final String OCR_Items_Remark1 = "//textarea[@id='editExportItem_exportItem_remarks1']";
	public static final String OCR_Items_Remark2 = "//textarea[@id='editExportItem_exportItem_remarks2']";
	public static final String OCR_Items_Notes = "//textarea[@id='editExportItem_exportItem_smeDsp83Desc']";
	public static final String OCR_Items_PopUpClose = "//button[@class='close']";
	public static final String OCR_Items_CancleBtn = "//input[@name='Cancel.x']";

	/* ******************** Constructor ***************************** */

	public ImportHardwareTechDataServicesItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save button
	public void click_ItemSaveBtn() {
		clickElement(driver, test, OCR_Items_SavBtn, "click on Save button");
	}

	// Click on Save and return button
	public void click_ItemSaveAndReturnBtn() {
	//	scrollToElement(driver, "OCR_Items_SaveAndReturnBtn");
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Items_SaveAndReturnBtn, "Clicking on Save And Return Button");
	}

	// Adding Hardware/ Tech Data/ Services Items
	public void addItem(String PartNo, String Quantity, String UnitPrice, String UnitType, String CommodityDescription,
			String CommodityClassification, String CommodityCode, String ArticleType, String SalesOrderLineItem,
			String PurchaseOrderLineItem, String ContractNo, String ContractLineItem, String SourceSystem,
			String SourcePartNo, String Remark1, String Remark2, String Notes) {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Items_SearchPartNoLink, "click on Search Part No link");
		try {
			typeText(driver, test, OCR_Items_PartNo, "Enter Part No : ", PartNo);
			clickElement(driver, test, OCR_Items_SearchBtn, "Click on Search button");
			String partNo = "//td[contains(text(),'" + PartNo + "')]";
			clickElement(driver, test, partNo, "Select the Part No : " + PartNo);
			clickElement(driver, test, OCR_Items_SelectBtn, "click on select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Items_PopUpClose, "click on Pop up close");
		}

		typeText(driver, test, OCR_Items_Quantity, "Enter Quantity : ", Quantity);
		typeText(driver, test, OCR_Items_UnitPrice, "Enter Unit Price : ", UnitPrice);
		selectByVisibleText(driver, test, OCR_Items_UnitType, "Select unit type : ", UnitType);
		typeText(driver, test, OCR_Items_CommodityDescription, "Enter Commodity Description : ", CommodityDescription);
		if (CommodityClassification.length() > 0) {
			clickElement(driver, test, OCR_Items_CommodityClasLink, "Click on Commodity Classification Link");
			try {
				String productClass = "//td[contains(text(),'" + CommodityClassification + "')]";
				typeText(driver, test, OCR_Items_ECCN_USML, "Enter ECCN/USML : ", CommodityClassification);
				clickElement(driver, test, OCR_Items_SearchBtn, "Click on product search button");
				clickElement(driver, test, productClass, "Select the ECCN/USML : " + CommodityClassification);
				clickElement(driver, test, OCR_Items_SelectBtn, "click on product select button");
				Wait.waitfor(3);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Items_PopUpClose, "click on Pop up close");
			}
		}
		selectByVisibleText(driver, test, OCR_Items_ArticleType, "Select Article Type : ", ArticleType);
		typeText(driver, test, OCR_Items_SalesOrderLineItem, "Enter Sales Order Line Item : ", SalesOrderLineItem);
		typeText(driver, test, OCR_Items_PurchaseOrderLineItem, "Enter Purchase Order Line Item : ",PurchaseOrderLineItem);
		typeText(driver, test, OCR_Items_ContractNo, "Enter Contract No : ", ContractNo);
		typeText(driver, test, OCR_Items_ContractLineItem, "Enter Contract Line Item : ", ContractLineItem);
		typeText(driver, test, OCR_Items_SourceSystem, "Enter Source System : ", SourceSystem);
		typeText(driver, test, OCR_Items_SourcePartNo, "Enter Source Part No : ", SourcePartNo);
		typeText(driver, test, OCR_Items_Remark1, "Enter Remark1 : ", Remark1);
		typeText(driver, test, OCR_Items_Remark2, "Enter Remark2 : ", Remark2);
		scrollToBottom(driver);
		typeText(driver, test, OCR_Items_Notes, "Enter Notes : ", Notes);
		scrollToTop(driver);
	}

	// Error message in Add Items
	public void validationAddItems() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Commodity Description is required')]")) {
					test.log(LogStatus.INFO, "Commodity Description is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Quantity is required')]")) {
					test.log(LogStatus.INFO, "Quantity is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Unit Type is required')]")) {
					test.log(LogStatus.INFO, "Unit Type is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Add Items");
		}
	}

	// Click on Cancle button
	public void click_CancleItemBtn() {
		clickElement(driver, test, OCR_Items_CancleBtn, "Click on Cancle button in Add Items");
	}

}
