package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewOrderItemSubComponentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ItemSubComp_AddSubComponent = "//button[@class='primary-btn inv-item-subComp']";
	public static final String OCR_ItemSubComp_SubcomponentItemNo = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_subComponentLineItemNo']";
	public static final String OCR_ItemSubComp_ProductIdLink = "//a[contains(text(),'Product Id')]";
	public static final String OCR_ItemSubComp_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ItemSubComp_PopUpClose = "//form[@id='stdSubcomponentItemNo']//button[@class='close']";
	public static final String OCR_ItemSubComp_PopUpSaveAndReturn = "//button[@id='subCompSaveReturn']";
	public static final String OCR_ItemSubComp_Close = "//button[@id='cancelInvoiceItem']";
	
	public static final String OCR_ItemSubComp_SubCompItemNo = "//input[@name='invoiceItemSubComp.subComponentLineItemNo']";
	public static final String OCR_ItemSubComp_ContainerId = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_huNum']";
	public static final String OCR_ItemSubComp_SubCompClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ItemSubComp_SubCompSaveReturnBtn = "(//button[@id='subCompSaveReturn'])[1]";
	public static final String OCR_ItemSubComp_SubComponentProdID = "//a[@id='productId-popup']";
	public static final String OCR_ItemSubComp_SubComponentCloseBtn = "//button[@id='cancelInvoiceItem']";

	public static final String OCR_ItemSubComp_Regres_SubComponentProdID = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_productNo']";
	public static final String OCR_ItemSubComp_Regres_SubComponentCoo = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_countryOfOriginName']";
	public static final String OCR_ItemSubComp_Regres_SubComponentSerialID = "//textarea[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_serialId']";
	public static final String OCR_ItemSubComp_Regres_SubComponentPrimQty = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_primaryQuantity']";
	public static final String OCR_ItemSubComp_Regres_SubComponentUnitPrice = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_unitPrice']";
	public static final String OCR_ItemSubComp_Regres_SubComponentProdDesc = "//textarea[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_productDesc']";

	public static final String OCR_ItemSubComp_Regres_AdditionalTransaction = "//i[@class='fa fa-th']";
	public static final String OCR_ItemSubComp_Regres_VehicleInfo = "//a[contains(text(),'Vehicle Information')]";
	
	/* ******************************* Constructor ****************************** */

	public CreateNewOrderItemSubComponentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Add sub component
	public void click_AddSubComponent() {
		clickElement(driver, test, "//span[@class='heading-additional']", "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemSubComp_AddSubComponent, "Click on  Add Sub Component ");
	}

	// Add order item sub component
	public void addOrderItemSubComponent(String SubcomponentItemNo, String ProductNo) {
		if (SubcomponentItemNo.length() > 0) {
			clickElement(driver, test, OCR_ItemSubComp_AddSubComponent, "Click on  Add Sub Component ");
			try {
				typeText(driver, test, OCR_ItemSubComp_SubcomponentItemNo, "Enter the Sub Component Item No : ",
						SubcomponentItemNo);
				clickElement(driver, test, OCR_ItemSubComp_ProductIdLink, "Click on Product Id Link");
				clickElement(driver, test, "//td[contains(text(),'" + ProductNo + "')]",
						"Select the ProductNo : " + ProductNo);
				clickElement(driver, test, OCR_ItemSubComp_Select, "Click on Select");
				clickElement(driver, test, OCR_ItemSubComp_PopUpSaveAndReturn,
						"Click on Sub component Save and return");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ItemSubComp_PopUpClose, "Click on Pop Up close icon");
			}
		}
	}
	
	// Add the sub components Regression US
		public void addOrderItemSubCompUS(String SubCompNo, String ContainerId, String ParentProdID, String SubCOO,
				String SerialID, String PrimQty, String SubUnitPrice, String SubProdDesc) {
			typeText(driver, test, OCR_ItemSubComp_SubCompItemNo, "Enter Sub Component Item No : ",
					SubCompNo);
			typeText(driver, test, OCR_ItemSubComp_ContainerId, "Enter Subcomponent Container Id : ",
					ContainerId);
			typeText(driver, test, OCR_ItemSubComp_SubComponentProdID,
					"Enter Subcomponent Parent Product ID : ", ParentProdID);
			typeText(driver, test, OCR_ItemSubComp_Regres_SubComponentCoo,
					"Enter Country Of Origin : ", SubCOO);
			typeText(driver, test, OCR_ItemSubComp_Regres_SubComponentSerialID, "Enter Serial ID : ",
					SerialID);
			clearText(driver, test, OCR_ItemSubComp_Regres_SubComponentPrimQty,
					"Clear Primary Quantity value");
			Wait.waitfor(2);
			typeText(driver, test, OCR_ItemSubComp_Regres_SubComponentPrimQty,
					"Enter Primary Quantity : ", PrimQty);
			clearText(driver, test, OCR_ItemSubComp_Regres_SubComponentUnitPrice, "Clear Unit Price");
			Wait.waitfor(2);
			typeText(driver, test, OCR_ItemSubComp_Regres_SubComponentUnitPrice, "Enter Unit price : ",
					SubUnitPrice);
			typeText(driver, test, OCR_ItemSubComp_Regres_SubComponentProdDesc, "Enter Product Description : ", SubProdDesc);
			clickElement(driver, test, OCR_ItemSubComp_SubCompSaveReturnBtn,
					"Click on Save and Return button");
			scrollToElement(driver, OCR_ItemSubComp_SubCompClosePopUp);

			clickElement(driver, test, OCR_ItemSubComp_SubCompClosePopUp, "Click on Close Icon");
		}


	// Click on Close button
	public void click_CloseBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemSubComp_Close, "Click on Close button");
	}
	
	//click on Save button
	public void click_SaveAndReturnBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ItemSubComp_PopUpSaveAndReturn, "Click on Save button in Sub Component");
	}
	
	//navigate to Additional Transaction Details
	public void navigateVehicleInfo() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_ItemSubComp_Regres_AdditionalTransaction);
		clickElement(driver, test, OCR_ItemSubComp_Regres_AdditionalTransaction, "Click on Additional Transaction Details :");
		clickElement(driver, test, OCR_ItemSubComp_Regres_VehicleInfo, "Click on Vehicle Information :");
	}
	
	//validate the sub component 
	public void validateSubComponent() {
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please enter Sub Component Item No')]")) {
					test.log(LogStatus.INFO, "Please enter Sub Component Item No");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please enter HU No/Container Id')]")) {
					test.log(LogStatus.INFO, "Please enter parent product id");
				}
				Wait.waitfor(3);
				clickElement(driver, test, "//div[@id='ocrModal']//button[@class='btn-close']", "Click on Pop Up close");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Add Order Item Sub Component");
			clickElement(driver, test, "//div[@id='ocrModal']//button[@class='btn-close']", "Click on Pop Up close");
		}
	}

}
