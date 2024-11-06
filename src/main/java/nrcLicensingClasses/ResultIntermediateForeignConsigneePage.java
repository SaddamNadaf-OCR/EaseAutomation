package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultIntermediateForeignConsigneePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_IFC_AddConsignee = "//button[@id='add']";
	public static final String OCR_IFC_SaveAndReturn = "//button[@id='saveReturn']";
	public static final String OCR_IFC_CodeLink = "//a[contains(text(),'Code')]";
	public static final String OCR_IFC_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_IFC_Search = "//button[@name='Search']";
	public static final String OCR_IFC_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_IFC_PopUpClose = "(//button[@class='close'])[1]";

	/* ******************** Constructor ***************************** */

	public ResultIntermediateForeignConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// click on Add Consignee
	public void clickAddInterConsignee() {
		clickElement(driver, test, OCR_IFC_AddConsignee, "Click on Add Consignee");
	}

	// Add the Consignee
	public void addInterConsignee(String InterConsigneeCode) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_IFC_AddConsignee, "Click on Add Consignee");
		clickElement(driver, test, OCR_IFC_CodeLink, "Click on Code Link");

		try {
			typeText(driver, test, OCR_IFC_ConsigneeCode, "Enter the ConsigneeCode : ", InterConsigneeCode);
			clickElement(driver, test, OCR_IFC_Search, "Click on Search");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + InterConsigneeCode + "')]",
					"Click on Consignee Code : " + InterConsigneeCode);
			clickElement(driver, test, OCR_IFC_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_IFC_PopUpClose, "Click on POP Up close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_IFC_SaveAndReturn, "Click on Save And Return");
	}

	// validations in Intermediate Foreign Consignee Details
	public void validateIntermediateConsigneeDetailsError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_IFC_SaveAndReturn, "Click on Save And Return");
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Name is required')]")) {
					test.log(LogStatus.INFO, "Intermediate Consignee Name is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Address is required')]")) {
					test.log(LogStatus.INFO, "Intermediate Consignee Address is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee City is required')]")) {
					test.log(LogStatus.INFO, "Intermediate Consignee City is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Consignee Country is required')]")) {
					test.log(LogStatus.INFO, "Intermediate Consignee Country is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Intermediate Consignee Details Pop Up");
		}
	}

}
