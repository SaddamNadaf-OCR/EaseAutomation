package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class DOSListAgreementPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ListAgreement_TransactionId = "//table[@id='grid']/tbody/tr[2]/td[2]/a";

	/* ******************** Constructor ***************************** */

	public DOSListAgreementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to features and click Compliance Request
	public void click_transactionid() {
		clickElement(driver, test, OCR_ListAgreement_TransactionId, "Clicking on Transaction Id");
	}

	public String get_transactionid() {
		return getText(driver, test, OCR_ListAgreement_TransactionId, "Getting the Text : ");
	}

	// Transation ID is Displayed or not
	public void transationIdIsDisplayed(String TransationID) {
		String transationID = "//table[@id='grid']/tbody/tr[2]//td[2]/a[contains(text(),'" + TransationID + "')]";
		if (isDisplayed(driver, transationID)) {
			test.log(LogStatus.PASS, "Dos licensing is displayed in list of DSP5");
		}
		clickElement(driver, test, transationID, "Click on Transation ID link : " +transationID);
	}

}
