package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ReportMisDisapprovalMetricsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "//button[contains(text(),'Search')]";
	public static final String OCR_RESET = "//button[@type='reset']";
	public static final String OCR_SBUCODE = "//select[@name='selectSbu']";
	public static final String OCR_ReportType = "//select[@name='reportType']";
	public static final String OCR_ShipmentWorkStatus = "//select[@name='shipment.shipmentWorkStatus']";

	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SBUCode = "//select[@id='selectSbu']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_WorkStatus = "//select[@id='resultDisapprovalMetricsBySbuReport_shipment_shipmentWorkStatus']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry = "//select[@id='encryptedCountryCode']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectRegion = "//select[@id='resultDisapprovalMetricsReport_selectRegion']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectSite = "//select[@id='resultDisapprovalMetricsReport_selectSite']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedFrom = "//input[@id='resultDisapprovalMetricsReport_fromCreatedDate']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedTo = "//input[@id='resultDisapprovalMetricsReport_toCreatedDate']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedFromDate = "//input[@id='resultDisapprovalMetricsReport_fromDateOfExport']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedToDate = "//input[@id='resultDisapprovalMetricsReport_toDateOfExport']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectReporttype = "//select[@id='reportTypeId']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_DateToday = "//button[contains(text(),'Today')]";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SearchBtn = "//button[@id='btnsearch']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_ValidateHeading = "//h3[contains(text(),'Search Cancelled\\Disapproved\\Returned Shipment Met')]";

	// * ******************************* Constructor ******************************
	// *//

	public ReportMisDisapprovalMetricsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}

	// Search by parameter
	public void parameter(String ReportType, String Sbu, String ShipmentWorkStatus) {
		selectByVisibleText(driver, test, OCR_ReportType, "Select Report Type:", ReportType);
		selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu :", Sbu);
		selectByVisibleText(driver, test, OCR_ShipmentWorkStatus, "Select ShipmentWorkStatus :", ShipmentWorkStatus);
		scrollToElement(driver, OCR_SEARCH);
	}

	public void selectSBU(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SBUCode, "Select SBU Code : ", SbuCode);

	}

	public void selectWorkStatus(String WorkStatus) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ShipmentWorkStatus, "Select Shipment Work Status : ", WorkStatus);
	}

	public void selectCountry(String Country) {
		Wait.waitfor(2);
		// deSelectAll(driver, test,
		// OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Deselect All the
		// options from Country");
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Select Country : ",
				Country);

	}

	public void selectRegion(String region) {

		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//option[contains(text(),'" + region + "')]", "Select a particular region :",
				region);

	}

	public void selectSite(String site) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//option[contains(text(),'" + site + "')]", "Select a particular site :",
				site);

	}

	public void searchbyParameters(String Sbu, String Workstatus, String country, String Region, String Site,
			String CreatedFrom, String CreatedTo, String ExportFromDate, String ExportToDate) {
		Wait.waitfor(2);
		if(Sbu.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SBUCode, "Select SBU Code : ", Sbu);
		}
		if(Workstatus.length() > 0) {
		selectByVisibleText(driver, test, OCR_ShipmentWorkStatus, "Select Shipment Work Status : ", Workstatus);
		}
		if(country.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Select Country : ",
				country);
		}
		if(Region.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultDisapprovalMetricsReport_selectRegion']", Region);
		selectByVisibleText(driver, test, "//select[@id='resultDisapprovalMetricsReport_selectRegion']", "Select a region : ", Region);
		}
		if(Site.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultDisapprovalMetricsReport_selectSite']", Site);
		selectByVisibleText(driver, test, "//select[@id='resultDisapprovalMetricsReport_selectSite']", "Select a site : ", Site);
		}
		Wait.waitfor(2);
		if (CreatedFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedFrom,
					"Click on Created From Date :");
			try {
				if (CreatedFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", CreatedFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (CreatedTo.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedTo,
					"Click on Created To Date :");
			try {
				if (CreatedTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", CreatedTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportFromDate.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedFromDate,
					"Click on Export Created From Date :");
			try {
				if (ExportFromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the From Date :", ExportFromDate);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportToDate.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedToDate,
					"Click on Export Created To Date :");
			try {
				if (ExportToDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", ExportToDate);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}

		}
	}

	public void reportType(String ReportType) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectReporttype,
				"Select report type : ", ReportType);
	}

	// public void searchBtn() {
	// Wait.waitfor(2);
	// clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SearchBtn,
	// "Click on Search Button");
	// }

	public void validateHeading() {
		Wait.waitfor(3);
		isDisplayed(driver, OCR_MISReport_DisapprovalMetricsBySBU_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS,
				"Search Cancelled/Disapproved/Returned Shipment Metrics by SBU Report page is Displayed");
		Wait.waitfor(3);

	}

}
