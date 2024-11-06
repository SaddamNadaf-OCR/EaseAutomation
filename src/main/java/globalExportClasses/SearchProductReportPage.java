package globalExportClasses;

import org.openqa.selenium.WebDriver;
import org.python.util.Generic;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchProductReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchProductReportPage_SBUCode = "//select[@id='resultProductTableReport_product_sbuCode']";
	public static final String OCR_SearchProductReportPage_PartNo = "//input[@id='resultProductTableReport_product_productCode']";
	public static final String OCR_SearchProductReportPage_ManufacturerLabel = "//label[contains(text(),'Search Manufacturer')]";
	public static final String OCR_SearchProductReportPage_manufacturerLink = "(//a[contains(text(),'Manufacturer')])[2]";
	public static final String OCR_SearchProductReportPage_SearchPopUpbtn = "//button[@name='Search']";
	public static final String OCR_SearchProductReportPage_Selectbtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_SearchProductReportPage_Closebtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchProductReportPage_Manufacturer = "//input[@id='resultProductTableReport_product_manufacturer']";
	public static final String OCR_SearchProductReportPage_ValidateHeading = "//h3[contains(text(),'Product Report')]";
	public static final String OCR_SearchProductReportPage_SearchBtn = "(//button[contains(text(),'Search')])[1]";
	/* ******************************* Constructor ****************************** */

	public SearchProductReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String SbuCode) {
		if(SbuCode.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_SearchProductReportPage_SBUCode, "Select SBU Code : ", SbuCode);
			Wait.waitfor(5);
		}
	}
	
	public void enterPartNo(String PartNo) {
		if(PartNo.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, OCR_SearchProductReportPage_PartNo, "Enter Part Number : ", PartNo);
		}
	}
	
	public void selectManufacturer(String ManufacturerLink, String Manufacturer) {
		scrollToElement(driver, OCR_SearchProductReportPage_ManufacturerLabel);
		clickElement(driver, test, OCR_SearchProductReportPage_ManufacturerLabel, "Click on Search Manufacturer label");
		if(ManufacturerLink.length() > 0) {
			try {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='searchForm_userDTO_userCode']", "Enter manufacturer : ", ManufacturerLink);
			clickElement(driver, test, OCR_SearchProductReportPage_SearchPopUpbtn, "Click on Search Button pop up");
			clickElement(driver, test, "//td[contains(text(),'"+ ManufacturerLink +"')]", "Select the Manufacturer : " +ManufacturerLink);
			clickElement(driver, test, OCR_SearchProductReportPage_Selectbtn, "Click on Select Pop Up button");
			}
			catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchProductReportPage_Closebtn, "Click on Close popup icon");
			}
		  }else {
			  typeText(driver, test, OCR_SearchProductReportPage_Manufacturer, "Enter Manufacturer Name : ", Manufacturer);
			 
		  }
	}
	
	public void searchBtn() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_SearchProductReportPage_SearchBtn);
		clickElement(driver, test, OCR_SearchProductReportPage_SearchBtn, "Click on Search Button");
		
	}
	
	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_SearchProductReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Product Report Page is Displayed");
		
	}

}
