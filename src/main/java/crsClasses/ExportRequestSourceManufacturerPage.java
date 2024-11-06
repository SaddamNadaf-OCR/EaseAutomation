package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportRequestSourceManufacturerPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/******************************* Locators ************************************/
	public static final String OCR_ExportRequest_SourceRadioBtn = "//input[@id='editExportSourceMfg_exportSourceMfgValue_sourceMfgTypeS']";
	public static final String OCR_ExportRequest_ManufacturerRadioBtn = "//input[@id='editExportSourceMfg_exportSourceMfgValue_sourceMfgTypeM']";
	public static final String OCR_ExportRequest_USSignatoryRadioBtn = "//input[@id='editExportSourceMfg_exportSourceMfgValue_sourceMfgTypeE']";
	public static final String OCR_ExportRequest_SellerRadioBtn = "//input[@id='editExportSourceMfg_exportSourceMfgValue_sourceMfgTypeL']";
	public static final String OCR_ExportRequest_ManufacturerPopUpManuRadioBtn = "//input[@id='searchForm_userDTO_sourceMfgTypeM']";
	public static final String OCR_ExportRequest_ManufacturerPopUpSourceRadioBtn = "//input[@id='searchForm_userDTO_sourceMfgTypeS']";
	public static final String OCR_ExportRequest_ManufacturerPopUpSelerRadioBtn = "//input[@id='searchForm_userDTO_sourceMfgTypeL']";
	public static final String OCR_ExportRequest_ManufacturerPopUpUSsignRadioBtn = "//input[@id='searchForm_userDTO_sourceMfgTypeE']";
	public static final String OCR_ExportRequest_SourceManufacturerCodeLink = "(//a[contains(text(),'Source')])[2]";
	public static final String OCR_ExportRequest_SourceManufacturerCodeTextBox = "//input[@id='searchForm_userDTO_userCode']";
	public static final String OCR_ExportRequest_ManufacturerPopUpStatusDropdown = "//select[@id='searchForm_userDTO_status']";
	public static final String OCR_ExportRequest_ManufacturerPopUpSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_ManufacturerPopUpSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_ManufacturerSaveandReturnBtn = "//input[@name='OK']";
	public static final String OCR_ExportRequest_Manufacturer_CancleBtn = "//input[@name='Cancel']";

	/************************* constructor ***********************/
	public ExportRequestSourceManufacturerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding the Source info
	public void addSourceInfo(String sourcetype, String ManufacturerType, String ManufacturerCode,
			String Approvestatus) {
		if (sourcetype.contains("Source")) {
			clickElement(driver, test, OCR_ExportRequest_ManufacturerRadioBtn, "Click on Manufacturer  Radio Button");
		}
		if (sourcetype.contains("Manufacturer")) {
			clickElement(driver, test, OCR_ExportRequest_ManufacturerRadioBtn, "Click on Manufacturer  Radio Button");
		}
		if (sourcetype.contains("US Signatory")) {
			clickElement(driver, test, OCR_ExportRequest_USSignatoryRadioBtn, "Click on US signatory Radio button");
		}
		if (sourcetype.contains("Seller")) {
			clickElement(driver, test, OCR_ExportRequest_SellerRadioBtn, "Click on seller Radio Button");
		}
		
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_SourceManufacturerCodeLink, "click on manufacturer link");
		if (ManufacturerType.contains("Source")) {
			clickElement(driver, test, OCR_ExportRequest_ManufacturerPopUpSourceRadioBtn,
					"Click on Manufacturer  Radio Button");
		}
		if (ManufacturerType.contains("Manufacturer")) {
			clickElement(driver, test, OCR_ExportRequest_ManufacturerPopUpManuRadioBtn,
					"Click on Manufacturer  Radio Button");
		}
		if (ManufacturerType.contains("US Signatory")) {
			clickElement(driver, test, OCR_ExportRequest_ManufacturerPopUpUSsignRadioBtn,
					"click on US signatory Radio Button");
		}
		if (sourcetype.contains("Seller")) {
			clickElement(driver, test, OCR_ExportRequest_ManufacturerPopUpSelerRadioBtn,
					"Click on Seller Radio Button");
		}
		typeText(driver, test, OCR_ExportRequest_SourceManufacturerCodeTextBox, "Enter Manufacturer code : ",
				ManufacturerCode);
		selectByVisibleText(driver, test, OCR_ExportRequest_ManufacturerPopUpStatusDropdown, "Select status : ",
				Approvestatus);
		clickElement(driver, test, OCR_ExportRequest_ManufacturerPopUpSearchBtn, "Click on Search Button");
		Wait.waitfor(5);
		String mcode = "//td[contains(text(),'" + ManufacturerCode + "')]";
		
		clickElement(driver, test, mcode, "CLick on Code : " + ManufacturerCode);
		clickElement(driver, test, OCR_ExportRequest_ManufacturerPopUpSelectBtn, "Click on Select Button");
	}

	// click on save and Return Button
	public void clickSaveandReturn() {
		Wait.waitfor(3);
		clickElement(driver, test, "//select[@name='dplStatus1']", "mouseover to save and return");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_ManufacturerSaveandReturnBtn, "click on save and Return Button");
	}

	// click on Cancle button
	public void click_cancleBtn() {
		clickElement(driver, test, OCR_ExportRequest_Manufacturer_CancleBtn, "Click on Cancle button");
	}

	// Error validation in source and manufacture
	public void validateSourceAndManf() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(), 'Please Enter Source Manufacturer Name')]")) {
					test.log(LogStatus.INFO, "Please Enter Source Manufacturer Name");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Source/Manufacturer");
		}
	}

}
