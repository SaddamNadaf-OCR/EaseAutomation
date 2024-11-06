package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : 
 * created date : 
 * Descriptions : Search Packing List Report Page
 * changed by : Saddam
 * changed date : 14/05/2024
 * Purpose of change : Added in Regression Testcases
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchPackingListReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchPackingListReportPage_SBUCode = "//select[@id='searchPackinglistReport_packinglist_sbuCode']";
	public static final String OCR_SearchPackingListReportPage_PackingList = "//input[@id='searchPackinglistReport_packinglist_packinglistNo']";
	public static final String OCR_SearchPackingListReportPage_ExporterNo = "//a[contains(text(),'Exporter No')]";
	public static final String OCR_SearchPackingListReportPage_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_SearchPackingListReportPage_SearchPopup = "//button[@name='Search']";
	public static final String OCR_SearchPackingListReportPage_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_SearchPackingListReportPage_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchPackingListReportPage_ExporterCodeTextbox = "//input[@id='searchPackinglistReport_packinglist_exporterCode']";
	public static final String OCR_SearchPackingListReportPage_DateOfExport = "//input[@id='searchPackinglistReport_dateOfExport']";
	public static final String OCR_SearchPackingListReportPage_ConsigneeName = "//input[@id='searchPackinglistReport_packinglist_ultimateConsigneeName']";
	public static final String OCR_SearchPackingListReportPage_DateOfArrival = "//input[@id='searchPackinglistReport_dateOfArrival']";
	public static final String OCR_SearchPackingListReportPage_ShipNo = "//input[@id='searchPackinglistReport_packinglist_shipmentNo']";
	public static final String OCR_SearchPackingListReportPage_Status = "//select[@id='searchPackinglistReport_packinglist_status']";
	public static final String OCR_SearchPackingListReportPage_CreatedBy = "//select[@id='searchPackinglistReport_packinglist_createdBy']";
	public static final String OCR_SearchPackingListReportPage_SortBy = "(//select[@name='sortBy'])[1]";
	public static final String OCR_SearchPackingListReportPage_Direction = "(//select[@name='direction'])[1]";
	public static final String OCR_SearchPackingListReportPage_Searchbtn = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_SearchPackingListReportPage_Resetbtn = "(//button[contains(text(),'Reset')])[1]";
	public static final String OCR_SearchPackingListReportPage_ValidateHeading = "//h3[contains(text(),'Packing List Report')]";
	public static final String OCR_SearchPackingListReportPage_Today = "(//button[contains(text(),'Today')])[1]";

	/* ******************************* Constructor ****************************** */

	public SearchPackingListReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_SBUCode, "Select SBU : ", SbuCode);

	}

	public void packingList(String PL) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchPackingListReportPage_PackingList, "Enter Packing List : ", PL);
	}

	public void shipmentNo(String ShpNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchPackingListReportPage_ShipNo, "Enter Shipment Number : ", ShpNo);
	}

	public void status(String Status) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_Status, "Select Status : ", Status);
	}

	public void ResetBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchPackingListReportPage_Resetbtn, "Click on Reset Button");
	}

	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchPackingListReportPage_Searchbtn, "Click on Search Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_SearchPackingListReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Packing List Report Page is Displayed");
	}
	
	//Search By Parameters
	public void searchByParameters(String SbuCode, String PL, String ExporterCode, String DateOfExport, String ConsigneeName, String DateOfArrival, String ShpNo, String Status, String CreatedBy, String SortBy, String Direction) {
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_SBUCode, "Select SBU : ", SbuCode);
		typeText(driver, test, OCR_SearchPackingListReportPage_PackingList, "Enter Packing List : ", PL);
		if(ExporterCode.length() > 0) {
			clickElement(driver, test, OCR_SearchPackingListReportPage_ExporterCode, "Clicking on Exporter Code :");
			try {
				typeText(driver, test, OCR_SearchPackingListReportPage_ExporterCodeTextbox, "Entering Exporter Code :", ExporterCode);
				clickElement(driver, test, OCR_SearchPackingListReportPage_SearchPopup, "Clicking on Search Popup button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExporterCode+"')]", "Clicking on Exporter Code :");
				clickElement(driver, test, OCR_SearchPackingListReportPage_ShipNo, "Clicking on Select Popup button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Exporter Code :");
				clickElement(driver, test, OCR_SearchPackingListReportPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
		if(DateOfExport.length() > 0) {
			clickElement(driver, test, OCR_SearchPackingListReportPage_DateOfExport, "Clicking on Date Of Export :");
			if(DateOfExport.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_SearchPackingListReportPage_Today, "Clicking on Today :");
			}else {
				dateOfMonthName(driver, test, "Selecting Date Of Export :", DateOfExport);
			}
		}
		typeText(driver, test, OCR_SearchPackingListReportPage_ConsigneeName, "Entering Consignee name :", ConsigneeName);
		if(DateOfArrival.length() > 0) {
			clickElement(driver, test, OCR_SearchPackingListReportPage_DateOfArrival, "Clicking on Date Of Arrival :");
			if(DateOfArrival.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_SearchPackingListReportPage_Today, "Clicking on Today :");
			}else {
				dateOfMonthName(driver, test, "Selecting Date Of Arrival :", DateOfArrival);
			}
		}
		typeText(driver, test, OCR_SearchPackingListReportPage_ShipNo, "Enter Shipment Number : ", ShpNo);
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_Status, "Select Status : ", Status);
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_CreatedBy, "Select Created By : ", CreatedBy);
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_SortBy, "Select Sort By : ", SortBy);
		selectByVisibleText(driver, test, OCR_SearchPackingListReportPage_Direction, "Select Direction : ", Direction);
	}
}
