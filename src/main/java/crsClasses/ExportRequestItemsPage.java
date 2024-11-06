package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportRequestItemsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/************** Locators *******************************/

	public static final String OCR_ExportRequest_Items_AddItems = "//input[@id='addItemId']";
	public static final String OCR_ExportRequest_Items_PartNoLink = "html/body/div[2]/form/div[2]/div/div[8]/div/fieldset/div[1]/label[2]/a/b";
	public static final String OCR_ExportRequest_Items_PartNoTextBox = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ExportRequest_Items_PartNoSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_Items_PartNoSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_Items_QuantityTextBx = "//input[@id='editExportItem_exportItem_licenseQuantity']";
	public static final String OCR_ExportRequest_Items_UnitPrice = "//input[@id='editExportItem_unitPrice']";
	public static final String OCR_ExportRequest_Items_UNitTypeDropdwn = "//select[@id='editExportItem_exportItem_unitOfQuantity']";
	public static final String OCR_ExportRequest_Items_CommodityDescribtionTextBx = "//textarea[@id='editExportItem_exportItem_description']";
	public static final String OCR_ExportRequest_Items_ArticleTypeDropdwn = "//select[@id='editExportItem_exportItem_defenceArticleType']";
	public static final String OCR_ExportRequest_Items_OCRExportControl_EARClassificationLink = "//a[contains(text(),'EAR Classification')]";
	public static final String OCR_ExportRequest_Items_OCRExportControl_CommodityCodeLink = "//div[9]//div[1]//fieldset[1]//div[2]//label[1]";
	public static final String OCR_ExportRequest_Items_SalesOrderNoTextBx = "//input[@id='editExportItem_exportItem_salesOrderNo']";
	public static final String OCR_ExportRequest_Items_SalesOrderLineItemTextBx = "//input[@id='editExportItem_exportItem_salesOrderLineItem']";
	public static final String OCR_ExportRequest_Items_PurchaseOrderNoTextBx = "//input[@id='editExportItem_exportItem_purchaseOrderNo']";
	public static final String OCR_ExportRequest_Items_PurchaseOrderLineItemTextBox = "//input[@id='editExportItem_exportItem_purchaseOrderLineItem']";
	public static final String OCR_ExportRequest_Items_ContractNoTextBox = "//input[@id='editExportItem_exportItem_contractNo']";
	public static final String OCR_ExportRequest_Items_ContractLineItemTextBx = "//input[@id='editExportItem_exportItem_contractLineItem']";
	public static final String OCR_ExportRequest_Items_SourceSystemTextBx = "//input[@id='editExportItem_exportItem_sourceSystem']";
	public static final String OCR_ExportRequest_Items_SoucePartNoTextBox = "//input[@id='editExportItem_exportItem_sourcePartNo']";
	public static final String OCR_ExportRequest_Items_Remark1TextBox = "//textarea[@id='editExportItem_exportItem_remarks1']";
	public static final String OCR_ExportRequest_Items_Remark2TextBox = "//textarea[@id='editExportItem_exportItem_remarks2']";
	public static final String OCR_ExportRequest_Items_NotesTextBox = "//textarea[@id='editExportItem_exportItem_smeDsp83Desc']";
	public static final String OCR_ExportRequest_Items_saveBtn = "//input[@name='save']";
	public static final String OCR_ExportRequest_Items_CancelBtn = "//input[@name='Cancel.x']";
	public static final String OCR_ExportRequest_Items_SaveAndReturnBtn = "//input[@name='OK.x']";
	public static final String OCR_ExportRequest_Items_ClosePopUp = "//button[@class='close']";
	public static final String OCR_ExportRequest_Items_Parties = "//span[contains(text(),'Parties')]";
	public static final String OCR_ItemGrid = "//div[@id='gbox_gridPopup1']";

	/************************* constructor ***********************/
	public ExportRequestItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save button
	public void click_ItemSaveBtn() {
		clickElement(driver, test, OCR_ExportRequest_Items_saveBtn, "click on Save button");
	}

	// Click on Save and return button
	public void click_ItemSaveandReturn() {
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ExportRequest_Items_SaveAndReturnBtn, "click on save and return button");
	}

	// Adding the Items
	public void addItems(String PartNo, String Quantity, String UnitPrice, String UnitType, String ArticleType,
			String SalesOrderLineItem, String PurchaseOrderLineItem, String ContractNo, String ContractLineItem,
			String SourceSystem, String SourcePartNo, String Remark1, String Remark2, String Notes) {
		Wait.waitfor(10);
		clickElement(driver, test, OCR_ExportRequest_Items_PartNoLink, "click on Search Part No link");
		try {
			typeText(driver, test, OCR_ExportRequest_Items_PartNoTextBox, "Enter Part No : ", PartNo);
			clickElement(driver, test, OCR_ExportRequest_Items_PartNoSearchBtn, "Click on Search button");
			String partNo = "//td[contains(text(),'" + PartNo + "')]";
			clickElement(driver, test, partNo, "Select the Part No : " + PartNo);
			clickElement(driver, test, OCR_ExportRequest_Items_PartNoSelectBtn, "click on select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportRequest_Items_ClosePopUp, "click on Pop up close");
		}
		typeText(driver, test, OCR_ExportRequest_Items_QuantityTextBx, "Enter Quantity : ", Quantity);
		typeText(driver, test, OCR_ExportRequest_Items_UnitPrice, "Enter Unit Price", UnitPrice);
		selectByVisibleText(driver, test, OCR_ExportRequest_Items_UNitTypeDropdwn, "Select unit type : ", UnitType);
		selectByVisibleText(driver, test, OCR_ExportRequest_Items_ArticleTypeDropdwn, "Select Article Type : ",
				ArticleType);
		typeText(driver, test, OCR_ExportRequest_Items_SalesOrderLineItemTextBx, "Enter Sales Order Line Item : ",
				SalesOrderLineItem);
		typeText(driver, test, OCR_ExportRequest_Items_PurchaseOrderLineItemTextBox,
				"Enter Purchase Order Line Item : ", PurchaseOrderLineItem);
		typeText(driver, test, OCR_ExportRequest_Items_ContractNoTextBox, "Enter Contract No : ", ContractNo);
		typeText(driver, test, OCR_ExportRequest_Items_ContractLineItemTextBx, "Enter Contract Line Item : ",
				ContractLineItem);
		typeText(driver, test, OCR_ExportRequest_Items_SourceSystemTextBx, "Enter Source System : ", SourceSystem);
		typeText(driver, test, OCR_ExportRequest_Items_SoucePartNoTextBox, "Enter Source Part No : ", SourcePartNo);
		typeText(driver, test, OCR_ExportRequest_Items_Remark1TextBox, "Enter Remark1 : ", Remark1);
		typeText(driver, test, OCR_ExportRequest_Items_Remark2TextBox, "Enter Remark2 : ", Remark2);
		typeText(driver, test, OCR_ExportRequest_Items_NotesTextBox, "Enter Notes : ", Notes);
	}

	// Click on Cancle button
	public void click_CancleItemBtn() {
		clickElement(driver, test, OCR_ExportRequest_Items_CancelBtn, "Click on Cancle button in Add Items");
	}

	// Validation in items details
	public void validateItems() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Commodity Description is required')]")) {
					test.log(LogStatus.INFO, "Commodity Description is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Quantity is required')]")) {
					test.log(LogStatus.INFO, "Quantity is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Unit Price is required')]")) {
					test.log(LogStatus.INFO, "Unit Price is required");
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
}
