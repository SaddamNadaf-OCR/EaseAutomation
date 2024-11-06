package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportUnderITARExemptionReport extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ITARExemptionReportPage_SBUCode = "//select[@id='resultItarExemptionDetailReport_selectSbu']";
	public static final String OCR_ITARExemptionReportPage_WorkStatus = "//select[@name='selectShipmentWorkStatus']";
	public static final String OCR_ITARExemptionReportPageDestCountry = "//select[@id='resultItarExemptionDetailReport_selectCountryOfUltDest']";
	public static final String OCR_ITARExemptionReportPageShipmentNo = "//input[@id='resultItarExemptionDetailReport_shipment_shipmentNo']";
	public static final String OCR_ITARExemptionReportPageULtConsignee = "//input[@id='resultItarExemptionDetailReport_shipment_ultConsName']";
	public static final String OCR_ITARExemptionReportPageAuthType = "//textarea[@id='resultItarExemptionDetailReport_itarExemptionNo']";
	public static final String OCR_ITARExemptionReportDtOfEXportFrom = "//input[@id='resultItarExemptionDetailReport_fromDateOfExport']";
	public static final String OCR_ITARExemptionReportDtOfExportTo = "//input[@id='resultItarExemptionDetailReport_toDateOfExport']";
	public static final String OCR_ITARExemptionReportPage_Searchbtn="//button[@name='Search']";
	public static final String 	OCR_ITARExemptionReportPageValidateHeading="//h3[contains(text(),'ITAR Exemption Detail Report')]";
	

	/* ******************************* Constructor ****************************** */

	public ExportUnderITARExemptionReport(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ITARExemptionReportPage_SBUCode, "Deselecting All SBUs");
		selectByVisibleText(driver, test, OCR_ITARExemptionReportPage_SBUCode, "Select SBu Code : ", sbu);

	}

	public void selectWorkStatus(String WorkStatus) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ITARExemptionReportPage_WorkStatus, "Deselecting All Statuses");
		selectByVisibleText(driver, test, OCR_ITARExemptionReportPage_WorkStatus, "Select Work Status : ",
				WorkStatus);
	}

	public void selectDestinationCountry(String DestinationCountry) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ITARExemptionReportPageDestCountry, "De select All destination country");
		selectByVisibleText(driver, test, OCR_ITARExemptionReportPageDestCountry,
				"Select Destination county  : ", DestinationCountry);
	}

	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ITARExemptionReportPage_Searchbtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_ITARExemptionReportPageValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "ITAR Exemption Detail Report page is Displayed");
		Wait.waitfor(3);

	}
}
