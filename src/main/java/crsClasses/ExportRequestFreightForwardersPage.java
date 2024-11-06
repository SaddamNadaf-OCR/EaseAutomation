package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportRequestFreightForwardersPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/************ Locators ****************************************/

	public static final String OCR_ExportRequest_SearchFFCodesPopUp = "//a[contains(text(),'Search FF Codes')]";
	public static final String OCR_ExportRequest_SearchFrightForwarderPopUPcodeTextBx = "//input[@id='searchForm_freightForwarder_ffCode']";
	public static final String OCR_ExportRequest_SearchFreightForwarderPopUpSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_SearchFreightFOrwarderPopUpSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_ExportFreightForwarderSaveandReturn = "//input[@name='OK.x']";
	public static final String OCR_ExportRequest_SearchFrightForwarderStatusdropdwn = "//select[@id='searchForm_freightForwarder_status']";
	public static final String OCR_ExportRequest_SearchFrightForwarderPopUpCloseBtn = "//button[@class='btn-close']";
	public static final String OCR_ExportRequest_SearchFrightForwarderCancelBtn = "//input[@name='Cancel.x']";

	/* ******************** Constructor ***************************** */

	public ExportRequestFreightForwardersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save and return button
	public void click_FFSaveAndReturnBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_ExportFreightForwarderSaveandReturn,
				"Clicking on Save And Return Button");
	}

	// Adding the Freight Forwarder
	public void addFreightForwarder(String FFStatus, String SearchFFcode) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_SearchFFCodesPopUp, "Click on Freight forwarder link");
		try {
			selectByVisibleText(driver, test, OCR_ExportRequest_SearchFrightForwarderStatusdropdwn,
					"Select the Status : ", FFStatus);
			typeText(driver, test, OCR_ExportRequest_SearchFrightForwarderPopUPcodeTextBx, "Entering FF Code :", SearchFFcode);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportRequest_SearchFreightForwarderPopUpSearchBtn,
					"Click on FF Search button");
			String FF = "//td[contains(text(),'" + SearchFFcode + "')]";
			mouseOverAndClick(driver, test, FF, "Select the Freight Forwarder Code : " + SearchFFcode);
			clickElement(driver, test, OCR_ExportRequest_SearchFreightFOrwarderPopUpSelectBtn,
					"Click on FF Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportRequest_SearchFrightForwarderPopUpCloseBtn, "Click on Close button");
		}
	}

	// Error message in Freight Forwarder
	public void validationFreightForwarder() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Please Enter Export Freight Forwarder Name')]")) {
					test.log(LogStatus.INFO, "Please Enter Export Freight Forwarder Name");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Freight Forwarder");
		}
	}

	// Click on Cancel button
	public void click_CancleFreightForwarderBtn() {
		clickElement(driver, test, OCR_ExportRequest_SearchFrightForwarderCancelBtn, "Click on Cancle button");
	}

}
