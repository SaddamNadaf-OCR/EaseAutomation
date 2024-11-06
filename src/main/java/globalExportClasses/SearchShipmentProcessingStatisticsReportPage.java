package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchShipmentProcessingStatisticsReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_MISReport_StatisticsReport_SBUCode = "//select[@id='selectSbu']";
	public static final String OCR_MISReport_StatisticsReport_WorkStatus ="//select[@id='selectShipmentWorkStatus']";
	public static final String OCR_MISReport_StatisticsReport_SelectCountry = "//select[@id='encryptedCountryCode']";
	public static final String OCR_MISReport_StatisticsReport_SearchBtn = "//button[@id='btnsearch']";
	public static final String OCR_MISReport_StatisticsReport_ValidateHeading = "//h3[contains(text(),'SHIPMENT PROCESSING STATISTICS REPORT')]";
	public static final String OCR_MISReport_StatisticsReport_CreatedFromDate = "//input[@id='resultShipmentStatisticsReport_fromCreatedDate']";
	public static final String OCR_MISReport_StatisticsReport_CreatedToDate = "//input[@id='resultShipmentStatisticsReport_toCreatedDate']";
	public static final String OCR_MISReport_StatisticsReport_ExportFromDate = "//input[@id='resultShipmentStatisticsReport_fromDateOfExport']";
	public static final String OCR_MISReport_StatisticsReport_ExportToDate = "//input[@id='resultShipmentStatisticsReport_toDateOfExport']";
	public static final String OCR_MISReport_StatisticsReport_ShipReviewFromDate = "//input[@id='resultShipmentStatisticsReport_fromDateOfShippingReview']";
	public static final String OCR_MISReport_StatisticsReport_ShipReviewToDate = "//input[@id='resultShipmentStatisticsReport_toDateOfShippingReview']";
	public static final String OCR_MISReport_StatisticsReport_ExportReviewFromDate = "//input[@id='resultShipmentStatisticsReport_fromDateOfExportReview']";
	public static final String OCR_MISReport_StatisticsReport_ExportReviewToDate = "//input[@id='resultShipmentStatisticsReport_toDateOfExportReview']";
	public static final String OCR_MISReport_StatisticsReport_TransReviewFromDate = "//input[@id='resultShipmentStatisticsReport_fromDateOfTransportReview']";
	public static final String OCR_MISReport_StatisticsReport_TransReviewToDate = "//input[@id='resultShipmentStatisticsReport_toDateOfTransportReview']";
	public static final String OCR_MISReport_DisapprovalMetricsBySBU_DateToday = "//button[contains(text(),'Today')]";
	
	/* ******************************* Constructor ****************************** */

	public SearchShipmentProcessingStatisticsReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String SBUCode) {
	Wait.waitfor(2);
	selectByVisibleText(driver, test, OCR_MISReport_StatisticsReport_SBUCode, "Select SBU Code : ", SBUCode);
	
	}
	
	public void selectWorkStatus(String workStatus) {
		Wait.waitfor(3);
		//deSelectAll(driver, test, OCR_MISReport_StatisticsReport_WorkStatus, "Deselect All the options from work status");
		 selectByVisibleText(driver, test, OCR_MISReport_StatisticsReport_WorkStatus, "Select Shipment Work Status : ", workStatus);
	 
	}
	
	 public void selectCountry(String country) {
		 Wait.waitfor(2);
	// deSelectAll(driver, test, OCR_MISReport_StatisticsReport_SelectCountry, "Deselect All the options from Country");
		selectByVisibleText(driver, test, OCR_MISReport_StatisticsReport_SelectCountry, "Select Country : ", country); 
		
	 }
	 
	 public void searchBtn() {
		 Wait.waitfor(2);
		 clickElement(driver, test, OCR_MISReport_StatisticsReport_SearchBtn, "Click on Search Button");
	 }
	 
	 public void validateHeading()
	 {
		 Wait.waitfor(3);
			isDisplayed(driver, OCR_MISReport_StatisticsReport_ValidateHeading);
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "SHIPMENT PROCESSING STATISTICS REPORT page is Displayed");
			Wait.waitfor(3);
		 
		 }
	 
	 public void searchByParameters(String SbuCode, String WorkStatus, String Country, String Region, String Site,
				String CreatedFrom, String CreatedTo, String ExportFrom, String ExportTo, String ShipReviewFrom,
				String ShipReviewTo, String ExportReviewFrom, String ExportReviewTo, String TransReviewFrom,
				String TransReviewTo) {
			Wait.waitfor(2);
			if(SbuCode.length() > 0) {
			selectByVisibleText(driver, test, OCR_MISReport_StatisticsReport_SBUCode, "Select SBU Code : ", SbuCode);
			}
			Wait.waitfor(2);
			if(WorkStatus.length() > 0) {
				deSelectAll(driver, test, OCR_MISReport_StatisticsReport_WorkStatus, "De-selecting work status :");
				Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_MISReport_StatisticsReport_WorkStatus, "Select Shipment Work Status : ", WorkStatus);
			}
			Wait.waitfor(2);
			if(Country.length() > 0) {
			selectByVisibleText(driver, test, OCR_MISReport_StatisticsReport_SelectCountry, "Select Country : ",
					Country);
			}
			if(Region.length() > 0) {
			selectByVisibleText(driver, test, "//option[contains(text(),'" + Region + "')]", "Select a region : ", Region);
			}
			if(Site.length() > 0) {
				selectByVisibleText(driver, test, "//option[contains(text(),'" + Site + "')]", "Select a site : ", Site);	
			}
			Wait.waitfor(2);
			if (CreatedFrom.length() > 0) {
				clickElement(driver, test, OCR_MISReport_StatisticsReport_CreatedFromDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_CreatedToDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_ExportFromDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_ExportToDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_ShipReviewFromDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_ShipReviewToDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_ExportReviewFromDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_ExportReviewToDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_TransReviewFromDate,
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
				clickElement(driver, test, OCR_MISReport_StatisticsReport_TransReviewToDate,
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

