package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportGeneralDescriptionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/******************* Locators ***************************************/

	public static final String OCR_GeneralDesc_Site = "//a[@class='qtooltip'][contains(text(),'Site')]";
	public static final String OCR_GeneralDesc_SiteSearchBtn = "//button[@name='Search']";
	public static final String OCR_GeneralDesc_SitePopSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SiteTextbox = "//textarea[@id='editExportRequest_exportRequestValue_site']";
	public static final String OCR__GeneralDesc_Department = "//a[@class='qtooltip'][contains(text(),'Department')]";
	public static final String OCR_GeneralDesc_Department_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_DepartmentTextbox = "//textarea[@id='editExportRequest_exportRequestValue_department']";
	public static final String OCR_GeneralDesc_Program = "//a[@class='qtooltip'][contains(text(),'Program')]";
	public static final String OCR_GeneralDesc_ProgramSearchBtn = "//button[@name='Search']";
	public static final String OCR_GeneralDesc_ProgramSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ProgramTextbox = "//textarea[@id='editExportRequest_exportRequestValue_program']";
	public static final String OCR_GeneralDesc_ProductFamily = "//a[@class='qtooltip'][contains(text(),'Product Family')]";
	public static final String OCR_GeneralDesc_ProductFamilySelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ProductFamilyTextbox = "//textarea[@id='editExportRequest_exportRequestValue_prodFamily']";
	public static final String OCR_GeneralDesc_Segment = "//a[@class='qtooltip'][contains(text(),'Segment')]";
	public static final String OCR_GeneralDesc_SegentsSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SegmentTextbox = "//textarea[@id='editExportRequest_exportRequestValue_segment']";
	public static final String OCR_GeneralDesc_ProductLines = "//a[@class='qtooltip'][contains(text(),'Product Line')]";
	public static final String OCR_GeneralDesc_ProductlinesSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ProductLineTextbox = "//textarea[@id='editExportRequest_exportRequestValue_prodLine']";
	public static final String OCR_GeneralDesc_SalesOrderNo = "//input[@id='editExportRequest_exportRequestValue_salesOrderNo']";
	public static final String OCR_GeneralDesc_PurchaseOrderNo = "//input[@id='editExportRequest_exportRequestValue_purchaseOrderNo']";
	public static final String OCR_GeneralDesc_ContractNo = "//input[@id='editExportRequest_exportRequestValue_contractNo']";
	public static final String OCR_GeneralDesc_FMSCaseNo = "//input[@id='editExportRequest_exportRequestValue_fmsCaseNo']";
	public static final String OCR_GeneralDesc_InternalTrackingNo = "//input[@id='editExportRequest_exportRequestValue_trackingNo']";
	public static final String OCR_GeneralDesc_SaveBtn = "//div[@id='3']//div[@class='row btn-row']//input[1]";
	public static final String OCR_GeneralDesc_PopUpCloseBtn = "//button[@class='close']";

	/************************* constructor ***********************/

	public ExportGeneralDescriptionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select the site
	public void select_Site(String SiteId) {
		try {
			if (SiteId.length() > 0) {
				clickElement(driver, test, OCR_GeneralDesc_Site, "click on Site Link");
				clickElement(driver, test, OCR_GeneralDesc_SiteSearchBtn, "click on search button of Site pop up");
				String SitId = "//td[contains(text(),'" + SiteId + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_siteId'])[1]", "Select the Exporter Code : " + SiteId);
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
			if (Department.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR__GeneralDesc_Department, "click on Department Link");
				String Depart = "//td[contains(text(),'" + Department + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_centerId'])[1]", "Select a Department : " + Department);
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
			if (Program.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_Program, "Click on Program Link");
				clickElement(driver, test, OCR_GeneralDesc_ProgramSearchBtn, "Click on Search Button ");
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
			if (Segment.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_Segment, "Click on Segment Link");
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
			if (ProductFamily.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_ProductFamily, "click on product family Link");
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
			if (ProductLines.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_ProductLines, "Click on product Line Link");
				String ProductL = "//td[contains(text(),'" + ProductLines + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_prodLineId'])[1]", "Select Product Line : " + ProductLines);
				clickElement(driver, test, OCR_GeneralDesc_ProductlinesSelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
	}

	// Add the general Description
	public void add_GeneralDesc(String SalesNO, String PurchaseNo, String ContractNo, String FMSCaseNo,
			String InternalTrackingNo) {
		scrollToBottom(driver);
		Wait.waitfor(2);
		typeText(driver, test, OCR_GeneralDesc_SalesOrderNo, "Enter the Sale No. : ", SalesNO);
		typeText(driver, test, OCR_GeneralDesc_PurchaseOrderNo, "Enter the Purchase Order No : ", PurchaseNo);
		typeText(driver, test, OCR_GeneralDesc_ContractNo, "Enter the Contract No : ", ContractNo);
		typeText(driver, test, OCR_GeneralDesc_FMSCaseNo, "Enter the FM : ", FMSCaseNo);
		typeText(driver, test, OCR_GeneralDesc_InternalTrackingNo, "Enter Internal Tracking No : ", InternalTrackingNo);

	}

	// click on Save Button
	public void clickOnSaveBtn() {
		clickElement(driver, test, OCR_GeneralDesc_SaveBtn, "click on Save Button");
	}
	
	public void movetodoctab() {

		clickElement(driver, test, "//span[contains(text(),'Documents')]","Click on Document Tab");
		}
	
	}


