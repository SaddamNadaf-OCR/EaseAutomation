package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultLicenseDecisionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ResultLD_ChangeStatusActive = "//i[@class='icon-cancel']";
	public static final String OCR_ResultLD_ChangeStatusInActive = "//i[@class='fa inactive']";

	/* ******************************* Constructor ****************************** */

	public ResultLicenseDecisionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Check the Status is Active or not
	public void checkStatus() {
		try {
			if (isDisplayed(driver, OCR_ResultLD_ChangeStatusActive)) {
				test.log(LogStatus.PASS, "Status is Active");
			}
		} catch (Exception e) {
			clickElement(driver, test, OCR_ResultLD_ChangeStatusInActive, "Click on Change Status InActive Icon");
			AlertPopUp(driver, test, "This record will be marked Active. Do you wish to proceed?");
		}
	}

	// Check the Status is Active and click on Change Status icon
	public void changeStatusActive() {
		if (isDisplayed(driver, "//table[@id='grid']//tr[2]/td[contains(text(),'Active')]")) {
			clickElement(driver, test, OCR_ResultLD_ChangeStatusActive, "Click on Change Status Active Icon");
			AlertPopUp(driver, test, "This record will be marked Deleted. Do you wish to proceed?");
		}
	}

	// Check the Status is In Active and click on Change Status icon
	public void changeStatusInActive() {
		if (isDisplayed(driver, "//table[@id='grid']//tr[2]/td[contains(text(),'Deleted')]")) {
			clickElement(driver, test, OCR_ResultLD_ChangeStatusInActive, "Click on Change Status InActive Icon");
			AlertPopUp(driver, test, "This record will be marked Active. Do you wish to proceed?");
		}
	}

}
