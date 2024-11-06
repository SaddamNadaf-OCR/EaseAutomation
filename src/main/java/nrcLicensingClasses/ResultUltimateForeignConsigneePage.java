package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultUltimateForeignConsigneePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ForeignConsignee_AddConsignee = "//button[@id='add']";
	public static final String OCR_ForeignConsignee_SaveAndReturn = "//button[@id='saveReturn']";
	public static final String OCR_ForeignConsignee_CodeLink = "//a[contains(text(),'Code')]";
	public static final String OCR_ForeignConsignee_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_ForeignConsignee_Search = "//button[@name='Search']";
	public static final String OCR_ForeignConsignee_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_ForeignConsignee_PopUpClose = "(//button[@class='close'])[1]";

	/* ******************** Constructor ***************************** */

	public ResultUltimateForeignConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click on Add Consignee
	public void clickAddUFC() {
		clickElement(driver, test, OCR_ForeignConsignee_AddConsignee, "Click on Add Consignee");
	}

	// Add Ultimate Foreign consignee
	public void addUFC(String UltimateConsigneeCode) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ForeignConsignee_AddConsignee, "Click on Add Consignee");
		clickElement(driver, test, OCR_ForeignConsignee_CodeLink, "Click on Code Link");

		try {
			typeText(driver, test, OCR_ForeignConsignee_ConsigneeCode, "Enter the ConsigneeCode : ",
					UltimateConsigneeCode);
			clickElement(driver, test, OCR_ForeignConsignee_Search, "Click on Search");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + UltimateConsigneeCode + "')]",
					"Click on Consignee Code : " + UltimateConsigneeCode);
			clickElement(driver, test, OCR_ForeignConsignee_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ForeignConsignee_PopUpClose, "Click on POP Up close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ForeignConsignee_SaveAndReturn, "Click on Save And Return");
	}

	// validations in Ultimate Foreign Consignee Details
	public void validateUltimateConsigneeDetailsError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ForeignConsignee_SaveAndReturn, "Click on Save And Return");
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Name is required')]")) {
					test.log(LogStatus.INFO, "Ultimate Consignee Name is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Address is required')]")) {
					test.log(LogStatus.INFO, "Ultimate Consignee Address is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee City is required')]")) {
					test.log(LogStatus.INFO, "Ultimate Consignee City is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Country is required')]")) {
					test.log(LogStatus.INFO, "Ultimate Consignee Country is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Ultimate Consignee Details Pop Up");
		}
	}

}
