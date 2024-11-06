package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class licenseExceptionSummarypage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_selectsbu = "//select[@id='resultLicenseExceptionSummaryReport_selectSbu']";
	public static final String OCR_workstatus = "//select[@id='selectShipmentWorkStatus']";
	public static final String OCR_Exception = "//input[@id='resultLicenseExceptionSummaryReport_licenseExceptionNo']";
	public static final String OCR_exceptiondescription = "//input[@id='resultLicenseExceptionSummaryReport_licenseExceptionName']";
	public static final String OCR_dtofexportfrom = "//input[@id='resultLicenseExceptionSummaryReport_fromDateOfExport']";
	public static final String OCR_dtofexportTo = "//input[@id='resultLicenseExceptionSummaryReport_toDateOfExport']";
	public static final String OCR_exportercode = "//input[@id='resultLicenseExceptionSummaryReport_shipment_exporterCode']";
	public static final String OCR_exportername = "//input[@id='resultLicenseExceptionSummaryReport_shipment_exporterContactName']";
	public static final String OCR_shippmentno = "//input[@id='resultLicenseExceptionSummaryReport_shipment_shipmentNo']";
	public static final String OCR_salesorderno = "//input[@id='resultLicenseExceptionSummaryReport_orderNo']";
	public static final String OCR_eccncategory = "resultLicenseExceptionSummaryReport_usmlCategoryCode";
	public static final String OCR_ultimtconsignee = "//input[@id='resultLicenseExceptionSummaryReport_shipment_ultConsName']";
	public static final String OCR_cntryofultdestintion = "//select[@id='resultLicenseExceptionSummaryReport_selectCountryOfUltDest']";
	public static final String OCR_partno = "//input[@id='resultLicenseExceptionSummaryReport_partNo']";
	public static final String OCR_ITARExemptionReportPage_Searchbtn = "//button[@onclick='buttonPress()']";
	public static final String OCR_kicexceptionsummryReportPageValidateHeading = "//h3[contains(text(),'LICENSE EXCEPTIONS SUMMARY')]";
	public static final String OCR_Today = "//button[contains(text(),'Today')]";
	
	/* ******************************* Constructor ****************************** */

	public licenseExceptionSummarypage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_selectsbu, "Deselecting All SBUs");
		selectByVisibleText(driver, test, OCR_selectsbu, "Select SBu Code : ", sbu);

	}

	public void selectWorkstatus(String workstatus, String ExportDateFrom, String ExportDateTo) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_workstatus, "Deselecting workstatus");
		selectByVisibleText(driver, test, OCR_workstatus, "Select workstatus : ", workstatus);
		
		if(ExportDateFrom.length() > 0) {
			clickElement(driver, test, OCR_dtofexportfrom, "Clicking on Export Date From :");
			try {
				if(ExportDateFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					date(driver, test, "Selecting Date Of Export From :", ExportDateFrom);
					
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Export Date From :");
			}
		}
		if(ExportDateTo.length() > 0) {
			clickElement(driver, test, OCR_dtofexportTo, "Clicking on Export Date To :");
			try {
				if(ExportDateTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					date(driver, test, "Selecting Export Date To :", ExportDateTo);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Export Date To :");
			}
		}
	}

	public void selectUltDestination(String UltDestination) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_cntryofultdestintion, "Deselecting All ultimate destination");
		selectByVisibleText(driver, test, OCR_cntryofultdestintion, "Select ultimate destination : ", UltDestination);
	}

	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ITARExemptionReportPage_Searchbtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_kicexceptionsummryReportPageValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "LICENSE EXCEPTIONS SUMMARY Report page is Displayed");
		Wait.waitfor(3);

	}
	public void expcode(String ExporterCode) {
		typeText(driver, test, OCR_exportercode, "exporter code", ExporterCode);
	}

}
