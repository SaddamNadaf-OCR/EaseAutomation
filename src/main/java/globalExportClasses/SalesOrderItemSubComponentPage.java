package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SalesOrderItemSubComponentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SalesOrderItemSubComponentPage_AddSubCompBtn = "//button[contains(text(),'Add Sub Component')]";
	public static final String OCR_SalesOrderItemSubComponentPage_SubCompItemNo = "//input[@name='invoiceItemSubComp.subComponentLineItemNo']";
	public static final String OCR_SalesOrderItemSubComponentPage_ContainerID = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_huNum']";
	public static final String OCR_SalesOrderItemSubComponentPage_SubCompClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SalesOrderItemSubComponentPage_SubCompSaveReturnBtn = "(//button[@id='subCompSaveReturn'])[1]";
	public static final String OCR_SalesOrderItemSubComponentPage_SubComponentProdID = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_productNo']";
	public static final String OCR_SalesOrderItemSubComponentPage_SubComponentCloseBtn = "//button[@id='cancelInvoiceItem']";
	public static final String OCR_SalesOrderItemSubComponentPage_SubComponentProdIDUS = "//input[@id='editTabbedInvoiceSubItem_invoiceItemSubComp_productNo']";

	/* ******************************* Constructor ****************************** */

	public SalesOrderItemSubComponentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void addSubCompBtn() {
		clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_AddSubCompBtn,
				"Click on Add Sub Component button");
	}

	public void addOrderItemSubComp(String SubCompNo, String ParentProdID) {
		typeText(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompItemNo, "Enter Sub Component Item No : ",
				SubCompNo);
		Wait.waitfor(2);
		typeText(driver, test, OCR_SalesOrderItemSubComponentPage_SubComponentProdID,
				"Enter Subcomponent Parent Product ID : ", ParentProdID);
		clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompSaveReturnBtn,
				"Click on Save and Return button");
		clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompClosePopUp, "Click on Close Icon");
	}

	public void addOrderItemSubCompUS(String SubCompNo, String ContainerID, String ProdID) {
		try {
			typeText(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompItemNo, "Enter Sub Component Item No : ",
					SubCompNo);
			typeText(driver, test, OCR_SalesOrderItemSubComponentPage_ContainerID, "Enter the Container ID : ",
					ContainerID);
			typeText(driver, test, OCR_SalesOrderItemSubComponentPage_SubComponentProdIDUS,
					"Enter Subcomponent Parent Product ID : ", ProdID);
			clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompSaveReturnBtn,
					"Click on Save and Return button");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompClosePopUp, "Click on Close Icon");
			Wait.waitfor(2);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_SubCompClosePopUp, "Click on Close Icon");
		}
	}

	public void closeSubCompBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SalesOrderItemSubComponentPage_SubComponentCloseBtn,
				"Click on Close Button of Sub Component Page");
	}
}
