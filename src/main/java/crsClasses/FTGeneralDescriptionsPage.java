package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class FTGeneralDescriptionsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/******************* Locators ***************************************/

	public static final String OCR_GeneralDesc_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String OCR_GeneralDesc_SiteSearchBtn = "//button[@name='Search']";
	public static final String OCR_GeneralDesc_SitePopSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR__GeneralDesc_Department = "//a[@class='qtooltip'][contains(text(),'Department')]";
	public static final String OCR_GeneralDesc_Department_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String OCR_GeneralDesc_ProgramSearchBtn = "//button[@name='Search']";
	public static final String OCR_GeneralDesc_ProgramSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String OCR_GeneralDesc_ProductFamilySelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_GeneralDesc_SegentsSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_ProductLines = "(//a[contains(text(),'Product Line')])[2]";
	public static final String OCR_GeneralDesc_ProductlinesSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_SalesOrderNo = "//input[@id='editExportRequest_exportRequestValue_salesOrderNo']";
	public static final String OCR_GeneralDesc_PurchaseOrderNo = "//input[@id='editExportRequest_exportRequestValue_purchaseOrderNo']";
	public static final String OCR_GeneralDesc_ContractNo = "//input[@id='editExportRequest_exportRequestValue_contractNo']";
	public static final String OCR_GeneralDesc_FMSCaseNo = "//input[@id='editExportRequest_exportRequestValue_fmsCaseNo']";
	public static final String OCR_GeneralDesc_InternalTrackingNo = "//input[@id='editExportRequest_exportRequestValue_trackingNo']";
	public static final String OCR_GeneralDesc_SaveBtn = "//button[contains(text(),'Save')]";
	public static final String OCR_GeneralDesc_PopUpCloseBtn = "//button[@class='btn-close']";
	public static final String OCR_Button_TravelInfo = "//a[contains(text(),'Travel Info')]";

	/************************* constructor ***********************/

	public FTGeneralDescriptionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select the site
	public void select_Site(String SiteId) {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GeneralDesc_Site, "click on Site Link");
			if (SiteId.length() > 0) {
				String SitId = "//td[contains(text(),'" + SiteId + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_siteId'])[1]", "Select the Site Id Code : " + SiteId);
				clickElement(driver, test, OCR_GeneralDesc_SitePopSelectBtn, "click on Select Button ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	// Select the Department
	public void select_Department(String Department) {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR__GeneralDesc_Department, "click on Department Link");
			if (Department.length() > 0) {
				Wait.waitfor(3);
				String Depart = "//td[contains(text(),'" + Department + "')]";
				clickElement(driver, test, Depart, "Select a Department : " + Department);
				clickElement(driver, test, OCR_GeneralDesc_Department_SelectBtn, "click on select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	// Select the Program
	public void select_Program(String Program) {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GeneralDesc_Program, "Click on Program Link");
			if (Program.length() > 0) {
				clickElement(driver, test, OCR_GeneralDesc_ProgramSearchBtn, "Click on Search Button ");
				Wait.waitfor(3);
				String Prog = "//td[contains(text(), '" + Program + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_programCode'])[1]", "Select a Program : " + Program);
				clickElement(driver, test, OCR_GeneralDesc_ProgramSelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	// Select the Segment
	public void select_Segment(String Segment) {
		try {
			Wait.waitfor(5);
			clickElement(driver, test, OCR_GeneralDesc_Segment, "Click on Segment Link");
			if (Segment.length() > 0) {
				Wait.waitfor(3);
				String Seg = "//td[contains(text(),'" + Segment + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_segmentCode'])[1]", "Select the Segment : " + Segment);
				clickElement(driver, test, OCR_GeneralDesc_SegentsSelectBtn, "click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	// Select the ProductFamily
	public void select_ProductFamily(String ProductFamily) {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GeneralDesc_ProductFamily, "click on product family Link");
			if (ProductFamily.length() > 0) {
				String ProductF = "//td[contains(text(), '" + ProductFamily + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_familyId'])[1]", "Select product family : " + ProductFamily);
				clickElement(driver, test, OCR_GeneralDesc_ProductFamilySelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	// Select the ProductLines
	public void select_ProductLines(String ProductLines) {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GeneralDesc_ProductLines, "Click on product Line Link");
			if (ProductLines.length() > 0) {
				Wait.waitfor(3);
				String ProductL = "//td[contains(text(),'" + ProductLines + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_prodLineId'])[1]", "Select Product Line : " + ProductLines);
				clickElement(driver, test, OCR_GeneralDesc_ProductlinesSelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	public void movetotravelinfo() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_TravelInfo)));
	}

	// click on Save Button
	public void clickOnSaveBtn() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_GeneralDesc_SaveBtn);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GeneralDesc_SaveBtn, "click on Save Button");
	}

	// Move to Document Tab
	public void movetodoctab() {
		clickElement(driver, test, "//span[contains(text(),'Documents')]", "Click on Document Tab");
	}

}
