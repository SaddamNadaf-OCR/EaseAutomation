package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultForeignTravelPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ResultIR_Title = "//h3[@class='page-heading']";

	/* ******************** Constructor ***************************** */

	public ResultForeignTravelPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Title of the page is Displayed or not
	public void titleIsDisplayed() {
		try {
			if (isDisplayed(driver, OCR_ResultIR_Title)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Agreement request ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Agreement request ");
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

	// Click on Copy Icon
	public void click_CopyIcon() {
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//td[@aria-describedby='grid_copy'])[1]", "Clicking on Copy Icon :");
		Wait.waitfor(6);
		//AlertPopUp(driver, test, "Would you like to copy the existing attachments to the new form?");
		String alertmsg = "Proceed to Copy without Invalid data";
		// String alertmsg = getText(driver, test, "//span[contains(text(),'Proceed to
		// Copy without Invalid data')]", "Alert Msg :");
		try {
			if (alertmsg.equalsIgnoreCase("Proceed to Copy without Invalid data")) {
				clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]",
						"Clicking on Proceed Without Invalid Data Button :");
			} else {
				clickElement(driver, test, "//span[contains(text(),'Abort Copying')]", "Clicking on Abort Copying :");
			}
		} catch (Exception e) {
			// testFailSshot(driver, test);
			test.log(LogStatus.INFO, "Clicked on Copy Icon without Alert Msg :");
		}
	}
}
