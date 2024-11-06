package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SBUCode = "//select[@id='selectSbu']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_WorkStatus = "//select[@id='resultDisapprovalMetricsBySbuReport_shipment_shipmentWorkStatus']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry = "//select[@id='encryptedCountryCode']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectRegion = "//select[@id='resultDisapprovalMetricsReport_selectRegion']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectSite = "//select[@id='resultDisapprovalMetricsReport_selectSite']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedFrom = "//input[@id='resultDisapprovalMetricsBySbuReport_fromCreatedDate']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedTo = "//input[@id='resultDisapprovalMetricsBySbuReport_toCreatedDate']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedFromDate = "//input[@id='resultDisapprovalMetricsBySbuReport_fromDateOfExport']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedToDate = "//input[@id='resultDisapprovalMetricsBySbuReport_toDateOfExport']";
//	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectReporttype = "//select[@id='reportTypeId']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_ResetBtn = "//button[@name='Reset']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SearchBtn = "//button[@id='btnsearch']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_ValidateHeading = "//h3[contains(text(),'Search Cancelled\\Disapproved\\Returned Shipment Met')]";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_DateToday = "//button[contains(text(),'Today')]";

	/* ******************************* Constructor ****************************** */

	public SearchCancelledDisapprovedReturnedShipmentMetricsBySBUReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SearchBtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(3);
		isDisplayed(driver, OCR_MISReport_DisapprovalMetricsBySBU_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS,
				"Search Cancelled/Disapproved/Returned Shipment Metrics by SBU Report page is Displayed");
		Wait.waitfor(3);

	}

	public void resetBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_ResetBtn, "Click on Reset button");

	}

	public void searchByParameters(String SbuCode, String WorkStatus, String Country, String region, String site,
			String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo) {
		Wait.waitfor(2);
		if(SbuCode.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SBUCode, "Select SBU Code : ", SbuCode);
		}
		Wait.waitfor(3);
		if(WorkStatus.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_WorkStatus,
				"Select Shipment Work Status : ", WorkStatus);
		}
		if(Country.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Select Country : ",
				Country);
		}
		Wait.waitfor(2);
		if(region.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultDisapprovalMetricsBySbuReport_selectRegion']", region);
		selectByVisibleText(driver, test, "//select[@id='resultDisapprovalMetricsBySbuReport_selectRegion']", "Select region : ",
				region);
		}
		
		if(site.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultDisapprovalMetricsBySbuReport_selectSite']", site);
		selectByVisibleText(driver, test, "//select[@id='resultDisapprovalMetricsBySbuReport_selectSite']", "Select Site : ", site);
		}
		Wait.waitfor(2);

		if (CreatedFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedFrom,
					"Clicking on Created On From Date :");
			try {
				if (CreatedFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", CreatedFrom);
				//	dateOfMonthName(driver, test, "Selecting the From Date :", CreatedFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (CreatedTo.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedTo,
					"Clicking on Created on To Date :");
			try {
				if (CreatedTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", CreatedTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedFromDate,
					"Click on Export Created From Date :");
			try {
				if (ExportFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", ExportFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportTo.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedToDate,
					"Click on Export Created To Date :");
			try {
				if (ExportTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", ExportTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

	}

}
