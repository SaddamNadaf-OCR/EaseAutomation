package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewPackingListItemPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewPackingListItemPage_PartNoLink = "//a[contains(text(),'Part No.')]";
	public static final String OCR_CreateNewPackingListItemPage_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_CreateNewPackingListItemPage_PartNoSearchBtn = "//button[@class='primary-btn popupSearchButton']";
	public static final String OCR_CreateNewPackingListItemPage_PartNoSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewPackingListItemPage_SerialNo = "//textarea[@id='editPackinglistDetail_packinglistDetail_serialNo']";
	public static final String OCR_CreateNewPackingListItemPage_SaveBtn = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_CreateNewPackingListItemPage_SaveReturnBtn = "//button[@id='saveAndReturnBtn']";
	public static final String OCR_CreateNewPackingListItemPage_CancelBtn = "//button[@id='cancelBtn']";
	
	
	
	/* ******************************* Constructor ****************************** */

	public CreateNewPackingListItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void partNum(String partNo) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewPackingListItemPage_PartNoLink, "Click on part number link :");
		if(partNo.length() > 0) {
			typeText(driver, test, OCR_CreateNewPackingListItemPage_PartNo, "Enter part number : ", partNo);
			clickElement(driver, test, OCR_CreateNewPackingListItemPage_PartNoSearchBtn, "CLick on Search button :");
			clickElement(driver, test, "(//td[contains(text(),'"+ partNo +"')])[1]", partNo);
			clickElement(driver, test, OCR_CreateNewPackingListItemPage_PartNoSelectBtn, "Select the part number :");
		}
	}
	
	public void moreItemDetails(String SerialNum, String shipQty, String orderQty, String GrsWeight, String unit, String caseNum, String dimension) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewPackingListItemPage_SerialNo, "Enter Serial Number : ", SerialNum);
		typeText(driver, test, "//input[@id='editPackinglistDetail_packinglistDetail_shipQuantity']", "Enter Shiment Quantity : ", shipQty);
		typeText(driver, test, "//input[@id='editPackinglistDetail_packinglistDetail_orderQuantity']", "Enter Order Quantity : ", orderQty);
		typeText(driver, test, "//input[@id='editPackinglistDetail_packinglistDetail_grossWeight']", "Enter Gross Weight : ", GrsWeight);
		typeText(driver, test, "//input[@id='editPackinglistDetail_packinglistDetail_orderUnit']", "Enter unit : ", unit);
		typeText(driver, test, "//input[@id='editPackinglistDetail_packinglistDetail_caseNo']", "Enter Case number : ", caseNum);
		typeText(driver, test, "//input[@id='editPackinglistDetail_packinglistDetail_dimension']", "Enter Dimension : ", dimension);
		
	}
	
	public void saveBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewPackingListItemPage_SaveBtn, "Click on Save button :");
	}
	
	public void saveReturnBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewPackingListItemPage_SaveReturnBtn, "Click on Save and Return button :");
	}
	
	public void cancelBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewPackingListItemPage_CancelBtn, "Click on Cancel button :");
	}

}
