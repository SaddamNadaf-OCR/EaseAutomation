package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportGoodsListUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/****************************** Locators ***************************/

	public static final String OCR_ExportGoodsListTab = "//i[@id='AUTH_ITEM']";
	public static final String OCR_ExportGoodsList_AddItemBtn = "//button[@id='itemButton']";
	public static final String OCR_ExportGoodsList_PartNoLink = "//a[contains(text(),'Part No.')]";
	public static final String OCR_ExportGoodsList_PartNoGoodQuantityMeasure = "//select[@id='unitOfMeasure']";
	public static final String OCR_ExportGoodsList_PartNoGoodsVaue = "//input[@id='editExportGoodsList_authorisationItem_licenseValue']";
	public static final String OCR_ExportGoodsList_Items = "//textarea[@id='editExportGoodsList_authorisationItem_description']";
	public static final String OCR_ExportGoodsList_PartNoGoodsQuantity = "//input[@id='quantityId']";
	public static final String OCR_ExportGoodsList_PartNoField = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ExportGoodsList_PartNoSearchBtn = "//div[@id='content-cont']//div[@id='searchDIV']//button[2]";
	public static final String OCR_ExportGoodsList_PartNoSelectBtn = "//div[@id='content-cont']//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportGoodsList_PartNoSaveandReturnBtn = "//button[@id='saveAndReturn']";
	public static final String OCR_ExportGoodsList_PartNoSaveBtn = "//button[@id='save']";
	public static final String OCR_ExportGoodsList_PartNoAddMoreBtn = "//button[@id='AddMore']";
	public static final String OCR_ExportGoodsList_SaveBtn = "//button[@id='submitItem']";
	public static final String OCR_ExportGoodsList_FurtherDetailsOnItems = "//label[contains(text(),'Further Details on the Items, Their Use and Origin')]";
	public static final String OCR_ExportGoodsList_GeneralGoodDescriptionBox = "//textarea[@id='editExportGoodsDetails_authorisationHeaderValue_genGoodsDesc']";
	public static final String OCR_ExportGoodsList_NatureOfGoodsIcon = "//i[@id='NATURE_OF_GOODS']";
	public static final String OCR_ExportGoodsList_CancelPopup = "(//button[@class='btn-close'])[1]";

	/******************************* Constructor *******************************/
	public ExportGoodsListUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*************************** Actions ***************************************/

	public void clickOnExportGoodsListTab() {
		clickElement(driver, test, OCR_ExportGoodsListTab, "Click on Export Goods List Tab");
	}

	public void clickItemBtn() {
		clickElement(driver, test, OCR_ExportGoodsList_AddItemBtn, "Click on Add Item Button");
	}

	public void addItem(String ExportPartNo, String ExportQuantyMeasure, String ExportGoodsQuantity,
			String ExportGoodsValue, String ExportItems) {
		Wait.waitfor(3);
		try {
			clickElement(driver, test, OCR_ExportGoodsList_PartNoLink, "Click on PartNo link");
			searchProductPopUp(ExportPartNo);
			selectByVisibleText(driver, test, OCR_ExportGoodsList_PartNoGoodQuantityMeasure, "Select Quantity Measure ",
					ExportQuantyMeasure);
			typeText(driver, test, OCR_ExportGoodsList_PartNoGoodsQuantity, "Add Goods Quantity : ",
					ExportGoodsQuantity);
			typeText(driver, test, OCR_ExportGoodsList_PartNoGoodsVaue, "Add Goods Value : ", ExportGoodsValue);
			typeText(driver, test, OCR_ExportGoodsList_Items, "Add Goods Value :  ", ExportItems);
			clickElement(driver, test, OCR_ExportGoodsList_PartNoSaveandReturnBtn,
					"Click on Save and Return Button of Add Item");
			Wait.waitfor(5);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportGoodsList_CancelPopup, "click on pop close");
		}
	}

	public void searchProductPopUp(String ExportPartNo) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_ExportGoodsList_PartNoField, "Enter Export PartNo : ", ExportPartNo);
		clickElement(driver, test, OCR_ExportGoodsList_PartNoSearchBtn, "click on Search Button");
		Wait.waitfor(3);
		String part = "//td[contains(text(),'" + ExportPartNo + "')]";
		clickElement(driver, test, part, "Selected Part No. : " + ExportPartNo);
		clickElement(driver, test, OCR_ExportGoodsList_PartNoSelectBtn, "click on select button");
		Wait.waitfor(2);
	}

	public void addGeneralDescBox(String ExportDescBox) {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_ExportGoodsList_FurtherDetailsOnItems, "click on scroll bar");
		typeText(driver, test, OCR_ExportGoodsList_GeneralGoodDescriptionBox, "Add data to General Desc Box : ",
				ExportDescBox);
	}

	public void saveExportsGoodList() {
		clickElement(driver, test, OCR_ExportGoodsList_SaveBtn, "Click on Save Button");
	}

	public void clickOnNatureofGoodsIcon() {
		clickElement(driver, test, OCR_ExportGoodsList_NatureOfGoodsIcon, "click on Nature of Goods Icon");
	}

	// validations in Export Goods List Tab
	public void validateExportGoodsListError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportGoodsList_PartNoSaveandReturnBtn, "Click on Save and Return");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//div[@id='error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()=' Goods Quantity is required and must be greater than Zero']")) {
					test.log(LogStatus.INFO, "Goods Quantity is required and must be greater than Zero");
				}
				if (isDisplayed(driver, "//li[text()=' Goods Value is required']")) {
					test.log(LogStatus.INFO, "Goods Value is required");
				}
				if (isDisplayed(driver, "//li[text()=' Goods Quantity is required']")) {
					test.log(LogStatus.INFO, "Goods Quantity is required");
				}
				if (isDisplayed(driver, "//li[text()=' Goods Quantity Measure  is required']")) {
					test.log(LogStatus.INFO, "Goods Quantity Measure  is required");
				}
				if (isDisplayed(driver, "//li[text()=' Item(s) cannot be blank']")) {
					test.log(LogStatus.INFO, "Item(s) cannot be blank");
				}
				clickElement(driver, test, OCR_ExportGoodsList_CancelPopup, "Close Good Recipient Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_ExportGoodsList_CancelPopup, "Close Good Recipient Pop up");
		}
	}
}
