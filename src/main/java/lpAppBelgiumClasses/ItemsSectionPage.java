package lpAppBelgiumClasses;
/* 
 * Module : LP
 * Author  : Saddam
 * created date : April 2024
 * Descriptions : Add Item Section For General Form
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ItemsSectionPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//Locaters
	public static final String OCR_ItemSection_Save = "//input[@id='saveTopBtn']";
	public static final String OCR_ItemSection_SaveandReturn = "//input[@id='saveReturnTopBtn']";
	public static final String OCR_ItemSection_Cancel = "//input[@id='Cancel']";
	public static final String OCR_ItemSection_PartNo = "//a[contains(text(),'Part No.')]";
	public static final String OCR_ItemSection_PartNoTextBox = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ItemSection_SearchPopup = "(//button[@name='Search'])[2]";
	public static final String OCR_ItemSection_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_ItemSection_ClosePopup = "//button[@class='btn-close']";
	public static final String OCR_ItemSection_UnitOfMeasure = "//select[@id='uslicItemSave_authorisationItem_unitOfMeasure']";
	public static final String OCR_ItemSection_Quantity = "//input[@id='quantityId']";
	public static final String OCR_ItemSection_Description = "//textarea[@name='authorisationItem.description']";
	public static final String OCR_ItemSection_TyprOfModification = "//select[@id='uslicItemSave_authorisationItem_modifiedFlag']";
	public static final String OCR_ItemSection_SalesOrderNo = "//input[@id='salesOrderNo']";
	public static final String OCR_ItemSection_salesOrderLineItem = "//input[@id='salesOrderLineItem']";
	public static final String OCR_ItemSection_UnitValue = "//input[@id='unitValId']";
	public static final String OCR_ItemSection_Remark = "//textarea[@name='authorisationItem.remark']";
	public static final String OCR_ItemSection_Classification = "//input[@name='authorisationItem.prodClassification']";
	public static final String OCR_ItemSection_ClassificationLink = "(//a[contains(text(),'Classification')])[7]";
	public static final String OCR_ItemSection_ClassificationTextbox = "//input[@id='searchForm_ukItemsDTO_prodClassification']";
	public static final String OCR_ItemSection_ClassificationSearch = "(//button[@name='Search'])";
	public static final String OCR_ViewEditAuth_ItemsLabel = "//label[contains(text(),'Items')]";
	
	
	/* ******************** Constructor ***************************** */
	public ItemsSectionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_ItemSection_Save, "Clicking on Save Button :");
	}
	
	//Click on Save and Return Button
	public void saveandreturn() {
		clickElement(driver, test, OCR_ItemSection_SaveandReturn, "Clicking on Save and Return Button :");
	}
	
	//Click on CAncel Button
	public void cancel() {
		clickElement(driver, test, OCR_ItemSection_Cancel, "Clicking on Cancel Button :");
	}
	
	//Getting Data From Part No Link
	public void partNoLink(String PartNo, String UnitOfMeasure, String Quantity, String Description, String TypeOfModification, 
			String SalesOrderNo, String SalesOrderLineItemNo, String Classification, String UnitValue, String Remark) {
		Wait.waitfor(1);
		clickElement(driver, test, OCR_ViewEditAuth_ItemsLabel, "Clicking on Add Items Label :");
		Wait.waitfor(3);
		if(PartNo.length() > 0) {
			clickElement(driver, test, OCR_ItemSection_PartNo, "Clicking on Part No. :");
			try {
				typeText(driver, test, OCR_ItemSection_PartNoTextBox, "Entering Part No. :", PartNo);
				clickElement(driver, test, OCR_ItemSection_SearchPopup, "Clikcing on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ PartNo +"')]", "Selecting Part No :");
				clickElement(driver, test, OCR_ItemSection_SelectPopup, "Clicking on Select Button :");
				}catch(Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ItemSection_ClosePopup, "Clicking on Close Popup Icon :");
				}
			}else {
				typeText(driver, test, OCR_ItemSection_PartNoTextBox, "Entering Part No :", PartNo);
				selectByVisibleText(driver, test, OCR_ItemSection_UnitOfMeasure, "Selecting unit Of Measure :", UnitOfMeasure);
				typeText(driver, test, OCR_ItemSection_Quantity, "Entering Quantity :", Quantity);
				typeText(driver, test, OCR_ItemSection_Description, "Entering Description :", Description);
				selectByVisibleText(driver, test, OCR_ItemSection_TyprOfModification, "Selecting Type Of Modificatio :", TypeOfModification);
				typeText(driver, test, OCR_ItemSection_SalesOrderNo, "Entering Sales Order No :", SalesOrderNo);
				typeText(driver, test, OCR_ItemSection_salesOrderLineItem, "Enterinf Sales Order Line Item No :", SalesOrderLineItemNo);
				typeText(driver, test, OCR_ItemSection_Classification, "Entering Classofication :", Classification);
				typeText(driver, test, OCR_ItemSection_UnitValue, "Entering Unit value :", UnitValue);
				typeText(driver, test, OCR_ItemSection_Remark, "Entering Remark :", Remark);
			}
	}
	
	//Validating Items in the Grid
	public void itemGridDisplayed(String PartNo) {
		clickElement(driver, test, OCR_ViewEditAuth_ItemsLabel, "Clicking on Add Items Label :");
		Wait.waitfor(2);
		//Added Items are Displaying in Grid
				try {
					if(isDisplayed(driver, "//td[contains(text(),'"+PartNo+"')]")) {
						test.log(LogStatus.PASS, "Added Items is Displayed in Grid :");
					}
				}catch(Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Added Items is Not Displayed in Grid :");
				}
	}

}
