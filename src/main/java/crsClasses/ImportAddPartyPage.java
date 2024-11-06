package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class ImportAddPartyPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Party_SaveBtn = "//input[@name='save']";
	public static final String OCR_Party_SaveAndReturnBtn = "//input[@name='OK.x']";
	public static final String OCR_Party_SearchByPartyCodeLink = "//a[contains(text(),'Search By Party Code :')]";
	public static final String OCR_Vendor_Consignee_Code = "//input[@name='userDTO.userCode']";
	public static final String OCR_Party_CustAndVendStatus = "//select[@id='searchForm_userDTO_status']";
	public static final String OCR_Party_CustAndVendSearch = "//button[@name='Search']";
	public static final String OCR_Party_CustAndVendSelect = "//div[@id='resultDIV']//button[1]";
	public static final String OCR_Party_CloseBtn = "//button[@class='btn-close']";
	public static final String OCR_Party_CancleBtn = "//input[@name='Cancel.x']";

	/* ******************** Constructor ***************************** */

	public ImportAddPartyPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Party Save
	public void click_PartySave() {
		clickElement(driver, test, OCR_Party_SaveBtn, "Clicking on Party Save button");
	}

	// Click on Party Save And Return
	public void click_PartySaveAndReturn() {
		Wait.waitfor(3);
		click_PartySave();
		clickElement(driver, test, OCR_Party_SaveAndReturnBtn, "Clicking on Party Save & Return button");
	}

	// Add party Details
	public void addParty(String PartiesStatus, String PartiesCode) {
		clickElement(driver, test, OCR_Party_SearchByPartyCodeLink, "Click on Search By Party Code Link ");
		try {
			if (isSelected(driver, "//input[@id='searchForm_userDTO_sourceMfgTypeC']")) {
				test.log(LogStatus.PASS, "Customer is Radio button is Selected");
			} else {
				test.log(LogStatus.FAIL, "Customer is Radio button is not Selected");
			}
			typeText(driver, test, OCR_Vendor_Consignee_Code, "Entering Vendor Consignee Code :", PartiesCode);
			selectByVisibleText(driver, test, OCR_Party_CustAndVendStatus, "Select the Customer or Vendor Status : ",
					PartiesStatus);
			clickElement(driver, test, OCR_Party_CustAndVendSearch, "Click on Customer or Vendor Search");
			Wait.waitfor(3);
			String code = "//td[contains(text(),'" + PartiesCode + "')]";
			clickElement(driver, test, code, "Select the Customer Or Vendor Code : " + PartiesCode);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Party_CustAndVendSelect, "Click on Customer or Vendor Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Party_CloseBtn, "Click on Close button");
		}
	}

	// Error message in Add Party
	public void validationAddParty() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Please Enter Consignee Name')]")) {
					test.log(LogStatus.INFO, "Please Enter Consignee Name");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Add Party");
		}
	}

	// Click on Cancle button
	public void click_CanclePartyBtn() {
		clickElement(driver, test, OCR_Party_CancleBtn, "Click on Cancle button");
	}

}
