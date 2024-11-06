package globalExportClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ClickElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AESStatusChangeReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AESStatusChangeReportPage_SBUCode = "//select[@id='resultAesStatusReport_shipment_sbuCode']";
	public static final String OCR_AESStatusChangeReportPage_AESStatus = "//select[@id='resultAesStatusReport_selectedAesValue']";
	public static final String OCR_AESStatusChangeReportPage_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_AESStatusChangeReportPage_ValidateHeading = "//h3[contains(text(),'AES Status Change Report')]";
	public static final String OCR_AESStatusChangeReportPage_ShipmentNo = "//input[@id='resultAesStatusReport_shipment_shipmentNo']";
	public static final String OCR_AESStatusChangeReportPage_ITNNO = "//input[@id='resultAesStatusReport_shipment_itn']";
	public static final String OCR_AESStatusChangeReportPage_FromDate = "//input[@id='resultAesStatusReport_fromDate']";
	public static final String OCR_AESStatusChangeReportPage_EndDate = "//input[@id='resultAesStatusReport_toDate']";
	public static final String OCR_AESStatusChangeReportPage_UserName = "//select[@id='resultAesStatusReport_shipment_createdBy']";
	public static final String OCR_AESStatusChangeReportPage_SortBy = "//select[@name='sortBy']";
	public static final String OCR_AESStatusChangeReportPage_Direction = "//select[@name='direction']";
	public static final String OCR_AESStatusChangeReportPage_Reset = "//button[@type='reset']";
	public static final String OCR_Today = "//button[@data-handler='today']";
	/* ******************************* Constructor ****************************** */

	public AESStatusChangeReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBUCode(String SBUCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_SBUCode, "Select SBU Code : ", SBUCode);

	}

	public void selectAES(String AESStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_AESStatus, "Select AES Status : ", AESStatus);

	}

	public void searchbyparameter(String SBUCode, String ShipmentNo, String AESStatus, String ITNNO, String FromDate,
			String EndDate, String UserName, String SortBy, String Direction) {
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_SBUCode, "Select SBU Code : ", SBUCode);
		typeText(driver, test, OCR_AESStatusChangeReportPage_ShipmentNo, "Enter Shipment No", ShipmentNo);
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_AESStatus, "Select AES Status : ", AESStatus);
		typeText(driver, test, OCR_AESStatusChangeReportPage_ITNNO, "Enter ITN NO", ITNNO);
		if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_AESStatusChangeReportPage_FromDate, "Click on From date");
			if (FromDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", FromDate);
			}
		}
		if (EndDate.length() > 0) {
			clickElement(driver, test, OCR_AESStatusChangeReportPage_EndDate, "Click on End date");
			if (EndDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", EndDate);
			}
		}
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_UserName, "Select User Name", UserName);
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_SortBy, "Select Sort By", SortBy);
		selectByVisibleText(driver, test, OCR_AESStatusChangeReportPage_Direction, "Select Direction", Direction);
	}

	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AESStatusChangeReportPage_SearchBtn, "Click on Search Button");
	}

	public void validateHeading() {
		isDisplayed(driver, OCR_AESStatusChangeReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "AES Status Change Report page is Displayed");
		Wait.waitfor(3);
	}

}
