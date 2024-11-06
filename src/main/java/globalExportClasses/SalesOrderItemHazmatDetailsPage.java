package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SalesOrderItemHazmatDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SalesOrderItemHazmatDetailsPage_HazmatID = "//input[@id='editInvoiceItem_invoiceItem_unIdNo']";
	public static final String OCR_SalesOrderItemHazmatDetailsPage_HazmatSaveBtn = "//button[@id='saveSubmitBtn']";
	public static final String OCR_SalesOrderItemHazmatDetailsPage_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_SalesOrderItemHazmatDetailsPage_SubCompDetails = "//a[contains(text(),'Sub Component')]";

	/* ******************************* Constructor ****************************** */

	public SalesOrderItemHazmatDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void hazmatInfo(String hazmatID) {
		typeText(driver, test, OCR_SalesOrderItemHazmatDetailsPage_HazmatID, "Enter Hazmat Details : ", hazmatID);
	}

	public void hazmatSaveBtn() {
		clickElement(driver, test, OCR_SalesOrderItemHazmatDetailsPage_HazmatSaveBtn, "Click on Save button");
	}

	public void subComponentDetails() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_SalesOrderItemHazmatDetailsPage_AdditionalTransactionDetails);
		clickElement(driver, test, OCR_SalesOrderItemHazmatDetailsPage_AdditionalTransactionDetails,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_SalesOrderItemHazmatDetailsPage_SubCompDetails, "Click Sub Component Details");

	}

}
