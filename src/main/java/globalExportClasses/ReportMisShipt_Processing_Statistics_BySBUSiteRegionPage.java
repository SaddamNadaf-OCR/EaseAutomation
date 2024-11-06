package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ReportMisShipt_Processing_Statistics_BySBUSiteRegionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "//button[contains(text(),'Search')]";
	public static final String OCR_RESET = "//button[@type='reset']";
	public static final String OCR_SBUCODE = "//select[@name='selectSbu']";
	public static final String OCR_ReportType = "//select[@name='reportType']";
	public static final String OCR_Shipment_WorkStatus = "//select[@name='selectShipmentWorkStatus']";
	public static final String OCR_Region = "//select[@name='selectRegion']";

	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SBUCode = "//select[@id='selectSbu']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_WorkStatus = "//select[@id='resultDisapprovalMetricsBySbuReport_shipment_shipmentWorkStatus']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry = "//select[@id='encryptedCountryCode']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectRegion = "//select[@id='resultDisapprovalMetricsReport_selectRegion']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectSite = "//select[@id='resultDisapprovalMetricsReport_selectSite']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedFrom = "//input[@id='resultShipmentStatisticsByCategoryReport_fromCreatedDate']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedTo = "//input[@id='resultShipmentStatisticsByCategoryReport_toCreatedDate']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedFromDate = "//input[@id='resultShipmentStatisticsByCategoryReport_fromDateOfExport']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportCreatedToDate = "//input[@id='resultShipmentStatisticsByCategoryReport_toDateOfExport']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectReporttype = "//select[@id='reportTypeId']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectShipReviewFromDate = "//input[@id='resultShipmentStatisticsByCategoryReport_fromDateOfShippingReview']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectShipReviewToDate = "//input[@id='resultShipmentStatisticsByCategoryReport_toDateOfShippingReview']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportReviewFromDate = "//input[@id='resultShipmentStatisticsByCategoryReport_fromDateOfExportReview']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectExportReviewToDate = "//input[@id='resultShipmentStatisticsByCategoryReport_toDateOfExportReview']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectTransReviewFromDate = "//input[@id='resultShipmentStatisticsByCategoryReport_fromDateOfTransportReview']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_SelectTransReviewToDate = "//input[@id='resultShipmentStatisticsByCategoryReport_toDateOfTransportReview']";

	public static final String OCR_MISReport_DisapprovalMetricsBySBU_DateToday = "//button[contains(text(),'Today')]";
	// * ******************************* Constructor ******************************
	// *//

	public ReportMisShipt_Processing_Statistics_BySBUSiteRegionPage(WebDriver driver, ExtentTest test) {
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
	public void parameter(String ReportType, String Sbu, String ShipmentStatus, String Region) {
		selectByVisibleText(driver, test, OCR_ReportType, "Select Report Type:", ReportType);
		selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu Code", Sbu);
		selectByVisibleText(driver, test, OCR_Shipment_WorkStatus, "Shipment Work Status :", ShipmentStatus);
		selectByVisibleText(driver, test, OCR_Region, "Select Region", Region);
		scrollToElement(driver, OCR_SEARCH);

	}

	public void selectSBU(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SBUCode, "Select SBU Code : ", SbuCode);

	}

	public void reportType(String ReportType) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectReporttype,
				"Select report type : ", ReportType);
	}

	public void selectWorkStatus(String WorkStatus) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_Shipment_WorkStatus, "Select Shipment Work Status : ", WorkStatus);
	}

	public void selectCountry(String Country) {
		Wait.waitfor(2);
		// deSelectAll(driver, test,
		// OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Deselect All the
		// options from Country");
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Select Country : ",
				Country);

	}

	public void selectRegion(String Region) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//option[contains(text(),'" + Region + "')]", "Select a region : ", Region);

	}

	public void selectSite(String Site) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//option[contains(text(),'" + Site + "')]", "Select a site : ", Site);

	}

	public void searchByParameters(String SbuCode, String WorkStatus, String Country, String Region, String Site,
			String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo, String ShipReviewFrom,
			String ShipReviewTo, String ExportReviewFrom, String ExportReviewTo, String TransReviewFrom,
			String TransReviewTo) {
		Wait.waitfor(2);
		if(SbuCode.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SBUCode, "Select SBU Code : ", SbuCode);
		}
		if(WorkStatus.length() > 0) {
			deSelectAll(driver, test, "//select[@id='selectShipmentWorkStatus']", WorkStatus);
		selectByVisibleText(driver, test, "//select[@id='selectShipmentWorkStatus']", "Select Shipment Work Status : ", WorkStatus);
		}
		if(Country.length() > 0) {
		selectByVisibleText(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCountry, "Select Country : ",
				Country);
		}
		if(Region.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultShipmentStatisticsByCategoryReport_selectRegion']", Region);
		selectByVisibleText(driver, test, "//select[@id='resultShipmentStatisticsByCategoryReport_selectRegion']", "Select a region : ", Region);
		}
		if(Site.length() > 0) {
			deSelectAll(driver, test, "//select[@id='resultShipmentStatisticsByCategoryReport_selectSite']", Site);
		selectByVisibleText(driver, test, "//select[@id='resultShipmentStatisticsByCategoryReport_selectSite']", "Select a site : ", Site);
		}
		if (CreatedFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectCreatedFrom,
					"Clicking on Created On From Date :");
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
					date(driver, test, "Selecting the To Date :", ExportTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ShipReviewFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectShipReviewFromDate,
					"Click on Shipping review From Date :");
			try {
				if (ShipReviewFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the Shipping review From Date :", ShipReviewFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ShipReviewTo.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectShipReviewToDate,
					"Click on Shipping review Created To Date :");
			try {
				if (ShipReviewTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", ShipReviewTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportReviewFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectExportReviewFromDate,
					"Click on Export review From Date :");
			try {
				if (ExportReviewFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the Export review From Date :", ExportReviewFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (ExportReviewTo.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectExportReviewToDate,
					"Click on Export review Created To Date :");
			try {
				if (ExportReviewTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", ExportReviewTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (TransReviewFrom.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectTransReviewFromDate,
					"Click on Transport review From Date :");
			try {
				if (TransReviewFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the Transport review From Date :", TransReviewFrom);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

		if (TransReviewTo.length() > 0) {
			clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_SelectTransReviewToDate,
					"Click on Transport review Created To Date :");
			try {
				if (TransReviewTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_MISReport_DisapprovalMetricsBySBU_DateToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", TransReviewTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}

	}

}
