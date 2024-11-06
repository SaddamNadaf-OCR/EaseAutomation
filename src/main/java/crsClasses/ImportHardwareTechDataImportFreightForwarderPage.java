package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ImportHardwareTechDataImportFreightForwarderPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_FreightForwd_SaveAndReturnBtn = "//input[@name='OK.x']";
	public static final String OCR_FreightForwd_SearchFFcodeLink = "//a[contains(text(),'Search FF Codes')]";
	public static final String OCR_FreightForwd_Status = "//select[@id='searchForm_freightForwarder_status']";
	public static final String OCR_FreightForwd_Code = "//input[@name='freightForwarder.ffCode']";
	public static final String OCR_FreightForwd_SearchBtn = "//button[@name='Search']";
	public static final String OCR_FreightForwd_SelectBtn = "//div[@id='resultDIV']//button[1]";
	public static final String OCR_FreightForwd_CloseBtn = "//button[@class='btn-close']";
	public static final String OCR_FreightForwd_CancleBtn = "//input[@name='Cancel.x']";
	public static final String OCR_FreightForwd_Save = "//input[@name='save.x']";

	/* ******************** Constructor ***************************** */

	public ImportHardwareTechDataImportFreightForwarderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save and return button
	public void click_FFSaveAndReturnBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_FreightForwd_Save, "click on Save button");
		clickElement(driver, test, OCR_FreightForwd_SaveAndReturnBtn, "Clicking on Save And Return Button");
	}

	// Adding the freight forwarder
	public void addFreightForwarder(String FFStatus, String SearchFFcode) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_FreightForwd_SearchFFcodeLink, "Click on Freight forwarder link");
		try {
			Wait.waitfor(3);
			selectByVisibleText(driver, test, OCR_FreightForwd_Status, "Select the Status : ", FFStatus);
			typeText(driver, test, OCR_FreightForwd_Code, "Entering Freight Forwarder Code :", SearchFFcode);
			clickElement(driver, test, OCR_FreightForwd_SearchBtn, "Click on FF Search button");
			String FF = "//td[contains(text(),'" + SearchFFcode + "')]";
			clickElement(driver, test, FF, "Select the Freight Forwarder Code : " + SearchFFcode);
			clickElement(driver, test, OCR_FreightForwd_SelectBtn, "Click on FF Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_FreightForwd_CloseBtn, "Click on Close button");
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

	// Click on Cancle button
	public void click_CancleFreightForwarderBtn() {
		clickElement(driver, test, OCR_FreightForwd_CancleBtn, "Click on Cancle button");
	}

}
