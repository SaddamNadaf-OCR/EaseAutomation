
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreatShipmentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreatShipment_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_CreateShipment_CreateShipmentBtn = "//button[contains(text(),'Create')]";
	public static final String OCR_CreateShipment_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_CreateShipment_templateSelect = "//select[@id='template']";
	public static final String OCR_CreateShipment_teplateRadioBtn = "//input[@value='template']";
	public static final String OCR_CreateShipment_authorizationRadioBtn = "//input[@value='license']";
	public static final String OCR_CreateShipment_EntrynoRadiobtn = "//input[@value='entry']";
	public static final String OCR_CreateShipment_AuthorizationNolink = "//a[@id='licenseno-pop']";
	public static final String OCR_CreateShipment_EntrynoLink = "//a[@id='entryNo-pop']";
	public static final String OCR_CreateShipment_srchAuthorization = "//button[@id='searchAuth']";
	public static final String OCR_CreateShipment_btnclose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateShipment_Authorizationnotext = "(//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo'])[1]";
	public static final String OCR_CreateShipmentSelectgrmPoup = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateShipmententrynotext = "//input[@id='resultEntryPopupData_import7501DetailsDTO_entryNo']";
	public static final String OCR_CreateShipment_searchentryno = "//button[@name='Search']";
	public static final String OCR_CreateShipment_UltConsignee = "//label[contains(text(),'Ult. Consignee')]";
	public static final String OCR_CreateShipment_IntConsignee = "//label[contains(text(),'Intermediate Consignee')]";
	public static final String OCR_CreateShipment_EndUser = "//label[contains(text(),'End User')]";
	public static final String OCR_CreateShipment_FF = "//label[contains(text(),'Freight Forwarder')]";

	/* ******************************* Constructor ****************************** */

	public CreatShipmentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// select Sbu Code
	public void select_SBUcode(String SBUcode) {
		selectByVisibleText(driver, test, OCR_CreatShipment_SBUCode, "Select Sbu Code : ", SBUcode);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateShipment_CreateShipmentBtn, "Click on create shipment button");
	}

	public void click_CreateShipmentBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateShipment_CreateShipmentBtn, "Click on create shipment button");
	}

	public void selectSBUcode(String SBUcode) {
		if(SBUcode.length() > 0) {
			selectByVisibleText(driver, test, OCR_CreatShipment_SBUCode, "Select Sbu Code : ", SBUcode);
		}
	}

	// click only on Create Shipment button
	public void create_Shp() {
		clickElement(driver, test, OCR_CreateShipment_CreateShipmentBtn, "Click on create shipment button");
	}

	public void createshipmentwithtemplate(String ShipmentTemplate) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateShipment_teplateRadioBtn, "click on shipment template radio button");
		selectByVisibleText(driver, test, OCR_CreateShipment_templateSelect, "select shipment template",
				ShipmentTemplate);
	}

	public void createshipmentwithAuthorization() {
		clickElement(driver, test, OCR_CreateShipment_authorizationRadioBtn,
				"click on shipment authorization radio button");
	}

	public void authorizationno(String AuthorizationNo) {
		if (AuthorizationNo.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateShipment_AuthorizationNolink, "click on authorization no");
			try {
				Wait.waitfor(5);
				typeText(driver, test, OCR_CreateShipment_Authorizationnotext, "Enter authorization NO.",
						AuthorizationNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateShipment_srchAuthorization, "Click on search button");
				Wait.waitfor(4);
				String Ano = "//td[contains(text(),'" + AuthorizationNo + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, Ano, "Click User :" + AuthorizationNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateShipmentSelectgrmPoup, "Click on Select button");
			} catch (Exception e) {

				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add authorization no ");
				clickElement(driver, test, OCR_CreateShipment_btnclose, "Close the popup");
			}
		}
	}

	public void createshipmentwithEntryNo() {
		clickElement(driver, test, OCR_CreateShipment_EntrynoRadiobtn, "click on shipment Entry no radio button");
	}

	public void entryno(String entryno) {
		if (entryno.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateShipment_EntrynoLink, "click on entry no");
			try {
				Wait.waitfor(5);
				typeText(driver, test, OCR_CreateShipmententrynotext, "Enter entry NO.", entryno);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateShipment_searchentryno, "Click on search button");
				Wait.waitfor(4);
				String eno = "//td[contains(text(),'" + entryno + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, eno, "Click User :" + entryno);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateShipmentSelectgrmPoup, "Click on Select button");
			} catch (Exception e) {

				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add authorization no ");
				clickElement(driver, test, OCR_CreateShipment_btnclose, "Close the popup");
			}
		}
	}

	// Configured Party Validation
	public void configuredPartyValidation() {
		try {
			if (isDisplayed(driver, OCR_CreateShipment_UltConsignee)) {
				test.log(LogStatus.PASS, "Ultimate Consignee Is Displayed :");
			}
			if (isDisplayed(driver, OCR_CreateShipment_IntConsignee)) {
				test.log(LogStatus.PASS, "Intermediate Consignee Is Displayed :");
			}
			if (isDisplayed(driver, OCR_CreateShipment_EndUser)) {
				test.log(LogStatus.PASS, "End User Is Displayed :");
			}
			if (isDisplayed(driver, OCR_CreateShipment_FF)) {
				test.log(LogStatus.PASS, "Freight Forwarder Is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Configured Parties are Not Displayed :");
		}
	}

	// Configured Party Validation
	public void configuredPartyValidationN() {
		try {
			if (!isDisplayed(driver, OCR_CreateShipment_UltConsignee)) {
				test.log(LogStatus.PASS, "Ultimate Consignee Is Displayed :");
			}
			if (!isDisplayed(driver, OCR_CreateShipment_IntConsignee)) {
				test.log(LogStatus.PASS, "Intermediate Consignee Is Displayed :");
			}
			if (!isDisplayed(driver, OCR_CreateShipment_EndUser)) {
				test.log(LogStatus.PASS, "End User Is Displayed :");
			}
			if (!isDisplayed(driver, OCR_CreateShipment_FF)) {
				test.log(LogStatus.PASS, "Freight Forwarder Is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Configured Parties are Not Displayed :");
		}
	}

}
