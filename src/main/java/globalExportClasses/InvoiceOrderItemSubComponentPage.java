package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class InvoiceOrderItemSubComponentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_InvoiceOrderItemSubComponentPage_AddSubCompBtn = "//button[contains(text(),'Add Sub Component')]";
	public static final String OCR_InvoiceOrderItemSubComponentPage_SubCompItemNo = "//input[@name='invoiceItemSubComp.subComponentLineItemNo']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_ContainerId = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_huNum']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_InvoiceOrderItemSubComponentPage_SubCompSaveReturnBtn = "(//button[@id='subCompSaveReturn'])[1]";
	public static final String OCR_InvoiceOrderItemSubComponentPage_SubComponentProdID = "//a[@id='productId-popup']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_SubComponentCloseBtn = "//button[@id='cancelInvoiceItem']";

	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentProdID = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_productNo']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentCoo = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_countryOfOriginName']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentSerialID = "//textarea[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_serialId']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentPrimQty = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_primaryQuantity']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentUnitPrice = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_unitPrice']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentProdDesc = "//textarea[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_productDesc']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_InvoiceOrderItemSubComponentPage_Regres_VehicleInfoDetails = "//a[contains(text(),'Vehicle Information')]";
	
	
	/* ******************************* Constructor ****************************** */

	public InvoiceOrderItemSubComponentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void addSubCompBtn() {
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_AddSubCompBtn,
				"Click on Add Sub Component button");
	}

	// add the sub components
	public void addOrderItemSubComp(String SubCompNo, String ParentProdID) {
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompItemNo, "Enter Sub Component Item No : ",
				SubCompNo);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentProdID,
				"Enter Subcomponent Parent Product ID : ", ParentProdID);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompSaveReturnBtn,
				"Click on Save and Return button");
		scrollToElement(driver, OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp, "Click on Close Icon");
	}

	// Add the sub components US
	public void addOrderItemSubCompUS(String SubCompNo, String ContainerId) {
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompItemNo, "Enter Sub Component Item No : ",
				SubCompNo);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_ContainerId, "Enter Subcomponent Container Id : ",
				ContainerId);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompSaveReturnBtn,
				"Click on Save and Return button");
		scrollToElement(driver, OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp, "Click on Close Icon");
	}

	// Add the sub components Regression US
	public void addOrderItemSubCompUS(String SubCompNo, String ContainerId, String ParentProdID, String SubCOO,
			String SerialID, String PrimQty, String SubUnitPrice, String SubProdDesc) {
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompItemNo, "Enter Sub Component Item No : ",
				SubCompNo);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_ContainerId, "Enter Subcomponent Container Id : ",
				ContainerId);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentProdID,
				"Enter Subcomponent Parent Product ID : ", ParentProdID);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentCoo,
				"Enter Country Of Origin : ", SubCOO);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentSerialID, "Enter Serial ID : ",
				SerialID);
		clearText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentPrimQty,
				"Clear Primary Quantity value");
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentPrimQty,
				"Enter Primary Quantity : ", PrimQty);
		clearText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentUnitPrice, "Clear Unit Price");
		Wait.waitfor(2);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentUnitPrice, "Enter Unit price : ",
				SubUnitPrice);
		typeText(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_SubComponentProdDesc, "Enter Product Description : ", SubProdDesc);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompSaveReturnBtn,
				"Click on Save and Return button");
		scrollToElement(driver, OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp);

		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubCompClosePopUp, "Click on Close Icon");
	}

	// Click on Close button
	public void closeSubCompBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_SubComponentCloseBtn,
				"Click on Close Button of Sub Component Page");
	}
	
	public void vehicleInfoDetails() {
		scrollToElement(driver, OCR_InvoiceOrderItemSubComponentPage_Regres_AdditionalTransactionDetails);
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_AdditionalTransactionDetails, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_InvoiceOrderItemSubComponentPage_Regres_VehicleInfoDetails, "Click on Vehicle Info Details");
		
	}

}
