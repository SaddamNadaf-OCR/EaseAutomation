package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ExportRequestParties extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/****************************** Locators *************************************/

	public static final String OCR_ExportRequest_PartiesSearchByCodePartyLink = "//a[contains(text(),'Search By Party Code')]";
	public static final String OCR_ExportREquest_PartiesCustomerStatus = "//select[@id='searchForm_userDTO_status']";
	public static final String OCR_ExportRequest_PartiesSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_PartiesSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_PartiesSaveReturnBtn ="//div[4]/div[1]/input[2]";
	public static final String OCR_ExportRequest_PartiesCancleBtn = "//input[@name='Cancel.x']";
	public static final String OCR_ExportRequest_PartyVendorRadioBtn = "//input[@id='searchForm_userDTO_sourceMfgTypeV']";
	public static final String OCR_ExportRequest_PartyVendorStatusDropDown = "//select[@id='searchForm_userDTO_status']";

	/************************* constructor ***********************/
	public ExportRequestParties(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding the party customer
	public void addPartyCustomer(String CustomerStatus, String customer) {
		clickElement(driver, test, OCR_ExportRequest_PartiesSearchByCodePartyLink, "Click on  Search by Code");
		selectByVisibleText(driver, test, OCR_ExportREquest_PartiesCustomerStatus, "Select Approve Status",
				CustomerStatus);
		clickElement(driver, test, OCR_ExportRequest_PartiesSearchBtn, "Search Approved Customer");
		String CustomerP = "//td[contains(text(),'" + customer + "')]";
		System.out.println(CustomerP);
		clickElement(driver, test, CustomerP, "Select a Customer");
		clickElement(driver, test, OCR_ExportRequest_PartiesSelectBtn, "click on Select Button");
	}

	// click on Save and return
	public void saveAndReturn() {
		clickElement(driver, test, OCR_ExportRequest_PartiesSaveReturnBtn, "Click on Save and Return ");
	}

	// click on Cancle button
	public void click_CancleBtn() {
		clickElement(driver, test, OCR_ExportRequest_PartiesCancleBtn, "Click on Cancle button ");
	}

	// Add party vendor
	public void addPartyVendor(String VendorStatus) {
		clickElement(driver, test, OCR_ExportRequest_PartiesSearchByCodePartyLink, "Click on  Search by Code");
		clickElement(driver, test, OCR_ExportRequest_PartyVendorRadioBtn, "Select Vendor using Radio Button");
		selectByVisibleText(driver, test, OCR_ExportRequest_PartyVendorStatusDropDown, "Select Approve Status",
				VendorStatus);
		clickElement(driver, test, OCR_ExportRequest_PartiesSearchBtn, "Click on Search Button");
	}

	// Validating the Add Party
	public void validateAddParty() {
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
}
