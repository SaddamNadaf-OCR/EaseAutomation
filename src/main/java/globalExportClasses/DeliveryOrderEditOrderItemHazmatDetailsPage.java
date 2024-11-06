package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DeliveryOrderEditOrderItemHazmatDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ItemHazmat_OCRHazmatIDLink = "//a[@id='unidno-popup']";
	public static final String OCR_ItemHazmat_HazClassDiv = "//input[@id='searchForm_hazmat_hazardClassOrDivision']";
	public static final String OCR_ItemHazmat_HazmatClassSearch = "//input[@id='searchForm_hazmat_hazardClassOrDivision']";
	public static final String OCR_ItemHazmat_HazmatSearch = "//button[@name='Search']";
	public static final String OCR_ItemHazmat_HazmatSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ItemHazmat_ClosePopUp = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_ItemHazmat_Save = "//button[@id='saveSubmitBtn']";
	public static final String OCR_ItemHazmat_SaveAndReturn = "//button[@id='saveAndReturnInvoiceItem']";

	/* ******************************* Constructor ****************************** */

	public DeliveryOrderEditOrderItemHazmatDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add the Hazamat Information
	public void add_HazmatInformation(String SearchHazardClassorDivision) {
		Wait.waitfor(3);
		if (SearchHazardClassorDivision.length() > 0) {
			clickElement(driver, test, OCR_ItemHazmat_OCRHazmatIDLink, "Click on OCR Hazmat ID");
			try {
				//typeText(driver, test, OCR_ItemHazmat_HazClassDiv, "Enter hazard Class or Division : ", HazClass);
				clickElement(driver, test, OCR_ItemHazmat_HazmatSearch, "Click on Search");
				clickElement(driver, test, "(//td[contains(text(),'" + SearchHazardClassorDivision + "')])[1]",
						"Select the hazard class or Division : " + SearchHazardClassorDivision);
				clickElement(driver, test, OCR_ItemHazmat_HazmatSelect, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ItemHazmat_ClosePopUp, "Click on Pop Up Close button");
			}
		}
	}

	// Click on Save
	public void click_SaveItemHazmatDetails() {
		clickElement(driver, test, OCR_ItemHazmat_Save, "Click on Save in Item Hazmat Details");
	}

	// click on Save and Return
	public void click_SaveAndReturn() {
		clickElement(driver, test, OCR_ItemHazmat_SaveAndReturn, "Click on Save and Return in Item Hazmat Details");
	}

}
