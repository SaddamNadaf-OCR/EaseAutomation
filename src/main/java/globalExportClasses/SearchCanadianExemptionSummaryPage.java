package globalExportClasses;


import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchCanadianExemptionSummaryPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CanadianExemptionReportPage_SBUCode = "//select[@id='resultCanadianExemptionSummaryReport_selectSbu']";
	public static final String OCR_CanadianExemptionReportPage_WorkStatus= "//select[@id='resultCanadianExemptionSummaryReport_selectShipmentWorkStatus']";
	public static final String OCR_CanadianExemptionReportPage_CanadianExempNo = "//select[@id='resultCanadianExemptionSummaryReport_selectItarExemptionNo']";
	public static final String OCR_CanadianExemptionReportPage_Searchbtn = "//button[contains(text(),'Search')]";
	public static final String OCR_CanadianExemptionReportPage_ValidateHeading ="//h3[contains(text(),'CANADIAN EXEMPTIONS - SUMMARY')]";
	public static final String OCR_CanExemptionDecsription="//input[@id='resultCanadianExemptionSummaryReport_itarExemptionName']";
	public static final String OCR_CanExemptionDtofExportFrom="//input[@id='resultCanadianExemptionSummaryReport_fromDateOfExport']";
	public static final String OCR_CanExemptionDtofExportTo="//input[@id='resultCanadianExemptionSummaryReport_toDateOfExport']";
	public static final String OCR_CanExemptionExporterCodetext="//input[@id='resultCanadianExemptionSummaryReport_shipment_exporterCode']";
	public static final String OCR_CanExemptionExpoName="//input[@id='resultCanadianExemptionSummaryReport_shipment_exporterContactName']";
	public static final String OCR_CanExemptionShipmentNo="//input[@id='resultCanadianExemptionSummaryReport_shipment_shipmentNo']";
	public static final String OCR_CanExemptionSalesOrderNo="resultCanadianExemptionSummaryReport_orderNo";
	public static final String OCR_CanExemptionUSMILCAT="//input[@id='resultCanadianExemptionSummaryReport_usmlCategoryCode']";
	
	
	
	/* ******************************* Constructor ****************************** */

	public SearchCanadianExemptionSummaryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		if(sbu.length()> 0) {
			Wait.waitfor(2);
			deSelectAll(driver, test, OCR_CanadianExemptionReportPage_SBUCode, "Deselecting All SBUs");
			selectByVisibleText(driver, test, OCR_CanadianExemptionReportPage_SBUCode, "Select SBu Code : ", sbu);
		}		
	}

	public void selectWorkStatus(String WorkStatus) {
		if(WorkStatus.length() > 0) {
			Wait.waitfor(2);
			deSelectAll(driver, test, OCR_CanadianExemptionReportPage_WorkStatus, "Deselecting All Statuses");
			selectByVisibleText(driver, test, OCR_CanadianExemptionReportPage_WorkStatus, "Select Work Status : ", WorkStatus);
		}
	}
	
	public void selectCanadianExempNo(String CanadianExemp) {
		if(CanadianExemp.length() > 0) {
			Wait.waitfor(2);
			deSelectAll(driver, test, OCR_CanadianExemptionReportPage_CanadianExempNo, "De select All Canadian Exemption");
			selectByVisibleText(driver, test, OCR_CanadianExemptionReportPage_CanadianExempNo, "Select Canadian Exemption : ", CanadianExemp);
		}
	}

	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CanadianExemptionReportPage_Searchbtn, "Click on Search Button");
	}
	
	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_CanadianExemptionReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "CANADIAN EXEMPTION-SUMMARY REPORT page is Displayed");
		Wait.waitfor(3);
		
	}
}
