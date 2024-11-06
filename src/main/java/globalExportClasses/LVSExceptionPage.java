package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class LVSExceptionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_selectsbu ="//select[@id='resultLvsExceptionReport_selectSbu']";
	public static final String OCR_workstatus="//select[@id='selectShipmentWorkStatus']";
	public static final String OCR_ultimateDest="//select[@id='resultLvsExceptionReport_selectCountryOfUltDest']";
	public static final String OCR_exportdtfrom="//input[@id='resultLvsExceptionReport_fromDateOfExport']";
	public static final String OCR_exportdtTo="//input[@id='resultLvsExceptionReport_toDateOfExport']";
	public static final String OCR_exportercode="//input[@id='resultLvsExceptionReport_shipment_exporterCode']";
	public static final String OCR_exportername="//input[@id='resultLvsExceptionReport_shipment_exporterContactName']";
	public static final String OCR_shipmentno="//input[@id='resultLvsExceptionReport_shipment_shipmentNo']";
	public static final String OCR_salesordrno="//input[@id='resultLvsExceptionReport_orderNo']";
	public static final String OCR_eccncategory="//input[@id='resultLvsExceptionReport_usmlCategoryCode']";
	public static final String OCR_ultconsignee="//input[@id='resultLvsExceptionReport_shipment_ultConsName']";
	public static final String OCR_partno="//input[@id='resultLvsExceptionReport_partNo']";
	public static final String OCR_ITARExemptionReportPage_Searchbtn="//button[@name='Search']";
	public static final String 	OCR_LVSreportPageValidateHeading="//h3[contains(text(),'LVS Exception Report')]";
	public static final String OCR_Today = "//button[contains(text(),'Today')]";
	
	/* ******************************* Constructor ****************************** */
	public LVSExceptionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_selectsbu, "Deselecting All SBUs");
		selectByVisibleText(driver, test, OCR_selectsbu, "Select SBu Code : ", sbu);
	}
	public void selectWorkstatus(String workstatus) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_workstatus, "Deselecting workstatus");
		selectByVisibleText(driver, test, OCR_workstatus, "Select workstatus : ", workstatus);
	}
	public void selectultdestination(String UltiDestination, String ExportDateFrom, String ExportDateTo) {
		Wait.waitfor(2);
		deSelectAll(driver, test, OCR_ultimateDest, "Deselecting ultimate destination");
		selectByVisibleText(driver, test, OCR_ultimateDest, "ultimate destination : ", UltiDestination);
	    Wait.waitfor(2);
	    
	    if(ExportDateFrom.length() > 0) {
			clickElement(driver, test, OCR_exportdtfrom, "Clicking on Export Date From :");
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
			clickElement(driver, test, OCR_exportdtTo, "Clicking on Export Date To :");
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
	public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ITARExemptionReportPage_Searchbtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_LVSreportPageValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "LVS Exception Report page is Displayed");
		Wait.waitfor(3);

	}
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		