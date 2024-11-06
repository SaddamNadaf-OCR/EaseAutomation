package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ExportResultsExportRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ResultIR_Title = "//h3[contains(text(),'Export Request')]";

	/* ******************** Constructor ***************************** */
	public ExportResultsExportRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Title of the page is Displayed or not
	public void titleIsDisplayed() {
		try {
			if (isDisplayed(driver, OCR_ResultIR_Title)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Export request ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Export request ");
		}
	}

	// Request ID is Displayed or not
	public void requestIDIsDisplayed(String RequestID) {
		try {
			String requestID = "//table[@id='grid']//tr//td//a[contains(text(),'" + RequestID + "')]";
			if (isDisplayed(driver, requestID)) {
				test.log(LogStatus.PASS, "Request ID is Displayed in results grid table : " + RequestID);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Request ID is not Displayed in results grid table : " + RequestID);
		}
	}

}
