package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultExportSupplierPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ExportSupplier_AddSupplier = "//button[@id='add']";
	public static final String OCR_ExportSupplier_CodeLink = "//a[contains(text(),'Code')]";
	public static final String OCR_ExportSupplier_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_ExportSupplier_Search = "//button[@name='Search']";
	public static final String OCR_ExportSupplier_SaveAndReturn = "//button[@id='saveReturn']";
	public static final String OCR_ExportSupplier_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_ExportSupplie_PopUpClose = "(//button[@class='close'])[1]";
	public static final String OCR_ExportSupplie_Form7Details = "//button[contains(text(),'Form 7 Details')]";

	/* ******************** Constructor ***************************** */

	public ResultExportSupplierPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click on Add Supplier
	public void clickAddSupplier() {
		clickElement(driver, test, OCR_ExportSupplier_AddSupplier, "Click on Add Supplier");
	}

	// Add Supplier
	public void addSupplier(String SupplierConsigneeCode) {
		clickElement(driver, test, OCR_ExportSupplier_CodeLink, "Click on Code Link");

		try {
			typeText(driver, test, OCR_ExportSupplier_ConsigneeCode, "Enter the ConsigneeCode : ",
					SupplierConsigneeCode);
			clickElement(driver, test, OCR_ExportSupplier_Search, "Click on Search");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + SupplierConsigneeCode + "')]",
					"Click on Consignee Code : " + SupplierConsigneeCode);
			clickElement(driver, test, OCR_ExportSupplier_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportSupplie_PopUpClose, "Click on POP Up close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportSupplier_SaveAndReturn, "Click on Save And Return");
	}

	// click on Back to Form 7
	public void clickForm7Details() {
		clickElement(driver, test, OCR_ExportSupplie_Form7Details, "Click on Form 7 Details");
	}

	// validations in Party Details
	public void validatePartyDetailsError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportSupplier_SaveAndReturn, "Click on Save And Return");
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Name is required')]")) {
					test.log(LogStatus.INFO, "Party Name is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Address is required')]")) {
					test.log(LogStatus.INFO, "Party Address is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee City is required')]")) {
					test.log(LogStatus.INFO, "Party City is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Country is required')]")) {
					test.log(LogStatus.INFO, "Party Country	is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Party Details Pop Up");
		}
	}

}
